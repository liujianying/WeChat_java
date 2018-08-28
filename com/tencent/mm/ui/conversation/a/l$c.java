package com.tencent.mm.ui.conversation.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelvideo.m.5;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.plugin.appbrand.jsapi.bh;
import com.tencent.mm.plugin.sight.decode.a.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.conversation.a.l$b.1;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

final class l$c implements Runnable {
    List<r> usC;
    List<r> usD;
    WeakReference<l> ust;

    private l$c() {
    }

    /* synthetic */ l$c(byte b) {
        this();
    }

    private static int a(String str, l lVar, List<r> list, int i, int i2, int i3) {
        for (r rVar : list) {
            lVar.usr.put(rVar.getFileName(), Long.valueOf(rVar.emf));
            if (lVar.uss.containsKey(Long.valueOf(rVar.emf))) {
                x.d("MicroMsg.MassSightBanner", "%s: has contains massSendId %d, file %s", new Object[]{str, Long.valueOf(rVar.emf), rVar.getFileName()});
            } else {
                View view;
                l$b l_b;
                View inflate;
                if (i < i2) {
                    x.d("MicroMsg.MassSightBanner", "%s: refresh view(%d/%d, hashCode %d) with massSendId %d", new Object[]{str, Integer.valueOf(i + 1), Integer.valueOf(i2), Integer.valueOf(lVar.mContainer.getChildAt(i).hashCode()), Long.valueOf(rVar.emf)});
                    view = inflate;
                    i = r3;
                } else {
                    inflate = LayoutInflater.from(lVar.mContainer.getContext()).inflate(R.i.mass_send_sight_banner_view, lVar.mContainer, false);
                    lVar.mContainer.addView(inflate);
                    x.d("MicroMsg.MassSightBanner", "%s: new view(%d/%d, hashCode %d) with massSendId %d", new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(inflate.hashCode()), Long.valueOf(rVar.emf)});
                    view = inflate;
                }
                l$b l_b2 = (l$b) view.getTag();
                if (l_b2 == null) {
                    l_b = new l$b();
                } else {
                    l_b = l_b2;
                }
                if (l_b.usu != rVar.emf) {
                    x.d("MicroMsg.MassSightBanner", "ashutest::mass send id not match! %d -> %d, totalCount %d", new Object[]{Long.valueOf(l_b.usu), Long.valueOf(rVar.emf), Integer.valueOf(i3)});
                    l_b.usu = rVar.emf;
                    l_b.usw = view;
                    l_b.usx = (a) view.findViewById(R.h.image_view);
                    l_b.usy = (ImageView) view.findViewById(R.h.status_iv);
                    l_b.eWx = (ProgressBar) view.findViewById(R.h.progress);
                    l_b.usA = (ImageButton) view.findViewById(R.h.cancel_btn);
                    l_b.usz = (TextView) view.findViewById(R.h.info_tv);
                    l_b.usx.setDrawableWidth(view.getResources().getDimensionPixelSize(R.f.NormalAvatarSize));
                    l_b.usw.setTag(l_b);
                    l_b.usA.setTag(Long.valueOf(l_b.usu));
                    l_b.usw.setOnClickListener(new 1(l_b));
                    l_b.usA.setOnClickListener(new OnClickListener() {
                        public final void onClick(View view) {
                            x.i("MicroMsg.MassSightBanner", "on click cancel, massSendId %d", new Object[]{Long.valueOf(((Long) view.getTag()).longValue())});
                            g.Em().H(new 5(o.Tg(), r0));
                        }
                    });
                } else {
                    x.d("MicroMsg.MassSightBanner", "ashutest::mass send id match! %d, totalCount %d", new Object[]{Long.valueOf(l_b.usu), Integer.valueOf(i3)});
                }
                o.Ta();
                String nK = s.nK(rVar.getFileName());
                o.Ta();
                l_b.usx.setThumbBmp(com.tencent.mm.ak.o.Pf().a(s.nL(rVar.getFileName()), com.tencent.mm.bp.a.getDensity(view.getContext()), view.getContext()));
                if (i3 > 3) {
                    l_b.usx.clear();
                    l_b.usy.setVisibility(0);
                } else {
                    l_b.usx.aO(nK, false);
                    l_b.usy.setVisibility(8);
                }
                a(l_b, rVar);
                lVar.uss.put(Long.valueOf(rVar.emf), l_b);
            }
        }
        return i;
    }

    public static void a(l$b l_b, r rVar) {
        boolean z = true;
        x.v("MicroMsg.MassSightBanner", "info status %d", new Object[]{Integer.valueOf(rVar.status)});
        if (rVar.status == bh.CTRL_INDEX || rVar.status == 197 || rVar.status == 196) {
            l_b.eWx.setVisibility(4);
            l_b.usz.setVisibility(0);
            l_b.usA.setEnabled(true);
            l_b.usv = true;
            return;
        }
        float f = ((float) rVar.emu) / ((float) rVar.dHI);
        l_b.eWx.setVisibility(0);
        l_b.usz.setVisibility(4);
        l_b.eWx.setProgress((int) (((float) l_b.eWx.getMax()) * f));
        ImageButton imageButton = l_b.usA;
        if (Float.compare(0.99f, f) <= 0) {
            z = false;
        }
        imageButton.setEnabled(z);
        l_b.usv = false;
    }

    public final void run() {
        l lVar = (l) this.ust.get();
        if (lVar == null) {
            x.w("MicroMsg.MassSightBanner", "try to refresh, but banner ref is null");
            return;
        }
        int childCount = lVar.mContainer.getChildCount();
        lVar.uss.clear();
        Set hashSet = new HashSet();
        for (r rVar : this.usC) {
            hashSet.add(Long.valueOf(rVar.emf));
        }
        for (r rVar2 : this.usD) {
            hashSet.add(Long.valueOf(rVar2.emf));
        }
        int size = hashSet.size();
        int a = a("update fail", lVar, this.usD, a("update unfinish", lVar, this.usC, 0, childCount, size), childCount, size);
        for (int i = a; i < childCount; i++) {
            lVar.mContainer.removeViewAt(a);
        }
    }
}

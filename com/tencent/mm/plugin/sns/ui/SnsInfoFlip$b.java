package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.g.a.pw;
import com.tencent.mm.modelcontrol.c;
import com.tencent.mm.network.ab;
import com.tencent.mm.plugin.sns.g.b;
import com.tencent.mm.plugin.sns.i;
import com.tencent.mm.plugin.sns.i$e;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.g;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.v;
import com.tencent.mm.protocal.c.ate;
import com.tencent.mm.protocal.c.bsu;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.av;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.base.f;
import com.tencent.mm.ui.tools.MMGestureGallery;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

class SnsInfoFlip$b extends BaseAdapter {
    private Context context;
    private String dDi = "";
    private boolean icr = true;
    private int nKI = 0;
    final /* synthetic */ SnsInfoFlip nXg;
    private boolean nXm = false;
    Map<String, WeakReference<View>> nXn = new HashMap();
    private String nXo;

    public SnsInfoFlip$b(SnsInfoFlip snsInfoFlip, Context context) {
        this.nXg = snsInfoFlip;
        this.context = context;
        this.nXm = f.crf();
        this.nKI = SnsInfoFlip.j(snsInfoFlip).size();
        c.NM();
        this.icr = c.NO();
    }

    public final int getCount() {
        return SnsInfoFlip.j(this.nXg) == null ? 0 : SnsInfoFlip.j(this.nXg).size();
    }

    private void xs(int i) {
        ate ate = ((b) SnsInfoFlip.j(this.nXg).get(i)).caK;
        av a = av.a(SnsInfoFlip.k(this.nXg), ((b) SnsInfoFlip.j(this.nXg).get(i)).dTR);
        if (ate.hcE == 2) {
            boolean ND = v.ND(((b) SnsInfoFlip.j(this.nXg).get(i)).nuP);
            af.byl();
            ND = g.a(ate, a, ND);
            if (SnsInfoFlip.l(this.nXg) && !ND) {
                SnsInfoFlip.a(this.nXg, ate.ksA);
            }
        }
    }

    public final int getViewTypeCount() {
        return 2;
    }

    public final int getItemViewType(int i) {
        if (((b) SnsInfoFlip.j(this.nXg).get(i)).caK.hcE == 6) {
            return 0;
        }
        return 1;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        if (((b) SnsInfoFlip.j(this.nXg).get(i)).caK.hcE == 6) {
            String str = "MicroMsg.SnsInfoFlip";
            String str2 = "fill view online sight %d convert view is null %b";
            Object[] objArr = new Object[2];
            objArr[0] = Integer.valueOf(i);
            objArr[1] = Boolean.valueOf(view == null);
            x.d(str, str2, objArr);
            b bVar = (b) SnsInfoFlip.j(this.nXg).get(i);
            if (bVar == null) {
                x.w("MicroMsg.SnsInfoFlip", "fill online sight view, but flip item is null.");
                return view;
            }
            str2 = bVar.nuP;
            if (bi.oW(str2)) {
                x.w("MicroMsg.SnsInfoFlip", "fill online sight view, but sns local id is null.");
                return view;
            }
            View onlineVideoView;
            WeakReference weakReference = (WeakReference) this.nXn.get(str2);
            if (weakReference == null || weakReference.get() == null) {
                onlineVideoView = new OnlineVideoView(this.context);
                this.nXn.put(str2, new WeakReference(onlineVideoView));
            } else {
                onlineVideoView = (OnlineVideoView) weakReference.get();
            }
            if (bi.fS(str2, this.nXo)) {
                xt(i);
            }
            x.i("MicroMsg.SnsInfoFlip", "return online sight view %d parent id %s", new Object[]{Integer.valueOf(onlineVideoView.hashCode()), bVar.nuP});
            return onlineVideoView;
        }
        SnsInfoFlip$d snsInfoFlip$d;
        ate ate;
        Bitmap a;
        LayoutParams layoutParams;
        ate ate2 = ((b) SnsInfoFlip.j(this.nXg).get(i)).caK;
        x.d("MicroMsg.SnsInfoFlip", "gallery position " + i + " " + this.nKI + " " + ate2.ksA);
        if (i != SnsInfoFlip.m(this.nXg) && (SnsInfoFlip.g(this.nXg) instanceof MMGestureGallery)) {
            ((MMGestureGallery) SnsInfoFlip.g(this.nXg)).setLoadQuit(false);
        }
        if (view == null) {
            SnsInfoFlip$d snsInfoFlip$d2 = new SnsInfoFlip$d();
            view = View.inflate(this.context, i.g.sns_gallery_item, null);
            snsInfoFlip$d2.nXp = view.findViewById(i.f.click_keeper);
            snsInfoFlip$d2.nXq = (ProgressBar) view.findViewById(i.f.progressbar);
            snsInfoFlip$d2.kAp = (TextView) view.findViewById(i.f.sns_info);
            snsInfoFlip$d2.nXr = (FrameLayout) view.findViewById(i.f.big_img_fl);
            snsInfoFlip$d2.bRk = (ImageView) view.findViewById(i.f.image);
            view.setTag(snsInfoFlip$d2);
            snsInfoFlip$d = snsInfoFlip$d2;
        } else {
            snsInfoFlip$d = (SnsInfoFlip$d) view.getTag();
        }
        snsInfoFlip$d.position = i;
        av a2 = av.a(SnsInfoFlip.k(this.nXg), ((b) SnsInfoFlip.j(this.nXg).get(i)).dTR);
        view.setLayoutParams(new Gallery.LayoutParams(-1, -1));
        snsInfoFlip$d.nXq.setVisibility(8);
        snsInfoFlip$d.kAp.setVisibility(8);
        snsInfoFlip$d.nXr.setVisibility(0);
        Object obj = (bi.oW(SnsInfoFlip.n(this.nXg)) || !SnsInfoFlip.n(this.nXg).equals(ate2.ksA)) ? null : 1;
        if (ate2.ksA.startsWith("Locall_path") && !bi.oW(((b) SnsInfoFlip.j(this.nXg).get(i)).nuP)) {
            n nVar = (n) SnsInfoFlip.o(this.nXg).get(((b) SnsInfoFlip.j(this.nXg).get(i)).nuP);
            if (nVar == null) {
                n Nl = af.byo().Nl(((b) SnsInfoFlip.j(this.nXg).get(i)).nuP);
                SnsInfoFlip.o(this.nXg).put(((b) SnsInfoFlip.j(this.nXg).get(i)).nuP, Nl);
                nVar = Nl;
            }
            bsu bAJ = nVar.bAJ();
            if (bAJ.sqc.ruA.size() > ((b) SnsInfoFlip.j(this.nXg).get(i)).nuQ) {
                ate = (ate) bAJ.sqc.ruA.get(((b) SnsInfoFlip.j(this.nXg).get(i)).nuQ);
                a = af.byl().a(ate, snsInfoFlip$d.bRk, this.context.hashCode(), obj != null, a2, v.ND(((b) SnsInfoFlip.j(this.nXg).get(i)).nuP));
                if (a == null && SnsInfoFlip.l(this.nXg)) {
                    SnsInfoFlip.a(this.nXg, ate.ksA);
                }
                layoutParams = snsInfoFlip$d.bRk.getLayoutParams();
                layoutParams.width = -1;
                layoutParams.height = -1;
                snsInfoFlip$d.bRk.setLayoutParams(layoutParams);
                if (a != null && ate.ksA != null && !ate.ksA.startsWith("pre_temp_extend_pic")) {
                    LayoutParams layoutParams2 = snsInfoFlip$d.bRk.getLayoutParams();
                    BackwardSupportUtil.b.b(this.context, 160.0f);
                    int b = BackwardSupportUtil.b.b(this.context, 200.0f);
                    BackwardSupportUtil.b.b(this.context, 44.0f);
                    g byl = af.byl();
                    String aE = com.tencent.mm.plugin.sns.data.i.aE(1, ate.ksA);
                    String str3 = ate.ksA;
                    com.tencent.mm.memory.n LY = byl.LY(aE);
                    if (!com.tencent.mm.plugin.sns.data.i.b(LY)) {
                        LY = null;
                    }
                    if (LY != null) {
                        double width = (double) LY.bitmap.getWidth();
                        double height = (double) LY.bitmap.getHeight();
                        if (width > 0.0d && height > 0.0d) {
                            Math.min(((double) b) / width, ((double) b) / height);
                        }
                    }
                    snsInfoFlip$d.bRk.setLayoutParams(layoutParams);
                    snsInfoFlip$d.nXq.setVisibility(0);
                    snsInfoFlip$d.bRk.setVisibility(0);
                    af.byl().cx(snsInfoFlip$d.bRk);
                    af.byl().c(ate, snsInfoFlip$d.bRk, i$e.black, this.context.hashCode(), a2);
                    SnsInfoFlip.xq(layoutParams2.width);
                    SnsInfoFlip.xr(layoutParams2.height);
                    if (obj != null) {
                        snsInfoFlip$d.nXq.setVisibility(8);
                    }
                } else if (this.nXm) {
                    snsInfoFlip$d.nXq.setVisibility(8);
                    af.byl().a(ate, snsInfoFlip$d.bRk, this.context.hashCode(), a2, v.ND(((b) SnsInfoFlip.j(this.nXg).get(i)).nuP));
                    snsInfoFlip$d.bRk.setImageBitmap(a);
                    snsInfoFlip$d.bRk.setVisibility(0);
                } else {
                    snsInfoFlip$d.nXq.setVisibility(8);
                    if (a != null) {
                        if (SnsInfoFlip.p(this.nXg)) {
                            return view;
                        }
                        x.i("MicroMsg.SnsInfoFlip", "update view ");
                        MultiTouchImageView multiTouchImageView = new MultiTouchImageView(this.context, a.getWidth(), a.getHeight(), SnsInfoFlip.q(this.nXg));
                        multiTouchImageView.setEnableHorLongBmpMode(SnsInfoFlip.r(this.nXg));
                        multiTouchImageView.setLayoutParams(new Gallery.LayoutParams(-1, -1));
                        af.byl().a(ate, multiTouchImageView, this.context.hashCode(), a2, v.ND(((b) SnsInfoFlip.j(this.nXg).get(i)).nuP));
                        multiTouchImageView.setImageBitmap(a);
                        x.d("MicroMsg.SnsInfoFlip", "dancy mediaId: %s, isbigImgLoaded: %s, view: %s", new Object[]{ate.ksA, SnsInfoFlip.s(this.nXg).get(ate.ksA), Integer.valueOf(multiTouchImageView.getId())});
                        return multiTouchImageView;
                    }
                }
                if (!this.icr && ab.bU(this.context)) {
                    if (i - 1 >= 0) {
                        xs(i - 1);
                    }
                    if (i + 1 >= SnsInfoFlip.d(this.nXg).getCount()) {
                        return view;
                    }
                    xs(i + 1);
                    return view;
                }
            }
        }
        ate = ate2;
        if (obj != null) {
        }
        a = af.byl().a(ate, snsInfoFlip$d.bRk, this.context.hashCode(), obj != null, a2, v.ND(((b) SnsInfoFlip.j(this.nXg).get(i)).nuP));
        SnsInfoFlip.a(this.nXg, ate.ksA);
        layoutParams = snsInfoFlip$d.bRk.getLayoutParams();
        layoutParams.width = -1;
        layoutParams.height = -1;
        snsInfoFlip$d.bRk.setLayoutParams(layoutParams);
        if (a != null) {
        }
        if (this.nXm) {
            snsInfoFlip$d.nXq.setVisibility(8);
            af.byl().a(ate, snsInfoFlip$d.bRk, this.context.hashCode(), a2, v.ND(((b) SnsInfoFlip.j(this.nXg).get(i)).nuP));
            snsInfoFlip$d.bRk.setImageBitmap(a);
            snsInfoFlip$d.bRk.setVisibility(0);
        } else {
            snsInfoFlip$d.nXq.setVisibility(8);
            if (a != null) {
                if (SnsInfoFlip.p(this.nXg)) {
                    return view;
                }
                x.i("MicroMsg.SnsInfoFlip", "update view ");
                MultiTouchImageView multiTouchImageView2 = new MultiTouchImageView(this.context, a.getWidth(), a.getHeight(), SnsInfoFlip.q(this.nXg));
                multiTouchImageView2.setEnableHorLongBmpMode(SnsInfoFlip.r(this.nXg));
                multiTouchImageView2.setLayoutParams(new Gallery.LayoutParams(-1, -1));
                af.byl().a(ate, multiTouchImageView2, this.context.hashCode(), a2, v.ND(((b) SnsInfoFlip.j(this.nXg).get(i)).nuP));
                multiTouchImageView2.setImageBitmap(a);
                x.d("MicroMsg.SnsInfoFlip", "dancy mediaId: %s, isbigImgLoaded: %s, view: %s", new Object[]{ate.ksA, SnsInfoFlip.s(this.nXg).get(ate.ksA), Integer.valueOf(multiTouchImageView2.getId())});
                return multiTouchImageView2;
            }
        }
        return !this.icr ? view : view;
    }

    public final void clear() {
        x.i("MicroMsg.SnsInfoFlip", "adapter clear.");
        this.nXn.clear();
    }

    public final void xt(int i) {
        b bVar = (b) SnsInfoFlip.j(this.nXg).get(i);
        if (bVar == null) {
            x.w("MicroMsg.SnsInfoFlip", "notify online sight play, but flip item is null.");
            return;
        }
        String str = bVar.nuP;
        if (bi.oW(str)) {
            x.w("MicroMsg.SnsInfoFlip", "notify online sight play, but sns local id is null.");
            return;
        }
        x.i("MicroMsg.SnsInfoFlip", "notify online sight play pos %s sns local id %s", new Object[]{Integer.valueOf(i), str});
        WeakReference weakReference = (WeakReference) this.nXn.get(str);
        if (weakReference == null) {
            x.w("MicroMsg.SnsInfoFlip", "notify online sight play, but view cache is null ");
            this.nXo = str;
            return;
        }
        OnlineVideoView onlineVideoView = (OnlineVideoView) weakReference.get();
        if (onlineVideoView == null) {
            x.w("MicroMsg.SnsInfoFlip", "online sight view is null, do nothing. snsLocalId %s", new Object[]{str});
            this.nXo = str;
            return;
        }
        x.i("MicroMsg.SnsInfoFlip", "%d notify online sight play video %s", new Object[]{Integer.valueOf(onlineVideoView.hashCode()), str});
        this.nXo = null;
        x.d("MicroMsg.OnlineVideoView", "%d register sns ui event", new Object[]{Integer.valueOf(onlineVideoView.hashCode())});
        a.sFg.b(onlineVideoView.nPC);
        onlineVideoView.a(bVar.caK, bVar.nuP, bVar.dTR);
        pw pwVar = new pw();
        pwVar.caC.bOh = 1;
        pwVar.caC.bNH = str;
        a.sFg.m(pwVar);
    }

    public final void bDx() {
        x.i("MicroMsg.SnsInfoFlip", "notify online sight stop %s", new Object[]{bi.cjd()});
        this.nXo = null;
        pw pwVar = new pw();
        pwVar.caC.bOh = 2;
        a.sFg.m(pwVar);
    }

    public final Object getItem(int i) {
        if (i >= SnsInfoFlip.j(this.nXg).size() || i < 0) {
            return null;
        }
        return SnsInfoFlip.j(this.nXg).get(i);
    }

    public final long getItemId(int i) {
        return 0;
    }

    public final void notifyDataSetChanged() {
        this.nKI = SnsInfoFlip.j(this.nXg).size();
        x.d("MicroMsg.SnsInfoFlip", "items.size:" + SnsInfoFlip.j(this.nXg).size());
        this.nXg.invalidate();
        this.nXg.requestLayout();
        super.notifyDataSetChanged();
        if (SnsInfoFlip.j(this.nXg).size() <= 0 && SnsInfoFlip.t(this.nXg) != null) {
            SnsInfoFlip.t(this.nXg).run();
        }
    }
}

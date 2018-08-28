package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;
import android.widget.AbsoluteLayout;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.sns.f.b;
import com.tencent.mm.plugin.sns.i;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.storage.a;
import com.tencent.mm.pluginsdk.e;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.y;

public final class c {
    private Context mContext;
    boolean nAK = false;
    private b nKt;
    TextView nKu;
    ListView nKv;
    View nKw;
    private int njc = -1;
    protected Animation ntA;
    boolean ntB = false;
    private com.tencent.mm.plugin.sns.ui.b.b ntw;
    private FrameLayout ntx;
    AbsoluteLayout nty = null;
    protected Animation ntz;

    static /* synthetic */ void a(c cVar, View view, View view2) {
        boolean z;
        com.tencent.mm.plugin.sns.data.b bVar = (com.tencent.mm.plugin.sns.data.b) view.getTag();
        view2.setVisibility(0);
        cVar.ntB = true;
        cVar.ntz.setAnimationListener(new AnimationListener() {
            public final void onAnimationStart(Animation animation) {
                c.this.ntB = true;
            }

            public final void onAnimationEnd(Animation animation) {
                c.this.ntB = false;
            }

            public final void onAnimationRepeat(Animation animation) {
            }
        });
        view2.startAnimation(cVar.ntz);
        cVar.nKu = (TextView) view2.findViewById(f.ad_unlike_tv);
        cVar.nKu.setTag(bVar);
        if (bVar.nkH == null || bVar.nkH.oho == null) {
            z = false;
        } else {
            a aVar = bVar.nkH.ohp;
            String fD = w.fD(ad.getContext());
            CharSequence charSequence = "zh_CN".equals(fD) ? aVar.nyp : ("zh_TW".equals(fD) || "zh_HK".equals(fD)) ? aVar.nyr : aVar.nyq;
            if (!bi.oW(charSequence)) {
                cVar.nKu.setText(charSequence);
            }
            z = aVar.nys;
        }
        cVar.nKv = (ListView) view2.findViewById(f.ad_unlike_reason_list);
        cVar.nKv.setAdapter(new d(cVar.mContext, (com.tencent.mm.plugin.sns.data.b) view.getTag()));
        if (z) {
            cVar.nKv.setClickable(false);
            cVar.nKv.setOnItemClickListener(null);
        } else {
            cVar.nKv.setClickable(true);
            cVar.nKv.setOnItemClickListener(cVar.ntw.okX);
        }
        cVar.nKu.setClickable(false);
        cVar.nKw = view2;
    }

    public c(Context context, com.tencent.mm.plugin.sns.ui.b.b bVar, FrameLayout frameLayout, b bVar2) {
        this.mContext = context;
        this.nKt = bVar2;
        this.ntw = bVar;
        this.ntx = frameLayout;
        this.ntz = new ScaleAnimation(1.0f, 1.0f, 0.0f, 1.0f, 1, 1.0f, 1, 0.0f);
        this.ntz = AnimationUtils.loadAnimation(context, i.a.dropdown_down);
        this.ntA = new ScaleAnimation(1.0f, 1.0f, 1.0f, 0.0f, 1, 1.0f, 1, 0.0f);
        this.ntA = AnimationUtils.loadAnimation(context, i.a.dropdown_up);
    }

    public final boolean cD(final View view) {
        int cA;
        if (af.byg().bzg() && this.nKt != null) {
            cA = this.nKt.cA(view);
            if (cA == 0 || cA == 1) {
                return true;
            }
            x.i("MicroMsg.AdNotLikeHelper", "abtest error return 2");
        }
        if (this.ntB) {
            return false;
        }
        if (this.nty != null) {
            if (this.nty.getTag() instanceof a) {
                View view2 = ((a) this.nty.getTag()).nid;
                this.ntB = true;
                view2.startAnimation(this.ntA);
                this.ntA.setAnimationListener(new 3(this, view2));
            } else {
                bzf();
            }
            return false;
        } else if (view.getTag() == null || !(view.getTag() instanceof com.tencent.mm.plugin.sns.data.b)) {
            return false;
        } else {
            com.tencent.mm.plugin.sns.data.b bVar = (com.tencent.mm.plugin.sns.data.b) view.getTag();
            String str = bVar.bKW;
            this.nty = new AbsoluteLayout(this.mContext);
            this.nty.setId(f.address);
            LayoutParams layoutParams = new LayoutParams(-1, -1);
            this.ntx.addView(this.nty);
            int b = BackwardSupportUtil.b.b(this.mContext, 150.0f);
            int b2 = BackwardSupportUtil.b.b(this.mContext, 17.0f);
            BackwardSupportUtil.b.b(this.mContext, 40.0f);
            final View inflate = y.gq(this.mContext).inflate(g.ad_unlike_content, null);
            TextView textView = (TextView) inflate.findViewById(f.ad_unlike_tip);
            String fD = w.fD(ad.getContext());
            com.tencent.mm.plugin.sns.storage.b bVar2 = bVar.nkH.oho;
            if (bVar2 != null) {
                CharSequence charSequence;
                if ("zh_CN".equals(fD)) {
                    charSequence = bVar2.nyU;
                } else if ("zh_TW".equals(fD) || "zh_HK".equals(fD)) {
                    charSequence = bVar2.nyW;
                } else {
                    charSequence = bVar2.nyV;
                }
                if (!bi.oW(charSequence)) {
                    textView.setText(charSequence);
                }
            }
            Rect rect = new Rect();
            int eK = e.eK(this.mContext);
            int[] bED = bVar.nkH.bED();
            x.d("MicroMsg.AdNotLikeHelper", "addCommentView getLocationInWindow " + bED[0] + "  " + bED[1] + " height: " + eK);
            this.njc = e.eL(this.mContext);
            if (this.nAK) {
                cA = com.tencent.mm.bp.a.fromDPToPix(this.mContext, 2);
                this.njc = 0;
            } else {
                cA = eK;
            }
            ViewGroup.LayoutParams layoutParams2 = new AbsoluteLayout.LayoutParams(-2, -2, bED[0] - b, ((bED[1] - this.njc) - cA) + b2);
            this.nty.setTag(new a(this, str, inflate));
            this.nty.addView(inflate, layoutParams2);
            inflate.setVisibility(8);
            this.ntB = true;
            new ag().post(new Runnable() {
                public final void run() {
                    c.a(c.this, view, inflate);
                }
            });
            return true;
        }
    }

    public final boolean bzf() {
        if (this.nKt != null && af.byg().bzg()) {
            this.nKt.bzf();
        }
        if (this.nty != null) {
            this.ntx.removeView(this.nty);
            this.nty = null;
            return true;
        }
        this.ntB = false;
        this.nKv = null;
        this.nKw = null;
        return false;
    }

    public final boolean bBH() {
        int height = this.nKu.getHeight();
        this.nKu.setVisibility(8);
        View view = null;
        int i = 0;
        for (int i2 = 0; i2 < this.nKv.getAdapter().getCount(); i2++) {
            view = this.nKv.getAdapter().getView(i2, view, null);
            view.measure(this.nKw.getWidth(), -2);
            i += view.getMeasuredHeight();
        }
        ((RelativeLayout.LayoutParams) this.nKv.getLayoutParams()).bottomMargin = height - i;
        this.nKv.setVisibility(0);
        4 4 = new 4(this, height, i);
        4.setDuration(250);
        this.nKv.startAnimation(4);
        return true;
    }
}

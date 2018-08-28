package com.tencent.mm.plugin.mall.ui;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.tencent.mm.bp.a;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.an;

class MallIndexBaseUI$3 implements OnScrollListener {
    final /* synthetic */ MallIndexBaseUI kZq;

    MallIndexBaseUI$3(MallIndexBaseUI mallIndexBaseUI) {
        this.kZq = mallIndexBaseUI;
    }

    public final void onScrollStateChanged(AbsListView absListView, int i) {
    }

    public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
        int i4 = 100;
        if (absListView.getChildCount() != 0) {
            int fromDPToPix = a.fromDPToPix(this.kZq.mController.tml, 50);
            int fromDPToPix2 = a.fromDPToPix(this.kZq.mController.tml, 200);
            if (i == 0) {
                int abs = Math.abs(absListView.getChildAt(0).getTop());
                if (abs <= fromDPToPix) {
                    i4 = 0;
                } else if (abs < fromDPToPix2) {
                    i4 = ((abs - fromDPToPix) * 100) / (fromDPToPix2 - fromDPToPix);
                }
                x.d("MicroMsg.MallIndexBaseUI", "dancy scrollY: %s, mAlpha:%s", new Object[]{Integer.valueOf(abs), Integer.valueOf(i4)});
                fromDPToPix = i4;
            } else {
                fromDPToPix = 100;
            }
            if (fromDPToPix <= 0) {
                this.kZq.lF(this.kZq.mController.tml.getResources().getColor(c.transparent));
                return;
            }
            boolean z = ad.getContext().getSharedPreferences(ad.chY() + "_redesign", 4).getBoolean("dark_actionbar", false);
            i4 = c.normal_actionbar_color;
            if (z) {
                i4 = c.dark_actionbar_color;
            }
            this.kZq.lF(an.eN(this.kZq.mController.tml.getResources().getColor(i4), fromDPToPix));
        }
    }
}

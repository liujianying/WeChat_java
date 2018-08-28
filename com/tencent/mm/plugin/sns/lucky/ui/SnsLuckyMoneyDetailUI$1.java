package com.tencent.mm.plugin.sns.lucky.ui;

import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.tencent.mm.plugin.wxpay.a.c;

class SnsLuckyMoneyDetailUI$1 implements OnScrollListener {
    private boolean kLV = false;
    private boolean kLW;
    final /* synthetic */ SnsLuckyMoneyDetailUI nmg;

    SnsLuckyMoneyDetailUI$1(SnsLuckyMoneyDetailUI snsLuckyMoneyDetailUI) {
        this.nmg = snsLuckyMoneyDetailUI;
    }

    public final void onScrollStateChanged(AbsListView absListView, int i) {
        if (absListView.getCount() != 0) {
            switch (i) {
                case 0:
                    this.kLV = false;
                    return;
                case 1:
                    this.kLV = true;
                    return;
                default:
                    return;
            }
        }
    }

    public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
        boolean z = true;
        if (i3 != 0 && this.kLV) {
            if (i <= 0) {
                int top;
                View childAt = absListView.getChildAt(i);
                if (childAt != null) {
                    top = 0 - childAt.getTop();
                } else {
                    top = 0;
                }
                if (top <= 100) {
                    z = false;
                }
            }
            if (this.kLW != z) {
                if (z) {
                    this.nmg.getResources().getDrawable(c.sns_lucky_background_start_color);
                    SnsLuckyMoneyDetailUI.bxf();
                } else {
                    SnsLuckyMoneyDetailUI.bxg();
                }
                this.kLW = z;
            }
        }
    }
}

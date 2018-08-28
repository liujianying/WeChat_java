package com.tencent.mm.plugin.luckymoney.appbrand.ui.detail;

import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.tencent.mm.plugin.wxpay.a.e;

class WxaLuckyMoneyDetailUI$1 implements OnScrollListener {
    private boolean kLV = false;
    private boolean kLW;
    final /* synthetic */ WxaLuckyMoneyDetailUI kLX;

    WxaLuckyMoneyDetailUI$1(WxaLuckyMoneyDetailUI wxaLuckyMoneyDetailUI) {
        this.kLX = wxaLuckyMoneyDetailUI;
    }

    public final void onScrollStateChanged(AbsListView absListView, int i) {
        if (absListView.getCount() != 0) {
            switch (i) {
                case 0:
                    if (absListView.getLastVisiblePosition() == absListView.getCount() - 1) {
                        WxaLuckyMoneyDetailUI.a(this.kLX).rW(absListView.getCount());
                    }
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
                    WxaLuckyMoneyDetailUI.a(this.kLX, this.kLX.getResources().getDrawable(e.lucky_money_actionbar_bg));
                } else {
                    WxaLuckyMoneyDetailUI.b(this.kLX);
                }
                this.kLW = z;
            }
        }
    }
}

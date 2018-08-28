package com.tencent.mm.plugin.luckymoney.ui;

import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.tencent.mm.plugin.wxpay.a.e;

class LuckyMoneyBusiDetailUI$1 implements OnScrollListener {
    private boolean kLV = false;
    private boolean kLW;
    final /* synthetic */ LuckyMoneyBusiDetailUI kUw;

    LuckyMoneyBusiDetailUI$1(LuckyMoneyBusiDetailUI luckyMoneyBusiDetailUI) {
        this.kUw = luckyMoneyBusiDetailUI;
    }

    public final void onScrollStateChanged(AbsListView absListView, int i) {
        if (absListView.getCount() != 0) {
            switch (i) {
                case 0:
                    if (absListView.getLastVisiblePosition() == absListView.getCount() - 1) {
                        if (!this.kUw.kUg.baU()) {
                            LuckyMoneyBusiDetailUI.a(this.kUw);
                        }
                        if (LuckyMoneyBusiDetailUI.b(this.kUw) && !LuckyMoneyBusiDetailUI.c(this.kUw)) {
                            LuckyMoneyBusiDetailUI.d(this.kUw);
                        }
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
                    this.kUw.getResources().getDrawable(e.lucky_money_actionbar_bg);
                }
                LuckyMoneyBusiDetailUI.bbo();
                this.kLW = z;
            }
        }
    }
}

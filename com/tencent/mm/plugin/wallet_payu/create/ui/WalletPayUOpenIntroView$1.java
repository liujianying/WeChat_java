package com.tencent.mm.plugin.wallet_payu.create.ui;

import android.support.v4.view.ViewPager.e;

class WalletPayUOpenIntroView$1 implements e {
    final /* synthetic */ WalletPayUOpenIntroView pEJ;

    WalletPayUOpenIntroView$1(WalletPayUOpenIntroView walletPayUOpenIntroView) {
        this.pEJ = walletPayUOpenIntroView;
    }

    public final void a(int i, float f, int i2) {
    }

    public final void O(int i) {
        if (WalletPayUOpenIntroView.a(this.pEJ).getParent() != null) {
            WalletPayUOpenIntroView.a(this.pEJ).getParent().requestDisallowInterceptTouchEvent(true);
        }
        WalletPayUOpenIntroView.b(this.pEJ).setPage(i);
    }

    public final void N(int i) {
    }
}

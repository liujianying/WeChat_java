package com.tencent.mm.plugin.offline.ui;

import android.widget.ScrollView;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa.a;
import com.tencent.mm.ui.ak;

class WalletOfflineCoinPurseUI$5 implements Runnable {
    final /* synthetic */ WalletOfflineCoinPurseUI lMe;
    final /* synthetic */ boolean lMf;
    final /* synthetic */ boolean lMg;
    final /* synthetic */ boolean lMh;
    final /* synthetic */ boolean lMi;
    final /* synthetic */ boolean lMj;

    WalletOfflineCoinPurseUI$5(WalletOfflineCoinPurseUI walletOfflineCoinPurseUI, boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        this.lMe = walletOfflineCoinPurseUI;
        this.lMf = z;
        this.lMg = z2;
        this.lMh = z3;
        this.lMi = z4;
        this.lMj = z5;
    }

    public final void run() {
        ScrollView scrollView = (ScrollView) this.lMe.findViewById(f.offline_root_layout);
        if (scrollView != null) {
            int bottom;
            int[] iArr = new int[2];
            scrollView.getLocationInWindow(iArr);
            int i = ak.gu(this.lMe.mController.tml).y;
            if (ak.gt(this.lMe.mController.tml)) {
                x.d("MicroMsg.WalletOfflineCoinPurseUI", "has navi");
                i -= ak.gs(this.lMe.mController.tml);
            }
            if (this.lMf) {
                bottom = iArr[1] + WalletOfflineCoinPurseUI.h(this.lMe).getBottom();
            } else {
                bottom = 0;
            }
            if (this.lMg) {
                bottom = iArr[1] + WalletOfflineCoinPurseUI.i(this.lMe).getBottom();
            }
            if (this.lMh) {
                bottom = iArr[1] + WalletOfflineCoinPurseUI.j(this.lMe).getBottom();
            }
            if (this.lMi) {
                bottom = iArr[1] + WalletOfflineCoinPurseUI.k(this.lMe).getBottom();
            }
            if (this.lMj) {
                bottom = iArr[1] + WalletOfflineCoinPurseUI.l(this.lMe).getBottom();
            }
            x.d("MicroMsg.WalletOfflineCoinPurseUI", "f2f: %s, screen: %s", new Object[]{Integer.valueOf(bottom), Integer.valueOf(i)});
            i = bottom - i;
            if (i > 0) {
                scrollView.scrollBy(0, i);
            }
            g.Ei().DT().a(a.sZh, Boolean.valueOf(true));
        }
    }
}

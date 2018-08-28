package com.tencent.mm.plugin.offline.ui;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.offline.c.a;
import com.tencent.mm.plugin.offline.ui.c.10;
import com.tencent.mm.plugin.offline.ui.c.7;
import com.tencent.mm.plugin.offline.ui.c.8;
import com.tencent.mm.plugin.offline.ui.c.9;
import com.tencent.mm.plugin.walletlock.a.b;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.c;

class WalletOfflineCoinPurseUI$15 implements c {
    final /* synthetic */ WalletOfflineCoinPurseUI lMe;

    WalletOfflineCoinPurseUI$15(WalletOfflineCoinPurseUI walletOfflineCoinPurseUI) {
        this.lMe = walletOfflineCoinPurseUI;
    }

    public final void ju(int i) {
        switch (i) {
            case 0:
                a.dY(this.lMe);
                return;
            case 1:
                c A = WalletOfflineCoinPurseUI.A(this.lMe);
                if (((b) g.l(b.class)).bRp()) {
                    h.a(A.mActivity, A.getString(i.wallet_wx_offline_close_tips), "", A.getString(i.wallet_wx_offline_close_btn_text), A.getString(i.app_cancel), new 9(A), new 10(A));
                    return;
                } else {
                    h.a(A.mActivity, A.getString(i.wallet_wx_offline_close_tips_no_wallet_lock), "", A.getString(i.wallet_wx_offline_start_wallet_lock), A.getString(i.wallet_wx_offline_close_btn_text), new 7(A), new 8(A));
                    return;
                }
            default:
                return;
        }
    }
}

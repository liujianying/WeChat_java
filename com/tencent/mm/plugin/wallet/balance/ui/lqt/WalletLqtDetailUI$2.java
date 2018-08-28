package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.platformtools.af;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vending.g.g;
import com.tencent.mm.wallet_core.ui.e;

class WalletLqtDetailUI$2 implements OnClickListener {
    final /* synthetic */ WalletLqtDetailUI pbs;

    WalletLqtDetailUI$2(WalletLqtDetailUI walletLqtDetailUI) {
        this.pbs = walletLqtDetailUI;
    }

    public final void onClick(View view) {
        String str = null;
        boolean z = true;
        Intent intent;
        String str2;
        if (af.eyi) {
            intent = new Intent(this.pbs, WalletLqtSaveFetchUI.class);
            str2 = "lqt_save_fund_code";
            if (WalletLqtDetailUI.c(this.pbs) != null) {
                str = WalletLqtDetailUI.c(this.pbs).seK;
            }
            intent.putExtra(str2, str);
            intent.putExtra("lqt_save_fetch_mode", 1);
            intent.putExtra("lqt_is_show_protocol", WalletLqtDetailUI.c(this.pbs).cej == 1);
            str = "lqt_is_agree_protocol";
            if (WalletLqtDetailUI.c(this.pbs).sfD != 1) {
                z = false;
            }
            intent.putExtra(str, z);
            intent.putStringArrayListExtra("lqt_protocol_list", WalletLqtDetailUI.e(this.pbs));
            intent.putExtra("lqt_profile_wording", WalletLqtDetailUI.c(this.pbs).sfx);
            this.pbs.startActivity(intent);
            return;
        }
        g.cx(Integer.valueOf(WalletLqtDetailUI.c(this.pbs).rtK)).c(WalletLqtDetailUI.f(this.pbs).oYX);
        if (bi.oW(WalletLqtDetailUI.c(this.pbs).sfJ)) {
            intent = new Intent(this.pbs, WalletLqtSaveFetchUI.class);
            str2 = "lqt_save_fund_code";
            if (WalletLqtDetailUI.c(this.pbs) != null) {
                str = WalletLqtDetailUI.c(this.pbs).seK;
            }
            intent.putExtra(str2, str);
            intent.putExtra("lqt_save_fetch_mode", 1);
            intent.putExtra("lqt_is_show_protocol", WalletLqtDetailUI.c(this.pbs).cej == 1);
            str = "lqt_is_agree_protocol";
            if (WalletLqtDetailUI.c(this.pbs).sfD != 1) {
                z = false;
            }
            intent.putExtra(str, z);
            intent.putStringArrayListExtra("lqt_protocol_list", WalletLqtDetailUI.e(this.pbs));
            intent.putExtra("lqt_profile_wording", WalletLqtDetailUI.c(this.pbs).sfx);
            intent.putExtra("lqt_account_type", WalletLqtDetailUI.c(this.pbs).rtK);
            intent.putExtra("lqt_fund_spid", WalletLqtDetailUI.c(this.pbs).seM);
            this.pbs.startActivity(intent);
            return;
        }
        x.i("MicroMsg.WalletLqtDetailUI", "click save button, go to block url: %s", new Object[]{WalletLqtDetailUI.c(this.pbs).sfJ});
        e.l(this.pbs, WalletLqtDetailUI.c(this.pbs).sfJ, false);
    }
}

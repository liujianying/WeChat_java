package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.content.Intent;
import com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtSaveFetchUI.7;
import com.tencent.mm.protocal.c.bft;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vending.c.a;

class WalletLqtSaveFetchUI$7$4 implements a<Void, bft> {
    final /* synthetic */ 7 pcf;
    final /* synthetic */ int pcg;

    WalletLqtSaveFetchUI$7$4(7 7, int i) {
        this.pcf = 7;
        this.pcg = i;
    }

    private Void a(bft bft) {
        x.i("MicroMsg.WalletLqtSaveFetchUI", "redeem succ: %s, is_realtime_arrivial: %s, is_redeem_into_pocket: %s", new Object[]{bft, Boolean.valueOf(bft.sgR), Boolean.valueOf(bft.sgS)});
        if (bft.sgR && bft.sgS) {
            Intent intent = new Intent(this.pcf.pcc, WalletLqtSaveFetchFinishUI.class);
            intent.putExtra("key_amount", ((double) this.pcg) / 100.0d);
            intent.putExtra("key_mode", 2);
            this.pcf.pcc.startActivity(intent);
        } else {
            Intent intent2 = new Intent(this.pcf.pcc, WalletLqtSaveFetchFinishProgressUI.class);
            try {
                intent2.putExtra("key_redeem_res", bft.toByteArray());
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.WalletLqtSaveFetchUI", e, "pass redeemFundRes error: %s", new Object[]{e.getMessage()});
            }
            this.pcf.pcc.startActivity(intent2);
        }
        this.pcf.pcc.finish();
        return uQG;
    }
}

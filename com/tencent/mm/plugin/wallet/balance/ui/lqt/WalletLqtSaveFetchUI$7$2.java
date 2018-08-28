package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.content.Intent;
import com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtSaveFetchUI.7;
import com.tencent.mm.protocal.c.bdm;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vending.c.a;

class WalletLqtSaveFetchUI$7$2 implements a<Void, bdm> {
    final /* synthetic */ 7 pcf;
    final /* synthetic */ int pcg;

    WalletLqtSaveFetchUI$7$2(7 7, int i) {
        this.pcf = 7;
        this.pcg = i;
    }

    public final /* synthetic */ Object call(Object obj) {
        bdm bdm = (bdm) obj;
        x.i("MicroMsg.WalletLqtSaveFetchUI", "save finish: %s", Integer.valueOf(bdm.sfv));
        Intent intent = new Intent(this.pcf.pcc, WalletLqtSaveFetchFinishUI.class);
        intent.putExtra("key_amount", ((double) this.pcg) / 100.0d);
        intent.putExtra("key_mode", 1);
        intent.putExtra("profile_date_wording", bdm.sfx);
        intent.putExtra("profile_upgrade_wording", bdm.sfw);
        this.pcf.pcc.startActivity(intent);
        this.pcf.pcc.finish();
        return uQG;
    }
}

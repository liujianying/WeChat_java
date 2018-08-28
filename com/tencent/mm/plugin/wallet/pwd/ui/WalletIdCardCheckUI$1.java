package com.tencent.mm.plugin.wallet.pwd.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.sdk.platformtools.x;

class WalletIdCardCheckUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ WalletIdCardCheckUI phR;

    WalletIdCardCheckUI$1(WalletIdCardCheckUI walletIdCardCheckUI) {
        this.phR = walletIdCardCheckUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        x.i("Micromsg.WalletIdCardCheckUI", "onbackbtn click");
        this.phR.finish();
        return false;
    }
}

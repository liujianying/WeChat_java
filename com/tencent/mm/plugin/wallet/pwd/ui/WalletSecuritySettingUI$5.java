package com.tencent.mm.plugin.wallet.pwd.ui;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.tencent.mm.ak.p$a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.preference.IconPreference;

class WalletSecuritySettingUI$5 implements p$a {
    final /* synthetic */ WalletSecuritySettingUI piD;
    final /* synthetic */ IconPreference piE;

    WalletSecuritySettingUI$5(WalletSecuritySettingUI walletSecuritySettingUI, IconPreference iconPreference) {
        this.piD = walletSecuritySettingUI;
        this.piE = iconPreference;
    }

    public final void i(String str, Bitmap bitmap) {
        x.i("MicroMsg.WalletSecuritySettingUI", "alvinluo icon url: %s", new Object[]{str});
        this.piE.drawable = new BitmapDrawable(this.piD.mController.tml.getResources(), bitmap);
    }
}

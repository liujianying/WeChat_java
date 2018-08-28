package com.tencent.mm.plugin.wallet_payu.pwd.ui;

import com.tencent.mm.plugin.wallet.pwd.ui.WalletPasswordSettingUI;
import com.tencent.mm.plugin.wallet_payu.pwd.a.f;
import com.tencent.mm.plugin.wallet_payu.pwd.a.g;
import com.tencent.mm.plugin.wxpay.a$l;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.a;

public class WalletPayUPasswordSettingUI extends WalletPasswordSettingUI {
    protected final void bOf() {
        x.d("MicroMsg.WalletPayUPasswordSettingUI", "hy: start payu do forgot pwd");
        a.a(this, f.class, null);
    }

    protected final void bOe() {
        x.d("MicroMsg.WalletPayUPasswordSettingUI", "hy: start payu reset pwd");
        a.a(this, g.class, null);
    }

    protected final void bOg() {
        this.tCL.bw("wallet_modify_gesture_password", true);
        this.tCL.bw("wallet_open_gesture_password", true);
    }

    protected final int bOd() {
        return a$l.wallet_payu_password_setting_pref;
    }
}

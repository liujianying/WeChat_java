package com.tencent.mm.plugin.wallet_payu.pwd.a;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.mm.plugin.wallet_payu.pwd.ui.WalletPayUCheckPwdUI;
import com.tencent.mm.plugin.wallet_payu.pwd.ui.WalletPayUPwdConfirmUI;
import com.tencent.mm.plugin.wallet_payu.pwd.ui.WalletPayUSetPasswordUI;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.d.i;

public class g extends e {
    public final c a(Activity activity, Bundle bundle) {
        c(activity, WalletPayUCheckPwdUI.class, bundle);
        return this;
    }

    public final void a(Activity activity, int i, Bundle bundle) {
        if (activity instanceof WalletPayUCheckPwdUI) {
            c(activity, WalletPayUSetPasswordUI.class, bundle);
        } else {
            super.a(activity, i, bundle);
        }
    }

    public final com.tencent.mm.wallet_core.d.g a(MMActivity mMActivity, i iVar) {
        if (mMActivity instanceof WalletPayUCheckPwdUI) {
            return new 1(this, mMActivity, iVar, this.jfZ);
        }
        return mMActivity instanceof WalletPayUPwdConfirmUI ? new 2(this, mMActivity, iVar) : super.a(mMActivity, iVar);
    }

    public final String aNK() {
        return "PayUModifyPasswordProcess";
    }
}

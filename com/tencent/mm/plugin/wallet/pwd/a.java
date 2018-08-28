package com.tencent.mm.plugin.wallet.pwd;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.plugin.wallet.a.p;
import com.tencent.mm.plugin.wallet.pwd.ui.WalletForgotPwdBindNewUI;
import com.tencent.mm.plugin.wallet.pwd.ui.WalletForgotPwdUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletBankcardIdUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletCardElementUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletConfirmCardIDUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletPwdConfirmUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletSetPasswordUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletVerifyCodeUI;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

public class a extends com.tencent.mm.plugin.wallet_core.b.a {
    public final c a(Activity activity, Bundle bundle) {
        x.d("MicroMsg.ProcessManager", "start Process : ForgotPwdProcess");
        Bundle bundle2 = this.jfZ;
        String str = "key_is_oversea";
        p.bNp();
        bundle2.putBoolean(str, !p.bNq().bPx());
        bundle2 = this.jfZ;
        str = "key_support_bankcard";
        p.bNp();
        bundle2.putInt(str, p.bNq().bPx() ? 1 : 2);
        this.jfZ.putBoolean("key_is_forgot_process", true);
        c(activity, WalletForgotPwdUI.class, bundle);
        return this;
    }

    public final void a(Activity activity, int i, Bundle bundle) {
        if (activity instanceof WalletForgotPwdUI) {
            if (bundle.containsKey("key_is_force_bind") && bundle.getBoolean("key_is_force_bind")) {
                c(activity, WalletForgotPwdBindNewUI.class, bundle);
            } else {
                c(activity, WalletCardElementUI.class, bundle);
            }
        } else if (activity instanceof WalletCardElementUI) {
            if (bQH()) {
                c(activity, WalletSetPasswordUI.class, bundle);
            } else {
                c(activity, WalletVerifyCodeUI.class, bundle);
            }
        } else if (activity instanceof WalletVerifyCodeUI) {
            c(activity, WalletSetPasswordUI.class, bundle);
        } else if (activity instanceof WalletSetPasswordUI) {
            c(activity, WalletPwdConfirmUI.class, bundle);
        } else if (activity instanceof WalletPwdConfirmUI) {
            b(activity, bundle);
        } else if ((activity instanceof WalletBankcardIdUI) || (activity instanceof WalletConfirmCardIDUI)) {
            y(new Object[]{"startActivity2", activity, WalletCardElementUI.class, bundle, "flag: 67108864"});
            Intent intent = new Intent(activity, WalletCardElementUI.class);
            intent.putExtra("process_id", getClass().hashCode());
            intent.addFlags(67108864);
            activity.startActivity(intent);
            if (bundle != null) {
                this.jfZ.putAll(bundle);
            }
            x.d("MicroMsg.ProcessManager", "bankcard tag :" + cCR());
        }
    }

    public final void b(Activity activity, Bundle bundle) {
        a(activity, WalletForgotPwdUI.class, -1, false);
    }

    public final g a(MMActivity mMActivity, i iVar) {
        if (mMActivity instanceof WalletForgotPwdUI) {
            return new 1(this, mMActivity, iVar);
        }
        if (mMActivity instanceof WalletCardElementUI) {
            return new 2(this, mMActivity, iVar);
        }
        if (mMActivity instanceof WalletVerifyCodeUI) {
            return new 3(this, mMActivity, iVar);
        }
        return mMActivity instanceof WalletPwdConfirmUI ? new 4(this, mMActivity, iVar) : super.a(mMActivity, iVar);
    }

    public final boolean c(Activity activity, Bundle bundle) {
        return activity instanceof WalletPwdConfirmUI;
    }

    public final boolean a(WalletBaseUI walletBaseUI, int i, String str) {
        switch (i) {
            case 404:
                h.a(walletBaseUI, str, null, walletBaseUI.getString(com.tencent.mm.plugin.wxpay.a.i.wallet_forget_password_finish_confirm), false, new 5(this, walletBaseUI));
                return true;
            default:
                return false;
        }
    }

    public final int a(MMActivity mMActivity, int i) {
        return com.tencent.mm.plugin.wxpay.a.i.wallet_forget_password_finish_confirm;
    }

    public final String aNK() {
        return "ForgotPwdProcess";
    }
}

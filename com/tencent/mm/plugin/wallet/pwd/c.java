package com.tencent.mm.plugin.wallet.pwd;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.wallet.pwd.ui.WalletResetPwdAdapterUI;
import com.tencent.mm.plugin.wallet_core.model.p;
import com.tencent.mm.plugin.wallet_core.ui.WalletCheckPwdUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletPwdConfirmUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletSetPasswordUI;
import com.tencent.mm.plugin.wxpay.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.smtt.sdk.TbsListener$ErrorCode;

public class c extends com.tencent.mm.wallet_core.c {
    public final com.tencent.mm.wallet_core.c a(Activity activity, Bundle bundle) {
        x.d("MicroMsg.ResetPwdProcessByToken", "start Process : ResetPwdProcessByToken");
        c(activity, WalletSetPasswordUI.class, bundle);
        return this;
    }

    public final void a(Activity activity, int i, Bundle bundle) {
        if (activity instanceof WalletSetPasswordUI) {
            c(activity, WalletPwdConfirmUI.class, bundle);
        } else if (activity instanceof WalletPwdConfirmUI) {
            b(activity, bundle);
        }
    }

    public final void c(Activity activity, int i) {
        if (activity instanceof WalletPwdConfirmUI) {
            a(activity, WalletSetPasswordUI.class, i);
        }
    }

    public final void b(Activity activity, Bundle bundle) {
        Intent intent = new Intent(activity, WalletResetPwdAdapterUI.class);
        intent.putExtra("RESET_PWD_USER_ACTION", bundle.getInt("RESET_PWD_USER_ACTION", 0));
        a(activity, WalletResetPwdAdapterUI.class, -1, intent, false);
    }

    public final g a(MMActivity mMActivity, i iVar) {
        if (mMActivity instanceof WalletCheckPwdUI) {
            return new 1(this, mMActivity, iVar);
        }
        return mMActivity instanceof WalletPwdConfirmUI ? new g(mMActivity, iVar) {
            public final boolean d(int i, int i2, String str, l lVar) {
                if (i == 0 && i2 == 0) {
                    if (!(lVar instanceof com.tencent.mm.plugin.wallet.pwd.a.g)) {
                        return true;
                    }
                    c.this.jfZ.putInt("RESET_PWD_USER_ACTION", 1);
                    c.this.a(this.fEY, 0, c.this.jfZ);
                    h.bA(this.fEY, this.fEY.getString(a.i.wallet_password_setting_success_tip));
                    return true;
                } else if (!(lVar instanceof com.tencent.mm.plugin.wallet.pwd.a.g)) {
                    return false;
                } else {
                    h.a(this.fEY, str, "", false, new 1(this));
                    return true;
                }
            }

            public final boolean m(Object... objArr) {
                p pVar = (p) objArr[0];
                c.this.jfZ.getString("key_pwd1");
                this.uXK.a(new com.tencent.mm.plugin.wallet.pwd.a.g(pVar.eJn, pVar.token), true, 1);
                return true;
            }
        } : super.a(mMActivity, iVar);
    }

    public final boolean c(Activity activity, Bundle bundle) {
        return false;
    }

    public final boolean a(WalletBaseUI walletBaseUI, int i, String str) {
        switch (i) {
            case TbsListener$ErrorCode.INFO_DISABLE_X5 /*404*/:
                h.a(walletBaseUI, str, null, walletBaseUI.getString(a.i.wallet_set_password_finish_confirm), false, new 3(this, walletBaseUI));
                return true;
            default:
                return false;
        }
    }

    public final int a(MMActivity mMActivity, int i) {
        return a.i.wallet_set_password_finish_confirm;
    }

    public final String aNK() {
        return "ResetPwdProcessByToken";
    }
}

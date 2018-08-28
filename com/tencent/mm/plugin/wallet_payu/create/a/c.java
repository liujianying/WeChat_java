package com.tencent.mm.plugin.wallet_payu.create.a;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.mm.plugin.wallet.a.p;
import com.tencent.mm.plugin.wallet_payu.create.ui.WalletPayUStartOpenUI;
import com.tencent.mm.plugin.wallet_payu.create.ui.WalletPayUVerifyCodeUI;
import com.tencent.mm.plugin.wallet_payu.pwd.ui.WalletPayUPwdConfirmUI;
import com.tencent.mm.plugin.wallet_payu.pwd.ui.WalletPayUSetPasswordUI;
import com.tencent.mm.plugin.wallet_payu.security_question.model.a;
import com.tencent.mm.plugin.wallet_payu.security_question.ui.WalletPayUSecurityQuestionAnswerUI;
import com.tencent.mm.plugin.wallet_payu.security_question.ui.WalletPayUSecurityQuestionSettingUI;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.ui.e;

public class c extends com.tencent.mm.wallet_core.c {
    public final com.tencent.mm.wallet_core.c a(Activity activity, Bundle bundle) {
        x.d("MicroMsg.PayUOpenProcess", "hy: start process PayUOpenProcess");
        p.bNp();
        String Ol = p.Ol();
        p.bNp();
        String bNr = p.bNr();
        if (bundle != null) {
            bundle.putString("key_mobile", Ol);
            bundle.putString("dial_code", bNr);
        }
        c(activity, WalletPayUStartOpenUI.class, bundle);
        return this;
    }

    public final void a(Activity activity, int i, Bundle bundle) {
        if (activity instanceof WalletPayUStartOpenUI) {
            c(activity, WalletPayUVerifyCodeUI.class, bundle);
        }
        if (activity instanceof WalletPayUVerifyCodeUI) {
            if (bundle.getBoolean("key_is_has_mobile")) {
                c(activity, WalletPayUSecurityQuestionAnswerUI.class, bundle);
            } else {
                c(activity, WalletPayUSecurityQuestionSettingUI.class, bundle);
            }
        }
        if (activity instanceof WalletPayUSecurityQuestionSettingUI) {
            c(activity, WalletPayUSetPasswordUI.class, bundle);
        }
        if (activity instanceof WalletPayUSetPasswordUI) {
            c(activity, WalletPayUPwdConfirmUI.class, bundle);
        }
        if (activity instanceof WalletPayUSecurityQuestionAnswerUI) {
            c(activity, WalletPayUSetPasswordUI.class, bundle);
        }
    }

    public final void c(Activity activity, int i) {
        if (activity instanceof WalletPayUPwdConfirmUI) {
            a(activity, WalletPayUSetPasswordUI.class, i);
        } else {
            b(activity, this.jfZ);
        }
    }

    public final boolean h(Activity activity, Bundle bundle) {
        bundle.putInt("key_open_error_code", 1);
        s.makeText(activity, activity.getString(i.wallet_payu_start_failed), 0).show();
        b(activity, bundle);
        return true;
    }

    public final void b(Activity activity, Bundle bundle) {
        if (bundle.getInt("key_open_error_code", -1) == 0) {
            x.i("MicroMsg.PayUOpenProcess", "hy: user open success");
            e(activity, "mall", ".ui.MallIndexUI");
            return;
        }
        x.i("MicroMsg.PayUOpenProcess", "hy: user interrupted the process. go to preference");
        super.ag(activity);
        e.hh(activity);
    }

    public final int a(MMActivity mMActivity, int i) {
        if (i == 1) {
            return i.wallet_payu_endprocesstip_create;
        }
        return super.a(mMActivity, i);
    }

    public final boolean c(Activity activity, Bundle bundle) {
        return false;
    }

    public final g a(MMActivity mMActivity, com.tencent.mm.wallet_core.d.i iVar) {
        if (mMActivity instanceof WalletPayUStartOpenUI) {
            return new 1(this, mMActivity, iVar);
        }
        if (mMActivity instanceof WalletPayUVerifyCodeUI) {
            return new 2(this, mMActivity, iVar);
        }
        if (mMActivity instanceof WalletPayUSecurityQuestionSettingUI) {
            return new 3(this, mMActivity, iVar);
        }
        if (mMActivity instanceof WalletPayUPwdConfirmUI) {
            return new 4(this, mMActivity, iVar);
        }
        if (mMActivity instanceof WalletPayUSecurityQuestionAnswerUI) {
            return new a(mMActivity, iVar, this.jfZ);
        }
        return super.a(mMActivity, iVar);
    }

    public final String aNK() {
        return "PayUOpenProcess";
    }
}

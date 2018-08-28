package com.tencent.mm.plugin.wallet_payu.pwd.a;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.mm.plugin.wallet_payu.pwd.ui.WalletPayUPwdConfirmUI;
import com.tencent.mm.plugin.wallet_payu.pwd.ui.WalletPayUSetPasswordUI;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.d.g;

public abstract class e extends c {
    public void a(Activity activity, int i, Bundle bundle) {
        if (activity instanceof WalletPayUSetPasswordUI) {
            c(activity, WalletPayUPwdConfirmUI.class, bundle);
        }
    }

    public final void c(Activity activity, int i) {
        if (activity instanceof WalletPayUPwdConfirmUI) {
            a(activity, WalletPayUSetPasswordUI.class, i);
        }
    }

    public final void b(Activity activity, Bundle bundle) {
        if (this.jfZ.getInt("key_errcode_payu", -1) == 0) {
            s.makeText(activity, i.wallet_order_info_result_success, 0).show();
        } else {
            s.makeText(activity, i.wallet_err_wording_comm_failed, 0).show();
        }
        e(activity, "mall", ".ui.MallIndexUI");
    }

    public final boolean c(Activity activity, Bundle bundle) {
        return false;
    }

    public g a(MMActivity mMActivity, com.tencent.mm.wallet_core.d.i iVar) {
        return mMActivity instanceof WalletPayUPwdConfirmUI ? new 1(this, mMActivity, iVar) : super.a(mMActivity, iVar);
    }
}

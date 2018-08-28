package com.tencent.mm.plugin.wallet_payu.pay.a;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.bg.d;
import com.tencent.mm.g.a.te;
import com.tencent.mm.g.a.te$a;
import com.tencent.mm.plugin.wallet_core.b.a;
import com.tencent.mm.plugin.wallet_core.ui.WalletPwdConfirmUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletSetPasswordUI;
import com.tencent.mm.plugin.wallet_payu.balance.ui.WalletPayUBalanceManagerUI;
import com.tencent.mm.plugin.wallet_payu.balance.ui.WalletPayUBalanceResultUI;
import com.tencent.mm.plugin.wallet_payu.create.ui.WalletPayUVerifyCodeUI;
import com.tencent.mm.plugin.wallet_payu.pay.ui.WalletPayUChangeBankcardUI;
import com.tencent.mm.plugin.wallet_payu.pay.ui.WalletPayUOrderInfoUI;
import com.tencent.mm.plugin.wallet_payu.pay.ui.WalletPayUPayUI;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

public class e extends a {
    public final c a(Activity activity, Bundle bundle) {
        bundle.putInt("key_pay_scene", ((PayInfo) bundle.getParcelable("key_pay_info")).bVY);
        switch (bundle.getInt("key_err_code", 0)) {
            case -1004:
            case -1003:
                bundle.putInt("key_pay_flag", 3);
                bundle.putInt("key_err_code", 0);
                c(activity, WalletPayUChangeBankcardUI.class, bundle);
                break;
            default:
                x.d("MicroMsg.PayUPayProcess", "start pay_flag : " + bundle.getInt("key_pay_flag", 0));
                switch (bundle.getInt("key_pay_flag", 0)) {
                    case 3:
                        i(activity, bundle);
                        break;
                }
                break;
        }
        return this;
    }

    public final void a(Activity activity, int i, Bundle bundle) {
        int i2 = 1;
        switch (bundle.getInt("key_err_code", 0)) {
            case -1004:
                bundle.putInt("key_pay_flag", 3);
                bundle.putInt("key_err_code", 0);
                c(activity, WalletPayUChangeBankcardUI.class, bundle);
                break;
            case -1003:
                com.tencent.mm.wallet_core.a.a(activity, com.tencent.mm.plugin.wallet_payu.bind.model.c.class, bundle);
                break;
            case 402:
            case 403:
            case 408:
                b(activity, bundle);
                break;
            default:
                i2 = 0;
                break;
        }
        if (i2 != 0) {
            x.i("MicroMsg.PayUPayProcess", "deal with the err!");
            return;
        }
        i2 = bundle.containsKey("key_pay_flag") ? bundle.getInt("key_pay_flag", 0) : this.jfZ.getInt("key_pay_flag", 0);
        x.d("MicroMsg.PayUPayProcess", "forward pay_flag : " + i2);
        switch (i2) {
            case 3:
                if (activity instanceof WalletPayUVerifyCodeUI) {
                    f(activity, bundle);
                    return;
                } else if (activity instanceof WalletPayUChangeBankcardUI) {
                    i(activity, bundle);
                    return;
                } else if (activity instanceof WalletPayUBalanceResultUI) {
                    Intent intent = new Intent(activity, WalletPayUBalanceManagerUI.class);
                    intent.putExtras(new Bundle());
                    intent.getExtras().putAll(bundle);
                    a(activity, WalletPayUBalanceManagerUI.class, intent);
                    return;
                } else {
                    super.a(activity, 0, bundle);
                    return;
                }
            default:
                return;
        }
    }

    public final void c(Activity activity, int i) {
        x.d("MicroMsg.PayUPayProcess", "bakck pay_flag : " + this.jfZ.getInt("key_pay_flag", 0));
        if (activity instanceof WalletPwdConfirmUI) {
            a(activity, WalletSetPasswordUI.class, i);
        } else {
            z(activity);
        }
    }

    public final void b(Activity activity, Bundle bundle) {
        int i = -1;
        x.d("MicroMsg.PayUPayProcess", "end pay_flag : " + this.jfZ.getInt("key_pay_flag", 0));
        int i2 = this.jfZ.getBoolean("intent_pay_end", false) ? -1 : 0;
        Intent intent = new Intent();
        if (bundle != null) {
            Bundle bundle2 = new Bundle();
            bundle2.putInt("intent_pay_end_errcode", this.jfZ.getInt("intent_pay_end_errcode"));
            bundle2.putString("intent_pay_app_url", this.jfZ.getString("intent_pay_app_url"));
            bundle2.putBoolean("intent_pay_end", this.jfZ.getBoolean("intent_pay_end"));
            bundle2.putString("intent_wap_pay_jump_url", this.jfZ.getString("intent_wap_pay_jump_url"));
            intent.putExtras(bundle2);
        }
        te teVar = new te();
        teVar.ceH.intent = intent;
        te$a te_a = teVar.ceH;
        if (!this.jfZ.getBoolean("intent_pay_end", false)) {
            i = 0;
        }
        te_a.result = i;
        com.tencent.mm.sdk.b.a.sFg.m(teVar);
        a(activity, "wallet_payu", ".pay.ui.WalletPayUPayUI", i2, intent, false);
    }

    private void i(Activity activity, Bundle bundle) {
        if (bundle.getBoolean("key_should_redirect", false)) {
            bundle.getString("key_gateway_code");
            String string = bundle.getString("key_gateway_reference");
            boolean z = bundle.getBoolean("key_should_force_adjust");
            String string2 = bundle.getString("key_force_adjust_code");
            Intent intent = new Intent();
            intent.putExtra("rawUrl", string);
            intent.putExtra("showShare", false);
            intent.putExtra("shouldForceViewPort", z);
            intent.putExtra("pay_channel", 2);
            intent.putExtra("view_port_code", string2);
            d.b(activity, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent, 23351);
            return;
        }
        f(activity, bundle);
    }

    private void f(Activity activity, Bundle bundle) {
        int i = bundle.getInt("key_pay_scene", 6);
        if (i == 11 || i == 21) {
            c(activity, WalletPayUBalanceResultUI.class, bundle);
        } else if (i == 31 || i == 32 || i == 33) {
            a(activity, "remittance", ".ui.RemittanceResultUI", bundle);
        } else {
            c(activity, WalletPayUOrderInfoUI.class, bundle);
        }
    }

    public final boolean c(Activity activity, Bundle bundle) {
        x.d("MicroMsg.PayUPayProcess", "needupdatebankcardlist pay_flag : " + this.jfZ.getInt("key_pay_flag", 0));
        switch (this.jfZ.getInt("key_pay_flag", 0)) {
        }
        return false;
    }

    public final g a(MMActivity mMActivity, i iVar) {
        if (mMActivity instanceof WalletPayUPayUI) {
            return new 1(this, mMActivity, iVar);
        }
        return mMActivity instanceof WalletPayUBalanceResultUI ? new 2(this, mMActivity, iVar) : super.a(mMActivity, iVar);
    }

    public final boolean a(WalletBaseUI walletBaseUI, int i, String str) {
        return false;
    }

    public final int a(MMActivity mMActivity, int i) {
        return com.tencent.mm.plugin.wxpay.a.i.wallet_pay_finish_confirm_payu;
    }

    public final String aNK() {
        return "PayUPayProcess";
    }
}

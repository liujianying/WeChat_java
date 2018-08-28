package com.tencent.mm.plugin.wallet_payu.bind.model;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.wallet_payu.bind.model.NetScenePayUElementQuery.PayUBankcardElement;
import com.tencent.mm.plugin.wallet_payu.bind.ui.WalletPayUBankcardManageUI;
import com.tencent.mm.plugin.wallet_payu.bind.ui.WalletPayUCardElementUI;
import com.tencent.mm.plugin.wallet_payu.pwd.ui.WalletPayUCheckPwdUI;
import com.tencent.mm.plugin.wxpay.a$i;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;

public class c extends com.tencent.mm.wallet_core.c {
    public final com.tencent.mm.wallet_core.c a(Activity activity, Bundle bundle) {
        x.d("MicroMsg.PayUBindProcess", "hy: start process: PayUBindProcess");
        c(activity, WalletPayUCheckPwdUI.class, bundle);
        return this;
    }

    public final void a(Activity activity, int i, Bundle bundle) {
        if (activity instanceof WalletPayUCheckPwdUI) {
            c(activity, WalletPayUCardElementUI.class, bundle);
        }
    }

    public final void c(Activity activity, int i) {
        z(activity);
    }

    public final void b(Activity activity, Bundle bundle) {
        if (this.jfZ.getInt("key_errcode_payu", -1) == 0) {
            s.makeText(activity, a$i.wallet_order_info_result_success, 0).show();
            a(activity, WalletPayUBankcardManageUI.class, -1, false);
            return;
        }
        s.makeText(activity, a$i.wallet_err_wording_comm_failed, 0).show();
        a(activity, WalletPayUBankcardManageUI.class, 0, false);
    }

    public final boolean c(Activity activity, Bundle bundle) {
        return false;
    }

    public final g a(MMActivity mMActivity, i iVar) {
        if (mMActivity instanceof WalletPayUCheckPwdUI) {
            return new 1(this, mMActivity, iVar, this.jfZ);
        }
        return mMActivity instanceof WalletPayUCardElementUI ? new g(mMActivity, iVar) {
            public final boolean d(int i, int i2, String str, l lVar) {
                if ((lVar instanceof a) && i == 0 && i2 == 0) {
                    c.this.jfZ.putInt("key_errcode_payu", 0);
                    c.this.b(this.fEY, c.this.jfZ);
                }
                if (lVar instanceof NetScenePayUElementQuery) {
                    PayUBankcardElement payUBankcardElement;
                    if (i == 0 && i2 == 0) {
                        payUBankcardElement = ((NetScenePayUElementQuery) lVar).pEb;
                        if (bi.oW(payUBankcardElement.pEc)) {
                            payUBankcardElement.pEd = ad.getContext().getString(a$i.wallet_payu_bind_err_card_number);
                        }
                        c.this.jfZ.putParcelable("key_card_element", ((NetScenePayUElementQuery) lVar).pEb);
                    } else {
                        payUBankcardElement = new PayUBankcardElement();
                        if (bi.oW(str)) {
                            str = "err card element";
                        }
                        payUBankcardElement.pEd = str;
                        c.this.jfZ.putParcelable("key_card_element", payUBankcardElement);
                    }
                }
                return false;
            }

            public final boolean m(Object... objArr) {
                PayUBankcardElement payUBankcardElement = (PayUBankcardElement) c.this.jfZ.getParcelable("key_card_element");
                this.uXK.a(new a(payUBankcardElement.lNT, payUBankcardElement.pEd, c.this.jfZ.getString("key_bank_username"), c.this.jfZ.getString("key_card_id"), c.this.jfZ.getString("key_expire_data"), payUBankcardElement.cardType, c.this.jfZ.getString("key_cvv"), c.this.jfZ.getString("key_pwd1")), true);
                return false;
            }
        } : super.a(mMActivity, iVar);
    }

    public final String aNK() {
        return "PayUBindProcess";
    }
}

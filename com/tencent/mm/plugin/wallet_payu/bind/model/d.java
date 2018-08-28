package com.tencent.mm.plugin.wallet_payu.bind.model;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.wallet.bind.a;
import com.tencent.mm.plugin.wallet.bind.ui.WalletBankcardDetailUI;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_payu.bind.ui.WalletPayUBankcardDetailUI;
import com.tencent.mm.plugin.wallet_payu.pwd.a.c;
import com.tencent.mm.plugin.wallet_payu.pwd.ui.WalletPayUCheckPwdUI;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.wallet_core.d.g;

public class d extends a {
    protected final void d(Activity activity, Bundle bundle) {
        c(activity, WalletPayUBankcardDetailUI.class, bundle);
    }

    public final void b(Activity activity, Bundle bundle) {
        if (this.jfZ.getInt("key_errcode_payu", -1) == 0) {
            s.makeText(activity, i.wallet_order_info_result_success, 0).show();
        } else {
            s.makeText(activity, i.wallet_err_wording_comm_failed, 0).show();
        }
        e(activity, "mall", ".ui.MallIndexUI");
    }

    public final void a(Activity activity, int i, Bundle bundle) {
        if (activity instanceof WalletBankcardDetailUI) {
            c(activity, WalletPayUCheckPwdUI.class, bundle);
        } else if (activity instanceof WalletPayUCheckPwdUI) {
            b(activity, bundle);
        }
    }

    public final g a(MMActivity mMActivity, com.tencent.mm.wallet_core.d.i iVar) {
        return mMActivity instanceof WalletPayUCheckPwdUI ? new g(mMActivity, iVar) {
            public final CharSequence ui(int i) {
                if (i == 0) {
                    return this.fEY.getString(i.wallet_check_pwd_unbind_bankcard_tip_payu);
                }
                return super.ui(i);
            }

            public final boolean d(int i, int i2, String str, l lVar) {
                if (lVar instanceof c) {
                    if (i2 == 0 && i == 0) {
                        c cVar = (c) lVar;
                        d.this.jfZ.putString("payu_reference", cVar.token);
                        if (bi.oW(cVar.token)) {
                            x.w("MicroMsg.PayUUnbindProcess", "hy: check pwd failed");
                        } else {
                            x.d("MicroMsg.PayUUnbindProcess", "hy: check pwd pass");
                            Bankcard bankcard = (Bankcard) d.this.jfZ.getParcelable("key_bankcard");
                            if (bankcard != null) {
                                this.uXK.a(new b(bankcard.field_bindSerial, d.this.jfZ.getString("payu_reference")), true);
                            }
                        }
                    }
                } else if ((lVar instanceof b) && i == 0 && i2 == 0) {
                    d.this.jfZ.putInt("key_errcode_payu", 0);
                    d.this.b(this.fEY, d.this.jfZ);
                }
                return false;
            }

            public final boolean m(Object... objArr) {
                d.this.jfZ.putString("key_pwd1", (String) objArr[0]);
                this.uXK.a(new c(d.this.jfZ.getString("key_pwd1")), true);
                return true;
            }
        } : super.a(mMActivity, iVar);
    }

    public final boolean c(Activity activity, Bundle bundle) {
        return false;
    }
}

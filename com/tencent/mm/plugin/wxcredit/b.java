package com.tencent.mm.plugin.wxcredit;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.ui.WalletCheckPwdUI;
import com.tencent.mm.plugin.wxcredit.a.e;
import com.tencent.mm.plugin.wxcredit.ui.WalletWXCreditChangeAmountResultUI;
import com.tencent.mm.plugin.wxcredit.ui.WalletWXCreditChangeAmountUI;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;

public class b extends c {
    public final c a(Activity activity, Bundle bundle) {
        x.d("MicroMsg.WXCreditChangeAmountProcess", "start Process : WXCreditChangeAmountProcess");
        c(activity, WalletCheckPwdUI.class, bundle);
        return this;
    }

    public final void a(Activity activity, int i, Bundle bundle) {
        if (activity instanceof WalletCheckPwdUI) {
            c(activity, WalletWXCreditChangeAmountUI.class, bundle);
        } else if (activity instanceof WalletWXCreditChangeAmountUI) {
            c(activity, WalletWXCreditChangeAmountResultUI.class, bundle);
        } else if (activity instanceof WalletWXCreditChangeAmountResultUI) {
            b(activity, bundle);
        }
    }

    public final void c(Activity activity, int i) {
        z(activity);
    }

    public final void b(Activity activity, Bundle bundle) {
        e(activity, "wallet", ".bind.ui.WalletBankcardManageUI");
    }

    public final boolean c(Activity activity, Bundle bundle) {
        return false;
    }

    public final g a(MMActivity mMActivity, i iVar) {
        if (mMActivity instanceof WalletWXCreditChangeAmountUI) {
            return new g(mMActivity, iVar) {
                public final boolean d(int i, int i2, String str, l lVar) {
                    if (i != 0 || i2 != 0) {
                        return false;
                    }
                    if (lVar instanceof e) {
                        b.this.jfZ.putString("kreq_token", ((e) lVar).token);
                        return false;
                    } else if (!(lVar instanceof com.tencent.mm.plugin.wxcredit.a.c)) {
                        return false;
                    } else {
                        b.this.jfZ.putDouble("key_credit_amount", ((com.tencent.mm.plugin.wxcredit.a.c) lVar).qwm);
                        b.this.a(this.fEY, 0, b.this.jfZ);
                        return true;
                    }
                }

                public final boolean m(Object... objArr) {
                    this.uXK.a(new e(((Bankcard) b.this.jfZ.getParcelable("key_bankcard")).field_bindSerial), true, 1);
                    return true;
                }
            };
        }
        return mMActivity instanceof WalletCheckPwdUI ? new 2(this, mMActivity, iVar) : null;
    }

    public final String aNK() {
        return "WXCreditChangeAmountProcess";
    }
}

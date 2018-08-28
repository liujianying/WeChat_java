package com.tencent.mm.plugin.wxcredit;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.wallet_core.b.a.b;
import com.tencent.mm.plugin.wallet_core.c.q;
import com.tencent.mm.plugin.wallet_core.c.y;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.plugin.wallet_core.model.p;
import com.tencent.mm.plugin.wallet_core.ui.WalletCheckPwdUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletPwdConfirmUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletSetPasswordUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletVerifyCodeUI;
import com.tencent.mm.plugin.wxcredit.a.h;
import com.tencent.mm.plugin.wxcredit.ui.WalletBindDepositUI;
import com.tencent.mm.plugin.wxcredit.ui.WalletCheckIdentityUI;
import com.tencent.mm.plugin.wxcredit.ui.WalletWXCreditOpenResultUI;
import com.tencent.mm.plugin.wxcredit.ui.WalletWXCreditOpenUI;
import com.tencent.mm.plugin.wxpay.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;

public class e extends c {
    public final c a(Activity activity, Bundle bundle) {
        if (!o.bOW().bPr()) {
            if (o.bOW().bPs()) {
                c(activity, WalletCheckPwdUI.class, bundle);
            } else {
                c(activity, WalletWXCreditOpenUI.class, bundle);
            }
        }
        return this;
    }

    public final void a(Activity activity, int i, Bundle bundle) {
        if (activity instanceof WalletWXCreditOpenUI) {
            c(activity, WalletCheckIdentityUI.class, bundle);
        } else if (activity instanceof WalletCheckPwdUI) {
            z(activity);
            c(activity, WalletWXCreditOpenUI.class, bundle);
        } else if (activity instanceof WalletWXCreditOpenUI) {
            c(activity, WalletCheckIdentityUI.class, bundle);
        } else if (activity instanceof WalletCheckIdentityUI) {
            if (bundle.getBoolean("key_need_bind_deposit", true)) {
                c(activity, WalletBindDepositUI.class, bundle);
            } else {
                c(activity, WalletVerifyCodeUI.class, bundle);
            }
        } else if (activity instanceof WalletBindDepositUI) {
            c(activity, WalletVerifyCodeUI.class, bundle);
        } else if (activity instanceof WalletVerifyCodeUI) {
            if (o.bOW().bPs()) {
                c(activity, WalletWXCreditOpenResultUI.class, bundle);
            } else {
                c(activity, WalletSetPasswordUI.class, bundle);
            }
        } else if (activity instanceof WalletSetPasswordUI) {
            c(activity, WalletPwdConfirmUI.class, bundle);
        } else if (activity instanceof WalletPwdConfirmUI) {
            c(activity, WalletWXCreditOpenResultUI.class, bundle);
        } else if (activity instanceof WalletWXCreditOpenResultUI) {
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
        if (mMActivity instanceof WalletCheckPwdUI) {
            return new 1(this, mMActivity, iVar);
        }
        if (mMActivity instanceof WalletCheckIdentityUI) {
            return new 2(this, mMActivity, iVar);
        }
        if (mMActivity instanceof WalletVerifyCodeUI) {
            return new g(mMActivity, iVar) {
                public final /* synthetic */ CharSequence ui(int i) {
                    if (e.this.jfZ.getBoolean("key_is_bank_user", false)) {
                        Bankcard bankcard = (Bankcard) e.this.jfZ.getParcelable("key_bankcard");
                        return this.fEY.getString(a.i.wallet_verify_code_wxcredit_bank_user, new Object[]{bankcard.field_bankName, bankcard.field_bankName, e.this.jfZ.getString("key_mobile")});
                    }
                    return this.fEY.getString(a.i.wallet_verify_code_wxcredit_open, new Object[]{e.this.jfZ.getString("key_mobile")});
                }

                public final boolean d(int i, int i2, String str, l lVar) {
                    if (i != 0 || i2 != 0) {
                        return false;
                    }
                    if (lVar instanceof com.tencent.mm.plugin.wxcredit.a.g) {
                        String str2 = ((com.tencent.mm.plugin.wxcredit.a.g) lVar).bVX;
                        if (!bi.oW(str2)) {
                            e.this.jfZ.putString("key_bank_username", str2);
                        }
                        e.this.a(this.fEY, 0, e.this.jfZ);
                        return true;
                    } else if (lVar instanceof h) {
                        e.this.a(this.fEY, 0, e.this.jfZ);
                        return true;
                    } else if (lVar instanceof q) {
                        if (o.bOW().bPs()) {
                            this.uXK.a(new y(), true, 1);
                            return true;
                        }
                        e.this.a(this.fEY, 0, e.this.jfZ);
                        return true;
                    } else if (!(lVar instanceof y)) {
                        return false;
                    } else {
                        this.uXK.a(new com.tencent.mm.plugin.wxcredit.a.g(e.this.jfZ.getString("key_verify_code"), e.this.jfZ.getString("KEY_SESSION_KEY"), e.this.jfZ.getString("key_pwd1"), o.bOW().bPH(), e.this.jfZ.getString("key_bank_type")), true, 1);
                        return true;
                    }
                }

                public final boolean m(Object... objArr) {
                    String str = (String) objArr[0];
                    e.this.jfZ.putString("key_verify_code", str);
                    p pVar;
                    if (o.bOW().bPs()) {
                        if (!e.this.jfZ.getBoolean("key_need_bind_deposit", true) || e.this.jfZ.getBoolean("key_is_bank_user")) {
                            this.uXK.a(new com.tencent.mm.plugin.wxcredit.a.g(str, e.this.jfZ.getString("KEY_SESSION_KEY"), e.this.jfZ.getString("key_pwd1"), e.this.jfZ.getString("key_bind_serial"), e.this.jfZ.getString("key_bank_type")), true, 1);
                        } else {
                            pVar = (p) objArr[1];
                            pVar.flag = "2";
                            this.uXK.a(new q(pVar), true, 1);
                        }
                    } else if (e.this.jfZ.getBoolean("key_is_bank_user", false)) {
                        e.this.jfZ.putString("key_verify_code", str);
                        this.uXK.a(new h(str, e.this.jfZ.getString("KEY_SESSION_KEY"), e.this.jfZ.getString("key_pwd1"), e.this.jfZ.getString("key_bind_serial"), e.this.jfZ.getString("key_bank_type")), true, 1);
                    } else {
                        pVar = (p) objArr[1];
                        pVar.flag = "1";
                        this.uXK.a(new q(pVar), true, 1);
                    }
                    return true;
                }
            };
        }
        if (mMActivity instanceof WalletBindDepositUI) {
            return new 4(this, mMActivity, iVar);
        }
        if (mMActivity instanceof WalletPwdConfirmUI) {
            return new g(mMActivity, iVar) {
                public final boolean d(int i, int i2, String str, l lVar) {
                    if (i != 0 || i2 != 0) {
                        return false;
                    }
                    if (lVar instanceof b) {
                        this.uXK.a(new y(), true, 1);
                        return true;
                    } else if (lVar instanceof y) {
                        this.uXK.a(new com.tencent.mm.plugin.wxcredit.a.g(e.this.jfZ.getString("key_verify_code"), e.this.jfZ.getString("KEY_SESSION_KEY"), e.this.jfZ.getString("key_pwd1"), o.bOW().bPH(), e.this.jfZ.getString("key_bank_type")), true, 1);
                        return true;
                    } else if (!(lVar instanceof com.tencent.mm.plugin.wxcredit.a.g)) {
                        return false;
                    } else {
                        String str2 = ((com.tencent.mm.plugin.wxcredit.a.g) lVar).bVX;
                        if (!bi.oW(str2)) {
                            e.this.jfZ.putString("key_bank_username", str2);
                        }
                        e.this.a(this.fEY, 0, e.this.jfZ);
                        return true;
                    }
                }

                public final boolean m(Object... objArr) {
                    if (e.this.jfZ.getBoolean("key_is_bank_user", false)) {
                        this.uXK.a(new com.tencent.mm.plugin.wxcredit.a.g(e.this.jfZ.getString("key_verify_code"), e.this.jfZ.getString("KEY_SESSION_KEY"), e.this.jfZ.getString("key_pwd1"), o.bOW().bPH(), e.this.jfZ.getString("key_bank_type")), true, 1);
                    } else {
                        this.uXK.a(new b((p) objArr[0]), true, 1);
                    }
                    return true;
                }
            };
        }
        return mMActivity instanceof WalletWXCreditOpenResultUI ? new 6(this, mMActivity, iVar) : null;
    }

    public final String aNK() {
        return "WXCreditOpenProcess";
    }
}

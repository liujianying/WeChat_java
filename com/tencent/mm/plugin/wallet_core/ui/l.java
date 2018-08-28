package com.tencent.mm.plugin.wallet_core.ui;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.mm.plugin.wallet_core.c.ac;
import com.tencent.mm.plugin.wallet_core.c.s;
import com.tencent.mm.plugin.wallet_core.model.p;
import com.tencent.mm.plugin.wxpay.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;

public class l extends c {
    private String eTo;
    private String pjx;
    private int scene;
    private String token;

    public final c a(Activity activity, Bundle bundle) {
        x.i("MicroMsg.WalletJSApiVerifyCodeProcess", "start WalletJSApiVerifyCodeProcess");
        this.pjx = bundle.getString("key_relation_key");
        this.eTo = bundle.getString("key_pwd1");
        this.token = bundle.getString("key_jsapi_token");
        this.scene = bundle.getInt("key_verify_scene");
        c(activity, WalletVerifyCodeUI.class, bundle);
        return this;
    }

    public final void a(Activity activity, int i, Bundle bundle) {
    }

    public final void c(Activity activity, int i) {
    }

    public final void b(Activity activity, Bundle bundle) {
        x.i("MicroMsg.WalletJSApiVerifyCodeProcess", "end WalletJSApiVerifyCodeProcess");
        if (this.scene == 8) {
            a(activity, "wallet", ".pay.ui.WalletLoanRepaymentUI", -1, null, false);
            return;
        }
        a(activity, WalletCheckPwdUI.class, -1, null, false);
    }

    public final boolean c(Activity activity, Bundle bundle) {
        return false;
    }

    public final String aNK() {
        return null;
    }

    public final g a(MMActivity mMActivity, i iVar) {
        final i iVar2 = iVar;
        final MMActivity mMActivity2 = mMActivity;
        return new g(mMActivity, iVar) {
            public final boolean m(Object... objArr) {
                if (objArr.length == 2) {
                    p pVar = (p) objArr[1];
                    pVar.token = l.this.token;
                    x.i("MicroMsg.WalletJSApiVerifyCodeProcess", "do NetSceneTenpayVerifySmsByPasswd");
                    iVar2.a(new ac(pVar, l.this.pjx), true, 1);
                    return true;
                }
                x.e("MicroMsg.WalletJSApiVerifyCodeProcess", "arguments is error");
                return false;
            }

            public final boolean s(Object... objArr) {
                x.i("MicroMsg.WalletJSApiVerifyCodeProcess", "resend sms");
                iVar2.a(new s(l.this.eTo, l.this.token, 0), true, 1);
                return true;
            }

            public final boolean d(int i, int i2, String str, com.tencent.mm.ab.l lVar) {
                if (i != 0 || i2 != 0) {
                    if (lVar instanceof ac) {
                        x.e("MicroMsg.WalletJSApiVerifyCodeProcess", "send sms fail,errType=" + i + ",errCode=" + i2 + ",errMsg=" + str);
                    }
                    return false;
                } else if (lVar instanceof ac) {
                    x.i("MicroMsg.WalletJSApiVerifyCodeProcess", "send sms succ");
                    ac acVar = (ac) lVar;
                    Bundle bundle = l.this.jfZ;
                    bundle.putString("key_jsapi_token", acVar.pjE);
                    l.this.b(mMActivity2, bundle);
                    return true;
                } else if (lVar instanceof s) {
                    return true;
                } else {
                    return false;
                }
            }

            public final CharSequence ui(int i) {
                return String.format(mMActivity2.getResources().getString(a.i.wallet_verify_code_hint), new Object[]{l.this.jfZ.getString("key_mobile")});
            }
        };
    }
}

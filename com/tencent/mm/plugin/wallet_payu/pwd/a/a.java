package com.tencent.mm.plugin.wallet_payu.pwd.a;

import android.os.Bundle;
import com.tencent.mm.ab.l;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;

public class a extends g {
    private Bundle jfZ;

    public a(MMActivity mMActivity, i iVar, Bundle bundle) {
        super(mMActivity, iVar);
        this.jfZ = bundle;
    }

    public final boolean d(int i, int i2, String str, l lVar) {
        if (lVar instanceof c) {
            c cVar = (c) lVar;
            if (bi.oW(cVar.token)) {
                x.w("MicroMsg.CommonCheckPwdController", "hy: check pwd failed");
            } else {
                x.d("MicroMsg.CommonCheckPwdController", "hy: check pwd pass");
                this.jfZ.putString("payu_reference", cVar.token);
                com.tencent.mm.wallet_core.a.j(this.fEY, this.jfZ);
            }
        }
        return false;
    }

    public final boolean m(Object... objArr) {
        this.jfZ.putString("key_pwd1", (String) objArr[0]);
        this.uXK.a(new c(this.jfZ.getString("key_pwd1")), true);
        return true;
    }
}

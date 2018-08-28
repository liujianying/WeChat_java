package com.tencent.mm.plugin.wallet_payu.create.a;

import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.wallet_payu.a.b;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.a;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;

class c$1 extends g {
    final /* synthetic */ c pEC;

    c$1(c cVar, MMActivity mMActivity, i iVar) {
        this.pEC = cVar;
        super(mMActivity, iVar);
    }

    public final boolean d(int i, int i2, String str, l lVar) {
        if (lVar instanceof b) {
            x.d("MicroMsg.PayUOpenProcess", "hy: scene gen otp, errCode %d, errType %d, errMsg %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
            if (i == 0 && i2 == 0) {
                b bVar = (b) lVar;
                this.pEC.jfZ.putString("payu_reference", bVar.bST);
                x.d("MicroMsg.PayUOpenProcess", "hy: session: %s", new Object[]{bVar.bST});
                this.pEC.jfZ.putBoolean("key_is_has_mobile", bVar.pEV);
                a.j(this.fEY, this.pEC.jfZ);
                return true;
            }
        }
        return false;
    }

    public final boolean m(Object... objArr) {
        this.uXK.a(new b(this.pEC.jfZ.getString("dial_code"), this.pEC.jfZ.getString("key_mobile")), true);
        return false;
    }
}

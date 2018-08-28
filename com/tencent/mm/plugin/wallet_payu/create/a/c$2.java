package com.tencent.mm.plugin.wallet_payu.create.a;

import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.wallet_payu.a.a;
import com.tencent.mm.plugin.wallet_payu.a.b;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;
import com.tencent.mm.wallet_core.ui.e;

class c$2 extends g {
    final /* synthetic */ c pEC;

    c$2(c cVar, MMActivity mMActivity, i iVar) {
        this.pEC = cVar;
        super(mMActivity, iVar);
    }

    public final boolean s(Object... objArr) {
        this.uXK.a(new b(this.pEC.jfZ.getString("dial_code"), this.pEC.jfZ.getString("key_mobile")), true, 1);
        return true;
    }

    public final boolean d(int i, int i2, String str, l lVar) {
        if (lVar instanceof a) {
            a aVar = (a) lVar;
            if (i == 0 && i2 == 0 && aVar.mSN) {
                c.a(this.pEC).putString("payu_reference", aVar.pEU);
                com.tencent.mm.wallet_core.a.j(this.fEY, this.pEC.jfZ);
                return true;
            }
        } else if ((lVar instanceof b) && i == 0 && i2 == 0) {
            this.pEC.jfZ.putString("payu_reference", ((b) lVar).bST);
            return true;
        }
        return false;
    }

    public final boolean m(Object... objArr) {
        this.uXK.a(new a((String) objArr[0], this.pEC.jfZ.getString("payu_reference")), true);
        return true;
    }

    public final CharSequence ui(int i) {
        if (i != 0) {
            return super.ui(i);
        }
        return this.fEY.getString(com.tencent.mm.plugin.wxpay.a.i.wallet_verify_code_bind_hint_payu, new Object[]{e.aca("+" + c.b(this.pEC).getString("dial_code") + c.c(this.pEC).getString("key_mobile"))});
    }
}

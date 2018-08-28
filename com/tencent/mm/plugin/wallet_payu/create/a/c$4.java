package com.tencent.mm.plugin.wallet_payu.create.a;

import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.wallet_core.model.p;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.wallet_core.a;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;

class c$4 extends g {
    final /* synthetic */ c pEC;

    c$4(c cVar, MMActivity mMActivity, i iVar) {
        this.pEC = cVar;
        super(mMActivity, iVar);
    }

    public final boolean d(int i, int i2, String str, l lVar) {
        if ((lVar instanceof a) && i == 0 && i2 == 0) {
            x.d("MicroMsg.PayUOpenProcess", "hy: create user success");
            a.c(this.fEY, this.pEC.jfZ, 0);
            c.d(this.pEC).putInt("key_open_error_code", 0);
            s.makeText(this.fEY, this.fEY.getString(com.tencent.mm.plugin.wxpay.a.i.wallet_payu_start_success), 0).show();
            return true;
        } else if (!(lVar instanceof b) || i != 0 || i2 != 0) {
            return false;
        } else {
            x.d("MicroMsg.PayUOpenProcess", "hy: link user success");
            a.c(this.fEY, this.pEC.jfZ, 0);
            c.e(this.pEC).putInt("key_open_error_code", 0);
            s.makeText(this.fEY, this.fEY.getString(com.tencent.mm.plugin.wxpay.a.i.wallet_payu_start_success), 0).show();
            return true;
        }
    }

    public final boolean m(Object... objArr) {
        p pVar = (p) objArr[0];
        String string = this.pEC.jfZ.getString("dial_code");
        String string2 = this.pEC.jfZ.getString("key_mobile");
        String str = pVar.eJn;
        String string3 = this.pEC.jfZ.getString("key_question_id");
        String string4 = this.pEC.jfZ.getString("key_question_answer");
        String string5 = this.pEC.jfZ.getString("payu_reference");
        if (this.pEC.jfZ.getBoolean("key_is_has_mobile")) {
            this.uXK.a(new b(string, string2, str, string5), true);
        } else {
            this.uXK.a(new a(string, string2, str, string3, string4, string5), true);
        }
        return true;
    }
}

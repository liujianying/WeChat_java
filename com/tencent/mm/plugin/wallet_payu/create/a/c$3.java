package com.tencent.mm.plugin.wallet_payu.create.a;

import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.wallet_payu.security_question.model.d;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;

class c$3 extends g {
    final /* synthetic */ c pEC;

    c$3(c cVar, MMActivity mMActivity, i iVar) {
        this.pEC = cVar;
        super(mMActivity, iVar);
    }

    public final boolean r(Object... objArr) {
        this.uXK.a(new d(), true);
        return false;
    }

    public final boolean d(int i, int i2, String str, l lVar) {
        if (!(lVar instanceof d) || i != 0 || i2 != 0) {
            return false;
        }
        this.pEC.jfZ.putParcelableArrayList("key_security_question_list", ((d) lVar).pGk);
        return true;
    }

    public final boolean m(Object... objArr) {
        return false;
    }
}

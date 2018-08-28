package com.tencent.mm.plugin.wallet_payu.security_question.model;

import android.os.Bundle;
import com.tencent.mm.ab.l;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;

public final class a extends g {
    private Bundle jfZ;

    public a(MMActivity mMActivity, i iVar, Bundle bundle) {
        super(mMActivity, iVar);
        this.jfZ = bundle;
    }

    public final boolean r(Object... objArr) {
        this.uXK.a(new c(this.jfZ.getString("payu_reference")), true);
        return true;
    }

    public final boolean d(int i, int i2, String str, l lVar) {
        if ((lVar instanceof c) && i == 0 && i2 == 0) {
            c cVar = (c) lVar;
            this.jfZ.putParcelable("key_security_question", new PayUSecurityQuestion(cVar.id, cVar.pGj));
            return false;
        } else if (!(lVar instanceof b)) {
            return false;
        } else {
            b bVar = (b) lVar;
            if (i != 0 || i2 != 0 || !bVar.iMA) {
                return false;
            }
            this.jfZ.putString("payu_reference", bVar.pGi);
            com.tencent.mm.wallet_core.a.j(this.fEY, this.jfZ);
            return true;
        }
    }

    public final boolean m(Object... objArr) {
        PayUSecurityQuestion payUSecurityQuestion = (PayUSecurityQuestion) this.jfZ.getParcelable("key_security_question");
        String string = this.jfZ.getString("key_question_answer");
        this.uXK.a(new b(this.jfZ.getString("payu_reference"), payUSecurityQuestion.id, string), true);
        return false;
    }
}

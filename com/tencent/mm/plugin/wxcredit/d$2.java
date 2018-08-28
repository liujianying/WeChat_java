package com.tencent.mm.plugin.wxcredit;

import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.wallet_core.c.y;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wxcredit.a.d;
import com.tencent.mm.plugin.wxcredit.a.f;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;

class d$2 extends g {
    final /* synthetic */ d qwg;

    d$2(d dVar, MMActivity mMActivity, i iVar) {
        this.qwg = dVar;
        super(mMActivity, iVar);
    }

    public final boolean d(int i, int i2, String str, l lVar) {
        if (i != 0 || i2 != 0) {
            return false;
        }
        if (lVar instanceof f) {
            this.uXK.a(new y(), true);
            return true;
        } else if (!(lVar instanceof y)) {
            return true;
        } else {
            this.qwg.b(this.fEY, d.a(this.qwg));
            return true;
        }
    }

    public final boolean m(Object... objArr) {
        Bankcard bankcard = (Bankcard) d.b(this.qwg).getParcelable("key_bankcard");
        this.uXK.a(new f(bankcard.field_bankcardType, bankcard.field_bindSerial, (String) objArr[0]), true, 1);
        return true;
    }

    public final boolean r(Object... objArr) {
        Bankcard bankcard = (Bankcard) objArr[0];
        this.uXK.a(new d(bankcard.field_bindSerial, bankcard.field_bankcardType), true, 1);
        return true;
    }
}

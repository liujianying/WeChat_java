package com.tencent.mm.plugin.wallet_core.b;

import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.wallet_core.b.a.b;
import com.tencent.mm.plugin.wallet_core.id_verify.model.h;
import com.tencent.mm.plugin.wallet_core.model.p;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;

class b$4 extends g {
    final /* synthetic */ b piV;

    b$4(b bVar, MMActivity mMActivity, i iVar) {
        this.piV = bVar;
        super(mMActivity, iVar);
    }

    public final boolean d(int i, int i2, String str, l lVar) {
        if (lVar instanceof b) {
            this.piV.a(this.uXK);
            if (((b) lVar).piW != null) {
                b.h(this.piV).putParcelable("key_bindcard_value_result", ((b) lVar).piW);
            }
        } else if (lVar instanceof h) {
            return true;
        }
        return false;
    }

    public final boolean m(Object... objArr) {
        p pVar = (p) objArr[0];
        b.i(this.piV).getString("verify_card_flag", "0");
        if ("realname_verify_process".equals(this.piV.aNK())) {
            this.uXK.a(new b(pVar, this.piV.jfZ.getInt("entry_scene", -1)), true);
        } else {
            this.uXK.a(new b(pVar), true);
        }
        return false;
    }
}

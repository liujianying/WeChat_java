package com.tencent.mm.plugin.offline;

import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.offline.a.k;
import com.tencent.mm.plugin.offline.c.a;
import com.tencent.mm.plugin.wallet_core.c.q;
import com.tencent.mm.plugin.wallet_core.c.y;
import com.tencent.mm.plugin.wallet_core.model.p;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

class d$1 extends g {
    final /* synthetic */ d lIE;

    d$1(d dVar, MMActivity mMActivity, i iVar) {
        this.lIE = dVar;
        super(mMActivity, iVar);
    }

    public final boolean m(Object... objArr) {
        p pVar = (p) objArr[1];
        pVar.flag = "1";
        this.uXK.a(new q(pVar), true, 1);
        return true;
    }

    public final boolean d(int i, int i2, String str, l lVar) {
        if (i == 0 && i2 == 0) {
            if (lVar instanceof y) {
                if (!(((WalletBaseUI) this.fEY).sy == null || ((WalletBaseUI) this.fEY).sy.getInt("key_bind_scene", -1) != 5 || a.bly())) {
                    d.h(this.fEY);
                    return true;
                }
            } else if (lVar instanceof k) {
                com.tencent.mm.wallet_core.a.j(this.fEY, ((WalletBaseUI) this.fEY).sy);
                a.C(this.fEY);
                return true;
            }
        }
        return false;
    }
}

package com.tencent.mm.plugin.offline;

import android.os.Bundle;
import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.offline.a.k;
import com.tencent.mm.plugin.offline.c.a;
import com.tencent.mm.plugin.wallet_core.b.a.b;
import com.tencent.mm.plugin.wallet_core.c.y;
import com.tencent.mm.plugin.wallet_core.model.p;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

class c$2 extends g {
    final /* synthetic */ c lID;

    c$2(c cVar, MMActivity mMActivity, i iVar) {
        this.lID = cVar;
        super(mMActivity, iVar);
    }

    public final boolean m(Object... objArr) {
        this.uXK.a(new b((p) objArr[0]), true, 1);
        return true;
    }

    public final boolean d(int i, int i2, String str, l lVar) {
        if (i == 0 && i2 == 0) {
            if (lVar instanceof y) {
                if (!(((WalletBaseUI) this.fEY).sy == null || ((WalletBaseUI) this.fEY).sy.getInt("key_bind_scene", -1) != 5 || a.bly())) {
                    c.g(this.fEY);
                    return true;
                }
            } else if (lVar instanceof k) {
                Bundle bundle = ((WalletBaseUI) this.fEY).sy;
                bundle.putBoolean("intent_bind_end", true);
                com.tencent.mm.wallet_core.a.j(this.fEY, bundle);
                a.C(this.fEY);
                return true;
            }
        }
        return false;
    }
}

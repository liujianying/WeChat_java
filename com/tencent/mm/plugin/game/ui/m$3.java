package com.tencent.mm.plugin.game.ui;

import com.tencent.mm.plugin.game.model.d;
import com.tencent.mm.plugin.game.model.m.b;
import com.tencent.mm.plugin.game.model.n;
import com.tencent.mm.sdk.platformtools.x;

class m$3 implements b {
    final /* synthetic */ m jZZ;

    m$3(m mVar) {
        this.jZZ = mVar;
    }

    public final void f(int i, String str, boolean z) {
        if (z && this.jZZ.jZW != null && str != null) {
            try {
                for (n nVar : this.jZZ.jZW.values()) {
                    if (!(nVar == null || nVar.jMa == null)) {
                        if (nVar.jMa.field_appId.equals(str) || nVar.jMa.field_packageName.equals(str)) {
                            nVar.dC(this.jZZ.mContext);
                            nVar.aTT();
                        }
                    }
                }
                int i2 = 0;
                while (true) {
                    int i3 = i2;
                    if (i3 < this.jZZ.jOb.size()) {
                        d dVar = (d) this.jZZ.jOb.get(i3);
                        if (dVar.type != 0 || (!(dVar.field_appId.equals(str) || dVar.field_packageName.equals(str)) || m.a(this.jZZ) == null)) {
                            i2 = i3 + 1;
                        } else {
                            m.a(this.jZZ).qS(i3);
                            return;
                        }
                    }
                    return;
                }
            } catch (Exception e) {
                x.e("MicroMsg.GameListAdapter", e.getMessage());
            }
        }
    }
}

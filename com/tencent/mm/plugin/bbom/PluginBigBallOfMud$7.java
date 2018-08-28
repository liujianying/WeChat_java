package com.tencent.mm.plugin.bbom;

import com.tencent.mm.ac.a.e;
import com.tencent.mm.ac.f;
import com.tencent.mm.j.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bf;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.storage.bd;

class PluginBigBallOfMud$7 implements a {
    final /* synthetic */ PluginBigBallOfMud heA;

    PluginBigBallOfMud$7(PluginBigBallOfMud pluginBigBallOfMud) {
        this.heA = pluginBigBallOfMud;
    }

    public final void c(bd bdVar) {
        if (f.eZ(bdVar.field_talker)) {
            bdVar.dt(e.Ir());
        }
    }

    public final String z(String str, int i) {
        if (f.eZ(str)) {
            return e.lg(((i) g.l(i.class)).bcY().dW((long) i).cqb);
        }
        return bf.Is();
    }

    public final String d(bd bdVar) {
        if (f.eZ(bdVar.field_talker)) {
            return e.lg(bdVar.cqb);
        }
        return null;
    }

    public final boolean eZ(String str) {
        return f.eZ(str);
    }
}

package com.tencent.mm.plugin.sns;

import com.tencent.mm.g.a.ql;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.model.u;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

public final class m extends c<ql> {
    public m() {
        this.sFo = ql.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        if (((ql) bVar) instanceof ql) {
            x.d("MicroMsg.SnsSyncListener", "NetSceneSnsSync");
            g.Ek();
            g.Eh().dpP.a(new u(), 0);
            return true;
        }
        x.f("MicroMsg.SnsSyncListener", "mismatched event");
        return false;
    }
}

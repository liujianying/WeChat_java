package com.tencent.mm.plugin.sns;

import com.tencent.mm.g.a.ht;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.model.v;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

public final class e extends c<ht> {
    public e() {
        this.sFo = ht.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        ht htVar = (ht) bVar;
        if (htVar instanceof ht) {
            if (htVar.bRe.bOh == 0) {
                g.Ek();
                g.Eh().dpP.a(new v(1), 0);
            } else {
                g.Ek();
                g.Eh().dpP.a(new v(htVar.bRe.bOh), 0);
            }
            return true;
        }
        x.f("MicroMsg.GetSnsTagListListener", "mismatched event");
        return false;
    }
}

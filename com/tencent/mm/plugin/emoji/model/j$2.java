package com.tencent.mm.plugin.emoji.model;

import com.tencent.mm.g.a.cs;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.emoji.f.q;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

class j$2 extends c<cs> {
    final /* synthetic */ j iid;

    j$2(j jVar) {
        this.iid = jVar;
        this.sFo = cs.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        cs csVar = (cs) bVar;
        if (this.iid.ihY.contains(csVar.bKf.bKg)) {
            this.iid.iia.remove(csVar.bKf.bKg);
            if (csVar.bKf.success) {
                x.i("MicroMsg.emoji.WearEmojiLogic", "emoji downloaded %s success", new Object[]{csVar.bKf.bKg});
                i.aEA().igy.Zu(csVar.bKf.bKg);
                au.DF().a(new q(csVar.bKf.bKg, 2), 0);
            } else {
                x.i("MicroMsg.emoji.WearEmojiLogic", "emoji downloaded %s fail", new Object[]{csVar.bKf.bKg});
            }
            this.iid.aEE();
        }
        return false;
    }
}

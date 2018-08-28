package com.tencent.mm.plugin.emoji.e;

import com.tencent.mm.g.a.ji;
import com.tencent.mm.model.au;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa.a;

class b$3 extends c<ji> {
    final /* synthetic */ b ifh;

    b$3(b bVar) {
        this.ifh = bVar;
        this.sFo = ji.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        ji jiVar = (ji) bVar;
        if (jiVar != null && (jiVar instanceof ji)) {
            x.i("MicroMsg.emoji.EmojiEventMgr", "manualAuthEventListener callback");
            if (jiVar.bSN.bGZ) {
                au.HU();
                com.tencent.mm.model.c.DT().a(a.sOY, Boolean.valueOf(true));
            }
        }
        return false;
    }
}

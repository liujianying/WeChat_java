package com.tencent.mm.plugin.game.model.a;

import com.tencent.mm.g.a.gr;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class d$2 extends c<gr> {
    d$2() {
        this.sFo = gr.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        String str = ((gr) bVar).bPR.bPS;
        if (bi.oW(str)) {
            x.i("MicroMsg.GameSilentDownloadListener", "GameSilentDownloadEvent, appid is null!");
        } else {
            e.U(str, 7, 0);
            c cVar = new c();
            cVar.field_appId = str;
            boolean a = ((com.tencent.mm.plugin.game.a.c) g.l(com.tencent.mm.plugin.game.a.c.class)).aSl().a(cVar, new String[0]);
            x.i("MicroMsg.GameSilentDownloadListener", "cancel silentDownloadTask, appid:%s, ret:%b", new Object[]{str, Boolean.valueOf(a)});
        }
        return false;
    }
}

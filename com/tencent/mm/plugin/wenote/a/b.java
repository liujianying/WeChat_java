package com.tencent.mm.plugin.wenote.a;

import com.tencent.mm.g.a.lj;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wenote.model.j;
import com.tencent.mm.protocal.c.wn;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

public final class b extends c<lj> {
    public b() {
        this.sFo = lj.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
        lj ljVar = (lj) bVar;
        if (ljVar.bVI.bUY) {
            h.mEJ.h(14789, new Object[]{Integer.valueOf(3)});
        } else {
            h.mEJ.h(14789, new Object[]{Integer.valueOf(2)});
        }
        x.i("MicroMsg.OpenNoteFromSessionListener", "do OpenNoteFromSessionListener");
        j jVar = new j();
        com.tencent.mm.plugin.wenote.model.c.bZb().qnC = jVar;
        wn wnVar = new wn();
        wnVar.scene = ljVar.bVI.scene;
        jVar.a(ljVar.bVI.bVJ, Long.valueOf(ljVar.bVI.bJC), ljVar.bVI.bUY, ljVar.bVI.context, 0, 0, wnVar);
        return false;
    }
}

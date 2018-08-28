package com.tencent.mm.plugin.location.model;

import com.tencent.mm.g.a.iw;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;

final class l$b extends c<iw> {
    private l$b() {
        this.sFo = iw.class.getName().hashCode();
    }

    /* synthetic */ l$b(byte b) {
        this();
        this.sFo = iw.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        iw iwVar = (iw) bVar;
        if (!(iwVar instanceof iw)) {
            return false;
        }
        x.d("MicroMsg.SubCoreLocation", "e.data.eventType : " + iwVar.bSt.bSv);
        switch (iwVar.bSt.bSv) {
            case 0:
                iwVar.bSu.path = e.a(iwVar.bSt.bSw, iwVar.bSt.filename, iwVar.bSt.view);
                break;
            case 1:
                com.tencent.mm.pluginsdk.location.b bVar2 = new com.tencent.mm.pluginsdk.location.b(-1, iwVar.bSt.bSx, iwVar.bSt.bSy, iwVar.bSt.bSz, 1);
                iwVar.bSu.path = k.b(bVar2);
                break;
            case 2:
                g.DF().a(new g(iwVar.bSt.bSx, iwVar.bSt.bSy, iwVar.bSt.bSz, iwVar.bSt.width, iwVar.bSt.height, iwVar.bSt.filename, w.chP()), 0);
                break;
            case 3:
                g gVar = (g) iwVar.bSt.bKq;
                iwVar.bSu.path = gVar.kCH;
                break;
        }
        return true;
    }
}

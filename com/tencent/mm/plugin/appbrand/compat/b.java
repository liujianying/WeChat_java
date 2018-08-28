package com.tencent.mm.plugin.appbrand.compat;

import com.tencent.mm.ab.g.a;
import com.tencent.mm.g.a.fc;
import com.tencent.mm.plugin.appbrand.compat.a.d;

final class b implements d {
    b() {
    }

    public final void a(String str, a aVar, com.tencent.mm.ab.g.b bVar) {
        fc fcVar = new fc();
        fcVar.bNi.op = 1;
        fcVar.bNi.fileName = str;
        fcVar.bNi.bNk = true;
        fcVar.bNi.bCH = true;
        fcVar.bNi.bNl = aVar;
        fcVar.bNi.bNm = bVar;
        com.tencent.mm.sdk.b.a.sFg.m(fcVar);
    }

    public final void pause() {
        fc fcVar = new fc();
        fcVar.bNi.op = 4;
        com.tencent.mm.sdk.b.a.sFg.m(fcVar);
    }

    public final void stop() {
        fc fcVar = new fc();
        fcVar.bNi.op = 2;
        com.tencent.mm.sdk.b.a.sFg.m(fcVar);
    }
}

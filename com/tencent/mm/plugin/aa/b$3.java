package com.tencent.mm.plugin.aa;

import com.tencent.mm.g.a.bo;
import com.tencent.mm.plugin.aa.a.j;
import com.tencent.mm.plugin.aa.a.j.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vending.g.g;

class b$3 extends c<bo> {
    final /* synthetic */ b ezx;

    b$3(b bVar) {
        this.ezx = bVar;
        this.sFo = bo.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        bo boVar = (bo) bVar;
        x.i("MicroMsg.SubCoreAA", "closeAAEvent callback, billNo: %s, chatroom: %s", new Object[]{boVar.bIW.bIX, boVar.bIW.bIY});
        if (!(bi.oW(boVar.bIW.bIX) || bi.oW(boVar.bIW.bIY))) {
            j jVar = new j();
            jVar.Wb().init();
            a aVar = jVar.eAw;
            String str = boVar.bIW.bIX;
            int i = com.tencent.mm.plugin.aa.a.a.ezY;
            g.a(str, Integer.valueOf(i), boVar.bIW.bIY, Long.valueOf(boVar.bIW.bIZ)).c(aVar).d(new 2(this, jVar)).a(new 1(this, jVar));
        }
        return false;
    }
}

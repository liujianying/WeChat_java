package com.tencent.mm.booter;

import com.tencent.mm.booter.z.a;
import com.tencent.mm.g.a.mo;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;

class z$2 extends c<mo> {
    final /* synthetic */ z cXX;

    z$2(z zVar) {
        this.cXX = zVar;
        this.sFo = mo.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        mo moVar = (mo) bVar;
        if (moVar instanceof mo) {
            bd bdVar = moVar.bXx.bGS;
            z zVar = this.cXX;
            if (!(zVar.cXL == null || zVar.cXO.contains(Long.valueOf(bdVar.field_msgSvrId)) || !zVar.cXL.cXY.equals(bdVar.field_talker))) {
                zVar.cXO.add(Long.valueOf(bdVar.field_msgSvrId));
                a aVar = zVar.cXL;
                aVar.cYe++;
                x.i("MicroMsg.StayTimeReport", "receiveMsg msgType:%d, recvCnt:%d", new Object[]{Integer.valueOf(bdVar.getType()), Integer.valueOf(zVar.cXL.cYe)});
            }
        }
        return false;
    }
}

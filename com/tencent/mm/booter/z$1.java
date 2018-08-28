package com.tencent.mm.booter;

import com.tencent.mm.booter.z.a;
import com.tencent.mm.g.a.pa;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;

class z$1 extends c<pa> {
    final /* synthetic */ z cXX;

    z$1(z zVar) {
        this.cXX = zVar;
        this.sFo = pa.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        pa paVar = (pa) bVar;
        if (paVar instanceof pa) {
            bd bdVar = paVar.bZV.bGS;
            z zVar = this.cXX;
            if (!(zVar.cXL == null || zVar.cXN.contains(Long.valueOf(bdVar.field_msgId)) || !zVar.cXL.cXY.equals(bdVar.field_talker))) {
                zVar.cXN.add(Long.valueOf(bdVar.field_msgId));
                a aVar = zVar.cXL;
                aVar.cYf++;
                x.i("MicroMsg.StayTimeReport", "sendMsg msgType:%d, SendCnt:%d", new Object[]{Integer.valueOf(bdVar.getType()), Integer.valueOf(zVar.cXL.cYf)});
            }
        }
        return false;
    }
}

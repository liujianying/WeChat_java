package com.tencent.mm.plugin.subapp.jdbiz;

import com.tencent.mm.g.a.km;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bi;

class a$1 extends c<km> {
    final /* synthetic */ a oqE;

    a$1(a aVar) {
        this.oqE = aVar;
        this.sFo = km.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        km kmVar = (km) bVar;
        if ((kmVar instanceof km) && kmVar.bUM.bUO != null && kmVar.bUM.bUN != null && "bizjd".equals(kmVar.bUM.bUN)) {
            String aG = bi.aG(kmVar.bUM.bUO.getString("activity_id"), "");
            String aG2 = bi.aG(kmVar.bUM.bUO.getString("jump_url"), "");
            h.mEJ.h(11179, new Object[]{aG2, c.bGg().bGq().oqH, Integer.valueOf(4)});
            b bGl = c.bGg().bGq();
            if (!(bGl == null || bGl.oqH == null || !bGl.oqH.equals(aG))) {
                c.bGg().bGk();
                c.bGg().bGj();
            }
            a.sFg.c(this.oqE.oqD);
        }
        return false;
    }
}

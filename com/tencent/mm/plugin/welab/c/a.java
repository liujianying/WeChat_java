package com.tencent.mm.plugin.welab.c;

import android.database.Cursor;
import com.tencent.mm.bt.h;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.List;

public final class a extends i<com.tencent.mm.plugin.welab.c.a.a> {
    private e diF;

    public a(e eVar) {
        super(eVar, com.tencent.mm.plugin.welab.c.a.a.dhO, "LabAppInfo", null);
        this.diF = eVar;
    }

    public final List<com.tencent.mm.plugin.welab.c.a.a> bYS() {
        Cursor axc = axc();
        List<com.tencent.mm.plugin.welab.c.a.a> arrayList = new ArrayList();
        while (axc.moveToNext()) {
            com.tencent.mm.plugin.welab.c.a.a aVar = new com.tencent.mm.plugin.welab.c.a.a();
            aVar.d(axc);
            arrayList.add(aVar);
        }
        axc.close();
        return arrayList;
    }

    public final void cQ(List<com.tencent.mm.plugin.welab.c.a.a> list) {
        long dO;
        h hVar = null;
        if (this.diF instanceof h) {
            h hVar2 = (h) this.diF;
            dO = hVar2.dO(-1);
            hVar = hVar2;
        } else {
            dO = 0;
        }
        for (com.tencent.mm.plugin.welab.c.a.a c : list) {
            c(c);
        }
        if (hVar != null) {
            hVar.gp(dO);
        }
    }

    public final void c(com.tencent.mm.plugin.welab.c.a.a aVar) {
        if (!d(aVar)) {
            b(aVar);
        }
    }

    private boolean d(com.tencent.mm.plugin.welab.c.a.a aVar) {
        com.tencent.mm.plugin.welab.c.a.a aVar2 = new com.tencent.mm.plugin.welab.c.a.a();
        aVar2.field_LabsAppId = aVar.field_LabsAppId;
        b(aVar2, new String[0]);
        if (aVar.field_sequence > aVar2.field_sequence) {
            return super.a(aVar);
        }
        x.i("LabAppInfoStorage", "sequence old origin.seq " + aVar2.field_sequence + " old.seq " + aVar.field_sequence);
        return false;
    }
}

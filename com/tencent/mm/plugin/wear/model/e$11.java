package com.tencent.mm.plugin.wear.model;

import com.tencent.mm.g.a.oc;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.wear.model.f.i;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.storage.ai;
import java.util.ArrayList;

class e$11 extends c<oc> {
    final /* synthetic */ e pJo;

    e$11(e eVar) {
        this.pJo = eVar;
        this.sFo = oc.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        oc ocVar = (oc) bVar;
        if (e.a(this.pJo)) {
            au.HU();
            ai Yq = com.tencent.mm.model.c.FW().Yq(ocVar.bYY.bXQ.field_talker);
            if (Yq != null) {
                int i = Yq.field_unReadCount;
                f PK = a.bSl().pIO.PK(ocVar.bYY.bXQ.field_talker);
                if (i - PK.pJw > 0) {
                    e.m(ocVar.bYY.bXQ.field_talker, i, false);
                } else {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(Integer.valueOf(PK.id));
                    a.bSl().pIS.a(new i(arrayList));
                }
            }
        }
        return false;
    }
}

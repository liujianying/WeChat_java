package com.tencent.mm.plugin.hp.tinker;

import com.tencent.mm.kernel.g;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.boots.a.c;
import com.tencent.mm.plugin.hp.b.b;
import com.tencent.mm.protocal.c.bsw;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.x;
import com.tinkerboots.sdk.a.a.a;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class f extends a {
    public final boolean aWu() {
        return super.aWu();
    }

    public final void E(Map<String, String> map) {
        super.E(map);
        b.rl(2);
        String str = "tinker_id_" + com.tencent.mm.loader.stub.a.baseRevision();
        String str2 = com.tencent.mm.loader.stub.a.PATCH_REV == null ? "" : "tinker_id_" + com.tencent.mm.loader.stub.a.PATCH_REV;
        List linkedList = new LinkedList();
        for (String str3 : map.keySet()) {
            bsw bsw = new bsw();
            bsw.aAL = str3;
            bsw.value = (String) map.get(str3);
            linkedList.add(bsw);
        }
        StringBuilder stringBuilder = new StringBuilder();
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            bsw bsw2 = (bsw) it.next();
            stringBuilder.append(bsw2.aAL).append(":").append(bsw2.value).append("\n");
        }
        x.i("Tinker.TinkerPatchRequestCallback", "checkAvailableUpdate BaseID:%s PatchID:%s config:%s", new Object[]{str, str2, stringBuilder.toString()});
        au.DF().a(new com.tencent.mm.plugin.hp.c.a(str, str2, linkedList), 0);
    }

    public final void aWv() {
        super.aWv();
        com.tinkerboots.sdk.a.cJC().gy("uin", String.valueOf(((long) com.tencent.mm.kernel.a.Dz()) & 4294967295L)).gy("network", String.valueOf(ao.isWifi(ad.getContext()) ? 3 : 2));
        List<com.tencent.mm.plugin.boots.a.a> aua = ((c) g.l(c.class)).aua();
        if (aua != null) {
            for (com.tencent.mm.plugin.boots.a.a aVar : aua) {
                com.tinkerboots.sdk.a.cJC().gy(Integer.toHexString(aVar.field_key), String.valueOf(aVar.field_dau));
            }
        }
    }
}

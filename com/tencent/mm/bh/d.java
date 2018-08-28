package com.tencent.mm.bh;

import com.tencent.mm.aq.h;
import com.tencent.mm.aq.h.a;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public final class d {
    public static void cfO() {
        Object obj = (!au.HX() || au.Dr()) ? null : 1;
        if (obj != null && xG()) {
            au.HU();
            String str = (String) c.DT().get(77829, null);
            if (str != null) {
                Map Uv = a.Uv(str);
                if (Uv != null && Uv.size() > 0) {
                    List linkedList = new LinkedList();
                    for (Entry entry : Uv.entrySet()) {
                        a aVar = (a) entry.getValue();
                        if (aVar != null) {
                            int i = aVar.hitCount;
                            int i2 = aVar.ecL;
                            if (i > 0 || i2 > 0) {
                                linkedList.add(new a(10166, ((String) entry.getKey()) + "," + i + "," + i2));
                            }
                            x.d("PostTaskTenMinutesLogicState", "report PostTaskTenMinutesLogicState  name " + ((String) entry.getKey()) + " " + i + "  " + i2);
                        }
                    }
                    if (!linkedList.isEmpty()) {
                        au.HU();
                        c.FQ().b(new h(linkedList));
                        au.HU();
                        c.DT().set(77829, null);
                    }
                }
            }
        }
        au.HU();
        c.DT().set(77828, Long.valueOf(bi.VE()));
        x.d("PostTaskTenMinutesLogicState", "report PostTaskTenMinutesLogicState done ");
    }

    public static boolean xG() {
        au.HU();
        return bi.bG(bi.a((Long) c.DT().get(77828, null), 0)) * 1000 > 1800000;
    }
}

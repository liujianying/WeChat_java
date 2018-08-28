package com.tencent.c.e.a.a;

import com.tencent.c.e.a.b.f;
import com.tencent.c.e.a.b.g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class i {
    final int dty;
    int iUy = 0;
    Object[] tD;
    final int uVx;
    private final int vkg;

    public i(int i, int i2, int i3) {
        this.vkg = i;
        this.tD = new Object[((int) Math.ceil((double) ((1.0f * ((float) i3)) / ((float) i2))))];
        this.dty = i3;
        this.uVx = i2;
    }

    private ArrayList<f> Ho(int i) {
        ArrayList<f> arrayList = new ArrayList();
        List list = (List) this.tD[i];
        if (list == null) {
            return arrayList;
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            j jVar = (j) list.get(i2);
            f fVar = new f();
            fVar.x = jVar.values[0];
            fVar.y = jVar.values[1];
            fVar.z = jVar.values[2];
            fVar.vkB = jVar.timestamp;
            arrayList.add(fVar);
        }
        return arrayList;
    }

    public final ArrayList<g> eg(List<k> list) {
        ArrayList<g> arrayList = new ArrayList();
        for (int i = 0; i < this.tD.length; i++) {
            List list2 = (List) this.tD[i];
            if (!(list2 == null || list2.size() == 0)) {
                g gVar = new g();
                ArrayList Ho = Ho(i);
                Map hashMap = new HashMap();
                int i2 = this.vkg == 1 ? 0 : this.vkg == 4 ? 2 : this.vkg == 9 ? 4 : -1;
                hashMap.put(Integer.valueOf(i2), Ho);
                gVar.vkD = hashMap;
                j jVar = (j) list2.get(0);
                if (jVar != null) {
                    gVar.vkC = jVar.timestamp;
                    if (list.size() > i) {
                        k kVar = (k) list.get(i);
                        if (kVar != null) {
                            gVar.vki = kVar.vki;
                            gVar.vkj = kVar.vkj;
                            gVar.vkk = kVar.vkk;
                            gVar.vkl = kVar.vkl;
                        }
                    }
                    arrayList.add(gVar);
                }
            }
        }
        return arrayList;
    }

    public final Object[] cFu() {
        return (Object[]) this.tD.clone();
    }
}

package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.ui.at.c;
import com.tencent.mm.plugin.sns.ui.au.b;
import com.tencent.mm.sdk.platformtools.x;
import java.util.List;
import java.util.Map;

class at$1 implements b {
    final /* synthetic */ c nZO;
    final /* synthetic */ at nZP;

    at$1(at atVar, c cVar) {
        this.nZP = atVar;
        this.nZO = cVar;
    }

    public final void a(List<n> list, Map<Integer, Integer> map, Map<Integer, Integer> map2, Map<Integer, Integer> map3, int i, int i2) {
        x.d("MicroMsg.SnsphotoAdapter", "onFinishFixPos");
        at atVar = this.nZP;
        x.d("MicroMsg.SnsphotoAdapter", "setSnsList the thread id is " + Thread.currentThread().getId());
        if (list != null && list.size() > 0) {
            int i3;
            x.d("MicroMsg.SnsphotoAdapter", "copy list info");
            int size = list.size();
            atVar.list.clear();
            atVar.nKG.clear();
            atVar.nKH.clear();
            atVar.nZD.clear();
            for (i3 = 0; i3 < size; i3++) {
                atVar.list.add(n.x((n) list.get(i3)));
            }
            for (Integer intValue : map.keySet()) {
                size = intValue.intValue();
                atVar.nKG.put(Integer.valueOf(size), Integer.valueOf(((Integer) map.get(Integer.valueOf(size))).intValue()));
            }
            for (Integer intValue2 : map2.keySet()) {
                size = intValue2.intValue();
                atVar.nKH.put(Integer.valueOf(size), Integer.valueOf(((Integer) map2.get(Integer.valueOf(size))).intValue()));
            }
            for (Integer intValue22 : map3.keySet()) {
                size = intValue22.intValue();
                atVar.nZD.put(Integer.valueOf(size), Integer.valueOf(((Integer) map3.get(Integer.valueOf(size))).intValue()));
            }
            map.clear();
            map2.clear();
            if (atVar.bNu) {
                i3 = atVar.list.size() <= 1 ? Integer.MAX_VALUE : ((n) atVar.list.get(1)).field_head;
            } else {
                i3 = atVar.list.isEmpty() ? Integer.MAX_VALUE : ((n) atVar.list.get(0)).field_head;
            }
            atVar.nZI = 0;
            size = 0;
            while (size < atVar.list.size()) {
                if (!atVar.bNu || size != 0) {
                    if (i3 != ((n) atVar.list.get(size)).field_head) {
                        break;
                    }
                    atVar.nZI = Math.max(atVar.nZI, ((n) atVar.list.get(size)).field_createTime);
                }
                size++;
            }
            if (atVar.list.isEmpty() || (atVar.bNu && atVar.list.size() == 1)) {
                atVar.nZI = Integer.MAX_VALUE;
            }
            i3 = atVar.list.isEmpty() ? 0 : ((n) atVar.list.get(atVar.list.size() - 1)).field_head;
            atVar.nZJ = Integer.MAX_VALUE;
            int size2 = atVar.list.size() - 1;
            while (size2 >= 0 && i3 != 0 && i3 == ((n) atVar.list.get(size2)).field_head) {
                atVar.nZJ = Math.min(atVar.nZJ, ((n) atVar.list.get(size2)).field_createTime);
                size2--;
            }
            if (atVar.list.isEmpty()) {
                atVar.nZJ = 0;
            }
            atVar.nKJ = i;
            atVar.nKI = i2;
            x.d("MicroMsg.SnsphotoAdapter", "reallyCount " + i + " icount " + i2 + " stTime " + atVar.nZI + " edTIme " + atVar.nZJ);
            atVar.notifyDataSetChanged();
        }
    }

    public final void bDJ() {
        this.nZP.notifyDataSetChanged();
    }
}

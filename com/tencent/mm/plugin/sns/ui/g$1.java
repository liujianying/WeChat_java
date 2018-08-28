package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.modelsns.e;
import com.tencent.mm.plugin.sns.ui.h.a;
import com.tencent.mm.protocal.c.ate;
import com.tencent.mm.protocal.c.dx;
import com.tencent.mm.sdk.platformtools.x;
import java.util.List;
import java.util.Map;

class g$1 implements a {
    final /* synthetic */ g nKN;

    g$1(g gVar) {
        this.nKN = gVar;
    }

    public final void a(List<ate> list, Map<Integer, Integer> map, Map<Integer, Integer> map2, int i, int i2, dx dxVar) {
        x.d("MicroMsg.ArtistAdapter", "onFinishFixPos");
        g gVar = this.nKN;
        if (list != null && list.size() > 0) {
            int intValue;
            try {
                gVar.nKM.a((dx) new dx().aG(dxVar.toByteArray()));
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.ArtistAdapter", e, "", new Object[0]);
            }
            x.d("MicroMsg.ArtistAdapter", "copy list info");
            int size = list.size();
            gVar.list.clear();
            gVar.nKG.clear();
            gVar.nKH.clear();
            for (int i3 = 0; i3 < size; i3++) {
                ate ate = (ate) list.get(i3);
                gVar.list.add(e.a(ate.ksA, ate.hcE, ate.jPK, ate.rVE, ate.rVD, ate.rVF, ate.jOS));
            }
            for (Integer intValue2 : map.keySet()) {
                intValue = intValue2.intValue();
                gVar.nKG.put(Integer.valueOf(intValue), Integer.valueOf(((Integer) map.get(Integer.valueOf(intValue))).intValue()));
            }
            for (Integer intValue22 : map2.keySet()) {
                intValue = intValue22.intValue();
                gVar.nKH.put(Integer.valueOf(intValue), Integer.valueOf(((Integer) map2.get(Integer.valueOf(intValue))).intValue()));
            }
            list.clear();
            map.clear();
            map2.clear();
            gVar.nKJ = i;
            gVar.nKI = i2;
            x.d("MicroMsg.ArtistAdapter", "reallyCount " + i + " icount " + i2);
            gVar.notifyDataSetChanged();
        }
    }

    public final void bBJ() {
        g gVar = this.nKN;
        if (gVar.nKM != null) {
            gVar.nKM.bBK();
        }
    }
}

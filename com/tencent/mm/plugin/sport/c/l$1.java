package com.tencent.mm.plugin.sport.c;

import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sport.PluginSport;
import com.tencent.mm.protocal.c.aib;
import com.tencent.mm.protocal.c.bre;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

class l$1 implements e {
    final /* synthetic */ l opm;

    l$1(l lVar) {
        this.opm = lVar;
    }

    public final void a(int i, int i2, String str, l lVar) {
        if (lVar instanceof d) {
            g.DF().b(1734, this.opm.dKj);
            d dVar = (d) lVar;
            if (i == 0 && i2 == 0) {
                aib aib = dVar.ooV;
                Collections.sort(aib.rKS, new Comparator<bre>() {
                    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
                        return ((bre) obj).timestamp - ((bre) obj2).timestamp;
                    }
                });
                Calendar instance = Calendar.getInstance();
                instance.setTimeInMillis(((long) ((bre) aib.rKS.get(0)).timestamp) * 1000);
                instance.set(10, 0);
                instance.set(12, 0);
                instance.set(13, 0);
                long timeInMillis = instance.getTimeInMillis();
                ((PluginSport) g.n(PluginSport.class)).getSportStepStorage();
                m.D((long) dVar.ooU.rvI, (long) dVar.ooU.rvJ);
                x.i("MicroMsg.Sport.SportStepManager", "delete step item after %s", new Object[]{this.opm.opl.format(new Date(timeInMillis))});
                List arrayList = new ArrayList();
                Iterator it = aib.rKS.iterator();
                while (it.hasNext()) {
                    bre bre = (bre) it.next();
                    com.tencent.mm.plugin.sport.b.e eVar = new com.tencent.mm.plugin.sport.b.e();
                    eVar.field_step = bre.fHo;
                    eVar.field_timestamp = ((long) bre.timestamp) * 1000;
                    eVar.field_date = this.opm.opl.format(new Date(eVar.field_timestamp));
                    arrayList.add(eVar);
                }
                ((PluginSport) g.n(PluginSport.class)).getSportStepStorage();
                m.cx(arrayList);
                if (dVar.ooW != null) {
                    dVar.ooW.aId();
                }
            }
        }
    }
}

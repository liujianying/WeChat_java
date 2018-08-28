package com.tencent.mm.plugin.fav.ui;

import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.ui.FavCleanUI.5.1.1;
import com.tencent.mm.plugin.fav.ui.a.b;
import java.util.ArrayList;
import java.util.List;

class FavCleanUI$5$1$1$1 implements Runnable {
    final /* synthetic */ 1 iYF;

    FavCleanUI$5$1$1$1(1 1) {
        this.iYF = 1;
    }

    public final void run() {
        b e = FavCleanUI.e(this.iYF.iYE.iYB.iYA);
        List<g> list = this.iYF.iYC;
        if (e.jbE != null) {
            List arrayList = new ArrayList();
            for (g gVar : e.jbE) {
                if (gVar != null) {
                    Object obj;
                    for (g gVar2 : list) {
                        if (gVar2 != null && gVar.field_localId == gVar2.field_localId) {
                            obj = 1;
                            break;
                        }
                    }
                    obj = null;
                    if (obj == null) {
                        arrayList.add(gVar);
                    }
                }
            }
            e.jbE = arrayList;
            arrayList = new ArrayList();
            for (Long l : e.jbH) {
                Object obj2;
                for (g gVar3 : list) {
                    if (gVar3 != null && l.equals(Long.valueOf(gVar3.field_localId))) {
                        obj2 = 1;
                        break;
                    }
                }
                obj2 = null;
                if (obj2 == null) {
                    arrayList.add(l);
                }
            }
            e.jbH = arrayList;
        }
        FavCleanUI.e(this.iYF.iYE.iYB.iYA).notifyDataSetChanged();
        FavCleanUI.f(this.iYF.iYE.iYB.iYA).aMR();
        this.iYF.iYD.dismiss();
    }

    public final String toString() {
        return super.toString() + "|batchDelFavItems";
    }
}

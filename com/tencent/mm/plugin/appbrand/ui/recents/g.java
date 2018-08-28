package com.tencent.mm.plugin.appbrand.ui.recents;

import com.tencent.mm.plugin.appbrand.appusage.k;
import com.tencent.mm.sdk.platformtools.bi;
import java.util.ArrayList;
import java.util.Iterator;

final class g {
    final boolean bKe;

    g(boolean z) {
        this.bKe = z;
    }

    final ArrayList<k> k(ArrayList<k> arrayList) {
        if (!this.bKe || bi.cX(arrayList)) {
            return arrayList;
        }
        ArrayList<k> arrayList2 = new ArrayList(arrayList.size());
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            k kVar = (k) it.next();
            if (!kVar.fmd) {
                arrayList2.add(kVar);
            }
        }
        return arrayList2;
    }
}

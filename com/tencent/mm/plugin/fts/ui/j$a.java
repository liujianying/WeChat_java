package com.tencent.mm.plugin.fts.ui;

import com.tencent.mm.plugin.fts.a.d.e;
import java.util.Iterator;

class j$a implements Runnable {
    private String bWm;
    final /* synthetic */ j jwU;
    private e jwV;

    j$a(j jVar, e eVar, String str) {
        this.jwU = jVar;
        this.bWm = str;
        this.jwV = eVar;
    }

    public final void run() {
        int i;
        if (!j.a(this.jwU) && ((e) j.b(this.jwU).get(j.b(this.jwU).size() - 1)).getType() == this.jwV.getType()) {
            j.c(this.jwU);
        }
        int i2 = 0;
        Iterator it = j.b(this.jwU).iterator();
        while (true) {
            i = i2;
            if (!it.hasNext()) {
                break;
            }
            i2 = ((e) it.next()).qg(i);
        }
        this.jwU.setCount(i);
        this.jwU.notifyDataSetChanged();
        this.jwU.J(i, j.d(this.jwU));
        if (j.d(this.jwU)) {
            j.e(this.jwU).jyY = System.currentTimeMillis();
        }
    }
}

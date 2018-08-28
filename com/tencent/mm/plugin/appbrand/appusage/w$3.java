package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.mm.plugin.appbrand.config.k.a;
import com.tencent.mm.plugin.appbrand.config.r;
import com.tencent.mm.protocal.c.ahn;
import com.tencent.mm.protocal.c.bno;
import com.tencent.mm.sdk.platformtools.bi;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

class w$3 implements Runnable {
    final /* synthetic */ w fmI;
    final /* synthetic */ ahn fmK;

    w$3(w wVar, ahn ahn) {
        this.fmI = wVar;
        this.fmK = ahn;
    }

    public final void run() {
        if (!bi.cX(this.fmK.rKL)) {
            List linkedList = new LinkedList();
            Iterator it = this.fmK.rKL.iterator();
            while (it.hasNext()) {
                linkedList.add(((bno) it.next()).username);
            }
            r.a(linkedList, a.frs);
        }
    }
}

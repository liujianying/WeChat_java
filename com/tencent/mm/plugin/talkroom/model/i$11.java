package com.tencent.mm.plugin.talkroom.model;

import java.util.Iterator;

class i$11 implements Runnable {
    final /* synthetic */ String hMX;
    final /* synthetic */ i oxm;

    i$11(i iVar, String str) {
        this.oxm = iVar;
        this.hMX = str;
    }

    public final void run() {
        synchronized (this.oxm.cWy) {
            Iterator it = this.oxm.cWy.iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }
}

package com.tencent.mm.plugin.appbrand.ipc;

import com.tencent.mm.plugin.appbrand.ipc.MMToClientEvent.a;
import java.util.List;

class MMToClientEvent$1 implements Runnable {
    final /* synthetic */ List fEu;
    final /* synthetic */ Object fEv;
    final /* synthetic */ MMToClientEvent fEw;

    MMToClientEvent$1(MMToClientEvent mMToClientEvent, List list, Object obj) {
        this.fEw = mMToClientEvent;
        this.fEu = list;
        this.fEv = obj;
    }

    public final void run() {
        for (a bj : this.fEu) {
            bj.bj(this.fEv);
        }
    }
}

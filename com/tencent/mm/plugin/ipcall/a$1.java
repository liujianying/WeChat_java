package com.tencent.mm.plugin.ipcall;

import com.tencent.mm.g.a.ho;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.x;

class a$1 implements Runnable {
    final /* synthetic */ a knP;

    a$1(a aVar) {
        this.knP = aVar;
    }

    public final void run() {
        x.d("MicroMsg.IPCallAddressBookUsernameUpdater", "start GetMFriend");
        ho hoVar = new ho();
        hoVar.bQU.scene = 2;
        a.sFg.m(hoVar);
        a.a(this.knP, System.currentTimeMillis());
    }
}

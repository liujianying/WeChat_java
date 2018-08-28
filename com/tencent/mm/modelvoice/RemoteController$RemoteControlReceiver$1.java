package com.tencent.mm.modelvoice;

import com.tencent.mm.modelvoice.RemoteController.RemoteControlReceiver;
import com.tencent.mm.sdk.platformtools.al.a;
import com.tencent.mm.sdk.platformtools.x;

class RemoteController$RemoteControlReceiver$1 implements a {
    final /* synthetic */ RemoteControlReceiver eoQ;

    RemoteController$RemoteControlReceiver$1(RemoteControlReceiver remoteControlReceiver) {
        this.eoQ = remoteControlReceiver;
    }

    public final boolean vD() {
        x.d("MicroMsg.RemoteControlReceiver", "got remote key event up");
        RemoteControlReceiver.TB();
        return false;
    }
}

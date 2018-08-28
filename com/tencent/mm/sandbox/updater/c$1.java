package com.tencent.mm.sandbox.updater;

import android.os.Message;
import com.tencent.mm.protocal.c.bhp;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;

class c$1 extends ag {
    final /* synthetic */ c sDP;

    c$1(c cVar) {
        this.sDP = cVar;
    }

    public final void handleMessage(Message message) {
        if (1 == message.what && !c.a(this.sDP)) {
            new File(this.sDP.beJ()).delete();
            if (message.arg1 == 0) {
                x.d("MicroMsg.NetSceneGetUpdatePackFromCDN", "patch ok");
                c.b(this.sDP).a(200, 0, (bhp) message.obj);
            } else if (message.arg1 == 3) {
                c.b(this.sDP).a(3, -1, (bhp) message.obj);
            } else if (message.arg1 == 4) {
                c.b(this.sDP).a(4, -1, (bhp) message.obj);
            }
        }
        super.handleMessage(message);
    }
}

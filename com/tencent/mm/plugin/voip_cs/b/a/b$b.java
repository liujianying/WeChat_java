package com.tencent.mm.plugin.voip_cs.b.a;

import android.os.Message;
import com.tencent.mm.sdk.f.e;

class b$b implements Runnable {
    final /* synthetic */ b oXY;

    b$b(b bVar) {
        this.oXY = bVar;
    }

    public final void run() {
        this.oXY.oXX = b.OO(this.oXY.oXW);
        Message message = new Message();
        message.what = 12;
        b.t(this.oXY).sendMessage(message);
        e.remove(this.oXY.oXV);
    }
}

package com.tencent.mm.plugin.radar.b;

import android.os.Message;
import b.c.b.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.radar.b.e.b;
import com.tencent.mm.sdk.platformtools.ag;

public final class e$g extends ag {
    e$g() {
    }

    public final void handleMessage(Message message) {
        e.i(message, "msg");
        int i = message.what;
        b bVar = e.mkl;
        if (i == e.bpw()) {
            g.DF().d((l) new b());
        }
    }
}

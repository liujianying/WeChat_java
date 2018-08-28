package com.tencent.mm.plugin.appbrand.media.record;

import com.tencent.mm.e.b.b.a;
import com.tencent.mm.sdk.platformtools.x;

class a$2 implements a {
    a$2() {
    }

    public final void onError() {
        x.e("MicroMsg.Record.AudioRecorder", "onError");
        a.lg(-1);
    }
}

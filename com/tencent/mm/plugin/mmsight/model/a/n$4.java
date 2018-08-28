package com.tencent.mm.plugin.mmsight.model.a;

import com.tencent.mm.plugin.mmsight.model.a.n.6;
import com.tencent.mm.sdk.f.e;

class n$4 implements f$a {
    final /* synthetic */ n ljp;

    n$4(n nVar) {
        this.ljp = nVar;
    }

    public final void bew() {
        e.post(new 6(this.ljp), "MMSightMediaCodecMP4MuxRecorder_stop");
    }
}

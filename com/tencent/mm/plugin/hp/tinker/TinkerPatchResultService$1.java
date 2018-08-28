package com.tencent.mm.plugin.hp.tinker;

import com.tencent.tinker.lib.f.a;
import com.tencent.tinker.lib.f.b;

class TinkerPatchResultService$1 implements Runnable {
    final /* synthetic */ TinkerPatchResultService knc;

    TinkerPatchResultService$1(TinkerPatchResultService tinkerPatchResultService) {
        this.knc = tinkerPatchResultService;
    }

    public final void run() {
        a.w("Tinker.TinkerPatchResultService", "actually kill tinker patch service!", new Object[0]);
        b.hM(this.knc.getApplicationContext());
    }
}

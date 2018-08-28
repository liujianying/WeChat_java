package com.tencent.mm.app;

import com.tencent.mm.plugin.report.service.KVCommCrossProcessReceiver;
import com.tencent.mm.sdk.platformtools.ak.c;

class ToolsProfile$1 implements c {
    final /* synthetic */ ToolsProfile bzj;

    ToolsProfile$1(ToolsProfile toolsProfile) {
        this.bzj = toolsProfile;
    }

    public final void c(String str, Throwable th) {
        KVCommCrossProcessReceiver.brP();
    }
}

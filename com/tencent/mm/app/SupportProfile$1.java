package com.tencent.mm.app;

import com.tencent.mm.plugin.report.service.KVCommCrossProcessReceiver;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ak.c;

class SupportProfile$1 implements c {
    final /* synthetic */ SupportProfile bzi;

    SupportProfile$1(SupportProfile supportProfile) {
        this.bzi = supportProfile;
    }

    public final void c(String str, Throwable th) {
        h.mEJ.a(637, 0, 1, false);
        KVCommCrossProcessReceiver.brP();
    }
}

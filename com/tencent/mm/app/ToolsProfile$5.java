package com.tencent.mm.app;

import com.tencent.mm.sdk.platformtools.x;
import com.tencent.xweb.WebView.c;

class ToolsProfile$5 implements c {
    final /* synthetic */ ToolsProfile bzj;

    ToolsProfile$5(ToolsProfile toolsProfile) {
        this.bzj = toolsProfile;
    }

    public final void onCoreInitFinished() {
        x.i("MicroMsg.ToolsProfile", "onCoreInitFinished");
    }

    public final void uL() {
        x.i("MicroMsg.ToolsProfile", "onCoreInitFailed");
    }
}

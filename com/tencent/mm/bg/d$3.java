package com.tencent.mm.bg;

import com.tencent.mm.sdk.platformtools.x;

class d$3 implements b {
    final /* synthetic */ String qVb;

    d$3(String str) {
        this.qVb = str;
    }

    public final void e(Exception exception) {
        x.f("MicroMsg.PluginHelper", "start activity failed, plugin(%s) not loaded", new Object[]{this.qVb});
        x.e("MicroMsg.PluginHelper", "start activity failed,%s", new Object[]{exception});
    }
}

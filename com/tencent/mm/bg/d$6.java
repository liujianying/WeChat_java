package com.tencent.mm.bg;

import com.tencent.mm.sdk.platformtools.x;

class d$6 implements b {
    final /* synthetic */ String qVb;

    d$6(String str) {
        this.qVb = str;
    }

    public final void e(Exception exception) {
        x.e("MicroMsg.PluginHelper", "start wizard activity failed, plugin(%s) not loaded", new Object[]{this.qVb});
        x.e("MicroMsg.PluginHelper", "start wizard activity with exception:%s", new Object[]{exception});
    }
}

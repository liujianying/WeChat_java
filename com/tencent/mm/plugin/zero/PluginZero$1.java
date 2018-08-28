package com.tencent.mm.plugin.zero;

import com.tencent.mm.kernel.a.a;
import com.tencent.mm.kernel.api.g;
import com.tencent.mm.kernel.k;
import com.tencent.mm.sdk.platformtools.x;

class PluginZero$1 implements g {
    final /* synthetic */ com.tencent.mm.kernel.b.g bys;
    final /* synthetic */ PluginZero qxK;

    PluginZero$1(PluginZero pluginZero, com.tencent.mm.kernel.b.g gVar) {
        this.qxK = pluginZero;
        this.bys = gVar;
    }

    public final void vk() {
        a.j("onStartupDone", new Object[0]);
    }

    public final void aF(boolean z) {
        if (z) {
            k.j(this.bys.dsQ, true);
            k.k(this.bys.dsQ, true);
        }
        x.chR();
    }
}

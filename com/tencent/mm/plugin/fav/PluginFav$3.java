package com.tencent.mm.plugin.fav;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fav.b.c.a;

class PluginFav$3 implements Runnable {
    final /* synthetic */ PluginFav iVm;
    final /* synthetic */ a iVn;

    PluginFav$3(PluginFav pluginFav, a aVar) {
        this.iVm = pluginFav;
        this.iVn = aVar;
    }

    public final void run() {
        g.DF().a(this.iVn, 0);
    }
}

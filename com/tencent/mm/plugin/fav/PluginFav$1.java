package com.tencent.mm.plugin.fav;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fav.b.a.b;
import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.a.n;

class PluginFav$1 extends a {
    final /* synthetic */ PluginFav iVm;

    PluginFav$1(PluginFav pluginFav) {
        this.iVm = pluginFav;
    }

    public final boolean execute() {
        com.tencent.mm.plugin.fav.b.a.a aVar = new com.tencent.mm.plugin.fav.b.a.a();
        ((n) g.n(n.class)).registerIndexStorage(aVar);
        aVar.create();
        b bVar = new b();
        ((n) g.n(n.class)).registerNativeLogic(6, bVar);
        bVar.create();
        return true;
    }

    public final String getName() {
        return "InitFTSFavPluginTask";
    }
}

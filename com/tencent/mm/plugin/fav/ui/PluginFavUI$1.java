package com.tencent.mm.plugin.fav.ui;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fav.ui.b.b;
import com.tencent.mm.plugin.fav.ui.b.d;
import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.a.n;

class PluginFavUI$1 extends a {
    final /* synthetic */ PluginFavUI jbz;

    PluginFavUI$1(PluginFavUI pluginFavUI) {
        this.jbz = pluginFavUI;
    }

    public final boolean execute() {
        ((n) g.n(n.class)).registerFTSUILogic(new d());
        ((n) g.n(n.class)).registerFTSUILogic(new b());
        return true;
    }

    public final String getName() {
        return "InitFTSFavUIPluginTask";
    }
}

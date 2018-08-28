package com.tencent.mm.plugin.fav.ui;

import com.tencent.mm.kernel.a.b.b;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.fav.ui.c.a;
import com.tencent.mm.plugin.fts.a.n;

public class PluginFavUI extends f implements b, c {
    private a jbw = new a();
    private a jbx = new a();
    private l jby = new l();

    public void execute(g gVar) {
    }

    public void parallelsDependency() {
    }

    public void onAccountInitialized(e.c cVar) {
        this.jbw.cht();
        this.jbx.cht();
        this.jby.cht();
        ((n) com.tencent.mm.kernel.g.n(n.class)).getFTSTaskDaemon().a(-86016, new 1(this));
    }

    public void onAccountRelease() {
        this.jbw.dead();
        this.jbx.dead();
        this.jby.dead();
    }
}

package com.tencent.mm.plugin.topstory.ui;

import com.tencent.mm.kernel.a.b.b;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.topstory.ui.home.d;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa.a;

public class PluginTopStoryUI extends f implements b, c, a {
    private int ozm = 2;
    private c ozn;
    private d ozo;

    public void parallelsDependency() {
    }

    public void onAccountInitialized(e.c cVar) {
        this.ozo = new d();
        this.ozn = new c();
        com.tencent.mm.pluginsdk.cmd.b.a(this.ozn, "//topstory");
        if (System.currentTimeMillis() - g.Ei().DT().i(a.tad) <= 259200000) {
            x.i("MicroMsg.TopStory.PluginTopStoryUI", "Use TopStory In Three Days");
            ah.i(new 1(this), 1000);
        } else {
            x.i("MicroMsg.TopStory.PluginTopStoryUI", "Not Use TopStory In Three Days");
        }
        com.tencent.mm.sdk.f.e.post(new 2(this), "TopStory.DeleteTopStoryConversation");
    }

    public void onAccountRelease() {
        this.ozo = null;
        this.ozn = null;
        com.tencent.mm.pluginsdk.cmd.b.D("//topstory");
    }

    public void execute(com.tencent.mm.kernel.b.g gVar) {
    }

    public c getTopStoryCommand() {
        return this.ozn;
    }

    public d getWebViewMgr() {
        return this.ozo;
    }

    public int getFirstLoadWebView() {
        return this.ozm;
    }

    public void setFirstLoadWebView(int i) {
        this.ozm = i;
    }
}

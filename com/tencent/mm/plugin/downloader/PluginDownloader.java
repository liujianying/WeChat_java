package com.tencent.mm.plugin.downloader;

import com.tencent.mm.kernel.api.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.downloader.a.d;
import com.tencent.mm.plugin.downloader.b.a;
import com.tencent.mm.sdk.platformtools.x;

public class PluginDownloader extends f implements c, d {
    public void execute(g gVar) {
        x.d("MicroMsg.PluginDownloader", "execute");
        if (gVar.ES()) {
            com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.downloader.a.c.class, new a());
        }
    }

    public void onAccountInitialized(e.c cVar) {
        a.aDb();
        new Thread(new 1(this)).start();
    }

    public void onAccountRelease() {
        a.aDc();
    }
}

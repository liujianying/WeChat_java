package com.tencent.mm.plugin.boots;

import com.tencent.mm.bt.h;
import com.tencent.mm.kernel.api.bucket.a;
import com.tencent.mm.kernel.api.bucket.d;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.plugin.boots.a.c;
import com.tencent.mm.plugin.boots.a.e;
import com.tencent.mm.plugin.boots.b.b;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;

public class PluginBoots extends f implements a, d, e {
    private com.tencent.mm.plugin.boots.c.a hjr;
    private b hjs;

    public String name() {
        return "plugin-tinker";
    }

    public void installed() {
        x.d("MicroMsg.Boots.PluginBoots", "installed");
        alias(e.class);
        com.tencent.mm.pluginsdk.cmd.b.a(new a(), new String[]{"//boots"});
    }

    public void uninstalled() {
        x.d("MicroMsg.Boots.PluginBoots", "uninstalled");
        super.uninstalled();
        com.tencent.mm.pluginsdk.cmd.b.D(new String[]{"//boots"});
    }

    public void dependency() {
        x.d("MicroMsg.Boots.PluginBoots", "dependency");
        dependsOn(com.tencent.mm.plugin.comm.a.a.class);
    }

    public void configure(g gVar) {
        super.configure(gVar);
    }

    public void execute(g gVar) {
        x.d("MicroMsg.Boots.PluginBoots", "execute");
        if (gVar.ES()) {
            com.tencent.mm.kernel.g.a(c.class, new com.tencent.mm.kernel.c.e(new b()));
        }
    }

    public HashMap<Integer, h.d> collectDatabaseFactory() {
        HashMap<Integer, h.d> hashMap = new HashMap();
        hashMap.put(Integer.valueOf("ACTIVE_TABLE".hashCode()), new 1(this));
        return hashMap;
    }

    public void onDataBaseOpened(h hVar, h hVar2) {
        com.tencent.mm.plugin.boots.c.a.a aVar = new com.tencent.mm.plugin.boots.c.a.a(hVar);
        if (com.tencent.mm.plugin.boots.c.a.hjJ == null) {
            com.tencent.mm.plugin.boots.c.a.hjJ = new com.tencent.mm.plugin.boots.c.a(aVar);
        }
        this.hjr = com.tencent.mm.plugin.boots.c.a.hjJ;
        if (b.hjC == null) {
            b.hjC = new b();
        }
        this.hjs = b.hjC;
        b bVar = this.hjs;
        com.tencent.mm.plugin.downloader.model.d.aCU();
        com.tencent.mm.plugin.downloader.model.b.a(bVar.hjE);
    }

    public void onDataBaseClosed(h hVar, h hVar2) {
        if (this.hjs != null) {
            b bVar = this.hjs;
            com.tencent.mm.plugin.downloader.model.d.aCU();
            com.tencent.mm.plugin.downloader.model.b.b(bVar.hjE);
        }
    }

    public com.tencent.mm.plugin.boots.a.f getTinkerLogic() {
        return this.hjr;
    }

    public com.tencent.mm.plugin.boots.a.d getLuggageLogic() {
        return this.hjs;
    }
}

package com.tencent.mm.plugin.music;

import com.tencent.mm.an.a.b;
import com.tencent.mm.an.a.c;
import com.tencent.mm.an.e;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.model.p;
import com.tencent.mm.plugin.music.a.a;
import com.tencent.mm.plugin.music.a.d;
import com.tencent.mm.plugin.music.model.h;
import com.tencent.mm.sdk.platformtools.x;

public class PluginMusic extends f implements c {
    private a lwy = new a();

    public void installed() {
        alias(c.class);
    }

    public String name() {
        return "plugin-music";
    }

    public void configure(g gVar) {
        if (gVar.ES()) {
            x.i("MicroMsg.Music.PluginMusic", "PluginMusic configure SubCoreMusic");
            pin(new p(h.class));
            com.tencent.mm.kernel.g.Ek();
            com.tencent.mm.kernel.g.a(b.class, new e());
            com.tencent.mm.kernel.g.Ek();
            com.tencent.mm.kernel.g.a(com.tencent.mm.an.a.a.class, new a());
        }
        d.bhe();
        this.lwy.cht();
    }

    public void execute(g gVar) {
        if (gVar.ES()) {
            x.i("MicroMsg.Music.PluginMusic", "PluginMusic execute");
            com.tencent.mm.bg.c.Um("music");
        }
    }

    public void uninstalled() {
        super.uninstalled();
        this.lwy.dead();
        d bhf = d.bhf();
        x.i("MicroMsg.Audio.AudioPlayerMgr", "release, clear all cache");
        bhf.bhg();
    }
}

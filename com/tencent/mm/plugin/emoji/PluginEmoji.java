package com.tencent.mm.plugin.emoji;

import com.tencent.mm.api.o;
import com.tencent.mm.br.b;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.plugin.comm.a.a;
import com.tencent.mm.plugin.emoji.b.c;
import com.tencent.mm.pluginsdk.a.d;
import com.tencent.mm.pluginsdk.a.e;
import com.tencent.mm.pluginsdk.f.h;

public class PluginEmoji extends f implements c {
    private d icP;
    e icQ;

    public String name() {
        return "plugin-emoji";
    }

    public void installed() {
        alias(c.class);
    }

    public void dependency() {
        dependsOn(a.class);
    }

    public void configure(g gVar) {
        com.tencent.mm.pluginsdk.ui.d.d.a.a(com.tencent.mm.br.g.cjL());
        b.cjC();
        h.ccd();
    }

    public void execute(g gVar) {
        if (gVar.ES()) {
            pin(d.aDh());
            if (gVar.ES()) {
                com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.emoji.b.a.class, new com.tencent.mm.kernel.c.e(new a()));
            }
        }
        com.tencent.mm.ui.e.b.c.a(new 1(this));
        com.tencent.mm.ui.e.c.b.a(new 2(this));
        o.bxf = new 3(this);
    }

    public void setEmojiMgr() {
        if (this.icP == null) {
            this.icP = com.tencent.mm.plugin.emoji.b.b.a.ieJ.aDG();
        }
    }

    public void removeEmojiMgr() {
        this.icP = null;
    }

    public d getEmojiMgr() {
        setEmojiMgr();
        return this.icP;
    }

    public e getProvider() {
        if (this.icQ == null) {
            this.icQ = new com.tencent.mm.bo.a();
        }
        return this.icQ;
    }
}

package com.tencent.mm.plugin.talkroom;

import com.tencent.mm.g.a.rp;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

class Plugin$c extends c<rp> {
    final /* synthetic */ Plugin ovt;

    private Plugin$c(Plugin plugin) {
        this.ovt = plugin;
        this.sFo = rp.class.getName().hashCode();
    }

    /* synthetic */ Plugin$c(Plugin plugin, byte b) {
        this(plugin);
        this.sFo = rp.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        if (!(((rp) bVar) instanceof rp)) {
            x.f("MicroMsg.TalkRoom.Plugin", "mismatch %s", new Object[]{((rp) bVar).getClass().getName()});
        }
        return false;
    }
}

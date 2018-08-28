package com.tencent.mm.plugin.talkroom;

import com.tencent.mm.g.a.rm;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

class Plugin$a extends c<rm> {
    final /* synthetic */ Plugin ovt;

    private Plugin$a(Plugin plugin) {
        this.ovt = plugin;
        this.sFo = rm.class.getName().hashCode();
    }

    /* synthetic */ Plugin$a(Plugin plugin, byte b) {
        this(plugin);
        this.sFo = rm.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        rm rmVar = (rm) bVar;
        if (!(rmVar instanceof rm)) {
            x.f("MicroMsg.TalkRoomReportMgrListener", "mismatch %s", rmVar.getClass().getName());
        } else if (rmVar.ccl.ccm) {
            com.tencent.mm.plugin.talkroom.model.b.bGW().owy = 1;
            return true;
        }
        return false;
    }
}

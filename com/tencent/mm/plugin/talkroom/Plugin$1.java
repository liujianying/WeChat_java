package com.tencent.mm.plugin.talkroom;

import com.tencent.mm.g.a.ja;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;

class Plugin$1 extends c<ja> {
    final /* synthetic */ Plugin ovt;

    Plugin$1(Plugin plugin) {
        this.ovt = plugin;
        this.sFo = ja.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        switch (((ja) bVar).bSG.status) {
            case 0:
                if (com.tencent.mm.plugin.talkroom.model.b.bGT() != null) {
                    com.tencent.mm.plugin.talkroom.model.b.bGT().aZL();
                    break;
                }
                break;
        }
        return false;
    }
}

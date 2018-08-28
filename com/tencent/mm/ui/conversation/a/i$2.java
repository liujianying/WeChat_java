package com.tencent.mm.ui.conversation.a;

import com.tencent.mm.g.a.cm;
import com.tencent.mm.k.g;
import com.tencent.mm.platformtools.ai;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

class i$2 extends c<cm> {
    final /* synthetic */ i usk;

    i$2(i iVar) {
        this.usk = iVar;
        this.sFo = cm.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        x.i("MicroMsg.InviteFriendBanner", "dynamic config file change");
        this.usk.csE = ai.getInt(g.AT().getValue("InviteFriendsControlFlags"), 0);
        if ((this.usk.csE & 1) > 0) {
            this.usk.usj.post(new Runnable() {
                public final void run() {
                    i$2.this.usk.usj.setVisibility(0);
                    i$2.this.usk.usj.setPadding(0, 0, 0, 0);
                }
            });
        }
        return true;
    }
}

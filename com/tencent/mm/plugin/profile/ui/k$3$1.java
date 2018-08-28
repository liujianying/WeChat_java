package com.tencent.mm.plugin.profile.ui;

import com.tencent.mm.g.a.ap;
import com.tencent.mm.model.am.a;
import com.tencent.mm.plugin.profile.ui.k.3;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class k$3$1 implements Runnable {
    final /* synthetic */ ap lWy;
    final /* synthetic */ 3 lWz;

    k$3$1(3 3, ap apVar) {
        this.lWz = 3;
        this.lWy = apVar;
    }

    public final void run() {
        String str = this.lWy.bHX.bHY;
        this.lWz.lWx.bOb.getIntent().putExtra("inviteer", str);
        String gT = this.lWz.lWx.gT(this.lWy.bHX.bHY);
        x.i("MicroMsg.ContactWidgetNormal", "[ChatroomMemberInviteerUpdatedEvent callback] inviteer:%s inviteerDisplayName:%s", new Object[]{str, gT});
        if (bi.oW(gT)) {
            a.dBr.a(str, "", new 1(this, str));
        } else {
            this.lWz.lWx.ee(str, gT);
        }
    }
}

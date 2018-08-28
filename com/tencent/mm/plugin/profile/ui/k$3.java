package com.tencent.mm.plugin.profile.ui;

import com.tencent.mm.g.a.ap;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class k$3 extends c<ap> {
    final /* synthetic */ k lWx;

    k$3(k kVar) {
        this.lWx = kVar;
        this.sFo = ap.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        ap apVar = (ap) bVar;
        x.i("MicroMsg.ContactWidgetNormal", "[ChatroomMemberInviteerUpdatedEvent callback] username:%s inviteer:%s", new Object[]{apVar.bHX.username, apVar.bHX.bHY});
        if (!(bi.oW(apVar.bHX.username) || !apVar.bHX.username.equals(this.lWx.guS.field_username) || bi.oW(apVar.bHX.bHY))) {
            ah.A(new 1(this, apVar));
        }
        return false;
    }
}

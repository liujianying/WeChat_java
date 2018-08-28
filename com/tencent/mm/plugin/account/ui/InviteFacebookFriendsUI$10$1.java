package com.tencent.mm.plugin.account.ui;

import android.os.Bundle;
import com.tencent.mm.aq.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.friend.a.p;
import com.tencent.mm.plugin.account.ui.InviteFacebookFriendsUI.10;
import com.tencent.mm.plugin.account.ui.q.e;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.f.a.b;
import com.tencent.mm.ui.f.a.c.a;
import com.tencent.mm.ui.f.a.d;
import java.util.ArrayList;
import java.util.List;

class InviteFacebookFriendsUI$10$1 implements a {
    final /* synthetic */ long[] eQC;
    final /* synthetic */ 10 eQD;

    InviteFacebookFriendsUI$10$1(10 10, long[] jArr) {
        this.eQD = 10;
        this.eQC = jArr;
    }

    public final void a(d dVar) {
        x.e("MicroMsg.InviteFacebookFriendsUI", "fbinvite error");
    }

    public final void a(b bVar) {
        x.e("MicroMsg.InviteFacebookFriendsUI", "fbinvite error");
    }

    public final void m(Bundle bundle) {
        x.i("MicroMsg.InviteFacebookFriendsUI", "fbinvite oncomplete");
        List arrayList = new ArrayList();
        arrayList.add(new h.a(33, Integer.toString(this.eQC.length)));
        ((i) g.l(i.class)).FQ().b(new h(arrayList));
        for (long j : this.eQC) {
            p pVar = new p();
            pVar.username = Long.toString(j);
            pVar.eKy = 5;
            pVar.dLB = (int) bi.VE();
            com.tencent.mm.plugin.account.b.getInviteFriendOpenStg().a(pVar);
        }
        com.tencent.mm.ui.base.h.a(this.eQD.eQB, e.facebook_invitefriends_tips_invitemore, e.app_tip, e.app_yes, e.app_no, new 1(this), new 2(this));
    }

    public final void onCancel() {
        x.e("MicroMsg.InviteFacebookFriendsUI", "fbinvite cancle");
    }
}

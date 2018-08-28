package com.tencent.mm.plugin.account.friend.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.g.a.mc;
import com.tencent.mm.sdk.b.a;

class InviteFriendUI$2 implements OnClickListener {
    final /* synthetic */ InviteFriendUI eMv;

    InviteFriendUI$2(InviteFriendUI inviteFriendUI) {
        this.eMv = inviteFriendUI;
    }

    public final void onClick(View view) {
        mc mcVar = new mc();
        mcVar.bWF.opType = 0;
        mcVar.bWF.bWH = InviteFriendUI.b(this.eMv) + "@qqim";
        mcVar.bWF.bWI = InviteFriendUI.f(this.eMv);
        a.sFg.m(mcVar);
        if (mcVar.bWG.bJm) {
            com.tencent.mm.plugin.account.a.a.ezn.e(new Intent().putExtra("Chat_User", InviteFriendUI.b(this.eMv) + "@qqim"), this.eMv);
        }
        this.eMv.finish();
    }
}

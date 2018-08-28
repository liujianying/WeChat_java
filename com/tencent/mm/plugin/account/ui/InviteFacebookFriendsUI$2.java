package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;

class InviteFacebookFriendsUI$2 implements OnClickListener {
    final /* synthetic */ InviteFacebookFriendsUI eQB;

    InviteFacebookFriendsUI$2(InviteFacebookFriendsUI inviteFacebookFriendsUI) {
        this.eQB = inviteFacebookFriendsUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        Intent intent = new Intent(this.eQB.mController.tml, FacebookAuthUI.class);
        intent.putExtra("is_force_unbind", true);
        this.eQB.mController.tml.startActivity(intent);
        this.eQB.finish();
    }
}

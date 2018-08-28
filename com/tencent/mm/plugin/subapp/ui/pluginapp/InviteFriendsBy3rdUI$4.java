package com.tencent.mm.plugin.subapp.ui.pluginapp;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.bg.d;

class InviteFriendsBy3rdUI$4 implements OnClickListener {
    final /* synthetic */ InviteFriendsBy3rdUI otN;

    InviteFriendsBy3rdUI$4(InviteFriendsBy3rdUI inviteFriendsBy3rdUI) {
        this.otN = inviteFriendsBy3rdUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        d.b(this.otN.mController.tml, "account", ".ui.FacebookAuthUI", new Intent());
    }
}

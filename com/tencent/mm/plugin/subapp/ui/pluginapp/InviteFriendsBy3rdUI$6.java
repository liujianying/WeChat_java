package com.tencent.mm.plugin.subapp.ui.pluginapp;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.support.v7.app.ActionBarActivity;
import com.tencent.mm.R;
import com.tencent.mm.ui.base.h;

class InviteFriendsBy3rdUI$6 implements OnClickListener {
    final /* synthetic */ InviteFriendsBy3rdUI otN;

    InviteFriendsBy3rdUI$6(InviteFriendsBy3rdUI inviteFriendsBy3rdUI) {
        this.otN = inviteFriendsBy3rdUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        InviteFriendsBy3rdUI inviteFriendsBy3rdUI = this.otN;
        ActionBarActivity actionBarActivity = this.otN.mController.tml;
        this.otN.mController.tml.getString(R.l.app_tip);
        InviteFriendsBy3rdUI.a(inviteFriendsBy3rdUI, h.a(actionBarActivity, this.otN.mController.tml.getString(R.l.twitter_loading), true, new 1(this)));
        InviteFriendsBy3rdUI.a(this.otN).a(this.otN, this.otN.mController.tml);
    }
}

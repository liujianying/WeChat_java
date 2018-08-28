package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;

class FacebookFriendUI$4 implements OnClickListener {
    final /* synthetic */ FacebookFriendUI eQm;

    FacebookFriendUI$4(FacebookFriendUI facebookFriendUI) {
        this.eQm = facebookFriendUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        Intent intent = new Intent(this.eQm.mController.tml, FacebookAuthUI.class);
        intent.putExtra("is_force_unbind", true);
        this.eQm.mController.tml.startActivity(intent);
        this.eQm.finish();
    }
}

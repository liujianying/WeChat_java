package com.tencent.mm.plugin.account.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

class FacebookFriendUI$12 implements OnClickListener {
    final /* synthetic */ FacebookFriendUI eQm;

    FacebookFriendUI$12(FacebookFriendUI facebookFriendUI) {
        this.eQm = facebookFriendUI;
    }

    public final void onClick(View view) {
        this.eQm.startActivity(new Intent(this.eQm, FacebookAuthUI.class));
    }
}

package com.tencent.mm.plugin.account.ui;

import android.os.Bundle;
import com.tencent.mm.plugin.account.model.h;

class FacebookFriendUI$8 extends h {
    final /* synthetic */ FacebookFriendUI eQm;

    FacebookFriendUI$8(FacebookFriendUI facebookFriendUI) {
        this.eQm = facebookFriendUI;
    }

    public final void m(Bundle bundle) {
        super.m(bundle);
    }

    public final void onError(int i, String str) {
        super.onError(i, str);
        if (i == 3) {
            FacebookFriendUI.f(this.eQm);
        }
    }
}

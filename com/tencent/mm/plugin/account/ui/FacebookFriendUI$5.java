package com.tencent.mm.plugin.account.ui;

import android.widget.TextView;
import com.tencent.mm.model.q;
import com.tencent.mm.ui.r.a;

class FacebookFriendUI$5 implements a {
    final /* synthetic */ FacebookFriendUI eQm;
    final /* synthetic */ TextView eQn;

    FacebookFriendUI$5(FacebookFriendUI facebookFriendUI, TextView textView) {
        this.eQm = facebookFriendUI;
        this.eQn = textView;
    }

    public final void Xb() {
        if (q.Hg() && FacebookFriendUI.a(this.eQm)) {
            if (FacebookFriendUI.b(this.eQm).getCount() == 0) {
                this.eQn.setVisibility(0);
            } else {
                this.eQn.setVisibility(8);
            }
        }
        FacebookFriendUI.c(this.eQm);
    }

    public final void Xa() {
    }
}

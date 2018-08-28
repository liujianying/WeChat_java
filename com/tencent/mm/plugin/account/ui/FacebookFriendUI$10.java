package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.friend.a.ab;
import com.tencent.mm.sdk.platformtools.al;

class FacebookFriendUI$10 implements OnCancelListener {
    final /* synthetic */ FacebookFriendUI eQm;
    final /* synthetic */ ab eQo;
    final /* synthetic */ al eQp;

    FacebookFriendUI$10(FacebookFriendUI facebookFriendUI, al alVar, ab abVar) {
        this.eQm = facebookFriendUI;
        this.eQp = alVar;
        this.eQo = abVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        this.eQp.SO();
        g.DF().c(this.eQo);
    }
}

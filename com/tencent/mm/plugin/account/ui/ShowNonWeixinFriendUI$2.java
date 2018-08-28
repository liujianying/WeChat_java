package com.tencent.mm.plugin.account.ui;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.account.a.j;
import com.tencent.mm.ui.f.a.c;

class ShowNonWeixinFriendUI$2 implements OnClickListener {
    final /* synthetic */ ShowNonWeixinFriendUI eXk;

    ShowNonWeixinFriendUI$2(ShowNonWeixinFriendUI showNonWeixinFriendUI) {
        this.eXk = showNonWeixinFriendUI;
    }

    public final void onClick(View view) {
        c cVar = new c("290293790992170");
        Bundle bundle = new Bundle();
        bundle.putString("message", this.eXk.getString(j.facebook_invite_message));
        bundle.putString("to", Long.toString(ShowNonWeixinFriendUI.a(this.eXk)));
        cVar.a(this.eXk, "apprequests", bundle, new 1(this));
    }
}

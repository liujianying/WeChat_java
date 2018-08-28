package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.account.ui.FacebookFriendUI;

class h$1 implements OnClickListener {
    final /* synthetic */ h usi;

    h$1(h hVar) {
        this.usi = hVar;
    }

    public final void onClick(View view) {
        au.HU();
        c.DT().set(65833, Integer.valueOf(0));
        ((Context) this.usi.qJS.get()).startActivity(new Intent((Context) this.usi.qJS.get(), FacebookFriendUI.class));
        this.usi.view.setVisibility(8);
    }
}

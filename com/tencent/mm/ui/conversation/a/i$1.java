package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.bg.d;
import com.tencent.mm.plugin.report.service.h;

class i$1 implements OnClickListener {
    final /* synthetic */ i usk;
    final /* synthetic */ Context val$context;

    i$1(i iVar, Context context) {
        this.usk = iVar;
        this.val$context = context;
    }

    public final void onClick(View view) {
        Intent intent = new Intent();
        intent.putExtra("Invite_friends", 1);
        d.b(this.val$context, "subapp", ".ui.pluginapp.InviteFriendsBy3rdUI", intent);
        h.mEJ.h(14034, new Object[]{Integer.valueOf(1)});
    }
}

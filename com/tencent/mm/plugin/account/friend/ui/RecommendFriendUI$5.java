package com.tencent.mm.plugin.account.friend.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.friend.a.aa;

class RecommendFriendUI$5 implements OnCancelListener {
    final /* synthetic */ RecommendFriendUI eNc;
    final /* synthetic */ aa eNe;

    RecommendFriendUI$5(RecommendFriendUI recommendFriendUI, aa aaVar) {
        this.eNc = recommendFriendUI;
        this.eNe = aaVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        g.DF().c(this.eNe);
        this.eNc.finish();
    }
}

package com.tencent.mm.plugin.account.bind.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.kernel.g;

class GoogleFriendUI$5 implements OnCancelListener {
    final /* synthetic */ GoogleFriendUI eIi;

    GoogleFriendUI$5(GoogleFriendUI googleFriendUI) {
        this.eIi = googleFriendUI;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        GoogleFriendUI.c(this.eIi);
        g.DF().c(GoogleFriendUI.d(this.eIi));
    }
}

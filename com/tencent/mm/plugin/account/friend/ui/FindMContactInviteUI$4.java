package com.tencent.mm.plugin.account.friend.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class FindMContactInviteUI$4 implements OnClickListener {
    final /* synthetic */ FindMContactInviteUI eLY;

    FindMContactInviteUI$4(FindMContactInviteUI findMContactInviteUI) {
        this.eLY = findMContactInviteUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        FindMContactInviteUI.n(this.eLY);
        this.eLY.finish();
    }
}

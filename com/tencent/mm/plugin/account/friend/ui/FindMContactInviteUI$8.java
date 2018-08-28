package com.tencent.mm.plugin.account.friend.ui;

import android.view.View;
import android.view.View.OnClickListener;

class FindMContactInviteUI$8 implements OnClickListener {
    final /* synthetic */ FindMContactInviteUI eLY;

    FindMContactInviteUI$8(FindMContactInviteUI findMContactInviteUI) {
        this.eLY = findMContactInviteUI;
    }

    public final void onClick(View view) {
        FindMContactInviteUI.e(this.eLY).setVisibility(0);
        FindMContactInviteUI.f(this.eLY).setVisibility(8);
        FindMContactInviteUI.b(this.eLY).ci(false);
        FindMContactInviteUI.b(this.eLY).notifyDataSetChanged();
    }
}

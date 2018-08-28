package com.tencent.mm.plugin.pwdgroup.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class FacingCreateChatRoomAllInOneUI$12 implements OnMenuItemClickListener {
    final /* synthetic */ FacingCreateChatRoomAllInOneUI mam;

    FacingCreateChatRoomAllInOneUI$12(FacingCreateChatRoomAllInOneUI facingCreateChatRoomAllInOneUI) {
        this.mam = facingCreateChatRoomAllInOneUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.mam.finish();
        return false;
    }
}

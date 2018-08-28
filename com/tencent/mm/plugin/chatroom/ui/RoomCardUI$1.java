package com.tencent.mm.plugin.chatroom.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.R;

class RoomCardUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ RoomCardUI hNw;

    RoomCardUI$1(RoomCardUI roomCardUI) {
        this.hNw = roomCardUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        if (menuItem.getTitle().equals(this.hNw.getString(R.l.app_finish))) {
            RoomCardUI.a(this.hNw);
        }
        RoomCardUI.b(this.hNw).setEnabled(true);
        RoomCardUI.b(this.hNw).setFocusableInTouchMode(true);
        RoomCardUI.b(this.hNw).setFocusable(true);
        RoomCardUI.b(this.hNw).setCursorVisible(true);
        this.hNw.updateOptionMenuText(0, this.hNw.getString(R.l.app_finish));
        this.hNw.enableOptionMenu(false);
        this.hNw.showVKB();
        RoomCardUI.b(this.hNw).setSelection(RoomCardUI.b(this.hNw).getText().toString().length());
        return true;
    }
}

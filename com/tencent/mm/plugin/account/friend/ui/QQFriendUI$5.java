package com.tencent.mm.plugin.account.friend.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class QQFriendUI$5 implements OnMenuItemClickListener {
    final /* synthetic */ QQFriendUI eMV;

    QQFriendUI$5(QQFriendUI qQFriendUI) {
        this.eMV = qQFriendUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.eMV.YC();
        this.eMV.finish();
        return true;
    }
}

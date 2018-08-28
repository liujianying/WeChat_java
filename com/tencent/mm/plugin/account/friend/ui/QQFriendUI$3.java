package com.tencent.mm.plugin.account.friend.ui;

import com.tencent.mm.plugin.account.friend.ui.d.a;

class QQFriendUI$3 implements a {
    final /* synthetic */ QQFriendUI eMV;

    QQFriendUI$3(QQFriendUI qQFriendUI) {
        this.eMV = qQFriendUI;
    }

    public final void ja(int i) {
        if (QQFriendUI.a(this.eMV)) {
            if (i > 0) {
                QQFriendUI.b(this.eMV).setVisibility(8);
            } else {
                QQFriendUI.b(this.eMV).setVisibility(0);
            }
        }
        QQFriendUI.a(this.eMV, false);
    }
}

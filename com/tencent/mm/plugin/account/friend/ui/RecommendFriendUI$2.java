package com.tencent.mm.plugin.account.friend.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.plugin.account.a$h;
import com.tencent.mm.plugin.account.a.j;
import com.tencent.mm.ui.base.h;

class RecommendFriendUI$2 implements OnMenuItemClickListener {
    final /* synthetic */ RecommendFriendUI eNc;

    RecommendFriendUI$2(RecommendFriendUI recommendFriendUI) {
        this.eNc = recommendFriendUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        int length = RecommendFriendUI.b(this.eNc).Ye().length;
        h.a(this.eNc.mController.tml, this.eNc.mController.tml.getResources().getQuantityString(a$h.inviteqqfriends_invite_tips, length, new Object[]{Integer.valueOf(length)}), this.eNc.getString(j.app_tip), new 1(this), new 2(this));
        return true;
    }
}

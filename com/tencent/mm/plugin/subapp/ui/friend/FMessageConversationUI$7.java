package com.tencent.mm.plugin.subapp.ui.friend;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.plugin.subapp.ui.pluginapp.AddMoreFriendsUI;

class FMessageConversationUI$7 implements OnMenuItemClickListener {
    final /* synthetic */ FMessageConversationUI ose;

    FMessageConversationUI$7(FMessageConversationUI fMessageConversationUI) {
        this.ose = fMessageConversationUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        Intent intent = new Intent(this.ose, AddMoreFriendsUI.class);
        intent.putExtra("invite_friend_scene", 3);
        this.ose.startActivity(intent);
        return true;
    }
}

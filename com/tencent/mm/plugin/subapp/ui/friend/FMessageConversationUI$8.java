package com.tencent.mm.plugin.subapp.ui.friend;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class FMessageConversationUI$8 implements OnMenuItemClickListener {
    final /* synthetic */ FMessageConversationUI ose;

    FMessageConversationUI$8(FMessageConversationUI fMessageConversationUI) {
        this.ose = fMessageConversationUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.ose.finish();
        return true;
    }
}

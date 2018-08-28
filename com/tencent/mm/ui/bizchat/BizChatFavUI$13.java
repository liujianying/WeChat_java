package com.tencent.mm.ui.bizchat;

import android.view.MenuItem;
import com.tencent.mm.ui.base.n$d;

class BizChatFavUI$13 implements n$d {
    final /* synthetic */ BizChatFavUI tEG;

    BizChatFavUI$13(BizChatFavUI bizChatFavUI) {
        this.tEG = bizChatFavUI;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        switch (menuItem.getItemId()) {
            case 0:
                BizChatFavUI.a(this.tEG, BizChatFavUI.f(this.tEG));
                return;
            default:
                return;
        }
    }
}

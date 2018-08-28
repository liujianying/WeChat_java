package com.tencent.mm.ui.bizchat;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class BizChatroomInfoUI$8 implements OnMenuItemClickListener {
    final /* synthetic */ BizChatroomInfoUI tFD;

    BizChatroomInfoUI$8(BizChatroomInfoUI bizChatroomInfoUI) {
        this.tFD = bizChatroomInfoUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.tFD.finish();
        return true;
    }
}

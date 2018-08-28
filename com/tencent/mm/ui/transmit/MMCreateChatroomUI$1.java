package com.tencent.mm.ui.transmit;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.plugin.fts.ui.k;
import com.tencent.mm.sdk.platformtools.x;

class MMCreateChatroomUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ MMCreateChatroomUI uDk;

    MMCreateChatroomUI$1(MMCreateChatroomUI mMCreateChatroomUI) {
        this.uDk = mMCreateChatroomUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        if (!MMCreateChatroomUI.a(this.uDk)) {
            MMCreateChatroomUI.a(this.uDk, true);
            MMCreateChatroomUI.b(this.uDk);
            if (MMCreateChatroomUI.c(this.uDk) == 3) {
                MMCreateChatroomUI.d(this.uDk);
                k.fh(true);
            }
        }
        x.i("MicroMsg.MMCreateChatroomUI", "Create the chatroom");
        return true;
    }
}

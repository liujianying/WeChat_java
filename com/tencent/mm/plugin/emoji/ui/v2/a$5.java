package com.tencent.mm.plugin.emoji.ui.v2;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.plugin.emoji.ui.EmojiMineUI;

class a$5 implements OnMenuItemClickListener {
    final /* synthetic */ a ioY;

    a$5(a aVar) {
        this.ioY = aVar;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        Intent intent = new Intent();
        intent.setClass(this.ioY.thisActivity(), EmojiMineUI.class);
        this.ioY.startActivity(intent);
        return false;
    }
}

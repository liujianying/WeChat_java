package com.tencent.mm.plugin.emoji.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class AppMsgEmojiDownloadUI$2 implements OnMenuItemClickListener {
    final /* synthetic */ AppMsgEmojiDownloadUI ikb;

    AppMsgEmojiDownloadUI$2(AppMsgEmojiDownloadUI appMsgEmojiDownloadUI) {
        this.ikb = appMsgEmojiDownloadUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.ikb.finish();
        return true;
    }
}

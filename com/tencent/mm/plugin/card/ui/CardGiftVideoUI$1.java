package com.tencent.mm.plugin.card.ui;

import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import com.tencent.mm.plugin.card.a.g;

class CardGiftVideoUI$1 implements OnCreateContextMenuListener {
    final /* synthetic */ CardGiftVideoUI hEs;

    CardGiftVideoUI$1(CardGiftVideoUI cardGiftVideoUI) {
        this.hEs = cardGiftVideoUI;
    }

    public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        contextMenu.add(0, 0, 0, this.hEs.getString(g.card_long_click_menu_save_video));
    }
}

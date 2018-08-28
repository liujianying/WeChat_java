package com.tencent.mm.ui.chatting.g;

import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import com.tencent.mm.R;
import com.tencent.mm.ui.chatting.g.f.2;

class f$2$1 implements OnCreateContextMenuListener {
    final /* synthetic */ 2 tYC;

    f$2$1(2 2) {
        this.tYC = 2;
    }

    public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        contextMenu.add(0, 0, 0, view.getContext().getString(R.l.retransmits));
        contextMenu.add(0, 1, 0, view.getContext().getString(R.l.chatting_fav));
        contextMenu.add(0, 2, 0, view.getContext().getString(R.l.chatting_long_click_menu_delete_msg));
    }
}

package com.tencent.mm.ui.chatting;

import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import com.tencent.mm.R;
import com.tencent.mm.ui.chatting.m.4;

class m$4$7 implements OnCreateContextMenuListener {
    final /* synthetic */ 4 tIT;

    m$4$7(4 4) {
        this.tIT = 4;
    }

    public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        contextMenu.add(0, 0, 0, R.l.multi_select_send_normal);
        contextMenu.add(0, 1, 1, R.l.multi_select_send_record);
    }
}

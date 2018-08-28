package com.tencent.mm.ui.chatting;

import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import com.tencent.mm.R;

class TextPreviewUI$8 implements OnCreateContextMenuListener {
    final /* synthetic */ TextPreviewUI tNo;

    TextPreviewUI$8(TextPreviewUI textPreviewUI) {
        this.tNo = textPreviewUI;
    }

    public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        contextMenu.clear();
        contextMenu.add(0, 0, 0, this.tNo.getResources().getString(R.l.app_copy));
        contextMenu.add(1, 1, 0, this.tNo.getResources().getString(R.l.menu_select_all));
        contextMenu.add(1, 2, 0, this.tNo.getResources().getString(R.l.menu_retransmits));
    }
}

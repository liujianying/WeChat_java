package com.tencent.mm.ui.chatting.b;

import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import com.tencent.mm.R;

class ab$3 implements OnCreateContextMenuListener {
    final /* synthetic */ ab tRg;

    ab$3(ab abVar) {
        this.tRg = abVar;
    }

    public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        contextMenu.add(0, 0, 0, view.getContext().getString(R.l.room_delete_member_remove_this_member));
        contextMenu.add(0, 1, 1, view.getContext().getString(R.l.room_delete_member_cancel_qrcode));
    }
}

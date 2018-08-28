package com.tencent.mm.plugin.record.ui.b;

import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import com.tencent.mm.R;
import com.tencent.mm.plugin.record.ui.b.d.1;

class d$1$1 implements OnCreateContextMenuListener {
    final /* synthetic */ 1 mtJ;

    d$1$1(1 1) {
        this.mtJ = 1;
    }

    public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        contextMenu.add(this.mtJ.mtI.context.getString(R.l.app_copy));
    }
}

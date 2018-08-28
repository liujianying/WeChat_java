package com.tencent.mm.pluginsdk.ui.d;

import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import java.util.List;

class l$3 implements OnCreateContextMenuListener {
    final /* synthetic */ List qQf;

    public l$3(List list) {
        this.qQf = list;
    }

    public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        for (String add : this.qQf) {
            contextMenu.add(0, 0, 0, add);
        }
    }
}

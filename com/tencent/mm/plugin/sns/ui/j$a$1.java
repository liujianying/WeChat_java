package com.tencent.mm.plugin.sns.ui;

import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.ui.j.a;

class j$a$1 implements OnCreateContextMenuListener {
    final /* synthetic */ a nMj;

    j$a$1(a aVar) {
        this.nMj = aVar;
    }

    public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        contextMenu.add(0, 0, 0, j.c(this.nMj.nMb).getString(j.app_copy));
        contextMenu.add(1, 1, 0, j.c(this.nMj.nMb).getString(j.app_delete));
    }
}

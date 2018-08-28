package com.tencent.mm.plugin.brandservice.ui;

import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import com.tencent.mm.plugin.brandservice.b.h;
import com.tencent.mm.plugin.brandservice.ui.EnterpriseBizContactListView.a;

class EnterpriseBizContactListView$a$1 implements OnCreateContextMenuListener {
    final /* synthetic */ int hW;
    final /* synthetic */ a hpx;

    EnterpriseBizContactListView$a$1(a aVar, int i) {
        this.hpx = aVar;
        this.hW = i;
    }

    public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        contextMenu.add(this.hW, 1, 0, h.enterprise_longclick_disable_sub);
    }
}

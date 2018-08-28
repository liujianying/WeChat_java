package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import com.tencent.mm.R;

class i$1 implements OnCreateContextMenuListener {
    final /* synthetic */ i jGV;

    i$1(i iVar) {
        this.jGV = iVar;
    }

    public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        contextMenu.add(0, 1, 0, this.jGV.jGT.getString(R.l.app_field_mmsight));
        contextMenu.add(0, 2, 1, this.jGV.jGT.getString(R.l.app_field_select_new_pic));
    }
}

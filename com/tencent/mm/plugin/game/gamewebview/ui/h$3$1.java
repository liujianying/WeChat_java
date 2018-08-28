package com.tencent.mm.plugin.game.gamewebview.ui;

import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import com.tencent.mm.plugin.game.gamewebview.ui.h.3;
import com.tencent.mm.sdk.platformtools.x;

class h$3$1 implements OnCreateContextMenuListener {
    final /* synthetic */ 3 jKn;

    h$3$1(3 3) {
        this.jKn = 3;
    }

    public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        if (this.jKn.jKm.gcV != null) {
            x.d("MicroMsg.GameWebViewMenuListHelper", "show webkit menu");
            this.jKn.jKm.b(contextMenu, this.jKn.jKm.gcV);
            this.jKn.jKm.gcV = null;
        } else if (this.jKn.jKm.gcW != null) {
            x.d("MicroMsg.GameWebViewMenuListHelper", "show IX5 menu");
            this.jKn.jKm.a(contextMenu, this.jKn.jKm.gcW);
            this.jKn.jKm.gcW = null;
        }
    }
}

package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import com.tencent.mm.R;

class g$115 implements OnCreateContextMenuListener {
    final /* synthetic */ g qiK;

    g$115(g gVar) {
        this.qiK = gVar;
    }

    public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        contextMenu.add(0, 1, 0, g.j(this.qiK).getString(R.l.scan_entry_id_card_for_pay_auth));
        contextMenu.add(0, 2, 1, g.j(this.qiK).getString(R.l.scan_choose_from_album));
    }
}

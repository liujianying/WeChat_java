package com.tencent.mm.plugin.readerapp.ui;

import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import com.tencent.mm.bg.d;
import com.tencent.mm.plugin.readerapp.a;
import com.tencent.mm.plugin.readerapp.a.g;

class ReaderAppUI$1 implements OnCreateContextMenuListener {
    final /* synthetic */ boolean mnP;
    final /* synthetic */ ReaderAppUI mnQ;

    ReaderAppUI$1(ReaderAppUI readerAppUI, boolean z) {
        this.mnQ = readerAppUI;
        this.mnP = z;
    }

    public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        int intValue = ((Integer) view.getTag()).intValue();
        contextMenu.clear();
        if (ReaderAppUI.a(this.mnQ) == 20) {
            contextMenu.setHeaderTitle(g.hardcode_plugin_readerappnews_nick);
        } else {
            contextMenu.setHeaderTitle(g.hardcode_plugin_readerappweibo_nick);
        }
        if (20 == ReaderAppUI.a(this.mnQ)) {
            if (this.mnP) {
                contextMenu.add(intValue, 0, 1, g.readerapp_menu_transmit);
            }
            if (d.QS("favorite")) {
                contextMenu.add(intValue, 1, 2, g.plugin_favorite_opt);
            }
            ReaderAppUI.a(this.mnQ, ((Integer) view.getTag(a.d.reader_msgindex)).intValue());
        }
        contextMenu.add(intValue, 2, 3, g.readerapp_menu_delete);
    }
}

package com.tencent.mm.plugin.webview.ui.tools;

import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import java.util.ArrayList;
import java.util.Iterator;

class WebViewUI$52 implements OnCreateContextMenuListener {
    final /* synthetic */ WebViewUI pZJ;
    final /* synthetic */ ArrayList qaB;

    WebViewUI$52(WebViewUI webViewUI, ArrayList arrayList) {
        this.pZJ = webViewUI;
        this.qaB = arrayList;
    }

    public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        Iterator it = this.qaB.iterator();
        while (it.hasNext()) {
            contextMenu.add((String) it.next());
        }
    }
}

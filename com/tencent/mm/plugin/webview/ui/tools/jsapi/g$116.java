package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.view.MenuItem;
import com.tencent.mm.ui.base.n$d;

class g$116 implements n$d {
    final /* synthetic */ i qiH;
    final /* synthetic */ g qiK;

    g$116(g gVar, i iVar) {
        this.qiK = gVar;
        this.qiH = iVar;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        switch (menuItem.getItemId()) {
            case 1:
                g.dU(this.qiK, this.qiH);
                return;
            case 2:
                g.dV(this.qiK, this.qiH);
                return;
            default:
                return;
        }
    }
}

package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.content.Intent;
import android.view.MenuItem;
import com.tencent.mm.ui.base.n.d;

class g$61 implements d {
    final /* synthetic */ String jGW;
    final /* synthetic */ g qiK;
    final /* synthetic */ Intent val$intent;

    g$61(g gVar, String str, Intent intent) {
        this.qiK = gVar;
        this.jGW = str;
        this.val$intent = intent;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        switch (menuItem.getItemId()) {
            case 1:
                g.a(this.qiK, this.jGW, this.val$intent);
                return;
            case 2:
                g.b(this.qiK, this.val$intent);
                return;
            default:
                return;
        }
    }
}

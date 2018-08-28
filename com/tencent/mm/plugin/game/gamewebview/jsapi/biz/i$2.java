package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import android.content.Intent;
import android.view.MenuItem;
import com.tencent.mm.ui.base.n.d;

class i$2 implements d {
    final /* synthetic */ i jGV;
    final /* synthetic */ String jGW;
    final /* synthetic */ Intent val$intent;

    i$2(i iVar, String str, Intent intent) {
        this.jGV = iVar;
        this.jGW = str;
        this.val$intent = intent;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        switch (menuItem.getItemId()) {
            case 1:
                this.jGV.a(this.jGW, this.val$intent);
                return;
            case 2:
                this.jGV.K(this.val$intent);
                return;
            default:
                return;
        }
    }
}

package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.view.MenuItem;
import com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseMedia.a;
import com.tencent.mm.ui.base.n.d;

class JsApiChooseMedia$a$2 implements d {
    final /* synthetic */ a fUI;

    JsApiChooseMedia$a$2(a aVar) {
        this.fUI = aVar;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        switch (menuItem.getItemId()) {
            case 1:
                a.c(this.fUI);
                return;
            case 2:
                a.d(this.fUI);
                return;
            default:
                return;
        }
    }
}

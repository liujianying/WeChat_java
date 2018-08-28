package com.tencent.mm.plugin.fav.ui.detail;

import android.content.Intent;
import com.tencent.mm.bg.d;
import com.tencent.mm.plugin.fav.ui.detail.FavoriteFileDetailUI.1;

class FavoriteFileDetailUI$1$1 implements Runnable {
    final /* synthetic */ 1 jcy;
    final /* synthetic */ Intent val$intent;

    FavoriteFileDetailUI$1$1(1 1, Intent intent) {
        this.jcy = 1;
        this.val$intent = intent;
    }

    public final void run() {
        d.b(this.jcy.jcx, "webview", ".ui.tools.WebViewUI", this.val$intent);
        this.jcy.jcx.finish();
    }
}

package com.tencent.mm.plugin.game.ui;

import android.graphics.Bitmap;
import android.view.View;
import com.tencent.mm.plugin.game.e.e$b;

class n$1 extends e$b {
    final /* synthetic */ n kay;
    final /* synthetic */ String val$url;

    n$1(n nVar, String str) {
        this.kay = nVar;
        this.val$url = str;
    }

    public final void a(View view, Bitmap bitmap) {
        if (bitmap != null && !bitmap.isRecycled()) {
            n.a(this.kay).put(this.val$url, bitmap);
        }
    }
}

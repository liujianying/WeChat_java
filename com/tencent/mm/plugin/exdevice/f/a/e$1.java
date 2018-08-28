package com.tencent.mm.plugin.exdevice.f.a;

import android.content.Context;
import android.widget.ImageView;

class e$1 implements Runnable {
    final /* synthetic */ ImageView ixr;
    final /* synthetic */ int ixs;
    final /* synthetic */ Context val$context;
    final /* synthetic */ String val$url;

    e$1(Context context, ImageView imageView, String str, int i) {
        this.val$context = context;
        this.ixr = imageView;
        this.val$url = str;
        this.ixs = i;
    }

    public final void run() {
        e.b(this.ixr, this.val$url, this.ixs);
    }
}

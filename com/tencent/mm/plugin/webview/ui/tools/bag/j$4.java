package com.tencent.mm.plugin.webview.ui.tools.bag;

import android.view.View;
import android.view.View.OnClickListener;

class j$4 implements OnClickListener {
    final /* synthetic */ j qcu;

    j$4(j jVar) {
        this.qcu = jVar;
    }

    public final void onClick(View view) {
        j.a(this.qcu, j.c(this.qcu).url, j.c(this.qcu).scene);
    }
}

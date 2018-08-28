package com.tencent.mm.plugin.wenote.model.nativenote.manager;

import android.content.Context;
import android.widget.Toast;

class d$2 implements Runnable {
    final /* synthetic */ String jcA;
    final /* synthetic */ d qqm;
    final /* synthetic */ Context val$context;

    d$2(d dVar, Context context, String str) {
        this.qqm = dVar;
        this.val$context = context;
        this.jcA = str;
    }

    public final void run() {
        Toast.makeText(this.val$context, this.jcA, 0).show();
    }
}

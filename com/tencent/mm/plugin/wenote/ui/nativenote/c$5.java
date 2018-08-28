package com.tencent.mm.plugin.wenote.ui.nativenote;

import android.view.View;

class c$5 implements Runnable {
    final /* synthetic */ View gvo;
    final /* synthetic */ c quZ;
    final /* synthetic */ boolean qva;

    c$5(c cVar, View view, boolean z) {
        this.quZ = cVar;
        this.gvo = view;
        this.qva = z;
    }

    public final void run() {
        this.gvo.setPressed(this.qva);
    }
}

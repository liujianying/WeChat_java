package com.tencent.mm.plugin.af.a;

import com.tencent.mm.plugin.af.a.a.b;

class a$1 implements Runnable {
    final /* synthetic */ String dhx;
    final /* synthetic */ a miR;

    a$1(a aVar, String str) {
        this.miR = aVar;
        this.dhx = str;
    }

    public final void run() {
        new b(this.miR).execute(new String[]{this.dhx});
    }
}

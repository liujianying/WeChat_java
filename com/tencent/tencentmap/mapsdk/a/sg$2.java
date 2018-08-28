package com.tencent.tencentmap.mapsdk.a;

import java.io.File;

class sg$2 extends Thread {
    private /* synthetic */ File a;

    sg$2(sg sgVar, File file) {
        this.a = file;
    }

    public final void run() {
        super.run();
        rv.a(this.a.getAbsolutePath());
    }
}

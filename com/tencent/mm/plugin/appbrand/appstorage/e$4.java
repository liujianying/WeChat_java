package com.tencent.mm.plugin.appbrand.appstorage;

import com.tencent.mm.plugin.appbrand.appstorage.e.b;
import java.io.File;

class e$4 extends b {
    final /* synthetic */ e fkl;

    e$4(e eVar) {
        this.fkl = eVar;
        super(eVar, (byte) 0);
    }

    public final j v(File file) {
        if (file.exists()) {
            return file.isDirectory() ? j.fkI : j.fkQ;
        } else {
            return j.fkO;
        }
    }
}

package com.tencent.mm.plugin.appbrand.appstorage;

import com.tencent.mm.plugin.appbrand.appstorage.e.b;
import java.io.File;

class e$1 extends b {
    final /* synthetic */ e fkl;

    e$1(e eVar) {
        this.fkl = eVar;
        super(eVar, (byte) 0);
    }

    public final j v(File file) {
        return file.exists() ? j.fkI : j.fkO;
    }
}

package com.tencent.mm.plugin.appbrand.appstorage;

import com.tencent.mm.plugin.appbrand.appstorage.e.b;
import java.io.File;

class e$5 extends b {
    final /* synthetic */ e fkl;

    e$5(e eVar) {
        this.fkl = eVar;
        super(eVar, (byte) 0);
    }

    public final j v(File file) {
        if (file.exists()) {
            return j.fkN;
        }
        return file.mkdir() ? j.fkI : j.fkJ;
    }
}

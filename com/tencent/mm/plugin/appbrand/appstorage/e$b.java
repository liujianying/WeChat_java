package com.tencent.mm.plugin.appbrand.appstorage;

import com.tencent.mm.plugin.appbrand.appstorage.e.a;
import java.io.File;

abstract class e$b implements a {
    final /* synthetic */ e fkl;

    public abstract j v(File file);

    private e$b(e eVar) {
        this.fkl = eVar;
    }

    /* synthetic */ e$b(e eVar, byte b) {
        this(eVar);
    }

    public final j a(File file, Object... objArr) {
        return v(file);
    }
}

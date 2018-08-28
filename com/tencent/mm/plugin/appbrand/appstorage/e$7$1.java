package com.tencent.mm.plugin.appbrand.appstorage;

import com.tencent.mm.plugin.appbrand.appcache.a;
import com.tencent.mm.plugin.appbrand.appstorage.e.7;
import java.io.File;
import java.io.FileFilter;
import java.util.List;

class e$7$1 implements FileFilter {
    final /* synthetic */ String fkm;
    final /* synthetic */ List fkn;
    final /* synthetic */ 7 fko;

    e$7$1(7 7, String str, List list) {
        this.fko = 7;
        this.fkm = str;
        this.fkn = list;
    }

    public final boolean accept(File file) {
        boolean z = !file.getName().endsWith(".nomedia");
        if (z) {
            h hVar = new h();
            hVar.fileName = a.qB(file.getAbsolutePath().replaceFirst(this.fkm, ""));
            this.fkn.add(hVar);
        }
        return z;
    }
}

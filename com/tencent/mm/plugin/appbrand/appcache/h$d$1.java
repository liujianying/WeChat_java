package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.mm.plugin.appbrand.appcache.h.d;
import java.io.File;
import java.io.FileFilter;

class h$d$1 implements FileFilter {
    final /* synthetic */ d ffy;

    h$d$1(d dVar) {
        this.ffy = dVar;
    }

    public final boolean accept(File file) {
        return file.isFile();
    }
}

package com.tencent.mm.plugin.appbrand.appstorage;

import com.tencent.mm.plugin.appbrand.appstorage.d.1;
import java.io.File;
import java.io.FileFilter;

class d$1$1 implements FileFilter {
    final /* synthetic */ 1 fjX;

    d$1$1(1 1) {
        this.fjX = 1;
    }

    public final boolean accept(File file) {
        return (file.getName().endsWith(".dat") || file.getName().startsWith("store_") || file.getName().endsWith(".nomedia")) ? false : true;
    }
}

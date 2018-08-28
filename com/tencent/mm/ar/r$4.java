package com.tencent.mm.ar;

import java.io.File;
import java.io.FileFilter;

class r$4 implements FileFilter {
    final /* synthetic */ r edd;

    r$4(r rVar) {
        this.edd = rVar;
    }

    public final boolean accept(File file) {
        return file.getName().endsWith("txt");
    }
}

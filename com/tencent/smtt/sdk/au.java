package com.tencent.smtt.sdk;

import java.io.File;
import java.io.FileFilter;

class au implements FileFilter {
    final /* synthetic */ an a;

    au(an anVar) {
        this.a = anVar;
    }

    public boolean accept(File file) {
        return (file.getName().endsWith(".dex") || file.getName().endsWith(".jar_is_first_load_dex_flag_file")) ? false : true;
    }
}

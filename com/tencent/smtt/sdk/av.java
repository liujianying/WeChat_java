package com.tencent.smtt.sdk;

import java.io.File;
import java.io.FileFilter;

class av implements FileFilter {
    final /* synthetic */ an a;

    av(an anVar) {
        this.a = anVar;
    }

    public boolean accept(File file) {
        return file.getName().endsWith(".jar");
    }
}

package com.tencent.smtt.sdk;

import java.io.File;
import java.io.FileFilter;

final class bc implements FileFilter {
    bc() {
    }

    public final boolean accept(File file) {
        return !file.getName().endsWith(".dex");
    }
}

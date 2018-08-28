package com.tencent.smtt.utils;

import com.tencent.smtt.utils.j.a;
import java.io.File;

final class l implements a {
    l() {
    }

    public final boolean a(File file, File file2) {
        return file.length() == file2.length() && file.lastModified() == file2.lastModified();
    }
}

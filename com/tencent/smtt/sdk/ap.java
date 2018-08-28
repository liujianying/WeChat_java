package com.tencent.smtt.sdk;

import android.os.Build.VERSION;
import java.io.File;
import java.io.FileFilter;

final class ap implements FileFilter {
    ap() {
    }

    public final boolean accept(File file) {
        String name = file.getName();
        return (name == null || name.endsWith(".jar_is_first_load_dex_flag_file")) ? false : VERSION.SDK_INT < 21 || !name.endsWith(".dex");
    }
}

package com.tencent.mm.plugin.appbrand.appstorage;

import com.tencent.mm.sdk.platformtools.bi;
import java.io.File;
import java.io.FileFilter;

class AppBrandLocalMediaObjectManager$1 implements FileFilter {
    AppBrandLocalMediaObjectManager$1() {
    }

    public final boolean accept(File file) {
        return file.exists() && !file.isDirectory() && !bi.oW(file.getName()) && file.getName().startsWith("store_");
    }
}

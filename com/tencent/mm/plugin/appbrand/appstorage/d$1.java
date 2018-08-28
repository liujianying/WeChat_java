package com.tencent.mm.plugin.appbrand.appstorage;

import com.tencent.mm.a.e;
import com.tencent.mm.sdk.platformtools.bi;
import java.io.File;

class d$1 implements Runnable {
    d$1() {
    }

    public final void run() {
        File file = new File(AppBrandLocalMediaObjectManager.OBJECT_ROOT_DIR_PATH);
        if (file.exists() && file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null && listFiles.length > 0) {
                for (File u : listFiles) {
                    u(u);
                }
            }
        }
    }

    private void u(File file) {
        if (file.exists() && file.isDirectory()) {
            File[] listFiles = file.listFiles(new 1(this));
            if (listFiles != null && listFiles.length > 0) {
                long VF = bi.VF();
                for (File file2 : listFiles) {
                    if (VF - file2.lastModified() >= d.ty()) {
                        e.deleteFile(file2.getAbsolutePath());
                    }
                }
            }
        }
    }
}

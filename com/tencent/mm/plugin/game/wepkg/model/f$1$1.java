package com.tencent.mm.plugin.game.wepkg.model;

import com.tencent.mm.plugin.game.wepkg.model.f.1;
import com.tencent.mm.plugin.game.wepkg.utils.d;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;

class f$1$1 implements Runnable {
    final /* synthetic */ String keO;
    final /* synthetic */ 1 kfr;

    f$1$1(1 1, String str) {
        this.kfr = 1;
        this.keO = str;
    }

    public final void run() {
        int i = 0;
        String Et = d.Et(this.kfr.keN);
        String str = "";
        WepkgVersion Em = g.Em(this.kfr.keN);
        if (Em != null) {
            str = Em.version;
        }
        x.i("MicroMsg.Wepkg.WepkgManager", "clear all local wepkg, pkgid:%s, currVersion:%s, usedVersion:%s", new Object[]{this.kfr.keN, str, this.keO});
        try {
            if (bi.oW(this.keO) && bi.oW(str)) {
                f.Ek(Et);
                return;
            }
            File file = new File(Et);
            if (file.exists() && !file.isFile()) {
                File[] listFiles = file.listFiles();
                if (listFiles == null || listFiles.length == 0) {
                    file.delete();
                    return;
                }
                int length = listFiles.length;
                while (i < length) {
                    File file2 = listFiles[i];
                    if (file2.isFile()) {
                        file2.delete();
                    }
                    if (!(!file2.isDirectory() || file2.getName().equalsIgnoreCase(this.keO) || file2.getName().equalsIgnoreCase(str))) {
                        x.i("MicroMsg.Wepkg.WepkgManager", "delete local path:%s", new Object[]{file2.getAbsolutePath()});
                        f.Ek(file2.getAbsolutePath());
                    }
                    i++;
                }
            }
        } catch (Exception e) {
            x.i("MicroMsg.Wepkg.WepkgManager", "clearAllLocalWepkg err:" + e.getMessage());
        }
    }
}

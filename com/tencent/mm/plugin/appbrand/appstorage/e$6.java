package com.tencent.mm.plugin.appbrand.appstorage;

import com.tencent.mm.plugin.appbrand.appstorage.e.b;
import java.io.File;

class e$6 extends b {
    final /* synthetic */ e fkl;

    e$6(e eVar) {
        this.fkl = eVar;
        super(eVar, (byte) 0);
    }

    public final j v(File file) {
        if (file.isFile() || !file.exists()) {
            return j.fkO;
        }
        if (file.equals(e.a(this.fkl))) {
            return j.fkM;
        }
        File[] listFiles = file.listFiles();
        if (listFiles.length > 0) {
            if (listFiles.length != 1) {
                return j.fkP;
            }
            if (!listFiles[0].getName().equals(".nomedia")) {
                return j.fkP;
            }
            listFiles[0].delete();
        }
        if (file.delete()) {
            return j.fkI;
        }
        return j.fkJ;
    }
}

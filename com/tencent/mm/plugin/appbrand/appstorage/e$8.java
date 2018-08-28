package com.tencent.mm.plugin.appbrand.appstorage;

import com.tencent.mm.plugin.appbrand.q.h;
import java.io.File;

class e$8 implements e$a {
    final /* synthetic */ e fkl;

    e$8(e eVar) {
        this.fkl = eVar;
    }

    public final j a(File file, Object... objArr) {
        h hVar = (h) objArr[0];
        if (!file.exists()) {
            return j.RET_NOT_EXISTS;
        }
        if (!file.isFile()) {
            return j.ERR_PERMISSION_DENIED;
        }
        if (k.z(file)) {
            return j.ERR_SYMLINK;
        }
        if (hVar != null) {
            hVar.value = k.x(file);
        }
        return j.OK;
    }
}

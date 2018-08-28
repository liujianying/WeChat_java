package com.tencent.mm.plugin.ipcall.a.g;

import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.x;

class j$1 extends m {
    final /* synthetic */ j ksG;

    j$1(j jVar) {
        this.ksG = jVar;
    }

    protected final boolean Xu() {
        if (j.a(this.ksG) != null && !j.a(this.ksG).cjr()) {
            return true;
        }
        String str = "MicroMsg.IPCallPopularCountryStorage";
        String str2 = "shouldProcessEvent db is close :%s";
        Object[] objArr = new Object[1];
        objArr[0] = j.a(this.ksG) == null ? "null" : Boolean.valueOf(j.a(this.ksG).cjr());
        x.w(str, str2, objArr);
        return false;
    }
}

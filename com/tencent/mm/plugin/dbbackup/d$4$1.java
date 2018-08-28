package com.tencent.mm.plugin.dbbackup;

import com.tencent.mm.plugin.dbbackup.d.4;
import com.tencent.wcdb.repair.DBDumpUtil.ExecuteSqlCallback;

class d$4$1 implements ExecuteSqlCallback {
    final /* synthetic */ int[] ias;
    final /* synthetic */ 4 iat;

    d$4$1(4 4, int[] iArr) {
        this.iat = 4;
        this.ias = iArr;
    }

    public final String preExecute(String str) {
        int[] iArr = this.ias;
        iArr[0] = iArr[0] + 1;
        return null;
    }
}

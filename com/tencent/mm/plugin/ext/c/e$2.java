package com.tencent.mm.plugin.ext.c;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.ext.c.a.a;
import com.tencent.mm.sdk.platformtools.bd;

class e$2 extends bd<Boolean> {
    final /* synthetic */ int fOZ;
    final /* synthetic */ int fPa;
    final /* synthetic */ e iKT;
    final /* synthetic */ String val$url;

    public e$2(e eVar, Boolean bool, String str, int i, int i2) {
        this.iKT = eVar;
        this.val$url = str;
        this.fOZ = i;
        this.fPa = i2;
        super(5000, bool);
    }

    private Boolean ame() {
        g.Eh().dpP.a(782, new 1(this));
        g.Eh().dpP.a(new a(this.val$url, this.fOZ, this.fPa), 0);
        return Boolean.valueOf(true);
    }
}

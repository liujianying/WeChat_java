package com.tencent.mm.openim.d;

import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bi;

public final class d extends i<c> {
    public static final String[] diD = new String[]{i.a(c.dhO, "OpenIMAppIdInfo")};
    public e diF;

    public d(e eVar) {
        super(eVar, c.dhO, "OpenIMAppIdInfo", null);
        this.diF = eVar;
    }

    public final boolean a(c cVar) {
        cVar.field_updateTime = bi.VE();
        return super.a(cVar);
    }
}

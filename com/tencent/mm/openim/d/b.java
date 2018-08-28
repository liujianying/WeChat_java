package com.tencent.mm.openim.d;

import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bi;

public final class b extends i<a> {
    public static final String[] diD = new String[]{i.a(a.dhO, "OpenIMAccTypeInfo")};
    private e diF;

    public b(e eVar) {
        super(eVar, a.dhO, "OpenIMAccTypeInfo", null);
        this.diF = eVar;
    }

    public final boolean a(a aVar) {
        aVar.field_updateTime = bi.VE();
        return super.a(aVar);
    }
}

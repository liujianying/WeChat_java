package com.tencent.mm.plugin.sns.storage;

import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;

public final class d extends i<c> {
    public static final String[] diD = new String[]{i.a(c.dhO, "CanvasInfo")};

    public d(e eVar) {
        this(eVar, c.dhO, "CanvasInfo");
    }

    private d(e eVar, a aVar, String str) {
        super(eVar, aVar, str, null);
    }

    public final void a(c cVar) {
        if (cVar != null) {
            cVar.field_createTime = System.currentTimeMillis();
            if (!b(cVar)) {
                c(cVar, new String[0]);
            }
        }
    }
}

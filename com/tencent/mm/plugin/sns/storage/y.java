package com.tencent.mm.plugin.sns.storage;

import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bi;

public final class y extends i<x> {
    public static final String[] diD = new String[]{i.a(x.dhO, "UxCanvasInfo")};

    public y(e eVar) {
        this(eVar, x.dhO, "UxCanvasInfo");
    }

    private y(e eVar, a aVar, String str) {
        super(eVar, aVar, str, null);
    }

    public final void a(x xVar) {
        if (xVar != null && !bi.oW(xVar.field_canvasXml)) {
            xVar.field_createTime = System.currentTimeMillis();
            if (!b((c) xVar)) {
                c(xVar, new String[0]);
            }
        }
    }
}

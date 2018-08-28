package com.tencent.mm.pluginsdk.model.app;

import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;

public final class c extends i<b> {
    public static final String[] diD = new String[]{i.a(b.dhO, "appattach")};
    e diF;

    public c(e eVar) {
        super(eVar, b.dhO, "appattach", null);
        this.diF = eVar;
    }

    public final b SR(String str) {
        b bVar = new b();
        bVar.field_mediaSvrId = str;
        if (b(bVar, new String[]{"mediaSvrId"})) {
            return bVar;
        }
        return !b(bVar, new String[]{"mediaId"}) ? null : bVar;
    }

    public final b fH(long j) {
        b bVar = new b();
        bVar.field_msgInfoId = j;
        return b(bVar, new String[]{"msgInfoId"}) ? bVar : null;
    }
}

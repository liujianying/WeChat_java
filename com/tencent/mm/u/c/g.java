package com.tencent.mm.u.c;

import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.u.b.e;
import java.util.HashMap;
import java.util.Map;

public final class g {
    private final Map<String, e> dpb = new HashMap();

    public final void a(e eVar) {
        this.dpb.put(eVar.getName(), eVar);
    }

    public final e fO(String str) {
        if (bi.oW(str)) {
            return null;
        }
        return (e) this.dpb.get(str);
    }
}

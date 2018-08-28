package com.tencent.mm.plugin.t;

import com.tencent.mm.bt.h;
import com.tencent.mm.kernel.api.bucket.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.storage.bc;
import java.util.HashMap;

public final class a implements com.tencent.mm.kernel.api.bucket.a, d, com.tencent.mm.plugin.t.a.a {
    private bc lby;

    public final bc FY() {
        g.Ek();
        g.Eg().Ds();
        return this.lby;
    }

    public final void onDataBaseOpened(h hVar, h hVar2) {
        this.lby = new bc(hVar);
    }

    public final void onDataBaseClosed(h hVar, h hVar2) {
    }

    public final HashMap<Integer, h.d> collectDatabaseFactory() {
        HashMap<Integer, h.d> hashMap = new HashMap();
        hashMap.put(Integer.valueOf("MediaCheckDumplicationStorage".hashCode()), new 1(this));
        return hashMap;
    }
}

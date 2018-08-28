package com.tencent.mm.plugin.d;

import com.tencent.mm.bt.h;
import com.tencent.mm.bt.h.d;
import com.tencent.mm.kernel.api.e;
import com.tencent.mm.kernel.b.c;
import com.tencent.mm.storage.g;
import java.util.HashMap;

public final class a implements com.tencent.mm.kernel.api.a, e, c {
    private static final HashMap<Integer, d> cVM;
    private static a fak;
    private g fal;

    private a() {
    }

    public static synchronized a ZN() {
        a aVar;
        synchronized (a.class) {
            if (fak == null) {
                fak = new a();
            }
            aVar = fak;
        }
        return aVar;
    }

    public final g Gw() {
        com.tencent.mm.kernel.g.Eg().Ds();
        return this.fal;
    }

    public final void onDataBaseOpened(h hVar, h hVar2) {
        this.fal = new g(hVar);
    }

    public final void onDataBaseClosed(h hVar, h hVar2) {
    }

    public final HashMap<Integer, d> collectDatabaseFactory() {
        return cVM;
    }

    static {
        HashMap hashMap = new HashMap();
        cVM = hashMap;
        hashMap.put(Integer.valueOf("AddContactAntispamTicket".hashCode()), new 1());
    }
}

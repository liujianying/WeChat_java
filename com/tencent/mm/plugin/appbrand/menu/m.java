package com.tencent.mm.plugin.appbrand.menu;

import com.tencent.mm.plugin.appbrand.menu.a.a;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class m {
    public Map<Integer, a> gjM;

    /* synthetic */ m(byte b) {
        this();
    }

    private m() {
        this.gjM = new HashMap();
        a(new b());
        a(new a());
        a(new c());
        a(new f());
        a(new MenuDelegate_SendToDesktop());
        a(new g());
        a(new i());
        a(new j());
        a(new MenuDelegate_EnableDebug());
        a(new h());
        a(new e());
        a(new d());
    }

    public static k e(List<k> list, int i) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        for (k kVar : list) {
            if (kVar != null && kVar.id == i) {
                return kVar;
            }
        }
        return null;
    }

    public static void b(List<k> list, int i, boolean z) {
        k kVar = new k(i);
        kVar.gju = z;
        list.add(kVar);
    }

    private void a(a aVar) {
        this.gjM.put(Integer.valueOf(aVar.gjO), aVar);
    }
}

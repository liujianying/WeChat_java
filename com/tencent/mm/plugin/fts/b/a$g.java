package com.tencent.mm.plugin.fts.b;

import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.a.a.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class a$g extends a {
    final /* synthetic */ a jtJ;
    private int[] jua;
    private int jub = 0;
    private int juc = 0;

    public a$g(a aVar, int[] iArr) {
        this.jtJ = aVar;
        this.jua = iArr;
    }

    public final boolean execute() {
        List<b> e = a.a(this.jtJ).e(this.jua, 1);
        this.jub = e.size();
        Object hashMap = new HashMap();
        for (b bVar : e) {
            String str = bVar.jrv;
            if (!a.b(this.jtJ).containsKey(str)) {
                List list = (List) hashMap.get(str);
                if (list == null) {
                    list = new ArrayList(16);
                    hashMap.put(str, list);
                }
                list.add(Long.valueOf(bVar.jrt));
            }
        }
        a.b(this.jtJ).putAll(hashMap);
        this.juc = hashMap.size();
        return true;
    }

    public final String afC() {
        return String.format("{touched: %d users: %d}", new Object[]{Integer.valueOf(this.jub), Integer.valueOf(this.juc)});
    }

    public final String getName() {
        return "MarkAllContactDirtyTask";
    }
}

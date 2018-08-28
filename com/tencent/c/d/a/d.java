package com.tencent.c.d.a;

import com.tencent.c.d.b.d.a;
import com.tencent.c.f.h;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public final class d implements b {
    private final HashSet<Integer> vjp = new HashSet();
    private final List<a> vjq = new ArrayList();

    public final void a(a aVar) {
        if (aVar.uid == 0) {
            if (aVar.vjv == 1 && !"/sbin/adbd".equals(aVar.name)) {
                h.d("ProcessRelationAnalyzer parent : " + aVar.toString());
                this.vjp.add(Integer.valueOf(aVar.pid));
            } else if (aVar.vjv > 1 && "sh".equals(aVar.name) && "/system/bin/sh".equals(aVar.name)) {
                h.d("ProcessRelationAnalyzer child : " + aVar.toString());
                this.vjq.add(aVar);
            }
        }
    }

    public final boolean cFe() {
        for (a aVar : this.vjq) {
            if (this.vjp.contains(Integer.valueOf(aVar.vjv))) {
                h.i("ProcessRelationAnalyzer match : " + aVar.toString());
                return true;
            }
        }
        return false;
    }
}

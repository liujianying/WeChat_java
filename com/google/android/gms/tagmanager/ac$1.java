package com.google.android.gms.tagmanager;

import com.google.android.gms.c.at;
import com.google.android.gms.c.at.b;
import com.google.android.gms.tagmanager.ac.a;
import java.util.List;
import java.util.Map;
import java.util.Set;

class ac$1 implements a {
    final /* synthetic */ Map bcf;
    final /* synthetic */ Map bcg;
    final /* synthetic */ Map bch;
    final /* synthetic */ Map bci;
    final /* synthetic */ ac bcj;

    ac$1(ac acVar, Map map, Map map2, Map map3, Map map4) {
        this.bcj = acVar;
        this.bcf = map;
        this.bcg = map2;
        this.bch = map3;
        this.bci = map4;
    }

    public final void a(b bVar, Set<at.a> set, Set<at.a> set2, aa aaVar) {
        List list = (List) this.bcf.get(bVar);
        this.bcg.get(bVar);
        if (list != null) {
            set.addAll(list);
            aaVar.rm();
        }
        list = (List) this.bch.get(bVar);
        this.bci.get(bVar);
        if (list != null) {
            set2.addAll(list);
            aaVar.rn();
        }
    }
}

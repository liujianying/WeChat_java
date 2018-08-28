package com.tencent.mm.pluginsdk.model.app;

import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class d implements e {
    public Map<Integer, Set<t>> dJw = new HashMap();

    public d() {
        g.Eh().dpP.a(452, this);
    }

    public final void a(int i, t tVar) {
        if (!this.dJw.containsKey(Integer.valueOf(i))) {
            this.dJw.put(Integer.valueOf(i), new HashSet());
        }
        if (!((Set) this.dJw.get(Integer.valueOf(i))).contains(tVar)) {
            ((Set) this.dJw.get(Integer.valueOf(i))).add(tVar);
        }
    }

    public final void b(int i, t tVar) {
        if (this.dJw.get(Integer.valueOf(i)) != null) {
            ((Set) this.dJw.get(Integer.valueOf(i))).remove(tVar);
        }
    }

    public static void a(int i, x xVar) {
        g.Eh().dpP.a(new y(i, xVar), 0);
    }

    public final void a(int i, int i2, String str, l lVar) {
        if (lVar instanceof y) {
            y yVar = (y) lVar;
            Set set = (Set) this.dJw.get(Integer.valueOf(yVar.qAc));
            if (set != null && set.size() > 0) {
                Set<t> hashSet = new HashSet();
                hashSet.addAll(set);
                for (t tVar : hashSet) {
                    if (tVar != null && set.contains(tVar)) {
                        tVar.a(i, i2, str, yVar.qAd);
                    }
                }
                return;
            }
            return;
        }
        x.i("MicroMsg.AppCenterNetSceneService", "onSceneEnd, the scene is not a instance of NetSceneAppCenter");
    }
}

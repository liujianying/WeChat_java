package com.tencent.mm.r;

import com.tencent.mm.bt.h.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.p;
import com.tencent.mm.r.a.1;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class i implements ar {
    private static HashMap<Integer, d> cVM;
    private e diO;
    private c diP = new c();
    Map<Integer, List<f>> diQ = new HashMap();

    static i Cf() {
        return (i) p.v(i.class);
    }

    public static e Cg() {
        if (Cf().diO == null) {
            Cf().diO = new e(g.Ei().dqq);
        }
        return Cf().diO;
    }

    public static c Ch() {
        if (Cf().diP == null) {
            Cf().diP = new c();
        }
        return Cf().diP;
    }

    public static synchronized void a(f fVar) {
        synchronized (i.class) {
            x.i("MicroMsg.SubCoreFunctionMsg", "removeUpdateCallback, msgType: %s, callback: %s", new Object[]{Integer.valueOf(12399999), fVar});
            if (fVar != null) {
                List list = (List) Cf().diQ.get(Integer.valueOf(12399999));
                if (list != null && list.contains(fVar)) {
                    list.remove(fVar);
                    Cf().diQ.put(Integer.valueOf(12399999), list);
                }
            }
        }
    }

    public static synchronized void b(f fVar) {
        synchronized (i.class) {
            x.i("MicroMsg.SubCoreFunctionMsg", "addUpdateCallback, msgType: %s, callback: %s", new Object[]{Integer.valueOf(12399999), fVar});
            if (fVar != null) {
                List list = (List) Cf().diQ.get(Integer.valueOf(12399999));
                if (list == null) {
                    list = new ArrayList();
                }
                if (!list.contains(fVar)) {
                    list.add(fVar);
                }
                Cf().diQ.put(Integer.valueOf(12399999), list);
            }
        }
    }

    static {
        HashMap hashMap = new HashMap();
        cVM = hashMap;
        hashMap.put(Integer.valueOf("FunctionMsgItem".hashCode()), new 1());
    }

    public final HashMap<Integer, d> Ci() {
        x.i("MicroMsg.SubCoreFunctionMsg", "getBaseDBFactories");
        return cVM;
    }

    public final void gi(int i) {
    }

    public final void bn(boolean z) {
        x.i("MicroMsg.SubCoreFunctionMsg", "onAccountPostReset");
        g.Em().h(new 1(), 10000);
    }

    public final void bo(boolean z) {
    }

    public final void onAccountRelease() {
        x.d("MicroMsg.SubCoreFunctionMsg", "onAccountRelease");
    }
}

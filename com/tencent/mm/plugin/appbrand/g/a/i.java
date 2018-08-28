package com.tencent.mm.plugin.appbrand.g.a;

import android.util.Pair;
import com.tencent.mm.plugin.appbrand.g.a.f.4;
import com.tencent.mm.plugin.appbrand.g.a.f.5;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public final class i {
    j fef;
    public final HashMap<Integer, f> geA = new HashMap();
    private a geB = new 4(this);
    private final AtomicInteger gez = new AtomicInteger(0);

    public i(j jVar) {
        this.fef = jVar;
    }

    public final int a(Pair<String, String>... pairArr) {
        int addAndGet = this.gez.addAndGet(1);
        f fVar = new f(this.geB);
        fVar.gem.r(new 5(fVar, new 2(this, addAndGet), "postMessage"));
        fVar.gem.gex = new 1(this, fVar);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < 5) {
                Pair pair = pairArr[i2];
                if (!(pair == null || pair.second == null || ((String) pair.second).length() == 0)) {
                    String str = (String) pair.first;
                    fVar.gem.r(new 4(fVar, (String) pair.second, str));
                }
                i = i2 + 1;
            } else {
                this.geA.put(Integer.valueOf(addAndGet), fVar);
                return addAndGet;
            }
        }
    }
}

package com.tencent.mm.model;

import com.tencent.mm.bt.h.d;
import com.tencent.mm.kernel.api.c;
import com.tencent.mm.kernel.api.f;
import com.tencent.mm.kernel.api.h;
import com.tencent.mm.kernel.e;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class p implements com.tencent.mm.kernel.api.a, c, f, h, com.tencent.mm.kernel.b.c {
    private static ConcurrentHashMap<String, p> dAK = new ConcurrentHashMap();
    private volatile a dAG;
    private volatile Class<? extends ar> dAH;
    private volatile ar dAI;
    private volatile boolean dAJ = false;

    public interface a {
        ar createSubCore();
    }

    public p(Class<? extends ar> cls) {
        this.dAH = cls;
        a(this.dAH.getName(), this);
    }

    public p(a aVar) {
        this.dAG = aVar;
    }

    public final synchronized ar GC() {
        if (this.dAI == null) {
            a(createSubCore());
        }
        return this.dAI;
    }

    public final void a(ar arVar) {
        synchronized (this) {
            this.dAI = arVar;
            if (this.dAH == null && this.dAI != null) {
                this.dAH = this.dAI.getClass();
            }
        }
    }

    private ar createSubCore() {
        try {
            x.i("MicroMsg.CompatSubCore", "createSubCore(), %s %s", this.dAH, this.dAG);
            if (this.dAG != null) {
                return this.dAG.createSubCore();
            }
            return (ar) this.dAH.newInstance();
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.CompatSubCore", e, "", new Object[0]);
            throw new IllegalAccessError(e.getMessage());
        } catch (Throwable e2) {
            x.printErrStackTrace("MicroMsg.CompatSubCore", e2, "", new Object[0]);
            throw new IllegalAccessError(e2.getMessage());
        }
    }

    private synchronized void reset() {
        this.dAI = null;
        this.dAJ = false;
    }

    public static p a(String str, p pVar) {
        p pVar2 = (p) dAK.putIfAbsent(str, pVar);
        if (pVar2 == null) {
            com.tencent.mm.kernel.a.c Et = com.tencent.mm.kernel.a.c.Et();
            x.i("MicroMsg.CallbacksProxy", "add pending callbacks %s", pVar);
            Et.drJ.putIfAbsent(pVar, Et.drJ);
        } else {
            pVar = pVar2;
        }
        x.i("MicroMsg.CompatSubCore", "registerCompatSubCoreWithNameIfAbsent %s, %s", str, pVar);
        return pVar;
    }

    public static p gP(String str) {
        p pVar = (p) dAK.get(str);
        if (pVar == null) {
            x.i("MicroMsg.CompatSubCore", "compatSubCore is null by name %s", str);
        } else {
            com.tencent.mm.kernel.a.c.Et().aH(pVar);
        }
        return pVar;
    }

    public static void GD() {
        for (p reset : dAK.values()) {
            reset.reset();
        }
    }

    public static void gS(int i) {
        for (p GC : dAK.values()) {
            ar GC2 = GC.GC();
            if (GC2 != null) {
                GC2.gi(i);
            }
        }
    }

    public static <T extends ar> T v(Class<T> cls) {
        p gP = gP(cls.getName());
        if (gP == null) {
            gP = new p((Class) cls);
            a(cls.getName(), gP);
        }
        return gP.GC();
    }

    public HashMap<Integer, d> collectDatabaseFactory() {
        ar GC = GC();
        if (GC == null) {
            return null;
        }
        return GC.Ci();
    }

    public void onAccountInitialized(e.c cVar) {
        ar GC = GC();
        if (GC != null) {
            GC.bn(cVar.dqH);
            this.dAJ = true;
        }
    }

    public void onAccountRelease() {
        ar GC = GC();
        if (GC != null) {
            GC.onAccountRelease();
        }
    }

    public final void Ep() {
        ar GC = GC();
        if (GC != null && this.dAJ) {
            GC.bo(com.tencent.mm.compatible.util.f.zZ());
        }
    }

    public void gj(String str) {
    }

    public final void Eq() {
        GC();
    }

    public String toString() {
        return super.toString() + " " + this.dAH + " " + this.dAG + " " + this.dAI;
    }
}

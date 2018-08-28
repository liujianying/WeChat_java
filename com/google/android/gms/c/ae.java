package com.google.android.gms.c;

import com.google.android.gms.common.internal.w;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public final class ae {
    public final v aFC;
    public final ag aXY;
    public boolean aXZ;
    public long aYa;
    public long aYb;
    public long aYc;
    private long aYd;
    private long aYe;
    public boolean aYf;
    final Map<Class<? extends af>, af> aYg;
    final List<ai> aYh;

    private ae(ae aeVar) {
        this.aXY = aeVar.aXY;
        this.aFC = aeVar.aFC;
        this.aYa = aeVar.aYa;
        this.aYb = aeVar.aYb;
        this.aYc = aeVar.aYc;
        this.aYd = aeVar.aYd;
        this.aYe = aeVar.aYe;
        this.aYh = new ArrayList(aeVar.aYh);
        this.aYg = new HashMap(aeVar.aYg.size());
        for (Entry entry : aeVar.aYg.entrySet()) {
            af f = f((Class) entry.getKey());
            ((af) entry.getValue()).a(f);
            this.aYg.put(entry.getKey(), f);
        }
    }

    ae(ag agVar, v vVar) {
        w.ah(agVar);
        w.ah(vVar);
        this.aXY = agVar;
        this.aFC = vVar;
        this.aYd = 1800000;
        this.aYe = 3024000000L;
        this.aYg = new HashMap();
        this.aYh = new ArrayList();
    }

    private static <T extends af> T f(Class<T> cls) {
        try {
            return (af) cls.newInstance();
        } catch (Throwable e) {
            throw new IllegalArgumentException("dataType doesn't have default constructor", e);
        } catch (Throwable e2) {
            throw new IllegalArgumentException("dataType default constructor is not accessible", e2);
        }
    }

    public final void b(af afVar) {
        w.ah(afVar);
        Class cls = afVar.getClass();
        if (cls.getSuperclass() != af.class) {
            throw new IllegalArgumentException();
        }
        afVar.a(e(cls));
    }

    public final <T extends af> T d(Class<T> cls) {
        return (af) this.aYg.get(cls);
    }

    public final <T extends af> T e(Class<T> cls) {
        af afVar = (af) this.aYg.get(cls);
        if (afVar != null) {
            return afVar;
        }
        T f = f(cls);
        this.aYg.put(cls, f);
        return f;
    }

    public final ae ql() {
        return new ae(this);
    }
}

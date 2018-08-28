package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.mm.plugin.appbrand.appstorage.o;
import java.io.Closeable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

final class aj$a implements Closeable {
    private final n fhy;
    private final Map<ag, o> fhz;

    /* synthetic */ aj$a(n nVar, byte b) {
        this(nVar);
    }

    private aj$a(n nVar) {
        this.fhz = new HashMap();
        this.fhy = nVar;
    }

    final Collection<o> aci() {
        Collection<o> values;
        synchronized (this.fhz) {
            values = this.fhz.values();
        }
        return values;
    }

    final o qP(String str) {
        ag qG = this.fhy.qG(str);
        if (qG == null) {
            return null;
        }
        o oVar;
        synchronized (this.fhz) {
            oVar = (o) this.fhz.get(qG);
            if (oVar == null) {
                Map map = this.fhz;
                oVar = new o(qG);
                map.put(qG, oVar);
            }
        }
        return oVar;
    }

    public final void close() {
        synchronized (this.fhz) {
            this.fhz.clear();
        }
        this.fhy.close();
    }
}

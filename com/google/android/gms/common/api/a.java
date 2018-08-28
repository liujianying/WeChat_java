package com.google.android.gms.common.api;

import com.google.android.gms.common.api.c.e;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.common.internal.w;
import java.io.PrintWriter;
import java.util.Set;

public final class a<O> {
    private final a<?, O> aJP;
    final e<?, O> aJQ = null;
    private final c<?> aJR;
    final f<?> aJS;
    final String mName;

    public interface b {
        void a(e eVar);

        void a(p pVar);

        void a(p pVar, Set<Scope> set);

        void a(String str, PrintWriter printWriter);

        void disconnect();

        boolean isConnected();

        boolean ou();

        boolean ov();
    }

    public <C extends b> a(String str, a<C, O> aVar, c<C> cVar) {
        w.j(aVar, "Cannot construct an Api with a null ClientBuilder");
        w.j(cVar, "Cannot construct an Api with a null ClientKey");
        this.mName = str;
        this.aJP = aVar;
        this.aJR = cVar;
        this.aJS = null;
    }

    public final a<?, O> or() {
        w.d(this.aJP != null, "This API was constructed with a SimpleClientBuilder. Use getSimpleClientBuilder");
        return this.aJP;
    }

    public final c<?> os() {
        w.d(this.aJR != null, "This API was constructed with a SimpleClientKey. Use getSimpleClientKey");
        return this.aJR;
    }
}

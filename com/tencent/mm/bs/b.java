package com.tencent.mm.bs;

import android.content.Context;
import java.util.HashMap;

public final class b {
    private final b<?>[] sND;
    private final HashMap<String, b<?>> sNE = new HashMap();

    public interface a<T> {
        void aZ(T t);
    }

    public interface b<T> {
        void a(a<T> aVar);

        void b(a<T> aVar);

        T get();

        String name();

        void removeAllListeners();
    }

    public b(Context context) {
        d dVar = new d(context);
        this.sND = new b[]{dVar.sNL, dVar.sNM};
    }

    public final <T> b<T> Dh(int i) {
        return (i < 0 || i >= this.sND.length) ? null : this.sND[i];
    }
}

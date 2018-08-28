package com.tencent.mm.plugin.appbrand.g.a;

import com.eclipsesource.v8.V8;
import com.eclipsesource.v8.utils.MemoryManager;
import com.tencent.mm.compatible.util.k;
import java.util.LinkedList;

public class f {
    private final a gdW;
    final V8 gek;
    private final MemoryManager gel;
    public final h gem;
    private final LinkedList<b> gen;

    static {
        k.b("mmv8", f.class.getClassLoader());
        k.b("j2v8", f.class.getClassLoader());
    }

    public f() {
        this(null);
    }

    f(a aVar) {
        this.gen = new LinkedList();
        this.gek = V8.createV8Runtime();
        this.gel = new MemoryManager(this.gek);
        this.gem = new h(this.gek);
        if (aVar == null) {
            aVar = new g();
        }
        this.gdW = aVar;
        this.gem.r(new 1(this));
        this.gem.r(new 2(this));
    }
}

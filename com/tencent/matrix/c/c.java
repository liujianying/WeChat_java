package com.tencent.matrix.c;

import java.util.HashSet;

public class c {
    private final a bro;
    private final HashSet<String> brp = new HashSet();

    public interface a {
        void a(b bVar);
    }

    public c(a aVar) {
        this.bro = aVar;
    }

    public final void c(b bVar) {
        if (this.bro == null) {
            throw new RuntimeException("publish issue, but issue listener is null");
        }
        this.bro.a(bVar);
    }

    public boolean cb(String str) {
        if (str == null) {
            return false;
        }
        return this.brp.contains(str);
    }

    public void ca(String str) {
        if (str != null) {
            this.brp.add(str);
        }
    }
}

package com.tencent.mm.storage;

import com.tencent.mm.bt.h;
import com.tencent.mm.model.bd.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.f;
import com.tencent.mm.plugin.messenger.foundation.a.a.f.c;
import com.tencent.mm.plugin.messenger.foundation.a.k;

public abstract class e {
    public static k sNP;
    protected f sNO;

    public abstract String XG(String str);

    protected boolean a(bd bdVar, b bVar) {
        return true;
    }

    public e(f fVar) {
        this.sNO = fVar;
    }

    public final h bdc() {
        return this.sNO.bdc();
    }

    protected final void a(h hVar, String str) {
        this.sNO.a(hVar, str);
    }

    protected final void a(f.b bVar) {
        this.sNO.a(bVar);
    }

    protected final String GX(String str) {
        return this.sNO.GX(str);
    }

    protected final void a(c cVar) {
        this.sNO.a(cVar);
    }

    protected final void fW(String str, String str2) {
        this.sNO.b(str, str2, null);
    }
}

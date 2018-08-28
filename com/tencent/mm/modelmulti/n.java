package com.tencent.mm.modelmulti;

import com.tencent.mm.plugin.messenger.foundation.a.g;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.storage.bd;

public final class n implements p {
    private final a eam = new a((byte) 0);
    private g ean;

    public final String v(bd bdVar) {
        if (this.ean != null) {
            return this.ean.v(bdVar);
        }
        return null;
    }

    public final void a(l lVar) {
        this.eam.aI(lVar);
    }

    public final void a(g gVar) {
        this.ean = gVar;
    }

    public final l PK() {
        return this.eam;
    }
}

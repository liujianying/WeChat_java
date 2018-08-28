package com.tencent.mm.aq;

import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.a.h.b;
import com.tencent.mm.sdk.e.j;

public final class i extends j implements h {
    public static final String[] diD = new String[]{"CREATE TABLE IF NOT EXISTS oplog2 ( id INTEGER PRIMARY KEY , inserTime long , cmdId int , buffer blob , reserved1 int , reserved2 long , reserved3 text , reserved4 text ) "};
    com.tencent.mm.bt.h dCZ;

    public i(com.tencent.mm.bt.h hVar) {
        this.dCZ = hVar;
    }

    public final boolean a(b bVar) {
        if (bVar == null) {
            return true;
        }
        if (this.dCZ.delete("oplog2", "id= ? AND inserTime= ?", new String[]{bVar.id, bVar.dSH}) < 0) {
            return false;
        }
        return true;
    }
}

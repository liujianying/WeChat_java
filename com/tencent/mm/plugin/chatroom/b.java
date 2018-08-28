package com.tencent.mm.plugin.chatroom;

import com.tencent.mm.bt.h;
import com.tencent.mm.bt.h.d;
import com.tencent.mm.kernel.api.bucket.a;
import com.tencent.mm.kernel.api.c;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.af;
import com.tencent.mm.storage.v;
import java.util.HashMap;

public final class b implements a, c, com.tencent.mm.kernel.c.a, com.tencent.mm.plugin.chatroom.b.b {
    private v hKz;

    public final /* bridge */ /* synthetic */ af Ga() {
        return this.hKz;
    }

    public final af c(h hVar) {
        return new v(hVar);
    }

    public final HashMap<Integer, d> collectDatabaseFactory() {
        HashMap<Integer, d> hashMap = new HashMap();
        hashMap.put(Integer.valueOf("CHATROOM_MEMBERS_TABLE".hashCode()), new 1(this));
        return hashMap;
    }

    public final void onAccountInitialized(e.c cVar) {
        this.hKz = new v(g.Ei().dqq);
    }

    public final void onAccountRelease() {
    }
}

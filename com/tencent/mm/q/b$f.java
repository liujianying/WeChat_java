package com.tencent.mm.q;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.friend.a.b;
import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.sdk.platformtools.x;

class b$f extends a {
    final /* synthetic */ b dhZ;
    private int dik;
    private String dil;
    private boolean dio = false;

    public b$f(b bVar, String str) {
        this.dhZ = bVar;
        this.dil = str;
        this.dik = 0;
    }

    public final boolean execute() {
        x.d("MicroMsg.FTS.FTS5SearchFriendLogic", "[InsertFriendTask mEntityId: %s, mFriendType: %s]", new Object[]{this.dil, Integer.valueOf(this.dik)});
        if (this.dik == 0) {
            com.tencent.mm.plugin.account.friend.a.a pq = ((b) ((com.tencent.mm.plugin.account.a.a.a) g.n(com.tencent.mm.plugin.account.a.a.a.class)).getAddrUploadStg()).pq(this.dil);
            if (pq == null) {
                this.dio = true;
            } else {
                b.a aVar = new b.a(pq);
                if (b.a(aVar)) {
                    b.a(this.dhZ, aVar);
                } else {
                    this.dio = true;
                }
            }
        }
        return true;
    }

    public final String toString() {
        return "InsertFriend(\"" + this.dil + "\", " + this.dik + ")" + (this.dio ? " [skipped]" : "");
    }
}

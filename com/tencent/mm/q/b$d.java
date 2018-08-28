package com.tencent.mm.q;

import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.a.c;
import com.tencent.mm.sdk.platformtools.x;

class b$d extends a {
    final /* synthetic */ b dhZ;
    private int dik = 0;
    private String dil;

    public b$d(b bVar, String str) {
        this.dhZ = bVar;
        this.dil = str;
    }

    public final boolean execute() {
        x.d("MicroMsg.FTS.FTS5SearchFriendLogic", "[DeleteFriendTask mEntityId: %s, mFriendType: %s]", new Object[]{this.dil, Integer.valueOf(this.dik)});
        if (this.dik == 0) {
            this.dhZ.dhX.b(c.jqm, (long) com.tencent.mm.plugin.account.friend.a.a.pn(this.dil));
        }
        return true;
    }

    public final String toString() {
        return "DeleteFriend(\"" + this.dil + "\", " + this.dik + ")";
    }
}

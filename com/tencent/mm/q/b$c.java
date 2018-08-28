package com.tencent.mm.q;

import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.a.c;
import com.tencent.mm.sdk.platformtools.x;

class b$c extends a {
    final /* synthetic */ b dhZ;
    private int dik = 0;
    private int mCount = 0;

    public b$c(b bVar) {
        this.dhZ = bVar;
    }

    public final boolean execute() {
        x.d("MicroMsg.FTS.FTS5SearchFriendLogic", "[DeleteAllFriendsTask mFriendType: %s]", new Object[]{Integer.valueOf(this.dik)});
        if (this.dik == 0) {
            this.mCount = this.dhZ.dhX.e(c.jqm, -1).size();
        }
        return true;
    }

    public final String toString() {
        return "DeleteAllFriends [" + this.mCount + ", " + this.dik + "]";
    }
}

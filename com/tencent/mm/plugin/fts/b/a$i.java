package com.tencent.mm.plugin.fts.b;

import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.storage.ab;

class a$i extends a {
    final /* synthetic */ a jtJ;
    private boolean jue;
    private String username;

    public a$i(a aVar, String str) {
        this.jtJ = aVar;
        this.username = str;
    }

    public final boolean execute() {
        if (a.b(this.jtJ).containsKey(this.username)) {
            this.jue = true;
        } else if (a.c(this.jtJ).add(this.username)) {
            ab Co = a.d(this.jtJ).Co(this.username);
            if (Co == null || this.jtJ.E(Co)) {
                com.tencent.mm.plugin.fts.c.a a = a.a(this.jtJ);
                String str = this.username;
                a.jpZ.bindLong(1, 2);
                a.jpZ.bindString(2, str);
                a.jpZ.bindLong(3, 0);
                a.jpZ.execute();
            } else {
                this.jue = true;
            }
        } else {
            this.jue = true;
        }
        return true;
    }

    public final String afC() {
        return String.format("{username: %s isSkipped: %b}", new Object[]{this.username, Boolean.valueOf(this.jue)});
    }

    public final String getName() {
        return "MarkContactTimestampTask";
    }
}

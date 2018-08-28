package com.tencent.mm.storage;

import com.tencent.mm.bt.h;
import com.tencent.mm.plugin.messenger.foundation.a.a.l;
import com.tencent.mm.sdk.e.j;

public final class bw extends j implements l {
    public static final String[] diD = new String[]{"CREATE TABLE IF NOT EXISTS verifycontact ( id INTEGER PRIMARY KEY, username varchar(40), nickname varchar(40), fullpy varchar(60), shortpy varchar(40), imgflag int, scene int, content text, status int, reserved1 int,reserved2 int,reserved3 text,reserved4 text)", "CREATE UNIQUE INDEX IF NOT EXISTS verifyContactIndex  ON verifycontact ( username )"};
    private h dCZ;

    public bw(h hVar) {
        this.dCZ = hVar;
    }
}

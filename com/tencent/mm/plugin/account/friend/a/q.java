package com.tencent.mm.plugin.account.friend.a;

import android.database.Cursor;
import com.tencent.mm.bt.h;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.bi;

public final class q extends j {
    public static final String[] diD = new String[]{"CREATE TABLE IF NOT EXISTS invitefriendopen ( username text  PRIMARY KEY , friendtype int  , updatetime int  , reserved1 int  , reserved2 int  , reserved3 text  , reserved4 text  ) "};
    private h dCZ;

    public q(h hVar) {
        this.dCZ = hVar;
    }

    public final boolean a(p pVar) {
        if (pz(pVar.getUsername())) {
            pVar.bWA = -1;
            if (this.dCZ.update("invitefriendopen", pVar.wH(), "username=?", new String[]{pVar.getUsername()}) > 0) {
                return true;
            }
            return false;
        }
        pVar.bWA = -1;
        if (((int) this.dCZ.insert("invitefriendopen", "username", pVar.wH())) == -1) {
            return false;
        }
        return true;
    }

    public final boolean pz(String str) {
        Cursor b = this.dCZ.b("select invitefriendopen.username,invitefriendopen.friendtype,invitefriendopen.updatetime,invitefriendopen.reserved1,invitefriendopen.reserved2,invitefriendopen.reserved3,invitefriendopen.reserved4 from invitefriendopen   where invitefriendopen.username = \"" + bi.oU(str) + "\"", null, 2);
        boolean moveToFirst = b.moveToFirst();
        b.close();
        return moveToFirst;
    }
}

package com.tencent.mm.ar;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.bt.h;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.bi;
import junit.framework.Assert;

public final class b extends j {
    public static final String[] diD = new String[]{"CREATE TABLE IF NOT EXISTS chattingbginfo ( username text  PRIMARY KEY , bgflag int  , path text  , reserved1 text  , reserved2 text  , reserved3 int  , reserved4 int  ) "};
    public h dCZ;

    public b(h hVar) {
        this.dCZ = hVar;
    }

    public final boolean a(a aVar) {
        aVar.bWA = -1;
        if (((int) this.dCZ.insert("chattingbginfo", "username", aVar.wH())) == -1) {
            return false;
        }
        Xp(aVar.getUsername());
        return true;
    }

    public final boolean b(a aVar) {
        Assert.assertTrue(aVar != null);
        ContentValues wH = aVar.wH();
        if (wH.size() > 0) {
            if (this.dCZ.update("chattingbginfo", wH, "username= ?", new String[]{aVar.getUsername()}) > 0) {
                Xp(aVar.getUsername());
                return true;
            }
        }
        return false;
    }

    public final a mw(String str) {
        a aVar = null;
        Cursor b = this.dCZ.b("select chattingbginfo.username,chattingbginfo.bgflag,chattingbginfo.path,chattingbginfo.reserved1,chattingbginfo.reserved2,chattingbginfo.reserved3,chattingbginfo.reserved4 from chattingbginfo   where chattingbginfo.username = \"" + bi.oU(str) + "\"", null, 2);
        if (b != null) {
            if (b.moveToFirst()) {
                aVar = new a();
                aVar.d(b);
            }
            b.close();
        }
        return aVar;
    }
}

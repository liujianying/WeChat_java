package com.tencent.mm.plugin.qmessage.a;

import android.database.Cursor;
import com.tencent.mm.bt.h;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.bi;
import junit.framework.Assert;

public final class e extends j {
    public static final String[] diD = new String[]{"CREATE TABLE IF NOT EXISTS qcontact ( username text  PRIMARY KEY , qq long  , extinfo text  , needupdate int  , extupdateseq long  , imgupdateseq long  , reserved1 int  , reserved2 int  , reserved3 int  , reserved4 int  , reserved5 text  , reserved6 text  , reserved7 text  , reserved8 text  ) "};
    private h dCZ;

    public e(h hVar) {
        this.dCZ = hVar;
    }

    public final boolean a(d dVar) {
        dVar.bWA = -1;
        return ((int) this.dCZ.insert("qcontact", "username", dVar.wH())) != -1;
    }

    public final boolean a(String str, d dVar) {
        boolean z = str != null && str.length() > 0;
        Assert.assertTrue(z);
        if (dVar == null) {
            return false;
        }
        if (this.dCZ.update("qcontact", dVar.wH(), "username=?", new String[]{str}) > 0) {
            return true;
        }
        return false;
    }

    public final d JM(String str) {
        d dVar = null;
        Cursor b = this.dCZ.b("select qcontact.username,qcontact.qq,qcontact.extinfo,qcontact.needupdate,qcontact.extupdateseq,qcontact.imgupdateseq,qcontact.reserved1,qcontact.reserved2,qcontact.reserved3,qcontact.reserved4,qcontact.reserved5,qcontact.reserved6,qcontact.reserved7,qcontact.reserved8 from qcontact   where qcontact.username = \"" + bi.oU(str) + "\"", null, 2);
        if (b != null) {
            if (b.moveToFirst()) {
                dVar = new d();
                dVar.username = b.getString(0);
                dVar.eLw = b.getLong(1);
                dVar.extInfo = b.getString(2);
                dVar.mbv = b.getInt(3);
                dVar.mbw = b.getLong(4);
                dVar.mbx = b.getLong(5);
                dVar.dCV = b.getInt(6);
                dVar.dSJ = b.getInt(7);
                dVar.dHN = b.getInt(8);
                dVar.dHO = b.getInt(9);
                dVar.mby = b.getString(10);
                dVar.mbz = b.getString(11);
                dVar.mbA = b.getString(12);
                dVar.mbB = b.getString(13);
            }
            b.close();
        }
        return dVar;
    }
}

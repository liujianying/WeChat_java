package com.tencent.mm.aa;

import android.database.Cursor;
import com.tencent.mm.bt.h;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.bi;

public final class i extends j {
    public static final String[] diD = new String[]{"CREATE TABLE IF NOT EXISTS hdheadimginfo ( username text  PRIMARY KEY , imgwidth int  , imgheigth int  , imgformat text  , totallen int  , startpos int  , headimgtype int  , reserved1 text  , reserved2 text  , reserved3 int  , reserved4 int  ) "};
    h dCZ;

    public i(h hVar) {
        this.dCZ = hVar;
    }

    public final int a(String str, h hVar) {
        return this.dCZ.update("hdheadimginfo", hVar.wH(), "username=?", new String[]{str});
    }

    public final h ka(String str) {
        h hVar = null;
        Cursor b = this.dCZ.b("select hdheadimginfo.username,hdheadimginfo.imgwidth,hdheadimginfo.imgheigth,hdheadimginfo.imgformat,hdheadimginfo.totallen,hdheadimginfo.startpos,hdheadimginfo.headimgtype,hdheadimginfo.reserved1,hdheadimginfo.reserved2,hdheadimginfo.reserved3,hdheadimginfo.reserved4 from hdheadimginfo   where hdheadimginfo.username = \"" + bi.oU(str) + "\"", null, 2);
        if (b != null) {
            if (b.moveToFirst()) {
                hVar = new h();
                hVar.username = b.getString(0);
                hVar.dHF = b.getInt(1);
                hVar.dHG = b.getInt(2);
                hVar.dHH = b.getString(3);
                hVar.dHI = b.getInt(4);
                hVar.dHJ = b.getInt(5);
                hVar.dHK = b.getInt(6);
                hVar.dHL = b.getString(7);
                hVar.dHM = b.getString(8);
                hVar.dHN = b.getInt(9);
                hVar.dHO = b.getInt(10);
            }
            b.close();
        }
        return hVar;
    }
}

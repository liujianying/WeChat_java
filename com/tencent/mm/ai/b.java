package com.tencent.mm.ai;

import android.content.ContentValues;
import com.tencent.mm.bt.h;
import com.tencent.mm.sdk.e.j;

public final class b extends j {
    public static final String[] diD = new String[]{"CREATE TABLE IF NOT EXISTS getcontactinfov2 ( username text  PRIMARY KEY , inserttime long  , type int  , lastgettime int  , reserved1 int  , reserved2 int  , reserved3 text  , reserved4 text  ) "};
    h dCZ;

    public b(h hVar) {
        this.dCZ = hVar;
    }

    public final boolean a(a aVar) {
        aVar.bWA = -1;
        ContentValues contentValues = new ContentValues();
        if ((aVar.bWA & 1) != 0) {
            contentValues.put("username", aVar.getUsername());
        }
        if ((aVar.bWA & 2) != 0) {
            contentValues.put("inserttime", Long.valueOf(aVar.dSH));
        }
        if ((aVar.bWA & 4) != 0) {
            contentValues.put("type", Integer.valueOf(aVar.type));
        }
        if ((aVar.bWA & 8) != 0) {
            contentValues.put("lastgettime", Integer.valueOf(aVar.dSI));
        }
        if ((aVar.bWA & 16) != 0) {
            contentValues.put("reserved1", Integer.valueOf(aVar.dCV));
        }
        if ((aVar.bWA & 32) != 0) {
            contentValues.put("reserved2", Integer.valueOf(aVar.dSJ));
        }
        if ((aVar.bWA & 64) != 0) {
            contentValues.put("reserved3", aVar.IB());
        }
        if ((aVar.bWA & 128) != 0) {
            contentValues.put("reserved4", aVar.OG());
        }
        if (((int) this.dCZ.replace("getcontactinfov2", "username", contentValues)) == -1) {
            return false;
        }
        Xp(aVar.getUsername());
        return true;
    }

    public final boolean lE(String str) {
        if (this.dCZ.delete("getcontactinfov2", "username= ?", new String[]{str}) <= 0) {
            return false;
        }
        Xp(str);
        return true;
    }
}

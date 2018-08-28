package com.tencent.mm.plugin.bottle.a;

import android.content.ContentValues;
import com.tencent.map.lib.mapstructure.MapRouteSectionWithName;
import com.tencent.mm.bt.h;
import com.tencent.mm.sdk.e.j;

public final class b extends j {
    public static final String[] diD = new String[]{"CREATE TABLE IF NOT EXISTS bottleinfo1 ( parentclientid text  , childcount int  , bottleid text  PRIMARY KEY , bottletype int  , msgtype int  , voicelen int  , content text  , createtime long  , reserved1 int  , reserved2 int  , reserved3 text  , reserved4 text  ) "};
    public h dCZ;

    public b(h hVar) {
        this.dCZ = hVar;
    }

    public final boolean a(a aVar) {
        aVar.bWA = -1;
        ContentValues contentValues = new ContentValues();
        if ((aVar.bWA & 1) != 0) {
            contentValues.put("parentclientid", aVar.hjN == null ? "" : aVar.hjN);
        }
        if ((aVar.bWA & 2) != 0) {
            contentValues.put("childcount", Integer.valueOf(aVar.hjO));
        }
        if ((aVar.bWA & 4) != 0) {
            contentValues.put("bottleid", aVar.aub());
        }
        if ((aVar.bWA & 8) != 0) {
            contentValues.put("bottletype", Integer.valueOf(aVar.hjQ));
        }
        if ((aVar.bWA & 16) != 0) {
            contentValues.put("msgtype", Integer.valueOf(aVar.msgType));
        }
        if ((aVar.bWA & 32) != 0) {
            contentValues.put("voicelen", Integer.valueOf(aVar.hjR));
        }
        if ((aVar.bWA & 64) != 0) {
            contentValues.put("content", aVar.getContent());
        }
        if ((aVar.bWA & MapRouteSectionWithName.kMaxRoadNameLength) != 0) {
            contentValues.put("createtime", Long.valueOf(aVar.hjS));
        }
        if ((aVar.bWA & 256) != 0) {
            contentValues.put("reserved1", Integer.valueOf(aVar.dCV));
        }
        if ((aVar.bWA & 512) != 0) {
            contentValues.put("reserved2", Integer.valueOf(aVar.dSJ));
        }
        if ((aVar.bWA & 1024) != 0) {
            contentValues.put("reserved3", aVar.dCX == null ? "" : aVar.dCX);
        }
        if ((aVar.bWA & 2048) != 0) {
            contentValues.put("reserved4", aVar.dCY == null ? "" : aVar.dCY);
        }
        if (((int) this.dCZ.insert("bottleinfo1", "bottleid", contentValues)) != -1) {
            return true;
        }
        return false;
    }
}

package com.tencent.mm.storage;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.a.f;
import com.tencent.mm.bt.h;
import com.tencent.mm.plugin.messenger.foundation.a.a.b;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.List;

public final class am extends j implements b {
    public static final String[] diD = new String[]{"CREATE TABLE IF NOT EXISTS DeletedConversationInfo ( userName TEXT  PRIMARY KEY , lastSeq LONG  , reserved1 INT  , reserved2 LONG  , reserved3 TEXT  ) ", "CREATE INDEX IF NOT EXISTS createTimeIndex  ON DeletedConversationInfo ( reserved2 )"};
    private h dCZ;
    private final f<String, Long> dzj = new f(50);

    public am(h hVar) {
        this.dCZ = hVar;
    }

    public final boolean F(String str, long j) {
        if (bi.oW(str)) {
            return false;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("userName", str);
        contentValues.put("lastSeq", Long.valueOf(j));
        contentValues.put("reserved2", Long.valueOf(Gw(str)));
        if (((int) this.dCZ.replace("DeletedConversationInfo", "userName", contentValues)) == -1) {
            return false;
        }
        Xp(str);
        return true;
    }

    public final long Gv(String str) {
        if (bi.oW(str)) {
            return 0;
        }
        Cursor b = this.dCZ.b("select lastSeq from DeletedConversationInfo where userName = \"" + bi.oU(str) + "\"", null, 2);
        if (b == null) {
            x.i("MicroMsg.DeletedConversationInfoStorage", "getLastSeq failed " + str);
            return 0;
        } else if (b.moveToFirst()) {
            long j = b.getLong(0);
            b.close();
            return j;
        } else {
            b.close();
            return 0;
        }
    }

    public final boolean G(String str, long j) {
        if (bi.oW(str)) {
            return false;
        }
        this.dzj.m(str, Long.valueOf(j));
        ContentValues contentValues = new ContentValues();
        contentValues.put("userName", str);
        contentValues.put("lastSeq", Long.valueOf(Gv(str)));
        contentValues.put("reserved2", Long.valueOf(j));
        if (((int) this.dCZ.replace("DeletedConversationInfo", "userName", contentValues)) == -1) {
            return false;
        }
        Xp(str);
        return true;
    }

    public final List<String> bda() {
        List arrayList = new ArrayList();
        Cursor b = this.dCZ.b("select userName,reserved2 from DeletedConversationInfo where reserved2 > 0", null, 2);
        if (b != null) {
            if (b.moveToFirst()) {
                do {
                    String string = b.getString(0);
                    this.dzj.m(string, Long.valueOf(b.getLong(1)));
                    arrayList.add(string);
                } while (b.moveToNext());
            }
            b.close();
        }
        return arrayList;
    }

    public final long Gw(String str) {
        if (bi.oW(str)) {
            return 0;
        }
        Long l = (Long) this.dzj.get(str);
        if (l != null) {
            return l.longValue();
        }
        Cursor b = this.dCZ.b("select reserved2 from DeletedConversationInfo where userName = \"" + bi.oU(str) + "\"", null, 2);
        if (b == null) {
            x.i("MicroMsg.DeletedConversationInfoStorage", "getCreateTime failed " + str);
            this.dzj.m(str, Long.valueOf(0));
            return 0;
        } else if (b.moveToFirst()) {
            long j = b.getLong(0);
            this.dzj.m(str, Long.valueOf(j));
            b.close();
            return j;
        } else {
            b.close();
            return 0;
        }
    }
}

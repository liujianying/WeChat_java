package com.tencent.mm.plugin.dbbackup.a;

import android.database.Cursor;
import com.tencent.mm.plugin.dbbackup.a.a.c;
import com.tencent.wcdb.database.SQLiteStatement;
import java.util.HashMap;

class a$5 implements c {
    final /* synthetic */ a iaS;
    final /* synthetic */ HashMap iaV;
    final /* synthetic */ int iaX;

    a$5(a aVar, int i, HashMap hashMap) {
        this.iaS = aVar;
        this.iaX = i;
        this.iaV = hashMap;
    }

    public final boolean a(Cursor cursor, SQLiteStatement sQLiteStatement) {
        Long l = (Long) this.iaV.get(Long.valueOf(cursor.getLong(this.iaX)));
        if (l != null) {
            sQLiteStatement.bindLong(this.iaX + 1, l.longValue());
        }
        return true;
    }
}

package com.tencent.mm.plugin.dbbackup.a;

import android.database.Cursor;
import com.tencent.mm.plugin.dbbackup.a.a.c;
import com.tencent.wcdb.database.SQLiteStatement;
import java.util.HashMap;

class a$3 implements c {
    final /* synthetic */ a iaS;
    final /* synthetic */ int iaT;
    final /* synthetic */ long[] iaU;
    final /* synthetic */ HashMap iaV;

    a$3(a aVar, int i, long[] jArr, HashMap hashMap) {
        this.iaS = aVar;
        this.iaT = i;
        this.iaU = jArr;
        this.iaV = hashMap;
    }

    public final boolean a(Cursor cursor, SQLiteStatement sQLiteStatement) {
        long j = cursor.getLong(this.iaT);
        long[] jArr = this.iaU;
        long j2 = jArr[0];
        jArr[0] = 1 + j2;
        this.iaV.put(Long.valueOf(j), Long.valueOf(j2));
        sQLiteStatement.bindLong(this.iaT + 1, j2);
        if (this.iaU[0] > 1000000 && this.iaU[0] <= 10000000) {
            this.iaU[0] = 10000001;
        }
        return true;
    }
}

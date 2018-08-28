package com.tencent.mm.plugin.sport.c;

import android.database.Cursor;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sport.b.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.wcdb.database.SQLiteDatabase;
import com.tencent.wcdb.database.SQLiteStatement;
import java.util.ArrayList;
import java.util.List;

public final class m extends i<e> {
    public static final String[] opo = new String[]{i.a(e.dhO, "SportStepItem")};
    private static final String[] opp;

    static {
        r0 = new String[2];
        r0[0] = String.format("CREATE INDEX IF NOT EXISTS %s_date ON %s(date);", new Object[]{"SportStepItem", "SportStepItem"});
        r0[1] = String.format("CREATE INDEX IF NOT EXISTS %s_timestamp ON %s(timestamp);", new Object[]{"SportStepItem", "SportStepItem"});
        opp = r0;
    }

    public m() {
        super(g.Ei().dqq, e.dhO, "SportStepItem", opp);
    }

    public static List<e> C(long j, long j2) {
        List arrayList = new ArrayList();
        String format = String.format("SELECT * FROM %s WHERE timestamp >= ? AND timestamp <= ?;", new Object[]{"SportStepItem"});
        Cursor b = g.Ei().dqq.b(format, new String[]{String.valueOf(j), String.valueOf(j2)}, 0);
        while (b.moveToNext()) {
            e eVar = new e();
            eVar.d(b);
            arrayList.add(eVar);
        }
        b.close();
        return arrayList;
    }

    public static e bFy() {
        e eVar = null;
        Cursor b = g.Ei().dqq.b(String.format("SELECT * FROM %s ORDER BY timestamp desc LIMIT 1;", new Object[]{"SportStepItem"}), null, 0);
        try {
            if (b.moveToNext()) {
                eVar = new e();
                eVar.d(b);
            } else {
                b.close();
            }
            return eVar;
        } finally {
            b.close();
        }
    }

    public static void D(long j, long j2) {
        g.Ei().dqq.fV(null, String.format("DELETE FROM %s WHERE timestamp >= %d AND timestamp <= endTime", new Object[]{"SportStepItem", Long.valueOf(j), Long.valueOf(j2)}));
    }

    public static void cx(List<e> list) {
        SQLiteDatabase coa = g.Ei().dqq.coa();
        if (!coa.inTransaction()) {
            coa.beginTransaction();
        }
        SQLiteStatement compileStatement = coa.compileStatement(String.format("INSERT INTO %s (date, step, timestamp) VALUES (?,?,?)", new Object[]{"SportStepItem"}));
        for (e eVar : list) {
            compileStatement.bindString(1, eVar.field_date);
            compileStatement.bindLong(2, (long) eVar.field_step);
            compileStatement.bindLong(3, eVar.field_timestamp);
            compileStatement.execute();
        }
        if (coa.inTransaction()) {
            coa.setTransactionSuccessful();
            coa.endTransaction();
        }
    }
}

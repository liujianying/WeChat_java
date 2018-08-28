package com.tencent.sqlitelint.behaviour.a;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import com.tencent.sqlitelint.SQLiteLintIssue;
import com.tencent.sqlitelint.util.SLog;
import com.tencent.sqlitelint.util.SQLiteLintUtil;
import java.util.ArrayList;
import java.util.List;

public final class a {
    public static final String vnP = String.format("CREATE TABLE IF NOT EXISTS %s (%s TEXT PRIMARY KEY NOT NULL, %s TEXT NOT NULL, %s INTEGER, %s TEXT, %s TEXT, %s TEXT, %s INTEGER, %s TEXT)", new Object[]{"Issue", "id", "dbPath", "level", "desc", "detail", "advice", "createTime", "extInfo"});
    public static final String[] vnQ;
    private static SQLiteStatement vnR;

    static {
        r0 = new String[2];
        r0[0] = String.format("CREATE INDEX IF NOT EXISTS %s ON %s(%s)", new Object[]{"DbLabel_Index", "Issue", "dbPath"});
        r0[1] = String.format("CREATE INDEX IF NOT EXISTS %s ON %s(%s,%s)", new Object[]{"DbLabel_CreateTime_Index", "Issue", "dbPath", "createTime"});
        vnQ = r0;
    }

    public static void ei(List<SQLiteLintIssue> list) {
        int i = 0;
        c.vnS.getDatabase().beginTransaction();
        while (true) {
            try {
                int i2 = i;
                if (i2 >= list.size()) {
                    break;
                }
                SQLiteLintIssue sQLiteLintIssue = (SQLiteLintIssue) list.get(i2);
                if (acJ(sQLiteLintIssue.id)) {
                    SLog.i("SQLiteLint.IssueStorage", "saveIssue already recorded id=%s", sQLiteLintIssue.id);
                } else {
                    if (vnR == null) {
                        vnR = c.vnS.getDatabase().compileStatement(String.format("INSERT INTO %s VALUES(?, ?, ?, ?, ?, ?, ?, ?)", new Object[]{"Issue"}));
                    }
                    SQLiteStatement sQLiteStatement = vnR;
                    sQLiteStatement.bindString(1, sQLiteLintIssue.id);
                    sQLiteStatement.bindString(2, sQLiteLintIssue.dbPath);
                    sQLiteStatement.bindLong(3, (long) sQLiteLintIssue.level);
                    sQLiteStatement.bindString(4, SQLiteLintUtil.oV(sQLiteLintIssue.desc));
                    sQLiteStatement.bindString(5, SQLiteLintUtil.oV(sQLiteLintIssue.detail));
                    sQLiteStatement.bindString(6, SQLiteLintUtil.oV(sQLiteLintIssue.advice));
                    sQLiteStatement.bindLong(7, sQLiteLintIssue.createTime);
                    sQLiteStatement.bindString(8, sQLiteLintIssue.extInfo);
                    SLog.d("SQLiteLint.IssueStorage", "saveIssue insert ret=%s, id=%s", Long.valueOf(sQLiteStatement.executeInsert()), sQLiteLintIssue.id);
                    if (sQLiteStatement.executeInsert() == -1) {
                        SLog.e("SQLiteLint.IssueStorage", "addIssue failed", new Object[0]);
                    }
                }
                i = i2 + 1;
            } finally {
                c.vnS.getDatabase().endTransaction();
            }
        }
        c.vnS.getDatabase().setTransactionSuccessful();
    }

    public static boolean acJ(String str) {
        boolean z = true;
        Cursor rawQuery = c.vnS.getDatabase().rawQuery(String.format("SELECT %s FROM %s WHERE %s='%s' limit 1", new Object[]{"id", "Issue", "id", str}), null);
        try {
            if (rawQuery.getCount() <= 0) {
                z = false;
            }
            rawQuery.close();
            return z;
        } catch (Throwable th) {
            rawQuery.close();
        }
    }

    public static List<SQLiteLintIssue> acK(String str) {
        List<SQLiteLintIssue> arrayList = new ArrayList();
        if (!SQLiteLintUtil.oW(str)) {
            Cursor rawQuery = c.vnS.getDatabase().rawQuery(String.format("SELECT * FROM %s where %s='%s' ORDER BY %s DESC", new Object[]{"Issue", "dbPath", str, "createTime"}), null);
            while (rawQuery.moveToNext()) {
                try {
                    SQLiteLintIssue sQLiteLintIssue = new SQLiteLintIssue();
                    sQLiteLintIssue.id = rawQuery.getString(rawQuery.getColumnIndex("id"));
                    sQLiteLintIssue.dbPath = rawQuery.getString(rawQuery.getColumnIndex("dbPath"));
                    sQLiteLintIssue.level = rawQuery.getInt(rawQuery.getColumnIndex("level"));
                    sQLiteLintIssue.desc = rawQuery.getString(rawQuery.getColumnIndex("desc"));
                    sQLiteLintIssue.detail = rawQuery.getString(rawQuery.getColumnIndex("detail"));
                    sQLiteLintIssue.advice = rawQuery.getString(rawQuery.getColumnIndex("advice"));
                    sQLiteLintIssue.createTime = rawQuery.getLong(rawQuery.getColumnIndex("createTime"));
                    sQLiteLintIssue.extInfo = rawQuery.getString(rawQuery.getColumnIndex("extInfo"));
                    arrayList.add(sQLiteLintIssue);
                } finally {
                    rawQuery.close();
                }
            }
        }
        return arrayList;
    }

    public static List<String> cGh() {
        List<String> arrayList = new ArrayList();
        Cursor rawQuery = c.vnS.getDatabase().rawQuery(String.format("SELECT DISTINCT(%s) FROM %s", new Object[]{"dbPath", "Issue"}), null);
        while (rawQuery.moveToNext()) {
            try {
                arrayList.add(rawQuery.getString(rawQuery.getColumnIndex("dbPath")));
            } finally {
                rawQuery.close();
            }
        }
        return arrayList;
    }

    public static long cGi() {
        Cursor rawQuery = c.vnS.getDatabase().rawQuery(String.format("SELECT rowid FROM %s order by rowid desc limit 1", new Object[]{"Issue"}), null);
        if (rawQuery != null) {
            try {
                if (rawQuery.getCount() > 0) {
                    rawQuery.moveToFirst();
                    long j = rawQuery.getLong(0);
                    return j;
                }
            } finally {
                rawQuery.close();
            }
        }
        rawQuery.close();
        return -1;
    }
}

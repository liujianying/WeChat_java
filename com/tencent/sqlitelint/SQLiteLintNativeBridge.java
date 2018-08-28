package com.tencent.sqlitelint;

import android.database.Cursor;
import android.database.SQLException;
import com.tencent.sqlitelint.util.SLog;
import java.util.ArrayList;

public class SQLiteLintNativeBridge {
    private static final String TAG = "SQLiteLint.SQLiteLintNativeBridge";

    private native void execSqlCallback(long j, long j2, String str, int i, String[] strArr, String[] strArr2);

    public static native void nativeAddToWhiteList(String str, String[] strArr, String[][] strArr2);

    public static native void nativeEnableCheckers(String str, String[] strArr);

    static native void nativeInstall(String str);

    static native void nativeNotifySqlExecute(String str, String str2, long j, String str3);

    static native void nativeUninstall(String str);

    public static void loadLibrary() {
        System.loadLibrary("SqliteLint-lib");
        SLog.nativeSetLogger(2);
    }

    SQLiteLintNativeBridge() {
    }

    private static void onPublishIssue(String str, ArrayList<SQLiteLintIssue> arrayList) {
        try {
            g.vnt.acI(str).eh(arrayList);
        } catch (Throwable th) {
            SLog.e(TAG, "onPublishIssue ex ", th.getMessage());
        }
    }

    private String[] sqliteLintExecSql(String str, String str2, boolean z, long j, long j2) {
        String[] strArr = new String[2];
        try {
            SLog.i(TAG, "dbPath %s, sql is %s ,needCallBack: %b", str, str2, Boolean.valueOf(z));
            strArr[0] = "";
            strArr[1] = "-1";
            c cVar = null;
            f acI = g.vnt.acI(str);
            if (acI != null) {
                cVar = acI.vnl;
            }
            if (cVar == null) {
                SLog.w(TAG, "sqliteLintExecSql mExecSqlImp is null", new Object[0]);
            } else if (z) {
                Cursor rawQuery = cVar.rawQuery(str2, new String[0]);
                if (rawQuery == null || rawQuery.getCount() < 0) {
                    SLog.w(TAG, "sqliteLintExecSql cu is null", new Object[0]);
                    strArr[0] = "Cursor is null";
                } else {
                    doExecSqlCallback(j, j2, str, rawQuery);
                    strArr[1] = "0";
                }
                if (rawQuery != null) {
                    rawQuery.close();
                }
            } else {
                try {
                    cVar.execSQL(str2);
                    strArr[1] = "0";
                } catch (SQLException e) {
                    SLog.w(TAG, "sqliteLintExecSql execSQL exp: %s", e.getMessage());
                    strArr[0] = e.getMessage();
                }
            }
        } catch (Exception e2) {
            SLog.w(TAG, "sqliteLintExecSql rawQuery exp: %s", e2.getMessage());
            strArr[0] = e2.getMessage();
        } catch (Throwable th) {
            SLog.e(TAG, "sqliteLintExecSql ex ", th.getMessage());
        }
        return strArr;
    }

    private void doExecSqlCallback(long j, long j2, String str, Cursor cursor) {
        if (cursor == null) {
            SLog.w(TAG, "doExecSqlCallback cu is null", new Object[0]);
            return;
        }
        while (cursor.moveToNext()) {
            int columnCount = cursor.getColumnCount();
            String[] strArr = new String[columnCount];
            String[] strArr2 = new String[columnCount];
            for (int i = 0; i < columnCount; i++) {
                strArr[i] = cursor.getColumnName(i);
                switch (cursor.getType(i)) {
                    case 1:
                        strArr2[i] = String.valueOf(cursor.getLong(i));
                        break;
                    case 2:
                        strArr2[i] = String.valueOf(cursor.getFloat(i));
                        break;
                    case 3:
                        strArr2[i] = String.valueOf(cursor.getString(i));
                        break;
                    case 4:
                        strArr2[i] = String.valueOf(cursor.getBlob(i));
                        break;
                    default:
                        strArr2[i] = "";
                        break;
                }
            }
            execSqlCallback(j, j2, str, columnCount, strArr2, strArr);
        }
    }
}

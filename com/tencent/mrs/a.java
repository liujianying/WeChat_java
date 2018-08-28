package com.tencent.mrs;

import android.database.Cursor;
import android.text.TextUtils;
import com.tencent.matrix.mrs.core.MatrixReport;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.sqlitelint.c;
import com.tencent.sqlitelint.e;
import com.tencent.sqlitelint.h;
import com.tencent.sqlitelint.util.SLog;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.util.HashMap;
import java.util.Map;

public final class a {
    public static com.tencent.mrs.b.a uZP;

    public static final class b {
        private static Map<String, Boolean> uZQ = new HashMap();
        private static h uZR;

        public static void a(SQLiteDatabase sQLiteDatabase, String str, long j) {
            if (com.tencent.matrix.a.isInstalled()) {
                if (uZR == null) {
                    h hVar = (h) com.tencent.matrix.a.tg().g(h.class);
                    uZR = hVar;
                    if (hVar == null) {
                        return;
                    }
                }
                if (uZR.tw()) {
                    x.v("Matrix.Manager", "onSQLExecuted  String sql:%s,  timeCost:%d", str, Long.valueOf(j));
                    String path = sQLiteDatabase.getPath();
                    if (!uZQ.containsKey(path)) {
                        com.tencent.sqlitelint.e.a aVar = new com.tencent.sqlitelint.e.a(path, new a(sQLiteDatabase));
                        com.tencent.sqlitelint.e.b.a aVar2 = new com.tencent.sqlitelint.e.b.a();
                        aVar2.vno |= 2;
                        aVar2.vno &= -2;
                        com.tencent.sqlitelint.a.a.a aVar3 = new com.tencent.sqlitelint.a.a.a(aVar, aVar2.cGg());
                        aVar3.acL("AvoidAutoIncrementChecker");
                        aVar3.acL("AvoidSelectAllChecker");
                        aVar3.acL("ExplainQueryPlanChecker");
                        aVar3.acL("RedundantIndexChecker");
                        aVar3.acL("WithoutRowIdBetterChecker");
                        aVar3.acL("PreparedStatementBetterChecker");
                        String str2 = aVar3.vnX.vnk;
                        if (str2.endsWith("EnMicroMsg.db")) {
                            aVar3.vnZ = com.tencent.mm.plugin.report.e.a.enmicromsg_sqlite_lint_whitelist;
                        } else if (str2.endsWith("AppBrandComm.db")) {
                            aVar3.vnZ = com.tencent.mm.plugin.report.e.a.appbrandcomm_sqlite_lint_whitelist;
                        } else if (str2.endsWith("SnsMicroMsg.db")) {
                            aVar3.vnZ = com.tencent.mm.plugin.report.e.a.snsmicromsg_sqlite_lint_whitelist;
                        }
                        h hVar2 = uZR;
                        if (hVar2.tw()) {
                            com.tencent.sqlitelint.a.a aVar4 = hVar2.vnw;
                            if (aVar3.vnX != null) {
                                Object obj = aVar3.vnX.vnk;
                                if (!TextUtils.isEmpty(obj)) {
                                    for (int i = 0; i < aVar4.vnW.size(); i++) {
                                        if (obj.equals(aVar3.vnX.vnk)) {
                                            break;
                                        }
                                    }
                                    aVar4.vnW.add(aVar3);
                                }
                            }
                            str2 = aVar3.vnX.vnk;
                            e.a(hVar2.mContext, aVar3.vnX, aVar3.vnY);
                            e.dD(str2, aVar3.vnZ);
                            e.v(str2, aVar3.voa);
                        } else {
                            SLog.i("Matrix.SQLiteLintPlugin", "addConcernedDB isPluginStarted not", new Object[0]);
                        }
                        uZQ.put(path, Boolean.valueOf(true));
                    }
                    int i2 = (int) j;
                    if (uZR.tw()) {
                        e.M(path, str, i2);
                    } else {
                        SLog.i("Matrix.SQLiteLintPlugin", "notifySqlExecution isPluginStarted not", new Object[0]);
                    }
                }
            }
        }
    }

    private static final class a implements c {
        private final SQLiteDatabase mDb;

        a(SQLiteDatabase sQLiteDatabase) {
            this.mDb = sQLiteDatabase;
        }

        public final Cursor rawQuery(String str, String... strArr) {
            if (this.mDb.isOpen()) {
                return this.mDb.rawQuery(str, strArr);
            }
            x.w("Matrix.Manager", "rawQuery db close", new Object[0]);
            return null;
        }

        public final void execSQL(String str) {
            if (this.mDb.isOpen()) {
                this.mDb.execSQL(str);
            } else {
                x.w("Matrix.Manager", "rawQuery db close", new Object[0]);
            }
        }
    }

    public static void onDestroy() {
        if (MatrixReport.isInstalled()) {
            MatrixReport.with().onDestroy();
        } else {
            com.tencent.matrix.d.b.e("Matrix.Manager", "onDestroy, matrix report is not installed, just return", new Object[0]);
        }
    }
}

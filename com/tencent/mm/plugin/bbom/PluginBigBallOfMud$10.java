package com.tencent.mm.plugin.bbom;

import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.au;
import com.tencent.mm.model.d.b;
import com.tencent.mm.model.d.b.3;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mrs.a;
import com.tencent.wcdb.database.SQLiteDatabase;
import com.tencent.wcdb.database.SQLiteTrace;
import java.util.List;

class PluginBigBallOfMud$10 implements SQLiteTrace {
    final /* synthetic */ PluginBigBallOfMud heA;

    PluginBigBallOfMud$10(PluginBigBallOfMud pluginBigBallOfMud) {
        this.heA = pluginBigBallOfMud;
    }

    public final void onSQLExecuted(SQLiteDatabase sQLiteDatabase, String str, int i, long j) {
        try {
            b JG = b.JG();
            boolean isMainThread = ah.isMainThread();
            String path = sQLiteDatabase.getPath();
            a.b.a(sQLiteDatabase, str, j);
            if ((j > JG.dFf && isMainThread) || (j > JG.dFh && !isMainThread)) {
                for (String str2 : b.dFn) {
                    if (!isMainThread && path.contains(str2)) {
                        return;
                    }
                }
                if (i != 2 || !isMainThread || j >= JG.dFg) {
                    if (JG.dEK) {
                        x.i("MicroMsg.SQLTraceManager", "mark stop as file is full !");
                        return;
                    }
                    String toUpperCase = str.trim().toUpperCase();
                    if (toUpperCase.startsWith("INSERT") || toUpperCase.startsWith("UPDATE") || toUpperCase.startsWith("DELETE") || toUpperCase.startsWith("COMMIT") || toUpperCase.startsWith("SELECT")) {
                        if (toUpperCase.startsWith("INSERT")) {
                            toUpperCase = toUpperCase.substring(0, toUpperCase.indexOf("(", 0));
                        } else if (toUpperCase.startsWith("COMMIT")) {
                            toUpperCase = j > JG.dFi ? toUpperCase + "task:" + bi.cjd() : null;
                        }
                        if (toUpperCase.length() > WXMediaMessage.TITLE_LENGTH_LIMIT) {
                            toUpperCase = toUpperCase.substring(0, WXMediaMessage.TITLE_LENGTH_LIMIT) + "...";
                        }
                        if (!toUpperCase.trim().endsWith(";")) {
                            toUpperCase = toUpperCase + ";";
                        }
                    } else {
                        toUpperCase = null;
                    }
                    if (!bi.oW(toUpperCase)) {
                        StringBuilder stringBuilder = new StringBuilder();
                        b.a("tid", String.valueOf(Thread.currentThread().getId()), stringBuilder);
                        b.a("sql", toUpperCase, stringBuilder);
                        b.a("lastTime", String.valueOf(j), stringBuilder);
                        b.a("foreground", com.tencent.mm.sdk.a.b.foreground ? "1" : "0", stringBuilder);
                        b.a("tname", Thread.currentThread().getName(), stringBuilder);
                        toUpperCase = stringBuilder.toString();
                        x.d("MicroMsg.SQLTraceManager", "SQL Trace mark : " + toUpperCase);
                        au.Em().H(new 3(JG, toUpperCase));
                    }
                }
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.SQLiteTrace", e, "Failed to send trace.", new Object[0]);
        }
    }

    public final void onConnectionObtained(SQLiteDatabase sQLiteDatabase, String str, long j, boolean z) {
    }

    public final void onConnectionPoolBusy(SQLiteDatabase sQLiteDatabase, String str, List<String> list, String str2) {
        int cij;
        boolean z = HardCoderJNI.hcDBEnable;
        int i = HardCoderJNI.hcDBDelayWrite;
        int i2 = HardCoderJNI.hcDBCPU;
        int i3 = HardCoderJNI.hcDBIO;
        if (HardCoderJNI.hcDBThr) {
            cij = g.Em().cij();
        } else {
            cij = 0;
        }
        HardCoderJNI.startPerformance(z, i, i2, i3, cij, HardCoderJNI.hcDBTimeoutBusy, 501, HardCoderJNI.hcDBActionWrite, "MicroMsg.PluginBigBallOfMud");
    }

    public final void onDatabaseCorrupted(SQLiteDatabase sQLiteDatabase) {
    }
}

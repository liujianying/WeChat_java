package com.tencent.mm.plugin.zero.tasks;

import android.os.Process;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.sdk.platformtools.x.a;
import com.tencent.wcdb.support.Log.LogCallback;
import java.util.HashSet;

class a$1 implements LogCallback {
    private final HashSet<String> qxV = new HashSet();
    final /* synthetic */ a qxW;

    a$1(a aVar) {
        this.qxW = aVar;
    }

    public final void println(int i, String str, String str2) {
        a chQ = x.chQ();
        int myPid = Process.myPid();
        int myTid = Process.myTid();
        switch (i) {
            case 2:
                chQ.logV(str, "", "", 0, myPid, (long) myTid, (long) myPid, str2);
                return;
            case 3:
                chQ.logD(str, "", "", 0, myPid, (long) myTid, (long) myPid, str2);
                return;
            case 4:
                chQ.logI(str, "", "", 0, myPid, (long) myTid, (long) myPid, str2);
                return;
            case 5:
                chQ.logW(str, "", "", 0, myPid, (long) myTid, (long) myPid, str2);
                if (str.equals("WCDB.SQLite") && str2.startsWith("[SQLite ErrCode: 284] automatic index on ")) {
                    boolean add;
                    String substring = str2.substring(41);
                    synchronized (this.qxV) {
                        add = this.qxV.add(substring);
                    }
                    if (!add) {
                        try {
                            f.mDy.c("DBAutoIndex", substring, null);
                            return;
                        } catch (Exception e) {
                            x.e("DBLogger", "Cannot report automatic index: " + e.getMessage());
                            return;
                        }
                    }
                    return;
                }
                return;
            case 6:
                chQ.logE(str, "", "", 0, myPid, (long) myTid, (long) myPid, str2);
                return;
            case 7:
                chQ.logF(str, "", "", 0, myPid, (long) myTid, (long) myPid, str2);
                return;
            default:
                return;
        }
    }
}

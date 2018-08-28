package com.tencent.recovery.log;

import com.tencent.recovery.log.RecoveryLog.RecoveryLogImpl;
import java.util.ArrayList;
import java.util.List;

public class RecoveryCacheLog implements RecoveryLogImpl {
    List<LogItem> vhn = new ArrayList(100);

    private class LogItem {
        int level;
        String tag;
        String vho;
        Object[] vhp;
        Throwable vhq;

        private LogItem() {
        }

        /* synthetic */ LogItem(RecoveryCacheLog recoveryCacheLog, byte b) {
            this();
        }
    }

    public final void v(String str, String str2, Object... objArr) {
        if (this.vhn.size() < 100) {
            LogItem logItem = new LogItem(this, (byte) 0);
            logItem.level = 1;
            logItem.tag = str;
            logItem.vho = str2;
            logItem.vhp = objArr;
            this.vhn.add(logItem);
        }
        String.format(str2, objArr);
    }

    public final void d(String str, String str2, Object... objArr) {
        if (this.vhn.size() < 100) {
            LogItem logItem = new LogItem(this, (byte) 0);
            logItem.level = 2;
            logItem.tag = str;
            logItem.vho = str2;
            logItem.vhp = objArr;
            this.vhn.add(logItem);
        }
        String.format(str2, objArr);
    }

    public final void i(String str, String str2, Object... objArr) {
        if (this.vhn.size() < 100) {
            LogItem logItem = new LogItem(this, (byte) 0);
            logItem.level = 3;
            logItem.tag = str;
            logItem.vho = str2;
            logItem.vhp = objArr;
            this.vhn.add(logItem);
        }
        String.format(str2, objArr);
    }

    public final void w(String str, String str2, Object... objArr) {
        if (this.vhn.size() < 100) {
            LogItem logItem = new LogItem(this, (byte) 0);
            logItem.level = 4;
            logItem.tag = str;
            logItem.vho = str2;
            logItem.vhp = objArr;
            this.vhn.add(logItem);
        }
        String.format(str2, objArr);
    }

    public final void e(String str, String str2, Object... objArr) {
        if (this.vhn.size() < 100) {
            LogItem logItem = new LogItem(this, (byte) 0);
            logItem.level = 5;
            logItem.tag = str;
            logItem.vho = str2;
            logItem.vhp = objArr;
            this.vhn.add(logItem);
        }
        String.format(str2, objArr);
    }

    public final void printErrStackTrace(String str, Throwable th, String str2, Object... objArr) {
        if (this.vhn.size() < 100) {
            LogItem logItem = new LogItem(this, (byte) 0);
            logItem.level = 5;
            logItem.tag = str;
            logItem.vho = str2;
            logItem.vhp = objArr;
            logItem.vhq = th;
            this.vhn.add(logItem);
        }
        String.format(str2, objArr);
    }
}

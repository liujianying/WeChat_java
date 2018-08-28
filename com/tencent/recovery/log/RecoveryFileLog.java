package com.tencent.recovery.log;

import android.os.Process;
import android.util.Log;
import com.tencent.recovery.log.RecoveryLog.RecoveryLogImpl;
import com.tencent.recovery.storage.MMappedFileStorage;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RecoveryFileLog implements RecoveryLogImpl {
    private MMappedFileStorage vhs;
    private SimpleDateFormat vht;
    private boolean vhu;

    public final synchronized void bC(String str, boolean z) {
        this.vhs.f(str.getBytes(), z);
    }

    public final void v(String str, String str2, Object... objArr) {
        bC(au("V", str, String.format(str2, objArr)), false);
        if (this.vhu) {
            String.format(str2, objArr);
        }
    }

    public final void i(String str, String str2, Object... objArr) {
        bC(au("I", str, String.format(str2, objArr)), false);
        if (this.vhu) {
            String.format(str2, objArr);
        }
    }

    public final void w(String str, String str2, Object... objArr) {
        bC(au("W", str, String.format(str2, objArr)), false);
        if (this.vhu) {
            String.format(str2, objArr);
        }
    }

    public final void d(String str, String str2, Object... objArr) {
        bC(au("D", str, String.format(str2, objArr)), false);
        if (this.vhu) {
            String.format(str2, objArr);
        }
    }

    public final void e(String str, String str2, Object... objArr) {
        bC(au("E", str, String.format(str2, objArr)), false);
        if (this.vhu) {
            String.format(str2, objArr);
        }
    }

    public final void printErrStackTrace(String str, Throwable th, String str2, Object... objArr) {
        String str3 = "E";
        bC(au(str3, str, String.format(str2, objArr) + "  " + Log.getStackTraceString(th)), false);
        if (this.vhu) {
            String.format(str2, objArr);
        }
    }

    private String au(String str, String str2, String str3) {
        String format = this.vht.format(new Date());
        return String.format("%s​%s​[%d][%d][%s]: %s​​", new Object[]{str, str2, Integer.valueOf(Process.myPid()), Long.valueOf(Thread.currentThread().getId()), format, str3});
    }
}

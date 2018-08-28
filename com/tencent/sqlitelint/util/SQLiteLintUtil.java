package com.tencent.sqlitelint.util;

import com.tencent.sqlitelint.e;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.ListIterator;

public class SQLiteLintUtil {
    public static boolean oW(String str) {
        return str == null || str.length() <= 0;
    }

    public static String oV(String str) {
        return str == null ? "" : str;
    }

    public static String acM(String str) {
        if (oW(str)) {
            return null;
        }
        String[] split = str.split("/");
        if (split == null || split.length <= 0) {
            return null;
        }
        return split[split.length - 1];
    }

    public static String h(String str, long j) {
        return new SimpleDateFormat(str).format(new Date(j));
    }

    public static String getThrowableStack(Throwable th) {
        if (th == null) {
            return "";
        }
        StackTraceElement[] stackTrace = th.getStackTrace();
        if (stackTrace == null) {
            return "";
        }
        ArrayList arrayList = new ArrayList(stackTrace.length);
        for (int i = 0; i < stackTrace.length; i++) {
            if (!stackTrace[i].getClassName().contains("com.tencent.sqlitelint")) {
                arrayList.add(stackTrace[i]);
            }
        }
        if (arrayList.size() > 6 && e.bqz != null) {
            ListIterator listIterator = arrayList.listIterator(arrayList.size());
            while (listIterator.hasPrevious()) {
                if (!((StackTraceElement) listIterator.previous()).getClassName().contains(e.bqz)) {
                    listIterator.remove();
                }
                if (arrayList.size() <= 6) {
                    break;
                }
            }
        }
        StringBuffer stringBuffer = new StringBuffer(arrayList.size());
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            stringBuffer.append((StackTraceElement) it.next()).append(10);
        }
        return stringBuffer.toString();
    }

    public static String getThrowableStack() {
        try {
            return getThrowableStack(new Throwable());
        } catch (Throwable th) {
            SLog.e("SQLiteLint.SQLiteLintUtil", "getThrowableStack ex %s", th.getMessage());
            return "";
        }
    }
}

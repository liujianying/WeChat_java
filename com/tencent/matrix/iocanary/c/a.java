package com.tencent.matrix.iocanary.c;

import android.content.Context;
import com.tencent.matrix.c.b;
import com.tencent.matrix.iocanary.core.IOIssue;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;
import org.json.JSONException;
import org.json.JSONObject;

public final class a {
    private static String bqz = null;

    public static void ay(Context context) {
        if (bqz == null) {
            bqz = context.getPackageName();
        }
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
            String className = stackTrace[i].getClassName();
            if (!(className.contains("libcore.io") || className.contains("com.tencent.matrix.iocanary") || className.contains("java.io") || className.contains("dalvik.system") || className.contains("android.os"))) {
                arrayList.add(stackTrace[i]);
            }
        }
        if (arrayList.size() > 10 && bqz != null) {
            ListIterator listIterator = arrayList.listIterator(arrayList.size());
            while (listIterator.hasPrevious()) {
                if (!((StackTraceElement) listIterator.previous()).getClassName().contains(bqz)) {
                    listIterator.remove();
                }
                if (arrayList.size() <= 10) {
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

    public static b a(IOIssue iOIssue) {
        if (iOIssue == null) {
            return null;
        }
        b bVar = new b(iOIssue.type);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("path", iOIssue.path);
            jSONObject.put("size", iOIssue.fileSize);
            jSONObject.put("op", iOIssue.opCnt);
            jSONObject.put("buffer", iOIssue.bufferSize);
            jSONObject.put("cost", iOIssue.opCostTime);
            jSONObject.put("opType", iOIssue.opType);
            jSONObject.put("opSize", iOIssue.opSize);
            jSONObject.put("thread", iOIssue.threadName);
            jSONObject.put("stack", iOIssue.stack);
            jSONObject.put("repeat", iOIssue.repeatReadCnt);
        } catch (JSONException e) {
        }
        bVar.brm = jSONObject;
        return bVar;
    }
}

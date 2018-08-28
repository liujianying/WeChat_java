package com.tencent.mrs.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.os.MessageQueue.IdleHandler;
import com.tencent.matrix.d.b;
import com.tencent.matrix.mrs.core.MatrixReport;
import com.tencent.mm.sdk.platformtools.s;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class MatrixReportBroadcast extends BroadcastReceiver {
    private static final HashMap<String, ArrayList<a>> uZW = new HashMap();

    private static class a {
        String tag;
        String value;

        a(String str, String str2) {
            this.tag = str;
            this.value = str2;
        }
    }

    public void onReceive(Context context, Intent intent) {
        if (intent == null) {
            b.e("Matrix.ReportBroadcast", "MatrixReportBroadcast intent == null", new Object[0]);
            return;
        }
        String j = s.j(intent, "tag");
        String j2 = s.j(intent, "value");
        if (MatrixReport.isInstalled()) {
            b.i("Matrix.ReportBroadcast", "MatrixReportBroadcast, receive broadcast with tag %s, value:%s", j, j2);
            MatrixReport.with().reportLocal(j, j2);
            return;
        }
        b.e("Matrix.ReportBroadcast", "MatrixReportBroadcast, matrix report is not init, wait to report plugin:%s, content:%s", j, j2);
        a aVar = new a(j, j2);
        ArrayList arrayList = (ArrayList) uZW.get(j);
        if (arrayList == null) {
            arrayList = new ArrayList();
        }
        arrayList.add(aVar);
    }

    public static void cEa() {
        Looper.getMainLooper();
        Looper.myQueue().addIdleHandler(new IdleHandler() {
            public final boolean queueIdle() {
                for (String str : MatrixReportBroadcast.uZW.keySet()) {
                    b.i("Matrix.ReportBroadcast", "MatrixReportBroadcast, matrix report pending issues tag:%s, size:%d", str, Integer.valueOf(((ArrayList) MatrixReportBroadcast.uZW.get((String) r2.next())).size()));
                    Iterator it = r1.iterator();
                    while (it.hasNext()) {
                        a aVar = (a) it.next();
                        MatrixReport.with().reportLocal(aVar.tag, aVar.value);
                    }
                }
                MatrixReportBroadcast.uZW.clear();
                return false;
            }
        });
    }
}

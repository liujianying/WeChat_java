package com.tencent.mm.plugin.sns.model;

import android.os.Looper;
import com.tencent.mm.a.g;
import com.tencent.mm.sdk.platformtools.bi;
import java.util.HashMap;
import java.util.Map;

public final class an {
    private static final Map<String, String> nrt = new HashMap();

    public static String s(String str, String str2) {
        if (str2 == null) {
            return "";
        }
        String str3;
        boolean equals = Looper.getMainLooper().equals(Looper.myLooper());
        if (equals && nrt.containsKey(str + str2)) {
            str3 = (String) nrt.get(str + str2);
            if (!bi.oW(str3)) {
                return str3;
            }
        }
        str3 = g.u(str2.getBytes());
        StringBuffer stringBuffer = new StringBuffer(str);
        if (str3.length() > 0) {
            stringBuffer.append(str3.charAt(0));
            stringBuffer.append("/");
        }
        if (str3.length() >= 2) {
            stringBuffer.append(str3.charAt(1));
            stringBuffer.append("/");
        }
        if (equals) {
            nrt.put(str + str2, stringBuffer.toString());
        }
        return stringBuffer.toString();
    }

    public static synchronized void release() {
        synchronized (an.class) {
            nrt.clear();
        }
    }
}

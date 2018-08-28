package com.tencent.pb.common.c;

import com.tencent.pb.talkroom.sdk.e;
import com.tencent.wecall.talkroom.model.f;

public final class c {
    public static int level = 0;
    private static int vgd = 2;
    private static boolean vge = false;

    public static void cED() {
        vgd = 0;
        vge = true;
    }

    private static void D(int i, String str, String str2) {
        e cHX = f.cHX();
        if (cHX != null) {
            cHX.m(i, "MTSDK" + str, str2);
        }
    }

    public static void d(String str, Object... objArr) {
        if (vge && vgd <= 1 && str != null) {
            D(1, str, " " + B(objArr));
        }
    }

    public static void w(String str, Object... objArr) {
        if (vge && vgd <= 2) {
            D(2, str, " " + B(objArr));
        }
    }

    public static void x(String str, Object... objArr) {
        if (vge && vgd <= 3 && str != null) {
            D(3, str, " " + B(objArr));
        }
    }

    public static void e(String str, Object... objArr) {
        if (vge && vgd <= 4) {
            D(4, str, " " + B(objArr));
        }
    }

    private static String B(Object[] objArr) {
        if (objArr == null || objArr.length == 0) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer(250);
        for (Object obj : objArr) {
            if (obj != null) {
                stringBuffer.append("|");
                if (obj instanceof Throwable) {
                    stringBuffer.append(((Throwable) obj).getMessage());
                } else {
                    stringBuffer.append(obj.toString());
                }
            }
        }
        return stringBuffer.toString();
    }
}

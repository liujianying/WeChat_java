package com.tencent.mm.protocal;

import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.wcdb.FileUtils;
import junit.framework.Assert;

public final class d extends e {
    public static final String DEVICE_NAME = (Build.MANUFACTURER + "-" + Build.MODEL);
    public static String DEVICE_TYPE = ("android-" + VERSION.SDK_INT);
    public static final String qVH = Build.BRAND;
    public static final String qVI = (Build.MODEL + Build.CPU_ABI);
    public static String qVJ = ("android-" + VERSION.SDK_INT);
    public static final String qVK = ("android-" + Build.MANUFACTURER);
    public static String qVL = (VERSION.SDK_INT);
    public static long qVM = 0;
    public static int qVN;
    public static boolean qVO = cge();
    public static boolean qVP = cgd();
    public static boolean qVQ = cgb();
    public static boolean qVR = cga();
    public static boolean qVS = cgc();
    public static int qVT = 5;
    public static final byte[] qVU = null;
    public static final byte[] qVV = null;
    public static final byte[] qVW = null;

    public static void CA(int i) {
        qVN = i;
        qVQ = cgb();
        qVR = cga();
        qVO = cge();
        qVP = cgd();
        qVS = cgc();
    }

    static {
        qVN = Integer.decode(com.tencent.mm.sdk.platformtools.d.CLIENT_VERSION).intValue();
        Assert.assertNotNull(com.tencent.mm.sdk.platformtools.d.CLIENT_VERSION);
        try {
            int i = ad.getContext().getPackageManager().getApplicationInfo(ad.getPackageName(), FileUtils.S_IWUSR).metaData.getInt("com.tencent.mm.BuildInfo.CLIENT_VERSION");
            if (i > qVN && i - qVN < 255 && (i & 255) >= 48) {
                qVN = i;
            }
        } catch (Exception e) {
            x.k("MicroMsg.ConstantsProtocal", "", e);
        }
    }

    private static boolean cga() {
        return (qVN & 255) >= 32 && (qVN & 255) <= 47;
    }

    private static boolean cgb() {
        return (qVN & 255) >= 0 && (qVN & 255) <= 31;
    }

    private static boolean cgc() {
        return (qVN & 255) >= 0 && (qVN & 255) <= 15;
    }

    private static boolean cgd() {
        return (qVN & 255) >= 96 && (qVN & 255) <= 159;
    }

    private static boolean cge() {
        return (qVN & 255) >= 48 && (qVN & 255) <= 95;
    }
}

package com.tencent.mm.sdk.platformtools;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.net.Uri;
import android.os.Build.VERSION;
import com.tencent.wcdb.FileUtils;
import java.util.Map;

public final class e {
    public static int bxk = 0;
    public static String bxl = (VERSION.SDK_INT);
    public static int bxm = 0;
    public static int bxq = 0;
    public static int sFA = 0;
    public static String sFB = ("market://details?id=" + ad.getPackageName());
    public static boolean sFC = false;
    public static boolean sFD = true;
    public static boolean sFE = false;
    public static boolean sFF = false;
    public static int sFz = 0;

    public static void fq(Context context) {
        try {
            bxk = Integer.parseInt((String) q.Wi(bi.convertStreamToString(context.getAssets().open("channel.ini"))).get("CHANNEL"));
        } catch (Throwable e) {
            x.e("MicroMsg.SDK.ChannelUtil", "setup channel id from channel.ini failed");
            x.printErrStackTrace("MicroMsg.SDK.ChannelUtil", e, "", new Object[0]);
        }
    }

    public static void fr(Context context) {
        try {
            Map Wi = q.Wi(bi.convertStreamToString(context.getAssets().open("profile.ini")));
            String oV = bi.oV((String) Wi.get("PROFILE_DEVICE_TYPE"));
            bxl = oV;
            if (oV.length() <= 0) {
                bxl = VERSION.SDK_INT;
            }
            bxm = parseInt((String) Wi.get("UPDATE_MODE"));
            sFA = parseInt((String) Wi.get("BUILD_REVISION"));
            sFE = parseBoolean((String) Wi.get("GPRS_ALERT"));
            bxq = parseInt((String) Wi.get("AUTO_ADD_ACOUNT"));
            sFF = parseBoolean((String) Wi.get("NOKIA_AOL"));
            x.w("MicroMsg.SDK.ChannelUtil", "profileDeviceType=" + bxl);
            x.w("MicroMsg.SDK.ChannelUtil", "updateMode=" + bxm);
            x.w("MicroMsg.SDK.ChannelUtil", "shouldShowGprsAlert=" + sFE);
            x.w("MicroMsg.SDK.ChannelUtil", "autoAddAccount=" + bxq);
            x.w("MicroMsg.SDK.ChannelUtil", "isNokiaol=" + sFF);
            oV = (String) Wi.get("MARKET_URL");
            if (!(oV == null || oV.trim().length() == 0 || Uri.parse(oV) == null)) {
                sFB = oV;
            }
            x.w("MicroMsg.SDK.ChannelUtil", "marketURL=" + sFB);
        } catch (Throwable e) {
            x.e("MicroMsg.SDK.ChannelUtil", "setup profile from profile.ini failed");
            x.printErrStackTrace("MicroMsg.SDK.ChannelUtil", e, "", new Object[0]);
        }
    }

    private static int parseInt(String str) {
        try {
            return Integer.parseInt(str);
        } catch (Exception e) {
            x.w("MicroMsg.SDK.ChannelUtil", e.getMessage());
            return 0;
        }
    }

    private static boolean parseBoolean(String str) {
        boolean z = false;
        try {
            return Boolean.parseBoolean(str);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.SDK.ChannelUtil", e, "", new Object[z]);
            x.w("MicroMsg.SDK.ChannelUtil", e.getMessage());
            return z;
        }
    }

    public static String aj(Context context, int i) {
        return b(context, i, sFC);
    }

    public static String b(Context context, int i, boolean z) {
        String str;
        int i2 = (i >> 8) & 255;
        if (i2 == 0) {
            str = ((i >> 24) & 15) + "." + ((i >> 16) & 255);
        } else {
            str = ((i >> 24) & 15) + "." + ((i >> 16) & 255) + "." + i2;
        }
        x.d("MicroMsg.SDK.ChannelUtil", "minminor " + i2);
        i2 = 268435455 & i;
        if (context != null) {
            try {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), FileUtils.S_IWUSR);
                if (packageInfo != null) {
                    i2 = packageInfo.versionCode;
                    str = packageInfo.versionName;
                }
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.SDK.ChannelUtil", e, "", new Object[0]);
            }
        }
        if (z) {
            str = str + "_" + i2;
            x.d("MicroMsg.SDK.ChannelUtil", "full version: " + str);
            return str;
        }
        String[] split = str.split("\\.");
        if (split == null || split.length < 4) {
            return str;
        }
        str = split[0] + "." + split[1];
        return !split[2].trim().equals("0") ? str + "." + split[2] : str;
    }

    public static boolean chv() {
        return bxk == 1;
    }

    public static boolean chw() {
        return bxk == 1001;
    }
}

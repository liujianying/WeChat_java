package com.tencent.mm.sdk.platformtools;

import android.telephony.TelephonyManager;
import java.util.TimeZone;

public final class bk {
    public static boolean cjj() {
        String e = w.e(ad.getContext().getSharedPreferences(ad.chY(), 0));
        String chP = w.chP();
        if (!e.equals("language_default")) {
            chP = e;
        }
        if (!chP.equals("zh_CN")) {
            return true;
        }
        if (TimeZone.getDefault().getRawOffset() != TimeZone.getTimeZone("GMT+08:00").getRawOffset()) {
            return true;
        }
        TelephonyManager telephonyManager = (TelephonyManager) ad.getContext().getSystemService("phone");
        if (telephonyManager != null) {
            chP = telephonyManager.getNetworkCountryIso();
            if (!(bi.oW(chP) || chP.contains("cn") || chP.contains("CN"))) {
                return true;
            }
        }
        return false;
    }
}

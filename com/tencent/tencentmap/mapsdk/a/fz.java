package com.tencent.tencentmap.mapsdk.a;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Environment;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class fz {
    private static String a = "";
    private static String b = "";

    public static int a(byte[] bArr, int i) {
        return ((((bArr[0] << 24) & -16777216) + ((bArr[1] << 16) & 16711680)) + ((bArr[2] << 8) & 65280)) + (bArr[3] & 255);
    }

    public static String a(Context context) {
        Object obj = 1;
        if (context == null) {
            return null;
        }
        try {
            String str = a;
            if (str != null) {
                if (str.trim().length() != 0) {
                    obj = null;
                }
            }
            if (obj != null) {
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                if (telephonyManager != null) {
                    a = telephonyManager.getDeviceId();
                }
            }
        } catch (Exception e) {
        }
        return a;
    }

    public static String a(Exception exception) {
        String stackTraceString = Log.getStackTraceString(exception);
        return stackTraceString != null ? (stackTraceString.indexOf("\n") == -1 || stackTraceString.indexOf("\n") >= 100) ? stackTraceString.length() > 100 ? stackTraceString.substring(0, 100) : stackTraceString : stackTraceString.substring(0, stackTraceString.indexOf("\n")) : "";
    }

    public static String a(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        String str = "";
        for (int i = 0; i < bArr.length; i++) {
            str = (str + Integer.toHexString((bArr[i] >> 4) & 15)) + Integer.toHexString(bArr[i] & 15);
        }
        return str;
    }

    public static boolean a() {
        return "mounted".equals(Environment.getExternalStorageState());
    }

    public static boolean a(String str) {
        return str == null || str.trim().length() == 0;
    }

    public static String b() {
        return ("mounted".equals(Environment.getExternalStorageState()) ? 1 : null) != null ? Environment.getExternalStorageDirectory().getAbsolutePath() + "/AccessSchedulerDir" : "";
    }

    public static String b(Context context) {
        Object obj = 1;
        if (context == null) {
            return null;
        }
        try {
            String str = b;
            if (str != null) {
                if (str.trim().length() != 0) {
                    obj = null;
                }
            }
            if (obj != null) {
                WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
                if (wifiManager != null) {
                    WifiInfo connectionInfo = wifiManager.getConnectionInfo();
                    if (connectionInfo != null) {
                        b = connectionInfo.getMacAddress();
                    }
                }
            }
        } catch (Exception e) {
        }
        return b;
    }

    public static String b(String str) {
        String str2 = "";
        Context a = em.a();
        try {
            StringBuilder stringBuilder = new StringBuilder("");
            Object a2 = a(a);
            if (!TextUtils.isEmpty(a2)) {
                stringBuilder.append(a2);
            }
            Object b = b(a);
            if (!TextUtils.isEmpty(b)) {
                stringBuilder.append(b);
            }
            stringBuilder.append(System.currentTimeMillis());
            stringBuilder.append(str);
            stringBuilder.append((int) (Math.random() * 2.147483647E9d));
            return e(stringBuilder.toString());
        } catch (Exception e) {
            return str2;
        }
    }

    public static String c() {
        Object obj = 1;
        try {
            String str = a;
            if (str != null) {
                if (str.trim().length() != 0) {
                    obj = null;
                }
            }
            if (obj != null) {
                Context a = em.a();
                if (a != null) {
                    TelephonyManager telephonyManager = (TelephonyManager) a.getSystemService("phone");
                    if (telephonyManager != null) {
                        a = telephonyManager.getDeviceId();
                    }
                }
            }
        } catch (Exception e) {
        }
        return a;
    }

    public static String c(String str) {
        return (str == null || str.length() == 0) ? null : (str.toLowerCase().startsWith("http://") || str.toLowerCase().startsWith("https://")) ? str : "http://" + str;
    }

    public static String d(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        String substring;
        int indexOf = str.indexOf("://");
        indexOf = indexOf != -1 ? indexOf + 3 : 0;
        int indexOf2 = str.indexOf(47, indexOf);
        if (indexOf2 != -1) {
            substring = str.substring(indexOf, indexOf2);
        } else {
            indexOf2 = str.indexOf(63, indexOf);
            substring = indexOf2 != -1 ? str.substring(indexOf, indexOf2) : str.substring(indexOf);
        }
        indexOf2 = substring.indexOf(":");
        return indexOf2 >= 0 ? substring.substring(0, indexOf2) : substring;
    }

    private static String e(String str) {
        String str2 = null;
        if (str == null || str.length() == 0) {
            return str2;
        }
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(str.getBytes());
            byte[] digest = instance.digest();
            if (digest == null) {
                return "";
            }
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b : digest) {
                String toHexString = Integer.toHexString(b & 255);
                if (toHexString.length() == 1) {
                    stringBuffer.append("0");
                }
                stringBuffer.append(toHexString);
            }
            return stringBuffer.toString().toUpperCase();
        } catch (NoSuchAlgorithmException e) {
            return str2;
        }
    }
}

package com.tencent.c.f;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.net.Proxy;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.net.NetworkInterface;
import java.util.Collections;
import java.util.Enumeration;

public final class d {
    public static String ht(Context context) {
        String str = "";
        try {
            return ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
        } catch (Throwable th) {
            h.cD("getIMEI: " + th);
            return str;
        }
    }

    public static String hu(Context context) {
        String str = "";
        try {
            return ((TelephonyManager) context.getSystemService("phone")).getSubscriberId();
        } catch (Throwable th) {
            h.cD("getIMSI: " + th);
            return str;
        }
    }

    public static int cFv() {
        try {
            return Integer.parseInt(VERSION.SDK);
        } catch (Throwable th) {
            h.cD("getSDKVersion: " + th);
            return 0;
        }
    }

    public static String hv(Context context) {
        try {
            return Secure.getString(context.getContentResolver(), "android_id");
        } catch (Throwable th) {
            h.cD("getAndroidId: " + th);
            return "";
        }
    }

    public static String mP(boolean z) {
        String str;
        Object obj;
        BufferedReader bufferedReader;
        Throwable th;
        BufferedReader bufferedReader2 = null;
        if (z) {
            str = "/sys/block/mmcblk0/device/";
            obj = "MMC";
        } else {
            str = "/sys/block/mmcblk1/device/";
            obj = "SD";
        }
        BufferedReader bufferedReader3;
        try {
            bufferedReader3 = new BufferedReader(new FileReader(str + DownloadSettingTable$Columns.TYPE));
            try {
                String readLine = bufferedReader3.readLine();
                if (readLine != null && readLine.toUpperCase().equals(obj)) {
                    BufferedReader bufferedReader4 = new BufferedReader(new FileReader(str + "cid"));
                    try {
                        String readLine2 = bufferedReader4.readLine();
                        if (readLine2 != null) {
                            readLine2 = readLine2.trim();
                            try {
                                bufferedReader3.close();
                            } catch (IOException e) {
                            }
                            try {
                                bufferedReader4.close();
                                return readLine2;
                            } catch (IOException e2) {
                                return readLine2;
                            }
                        }
                        bufferedReader2 = bufferedReader4;
                    } catch (Throwable th2) {
                        th = th2;
                        bufferedReader = bufferedReader4;
                        if (bufferedReader3 != null) {
                            try {
                                bufferedReader3.close();
                            } catch (IOException e3) {
                            }
                        }
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e4) {
                            }
                        }
                        throw th;
                    }
                }
                try {
                    bufferedReader3.close();
                } catch (IOException e5) {
                }
                if (bufferedReader2 != null) {
                    try {
                        bufferedReader2.close();
                    } catch (IOException e6) {
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                bufferedReader = null;
                if (bufferedReader3 != null) {
                    try {
                        bufferedReader3.close();
                    } catch (IOException e32) {
                    }
                }
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e42) {
                    }
                }
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            bufferedReader = null;
            bufferedReader3 = null;
            if (bufferedReader3 != null) {
                try {
                    bufferedReader3.close();
                } catch (IOException e322) {
                }
            }
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e422) {
                }
            }
            throw th;
        }
        return "";
    }

    public static String cFw() {
        String str = "";
        try {
            InputStream fileInputStream = new FileInputStream("/proc/version");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream), 8192);
            StringBuilder stringBuilder = new StringBuilder("");
            while (true) {
                try {
                    str = bufferedReader.readLine();
                    if (str != null) {
                        stringBuilder.append(str);
                    } else {
                        try {
                            break;
                        } catch (Throwable th) {
                            h.cE(th);
                        }
                    }
                } catch (Throwable th2) {
                    h.cE(th2);
                }
            }
            bufferedReader.close();
            try {
                fileInputStream.close();
            } catch (Throwable th22) {
                h.cE(th22);
            }
            return stringBuilder.toString();
            fileInputStream.close();
            return stringBuilder.toString();
            return stringBuilder.toString();
        } catch (Throwable th3) {
            h.cE(th3);
            return str;
        }
    }

    public static int hw(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null || (activeNetworkInfo.getState() != State.CONNECTING && activeNetworkInfo.getState() != State.CONNECTED)) {
            return a.vkJ;
        }
        if (activeNetworkInfo.getType() == 1) {
            return a.vkG;
        }
        if (activeNetworkInfo.getType() != 0) {
            return a.vkJ;
        }
        if (Proxy.getDefaultHost() == null && Proxy.getHost(context) == null) {
            return a.vkI;
        }
        return a.vkH;
    }

    public static String acu(String str) {
        Object th;
        String str2 = "";
        String str3;
        try {
            Method method = Class.forName("android.os.SystemProperties").getMethod("get", new Class[]{String.class});
            method.setAccessible(true);
            str3 = (String) method.invoke(null, new Object[]{str});
            if (str3 != null) {
                return str3;
            }
            try {
                return "";
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            th = th3;
            str3 = str2;
            h.cD(" getBuildPropByReflect: " + th);
            return str3;
        }
    }

    public static String hx(Context context) {
        String macAddress;
        String str = "";
        try {
            WifiInfo connectionInfo = ((WifiManager) context.getSystemService("wifi")).getConnectionInfo();
            if (connectionInfo != null) {
                macAddress = connectionInfo.getMacAddress();
                if (!TextUtils.isEmpty(macAddress) || macAddress.equals("02:00:00:00:00:00")) {
                    return cFx();
                }
                return macAddress;
            }
        } catch (Throwable th) {
            h.cD("getMac: " + th);
        }
        macAddress = str;
        if (!TextUtils.isEmpty(macAddress)) {
        }
        return cFx();
    }

    private static String cFx() {
        String str = "";
        try {
            Enumeration networkInterfaces = NetworkInterface.getNetworkInterfaces();
            if (networkInterfaces == null) {
                h.cD("[tomys] getMac2, itfs is null.");
                return str;
            }
            String stringBuilder;
            for (NetworkInterface networkInterface : Collections.list(networkInterfaces)) {
                if (networkInterface.getName().equalsIgnoreCase("wlan0")) {
                    byte[] hardwareAddress = networkInterface.getHardwareAddress();
                    if (hardwareAddress != null) {
                        StringBuilder stringBuilder2 = new StringBuilder();
                        int length = hardwareAddress.length;
                        for (int i = 0; i < length; i++) {
                            stringBuilder2.append(String.format("%02x:", new Object[]{Byte.valueOf(hardwareAddress[i])}));
                        }
                        if (stringBuilder2.length() > 0) {
                            stringBuilder2.deleteCharAt(stringBuilder2.length() - 1);
                        }
                        stringBuilder = stringBuilder2.toString();
                        return stringBuilder;
                    }
                }
            }
            stringBuilder = str;
            return stringBuilder;
        } catch (Throwable th) {
            h.cD("getMac2: " + th);
        }
    }
}

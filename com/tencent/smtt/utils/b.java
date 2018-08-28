package com.tencent.smtt.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.map.lib.mapstructure.MapRouteSectionWithName;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.security.cert.Certificate;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class b {
    public static String a = "";
    public static String b = "";
    public static String c = "";
    public static String d = "";
    public static String e = "";

    private static PackageInfo a(String str, int i) {
        try {
            Class cls = Class.forName("android.content.pm.PackageParser");
            for (Class cls2 : cls.getDeclaredClasses()) {
                if (cls2.getName().compareTo("android.content.pm.PackageParser$Package") == 0) {
                    break;
                }
            }
            Class cls22 = null;
            Constructor constructor = cls.getConstructor(new Class[]{String.class});
            Method declaredMethod = cls.getDeclaredMethod("parsePackage", new Class[]{File.class, String.class, DisplayMetrics.class, Integer.TYPE});
            Method declaredMethod2 = cls.getDeclaredMethod("collectCertificates", new Class[]{cls22, Integer.TYPE});
            Method declaredMethod3 = cls.getDeclaredMethod("generatePackageInfo", new Class[]{cls22, int[].class, Integer.TYPE, Long.TYPE, Long.TYPE});
            constructor.setAccessible(true);
            declaredMethod.setAccessible(true);
            declaredMethod2.setAccessible(true);
            declaredMethod3.setAccessible(true);
            Object newInstance = constructor.newInstance(new Object[]{str});
            new DisplayMetrics().setToDefaults();
            if (declaredMethod.invoke(newInstance, new Object[]{new File(str), str, new DisplayMetrics(), Integer.valueOf(0)}) == null) {
                return null;
            }
            if ((i & 64) != 0) {
                declaredMethod2.invoke(newInstance, new Object[]{r3, Integer.valueOf(0)});
            }
            return (PackageInfo) declaredMethod3.invoke(null, new Object[]{r3, null, Integer.valueOf(i), Integer.valueOf(0), Integer.valueOf(0)});
        } catch (Exception e) {
            return null;
        }
    }

    public static String a() {
        Throwable th;
        BufferedReader bufferedReader;
        if (!TextUtils.isEmpty(c)) {
            return c;
        }
        InputStreamReader inputStreamReader;
        BufferedReader bufferedReader2;
        String a;
        try {
            inputStreamReader = new InputStreamReader(Runtime.getRuntime().exec("getprop ro.product.cpu.abi").getInputStream());
            try {
                bufferedReader2 = new BufferedReader(inputStreamReader);
                try {
                    a = bufferedReader2.readLine().contains("x86") ? a("i686") : a(System.getProperty("os.arch"));
                    if (bufferedReader2 != null) {
                        try {
                            bufferedReader2.close();
                        } catch (IOException e) {
                        }
                    }
                    if (inputStreamReader == null) {
                        return a;
                    }
                    try {
                        inputStreamReader.close();
                        return a;
                    } catch (IOException e2) {
                        return a;
                    }
                } catch (Throwable th2) {
                }
            } catch (Throwable th3) {
                th = th3;
                bufferedReader = null;
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e3) {
                    }
                }
                if (inputStreamReader != null) {
                    try {
                        inputStreamReader.close();
                    } catch (IOException e4) {
                    }
                }
                throw th;
            }
        } catch (Throwable th32) {
            th = th32;
            bufferedReader = null;
            inputStreamReader = null;
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e32) {
                }
            }
            if (inputStreamReader != null) {
                try {
                    inputStreamReader.close();
                } catch (IOException e42) {
                }
            }
            throw th;
        }
    }

    public static String a(Context context) {
        String str = null;
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (Exception e) {
            return str;
        }
    }

    public static String a(Context context, File file) {
        String a;
        try {
            if (context.getApplicationContext().getPackageName().contains("com.jd.jrapp")) {
                TbsLog.i("AppUtil", "[AppUtil.getSignatureFromApk]  #1");
                a = a(file);
                if (a != null) {
                    TbsLog.i("AppUtil", "[AppUtil.getSignatureFromApk]  #2");
                    return a;
                }
            }
        } catch (Throwable th) {
            TbsLog.i("AppUtil", "[AppUtil.getSignatureFromApk]  #3");
        }
        TbsLog.i("AppUtil", "[AppUtil.getSignatureFromApk]  #4");
        a = a(context, file, false);
        TbsLog.i("AppUtil", "[AppUtil.getSignatureFromApk]  android api signature=" + a);
        if (a == null) {
            a = a(file);
            TbsLog.i("AppUtil", "[AppUtil.getSignatureFromApk]  java get signature=" + a);
        }
        if (a != null) {
            return a;
        }
        a = a(context, file, true);
        TbsLog.i("AppUtil", "[AppUtil.getSignatureFromApk]  android reflection signature=" + a);
        return a;
    }

    private static String a(Context context, File file, boolean z) {
        Signature signature;
        PackageInfo a = z ? a(file.getAbsolutePath(), 65) : context.getPackageManager().getPackageArchiveInfo(file.getAbsolutePath(), 65);
        if (a != null) {
            if (a.signatures == null || a.signatures.length <= 0) {
                TbsLog.w("AppUtil", "[getSignatureFromApk] pkgInfo is not null BUT signatures is null!");
            } else {
                signature = a.signatures[0];
                return signature == null ? signature.toCharsString() : null;
            }
        }
        signature = null;
        if (signature == null) {
        }
    }

    public static String a(Context context, String str) {
        String str2 = null;
        try {
            try {
                return String.valueOf(Integer.toHexString(Integer.parseInt(String.valueOf(context.getPackageManager().getApplicationInfo(context.getPackageName(), MapRouteSectionWithName.kMaxRoadNameLength).metaData.get(str)))));
            } catch (Exception e) {
                return str2;
            }
        } catch (Exception e2) {
            return str2;
        }
    }

    private static String a(File file) {
        try {
            JarFile jarFile = new JarFile(file);
            byte[] bArr = new byte[8192];
            String a = a(a(jarFile, jarFile.getJarEntry("AndroidManifest.xml"), bArr)[0].getEncoded());
            Enumeration entries = jarFile.entries();
            while (entries.hasMoreElements()) {
                JarEntry jarEntry = (JarEntry) entries.nextElement();
                String name = jarEntry.getName();
                if (name != null) {
                    Certificate[] a2 = a(jarFile, jarEntry, bArr);
                    String a3 = a2 != null ? a(a2[0].getEncoded()) : null;
                    if (a3 == null) {
                        if (!name.startsWith("META-INF/")) {
                            return null;
                        }
                    } else if (!a3.equals(a)) {
                        return null;
                    }
                }
            }
            return a;
        } catch (Exception e) {
            return null;
        }
    }

    private static String a(String str) {
        return str == null ? "" : str;
    }

    private static String a(byte[] bArr) {
        int length = bArr.length;
        char[] cArr = new char[(length * 2)];
        for (int i = 0; i < length; i++) {
            byte b = bArr[i];
            int i2 = (b >> 4) & 15;
            cArr[i * 2] = (char) (i2 >= 10 ? (i2 + 97) - 10 : i2 + 48);
            i2 = b & 15;
            cArr[(i * 2) + 1] = (char) (i2 >= 10 ? (i2 + 97) - 10 : i2 + 48);
        }
        return new String(cArr);
    }

    private static Certificate[] a(JarFile jarFile, JarEntry jarEntry, byte[] bArr) {
        InputStream inputStream = jarFile.getInputStream(jarEntry);
        do {
        } while (inputStream.read(bArr, 0, bArr.length) != -1);
        inputStream.close();
        return jarEntry != null ? jarEntry.getCertificates() : null;
    }

    public static int b(Context context) {
        int i = 0;
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (Exception e) {
            return i;
        }
    }

    public static String c(Context context) {
        String str = "";
        if (!TextUtils.isEmpty(a)) {
            return a;
        }
        try {
            return ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
        } catch (Exception e) {
            return str;
        }
    }

    public static String d(Context context) {
        String str = "";
        if (!TextUtils.isEmpty(b)) {
            return b;
        }
        try {
            return ((TelephonyManager) context.getSystemService("phone")).getSubscriberId();
        } catch (Exception e) {
            return str;
        }
    }

    public static String e(Context context) {
        String str = "";
        if (!TextUtils.isEmpty(d)) {
            return d;
        }
        try {
            WifiManager wifiManager = (WifiManager) context.getApplicationContext().getSystemService("wifi");
            WifiInfo connectionInfo = wifiManager == null ? null : wifiManager.getConnectionInfo();
            return connectionInfo == null ? "" : connectionInfo.getMacAddress();
        } catch (Exception e) {
            return str;
        }
    }

    public static String f(Context context) {
        if (!TextUtils.isEmpty(e)) {
            return e;
        }
        try {
            e = Secure.getString(context.getContentResolver(), "android_id");
        } catch (Exception e) {
        }
        return e;
    }
}

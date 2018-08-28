package com.tencent.tinker.loader.shareutil;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Process;
import com.tencent.wcdb.FileUtils;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class ShareTinkerInternals {
    private static String processName = null;
    private static final boolean vvU = ada(System.getProperty("java.vm.version"));
    private static final boolean vvV = cHi();
    private static Boolean vvW = null;
    private static String vvX = null;
    private static String vvY = null;

    public static boolean cHe() {
        return vvU || VERSION.SDK_INT >= 21;
    }

    public static boolean cHf() {
        return vvV && VERSION.SDK_INT < 24;
    }

    public static boolean cHg() {
        return VERSION.SDK_INT > 25;
    }

    public static String cHh() {
        if (vvY != null) {
            return vvY;
        }
        vvY = (String) Class.forName("dalvik.system.VMRuntime").getDeclaredMethod("getCurrentInstructionSet", new Class[0]).invoke(null, new Object[0]);
        new StringBuilder("getCurrentInstructionSet:").append(vvY);
        return vvY;
    }

    public static boolean acZ(String str) {
        String str2 = Build.FINGERPRINT;
        if (str == null || str.equals("") || str2 == null || str2.equals("")) {
            new StringBuilder("fingerprint empty:").append(str).append(",current:").append(str2);
            return false;
        } else if (str.equals(str2)) {
            return false;
        } else {
            new StringBuilder("system OTA,fingerprint not equal:").append(str).append(",").append(str2);
            return true;
        }
    }

    public static ShareDexDiffPatchInfo a(ShareDexDiffPatchInfo shareDexDiffPatchInfo, int i) {
        if (!shareDexDiffPatchInfo.vuz.startsWith("test.dex")) {
            return null;
        }
        String str;
        if (i != 1) {
            str = "classes" + i + ".dex";
        } else {
            str = "classes.dex";
        }
        return new ShareDexDiffPatchInfo(str, shareDexDiffPatchInfo.path, shareDexDiffPatchInfo.vuA, shareDexDiffPatchInfo.vuB, shareDexDiffPatchInfo.vuE, shareDexDiffPatchInfo.vuC, shareDexDiffPatchInfo.vuD, shareDexDiffPatchInfo.vuF);
    }

    public static boolean oW(String str) {
        if (str == null || str.length() <= 0) {
            return true;
        }
        return false;
    }

    public static int a(Context context, int i, File file, ShareSecurityCheck shareSecurityCheck) {
        int i2;
        HashMap cHd;
        if (shareSecurityCheck.an(file)) {
            String hZ = hZ(context);
            if (hZ == null) {
                i2 = -5;
            } else {
                cHd = shareSecurityCheck.cHd();
                if (cHd == null) {
                    i2 = -2;
                } else {
                    String str = (String) cHd.get("TINKER_ID");
                    if (str == null) {
                        i2 = -6;
                    } else if (hZ.equals(str)) {
                        i2 = 0;
                    } else {
                        new StringBuilder("tinkerId is not equal, base is ").append(hZ).append(", but patch is ").append(str);
                        i2 = -7;
                    }
                }
            }
        } else {
            i2 = -1;
        }
        if (i2 != 0) {
            return i2;
        }
        Object obj;
        if (i == 7) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj == null) {
            cHd = shareSecurityCheck.vvS;
            if (!Ij(i) && cHd.containsKey("assets/dex_meta.txt")) {
                return -9;
            }
            if (!Ik(i) && cHd.containsKey("assets/so_meta.txt")) {
                return -9;
            }
            if (!Il(i) && cHd.containsKey("assets/res_meta.txt")) {
                return -9;
            }
        }
        return 0;
    }

    public static Properties ao(File file) {
        Throwable th;
        IOException e;
        ZipFile zipFile;
        if (!file.isFile() || file.length() == 0) {
            return null;
        }
        ZipFile zipFile2;
        try {
            zipFile2 = new ZipFile(file);
            try {
                ZipEntry entry = zipFile2.getEntry("assets/package_meta.txt");
                if (entry == null) {
                    SharePatchFileUtil.a(zipFile2);
                    return null;
                }
                Object inputStream;
                try {
                    inputStream = zipFile2.getInputStream(entry);
                    try {
                        Properties properties = new Properties();
                        properties.load(inputStream);
                        SharePatchFileUtil.ar(inputStream);
                        SharePatchFileUtil.a(zipFile2);
                        return properties;
                    } catch (Throwable th2) {
                        th = th2;
                        SharePatchFileUtil.ar(inputStream);
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    inputStream = null;
                }
            } catch (IOException e2) {
                e = e2;
                zipFile = zipFile2;
            } catch (Throwable th4) {
                th = th4;
                SharePatchFileUtil.a(zipFile2);
                throw th;
            }
        } catch (IOException e3) {
            e = e3;
            zipFile = null;
            try {
                new StringBuilder("fastGetPatchPackageMeta exception:").append(e.getMessage());
                SharePatchFileUtil.a(zipFile);
                return null;
            } catch (Throwable th42) {
                th = th42;
                zipFile2 = zipFile;
                SharePatchFileUtil.a(zipFile2);
                throw th;
            }
        } catch (Throwable th5) {
            th = th5;
            zipFile2 = null;
            SharePatchFileUtil.a(zipFile2);
            throw th;
        }
    }

    private static String hZ(Context context) {
        if (vvX != null) {
            return vvX;
        }
        try {
            Object obj = context.getPackageManager().getApplicationInfo(context.getPackageName(), FileUtils.S_IWUSR).metaData.get("TINKER_ID");
            if (obj != null) {
                vvX = String.valueOf(obj);
            } else {
                vvX = null;
            }
            return vvX;
        } catch (Exception e) {
            new StringBuilder("getManifestTinkerID exception:").append(e.getMessage());
            return null;
        }
    }

    public static boolean Ij(int i) {
        return (i & 1) != 0;
    }

    public static boolean Ik(int i) {
        return (i & 2) != 0;
    }

    public static boolean Il(int i) {
        return (i & 4) != 0;
    }

    public static String Im(int i) {
        switch (i) {
            case 1:
                return "patch_file";
            case 2:
                return "patch_info";
            case 3:
                return "dex";
            case 4:
                return "dex_opt";
            case 5:
                return "lib";
            case 6:
                return "resource";
            default:
                return "unknown";
        }
    }

    public static void ia(Context context) {
        context.getSharedPreferences("tinker_share_config", 4).edit().putBoolean("tinker_enable_1.9.7", false).commit();
    }

    public static boolean ib(Context context) {
        if (context == null) {
            return false;
        }
        return context.getSharedPreferences("tinker_share_config", 4).getBoolean("tinker_enable_1.9.7", true);
    }

    public static boolean In(int i) {
        return i != 0;
    }

    public static boolean ic(Context context) {
        String str = null;
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        if (applicationInfo != null) {
            str = applicationInfo.processName;
        }
        if (oW(str)) {
            str = context.getPackageName();
        }
        Object aC = aC(context);
        if (aC == null || aC.length() == 0) {
            aC = "";
        }
        return str.equals(aC);
    }

    public static boolean id(Context context) {
        if (vvW != null) {
            return vvW.booleanValue();
        }
        Boolean valueOf = Boolean.valueOf(aC(context).endsWith(":patch"));
        vvW = valueOf;
        return valueOf.booleanValue();
    }

    public static String bS(Context context, String str) {
        if (!str.equals("changing")) {
            return str;
        }
        if (ic(context)) {
            return "odex";
        }
        return "interpet";
    }

    public static void ie(Context context) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        if (activityManager != null) {
            List<RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
            if (runningAppProcesses != null) {
                for (RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                    if (runningAppProcessInfo.uid == Process.myUid() && runningAppProcessInfo.pid != Process.myPid()) {
                        Process.killProcess(runningAppProcessInfo.pid);
                    }
                }
            }
        }
    }

    public static String aC(Context context) {
        if (processName != null) {
            return processName;
        }
        String aD = aD(context);
        processName = aD;
        return aD;
    }

    private static String aD(Context context) {
        Exception e;
        Throwable th;
        int myPid = Process.myPid();
        if (context == null || myPid <= 0) {
            return "";
        }
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        if (activityManager != null) {
            try {
                List<RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
                if (runningAppProcesses != null) {
                    for (RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                        if (runningAppProcessInfo.pid == myPid) {
                            break;
                        }
                    }
                    RunningAppProcessInfo runningAppProcessInfo2 = null;
                    if (runningAppProcessInfo2 != null) {
                        return runningAppProcessInfo2.processName;
                    }
                }
            } catch (Exception e2) {
                new StringBuilder("getProcessNameInternal exception:").append(e2.getMessage());
            }
        }
        byte[] bArr = new byte[FileUtils.S_IWUSR];
        FileInputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream("/proc/" + myPid + "/cmdline");
            try {
                int read = fileInputStream.read(bArr);
                if (read > 0) {
                    int i = 0;
                    while (i < read) {
                        if ((bArr[i] & 255) > FileUtils.S_IWUSR || bArr[i] <= (byte) 0) {
                            read = i;
                            break;
                        }
                        i++;
                    }
                    String str = new String(bArr, 0, read);
                    try {
                        fileInputStream.close();
                        return str;
                    } catch (Exception e3) {
                        return str;
                    }
                }
                try {
                    fileInputStream.close();
                } catch (Exception e4) {
                }
                return "";
            } catch (Exception e5) {
                e2 = e5;
                try {
                    new StringBuilder("getProcessNameInternal exception:").append(e2.getMessage());
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Exception e6) {
                        }
                    }
                    return "";
                } catch (Throwable th2) {
                    th = th2;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Exception e7) {
                        }
                    }
                    throw th;
                }
            }
        } catch (Exception e8) {
            e2 = e8;
            fileInputStream = null;
            new StringBuilder("getProcessNameInternal exception:").append(e2.getMessage());
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (Exception e62) {
                }
            }
            return "";
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = null;
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (Exception e72) {
                }
            }
            throw th;
        }
    }

    private static boolean ada(String str) {
        if (str == null) {
            return false;
        }
        Matcher matcher = Pattern.compile("(\\d+)\\.(\\d+)(\\.\\d+)?").matcher(str);
        if (!matcher.matches()) {
            return false;
        }
        try {
            int parseInt = Integer.parseInt(matcher.group(1));
            int parseInt2 = Integer.parseInt(matcher.group(2));
            if (parseInt > 2 || (parseInt == 2 && parseInt2 > 0)) {
                return true;
            }
            return false;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static boolean cHi() {
        try {
            Method declaredMethod = Class.forName("android.os.SystemProperties").getDeclaredMethod("get", new Class[]{String.class});
            String str = (String) declaredMethod.invoke(null, new Object[]{"dalvik.vm.usejit"});
            String str2 = (String) declaredMethod.invoke(null, new Object[]{"dalvik.vm.usejitprofiles"});
            if (!oW(str) && oW(str2) && str.equals("true")) {
                return true;
            }
        } catch (Throwable th) {
            new StringBuilder("isVmJitInternal ex:").append(th);
        }
        return false;
    }

    public static String j(Throwable th) {
        if (th == null) {
            return "";
        }
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        while (true) {
            try {
                Throwable cause = th.getCause();
                if (cause == null) {
                    break;
                }
                th = cause;
            } finally {
                SharePatchFileUtil.ar(printStream);
            }
        }
        th.printStackTrace(printStream);
        String Ws = Ws(byteArrayOutputStream.toString());
        return Ws;
    }

    private static String Ws(String str) {
        if (str == null) {
            return null;
        }
        char[] toCharArray = str.toCharArray();
        if (toCharArray == null) {
            return null;
        }
        char c;
        int i = 0;
        while (i < toCharArray.length) {
            if (toCharArray[i] > 127) {
                toCharArray[i] = 0;
                c = 1;
                break;
            }
            i++;
        }
        c = 0;
        if (c != 0) {
            return new String(toCharArray, 0, i);
        }
        return str;
    }
}

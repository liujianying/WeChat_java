package com.tencent.mm.compatible.e;

import android.os.Build.VERSION;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public final class n {
    private static Map<String, String> dex = null;

    class a implements FileFilter {
        a() {
        }

        public final boolean accept(File file) {
            if (Pattern.matches("cpu[0-9]", file.getName())) {
                return true;
            }
            return false;
        }
    }

    public static Map<String, String> zn() {
        if (dex == null) {
            dex = zt();
        }
        return dex;
    }

    public static String zo() {
        if (dex == null) {
            dex = zt();
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(": ");
        stringBuilder.append(c(dex, "Features"));
        stringBuilder.append(": ");
        stringBuilder.append(c(dex, "Processor"));
        stringBuilder.append(": ");
        stringBuilder.append(c(dex, "CPU architecture"));
        stringBuilder.append(": ");
        stringBuilder.append(c(dex, "Hardware"));
        stringBuilder.append(": ");
        stringBuilder.append(c(dex, "Serial"));
        return stringBuilder.toString();
    }

    public static boolean zp() {
        if (dex == null) {
            dex = zt();
        }
        if (dex != null) {
            String c = c(dex, "Features");
            if (c != null && c.contains("neon")) {
                return true;
            }
            if (c != null && c.contains("asimd")) {
                return true;
            }
        }
        return false;
    }

    public static boolean zq() {
        try {
            return (VERSION.SDK_INT >= 4) && zp();
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.Crash", e, "May cause dvmFindCatchBlock crash!", new Object[0]);
            throw ((IncompatibleClassChangeError) new IncompatibleClassChangeError("May cause dvmFindCatchBlock crash!").initCause(e));
        } catch (Throwable th) {
            return false;
        }
    }

    public static boolean zr() {
        if (dex == null) {
            dex = zt();
        }
        if (dex == null) {
            return false;
        }
        String c = c(dex, "CPU architecture");
        x.d("CpuFeatures", "arch " + c);
        if (c == null) {
            return false;
        }
        try {
            if (c.length() <= 0) {
                return false;
            }
            int i = bi.getInt(fc(fb(c)), 0);
            x.d("CpuFeatures", "armarch " + i);
            if (i >= 6) {
                return true;
            }
            return false;
        } catch (Throwable e) {
            x.printErrStackTrace("CpuFeatures", e, "", new Object[0]);
            return false;
        }
    }

    public static int zs() {
        try {
            return new File("/sys/devices/system/cpu/").listFiles(new a()).length;
        } catch (Exception e) {
            return 1;
        }
    }

    private static boolean f(char c) {
        if (c < '0' || c > '9') {
            return false;
        }
        return true;
    }

    private static String fb(String str) {
        if (str == null) {
            return str;
        }
        try {
            if (str.length() <= 0) {
                return str;
            }
            while (!f(str.charAt(0))) {
                if (str.length() == 1) {
                    return null;
                }
                str = str.substring(1);
            }
            return str;
        } catch (Throwable e) {
            x.printErrStackTrace("CpuFeatures", e, "", new Object[0]);
            return str;
        }
    }

    private static String fc(String str) {
        int i;
        int i2 = 0;
        while (true) {
            i = i2 + 1;
            try {
                if (!f(str.charAt(i2)) || str.length() <= i) {
                    i2 = i - 1;
                } else {
                    i2 = i;
                }
            } catch (Throwable e) {
                x.printErrStackTrace("CpuFeatures", e, "", new Object[0]);
                return str;
            }
        }
        i2 = i - 1;
        if (str.length() <= i2 + 1 || i2 <= 0) {
            return str;
        }
        return str.substring(0, i2);
    }

    private static String c(Map<String, String> map, String str) {
        return (String) map.get(str);
    }

    public static HashMap<String, String> zt() {
        Throwable e;
        HashMap<String, String> hashMap = new HashMap();
        Closeable bufferedReader;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/cpuinfo"), "UTF-8"));
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    String[] split = readLine.split(":", 2);
                    if (split != null && split.length >= 2) {
                        String trim = split[0].trim();
                        readLine = split[1].trim();
                        if (hashMap.get(trim) == null) {
                            hashMap.put(trim, readLine);
                        }
                    }
                } catch (IOException e2) {
                    e = e2;
                    try {
                        x.printErrStackTrace("CpuFeatures", e, "getCpu() failed.", new Object[0]);
                        bi.d(bufferedReader);
                        return hashMap;
                    } catch (Throwable th) {
                        e = th;
                        bi.d(bufferedReader);
                        throw e;
                    }
                }
            }
            bi.d(bufferedReader);
        } catch (IOException e3) {
            e = e3;
            bufferedReader = null;
            x.printErrStackTrace("CpuFeatures", e, "getCpu() failed.", new Object[0]);
            bi.d(bufferedReader);
            return hashMap;
        } catch (Throwable th2) {
            e = th2;
            bufferedReader = null;
            bi.d(bufferedReader);
            throw e;
        }
        return hashMap;
    }
}

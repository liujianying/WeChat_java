package com.tencent.mm.bh;

import android.os.StatFs;
import android.util.DisplayMetrics;
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.model.au;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public final class c {
    private static String Uu(String str) {
        if (bi.oW(str)) {
            return "";
        }
        return str.replaceAll(" ", "").trim().replaceAll("kB", "").trim().replaceAll("\\t", "").trim();
    }

    public static String cfJ() {
        String replace;
        Throwable th;
        Closeable bufferedReader;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/cpuinfo"), "UTF-8"));
            try {
                StringBuilder stringBuilder = new StringBuilder(256);
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    } else if (!bi.oW(readLine)) {
                        stringBuilder.append(Uu(readLine)).append(';');
                    }
                }
                replace = stringBuilder.toString().replace(',', '_');
                bi.d(bufferedReader);
            } catch (Throwable th2) {
                th = th2;
                try {
                    x.printErrStackTrace("MicroMsg.PostTaskHardwareInfo", th, "unexpected exception occurred.", new Object[0]);
                    replace = "";
                    bi.d(bufferedReader);
                    return replace;
                } catch (Throwable th3) {
                    th = th3;
                    bi.d(bufferedReader);
                    throw th;
                }
            }
        } catch (Throwable th4) {
            th = th4;
            bufferedReader = null;
            bi.d(bufferedReader);
            throw th;
        }
        return replace;
    }

    public static String cfK() {
        String replace;
        Throwable th;
        Closeable bufferedReader;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/meminfo"), "UTF-8"));
            try {
                StringBuilder stringBuilder = new StringBuilder(256);
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    } else if (!bi.oW(readLine)) {
                        stringBuilder.append(Uu(readLine)).append(';');
                    }
                }
                replace = stringBuilder.toString().replace(',', '_');
                bi.d(bufferedReader);
            } catch (Throwable th2) {
                th = th2;
                try {
                    x.printErrStackTrace("MicroMsg.PostTaskHardwareInfo", th, "unexpected exception occurred.", new Object[0]);
                    replace = "";
                    bi.d(bufferedReader);
                    return replace;
                } catch (Throwable th3) {
                    th = th3;
                    bi.d(bufferedReader);
                    throw th;
                }
            }
        } catch (Throwable th4) {
            th = th4;
            bufferedReader = null;
            bi.d(bufferedReader);
            throw th;
        }
        return replace;
    }

    public static String cfL() {
        String str = "";
        try {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            displayMetrics = ad.getContext().getResources().getDisplayMetrics();
            int i = displayMetrics.widthPixels;
            int i2 = displayMetrics.heightPixels;
            float f = displayMetrics.density;
            float f2 = displayMetrics.xdpi;
            float f3 = displayMetrics.ydpi;
            str = (((("" + "width:" + String.valueOf(i) + ";") + "height:" + String.valueOf(i2) + ";") + "density:" + String.valueOf(f) + ";") + "xd:" + String.valueOf(f2) + ";") + "yd:" + String.valueOf(f3) + ";";
        } catch (Throwable e) {
            x.e("MicroMsg.PostTaskHardwareInfo", "exception:%s", new Object[]{bi.i(e)});
        }
        return str.replace(",", "_");
    }

    public static String getRomInfo() {
        String str = "";
        try {
            StatFs statFs = new StatFs(h.getDataDirectory().getPath());
            long blockSize = (long) statFs.getBlockSize();
            str = ((str + "AvailableSizes:" + (((long) statFs.getAvailableBlocks()) * blockSize) + ";") + "FreeSizes:" + (((long) statFs.getFreeBlocks()) * blockSize) + ";") + "AllSize:" + (((long) statFs.getBlockCount()) * blockSize) + ";";
        } catch (Throwable e) {
            x.e("MicroMsg.PostTaskHardwareInfo", "exception:%s", new Object[]{bi.i(e)});
        }
        return str.replace(",", "_");
    }

    public static String cfM() {
        String str = "";
        try {
            StatFs statFs = new StatFs(h.getExternalStorageDirectory().getPath());
            long blockSize = (long) statFs.getBlockSize();
            str = ((str + "AvailableSizes:" + (((long) statFs.getAvailableBlocks()) * blockSize) + ";") + "FreeSizes:" + (((long) statFs.getFreeBlocks()) * blockSize) + ";") + "AllSize:" + (((long) statFs.getBlockCount()) * blockSize) + ";";
        } catch (Throwable e) {
            x.e("MicroMsg.PostTaskHardwareInfo", "exception:%s", new Object[]{bi.i(e)});
        }
        return str.replace(",", "_");
    }

    public static String cfN() {
        au.HU();
        return (String) com.tencent.mm.model.c.DT().get(71, null);
    }
}

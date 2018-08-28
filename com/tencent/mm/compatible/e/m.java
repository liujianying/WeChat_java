package com.tencent.mm.compatible.e;

import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileReader;

public final class m {
    static int dev = 0;
    static String dew = null;

    public static int zj() {
        int i;
        int i2 = 15;
        int i3 = n.zq() ? 7 : n.zr() ? 3 : 1;
        if (q.deL.dey && q.deL.deA == 0) {
            x.d("MicroMsg.CpuChecker", "disable armv6 by server ");
            i3 &= -3;
        }
        if (q.deL.dey && q.deL.dez == 0) {
            x.d("MicroMsg.CpuChecker", "disable armv7 by server ");
            i3 &= -5;
        }
        int zs = n.zs();
        if (zs > 16) {
            zs = 15;
        } else if (zs <= 0) {
            zs = 1;
        }
        int i4 = bi.getInt(zk(), 0) / 1000;
        if (zs > 4) {
            i = i4 * 4;
        } else if (zs > 2) {
            i = i4 * 2;
        } else if (zs > 1) {
            i = (i4 * 3) >> 1;
        } else {
            i = i4;
        }
        i /= 100;
        if (i > 30) {
            i = 30;
        } else if (i < 5) {
            i = 5;
        }
        if (i > 5 || zs < 4) {
            i2 = i;
        }
        i3 = ((i3 + (zs << 4)) << 8) + i2;
        dev = i3;
        return i3;
    }

    public static String zk() {
        Throwable th;
        Closeable bufferedReader;
        String readLine;
        try {
            bufferedReader = new BufferedReader(new FileReader("/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_max_freq"));
            try {
                readLine = bufferedReader.readLine();
                if (readLine == null) {
                    throw new NullPointerException("null was returned while reading cpuinfo_max_freq.");
                }
                readLine = readLine.trim();
                bi.d(bufferedReader);
                return readLine;
            } catch (Throwable th2) {
                th = th2;
                try {
                    x.printErrStackTrace("MicroMsg.CpuChecker", th, "unexpected exception occurred.", new Object[0]);
                    readLine = "0";
                    bi.d(bufferedReader);
                    return readLine;
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
    }

    public static String zl() {
        Throwable th;
        Closeable bufferedReader;
        String readLine;
        try {
            bufferedReader = new BufferedReader(new FileReader("/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_min_freq"));
            try {
                readLine = bufferedReader.readLine();
                if (readLine == null) {
                    throw new NullPointerException("null was returned while reading cpuinfo_min_freq.");
                }
                readLine = readLine.trim();
                bi.d(bufferedReader);
                return readLine;
            } catch (Throwable th2) {
                th = th2;
                try {
                    x.printErrStackTrace("MicroMsg.CpuChecker", th, "unexpected exception occurred.", new Object[0]);
                    readLine = "0";
                    bi.d(bufferedReader);
                    return readLine;
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
    }

    public static String zm() {
        Throwable e;
        Closeable bufferedReader;
        String readLine;
        try {
            bufferedReader = new BufferedReader(new FileReader("/sys/devices/system/cpu/cpu0/cpufreq/scaling_cur_freq"));
            try {
                readLine = bufferedReader.readLine();
                if (readLine == null) {
                    throw new NullPointerException("null was returned while reading scaling_cur_freq.");
                }
                readLine = readLine.trim();
                bi.d(bufferedReader);
                return readLine;
            } catch (Exception e2) {
                e = e2;
                try {
                    x.printErrStackTrace("MicroMsg.CpuChecker", e, "unexpected exception occurred.", new Object[0]);
                    readLine = "0";
                    bi.d(bufferedReader);
                    return readLine;
                } catch (Throwable th) {
                    e = th;
                    bi.d(bufferedReader);
                    throw e;
                }
            }
        } catch (Exception e3) {
            e = e3;
            bufferedReader = null;
            x.printErrStackTrace("MicroMsg.CpuChecker", e, "unexpected exception occurred.", new Object[0]);
            readLine = "0";
            bi.d(bufferedReader);
            return readLine;
        } catch (Throwable th2) {
            e = th2;
            bufferedReader = null;
            bi.d(bufferedReader);
            throw e;
        }
    }
}

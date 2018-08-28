package com.tencent.mm.plugin.report.service;

import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.os.StatFs;
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public final class g$a {
    public static g$a mEI;
    public volatile boolean hasInit;
    public long[] mEE;
    public int mEF;
    public String mEG;
    public long mEH;

    public static synchronized g$a brT() {
        g$a g_a;
        synchronized (g$a.class) {
            if (mEI == null) {
                g_a = new g$a();
                mEI = g_a;
                g_a.mEF = zs();
                mEI.mEG = zm();
                g$a g_a2 = mEI;
                ActivityManager activityManager = (ActivityManager) ad.getContext().getSystemService("activity");
                MemoryInfo memoryInfo = new MemoryInfo();
                activityManager.getMemoryInfo(memoryInfo);
                g_a2.mEH = memoryInfo.availMem >> 10;
                g_a = mEI;
                long[] jArr = new long[2];
                StatFs statFs = new StatFs(h.getDataDirectory().getPath());
                jArr[0] = ((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize());
                StatFs statFs2 = new StatFs(h.getDataDirectory().getPath());
                jArr[1] = ((long) statFs2.getAvailableBlocks()) * ((long) statFs2.getBlockSize());
                g_a.mEE = jArr;
                mEI.hasInit = true;
            }
            g_a = mEI;
        }
        return g_a;
    }

    private static String zm() {
        BufferedReader bufferedReader;
        Throwable e;
        Throwable th;
        String str = "N/A";
        FileReader fileReader;
        try {
            fileReader = new FileReader("/sys/devices/system/cpu/cpu0/cpufreq/scaling_cur_freq");
            try {
                bufferedReader = new BufferedReader(fileReader);
            } catch (FileNotFoundException e2) {
                e = e2;
                bufferedReader = null;
                try {
                    x.printErrStackTrace("MicroMsg.ReportLogInfo", e, "", new Object[0]);
                    if (fileReader != null) {
                        try {
                            fileReader.close();
                        } catch (Throwable e3) {
                            x.printErrStackTrace("MicroMsg.ReportLogInfo", e3, "", new Object[0]);
                        }
                    }
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (Throwable e32) {
                            x.printErrStackTrace("MicroMsg.ReportLogInfo", e32, "", new Object[0]);
                        }
                    }
                    return str;
                } catch (Throwable th2) {
                    th = th2;
                    if (fileReader != null) {
                        try {
                            fileReader.close();
                        } catch (Throwable e322) {
                            x.printErrStackTrace("MicroMsg.ReportLogInfo", e322, "", new Object[0]);
                        }
                    }
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (Throwable e3222) {
                            x.printErrStackTrace("MicroMsg.ReportLogInfo", e3222, "", new Object[0]);
                        }
                    }
                    throw th;
                }
            } catch (IOException e4) {
                e3222 = e4;
                bufferedReader = null;
                x.printErrStackTrace("MicroMsg.ReportLogInfo", e3222, "", new Object[0]);
                if (fileReader != null) {
                    try {
                        fileReader.close();
                    } catch (Throwable e32222) {
                        x.printErrStackTrace("MicroMsg.ReportLogInfo", e32222, "", new Object[0]);
                    }
                }
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (Throwable e322222) {
                        x.printErrStackTrace("MicroMsg.ReportLogInfo", e322222, "", new Object[0]);
                    }
                }
                return str;
            } catch (Throwable th3) {
                th = th3;
                bufferedReader = null;
                if (fileReader != null) {
                    try {
                        fileReader.close();
                    } catch (Throwable e3222222) {
                        x.printErrStackTrace("MicroMsg.ReportLogInfo", e3222222, "", new Object[0]);
                    }
                }
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (Throwable e32222222) {
                        x.printErrStackTrace("MicroMsg.ReportLogInfo", e32222222, "", new Object[0]);
                    }
                }
                throw th;
            }
            try {
                str = bufferedReader.readLine().trim();
                bufferedReader.close();
                try {
                    fileReader.close();
                } catch (Throwable e322222222) {
                    x.printErrStackTrace("MicroMsg.ReportLogInfo", e322222222, "", new Object[0]);
                }
                try {
                    bufferedReader.close();
                } catch (Throwable e3222222222) {
                    x.printErrStackTrace("MicroMsg.ReportLogInfo", e3222222222, "", new Object[0]);
                }
            } catch (FileNotFoundException e5) {
                e3222222222 = e5;
                x.printErrStackTrace("MicroMsg.ReportLogInfo", e3222222222, "", new Object[0]);
                if (fileReader != null) {
                    try {
                        fileReader.close();
                    } catch (Throwable e32222222222) {
                        x.printErrStackTrace("MicroMsg.ReportLogInfo", e32222222222, "", new Object[0]);
                    }
                }
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (Throwable e322222222222) {
                        x.printErrStackTrace("MicroMsg.ReportLogInfo", e322222222222, "", new Object[0]);
                    }
                }
                return str;
            } catch (IOException e6) {
                e322222222222 = e6;
                x.printErrStackTrace("MicroMsg.ReportLogInfo", e322222222222, "", new Object[0]);
                if (fileReader != null) {
                    try {
                        fileReader.close();
                    } catch (Throwable e3222222222222) {
                        x.printErrStackTrace("MicroMsg.ReportLogInfo", e3222222222222, "", new Object[0]);
                    }
                }
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (Throwable e32222222222222) {
                        x.printErrStackTrace("MicroMsg.ReportLogInfo", e32222222222222, "", new Object[0]);
                    }
                }
                return str;
            }
        } catch (FileNotFoundException e7) {
            e32222222222222 = e7;
            bufferedReader = null;
            fileReader = null;
            x.printErrStackTrace("MicroMsg.ReportLogInfo", e32222222222222, "", new Object[0]);
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (Throwable e322222222222222) {
                    x.printErrStackTrace("MicroMsg.ReportLogInfo", e322222222222222, "", new Object[0]);
                }
            }
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (Throwable e3222222222222222) {
                    x.printErrStackTrace("MicroMsg.ReportLogInfo", e3222222222222222, "", new Object[0]);
                }
            }
            return str;
        } catch (IOException e8) {
            e3222222222222222 = e8;
            bufferedReader = null;
            fileReader = null;
            x.printErrStackTrace("MicroMsg.ReportLogInfo", e3222222222222222, "", new Object[0]);
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (Throwable e32222222222222222) {
                    x.printErrStackTrace("MicroMsg.ReportLogInfo", e32222222222222222, "", new Object[0]);
                }
            }
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (Throwable e322222222222222222) {
                    x.printErrStackTrace("MicroMsg.ReportLogInfo", e322222222222222222, "", new Object[0]);
                }
            }
            return str;
        } catch (Throwable th4) {
            th = th4;
            bufferedReader = null;
            fileReader = null;
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (Throwable e3222222222222222222) {
                    x.printErrStackTrace("MicroMsg.ReportLogInfo", e3222222222222222222, "", new Object[0]);
                }
            }
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (Throwable e32222222222222222222) {
                    x.printErrStackTrace("MicroMsg.ReportLogInfo", e32222222222222222222, "", new Object[0]);
                }
            }
            throw th;
        }
        return str;
    }

    private static int zs() {
        try {
            return new File("/sys/devices/system/cpu/").listFiles(new a()).length;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.ReportLogInfo", e, "", new Object[0]);
            return 1;
        }
    }
}

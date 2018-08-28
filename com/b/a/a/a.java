package com.b.a.a;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.content.Context;
import android.os.Build.VERSION;
import com.tencent.mm.opensdk.constants.ConstantsAPI$AppSupportContentFlag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.tmassistantsdk.logreport.BaseReportManager;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public final class a {
    private static final FileFilter acg = new 1();

    public static int in() {
        if (VERSION.SDK_INT <= 10) {
            return 1;
        }
        try {
            int ad = ad("/sys/devices/system/cpu/possible");
            if (ad == -1) {
                ad = ad("/sys/devices/system/cpu/present");
            }
            if (ad == -1) {
                return new File("/sys/devices/system/cpu/").listFiles(acg).length;
            }
            return ad;
        } catch (SecurityException e) {
            return -1;
        } catch (NullPointerException e2) {
            return -1;
        }
    }

    private static int ad(String str) {
        Throwable th;
        int i = -1;
        InputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream(str);
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
                String readLine = bufferedReader.readLine();
                bufferedReader.close();
                if (readLine != null && readLine.matches("0-[\\d]+$")) {
                    i = Integer.valueOf(readLine.substring(2)).intValue() + 1;
                }
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                }
            } catch (IOException e2) {
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e3) {
                    }
                }
                return i;
            } catch (Throwable th2) {
                th = th2;
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e4) {
                    }
                }
                throw th;
            }
        } catch (IOException e5) {
            fileInputStream = null;
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e32) {
                }
            }
            return i;
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = null;
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e42) {
                }
            }
            throw th;
        }
        return i;
    }

    public static int io() {
        int i;
        FileInputStream fileInputStream;
        int i2 = -1;
        for (int i3 = 0; i3 < in(); i3++) {
            FileInputStream fileInputStream2;
            try {
                File file = new File("/sys/devices/system/cpu/cpu" + i3 + "/cpufreq/cpuinfo_max_freq");
                if (file.exists() && file.canRead()) {
                    byte[] bArr = new byte[128];
                    fileInputStream2 = new FileInputStream(file);
                    fileInputStream2.read(bArr);
                    i = 0;
                    while (Character.isDigit(bArr[i]) && i < 128) {
                        i++;
                    }
                    Integer valueOf = Integer.valueOf(bi.WU(new String(bArr, 0, i)));
                    if (valueOf.intValue() > i2) {
                        i2 = valueOf.intValue();
                    }
                    fileInputStream2.close();
                }
            } catch (NumberFormatException e) {
                fileInputStream2.close();
            } catch (IOException e2) {
                return -1;
            } catch (Throwable th) {
                fileInputStream2.close();
            }
        }
        if (i2 != -1) {
            return i2;
        }
        fileInputStream = new FileInputStream("/proc/cpuinfo");
        i = a("cpu MHz", fileInputStream) * BaseReportManager.MAX_READ_COUNT;
        if (i > i2) {
            i2 = i;
        }
        fileInputStream.close();
        return i2;
    }

    @TargetApi(16)
    public static long U(Context context) {
        if (VERSION.SDK_INT >= 16) {
            MemoryInfo memoryInfo = new MemoryInfo();
            ((ActivityManager) context.getSystemService("activity")).getMemoryInfo(memoryInfo);
            return memoryInfo.totalMem;
        }
        FileInputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream("/proc/meminfo");
            long a = ((long) a("MemTotal", fileInputStream)) * ConstantsAPI$AppSupportContentFlag.MMAPP_SUPPORT_XLS;
            try {
                fileInputStream.close();
                return a;
            } catch (IOException e) {
                return a;
            }
        } catch (IOException e2) {
            return -1;
        } catch (Throwable th) {
            fileInputStream.close();
        }
    }

    private static int a(String str, FileInputStream fileInputStream) {
        int i = 0;
        byte[] bArr = new byte[1024];
        try {
            int read = fileInputStream.read(bArr);
            while (i < read) {
                if (bArr[i] == (byte) 10 || i == 0) {
                    if (bArr[i] == (byte) 10) {
                        i++;
                    }
                    int i2 = i;
                    while (i2 < read) {
                        int i3 = i2 - i;
                        if (bArr[i2] != str.charAt(i3)) {
                            continue;
                            break;
                        } else if (i3 == str.length() - 1) {
                            while (i2 < 1024 && bArr[i2] != (byte) 10) {
                                if (Character.isDigit(bArr[i2])) {
                                    i = i2 + 1;
                                    while (i < 1024 && Character.isDigit(bArr[i])) {
                                        i++;
                                    }
                                    return bi.WU(new String(bArr, 0, i2, i - i2));
                                }
                                i2++;
                            }
                            return -1;
                        } else {
                            i2++;
                        }
                    }
                    continue;
                }
                i++;
            }
        } catch (IOException e) {
        } catch (NumberFormatException e2) {
        }
        return -1;
    }
}

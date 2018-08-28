package com.tencent.mm.ipcinvoker;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.os.Process;
import android.util.Log;
import com.tencent.mm.ipcinvoker.h.b;
import java.io.FileInputStream;
import java.util.List;
import junit.framework.Assert;

public final class e {
    public static Context dmA;
    private static String dmB;

    public static Context getContext() {
        Assert.assertNotNull("IPCInvoker not initialize.", dmA);
        return dmA;
    }

    public static boolean fC(String str) {
        return str != null && str.equals(Cs());
    }

    public static String Cs() {
        if (dmB == null || dmB.length() == 0) {
            dmB = t(dmA, Process.myPid());
        }
        return dmB;
    }

    private static String t(Context context, int i) {
        Throwable e;
        if (context == null) {
            return null;
        }
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        if (activityManager != null) {
            List<RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
            if (!(runningAppProcesses == null || runningAppProcesses.isEmpty())) {
                for (RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                    if (runningAppProcessInfo.pid == i) {
                        return runningAppProcessInfo.processName;
                    }
                }
            }
        }
        byte[] bArr = new byte[128];
        FileInputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream("/proc/" + i + "/cmdline");
            try {
                int read = fileInputStream.read(bArr);
                if (read > 0) {
                    int i2 = 0;
                    while (i2 < read) {
                        if (bArr[i2] > Byte.MIN_VALUE || bArr[i2] <= (byte) 0) {
                            read = i2;
                            break;
                        }
                        i2++;
                    }
                    String str = new String(bArr, 0, read);
                    try {
                        fileInputStream.close();
                        return str;
                    } catch (Exception e2) {
                        return str;
                    }
                }
                try {
                    fileInputStream.close();
                } catch (Exception e3) {
                }
                return null;
            } catch (Exception e4) {
                e = e4;
                try {
                    b.e("IPC.IPCInvokeLogic", "get running process error : %s", new Object[]{Log.getStackTraceString(e)});
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Exception e5) {
                        }
                    }
                    return null;
                } catch (Throwable th) {
                    e = th;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Exception e6) {
                        }
                    }
                    throw e;
                }
            }
        } catch (Exception e7) {
            e = e7;
            fileInputStream = null;
            b.e("IPC.IPCInvokeLogic", "get running process error : %s", new Object[]{Log.getStackTraceString(e)});
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (Exception e52) {
                }
            }
            return null;
        } catch (Throwable th2) {
            e = th2;
            fileInputStream = null;
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (Exception e62) {
                }
            }
            throw e;
        }
    }
}

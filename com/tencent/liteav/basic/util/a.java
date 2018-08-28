package com.tencent.liteav.basic.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.media.MediaFormat;
import android.media.MediaMetadataRetriever;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Process;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.tencent.liteav.basic.datareport.TXCDRApi;
import com.tencent.smtt.utils.TbsLog;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.UUID;

public class a {
    private static float a = 0.0f;
    private static float b = 0.0f;
    private static float c = 0.0f;
    private static float d = 0.0f;
    private static float e = 0.0f;
    private static float f = 0.0f;
    private static boolean g = true;
    private static int[] h = new int[2];
    private static long i = 0;
    private static String j = "";
    private static final Object k = new Object();
    private static boolean l = false;
    private static int[] m = new int[]{96000, 88200, 64000, 48000, 44100, 32000, 24000, 22050, 16000, 12000, 11025, 8000, 7350};

    private static long f() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/" + Process.myPid() + "/stat")), TbsLog.TBSLOG_CODE_SDK_BASE);
            String readLine = bufferedReader.readLine();
            bufferedReader.close();
            String[] split = readLine.split(" ");
            if (split == null || TextUtils.isEmpty(split[13])) {
                return 0;
            }
            return Long.parseLong(split[16]) + ((Long.parseLong(split[13]) + Long.parseLong(split[14])) + Long.parseLong(split[15]));
        } catch (Exception e) {
            return 0;
        }
    }

    private static void g() {
        long parseLong;
        long parseLong2;
        if (VERSION.SDK_INT < 26) {
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/stat")), TbsLog.TBSLOG_CODE_SDK_BASE);
                String readLine = bufferedReader.readLine();
                bufferedReader.close();
                String[] split = readLine.split(" ");
                if (split != null && split.length >= 9) {
                    parseLong = (((((Long.parseLong(split[2]) + Long.parseLong(split[3])) + Long.parseLong(split[4])) + Long.parseLong(split[6])) + Long.parseLong(split[5])) + Long.parseLong(split[7])) + Long.parseLong(split[8]);
                    try {
                        parseLong2 = Long.parseLong(split[6]) + Long.parseLong(split[5]);
                    } catch (Exception e) {
                        parseLong2 = 0;
                        if (g) {
                            a = (float) parseLong;
                            e = (float) parseLong2;
                        }
                        b = (float) parseLong;
                        f = (float) parseLong2;
                        return;
                    }
                    if (g) {
                        a = (float) parseLong;
                        e = (float) parseLong2;
                    }
                    b = (float) parseLong;
                    f = (float) parseLong2;
                    return;
                }
            } catch (Exception e2) {
                parseLong = 0;
                parseLong2 = 0;
                if (g) {
                    a = (float) parseLong;
                    e = (float) parseLong2;
                }
                b = (float) parseLong;
                f = (float) parseLong2;
                return;
            }
        }
        parseLong2 = 0;
        parseLong = 0;
        if (g) {
            b = (float) parseLong;
            f = (float) parseLong2;
            return;
        }
        a = (float) parseLong;
        e = (float) parseLong2;
    }

    public static int[] a() {
        if (i != 0 && TXCTimeUtil.getTimeTick() - i < 2000) {
            return h;
        }
        int[] iArr = new int[2];
        if (g) {
            c = (float) f();
            g();
            g = false;
            iArr[0] = 0;
            iArr[1] = 0;
            return iArr;
        }
        float f;
        float f2;
        d = (float) f();
        g();
        if (b != a) {
            f = (((b - a) - (f - e)) * 100.0f) / (b - a);
            f2 = ((d - c) * 100.0f) / (b - a);
        } else {
            f = 0.0f;
            f2 = 0.0f;
        }
        a = b;
        c = d;
        e = f;
        iArr[0] = (int) (f2 * 10.0f);
        iArr[1] = (int) (f * 10.0f);
        h[0] = iArr[0];
        h[1] = iArr[1];
        i = TXCTimeUtil.getTimeTick();
        return iArr;
    }

    public static String a(Context context) {
        return TXCDRApi.getSimulateIDFA(context);
    }

    public static String b(Context context) {
        String str = "";
        if (context == null) {
            return str;
        }
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).packageName;
        } catch (Exception e) {
            return str;
        }
    }

    public static int c(Context context) {
        if (context == null) {
            return 255;
        }
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null) {
            return 255;
        }
        if (!activeNetworkInfo.isConnected()) {
            return 255;
        }
        if (activeNetworkInfo.getType() == 9) {
            return 5;
        }
        if (activeNetworkInfo.getType() == 1) {
            return 1;
        }
        if (activeNetworkInfo.getType() != 0) {
            return 255;
        }
        switch (telephonyManager.getNetworkType()) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
                return 4;
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
            case 15:
                return 3;
            case 13:
                return 2;
            default:
                return 2;
        }
    }

    public static String b() {
        return Build.MODEL;
    }

    public static String c() {
        return UUID.randomUUID().toString();
    }

    public static String d(Context context) {
        return TXCDRApi.getDevUUID(context, TXCDRApi.getSimulateIDFA(context));
    }

    public static void a(WeakReference<com.tencent.liteav.basic.c.a> weakReference, long j, int i, String str) {
        Bundle bundle = new Bundle();
        bundle.putLong("EVT_USERID", j);
        bundle.putInt("EVT_ID", i);
        bundle.putLong("EVT_TIME", TXCTimeUtil.getTimeTick());
        if (str != null) {
            bundle.putCharSequence("EVT_MSG", str);
        }
        a((WeakReference) weakReference, i, bundle);
    }

    public static void a(WeakReference<com.tencent.liteav.basic.c.a> weakReference, int i, String str) {
        Bundle bundle = new Bundle();
        bundle.putInt("EVT_ID", i);
        bundle.putLong("EVT_TIME", TXCTimeUtil.getTimeTick());
        if (str != null) {
            bundle.putCharSequence("EVT_MSG", str);
        }
        a((WeakReference) weakReference, i, bundle);
    }

    public static void a(WeakReference<com.tencent.liteav.basic.c.a> weakReference, int i, Bundle bundle) {
        if (weakReference != null) {
            com.tencent.liteav.basic.c.a aVar = (com.tencent.liteav.basic.c.a) weakReference.get();
            if (aVar != null) {
                aVar.onNotifyEvent(i, bundle);
            }
        }
    }

    public static void a(WeakReference<com.tencent.liteav.basic.c.a> weakReference, long j, int i, Bundle bundle) {
        if (weakReference != null) {
            com.tencent.liteav.basic.c.a aVar = (com.tencent.liteav.basic.c.a) weakReference.get();
            if (aVar != null) {
                bundle.putLong("EVT_USERID", j);
                aVar.onNotifyEvent(i, bundle);
            }
        }
    }

    public static com.tencent.liteav.basic.d.a a(int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7;
        int i8 = 0;
        if (i * i4 >= i2 * i3) {
            i5 = i2;
            i6 = (i2 * i3) / i4;
        } else {
            i5 = (i * i4) / i3;
            i6 = i;
        }
        if (i > i6) {
            i7 = (i - i6) >> 1;
        } else {
            i7 = 0;
        }
        if (i2 > i5) {
            i8 = (i2 - i5) >> 1;
        }
        return new com.tencent.liteav.basic.d.a(i7, i8, i6, i5);
    }

    public static void d() {
        synchronized (k) {
            if (!l) {
                a("stlport_shared");
                a("saturn");
                a("txffmpeg");
                a("liteavsdk");
                l = true;
            }
        }
    }

    public static void a(String str) {
        try {
            System.loadLibrary(str);
        } catch (Error e) {
            new StringBuilder("load library : ").append(e.toString());
            b(j, str);
        } catch (Exception e2) {
            new StringBuilder("load library : ").append(e2.toString());
            b(j, str);
        }
    }

    private static void b(String str, String str2) {
        try {
            if (!TextUtils.isEmpty(str)) {
                System.load(str + "/lib" + str2 + ".so");
            }
        } catch (Error e) {
            new StringBuilder("load library : ").append(e.toString());
        } catch (Exception e2) {
            new StringBuilder("load library : ").append(e2.toString());
        }
    }

    public static void b(String str) {
        j = str;
    }

    public static String e() {
        return j;
    }

    public static int a(int i) {
        int i2 = 0;
        while (i2 < m.length && m[i2] != i) {
            i2++;
        }
        if (i2 >= m.length) {
            return -1;
        }
        return i2;
    }

    @TargetApi(16)
    public static MediaFormat a(int i, int i2, int i3) {
        int a = a(i);
        ByteBuffer allocate = ByteBuffer.allocate(2);
        allocate.put(0, (byte) ((i3 << 3) | (a >> 1)));
        allocate.put(1, (byte) (((a & 1) << 7) | (i2 << 3)));
        MediaFormat createAudioFormat = MediaFormat.createAudioFormat("audio/mp4a-latm", i, i2);
        createAudioFormat.setInteger("channel-count", i2);
        createAudioFormat.setInteger("sample-rate", i);
        createAudioFormat.setByteBuffer("csd-0", allocate);
        return createAudioFormat;
    }

    public static boolean a(String str, String str2) {
        FileOutputStream fileOutputStream;
        Throwable th;
        if (str == null || str2 == null) {
            return false;
        }
        MediaMetadataRetriever mediaMetadataRetriever;
        try {
            if (!new File(str).exists()) {
                return false;
            }
            Bitmap frameAtTime;
            mediaMetadataRetriever = new MediaMetadataRetriever();
            try {
                mediaMetadataRetriever.setDataSource(str);
                frameAtTime = mediaMetadataRetriever.getFrameAtTime();
                File file = new File(str2);
                if (file.exists()) {
                    file.delete();
                }
                fileOutputStream = new FileOutputStream(file);
            } catch (Exception e) {
                fileOutputStream = null;
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e2) {
                    }
                }
                if (mediaMetadataRetriever != null) {
                    return false;
                }
                mediaMetadataRetriever.release();
                return false;
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream = null;
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e3) {
                    }
                }
                if (mediaMetadataRetriever != null) {
                    mediaMetadataRetriever.release();
                }
                throw th;
            }
            try {
                frameAtTime.compress(CompressFormat.JPEG, 100, fileOutputStream);
                fileOutputStream.flush();
                try {
                    fileOutputStream.close();
                } catch (IOException e4) {
                }
                mediaMetadataRetriever.release();
                return true;
            } catch (Exception e5) {
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e22) {
                    }
                }
                if (mediaMetadataRetriever != null) {
                    return false;
                }
                mediaMetadataRetriever.release();
                return false;
            } catch (Throwable th3) {
                th = th3;
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e32) {
                    }
                }
                if (mediaMetadataRetriever != null) {
                    mediaMetadataRetriever.release();
                }
                throw th;
            }
        } catch (Exception e6) {
            mediaMetadataRetriever = null;
            fileOutputStream = null;
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e222) {
                }
            }
            if (mediaMetadataRetriever != null) {
                return false;
            }
            mediaMetadataRetriever.release();
            return false;
        } catch (Throwable th4) {
            th = th4;
            mediaMetadataRetriever = null;
            fileOutputStream = null;
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e322) {
                }
            }
            if (mediaMetadataRetriever != null) {
                mediaMetadataRetriever.release();
            }
            throw th;
        }
    }
}

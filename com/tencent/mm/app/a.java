package com.tencent.mm.app;

import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Debug;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.util.Base64;
import android.util.Pair;
import com.tencent.mm.compatible.e.p;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa;
import java.io.File;
import java.io.RandomAccessFile;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

public final class a {
    private static String bqA = "";
    private static int bxE = 0;
    private static int bxF = 0;
    private static p bxG = new p((long) Process.myPid());
    private static final b bxH = new b() {
        public final void c(a aVar) {
            int i = ad.getContext().getSharedPreferences("system_config_prefs", 4).getInt("main_thread_watch_report", 0);
            String str = "MicroMsg.ANRWatchDog.summeranr";
            String str2 = "summeranr onAppNotResponding error reportFlag[%b]";
            Object[] objArr = new Object[1];
            objArr[0] = Boolean.valueOf(i > 0);
            x.w(str, str2, objArr);
            try {
                String b = a.a(aVar);
                if (i > 0) {
                    b.A(Base64.encodeToString(b.getBytes(), 2), "main_thread_watch");
                } else {
                    h.mEJ.a(510, 14, 1, true);
                }
            } catch (OutOfMemoryError e) {
                x.e("MicroMsg.ANRWatchDog.summeranr", "summeranr buildReport OutOfMemory %s", new Object[]{e.getMessage()});
                System.gc();
                h.mEJ.a(510, 15, 1, true);
            }
        }
    };
    private static final d bxI = new d() {
        public final void a(InterruptedException interruptedException) {
            x.w("MicroMsg.ANRWatchDog.summeranr", "summeranr DEFAULT_INTERRUPTION_LISTENER onInterrupted exception.getMessage[%s]", new Object[]{interruptedException.getMessage()});
        }
    };
    private static b bxJ = bxH;
    private static d bxK = bxI;
    private static Handler bxL;
    private static int bxM = 4500;
    private static int bxN = 500;
    private static String bxO = "";
    private static boolean bxP = true;
    private static boolean bxQ = false;
    private static Thread bxR;

    static /* synthetic */ int er(int i) {
        int i2 = 0;
        if (i < 0) {
            return -1;
        }
        if (i == 0) {
            return 0;
        }
        if (i == 1 || i == 2) {
            return 1;
        }
        int i3 = 3;
        int i4 = 1;
        int i5 = 1;
        while (i3 <= i) {
            int i6 = i5 + i4;
            i3++;
            i5 = i4;
            i2 = i6;
            i4 = i6;
        }
        return i2;
    }

    static /* synthetic */ int uI() {
        int i = bxF;
        bxF = i + 1;
        return i;
    }

    private static boolean p(String str, int i) {
        if (bi.oW(str)) {
            return false;
        }
        if (str.equals(ad.getPackageName())) {
            bxE = 1;
            if ((i & 1) != 0) {
                return true;
            }
            return false;
        } else if (str.endsWith(":push")) {
            bxE = 2;
            if ((i & 2) != 0) {
                return true;
            }
            return false;
        } else if (str.endsWith(":tools")) {
            bxE = 4;
            if ((i & 4) != 0) {
                return true;
            }
            return false;
        } else if (str.endsWith(":sandbox")) {
            bxE = 8;
            if ((i & 8) != 0) {
                return true;
            }
            return false;
        } else if (str.endsWith(":exdevice")) {
            bxE = 16;
            if ((i & 16) != 0) {
                return true;
            }
            return false;
        } else if (!str.contains(":appbrand")) {
            return false;
        } else {
            bxE = 32;
            if ((i & 32) != 0) {
                return true;
            }
            return false;
        }
    }

    public static void cI(String str) {
        SharedPreferences sharedPreferences = ad.getContext().getSharedPreferences("system_config_prefs", 4);
        int i = sharedPreferences.getInt("main_thread_watch_enable", 65535);
        int i2 = sharedPreferences.getInt("main_thread_watch_timeout", 0);
        int i3 = sharedPreferences.getInt("main_thread_watch_log_loop", 0);
        int i4 = sharedPreferences.getInt("main_thread_watch_report", 0);
        if (p(str, i)) {
            if (i2 <= 0) {
                i2 = 4500;
            }
            if (i3 <= 0) {
                i3 = 500;
            }
            if (bxR != null) {
                bxR.interrupt();
            }
            bqA = str;
            if (i2 > 0) {
                bxM = i2;
            }
            if (i3 > 0) {
                bxN = i3;
            }
            bxR = e.b(new c(), str + "_ANRWatchDog");
            if (bxL == null) {
                bxL = new Handler(Looper.getMainLooper());
            }
            bxR.start();
            x.i("MicroMsg.ANRWatchDog.summeranr", "summeranr startWatch sProcessName[%s], sTimeoutInterval[%d], logLoop[%d], sWatchThread[%s], stack[%s]", new Object[]{bqA, Integer.valueOf(bxM), Integer.valueOf(bxN), bxR.getName(), bi.cjd()});
        }
        x.i("MicroMsg.ANRWatchDog.summeranr", "summeranr startWatch processName[%s] enable[%d], timeout[%d], loop[%d], report[%d]", new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
    }

    private static String a(a aVar) {
        String str;
        JSONObject jSONObject = new JSONObject();
        try {
            int i;
            JSONObject jSONObject2 = new JSONObject();
            jSONObject.put("head", jSONObject2);
            jSONObject2.put("protocol_ver", new Integer(1));
            jSONObject2.put("phone", new String(Build.MODEL));
            jSONObject2.put("os_ver", new String("android-" + VERSION.SDK_INT));
            JSONObject jSONObject3 = new JSONObject();
            jSONObject.put("items", jSONObject3);
            jSONObject3.put("tag", "main_thread_watch");
            JSONArray jSONArray = new JSONArray();
            JSONObject jSONObject4 = new JSONObject();
            jSONArray.put(jSONObject4);
            jSONObject3.put("info", jSONArray);
            JSONObject jSONObject5 = new JSONObject();
            jSONObject4.put("traces", jSONObject5);
            Object obj = aVar.bxS;
            if (!bi.cX(obj)) {
                Iterator it = obj.iterator();
                while (it.hasNext()) {
                    Pair pair = (Pair) it.next();
                    Thread thread = (Thread) pair.first;
                    StackTraceElement[] stackTraceElementArr = (StackTraceElement[]) pair.second;
                    if (stackTraceElementArr != null && stackTraceElementArr.length > 0) {
                        String str2 = thread.getName() + " (prio:" + thread.getPriority() + " tid:" + thread.getId() + " state:" + thread.getState() + ")";
                        JSONArray jSONArray2 = new JSONArray();
                        for (StackTraceElement stackTraceElement : stackTraceElementArr) {
                            if (stackTraceElement != null) {
                                jSONArray2.put(stackTraceElement.toString());
                            }
                        }
                        jSONObject5.put(str2, jSONArray2);
                    }
                }
            }
            try {
                x.i("MicroMsg.ANRWatchDog.summeranr", "summeranr buildReport CpuUsage [%d, %d, %d]", new Object[]{Integer.valueOf(bxG.zw()), Integer.valueOf(bxG.zx()), Integer.valueOf(bxG.zv())});
                jSONObject4.put("cpu_usage_total", r0);
                jSONObject4.put("cpu_usage_pid", i);
                jSONObject4.put("cpu_count", r2);
                ActivityManager activityManager = (ActivityManager) ad.getContext().getSystemService("activity");
                MemoryInfo memoryInfo = new MemoryInfo();
                activityManager.getMemoryInfo(memoryInfo);
                long j = 0;
                if (d.fR(16)) {
                    j = memoryInfo.totalMem;
                } else {
                    RandomAccessFile randomAccessFile = new RandomAccessFile("/proc/meminfo", "r");
                    try {
                        StringBuffer stringBuffer = new StringBuffer();
                        char[] toCharArray = randomAccessFile.readLine().toCharArray();
                        int length = toCharArray.length;
                        i = 0;
                        while (i < length) {
                            if (toCharArray[i] <= '9' && toCharArray[i] >= '0') {
                                stringBuffer.append(toCharArray[i]);
                            }
                            i++;
                        }
                        long j2 = bi.getLong(stringBuffer.toString(), -1);
                        if (j2 > 0) {
                            j = j2 << 10;
                        }
                    } catch (Throwable e) {
                        x.printErrStackTrace("MicroMsg.ANRWatchDog.summeranr", e, "summeranr", new Object[0]);
                    } finally {
                        randomAccessFile.close();
                    }
                }
                x.i("MicroMsg.ANRWatchDog.summeranr", "summeranr buildReport MemoryInfo[%d, %d, %d, %b]", new Object[]{Long.valueOf(j), Long.valueOf(memoryInfo.availMem), Long.valueOf(memoryInfo.threshold), Boolean.valueOf(memoryInfo.lowMemory)});
                jSONObject4.put("mem_sys_total", j);
                jSONObject4.put("mem_sys_avail", memoryInfo.availMem);
                jSONObject4.put("mem_sys_threshold", memoryInfo.threshold);
                jSONObject4.put("mem_sys_low", memoryInfo.lowMemory);
                jSONObject4.put("mem_native_heap_size", Debug.getNativeHeapSize());
                jSONObject4.put("mem_native_heap_alloc_size", Debug.getNativeHeapAllocatedSize());
                jSONObject4.put("mem_native_heap_free_size", Debug.getNativeHeapFreeSize());
                Debug.MemoryInfo[] processMemoryInfo = activityManager.getProcessMemoryInfo(new int[]{Process.myPid()});
                if (!(processMemoryInfo == null || processMemoryInfo.length <= 0 || processMemoryInfo[0] == null)) {
                    Debug.MemoryInfo memoryInfo2 = processMemoryInfo[0];
                    jSONObject4.put("mem_private_dirty", memoryInfo2.getTotalPrivateDirty() << 10);
                    jSONObject4.put("mem_shared_dirty", memoryInfo2.getTotalSharedDirty() << 10);
                    jSONObject4.put("mem_pss", memoryInfo2.getTotalPss() << 10);
                }
                if (bxE == 1 && au.HX() && g.Eg().dpD) {
                    String str3;
                    com.tencent.mm.storage.aa.a[] aVarArr = new com.tencent.mm.storage.aa.a[]{com.tencent.mm.storage.aa.a.sVQ, com.tencent.mm.storage.aa.a.sVR, com.tencent.mm.storage.aa.a.sVS, com.tencent.mm.storage.aa.a.sVT, com.tencent.mm.storage.aa.a.sVU, com.tencent.mm.storage.aa.a.sVV, com.tencent.mm.storage.aa.a.sVW};
                    str = "";
                    i = 0;
                    while (true) {
                        str3 = str;
                        if (i >= 7) {
                            break;
                        }
                        com.tencent.mm.storage.aa.a aVar2 = aVarArr[i];
                        StringBuilder append = new StringBuilder().append(str3);
                        au.HU();
                        str = append.append(c.DT().get(aVar2, Long.valueOf(0))).append(":").toString();
                        i++;
                    }
                    x.i("MicroMsg.ANRWatchDog.summeranr", "summeranr sProcessName[%s] storage_usage[%s]", new Object[]{bqA, str3});
                    jSONObject4.put("storage_usage", str3);
                }
            } catch (Throwable e2) {
                x.printErrStackTrace("MicroMsg.ANRWatchDog.summeranr", e2, "summeranr buildReport storage_usage:", new Object[0]);
                h.mEJ.a(510, 9, 1, true);
            } catch (Throwable e22) {
                x.printErrStackTrace("MicroMsg.ANRWatchDog.summeranr", e22, "summeranr buildReport JSONException:", new Object[0]);
                h.mEJ.a(510, 10, 1, true);
            }
            jSONObject4.put("time", new Integer(bxM));
            int i2 = 0;
            if (new File(aa.duN).exists()) {
                i2 = ad.getContext().getSharedPreferences("system_config_prefs", 4).getInt("default_uin", 0);
            }
            jSONObject3.put("uin", new Long((long) i2));
            jSONObject3.put("process_name", bqA);
            jSONObject3.put("time", new Long(System.currentTimeMillis()));
            jSONObject3.put("cver", new Integer(com.tencent.mm.protocal.d.qVN));
            jSONObject3.put("revision", com.tencent.mm.loader.stub.a.codeRevision());
            h.mEJ.a(510, 8, 1, true);
        } catch (Throwable e222) {
            x.printErrStackTrace("MicroMsg.ANRWatchDog.summeranr", e222, "summeranr buildReport JSONException:", new Object[0]);
            h.mEJ.a(510, 10, 1, true);
        } catch (Throwable e2222) {
            x.printErrStackTrace("MicroMsg.ANRWatchDog.summeranr", e2222, "summeranr buildReport Exception:", new Object[0]);
            h.mEJ.a(510, 11, 1, true);
        }
        String jSONObject6 = jSONObject.toString();
        String str4 = "MicroMsg.ANRWatchDog.summeranr";
        String str5 = "summeranr buildReport packer len[%d][%d][%s]";
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(jSONObject.length());
        objArr[1] = Integer.valueOf(jSONObject6.length());
        if (jSONObject6.length() > 51200) {
            str = jSONObject6.substring(0, 51200);
        } else {
            str = jSONObject6;
        }
        objArr[2] = str;
        x.i(str4, str5, objArr);
        return jSONObject6;
    }
}

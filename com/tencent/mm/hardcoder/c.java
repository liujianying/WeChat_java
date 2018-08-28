package com.tencent.mm.hardcoder;

import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public final class c implements Runnable {
    private Set<Integer> dkG;
    private f dkH;
    private long dkI;
    private long dkJ;
    private h dky;

    public static class a {
        public final int dkO;
        public final long dkP;
        public final int dkQ;
        public final long startTime;

        public a(long j, int i, long j2, int i2) {
            this.startTime = j;
            this.dkO = i;
            this.dkP = j2;
            this.dkQ = i2;
        }

        public final String toString() {
            return String.format("Cpu status,startTime:%s,coreId:%s,freq:%s,power:%s", new Object[]{Long.valueOf(this.startTime), Integer.valueOf(this.dkO), Long.valueOf(this.dkP), Integer.valueOf(this.dkQ)});
        }
    }

    public static class b {
        public final Map<Integer, a> dkR;
        public final Map<Integer, c> dkS;
        public final long time;

        public b(long j, Map<Integer, a> map, Map<Integer, c> map2) {
            this.time = j;
            this.dkR = map;
            this.dkS = map2;
        }
    }

    public static class c {
        public final int dkT;
        public final int dkU;
        public final long dkV;
        public long dkW = 0;
        public final long[] dko;
        public long dkq = 0;
        public final long startTime;

        public c(int i, long j, int i2, long j2, long[] jArr) {
            this.dkT = i;
            this.startTime = j;
            this.dkU = i2;
            this.dkV = j2;
            this.dko = jArr;
            this.dkq = this.dkV;
        }

        public final String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(String.format("Thread status,threadId:%s,startTime:%s,startCoreId:%s,startCoreFreq:%s", new Object[]{Integer.valueOf(this.dkT), Long.valueOf(this.startTime), Integer.valueOf(this.dkU), Long.valueOf(this.dkV)}));
            stringBuilder.append(String.format(",sumJiffies:%s", new Object[]{Long.valueOf(this.dkW)}));
            return stringBuilder.toString();
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
        r13 = this;
        r9 = 1;
        r8 = 0;
    L_0x0002:
        r0 = java.lang.Thread.currentThread();
        r0 = r0.isInterrupted();
        if (r0 != 0) goto L_0x011b;
    L_0x000c:
        r2 = java.lang.System.currentTimeMillis();	 Catch:{ InterruptedException -> 0x00f9, Exception -> 0x016d }
        r0 = r13.dkI;	 Catch:{ InterruptedException -> 0x00f9, Exception -> 0x016d }
        r0 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1));
        if (r0 < 0) goto L_0x01eb;
    L_0x0016:
        r0 = r13.dkJ;	 Catch:{ InterruptedException -> 0x00f9, Exception -> 0x016d }
        r0 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1));
        if (r0 > 0) goto L_0x01eb;
    L_0x001c:
        r0 = com.tencent.mm.hardcoder.HardCoderJNI.hcDebug;	 Catch:{ InterruptedException -> 0x00f9, Exception -> 0x016d }
        if (r0 == 0) goto L_0x003a;
    L_0x0020:
        r0 = "MicroMsg.HardCoderMonitor";
        r1 = new java.lang.StringBuilder;	 Catch:{ InterruptedException -> 0x00f9, Exception -> 0x016d }
        r4 = "get cpu current freq,begin:";
        r1.<init>(r4);	 Catch:{ InterruptedException -> 0x00f9, Exception -> 0x016d }
        r4 = android.os.SystemClock.elapsedRealtime();	 Catch:{ InterruptedException -> 0x00f9, Exception -> 0x016d }
        r1 = r1.append(r4);	 Catch:{ InterruptedException -> 0x00f9, Exception -> 0x016d }
        r1 = r1.toString();	 Catch:{ InterruptedException -> 0x00f9, Exception -> 0x016d }
        com.tencent.mm.sdk.platformtools.x.d(r0, r1);	 Catch:{ InterruptedException -> 0x00f9, Exception -> 0x016d }
    L_0x003a:
        r0 = r13.dky;	 Catch:{ InterruptedException -> 0x00f9, Exception -> 0x016d }
        r10 = a(r2, r0);	 Catch:{ InterruptedException -> 0x00f9, Exception -> 0x016d }
        r0 = com.tencent.mm.hardcoder.HardCoderJNI.hcDebug;	 Catch:{ InterruptedException -> 0x00f9, Exception -> 0x016d }
        if (r0 == 0) goto L_0x005e;
    L_0x0044:
        r0 = "MicroMsg.HardCoderMonitor";
        r1 = new java.lang.StringBuilder;	 Catch:{ InterruptedException -> 0x00f9, Exception -> 0x016d }
        r4 = "get cpu current freq,end:";
        r1.<init>(r4);	 Catch:{ InterruptedException -> 0x00f9, Exception -> 0x016d }
        r4 = android.os.SystemClock.elapsedRealtime();	 Catch:{ InterruptedException -> 0x00f9, Exception -> 0x016d }
        r1 = r1.append(r4);	 Catch:{ InterruptedException -> 0x00f9, Exception -> 0x016d }
        r1 = r1.toString();	 Catch:{ InterruptedException -> 0x00f9, Exception -> 0x016d }
        com.tencent.mm.sdk.platformtools.x.d(r0, r1);	 Catch:{ InterruptedException -> 0x00f9, Exception -> 0x016d }
    L_0x005e:
        r4 = new java.util.HashSet;	 Catch:{ InterruptedException -> 0x00f9, Exception -> 0x016d }
        r4.<init>();	 Catch:{ InterruptedException -> 0x00f9, Exception -> 0x016d }
        r0 = new java.io.File;	 Catch:{ InterruptedException -> 0x00f9, Exception -> 0x016d }
        r1 = new java.lang.StringBuilder;	 Catch:{ InterruptedException -> 0x00f9, Exception -> 0x016d }
        r5 = "/proc/";
        r1.<init>(r5);	 Catch:{ InterruptedException -> 0x00f9, Exception -> 0x016d }
        r5 = android.os.Process.myPid();	 Catch:{ InterruptedException -> 0x00f9, Exception -> 0x016d }
        r1 = r1.append(r5);	 Catch:{ InterruptedException -> 0x00f9, Exception -> 0x016d }
        r5 = "/task";
        r1 = r1.append(r5);	 Catch:{ InterruptedException -> 0x00f9, Exception -> 0x016d }
        r1 = r1.toString();	 Catch:{ InterruptedException -> 0x00f9, Exception -> 0x016d }
        r0.<init>(r1);	 Catch:{ InterruptedException -> 0x00f9, Exception -> 0x016d }
        r1 = r0.isDirectory();	 Catch:{ InterruptedException -> 0x00f9, Exception -> 0x016d }
        if (r1 == 0) goto L_0x018d;
    L_0x0089:
        r5 = r0.listFiles();	 Catch:{ InterruptedException -> 0x00f9, Exception -> 0x016d }
        if (r5 == 0) goto L_0x0092;
    L_0x008f:
        r0 = r5.length;	 Catch:{ InterruptedException -> 0x00f9, Exception -> 0x016d }
        if (r0 != 0) goto L_0x011c;
    L_0x0092:
        r0 = r9;
    L_0x0093:
        r11 = new java.util.TreeMap;	 Catch:{ InterruptedException -> 0x00f9, Exception -> 0x016d }
        r11.<init>();	 Catch:{ InterruptedException -> 0x00f9, Exception -> 0x016d }
        r1 = r13.dkG;	 Catch:{ InterruptedException -> 0x00f9, Exception -> 0x016d }
        r1.addAll(r4);	 Catch:{ InterruptedException -> 0x00f9, Exception -> 0x016d }
        r1 = com.tencent.mm.hardcoder.HardCoderJNI.hcDebug;	 Catch:{ InterruptedException -> 0x00f9, Exception -> 0x016d }
        if (r1 == 0) goto L_0x00bb;
    L_0x00a1:
        r1 = "MicroMsg.HardCoderMonitor";
        r4 = new java.lang.StringBuilder;	 Catch:{ InterruptedException -> 0x00f9, Exception -> 0x016d }
        r5 = "get thread current stat,end:";
        r4.<init>(r5);	 Catch:{ InterruptedException -> 0x00f9, Exception -> 0x016d }
        r6 = android.os.SystemClock.elapsedRealtime();	 Catch:{ InterruptedException -> 0x00f9, Exception -> 0x016d }
        r4 = r4.append(r6);	 Catch:{ InterruptedException -> 0x00f9, Exception -> 0x016d }
        r4 = r4.toString();	 Catch:{ InterruptedException -> 0x00f9, Exception -> 0x016d }
        com.tencent.mm.sdk.platformtools.x.d(r1, r4);	 Catch:{ InterruptedException -> 0x00f9, Exception -> 0x016d }
    L_0x00bb:
        if (r0 != 0) goto L_0x01d5;
    L_0x00bd:
        r0 = r13.dkG;	 Catch:{ InterruptedException -> 0x00f9, Exception -> 0x016d }
        r0 = r0.isEmpty();	 Catch:{ InterruptedException -> 0x00f9, Exception -> 0x016d }
        if (r0 != 0) goto L_0x01cb;
    L_0x00c5:
        r0 = r13.dkG;	 Catch:{ InterruptedException -> 0x00f9, Exception -> 0x016d }
        r12 = r0.iterator();	 Catch:{ InterruptedException -> 0x00f9, Exception -> 0x016d }
    L_0x00cb:
        r0 = r12.hasNext();	 Catch:{ InterruptedException -> 0x00f9, Exception -> 0x016d }
        if (r0 == 0) goto L_0x01a7;
    L_0x00d1:
        r0 = r12.next();	 Catch:{ InterruptedException -> 0x00f9, Exception -> 0x016d }
        r0 = (java.lang.Integer) r0;	 Catch:{ InterruptedException -> 0x00f9, Exception -> 0x016d }
        r1 = r0.intValue();	 Catch:{ InterruptedException -> 0x00f9, Exception -> 0x016d }
        r7 = com.tencent.mm.hardcoder.HardCoderJNI.getThreadCpuJiffies(r1);	 Catch:{ InterruptedException -> 0x00f9, Exception -> 0x016d }
        r4 = com.tencent.mm.hardcoder.HardCoderJNI.getThreadCoreId(r1);	 Catch:{ InterruptedException -> 0x00f9, Exception -> 0x016d }
        r5 = com.tencent.mm.hardcoder.HardCoderJNI.getCpuFreqByCoreId(r4);	 Catch:{ InterruptedException -> 0x00f9, Exception -> 0x016d }
        r0 = java.lang.Integer.valueOf(r1);	 Catch:{ InterruptedException -> 0x00f9, Exception -> 0x016d }
        r0 = r11.containsKey(r0);	 Catch:{ InterruptedException -> 0x00f9, Exception -> 0x016d }
        if (r0 == 0) goto L_0x0199;
    L_0x00f1:
        r0 = java.lang.Integer.valueOf(r1);	 Catch:{ InterruptedException -> 0x00f9, Exception -> 0x016d }
        r11.get(r0);	 Catch:{ InterruptedException -> 0x00f9, Exception -> 0x016d }
        goto L_0x00cb;
    L_0x00f9:
        r0 = move-exception;
        r1 = "MicroMsg.HardCoderMonitor";
        r2 = new java.lang.StringBuilder;
        r3 = "Monitor thread need to interrupt:";
        r2.<init>(r3);
        r0 = r0.getMessage();
        r0 = r2.append(r0);
        r0 = r0.toString();
        com.tencent.mm.sdk.platformtools.x.e(r1, r0);
        r0 = java.lang.Thread.currentThread();
        r0.interrupt();
    L_0x011b:
        return;
    L_0x011c:
        r0 = com.tencent.mm.hardcoder.HardCoderJNI.hcDebug;	 Catch:{ InterruptedException -> 0x00f9, Exception -> 0x016d }
        if (r0 == 0) goto L_0x0137;
    L_0x0120:
        r0 = "MicroMsg.HardCoderMonitor";
        r1 = new java.lang.StringBuilder;	 Catch:{ InterruptedException -> 0x00f9, Exception -> 0x016d }
        r6 = "thread size:";
        r1.<init>(r6);	 Catch:{ InterruptedException -> 0x00f9, Exception -> 0x016d }
        r6 = r5.length;	 Catch:{ InterruptedException -> 0x00f9, Exception -> 0x016d }
        r1 = r1.append(r6);	 Catch:{ InterruptedException -> 0x00f9, Exception -> 0x016d }
        r1 = r1.toString();	 Catch:{ InterruptedException -> 0x00f9, Exception -> 0x016d }
        com.tencent.mm.sdk.platformtools.x.i(r0, r1);	 Catch:{ InterruptedException -> 0x00f9, Exception -> 0x016d }
    L_0x0137:
        r6 = r5.length;	 Catch:{ InterruptedException -> 0x00f9, Exception -> 0x016d }
        r1 = r8;
    L_0x0139:
        if (r1 >= r6) goto L_0x018a;
    L_0x013b:
        r0 = r5[r1];	 Catch:{ InterruptedException -> 0x00f9, Exception -> 0x016d }
        r0 = r0.getName();	 Catch:{ InterruptedException -> 0x00f9, Exception -> 0x016d }
        r7 = 0;
        r0 = com.tencent.mm.sdk.platformtools.bi.getInt(r0, r7);	 Catch:{ Exception -> 0x0151, InterruptedException -> 0x00f9 }
        r0 = java.lang.Integer.valueOf(r0);	 Catch:{ Exception -> 0x0151, InterruptedException -> 0x00f9 }
        r4.add(r0);	 Catch:{ Exception -> 0x0151, InterruptedException -> 0x00f9 }
    L_0x014d:
        r0 = r1 + 1;
        r1 = r0;
        goto L_0x0139;
    L_0x0151:
        r0 = move-exception;
        r7 = "MicroMsg.HardCoderMonitor";
        r11 = new java.lang.StringBuilder;	 Catch:{ InterruptedException -> 0x00f9, Exception -> 0x016d }
        r12 = "integer parse error:";
        r11.<init>(r12);	 Catch:{ InterruptedException -> 0x00f9, Exception -> 0x016d }
        r0 = r0.getMessage();	 Catch:{ InterruptedException -> 0x00f9, Exception -> 0x016d }
        r0 = r11.append(r0);	 Catch:{ InterruptedException -> 0x00f9, Exception -> 0x016d }
        r0 = r0.toString();	 Catch:{ InterruptedException -> 0x00f9, Exception -> 0x016d }
        com.tencent.mm.sdk.platformtools.x.e(r7, r0);	 Catch:{ InterruptedException -> 0x00f9, Exception -> 0x016d }
        goto L_0x014d;
    L_0x016d:
        r0 = move-exception;
        r1 = "MicroMsg.HardCoderMonitor";
        r2 = new java.lang.StringBuilder;
        r3 = "exception:";
        r2.<init>(r3);
        r0 = r0.getMessage();
        r0 = r2.append(r0);
        r0 = r0.toString();
        com.tencent.mm.sdk.platformtools.x.e(r1, r0);
        goto L_0x0002;
    L_0x018a:
        r0 = r8;
        goto L_0x0093;
    L_0x018d:
        r0 = "MicroMsg.HardCoderMonitor";
        r1 = "impossible as usual";
        com.tencent.mm.sdk.platformtools.x.e(r0, r1);	 Catch:{ InterruptedException -> 0x00f9, Exception -> 0x016d }
        r0 = r9;
        goto L_0x0093;
    L_0x0199:
        r0 = new com.tencent.mm.hardcoder.c$c;	 Catch:{ InterruptedException -> 0x00f9, Exception -> 0x016d }
        r0.<init>(r1, r2, r4, r5, r7);	 Catch:{ InterruptedException -> 0x00f9, Exception -> 0x016d }
        r1 = java.lang.Integer.valueOf(r1);	 Catch:{ InterruptedException -> 0x00f9, Exception -> 0x016d }
        r11.put(r1, r0);	 Catch:{ InterruptedException -> 0x00f9, Exception -> 0x016d }
        goto L_0x00cb;
    L_0x01a7:
        r1 = r13.dkH;	 Catch:{ InterruptedException -> 0x00f9, Exception -> 0x016d }
        r0 = new com.tencent.mm.hardcoder.c$b;	 Catch:{ InterruptedException -> 0x00f9, Exception -> 0x016d }
        r0.<init>(r2, r10, r11);	 Catch:{ InterruptedException -> 0x00f9, Exception -> 0x016d }
        r2 = r1.dlb;	 Catch:{ InterruptedException -> 0x00f9, Exception -> 0x016d }
        if (r2 == 0) goto L_0x01bc;
    L_0x01b2:
        r2 = r1.dlb;	 Catch:{ InterruptedException -> 0x00f9, Exception -> 0x016d }
        r2.add(r0);	 Catch:{ InterruptedException -> 0x00f9, Exception -> 0x016d }
        monitor-enter(r1);	 Catch:{ InterruptedException -> 0x00f9, Exception -> 0x016d }
        r1.notify();	 Catch:{ all -> 0x01c8 }
        monitor-exit(r1);	 Catch:{ all -> 0x01c8 }
    L_0x01bc:
        monitor-enter(r13);	 Catch:{ InterruptedException -> 0x00f9, Exception -> 0x016d }
        r0 = 50;
        r13.wait(r0);	 Catch:{ all -> 0x01c5 }
        monitor-exit(r13);	 Catch:{ all -> 0x01c5 }
        goto L_0x0002;
    L_0x01c5:
        r0 = move-exception;
        monitor-exit(r13);	 Catch:{ all -> 0x01c5 }
        throw r0;	 Catch:{ InterruptedException -> 0x00f9, Exception -> 0x016d }
    L_0x01c8:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x01c8 }
        throw r0;	 Catch:{ InterruptedException -> 0x00f9, Exception -> 0x016d }
    L_0x01cb:
        monitor-enter(r13);	 Catch:{ InterruptedException -> 0x00f9, Exception -> 0x016d }
        r13.wait();	 Catch:{ all -> 0x01d2 }
        monitor-exit(r13);	 Catch:{ all -> 0x01d2 }
        goto L_0x0002;
    L_0x01d2:
        r0 = move-exception;
        monitor-exit(r13);	 Catch:{ all -> 0x01d2 }
        throw r0;	 Catch:{ InterruptedException -> 0x00f9, Exception -> 0x016d }
    L_0x01d5:
        monitor-enter(r13);	 Catch:{ InterruptedException -> 0x00f9, Exception -> 0x016d }
        r0 = 60000; // 0xea60 float:8.4078E-41 double:2.9644E-319;
        r13.wait(r0);	 Catch:{ all -> 0x01e8 }
        monitor-exit(r13);	 Catch:{ all -> 0x01e8 }
        r0 = "MicroMsg.HardCoderMonitor";
        r1 = "Monitor thread wait(pid/task error):60000";
        com.tencent.mm.sdk.platformtools.x.i(r0, r1);	 Catch:{ InterruptedException -> 0x00f9, Exception -> 0x016d }
        goto L_0x0002;
    L_0x01e8:
        r0 = move-exception;
        monitor-exit(r13);	 Catch:{ all -> 0x01e8 }
        throw r0;	 Catch:{ InterruptedException -> 0x00f9, Exception -> 0x016d }
    L_0x01eb:
        monitor-enter(r13);	 Catch:{ InterruptedException -> 0x00f9, Exception -> 0x016d }
        r0 = 60000; // 0xea60 float:8.4078E-41 double:2.9644E-319;
        r13.wait(r0);	 Catch:{ all -> 0x01fe }
        monitor-exit(r13);	 Catch:{ all -> 0x01fe }
        r0 = "MicroMsg.HardCoderMonitor";
        r1 = "Monitor thread wait(no in time):60000";
        com.tencent.mm.sdk.platformtools.x.i(r0, r1);	 Catch:{ InterruptedException -> 0x00f9, Exception -> 0x016d }
        goto L_0x0002;
    L_0x01fe:
        r0 = move-exception;
        monitor-exit(r13);	 Catch:{ all -> 0x01fe }
        throw r0;	 Catch:{ InterruptedException -> 0x00f9, Exception -> 0x016d }
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.hardcoder.c.run():void");
    }

    public static Map<Integer, a> a(long j, h hVar) {
        Exception e;
        InputStream inputStream;
        Throwable th;
        final Map<Integer, a> treeMap = new TreeMap();
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        for (int i = 0; i < availableProcessors; i++) {
            File file = new File("/sys/devices/system/cpu/cpu" + i + "/cpufreq/scaling_cur_freq");
            if (file.exists()) {
                String absolutePath = file.getAbsolutePath();
                final h hVar2 = hVar;
                final long j2 = j;
                com.tencent.mm.hardcoder.g.a anonymousClass1 = new com.tencent.mm.hardcoder.g.a() {
                    public final boolean fx(String str) {
                        int intValue;
                        a aVar;
                        long j = bi.getLong(str.trim(), 0);
                        if (hVar2.dlk.containsKey(Integer.valueOf(i))) {
                            Integer num = (Integer) ((com.tencent.mm.hardcoder.h.a) hVar2.dlk.get(Integer.valueOf(i))).dlq.get(Long.valueOf(j));
                            if (num != null) {
                                intValue = num.intValue();
                                aVar = new a(j2, i, j, intValue);
                                treeMap.put(Integer.valueOf(i), aVar);
                                if (HardCoderJNI.hcDebug) {
                                    x.d("MicroMsg.HardCoderMonitor", aVar.toString());
                                }
                                return false;
                            }
                        }
                        intValue = 0;
                        aVar = new a(j2, i, j, intValue);
                        treeMap.put(Integer.valueOf(i), aVar);
                        if (HardCoderJNI.hcDebug) {
                            x.d("MicroMsg.HardCoderMonitor", aVar.toString());
                        }
                        return false;
                    }
                };
                try {
                    InputStream fileInputStream = new FileInputStream(absolutePath);
                    try {
                        g.a(fileInputStream, anonymousClass1);
                        try {
                            fileInputStream.close();
                        } catch (Exception e2) {
                            x.e("MicroMsg.HardCoderUtil", "exception:" + e2.getMessage());
                        }
                    } catch (Exception e3) {
                        e2 = e3;
                        inputStream = fileInputStream;
                        try {
                            x.e("MicroMsg.HardCoderUtil", "exception:" + e2.getMessage());
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (Exception e22) {
                                    x.e("MicroMsg.HardCoderUtil", "exception:" + e22.getMessage());
                                }
                            }
                        } catch (Throwable th2) {
                            th = th2;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        inputStream = fileInputStream;
                    }
                } catch (Exception e4) {
                    e22 = e4;
                    inputStream = null;
                    x.e("MicroMsg.HardCoderUtil", "exception:" + e22.getMessage());
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Exception e222) {
                            x.e("MicroMsg.HardCoderUtil", "exception:" + e222.getMessage());
                        }
                    }
                } catch (Throwable th4) {
                    th = th4;
                    inputStream = null;
                }
            }
        }
        return treeMap;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (Exception e5) {
                x.e("MicroMsg.HardCoderUtil", "exception:" + e5.getMessage());
            }
        }
        throw th;
        throw th;
    }

    protected final void finalize() {
        super.finalize();
        this.dkG = null;
        this.dky = null;
        this.dkH = null;
    }
}

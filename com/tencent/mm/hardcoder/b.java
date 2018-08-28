package com.tencent.mm.hardcoder;

import com.tencent.mm.sdk.platformtools.x;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public final class b implements Runnable {
    private Queue<Object> dkx = new ConcurrentLinkedQueue();
    private h dky = new h();
    private boolean dkz = false;
    private Thread thread = null;

    public static class a {
        public final long dkA;
        public final long dkB;
        public final long dkf;
        public final int scene;
        public final int type;

        public a(int i, long j, int i2, long j2, long j3) {
            this.scene = i;
            this.dkf = j;
            this.type = i2;
            this.dkA = j2;
            this.dkB = j3;
        }
    }

    public static class b {
        public final boolean caO;
        public final boolean dkC;
        public final int key;
        public final int value;

        public b(boolean z, int i, int i2, boolean z2) {
            this.dkC = z;
            this.key = i;
            this.value = i2;
            this.caO = z2;
        }
    }

    public static class c {
        public final List<a> dkD;
        public final int dkE;
        public final int dkF;
        public final int[] dkn;
        public final long time;

        public c(long j, List<a> list, int i, int i2, int[] iArr) {
            this.time = j;
            this.dkD = list;
            this.dkE = i;
            this.dkF = i2;
            this.dkn = iArr;
        }
    }

    public b() {
        this.dky.initialize();
    }

    public final synchronized void start() {
        if (this.thread == null) {
            this.thread = new Thread(this);
            this.thread.setPriority(5);
            this.thread.start();
        }
    }

    public final void run() {
        x.i("MicroMsg.HCPerfStatThread", "[oneliang]HCPerfStatThread running");
        while (!Thread.currentThread().isInterrupted()) {
            try {
                if (this.dkx.isEmpty()) {
                    synchronized (this) {
                        if (this.dkz && this.thread != null) {
                            this.thread.interrupt();
                            this.thread = null;
                            this.dkz = false;
                        }
                        wait();
                    }
                } else {
                    Object poll = this.dkx.poll();
                    if (poll instanceof c) {
                        long[] jArr;
                        c cVar = (c) poll;
                        long j = cVar.time;
                        List list = cVar.dkD;
                        int i = cVar.dkE;
                        int i2 = cVar.dkF;
                        int[] iArr = cVar.dkn;
                        if (HardCoderJNI.hcDebug) {
                            x.d("MicroMsg.HardCoderReporter", "[oneliang]save task status,time:%s,size:%s,cpu:%s,io:%s", Long.valueOf(j), Integer.valueOf(list.size()), Integer.valueOf(i), Integer.valueOf(i2));
                        }
                        Map a = c.a(j, this.dky);
                        int[] k = com.tencent.mm.hardcoder.f.b.k(a);
                        long[] myProcCpuTime = HardCoderJNI.getMyProcCpuTime();
                        if (myProcCpuTime == null) {
                            jArr = new long[]{0, 0};
                        } else {
                            jArr = myProcCpuTime;
                        }
                        int i3 = 0;
                        while (true) {
                            int i4 = i3;
                            if (i4 >= list.size()) {
                                continue;
                                break;
                            }
                            a aVar = (a) list.get(i4);
                            if (aVar.dke != 0) {
                                int[] iArr2;
                                int i5;
                                long j2 = j - aVar.lastUpdateTime;
                                aVar.lastUpdateTime = j;
                                if (i == -1) {
                                    aVar.dkj = 0;
                                    iArr2 = aVar.dkl;
                                    i5 = aVar.dkj;
                                    iArr2[i5] = (int) (((long) iArr2[i5]) + j2);
                                } else if (i == -2) {
                                    iArr2 = aVar.dkl;
                                    i5 = aVar.dkj;
                                    iArr2[i5] = (int) (((long) iArr2[i5]) + j2);
                                } else {
                                    aVar.dkj = i;
                                    iArr2 = aVar.dkl;
                                    iArr2[i] = (int) (((long) iArr2[i]) + j2);
                                }
                                if (i2 == -1) {
                                    aVar.dkk = 0;
                                    iArr2 = aVar.dkm;
                                    i5 = aVar.dkk;
                                    iArr2[i5] = (int) (j2 + ((long) iArr2[i5]));
                                } else if (i2 == -2) {
                                    iArr2 = aVar.dkm;
                                    i5 = aVar.dkk;
                                    iArr2[i5] = (int) (j2 + ((long) iArr2[i5]));
                                } else {
                                    aVar.dkk = i2;
                                    iArr2 = aVar.dkm;
                                    iArr2[i2] = (int) (j2 + ((long) iArr2[i2]));
                                }
                                if (iArr != null && iArr.length > 0) {
                                    aVar.dkn = iArr;
                                }
                                long[] threadCpuJiffies = HardCoderJNI.getThreadCpuJiffies(aVar.dke);
                                if (threadCpuJiffies == null) {
                                    threadCpuJiffies = new long[]{0, 0};
                                }
                                j2 = HardCoderJNI.getCpuFreqByCoreId(HardCoderJNI.getThreadCoreId(aVar.dke));
                                if (aVar.dkq == 0) {
                                    aVar.dkq = j2;
                                }
                                if (aVar.dko == null) {
                                    aVar.dko = threadCpuJiffies;
                                }
                                if (aVar.dkp == null) {
                                    aVar.dkp = jArr;
                                }
                                aVar.dkq = (j2 + aVar.dkq) / 2;
                                if (threadCpuJiffies != null && aVar.dke > 0) {
                                    aVar.dkr = (int) ((threadCpuJiffies[0] - aVar.dko[0]) + (threadCpuJiffies[1] - aVar.dko[1]));
                                    if (HardCoderJNI.hcDebug) {
                                        x.d("MicroMsg.HardCoderReporter", "thread id:" + aVar.dke + ",start jiffies:[" + aVar.dko[0] + "," + aVar.dko[1] + "], end jiffies:[" + threadCpuJiffies[0] + "," + threadCpuJiffies[1] + "],sum thread jiffies:" + aVar.dkr);
                                    }
                                }
                                if (jArr != null && aVar.dke > 0 && HardCoderJNI.hcDebug) {
                                    aVar.dks = (jArr[0] - aVar.dkp[0]) + (jArr[1] - aVar.dkp[1]);
                                    x.d("MicroMsg.HardCoderReporter", "thread id:" + aVar.dke + ",process start jiffies:[" + aVar.dkp[0] + "," + aVar.dkp[1] + "], process end jiffies:[" + jArr[0] + "," + jArr[1] + "],sum process jiffies:" + aVar.dks);
                                }
                                if (aVar.dkt == null && aVar.dku == null) {
                                    aVar.dkt = new com.tencent.mm.hardcoder.f.a(((com.tencent.mm.hardcoder.c.a) a.get(Integer.valueOf(k[0]))).dkP, (long) ((com.tencent.mm.hardcoder.c.a) a.get(Integer.valueOf(k[0]))).dkQ);
                                    if (k[1] < 0) {
                                        x.e("MicroMsg.HCPerfStatThread", "cluster one is unused?may be possible.");
                                        aVar.dku = null;
                                    } else {
                                        aVar.dku = new com.tencent.mm.hardcoder.f.a(((com.tencent.mm.hardcoder.c.a) a.get(Integer.valueOf(k[1]))).dkP, (long) ((com.tencent.mm.hardcoder.c.a) a.get(Integer.valueOf(k[1]))).dkQ);
                                    }
                                } else {
                                    if (aVar.dkt != null) {
                                        aVar.dkt.k(((com.tencent.mm.hardcoder.c.a) a.get(Integer.valueOf(k[0]))).dkP, (long) ((com.tencent.mm.hardcoder.c.a) a.get(Integer.valueOf(k[0]))).dkQ);
                                    }
                                    if (aVar.dku != null) {
                                        aVar.dku.k(((com.tencent.mm.hardcoder.c.a) a.get(Integer.valueOf(k[1]))).dkP, (long) ((com.tencent.mm.hardcoder.c.a) a.get(Integer.valueOf(k[1]))).dkQ);
                                    }
                                }
                            }
                            i3 = i4 + 1;
                        }
                    } else if (poll instanceof a) {
                        d.a((a) poll);
                    } else if (poll instanceof a) {
                        d.a((a) poll);
                    } else if (poll instanceof b) {
                        b bVar = (b) poll;
                        d.reportIDKey(bVar.dkC, bVar.key, bVar.value, bVar.caO);
                    }
                }
            } catch (InterruptedException e) {
                x.e("MicroMsg.HCPerfStatThread", "Performance status thread need to interrupt:" + e.getMessage());
                Thread.currentThread().interrupt();
                return;
            } catch (Exception e2) {
                x.e("MicroMsg.HCPerfStatThread", "exception:" + e2.getMessage());
            }
        }
    }

    public final void as(Object obj) {
        if (this.dkx != null) {
            this.dkx.add(obj);
            synchronized (this) {
                notify();
            }
        }
    }

    protected final void finalize() {
        super.finalize();
        this.dkx = null;
    }
}

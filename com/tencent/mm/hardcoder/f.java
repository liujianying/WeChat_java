package com.tencent.mm.hardcoder;

import com.tencent.mm.hardcoder.c.c;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Deque;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public final class f implements Runnable {
    private boolean dkz;
    Queue<com.tencent.mm.hardcoder.c.b> dlb;
    private b dlc;
    private Deque<b> dld;
    private Thread thread;

    public static class a {
        public final long dle;
        public final long dlf;
        public long dlg = 0;
        public long dlh = 0;

        public a(long j, long j2) {
            this.dle = j;
            this.dlf = j2;
            this.dlg = this.dle;
            this.dlh = this.dlf;
        }

        public final void k(long j, long j2) {
            this.dlg = (this.dlg + j) / 2;
            this.dlh = (this.dlh + j2) / 2;
        }

        public final String toString() {
            return String.format("startFreq:%s,startPower:%s,averageFreq:%s,averagePower:%s", new Object[]{Long.valueOf(this.dle), Long.valueOf(this.dlf), Long.valueOf(this.dlg), Long.valueOf(this.dlh)});
        }
    }

    public static class b {
        public final Map<Integer, com.tencent.mm.hardcoder.c.a> dkR;
        public final a dkt;
        public final a dku;
        public final Map<Integer, c> dli = new TreeMap();
        public long dlj = 0;
        public final long startTime;

        public b(long j, Map<Integer, com.tencent.mm.hardcoder.c.a> map, Map<Integer, c> map2) {
            int[] k = k(map);
            this.dkR = map;
            this.dkt = new a(((com.tencent.mm.hardcoder.c.a) map.get(Integer.valueOf(k[0]))).dkP, (long) ((com.tencent.mm.hardcoder.c.a) map.get(Integer.valueOf(k[0]))).dkQ);
            if (k[1] < 0) {
                x.e("MicroMsg.HardCoderStatThread", "cluster one is unused?may be possible.");
                this.dku = null;
            } else {
                this.dku = new a(((com.tencent.mm.hardcoder.c.a) map.get(Integer.valueOf(k[1]))).dkP, (long) ((com.tencent.mm.hardcoder.c.a) map.get(Integer.valueOf(k[1]))).dkQ);
            }
            this.startTime = j;
            this.dlj = this.startTime;
            l(map2);
        }

        public static int[] k(Map<Integer, com.tencent.mm.hardcoder.c.a> map) {
            if (map == null) {
                throw new NullPointerException("cpuStatusMap can not be null");
            }
            int i;
            int i2;
            for (i = h.dlm; i >= 0; i--) {
                if (map.containsKey(Integer.valueOf(i))) {
                    i2 = i;
                    break;
                }
            }
            i2 = -1;
            if (i2 < 0) {
                throw new NullPointerException("cluster zero is unused?impossible.");
            }
            i = h.dln;
            while (i > h.dlm) {
                if (map.containsKey(Integer.valueOf(i))) {
                    break;
                }
                i--;
            }
            i = -1;
            return new int[]{i2, i};
        }

        final void l(Map<Integer, c> map) {
            if (map == null) {
                throw new NullPointerException("threadStatusMap can not be null");
            }
            for (Integer num : map.keySet()) {
                c cVar;
                c cVar2 = (c) map.get(num);
                if (this.dli.containsKey(num)) {
                    cVar = (c) this.dli.get(num);
                } else {
                    cVar = new c(cVar2.dkT, cVar2.startTime, cVar2.dkU, cVar2.dkV, cVar2.dko);
                    this.dli.put(num, cVar);
                }
                long j = cVar2.dkV;
                long[] jArr = cVar2.dko;
                cVar.dkq = (j + cVar.dkq) / 2;
                if (jArr != null) {
                    cVar.dkW = (jArr[0] - cVar.dko[0]) + (jArr[1] - cVar.dko[1]);
                    if (HardCoderJNI.hcDebug) {
                        x.d("MicroMsg.HardCoderMonitor", "thread id:" + cVar.dkT + ",start jiffies:[" + cVar.dko[0] + "," + cVar.dko[1] + "], end jiffies:[" + jArr[0] + "," + jArr[1] + "]");
                    }
                }
            }
        }

        public final String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(String.format("startTime:%s,updateTime:%s", new Object[]{Long.valueOf(this.startTime), Long.valueOf(this.dlj)}));
            stringBuilder.append(",");
            stringBuilder.append(this.dkt);
            if (this.dku != null) {
                stringBuilder.append(",");
                stringBuilder.append(this.dku);
            }
            stringBuilder.append(",");
            stringBuilder.append(this.dli.toString());
            return stringBuilder.toString();
        }
    }

    public final void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                if (this.dlb.isEmpty()) {
                    synchronized (this) {
                        if (this.dkz) {
                            x.i("MicroMsg.HardCoderStatThread", "snapshotStatDeque size:" + this.dld.size());
                            if (this.thread != null) {
                                this.thread.interrupt();
                                this.thread = null;
                                this.dkz = false;
                            }
                        }
                        wait();
                    }
                } else {
                    com.tencent.mm.hardcoder.c.b bVar = (com.tencent.mm.hardcoder.c.b) this.dlb.poll();
                    if (bVar != null) {
                        b bVar2;
                        long j = bVar.time;
                        Map map = bVar.dkR;
                        Map map2 = bVar.dkS;
                        if (this.dlc == null) {
                            this.dlc = new b(j, map, map2);
                        } else {
                            bVar2 = this.dlc;
                            int[] k = b.k(map);
                            bVar2.dlj = j;
                            bVar2.dkt.k(((com.tencent.mm.hardcoder.c.a) map.get(Integer.valueOf(k[0]))).dkP, (long) ((com.tencent.mm.hardcoder.c.a) map.get(Integer.valueOf(k[0]))).dkQ);
                            if (bVar2.dku != null) {
                                bVar2.dku.k(((com.tencent.mm.hardcoder.c.a) map.get(Integer.valueOf(k[1]))).dkP, (long) ((com.tencent.mm.hardcoder.c.a) map.get(Integer.valueOf(k[1]))).dkQ);
                            }
                            bVar2.l(map2);
                        }
                        x.i("MicroMsg.HardCoderStatThread", this.dlc.toString());
                        bVar2 = new b(j, map, map2);
                        b bVar3 = (b) this.dld.peekFirst();
                        b bVar4 = (b) this.dld.peekLast();
                        if (bVar3 == null || bVar4 == null) {
                            this.dld.add(bVar2);
                        } else {
                            if (bVar4.startTime - bVar3.startTime >= 30000) {
                                this.dld.removeFirst();
                            }
                            this.dld.add(bVar2);
                        }
                    }
                }
            } catch (InterruptedException e) {
                x.e("MicroMsg.HardCoderStatThread", "Stat thread need to interrupt:" + e.getMessage());
                Thread.currentThread().interrupt();
                return;
            } catch (Exception e2) {
                x.e("MicroMsg.HardCoderStatThread", "exception:" + e2.getMessage());
            }
        }
    }

    protected final void finalize() {
        super.finalize();
        this.dlb = null;
        this.dlc = null;
        this.dld = null;
    }
}

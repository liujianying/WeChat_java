package com.tencent.mm.hardcoder;

import android.os.Process;
import android.os.SystemClock;
import com.tencent.mm.hardcoder.b.c;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import junit.framework.Assert;

public final class a {
    public static boolean djU = false;
    private static final int[] djV = new int[]{0, 1, 2, 3};
    private static final int[] djW = new int[]{0, 1, 2, 3};
    private static final Map<Integer, Integer> djX;
    private boolean bFi;
    b djY;
    LinkedBlockingQueue<Object> djZ;

    static class a {
        public int delay = 0;
        public int dkb = 0;
        public int dkc = 0;
        public int dkd = 0;
        public int dke = 0;
        public long dkf = 0;
        public long dkg = 0;
        public long dkh = 0;
        public int dki = 0;
        int dkj = 0;
        int dkk = 0;
        public int[] dkl = new int[a.djV.length];
        public int[] dkm = new int[a.djW.length];
        public int[] dkn = null;
        public long[] dko = null;
        public long[] dkp = null;
        public long dkq = 0;
        public int dkr = 0;
        public long dks = 0;
        public com.tencent.mm.hardcoder.f.a dkt = null;
        public com.tencent.mm.hardcoder.f.a dku = null;
        public long dkv = 0;
        public long dkw = 0;
        long lastUpdateTime = 0;
        public int scene = 0;
        public long startTime = 0;
        public String tag;

        a() {
        }

        public final String toString(long j) {
            return String.format("h:%x[%d,%d,%d][%d,%d][%d,%d,%d][%d,%d,%d][%s]", new Object[]{Integer.valueOf(hashCode()), Long.valueOf(this.dkg - j), Long.valueOf(this.startTime - j), Long.valueOf(this.dkh - j), Integer.valueOf(this.delay), Integer.valueOf(this.dkb), Integer.valueOf(this.scene), Long.valueOf(this.dkf), Integer.valueOf(this.dki), Integer.valueOf(this.dkc), Integer.valueOf(this.dkd), Integer.valueOf(this.dke), this.tag});
        }
    }

    static final class b {
        public int aeo = 0;
        public long dkw = 0;

        b() {
        }
    }

    static /* synthetic */ void a(a aVar) {
        x.i("MicroMsg.HardCoder.HCPerfManager", "HCPerfManager thread[%d] running", Long.valueOf(Thread.currentThread().getId()));
        HashSet hashSet = new HashSet();
        long j = 30000;
        ArrayList arrayList = new ArrayList();
        long[] myProcCpuTime = HardCoderJNI.getMyProcCpuTime();
        if (myProcCpuTime == null || myProcCpuTime.length < 2) {
            myProcCpuTime = new long[]{0, 0};
            x.i("MicroMsg.HardCoderReporter", "process jiffes info is invalid");
        }
        x.i("MicroMsg.HardCoderReporter", "process:[" + myProcCpuTime[0] + "," + myProcCpuTime[1] + "]");
        HashMap hashMap = new HashMap();
        HashSet hashSet2 = new HashSet();
        Collection collection = hashSet;
        a aVar2 = null;
        a aVar3 = null;
        while (aVar.bFi) {
            int i;
            a aVar4;
            int i2;
            long j2;
            int i3;
            int i4;
            long j3;
            int min;
            long currentTimeMillis = System.currentTimeMillis();
            int size = aVar.djZ.size();
            if (HardCoderJNI.hcDebug) {
                x.d("MicroMsg.HardCoder.HCPerfManager", "StartLoop queue:" + size + " startTask:" + arrayList.size() + " nextWakeInterval:" + j);
            }
            int i5 = 0;
            while (true) {
                if (i5 >= (size == 0 ? 1 : size)) {
                    break;
                }
                Object poll;
                try {
                    poll = aVar.djZ.poll(j, TimeUnit.MILLISECONDS);
                } catch (Exception e) {
                    x.e("MicroMsg.HardCoder.HCPerfManager", "queueTask poll: " + e.getMessage());
                    poll = null;
                }
                if (poll == null) {
                    break;
                }
                if (!(poll instanceof a)) {
                    if (!(poll instanceof b)) {
                        if (!HardCoderJNI.checkEnv) {
                            aVar.bFi = false;
                            break;
                        }
                        Assert.fail("queueTask poll invalid object");
                    } else {
                        i = ((b) poll).aeo;
                        if (hashSet2.contains(Integer.valueOf(i))) {
                            hashMap.put(Integer.valueOf(i), (b) poll);
                        }
                    }
                } else {
                    arrayList.add((a) poll);
                    hashSet2.add(Integer.valueOf(((a) poll).hashCode()));
                }
                i5++;
            }
            long j4 = 30000;
            a aVar5 = null;
            a aVar6 = null;
            HashSet hashSet3 = new HashSet();
            long currentTimeMillis2 = System.currentTimeMillis();
            if (HardCoderJNI.hcDebug) {
                x.d("MicroMsg.HardCoder.HCPerfManager", "InLoop startSize:" + arrayList.size());
            }
            i = 0;
            while (true) {
                int i6 = i;
                if (i6 >= arrayList.size()) {
                    break;
                }
                aVar4 = (a) arrayList.get(i6);
                if (aVar4 != null) {
                    if (hashMap.containsKey(Integer.valueOf(aVar4.hashCode()))) {
                        aVar4.dkh = currentTimeMillis2;
                        aVar4.dkw = ((b) hashMap.get(Integer.valueOf(aVar4.hashCode()))).dkw;
                        hashMap.remove(Integer.valueOf(aVar4.hashCode()));
                        aVar.a(currentTimeMillis2, arrayList, -2, -2, null);
                        if (HardCoderJNI.hcDebug) {
                            x.i("MicroMsg.HardCoder.HCPerfManager", "reportPerformanceTask:" + aVar4.hashCode());
                        }
                        aVar.djY.as(aVar4);
                    }
                    long j5 = aVar4.dkh - currentTimeMillis2;
                    if (j5 <= 0) {
                        if (HardCoderJNI.hcDebug) {
                            x.d("MicroMsg.HardCoder.HCPerfManager", "InLoop STOP:" + i6 + "/" + arrayList.size() + " task:" + aVar4.toString(currentTimeMillis2));
                        }
                        arrayList.remove(aVar4);
                        hashSet2.remove(Integer.valueOf(aVar4.hashCode()));
                        i6--;
                    } else {
                        j4 = Math.min(j4, j5);
                        j5 = aVar4.startTime - currentTimeMillis2;
                        if (j5 > 0) {
                            if (HardCoderJNI.hcDebug) {
                                x.d("MicroMsg.HardCoder.HCPerfManager", "InLoop WAIT:" + i6 + "/" + arrayList.size() + " task:" + aVar4.toString(currentTimeMillis2));
                            }
                            j4 = Math.min(j4, j5);
                        } else {
                            if (HardCoderJNI.hcDebug) {
                                x.d("MicroMsg.HardCoder.HCPerfManager", "InLoop  RUN:" + i6 + "/" + arrayList.size() + " task:" + aVar4.toString(currentTimeMillis2));
                            }
                            if (aVar4.dkc > 0 && (aVar5 == null || aVar5.dkc > aVar4.dkc || (aVar5.dkc == aVar4.dkc && aVar5.dkh < aVar4.dkh))) {
                                aVar5 = aVar4;
                            }
                            if (aVar4.dkd > 0 && (aVar6 == null || aVar6.dkd > aVar4.dkd || (aVar6.dkd == aVar4.dkd && aVar6.dkh < aVar4.dkh))) {
                                aVar6 = aVar4;
                            }
                            if (aVar4.dke > 0) {
                                hashSet3.add(aVar4);
                            }
                        }
                    }
                }
                i = i6 + 1;
            }
            long currentTimeMillis3 = System.currentTimeMillis();
            if (HardCoderJNI.hcDebug) {
                x.d("MicroMsg.HardCoder.HCPerfManager", String.format("EndLoop time:[%d,%d] list:%d stop:%d bindCore:%d -> %d", new Object[]{Long.valueOf(currentTimeMillis3 - currentTimeMillis2), Long.valueOf(currentTimeMillis3 - currentTimeMillis), Integer.valueOf(arrayList.size()), Integer.valueOf(hashMap.size()), Integer.valueOf(collection.size()), Integer.valueOf(hashSet3.size())}));
                x.d("MicroMsg.HardCoder.HCPerfManager", "EndLoop CurrCpu:" + (aVar3 == null ? "null" : aVar3.toString(currentTimeMillis2)) + " -> MaxCpu:" + (aVar5 == null ? "null" : aVar5.toString(currentTimeMillis2)));
                x.d("MicroMsg.HardCoder.HCPerfManager", "EndLoop CurrIO:" + (aVar2 == null ? "null" : aVar2.toString(currentTimeMillis2)) + " -> MaxIO:" + (aVar6 == null ? "null" : aVar6.toString(currentTimeMillis2)));
                x.d("MicroMsg.HardCoder.HCPerfManager", String.format("EndLoop BindCore.size cur: %d, need: %d", new Object[]{Integer.valueOf(collection.size()), Integer.valueOf(hashSet3.size())}));
            }
            if (aVar5 == aVar3 && aVar6 == aVar2 && collection.size() == hashSet3.size()) {
                HashSet hashSet4 = new HashSet();
                hashSet4.addAll(collection);
                hashSet4.removeAll(hashSet3);
                if (hashSet4.isEmpty()) {
                    if (HardCoderJNI.hcDebug) {
                        x.i("MicroMsg.HardCoder.HCPerfManager", "EndLoop Nothing Changed , Continue.");
                        j = j4;
                    } else {
                        j = j4;
                    }
                }
            }
            j = 0;
            int i7 = 0;
            int i8 = Integer.MAX_VALUE;
            HashSet hashSet5 = new HashSet();
            hashSet5.addAll(collection);
            hashSet5.removeAll(hashSet3);
            i = hashSet5.size();
            if (i > 0) {
                int[] iArr = new int[i];
                i = 0;
                Iterator it = hashSet5.iterator();
                while (true) {
                    i2 = i;
                    if (!it.hasNext()) {
                        break;
                    }
                    aVar4 = (a) it.next();
                    x.i("MicroMsg.HardCoder.HCPerfManager", "!cancelBindCore task:" + aVar4.toString(currentTimeMillis2));
                    if (aVar4.dkh > currentTimeMillis2) {
                        if (!HardCoderJNI.checkEnv) {
                            aVar.bFi = false;
                            break;
                        }
                        Assert.fail("stopTime:" + (aVar4.dkh - currentTimeMillis2));
                    }
                    if (aVar4.dke == 0) {
                        if (!HardCoderJNI.checkEnv) {
                            aVar.bFi = false;
                            break;
                        }
                        Assert.fail("bindTid:" + aVar4.dke);
                    }
                    iArr[i2] = aVar4.dke;
                    i = i2 + 1;
                }
                if (!djU && HardCoderJNI.checkEnv) {
                    HardCoderJNI.cancelCpuCoreForThread(iArr, Process.myTid(), SystemClock.elapsedRealtimeNanos());
                }
                aVar.a(currentTimeMillis2, arrayList, -2, -2, null);
            }
            int[] iArr2 = new int[hashSet3.size()];
            Iterator it2 = hashSet3.iterator();
            i2 = 0;
            int i9 = 0;
            while (it2.hasNext()) {
                aVar4 = (a) it2.next();
                x.i("MicroMsg.HardCoder.HCPerfManager", "requestBindCore task:" + aVar4.toString(currentTimeMillis2));
                if (aVar4.dkh <= currentTimeMillis2) {
                    if (!HardCoderJNI.checkEnv) {
                        aVar.bFi = false;
                        break;
                    }
                    Assert.fail("stopTime:" + (aVar4.dkh - currentTimeMillis2));
                }
                if (aVar4.dke == 0) {
                    if (!HardCoderJNI.checkEnv) {
                        aVar.bFi = false;
                        break;
                    }
                    Assert.fail("bindTid:" + aVar4.dke);
                }
                iArr2[i9] = aVar4.dke;
                i9++;
                i2 = aVar4.scene;
                j = aVar4.dkf;
                i5 = aVar4.dki;
                i8 = Math.min((int) (aVar4.dkh - currentTimeMillis2), i8);
                i7 = i5;
            }
            if (aVar6 == null) {
                if (aVar2 != null) {
                    x.i("MicroMsg.HardCoder.HCPerfManager", "!cancelHighIOFreq task:" + aVar2.toString(currentTimeMillis2));
                    if (!djU && HardCoderJNI.checkEnv) {
                        HardCoderJNI.cancelHighIOFreq(aVar2.dki, SystemClock.elapsedRealtimeNanos());
                    }
                    aVar.a(currentTimeMillis2, arrayList, -2, -1, null);
                }
            } else if (aVar2 != aVar6 && HardCoderJNI.hcDebug) {
                x.d("MicroMsg.HardCoder.HCPerfManager", "IOReq:" + (aVar2 == null ? "null" : aVar2.toString(currentTimeMillis2)) + " -> " + aVar6.toString(currentTimeMillis2) + " delay:" + (currentTimeMillis3 - aVar6.startTime));
            }
            if (aVar6 != null) {
                i9 = aVar6.dkd;
                i2 = aVar6.scene;
                j = aVar6.dkf;
                i7 = aVar6.dki;
                i8 = Math.min((int) (aVar6.dkh - currentTimeMillis2), i8);
                j2 = j;
                i3 = i2;
            } else {
                j2 = j;
                i3 = i2;
                i9 = 0;
            }
            if (aVar5 == null) {
                if (aVar3 != null) {
                    x.i("MicroMsg.HardCoder.HCPerfManager", "!cancelCpuHighFreq task:" + aVar3.toString(currentTimeMillis2));
                    if (!djU && HardCoderJNI.checkEnv) {
                        HardCoderJNI.cancelCpuHighFreq(aVar3.dki, SystemClock.elapsedRealtimeNanos());
                    }
                    aVar.a(currentTimeMillis2, arrayList, -1, -2, null);
                }
            } else if (aVar3 != aVar5 && HardCoderJNI.hcDebug) {
                x.d("MicroMsg.HardCoder.HCPerfManager", "CPUReq:" + (aVar3 == null ? "null" : aVar3.toString(currentTimeMillis2)) + " -> " + aVar5.toString(currentTimeMillis2) + " delay:" + (currentTimeMillis3 - aVar5.startTime));
            }
            if (aVar5 != null) {
                i4 = aVar5.dkc;
                i = aVar5.scene;
                j3 = aVar5.dkf;
                i5 = aVar5.dki;
                min = Math.min((int) (aVar5.dkh - currentTimeMillis2), i8);
            } else {
                j3 = j2;
                i = i3;
                i4 = 0;
                min = i8;
                i5 = i7;
            }
            if (min < Integer.MAX_VALUE) {
                String str = "MicroMsg.HardCoder.HCPerfManager";
                String str2 = "!UnifyRequest [%d,%d,%d] [%d,%d,%d] TO:%d max CPU:%s IO:%s cur CPU:%s IO:%s";
                Object[] objArr = new Object[11];
                objArr[0] = Integer.valueOf(i);
                objArr[1] = Long.valueOf(j3);
                objArr[2] = Integer.valueOf(i5);
                objArr[3] = Integer.valueOf(i4);
                objArr[4] = Integer.valueOf(i9);
                objArr[5] = Integer.valueOf(iArr2.length);
                objArr[6] = Integer.valueOf(min);
                objArr[7] = aVar5 == null ? "null" : aVar5.toString(currentTimeMillis2);
                objArr[8] = aVar6 == null ? "null" : aVar6.toString(currentTimeMillis2);
                objArr[9] = aVar5 == null ? "null" : aVar5.toString(currentTimeMillis2);
                objArr[10] = aVar6 == null ? "null" : aVar6.toString(currentTimeMillis2);
                x.i(str, String.format(str2, objArr));
                Assert.assertTrue(min > 0);
                boolean z = i > 0 || j3 > 0;
                Assert.assertTrue(z);
                Assert.assertTrue(i5 > 0);
                z = i4 > 0 || i9 > 0 || iArr2.length > 0;
                Assert.assertTrue(z);
                if (!djU && HardCoderJNI.checkEnv) {
                    HardCoderJNI.requestUnifyCpuIOThreadCore(i, j3, i4, i9, iArr2, min, i5, SystemClock.elapsedRealtimeNanos());
                    i5 = ((Integer) djX.get(Integer.valueOf(i))).intValue();
                    String str3 = "MicroMsg.HardCoder.HCPerfManager";
                    str = "hardcoder requestUnifyCpuIOThreadCore reqScene[%d, %d, %d] running[j %b, c %b]";
                    Object[] objArr2 = new Object[5];
                    objArr2[0] = Integer.valueOf(i);
                    objArr2[1] = Long.valueOf(j3);
                    objArr2[2] = Integer.valueOf(i5);
                    objArr2[3] = Boolean.valueOf(HardCoderJNI.isHCEnable());
                    boolean z2 = HardCoderJNI.checkEnv && HardCoderJNI.isRunning() > 0;
                    objArr2[4] = Boolean.valueOf(z2);
                    x.i(str3, str, objArr2);
                    HardCoderJNI.reportIDKey(false, i5, 1, false);
                }
                aVar.a(currentTimeMillis2, arrayList, i4, i9, iArr2);
            }
            if (djU) {
                Assert.assertTrue(aVar5 == aVar5);
                Assert.assertTrue(aVar6 == aVar6);
                if (arrayList.isEmpty()) {
                    Assert.assertTrue(j4 == 30000);
                    Assert.assertTrue(min == Integer.MAX_VALUE);
                    Assert.assertTrue(hashSet3.isEmpty());
                    Assert.assertTrue(aVar5 == null);
                    Assert.assertTrue(aVar6 == null);
                }
                i = 0;
                while (true) {
                    i2 = i;
                    if (i2 >= arrayList.size()) {
                        break;
                    }
                    aVar4 = (a) arrayList.get(i2);
                    if (HardCoderJNI.hcDebug) {
                        x.d("MicroMsg.HardCoder.HCPerfManager", "CheckTask:" + i2 + "/" + arrayList.size() + " task:" + aVar4.toString(currentTimeMillis2));
                    }
                    boolean z3 = aVar4.dkc > 0 || aVar4.dkd > 0 || aVar4.dke > 0;
                    Assert.assertTrue(z3);
                    z3 = aVar4.dkf > 0 || aVar4.scene > 0;
                    Assert.assertTrue(z3);
                    Assert.assertTrue("taskInintTime:" + (aVar4.dkg - currentTimeMillis2), aVar4.dkg <= currentTimeMillis2);
                    Assert.assertTrue("taskStopTime:" + (aVar4.dkh - currentTimeMillis2), aVar4.dkh >= currentTimeMillis2);
                    Assert.assertTrue("taskHash:" + aVar4.hashCode(), !hashMap.containsKey(Integer.valueOf(aVar4.hashCode())));
                    if (aVar4.startTime > currentTimeMillis2) {
                        Assert.assertTrue(aVar4 != aVar5);
                        Assert.assertTrue(aVar4 != aVar6);
                        Assert.assertTrue(!hashSet3.contains(aVar4));
                        Assert.assertTrue("next:" + j4 + " start:" + (aVar4.startTime - currentTimeMillis2), j4 <= aVar4.startTime - currentTimeMillis2);
                    } else {
                        Assert.assertTrue("nextWake:" + j4 + " stop:" + (aVar4.dkh - currentTimeMillis2), j4 <= aVar4.dkh - currentTimeMillis2);
                        String str4 = "reqTimeStamp:" + min;
                        z3 = min > 0 && ((long) min) < Long.MAX_VALUE;
                        Assert.assertTrue(str4, z3);
                        Assert.assertTrue("reqTimeStamp:" + min + " stop:" + (aVar4.dkh - currentTimeMillis2), ((long) min) <= aVar4.dkh - currentTimeMillis2);
                        Assert.assertTrue("reqCpu:" + i4 + " task:" + aVar4.dkc, i4 <= aVar4.dkc);
                        Assert.assertTrue("reqIO:" + i9 + " task:" + aVar4.dkd, i9 <= aVar4.dkd);
                        if (aVar4.dke > 0) {
                            Assert.assertTrue(hashSet3.contains(aVar4));
                            Assert.assertTrue(!hashSet5.contains(aVar4));
                        }
                    }
                    i = i2 + 1;
                }
                j = j4;
                collection = hashSet3;
                aVar2 = aVar6;
                aVar3 = aVar5;
            } else {
                j = j4;
                collection = hashSet3;
                aVar2 = aVar6;
                aVar3 = aVar5;
            }
        }
    }

    static {
        Map hashMap = new HashMap();
        djX = hashMap;
        hashMap.clear();
        djX.put(Integer.valueOf(101), Integer.valueOf(1));
        djX.put(Integer.valueOf(HardCoderJNI.SCENE_RECEIVE_MSG), Integer.valueOf(2));
        djX.put(Integer.valueOf(HardCoderJNI.SCENE_SEND_MSG), Integer.valueOf(3));
        djX.put(Integer.valueOf(HardCoderJNI.SCENE_SEND_PIC_MSG), Integer.valueOf(4));
        djX.put(Integer.valueOf(HardCoderJNI.SCENE_ENTER_CHATTING), Integer.valueOf(5));
        djX.put(Integer.valueOf(HardCoderJNI.SCENE_QUIT_CHATTING), Integer.valueOf(6));
        djX.put(Integer.valueOf(HardCoderJNI.SCENE_UPDATE_CHATROOM), Integer.valueOf(7));
        djX.put(Integer.valueOf(HardCoderJNI.SCENE_DB), Integer.valueOf(8));
        djX.put(Integer.valueOf(HardCoderJNI.SCENE_DECODE_PIC), Integer.valueOf(9));
        djX.put(Integer.valueOf(HardCoderJNI.SCENE_GIF), Integer.valueOf(10));
        djX.put(Integer.valueOf(HardCoderJNI.SCENE_ENCODE_VIDEO), Integer.valueOf(11));
        djX.put(Integer.valueOf(HardCoderJNI.SCENE_SNS_SCROLL), Integer.valueOf(12));
        djX.put(Integer.valueOf(HardCoderJNI.SCENE_ALBUM_SCROLL), Integer.valueOf(13));
        djX.put(Integer.valueOf(HardCoderJNI.SCENE_MEDIA_GALLERY_SCROLL), Integer.valueOf(14));
        djX.put(Integer.valueOf(HardCoderJNI.SCENE_SNS_USER_SCROLL), Integer.valueOf(15));
        djX.put(Integer.valueOf(HardCoderJNI.SCENE_SNS_MSG_SCROLL), Integer.valueOf(16));
    }

    public a() {
        this.djY = new b();
        this.djZ = new LinkedBlockingQueue();
        this.bFi = false;
        this.bFi = true;
        e.d(new Runnable() {
            public final void run() {
                x.i("MicroMsg.HardCoder.HCPerfManager", "HCPerfManager thread run start[%d, %s]", Long.valueOf(Thread.currentThread().getId()), Thread.currentThread().getName());
                a.a(a.this);
                x.i("MicroMsg.HardCoder.HCPerfManager", "HCPerfManager thread run end");
            }
        }, "HCPerfManager", 10).start();
        x.i("MicroMsg.HardCoder.HCPerfManager", "hardcoder HCPerfManager new thread[%s]", r0);
        this.djY.start();
    }

    private void a(long j, List<a> list, int i, int i2, int[] iArr) {
        this.djY.as(new c(j, new ArrayList(list), i, i2, iArr));
    }

    final void reportIDKey(boolean z, int i, int i2, boolean z2) {
        this.djY.as(new com.tencent.mm.hardcoder.b.b(z, i, i2, z2));
    }
}

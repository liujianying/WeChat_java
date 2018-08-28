package com.tencent.mm.plugin.exdevice.service;

import android.os.Build.VERSION;
import android.os.Looper;
import com.tencent.mm.plugin.exdevice.jni.Java2CExDevice;
import com.tencent.mm.plugin.h.a.d.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;
import junit.framework.Assert;

public final class b implements c {
    private static b iyt = null;
    private com.tencent.mm.plugin.h.a.d.b iyp = null;
    private final Vector<r> iyq = new Vector();
    private final HashMap<Long, Integer> iyr = new HashMap();
    private final HashMap<Long, Integer> iys = new HashMap();
    private CountDownLatch iyu;
    private ag mHandler = new ag(v.aHH().egm.lnJ.getLooper());

    static /* synthetic */ boolean a(b bVar, int i, r rVar, int[] iArr) {
        if (rVar == null) {
            x.e("MicroMsg.exdevice.BluetoothSDKAdapter", "Error parameter: null == aCallback");
            throw new IllegalArgumentException("scanImp: null == aCallback");
        }
        if (iArr == null ? bVar.iyp.a(i, new int[0]) : bVar.iyp.a(i, iArr)) {
            bVar.iyq.add(rVar);
            return true;
        }
        x.e("MicroMsg.exdevice.BluetoothSDKAdapter", "mBTSDKMrg.scan failed!!!");
        if (rVar == null) {
            return false;
        }
        rVar.wT("scanImp: mBTSDKMrg.scan failed!!!");
        return false;
    }

    public b() {
        x.i("MicroMsg.exdevice.BluetoothSDKAdapter", "now thread id : %d, main thread is : %d", new Object[]{Long.valueOf(Thread.currentThread().getId()), Long.valueOf(Looper.getMainLooper().getThread().getId())});
        if (VERSION.SDK_INT != 14 && VERSION.SDK_INT != 15) {
            this.iyp = new com.tencent.mm.plugin.h.a.d.b(ad.getContext(), this, v.aHH().egm);
        } else if (r0 == r2) {
            x.i("MicroMsg.exdevice.BluetoothSDKAdapter", "it is main thread now, init the bluetoothadapter directly");
            this.iyp = new com.tencent.mm.plugin.h.a.d.b(ad.getContext(), this, v.aHH().egm);
        } else {
            new ag(Looper.getMainLooper()).postAtFrontOfQueueV2(new 1(this));
            this.iyu = new CountDownLatch(1);
            try {
                this.iyu.await();
            } catch (InterruptedException e) {
            }
            x.i("MicroMsg.exdevice.BluetoothSDKAdapter", "now has init the sdk adapter");
        }
    }

    private static b aHu() {
        if (iyt != null) {
            return iyt;
        }
        b bVar = new b();
        iyt = bVar;
        return bVar;
    }

    public static boolean a(int i, r rVar, int... iArr) {
        if (rVar == null) {
            x.e("MicroMsg.exdevice.BluetoothSDKAdapter", "Error parameter: null == aCallback");
            return false;
        }
        b aHu = aHu();
        boolean post = aHu.mHandler.post(new 2(aHu, i, rVar, iArr));
        if (post) {
            return post;
        }
        x.e("MicroMsg.exdevice.BluetoothSDKAdapter", "scan: instance.mHandler.post failed!!!");
        return post;
    }

    public static boolean pb(int i) {
        x.i("MicroMsg.exdevice.BluetoothSDKAdapter", "---stopScan--- aBluetoothVersion = %d", new Object[]{Integer.valueOf(i)});
        b aHu = aHu();
        boolean post = aHu.mHandler.post(new 3(aHu, i));
        if (!post) {
            x.e("MicroMsg.exdevice.BluetoothSDKAdapter", "stopScan: instance.mHandler.post failed!!!");
        }
        return post;
    }

    public static void createSession(long j, long j2) {
        x.i("MicroMsg.exdevice.BluetoothSDKAdapter", "---createSession--- aDeviceId = %d, aChannelId = %d", new Object[]{Long.valueOf(j), Long.valueOf(j2)});
        b aHu = aHu();
        if (!aHu.mHandler.post(new 4(aHu, j, j2))) {
            x.e("MicroMsg.exdevice.BluetoothSDKAdapter", "createSession: instance.mHandler.post failed!!!");
        }
    }

    public static boolean sendData(long j, byte[] bArr) {
        int i = 0;
        String str = "MicroMsg.exdevice.BluetoothSDKAdapter";
        String str2 = "----sendData---- aSessionId = %d, datalength = %d";
        Object[] objArr = new Object[2];
        objArr[0] = Long.valueOf(j);
        if (bArr != null) {
            i = bArr.length;
        }
        objArr[1] = Integer.valueOf(i);
        x.i(str, str2, objArr);
        Assert.assertNotNull(bArr);
        b aHu = aHu();
        boolean post = aHu.mHandler.post(new 5(aHu, j, bArr));
        if (!post) {
            x.e("MicroMsg.exdevice.BluetoothSDKAdapter", "sendData: instance.mHandler.post failed!!!");
        }
        return post;
    }

    public static boolean connect(long j) {
        x.i("MicroMsg.exdevice.BluetoothSDKAdapter", "---connect--- aSessionId = %d", new Object[]{Long.valueOf(j)});
        b aHu = aHu();
        boolean post = aHu.mHandler.post(new 6(aHu, j));
        if (!post) {
            x.e("MicroMsg.exdevice.BluetoothSDKAdapter", "connect: instance.mHandler.post failed!!!");
        }
        return post;
    }

    public static void destroySession(long j) {
        x.i("MicroMsg.exdevice.BluetoothSDKAdapter", "---destroySession--- aSessionId = %d", new Object[]{Long.valueOf(j)});
        b aHu = aHu();
        if (!aHu.mHandler.post(new 7(aHu, j))) {
            x.e("MicroMsg.exdevice.BluetoothSDKAdapter", "destroySession: instance.mHandler.post failed!!!");
        }
    }

    public final void b(long j, long j2, long j3) {
        x.i("MicroMsg.exdevice.BluetoothSDKAdapter", "---onSessionCreate--- aSessionId = " + j + " aDeviceID = " + j2);
        Assert.assertTrue(this.iyr.containsKey(Long.valueOf(j2)));
        if (!this.iys.containsKey(Long.valueOf(j))) {
            this.iys.put(Long.valueOf(j), this.iyr.get(Long.valueOf(j2)));
        }
        Java2CExDevice.onBluetoothSessionCreated(j2, j3, j);
    }

    public final void na(int i) {
        x.i("MicroMsg.exdevice.BluetoothSDKAdapter", "---onScanFinished--- aBluetoothVersion =%d", new Object[]{Integer.valueOf(i)});
        if (this.iyq.isEmpty()) {
            x.w("MicroMsg.exdevice.BluetoothSDKAdapter", "mScanCallbackList is empty");
            return;
        }
        Iterator it = this.iyq.iterator();
        while (it.hasNext()) {
            r rVar = (r) it.next();
            if (rVar != null) {
                rVar.na(i);
            }
        }
        this.iyq.clear();
    }

    public final void a(String str, String str2, int i, int i2, byte[] bArr) {
        String str3 = "MicroMsg.exdevice.BluetoothSDKAdapter";
        String str4 = "---onScanFound--- deviceMac = %s, deviceName = %s, BTversion = %d, rssi = %d, advertisment length = %d";
        Object[] objArr = new Object[5];
        objArr[0] = str;
        objArr[1] = str2;
        objArr[2] = Integer.valueOf(i);
        objArr[3] = Integer.valueOf(i2);
        objArr[4] = Integer.valueOf(bArr == null ? -1 : bArr.length);
        x.d(str3, str4, objArr);
        if (this.iyq.isEmpty()) {
            x.w("MicroMsg.exdevice.BluetoothSDKAdapter", "mScanCallbackList is empty");
            return;
        }
        Iterator it = this.iyq.iterator();
        while (it.hasNext()) {
            ((r) it.next()).a(str, str2, i, i2, bArr);
        }
    }

    public final void i(long j, boolean z) {
        x.i("MicroMsg.exdevice.BluetoothSDKAdapter", "---onConnected--- sessionId = " + j + "Connected = " + z);
        if (z) {
            Java2CExDevice.onBluetoothConnected(j);
        } else {
            Java2CExDevice.onBluetoothDisconnected(j);
        }
    }

    public final void b(long j, byte[] bArr) {
        x.i("MicroMsg.exdevice.BluetoothSDKAdapter", "---onRecv--- sessionId = " + j);
        Java2CExDevice.onBluetoothRecvData(j, bArr);
    }

    public final void j(long j, boolean z) {
        x.i("MicroMsg.exdevice.BluetoothSDKAdapter", "---onSend--- sessionId = " + j + "success = " + z);
        if (z) {
            Java2CExDevice.onBluetoothSendDataCompleted(j);
        } else {
            Java2CExDevice.onBluetoothError(j, 0);
        }
    }

    public final void bY(long j) {
        Java2CExDevice.onBluetoothError(j, 0);
    }
}

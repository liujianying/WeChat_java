package com.tencent.mm.plugin.exdevice.service;

import com.tencent.mm.plugin.exdevice.jni.Java2CExDevice;
import com.tencent.mm.plugin.exdevice.jni.Java2CExDevice.AccessoryCmd;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map.Entry;
import junit.framework.Assert;

public final class a implements r {
    private static a iyg = null;
    private Object dMd = new Object();
    private final HashMap<Long, Long> iyh = new HashMap();
    private g iyi = null;
    ag mHandler = new a(this, v.aHH().egm.lnJ.getLooper());

    static /* synthetic */ void cK(long j) {
        x.i("MicroMsg.exdevice.BTDeviceManager", "stopTaskImp taskId = %d", Long.valueOf(j));
        Java2CExDevice.stopTask(j);
    }

    public a(g gVar) {
        this.iyi = gVar;
        iyg = this;
    }

    public static boolean pb(int i) {
        x.i("MicroMsg.exdevice.BTDeviceManager", "------stopScan------");
        if (b.pb(i)) {
            return true;
        }
        x.e("MicroMsg.exdevice.BTDeviceManager", "BluetoothSDKAdapter.stopScan Failed!!!");
        return false;
    }

    public static long[] aHt() {
        return com.tencent.mm.plugin.exdevice.h.a.Aj("conneted_device");
    }

    private boolean cI(long j) {
        x.i("MicroMsg.exdevice.BTDeviceManager", "stopChannelImp deviceId = " + j);
        x.i("MicroMsg.exdevice.BTDeviceManager", "remove the device from connected devices : [%d]", Long.valueOf(j));
        if (!com.tencent.mm.plugin.exdevice.h.a.B("conneted_device", j)) {
            x.e("MicroMsg.exdevice.BTDeviceManager", "removeFromSharedPreferences failed!!!");
        }
        if (this.iyh.containsKey(Long.valueOf(j))) {
            Java2CExDevice.stopChannelService(((Long) this.iyh.get(Long.valueOf(j))).longValue());
            Java2CExDevice.destroyChannel(((Long) this.iyh.get(Long.valueOf(j))).longValue());
            return true;
        }
        x.e("MicroMsg.exdevice.BTDeviceManager", "Cannot find deviceId in the map");
        return false;
    }

    private int a(long j, p pVar) {
        x.i("MicroMsg.exdevice.BTDeviceManager", "startTaskImp, taskId = %d", Long.valueOf(j));
        Assert.assertNotNull(pVar);
        try {
            long aHx = pVar.aHC().aHx();
            if (!com.tencent.mm.plugin.exdevice.h.a.z("conneted_device", aHx)) {
                x.w("MicroMsg.exdevice.BTDeviceManager", "Cannot startTask because this channel is close aready!!!");
                e eVar = new e();
                eVar.iyn = j;
                eVar.isA = -1;
                eVar.isM = -1;
                eVar.fGO = "Channel is close aready!!!";
                Assert.assertTrue(iyg.mHandler.sendMessage(iyg.mHandler.obtainMessage(3, 0, 0, eVar)));
                return -1;
            } else if (this.iyh.containsKey(Long.valueOf(aHx))) {
                AccessoryCmd accessoryCmd = new AccessoryCmd();
                accessoryCmd.channelID = ((Long) this.iyh.get(Long.valueOf(aHx))).longValue();
                try {
                    accessoryCmd.reqCmdID = pVar.aHC().aHz();
                    accessoryCmd.respCmdID = pVar.aHC().aHA();
                    try {
                        if (Java2CExDevice.startTask(j, (short) pVar.aHC().aHB(), accessoryCmd, pVar.aHC().aHy()) != 0) {
                            x.e("MicroMsg.exdevice.BTDeviceManager", "Java2CExDevice.startTask Failed!!!");
                            return -1;
                        }
                        x.i("MicroMsg.exdevice.BTDeviceManager", "------let task go------ taskId = %d, deviceId = %d, channelId = %d, seq = %d, reqCmdId = %d, respCmdId = %d", Long.valueOf(j), Long.valueOf(aHx), Long.valueOf(accessoryCmd.channelID), Integer.valueOf(pVar.aHC().aHB()), Integer.valueOf(accessoryCmd.reqCmdID), Integer.valueOf(accessoryCmd.respCmdID));
                        return 0;
                    } catch (Throwable e) {
                        x.e("MicroMsg.exdevice.BTDeviceManager", "Remote getDataOut failed!!! %s", e.getMessage());
                        x.printErrStackTrace("MicroMsg.exdevice.BTDeviceManager", e, "", new Object[0]);
                        this.iyi.c(j, -1, -1, "Remote getDataOut failed!!!!!!");
                        return -1;
                    }
                } catch (Throwable e2) {
                    x.e("MicroMsg.exdevice.BTDeviceManager", "Remote getResquestCmdId or getResponseCmdId failed!!! %s", e2.getMessage());
                    x.printErrStackTrace("MicroMsg.exdevice.BTDeviceManager", e2, "", new Object[0]);
                    this.iyi.c(j, -1, -1, "Remote getResquestCmdId or getResponseCmdId failed!!!");
                    return -1;
                }
            } else {
                x.e("MicroMsg.exdevice.BTDeviceManager", "Cannot find Channel by DeviceId(%s) in mMapDeviceChannelId", Long.valueOf(aHx));
                this.iyi.c(j, -1, -1, "Cannot find Channel by DeviceId!!!");
                return -1;
            }
        } catch (Throwable e22) {
            x.e("MicroMsg.exdevice.BTDeviceManager", "Remote getDeviceId failed!!! %s", e22.getMessage());
            x.printErrStackTrace("MicroMsg.exdevice.BTDeviceManager", e22, "", new Object[0]);
            this.iyi.c(j, -1, -1, "Remote getDeviceId failed!!!");
            return -1;
        }
    }

    public static void c(long j, int i, int i2, String str) {
        Assert.assertNotNull(iyg);
        x.i("MicroMsg.exdevice.BTDeviceManager", "onTaskEnd taskId = " + j + " errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        e eVar = new e();
        eVar.iyn = j;
        eVar.isA = i2;
        eVar.isM = i;
        eVar.fGO = str;
        Assert.assertTrue(iyg.mHandler.sendMessage(iyg.mHandler.obtainMessage(3, 0, 0, eVar)));
    }

    public static void b(long j, int i, int i2, int i3) {
        Assert.assertNotNull(iyg);
        x.i("MicroMsg.exdevice.BTDeviceManager", "onStateChange channelId = " + j + " oldState = " + i + " newState = " + i2 + " errCode = " + i3);
        long cJ = iyg.cJ(j);
        if (-1 == cJ) {
            x.e("MicroMsg.exdevice.BTDeviceManager", "Cannot find deviceId by channelId");
            return;
        }
        d dVar = new d((byte) 0);
        dVar.hjj = cJ;
        dVar.isA = i3;
        dVar.iym = i2;
        dVar.iyl = i;
        Assert.assertTrue(iyg.mHandler.sendMessage(iyg.mHandler.obtainMessage(4, 0, 0, dVar)));
    }

    private long cJ(long j) {
        if (this.iyh.containsValue(Long.valueOf(j))) {
            for (Entry entry : this.iyh.entrySet()) {
                if (j == ((Long) entry.getValue()).longValue()) {
                    return ((Long) entry.getKey()).longValue();
                }
            }
            Assert.assertTrue(false);
            return -1;
        }
        x.e("MicroMsg.exdevice.BTDeviceManager", "Cannot find DeviceId by channelId");
        return -1;
    }

    public static void onDeviceRequest(long j, short s, short s2, byte[] bArr, int i) {
        String str = "MicroMsg.exdevice.BTDeviceManager";
        String str2 = "onDeviceRequest channelId = %d, seq = %d, cmdId =%d, datain len = %d, errCode = %d";
        Object[] objArr = new Object[5];
        objArr[0] = Long.valueOf(j);
        objArr[1] = Short.valueOf(s);
        objArr[2] = Short.valueOf(s2);
        objArr[3] = Integer.valueOf(bArr == null ? -1 : bArr.length);
        objArr[4] = Integer.valueOf(i);
        x.i(str, str2, objArr);
        Assert.assertNotNull(iyg);
        x.i("MicroMsg.exdevice.BTDeviceManager", "onDeviceRequest channelId = " + j + " seq = " + s + "cmdId = " + s2 + "errCode = " + i);
        long cJ = iyg.cJ(j);
        if (-1 == cJ) {
            x.e("MicroMsg.exdevice.BTDeviceManager", "Cannot find deviceId by channelId");
            return;
        }
        b bVar = new b((byte) 0);
        bVar.hjj = cJ;
        bVar.isB = bArr;
        bVar.iyk = s2;
        bVar.isH = s;
        Assert.assertTrue(iyg.mHandler.sendMessage(iyg.mHandler.obtainMessage(5, i, 0, bVar)));
    }

    public final void na(int i) {
        x.i("MicroMsg.exdevice.BTDeviceManager", "******onScanFinished******aBluetoothVersion = " + i);
        Assert.assertTrue(this.mHandler.sendMessage(this.mHandler.obtainMessage(2, 0, 0, null)));
    }

    public final void a(String str, String str2, int i, int i2, byte[] bArr) {
        String str3 = "MicroMsg.exdevice.BTDeviceManager";
        String str4 = "------onScanFound------ aBluetoothVersion = %d, device mac = %s, device name = %s, rssi = %d, advertisment length = %d";
        Object[] objArr = new Object[5];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = str;
        objArr[2] = str2;
        objArr[3] = Integer.valueOf(i2);
        objArr[4] = Integer.valueOf(bArr == null ? -1 : bArr.length);
        x.d(str3, str4, objArr);
        Assert.assertTrue(this.mHandler.sendMessage(this.mHandler.obtainMessage(1, 0, 0, new c(str, str2, i2, bArr))));
    }

    public final void wT(String str) {
        x.i("MicroMsg.exdevice.BTDeviceManager", "------onScanError------ error code = %d, error msg = %s", Integer.valueOf(-1), Integer.valueOf(-1));
        if (!this.mHandler.post(new 1(this))) {
            x.e("MicroMsg.exdevice.BTDeviceManager", "onScanError: mHandler.post failed!!!");
        }
    }
}

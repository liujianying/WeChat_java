package com.tencent.mm.plugin.exdevice.model;

import android.os.Looper;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.exdevice.h.a;
import com.tencent.mm.plugin.exdevice.j.b;
import com.tencent.mm.plugin.exdevice.service.c;
import com.tencent.mm.plugin.exdevice.service.f$a;
import com.tencent.mm.plugin.exdevice.service.j;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.plugin.exdevice.service.w;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;

public final class d {
    private static int iti = 0;
    public c itd;
    private w ite;
    HashMap<Long, al> itf;
    HashMap<Long, al> itg;
    HashMap<Long, Integer> ith;
    j itj;
    private Object itk;

    public d() {
        this.itj = null;
        this.itk = new Object();
        u.aHG().isZ = new 1(this);
        if (this.ite == null) {
            this.ite = new 10(this);
        }
        this.itf = new HashMap();
        this.itg = new HashMap();
        this.ith = new HashMap();
    }

    public static int aGM() {
        return iti;
    }

    public final synchronized void oZ(int i) {
        x.i("MicroMsg.exdevice.ExdeviceConnectManager", "setConnectMode, mode = %d", new Object[]{Integer.valueOf(i)});
        iti = i;
    }

    public final synchronized void a(Long l, int i) {
        this.ith.put(l, Integer.valueOf(i));
    }

    public final void a(String str, long j, int i) {
        a(str, j, i, false);
    }

    public final void a(String str, long j, int i, boolean z) {
        a.B("shut_down_device", j);
        if (this.itd == null) {
            x.i("MicroMsg.exdevice.ExdeviceConnectManager", "Bind exdeviceService");
            this.itd = new c();
            this.itd.iyE = new 6(this, i, str, j, z);
            this.itd.dd(ad.getContext());
        } else if (this.itd == null || this.itd.iyF) {
            b(str, j, i, z);
        } else {
            x.i("MicroMsg.exdevice.ExdeviceConnectManager", "ExdeviceService setConnected");
            this.itd.iyE = new 7(this, i, str, j, z);
            this.itd.dd(ad.getContext());
        }
    }

    public final void b(String str, long j, int i, boolean z) {
        boolean b;
        x.i("MicroMsg.exdevice.ExdeviceConnectManager", "doConnect");
        if (z) {
            b = b(str, j, i);
        } else if (au.DF().Lg() != 4) {
            x.i("MicroMsg.exdevice.ExdeviceConnectManager", "now network is not avaiable, notify directly");
            b = false;
        } else {
            if (this.itf.containsKey(Long.valueOf(j))) {
                x.i("MicroMsg.exdevice.ExdeviceConnectManager", "now the device is connecting, reset timer : brand name = %s, deviceid = %d, bluetooth version = %d", new Object[]{str, Long.valueOf(j), Integer.valueOf(i)});
                al alVar = (al) this.itf.get(Long.valueOf(j));
                alVar.SO();
                alVar.J(30000, 30000);
            } else {
                x.i("MicroMsg.exdevice.ExdeviceConnectManager", "the device is not connecting, brand name = %s, deviceid = %d, bluetooth version = %d", new Object[]{str, Long.valueOf(j), Integer.valueOf(i)});
                al alVar2 = new al(Looper.getMainLooper(), new 9(this, j, str, i), false);
                alVar2.J(30000, 30000);
                this.itf.put(Long.valueOf(j), alVar2);
            }
            if (u.aHG().isY == null) {
                x.w("MicroMsg.exdevice.ExdeviceConnectManager", "MMExDeviceCore.getTaskQueue().getDispatcher() == null, Just leave, brand name is %s, device id is %d, bluetooth version is %d", new Object[]{str, Long.valueOf(j), Integer.valueOf(i)});
                b = false;
            } else {
                f$a cN = u.aHF().cN(j);
                if (cN == null) {
                    x.w("MicroMsg.exdevice.ExdeviceConnectManager", "Device unbond: %s", new Object[]{Long.valueOf(j)});
                    b = false;
                } else {
                    x.i("MicroMsg.exdevice.ExdeviceConnectManager", "onStateChange, connectState = %d ", new Object[]{Integer.valueOf(cN.bLv)});
                    if (!(cN.bLv == 2 || cN.bLv == 1)) {
                        u.aHG().isY.a(j, i, this.ite);
                    }
                    b = true;
                }
            }
        }
        x.i("MicroMsg.exdevice.ExdeviceConnectManager", "startChannel Ret = %s", new Object[]{Boolean.valueOf(b)});
    }

    public static void cB(long j) {
        if (u.aHG().isY != null) {
            boolean cT = u.aHG().isY.cT(j);
            x.i("MicroMsg.exdevice.ExdeviceConnectManager", "now stop the devide channel : %d, result : %b", new Object[]{Long.valueOf(j), Boolean.valueOf(cT)});
        }
    }

    public final void aGN() {
        if (this.itd != null && this.itd.iyF) {
            try {
                ad.getContext().unbindService(this.itd);
            } catch (Exception e) {
            }
        }
    }

    private synchronized boolean b(String str, long j, int i) {
        boolean z;
        int Lg = au.DF().Lg();
        if (Lg != 4 && Lg != 6) {
            x.e("MicroMsg.exdevice.ExdeviceConnectManager", "now network is not avaiable, notify directly");
            z = false;
        } else if (this.itg.containsKey(Long.valueOf(j))) {
            x.i("MicroMsg.exdevice.ExdeviceConnectManager", "now the device is syncing data : %s, %d, Just leave!!!", new Object[]{str, Long.valueOf(j)});
            z = false;
        } else {
            al alVar = new al(Looper.getMainLooper(), new 8(this, j, str, i), false);
            long aIs = b.aIs();
            x.i("MicroMsg.exdevice.ExdeviceConnectManager", "now sync time out is : %d", new Object[]{Long.valueOf(aIs)});
            alVar.J(aIs, aIs);
            this.itg.put(Long.valueOf(j), alVar);
            if (u.aHG().isY != null) {
                x.i("MicroMsg.exdevice.ExdeviceConnectManager", "start channel now : %s, %d", new Object[]{str, Long.valueOf(j)});
                z = u.aHG().isY.a(j, i, this.ite);
            } else {
                x.e("MicroMsg.exdevice.ExdeviceConnectManager", "MMExDeviceCore.getTaskQueue().getDispatcher() == null");
                z = false;
            }
        }
        return z;
    }

    public static boolean ev(boolean z) {
        if (u.aHG().isY != null) {
            long[] aHt = u.aHG().isY.aHt();
            if (aHt == null || aHt.length <= 0) {
                x.w("MicroMsg.exdevice.ExdeviceConnectManager", "connectedDevices = null or connectedDevices.length = 0");
                return false;
            }
            for (long j : aHt) {
                x.i("MicroMsg.exdevice.ExdeviceConnectManager", "deviceId = %s", new Object[]{Long.valueOf(j)});
                com.tencent.mm.plugin.exdevice.h.b cX = ad.aHe().cX(j);
                if (cX == null) {
                    x.w("MicroMsg.exdevice.ExdeviceConnectManager", "Get device info failed, deviceId = %s", new Object[]{Long.valueOf(j)});
                } else if (z && (cX.field_closeStrategy & 1) == 0) {
                    x.i("MicroMsg.exdevice.ExdeviceConnectManager", "Device is not close after exit chatting, deviceId = %s", new Object[]{Long.valueOf(j)});
                } else {
                    x.i("MicroMsg.exdevice.ExdeviceConnectManager", "Stop channel, deviceId = %s", new Object[]{Long.valueOf(j)});
                    u.aHG().isY.cT(j);
                }
            }
            return true;
        }
        x.w("MicroMsg.exdevice.ExdeviceConnectManager", "MMExDeviceCore.getTaskQueue().getDispatcher is null!");
        return false;
    }

    public final void a(int i, j jVar) {
        x.i("MicroMsg.exdevice.ExdeviceConnectManager", "scanLogic, bluetooth version = %d", new Object[]{Integer.valueOf(i)});
        if (jVar == null) {
            x.e("MicroMsg.exdevice.ExdeviceConnectManager", "null == aCallback");
            return;
        }
        this.itj = jVar;
        if (this.itd == null) {
            this.itd = new c();
            this.itd.iyE = new 12(this, i, i);
            this.itd.dd(ad.getContext());
            return;
        }
        x.i("MicroMsg.exdevice.ExdeviceConnectManager", "try start scan");
        if (u.aHG().isY == null) {
            x.e("MicroMsg.exdevice.ExdeviceConnectManager", "dispatcher is null.");
        } else if (!u.aHG().isY.b(i, this.itj)) {
            x.e("MicroMsg.exdevice.ExdeviceConnectManager", "scan failed!!!");
        }
    }
}

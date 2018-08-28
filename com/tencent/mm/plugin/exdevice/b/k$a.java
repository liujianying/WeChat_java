package com.tencent.mm.plugin.exdevice.b;

import android.os.Looper;
import android.os.Message;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.exdevice.b.k.c;
import com.tencent.mm.plugin.exdevice.b.k.d;
import com.tencent.mm.plugin.exdevice.b.k.e;
import com.tencent.mm.plugin.exdevice.b.k.f;
import com.tencent.mm.plugin.exdevice.e.k;
import com.tencent.mm.plugin.exdevice.h.b;
import com.tencent.mm.plugin.exdevice.i.h;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.plugin.exdevice.model.w;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.protocal.c.bkk;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import junit.framework.Assert;

class k$a extends ag {
    final /* synthetic */ k isL;

    public k$a(k kVar, Looper looper) {
        this.isL = kVar;
        super(looper);
    }

    public final void handleMessage(Message message) {
        x.i("MicroMsg.exdevice.MMSendDataToManufacturerLogic", "handleMessage msg.what = %d", new Object[]{Integer.valueOf(message.what)});
        e eVar;
        switch (message.what) {
            case 0:
                long longValue = ((Long) message.obj).longValue();
                e eVar2 = (e) k.c(this.isL).get(Long.valueOf(longValue));
                if (eVar2 == null) {
                    x.w("MicroMsg.exdevice.MMSendDataToManufacturerLogic", "Cannot find SendDataToManufacturerCmdContext in the map by SessionId(%d), or response has been send", new Object[]{Long.valueOf(longValue)});
                    return;
                }
                eVar2.aGG().c(-1, "", null);
                u.aHG().a(new h(eVar2.aGG()));
                k.c(this.isL).remove(Long.valueOf(longValue));
                return;
            case 1:
                f fVar = (f) message.obj;
                if (!u.aHF().cR(fVar.hjj)) {
                    x.e("MicroMsg.exdevice.MMSendDataToManufacturerLogic", "This device send other cmd before do auth, device id = %d", new Object[]{Long.valueOf(fVar.hjj)});
                    fVar.c(-2, "", new byte[0]);
                    u.aHG().a(new h(fVar));
                    return;
                } else if (-5 == message.arg1 || -3 == message.arg1 || -4 == message.arg1) {
                    x.e("MicroMsg.exdevice.MMSendDataToManufacturerLogic", "Error Code = %d, reply errorcode to device and close channel", new Object[]{Integer.valueOf(message.arg1)});
                    fVar.c(-1, "", new byte[0]);
                    u.aHG().a(new h(fVar));
                    return;
                } else {
                    b Ak = ad.aHe().Ak(fVar.hjj);
                    if (Ak == null) {
                        x.e("MicroMsg.exdevice.MMSendDataToManufacturerLogic", "SubCoreExDevice.getHardDeviceInfoStorage().getByDeviceId Failed!!!");
                        return;
                    }
                    if (System.currentTimeMillis() / 1000 < ((long) Ak.cCO)) {
                        x.e("MicroMsg.exdevice.MMSendDataToManufacturerLogic", "device has been blocked");
                        fVar.c(-5, "Device Is Block", null);
                        u.aHG().a(new h(fVar));
                        return;
                    }
                    long aGI = f.aGI();
                    k kVar = (k) fVar.aGD();
                    if (kVar == null) {
                        x.e("MicroMsg.exdevice.MMSendDataToManufacturerLogic", "SendDataToManufacturerSvr Request parse failed!!!, Tell device before stop this task");
                        fVar.c(-4, "Decode failed", null);
                        u.aHG().a(new h(fVar));
                        return;
                    }
                    Integer num = (Integer) k.b(this.isL).get(Ak.field_deviceID);
                    if (num == null) {
                        num = Integer.valueOf(0);
                    }
                    x.i("MicroMsg.exdevice.MMSendDataToManufacturerLogic", "SendDataDirection = %s", new Object[]{num});
                    d dVar;
                    e eVar3;
                    if (num.intValue() != 0) {
                        if ((num.intValue() & 1) != 0) {
                            ad.aHp();
                            com.tencent.mm.plugin.exdevice.model.e.d(Ak.field_deviceID, Ak.field_brandName, kVar.hbs.toByteArray());
                        }
                        if ((num.intValue() & 2) != 0) {
                            au.DF().a(new w(fVar.hjj, Ak.field_deviceType, Ak.field_deviceID, aGI, bi.VF(), kVar.hbs.toByteArray(), kVar.hcE), 0);
                            dVar = new d(this.isL, aGI);
                            k.a(this.isL).postDelayed(dVar, 30000);
                            eVar3 = new e((byte) 0);
                            eVar3.a(fVar);
                            eVar3.a(dVar);
                            eVar3.isR = 0;
                            k.c(this.isL).put(Long.valueOf(aGI), eVar3);
                            return;
                        }
                        return;
                    } else if (kVar.hcE == 10001) {
                        ad.aHp();
                        com.tencent.mm.plugin.exdevice.model.e.d(Ak.field_deviceID, Ak.field_brandName, kVar.hbs.toByteArray());
                        return;
                    } else {
                        au.DF().a(new w(fVar.hjj, Ak.field_deviceType, Ak.field_deviceID, aGI, bi.VF(), kVar.hbs.toByteArray(), kVar.hcE), 0);
                        dVar = new d(this.isL, aGI);
                        k.a(this.isL).postDelayed(dVar, 30000);
                        eVar3 = new e((byte) 0);
                        eVar3.a(fVar);
                        eVar3.a(dVar);
                        eVar3.isR = 0;
                        k.c(this.isL).put(Long.valueOf(aGI), eVar3);
                        return;
                    }
                }
            case 2:
                k.b bVar = (k.b) message.obj;
                if (bVar.isM != 0 || bVar.isA != 0) {
                    w wVar = (w) bVar.isN;
                    Assert.assertNotNull(wVar.ivx);
                    long j = ((bkk) wVar.ivx.dID.dIL).sjY.rON;
                    eVar = (e) k.c(this.isL).get(Long.valueOf(j));
                    if (eVar == null) {
                        x.e("MicroMsg.exdevice.MMSendDataToManufacturerLogic", "Cannot find SendDataToManufacturerCmdContext in the map by SessionId = %d", new Object[]{Long.valueOf(j)});
                        return;
                    }
                    int i;
                    f aGG = eVar.aGG();
                    switch (bVar.isA) {
                        case -417:
                            i = -5;
                            break;
                        default:
                            i = -1;
                            break;
                    }
                    aGG.c(i, bVar.fGO, null);
                    u.aHG().a(new h(eVar.aGG()));
                    k.a(this.isL).removeCallbacks(eVar.aGH());
                    k.c(this.isL).remove(Long.valueOf(j));
                    return;
                }
                return;
            case 3:
                c cVar = (c) message.obj;
                eVar = (e) k.c(this.isL).get(Long.valueOf(cVar.mSessionId));
                if (eVar == null) {
                    x.w("MicroMsg.exdevice.MMSendDataToManufacturerLogic", "Cannot find SendDataToManufacturerCmdContext in the map by SessionId = %d", new Object[]{Long.valueOf(cVar.mSessionId)});
                    return;
                }
                eVar.isP.c(0, "", cVar.hfA);
                u.aHG().a(new h(eVar.aGG()));
                k.a(this.isL).removeCallbacks(eVar.aGH());
                k.c(this.isL).remove(Long.valueOf(cVar.mSessionId));
                return;
            default:
                x.f("MicroMsg.exdevice.MMSendDataToManufacturerLogic", "unknown message type = %d", new Object[]{Integer.valueOf(message.what)});
                return;
        }
    }
}

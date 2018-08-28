package com.tencent.mm.plugin.exdevice.model;

import android.database.Cursor;
import com.tencent.mm.a.g;
import com.tencent.mm.plugin.exdevice.h.b;
import com.tencent.mm.plugin.exdevice.h.c;
import com.tencent.mm.protocal.c.aba;
import com.tencent.mm.protocal.c.alx;
import com.tencent.mm.protocal.c.aly;
import com.tencent.mm.protocal.c.aun;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

class i$2 implements Runnable {
    final /* synthetic */ i ivt;
    final /* synthetic */ aba ivu;

    i$2(i iVar, aba aba) {
        this.ivt = iVar;
        this.ivu = aba;
    }

    public final void run() {
        i.cH(bi.VF());
        c aHe = ad.aHe();
        List<b> linkedList = new LinkedList();
        Cursor axc = aHe.axc();
        Iterator it;
        if (axc == null || !axc.moveToFirst()) {
            boolean z;
            if (axc != null) {
                axc.close();
            }
            for (b bVar : linkedList) {
                Iterator it2 = this.ivu.rGg.iterator();
                while (it2.hasNext()) {
                    alx alx = ((aun) it2.next()).rhk;
                    if (bVar.field_deviceType.equals(alx.reT) && bVar.field_deviceID.equals(alx.hbO)) {
                        z = true;
                        break;
                    }
                }
                z = false;
                if (!z) {
                    x.d("MicroMsg.exdevice.GetBoundDeviceLogic", "delete deviceId %s, deviceType %s ", new Object[]{bVar.field_deviceID, bVar.field_deviceType});
                    i.d(bVar);
                    ad.aHe().cB(bVar.field_deviceID, bVar.field_deviceType);
                    ad.aHp();
                    e.ai(bVar.field_deviceID, false);
                }
            }
            it = this.ivu.rGg.iterator();
            while (it.hasNext()) {
                aun aun = (aun) it.next();
                aly aly = aun.rhl;
                alx alx2 = aun.rhk;
                if (!(alx2 == null || aly == null || bi.oW(alx2.hbO))) {
                    x.i("MicroMsg.exdevice.GetBoundDeviceLogic", "ModHardDevice deviceId = %s, deviceType = %s, BindFlag = %s", new Object[]{alx2.hbO, alx2.reT, Integer.valueOf(aun.rXH)});
                    b Al = ad.aHe().Al(alx2.hbO);
                    if (2 == aun.rXH) {
                        x.w("MicroMsg.exdevice.GetBoundDeviceLogic", "This Device is unbind, Just leave. deviceId = %s, mac = %s, brandName = %s", new Object[]{alx2.hbO, aly.rgL, aly.rOv});
                        if (Al != null) {
                            i.d(Al);
                            ad.aHe().cB(Al.field_deviceID, Al.field_deviceType);
                            ad.aHp();
                            e.ai(Al.field_deviceID, false);
                        }
                    } else {
                        b bVar2 = new b();
                        bVar2.field_deviceID = alx2.hbO;
                        bVar2.field_deviceType = alx2.reT;
                        bVar2.field_connProto = aly.rOw;
                        bVar2.field_connStrategy = aly.rOx;
                        bVar2.field_closeStrategy = aly.rOy;
                        if (!(aly.cCV != 2 || Al == null || Al.cCR == null)) {
                            aly.eJM = Al.cCR;
                        }
                        bVar2.du(aly.eJM);
                        bVar2.ek(aly.rOE);
                        bVar2.ej(aly.rOD);
                        bVar2.ei(aly.rOC);
                        bVar2.fe(aly.rOF);
                        bVar2.setIconUrl(aly.jPG);
                        bVar2.eh(aly.jOU);
                        bVar2.ff(aly.cCV);
                        bVar2.aw(aly.cCW);
                        bVar2.el(aly.cCX);
                        bVar2.em(aly.cCY);
                        bVar2.en(aly.cCZ);
                        bVar2.eo(aly.cDa);
                        bVar2.field_url = "";
                        bVar2.field_mac = com.tencent.mm.plugin.exdevice.j.b.Az(com.tencent.mm.plugin.exdevice.j.b.AA(aly.rgL));
                        bVar2.field_md5Str = g.u(new String(alx2.reT + alx2.hbO).getBytes());
                        bVar2.field_authKey = aly.reA;
                        bVar2.field_brandName = aly.rOv;
                        if (bVar2.field_mac == 0) {
                            bVar2.field_mac = System.currentTimeMillis();
                        }
                        if (Al == null) {
                            z = ad.aHe().b(bVar2);
                            if (z) {
                                ad.aHp();
                                e.ai(bVar2.field_deviceID, true);
                            }
                        } else {
                            z = ad.aHe().e(bVar2) != 0;
                        }
                        x.i("MicroMsg.exdevice.GetBoundDeviceLogic", "insert HardDeviceInfo %s, brandName = %s, deviceID = %s, deviceType = %s, connProto = %s, connStrategy = %s, closeStrategy = %s, mac = %s", new Object[]{Boolean.valueOf(z), bVar2.field_brandName, bVar2.field_deviceID, alx2.reT, bVar2.field_connProto, Integer.valueOf(bVar2.field_connStrategy), Integer.valueOf(bVar2.field_closeStrategy), Long.valueOf(bVar2.field_mac)});
                    }
                }
            }
        }
        do {
            b bVar3 = new b();
            bVar3.d(axc);
            linkedList.add(bVar3);
        } while (axc.moveToNext());
        if (axc != null) {
            axc.close();
        }
        for (b bVar4 : linkedList) {
            Iterator it22 = this.ivu.rGg.iterator();
            while (it22.hasNext()) {
                alx alx3 = ((aun) it22.next()).rhk;
                if (bVar4.field_deviceType.equals(alx3.reT) && bVar4.field_deviceID.equals(alx3.hbO)) {
                    z = true;
                    break;
                }
            }
            z = false;
            if (!z) {
                x.d("MicroMsg.exdevice.GetBoundDeviceLogic", "delete deviceId %s, deviceType %s ", new Object[]{bVar4.field_deviceID, bVar4.field_deviceType});
                i.d(bVar4);
                ad.aHe().cB(bVar4.field_deviceID, bVar4.field_deviceType);
                ad.aHp();
                e.ai(bVar4.field_deviceID, false);
            }
        }
        it = this.ivu.rGg.iterator();
        while (it.hasNext()) {
            aun aun2 = (aun) it.next();
            aly aly2 = aun2.rhl;
            alx alx22 = aun2.rhk;
            if (!(alx22 == null || aly2 == null || bi.oW(alx22.hbO))) {
                x.i("MicroMsg.exdevice.GetBoundDeviceLogic", "ModHardDevice deviceId = %s, deviceType = %s, BindFlag = %s", new Object[]{alx22.hbO, alx22.reT, Integer.valueOf(aun2.rXH)});
                b Al2 = ad.aHe().Al(alx22.hbO);
                if (2 == aun2.rXH) {
                    x.w("MicroMsg.exdevice.GetBoundDeviceLogic", "This Device is unbind, Just leave. deviceId = %s, mac = %s, brandName = %s", new Object[]{alx22.hbO, aly2.rgL, aly2.rOv});
                    if (Al2 != null) {
                        i.d(Al2);
                        ad.aHe().cB(Al2.field_deviceID, Al2.field_deviceType);
                        ad.aHp();
                        e.ai(Al2.field_deviceID, false);
                    }
                } else {
                    b bVar22 = new b();
                    bVar22.field_deviceID = alx22.hbO;
                    bVar22.field_deviceType = alx22.reT;
                    bVar22.field_connProto = aly2.rOw;
                    bVar22.field_connStrategy = aly2.rOx;
                    bVar22.field_closeStrategy = aly2.rOy;
                    if (!(aly2.cCV != 2 || Al2 == null || Al2.cCR == null)) {
                        aly2.eJM = Al2.cCR;
                    }
                    bVar22.du(aly2.eJM);
                    bVar22.ek(aly2.rOE);
                    bVar22.ej(aly2.rOD);
                    bVar22.ei(aly2.rOC);
                    bVar22.fe(aly2.rOF);
                    bVar22.setIconUrl(aly2.jPG);
                    bVar22.eh(aly2.jOU);
                    bVar22.ff(aly2.cCV);
                    bVar22.aw(aly2.cCW);
                    bVar22.el(aly2.cCX);
                    bVar22.em(aly2.cCY);
                    bVar22.en(aly2.cCZ);
                    bVar22.eo(aly2.cDa);
                    bVar22.field_url = "";
                    bVar22.field_mac = com.tencent.mm.plugin.exdevice.j.b.Az(com.tencent.mm.plugin.exdevice.j.b.AA(aly2.rgL));
                    bVar22.field_md5Str = g.u(new String(alx22.reT + alx22.hbO).getBytes());
                    bVar22.field_authKey = aly2.reA;
                    bVar22.field_brandName = aly2.rOv;
                    if (bVar22.field_mac == 0) {
                        bVar22.field_mac = System.currentTimeMillis();
                    }
                    if (Al2 == null) {
                        z = ad.aHe().b(bVar22);
                        if (z) {
                            ad.aHp();
                            e.ai(bVar22.field_deviceID, true);
                        }
                    } else {
                        z = ad.aHe().e(bVar22) != 0;
                    }
                    x.i("MicroMsg.exdevice.GetBoundDeviceLogic", "insert HardDeviceInfo %s, brandName = %s, deviceID = %s, deviceType = %s, connProto = %s, connStrategy = %s, closeStrategy = %s, mac = %s", new Object[]{Boolean.valueOf(z), bVar22.field_brandName, bVar22.field_deviceID, alx22.reT, bVar22.field_connProto, Integer.valueOf(bVar22.field_connStrategy), Integer.valueOf(bVar22.field_closeStrategy), Long.valueOf(bVar22.field_mac)});
                }
            }
        }
    }
}

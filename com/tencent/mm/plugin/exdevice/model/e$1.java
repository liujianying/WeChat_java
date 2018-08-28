package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.ac.d;
import com.tencent.mm.ac.f;
import com.tencent.mm.g.a.jd;
import com.tencent.mm.g.a.lb;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

class e$1 extends c<jd> {
    final /* synthetic */ e iup;

    e$1(e eVar) {
        this.iup = eVar;
        this.sFo = jd.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        com.tencent.mm.plugin.exdevice.h.b bVar2;
        jd jdVar = (jd) bVar;
        e eVar = this.iup;
        int i = jdVar.bSI.opType;
        int i2 = jdVar.bSI.bSK;
        String str = jdVar.bSI.bSJ;
        if (i == 1) {
            x.i("MicroMsg.exdevice.ExdeviceEventManager", "Just enter, so clear previous state.");
            lb lbVar = new lb();
            lbVar.bVp.op = 3;
            lbVar.bVp.bSJ = jdVar.bSI.bSJ;
            a.sFg.m(lbVar);
        }
        LinkedList An = ad.aHe().An(str);
        d kH = f.kH(str);
        if (kH != null) {
            d.b bG = kH.bG(false);
            if (bG != null) {
                d.b.b Ms = bG.Ms();
                if (Ms != null && Ms.MC() && Ms.dLA == 1) {
                    List<com.tencent.mm.plugin.exdevice.h.b> aHK = ad.aHe().aHK();
                    x.i("MicroMsg.exdevice.ExdeviceEventManager", "Wechat sport biz...");
                    if (aHK.size() != 0) {
                        for (com.tencent.mm.plugin.exdevice.h.b bVar22 : aHK) {
                            if (0 != (bVar22.cCW & 1)) {
                                x.i("MicroMsg.exdevice.ExdeviceEventManager", "BLE connected device info, mac(%s), deviceId(%s), deviceType(%s), SimpleProtol(%d), connProto(%s)", new Object[]{Long.valueOf(bVar22.field_mac), bVar22.field_deviceID, bVar22.field_deviceType, Long.valueOf(bVar22.cCW), bVar22.field_connProto});
                                An.add(bVar22);
                            }
                        }
                    }
                }
            }
        }
        if (An == null) {
            x.i("MicroMsg.exdevice.ExdeviceEventManager", "get hdinfo by brandName failed : %s", new Object[]{str});
            return false;
        } else if (An.size() == 0) {
            x.i("MicroMsg.exdevice.ExdeviceEventManager", "get hdinfo by brandName(%s) result count is 0 ", new Object[]{str});
            return true;
        } else {
            if (i == 2) {
                x.d("MicroMsg.exdevice.ExdeviceEventManager", "exit chattingui, clear observers.");
                eVar.itx.clear();
            }
            List linkedList = new LinkedList();
            Iterator it = An.iterator();
            Object obj = null;
            while (it.hasNext()) {
                bVar22 = (com.tencent.mm.plugin.exdevice.h.b) it.next();
                if (bVar22 == null || bi.oW(bVar22.field_brandName)) {
                    return false;
                }
                String oV = bi.oV(bVar22.field_connProto);
                if (oV.contains("4")) {
                    x.i("MicroMsg.exdevice.ExdeviceEventManager", "Wifi biz.");
                    linkedList.add(bVar22);
                } else {
                    if (oV.contains("1") || oV.contains("3") || oV.contains("5") || oV.length() == 0) {
                        x.i("MicroMsg.exdevice.ExdeviceEventManager", "BlueTooth biz.");
                        if (com.tencent.mm.plugin.h.a.e.a.atY()) {
                            obj = null;
                            e.a(bVar22, i, i2);
                        } else {
                            x.w("MicroMsg.exdevice.ExdeviceEventManager", "System bluetooth is close");
                            obj = 1;
                        }
                    }
                    obj = obj;
                }
            }
            i2 = linkedList.size();
            if (i2 > 0) {
                eVar.f(linkedList, i);
                bVar22 = (com.tencent.mm.plugin.exdevice.h.b) linkedList.get(i2 - 1);
                if (i2 == An.size()) {
                    e.e(bVar22.field_brandName, bVar22.field_url, 0, bVar22.field_deviceID);
                }
            }
            e.bj(str, obj != null ? 0 : -1);
            return false;
        }
    }
}

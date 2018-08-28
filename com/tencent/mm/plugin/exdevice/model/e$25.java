package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.g.a.dh;
import com.tencent.mm.plugin.exdevice.jni.Java2CExDevice;
import com.tencent.mm.plugin.exdevice.model.g.7;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.logreport.BaseReportManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class e$25 extends c<dh> {
    final /* synthetic */ e iup;

    e$25(e eVar) {
        this.iup = eVar;
        this.sFo = dh.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        dh dhVar = (dh) bVar;
        e eVar = this.iup;
        dhVar = dhVar;
        eVar.ium = new g();
        g gVar = eVar.ium;
        x.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "startScanWCLanDevice...");
        Java2CExDevice.startScanWCLanDevice(new byte[0], BaseReportManager.MAX_READ_COUNT);
        gVar.iuu = false;
        new al(new 7(gVar), false).J(3000, 3000);
        g gVar2 = eVar.ium;
        long j = dhVar.bKU.bJC;
        String str = dhVar.bKU.bKW;
        String str2 = dhVar.bKU.bKX;
        int i = dhVar.bKU.bKY;
        List arrayList = new ArrayList();
        gVar2.cYP = j;
        gVar2.iux = str;
        gVar2.iuy = str2;
        gVar2.iuz = i;
        int size = gVar2.iuJ.size();
        for (int i2 = 0; i2 < size; i2++) {
            HashMap hashMap = new HashMap();
            hashMap.put("deviceType", ((com.tencent.mm.plugin.exdevice.h.b) gVar2.iuJ.get(i2)).field_deviceType);
            hashMap.put("deviceID", ((com.tencent.mm.plugin.exdevice.h.b) gVar2.iuJ.get(i2)).field_deviceID);
            hashMap.put("displayName", g.c((com.tencent.mm.plugin.exdevice.h.b) gVar2.iuJ.get(i2)));
            hashMap.put("iconUrl", ((com.tencent.mm.plugin.exdevice.h.b) gVar2.iuJ.get(i2)).iconUrl);
            hashMap.put("ability", ((com.tencent.mm.plugin.exdevice.h.b) gVar2.iuJ.get(i2)).cCX);
            hashMap.put("abilityInf", ((com.tencent.mm.plugin.exdevice.h.b) gVar2.iuJ.get(i2)).cCY);
            arrayList.add(hashMap);
        }
        if (arrayList.size() > 0) {
            dhVar.bKV.bKZ = arrayList;
            dhVar.bKV.bKE = true;
        } else {
            dhVar.bKV.bKE = false;
        }
        return true;
    }
}

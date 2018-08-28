package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.g.a.db;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

class e$32 extends c<db> {
    final /* synthetic */ e iup;

    e$32(e eVar) {
        this.iup = eVar;
        this.sFo = db.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        db dbVar = (db) bVar;
        e eVar = this.iup;
        dbVar = dbVar;
        x.i("MicroMsg.exdevice.ExdeviceEventManager", "ExDeviceConnectLanDeviceEvent: brandName=%s, deviceId=%s, type=%b", new Object[]{dbVar.bKF.bKC, dbVar.bKF.byN, Boolean.valueOf(dbVar.bKF.bKD)});
        if (e.zU(dbVar.bKF.bKC)) {
            com.tencent.mm.plugin.exdevice.h.b Al = ad.aHe().Al(dbVar.bKF.byN);
            if (Al == null) {
                dbVar.bKG.bKE = false;
                x.e("MicroMsg.exdevice.ExdeviceEventManager", "hdInfo null, %s", new Object[]{dbVar.bKF.byN});
                return false;
            } else if (Al.field_brandName.equals(dbVar.bKF.bKC)) {
                boolean aj = eVar.iul.aj(dbVar.bKF.byN, dbVar.bKF.bKD);
                dbVar.bKG.bKE = aj;
                return aj;
            } else {
                dbVar.bKG.bKE = false;
                x.e("MicroMsg.exdevice.ExdeviceEventManager", "brand name not match. %s != %s", new Object[]{Al.field_brandName, dbVar.bKF.bKC});
                return false;
            }
        }
        dbVar.bKG.bKE = false;
        return false;
    }
}

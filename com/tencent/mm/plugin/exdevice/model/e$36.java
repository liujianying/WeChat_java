package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.g.a.di;
import com.tencent.mm.model.au;
import com.tencent.mm.protocal.c.aeh;
import com.tencent.mm.protocal.c.aei;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;

class e$36 implements e {
    final /* synthetic */ e iup;
    final /* synthetic */ di iuq;

    e$36(e eVar, di diVar) {
        this.iup = eVar;
        this.iuq = diVar;
    }

    public final void a(int i, int i2, String str, l lVar) {
        if (lVar == null || lVar.getType() != 543) {
            this.iuq.bLb.bLd = true;
            this.iuq.bLb.bLe = null;
            if (this.iuq.bJX != null) {
                this.iuq.bJX.run();
                return;
            }
            return;
        }
        au.DF().b(543, this);
        if (i == 0 && i2 == 0) {
            aeh aeh;
            x.i("MicroMsg.exdevice.ExdeviceEventManager", "getTicketSceneEndImpl errType = [%s], errCode = [%s]， errMsg = [%s]", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
            z zVar = (z) lVar;
            if (zVar.ivx == null || zVar.ivx.dIE.dIL == null) {
                aeh = null;
            } else {
                aeh = (aeh) zVar.ivx.dIE.dIL;
            }
            Iterator it = aeh.rIv.iterator();
            Object obj = null;
            while (it.hasNext()) {
                aei aei = (aei) it.next();
                if (aei != null) {
                    String str2 = null;
                    String str3 = null;
                    if (aei.rgS != null) {
                        str2 = aei.rgS.hbO;
                        str3 = aei.rgS.reT;
                    }
                    if (aei.rfn != 0 || bi.oW(aei.rwj)) {
                        x.e("MicroMsg.exdevice.ExdeviceEventManager", "deviceId(%s) get ticket fail. ret=%d, ticket=%s", new Object[]{str2, Integer.valueOf(aei.rfn), aei.rwj});
                    } else {
                        Object obj2;
                        x.i("MicroMsg.exdevice.ExdeviceEventManager", "GetHardDeviceOperTicket end. deviceId=%s, deviceType=%s, ticket=%s, oper=%d", new Object[]{str2, str3, aei.rwj, Integer.valueOf(aei.rIr)});
                        this.iuq.bLb.bLd = true;
                        this.iuq.bLb.bLe = aei.rwj;
                        if (this.iuq.bJX != null) {
                            this.iuq.bJX.run();
                            obj2 = 1;
                        } else {
                            obj2 = obj;
                        }
                        obj = obj2;
                    }
                }
            }
            if (obj == null) {
                this.iuq.bLb.bLd = true;
                this.iuq.bLb.bLe = null;
                if (this.iuq.bJX != null) {
                    this.iuq.bJX.run();
                    return;
                }
                return;
            }
            return;
        }
        x.e("MicroMsg.exdevice.ExdeviceEventManager", "getTicketSceneEndImpl errType = [%s], errCode = [%s]， errMsg = [%s]", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        this.iuq.bLb.bLd = true;
        this.iuq.bLb.bLe = null;
        if (this.iuq.bJX != null) {
            this.iuq.bJX.run();
        }
    }
}

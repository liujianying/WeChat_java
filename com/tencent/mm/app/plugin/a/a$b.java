package com.tencent.mm.app.plugin.a;

import com.tencent.mm.ac.d;
import com.tencent.mm.ac.f;
import com.tencent.mm.g.a.lb;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

class a$b extends c<lb> {
    final /* synthetic */ a bAN;

    a$b(a aVar) {
        this.bAN = aVar;
        this.sFo = lb.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        lb lbVar = (lb) bVar;
        if (this.bAN.bAG != null) {
            if (!this.bAN.bAG.tTq.isFinishing()) {
                int i = lbVar.bVp.op;
                String str = lbVar.bVp.bSJ;
                x.i("MicroMsg.exdevice.ChattingUIExDeviceLogic", "opcode is %d, brand name is %s", new Object[]{Integer.valueOf(i), str});
                if (this.bAN.bAG.getTalkerUserName().equals(str)) {
                    switch (i) {
                        case 1:
                            a aVar = this.bAN;
                            x.i("MicroMsg.exdevice.ChattingUIExDeviceLogic", "handleConnectFailedReason, reason : %d, brand name : %s", new Object[]{Integer.valueOf(lbVar.bVp.aAk), str});
                            d kH = f.kH(str);
                            if (a.a(kH)) {
                                if (kH.bG(false).Ms().dLz == 1) {
                                    aVar.bAG.tTq.setMMSubTitle(null);
                                    break;
                                }
                            }
                            x.w("MicroMsg.exdevice.ChattingUIExDeviceLogic", "It's not a biz, brandName(%s).", new Object[]{str});
                            break;
                            break;
                        case 2:
                            this.bAN.d(lbVar.bVp.bLv, str, lbVar.bVp.byN);
                            break;
                        case 3:
                            if (this.bAN.bAK != null) {
                                this.bAN.bAK.clear();
                                x.i("MicroMsg.exdevice.ChattingUIExDeviceLogic", "clear connected device ids successfully.");
                                break;
                            }
                            break;
                    }
                }
                x.i("MicroMsg.exdevice.ChattingUIExDeviceLogic", "not current brandname");
            } else {
                x.e("MicroMsg.exdevice.ChattingUIExDeviceLogic", "context isFinishing");
            }
        } else {
            x.e("MicroMsg.exdevice.ChattingUIExDeviceLogic", "context == null");
        }
        return false;
    }
}

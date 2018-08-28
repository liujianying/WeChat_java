package com.tencent.mm.plugin.remittance.a;

import android.text.TextUtils;
import com.tencent.mm.ab.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bv.a;
import com.tencent.mm.model.q;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.plugin.remittance.b.c;
import com.tencent.mm.protocal.c.by;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bl;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa;
import com.tencent.mm.storage.bd;
import java.net.URLDecoder;
import java.util.Map;

class b$4 implements a {
    final /* synthetic */ b mtR;

    b$4(b bVar) {
        this.mtR = bVar;
    }

    public final void a(d.a aVar) {
        x.i("MicroMsg.SubCoreRemittance", "hy: received AddMsg");
        by byVar = aVar.dIN;
        if (byVar == null) {
            x.e("MicroMsg.SubCoreRemittance", "recieve a null msg");
            return;
        }
        String a = ab.a(byVar.rcl);
        if (bi.oW(a)) {
            x.e("MicroMsg.SubCoreRemittance", "msg illegal,content is null");
            return;
        }
        Map z = bl.z(a, "sysmsg");
        if (z == null) {
            x.e("MicroMsg.SubCoreRemittance", "Resolve msg error");
            return;
        }
        a = (String) z.get(".sysmsg.paymsg.PayMsgType");
        String str;
        if ("15".equals(a)) {
            String decode = URLDecoder.decode((String) z.get(".sysmsg.paymsg.appmsgcontent"));
            if (TextUtils.isEmpty(decode)) {
                x.e("MicroMsg.SubCoreRemittance", "appmsgcontent is null");
                return;
            }
            Map z2 = bl.z(decode, "msg");
            if (z2 == null) {
                x.e("MicroMsg.SubCoreRemittance", "Resolve appmsgcontent error");
                return;
            }
            a = (String) z2.get(".msg.appmsg.wcpayinfo.transferid");
            if (bi.oW(a)) {
                x.e("MicroMsg.SubCoreRemittance", "paymsgid is null");
            } else if (this.mtR.bqT().Ky(a)) {
                x.e("MicroMsg.SubCoreRemittance", "it is a duplicate msg");
            } else {
                str = (String) z.get(".sysmsg.paymsg.tousername");
                if (bi.oW(decode) || bi.oW(str)) {
                    x.e("MicroMsg.SubCoreRemittance", "onRecieveMsg get a illegal msg,which content or toUserName is null");
                } else {
                    this.mtR.bqT().V(a, decode, str);
                }
            }
        } else if ("22".equals(a)) {
            a = (String) z.get(".sysmsg.paymsg.tousername");
            str = (String) z.get(".sysmsg.paymsg.fromusername");
            try {
                String decode2 = URLDecoder.decode((String) z.get(".sysmsg.paymsg.appmsgcontent"), "UTF-8");
                if (bi.oW(decode2)) {
                    x.e("MicroMsg.SubCoreRemittance", "appmsgcontent is null");
                    return;
                }
                Map z3 = bl.z(decode2, "msg");
                if (z3 == null) {
                    x.e("MicroMsg.SubCoreRemittance", "Resolve appmsgcontent error");
                    return;
                }
                String str2 = (String) z3.get(".msg.appmsg.wcpayinfo.transferid");
                int i = bi.getInt((String) z3.get(".msg.appmsg.wcpayinfo.paysubtype"), -1);
                x.i("MicroMsg.SubCoreRemittance", "receive delay transfer newxml, fromusername: %s, tousername: %s, transferId: %s, paysubtype: %d", new Object[]{str, a, str2, Integer.valueOf(i)});
                com.tencent.mm.plugin.remittance.b.a aVar2 = null;
                try {
                    b.bqQ();
                    aVar2 = b.bqR().Kw(str2);
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.SubCoreRemittance", e, "", new Object[0]);
                }
                if (aVar2 == null) {
                    x.i("MicroMsg.SubCoreRemittance", "empty record");
                    return;
                }
                bd dW = ((i) g.l(i.class)).bcY().dW(aVar2.field_msgId);
                if (dW.field_msgId <= 0) {
                    x.i("MicroMsg.SubCoreRemittance", "has delete msg");
                    b.bqQ();
                    b.bqR().a(aVar2, new String[0]);
                    return;
                }
                x.i("MicroMsg.SubCoreRemittance", "update msg: %s", new Object[]{Long.valueOf(dW.field_msgId)});
                dW.setContent(decode2);
                ((i) g.l(i.class)).bcY().a(dW.field_msgId, dW);
                c Kx = b.bqS().Kx(str2);
                if (Kx != null) {
                    Kx.field_receiveStatus = i;
                    b.bqS().a(Kx);
                } else if (!dW.field_talker.equals(q.GF())) {
                    Kx = new c();
                    Kx.field_locaMsgId = dW.field_msgId;
                    Kx.field_transferId = str2;
                    Kx.field_receiveStatus = i;
                    Kx.field_isSend = false;
                    b.bqS().a(Kx);
                }
            } catch (Throwable e2) {
                x.printErrStackTrace("MicroMsg.SubCoreRemittance", e2, "", new Object[0]);
            }
        } else if ("33".equals(a)) {
            int i2 = bi.getInt((String) z.get(".sysmsg.paymsg.opentransferbankcard"), 0);
            com.tencent.mm.storage.x DT = g.Ei().DT();
            DT.a(aa.a.sZl, Integer.valueOf(i2));
            x.i("MicroMsg.SubCoreRemittance", "receive open bank remit: %s, %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(((Integer) DT.get(aa.a.sZm, Integer.valueOf(0))).intValue())});
            if (((Integer) DT.get(aa.a.sZm, Integer.valueOf(0))).intValue() == 0) {
                com.tencent.mm.s.c.Cp().b(aa.a.sZg, true);
                DT.a(aa.a.sZm, Integer.valueOf(1));
                g.Ei().DT().a(aa.a.sZh, Boolean.valueOf(false));
            }
        }
    }
}

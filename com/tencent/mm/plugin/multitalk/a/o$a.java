package com.tencent.mm.plugin.multitalk.a;

import android.util.Base64;
import com.tencent.mm.ab.d;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bv.a;
import com.tencent.mm.model.q;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bl;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Map;

class o$a implements a {
    final /* synthetic */ o luP;

    o$a(o oVar) {
        this.luP = oVar;
    }

    public final void a(d.a aVar) {
        f bgQ = o.bgQ();
        String a = ab.a(aVar.dIN.rcl);
        Map z = bl.z(a, "sysmsg");
        if (((String) z.get(".sysmsg.multivoip.notfriendnotifydata")) != null) {
            x.i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "receive notfriendnotifydata msg:" + a);
            return;
        }
        String str = (String) z.get(".sysmsg.multivoip.notifydata");
        if (str != null) {
            byte[] decode = Base64.decode(bi.aG(str, "").getBytes(), 0);
            x.i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "receive " + ab.a(aVar.dIN.rcl) + " buffer len " + decode.length);
            o.bgM().lta.bg(bi.f((Integer) au.HS().get(1)), q.GF());
            o.bgM().lta.bL(decode);
            return;
        }
        str = (String) z.get(".sysmsg.multivoip.banner");
        if (str != null) {
            bgQ.a(str, aVar);
        }
    }
}

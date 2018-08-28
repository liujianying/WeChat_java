package com.tencent.mm.plugin.shake.b;

import com.tencent.mm.ab.d;
import com.tencent.mm.model.bv.a;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bl;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Map;

class m$13 implements a {
    final /* synthetic */ m mXg;

    m$13(m mVar) {
        this.mXg = mVar;
    }

    public final void a(d.a aVar) {
        m.buJ();
        if (m.buG() != 0) {
            m.buJ();
            m.buG();
            String a = ab.a(aVar.dIN.rcl);
            x.v("MicroMsg.ShakeMsgMgr", "func[onResvMsg] content:" + a);
            if (bi.oW(a)) {
                x.d("MicroMsg.ShakeMsgMgr", "func[onResvMsg] Msg content empty");
                return;
            }
            Map z = bl.z(a, "sysmsg");
            int i = bi.getInt((String) z.get(".sysmsg.shake.$type"), 0);
            switch (i) {
                case 1:
                    f fVar = new f();
                    i = bi.getInt((String) z.get(".sysmsg.shake.shaketv.msgtype"), 0);
                    if (i == 0) {
                        fVar.field_type = 1;
                        fVar.field_subtype = i;
                        fVar.field_svrid = aVar.dIN.rcq;
                        fVar.field_createtime = bi.VE();
                        fVar.field_tag = (String) z.get(".sysmsg.shake.shaketv.jumpurl");
                        fVar.field_status = 0;
                        fVar.field_title = (String) z.get(".sysmsg.shake.shaketv.title");
                        fVar.field_thumburl = (String) z.get(".sysmsg.shake.shaketv.iconurl");
                        fVar.field_desc = (String) z.get(".sysmsg.shake.shaketv.desc");
                        fVar.field_reserved1 = bi.oV((String) z.get(".sysmsg.shake.shaketv.pid"));
                        m.buD().a(fVar);
                        return;
                    }
                    x.w("MicroMsg.ShakeMsgMgr", "Unknown subType:" + i);
                    return;
                default:
                    x.d("MicroMsg.ShakeMsgMgr", "Unrecognized type :" + i);
                    return;
            }
        }
        x.w("MicroMsg.SubCoreShake", "func[onRecieveMsg] getShakeMsgMgr null");
    }
}

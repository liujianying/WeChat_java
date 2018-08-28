package com.tencent.mm.plugin.appbrand.h;

import com.tencent.mm.ab.d.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelappbrand.i;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.plugin.messenger.foundation.a.m;
import com.tencent.mm.protocal.c.by;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bd;
import java.util.Map;

public enum b implements m {
    ;

    private b(String str) {
    }

    public final com.tencent.mm.ab.d.b a(String str, Map<String, String> map, a aVar) {
        if (str == null || !str.equals("subscribesysmsg")) {
            x.e("MicroMsg.WxaSubscribeSysmsgHandler", "subType is err, return");
            return null;
        }
        String str2 = (String) map.get(".sysmsg.subscribesysmsg.content_template.link_list.link.share_key");
        if (bi.oW(str2)) {
            x.e("MicroMsg.WxaSubscribeSysmsgHandler", "shareKey is null, return");
            return null;
        }
        x.i("MicroMsg.WxaSubscribeSysmsgHandler", "consumeNewXml subType:%s", new Object[]{str});
        com.tencent.mm.y.a.b jm = ((i) g.l(i.class)).jm(str2);
        if (jm == null) {
            x.e("MicroMsg.WxaSubscribeSysmsgHandler", "shareKey:%s wxaUpdateableMsg is null, ingore", new Object[]{str2});
            return null;
        } else if (jm.field_btnState != 2 || jm.field_msgState != 0) {
            x.e("MicroMsg.WxaSubscribeSysmsgHandler", "shareKey:%s btnState:%d msgState:%d ingore", new Object[]{str2, Integer.valueOf(jm.field_btnState), Integer.valueOf(jm.field_msgState)});
            return null;
        } else if (aVar == null || aVar.dIN == null) {
            x.e("MicroMsg.WxaSubscribeSysmsgHandler", "addMsgInfo or addMsgInfo.addMsg is null! should not happen");
            return null;
        } else {
            by byVar = aVar.dIN;
            String a = ab.a(byVar.rcl);
            String a2 = ab.a(byVar.rcj);
            bd I = ((com.tencent.mm.plugin.messenger.foundation.a.i) g.l(com.tencent.mm.plugin.messenger.foundation.a.i.class)).bcY().I(a2, byVar.rcq);
            Object obj = null;
            if (I.field_msgId > 0) {
                obj = 1;
            }
            I.ax(byVar.rcq);
            if (!(aVar.dIO && aVar.dIQ)) {
                I.ay(com.tencent.mm.model.bd.o(a2, (long) byVar.lOH));
            }
            I.setType(603979825);
            I.setContent(a);
            I.eX(0);
            I.setStatus(3);
            I.ep(a2);
            I.dt(byVar.rco);
            com.tencent.mm.model.bd.a(I, aVar);
            if (obj == null) {
                com.tencent.mm.model.bd.i(I);
            } else {
                ((com.tencent.mm.plugin.messenger.foundation.a.i) g.l(com.tencent.mm.plugin.messenger.foundation.a.i.class)).bcY().b(byVar.rcq, I);
            }
            ai Yq = ((com.tencent.mm.plugin.messenger.foundation.a.i) g.l(com.tencent.mm.plugin.messenger.foundation.a.i.class)).FW().Yq(I.field_talker);
            if (Yq != null) {
                Yq.gf(33554432);
                int a3 = ((com.tencent.mm.plugin.messenger.foundation.a.i) g.l(com.tencent.mm.plugin.messenger.foundation.a.i.class)).FW().a(Yq, I.field_talker);
                x.d("MicroMsg.WxaSubscribeSysmsgHandler", "username:%s ok:%b", new Object[]{I.field_talker, Integer.valueOf(a3)});
            } else {
                x.d("MicroMsg.WxaSubscribeSysmsgHandler", "conv is null");
            }
            return null;
        }
    }
}

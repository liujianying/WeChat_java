package com.tencent.mm.app;

import android.graphics.Bitmap.CompressFormat;
import com.tencent.mm.ac.a.e;
import com.tencent.mm.ac.f;
import com.tencent.mm.ak.o;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.g.a.ot;
import com.tencent.mm.model.au;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;
import com.tencent.mm.y.g.a;

class WorkerProfile$34 extends c<ot> {
    final /* synthetic */ WorkerProfile bzO;

    WorkerProfile$34(WorkerProfile workerProfile) {
        this.bzO = workerProfile;
        this.sFo = ot.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        ot otVar = (ot) bVar;
        for (String str : bi.F(otVar.bZE.toUser.split(","))) {
            if (bi.oW(otVar.bZE.bZI)) {
                WXMediaMessage wXMediaMessage = otVar.bZE.bSg;
                String str2 = otVar.bZE.appId;
                String str3 = otVar.bZE.appName;
                int i = otVar.bZE.bZF;
                String str4 = otVar.bZE.bZG;
                String str5 = otVar.bZE.bZH;
                String str6 = otVar.bZE.bZJ;
                String str7 = otVar.bZE.bZK;
                String str8 = otVar.bZE.bZL;
                String str9 = otVar.bZE.bZM;
                String str10 = otVar.bZE.bJK;
                String str11 = otVar.bZE.bZN;
                com.tencent.mm.pluginsdk.model.app.b bVar2 = null;
                a aVar = new a();
                aVar.appId = str2;
                aVar.appName = str3;
                aVar.dwr = i;
                aVar.bZG = str4;
                aVar.bZH = str5;
                aVar.bZJ = str6;
                aVar.bZK = str7;
                aVar.bZL = str8;
                aVar.bZM = str9;
                aVar.bZN = str11;
                str2 = l.b(aVar, wXMediaMessage, null);
                x.d("MicroMsg.AppMsgLogic", g.Ac() + " content url:" + aVar.url + " lowUrl:" + aVar.dwn + " attachlen:" + aVar.dwo + " attachid:" + aVar.bGP + " attach file:" + str2);
                String str12 = System.currentTimeMillis();
                if (!bi.oW(str2)) {
                    bVar2 = l.a(str12, aVar, str2);
                    if (bVar2 == null) {
                        g.getLine();
                    }
                }
                bd bdVar = new bd();
                if (wXMediaMessage.thumbData != null && wXMediaMessage.thumbData.length > 0) {
                    str2 = o.Pf().a(6, wXMediaMessage.thumbData, aVar.type == 2, CompressFormat.PNG);
                    x.d("MicroMsg.AppMsgLogic", g.Ac() + " thumbData MsgInfo path:" + str2);
                    if (!bi.oW(str2)) {
                        bdVar.eq(str2);
                        x.d("MicroMsg.AppMsgLogic", "new thumbnail saved, path" + str2);
                    }
                }
                if (bVar2 != null) {
                    aVar.bGP = bVar2.sKx;
                }
                bdVar.setContent(a.a(aVar, null, null));
                bdVar.setStatus(1);
                bdVar.ep(str);
                bdVar.ay(com.tencent.mm.model.bd.iD(str));
                bdVar.eX(1);
                bdVar.setType(l.d(aVar));
                if (f.eZ(bdVar.field_talker)) {
                    bdVar.dt(e.Ir());
                    x.d("MicroMsg.AppMsgLogic", "NetSceneSendMsg:MsgSource:%s", new Object[]{bdVar.cqb});
                }
                au.HU();
                long T = com.tencent.mm.model.c.FT().T(bdVar);
                x.d("MicroMsg.AppMsgLogic", g.Ac() + " msginfo insert id: " + T);
                if (T < 0) {
                    x.e("MicroMsg.AppMsgLogic", g.Ac() + "insert msg failed :" + T);
                    g.getLine();
                } else {
                    x.i("MicroMsg.AppMsgLogic", g.getLine() + " new msg inserted to db , local id = " + T);
                    bdVar.setMsgId(T);
                    com.tencent.mm.y.g gVar = new com.tencent.mm.y.g();
                    gVar.field_xml = bdVar.field_content;
                    gVar.field_title = wXMediaMessage.title;
                    gVar.field_type = wXMediaMessage.mediaObject.type();
                    gVar.field_description = wXMediaMessage.description;
                    gVar.field_msgId = T;
                    gVar.field_source = str3;
                    ao.cbY().b(gVar);
                    if (bVar2 != null) {
                        bVar2.field_msgInfoId = T;
                        bVar2.field_status = 101;
                        ao.asF().c(bVar2, new String[0]);
                        ao.cca().run();
                    } else {
                        ao.cca();
                        an.a.v(T, str10);
                    }
                }
            } else {
                l.a(otVar.bZE.bSg, otVar.bZE.appId, otVar.bZE.appName, str, otVar.bZE.bZF, otVar.bZE.bZI);
            }
        }
        return false;
    }
}

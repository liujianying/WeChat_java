package com.tencent.mm.modelsimple;

import com.tencent.mm.R;
import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.g.a.od;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.o;
import com.tencent.mm.model.q;
import com.tencent.mm.modelstat.b$b;
import com.tencent.mm.modelvoice.m;
import com.tencent.mm.modelvoice.p;
import com.tencent.mm.network.k;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.protocal.c.bhu;
import com.tencent.mm.protocal.c.bhv;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bd;
import com.tencent.mm.y.h;

public final class t extends l implements k {
    private static final ah egm = new ah("deleteRevokeMessageThread");
    private final long bJC;
    private final b dZf;
    private e diJ;
    private final String egn;

    public t(bd bdVar, String str) {
        int i;
        au.HU();
        Object obj = c.DT().get(290818, Integer.valueOf(0));
        if (obj != null) {
            i = bi.getInt(obj.toString(), 0);
        } else {
            i = 0;
        }
        this.bJC = bdVar.field_msgId;
        this.egn = str;
        String str2 = null;
        int i2 = 0;
        int i3 = (int) (bdVar.field_createTime / 1000);
        long j = bdVar.field_msgSvrId;
        String GF = q.GF();
        String str3 = bdVar.field_talker;
        if (bdVar.cGF != 1) {
            String str4;
            switch (bdVar.getType()) {
                case 1:
                case 42:
                case 48:
                case 66:
                    x.i("MicroMsg.NetSceneRevokeMsg", "[oneliang][doSendRevokeMsg] type:text,newClientMsgId:%d", new Object[]{Integer.valueOf(o.l(q.GF(), bdVar.field_createTime).hashCode())});
                    i2 = r2;
                    break;
                case 3:
                    com.tencent.mm.ak.e br = com.tencent.mm.ak.o.Pf().br(bdVar.field_msgId);
                    x.i("MicroMsg.NetSceneRevokeMsg", "[oneliang][doSendRevokeMsg] type:img,talker:%s,hdId:%s,localId:%s,clientMsgId:%s", new Object[]{bdVar.field_talker, Integer.valueOf(br.dTU), Long.valueOf(br.dTK), bdVar.cGI});
                    str2 = str4;
                    break;
                case 34:
                    p ow = m.TI().ow(bdVar.field_imgPath);
                    if (ow != null) {
                        x.i("MicroMsg.NetSceneRevokeMsg", "[oneliang][doSendRevokeMsg] type:voice,clientMsgId:%s", new Object[]{ow.clientId});
                        str2 = str4;
                        break;
                    }
                    break;
                case 43:
                case 62:
                    x.i("MicroMsg.NetSceneRevokeMsg", "[oneliang][doSendRevokeMsg] type:video,clientMsgId:%s", new Object[]{bdVar.field_imgPath});
                    str2 = str4;
                    break;
                case 47:
                    x.i("MicroMsg.NetSceneRevokeMsg", "[oneliang][doSendRevokeMsg] type:emoji,clientMsgId:%s", new Object[]{String.valueOf(an.YJ(bdVar.field_content).time)});
                    str2 = str4;
                    break;
                case 49:
                case 1048625:
                case 268435505:
                case 553648177:
                case 587202609:
                    com.tencent.mm.pluginsdk.model.app.b fH = ao.asF().fH(bdVar.field_msgId);
                    if (fH != null) {
                        str4 = fH.field_clientAppDataId;
                    } else {
                        str4 = bdVar.field_talker + bdVar.field_msgId + "T" + bdVar.field_createTime;
                    }
                    x.i("MicroMsg.NetSceneRevokeMsg", "[oneliang][doSendRevokeMsg] type:app msg/emoji/img,clientMsgId:%s", new Object[]{str4});
                    str2 = str4;
                    break;
            }
        }
        a aVar = new a();
        aVar.dIG = new bhu();
        aVar.dIH = new bhv();
        aVar.uri = "/cgi-bin/micromsg-bin/revokemsg";
        aVar.dIF = 594;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.dZf = aVar.KT();
        bhu bhu = (bhu) this.dZf.dID.dIL;
        bhu.rdo = str2;
        bhu.siB = i2;
        bhu.siC = 0;
        bhu.siE = j;
        bhu.lOH = i3;
        bhu.jTv = GF;
        bhu.jTu = str3;
        bhu.siD = i;
        x.i("MicroMsg.NetSceneRevokeMsg", "[oneliang][NetSceneRevokeMsg]:clientMsgId:%s,newClientMsgId:%d,svrMsgId:%d,createTime:%d,fromUserName:%s,toUserName:%s,indexOfRequest:%d", new Object[]{bhu.rdo, Integer.valueOf(bhu.siB), Integer.valueOf(bhu.siC), Integer.valueOf(bhu.lOH), bhu.jTv, bhu.jTu, Integer.valueOf(bhu.siD)});
    }

    public final int getType() {
        return 594;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.dZf, this);
    }

    public final void a(int i, int i2, int i3, String str, com.tencent.mm.network.q qVar, byte[] bArr) {
        if (i2 == 0 && i3 == 0) {
            au.HU();
            bd dW = c.FT().dW(this.bJC);
            if (dW.field_msgId == this.bJC) {
                bhv Rs = Rs();
                x.i("MicroMsg.NetSceneRevokeMsg", "[oneliang][doSceneEnd.revokeMsg] msgId:%s,msgSvrId:%s,responseSysWording:%s", new Object[]{Long.valueOf(dW.field_msgId), Long.valueOf(dW.field_msgSvrId), Rs.siG});
                int type = dW.getType();
                a(this.egn, "  " + ad.getContext().getString(R.l.invoke_message_reedit_tip), dW, dW.field_content);
                dW.eX(0);
                dW.eC(dW.cqa | 4);
                od odVar = new od();
                odVar.bZc.bJC = this.bJC;
                com.tencent.mm.sdk.b.a.sFg.m(odVar);
                au.HU();
                c.FT().a(dW.field_msgId, dW);
                int i4 = 0;
                au.HU();
                Object obj = c.DT().get(290818, Integer.valueOf(0));
                if (obj != null) {
                    i4 = bi.getInt(obj.toString(), 0);
                }
                i4++;
                au.HU();
                c.DT().set(290818, Integer.valueOf(i4));
                dW.setType(type);
                com.tencent.mm.modelstat.b bVar;
                if (dW.aQm()) {
                    bVar = com.tencent.mm.modelstat.b.ehL;
                    type = h.g(dW);
                    if (bVar.RS()) {
                        bVar.a(dW, b$b.revoke, type);
                    }
                } else {
                    bVar = com.tencent.mm.modelstat.b.ehL;
                    if (bVar.RS()) {
                        bVar.a(dW, b$b.revoke, 0);
                    }
                }
                egm.h(new 1(this, dW), 300000);
            } else {
                x.e("MicroMsg.NetSceneRevokeMsg", "cannot find the msg:%d after revoke.", new Object[]{Long.valueOf(this.bJC)});
            }
        }
        this.diJ.a(i2, i3, str, this);
    }

    public static void a(String str, String str2, bd bdVar, String str3) {
        if (bdVar.getType() == 1 || bdVar.getType() == 16777265) {
            bdVar.setType(10002);
            bdVar.setContent(String.format("<sysmsg type=\"invokeMessage\"><invokeMessage><text><![CDATA[%s]]></text><timestamp><![CDATA[%s]]></timestamp><link><text><![CDATA[%s]]></text></link><preContent><![CDATA[%s]]></preContent></invokeMessage></sysmsg>", new Object[]{str, Long.valueOf(System.currentTimeMillis()), str2, str3}));
            return;
        }
        bdVar.setType(10000);
        bdVar.setContent(str);
    }

    public final bhv Rs() {
        return (bhv) this.dZf.dIE.dIL;
    }
}

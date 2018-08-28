package com.tencent.mm.plugin.fav.a;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.g.a.ua;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.o;
import com.tencent.mm.model.u;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.c.bu;
import com.tencent.mm.protocal.c.bv;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class af extends l implements k {
    private final b diG;
    private e diJ = null;
    public g iWJ;

    public af(g gVar) {
        x.i("MicroMsg.Fav.NetSceneAddFav", "NetSceneAddFavItem %s", new Object[]{Long.valueOf(gVar.field_localId)});
        a aVar = new a();
        aVar.dIG = new bu();
        aVar.dIH = new bv();
        aVar.uri = "/cgi-bin/micromsg-bin/addfavitem";
        aVar.dIF = 401;
        aVar.dII = 193;
        aVar.dIJ = 1000000193;
        this.diG = aVar.KT();
        this.iWJ = gVar;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        bu buVar = (bu) this.diG.dID.dIL;
        buVar.rcc = o.l(this.iWJ.field_xml, System.currentTimeMillis());
        buVar.hcE = this.iWJ.field_type;
        buVar.rcd = this.iWJ.field_sourceType;
        this.iWJ.field_xml = g.s(this.iWJ);
        ((ae) g.n(ae.class)).getFavItemInfoStorage().a(this.iWJ, "localId");
        buVar.rcf = this.iWJ.field_xml;
        buVar.rce = this.iWJ.field_sourceId;
        this.iWJ.Bi("MicroMsg.Fav.NetSceneAddFav");
        this.diJ = eVar2;
        x.i("MicroMsg.Fav.NetSceneAddFav", "ADD FavItem, sourceId:%s localId:%d favId:%d", new Object[]{this.iWJ.field_sourceId, Long.valueOf(this.iWJ.field_localId), Integer.valueOf(this.iWJ.field_id)});
        return a(eVar, this.diG, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.Fav.NetSceneAddFav", "netId : " + i + " errType :" + i2 + " errCode: " + i3 + " errMsg :" + str);
        if ((i2 == 0 && i3 == 0) || i3 == -400) {
            bv bvVar = (bv) ((b) qVar).dIE.dIL;
            x.i("MicroMsg.Fav.NetSceneAddFav", "fav id %d, local id %d, itemStatus %d, update seq %d", new Object[]{Integer.valueOf(bvVar.rbY), Long.valueOf(this.iWJ.field_localId), Integer.valueOf(this.iWJ.field_itemStatus), Integer.valueOf(bvVar.rcb)});
            this.iWJ.field_id = bvVar.rbY;
            this.iWJ.field_localSeq = bvVar.rcb;
            if (this.iWJ.field_itemStatus == 12) {
                x.v("MicroMsg.Fav.NetSceneAddFav", "onGYNetEnd wait server upload sent");
                this.iWJ.field_itemStatus = 13;
            }
            if (this.iWJ.field_itemStatus == 9) {
                x.v("MicroMsg.Fav.NetSceneAddFav", "onGYNetEnd item done");
                this.iWJ.field_itemStatus = 10;
                ((ae) g.n(ae.class)).getFavCdnStorage().dv(this.iWJ.field_localId);
                h.mEJ.h(10659, new Object[]{Integer.valueOf(0), Integer.valueOf(this.iWJ.field_type), Integer.valueOf(0), Long.valueOf(b.b(this.iWJ)), Long.valueOf(h.dr(this.iWJ.field_localId))});
            }
            g dz = ((ae) g.n(ae.class)).getFavItemInfoStorage().dz((long) bvVar.rbY);
            if (dz != null) {
                this.iWJ.field_updateSeq = dz.field_updateSeq;
                ((ae) g.n(ae.class)).getFavItemInfoStorage().z(dz);
                x.i("MicroMsg.Fav.NetSceneAddFav", "onGYNetEnd aleady exist, delete old info, favId:%d", new Object[]{Integer.valueOf(dz.field_id)});
            }
            u.b ib = u.Hx().ib(this.iWJ.field_sessionId);
            if (!(bi.oW(this.iWJ.field_sessionId) || this.iWJ.field_type != 5 || ib == null)) {
                ua uaVar = new ua();
                uaVar.cfH.cfI = ib.getString("prePublishId", "");
                if (!(this.iWJ.field_favProto == null || this.iWJ.field_favProto.rBG == null)) {
                    uaVar.cfH.url = this.iWJ.field_favProto.rBG.egr;
                }
                if (!(!bi.oW(uaVar.cfH.url) || this.iWJ.field_favProto == null || this.iWJ.field_favProto.rAN == null || this.iWJ.field_favProto.rAN.rCn == null)) {
                    uaVar.cfH.url = this.iWJ.field_favProto.rAN.rCn;
                }
                if (bi.oW(uaVar.cfH.url)) {
                    uaVar.cfH.url = ib.getString("url", "");
                }
                uaVar.cfH.cfK = ib.getString("preUsername", "");
                uaVar.cfH.cfL = ib.getString("preChatName", "");
                uaVar.cfH.cfM = ib.getInt("preMsgIndex", 0);
                uaVar.cfH.cfQ = ib.getInt("sendAppMsgScene", 0);
                uaVar.cfH.cfR = ib.getInt("getA8KeyScene", 0);
                uaVar.cfH.cfS = ib.getString("referUrl", null);
                uaVar.cfH.cfT = ib.getString("adExtStr", null);
                uaVar.cfH.cfN = "";
                uaVar.cfH.cfO = "";
                uaVar.cfH.cfP = 0;
                uaVar.cfH.cfJ = "fav_" + com.tencent.mm.model.q.GF() + "_" + this.iWJ.field_id;
                com.tencent.mm.sdk.b.a.sFg.m(uaVar);
            }
            this.iWJ.field_sessionId = null;
            ((ae) g.n(ae.class)).getFavItemInfoStorage().a(this.iWJ, "localId");
            b.dh(bvVar.rcg);
        }
        if (i2 == 4 && i3 == -401) {
            x.i("MicroMsg.Fav.NetSceneAddFav", "fav fail, full size");
            if (this.iWJ.aLi()) {
                ((ae) g.n(ae.class)).getFavItemInfoStorage().t(16, this.iWJ.field_localId);
            } else {
                ((ae) g.n(ae.class)).getFavItemInfoStorage().t(6, this.iWJ.field_localId);
            }
        }
        b.d(this.iWJ);
        this.diJ.a(i2, i3, str, this);
    }

    public final int getType() {
        return 401;
    }
}

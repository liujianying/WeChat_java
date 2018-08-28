package com.tencent.mm.pluginsdk.model.app;

import android.graphics.BitmapFactory.Options;
import android.util.Base64;
import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.ac.f;
import com.tencent.mm.ak.o;
import com.tencent.mm.g.a.n;
import com.tencent.mm.g.a.ua;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.c;
import com.tencent.mm.model.m;
import com.tencent.mm.model.t;
import com.tencent.mm.model.u;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bke;
import com.tencent.mm.protocal.c.bkf;
import com.tencent.mm.protocal.c.bqw;
import com.tencent.mm.protocal.c.df;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.bd;
import com.tencent.mm.y.g;
import com.tencent.mm.y.h;
import java.util.Locale;

public final class aj extends l implements k {
    private long bJC = 0;
    private bd bXQ = null;
    private b diG;
    private e diJ;
    private keep_SceneResult dlU = null;
    private String fmS;
    private ua nol;
    private n qAu;
    private b qAx = null;
    private boolean qAy = false;
    private a qAz = null;

    public aj(long j, boolean z, keep_SceneResult keep_sceneresult, a aVar, String str, b bVar) {
        this.bJC = j;
        this.fmS = str;
        this.dlU = keep_sceneresult;
        this.qAz = aVar;
        this.qAy = z;
        this.qAx = bVar;
        a aVar2 = new a();
        aVar2.dIG = new bke();
        aVar2.dIH = new bkf();
        aVar2.uri = "/cgi-bin/micromsg-bin/sendappmsg";
        aVar2.dIF = 222;
        aVar2.dII = 107;
        aVar2.dIJ = 1000000107;
        this.diG = aVar2.KT();
        x.i("MicroMsg.NetSceneSendAppMsgForCdn", "summerbig NetSceneSendAppMsgForCdn msgId[%d], sceneResult[%s], sessionId[%s], attachInfo[%s]. stack[%s]", new Object[]{Long.valueOf(j), keep_sceneresult, str, bVar, bi.cjd()});
    }

    public final int getType() {
        return 222;
    }

    protected final int a(q qVar) {
        return l.b.dJm;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        au.HU();
        this.bXQ = c.FT().dW(this.bJC);
        if (this.bXQ == null || this.bXQ.field_msgId != this.bJC) {
            x.e("MicroMsg.NetSceneSendAppMsgForCdn", "summerbig cdntra doscene msginfo null id:%d", new Object[]{Long.valueOf(this.bJC)});
            this.qAz.bp(3, -1);
            return -1;
        }
        String str;
        int i;
        String string;
        g.a gp = g.a.gp(this.bXQ.field_content);
        if (gp == null) {
            x.e("MicroMsg.NetSceneSendAppMsgForCdn", "summerbig cdntra doscene AppMessage.Content.parse null id:%d", new Object[]{Long.valueOf(this.bJC)});
            this.qAz.bp(3, -1);
        }
        bke bke = (bke) this.diG.dID.dIL;
        df dfVar = new df();
        dfVar.jQb = gp.appId;
        dfVar.rdo = this.bXQ.field_talker + this.bXQ.field_msgId + "T" + this.bXQ.field_createTime;
        dfVar.lOH = (int) bi.VE();
        dfVar.jTu = this.bXQ.field_talker;
        dfVar.jTv = com.tencent.mm.model.q.GF();
        dfVar.hcE = gp.type;
        dfVar.rdn = gp.sdkVer;
        dfVar.rdq = gp.dwr;
        if (f.eZ(this.bXQ.field_talker)) {
            dfVar.rco = com.tencent.mm.ac.a.e.lg(this.bXQ.cqb);
        } else {
            dfVar.rco = bf.Ir();
        }
        dfVar.rds = gp.bZJ;
        dfVar.rdt = gp.bZK;
        dfVar.rdu = gp.bZL;
        u.b ib = u.Hx().ib(this.fmS);
        if (ib != null) {
            this.nol = new ua();
            this.nol.cfH.url = gp.url;
            this.nol.cfH.cfI = ib.getString("prePublishId", "");
            this.nol.cfH.cfK = ib.getString("preUsername", "");
            this.nol.cfH.cfL = ib.getString("preChatName", "");
            this.nol.cfH.cfM = ib.getInt("preMsgIndex", 0);
            this.nol.cfH.cfQ = ib.getInt("sendAppMsgScene", 0);
            this.nol.cfH.cfR = ib.getInt("getA8KeyScene", 0);
            this.nol.cfH.cfS = ib.getString("referUrl", null);
            this.nol.cfH.cfT = ib.getString("adExtStr", null);
            this.nol.cfH.cfN = this.bXQ.field_talker;
            this.nol.cfH.cfU = gp.title;
            au.HU();
            ab Yg = c.FR().Yg(this.bXQ.field_talker);
            if (Yg != null) {
                this.nol.cfH.cfO = Yg.BK();
            }
            this.nol.cfH.cfP = m.gK(this.bXQ.field_talker);
            str = "";
            if (gp.bZN != null) {
                bqw bqw = new bqw();
                try {
                    bqw.aG(Base64.decode(gp.bZN, 0));
                    if (bqw.soY != null) {
                        str = bqw.soY.jLY;
                    }
                } catch (Exception e) {
                }
            }
            bke.sjU = String.format(Locale.US, "prePublishId=%s&preUserName=%s&preChatName=%s&preChatType=%d&getA8KeyScene=%d&sourceAppId=%s", new Object[]{this.nol.cfH.cfI, this.nol.cfH.cfK, this.nol.cfH.cfL, Integer.valueOf(t.N(this.nol.cfH.cfK, this.nol.cfH.cfL)), Integer.valueOf(this.nol.cfH.cfR), str});
        }
        if (ib != null && gp.type == 33) {
            this.qAu = new n();
            i = ib.getInt("fromScene", 1);
            this.qAu.bGE.scene = i;
            this.qAu.bGE.bGM = ib.getInt("appservicetype", 0);
            string = ib.getString("preChatName", "");
            if (2 == i) {
                this.qAu.bGE.bGG = string + ":" + ib.getString("preUsername", "");
            } else {
                this.qAu.bGE.bGG = string;
            }
            str = this.bXQ.field_talker;
            boolean z = ib.getBoolean("moreRetrAction", false);
            if (str.endsWith("@chatroom")) {
                this.qAu.bGE.action = z ? 5 : 2;
            } else {
                this.qAu.bGE.action = z ? 4 : 1;
            }
            this.qAu.bGE.bGF = gp.dyZ + 1;
            this.qAu.bGE.bGH = gp.dyR;
            this.qAu.bGE.bGy = gp.dyS;
            this.qAu.bGE.appId = gp.dyT;
            this.qAu.bGE.bGJ = bi.VE();
            this.qAu.bGE.bGK = 1;
        }
        x.d("MicroMsg.NetSceneSendAppMsgForCdn", "stev summerbig SnsPostOperationFields: ShareUrlOriginal=%s, ShareUrlOpen=%s, JsAppId=%s", new Object[]{gp.bZJ, gp.bZK, gp.bZL});
        int i2 = 0;
        i = 0;
        if (!bi.oW(this.bXQ.field_imgPath)) {
            Options VZ = com.tencent.mm.sdk.platformtools.c.VZ(o.Pf().lN(this.bXQ.field_imgPath));
            if (VZ != null) {
                i2 = VZ.outWidth;
                i = VZ.outHeight;
            }
        }
        if (this.dlU.isUploadBySafeCDNWithMD5()) {
            x.i("MicroMsg.NetSceneSendAppMsgForCdn", "summersafecdn app sceneResult crc[%d], safecdn[%b], hitcachetype[%d], aeskey[%s]", new Object[]{Integer.valueOf(this.dlU.field_filecrc), Boolean.valueOf(this.dlU.field_upload_by_safecdn), Integer.valueOf(this.dlU.field_UploadHitCacheType), this.dlU.field_aesKey});
            this.dlU.field_aesKey = "";
            bke.sjV = 1;
        }
        bke.rmA = this.dlU.field_filecrc;
        string = null;
        if (this.qAy) {
            string = "@cdn_" + this.dlU.field_fileId + "_" + this.dlU.field_aesKey + "_1";
        }
        dfVar.jSA = g.a.a(gp, string, this.dlU, i2, i);
        bke.sjS = dfVar;
        if (this.qAx != null && (gp.dws != 0 || gp.dwo > 26214400)) {
            bke.eJK = this.qAx.field_signature;
            bke.rdY = com.tencent.mm.modelcdntran.b.dOm;
        }
        bke.rwk = gp.filemd5;
        if (bi.oW(this.dlU.field_filemd5)) {
            x.i("MicroMsg.NetSceneSendAppMsgForCdn", "summerbig sceneResult filemd5 is null use content.filemd5[%s]", new Object[]{gp.filemd5});
        } else {
            bke.rwk = this.dlU.field_filemd5;
        }
        x.i("MicroMsg.NetSceneSendAppMsgForCdn", "summerbig file md5[%s], HitMd5[%d], signature[%s], type[%d], sceneResult[%s], fromScene[%s]", new Object[]{bke.rwk, Integer.valueOf(bke.sjV), bi.Xf(bke.eJK), Integer.valueOf(bke.rdY), this.dlU, bke.sjU});
        return a(eVar, this.diG, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        bke bke = (bke) ((b) qVar).dID.dIL;
        x.i("MicroMsg.NetSceneSendAppMsgForCdn", "summerbig cdntra onGYNetEnd [%d,%d,%s] msgId:%d, oldContent[%s], newContent[%s]", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str, Long.valueOf(this.bJC), this.bXQ.field_content, bke.sjS.jSA});
        if (i2 == 0 && i3 == 0) {
            bkf bkf = (bkf) ((b) qVar).dIE.dIL;
            x.i("MicroMsg.NetSceneSendAppMsgForCdn", "summersafecdn svrid[%d]. aeskey[%s], old content[%s]", new Object[]{Long.valueOf(bkf.rcq), bkf.rmy, this.bXQ.field_content});
            if (this.dlU != null && this.dlU.isUploadBySafeCDNWithMD5()) {
                if (bi.oW(bkf.rmy)) {
                    x.w("MicroMsg.NetSceneSendAppMsgForCdn", "summersafecdn need aeskey but ret null");
                } else {
                    g.a gp = g.a.gp(this.bXQ.field_content);
                    gp.dwK = bkf.rmy;
                    this.bXQ.setContent(g.a.a(gp, null, null));
                    x.i("MicroMsg.NetSceneSendAppMsgForCdn", "summersafecdn aeskey[%s], new content[%s]", new Object[]{bkf.rmy, this.bXQ.field_content});
                }
            }
            this.bXQ.setStatus(2);
            this.bXQ.ax(bkf.rcq);
            au.HU();
            c.FT().a(this.bXQ.field_msgId, this.bXQ);
            com.tencent.mm.modelstat.b.ehL.a(this.bXQ, h.g(this.bXQ));
            this.diJ.a(i2, i3, str, this);
            this.qAz.bp(i2, i3);
            if (!(this.nol == null || bi.oW(this.nol.cfH.url))) {
                this.nol.cfH.cfJ = "msg_" + Long.toString(bkf.rcq);
                com.tencent.mm.sdk.b.a.sFg.m(this.nol);
            }
            if (this.qAu != null) {
                this.qAu.bGE.bGI = "msg_" + this.bXQ.field_msgSvrId;
                com.tencent.mm.sdk.b.a.sFg.m(this.qAu);
            }
        } else if (i2 == 4 && i3 == 102) {
            x.w("MicroMsg.NetSceneSendAppMsgForCdn", "summersafecdn MM_ERR_GET_AESKEY_FAILED");
            this.diJ.a(i2, i3, str, this);
            this.qAz.bp(i2, i3);
        } else {
            this.bXQ.setStatus(5);
            au.HU();
            c.FT().a(this.bXQ.field_msgId, this.bXQ);
            x.e("MicroMsg.NetSceneSendAppMsgForCdn", "summerbig send app msg failed, err=" + i2 + "," + i3);
            this.diJ.a(i2, i3, str, this);
            this.qAz.bp(i2, i3);
        }
    }
}

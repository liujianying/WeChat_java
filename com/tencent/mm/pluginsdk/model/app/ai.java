package com.tencent.mm.pluginsdk.model.app;

import android.support.design.a$i;
import android.util.Base64;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.ak.o;
import com.tencent.mm.g.a.n;
import com.tencent.mm.g.a.ua;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.c;
import com.tencent.mm.model.m;
import com.tencent.mm.model.q;
import com.tencent.mm.model.t;
import com.tencent.mm.model.u;
import com.tencent.mm.model.u$b;
import com.tencent.mm.modelcdntran.b;
import com.tencent.mm.modelcdntran.d;
import com.tencent.mm.modelcdntran.i;
import com.tencent.mm.modelcdntran.i.a;
import com.tencent.mm.modelcdntran.keep_ProgressInfo;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.network.k;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.c.bhy;
import com.tencent.mm.protocal.c.bke;
import com.tencent.mm.protocal.c.bkf;
import com.tencent.mm.protocal.c.bqw;
import com.tencent.mm.protocal.c.df;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bd;
import com.tencent.mm.y.g;
import java.io.ByteArrayOutputStream;
import java.net.URLEncoder;
import java.util.Locale;
import junit.framework.Assert;

public final class ai extends l implements k {
    long bJC = 0;
    bd bXQ = null;
    String dVk = "";
    private a dVu = new a() {
        public final int a(String str, int i, keep_ProgressInfo keep_progressinfo, final keep_SceneResult keep_sceneresult, boolean z) {
            x.d("MicroMsg.NetSceneSendAppMsg", "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[]{ai.this.dVk, Integer.valueOf(i), keep_progressinfo, keep_sceneresult});
            if (i == -21005) {
                x.d("MicroMsg.NetSceneSendAppMsg", "cdntra  ERR_CNDCOM_MEDIA_IS_UPLOADING clientid:%s", new Object[]{ai.this.dVk});
                return 0;
            } else if (i != 0) {
                ai.this.bXQ.setStatus(5);
                f.mDy.a(111, 34, 1, true);
                au.HU();
                c.FT().a(ai.this.bXQ.field_msgId, ai.this.bXQ);
                h.mEJ.h(10421, new Object[]{Integer.valueOf(i), Integer.valueOf(1), Long.valueOf(ai.this.startTime), Long.valueOf(bi.VF()), Integer.valueOf(d.bL(ad.getContext())), Integer.valueOf(b.MediaType_FILE), Integer.valueOf(0), ""});
                ai.this.diJ.a(3, i, "", ai.this);
                return 0;
            } else {
                if (keep_sceneresult != null) {
                    if (keep_sceneresult.field_retCode != 0) {
                        x.e("MicroMsg.NetSceneSendAppMsg", "cdntra sceneResult.retCode :%d arg[%s] info[%s]", new Object[]{Integer.valueOf(keep_sceneresult.field_retCode), keep_sceneresult.field_arg, keep_sceneresult.field_transInfo, "", "", "", "", "", "", "", keep_sceneresult.report_Part2});
                        ai.this.bXQ.setStatus(5);
                        f.mDy.a(111, 34, 1, true);
                        au.HU();
                        c.FT().a(ai.this.bXQ.field_msgId, ai.this.bXQ);
                        h.mEJ.h(10421, new Object[]{Integer.valueOf(keep_sceneresult.field_retCode), Integer.valueOf(1), Long.valueOf(ai.this.startTime), Long.valueOf(bi.VF()), Integer.valueOf(d.bL(ad.getContext())), Integer.valueOf(b.MediaType_FILE), Integer.valueOf(keep_sceneresult.field_fileLength), keep_sceneresult.field_transInfo, "", "", "", "", "", "", "", keep_sceneresult.report_Part2});
                        h.mEJ.h(13937, new Object[]{Integer.valueOf(keep_sceneresult.field_retCode), Integer.valueOf(1), Long.valueOf(ai.this.startTime), Long.valueOf(bi.VF()), Integer.valueOf(d.bL(ad.getContext())), Integer.valueOf(b.MediaType_FILE), Integer.valueOf(keep_sceneresult.field_fileLength), keep_sceneresult.field_transInfo, "", "", "", "", "", "", "", keep_sceneresult.report_Part2});
                        ai.this.diJ.a(3, keep_sceneresult.field_retCode, "", ai.this);
                    } else {
                        if (ai.this.emx > 0 && keep_sceneresult.field_fileLength > 0) {
                            ak.r("SendAppMsgThumbTooBig", ai.this.emx + "," + keep_sceneresult.field_fileLength + "," + keep_sceneresult.field_fileId, ai.this.emx * 2 > keep_sceneresult.field_fileLength);
                        }
                        x.i("MicroMsg.NetSceneSendAppMsg", "summersafecdn cdnCallback upload attach by cdn, isHitCacheUpload: %d, onlyCheckExist[%b], exist[%b], aesKey[%s], md5[%s]", new Object[]{Integer.valueOf(keep_sceneresult.field_UploadHitCacheType), Boolean.valueOf(z), Boolean.valueOf(keep_sceneresult.field_exist_whencheck), bi.Xf(keep_sceneresult.field_aesKey), keep_sceneresult.field_filemd5});
                        au.DF().a(new aj(ai.this.bJC, false, keep_sceneresult, new aj.a() {
                            public final void bp(int i, int i2) {
                                x.d("MicroMsg.NetSceneSendAppMsg", "summersafecdn cdntra NetSceneSendAppMsgForCdn callback %d,%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
                                h.mEJ.h(10421, new Object[]{Integer.valueOf(i2), Integer.valueOf(1), Long.valueOf(ai.this.startTime), Long.valueOf(bi.VF()), Integer.valueOf(d.bL(ad.getContext())), Integer.valueOf(b.MediaType_FILE), Integer.valueOf(keep_sceneresult.field_fileLength), keep_sceneresult.field_transInfo, "", "", "", "", "", "", "", keep_sceneresult.report_Part2});
                                ai.this.diJ.a(i, i2, "", ai.this);
                            }
                        }, ai.this.fmS, null), 0);
                    }
                }
                return 0;
            }
        }

        public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
        }

        public final byte[] i(String str, byte[] bArr) {
            return null;
        }
    };
    private com.tencent.mm.ab.b diG;
    e diJ;
    int emx = 0;
    String fmS;
    private ua nol;
    private String ogj;
    private n qAu;
    long startTime = 0;

    public ai(long j, String str, String str2) {
        this.bJC = j;
        this.fmS = str;
        this.ogj = str2;
        com.tencent.mm.ab.b.a aVar = new com.tencent.mm.ab.b.a();
        aVar.dIG = new bke();
        aVar.dIH = new bkf();
        aVar.uri = "/cgi-bin/micromsg-bin/sendappmsg";
        aVar.dIF = 222;
        aVar.dII = a$i.AppCompatTheme_ratingBarStyleIndicator;
        aVar.dIJ = 1000000107;
        this.diG = aVar.KT();
        x.i("MicroMsg.NetSceneSendAppMsg", "summersafecdn NetSceneSendAppMsg msgid[%d], sessionid[%s], signature[%s], stack[%s]", new Object[]{Long.valueOf(j), str, bi.Xf(str2), bi.cjd()});
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        if (this.startTime == 0) {
            this.startTime = bi.VF();
        }
        au.HU();
        this.bXQ = c.FT().dW(this.bJC);
        if (this.bXQ == null || this.bXQ.field_msgId != this.bJC) {
            return -1;
        }
        g.a aVar;
        g.a gp = g.a.gp(this.bXQ.field_content);
        if (gp == null) {
            an YJ = an.YJ(this.bXQ.field_content);
            if (bi.oW(YJ.taT)) {
                gp = new g.a();
                gp.dwq = YJ.bKg;
                gp.type = 8;
                x.i("MicroMsg.NetSceneSendAppMsg", "create new content. loss appid");
                aVar = gp;
            } else {
                aVar = g.a.gp(YJ.taT);
            }
        } else {
            aVar = gp;
        }
        Assert.assertTrue("content != null [[" + this.bXQ.field_content + "]]", aVar != null);
        if (aVar == null) {
            this.bXQ = null;
            return -1;
        }
        String str;
        Object obj;
        String str2 = "";
        if (bi.oW(this.bXQ.field_imgPath)) {
            str = str2;
        } else {
            str = o.Pf().lN(this.bXQ.field_imgPath);
        }
        if (aVar.type == 8 || aVar.type == 9 || aVar.type == 6) {
            x.i("MicroMsg.NetSceneSendAppMsg", "cdntra cdn not support Emoji or voiceremind now type:%d", new Object[]{Integer.valueOf(aVar.type)});
            obj = null;
        } else if (bi.oW(str)) {
            x.i("MicroMsg.NetSceneSendAppMsg", "cdntra cdn not support no thumb msg type:%d", new Object[]{Integer.valueOf(aVar.type)});
            obj = null;
        } else {
            this.emx = com.tencent.mm.a.e.cm(str);
            if (aVar.type == 33 || aVar.type == 36 || this.emx < 262144) {
                x.i("MicroMsg.NetSceneSendAppMsg", "cdntra content.type:%d  thumbPath:%s,  thumbLength:%d ", new Object[]{Integer.valueOf(aVar.type), str, Integer.valueOf(this.emx)});
                if (bi.oW(aVar.bGP)) {
                    com.tencent.mm.modelcdntran.g.ND();
                    if (com.tencent.mm.modelcdntran.c.hz(4)) {
                        this.dVk = d.a("upappmsg", this.bXQ.field_createTime, this.bXQ.field_talker, this.bXQ.field_msgId);
                        if (bi.oW(this.dVk)) {
                            x.w("MicroMsg.NetSceneSendAppMsg", "cdntra genClientId failed not use cdn msgid:%d", new Object[]{Long.valueOf(this.bXQ.field_msgId)});
                            obj = null;
                        } else {
                            i iVar = new i();
                            iVar.dPV = this.dVu;
                            iVar.field_mediaId = this.dVk;
                            iVar.field_fullpath = "";
                            iVar.field_thumbpath = str;
                            iVar.field_fileType = b.MediaType_THUMBIMAGE;
                            iVar.field_talker = this.bXQ.field_talker;
                            iVar.field_priority = b.dOk;
                            iVar.field_needStorage = false;
                            iVar.field_isStreamMedia = false;
                            iVar.dPV = this.dVu;
                            iVar.field_force_aeskeycdn = true;
                            iVar.field_trysafecdn = false;
                            x.i("MicroMsg.NetSceneSendAppMsg", "summersafecdn cdntra checkUseCdn content.type[%d], thumb[%s], useCdnTransClientId[%s], fileType[%d], enable_hitcheck[%b], onlycheckexist[%b], force_aeskeycdn[%b], trysafecdn[%b]", new Object[]{Integer.valueOf(aVar.type), str, this.dVk, Integer.valueOf(iVar.field_fileType), Boolean.valueOf(iVar.field_enable_hitcheck), Boolean.valueOf(iVar.field_onlycheckexist), Boolean.valueOf(iVar.field_force_aeskeycdn), Boolean.valueOf(iVar.field_trysafecdn)});
                            if (com.tencent.mm.modelcdntran.g.ND().c(iVar)) {
                                obj = 1;
                            } else {
                                x.e("MicroMsg.NetSceneSendAppMsg", "cdntra addSendTask failed.");
                                this.dVk = "";
                                obj = null;
                            }
                        }
                    } else {
                        Object[] objArr = new Object[1];
                        com.tencent.mm.modelcdntran.g.ND();
                        objArr[0] = Boolean.valueOf(com.tencent.mm.modelcdntran.c.hz(4));
                        x.w("MicroMsg.NetSceneSendAppMsg", "cdntra not use cdn flag:%b ", objArr);
                        obj = null;
                    }
                } else {
                    x.w("MicroMsg.NetSceneSendAppMsg", "cdntra attach has been upload by cdn msgid:%d", new Object[]{Long.valueOf(this.bJC)});
                    obj = null;
                }
            } else {
                x.w("MicroMsg.NetSceneSendAppMsg", "cdntra thumb[%s][%d] Too Big Not Use CDN TRANS", new Object[]{str, Integer.valueOf(this.emx)});
                obj = null;
            }
        }
        if (obj != null) {
            x.d("MicroMsg.NetSceneSendAppMsg", "cdntra use cdn return -1 for onGYNetEnd clientId:%s", new Object[]{this.dVk});
            return 0;
        }
        String str3;
        bke bke = (bke) this.diG.dID.dIL;
        df dfVar = new df();
        dfVar.jQb = aVar.appId;
        dfVar.rdo = this.bXQ.field_talker + this.bXQ.field_msgId + "T" + this.bXQ.field_createTime;
        dfVar.jSA = g.a.a(aVar, null, null, 0, 0);
        dfVar.lOH = (int) bi.VE();
        dfVar.jTu = this.bXQ.field_talker;
        dfVar.jTv = q.GF();
        dfVar.hcE = aVar.type;
        dfVar.rdn = aVar.sdkVer;
        dfVar.rdq = aVar.dwr;
        if (com.tencent.mm.ac.f.eZ(this.bXQ.field_talker)) {
            dfVar.rco = com.tencent.mm.ac.a.e.lg(this.bXQ.cqb);
        } else {
            dfVar.rco = bf.Ir();
        }
        dfVar.rds = aVar.bZJ;
        dfVar.rdt = aVar.bZK;
        dfVar.rdu = aVar.bZL;
        u$b ib = u.Hx().ib(this.fmS);
        if (ib != null) {
            this.nol = new ua();
            this.nol.cfH.url = aVar.url;
            this.nol.cfH.cfI = ib.getString("prePublishId", "");
            this.nol.cfH.cfK = ib.getString("preUsername", "");
            this.nol.cfH.cfL = ib.getString("preChatName", "");
            this.nol.cfH.cfM = ib.getInt("preMsgIndex", 0);
            this.nol.cfH.cfQ = ib.getInt("sendAppMsgScene", 0);
            this.nol.cfH.cfR = ib.getInt("getA8KeyScene", 0);
            this.nol.cfH.cfS = ib.getString("referUrl", null);
            this.nol.cfH.cfT = ib.getString("adExtStr", null);
            this.nol.cfH.cfN = this.bXQ.field_talker;
            this.nol.cfH.cfU = aVar.title;
            au.HU();
            ab Yg = c.FR().Yg(this.bXQ.field_talker);
            if (Yg != null) {
                this.nol.cfH.cfO = Yg.BK();
            }
            this.nol.cfH.cfP = m.gK(this.bXQ.field_talker);
            str3 = "";
            if (aVar.bZN != null) {
                bqw bqw = new bqw();
                try {
                    bqw.aG(Base64.decode(aVar.bZN, 0));
                    if (bqw.soY != null) {
                        str3 = bqw.soY.jLY;
                    }
                } catch (Exception e) {
                }
            }
            bke.sjU = String.format(Locale.US, "prePublishId=%s&preUserName=%s&preChatName=%s&preChatType=%d&getA8KeyScene=%d&sourceAppId=%s", new Object[]{this.nol.cfH.cfI, this.nol.cfH.cfK, this.nol.cfH.cfL, Integer.valueOf(t.N(this.nol.cfH.cfK, this.nol.cfH.cfL)), Integer.valueOf(this.nol.cfH.cfR), str3});
        }
        if (ib != null && aVar.type == 33) {
            this.qAu = new n();
            int i = ib.getInt("fromScene", 1);
            this.qAu.bGE.scene = i;
            this.qAu.bGE.bGM = ib.getInt("appservicetype", 0);
            String string = ib.getString("preChatName", "");
            if (2 == i) {
                this.qAu.bGE.bGG = string + ":" + ib.getString("preUsername", "");
            } else {
                this.qAu.bGE.bGG = string;
            }
            str3 = this.bXQ.field_talker;
            boolean z = ib.getBoolean("moreRetrAction", false);
            if (str3.endsWith("@chatroom")) {
                this.qAu.bGE.action = z ? 5 : 2;
            } else {
                this.qAu.bGE.action = z ? 4 : 1;
            }
            this.qAu.bGE.bGF = aVar.dyZ + 1;
            this.qAu.bGE.bGH = aVar.dyR;
            this.qAu.bGE.bGy = aVar.dyS;
            this.qAu.bGE.appId = aVar.dyT;
            this.qAu.bGE.bGJ = bi.VE();
            this.qAu.bGE.bGK = 1;
        }
        x.d("MicroMsg.NetSceneSendAppMsg", "SnsPostOperationFields: ShareUrlOriginal=%s, ShareUrlOpen=%s, JsAppId=%s", new Object[]{aVar.bZJ, aVar.bZK, aVar.bZL});
        if (!bi.oW(str)) {
            byte[] e2 = com.tencent.mm.a.e.e(str, 0, -1);
            if (!bi.bC(e2)) {
                dfVar.rdp = new bhy().bq(e2);
            }
        }
        str3 = "MicroMsg.NetSceneSendAppMsg";
        String str4 = "doScene thumbFile:[%s] thumbdata:%d";
        Object[] objArr2 = new Object[2];
        objArr2[0] = str;
        objArr2[1] = Integer.valueOf(dfVar.rdp != null ? dfVar.rdp.siI : -1);
        x.d(str3, str4, objArr2);
        bke.sjS = dfVar;
        if (aVar.dws != 0 || aVar.dwo > 26214400) {
            bke.rdY = b.dOm;
        }
        bke.rwk = aVar.filemd5;
        bke.eJK = this.ogj;
        x.i("MicroMsg.NetSceneSendAppMsg", "summersafecdn file md5[%s], signature[%s], type[%d], fromScene[%s]", new Object[]{bke.rwk, bi.Xf(bke.eJK), Integer.valueOf(bke.rdY), bke.sjU});
        return a(eVar, this.diG, this);
    }

    public final void a(int i, int i2, int i3, String str, com.tencent.mm.network.q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneSendAppMsg", "summersafecdn cdntra onGYNetEnd [%d,%d,%s] msgId:%d, oldContent[%s]", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str, Long.valueOf(this.bJC), this.bXQ.field_content});
        if (i2 == 3 && i3 == -1 && !bi.oW(this.dVk)) {
            x.w("MicroMsg.NetSceneSendAppMsg", "cdntra using cdn trans,  wait cdn service callback! clientid:%s", new Object[]{this.dVk});
        } else if (i2 == 0 && i3 == 0) {
            bkf bkf = (bkf) ((com.tencent.mm.ab.b) qVar).dIE.dIL;
            bke bke = (bke) ((com.tencent.mm.ab.b) qVar).dID.dIL;
            this.bXQ.setStatus(2);
            this.bXQ.ax(bkf.rcq);
            au.HU();
            c.FT().a(this.bXQ.field_msgId, this.bXQ);
            com.tencent.mm.modelstat.b.ehL.a(this.bXQ, com.tencent.mm.y.h.g(this.bXQ));
            if (!(this.nol == null || bi.oW(this.nol.cfH.url))) {
                this.nol.cfH.cfJ = "msg_" + Long.toString(bkf.rcq);
                com.tencent.mm.sdk.b.a.sFg.m(this.nol);
            }
            g.a gp = g.a.gp(this.bXQ.field_content);
            if (gp != null && "wx4310bbd51be7d979".equals(gp.appId)) {
                Object obj = (bi.oW(this.bXQ.field_talker) || !this.bXQ.field_talker.endsWith("@chatroom")) ? null : 1;
                String str2 = "";
                try {
                    str2 = URLEncoder.encode(gp.description, "UTF-8");
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.NetSceneSendAppMsg", e, "", new Object[0]);
                }
                x.i("MicroMsg.NetSceneSendAppMsg", "androidSystemShareFixed(13717) %s", new Object[]{"1," + (obj != null ? 2 : 1) + ",," + str2});
                h.mEJ.k(13717, r0);
            }
            if (this.qAu != null) {
                this.qAu.bGE.bGI = "msg_" + this.bXQ.field_msgSvrId;
                com.tencent.mm.sdk.b.a.sFg.m(this.qAu);
            }
            if (bke.sjS.rdp != null) {
                h.mEJ.h(10420, new Object[]{Integer.valueOf(0), Integer.valueOf(1), Long.valueOf(this.startTime), Long.valueOf(bi.VF()), Integer.valueOf(d.bL(ad.getContext())), Integer.valueOf(b.MediaType_THUMBIMAGE), Integer.valueOf(bke.sjS.rdp.siI)});
            }
            this.diJ.a(i2, i3, str, this);
        } else {
            this.bXQ.setStatus(5);
            f.mDy.a(111, 34, 1, true);
            au.HU();
            c.FT().a(this.bXQ.field_msgId, this.bXQ);
            x.e("MicroMsg.NetSceneSendAppMsg", "send app msg failed, err=" + i2 + "," + i3 + ", msgId " + this.bXQ.field_msgId);
            if (i2 == 4) {
                h.mEJ.h(10420, new Object[]{Integer.valueOf(i3), Integer.valueOf(1), Long.valueOf(this.startTime), Long.valueOf(bi.VF()), Integer.valueOf(d.bL(ad.getContext())), Integer.valueOf(b.MediaType_THUMBIMAGE), Integer.valueOf(0)});
            }
            this.diJ.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 222;
    }

    protected final int a(com.tencent.mm.network.q qVar) {
        return l.b.dJm;
    }
}

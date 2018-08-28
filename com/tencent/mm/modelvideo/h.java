package com.tencent.mm.modelvideo;

import android.graphics.BitmapFactory.Options;
import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.q;
import com.tencent.mm.model.s;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.network.ab;
import com.tencent.mm.network.k;
import com.tencent.mm.platformtools.af;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.protocal.c.bhy;
import com.tencent.mm.protocal.c.bri;
import com.tencent.mm.protocal.c.bwq;
import com.tencent.mm.protocal.c.bwr;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.c;
import com.tencent.mm.sdk.platformtools.x;
import junit.framework.Assert;

public final class h extends l implements k {
    private b diG;
    private e diJ;
    private int emD = 0;
    private keep_SceneResult emE = null;
    private a emF = null;
    String fileName = null;

    public h(String str, int i, keep_SceneResult keep_sceneresult, a aVar) {
        boolean z = false;
        Assert.assertTrue(str != null);
        if (keep_sceneresult != null) {
            z = true;
        }
        Assert.assertTrue(z);
        Assert.assertTrue(true);
        this.fileName = str;
        this.emE = keep_sceneresult;
        this.emF = aVar;
        this.emD = i;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        r nW = t.nW(this.fileName);
        if (nW == null) {
            x.e("MicroMsg.NetSceneUploadVideoForCdn", "Get info Failed file:" + this.fileName);
            this.emF.bp(3, -1);
            return -1;
        }
        String Ir;
        int i;
        String str;
        String str2;
        Object[] objArr;
        a aVar = new a();
        aVar.dIG = new bwq();
        aVar.dIH = new bwr();
        aVar.uri = "/cgi-bin/micromsg-bin/uploadvideo";
        aVar.dIF = 149;
        aVar.dII = 39;
        aVar.dIJ = 1000000039;
        this.diG = aVar.KT();
        bwq bwq = (bwq) this.diG.dID.dIL;
        bwq.ssR = 0;
        bwq.ssQ = this.emE.field_fileLength;
        bwq.ssS = new bhy().bq(new byte[0]);
        bwq.rVq = 0;
        bwq.rVp = this.emE.field_thumbimgLength;
        bwq.rVr = new bhy().bq(new byte[0]);
        bwq.jTv = q.GF();
        bwq.jTu = this.emE.field_toUser;
        bwq.rdo = this.fileName;
        if (nW.enQ == 1) {
            bwq.ssT = 2;
        }
        if (nW.enT == 3) {
            bwq.ssT = 3;
        }
        bwq.slf = nW.enM;
        bwq.rvT = ab.bU(ad.getContext()) ? 1 : 2;
        bwq.rVs = 2;
        bwq.ssI = this.emE.field_thumbimgLength;
        bwq.ssU = this.emE.field_fileId;
        bwq.rPP = this.emE.field_fileId;
        bwq.rmz = 1;
        if (this.emE.isUploadBySafeCDNWithMD5()) {
            x.i("MicroMsg.NetSceneUploadVideoForCdn", "%s summersafecdn isUploadBySafeCDNWithMD5 field_upload_by_safecdn[%b], field_UploadHitCacheType[%d], crc[%d], aeskey[%s]", SR(), Boolean.valueOf(this.emE.field_upload_by_safecdn), Integer.valueOf(this.emE.field_UploadHitCacheType), Integer.valueOf(this.emE.field_filecrc), this.emE.field_aesKey);
            bwq.sjV = 1;
            bwq.rmy = "";
            bwq.rPR = "";
        } else {
            bwq.rmy = this.emE.field_aesKey;
            bwq.rPR = this.emE.field_aesKey;
        }
        bwq.ssW = this.emE.field_filemd5;
        bwq.stg = this.emE.field_mp4identifymd5;
        bwq.rmA = this.emE.field_filecrc;
        if (this.emD <= 0 || this.emD > 1048576) {
            Ir = bf.Ir();
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("<msgsource>");
            stringBuilder.append("<videopreloadlen>").append(this.emD).append("</videopreloadlen>");
            stringBuilder.append("</msgsource>");
            com.tencent.mm.plugin.report.service.h.mEJ.a(354, 35, 1, false);
            Ir = stringBuilder.toString();
        }
        bwq.rco = Ir;
        bwq.stf = nW.bZN;
        bri bri = nW.enV;
        if (bri != null && !bi.oW(bri.dyJ)) {
            bwq.ssX = bi.aG(bri.dyJ, "");
            bwq.ssY = bri.rBq;
            bwq.ssZ = bi.aG(bri.dyL, "");
            bwq.stb = bi.aG(bri.dyN, "");
            bwq.sta = bi.aG(bri.dyM, "");
            bwq.stc = bi.aG(bri.dyO, "");
        } else if (!(bri == null || bi.oW(bri.dyN) || bi.oW(bri.dyM))) {
            bwq.stb = bri.dyN;
            bwq.sta = bri.dyM;
        }
        if (bri != null) {
            bwq.ste = bi.aG(bri.dyP, "");
            bwq.std = bi.aG(bri.dyQ, "");
        }
        o.Ta();
        Options VZ = c.VZ(s.nL(this.fileName));
        if (VZ != null) {
            bwq.ssK = VZ.outWidth;
            bwq.ssJ = VZ.outHeight;
        } else {
            x.w("MicroMsg.NetSceneUploadVideoForCdn", "cdntra getImageOptions for thumb failed path:%s", Ir);
        }
        o.Ta();
        Ir = s.nK(this.fileName);
        n SY = n.SY();
        if (!bi.oW(Ir)) {
            n.a aVar2 = (n.a) SY.ena.get(Ir);
            if (aVar2 != null) {
                i = aVar2.ens;
                switch (i) {
                    case 1:
                        bwq.rmB = 1;
                        bwq.rdq = 2;
                        break;
                    case 2:
                        bwq.rmB = 1;
                        bwq.rdq = 1;
                        break;
                    case 3:
                    case 6:
                        bwq.rmB = 2;
                        bwq.rdq = 3;
                        break;
                    case 7:
                        bwq.rmB = 3;
                        bwq.rdq = 4;
                        break;
                    case 8:
                        bwq.rmB = 1;
                        bwq.rdq = 5;
                        break;
                    default:
                        bwq.rmB = 0;
                        bwq.rdq = 0;
                        break;
                }
                str = "MicroMsg.NetSceneUploadVideoForCdn";
                str2 = "%s summersafecdn cdntra doscene file:%s touser:%s aes:%d fileid:%s thumb:[%d %d %d], thumbaeskey [%s] funcFlag: %d, md5:%s HitMd5:%d CRC32:%d, VideoNewMd5:%s AESKey:%s stream %s streamtime: %d title %s thumburl %s msgSource[%s] msgForwardType[%d] Source[%d]";
                objArr = new Object[22];
                objArr[0] = SR();
                objArr[1] = this.fileName;
                objArr[2] = this.emE.field_toUser;
                if (this.emE.field_aesKey != null) {
                    i = -1;
                } else {
                    i = this.emE.field_aesKey.length();
                }
                objArr[3] = Integer.valueOf(i);
                objArr[4] = this.emE.field_fileId;
                objArr[5] = Integer.valueOf(this.emE.field_thumbimgLength);
                objArr[6] = Integer.valueOf(bwq.ssK);
                objArr[7] = Integer.valueOf(bwq.ssJ);
                objArr[8] = bi.Xf(bwq.rPR);
                objArr[9] = Integer.valueOf(bwq.ssT);
                objArr[10] = bwq.ssW;
                objArr[11] = Integer.valueOf(bwq.sjV);
                objArr[12] = Integer.valueOf(bwq.rmA);
                objArr[13] = bwq.stg;
                objArr[14] = bi.Xf(bwq.rmy);
                objArr[15] = bwq.ssX;
                objArr[16] = Integer.valueOf(bwq.ssY);
                objArr[17] = bwq.ssZ;
                objArr[18] = bwq.stc;
                objArr[19] = bwq.rco;
                objArr[20] = Integer.valueOf(bwq.rmB);
                objArr[21] = Integer.valueOf(bwq.rdq);
                x.i(str, str2, objArr);
                return a(eVar, this.diG, this);
            }
        }
        i = 0;
        switch (i) {
            case 1:
                bwq.rmB = 1;
                bwq.rdq = 2;
                break;
            case 2:
                bwq.rmB = 1;
                bwq.rdq = 1;
                break;
            case 3:
            case 6:
                bwq.rmB = 2;
                bwq.rdq = 3;
                break;
            case 7:
                bwq.rmB = 3;
                bwq.rdq = 4;
                break;
            case 8:
                bwq.rmB = 1;
                bwq.rdq = 5;
                break;
            default:
                bwq.rmB = 0;
                bwq.rdq = 0;
                break;
        }
        str = "MicroMsg.NetSceneUploadVideoForCdn";
        str2 = "%s summersafecdn cdntra doscene file:%s touser:%s aes:%d fileid:%s thumb:[%d %d %d], thumbaeskey [%s] funcFlag: %d, md5:%s HitMd5:%d CRC32:%d, VideoNewMd5:%s AESKey:%s stream %s streamtime: %d title %s thumburl %s msgSource[%s] msgForwardType[%d] Source[%d]";
        objArr = new Object[22];
        objArr[0] = SR();
        objArr[1] = this.fileName;
        objArr[2] = this.emE.field_toUser;
        if (this.emE.field_aesKey != null) {
            i = this.emE.field_aesKey.length();
        } else {
            i = -1;
        }
        objArr[3] = Integer.valueOf(i);
        objArr[4] = this.emE.field_fileId;
        objArr[5] = Integer.valueOf(this.emE.field_thumbimgLength);
        objArr[6] = Integer.valueOf(bwq.ssK);
        objArr[7] = Integer.valueOf(bwq.ssJ);
        objArr[8] = bi.Xf(bwq.rPR);
        objArr[9] = Integer.valueOf(bwq.ssT);
        objArr[10] = bwq.ssW;
        objArr[11] = Integer.valueOf(bwq.sjV);
        objArr[12] = Integer.valueOf(bwq.rmA);
        objArr[13] = bwq.stg;
        objArr[14] = bi.Xf(bwq.rmy);
        objArr[15] = bwq.ssX;
        objArr[16] = Integer.valueOf(bwq.ssY);
        objArr[17] = bwq.ssZ;
        objArr[18] = bwq.stc;
        objArr[19] = bwq.rco;
        objArr[20] = Integer.valueOf(bwq.rmB);
        objArr[21] = Integer.valueOf(bwq.rdq);
        x.i(str, str2, objArr);
        return a(eVar, this.diG, this);
    }

    protected final int a(com.tencent.mm.network.q qVar) {
        return b.dJm;
    }

    protected final int Cc() {
        return 1;
    }

    protected final void a(a aVar) {
        t.nP(this.fileName);
    }

    public final void a(int i, int i2, int i3, String str, com.tencent.mm.network.q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneUploadVideoForCdn", "%s cdntra onGYNetEnd errtype[%d %d]", SR(), Integer.valueOf(i2), Integer.valueOf(i3));
        bwr bwr = (bwr) ((b) qVar).dIE.dIL;
        r nW = t.nW(this.fileName);
        if (nW == null) {
            x.e("MicroMsg.NetSceneUploadVideoForCdn", "ERR: onGYNetEnd Get INFO FAILED :" + this.fileName);
            this.diJ.a(i2, i3, str, this);
            this.emF.bp(3, -1);
        } else if (i2 == 4 && i3 == 102) {
            x.e("MicroMsg.NetSceneUploadVideoForCdn", "summersafecdn ERR: MM_ERR_GET_AESKEY_FAILED errtype:" + i2 + " errCode:" + i3 + "  file:" + this.fileName + " user:" + nW.Tj());
            this.diJ.a(i2, i3, str, this);
            this.emF.bp(i2, i3);
        } else if (i2 == 4 && i3 == -22) {
            x.e("MicroMsg.NetSceneUploadVideoForCdn", "ERR: onGYNetEnd BLACK  errtype:" + i2 + " errCode:" + i3 + "  file:" + this.fileName + " user:" + nW.Tj());
            t.nQ(this.fileName);
            this.diJ.a(i2, i3, str, this);
            this.emF.bp(i2, i3);
        } else if (i2 == 4 && i3 != 0) {
            x.e("MicroMsg.NetSceneUploadVideoForCdn", "ERR: onGYNetEnd SERVER FAILED errtype:" + i2 + " errCode:" + i3 + "  file:" + this.fileName + " user:" + nW.Tj());
            t.nP(this.fileName);
            this.diJ.a(i2, i3, str, this);
            this.emF.bp(i2, i3);
        } else if (i2 == 0 && i3 == 0) {
            nW.enK = bi.VE();
            nW.bYu = bwr.rcq;
            x.i("MicroMsg.NetSceneUploadVideoForCdn", "%s dkmsgid  set svrmsgid %d -> %d", SR(), Long.valueOf(nW.bYu), Integer.valueOf(af.exn));
            if (!(10007 != af.exm || af.exn == 0 || nW.bYu == 0)) {
                nW.bYu = (long) af.exn;
                af.exn = 0;
            }
            nW.status = 199;
            nW.bWA = 1284;
            if (this.emE.isUploadBySafeCDNWithMD5()) {
                x.i("MicroMsg.NetSceneUploadVideoForCdn", "%s summersafecdn aeskey[%s], old RecvXml[%s]", SR(), bwr.rmy, nW.Tm());
                if (bi.oW(bwr.rmy)) {
                    x.w("MicroMsg.NetSceneUploadVideoForCdn", "%s summersafecdn need aeskey but ret null", SR());
                } else {
                    x.i("MicroMsg.NetSceneUploadVideoForCdn", "cdn callback new build cdnInfo:%s", ((("<msg><videomsg aeskey=\"" + bwr.rmy + "\" cdnthumbaeskey=\"" + bwr.rmy + "\" cdnvideourl=\"" + this.emE.field_fileId + "\" ") + "cdnthumburl=\"" + this.emE.field_fileId + "\" ") + "length=\"" + this.emE.field_fileLength + "\" ") + "cdnthumblength=\"" + this.emE.field_thumbimgLength + "\"/></msg>");
                    nW.enS = r1;
                    s Ta = o.Ta();
                    o.Ta();
                    boolean r = Ta.r(s.nK(this.fileName), this.emE.field_fileId, bwr.rmy);
                    com.tencent.mm.plugin.report.service.h hVar = com.tencent.mm.plugin.report.service.h.mEJ;
                    Object[] objArr = new Object[2];
                    objArr[0] = Integer.valueOf((r ? 1 : 2) + 900);
                    objArr[1] = Integer.valueOf(nW.dHI);
                    hVar.h(12696, objArr);
                    x.i("MicroMsg.NetSceneUploadVideoForCdn", "%s summersafecdn aeskey[%s], new RecvXml[%s], saveret[%b]", SR(), bwr.rmy, nW.Tm(), Boolean.valueOf(r));
                }
            }
            t.e(nW);
            t.c(nW);
            com.tencent.mm.modelstat.b.ehL.f(((i) g.l(i.class)).bcY().dW((long) nW.enN));
            com.tencent.mm.l.a Yg = ((i) g.l(i.class)).FR().Yg(nW.Tj());
            boolean ckW = (Yg == null || ((int) Yg.dhP) <= 0) ? false : Yg.ckW();
            if (ckW || s.hr(nW.Tj())) {
                x.i("MicroMsg.NetSceneUploadVideoForCdn", "%s upload to biz :%s", SR(), nW.Tj());
                if (nW.bYu < 0) {
                    x.e("MicroMsg.NetSceneUploadVideoForCdn", "ERR: finish video invaild MSGSVRID :" + nW.bYu + " file:" + this.fileName + " toUser:" + nW.Tj());
                    t.nP(this.fileName);
                    this.emF.bp(3, -1);
                }
            } else {
                x.i("MicroMsg.NetSceneUploadVideoForCdn", "%s not upload to biz", SR());
                if (nW.bYu <= 0) {
                    x.e("MicroMsg.NetSceneUploadVideoForCdn", "ERR: finish video invaild MSGSVRID :" + nW.bYu + " file:" + this.fileName + " toUser:" + nW.Tj());
                    t.nP(this.fileName);
                    this.emF.bp(3, -1);
                }
            }
            this.diJ.a(i2, i3, str, this);
            this.emF.bp(0, 0);
        } else {
            x.e("MicroMsg.NetSceneUploadVideoForCdn", "ERR: onGYNetEnd FAILED (WILL RETRY) errtype:" + i2 + " errCode:" + i3 + "  file:" + this.fileName + " user:" + nW.Tj());
            t.nP(this.fileName);
            this.diJ.a(i2, i3, str, this);
            this.emF.bp(i2, i3);
        }
    }

    public final int getType() {
        return 149;
    }

    private String SR() {
        return this.fileName + "_" + hashCode();
    }
}

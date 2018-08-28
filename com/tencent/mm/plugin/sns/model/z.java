package com.tencent.mm.plugin.sns.model;

import android.graphics.BitmapFactory.Options;
import com.tencent.mm.a.g;
import com.tencent.mm.ab.b;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.modelcdntran.c;
import com.tencent.mm.modelcdntran.i.a;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.af;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.storage.r;
import com.tencent.mm.plugin.sns.storage.s;
import com.tencent.mm.protocal.c.atb;
import com.tencent.mm.protocal.c.ath;
import com.tencent.mm.protocal.c.bhy;
import com.tencent.mm.protocal.c.bok;
import com.tencent.mm.protocal.c.bqb;
import com.tencent.mm.protocal.c.bqc;
import com.tencent.mm.protocal.c.bue;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.MMNativeJpeg;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.smtt.sdk.TbsListener$ErrorCode;

public final class z extends l implements k {
    private int dHI;
    private int dVE;
    public String dVk;
    int dVl;
    private a dVu;
    private b diG;
    public e diJ;
    private int nkZ;
    private String noN;
    private bqb noO;
    private String noP;
    private boolean noQ;
    private boolean noR;
    private boolean noS;
    long noT;
    int noU;
    private int offset;
    private String path;
    long startTime;

    public z(int i, String str, boolean z, int i2) {
        this.dVE = 8192;
        this.offset = 0;
        this.path = "";
        this.noN = "";
        this.nkZ = 0;
        this.noP = "";
        this.dVk = "";
        this.noQ = false;
        this.noR = false;
        this.noS = false;
        this.noT = 0;
        this.startTime = 0;
        this.dVl = 0;
        this.noU = 0;
        this.dVu = new 1(this);
        this.noT = System.currentTimeMillis();
        this.nkZ = i;
        this.noP = str;
        this.noU = i2;
        b.a aVar = new b.a();
        aVar.dIG = new bqb();
        aVar.dIH = new bqc();
        aVar.uri = "/cgi-bin/micromsg-bin/mmsnsupload";
        aVar.dIF = TbsListener$ErrorCode.UNZIP_OTHER_ERROR;
        aVar.dII = 95;
        aVar.dIJ = 1000000095;
        this.diG = aVar.KT();
        this.noO = (bqb) this.diG.dID.dIL;
        r fj = af.byd().fj((long) i);
        this.noS = z;
        x.i("MicroMsg.NetSceneMMSnsUpload", "start snsupload netscene localId " + i + "  offset " + fj.offset + " path " + fj.nJI + " totallen " + fj.nJH);
        if (!z) {
            this.noO.rXx = 1;
            x.i("MicroMsg.NetSceneMMSnsUpload", "this is single upload");
        }
        try {
            Object obj;
            ath ath = (ath) new ath().aG(fj.nJM);
            this.noN = i.LE(fj.nJI);
            this.path = an.s(af.getAccSnsPath(), fj.nJI) + this.noN;
            this.dHI = (int) FileOp.mI(this.path);
            this.noQ = i.LN(this.path);
            x.i("MicroMsg.NetSceneMMSnsUpload", "totallen " + this.dHI + " isLongPic: " + this.noQ);
            String str2 = ath.rWB;
            if (bi.oW(str2)) {
                str2 = g.u((bi.VG()).getBytes());
                ath.rWB = str2;
                try {
                    fj.nJM = ath.toByteArray();
                    af.byd().a(fj.nJc, fj);
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.NetSceneMMSnsUpload", e, "", new Object[0]);
                }
            }
            this.noO.rdV = this.dHI;
            this.noO.rdW = fj.offset;
            this.noO.rcc = str2;
            this.dVk = str2;
            x.d("MicroMsg.NetSceneMMSnsUpload", "filter style " + ath.rWa);
            this.noO.rWa = ath.rWa;
            x.d("MicroMsg.NetSceneMMSnsUpload", "syncWeibo " + ath.rWb);
            this.noO.rej = ath.jOS;
            this.noO.rWb = ath.rWb;
            x.i("MicroMsg.NetSceneMMSnsUpload", "request upload type " + fj.type + " md5: " + ath.bKg + " appid " + ath.bPS + " contenttype " + ath.afv);
            this.noO.hcE = fj.type;
            bue bue = new bue();
            bue.srB = ath.token;
            bue.srC = ath.rWk;
            this.noO.sdt = bue;
            if (!bi.oW(ath.bKg)) {
                this.noO.rwt = ath.bKg;
            }
            if (!bi.oW(ath.bPS)) {
                this.noO.jQb = ath.bPS;
            }
            this.noO.sob = ath.afv;
            if (af.ewP) {
                this.noO.hcE = 0;
            }
            if (this.startTime == 0) {
                this.startTime = bi.VF();
                this.dVl = com.tencent.mm.modelcdntran.b.MediaType_FRIENDS;
            }
            bqb bqb = this.noO;
            com.tencent.mm.modelcdntran.g.ND();
            if (!c.hz(32)) {
                Object[] objArr = new Object[1];
                com.tencent.mm.modelcdntran.g.ND();
                objArr[0] = Boolean.valueOf(c.hz(32));
                x.w("MicroMsg.NetSceneMMSnsUpload", "cdntra not use cdn flag:%b", objArr);
                obj = null;
            } else if (af.exE == 2) {
                obj = null;
            } else {
                this.dVk = bqb.rcc;
                if (bi.oW(this.dVk)) {
                    x.w("MicroMsg.NetSceneMMSnsUpload", "cdntra genClientId failed not use cdn");
                    obj = null;
                } else {
                    obj = 1;
                }
            }
            if (obj != null) {
                this.noR = true;
            } else if (!bxM()) {
                onError();
            }
        } catch (Exception e2) {
            x.e("MicroMsg.NetSceneMMSnsUpload", "parseFrom MediaUploadInfo error in NetSceneSnsUpload");
        }
    }

    private boolean bxM() {
        r fj = af.byd().fj((long) this.nkZ);
        int i = fj.nJH - fj.offset;
        if (i > this.dVE) {
            i = this.dVE;
        }
        this.offset = fj.offset;
        byte[] e = FileOp.e(this.path, this.offset, i);
        if (e == null || e.length <= 0) {
            return false;
        }
        bhy bhy = new bhy();
        bhy.bq(e);
        this.noO.rfy = bhy;
        this.noO.rdW = this.offset;
        return true;
    }

    protected final int a(q qVar) {
        return l.b.dJm;
    }

    protected final int Cc() {
        if (this.noQ) {
            return 675;
        }
        return 100;
    }

    public final int getType() {
        return TbsListener$ErrorCode.UNZIP_OTHER_ERROR;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneMMSnsUpload", "netId : " + i + " errType :" + i2 + " errCode: " + i3 + " errMsg :" + str);
        bqc bqc = (bqc) ((b) qVar).dIE.dIL;
        if (i2 == 4) {
            wp(i3);
            if (this.noU == 21) {
                com.tencent.mm.plugin.sns.lucky.a.b.kB(12);
            }
            this.diJ.a(i2, i3, str, this);
        } else if (i2 == 0 && i3 == 0) {
            r fj = af.byd().fj((long) this.nkZ);
            if (bqc.rdW < 0 || (bqc.rdW > fj.nJH && fj.nJH > 0)) {
                onError();
                if (i2 == 3) {
                    com.tencent.mm.plugin.sns.lucky.a.b.kB(14);
                }
            } else if (bqc.rdW < fj.offset) {
                onError();
                if (i2 == 3) {
                    com.tencent.mm.plugin.sns.lucky.a.b.kB(14);
                }
            } else {
                x.d("MicroMsg.NetSceneMMSnsUpload", " bufferUrl: " + bqc.soc.jPK + " bufferUrlType: " + bqc.soc.hcE + "  id:" + bqc.rlK + " thumb Count: " + bqc.rWy + "  type " + bqc.hcE + " startPos : " + bqc.rdW);
                fj.offset = bqc.rdW;
                af.byd().a(this.nkZ, fj);
                Object obj = (fj.offset != fj.nJH || fj.nJH == 0) ? null : 1;
                if (obj != null) {
                    x.i("MicroMsg.NetSceneMMSnsUpload", "uploadsns done pass: " + (System.currentTimeMillis() - this.noT));
                    if (bqc.rWz.size() == 0 || bqc.rWz.size() <= 0) {
                        a(bqc.soc.jPK, bqc.soc.hcE, "", 0, bqc.rlK, this.noO.rwt);
                    } else {
                        a(bqc.soc.jPK, bqc.soc.hcE, ((bok) bqc.rWz.get(0)).jPK, ((bok) bqc.rWz.get(0)).hcE, bqc.rlK, this.noO.rwt);
                    }
                    this.diJ.a(i2, i3, str, this);
                } else if (bxM() && a(this.dIX, this.diJ) < 0) {
                    this.diJ.a(3, -1, "doScene failed", this);
                }
            }
        } else {
            onError();
            if (this.noU == 21) {
                com.tencent.mm.plugin.sns.lucky.a.b.kB(13);
            }
            this.diJ.a(i2, i3, str, this);
        }
    }

    public final boolean a(String str, int i, String str2, int i2, String str3, String str4) {
        ath ath;
        r fj = af.byd().fj((long) this.nkZ);
        x.i("MicroMsg.NetSceneMMSnsUpload", "upload ok " + str + "  " + str3 + "  " + i + " thumbUrl: " + str2);
        Options options = new Options();
        options.inJustDecodeBounds = true;
        MMBitmapFactory.decodeFile(this.path, options, null, 0, new int[0]);
        String toLowerCase = options.outMimeType != null ? options.outMimeType.toLowerCase() : "";
        int i3 = -1;
        if (toLowerCase.endsWith("jpg") || toLowerCase.endsWith("jpeg")) {
            i3 = MMNativeJpeg.queryQuality(this.path);
            if (i3 == 0) {
                i3 = -1;
            }
        }
        com.tencent.mm.plugin.sns.h.c.a(str, options.outMimeType, options.outWidth, options.outHeight, i3, FileOp.mI(this.path));
        fj.nJL = str3;
        try {
            ath = (ath) new ath().aG(fj.nJM);
        } catch (Exception e) {
            ath = null;
        }
        if (ath == null) {
            ath = new ath();
        }
        atb atb = new atb();
        atb.hcE = i;
        atb.jPK = str;
        ath.rWx = atb;
        ath.rWA = 0;
        ath.bKg = str4;
        if (!bi.oW(str2)) {
            atb = new atb();
            atb.hcE = i2;
            atb.jPK = str2;
            ath.rWz.add(atb);
        }
        try {
            fj.nJM = ath.toByteArray();
        } catch (Throwable e2) {
            x.printErrStackTrace("MicroMsg.NetSceneMMSnsUpload", e2, "", new Object[0]);
        }
        fj.bBC();
        af.byd().a(this.nkZ, fj);
        af.byn().wu(this.nkZ);
        if (af.byk() != null) {
            af.byk().bwX();
        }
        return true;
    }

    final void wp(int i) {
        r fj = af.byd().fj((long) this.nkZ);
        try {
            ath ath = (ath) new ath().aG(fj.nJM);
            ath.rWA = 1;
            ath.rWj = i;
            fj.nJM = ath.toByteArray();
        } catch (Exception e) {
        }
        af.byn().wu(this.nkZ);
        af.byd().a(this.nkZ, fj);
    }

    private void onError() {
        r fj = af.byd().fj((long) this.nkZ);
        fj.offset = 0;
        try {
            ath ath = (ath) new ath().aG(fj.nJM);
            ath.rWB = "";
            fj.nJM = ath.toByteArray();
            af.byd().a(this.nkZ, fj);
            af.byn().wu(this.nkZ);
        } catch (Exception e) {
            x.e("MicroMsg.NetSceneMMSnsUpload", "parseFrom MediaUploadInfo error in NetSceneSnsUpload");
        }
    }

    protected final void cancel() {
        super.cancel();
        if (this.noR && !bi.oW(this.dVk)) {
            x.i("MicroMsg.NetSceneMMSnsUpload", "cancel by cdn " + this.dVk);
            com.tencent.mm.modelcdntran.g.ND().lw(this.dVk);
        }
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        int i = 108;
        this.diJ = eVar2;
        if (!this.noR) {
            return a(eVar, this.diG, this);
        }
        this.dVk = this.noO.rcc;
        if (bi.oW(this.dVk)) {
            x.w("MicroMsg.NetSceneMMSnsUpload", "cdntra genClientId failed not use cdn");
        } else {
            com.tencent.mm.modelcdntran.i iVar = new com.tencent.mm.modelcdntran.i();
            iVar.dPV = this.dVu;
            iVar.field_mediaId = this.dVk;
            iVar.field_fullpath = this.path;
            iVar.field_thumbpath = "";
            iVar.field_fileType = com.tencent.mm.modelcdntran.b.MediaType_FRIENDS;
            iVar.field_talker = "";
            iVar.field_priority = com.tencent.mm.modelcdntran.b.dOk;
            iVar.field_needStorage = true;
            iVar.field_isStreamMedia = false;
            if (s.bBE()) {
                if (!this.noS) {
                    i = 107;
                }
                iVar.field_appType = i;
            } else if (s.bBD()) {
                if (!this.noS) {
                    i = 107;
                }
                iVar.field_appType = i;
            } else {
                com.tencent.mm.modelcdntran.g.ND();
                if (c.hz(64)) {
                    iVar.field_appType = this.noS ? 104 : 103;
                } else {
                    iVar.field_appType = this.noS ? 101 : 100;
                }
            }
            iVar.field_bzScene = 1;
            if (!com.tencent.mm.modelcdntran.g.ND().c(iVar)) {
                x.e("MicroMsg.NetSceneMMSnsUpload", "cdntra addSendTask failed. clientid:%s", new Object[]{this.dVk});
                this.dVk = "";
            }
        }
        return 0;
    }
}

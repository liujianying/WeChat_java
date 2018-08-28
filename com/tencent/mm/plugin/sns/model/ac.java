package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.a.g;
import com.tencent.mm.g.a.qj;
import com.tencent.mm.modelcdntran.b;
import com.tencent.mm.modelcdntran.i;
import com.tencent.mm.modelcdntran.i.a;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.mmsight.model.h;
import com.tencent.mm.plugin.sight.base.d;
import com.tencent.mm.plugin.sns.storage.r;
import com.tencent.mm.protocal.c.aso;
import com.tencent.mm.protocal.c.atb;
import com.tencent.mm.protocal.c.ath;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class ac {
    private String bOX;
    private String ben;
    private String clientId;
    String dVk;
    int dVl;
    private a dVu;
    int ens;
    private String fHy;
    private int nkZ;
    private long noT;
    r npk;
    a npl;
    private ath npm;
    long startTime;

    public ac(int i, r rVar, String str, String str2, a aVar) {
        this.clientId = "";
        this.noT = 0;
        this.startTime = 0;
        this.dVl = 0;
        this.fHy = "";
        this.npm = new ath();
        this.dVu = new 4(this);
        this.noT = System.currentTimeMillis();
        this.ben = str;
        this.bOX = str2;
        this.npl = aVar;
        this.nkZ = i;
        this.npk = rVar;
        try {
            this.npm = (ath) new ath().aG(rVar.nJM);
            this.clientId = this.npm.rWB;
            this.fHy = this.npm.bKg;
            if (bi.oW(this.clientId)) {
                this.clientId = g.u((bi.VG()).getBytes());
                this.npm.rWB = this.clientId;
                try {
                    rVar.nJM = this.npm.toByteArray();
                    af.byd().a(rVar.nJc, rVar);
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.SightCdnUpload", e, "", new Object[0]);
                }
            }
            int mI = (int) FileOp.mI(str);
            x.i("MicroMsg.SightCdnUpload", "sightupload %d videopath %s sightFileSize %d md5 %s", new Object[]{Integer.valueOf(i), str, Integer.valueOf(mI), this.fHy});
        } catch (Exception e2) {
            x.e("MicroMsg.SightCdnUpload", "parseFrom MediaUploadInfo error in NetSceneSnsUpload");
        }
    }

    public final boolean bxO() {
        String cu = g.cu(this.ben);
        if (bi.oW(this.fHy) || this.fHy.equals(cu)) {
            aso aso;
            if (this.npm.rWE != null) {
                aso = this.npm.rWE;
            } else {
                aso = new aso();
            }
            x.i("MicroMsg.SightCdnUpload", "check upload %s %d %s", new Object[]{this.ben, Integer.valueOf(aso.rUQ), Boolean.valueOf(aso.rUP)});
            com.tencent.mm.plugin.sight.base.a Lo = d.Lo(this.ben);
            if (Lo != null) {
                x.i("MicroMsg.SightCdnUpload", "mediaInfo: %s", new Object[]{Lo});
                long j = (bi.oW(aso.bPS) || !aso.bPS.contains("wx5dfbe0a95623607b")) ? aso.rUP ? (long) com.tencent.mm.modelcontrol.d.NP().NR().duration : (long) com.tencent.mm.modelcontrol.d.NP().NS().duration : (long) com.tencent.mm.k.g.AT().getInt("WeiShiShareSnsSightTimeLength", 10);
                if (j <= 0) {
                    j = 10;
                }
                x.i("MicroMsg.SightCdnUpload", "maxVideoLen: %s", new Object[]{Long.valueOf((j * 1000) + 3000)});
                if (((long) Lo.jdD) >= (j * 1000) + 3000) {
                    x.i("MicroMsg.SightCdnUpload", "checkUpload isNotSafeSightVideo videoDuration: %s ", new Object[]{Integer.valueOf(Lo.jdD)});
                    wp(-2);
                    this.npl.hQ(false);
                    return false;
                }
            }
            if (aso.rUP) {
                int i = h.lgu;
                if (aso.rUQ >= 3) {
                    onError();
                    return false;
                }
                x.i("MicroMsg.SightCdnUpload", "try need remux %d %s", new Object[]{Integer.valueOf(i), this.ben});
                qj qjVar = new qj();
                qjVar.bJX = new 1(this, qjVar, aso);
                qjVar.caV.caZ = new 2(this);
                qjVar.caV.caI = this.ben;
                qjVar.caV.scene = i;
                qjVar.caV.caX = aso;
                qjVar.caV.caY = new 3(this, aso);
                com.tencent.mm.sdk.b.a.sFg.a(qjVar, af.byb().getLooper());
                return true;
            }
            a(aso);
            return true;
        }
        x.i("MicroMsg.SightCdnUpload", "checkUpload isNotSafeSightVideo old srcmd5 %s newmd5 %s ", new Object[]{this.fHy, cu});
        wp(-2);
        this.npl.hQ(false);
        return false;
    }

    final boolean a(aso aso) {
        if (this.startTime == 0) {
            this.startTime = bi.VF();
            this.dVl = b.dOp;
        }
        String str = this.clientId;
        if (bi.oW(str)) {
            x.w("MicroMsg.SightCdnUpload", "cdntra genClientId failed not use cdn");
            return false;
        }
        i iVar = new i();
        iVar.dPV = this.dVu;
        iVar.field_mediaId = str;
        iVar.field_fullpath = this.ben;
        iVar.field_thumbpath = this.bOX;
        iVar.field_fileType = b.dOp;
        iVar.field_talker = "";
        iVar.field_priority = b.dOk;
        iVar.field_needStorage = true;
        iVar.field_isStreamMedia = false;
        iVar.field_appType = 102;
        iVar.field_bzScene = 1;
        if (bi.oW(aso.bPS) || !aso.bPS.contains("wx5dfbe0a95623607b")) {
            VideoTransPara NR;
            com.tencent.mm.modelcontrol.d.NP();
            if (aso.rUP) {
                NR = com.tencent.mm.modelcontrol.d.NP().NR();
            } else {
                NR = com.tencent.mm.modelcontrol.d.NP().NS();
            }
            iVar.field_largesvideo = com.tencent.mm.modelcontrol.d.a(NR);
        } else {
            iVar.field_largesvideo = com.tencent.mm.k.g.AT().getInt("WeiShiShareSnsSightTimeLength", 10);
        }
        String cu = g.cu(this.ben);
        if (!bi.oW(this.fHy) && !this.fHy.equals(cu)) {
            x.i("MicroMsg.SightCdnUpload", "isNotSafeSightVideo old srcmd5 %s newmd5 %s ", new Object[]{this.fHy, cu});
            wp(-2);
            this.npl.hQ(false);
            return false;
        } else if (com.tencent.mm.modelcdntran.g.ND().c(iVar)) {
            int i = (aso == null || !aso.rUP) ? 5 : 4;
            this.ens = i;
            return true;
        } else {
            x.e("MicroMsg.SightCdnUpload", "cdntra addSendTask failed. clientid:%s", new Object[]{str});
            return false;
        }
    }

    public final boolean Z(String str, String str2, String str3) {
        ath ath;
        r fj = af.byd().fj((long) this.nkZ);
        x.d("MicroMsg.SightCdnUpload", "upload ok " + str + "  " + str3 + "  1");
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
        atb.hcE = 1;
        atb.jPK = str;
        ath.rWx = atb;
        ath.rWA = 0;
        com.tencent.mm.modelcdntran.g.NE();
        ath.rVZ = b.ls(this.ben);
        x.i("MicroMsg.SightCdnUpload", "onPostScene videomd5 %s", new Object[]{ath.rVZ});
        if (!bi.oW(str2)) {
            atb = new atb();
            atb.hcE = 1;
            atb.jPK = str2;
            ath.rWz.add(atb);
        }
        try {
            fj.nJM = ath.toByteArray();
        } catch (Throwable e2) {
            x.printErrStackTrace("MicroMsg.SightCdnUpload", e2, "", new Object[0]);
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
        x.i("MicroMsg.SightCdnUpload", "snsupload sight by cdn error!");
        r fj = af.byd().fj((long) this.nkZ);
        try {
            ath ath = (ath) new ath().aG(fj.nJM);
            ath.rWA = 1;
            ath.rWj = i;
            if (this.npm.rWE != null) {
                this.npm.rWE.rUQ = 0;
            }
            fj.nJM = ath.toByteArray();
        } catch (Exception e) {
        }
        af.byn().wu(this.nkZ);
        af.byd().a(this.nkZ, fj);
    }

    final void onError() {
        x.i("MicroMsg.SightCdnUpload", "snsupload sight by cdn error!");
        r fj = af.byd().fj((long) this.nkZ);
        fj.offset = 0;
        try {
            ath ath = (ath) new ath().aG(fj.nJM);
            ath.rWB = "";
            if (ath.rWE != null) {
                ath.rWE.rUQ = 0;
            }
            fj.nJM = ath.toByteArray();
            af.byd().a(this.nkZ, fj);
            af.byn().wu(this.nkZ);
        } catch (Exception e) {
            x.e("MicroMsg.SightCdnUpload", "parseFrom MediaUploadInfo error in NetSceneSnsUpload");
        }
    }
}

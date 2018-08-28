package com.tencent.mm.ak;

import android.graphics.BitmapFactory.Options;
import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bhy;
import com.tencent.mm.protocal.c.bwi;
import com.tencent.mm.protocal.c.bwj;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.c;
import com.tencent.mm.sdk.platformtools.x;

public final class m extends l implements k {
    private e dVR;
    private a dVS;
    private final b diG;
    private e diJ;
    private int dlO;

    public m(int i, bwi bwi, e eVar, keep_SceneResult keep_sceneresult, a aVar) {
        int i2;
        a aVar2 = new a();
        aVar2.dIG = new bwi();
        aVar2.dIH = new bwj();
        aVar2.uri = "/cgi-bin/micromsg-bin/uploadmsgimg";
        aVar2.dIF = 110;
        aVar2.dII = 9;
        aVar2.dIJ = 1000000009;
        this.diG = aVar2.KT();
        this.dVS = aVar;
        this.dlO = i;
        this.dVR = eVar;
        bwi bwi2 = (bwi) this.diG.dID.dIL;
        bwi2.rcj = bwi.rcj;
        bwi2.rck = bwi.rck;
        bwi2.ssC = bwi.ssC;
        bwi2.jQd = bwi.jQd;
        bwi2.rco = bwi.rco;
        bwi2.rmB = bwi.rmB;
        Options VZ = c.VZ(o.Pf().o(eVar.dTN, "", ""));
        bwi2.ssK = VZ != null ? VZ.outWidth : 0;
        if (VZ != null) {
            i2 = VZ.outHeight;
        } else {
            i2 = 0;
        }
        bwi2.ssJ = i2;
        bwi2.ssH = keep_sceneresult.field_fileId;
        bwi2.ssI = keep_sceneresult.field_thumbimgLength;
        bwi2.rdV = keep_sceneresult.field_thumbimgLength;
        bwi2.rdW = 0;
        bwi2.rdX = keep_sceneresult.field_thumbimgLength;
        bwi2.rtW = new bhy().bq(new byte[0]);
        bwi2.jQb = bwi.jQb;
        bwi2.raM = bwi.raM;
        bwi2.raO = bwi.raO;
        bwi2.raN = bwi.raN;
        bwi2.rmz = 1;
        if (keep_sceneresult.isUploadBySafeCDNWithMD5()) {
            x.i("MicroMsg.NetSceneUploadMsgImgForCdn", "summersafecdn isUploadBySafeCDNWithMD5 field_upload_by_safecdn[%b], field_UploadHitCacheType[%d], crc[%d], aeskey[%s]", new Object[]{Boolean.valueOf(keep_sceneresult.field_upload_by_safecdn), Integer.valueOf(keep_sceneresult.field_UploadHitCacheType), Integer.valueOf(keep_sceneresult.field_filecrc), keep_sceneresult.field_aesKey});
            bwi2.sjV = 1;
            bwi2.rmy = "";
            bwi2.rPR = "";
        } else {
            bwi2.rmy = keep_sceneresult.field_aesKey;
            bwi2.rPR = keep_sceneresult.field_aesKey;
        }
        bwi2.rJr = bwi.rJr;
        if (bwi.rJr == 1) {
            bwi2.ssF = keep_sceneresult.field_fileLength;
            bwi2.ssG = keep_sceneresult.field_midimgLength;
            bwi2.ssD = keep_sceneresult.field_fileId;
            bwi2.ssE = keep_sceneresult.field_fileId;
        } else {
            bwi2.ssF = 0;
            bwi2.ssG = keep_sceneresult.field_fileLength;
            bwi2.ssD = "";
            bwi2.ssE = keep_sceneresult.field_fileId;
        }
        bwi2.rmA = keep_sceneresult.field_filecrc;
        bwi2.rwk = keep_sceneresult.field_filemd5;
        x.i("MicroMsg.NetSceneUploadMsgImgForCdn", "summersafecdn NetSceneUploadMsgImgForCdn MsgForwardType[%d], hitmd5[%d], key[%s], crc[%d]", new Object[]{Integer.valueOf(bwi2.rmB), Integer.valueOf(bwi2.sjV), bi.Xf(bwi2.rmy), Integer.valueOf(bwi2.rmA)});
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        x.i("MicroMsg.NetSceneUploadMsgImgForCdn", "cdntra req[%s]", new Object[]{((bwi) this.diG.dID.dIL).toString()});
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneUploadMsgImgForCdn", "onGYNetEnd errtype:" + i2 + " errcode:" + i3);
        bwj bwj = (bwj) ((b) qVar).dIE.dIL;
        x.i("MicroMsg.NetSceneUploadMsgImgForCdn", "onGYNetEnd createtime:%d msgId:%d ", new Object[]{Integer.valueOf(bwj.lOH), Long.valueOf(bwj.rcq)});
        if (this.dVS != null) {
            this.dVS.a(bwj.rcq, bwj.lOH, i2, i3);
        }
        this.diJ.a(0, 0, "", this);
    }

    public final int getType() {
        return 110;
    }
}

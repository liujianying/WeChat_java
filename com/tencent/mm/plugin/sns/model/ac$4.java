package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.modelcdntran.d;
import com.tencent.mm.modelcdntran.i.a;
import com.tencent.mm.modelcdntran.keep_ProgressInfo;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.modelvideo.n;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.ByteArrayOutputStream;

class ac$4 implements a {
    final /* synthetic */ ac npp;

    ac$4(ac acVar) {
        this.npp = acVar;
    }

    public final int a(String str, int i, keep_ProgressInfo keep_progressinfo, keep_SceneResult keep_sceneresult, boolean z) {
        if (i == -21005) {
            x.d("MicroMsg.SightCdnUpload", "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[]{this.npp.dVk, Integer.valueOf(i), keep_progressinfo, keep_sceneresult});
            this.npp.npl.hQ(true);
            return 0;
        } else if (keep_sceneresult != null && keep_sceneresult.field_retCode == 0) {
            x.i("MicroMsg.SightCdnUpload", "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[]{this.npp.dVk, Integer.valueOf(i), keep_progressinfo, keep_sceneresult});
            this.npp.Z(keep_sceneresult.field_fileUrl, keep_sceneresult.field_thumbUrl, "upload_" + this.npp.dVk);
            h.mEJ.h(10421, new Object[]{Integer.valueOf(0), Integer.valueOf(1), Long.valueOf(this.npp.startTime), Long.valueOf(bi.VF()), Integer.valueOf(d.bL(ad.getContext())), Integer.valueOf(this.npp.dVl), Integer.valueOf(keep_sceneresult.field_fileLength), keep_sceneresult.field_transInfo, "", "", "", "", "", "", "", keep_sceneresult.report_Part2});
            n SY = n.SY();
            int i2 = this.npp.ens;
            if (keep_sceneresult != null) {
                String str2 = keep_sceneresult.field_fileUrl;
                String str3 = str2.hashCode();
                n.a aVar = (n.a) SY.ena.get(str3);
                if (aVar == null) {
                    aVar = new n.a(SY);
                }
                String str4 = "";
                aVar.cqb = str4;
                aVar.toUser = str4;
                aVar.eno = str4;
                aVar.ens = i2;
                aVar.enr = 1;
                aVar.bSW = str2;
                aVar.emE = keep_sceneresult;
                aVar.startTime = bi.VF();
                SY.ena.put(str3, aVar);
                x.i("MicroMsg.SubCoreMediaRpt", "note sns video sendScene %d snsKey[%s] url[%s]", new Object[]{Integer.valueOf(i2), str3, str2});
            }
            this.npp.npl.hQ(true);
            return 0;
        } else if (keep_sceneresult != null && keep_sceneresult.field_retCode != 0) {
            x.i("MicroMsg.SightCdnUpload", "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[]{this.npp.dVk, Integer.valueOf(i), keep_progressinfo, keep_sceneresult});
            this.npp.wp(0);
            h.mEJ.h(10421, new Object[]{Integer.valueOf(keep_sceneresult.field_retCode), Integer.valueOf(1), Long.valueOf(this.npp.startTime), Long.valueOf(bi.VF()), Integer.valueOf(d.bL(ad.getContext())), Integer.valueOf(this.npp.dVl), Integer.valueOf(keep_sceneresult.field_fileLength), keep_sceneresult.field_transInfo, "", "", "", "", "", "", "", keep_sceneresult.report_Part2});
            h.mEJ.h(13937, new Object[]{Integer.valueOf(keep_sceneresult.field_retCode), Integer.valueOf(1), Long.valueOf(this.npp.startTime), Long.valueOf(bi.VF()), Integer.valueOf(d.bL(ad.getContext())), Integer.valueOf(this.npp.dVl), Integer.valueOf(keep_sceneresult.field_fileLength), keep_sceneresult.field_transInfo, "", "", "", "", "", "", "", keep_sceneresult.report_Part2});
            this.npp.npl.hQ(false);
            return 0;
        } else if (i != 0) {
            x.i("MicroMsg.SightCdnUpload", "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[]{this.npp.dVk, Integer.valueOf(i), keep_progressinfo, keep_sceneresult});
            this.npp.wp(0);
            if (keep_sceneresult != null) {
                h.mEJ.h(10421, new Object[]{Integer.valueOf(i), Integer.valueOf(1), Long.valueOf(this.npp.startTime), Long.valueOf(bi.VF()), Integer.valueOf(d.bL(ad.getContext())), Integer.valueOf(this.npp.dVl), Integer.valueOf(keep_sceneresult.field_fileLength), keep_sceneresult.field_transInfo, "", "", "", "", "", "", "", keep_sceneresult.report_Part2});
            }
            this.npp.npl.hQ(false);
            return 0;
        } else {
            x.d("MicroMsg.SightCdnUpload", "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[]{this.npp.dVk, Integer.valueOf(i), keep_progressinfo, keep_sceneresult});
            return 0;
        }
    }

    public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
    }

    public final byte[] i(String str, byte[] bArr) {
        return null;
    }
}

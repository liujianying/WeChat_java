package com.tencent.mm.modelvideo;

import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelcdntran.b;
import com.tencent.mm.modelcdntran.d;
import com.tencent.mm.modelcdntran.i.a;
import com.tencent.mm.modelcdntran.keep_ProgressInfo;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;
import java.io.ByteArrayOutputStream;
import java.util.List;

final class m$a implements e, a {
    List<r> dEx;
    final /* synthetic */ m emY;
    String emZ;
    long emf;
    r emg;
    long startTime;

    private m$a(m mVar) {
        this.emY = mVar;
    }

    /* synthetic */ m$a(m mVar, byte b) {
        this(mVar);
    }

    public final int a(String str, int i, keep_ProgressInfo keep_progressinfo, keep_SceneResult keep_sceneresult, boolean z) {
        x.d("MicroMsg.SightMassSendService", "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[]{this.emZ, Integer.valueOf(i), keep_progressinfo, keep_sceneresult});
        if (i == -21005) {
            x.d("MicroMsg.SightMassSendService", "cdntra  ERR_CNDCOM_MEDIA_IS_UPLOADING clientid:%s", new Object[]{this.emZ});
            return 0;
        } else if (i != 0) {
            m.W(this.dEx);
            x.e("MicroMsg.SightMassSendService", "upload to CDN error, massSendId %d, errCode %d", new Object[]{Long.valueOf(this.emf), Integer.valueOf(i)});
            h.mEJ.h(10421, new Object[]{Integer.valueOf(i), Integer.valueOf(1), Long.valueOf(this.startTime), Long.valueOf(bi.VF()), Integer.valueOf(d.bL(ad.getContext())), Integer.valueOf(b.MediaType_TinyVideo), Integer.valueOf(0), ""});
            this.emY.d(this.emf, 3, i);
            return 0;
        } else if (keep_progressinfo != null) {
            x.v("MicroMsg.SightMassSendService", "progress length %d", new Object[]{Integer.valueOf(keep_progressinfo.field_finishedLength)});
            for (r rVar : this.dEx) {
                rVar.enK = bi.VE();
                rVar.emu = keep_progressinfo.field_finishedLength;
                rVar.bWA = 1032;
                t.e(rVar);
            }
            return 0;
        } else {
            if (keep_sceneresult != null) {
                if (keep_sceneresult.field_retCode != 0) {
                    x.e("MicroMsg.SightMassSendService", "cdntra sceneResult.retCode :%d arg[%s] info[%s], massSendId[%d]", new Object[]{Integer.valueOf(keep_sceneresult.field_retCode), keep_sceneresult.field_arg, keep_sceneresult.field_transInfo, Long.valueOf(this.emf)});
                    m.W(this.dEx);
                    h.mEJ.h(10421, new Object[]{Integer.valueOf(keep_sceneresult.field_retCode), Integer.valueOf(1), Long.valueOf(this.startTime), Long.valueOf(bi.VF()), Integer.valueOf(d.bL(ad.getContext())), Integer.valueOf(b.MediaType_TinyVideo), Integer.valueOf(keep_sceneresult.field_fileLength), keep_sceneresult.field_transInfo, "", "", "", "", "", "", "", keep_sceneresult.report_Part2});
                    h.mEJ.h(13937, new Object[]{Integer.valueOf(keep_sceneresult.field_retCode), Integer.valueOf(1), Long.valueOf(this.startTime), Long.valueOf(bi.VF()), Integer.valueOf(d.bL(ad.getContext())), Integer.valueOf(b.MediaType_TinyVideo), Integer.valueOf(keep_sceneresult.field_fileLength), keep_sceneresult.field_transInfo, "", "", "", "", "", "", "", keep_sceneresult.report_Part2});
                    this.emY.d(this.emf, 3, keep_sceneresult.field_retCode);
                } else {
                    x.i("MicroMsg.SightMassSendService", "uploadvideo by cdn, isHitCacheUpload[%d] massSendId[%d]", new Object[]{Integer.valueOf(keep_sceneresult.field_UploadHitCacheType), Long.valueOf(this.emf)});
                    x.i("MicroMsg.SightMassSendService", "cdn callback new build cdnInfo:%s", new Object[]{((("<msg><videomsg aeskey=\"" + keep_sceneresult.field_aesKey + "\" cdnthumbaeskey=\"" + keep_sceneresult.field_aesKey + "\" cdnvideourl=\"" + keep_sceneresult.field_fileId + "\" ") + "cdnthumburl=\"" + keep_sceneresult.field_fileId + "\" ") + "length=\"" + keep_sceneresult.field_fileLength + "\" ") + "cdnthumblength=\"" + keep_sceneresult.field_thumbimgLength + "\"/></msg>"});
                    for (r rVar2 : this.dEx) {
                        if (bi.oW(rVar2.Tm())) {
                            rVar2.enS = r1;
                            rVar2.bWA = 2097152;
                            boolean e = t.e(rVar2);
                            x.i("MicroMsg.SightMassSendService", "massSendId[%d] info %s, update recv xml ret %B", new Object[]{Long.valueOf(this.emf), rVar2.getFileName(), Boolean.valueOf(e)});
                        }
                    }
                    synchronized (m.a(this.emY)) {
                        if (bi.oW((String) m.b(this.emY).get(Long.valueOf(this.emf)))) {
                            x.i("MicroMsg.SightMassSendService", "check cdn client id FAIL do NOTHING, massSendId %d, oldClientId %s, selfClientId %s", new Object[]{Long.valueOf(this.emf), (String) m.b(this.emY).get(Long.valueOf(this.emf)), this.emZ});
                        } else {
                            x.i("MicroMsg.SightMassSendService", "check cdn client id ok do MASS SEND, massSendId %d, oldClientId %s, selfClientId %s", new Object[]{Long.valueOf(this.emf), (String) m.b(this.emY).get(Long.valueOf(this.emf)), this.emZ});
                            m.b(this.emY).put(Long.valueOf(this.emf), "done_upload_cdn_client_id");
                            g.DF().a(245, this);
                            if (!g.DF().a(new e(this.emf, this.emg, keep_sceneresult, this.emZ), 0)) {
                                x.e("MicroMsg.SightMassSendService", "try to do NetSceneMassUploadSight fail");
                                g.DF().b(245, this);
                                this.emY.d(this.emf, 3, 0);
                            }
                        }
                    }
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

    public final void a(int i, int i2, String str, l lVar) {
        g.DF().b(245, this);
        if (i == 4 && i2 == -22) {
            x.e("MicroMsg.SightMassSendService", "ERR: onGYNetEnd BLACK  errtype:" + i + " errCode:" + i2 + " massSendId:" + this.emf);
            m.X(this.dEx);
            this.emY.d(this.emf, i, i2);
        } else if (i == 4 && i2 != 0) {
            x.e("MicroMsg.SightMassSendService", "ERR: onGYNetEnd SERVER FAILED errtype:" + i + " errCode:" + i2 + "  massSendId:" + this.emf);
            m.W(this.dEx);
            this.emY.d(this.emf, i, i2);
        } else if (i == 0 && i2 == 0) {
            for (r rVar : this.dEx) {
                rVar.enK = bi.VE();
                rVar.status = 199;
                rVar.bWA = 1280;
                if (t.e(rVar)) {
                    if (rVar == null) {
                        x.e("MicroMsg.VideoLogic", "video info is null");
                    } else if (rVar.enN > 0) {
                        bd dW = ((i) g.l(i.class)).bcY().dW((long) rVar.enN);
                        int type = dW.getType();
                        x.i("MicroMsg.VideoLogic", "ashutest::updateWriteFinMassMsgInfo, msg type %d", new Object[]{Integer.valueOf(type)});
                        if (43 == type || 62 == type) {
                            dW.eX(1);
                            dW.ep(rVar.Tj());
                            dW.ax(rVar.bYu);
                            dW.setStatus(2);
                            dW.setContent(p.b(rVar.Tk(), (long) rVar.enM, false));
                            ((i) g.l(i.class)).bcY().a((long) rVar.enN, dW);
                            x.d("MicroMsg.VideoLogic", "updateWriteFinMassMsgInfo msgId:%d", new Object[]{Long.valueOf(dW.field_msgId)});
                        }
                    } else {
                        bd bdVar = new bd();
                        bdVar.ep(rVar.Tj());
                        bdVar.setType(62);
                        bdVar.eX(1);
                        bdVar.eq(rVar.getFileName());
                        bdVar.setStatus(2);
                        bdVar.ay(com.tencent.mm.model.bd.iD(rVar.Tj()));
                        rVar.enN = (int) com.tencent.mm.model.bd.i(bdVar);
                        rVar.bWA = 8192;
                        t.e(rVar);
                        x.d("MicroMsg.VideoLogic", "updateWriteFinMassMsgInfo insert msgId:%d", new Object[]{Long.valueOf(bdVar.field_msgId)});
                    }
                }
                x.v("MicroMsg.SightMassSendService", "massSendId %d, file %s, set status %d", new Object[]{Long.valueOf(this.emf), rVar.getFileName(), Integer.valueOf(199)});
            }
            g.Em().H(new m$1(this.emY, this.emf));
        } else {
            x.e("MicroMsg.SightMassSendService", "ERR: onGYNetEnd FAILED (WILL RETRY) errtype:" + i + " errCode:" + i2 + "  massSendId:" + this.emf);
            m.W(this.dEx);
            this.emY.d(this.emf, i, i2);
        }
    }
}

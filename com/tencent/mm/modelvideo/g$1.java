package com.tencent.mm.modelvideo;

import com.tencent.mm.a.e;
import com.tencent.mm.modelcdntran.d;
import com.tencent.mm.modelcdntran.g;
import com.tencent.mm.modelcdntran.i$a;
import com.tencent.mm.modelcdntran.keep_ProgressInfo;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bl;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.smtt.sdk.TbsMediaPlayer$TbsMediaPlayerListener;
import java.io.ByteArrayOutputStream;
import java.util.Map;

class g$1 implements i$a {
    final /* synthetic */ g emA;

    g$1(g gVar) {
        this.emA = gVar;
    }

    public final int a(String str, int i, keep_ProgressInfo keep_progressinfo, keep_SceneResult keep_sceneresult, boolean z) {
        x.d("MicroMsg.NetSceneUploadVideo", "%s cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[]{g.a(this.emA), g.b(this.emA), Integer.valueOf(i), keep_progressinfo, keep_sceneresult});
        if (i == -21005) {
            x.d("MicroMsg.NetSceneUploadVideo", "cdntra  ERR_CNDCOM_MEDIA_IS_UPLOADING clientid:%s", new Object[]{g.b(this.emA)});
            return 0;
        } else if (i != 0) {
            t.nP(g.c(this.emA));
            h.mEJ.h(10421, new Object[]{Integer.valueOf(i), Integer.valueOf(1), Long.valueOf(g.d(this.emA)), Long.valueOf(bi.VF()), Integer.valueOf(d.bL(ad.getContext())), Integer.valueOf(g.e(this.emA)), Integer.valueOf(0), ""});
            g.f(this.emA).a(3, i, "", this.emA);
            return 0;
        } else {
            g.a(this.emA, t.nW(g.c(this.emA)));
            int i2;
            if (g.g(this.emA) == null || g.g(this.emA).status == 105) {
                x.i("MicroMsg.NetSceneUploadVideo", "%s info is null or has paused, status:%d", new Object[]{g.a(this.emA), Integer.valueOf(g.g(this.emA) == null ? -1 : g.g(this.emA).status)});
                g.ND().lw(g.b(this.emA));
                g.f(this.emA).a(3, i, "info is null or has paused, status" + i2, this.emA);
                return 0;
            } else if (keep_progressinfo == null) {
                if (keep_sceneresult != null) {
                    if (keep_sceneresult.field_retCode != 0) {
                        x.e("MicroMsg.NetSceneUploadVideo", "%s cdntra sceneResult.retCode :%d arg[%s] info[%s]", new Object[]{g.a(this.emA), Integer.valueOf(keep_sceneresult.field_retCode), keep_sceneresult.field_arg, keep_sceneresult.field_transInfo});
                        t.nP(g.c(this.emA));
                        h.mEJ.h(10421, new Object[]{Integer.valueOf(keep_sceneresult.field_retCode), Integer.valueOf(1), Long.valueOf(g.d(this.emA)), Long.valueOf(bi.VF()), Integer.valueOf(d.bL(ad.getContext())), Integer.valueOf(g.e(this.emA)), Integer.valueOf(keep_sceneresult.field_fileLength), keep_sceneresult.field_transInfo, "", "", "", "", "", "", "", keep_sceneresult.report_Part2});
                        h.mEJ.h(13937, new Object[]{Integer.valueOf(keep_sceneresult.field_retCode), Integer.valueOf(1), Long.valueOf(g.d(this.emA)), Long.valueOf(bi.VF()), Integer.valueOf(d.bL(ad.getContext())), Integer.valueOf(g.e(this.emA)), Integer.valueOf(keep_sceneresult.field_fileLength), keep_sceneresult.field_transInfo, "", "", "", "", "", "", "", keep_sceneresult.report_Part2});
                        g.f(this.emA).a(3, keep_sceneresult.field_retCode, "", this.emA);
                    } else {
                        x.i("MicroMsg.NetSceneUploadVideo", "%s summersafecdn uploadvideo by cdn, videohash isHitCacheUpload: %d, enableHitcheck:%b", new Object[]{g.a(this.emA), Integer.valueOf(keep_sceneresult.field_UploadHitCacheType), Boolean.valueOf(g.h(this.emA))});
                        h hVar = h.mEJ;
                        Object[] objArr = new Object[2];
                        i2 = g.i(this.emA) ? 810 : g.j(this.emA) ? 820 : 830;
                        objArr[0] = Integer.valueOf(i2 + keep_sceneresult.field_UploadHitCacheType);
                        objArr[1] = Integer.valueOf(g.g(this.emA).dHI);
                        hVar.h(12696, objArr);
                        boolean z2 = keep_sceneresult.field_isVideoReduced;
                        x.i("MicroMsg.NetSceneUploadVideo", "%s it video was reduced by cdn %b %s", new Object[]{g.a(this.emA), Boolean.valueOf(z2), g.c(this.emA)});
                        if (z2) {
                            h.mEJ.a(106, 200, 1, false);
                        } else {
                            h.mEJ.a(106, 205, 1, false);
                            if (g.k(this.emA) > 0 && keep_sceneresult.field_thumbimgLength > 0) {
                                x.i("MicroMsg.NetSceneUploadVideo", "%s send video thumb too big thumb length [%d, %d] ", new Object[]{g.a(this.emA), Integer.valueOf(g.k(this.emA)), Integer.valueOf(keep_sceneresult.field_thumbimgLength)});
                                if (g.k(this.emA) * 2 > keep_sceneresult.field_thumbimgLength) {
                                    h.mEJ.a(106, 206, 1, false);
                                } else {
                                    h.mEJ.a(106, 207, 1, false);
                                }
                            }
                            o.Ta();
                            x.i("MicroMsg.NetSceneUploadVideo", "%s send video too big thumb length [%d, %d] ", new Object[]{g.a(this.emA), Integer.valueOf(g.g(this.emA).dHI), Integer.valueOf(e.cm(s.nK(g.c(this.emA))))});
                            if (g.g(this.emA).dHI != e.cm(s.nK(g.c(this.emA)))) {
                                h.mEJ.a(106, 208, 1, false);
                            } else {
                                h.mEJ.a(106, 209, 1, false);
                            }
                        }
                        g.a(this.emA, t.nW(g.c(this.emA)));
                        if (bi.oW(g.g(this.emA).Tm())) {
                            x.i("MicroMsg.NetSceneUploadVideo", "%s cdn callback new build cdnInfo:%s", new Object[]{g.a(this.emA), ((("<msg><videomsg aeskey=\"" + keep_sceneresult.field_aesKey + "\" cdnthumbaeskey=\"" + keep_sceneresult.field_aesKey + "\" cdnvideourl=\"" + keep_sceneresult.field_fileId + "\" ") + "cdnthumburl=\"" + keep_sceneresult.field_fileId + "\" ") + "length=\"" + keep_sceneresult.field_fileLength + "\" ") + "cdnthumblength=\"" + keep_sceneresult.field_thumbimgLength + "\"/></msg>"});
                            g.g(this.emA).enS = r0;
                            t.e(g.g(this.emA));
                        }
                        Map z3 = bl.z(g.g(this.emA).Tm(), "msg");
                        if (z3 != null) {
                            s Ta = o.Ta();
                            o.Ta();
                            boolean r = Ta.r(s.nK(g.c(this.emA)), (String) z3.get(".msg.videomsg.$cdnvideourl"), (String) z3.get(".msg.videomsg.$aeskey"));
                            hVar = h.mEJ;
                            objArr = new Object[2];
                            objArr[0] = Integer.valueOf((r ? 1 : 2) + TbsMediaPlayer$TbsMediaPlayerListener.MEDIA_INFO_TIMED_TEXT_ERROR);
                            objArr[1] = Integer.valueOf(g.g(this.emA).dHI);
                            hVar.h(12696, objArr);
                        }
                        com.tencent.mm.kernel.g.DF().a(new h(g.c(this.emA), z2 ? 0 : g.l(this.emA), keep_sceneresult, new 1(this, keep_sceneresult)), 0);
                    }
                }
                return 0;
            } else if (g.g(this.emA).emu > keep_progressinfo.field_finishedLength) {
                x.w("MicroMsg.NetSceneUploadVideo", "%s cdntra cdnEndProc error oldpos:%d newpos:%d", new Object[]{g.a(this.emA), Integer.valueOf(g.g(this.emA).emu), Integer.valueOf(keep_progressinfo.field_finishedLength)});
                return 0;
            } else {
                g.g(this.emA).enK = bi.VE();
                g.g(this.emA).emu = keep_progressinfo.field_finishedLength;
                g.g(this.emA).bWA = 1032;
                t.e(g.g(this.emA));
                return 0;
            }
        }
    }

    public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
    }

    public final byte[] i(String str, byte[] bArr) {
        return null;
    }
}

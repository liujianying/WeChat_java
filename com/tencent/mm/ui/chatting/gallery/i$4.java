package com.tencent.mm.ui.chatting.gallery;

import com.tencent.mm.g.a.la;
import com.tencent.mm.modelcdntran.f;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.chatting.gallery.l.1;

class i$4 extends c<la> {
    final /* synthetic */ i tWK;

    i$4(i iVar) {
        this.tWK = iVar;
        this.sFo = la.class.getName().hashCode();
    }

    private boolean a(la laVar) {
        if (!i.f(this.tWK).NS(laVar.bVm.mediaId)) {
            return false;
        }
        if (laVar.bVm.retCode == 0 || laVar.bVm.retCode == -21006) {
            String nK;
            int i;
            l f;
            switch (laVar.bVm.bOh) {
                case 1:
                    l f2 = i.f(this.tWK);
                    long j = (long) laVar.bVm.offset;
                    long j2 = laVar.bVm.bVn;
                    boolean z = laVar.bVm.bVo;
                    x.i("MicroMsg.OnlineVideoUIHelper", "deal moov ready moovPos[%d] needSeekTime[%d] timeDuration[%d] startDownload[%d %d]", new Object[]{Long.valueOf(j), Integer.valueOf(f2.elG), Integer.valueOf(f2.elF), Long.valueOf(j2), Long.valueOf(f2.dQj)});
                    if (f2.elF != 0) {
                        x.w("MicroMsg.OnlineVideoUIHelper", "moov had callback, do nothing.");
                    } else {
                        if (j2 <= f2.dQj) {
                            j2 = f2.dQj;
                        }
                        f2.dQj = j2;
                        h.mEJ.a(354, 5, 1, false);
                        f2.nPP = bi.VF();
                        o.Ta();
                        nK = s.nK(f2.filename);
                        try {
                            if (f2.elE == null) {
                                x.w("MicroMsg.OnlineVideoUIHelper", "parser is null, thread is error.");
                            } else if (f2.elE.s(nK, j)) {
                                f2.elF = f2.elE.eyV;
                                x.i("MicroMsg.OnlineVideoUIHelper", "mp4 parse moov success. duration %d filename %s isFastStart %b", new Object[]{Integer.valueOf(f2.elF), f2.filename, Boolean.valueOf(z)});
                                if (!z) {
                                    ah.A(new 1(f2));
                                }
                                if (f2.elG == -1) {
                                    f2.elD = 1;
                                } else {
                                    f2.elD = 2;
                                }
                                h.mEJ.a(354, 7, 1, false);
                            } else {
                                x.w("MicroMsg.OnlineVideoUIHelper", "mp4 parse moov error.");
                                o.Tb();
                                f.g(f2.mediaId, 0, -1);
                                t.V(f2.filename, 15);
                                h.mEJ.a(354, 8, 1, false);
                                x.w("MicroMsg.OnlineVideoUIHelper", "%d rpt parse moov fail %s ", new Object[]{Integer.valueOf(f2.hashCode()), f2.filename});
                                h.mEJ.h(13836, new Object[]{Integer.valueOf(302), Long.valueOf(bi.VE()), ""});
                            }
                        } catch (Throwable e) {
                            x.printErrStackTrace("MicroMsg.OnlineVideoUIHelper", e, "", new Object[0]);
                            x.e("MicroMsg.OnlineVideoUIHelper", "deal moov ready error: " + e.toString());
                        }
                    }
                    i.a(this.tWK, true);
                    break;
                case 2:
                    l f3 = i.f(this.tWK);
                    nK = laVar.bVm.mediaId;
                    i = laVar.bVm.offset;
                    int i2 = laVar.bVm.length;
                    f3.elM = false;
                    if (i < 0 || i2 < 0) {
                        x.w("MicroMsg.OnlineVideoUIHelper", "deal data available error offset[%d], length[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
                    } else if (f3.NS(nK)) {
                        Integer num = (Integer) f3.nPL.get(f3.mediaId + i + "_" + i2);
                        if (num == null || num.intValue() <= 0) {
                            try {
                                f3.elJ = f3.elE.bw(i, i2);
                            } catch (Throwable e2) {
                                x.printErrStackTrace("MicroMsg.OnlineVideoUIHelper", e2, "", new Object[0]);
                                x.e("MicroMsg.OnlineVideoUIHelper", "deal data available file pos to video time error: " + e2.toString());
                            }
                        } else {
                            f3.elJ = num.intValue();
                        }
                        x.i("MicroMsg.OnlineVideoUIHelper", "deal data available. offset[%d] length[%d] cachePlayTime[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(f3.elJ)});
                    }
                    if (laVar.bVm.length > 0) {
                        this.tWK.bS(true);
                        break;
                    }
                    break;
                case 3:
                    this.tWK.bS(true);
                    break;
                case 4:
                    f = i.f(this.tWK);
                    x.i("MicroMsg.OnlineVideoUIHelper", "deal stream finish. playStatus %d ", new Object[]{Integer.valueOf(f.elD)});
                    f.elM = false;
                    f.elC = 3;
                    if (f.elD == 0) {
                        x.w("MicroMsg.OnlineVideoUIHelper", "it had not moov callback and download finish start to play video.");
                        f.bCx();
                        h.mEJ.a(354, 6, 1, false);
                    } else if (f.elD == 5) {
                        x.w("MicroMsg.OnlineVideoUIHelper", "it had play error, it request all video data finish, start to play." + f.mediaId);
                        f.bCx();
                    }
                    f.cxD();
                    h.mEJ.a(354, 26, 1, false);
                    this.tWK.bS(true);
                    break;
                case 5:
                    f = i.f(this.tWK);
                    String str = laVar.bVm.mediaId;
                    i = laVar.bVm.offset;
                    if (f.NS(str)) {
                        f.nPN = (i * 100) / f.fhf;
                        x.i("MicroMsg.OnlineVideoUIHelper", "deal progress callback. downloadedPercent : " + f.nPN);
                    }
                    if (f.nPN >= 100) {
                        f.elC = 3;
                        break;
                    }
                    break;
                case 6:
                    f = i.f(this.tWK);
                    x.i("MicroMsg.OnlineVideoUIHelper", "deal had dup video.");
                    f.cxD();
                    f.bCx();
                    break;
                default:
                    x.w("MicroMsg.Imagegallery.handler.video", "unknown event opcode " + laVar.bVm.bOh);
                    break;
            }
            return false;
        }
        x.w("MicroMsg.Imagegallery.handler.video", "stream download online video error. retCode: " + laVar.bVm.retCode);
        i.a(this.tWK, laVar.bVm.mediaId, laVar.bVm.retCode);
        return false;
    }
}

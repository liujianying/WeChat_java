package com.tencent.mm.modelcdntran;

import com.tencent.mm.g.a.la;
import com.tencent.mm.g.a.la.a;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.q;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.smtt.sdk.TbsListener$ErrorCode;

class f$5 implements Runnable {
    final /* synthetic */ f dPC;
    final /* synthetic */ int dPF;
    final /* synthetic */ int dPG;
    final /* synthetic */ String sl;

    f$5(f fVar, String str, int i, int i2) {
        this.dPC = fVar;
        this.sl = str;
        this.dPF = i;
        this.dPG = i2;
    }

    public final void run() {
        boolean z = false;
        j jVar = (j) this.dPC.dOW.get(this.sl);
        if (jVar != null) {
            jVar.dQs = (long) this.dPF;
            if (jVar.dQt != null) {
                jVar.dQt.onMoovReady(this.sl, this.dPF, this.dPG);
            } else if (q.nD(jVar.field_fullpath)) {
                x.w("MicroMsg.OnlineVideoService", "it is qt video, need finish all file. isPlayMode" + jVar.dQm);
                if (jVar.dQm == 1) {
                    f.g(jVar.field_mediaId, 0, jVar.field_totalLen);
                    h.mEJ.a(354, 19, 1, false);
                }
            } else {
                la laVar = new la();
                laVar.bVm.bOh = 1;
                laVar.bVm.retCode = 0;
                laVar.bVm.mediaId = this.sl;
                laVar.bVm.offset = this.dPF;
                laVar.bVm.length = this.dPG;
                laVar.bVm.bVn = jVar.dQj;
                a aVar = laVar.bVm;
                if (jVar.initialDownloadLength > 0) {
                    z = true;
                }
                aVar.bVo = z;
                com.tencent.mm.sdk.b.a.sFg.m(laVar);
                r nW = t.nW(jVar.filename);
                if (nW != null) {
                    x.i("MicroMsg.OnlineVideoService", "on moov ready info: " + nW.getFileName() + " status : " + nW.status);
                    if (nW.status != 130 && nW.status != TbsListener$ErrorCode.DOWNLOAD_HAS_COPY_TBS_ERROR) {
                        nW = t.nW(jVar.filename);
                        if (nW != null) {
                            nW.status = TbsListener$ErrorCode.THREAD_INIT_ERROR;
                            nW.bWA = 256;
                            o.Ta().b(nW);
                        }
                        if (jVar.dQm == 0) {
                            x.i("MicroMsg.OnlineVideoService", "stop download video");
                            o.Tf().Tx();
                            o.Tf().run();
                        }
                    }
                }
            }
        }
    }
}

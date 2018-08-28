package com.tencent.mm.modelcdntran;

import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mm.g.a.la;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class f$8 implements Runnable {
    final /* synthetic */ f dPC;
    final /* synthetic */ keep_ProgressInfo dPe;
    final /* synthetic */ keep_SceneResult dPf;
    final /* synthetic */ String sl;

    f$8(f fVar, String str, keep_ProgressInfo keep_progressinfo, keep_SceneResult keep_sceneresult) {
        this.dPC = fVar;
        this.sl = str;
        this.dPe = keep_progressinfo;
        this.dPf = keep_sceneresult;
    }

    public final void run() {
        j jVar = (j) this.dPC.dOW.get(this.sl);
        if (jVar != null) {
            if (jVar.dQt == null) {
                r nW = t.nW(jVar.filename);
                la laVar;
                if (nW == null) {
                    x.w("MicroMsg.OnlineVideoService", "stream download video callback, but video info is null.[%s]", new Object[]{jVar.filename});
                } else if (jVar.dPV != null) {
                    jVar.dPV.a(this.sl, 0, this.dPe, this.dPf, jVar.field_onlycheckexist);
                    if (this.dPf != null) {
                        this.dPC.dOW.remove(this.sl);
                    }
                } else if (this.dPe != null) {
                    if (this.dPe.field_finishedLength == nW.dHI) {
                        x.i("MicroMsg.OnlineVideoService", "stream download finish.");
                    } else if (nW.status == 130 || nW.enH <= this.dPe.field_finishedLength) {
                        x.i("MicroMsg.OnlineVideoService", "callback progress info " + this.dPe.field_finishedLength);
                        nW.enK = bi.VE();
                        nW.enH = this.dPe.field_finishedLength;
                        nW.bWA = 1040;
                        t.e(nW);
                        laVar = new la();
                        laVar.bVm.bOh = 5;
                        laVar.bVm.mediaId = this.sl;
                        laVar.bVm.offset = this.dPe.field_finishedLength;
                        laVar.bVm.length = this.dPe.field_toltalLength;
                        a.sFg.m(laVar);
                    } else {
                        x.w("MicroMsg.OnlineVideoService", "set video error. db now size %d, cdn callback %d.", new Object[]{Integer.valueOf(nW.enH), Integer.valueOf(this.dPe.field_finishedLength)});
                    }
                } else if (this.dPf != null) {
                    x.i("MicroMsg.OnlineVideoService", "callback result info " + this.dPf.field_retCode + ", filesize:" + this.dPf.field_fileLength + ",recved:" + this.dPf.field_recvedBytes);
                    if (this.dPf.field_retCode != 0) {
                        if (this.dPf.field_retCode != -10012) {
                            t.nP(nW.getFileName());
                        }
                        boolean NI = jVar.NI();
                        int i = this.dPf.field_retCode;
                        int i2 = jVar.dQm;
                        if (NI) {
                            if (i2 == 1) {
                                if (i == -5103059) {
                                    h.mEJ.a(354, 111, 1, false);
                                } else if (i == -5103087) {
                                    h.mEJ.a(354, 112, 1, false);
                                } else if (i == -10012) {
                                    h.mEJ.a(354, 113, 1, false);
                                } else {
                                    h.mEJ.a(354, 114, 1, false);
                                }
                            } else if (i == -5103059) {
                                h.mEJ.a(354, 116, 1, false);
                            } else if (i == -5103087) {
                                h.mEJ.a(354, 117, 1, false);
                            } else if (i == -10012) {
                                h.mEJ.a(354, 118, 1, false);
                            } else {
                                h.mEJ.a(354, 119, 1, false);
                            }
                            h.mEJ.h(13836, new Object[]{Integer.valueOf(101), Long.valueOf(bi.VE()), Integer.valueOf(i)});
                        } else {
                            h.mEJ.a(354, 213, 1, false);
                            if (i2 == 1) {
                                h.mEJ.a(354, 214, 1, false);
                            } else {
                                h.mEJ.a(354, 215, 1, false);
                            }
                            h.mEJ.h(13836, new Object[]{Integer.valueOf(CdnLogic.kAppTypeNearEvent), Long.valueOf(bi.VE()), Integer.valueOf(i)});
                        }
                    } else {
                        f.a(nW, this.dPf.field_fileLength, jVar.dQk);
                        this.dPC.dPA.put(jVar.field_mediaId, jVar);
                        this.dPC.dPB.put(jVar.field_mediaId, this.dPf);
                    }
                    laVar = new la();
                    laVar.bVm.bOh = 4;
                    laVar.bVm.mediaId = this.sl;
                    laVar.bVm.offset = 0;
                    laVar.bVm.retCode = this.dPf.field_retCode;
                    laVar.bVm.length = this.dPf.field_fileLength;
                    a.sFg.m(laVar);
                    this.dPC.dOW.remove(this.sl);
                }
            } else if (this.dPe != null) {
                jVar.dQt.h(this.sl, this.dPe.field_finishedLength, this.dPe.field_toltalLength);
            } else if (this.dPf != null) {
                jVar.dQt.L(this.sl, this.dPf.field_retCode);
                this.dPC.dOW.remove(this.sl);
            }
        }
    }
}

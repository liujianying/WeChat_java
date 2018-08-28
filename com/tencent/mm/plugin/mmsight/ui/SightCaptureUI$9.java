package com.tencent.mm.plugin.mmsight.ui;

import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.mmsight.d;
import com.tencent.mm.plugin.mmsight.model.e.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class SightCaptureUI$9 implements Runnable {
    final /* synthetic */ int iSA;
    final /* synthetic */ int iSz;
    final /* synthetic */ SightCaptureUI lqr;

    SightCaptureUI$9(SightCaptureUI sightCaptureUI, int i, int i2) {
        this.lqr = sightCaptureUI;
        this.iSA = i;
        this.iSz = i2;
    }

    public final void run() {
        x.l("MicroMsg.SightCaptureUI", "call stop callback now, currentStatus: %s", new Object[]{SightCaptureUI.td(SightCaptureUI.e(this.lqr))});
        SightCaptureUI.h(this.lqr).a(a.lgf);
        SightCaptureUI.A(this.lqr);
        e.post(new 1(this, d.Hq("TIME_RECODER_2_PLAY")), "BigSightFFMpegRecorder_markAfterCaptureFinish_idkeystat");
        x.v("MicroMsg.TestCaptureUiEvent", "doStopRecorderAndStartPreviewDone %s", new Object[]{bi.cjd().toString()});
        x.i("MicroMsg.SightCaptureUI", "stop finish, filepath: %s %s time_takevideo %s", new Object[]{SightCaptureUI.n(this.lqr).getFilePath(), Long.valueOf(FileOp.mI(SightCaptureUI.n(this.lqr).getFilePath())), Long.valueOf(r0)});
        SightCaptureUI.a(this.lqr, SightCaptureUI.n(this.lqr).Xh());
        SightCaptureUI.z(this.lqr);
        SightCaptureUI.K(this.lqr);
        SightCaptureUI.L(this.lqr);
        ah.i(SightCaptureUI.M(this.lqr), 1000);
        if (SightCaptureUI.a(this.lqr).scene == 1 || SightCaptureUI.a(this.lqr).scene == 2) {
            h.mEJ.h(13819, new Object[]{Integer.valueOf(2), Integer.valueOf(SightCaptureUI.a(this.lqr).scene), SightCaptureUI.a(this.lqr).leu, Long.valueOf(bi.VE())});
        }
    }
}

package com.tencent.mm.plugin.mmsight.ui;

import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.mmsight.model.a;
import com.tencent.mm.plugin.mmsight.model.j;
import com.tencent.mm.plugin.mmsight.model.k;
import com.tencent.mm.plugin.mmsight.ui.SightCaptureUI.9;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.sight.base.d;
import com.tencent.mm.protocal.c.aso;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

class SightCaptureUI$9$1 implements Runnable {
    final /* synthetic */ long lqt;
    final /* synthetic */ 9 lqu;

    SightCaptureUI$9$1(9 9, long j) {
        this.lqu = 9;
        this.lqt = j;
    }

    public final void run() {
        String filePath = SightCaptureUI.n(this.lqu.lqr).getFilePath();
        aso J = SightCaptureUI.J(this.lqu.lqr);
        try {
            if (!bi.oW(filePath) && FileOp.cn(filePath)) {
                int i;
                int i2;
                int i3;
                int i4;
                int i5;
                h.mEJ.a(440, 87, 1, false);
                JSONObject jSONObject = new JSONObject(SightVideoJNI.getSimpleMp4Info(filePath));
                int i6 = (int) jSONObject.getDouble("videoFPS");
                int optInt = jSONObject.optInt("videoBitrate");
                x.i("MicroMsg.MMSightRecorderIDKeyStat", "markAfterCaptureFinish, videoFPS: %s, videoBitrate: %s", new Object[]{Integer.valueOf(i6), Integer.valueOf(optInt)});
                a bdH = a.bdH();
                bdH.leY = j.lgz.dfb;
                bdH.videoBitrate = j.lgz.videoBitrate;
                bdH.dfc = j.lgz.lgJ ? 1 : 0;
                bdH.leZ = j.lgz.lgK ? 1 : 0;
                bdH.lfa = j.lgz.lfa;
                bdH.lfb = i6;
                bdH.fileSize = FileOp.mI(filePath);
                com.tencent.mm.plugin.sight.base.a Lo = d.Lo(filePath);
                if (Lo != null) {
                    bdH.lfe = Lo.width;
                    bdH.lff = Lo.height;
                    bdH.lfg = Lo.videoBitrate;
                    bdH.lfc = Lo.jdD;
                }
                if (j.lgz.dfb == 1) {
                    h.mEJ.a(440, 89, 1, false);
                    h.mEJ.a(440, 49, (long) i6, false);
                    i = 93;
                    i2 = 73;
                    i3 = 69;
                } else {
                    h.mEJ.a(440, 88, 1, false);
                    h.mEJ.a(440, 48, (long) i6, false);
                    i = 90;
                    i2 = 54;
                    i3 = 50;
                }
                if (j.lgz.lfa == 720) {
                    i2 += 6;
                    i4 = i + 1;
                    i5 = i3 + 6;
                } else if (j.lgz.beb()) {
                    i2 += 12;
                    i4 = i + 2;
                    i5 = i3 + 12;
                } else {
                    i4 = i;
                    i5 = i3;
                }
                h.mEJ.a(440, (long) i2, (long) i6, false);
                h.mEJ.a(440, (long) i4, 1, false);
                h.mEJ.a(440, 47, (long) i6, false);
                x.i("MicroMsg.MMSightRecorderIDKeyStat", "markAfterCaptureFinish, filePath: %s base %d", new Object[]{filePath, Integer.valueOf(i5)});
                if (i6 >= 0 && i6 <= 10) {
                    h.mEJ.a(440, (long) i5, 1, false);
                } else if (i6 > 10 && i6 <= 15) {
                    h.mEJ.a(440, (long) (i5 + 1), 1, false);
                } else if (i6 > 15 && i6 <= 20) {
                    h.mEJ.a(440, (long) (i5 + 2), 1, false);
                } else if (i6 > 20 && i6 <= 30) {
                    h.mEJ.a(440, (long) (i5 + 3), 1, false);
                }
                if (optInt > 0) {
                    if (j.lgz.dfb == 2) {
                        h.mEJ.a(440, 175, (long) optInt, false);
                        h.mEJ.a(440, 176, 1, false);
                        if (J != null) {
                            if (J.rUR == 1) {
                                h.mEJ.a(440, 184, (long) optInt, false);
                                h.mEJ.a(440, 185, 1, false);
                            } else if (J.rUR == 2) {
                                h.mEJ.a(440, 194, (long) optInt, false);
                                h.mEJ.a(440, 195, 1, false);
                            }
                        }
                    } else {
                        h.mEJ.a(440, 179, (long) optInt, false);
                        h.mEJ.a(440, 180, 1, false);
                        if (J != null) {
                            if (J.rUR == 1) {
                                h.mEJ.a(440, 189, (long) optInt, false);
                                h.mEJ.a(440, 190, 1, false);
                            } else if (J.rUR == 2) {
                                h.mEJ.a(440, 199, (long) optInt, false);
                                h.mEJ.a(440, 200, 1, false);
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            x.e("MicroMsg.MMSightRecorderIDKeyStat", "markAfterCaptureFinish error: %s", new Object[]{e.getMessage()});
        }
        k.c(false, this.lqt);
    }
}

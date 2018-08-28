package com.tencent.mm.plugin.voip.video;

import android.hardware.Camera;
import android.hardware.Camera.PreviewCallback;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.voip.b.d;
import com.tencent.mm.plugin.voip.model.i;
import com.tencent.mm.plugin.voip.model.l;
import com.tencent.mm.plugin.voip.model.r;
import com.tencent.mm.sdk.platformtools.x;

class a$2 implements PreviewCallback {
    final /* synthetic */ a oTF;

    a$2(a aVar) {
        this.oTF = aVar;
    }

    public final void onPreviewFrame(byte[] bArr, Camera camera) {
        if (bArr == null || bArr.length <= 0) {
            h.mEJ.a(159, 0, 1, false);
            h.mEJ.a(159, 3, 1, false);
            if (this.oTF.oTt != null) {
                this.oTF.oTt.bgV();
            }
        } else if (this.oTF.oTm == null) {
            x.e("MicroMsg.Voip.CaptureRender", "onPreviewFrame mSize is null");
        } else if (this.oTF.oTt != null) {
            int i;
            boolean z;
            int i2;
            int i3;
            boolean z2;
            int i4;
            if (this.oTF.oTc) {
                i4 = j.oVr;
                if (q.deM.dcO && q.deM.dcN.bYE != 0) {
                    i = q.deM.dcN.ddr;
                    z = true;
                    i2 = i4;
                }
                z = false;
                i = 1;
                i2 = i4;
            } else {
                i4 = j.oVs;
                if (q.deM.dcQ && q.deM.dcP.bYE != 0) {
                    i = q.deM.dcP.ddr;
                    z = true;
                    i2 = i4;
                }
                z = false;
                i = 1;
                i2 = i4;
            }
            if (i2 > 0) {
                i3 = 32;
            } else {
                i3 = 0;
            }
            a aVar = this.oTF;
            if (z || i2 <= 0) {
                z2 = false;
            } else {
                z2 = true;
            }
            aVar.oTd = z2;
            i2 = this.oTF.oTm.width;
            int i5 = this.oTF.oTm.height;
            if (z) {
                if (this.oTF.oTw == null) {
                    this.oTF.oTw = new byte[(((i2 * i5) * 3) / 2)];
                    this.oTF.oTw[0] = (byte) 90;
                }
                r bJI = i.bJI();
                int length = bArr.length;
                int i6 = this.oTF.oTn;
                byte[] bArr2 = this.oTF.oTw;
                int length2 = this.oTF.oTw.length;
                l lVar = bJI.oNa.oHa.oJZ;
                if (lVar.oKv != l.oKu && lVar.oHa.oJX.lkO && lVar.oHa.bJV()) {
                    lVar.oHa.oJX.videoRorate90D(bArr, length, i2, i5, i6, bArr2, length2, i2, i5, i);
                }
                this.oTF.oTt.c(this.oTF.oTw, (long) this.oTF.oTw.length, i2, i5, this.oTF.oTn + i3);
            } else {
                this.oTF.oTt.c(bArr, (long) bArr.length, this.oTF.oTm.width, this.oTF.oTm.height, this.oTF.oTn + i3);
            }
            if (d.bLQ() >= 8) {
                this.oTF.oTk.addCallbackBuffer(bArr);
            }
        }
    }
}

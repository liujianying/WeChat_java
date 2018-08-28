package com.tencent.mm.plugin.mmsight.model;

import android.hardware.Camera;
import android.hardware.Camera.PreviewCallback;
import com.tencent.mm.compatible.e.m;
import com.tencent.mm.plugin.base.model.a;
import com.tencent.mm.plugin.mmsight.model.a.j;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class e$1 implements PreviewCallback {
    final /* synthetic */ e lgc;

    e$1(e eVar) {
        this.lgc = eVar;
    }

    public final void onPreviewFrame(byte[] bArr, Camera camera) {
        boolean z = false;
        if (!e.a(this.lgc)) {
            x.i("MicroMsg.MMSightCamera", "onPreviewFrame: %s %s", new Object[]{bArr, e.b(this.lgc)});
            e.c(this.lgc);
        }
        if (bArr == null || bArr.length <= 0) {
            x.e("MicroMsg.MMSightCamera", "onPreviewFrame, frame data is null!!");
            e.d(this.lgc);
            return;
        }
        byte[] bArr2;
        byte[] bArr3;
        a e = e.e(this.lgc);
        if (e.hds == 0) {
            e.hdr++;
            e.hdq = bi.WU(m.zm());
        }
        e.hds++;
        e.hds = e.hds >= 90 ? 0 : e.hds;
        long VG;
        int i;
        if (e.f(this.lgc) || e.g(this.lgc) == null || e.g(this.lgc).size() <= 0) {
            bArr2 = bArr;
            bArr3 = bArr;
        } else if (e.h(this.lgc) != null) {
            byte[] i2 = j.lin.i(Integer.valueOf(((e.h(this.lgc).x * e.h(this.lgc).y) * 3) / 2));
            e.i(this.lgc).ec(1);
            VG = bi.VG();
            SightVideoJNI.cropCameraData(bArr, i2, e.j(this.lgc).iSp, e.j(this.lgc).iSq, e.h(this.lgc).y);
            e.k(this.lgc).ec(bi.bI(VG));
            if (!e.l(this.lgc)) {
                VG = bi.VG();
                i = e.h(this.lgc).x;
                int i3 = e.h(this.lgc).y;
                if (this.lgc.lfx.bYE == 270 || this.lgc.lfx.bYE == 90) {
                    z = true;
                }
                SightVideoJNI.mirrorCameraData(i2, i, i3, z);
                e.m(this.lgc).ec(bi.bI(VG));
            }
            long j = VG;
            boolean a = e.a(this.lgc, i2);
            j = bi.bI(j);
            if (a) {
                e.n(this.lgc).ec(j);
            }
            bArr2 = bArr;
            bArr3 = i2;
        } else {
            VG = bi.VG();
            if (!e.l(this.lgc)) {
                i = e.j(this.lgc).iSp;
                int i4 = e.j(this.lgc).iSq;
                if (this.lgc.lfx.bYE == 270 || this.lgc.lfx.bYE == 90) {
                    z = true;
                }
                SightVideoJNI.mirrorCameraData(bArr, i, i4, z);
                e.m(this.lgc).ec(bi.bI(VG));
            }
            if (!e.o(this.lgc) || e.p(this.lgc) == null) {
                bArr3 = bArr;
            } else {
                SightVideoJNI.paddingYuvData16(bArr, e.p(this.lgc), e.q(this.lgc).x, e.r(this.lgc).y, e.q(this.lgc).y);
                bArr3 = e.p(this.lgc);
            }
            z = e.a(this.lgc, bArr3);
            long bI = bi.bI(VG);
            if (z) {
                e.n(this.lgc).ec(bI);
            }
            if ((!e.o(this.lgc) || e.p(this.lgc) == null) && z) {
                bArr = j.lin.i(Integer.valueOf(bArr.length));
            }
            if (e.o(this.lgc) && e.p(this.lgc) != null) {
                e eVar = this.lgc;
                if (z) {
                    bArr2 = j.lin.i(Integer.valueOf(e.p(this.lgc).length));
                } else {
                    bArr2 = e.p(this.lgc);
                }
                e.b(eVar, bArr2);
            }
            bArr2 = bArr;
        }
        e.c(this.lgc, bArr3);
        if (e.s(this.lgc) == e.a.lgd) {
            e.t(this.lgc).ec(1);
        } else if (e.s(this.lgc) == e.a.lge) {
            e.u(this.lgc).ec(1);
        }
        e.b(this.lgc).addCallbackBuffer(bArr2);
    }
}

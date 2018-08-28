package com.tencent.mm.plugin.mmsight.model.a;

import com.tencent.mm.plugin.mmsight.model.a.b.a;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class b$1 implements Runnable {
    final /* synthetic */ b lhA;
    final /* synthetic */ a lhz;

    b$1(b bVar, a aVar) {
        this.lhA = bVar;
        this.lhz = aVar;
    }

    public final void run() {
        b bVar = this.lhA;
        x.i("MicroMsg.FrameBufProcessor", "process srcWidth %d srcHeight %d targetWidth %d targetHeight %d bufIndex: %d", new Object[]{Integer.valueOf(bVar.lht), Integer.valueOf(bVar.lhu), Integer.valueOf(bVar.kGn), Integer.valueOf(bVar.kGo), Integer.valueOf(bVar.lhr)});
        if (bVar.lhv == 21 || bVar.lhv == 2130706688) {
            SightVideoJNI.NV21ToYUV420XXAndScaleRotate(bVar.lho, bVar.lhp, bVar.lht, bVar.lhu, bVar.kGn, bVar.kGo, 1, bVar.bYE, bVar.lhw, bVar.lhy, bVar.lhx);
        } else if (bVar.lhv == 19) {
            SightVideoJNI.NV21ToYUV420XXAndScaleRotate(bVar.lho, bVar.lhp, bVar.lht, bVar.lhu, bVar.kGn, bVar.kGo, 2, bVar.bYE, bVar.lhw, bVar.lhy, bVar.lhx);
        }
        x.v("MicroMsg.FrameBufProcessor", "process used %sms %d %d bufIndex %d", new Object[]{Long.valueOf(bi.bI(bVar.lhs)), Integer.valueOf(bVar.lho.length), Integer.valueOf(bVar.lhp.length), Integer.valueOf(bVar.lhr)});
        this.lhz.a(this.lhA);
        j.lin.F(this.lhA.lho);
    }
}

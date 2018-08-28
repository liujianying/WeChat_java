package com.tencent.mm.plugin.facedetect.d;

import android.os.CountDownTimer;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;

class d$2 extends CountDownTimer {
    final /* synthetic */ d iPx;

    d$2(d dVar) {
        this.iPx = dVar;
        super(Long.MAX_VALUE, 1000);
    }

    public final void onTick(long j) {
        x.i("MicroMsg.NumberFaceMotion", "hy: on ticked");
        if (this.iPx.hxu) {
            x.w("MicroMsg.NumberFaceMotion", "hy: isEnd. trigger cancel");
            cancel();
        } else if (this.iPx.iPj) {
            x.i("MicroMsg.NumberFaceMotion", "hy: suspend.");
        } else {
            x.i("MicroMsg.NumberFaceMotion", "hy: mCurrentShowedIndexInItem: %d, mItemDatas[mCurrentGroupDataIndex].length() - 1: %d, mCurrentGroupDataIndex: %d, mItemDatas.length - 1 : %d", new Object[]{Integer.valueOf(this.iPx.iPe), Integer.valueOf(this.iPx.iPc[this.iPx.iPd].length() - 1), Integer.valueOf(this.iPx.iPd), Integer.valueOf(this.iPx.iPc.length - 1)});
            if (this.iPx.iPe < this.iPx.iPc[this.iPx.iPd].length() - 1) {
                d dVar = this.iPx;
                dVar.iPe++;
                this.iPx.iPt.sendEmptyMessage(0);
                return;
            }
            x.i("MicroMsg.NumberFaceMotion", "hy: last number in group");
            ah.i(this.iPx.iPw, 1500);
            this.iPx.hxu = true;
            cancel();
            this.iPx.hxu = true;
        }
    }

    public final void onFinish() {
        x.i("MicroMsg.NumberFaceMotion", "hy: on count number finished");
    }
}

package com.tencent.mm.plugin.mmsight.model.a;

import android.os.Message;
import com.tencent.mm.plugin.mmsight.model.a.d.c;
import com.tencent.mm.plugin.mmsight.model.f;
import com.tencent.mm.sdk.platformtools.x;

class n$1 implements f {
    final /* synthetic */ n ljp;

    n$1(n nVar) {
        this.ljp = nVar;
    }

    public final boolean T(byte[] bArr) {
        if (bArr == null || bArr.length <= 0) {
            return false;
        }
        if (this.ljp.lis.ljK != c.lhC && this.ljp.lis.ljK != c.lhD) {
            return false;
        }
        if (this.ljp.lis.ljK == c.lhD) {
            this.ljp.lis.ljK = c.lhE;
            x.v("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "forward one more frame");
        }
        this.ljp.ljm.ec(1);
        if (this.ljp.ljf != null) {
            this.ljp.ljf.bef();
        }
        if (this.ljp.ljg != null) {
            Message obtain = Message.obtain();
            obtain.what = 1;
            obtain.obj = bArr;
            if (this.ljp.ljj != null) {
                this.ljp.ljj.sendMessage(obtain);
            }
        }
        return true;
    }
}

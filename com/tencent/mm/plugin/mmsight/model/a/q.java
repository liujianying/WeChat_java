package com.tencent.mm.plugin.mmsight.model.a;

import android.annotation.TargetApi;
import android.media.MediaCodec.BufferInfo;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.nio.ByteBuffer;

@TargetApi(16)
public final class q extends r {
    protected int lhM = -1;

    public q(int i, int i2, int i3, int i4, int i5, int i6, int i7, boolean z) {
        super(i, i2, i3, i4, i5, i6, i7, z);
    }

    public final int cQ(int i, int i2) {
        this.lhM = i;
        return super.cQ(i, i2);
    }

    protected final void e(ByteBuffer byteBuffer, BufferInfo bufferInfo) {
        if (this.lhM >= 0 && byteBuffer != null && bufferInfo != null) {
            long VG = bi.VG();
            SightVideoJNI.writeH264Data(this.lhM, byteBuffer, bufferInfo.size);
            x.i("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "writeH264Data used %sms, size: %s", new Object[]{Long.valueOf(bi.bI(VG)), Integer.valueOf(bufferInfo.size)});
        }
    }

    public final void clear() {
        super.clear();
        SightVideoJNI.releaseBigSightDataBuffer(this.lhM);
    }
}

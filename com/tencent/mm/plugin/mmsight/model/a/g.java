package com.tencent.mm.plugin.mmsight.model.a;

import android.annotation.TargetApi;
import android.media.MediaCodec.BufferInfo;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import java.nio.ByteBuffer;

@TargetApi(16)
public final class g extends h {
    private int lhM = -1;

    public g(int i, int i2) {
        super(i, i2);
    }

    public final int at(int i, String str) {
        this.lhM = i;
        return super.at(i, str);
    }

    protected final void e(ByteBuffer byteBuffer, BufferInfo bufferInfo) {
        if (this.lhM >= 0 && byteBuffer != null && bufferInfo != null && !this.lib) {
            SightVideoJNI.writeAACData(this.lhM, byteBuffer, bufferInfo.size);
        }
    }

    protected final boolean bex() {
        return true;
    }
}

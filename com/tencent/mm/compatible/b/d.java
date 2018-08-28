package com.tencent.mm.compatible.b;

import android.media.AudioTrack;

public final class d extends AudioTrack {
    public d(int i, int i2, int i3, int i4) {
        super(i, i2, i3, 2, i4, 1);
        f.fF(hashCode());
    }

    public final void release() {
        super.release();
        f.fG(hashCode());
    }
}

package com.google.android.exoplayer2.c.c;

import com.tencent.map.lib.mapstructure.MapRouteSectionWithName;
import java.util.Arrays;

final class i$a {
    static final byte[] anw = new byte[]{(byte) 0, (byte) 0, (byte) 1};
    boolean anx;
    public int any;
    public byte[] data = new byte[MapRouteSectionWithName.kMaxRoadNameLength];
    public int length;

    public final void d(byte[] bArr, int i, int i2) {
        if (this.anx) {
            int i3 = i2 - i;
            if (this.data.length < this.length + i3) {
                this.data = Arrays.copyOf(this.data, (this.length + i3) * 2);
            }
            System.arraycopy(bArr, i, this.data, this.length, i3);
            this.length = i3 + this.length;
        }
    }
}

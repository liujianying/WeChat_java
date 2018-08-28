package com.tencent.mm.plugin.gif;

import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class e {
    public final int[] khG = new int[6];

    public e(String str) {
        try {
            MMGIFJNI.recycle(MMGIFJNI.openByFilePath(str, this.khG));
            x.i("MMGIFInfo", "width:%d height:%d", new Object[]{Integer.valueOf(this.khG[0]), Integer.valueOf(this.khG[1])});
        } catch (MMGIFException e) {
            x.e("MMGIFInfo", bi.i(e));
        }
    }
}

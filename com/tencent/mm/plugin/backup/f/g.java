package com.tencent.mm.plugin.backup.f;

import android.os.Looper;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.smtt.sdk.TbsReaderView$ReaderCallback;

public final class g {
    static int index = 0;
    private a gWF;
    int[] gYd = new int[]{1000, 1000, 1000, 2000, TbsReaderView$ReaderCallback.GET_BAR_ANIMATING, 9000, 13000, 26000, 26000, 26000};
    int gYe = 0;
    boolean gYf = false;
    al gYg = new al(Looper.getMainLooper(), new 1(this), false);

    public interface a {
        void asc();

        void asd();
    }

    static /* synthetic */ int KF() {
        int i = index;
        index = i + 1;
        return i;
    }

    public g(a aVar) {
        this.gWF = aVar;
    }
}

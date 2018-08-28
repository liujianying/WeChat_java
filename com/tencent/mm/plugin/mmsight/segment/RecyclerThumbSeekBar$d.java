package com.tencent.mm.plugin.mmsight.segment;

import android.os.HandlerThread;
import com.tencent.mm.plugin.mmsight.segment.RecyclerThumbSeekBar.b;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ag;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

class RecyclerThumbSeekBar$d {
    ag handler = new ag();
    int lhd = 4;
    final /* synthetic */ RecyclerThumbSeekBar llX;
    HandlerThread[] lmg = new HandlerThread[this.lhd];
    int lmh = 0;
    private BlockingDeque<b> lmi = new LinkedBlockingDeque();

    public RecyclerThumbSeekBar$d(RecyclerThumbSeekBar recyclerThumbSeekBar) {
        this.llX = recyclerThumbSeekBar;
        for (int i = 0; i < this.lmg.length; i++) {
            this.lmg[i] = e.cZ("RecyclerThumbSeekBar_SimpleImageLoader_" + i, -1);
            this.lmg[i].start();
        }
        this.lmh = 0;
    }
}

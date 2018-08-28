package com.tencent.mm.plugin.mmsight.segment;

import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.x;

class RecyclerThumbSeekBar$2 implements Runnable {
    final /* synthetic */ RecyclerThumbSeekBar llX;

    RecyclerThumbSeekBar$2(RecyclerThumbSeekBar recyclerThumbSeekBar) {
        this.llX = recyclerThumbSeekBar;
    }

    public final void run() {
        if (this.llX.getHeight() == 0 || this.llX.getWidth() == 0) {
            this.llX.post(RecyclerThumbSeekBar.e(this.llX));
            return;
        }
        RecyclerThumbSeekBar.a(this.llX, this.llX.getHeight());
        RecyclerThumbSeekBar.b(this.llX, (this.llX.getWidth() - (RecyclerThumbSeekBar.f(this.llX) * 2)) / 12);
        e.post(new Runnable() {
            public final void run() {
                int i;
                try {
                    d beP = RecyclerThumbSeekBar.g(RecyclerThumbSeekBar$2.this.llX).beP();
                    RecyclerThumbSeekBar.c(RecyclerThumbSeekBar$2.this.llX, beP.getDurationMs());
                    RecyclerThumbSeekBar.g(RecyclerThumbSeekBar$2.this.llX).a(beP);
                    i = 1;
                } catch (Throwable e) {
                    x.printErrStackTrace("RecyclerThumbSeekBar", e, "Try to init fetcher error : %s", new Object[]{e.getMessage()});
                    i = 0;
                }
                if (i == 0) {
                    RecyclerThumbSeekBar.h(RecyclerThumbSeekBar$2.this.llX);
                    return;
                }
                if (RecyclerThumbSeekBar.i(RecyclerThumbSeekBar$2.this.llX) >= 10000) {
                    RecyclerThumbSeekBar.d(RecyclerThumbSeekBar$2.this.llX, (RecyclerThumbSeekBar.j(RecyclerThumbSeekBar$2.this.llX).duration * 1000) / 10);
                } else if (RecyclerThumbSeekBar.i(RecyclerThumbSeekBar$2.this.llX) > 0) {
                    RecyclerThumbSeekBar.d(RecyclerThumbSeekBar$2.this.llX, RecyclerThumbSeekBar.i(RecyclerThumbSeekBar$2.this.llX) / 10);
                } else {
                    x.e("RecyclerThumbSeekBar", "RecyclerThumbSeekBar duration invalid %d", new Object[]{Integer.valueOf(RecyclerThumbSeekBar.i(RecyclerThumbSeekBar$2.this.llX))});
                    RecyclerThumbSeekBar.h(RecyclerThumbSeekBar$2.this.llX);
                    return;
                }
                x.d("RecyclerThumbSeekBar", "duration %d interval %d", new Object[]{Integer.valueOf(RecyclerThumbSeekBar.i(RecyclerThumbSeekBar$2.this.llX)), Integer.valueOf(RecyclerThumbSeekBar.b(RecyclerThumbSeekBar$2.this.llX))});
                RecyclerThumbSeekBar.k(RecyclerThumbSeekBar$2.this.llX);
            }
        }, "check duration of ");
    }
}

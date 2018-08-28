package com.tencent.mm.plugin.mmsight.segment;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.mm.memory.o;
import com.tencent.mm.memory.o.b;
import com.tencent.mm.plugin.mmsight.segment.RecyclerThumbSeekBar.a;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.ref.WeakReference;

class RecyclerThumbSeekBar$b implements Runnable {
    private WeakReference<ImageView> YB;
    boolean dZm = false;
    private ag handler;
    final /* synthetic */ RecyclerThumbSeekBar llX;
    private Bitmap lma;
    private int time;

    RecyclerThumbSeekBar$b(RecyclerThumbSeekBar recyclerThumbSeekBar, int i, ImageView imageView, Bitmap bitmap, ag agVar) {
        this.llX = recyclerThumbSeekBar;
        this.time = i;
        this.YB = new WeakReference(imageView);
        this.handler = agVar;
        this.lma = bitmap;
    }

    public final void run() {
        if (this.dZm) {
            o.dvq.aQ(this.lma);
        } else if (((ImageView) this.YB.get()) == null) {
            o.dvq.aQ(this.lma);
        } else {
            try {
                d beP = RecyclerThumbSeekBar.g(this.llX).beP();
                if (this.lma == null) {
                    this.lma = o.dvq.a(new b(beP.getScaledWidth(), beP.getScaledHeight()));
                }
                beP.reuseBitmap(this.lma);
                if (!this.dZm) {
                    this.lma = beP.getFrameAtTime((long) this.time);
                }
                RecyclerThumbSeekBar.g(this.llX).a(beP);
                if (this.lma == null || this.dZm || this.YB.get() == null) {
                    o.dvq.aQ(this.lma);
                } else {
                    this.handler.post(new a(this.llX, this.lma, (ImageView) this.YB.get(), this));
                }
            } catch (Exception e) {
                x.e("RecyclerThumbSeekBar", "get bitmap error " + e.getMessage());
                o.dvq.aQ(this.lma);
            }
        }
    }
}

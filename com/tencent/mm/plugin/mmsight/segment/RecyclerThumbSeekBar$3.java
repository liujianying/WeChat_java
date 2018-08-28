package com.tencent.mm.plugin.mmsight.segment;

import com.tencent.mm.plugin.mmsight.segment.RecyclerThumbSeekBar.c;
import com.tencent.mm.plugin.mmsight.segment.n.1;
import com.tencent.mm.sdk.platformtools.x;

class RecyclerThumbSeekBar$3 implements Runnable {
    final /* synthetic */ RecyclerThumbSeekBar llX;

    RecyclerThumbSeekBar$3(RecyclerThumbSeekBar recyclerThumbSeekBar) {
        this.llX = recyclerThumbSeekBar;
    }

    public final void run() {
        int i = 1000;
        try {
            RecyclerThumbSeekBar.l(this.llX).setCursorPos(-1.0f);
            RecyclerThumbSeekBar.a(this.llX, new c(this.llX, (byte) 0));
            int e = RecyclerThumbSeekBar.e(this.llX, (RecyclerThumbSeekBar.j(this.llX).duration * 1000) + 1000);
            RecyclerThumbSeekBar recyclerThumbSeekBar = this.llX;
            if (RecyclerThumbSeekBar.b(this.llX) > 1000) {
                i = RecyclerThumbSeekBar.b(this.llX);
            }
            i = RecyclerThumbSeekBar.e(recyclerThumbSeekBar, i);
            RecyclerThumbSeekBar.f(this.llX, (this.llX.getWidth() - e) / 2);
            n l = RecyclerThumbSeekBar.l(this.llX);
            l.post(new 1(l, e, RecyclerThumbSeekBar.f(this.llX), i));
            x.i("RecyclerThumbSeekBar", "RecyclerThumbSeekBar.run(212) width %d", new Object[]{Integer.valueOf(this.llX.getWidth())});
            RecyclerThumbSeekBar.m(this.llX).lmd = (this.llX.getWidth() - RecyclerThumbSeekBar.f(this.llX)) - e;
            RecyclerThumbSeekBar.m(this.llX).lmc = RecyclerThumbSeekBar.f(this.llX);
            RecyclerThumbSeekBar.n(this.llX).setAdapter(RecyclerThumbSeekBar.m(this.llX));
            x.d("RecyclerThumbSeekBar", "init segment thumb fetcher end, adapter.getItemCount() %d", new Object[]{Integer.valueOf(RecyclerThumbSeekBar.m(this.llX).getItemCount())});
            if (RecyclerThumbSeekBar.o(this.llX) != null) {
                RecyclerThumbSeekBar.o(this.llX).gw(false);
            }
        } catch (Throwable e2) {
            x.printErrStackTrace("RecyclerThumbSeekBar", e2, "RecyclerThumbSeekBar notifySuccess error : %s", new Object[]{e2.getMessage()});
            if (RecyclerThumbSeekBar.o(this.llX) != null) {
                RecyclerThumbSeekBar.o(this.llX).gw(true);
            }
        }
    }
}

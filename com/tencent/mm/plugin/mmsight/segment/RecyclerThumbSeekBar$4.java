package com.tencent.mm.plugin.mmsight.segment;

class RecyclerThumbSeekBar$4 implements Runnable {
    final /* synthetic */ RecyclerThumbSeekBar llX;

    RecyclerThumbSeekBar$4(RecyclerThumbSeekBar recyclerThumbSeekBar) {
        this.llX = recyclerThumbSeekBar;
    }

    public final void run() {
        if (RecyclerThumbSeekBar.o(this.llX) != null) {
            RecyclerThumbSeekBar.o(this.llX).gw(true);
        }
    }
}

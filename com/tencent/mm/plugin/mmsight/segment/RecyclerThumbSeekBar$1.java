package com.tencent.mm.plugin.mmsight.segment;

import java.util.concurrent.Callable;

class RecyclerThumbSeekBar$1 implements Callable<d> {
    final /* synthetic */ RecyclerThumbSeekBar llX;

    RecyclerThumbSeekBar$1(RecyclerThumbSeekBar recyclerThumbSeekBar) {
        this.llX = recyclerThumbSeekBar;
    }

    public final /* synthetic */ Object call() {
        FFmpegSightJNIThumbFetcher fFmpegSightJNIThumbFetcher = new FFmpegSightJNIThumbFetcher();
        fFmpegSightJNIThumbFetcher.init(RecyclerThumbSeekBar.a(this.llX), RecyclerThumbSeekBar.b(this.llX), RecyclerThumbSeekBar.c(this.llX), RecyclerThumbSeekBar.d(this.llX));
        return fFmpegSightJNIThumbFetcher;
    }
}

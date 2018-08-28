package com.tencent.mm.plugin.gallery.model;

class l$2 implements Runnable {
    final /* synthetic */ int bpX;
    final /* synthetic */ long flf;
    final /* synthetic */ l jBn;
    final /* synthetic */ String jBo;

    l$2(l lVar, String str, int i, long j) {
        this.jBn = lVar;
        this.jBo = str;
        this.bpX = i;
        this.flf = j;
    }

    public final void run() {
        this.jBn.jBl.a(this.jBo, this.bpX, new 1(this), this.flf);
    }

    public final String toString() {
        return super.toString() + "|queryMediaInAlbums";
    }
}

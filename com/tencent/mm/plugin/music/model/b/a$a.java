package com.tencent.mm.plugin.music.model.b;

class a$a implements Runnable {
    int action;
    final /* synthetic */ a lyJ;

    public final void run() {
        if (this.lyJ.lyI != null) {
            this.lyJ.lyI.tE(this.action);
        }
    }

    a$a(a aVar, int i) {
        this.lyJ = aVar;
        this.action = i;
    }
}

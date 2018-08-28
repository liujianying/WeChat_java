package com.tencent.mm.plugin.fav.ui.widget;

import com.tencent.mm.plugin.fav.ui.widget.FavVideoView.a;

class FavVideoView$a$1 implements Runnable {
    final /* synthetic */ a jfU;

    FavVideoView$a$1(a aVar) {
        this.jfU = aVar;
    }

    public final void run() {
        if (FavVideoView.a(this.jfU.jfS) != null) {
            this.jfU.jfS.BK(FavVideoView.c(this.jfU.jfS));
        }
    }
}

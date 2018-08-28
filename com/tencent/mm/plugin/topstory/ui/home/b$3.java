package com.tencent.mm.plugin.topstory.ui.home;

class b$3 implements Runnable {
    final /* synthetic */ b ozD;

    b$3(b bVar) {
        this.ozD = bVar;
    }

    public final void run() {
        try {
            if (this.ozD.ozz != null && this.ozD.ozz.getView() != null) {
                this.ozD.ozz.getView().scrollTo(this.ozD.ozz.getView().getScrollX(), 0);
            }
        } catch (Throwable th) {
        }
    }
}

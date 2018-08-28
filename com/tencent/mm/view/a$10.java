package com.tencent.mm.view;

class a$10 implements Runnable {
    final /* synthetic */ a uSy;

    a$10(a aVar) {
        this.uSy = aVar;
    }

    public final void run() {
        this.uSy.getPresenter().onAttachedToWindow();
    }
}

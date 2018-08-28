package com.tencent.mm.ui;

class BaseActivity$6 implements Runnable {
    final /* synthetic */ BaseActivity tgA;

    BaseActivity$6(BaseActivity baseActivity) {
        this.tgA = baseActivity;
    }

    public final void run() {
        this.tgA.supportInvalidateOptionsMenu();
    }
}

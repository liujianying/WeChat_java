package com.tencent.mm.ui;

import com.tencent.mm.sdk.platformtools.x;

class MMNewPhotoEditUI$1 implements Runnable {
    final /* synthetic */ MMNewPhotoEditUI tnX;

    MMNewPhotoEditUI$1(MMNewPhotoEditUI mMNewPhotoEditUI) {
        this.tnX = mMNewPhotoEditUI;
    }

    public final void run() {
        x.i("MicroMsg.MMNewPhotoEditUI", "connected!!!");
        MMNewPhotoEditUI.a(this.tnX);
        this.tnX.initView();
    }
}

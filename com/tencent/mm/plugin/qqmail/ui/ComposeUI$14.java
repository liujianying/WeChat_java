package com.tencent.mm.plugin.qqmail.ui;

class ComposeUI$14 implements Runnable {
    final /* synthetic */ ComposeUI mfs;

    ComposeUI$14(ComposeUI composeUI) {
        this.mfs = composeUI;
    }

    public final void run() {
        this.mfs.setResult(-1);
        this.mfs.finish();
    }
}

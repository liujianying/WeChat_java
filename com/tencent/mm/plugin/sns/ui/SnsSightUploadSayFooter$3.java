package com.tencent.mm.plugin.sns.ui;

class SnsSightUploadSayFooter$3 implements Runnable {
    final /* synthetic */ SnsSightUploadSayFooter obk;

    SnsSightUploadSayFooter$3(SnsSightUploadSayFooter snsSightUploadSayFooter) {
        this.obk = snsSightUploadSayFooter;
    }

    public final void run() {
        SnsSightUploadSayFooter.b(this.obk).performClick();
        SnsSightUploadSayFooter.b(this.obk).requestFocus();
        SnsSightUploadSayFooter.c(this.obk).showVKB();
    }
}

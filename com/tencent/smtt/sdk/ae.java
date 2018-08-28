package com.tencent.smtt.sdk;

class ae implements Runnable {
    final /* synthetic */ ad a;

    ae(ad adVar) {
        this.a = adVar;
    }

    public void run() {
        if (!TbsShareManager.forceLoadX5FromTBSDemo(ad.a(this.a).getContext()) && TbsDownloader.needDownload(ad.a(this.a).getContext(), false)) {
            TbsDownloader.startDownload(ad.a(this.a).getContext());
        }
    }
}

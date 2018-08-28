package com.tencent.liteav.network;

class TXCStreamDownloader$1 implements Runnable {
    final /* synthetic */ TXCStreamDownloader a;

    TXCStreamDownloader$1(TXCStreamDownloader tXCStreamDownloader) {
        this.a = tXCStreamDownloader;
    }

    public void run() {
        this.a.stop();
        this.a.start(TXCStreamDownloader.access$000(this.a), TXCStreamDownloader.access$100(this.a), TXCStreamDownloader.access$200(this.a), TXCStreamDownloader.access$300(this.a));
    }
}

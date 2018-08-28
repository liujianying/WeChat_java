package com.tencent.liteav.network;

class TXCStreamUploader$3 implements Runnable {
    final /* synthetic */ boolean a;
    final /* synthetic */ TXCStreamUploader b;

    TXCStreamUploader$3(TXCStreamUploader tXCStreamUploader, boolean z) {
        this.b = tXCStreamUploader;
        this.a = z;
    }

    public void run() {
        TXCStreamUploader.access$2700(this.b, this.a);
    }
}

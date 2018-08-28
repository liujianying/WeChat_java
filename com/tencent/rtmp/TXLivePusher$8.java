package com.tencent.rtmp;

import android.graphics.Bitmap;

class TXLivePusher$8 implements Runnable {
    final /* synthetic */ TXLivePusher this$0;
    final /* synthetic */ Bitmap val$bmp;
    final /* synthetic */ TXLivePusher$ITXSnapshotListener val$listener;

    TXLivePusher$8(TXLivePusher tXLivePusher, TXLivePusher$ITXSnapshotListener tXLivePusher$ITXSnapshotListener, Bitmap bitmap) {
        this.this$0 = tXLivePusher;
        this.val$listener = tXLivePusher$ITXSnapshotListener;
        this.val$bmp = bitmap;
    }

    public void run() {
        if (this.val$listener != null) {
            this.val$listener.onSnapshot(this.val$bmp);
        }
    }
}

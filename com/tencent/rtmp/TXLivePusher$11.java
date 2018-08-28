package com.tencent.rtmp;

import android.os.Bundle;

class TXLivePusher$11 implements Runnable {
    final /* synthetic */ TXLivePusher this$0;
    final /* synthetic */ int val$finalEvent;
    final /* synthetic */ Bundle val$param;

    TXLivePusher$11(TXLivePusher tXLivePusher, int i, Bundle bundle) {
        this.this$0 = tXLivePusher;
        this.val$finalEvent = i;
        this.val$param = bundle;
    }

    public void run() {
        if (TXLivePusher.access$1000(this.this$0) != null) {
            TXLivePusher.access$1000(this.this$0).onPushEvent(this.val$finalEvent, this.val$param);
        }
    }
}

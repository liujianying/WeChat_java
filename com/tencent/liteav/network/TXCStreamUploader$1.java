package com.tencent.liteav.network;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class TXCStreamUploader$1 extends Handler {
    final /* synthetic */ TXCStreamUploader a;

    TXCStreamUploader$1(TXCStreamUploader tXCStreamUploader, Looper looper) {
        this.a = tXCStreamUploader;
        super(looper);
    }

    public void handleMessage(Message message) {
        switch (message.what) {
            case 101:
                TXCStreamUploader.access$000(this.a, (String) message.obj, message.arg1 == 2, 0);
                return;
            case 103:
                TXCStreamUploader.access$100(this.a);
                return;
            case 104:
                TXCStreamUploader.access$200(this.a);
                if (TXCStreamUploader.access$300(this.a) != null) {
                    TXCStreamUploader.access$300(this.a).sendEmptyMessageDelayed(104, 2000);
                    return;
                }
                return;
            default:
                return;
        }
    }
}

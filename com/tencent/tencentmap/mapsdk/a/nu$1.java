package com.tencent.tencentmap.mapsdk.a;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class nu$1 extends Handler {
    final /* synthetic */ nu a;

    nu$1(nu nuVar, Looper looper) {
        this.a = nuVar;
        super(looper);
    }

    public void handleMessage(Message message) {
        if (message != null && message.what == 0) {
            if (nu.a(this.a) != null) {
                nu.a(this.a).a((Bitmap) message.obj);
            }
            nu.a(this.a, null);
        }
    }
}

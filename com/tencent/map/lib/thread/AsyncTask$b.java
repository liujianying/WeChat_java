package com.tencent.map.lib.thread;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.map.lib.thread.AsyncTask.a;

class AsyncTask$b extends Handler {
    public AsyncTask$b(Looper looper) {
        super(looper);
    }

    public void handleMessage(Message message) {
        a aVar = (a) message.obj;
        switch (message.what) {
            case 1:
                AsyncTask.c(aVar.a, aVar.b[0]);
                return;
            case 2:
                aVar.a.onProgressUpdate(aVar.b);
                return;
            default:
                return;
        }
    }
}

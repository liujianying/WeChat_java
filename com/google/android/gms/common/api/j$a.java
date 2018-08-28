package com.google.android.gms.common.api;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.util.Pair;

public class j$a<R extends g> extends Handler {
    public j$a() {
        this(Looper.getMainLooper());
    }

    public j$a(Looper looper) {
        super(looper);
    }

    public final void handleMessage(Message message) {
        switch (message.what) {
            case 1:
                Pair pair = (Pair) message.obj;
                Object obj = pair.first;
                Object obj2 = pair.second;
                return;
            case 2:
                ((j) message.obj).a(Status.aKs);
                return;
            default:
                Log.wtf("AbstractPendingResult", "Don't know how to handle this message.");
                return;
        }
    }
}

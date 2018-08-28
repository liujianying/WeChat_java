package com.google.android.exoplayer2.video;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import android.view.Choreographer;
import android.view.Choreographer.FrameCallback;

final class d$a implements Callback, FrameCallback {
    private static final d$a aDV = new d$a();
    public volatile long aDU;
    private final HandlerThread aDW = new HandlerThread("ChoreographerOwner:Handler");
    private Choreographer aDX;
    private int aDY;
    final Handler handler;

    public static d$a my() {
        return aDV;
    }

    private d$a() {
        this.aDW.start();
        this.handler = new Handler(this.aDW.getLooper(), this);
        this.handler.sendEmptyMessage(0);
    }

    public final void doFrame(long j) {
        this.aDU = j;
        this.aDX.postFrameCallbackDelayed(this, 500);
    }

    public final boolean handleMessage(Message message) {
        switch (message.what) {
            case 0:
                this.aDX = Choreographer.getInstance();
                return true;
            case 1:
                this.aDY++;
                if (this.aDY != 1) {
                    return true;
                }
                this.aDX.postFrameCallback(this);
                return true;
            case 2:
                this.aDY--;
                if (this.aDY != 0) {
                    return true;
                }
                this.aDX.removeFrameCallback(this);
                this.aDU = 0;
                return true;
            default:
                return false;
        }
    }
}

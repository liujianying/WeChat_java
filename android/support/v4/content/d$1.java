package android.support.v4.content;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class d$1 extends Handler {
    final /* synthetic */ d rh;

    d$1(d dVar, Looper looper) {
        this.rh = dVar;
        super(looper);
    }

    public final void handleMessage(Message message) {
        switch (message.what) {
            case 1:
                d.a(this.rh);
                return;
            default:
                super.handleMessage(message);
                return;
        }
    }
}

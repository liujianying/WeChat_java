package c.t.m.g;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

final class dc$a extends Handler {
    volatile boolean a;
    private /* synthetic */ dc b;

    /* synthetic */ dc$a(dc dcVar, Looper looper, byte b) {
        this(dcVar, looper);
    }

    private dc$a(dc dcVar, Looper looper) {
        this.b = dcVar;
        super(looper);
        this.a = false;
        this.a = false;
    }

    public final void handleMessage(Message message) {
        super.handleMessage(message);
        if (this.b.a) {
            synchronized (dc.a(this.b)) {
                if (!(dc.b(this.b) == null || this.a)) {
                    sendEmptyMessageDelayed(0, 30000);
                }
            }
            dc.a(this.b, ec.b(dc.c(this.b)));
        }
    }
}

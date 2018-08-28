package c.t.m.g;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.List;

final class di$a extends Handler {
    volatile boolean a;
    private /* synthetic */ di b;

    /* synthetic */ di$a(di diVar, Looper looper, byte b) {
        this(diVar, looper);
    }

    private di$a(di diVar, Looper looper) {
        this.b = diVar;
        super(looper);
        this.a = false;
        this.a = false;
    }

    @SuppressLint({"NewApi", "MissingPermission"})
    public final void handleMessage(Message message) {
        if (this.b.a) {
            List list = null;
            if (di.b(this.b) != null) {
                try {
                    list = di.b(this.b).getAllCellInfo();
                } catch (Throwable th) {
                }
                this.b.onCellInfoChanged(list);
            }
            synchronized (di.c(this.b)) {
                if (!(di.d(this.b) == null || this.a)) {
                    sendEmptyMessageDelayed(0, 30000);
                }
            }
        }
    }
}

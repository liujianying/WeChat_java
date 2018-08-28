package android.support.v4.view;

import android.os.Handler;
import android.os.Message;
import android.support.v4.view.e.b;

class e$b$a extends Handler {
    final /* synthetic */ b uF;

    e$b$a(b bVar) {
        this.uF = bVar;
    }

    public final void handleMessage(Message message) {
        switch (message.what) {
            case 1:
                b.b(this.uF).onShowPress(b.a(this.uF));
                return;
            case 2:
                b.c(this.uF);
                return;
            case 3:
                if (b.d(this.uF) == null) {
                    return;
                }
                if (b.e(this.uF)) {
                    b.f(this.uF);
                    return;
                } else {
                    b.d(this.uF).onSingleTapConfirmed(b.a(this.uF));
                    return;
                }
            default:
                throw new RuntimeException("Unknown message " + message);
        }
    }
}

package c.t.m.g;

import android.content.IntentFilter;

final class v implements Runnable {
    v() {
    }

    public final void run() {
        try {
            p.e();
            m.a().registerReceiver(p.m(), new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        } catch (Throwable th) {
        }
    }
}

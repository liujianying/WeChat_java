package c.t.m.g;

import android.net.wifi.ScanResult;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

class dm$a extends Handler {
    private /* synthetic */ dm a;

    public dm$a(dm dmVar, Looper looper) {
        this.a = dmVar;
        super(looper);
    }

    public final void handleMessage(Message message) {
        synchronized (dm.e(this.a)) {
            switch (message.what) {
                case 1201:
                    dm.f(this.a);
                    break;
                case 1202:
                    try {
                        Collection<ScanResult> g = dm.g(this.a);
                        if (g != null && g.size() > 0) {
                            if (dm.h(this.a) && cn.a().d("up_wifis")) {
                                dm.a(this.a, g);
                                dm.i(this.a);
                            }
                            if (dm.j(this.a) == null) {
                                dm.b(this.a, new ArrayList());
                            }
                            int i = 1;
                            dm.a(this.a, "");
                            for (ScanResult scanResult : g) {
                                int i2;
                                if (i <= 20) {
                                    dm.a(this.a, dm.k(this.a) + scanResult.SSID + "," + scanResult.BSSID + "|");
                                    i2 = i + 1;
                                } else {
                                    i2 = i;
                                }
                                i = i2;
                            }
                            dm.j(this.a).clear();
                            dm.j(this.a).addAll(g);
                            dn.a(dm.j(this.a));
                            if (dm.j(this.a) != null && dm.j(this.a).size() > 0) {
                                Collections.sort(dm.j(this.a), dm.b());
                                dm.l(this.a);
                                break;
                            }
                        }
                        if (dm.h(this.a)) {
                            dm.d(this.a).c(dt.a);
                        }
                        dm.a(this.a, "");
                        break;
                    } catch (Throwable th) {
                        break;
                    }
                    break;
            }
        }
    }
}

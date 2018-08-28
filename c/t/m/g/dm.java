package c.t.m.g;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.provider.Settings.Secure;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public final class dm extends BroadcastReceiver {
    static boolean d;
    private static final Comparator<ScanResult> q = new Comparator<ScanResult>() {
        public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
            return ((ScanResult) obj2).level - ((ScanResult) obj).level;
        }
    };
    volatile boolean a;
    final ct b;
    HashSet<String> c;
    volatile Handler e;
    volatile a f;
    volatile List<ScanResult> g;
    Runnable h;
    String i;
    public long j = 30000;
    final byte[] k = new byte[0];
    private final WifiManager l;
    private long m;
    private volatile List<ScanResult> n;
    private Runnable o;
    private boolean p;

    public dm(ct ctVar) {
        this.b = ctVar;
        this.l = ctVar.f;
        this.c = new HashSet();
        this.p = true;
        this.o = new 1(this);
        this.h = new 2(this);
    }

    public final void onReceive(Context context, Intent intent) {
        if (intent != null) {
            try {
                String action = intent.getAction();
                boolean equals = "android.net.wifi.WIFI_STATE_CHANGED".equals(action);
                if (equals) {
                    a(1201);
                }
                if (equals || "android.net.wifi.SCAN_RESULTS".equals(action)) {
                    this.n = ej.c(this.l);
                    a(1202);
                }
            } catch (Throwable th) {
            }
        }
    }

    private void a(int i) {
        if (this.f != null) {
            this.f.obtainMessage(i).sendToTarget();
        }
    }

    public final void a(long j) {
        Handler handler = this.e;
        Runnable runnable = this.o;
        Looper looper = handler == null ? null : handler.getLooper();
        if (looper != null && looper.getThread().isAlive()) {
            handler.removeCallbacks(runnable);
            handler.postDelayed(runnable, j);
        }
    }

    final boolean a() {
        if (!ej.b(this.b) || d) {
            return false;
        }
        return ej.b(this.l);
    }

    private void a(List<ScanResult> list) {
        if (list == null || list.size() == 0) {
            c();
        } else if (ej.a) {
            ej.a = false;
            c();
        }
        long j = this.m;
        ej.a(this.l);
        this.b.c(new dt(list, j));
    }

    private void c() {
        int i = 1;
        try {
            int a = ej.a(this.l);
            if (a == 3) {
                a(0);
            } else if (a == 1) {
                i = 0;
                if (!ej.b(this.b)) {
                    if (this.g != null) {
                        this.g.clear();
                    }
                    if (this.e != null) {
                        this.e.sendEmptyMessage(555);
                    }
                }
            } else {
                i = -1;
            }
            try {
                if (VERSION.SDK_INT >= 23 && Secure.getInt(this.b.a.getContentResolver(), "location_mode") == 0) {
                    i = 5;
                }
            } catch (Throwable th) {
            }
            Message message = new Message();
            message.what = 12999;
            message.arg1 = 12001;
            message.arg2 = i;
            this.b.c(message);
        } catch (Throwable th2) {
        }
    }

    static /* synthetic */ void l(dm dmVar) {
        List<ScanResult> list = dmVar.g;
        if (dmVar.c == null) {
            dmVar.c = new HashSet();
        }
        if (list == null) {
            return;
        }
        if (dmVar.c.size() == 0) {
            for (ScanResult scanResult : list) {
                dmVar.c.add(scanResult.BSSID + scanResult.level);
            }
            dmVar.m = System.currentTimeMillis();
            dmVar.a((List) list);
            return;
        }
        int size = dmVar.c.size();
        if (size != list.size()) {
            dmVar.c.clear();
            for (ScanResult scanResult2 : list) {
                dmVar.c.add(scanResult2.BSSID + scanResult2.level);
            }
            dmVar.m = System.currentTimeMillis();
            dmVar.a((List) list);
            return;
        }
        for (ScanResult scanResult22 : list) {
            dmVar.c.add(scanResult22.BSSID + scanResult22.level);
        }
        if (size != dmVar.c.size()) {
            dmVar.c.clear();
            for (ScanResult scanResult222 : list) {
                dmVar.c.add(scanResult222.BSSID + scanResult222.level);
            }
            dmVar.m = System.currentTimeMillis();
            dmVar.a((List) list);
        }
    }
}

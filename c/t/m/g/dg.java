package c.t.m.g;

import android.bluetooth.BluetoothAdapter;
import android.content.IntentFilter;
import android.hardware.Sensor;
import android.location.Location;
import android.location.LocationManager;
import android.net.wifi.ScanResult;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.Parcelable;
import android.os.SystemClock;
import android.telephony.CellLocation;
import android.text.TextUtils;
import android.util.SparseArray;
import c.t.m.g.di.a;
import c.t.m.g.dk.1;
import com.tencent.map.geolocation.TencentLocationListener;
import com.tencent.map.geolocation.TencentLocationManagerOptions;
import com.tencent.map.geolocation.TencentLocationRequest;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.tencentmap.lbssdk.service.e;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.CopyOnWriteArrayList;
import org.eclipse.jdt.annotation.Nullable;

public final class dg {
    public static final TencentLocationListener a = new 1();
    private static SparseArray<String> n;
    private HandlerThread A;
    private dl B;
    private cv C;
    private dp D;
    private dt E;
    private dt F;
    private dq G;
    private final ct H;
    private WeakReference<TencentLocationListener> I;
    private volatile boolean J = false;
    private volatile double K = 0.0d;
    private long L;
    private final Object M = new Object();
    private double N;
    private double O;
    private eb P;
    private long Q;
    private String R;
    private volatile boolean S = false;
    private cr T = null;
    private byte[] U = new byte[0];
    public int b = 1;
    public dm c;
    public volatile int d = 0;
    public cu e;
    public List<WeakReference<TencentLocationListener>> f;
    public long g = 0;
    public volatile long h = 0;
    public volatile int i = 0;
    public final TencentLocationRequest j = TencentLocationRequest.create();
    public eb k;
    public int l = 404;
    public volatile b m = b.d;
    private volatile HandlerThread o;
    private a p;
    private c q;
    private Handler r;
    private dc s;
    private di t;
    private boolean u;
    private df v;
    private de w;
    private da x;
    private dh y;
    private dk z;

    static /* synthetic */ dr m(dg dgVar) {
        dq dqVar;
        List list = null;
        dt dtVar = dgVar.E;
        dp dpVar = dgVar.D;
        dq dqVar2 = dgVar.G;
        if (dqVar2 == null || dgVar.g()) {
            dqVar = dqVar2;
        } else {
            dqVar = null;
        }
        if (dpVar == null) {
            ct ctVar = dgVar.H;
            dpVar = dp.a(ctVar, ec.b(ctVar), null);
            if (!ec.a(dpVar)) {
                dpVar = null;
            }
        }
        if (dtVar != null) {
            Object obj;
            if (System.currentTimeMillis() - dtVar.c < 60000) {
                obj = 1;
            } else {
                obj = null;
            }
            if (obj == null) {
                dtVar = null;
            }
        }
        if (!(dpVar == null || dqVar == null || VERSION.SDK_INT < 12)) {
            int i = dpVar.d;
            int i2 = dpVar.e;
            Parcelable parcelable = dqVar.a;
            Bundle bundle = new Bundle();
            bundle.putString("cellkey", i + i2);
            bundle.putParcelable("location", parcelable);
            if (!dgVar.H.a(TencentLocationListener.CELL).b(bundle)) {
                new StringBuilder("getFromLastKnownInfo: discard bad cell(").append(i).append(",").append(i2).append(")");
                dpVar = null;
            }
        }
        if (dgVar.x != null) {
            list = dgVar.x.a();
        }
        return new dr(dtVar, dpVar, dqVar, list);
    }

    static {
        SparseArray sparseArray = new SparseArray();
        n = sparseArray;
        sparseArray.put(0, "OK");
        n.put(1, "ERROR_NETWORK");
        n.put(2, "ERROR_NOCELL&WIFI_LOCATIONSWITCHOFF");
        n.put(4, "DEFLECT_FAILED");
        n.put(404, "ERROR_SERVER_NOT_LOCATION");
        HashMap hashMap = new HashMap();
        hashMap.put("https", "true");
        hashMap.put("up_apps", "true");
        hashMap.put("up_wifis", "true");
        hashMap.put("start_daemon", "true");
        hashMap.put("up_daemon_delay", "300000");
        hashMap.put("gps_kalman", "false");
        hashMap.put("callback_wifis", "true");
        hashMap.put("min_wifi_scan_interval", "8000");
        hashMap.put("collect_bles", "false");
        hashMap.put("start_event_track", "true");
        hashMap.put("f_coll_item", "0");
        cm.a(hashMap);
    }

    public dg(ct ctVar) {
        dc dcVar = null;
        this.H = ctVar;
        if (TencentLocationManagerOptions.isLoadLibraryEnabled()) {
            try {
                System.loadLibrary("tencentloc");
            } catch (Throwable th) {
                this.d = 3;
                return;
            }
        }
        try {
            if (!TextUtils.isEmpty(TencentLocationManagerOptions.getKey())) {
                this.e.g = TencentLocationManagerOptions.getKey();
            }
        } catch (Throwable th2) {
            th2.toString();
        }
        this.e = this.H.b;
        String b = j.b(this.e.g);
        this.R = a(b);
        if (TextUtils.isEmpty(this.R)) {
            new StringBuilder("requestLocationUpdates: illegal key [").append(b).append("]");
            this.d = 2;
            return;
        }
        this.H.a(this);
        this.C = cw.b();
        this.B = new dl();
        this.f = new CopyOnWriteArrayList();
        this.y = new dh(this.H);
        this.z = new dk(this.H);
        this.w = de.a(ctVar.a);
        if (VERSION.SDK_INT >= 21) {
            this.x = new da(this.H.a);
        }
        this.u = VERSION.SDK_INT >= 18;
        Object[] objArr;
        df h;
        if (this.u) {
            di diVar;
            this.s = null;
            this.c = i();
            if (this.H.b()) {
                diVar = new di(this.H);
            } else {
                diVar = null;
            }
            this.t = diVar;
            objArr = new Object[1];
            h = h();
            this.v = h;
            objArr[0] = h;
        } else {
            this.t = null;
            this.c = i();
            if (this.H.b()) {
                dcVar = new dc(this.H);
            }
            this.s = dcVar;
            objArr = new Object[1];
            h = h();
            this.v = h;
            objArr[0] = h;
        }
        try {
            cm.a(this.H.a, "txsdk", this.H.b.d());
            cm.a(this.R);
            cm.a().a = (cl) this.H.h;
        } catch (Throwable th3) {
        }
    }

    public final int a(TencentLocationRequest tencentLocationRequest, TencentLocationListener tencentLocationListener, Looper looper) {
        if (this.d != 0) {
            return this.d;
        }
        e();
        if (this.e != null) {
            this.e.m = System.currentTimeMillis();
        }
        this.l = 404;
        this.k = null;
        synchronized (this.M) {
            this.I = new WeakReference(tencentLocationListener);
        }
        if (this.e != null && "0123456789ABCDEF".equals(this.e.a())) {
            this.H.a();
        }
        this.e.f = tencentLocationRequest.getQQ();
        TencentLocationRequest.copy(this.j, tencentLocationRequest);
        if (TextUtils.isEmpty(j.b(this.e.d))) {
            this.e.d = tencentLocationRequest.getPhoneNumber();
        }
        this.e.l = Math.max(cn.a().c("min_wifi_scan_interval"), tencentLocationRequest.getInterval());
        this.h = tencentLocationRequest.getInterval();
        this.m = b.a;
        if (this.A != null) {
            this.A.quit();
            this.A = null;
        }
        a(looper);
        return 0;
    }

    private void a(Looper looper) {
        BluetoothAdapter bluetoothAdapter = null;
        synchronized (this.U) {
            Object obj;
            c cVar;
            Looper looper2;
            Object obj2;
            if (Looper.myLooper() == null) {
                Looper.prepare();
            }
            if (this.q == null) {
                obj = 1;
            } else {
                obj = null;
            }
            if (!(obj == null && this.q.getLooper() == looper)) {
                this.q = new c(this, looper);
            }
            this.q.removeCallbacksAndMessages(null);
            if (this.r == null || this.r.getLooper() != Looper.getMainLooper()) {
                this.r = new Handler(Looper.getMainLooper());
            }
            d();
            if (this.o == null || !this.o.isAlive() || this.o.getLooper() == null) {
                this.o = new HandlerThread("loc_inner_thread");
                this.o.start();
            }
            if (this.p == null) {
                this.p = new a(this, this.o.getLooper());
            } else {
                this.p.a();
            }
            boolean z = this.j.getExtras().getBoolean("use_network", true);
            boolean z2 = b.b == this.m;
            a aVar = this.p;
            dk dkVar = this.z;
            if (!dkVar.g) {
                dkVar.g = true;
                dkVar.i = aVar;
                dkVar.h = z2;
                dkVar.b.c.execute(new 1(dkVar));
                dkVar.f = SystemClock.elapsedRealtime();
            }
            if (this.u) {
                if (z) {
                    if (this.t != null) {
                        obj = 1;
                    } else {
                        obj = null;
                    }
                    if (obj != null) {
                        if (aVar != null) {
                            obj = 1;
                        } else {
                            obj = null;
                        }
                        if (obj != null) {
                            di diVar = this.t;
                            if (!diVar.a) {
                                diVar.g = aVar;
                                if (diVar.h == null) {
                                    diVar.h = new ArrayList();
                                }
                                diVar.d = new HandlerThread("new_cell_provider");
                                if (!(diVar.d == null || diVar.g == null)) {
                                    try {
                                        diVar.d.start();
                                        diVar.e = new a(diVar, diVar.d.getLooper(), (byte) 0);
                                    } catch (Throwable th) {
                                        diVar.e = new a(diVar, diVar.g.getLooper(), (byte) 0);
                                    }
                                    diVar.e.post(diVar.f);
                                    if (!z2) {
                                        diVar.e.sendEmptyMessage(0);
                                    }
                                }
                            }
                        }
                    }
                }
            } else if (z) {
                if (this.s != null) {
                    obj = 1;
                } else {
                    obj = null;
                }
                if (obj != null) {
                    if (aVar != null) {
                        obj = 1;
                    } else {
                        obj = null;
                    }
                    if (obj != null) {
                        dc dcVar = this.s;
                        if (!dcVar.a) {
                            dcVar.a = true;
                            dcVar.h = new HandlerThread("CellProvider");
                            dcVar.h.start();
                            dcVar.i = new dc.a(dcVar, dcVar.h.getLooper(), (byte) 0);
                            dcVar.i.sendEmptyMessageDelayed(0, 3000);
                            CellLocation b = ec.b(dcVar.b);
                            if (dcVar.a(b)) {
                                dp a = dp.a(dcVar.b, b, null);
                                if (a != null) {
                                    dcVar.d = b;
                                    dcVar.b.c(a);
                                }
                            }
                            dcVar.a(273);
                        }
                    }
                }
            }
            if (z) {
                if (this.c != null) {
                    obj = 1;
                } else {
                    obj = null;
                }
                if (obj != null) {
                    if (aVar != null) {
                        obj = 1;
                    } else {
                        obj = null;
                    }
                    if (obj != null) {
                        this.c.j = this.e.l;
                        dm dmVar = this.c;
                        cVar = this.q;
                        synchronized (dmVar.k) {
                            if (dmVar.a) {
                            } else {
                                dmVar.a = true;
                                dm.d = z2;
                                dmVar.e = aVar;
                                if (dmVar.e == null) {
                                    looper2 = null;
                                } else {
                                    looper2 = dmVar.e.getLooper();
                                }
                                if (dmVar.f == null || dmVar.f.getLooper() != looper2) {
                                    if (dmVar.f != null) {
                                        dmVar.f.removeCallbacksAndMessages(null);
                                    }
                                    if (looper2 != null) {
                                        dmVar.f = new dm.a(dmVar, looper2);
                                    }
                                }
                                cVar.post(dmVar.h);
                                if (!dm.d) {
                                    dmVar.a(0);
                                }
                            }
                        }
                    }
                }
            }
            if (this.v != null) {
                obj = 1;
            } else {
                obj = null;
            }
            if (obj != null && this.j.isAllowGPS()) {
                if (aVar != null) {
                    obj = 1;
                } else {
                    obj = null;
                }
                if (obj != null) {
                    boolean z3;
                    df dfVar = this.v;
                    if (this.b == 1) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    dfVar.l = z3;
                    dfVar = this.v;
                    cVar = this.q;
                    if (!dfVar.k) {
                        dfVar.k = true;
                        dfVar.d = 0;
                        dfVar.r = -1;
                        looper2 = aVar == null ? null : aVar.getLooper();
                        if ((dfVar.n == null || dfVar.n.getLooper() != looper2) && looper2 != null) {
                            dfVar.n = new df.a(dfVar, aVar.getLooper());
                        }
                        if (z2) {
                            aVar.post(dfVar.q);
                        } else {
                            aVar.post(dfVar.o);
                            int i = VERSION.SDK_INT;
                            cVar.post(dfVar.p);
                        }
                        if (dfVar.c()) {
                            dfVar.b = 4;
                            dfVar.d();
                        }
                    }
                }
            }
            if (z2) {
                dk dkVar2 = this.z;
                String d = this.H.d();
                try {
                    if (!TextUtils.isEmpty(d)) {
                        byte[] a2 = ei.a(d.getBytes("UTF-8"));
                        e.o(a2, 2);
                        a aVar2 = new a(2, a2, "http://ue.indoorloc.map.qq.com/", null);
                        aVar2.b = d;
                        dkVar2.a(aVar2);
                    }
                } catch (Throwable th2) {
                }
            } else {
                if (!cn.a().d("collect_bles")) {
                    this.x = null;
                }
                if (this.x != null) {
                    obj = 1;
                } else {
                    obj = null;
                }
                if (obj != null) {
                    if (aVar != null) {
                        obj = 1;
                    } else {
                        obj = null;
                    }
                    if (obj != null) {
                        da daVar = this.x;
                        synchronized (daVar.g) {
                            try {
                                if (daVar.a != null) {
                                    bluetoothAdapter = daVar.a.getAdapter();
                                }
                                daVar.b = bluetoothAdapter;
                                if (daVar.b != null) {
                                    daVar.c = daVar.b.getBluetoothLeScanner();
                                }
                            } catch (Throwable th3) {
                                th3.toString();
                            }
                            daVar.f = new HandlerThread("ble_thread");
                            daVar.f.start();
                            daVar.e = new da.a(daVar, daVar.f.getLooper());
                            daVar.e.sendEmptyMessage(1000);
                        }
                    }
                }
                if (aVar != null) {
                    obj2 = 1;
                } else {
                    obj2 = null;
                }
                if (obj2 != null) {
                    dh dhVar = this.y;
                    if (!dhVar.b) {
                        dhVar.b = true;
                        if (aVar != null) {
                            try {
                                dhVar.a.a.registerReceiver(dhVar, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"), null, aVar);
                            } catch (Exception e) {
                            }
                        }
                    }
                }
                if (this.w != null) {
                    obj2 = 1;
                } else {
                    obj2 = null;
                }
                if (obj2 != null && this.j.isAllowDirection()) {
                    if (aVar != null) {
                        obj2 = 1;
                    } else {
                        obj2 = null;
                    }
                    if (obj2 != null) {
                        de deVar = this.w;
                        if (!(!deVar.b || deVar.c || aVar == null)) {
                            try {
                                Sensor defaultSensor = deVar.a.getDefaultSensor(11);
                                if (defaultSensor != null) {
                                    deVar.a.registerListener(deVar, defaultSensor, 3, aVar);
                                    deVar.c = true;
                                }
                            } catch (Throwable th4) {
                            }
                        }
                    }
                }
            }
            if (aVar != null) {
                obj2 = 1;
            } else {
                obj2 = null;
            }
            if (obj2 != null) {
                int b2 = cn.a().b("f_coll_item");
                if ((b2 == 1 || b2 == 2) && this.T == null) {
                    this.T = new cr(this.H);
                }
                if (this.T != null) {
                    new StringBuilder("fc:dc.1.0.1_171109,set:").append(b2).append(",daemon:").append(z2);
                    if (b2 == 2 || (b2 == 1 && !z2)) {
                        cr crVar = this.T;
                        if (!crVar.b) {
                            crVar.a();
                            cs csVar;
                            try {
                                obj2 = crVar.a.a.getExternalFilesDir("data").getAbsolutePath();
                                if (!TextUtils.isEmpty(obj2)) {
                                    crVar.c = new cs(crVar.a, obj2);
                                    csVar = crVar.c;
                                    boolean z4 = csVar.b != null && (csVar.b.exists() || csVar.b.mkdirs());
                                    csVar.c = z4;
                                    if (csVar.c) {
                                        csVar.d = new HandlerThread("data_c", 10);
                                        csVar.d.start();
                                        csVar.e = new cs.a(csVar, csVar.d.getLooper());
                                        csVar.i = System.currentTimeMillis() - 30000;
                                    }
                                    crVar.b = true;
                                }
                            } catch (Throwable th32) {
                                th32.toString();
                            }
                        }
                    }
                }
            }
        }
        return;
    }

    public final void a(eb ebVar) {
        if (ebVar != null) {
            if (this.w != null && this.j.isAllowDirection()) {
                ebVar.getExtra().putDouble("direction", this.w.a());
            }
            try {
                ebVar.getExtra().putAll(this.j.getExtras());
            } catch (Exception e) {
            }
        }
    }

    public final void a() {
        Object obj;
        synchronized (this.U) {
            d();
            try {
                if (this.p != null) {
                    this.p.a();
                    this.p = null;
                }
                if (this.o != null) {
                    this.o.quit();
                    this.o = null;
                }
            } catch (Throwable th) {
            }
        }
        synchronized (this.M) {
            if (this.I != null) {
                this.I.clear();
            }
            this.I = null;
            if (this.f != null) {
                this.f.clear();
            }
        }
        if (this.C != null) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj != null) {
            this.C.a();
        }
        e();
        if (cn.a().d("start_daemon")) {
            if (this.m == b.a && ej.c(this.H).equalsIgnoreCase("{}")) {
                this.A = new HandlerThread("daemon_thread");
                this.A.start();
                new Handler(this.A.getLooper()).postDelayed(new 2(this), 5000);
                this.Q = System.currentTimeMillis();
            } else {
                new StringBuilder("daemon not start! is wifi or running status=").append(this.m);
            }
        }
        this.m = b.d;
    }

    private void d() {
        boolean z;
        ec.a = false;
        if (this.y != null) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            dh dhVar = this.y;
            if (dhVar.b) {
                dhVar.b = false;
                try {
                    dhVar.a.a.unregisterReceiver(dhVar);
                } catch (Exception e) {
                }
            }
        }
        if (this.z != null) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            dk dkVar = this.z;
            if (dkVar.g) {
                dkVar.g = false;
                dkVar.a.clear();
                dkVar.a.offer(a.d);
                dkVar.i = null;
                if (dkVar.f != 0) {
                    long elapsedRealtime = SystemClock.elapsedRealtime() - dkVar.f;
                    String.format(Locale.ENGLISH, "shutdown: duration=%ds, sent=%dB, recv=%dB, reqCount=%d", new Object[]{Long.valueOf(elapsedRealtime / 1000), Long.valueOf(dkVar.d), Long.valueOf(dkVar.e), Long.valueOf(dkVar.c)});
                }
                dkVar.c = 0;
                dkVar.d = 0;
                dkVar.e = 0;
                dkVar.f = 0;
            }
        }
        if (this.B != null) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            this.B.a();
        }
        if (this.c != null) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            dm dmVar = this.c;
            synchronized (dmVar.k) {
                if (dmVar.a) {
                    dmVar.a = false;
                    try {
                        dmVar.b.a.unregisterReceiver(dmVar);
                    } catch (Exception e2) {
                    }
                    dmVar.c = null;
                    if (dmVar.g != null) {
                        dmVar.g.clear();
                    }
                    if (dmVar.c != null) {
                        dmVar.c.clear();
                    }
                    if (dmVar.f != null) {
                        dmVar.f.removeCallbacksAndMessages(null);
                        dmVar.f = null;
                    }
                }
            }
        }
        if (this.u) {
            if (this.t != null) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                di diVar = this.t;
                if (diVar.a) {
                    diVar.a = false;
                    diVar.a(0);
                    synchronized (diVar.b) {
                        if (diVar.e != null) {
                            diVar.e.a = true;
                            diVar.e.removeCallbacksAndMessages(null);
                            diVar.e = null;
                        }
                        if (diVar.d != null) {
                            diVar.d.quit();
                            diVar.d = null;
                        }
                        diVar.c = null;
                        if (diVar.h != null) {
                            diVar.h = null;
                        }
                    }
                }
            }
        } else {
            if (this.s != null) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                dc dcVar = this.s;
                if (dcVar.a) {
                    dcVar.a = false;
                    dcVar.a(0);
                    synchronized (dcVar.c) {
                        if (dcVar.i != null) {
                            dcVar.i.a = true;
                            dcVar.i.removeCallbacksAndMessages(null);
                            dcVar.i = null;
                        }
                        if (dcVar.h != null) {
                            dcVar.h.quit();
                            dcVar.h = null;
                        }
                        dcVar.d = null;
                        dcVar.e = null;
                        dcVar.f = null;
                        dcVar.g = 0;
                    }
                }
            }
        }
        if (this.v != null) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            df dfVar = this.v;
            if (dfVar.k) {
                dfVar.k = false;
                dfVar.b = WXMediaMessage.DESCRIPTION_LENGTH_LIMIT;
                dfVar.e = false;
                dfVar.f = false;
                dfVar.i = 0;
                dfVar.h = 0;
                dfVar.g = 0;
                dfVar.j.clear();
                dfVar.m = -1;
                dfVar.l = false;
                Arrays.fill(dfVar.s, 0.0d);
                dfVar.a.b(dfVar);
                LocationManager locationManager = dfVar.a.g;
                try {
                    locationManager.removeGpsStatusListener(dfVar);
                } catch (Exception e3) {
                }
                try {
                    locationManager.removeUpdates(dfVar);
                } catch (Exception e4) {
                }
                dfVar.n = null;
                dfVar.c = null;
            }
        }
        if (this.w != null) {
            z = true;
        } else {
            z = false;
        }
        if (z && this.j.isAllowDirection()) {
            de deVar = this.w;
            if (deVar.b && deVar.c) {
                deVar.c = false;
                deVar.d = Double.NaN;
                deVar.a.unregisterListener(deVar);
            }
        }
        if (this.x != null) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            da daVar = this.x;
            synchronized (daVar.g) {
                if (daVar.d && daVar.e != null && daVar.e.getLooper().getThread().isAlive()) {
                    daVar.e.sendEmptyMessage(2000);
                    daVar.e.postDelayed(new da.1(daVar.e, daVar.f), 50);
                    daVar.e = null;
                    daVar.f = null;
                }
            }
        }
        if (this.S) {
            cm.a().c();
            this.S = false;
        }
        if (this.T != null) {
            cr crVar = this.T;
            if (crVar.b) {
                crVar.b = false;
                crVar.a();
                if (crVar.c != null) {
                    cs csVar = crVar.c;
                    if (csVar.a()) {
                        csVar.a(1005);
                        csVar.a(1007);
                        csVar.a(1006);
                        csVar.a(true);
                        HandlerThread handlerThread = csVar.d;
                        csVar.e.postDelayed(new cs.1(csVar.e, handlerThread), 200);
                        csVar.e = null;
                        csVar.d = null;
                        csVar.c = false;
                    }
                    crVar.c = null;
                }
            }
        }
    }

    private void e() {
        this.i = 0;
        this.E = null;
        this.D = null;
        this.G = null;
        this.L = 0;
        dr.a = 0;
        if (VERSION.SDK_INT >= 12) {
            this.H.a(TencentLocationListener.CELL).a();
        }
        if (this.e != null) {
            this.e.p = "";
            this.e.o = 0;
            this.e.n = 0;
            this.e.m = 0;
        }
    }

    private void a(int i, eb ebVar) {
        Object obj = 1;
        if (ebVar != null) {
            if (!(i != 0 || ebVar.getLatitude() == 0.0d || ebVar.getLongitude() == 0.0d)) {
                int i2 = 0;
                if (this.b == 1 && ed.a(ebVar.getLatitude(), ebVar.getLongitude())) {
                    i2 = 1;
                }
                eb.a(ebVar, i2);
            }
            boolean z;
            if (f()) {
                if (ebVar.getAccuracy() < 5000.0f && ebVar.getAccuracy() > 0.0f) {
                    this.B.a(ebVar);
                    z = this.J;
                }
                this.N = ebVar.getLatitude();
                this.O = ebVar.getLongitude();
                if (j.a(this.I) && this.j.getInterval() > 0) {
                    a(11999, this.j.getInterval());
                }
            } else if (i == 0 && ebVar.getLatitude() != 0.0d && ebVar.getLongitude() != 0.0d && Math.abs(ebVar.getLatitude() - this.N) >= 1.0E-8d && Math.abs(ebVar.getLongitude() - this.O) >= 1.0E-8d) {
                if (this.B.a(ebVar, this.H, this.v.c())) {
                    this.N = ebVar.getLatitude();
                    this.O = ebVar.getLongitude();
                    if (ebVar.getAccuracy() < 5000.0f && ebVar.getAccuracy() > 0.0f) {
                        this.B.a(ebVar);
                        this.B.a(ebVar);
                        z = this.J;
                    }
                } else {
                    new StringBuilder("discard ").append(ebVar);
                    return;
                }
            }
            if (this.l == 0 || i != 0) {
                obj = null;
            }
            this.l = i;
            this.k = ebVar;
            if (this.j.getInterval() == 0 && j.a(this.I) && TencentLocationListener.GPS != this.k.getProvider()) {
                a(11998);
            } else if (obj != null && j.a(this.I)) {
                a(11998);
            }
        }
    }

    private boolean f() {
        return this.l == 404;
    }

    private boolean g() {
        if (this.v != null && this.v.c() && this.v.b()) {
            return true;
        }
        return false;
    }

    public final void a(int i) {
        if (this.p != null) {
            this.p.sendEmptyMessage(i);
        }
    }

    private void a(int i, long j) {
        if (this.p != null) {
            this.p.removeMessages(i);
            this.p.sendEmptyMessageDelayed(i, j);
        }
    }

    public final void onCellInfoEvent(dp dpVar) {
        int i;
        Object obj = null;
        this.D = dpVar;
        long max = Math.max(this.j.getInterval(), 20000);
        List emptyList = Collections.emptyList();
        if (this.c != null) {
            int i2;
            if (this.c.a()) {
                i2 = 0;
            } else {
                i2 = 1;
            }
            i = i2;
        } else {
            i = 1;
        }
        if (i != 0) {
            this.E = null;
        }
        List list;
        if (i == 1 || this.H == null) {
            list = emptyList;
        } else {
            list = ej.c(this.H.f);
            list.size();
        }
        if (i == 1 || list.size() == 0 || this.L == -1 || (this.L > 0 && System.currentTimeMillis() - this.L > max)) {
            a(3999);
        }
        new StringBuilder("cell change run prepare json,because status:").append(i).append(",mLastWF:").append(this.L).append(",current:").append(System.currentTimeMillis());
        if (this.T != null) {
            cr crVar = this.T;
            if (crVar.b && dpVar != null) {
                if (crVar.d == null || !(crVar.d == null || crVar.d.b().equals(dpVar.b()))) {
                    obj = 1;
                }
                crVar.d = dpVar;
                crVar.e = ec.a(crVar.a);
                if (obj != null) {
                    crVar.c();
                }
            }
        }
    }

    public final void onWifiInfoEvent(dt dtVar) {
        Object obj = null;
        if (this.F != null) {
            dt dtVar2 = this.F;
            if (dtVar != null) {
                List list = dtVar.b;
                List list2 = dtVar2.b;
                if (!(list.size() == 0 || list2.size() == 0)) {
                    boolean z;
                    int size = list.size();
                    int size2 = list2.size();
                    if (size == 0 && size2 == 0) {
                        z = true;
                    } else if (size == 0 || size2 == 0) {
                        z = false;
                    } else {
                        List list3;
                        List list4;
                        if (list.size() > list2.size()) {
                            list3 = list2;
                            list4 = list;
                        } else {
                            list3 = list;
                            list4 = list2;
                        }
                        int i = 0;
                        for (ScanResult scanResult : list3) {
                            for (ScanResult scanResult2 : list4) {
                                if (scanResult2.BSSID.equals(scanResult.BSSID)) {
                                    i++;
                                    break;
                                }
                            }
                        }
                        int i2 = size + size2;
                        if (((double) (i << 1)) < ((double) i2) * 0.85d || i < 13) {
                            z = true;
                        } else {
                            z = false;
                        }
                        new StringBuilder("isDiffrent:c=").append(size).append(",k=").append(i).append(",f=").append(i2).append(",r=0.85,s=").append(z);
                    }
                    if (!z) {
                        int obj2 = 1;
                    }
                }
            }
        }
        if (obj2 != null) {
            this.L = System.currentTimeMillis();
        }
        if (this.E == null || this.i == 2 || dtVar == dt.a || this.L == -1 || Collections.unmodifiableList(dtVar.b).size() < 3 || obj2 == null) {
            a(3999);
        }
        this.E = dtVar;
        if (this.T != null) {
            cr crVar = this.T;
            if (crVar.b && dtVar != null) {
                crVar.f = dtVar;
                if (crVar.b() && crVar.f != null && crVar.c != null) {
                    crVar.c.a(crVar.g, crVar.f, crVar.e);
                }
            }
        }
    }

    public final void onGpsInfoEvent(dq dqVar) {
        if (dqVar.a != dd.a) {
            double d;
            double d2;
            this.G = dqVar;
            int i = this.b;
            int requestLevel = this.j.getRequestLevel();
            eb ebVar = this.P;
            Location location = new Location(dqVar.a);
            Bundle extras = location.getExtras();
            if (extras != null) {
                double d3 = extras.getDouble("lat");
                d = extras.getDouble("lng");
                d2 = d3;
            } else {
                d = 0.0d;
                d2 = 0.0d;
            }
            eb.a aVar;
            eb a;
            if (ei.a(i)) {
                aVar = new eb.a();
                aVar.b = ebVar;
                aVar.d = TencentLocationListener.GPS;
                aVar.c = requestLevel;
                a = aVar.a(new Location(dqVar.a)).a();
                location.setLatitude(d2);
                location.setLongitude(d);
                a.a(location);
                a(0, a);
            } else {
                if (f()) {
                    a(3999);
                }
                aVar = new eb.a();
                aVar.b = ebVar;
                aVar.d = TencentLocationListener.GPS;
                aVar.c = requestLevel;
                a = aVar.a(new Location(dqVar.a)).a();
                location.setLatitude(d2);
                location.setLongitude(d);
                a.a(location);
                a(0, a);
            }
            a(12004, 3);
            if (this.v != null) {
                this.v.b();
            }
        }
        if (this.T != null) {
            cr crVar = this.T;
            if (crVar.b && dqVar != null) {
                crVar.g = dqVar;
                if (crVar.h == null || (crVar.g != null && crVar.g.a.distanceTo(crVar.h) >= 50.0f)) {
                    crVar.c();
                }
            }
        }
    }

    public final void onStatusEvent(Message message) {
        int i = message.what;
        a(message.arg1, message.arg2);
    }

    public final void onNetworkEvent(Integer num) {
        String str;
        int a = j.a(this.H.a);
        if (a != -1) {
            if (a == 0) {
                str = "mobile";
            } else if (a == 1) {
                str = TencentLocationListener.WIFI;
            }
            switch (num.intValue()) {
                case 0:
                    new StringBuilder("onNetworkEvent: ").append(str).append(" disconnected");
                    return;
                case 1:
                    new StringBuilder("onNetworkEvent: ").append(str).append(" connected");
                    a(7999, 1000);
                    if (this.T != null) {
                        cr crVar = this.T;
                        int intValue = num.intValue();
                        if (crVar.b && intValue == 1 && crVar.c != null) {
                            crVar.c.a(false);
                            return;
                        }
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
        str = "none";
        switch (num.intValue()) {
            case 0:
                new StringBuilder("onNetworkEvent: ").append(str).append(" disconnected");
                return;
            case 1:
                new StringBuilder("onNetworkEvent: ").append(str).append(" connected");
                a(7999, 1000);
                if (this.T != null) {
                    cr crVar2 = this.T;
                    int intValue2 = num.intValue();
                    if (crVar2.b && intValue2 == 1 && crVar2.c != null) {
                        crVar2.c.a(false);
                        return;
                    }
                    return;
                }
                return;
            default:
                return;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(int r6, int r7) {
        /*
        r5 = this;
        r1 = 0;
        r3 = 2;
        switch(r6) {
            case 12001: goto L_0x0081;
            case 12002: goto L_0x003a;
            case 12003: goto L_0x0064;
            case 12004: goto L_0x004f;
            default: goto L_0x0005;
        };
    L_0x0005:
        r0 = r1;
        r2 = r1;
    L_0x0007:
        r1 = r5.q;
        if (r1 == 0) goto L_0x0039;
    L_0x000b:
        r1 = r5.q;
        r3 = 3102; // 0xc1e float:4.347E-42 double:1.5326E-320;
        r3 = r1.obtainMessage(r3);
        r1 = r3.getData();
        if (r1 != 0) goto L_0x001e;
    L_0x0019:
        r1 = new android.os.Bundle;
        r1.<init>();
    L_0x001e:
        r1.clear();
        r4 = "name";
        r1.putString(r4, r2);
        r2 = "status";
        r1.putInt(r2, r7);
        r2 = "desc";
        r1.putString(r2, r0);
        r3.setData(r1);
        r3.sendToTarget();
    L_0x0039:
        return;
    L_0x003a:
        r1 = "gps";
        switch(r7) {
            case 0: goto L_0x004a;
            case 1: goto L_0x0045;
            default: goto L_0x0040;
        };
    L_0x0040:
        r0 = "unknown";
        r2 = r1;
        goto L_0x0007;
    L_0x0045:
        r0 = "gps enabled";
        r2 = r1;
        goto L_0x0007;
    L_0x004a:
        r0 = "gps disabled";
        r2 = r1;
        goto L_0x0007;
    L_0x004f:
        r1 = "gps";
        switch(r7) {
            case 3: goto L_0x005a;
            case 4: goto L_0x005f;
            default: goto L_0x0055;
        };
    L_0x0055:
        r0 = "unknown";
        r2 = r1;
        goto L_0x0007;
    L_0x005a:
        r0 = "gps available";
        r2 = r1;
        goto L_0x0007;
    L_0x005f:
        r0 = "gps unavailable";
        r2 = r1;
        goto L_0x0007;
    L_0x0064:
        r1 = "cell";
        r0 = 1;
        if (r7 != r0) goto L_0x0077;
    L_0x006a:
        r0 = "cell enabled";
    L_0x006d:
        r2 = c.t.m.g.ec.a;
        if (r2 == 0) goto L_0x00a4;
    L_0x0071:
        r0 = "location permission denied";
        r2 = r1;
        r7 = r3;
        goto L_0x0007;
    L_0x0077:
        if (r7 != 0) goto L_0x007d;
    L_0x0079:
        r0 = "cell disabled";
        goto L_0x006d;
    L_0x007d:
        r0 = "unknown";
        goto L_0x006d;
    L_0x0081:
        r1 = "wifi";
        switch(r7) {
            case 0: goto L_0x0098;
            case 1: goto L_0x009c;
            case 2: goto L_0x0087;
            case 3: goto L_0x0087;
            case 4: goto L_0x0087;
            case 5: goto L_0x00a0;
            default: goto L_0x0087;
        };
    L_0x0087:
        r0 = "unknown";
    L_0x008a:
        r2 = 5;
        if (r7 == r2) goto L_0x00a4;
    L_0x008d:
        r2 = c.t.m.g.ej.a;
        if (r2 == 0) goto L_0x00a4;
    L_0x0091:
        r0 = "location permission denied";
        r2 = r1;
        r7 = r3;
        goto L_0x0007;
    L_0x0098:
        r0 = "wifi disabled";
        goto L_0x008a;
    L_0x009c:
        r0 = "wifi enabled";
        goto L_0x008a;
    L_0x00a0:
        r0 = "location service switch is off";
        goto L_0x008a;
    L_0x00a4:
        r2 = r1;
        goto L_0x0007;
        */
        throw new UnsupportedOperationException("Method not decompiled: c.t.m.g.dg.a(int, int):void");
    }

    public final void a(eb ebVar, int i, int i2) {
        if (ebVar != null && this.q != null) {
            Message obtainMessage = this.q.obtainMessage(i2);
            Bundle data = obtainMessage.getData();
            if (data == null) {
                data = new Bundle();
            }
            data.clear();
            data.putInt("error_code", i);
            data.putParcelable("tx_location", ebVar);
            obtainMessage.setData(data);
            obtainMessage.sendToTarget();
        }
    }

    @Nullable
    private df h() {
        Object obj;
        if (this.H.g != null) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj == null) {
            return null;
        }
        return new df(this.H);
    }

    @Nullable
    private dm i() {
        Object obj;
        if (this.H.f != null) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj == null) {
            return null;
        }
        return new dm(this.H);
    }

    private static String a(String str) {
        Object obj = 1;
        if (str.contains(",")) {
            try {
                String[] split = str.split(",");
                if (split == null || split.length <= 1 || split[0] == null || split[1] == null || e.w(split[0], split[1]) <= 0) {
                    obj = null;
                }
                return obj != null ? split[0] : "";
            } catch (UnsatisfiedLinkError e) {
                return null;
            }
        }
        int v = e.v(str);
        return v >= 0 ? Integer.toString(v) : "";
    }
}

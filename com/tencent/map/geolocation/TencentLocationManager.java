package com.tencent.map.geolocation;

import android.content.Context;
import android.os.Looper;
import c.t.m.g.ct;
import c.t.m.g.cu;
import c.t.m.g.dg;
import c.t.m.g.dg.b;
import java.lang.ref.WeakReference;

public final class TencentLocationManager {
    public static final int COORDINATE_TYPE_GCJ02 = 1;
    public static final int COORDINATE_TYPE_WGS84 = 0;
    private static TencentLocationManager d;
    private final byte[] a = new byte[0];
    private final ct b;
    private final dg c;

    private TencentLocationManager(Context context) {
        this.b = ct.a(context);
        this.c = new dg(this.b);
    }

    public static synchronized TencentLocationManager getInstance(Context context) {
        TencentLocationManager tencentLocationManager;
        synchronized (TencentLocationManager.class) {
            if (d == null) {
                if (context == null) {
                    throw new NullPointerException("context is null");
                } else if (context.getApplicationContext() == null) {
                    throw new NullPointerException("application context is null");
                } else {
                    d = new TencentLocationManager(context.getApplicationContext());
                }
            }
            tencentLocationManager = d;
        }
        return tencentLocationManager;
    }

    public final void setCoordinateType(int i) {
        if (i == 1 || i == 0) {
            synchronized (this.a) {
                dg dgVar = this.c;
                if (dgVar.b != i) {
                    dgVar.b = i;
                }
            }
            return;
        }
        throw new IllegalArgumentException("unknown coordinate type: " + i);
    }

    public final int getCoordinateType() {
        return this.c.b;
    }

    public final int requestLocationUpdates(TencentLocationRequest tencentLocationRequest, TencentLocationListener tencentLocationListener) {
        return requestLocationUpdates(tencentLocationRequest, tencentLocationListener, Looper.myLooper());
    }

    public final int requestLocationUpdates(TencentLocationRequest tencentLocationRequest, TencentLocationListener tencentLocationListener, Looper looper) {
        if (tencentLocationRequest == null) {
            throw new NullPointerException("request is null");
        } else if (tencentLocationListener == null) {
            throw new NullPointerException("listener is null");
        } else if (looper == null) {
            throw new NullPointerException("looper is null");
        } else {
            int a;
            synchronized (this.a) {
                a = this.c.a(tencentLocationRequest, tencentLocationListener, looper);
            }
            return a;
        }
    }

    public final int requestSingleFreshLocation(TencentLocationListener tencentLocationListener, Looper looper) {
        int i = 0;
        if (tencentLocationListener == null) {
            throw new NullPointerException("listener is null");
        } else if (looper == null) {
            throw new NullPointerException("looper is null");
        } else {
            synchronized (this.a) {
                dg dgVar = this.c;
                if (dgVar.d != 0) {
                    i = dgVar.d;
                } else {
                    if (!(tencentLocationListener == null || dgVar.f == null)) {
                        dgVar.f.add(new WeakReference(tencentLocationListener));
                    }
                    if (System.currentTimeMillis() - dgVar.g >= 2000) {
                        dgVar.g = System.currentTimeMillis();
                        if (dgVar.f != null && dgVar.l == 0 && dgVar.k != null && ((dgVar.k.getProvider().equals(TencentLocation.GPS_PROVIDER) && System.currentTimeMillis() - dgVar.k.getTime() <= 90000) || (dgVar.k.getProvider().equals(TencentLocation.NETWORK_PROVIDER) && System.currentTimeMillis() - dgVar.k.getTime() <= 30000))) {
                            dgVar.a(dgVar.k, dgVar.l, 3103);
                            dgVar.g = 0;
                        } else if (dgVar.m == b.a) {
                            dgVar.a(3997);
                        } else {
                            i = dgVar.a(TencentLocationRequest.create().setInterval(0), dg.a, looper);
                            dgVar.m = b.c;
                        }
                    }
                }
            }
            return i;
        }
    }

    public final boolean startIndoorLocation() {
        this.c.i = 1;
        return true;
    }

    public final boolean stopIndoorLocation() {
        dg dgVar = this.c;
        if (dgVar.i > 0) {
            boolean z;
            if (dgVar.c != null) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                dgVar.c.j = dgVar.e.l;
            }
            if (Long.valueOf(dgVar.h) != null) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                dgVar.h = dgVar.j.getInterval();
            }
            dgVar.i = 0;
        }
        return true;
    }

    public final TencentLocation getLastKnownLocation() {
        dg dgVar = this.c;
        if (dgVar.l != 0) {
            return null;
        }
        dgVar.a(dgVar.k);
        return dgVar.k;
    }

    public final void removeUpdates(TencentLocationListener tencentLocationListener) {
        synchronized (this.a) {
            this.c.a();
        }
    }

    public final String getBuild() {
        cu c = this.b.c();
        return c != null ? c.e() : "None";
    }

    public final String getVersion() {
        cu c = this.b.c();
        return c != null ? c.d() : "None";
    }
}

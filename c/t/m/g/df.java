package c.t.m.g;

import android.annotation.SuppressLint;
import android.location.GpsSatellite;
import android.location.GpsStatus;
import android.location.GpsStatus.Listener;
import android.location.GpsStatus.NmeaListener;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Message;
import android.text.format.DateFormat;
import com.tencent.map.geolocation.internal.TencentExtraKeys;
import com.tencent.rtmp.TXLiveConstants;
import java.util.ArrayList;
import java.util.Iterator;

final class df implements Listener, NmeaListener, LocationListener {
    final ct a;
    volatile int b = 1024;
    volatile Location c;
    volatile long d = 0;
    boolean e = false;
    boolean f = false;
    int g = 0;
    int h = 0;
    int i = 0;
    ArrayList<Float> j = new ArrayList();
    volatile boolean k;
    boolean l;
    long m = -1;
    a n;
    Runnable o;
    Runnable p;
    Runnable q;
    long r;
    final double[] s = new double[2];
    private volatile GpsStatus t;
    private df u;
    private cz v;
    private LocationManager w;

    static /* synthetic */ boolean g(df dfVar) {
        int i = dfVar.g;
        int i2 = dfVar.h;
        if (i > 0) {
            dfVar.f = true;
        }
        if (i2 > 0) {
            dfVar.e = true;
        }
        if (!dfVar.f || i > 2) {
            if (dfVar.e) {
                if (i2 >= 3 || i2 == 0) {
                    return true;
                }
            } else if (i2 == 0) {
                return true;
            }
        }
        return false;
    }

    public df(ct ctVar) {
        this.a = ctVar;
        this.v = cz.a();
        this.u = this;
        this.w = this.a.g;
        this.o = new Runnable() {
            @SuppressLint({"MissingPermission"})
            public final void run() {
                try {
                    df.this.w.addGpsStatusListener(df.this.u);
                    Bundle bundle = new Bundle();
                    df.this.w.sendExtraCommand("gps", "force_xtra_injection", bundle);
                    df.this.w.sendExtraCommand("gps", "force_time_injection", bundle);
                } catch (Throwable th) {
                    th.toString();
                }
            }
        };
        this.p = new Runnable() {
            @SuppressLint({"MissingPermission"})
            public final void run() {
                try {
                    df.this.w.requestLocationUpdates("gps", 1000, 0.0f, df.this.u);
                } catch (Throwable th) {
                    ec.a = true;
                }
                try {
                    df.this.w.addNmeaListener(df.this.u);
                } catch (Throwable th2) {
                }
            }
        };
        this.q = new 3(this);
    }

    @SuppressLint({"MissingPermission"})
    public final Location a() {
        Location location = null;
        try {
            location = this.a.g.getLastKnownLocation("network");
        } catch (Throwable th) {
        }
        if (location == null) {
            return dd.a;
        }
        int i = (this.l && ed.a(location.getLatitude(), location.getLongitude())) ? 1 : 0;
        if (i != 0) {
            ei.a(location, this.s);
            a(location, this.s[0], this.s[1], 0);
            return location;
        }
        a(location, location.getLatitude(), location.getLongitude(), 0);
        return location;
    }

    public final boolean b() {
        return System.currentTimeMillis() - this.d < 20000;
    }

    public final boolean c() {
        boolean z = false;
        try {
            return this.a.g.isProviderEnabled("gps");
        } catch (Throwable th) {
            return z;
        }
    }

    private static boolean a(double d) {
        if (Math.abs(((double) Double.valueOf(d).longValue()) - d) < Double.MIN_VALUE) {
            return true;
        }
        return false;
    }

    private static boolean b(Location location) {
        try {
            if (location.getAccuracy() > 10000.0f) {
                return false;
            }
            if ((a(location.getLatitude()) && a(location.getLongitude())) || Math.abs(location.getLatitude()) < 1.0E-8d || Math.abs(location.getLongitude()) < 1.0E-8d || Math.abs(location.getLatitude() - 1.0d) < 1.0E-8d || Math.abs(location.getLongitude() - 1.0d) < 1.0E-8d || location.getLatitude() < -90.0d || location.getLatitude() > 90.0d || location.getLongitude() < -180.0d || location.getLongitude() > 180.0d) {
                return false;
            }
            return true;
        } catch (Throwable th) {
            th.toString();
        }
    }

    /* renamed from: d */
    final void k() {
        int i;
        if (this.b == 4) {
            i = 1;
        } else if (this.b == 0) {
            i = 0;
        } else {
            i = -1;
        }
        Message message = new Message();
        message.what = 12999;
        message.arg1 = 12002;
        message.arg2 = i;
        this.a.c(message);
    }

    @SuppressLint({"NewApi"})
    private boolean c(Location location) {
        if (!TencentExtraKeys.MOCK_LOCATION_FILTER) {
            return false;
        }
        try {
            if (!this.a.g.isProviderEnabled("gps")) {
                return true;
            }
            if (VERSION.SDK_INT < 18 || !location.isFromMockProvider()) {
                return false;
            }
            return true;
        } catch (Throwable th) {
            return false;
        }
    }

    public final void onNmeaReceived(long j, String str) {
        if (str != null && str.length() > 5) {
            int indexOf = str.indexOf(",");
            String trim = indexOf <= 0 ? null : str.substring(0, indexOf).trim();
            if (trim != null && trim.length() > 5 && trim.charAt(3) == 'R') {
                if (("$GPRMC".equals(trim) || "$GNRMC".equals(trim) || "$BDRMC".equals(trim) || "$GLRMC".equals(trim)) && "A".equals(str.split(",")[2])) {
                    this.r = System.currentTimeMillis();
                }
            }
        }
    }

    public final void onLocationChanged(Location location) {
        try {
            new StringBuilder("onLocationChanged: ").append(DateFormat.format("yyyy-MM-dd kk:mm:ss", location.getTime())).append(",").append(VERSION.SDK_INT >= 17 ? location.getElapsedRealtimeNanos() : 0).append(",").append(location.getLatitude()).append(",").append(location.getLongitude()).append(",").append(location.toString());
            if (location != null && "gps".equals(location.getProvider())) {
                if (this.r == -1 || System.currentTimeMillis() - this.r < 2000) {
                    this.c = location;
                    a((int) TXLiveConstants.PUSH_WARNING_NET_BUSY);
                }
            }
        } catch (Throwable th) {
        }
    }

    public final void onStatusChanged(String str, int i, Bundle bundle) {
    }

    public final void onProviderEnabled(String str) {
        if ("gps".equals(str)) {
            a((int) TXLiveConstants.PUSH_WARNING_HW_ACCELERATION_FAIL);
        }
    }

    public final void onProviderDisabled(String str) {
        if ("gps".equals(str)) {
            a((int) TXLiveConstants.PUSH_WARNING_VIDEO_ENCODE_FAIL);
        }
    }

    @SuppressLint({"MissingPermission"})
    public final void onGpsStatusChanged(int i) {
        switch (i) {
            case 1:
                this.b |= 1;
                return;
            case 2:
                this.b = 0;
                return;
            case 3:
                this.b |= 2;
                return;
            case 4:
                LocationManager locationManager = this.a.g;
                try {
                    if (this.t == null) {
                        this.t = locationManager.getGpsStatus(null);
                    } else {
                        locationManager.getGpsStatus(this.t);
                    }
                } catch (Throwable th) {
                }
                a((int) TXLiveConstants.PUSH_WARNING_RECONNECT);
                return;
            default:
                return;
        }
    }

    private void a(int i) {
        if (this.n != null) {
            this.n.obtainMessage(i).sendToTarget();
        }
    }

    private static void a(Location location, double d, double d2, int i) {
        Bundle extras = location.getExtras();
        if (extras == null) {
            extras = new Bundle();
        }
        extras.putDouble("lat", d);
        extras.putDouble("lng", d2);
        extras.putInt("rssi", i);
        location.setExtras(extras);
    }

    static /* synthetic */ void d(df dfVar) {
        try {
            dfVar.i = 0;
            dfVar.h = 0;
            dfVar.g = 0;
            GpsStatus gpsStatus = dfVar.t;
            if (gpsStatus != null) {
                dfVar.j.clear();
                dfVar.i = gpsStatus.getMaxSatellites();
                Iterator it = gpsStatus.getSatellites().iterator();
                if (it != null) {
                    while (it.hasNext() && dfVar.g <= dfVar.i) {
                        GpsSatellite gpsSatellite = (GpsSatellite) it.next();
                        dfVar.g++;
                        dfVar.j.add(Float.valueOf(gpsSatellite.getSnr()));
                        if (gpsSatellite.usedInFix()) {
                            dfVar.h++;
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.toString();
        }
    }
}

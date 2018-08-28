package com.d.a.a;

import android.content.Context;
import android.location.LocationManager;
import android.os.Handler;
import com.d.a.a.n.c;
import com.tencent.map.geolocation.internal.TencentExtraKeys;
import java.lang.ref.WeakReference;

public final class t {
    private static boolean bgH = false;
    private static Context bks;
    private static WeakReference<b> bkt;
    private static WeakReference<d> bku;
    private static WeakReference<c> bkv;
    private static WeakReference<e> bkw;
    private static final a bkx = new a((byte) 0);
    private static String imei;

    public static void a(Context context, q qVar) {
        bks = context.getApplicationContext();
        try {
            w.sY().a(context, new m[]{bkx});
            r.sC().bjL = qVar;
            r.sC().bjM = imei;
        } catch (Exception e) {
        }
    }

    public static void setImei(String str) {
        imei = str;
    }

    public static boolean a(Handler handler, long j, b bVar, d dVar) {
        if (bks == null) {
            return false;
        }
        if (bgH) {
            return true;
        }
        bkt = new WeakReference(bVar);
        bku = new WeakReference(dVar);
        bkv = new WeakReference(null);
        try {
            w sY = w.sY();
            if (handler == null) {
                handler = new Handler(bks.getMainLooper());
            }
            sY.a(handler, new c(j, 5000));
            if (y.bmK) {
                y.bmR = o.sB();
                o.q("filter_input_log_" + y.bmR, "type,unixTime,latR,lngR,alt,acc,numWap,speed,maturity,numStep,stepLength,bearingR");
                o.q("filter_output_log_" + y.bmR, "time,lat,lng,err,speed");
                o.q("gps_log_" + y.bmR, "lat,lng,alt,accuracy,speed,numSatVisible,numSatUsedInFix,quality,timeSinceFixS");
                o.q("post_processing_log_" + y.bmR, "tag,lat,lng");
            }
            if (!(bkw == null || ((e) bkw.get()) == null)) {
                boolean isProviderEnabled;
                LocationManager locationManager = (LocationManager) bks.getSystemService("location");
                try {
                    isProviderEnabled = locationManager.isProviderEnabled(TencentExtraKeys.LOCATION_SOURCE_GPS);
                } catch (SecurityException e) {
                    isProviderEnabled = false;
                }
                if (!isProviderEnabled) {
                    try {
                        locationManager.isProviderEnabled("network");
                    } catch (SecurityException e2) {
                    }
                }
            }
            bgH = true;
            return true;
        } catch (Exception e3) {
            bgH = false;
            return false;
        }
    }

    public static void sP() {
        try {
            w.sY().stop();
        } catch (Exception e) {
        } finally {
            bgH = false;
        }
    }

    public static void finish() {
        try {
            w.sY().su();
        } catch (Exception e) {
        }
    }
}

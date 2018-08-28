package com.tencent.mm.plugin.appbrand.jsapi.f.a;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.compat.a.c;
import com.tencent.mm.plugin.appbrand.e$b;
import com.tencent.mm.pluginsdk.q;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public final class b {
    public static SensorManager ejl;
    private static HashMap<String, HashMap<String, c>> fSQ = new HashMap();
    private static HashMap<String, e$b> fSR = new HashMap();
    private static Set<c> fSS = new HashSet();
    public static com.tencent.mm.plugin.appbrand.r.b.b fST;
    public static a fSU;

    private static class a implements SensorEventListener {
        private float fSV = 0.0f;
        private long timestamp = 200;

        public final void onSensorChanged(SensorEvent sensorEvent) {
            if (sensorEvent.sensor.getType() == 3) {
                long currentTimeMillis = System.currentTimeMillis() - this.timestamp;
                float ay = q.ay(sensorEvent.values[0]);
                if (currentTimeMillis > 200 && Math.abs(ay - this.fSV) > 3.0f) {
                    synchronized (b.fSQ) {
                        for (HashMap values : b.fSQ.values()) {
                            for (c cVar : values.values()) {
                                if (!(cVar == null || !cVar.fSX || cVar.isBackground || cVar.fSY == null)) {
                                    d dVar = cVar.fSY;
                                    dVar.fTV = ay;
                                    float heading = dVar.getHeading();
                                    if (dVar.fTv != null) {
                                        x.d("MicroMsg.AppbrandMapLocationPoint", "updateRotation rotation:%f", new Object[]{Float.valueOf(heading)});
                                        dVar.fTv.setRotation(heading);
                                    }
                                }
                            }
                        }
                    }
                    this.fSV = ay;
                    this.timestamp = System.currentTimeMillis();
                }
            }
        }

        public final void onAccuracyChanged(Sensor sensor, int i) {
        }
    }

    private static synchronized void init() {
        synchronized (b.class) {
            x.i("MicroMsg.AppBrandMapManager", "init");
            if (fST == null) {
                fST = new 1();
                com.tencent.mm.plugin.appbrand.r.b.a.b.aoC().a(fST);
            }
            if (fSU == null) {
                fSU = new a();
                SensorManager sensorManager = (SensorManager) ad.getContext().getSystemService("sensor");
                ejl = sensorManager;
                ejl.registerListener(fSU, sensorManager.getDefaultSensor(3), 1);
            }
        }
    }

    public static synchronized void a(c cVar) {
        synchronized (b.class) {
            x.i("MicroMsg.AppBrandMapManager", "registerListener map:%s", new Object[]{cVar});
            fSS.add(cVar);
            if (fSS.size() == 1) {
                init();
            }
        }
    }

    private static synchronized void uninit() {
        synchronized (b.class) {
            x.i("MicroMsg.AppBrandMapManager", "uninit");
            if (fST != null) {
                x.i("MicroMsg.AppBrandMapManager", "locationListener uninit");
                com.tencent.mm.plugin.appbrand.r.b.a.b.aoC().b(fST);
                fST = null;
            }
            if (!(fSU == null || ejl == null)) {
                x.i("MicroMsg.AppBrandMapManager", "sensorListener uninit");
                ejl.unregisterListener(fSU);
                ejl = null;
                fSU = null;
            }
        }
    }

    public static synchronized void b(c cVar) {
        synchronized (b.class) {
            x.i("MicroMsg.AppBrandMapManager", "unregisterListener map:%s", new Object[]{cVar});
            fSS.remove(cVar);
            if (fSS.size() == 0) {
                uninit();
            }
        }
    }

    public static c a(Context context, String str, int i, int i2, boolean z) {
        if (i2 == -1) {
            x.e("MicroMsg.AppBrandMapManager", "[createMapView]INVALID_MAP_ID");
            return null;
        }
        HashMap hashMap;
        synchronized (fSQ) {
            HashMap hashMap2 = (HashMap) fSQ.get(str);
            if (hashMap2 == null) {
                e$b e_b;
                hashMap = new HashMap();
                fSQ.put(str, hashMap);
                synchronized (fSR) {
                    e_b = (e$b) fSR.get(str);
                }
                if (e_b == null) {
                    x.i("MicroMsg.AppBrandMapManager", "[initLifeListener] appId:%s", new Object[]{str});
                    fSR.put(str, new 2(str));
                }
            } else {
                hashMap = hashMap2;
            }
        }
        c cVar = (c) hashMap.get(i + "&" + i2);
        if (cVar != null) {
            x.i("MicroMsg.AppBrandMapManager", "map is exist, return");
            View view = cVar.getView();
            if (view == null || !ViewGroup.class.isInstance(view.getParent())) {
                return cVar;
            }
            ((ViewGroup) view.getParent()).removeView(view);
            return cVar;
        }
        x.i("MicroMsg.AppBrandMapManager", "createMapView appId:%s, componentId:%d mapId:%d", new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2)});
        com.tencent.mm.plugin.appbrand.compat.a.b l = ((c) g.l(c.class)).l(context, z);
        l.adv();
        l.onResume();
        cVar = new c(context, str, i2, l);
        hashMap.put(i + "&" + i2, cVar);
        x.i("MicroMsg.AppBrandMapManager", "appId:%s, map count:%d", new Object[]{str, Integer.valueOf(hashMap.size())});
        return cVar;
    }

    public static c E(String str, int i, int i2) {
        if (i2 == -1) {
            x.e("MicroMsg.AppBrandMapManager", "[getMapView]INVALID_MAP_ID");
            return null;
        }
        synchronized (fSQ) {
            HashMap hashMap = (HashMap) fSQ.get(str);
            if (hashMap == null) {
                return null;
            }
            c cVar = (c) hashMap.get(i + "&" + i2);
            return cVar;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void F(java.lang.String r9, int r10, int r11) {
        /*
        r8 = 2;
        r7 = 1;
        r6 = 0;
        r1 = fSQ;
        monitor-enter(r1);
        r0 = fSQ;	 Catch:{ all -> 0x003d }
        r0 = r0.get(r9);	 Catch:{ all -> 0x003d }
        r0 = (java.util.HashMap) r0;	 Catch:{ all -> 0x003d }
        if (r0 != 0) goto L_0x0012;
    L_0x0010:
        monitor-exit(r1);	 Catch:{ all -> 0x003d }
    L_0x0011:
        return;
    L_0x0012:
        monitor-exit(r1);	 Catch:{ all -> 0x003d }
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r1 = r1.append(r10);
        r2 = "&";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r1 = r1.toString();
        r1 = r0.get(r1);
        r1 = (com.tencent.mm.plugin.appbrand.jsapi.f.a.c) r1;
        if (r1 != 0) goto L_0x0040;
    L_0x0033:
        r0 = "MicroMsg.AppBrandMapManager";
        r1 = "[destroyMapView] mapview not exist, err";
        com.tencent.mm.sdk.platformtools.x.e(r0, r1);
        goto L_0x0011;
    L_0x003d:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003d }
        throw r0;
    L_0x0040:
        r2 = "MicroMsg.AppBrandMapManager";
        r3 = "destoryMapView appId:%s, componentId:%d, mapId:%d";
        r4 = 3;
        r4 = new java.lang.Object[r4];
        r4[r6] = r9;
        r5 = java.lang.Integer.valueOf(r10);
        r4[r7] = r5;
        r5 = java.lang.Integer.valueOf(r11);
        r4[r8] = r5;
        com.tencent.mm.sdk.platformtools.x.i(r2, r3, r4);
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r2 = r2.append(r10);
        r3 = "&";
        r2 = r2.append(r3);
        r2 = r2.append(r11);
        r2 = r2.toString();
        r0.remove(r2);
        r2 = r0.size();
        if (r2 > 0) goto L_0x00ae;
    L_0x007b:
        r2 = fSQ;
        monitor-enter(r2);
        r3 = fSQ;	 Catch:{ all -> 0x00cd }
        r3.remove(r9);	 Catch:{ all -> 0x00cd }
        b(r1);	 Catch:{ all -> 0x00cd }
        monitor-exit(r2);	 Catch:{ all -> 0x00cd }
        r2 = "MicroMsg.AppBrandMapManager";
        r3 = "[uninitLifeListener] appId:%s";
        r4 = new java.lang.Object[r7];
        r4[r6] = r9;
        com.tencent.mm.sdk.platformtools.x.i(r2, r3, r4);
        r3 = fSR;
        monitor-enter(r3);
        r2 = fSR;	 Catch:{ all -> 0x00d0 }
        r2 = r2.get(r9);	 Catch:{ all -> 0x00d0 }
        r2 = (com.tencent.mm.plugin.appbrand.e$b) r2;	 Catch:{ all -> 0x00d0 }
        monitor-exit(r3);	 Catch:{ all -> 0x00d0 }
        if (r2 == 0) goto L_0x00a5;
    L_0x00a2:
        com.tencent.mm.plugin.appbrand.e.b(r9, r2);
    L_0x00a5:
        r2 = fSR;
        monitor-enter(r2);
        r3 = fSR;	 Catch:{ all -> 0x00d3 }
        r3.remove(r9);	 Catch:{ all -> 0x00d3 }
        monitor-exit(r2);	 Catch:{ all -> 0x00d3 }
    L_0x00ae:
        r1.onPause();
        r1.onDestroy();
        r1 = "MicroMsg.AppBrandMapManager";
        r2 = "[destroyMapView]appid:%s, map count:%d";
        r3 = new java.lang.Object[r8];
        r3[r6] = r9;
        r0 = r0.size();
        r0 = java.lang.Integer.valueOf(r0);
        r3[r7] = r0;
        com.tencent.mm.sdk.platformtools.x.i(r1, r2, r3);
        goto L_0x0011;
    L_0x00cd:
        r0 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x00cd }
        throw r0;
    L_0x00d0:
        r0 = move-exception;
        monitor-exit(r3);	 Catch:{ all -> 0x00d0 }
        throw r0;
    L_0x00d3:
        r0 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x00d3 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.jsapi.f.a.b.F(java.lang.String, int, int):void");
    }
}

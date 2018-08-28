package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.scan;

import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.location.LocationManager;
import android.os.Build.VERSION;
import android.os.Handler;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.c.b;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.c.d;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.c.i;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.c.j;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public final class a {
    public Context context;
    public BroadcastReceiver fKZ;
    public e fMN;
    public ScanSettingsCompat fMO;
    public Map<String, d> fMP;
    public AtomicBoolean fMQ = new AtomicBoolean(false);
    public AtomicBoolean fMR = new AtomicBoolean(false);
    public List<d> fMS;
    Runnable fMT = new 1(this);
    i fMU;
    final Handler mHandler = new Handler();

    public a(Context context) {
        this.context = context;
    }

    public final synchronized void a(b bVar, List<ScanFilterCompat> list, i iVar) {
        if (!this.fMR.get()) {
            bVar.a(j.fMF);
        } else if (this.fMQ.get()) {
            com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.d.a.w("MicroMsg.Ble.BleScanWorker", "already scan", new Object[0]);
            bVar.a(j.fMv);
        } else {
            BluetoothAdapter aiA = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.d.b.aiA();
            if (aiA == null || !com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.d.b.aiB()) {
                com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.d.a.e("MicroMsg.Ble.BleScanWorker", "BluetoothAdapter is null, err", new Object[0]);
                bVar.a(j.fMy);
            } else {
                List list2;
                if (VERSION.SDK_INT >= 23) {
                    boolean isProviderEnabled;
                    boolean z = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.d.b.tu("android.permission.ACCESS_COARSE_LOCATION") || com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.d.b.tu("android.permission.ACCESS_FINE_LOCATION");
                    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.d.a.i("MicroMsg.Ble.BleScanWorker", "checkLocationPermission :%b", new Object[]{Boolean.valueOf(z)});
                    LocationManager locationManager = (LocationManager) ad.getContext().getSystemService("location");
                    if (locationManager != null) {
                        isProviderEnabled = locationManager.isProviderEnabled(TencentLocation.GPS_PROVIDER);
                        z = locationManager.isProviderEnabled(TencentLocation.NETWORK_PROVIDER);
                        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.d.a.i("MicroMsg.Ble.BleHelper", "isGPSEnable " + isProviderEnabled + ", isNetworkEnable:" + z, new Object[0]);
                    } else {
                        z = false;
                        isProviderEnabled = false;
                    }
                    if (isProviderEnabled && r0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.d.a.i("MicroMsg.Ble.BleScanWorker", "checkGpsEnable:%b", new Object[]{Boolean.valueOf(z)});
                }
                this.fMQ.set(true);
                if (list2 != null && list2.size() == 0) {
                    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.d.a.w("MicroMsg.Ble.BleScanWorker", "scanFilterCompats size:%d", new Object[]{Integer.valueOf(list2.size())});
                    list2 = null;
                }
                com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.d.a.i("MicroMsg.Ble.BleScanWorker", "startBleScan isOk:%b", new Object[]{Boolean.valueOf(b.a(aiA, list2, this.fMO, this.fMN))});
                if (b.a(aiA, list2, this.fMO, this.fMN)) {
                    this.fMU = iVar;
                    if (com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.a.fLt.djl > 0) {
                        this.mHandler.postDelayed(this.fMT, (long) com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.a.fLt.djl);
                    }
                    bVar.a(j.fMv);
                } else {
                    bVar.a(j.fMF);
                }
            }
        }
    }

    public final synchronized j aiw() {
        j jVar;
        if (!this.fMR.get()) {
            jVar = j.fMx;
        } else if (this.fMQ.get()) {
            BluetoothAdapter aiA = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.d.b.aiA();
            if (aiA == null || !com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.d.b.aiB()) {
                com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.d.a.e("MicroMsg.Ble.BleScanWorker", "BluetoothAdapter is null, err", new Object[0]);
                jVar = j.fMy;
            } else {
                this.fMQ.set(false);
                b.a(aiA, this.fMN);
                jVar = j.fMv;
            }
        } else {
            com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.d.a.w("MicroMsg.Ble.BleScanWorker", "not scan", new Object[0]);
            jVar = j.fMv;
        }
        return jVar;
    }
}

package com.tencent.mm.plugin.card.b;

import android.content.IntentFilter;
import android.location.LocationManager;
import com.tencent.map.geolocation.TencentLocationListener;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.card.a.g;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.model.ai;
import com.tencent.mm.protocal.c.iu;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;

public final class i implements e {
    public volatile float cXm = -85.0f;
    public volatile float cXn = -1000.0f;
    String htC;
    private b htQ;
    public MMActivity hub;
    public volatile boolean huc = false;
    private volatile boolean hud = false;
    public Object hue = new Object();
    private boolean huf = false;
    boolean hug = false;
    private boolean huh = false;
    iu hui;
    private b huj;
    public a huk;
    private int hul = 60;
    private long hum = 0;
    private long hun = 0;
    private long huo = 10000;
    public al hup = new al(new 1(this), false);

    public final void a(MMActivity mMActivity, String str, b bVar, float f, float f2) {
        int i;
        boolean z;
        this.huc = true;
        this.hub = mMActivity;
        this.htC = str;
        this.htQ = bVar;
        this.cXm = f;
        this.cXn = f2;
        this.huf = bVar.awm().rop;
        this.hug = bVar.awn().rns;
        this.hui = bVar.awm().roq;
        if (bVar.awm().roq == null) {
            i = 60;
        } else {
            i = bVar.awm().roq.rjZ;
        }
        this.hul = i;
        if (bVar.awm().roq == null || bi.oW(bVar.awm().roq.name)) {
            z = false;
        } else {
            z = true;
        }
        this.huh = z;
        x.i("MicroMsg.CardLbsOrBluetooth", "init cardId:%s, needLocation:%b, isLocationAuth:%b needBluetooth:%b reportTime:%d", new Object[]{str, Boolean.valueOf(this.huf), Boolean.valueOf(this.hug), Boolean.valueOf(this.huh), Integer.valueOf(this.hul)});
        if (this.huf && !this.hug) {
            String str2 = bi.oW(this.htQ.awm().ror) ? this.htQ.awm().title : this.htQ.awm().ror;
            h.a(this.hub, this.hub.getString(g.card_report_location_confirm, new Object[]{str2}), this.hub.getString(g.app_tip), new 2(this), new 3(this));
        }
        if (this.huh) {
            x.i("MicroMsg.CardLbsOrBluetooth", "initBluetoothHelper blueToothInfo.name:%s", new Object[]{this.hui.name});
            this.huk = new a(this, (byte) 0);
            a aVar = this.huk;
            x.i("MicroMsg.CardLbsOrBluetooth", "init bluetoothStateListener");
            aVar.fKZ = new 2(aVar);
            ad.getContext().registerReceiver(aVar.fKZ, new IntentFilter("android.bluetooth.adapter.action.STATE_CHANGED"));
        }
        start();
        xP();
    }

    public final void start() {
        if (awQ()) {
            x.i("MicroMsg.CardLbsOrBluetooth", "start");
            if (this.huc) {
                if (this.huf) {
                    LocationManager locationManager = (LocationManager) ad.getContext().getSystemService("location");
                    if (locationManager != null) {
                        boolean isProviderEnabled = locationManager.isProviderEnabled(TencentLocationListener.GPS);
                        boolean isProviderEnabled2 = locationManager.isProviderEnabled("network");
                        x.i("MicroMsg.CardLbsOrBluetooth", "isGPSEnable:%b isNetworkEnable:%b", new Object[]{Boolean.valueOf(isProviderEnabled), Boolean.valueOf(isProviderEnabled2)});
                    }
                }
                if (this.huk != null && this.huh) {
                    this.huk.awS();
                }
                awN();
                com.tencent.mm.kernel.g.Eh().dpP.a(2574, this);
                return;
            }
            x.e("MicroMsg.CardLbsOrBluetooth", "isInit:%b", new Object[]{Boolean.valueOf(this.huc)});
        }
    }

    public final void awN() {
        awO();
        if (this.hul > 0) {
            long j = (long) (this.hul * 1000);
            this.hup.J(j, j);
            x.i("MicroMsg.CardLbsOrBluetooth", "start ReportTimer!");
            return;
        }
        x.e("MicroMsg.CardLbsOrBluetooth", "not to start ReportTimer!");
    }

    public final void awO() {
        x.i("MicroMsg.CardLbsOrBluetooth", "stop ReportTimer!");
        if (!this.hup.ciq()) {
            this.hup.SO();
        }
    }

    public final void xP() {
        if (!awQ()) {
            x.i("MicroMsg.CardLbsOrBluetooth", "[report]not need report");
        } else if (this.hud) {
            x.i("MicroMsg.CardLbsOrBluetooth", "isReporting, return");
        } else {
            boolean z;
            boolean awP;
            this.hud = true;
            if (this.huh) {
                if (this.huk == null) {
                    x.e("MicroMsg.CardLbsOrBluetooth", "[needReportBluetooth]bluetoothHelper is null, return");
                } else if (!this.huk.awR().byN.equals("") && System.currentTimeMillis() - this.hum >= this.huo) {
                    z = true;
                    awP = awP();
                    x.i("MicroMsg.CardLbsOrBluetooth", "report needLocation:%b, isLocationAuth:%b, isBluetoothEnable:%b, needReportBluetooth:%b needReportGps:%b", new Object[]{Boolean.valueOf(this.huf), Boolean.valueOf(this.hug), Boolean.valueOf(this.huk.hus), Boolean.valueOf(z), Boolean.valueOf(awP)});
                    b awR;
                    if (!z && awP) {
                        awR = this.huk.awR();
                        x.i("MicroMsg.CardLbsOrBluetooth", "reportBluetoothAndGps deviceInfo:%s", new Object[]{awR});
                        x.d("MicroMsg.CardLbsOrBluetooth", "reportBluetoothAndGps lbsLongitude:%f, lbsLatitude:%f", new Object[]{Float.valueOf(this.cXn), Float.valueOf(this.cXm)});
                        a(this.htC, awR.huy, this.cXn, this.cXm, awR.bMF, this.huk.hus, this.hug);
                        this.hun = System.currentTimeMillis();
                        this.hum = System.currentTimeMillis();
                        this.huk.reset();
                        this.huj = awR;
                        return;
                    } else if (z) {
                        awR = this.huk.awR();
                        x.i("MicroMsg.CardLbsOrBluetooth", "reportBluetooth deviceInfo:%s", new Object[]{awR});
                        a(this.htC, awR.huy, -1000.0f, -85.0f, awR.bMF, this.huk.hus, this.hug);
                        this.hum = System.currentTimeMillis();
                        this.huk.reset();
                        this.huj = awR;
                    } else if (awP) {
                        x.i("MicroMsg.CardLbsOrBluetooth", "reportgps");
                        x.d("MicroMsg.CardLbsOrBluetooth", "reportgps lbsLongitude:%f, lbsLatitude:%f", new Object[]{Float.valueOf(this.cXn), Float.valueOf(this.cXm)});
                        a(this.htC, new byte[0], this.cXn, this.cXm, 0, false, this.hug);
                        this.hun = System.currentTimeMillis();
                    } else {
                        x.e("MicroMsg.CardLbsOrBluetooth", "not report");
                        this.hud = false;
                    }
                }
            }
            z = false;
            awP = awP();
            x.i("MicroMsg.CardLbsOrBluetooth", "report needLocation:%b, isLocationAuth:%b, isBluetoothEnable:%b, needReportBluetooth:%b needReportGps:%b", new Object[]{Boolean.valueOf(this.huf), Boolean.valueOf(this.hug), Boolean.valueOf(this.huk.hus), Boolean.valueOf(z), Boolean.valueOf(awP)});
            if (!z) {
            }
            if (z) {
                awR = this.huk.awR();
                x.i("MicroMsg.CardLbsOrBluetooth", "reportBluetooth deviceInfo:%s", new Object[]{awR});
                a(this.htC, awR.huy, -1000.0f, -85.0f, awR.bMF, this.huk.hus, this.hug);
                this.hum = System.currentTimeMillis();
                this.huk.reset();
                this.huj = awR;
            } else if (awP) {
                x.i("MicroMsg.CardLbsOrBluetooth", "reportgps");
                x.d("MicroMsg.CardLbsOrBluetooth", "reportgps lbsLongitude:%f, lbsLatitude:%f", new Object[]{Float.valueOf(this.cXn), Float.valueOf(this.cXm)});
                a(this.htC, new byte[0], this.cXn, this.cXm, 0, false, this.hug);
                this.hun = System.currentTimeMillis();
            } else {
                x.e("MicroMsg.CardLbsOrBluetooth", "not report");
                this.hud = false;
            }
        }
    }

    private boolean awP() {
        boolean z = true;
        synchronized (this.hue) {
            boolean z2;
            if (System.currentTimeMillis() - this.hun >= this.huo) {
                z2 = true;
            } else {
                z2 = false;
            }
            boolean z3;
            if (Float.compare(this.cXm, -85.0f) == 0 || Float.compare(this.cXn, -1000.0f) == 0) {
                z3 = false;
            } else {
                z3 = true;
            }
            if (!(this.hug && this.huf && z3 && z2)) {
                z = false;
            }
        }
        return z;
    }

    static void a(String str, byte[] bArr, float f, float f2, int i, boolean z, boolean z2) {
        com.tencent.mm.kernel.g.Eh().dpP.a(new ai(str, bArr, f, f2, (float) i, z, z2), 0);
    }

    public final void a(int i, int i2, String str, l lVar) {
        x.i("MicroMsg.CardLbsOrBluetooth", "report success, onSceneEnd errType:%d, errCode:%d, errMsg:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        this.hud = false;
    }

    public final boolean awQ() {
        return this.huf || this.huh;
    }
}

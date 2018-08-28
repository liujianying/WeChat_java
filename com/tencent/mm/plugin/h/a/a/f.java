package com.tencent.mm.plugin.h.a.a;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothAdapter.LeScanCallback;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import com.tencent.mm.plugin.exdevice.j.b;
import com.tencent.mm.plugin.exdevice.service.r;
import com.tencent.mm.plugin.exdevice.service.v;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashSet;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@TargetApi(18)
public final class f implements LeScanCallback, r, b {
    private static boolean heV = false;
    public static boolean heX = false;
    private final b heQ;
    private final d heT;
    private final HashSet<UUID> heU;
    private boolean heW = false;
    private BluetoothAdapter heY;
    private boolean heZ = true;
    private int hfa = 0;
    private String hfb = "";
    private e hfc = null;
    private Map<String, Long> hfd = new ConcurrentHashMap();
    private final al hfe = new al(v.aHH().egm.lnJ.getLooper(), new 1(this), true);
    private final al hff = new al(v.aHH().egm.lnJ.getLooper(), new 2(this), true);
    private final al hfg = new al(v.aHH().egm.lnJ.getLooper(), new 3(this), true);
    private final al hfh = new al(v.aHH().egm.lnJ.getLooper(), new 4(this), true);
    private final al hfi = new al(v.aHH().egm.lnJ.getLooper(), new 5(this), true);
    public final ag mHandler;

    /* renamed from: com.tencent.mm.plugin.h.a.a.f$7 */
    class AnonymousClass7 implements Runnable {
        final /* synthetic */ UUID hfl;

        public AnonymousClass7(UUID uuid) {
            this.hfl = uuid;
        }

        public final void run() {
            if (!f.b(f.this, this.hfl)) {
                x.e("MicroMsg.exdevice.IBeaconServer", "stopRanging failed!!!");
            }
        }
    }

    static /* synthetic */ boolean b(f fVar, UUID uuid) {
        x.i("MicroMsg.exdevice.IBeaconServer", "stopRanging");
        if (uuid == null) {
            x.e("MicroMsg.exdevice.IBeaconServer", "error parameter: aUUID is null");
            return false;
        }
        fVar.heU.remove(uuid);
        fVar.atI();
        return true;
    }

    static /* synthetic */ Boolean g(f fVar) {
        return fVar.heY != null ? Boolean.valueOf(fVar.heY.startLeScan(fVar)) : Boolean.valueOf(false);
    }

    static /* synthetic */ void j(f fVar) {
        if (fVar.heY != null) {
            fVar.heY.stopLeScan(fVar);
        }
    }

    public f(b bVar) {
        if (bVar == null) {
            throw new NullPointerException("aCallback is null");
        }
        this.heU = new HashSet();
        this.heT = new d(this);
        this.heQ = bVar;
        this.mHandler = new ag(v.aHH().egm.lnJ.getLooper());
        this.heY = ((BluetoothManager) ad.getContext().getSystemService("bluetooth")).getAdapter();
    }

    private void atI() {
        this.hfd.clear();
        heV = false;
        if (!this.hfh.ciq()) {
            this.hfh.SO();
        }
        if (!this.hfg.ciq()) {
            this.hfg.SO();
        }
        if (!this.hff.ciq()) {
            this.hff.SO();
        }
        if (!this.hfe.ciq()) {
            this.hfe.SO();
        }
        if (!this.hfi.ciq()) {
            this.hfi.SO();
        }
        if (this.heW && this.heY != null) {
            this.heY.stopLeScan(this);
            this.heW = false;
        }
    }

    private synchronized void atJ() {
        if (this.hfh.ciq()) {
            this.hfh.J(2000, 2000);
        }
        if (heX && this.hfg.ciq()) {
            this.hfg.J(10000, 10000);
        }
        if (this.hfi.ciq()) {
            if (heX) {
                this.hfi.J(1800000, 1800000);
            } else {
                this.hfi.J(120000, 120000);
            }
        }
        if (!heV) {
            this.heZ = true;
            Boolean valueOf = Boolean.valueOf(this.heY.startLeScan(this));
            if (valueOf.booleanValue() || heV) {
                this.heW = true;
                heV = true;
                x.i("MicroMsg.exdevice.IBeaconServer", "[shakezb]start ibeacon range successful");
            } else {
                int i = 0;
                while (!valueOf.booleanValue() && i < 3 && !heV) {
                    i++;
                    this.heY.stopLeScan(this);
                    x.e("MicroMsg.exdevice.IBeaconServer", "start IBEACON BLE scan failed,retry no " + i + " time");
                    valueOf = Boolean.valueOf(this.heY.startLeScan(this));
                    if (valueOf.booleanValue()) {
                        heV = true;
                        this.heW = true;
                        x.i("MicroMsg.exdevice.IBeaconServer", "[shakezb]start ibeacon range successful");
                    }
                }
            }
        }
    }

    public final void a(double d, c cVar) {
        x.d("MicroMsg.exdevice.IBeaconServer", "[shakezb]onRangingCallback, distance = %f", new Object[]{Double.valueOf(d)});
        String aq = b.aq(cVar.heO.heS.hft);
        if (aq.length() >= 32) {
            aq = aq.substring(0, 8) + "-" + aq.substring(8, 12) + "-" + aq.substring(12, 16) + "-" + aq.substring(16, 20) + "-" + aq.substring(20);
        }
        String str = aq + cVar.heO.heS.hfu + cVar.heO.heS.hfv;
        if (this.hfd.containsKey(str)) {
            long longValue = ((Long) this.hfd.get(str)).longValue();
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - longValue > 500) {
                this.hfd.put(str, Long.valueOf(currentTimeMillis));
                this.heQ.a(d, cVar);
                return;
            }
            return;
        }
        this.hfd.put(str, Long.valueOf(System.currentTimeMillis()));
        this.heQ.a(d, cVar);
        x.i("MicroMsg.exdevice.IBeaconServer", "[shakezb]onRangingCallback,uuid = " + aq + ",major = " + cVar.heO.heS.hfu + ",minor = " + (cVar.heO.heS.hfv & 65535));
    }

    public final void na(int i) {
        if (i == 0) {
            atI();
        }
    }

    public final void a(String str, String str2, int i, int i2, byte[] bArr) {
        x.d("MicroMsg.exdevice.IBeaconServer", "onScanFound, device mac = %s, device name = %s, bluetooth version = %d, rssi = %d, advertisment = %s", new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), b.aq(bArr)});
        if (i == 0) {
            e eVar = new e();
            if (eVar.ab(bArr)) {
                UUID as = b.as(eVar.heS.hft);
                if (as == null) {
                    x.e("MicroMsg.exdevice.IBeaconServer", "parse UUID from byte array failed!!!");
                    return;
                } else if (this.heU.contains(as)) {
                    if (this.heZ) {
                        this.hfb = str;
                    }
                    this.mHandler.post(new 8(this, i2, str, eVar));
                    return;
                } else {
                    x.d("MicroMsg.exdevice.IBeaconServer", "this IBeacon UUID is not in the set");
                    return;
                }
            }
            x.d("MicroMsg.exdevice.IBeaconServer", "protocal.ParseFromByte Failed!!!");
        }
    }

    public final void wT(String str) {
        x.e("MicroMsg.exdevice.IBeaconServer", "------onScanError------ error code = %s, error msg = %s", new Object[]{Integer.valueOf(-1), str});
    }

    public final void onLeScan(BluetoothDevice bluetoothDevice, int i, byte[] bArr) {
        e eVar = new e();
        if (eVar.ab(bArr)) {
            UUID as = b.as(eVar.heS.hft);
            if (as == null) {
                x.e("MicroMsg.exdevice.IBeaconServer", "parse UUID from byte array failed!!!");
                return;
            } else if (this.heU.contains(as)) {
                if (this.heZ) {
                    this.hfa = i;
                    this.hfc = eVar;
                    if (this.hfe.ciq()) {
                        this.hfe.J(2000, 2000);
                    }
                    this.heZ = false;
                }
                this.mHandler.post(new 9(this, i, bluetoothDevice, eVar));
                return;
            } else {
                x.d("MicroMsg.exdevice.IBeaconServer", "this IBeacon UUID is not in the set");
                return;
            }
        }
        x.d("MicroMsg.exdevice.IBeaconServer", "protocal.ParseFromByte Failed!!!");
    }
}

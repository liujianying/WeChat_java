package c.t.m.g;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.bluetooth.le.BluetoothLeScanner;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanResult;
import android.content.Context;
import android.os.HandlerThread;
import android.os.Message;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@SuppressLint({"NewApi"})
public final class da extends ScanCallback {
    BluetoothManager a;
    BluetoothAdapter b;
    BluetoothLeScanner c;
    boolean d;
    a e;
    HandlerThread f;
    byte[] g = new byte[0];
    private final Context h;
    private List<do> i;
    private long j;

    public da(Context context) {
        this.h = context;
        this.i = new LinkedList();
        this.a = (BluetoothManager) this.h.getSystemService("bluetooth");
    }

    public final List<do> a() {
        synchronized (this.i) {
            if (System.currentTimeMillis() - this.j <= 5000) {
                List<do> list = this.i;
                return list;
            }
            return null;
        }
    }

    public final void onScanResult(int i, ScanResult scanResult) {
        Message message = new Message();
        message.what = 3000;
        message.obj = scanResult;
        synchronized (this.g) {
            if (!(this.e == null || this.e.getLooper() == null || !this.e.getLooper().getThread().isAlive())) {
                this.e.sendMessage(message);
            }
        }
    }

    public final void onBatchScanResults(List<ScanResult> list) {
    }

    public final void onScanFailed(int i) {
    }

    private int b() {
        try {
            if (!this.h.getPackageManager().hasSystemFeature("android.hardware.bluetooth_le")) {
                return -1;
            }
            if (this.b == null || !this.b.isEnabled() || this.c == null) {
                return -2;
            }
            this.c.startScan(this);
            this.d = true;
            return 0;
        } catch (Throwable th) {
            return -3;
        }
    }

    static /* synthetic */ void b(da daVar) {
        try {
            synchronized (daVar.g) {
                if (daVar.h.getPackageManager().hasSystemFeature("android.hardware.bluetooth_le")) {
                    if (daVar.c != null) {
                        daVar.c.stopScan(daVar);
                    }
                    daVar.b = null;
                    daVar.d = false;
                    synchronized (daVar.i) {
                        daVar.i.clear();
                    }
                    daVar.j = 0;
                    return;
                }
            }
        } catch (Throwable th) {
        }
    }

    static /* synthetic */ void a(da daVar, ScanResult scanResult) {
        if (scanResult != null) {
            try {
                BluetoothDevice device = scanResult.getDevice();
                int rssi = scanResult.getRssi();
                byte[] bytes = scanResult.getScanRecord().getBytes();
                if (bytes != null && bytes.length >= 30) {
                    do a = do.a(device, rssi, bytes);
                    synchronized (daVar.i) {
                        if (a != null) {
                            daVar.i.add(a);
                            daVar.j = System.currentTimeMillis();
                        }
                        Iterator it = daVar.i.iterator();
                        while (it.hasNext()) {
                            if (System.currentTimeMillis() - ((do) it.next()).a > 5000) {
                                it.remove();
                            }
                        }
                    }
                }
            } catch (Throwable th) {
            }
        }
    }
}

package com.tencent.mm.plugin.h.a.b;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.hardware.input.InputManager;
import android.location.LocationManager;
import android.os.Build.VERSION;
import android.view.InputDevice;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.h.a.b.c.a;
import com.tencent.mm.plugin.h.a.b.g.1;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import junit.framework.Assert;

@TargetApi(18)
public final class b {
    public BluetoothAdapter heY;
    public a hfE;
    public final HashMap<String, d> hfF;
    volatile boolean hfG;
    public c hfH;
    public g hfI;
    final HashSet<Long> hfJ;
    private a hfK;
    private g.a hfL;
    public ag mHandler;
    public volatile boolean mIsInit;
    private Runnable mRunnable;
    public Context rc;

    static /* synthetic */ void a(b bVar, BluetoothDevice bluetoothDevice, int i, byte[] bArr) {
        x.d("MicroMsg.exdevice.BluetoothLEManager", "onLeScanImp");
        if (!bVar.hfJ.isEmpty()) {
            long Az = com.tencent.mm.plugin.exdevice.j.b.Az(bluetoothDevice.getAddress());
            if (bVar.hfJ.contains(Long.valueOf(Az))) {
                x.i("MicroMsg.exdevice.BluetoothLEManager", "------onConnectPreScanFound------ sessionid = %d", new Object[]{Long.valueOf(Az)});
                d dVar = (d) bVar.hfF.get(String.valueOf(Az));
                if (dVar == null) {
                    x.e("MicroMsg.exdevice.BluetoothLEManager", "null == les");
                    if (bVar.hfE != null) {
                        bVar.hfE.i(Az, false);
                    }
                } else if (!dVar.connect()) {
                    x.e("MicroMsg.exdevice.BluetoothLEManager", "les.connect() Failed!!!");
                    if (bVar.hfE != null) {
                        bVar.hfE.i(Az, false);
                    }
                }
                bVar.hfJ.remove(Long.valueOf(Az));
                if (bVar.hfJ.isEmpty()) {
                    x.i("MicroMsg.exdevice.BluetoothLEManager", "Connect PreScan is done.");
                }
            }
        }
        if (bVar.hfE != null) {
            bVar.hfE.a(bluetoothDevice.getAddress(), bluetoothDevice.getName(), i, bArr);
        }
    }

    public b(ah ahVar) {
        this.hfE = null;
        this.rc = null;
        this.hfF = new HashMap();
        this.heY = null;
        this.mHandler = null;
        this.mRunnable = null;
        this.hfG = false;
        this.mIsInit = false;
        this.hfJ = new HashSet();
        this.hfK = new 2(this);
        this.hfL = new 3(this);
        this.mRunnable = new 1(this);
        this.mHandler = new ag(ahVar.lnJ.getLooper());
    }

    final void atM() {
        x.i("MicroMsg.exdevice.BluetoothLEManager", "tryToCleanPreScanSet");
        if (!this.hfJ.isEmpty()) {
            Iterator it = this.hfJ.iterator();
            while (it.hasNext()) {
                x.e("MicroMsg.exdevice.BluetoothLEManager", "Cannot scan out Remote device(Mac = %d), Connect Failed!!!", new Object[]{(Long) it.next()});
                if (this.hfE != null) {
                    this.hfE.i(r0.longValue(), false);
                }
            }
            this.hfJ.clear();
        }
    }

    @TargetApi(18)
    public final boolean atN() {
        Assert.assertTrue(this.mIsInit);
        return this.rc.getPackageManager().hasSystemFeature("android.hardware.bluetooth_le");
    }

    private void atI() {
        if (this.hfG) {
            this.mHandler.removeCallbacks(this.mRunnable);
            this.hfG = false;
            dI(false);
            atM();
            if (this.hfE != null) {
                this.hfE.atO();
            }
        }
    }

    public final boolean a(boolean z, int... iArr) {
        x.i("MicroMsg.exdevice.BluetoothLEManager", "------scanLEDevice------" + (z ? "true" : "false"));
        Assert.assertTrue(this.mIsInit);
        if (!atN()) {
            x.e("MicroMsg.exdevice.BluetoothLEManager", "BLE Unsupport");
            return false;
        } else if (!z) {
            atI();
            return true;
        } else if (this.hfG) {
            return true;
        } else {
            if (dI(z)) {
                if (iArr == null || iArr.length <= 0 || iArr[0] != 1) {
                    this.mHandler.postDelayed(this.mRunnable, 10000);
                } else {
                    this.mHandler.removeCallbacks(this.mRunnable);
                }
                this.hfG = true;
                return true;
            }
            x.e("MicroMsg.exdevice.BluetoothLEManager", "mAdapter.startLeScan Failed!!!");
            if (!this.hfJ.isEmpty()) {
                Iterator it = this.hfJ.iterator();
                while (it.hasNext()) {
                    x.e("MicroMsg.exdevice.BluetoothLEManager", "Cannot scan out Remote device(Mac = %d), Connect Failed!!!", new Object[]{(Long) it.next()});
                    if (this.hfE != null) {
                        this.hfE.i(r0.longValue(), false);
                    }
                }
                this.hfJ.clear();
            }
            return false;
        }
    }

    final boolean dI(boolean z) {
        boolean z2 = false;
        if (d.fR(21) && this.hfI != null) {
            g gVar = this.hfI;
            g.a aVar = this.hfL;
            x.i("MicroMsg.exdevice.NewBluetoothLEScanner", "(API21)execute scan");
            Boolean bool = (Boolean) new 1(gVar, z, aVar).a(gVar.mHandler);
            if (bool != null) {
                z2 = true;
            }
            Assert.assertTrue(z2);
            return bool.booleanValue();
        } else if (this.hfH != null) {
            return this.hfH.a(z, this.hfK);
        } else {
            x.e("MicroMsg.exdevice.BluetoothLEManager", "Scanner is null");
            return false;
        }
    }

    public final boolean connect(long j) {
        x.i("MicroMsg.exdevice.BluetoothLEManager", "------connect------ sessionId = %d ", new Object[]{Long.valueOf(j)});
        Assert.assertTrue(this.mIsInit);
        if (atN()) {
            d dVar = (d) this.hfF.get(String.valueOf(j));
            Assert.assertTrue(dVar != null);
            BluetoothManager bluetoothManager = (BluetoothManager) this.rc.getSystemService("bluetooth");
            if (bluetoothManager == null) {
                x.e("MicroMsg.exdevice.BluetoothLEManager", "null == bluetoothManager");
            } else {
                List<BluetoothDevice> connectedDevices = bluetoothManager.getConnectedDevices(8);
                if (connectedDevices == null) {
                    x.i("MicroMsg.exdevice.BluetoothLEManager", "null == list, may be no device is connected phone now");
                } else {
                    for (BluetoothDevice address : connectedDevices) {
                        x.i("MicroMsg.exdevice.BluetoothLEManager", "get connected device: mac = %s, long of mac =%d, name = %s", new Object[]{address.getAddress(), Long.valueOf(com.tencent.mm.plugin.exdevice.j.b.Az(((BluetoothDevice) r3.next()).getAddress())), ((BluetoothDevice) r3.next()).getName()});
                        if (j == com.tencent.mm.plugin.exdevice.j.b.Az(((BluetoothDevice) r3.next()).getAddress())) {
                            x.i("MicroMsg.exdevice.BluetoothLEManager", "This device is connected to phone now, start connecting without scan...");
                            return dVar.connect();
                        }
                    }
                    x.i("MicroMsg.exdevice.BluetoothLEManager", "Android version realse code: %s", new Object[]{VERSION.RELEASE});
                    if (d.fR(23) && !((LocationManager) this.rc.getSystemService("location")).isProviderEnabled(TencentLocation.GPS_PROVIDER) && !VERSION.RELEASE.equalsIgnoreCase("6.0") && !VERSION.RELEASE.equalsIgnoreCase("6.0.0")) {
                        return dVar.connect();
                    }
                    Set<BluetoothDevice> bondedDevices = bluetoothManager.getAdapter().getBondedDevices();
                    if (bondedDevices == null) {
                        x.i("MicroMsg.exdevice.BluetoothLEManager", "null == pairedDevices,get paired devices failed");
                    } else {
                        for (BluetoothDevice bluetoothDevice : bondedDevices) {
                            x.i("MicroMsg.exdevice.BluetoothLEManager", "get paired device: mac = %s, long of mac =%d, name = %s", new Object[]{bluetoothDevice.getAddress(), Long.valueOf(com.tencent.mm.plugin.exdevice.j.b.Az(bluetoothDevice.getAddress())), bluetoothDevice.getName()});
                            if (j == com.tencent.mm.plugin.exdevice.j.b.Az(bluetoothDevice.getAddress())) {
                                x.i("MicroMsg.exdevice.BluetoothLEManager", "This HID device is paired to phone now, check if it is connected...");
                                InputManager inputManager = (InputManager) this.rc.getSystemService("input");
                                int[] inputDeviceIds = inputManager.getInputDeviceIds();
                                if (inputDeviceIds == null) {
                                    x.i("MicroMsg.exdevice.BluetoothLEManager", "get input devices failed");
                                    break;
                                }
                                for (int inputDevice : inputDeviceIds) {
                                    InputDevice inputDevice2 = inputManager.getInputDevice(inputDevice);
                                    if (inputDevice2 != null) {
                                        String name = inputDevice2.getName();
                                        x.d("MicroMsg.exdevice.BluetoothLEManager", "Input devices: %s", new Object[]{name});
                                        if (name != null && name.equals(bluetoothDevice.getName())) {
                                            x.i("MicroMsg.exdevice.BluetoothLEManager", "This HID deivce has connected to phone as a input device");
                                            return dVar.connect();
                                        }
                                    }
                                }
                                x.i("MicroMsg.exdevice.BluetoothLEManager", "This HID device hasn't been connected...");
                            }
                        }
                    }
                }
            }
            this.hfJ.add(Long.valueOf(j));
            return a(true, new int[0]);
        }
        x.e("MicroMsg.exdevice.BluetoothLEManager", "BLE Unsupport");
        return false;
    }
}

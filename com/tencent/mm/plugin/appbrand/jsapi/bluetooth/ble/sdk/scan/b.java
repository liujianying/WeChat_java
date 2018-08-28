package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.scan;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothAdapter.LeScanCallback;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.le.BluetoothLeScanner;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanFilter.Builder;
import android.bluetooth.le.ScanSettings;
import android.os.Build.VERSION;
import android.os.ParcelUuid;
import android.support.v4.e.j;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.a;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import org.xwalk.core.Log;

@TargetApi(18)
public final class b {
    static final e fMW;

    static class b implements LeScanCallback {
        private final List<ScanFilterCompat> fMY;
        private final WeakReference<e> fMZ;

        b(List<ScanFilterCompat> list, e eVar) {
            this.fMY = list;
            this.fMZ = new WeakReference(eVar);
        }

        public final void onLeScan(BluetoothDevice bluetoothDevice, int i, byte[] bArr) {
            e eVar = (e) this.fMZ.get();
            if (eVar != null) {
                ScanResultCompat scanResultCompat = new ScanResultCompat(bluetoothDevice, f.V(bArr), i, System.currentTimeMillis());
                if (this.fMY == null) {
                    eVar.a(1, scanResultCompat);
                    return;
                }
                for (ScanFilterCompat scanFilterCompat : this.fMY) {
                    Object obj;
                    BluetoothDevice device = scanResultCompat.getDevice();
                    if (scanFilterCompat.fNw == null || (device != null && scanFilterCompat.fNw.equals(device.getAddress()))) {
                        f fVar = scanResultCompat.fNO;
                        if (fVar == null && (scanFilterCompat.fNv != null || scanFilterCompat.fNx != null || scanFilterCompat.fND != null || scanFilterCompat.fNA != null || scanFilterCompat.fNz != null || scanFilterCompat.fNC >= 0)) {
                            obj = null;
                            continue;
                        } else if (scanFilterCompat.fNv == null || scanFilterCompat.fNv.equals(fVar.fNv)) {
                            ParcelUuid parcelUuid;
                            if (scanFilterCompat.fNx != null) {
                                ParcelUuid parcelUuid2 = scanFilterCompat.fNx;
                                ParcelUuid parcelUuid3 = scanFilterCompat.fNy;
                                List<ParcelUuid> list = fVar.fNI;
                                if (parcelUuid2 == null) {
                                    obj = 1;
                                } else {
                                    if (list != null) {
                                        for (ParcelUuid parcelUuid4 : list) {
                                            if (ScanFilterCompat.a(parcelUuid2.getUuid(), parcelUuid3 == null ? null : parcelUuid3.getUuid(), parcelUuid4.getUuid())) {
                                                obj = 1;
                                                break;
                                            }
                                        }
                                    }
                                    obj = null;
                                }
                                if (obj == null) {
                                    obj = null;
                                    continue;
                                }
                            }
                            if (scanFilterCompat.fNz != null) {
                                byte[] bArr2 = scanFilterCompat.fNA;
                                byte[] bArr3 = scanFilterCompat.fNB;
                                parcelUuid4 = scanFilterCompat.fNz;
                                if (!ScanFilterCompat.a(bArr2, bArr3, parcelUuid4 == null ? null : (byte[]) fVar.fNK.get(parcelUuid4))) {
                                    obj = null;
                                    continue;
                                }
                            }
                            if (scanFilterCompat.fNC >= 0 && fVar != null) {
                                if (!ScanFilterCompat.a(scanFilterCompat.fND, scanFilterCompat.fNE, (byte[]) fVar.fNJ.get(scanFilterCompat.fNC))) {
                                    obj = null;
                                    continue;
                                }
                            }
                            obj = 1;
                            continue;
                        } else {
                            obj = null;
                            continue;
                        }
                    } else {
                        obj = null;
                        continue;
                    }
                    if (obj != null) {
                        eVar.a(1, scanResultCompat);
                        return;
                    }
                }
            }
        }
    }

    @SuppressLint({"MissingPermission"})
    @TargetApi(21)
    static class c implements e {
        static final j<e, d> fMX = new j();

        c() {
        }

        public final boolean a(BluetoothAdapter bluetoothAdapter, List<ScanFilterCompat> list, ScanSettingsCompat scanSettingsCompat, e eVar) {
            List arrayList;
            if (list != null) {
                arrayList = new ArrayList(list.size());
                for (ScanFilterCompat scanFilterCompat : list) {
                    Builder builder = new Builder();
                    if (scanFilterCompat.fNv != null) {
                        builder.setDeviceName(scanFilterCompat.fNv);
                    }
                    if (scanFilterCompat.fNx != null) {
                        builder.setServiceUuid(scanFilterCompat.fNx, scanFilterCompat.fNy);
                    }
                    if (scanFilterCompat.fNw != null) {
                        builder.setDeviceAddress(scanFilterCompat.fNw);
                    }
                    if (scanFilterCompat.fNz != null) {
                        builder.setServiceData(scanFilterCompat.fNz, scanFilterCompat.fNA, scanFilterCompat.fNB);
                    }
                    if (scanFilterCompat.fNC < 0) {
                        builder.setManufacturerData(scanFilterCompat.fNC, scanFilterCompat.fND, scanFilterCompat.fNE);
                    }
                    arrayList.add(builder.build());
                }
            } else {
                arrayList = null;
            }
            if (scanSettingsCompat == null) {
                throw new IllegalStateException("Scan settings are null");
            }
            ScanSettings build = new ScanSettings.Builder().setReportDelay(scanSettingsCompat.fNT).setScanMode(scanSettingsCompat.fNR).build();
            BluetoothLeScanner bluetoothLeScanner = bluetoothAdapter.getBluetoothLeScanner();
            ScanCallback scanCallback = (d) fMX.get(eVar);
            if (scanCallback == null) {
                scanCallback = new d(eVar);
                fMX.put(eVar, scanCallback);
            }
            bluetoothLeScanner.startScan(arrayList, build, scanCallback);
            return true;
        }

        public final boolean a(BluetoothAdapter bluetoothAdapter, e eVar) {
            d dVar = (d) fMX.remove(eVar);
            if (dVar == null) {
                return false;
            }
            bluetoothAdapter.getBluetoothLeScanner().stopScan(dVar);
            return true;
        }
    }

    public static boolean a(BluetoothAdapter bluetoothAdapter, List<ScanFilterCompat> list, ScanSettingsCompat scanSettingsCompat, e eVar) {
        return fMW.a(bluetoothAdapter, list, scanSettingsCompat, eVar);
    }

    public static boolean a(BluetoothAdapter bluetoothAdapter, e eVar) {
        return fMW.a(bluetoothAdapter, eVar);
    }

    static {
        int i = VERSION.SDK_INT;
        if (!a.fLG) {
            Log.i("MicroMsg.ble.BleScannerCompat", "use 18");
            fMW = new a();
        } else if (i >= 21) {
            Log.i("MicroMsg.ble.BleScannerCompat", "use 21");
            fMW = new c();
        } else {
            Log.i("MicroMsg.ble.BleScannerCompat", "use 18");
            fMW = new a();
        }
    }
}

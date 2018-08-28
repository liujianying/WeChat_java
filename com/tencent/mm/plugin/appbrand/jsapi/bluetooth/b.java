package com.tencent.mm.plugin.appbrand.jsapi.bluetooth;

import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.a.c;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.a.c.1;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.a.c.2;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.c.a;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.c.d;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.c.e;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public final class b extends com.tencent.mm.plugin.appbrand.e.b {
    private String appId;
    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.b fLc;
    a fLd;

    public b(String str) {
        this.appId = str;
    }

    public final List<d> air() {
        if (this.fLc == null) {
            return null;
        }
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.b bVar = this.fLc;
        if (bVar.fLH == null) {
            return null;
        }
        c cVar = bVar.fLH;
        List<d> arrayList = new ArrayList();
        for (com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.a.d dVar : cVar.fLQ.values()) {
            if (dVar.fLV != null) {
                arrayList.add(new d(bi.oV(dVar.fLV.getDevice().getName()), dVar.byN));
            }
        }
        return arrayList;
    }

    public final void a(String str, a aVar, com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.c.b bVar) {
        if (this.fLc != null) {
            com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.b bVar2 = this.fLc;
            if (bVar2.fLH != null) {
                c cVar = bVar2.fLH;
                com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.a.d dVar = (com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.a.d) cVar.fLQ.get(str);
                if (dVar == null) {
                    dVar = new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.a.d(cVar.context, str);
                    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.d.a.i("MicroMsg.Ble.BleConnectWorker", "init deviceId:%s", new Object[]{dVar.byN});
                    if (dVar.fLU == null) {
                        dVar.fLU = new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.a.b();
                        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.a.b bVar3 = dVar.fLU;
                        bVar3.fLK = new ConcurrentLinkedQueue();
                        bVar3.fLM = new ArrayList();
                    }
                    dVar.fLU = dVar.fLU;
                    dVar.fLX = new ConcurrentHashMap();
                    dVar.fLS = new 1(cVar);
                    dVar.fLR = new 2(cVar);
                    cVar.fLQ.put(str, dVar);
                }
                com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.d.a.i("MicroMsg.Ble.BleConnectWorker", "deviceId:%s aciton:%s", new Object[]{dVar.byN, aVar});
                aVar.fMb = dVar;
                aVar.a(dVar.fLU);
                aVar.fMd = bVar;
                com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.a.b bVar4 = dVar.fLU;
                com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.d.a.i("MicroMsg.Ble.BleConnectDispatcher", "doAction %s", new Object[]{aVar});
                if (aVar.fLA) {
                    bVar4.fLK.add(aVar);
                    bVar4.ait();
                } else if (aVar.fLy) {
                    bVar4.fLN.postDelayed(new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.a.b.1(bVar4, aVar), aVar.fMg);
                } else {
                    aVar.aiv();
                }
            }
        }
    }

    public final List<e> tt(String str) {
        if (this.fLc == null) {
            return null;
        }
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.b bVar = this.fLc;
        if (bVar.fLH != null) {
            c cVar = bVar.fLH;
            if (cVar.fLQ.get(str) != null) {
                com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.a.d dVar = (com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.a.d) cVar.fLQ.get(str);
                if (dVar.fLV == null) {
                    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.d.a.e("MicroMsg.Ble.BleConnectWorker", "[getServices] bluetoothGatt is null, err", new Object[0]);
                } else if (bi.oW(dVar.byN)) {
                    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.d.a.e("MicroMsg.Ble.BleConnectWorker", "[getServices] deviceId is null, err", new Object[0]);
                } else {
                    if (dVar.fLW == null) {
                        List<BluetoothGattService> services = dVar.fLV.getServices();
                        if (services == null) {
                            com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.d.a.w("MicroMsg.Ble.BleConnectWorker", "[getServices] bluetoothGattServices is null, err", new Object[0]);
                        } else {
                            dVar.fLW = new ArrayList();
                            Collection arrayList = new ArrayList();
                            for (BluetoothGattService bluetoothGattService : services) {
                                e eVar = new e();
                                eVar.fMk = bluetoothGattService.getUuid().toString().toUpperCase();
                                eVar.fMu = bluetoothGattService.getType() == 0;
                                if (eVar.fMk.equals("00001800-0000-1000-8000-00805F9B34FB") || eVar.fMk.equals("00001801-0000-1000-8000-00805F9B34FB")) {
                                    arrayList.add(eVar);
                                } else {
                                    dVar.fLW.add(eVar);
                                }
                            }
                            if (arrayList.size() > 0) {
                                dVar.fLW.addAll(arrayList);
                            }
                        }
                    }
                    return dVar.fLW;
                }
            }
        }
        return null;
    }

    public final List<com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.c.c> bn(String str, String str2) {
        if (this.fLc == null) {
            return null;
        }
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.b bVar = this.fLc;
        if (bVar.fLH != null) {
            c cVar = bVar.fLH;
            if (cVar.fLQ.get(str) != null) {
                com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.a.d dVar = (com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.a.d) cVar.fLQ.get(str);
                if (dVar.fLV == null) {
                    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.d.a.e("MicroMsg.Ble.BleConnectWorker", "[getCharacteristics] bluetoothGatt is null, err", new Object[0]);
                } else if (bi.oW(str2)) {
                    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.d.a.e("MicroMsg.Ble.BleConnectWorker", "[getCharacteristics] serviceId is null, err", new Object[0]);
                } else if (com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.d.b.tv(str2)) {
                    List<com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.c.c> list = (List) dVar.fLX.get(str2);
                    if (list != null) {
                        return list;
                    }
                    BluetoothGattService service = dVar.fLV.getService(UUID.fromString(str2));
                    if (service == null) {
                        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.d.a.w("MicroMsg.Ble.BleConnectWorker", "[getCharacteristics] bluetoothGattServices is null, err", new Object[0]);
                    } else {
                        List<BluetoothGattCharacteristic> characteristics = service.getCharacteristics();
                        if (characteristics == null) {
                            com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.d.a.w("MicroMsg.Ble.BleConnectWorker", "[getCharacteristics] characteristics is null, err", new Object[0]);
                        } else {
                            List<com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.c.c> arrayList = new ArrayList();
                            for (BluetoothGattCharacteristic bluetoothGattCharacteristic : characteristics) {
                                com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.c.c cVar2 = new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.c.c();
                                cVar2.fMk = bluetoothGattCharacteristic.getUuid().toString().toUpperCase();
                                int properties = bluetoothGattCharacteristic.getProperties();
                                cVar2.fMl = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.d.b.kE(properties);
                                cVar2.fMm = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.d.b.kF(properties);
                                cVar2.fMn = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.d.b.kG(properties);
                                cVar2.dBn = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.d.b.kH(properties);
                                cVar2.fMo = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.d.b.kI(properties);
                                arrayList.add(cVar2);
                            }
                            dVar.fLX.put(str2, arrayList);
                            return arrayList;
                        }
                    }
                } else {
                    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.d.a.e("MicroMsg.Ble.BleConnectWorker", "[getCharacteristics] serviceId is illegal, err", new Object[0]);
                }
            }
        }
        return null;
    }

    public final void onDestroy() {
        a.ts(this.appId);
    }

    public final synchronized void uninit() {
        if (this.fLc != null) {
            com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.b bVar = this.fLc;
            if (bVar.fLH != null) {
                c cVar = bVar.fLH;
                com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.d.a.i("MicroMsg.Ble.BleConnectMgr", "uninit", new Object[0]);
                if (cVar.fLQ != null) {
                    for (com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.a.d dVar : cVar.fLQ.values()) {
                        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.d.a.i("MicroMsg.Ble.BleConnectWorker", "uninit deviceId:%s", new Object[]{dVar.byN});
                        dVar.cM(true);
                        if (dVar.fLU != null) {
                            com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.a.b bVar2 = dVar.fLU;
                            if (bVar2.fLK != null) {
                                bVar2.fLK.clear();
                                bVar2.fLK = null;
                            }
                            if (bVar2.fLM != null) {
                                bVar2.fLM.clear();
                                bVar2.fLM = null;
                            }
                            dVar.fLU = null;
                        }
                        if (dVar.fLW != null) {
                            dVar.fLW.clear();
                            dVar.fLW = null;
                        }
                        if (dVar.fLX != null) {
                            dVar.fLX.clear();
                            dVar.fLX = null;
                        }
                    }
                    cVar.fLQ.clear();
                    cVar.fLQ = null;
                }
            }
            if (bVar.fLI != null) {
                com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.scan.a aVar = bVar.fLI;
                com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.d.a.i("MicroMsg.Ble.BleScanWorker", "uninit", new Object[0]);
                aVar.fMR.set(false);
                aVar.aiw();
                if (aVar.fMP != null) {
                    aVar.fMP.clear();
                }
                if (aVar.fMS != null) {
                    aVar.fMS.clear();
                }
                if (com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.d.b.aiA() != null && com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.d.b.aiA().isDiscovering()) {
                    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.d.b.aiA().cancelDiscovery();
                }
                if (!(aVar.fKZ == null || aVar.context == null)) {
                    x.i("MicroMsg.Ble.BleScanWorker", "bluetoothStateListener uninit");
                    aVar.context.unregisterReceiver(aVar.fKZ);
                    aVar.fKZ = null;
                }
                aVar.fMN = null;
                aVar.context = null;
            }
            this.fLc = null;
        }
    }
}

package com.tencent.mm.plugin.h.a.b;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.os.HandlerThread;
import com.tencent.mm.plugin.exdevice.j.b;
import com.tencent.mm.plugin.h.a.b.a.c;
import com.tencent.mm.plugin.h.a.e.a;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

@TargetApi(18)
public final class f {
    static int hgF = 0;
    private int aeo;
    public BluetoothDevice fNN;
    private BluetoothAdapter heY;
    private Context hfX;
    private BluetoothGatt hfY;
    private f hgA;
    private HashMap<String, HashMap<String, BluetoothGattCharacteristic>> hgB;
    private long hgC;
    private ArrayList<BluetoothGattCharacteristic> hgD;
    private boolean hgE;
    private a hgc;
    private Runnable hgd;
    private Runnable hgf;
    private final LinkedList<byte[]> hgh;
    private volatile boolean hgi;
    private volatile int hgj;
    private final BluetoothGattCallback hgk;
    private a hgy;
    private Runnable hgz;
    public ag mHandler;
    public long mSessionId;
    private HandlerThread mThread;

    static /* synthetic */ void a(f fVar) {
        x.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------connectImp------, mac=%s, name=%s", new Object[]{b.cY(fVar.mSessionId), fVar.fNN.getName()});
        if (1 == fVar.hgj) {
            x.w("MicroMsg.exdevice.BluetoothLESimpleSession", "Remote device is connected !!!");
            if (fVar.hgy != null) {
                x.i("MicroMsg.exdevice.BluetoothLESimpleSession", "Remote device has connected, just callback.");
                fVar.hgy.a(fVar.mSessionId, true, fVar.hgC);
            }
        } else if (fVar.hgj == 0) {
            x.w("MicroMsg.exdevice.BluetoothLESimpleSession", "Remote device is connecting !!!");
        } else {
            fVar.atQ();
            if (fVar.hfY == null) {
                fVar.hfY = fVar.fNN.connectGatt(fVar.hfX, false, fVar.hgk);
                hgF++;
                x.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------create resource------, objid=%d, resourceCount=%d, mac=%s, name=%s", new Object[]{Integer.valueOf(fVar.hashCode()), Integer.valueOf(hgF), b.cY(fVar.mSessionId), fVar.fNN.getName()});
                if (fVar.hfY == null) {
                    x.e("MicroMsg.exdevice.BluetoothLESimpleSession", "mDevice.connectGatt Failed!!!");
                    fVar.atT();
                    return;
                }
                fVar.hgj = 0;
                fVar.mHandler.postDelayed(fVar.hgf, 10000);
            } else if (fVar.hfY.connect()) {
                fVar.hgj = 0;
                fVar.mHandler.postDelayed(fVar.hgf, 10000);
            } else {
                x.e("MicroMsg.exdevice.BluetoothLESimpleSession", "mBluetoothGatt.connect() Failed!!!");
                fVar.atT();
            }
        }
    }

    static /* synthetic */ boolean a(f fVar, BluetoothGatt bluetoothGatt, int i) {
        x.i("MicroMsg.exdevice.BluetoothLESimpleSession", "onServicesDiscoveredImp, status = %d, mac=%s, name=%s", new Object[]{Integer.valueOf(i), b.cY(fVar.mSessionId), fVar.fNN.getName()});
        fVar.mHandler.removeCallbacks(fVar.hgf);
        if (3 == fVar.hgj) {
            x.w("MicroMsg.exdevice.BluetoothLESimpleSession", "Close or disconnect is Called, Just Leave");
            return false;
        }
        if (1 == fVar.hgj) {
            x.w("MicroMsg.exdevice.BluetoothLESimpleSession", "Connected is done, Just Leave");
        } else if (i != 0) {
            x.e("MicroMsg.exdevice.BluetoothLESimpleSession", "Discover services error");
            fVar.atS();
            return false;
        } else {
            List services = bluetoothGatt.getServices();
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= services.size()) {
                    break;
                }
                Object obj;
                BluetoothGattService bluetoothGattService = (BluetoothGattService) services.get(i3);
                if (bluetoothGattService == null) {
                    x.e("MicroMsg.exdevice.BluetoothLESimpleSession", "service is null");
                    obj = null;
                } else if (c.b(bluetoothGattService)) {
                    fVar.hgC |= c.a(bluetoothGattService);
                    HashMap hashMap = new HashMap();
                    List characteristics = bluetoothGattService.getCharacteristics();
                    int i4 = 0;
                    while (true) {
                        int i5 = i4;
                        if (i5 >= characteristics.size()) {
                            break;
                        }
                        BluetoothGattCharacteristic bluetoothGattCharacteristic = (BluetoothGattCharacteristic) characteristics.get(i5);
                        Object uuid = bluetoothGattCharacteristic.getUuid().toString();
                        int properties = bluetoothGattCharacteristic.getProperties();
                        int permissions = bluetoothGattCharacteristic.getPermissions();
                        x.d("MicroMsg.exdevice.BluetoothLESimpleSession", "found characteristic = %s, properties = %d, permission = %d", new Object[]{uuid, Integer.valueOf(properties), Integer.valueOf(permissions)});
                        if (uuid == null) {
                            uuid = "null";
                        }
                        hashMap.put(uuid, bluetoothGattCharacteristic);
                        fVar.hgD.add(bluetoothGattCharacteristic);
                        i4 = i5 + 1;
                    }
                    fVar.hgB.put(bluetoothGattService.getUuid().toString(), hashMap);
                    obj = 1;
                } else {
                    x.e("MicroMsg.exdevice.BluetoothLESimpleSession", "parse service error");
                    obj = null;
                }
                if (obj == null) {
                    x.e("MicroMsg.exdevice.BluetoothLESimpleSession", "parseService error. service uuid = %s", new Object[]{bluetoothGattService.getUuid().toString()});
                }
                i2 = i3 + 1;
            }
            if (0 == fVar.hgC) {
                x.e("MicroMsg.exdevice.BluetoothLESimpleSession", "the device hasn't pass test");
                fVar.atS();
                return false;
            } else if (!fVar.mHandler.sendMessage(fVar.mHandler.obtainMessage(9))) {
                x.e("MicroMsg.exdevice.BluetoothLESimpleSession", "SendMessage Failed!!! MessageWhat = %d", new Object[]{Integer.valueOf(9)});
            }
        }
        return true;
    }

    static /* synthetic */ void b(f fVar) {
        x.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------disconnectImp------, mac=%s, name=%s", new Object[]{b.cY(fVar.mSessionId), fVar.fNN.getName()});
        if (3 == fVar.hgj) {
            x.w("MicroMsg.exdevice.BluetoothLESimpleSession", "diconnect or close is called aready, just leave");
        } else if (2 == fVar.hgj) {
            x.i("MicroMsg.exdevice.BluetoothLESimpleSession", "already disconnected, just leave");
        } else {
            fVar.atQ();
            if (fVar.hfY == null) {
                x.e("MicroMsg.exdevice.BluetoothLESimpleSession", "disconnect:BluetoothGatt not found");
                return;
            }
            fVar.hgj = 3;
            fVar.mHandler.removeCallbacks(fVar.hgf);
            if (fVar.hfY != null) {
                fVar.hfY.disconnect();
            }
        }
    }

    static /* synthetic */ void b(f fVar, int i) {
        x.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------onDescriptorWriteImp------ status = %d, mac=%s, name=%s", new Object[]{Integer.valueOf(i), b.cY(fVar.mSessionId), fVar.fNN.getName()});
        if (!fVar.mHandler.sendMessage(fVar.mHandler.obtainMessage(9))) {
            x.e("MicroMsg.exdevice.BluetoothLESimpleSession", "SendMessage Failed!!! MessageWhat = %d", new Object[]{Integer.valueOf(9)});
        }
    }

    static /* synthetic */ void c(f fVar) {
        x.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------closeImp------, mac=%s, name=%s", new Object[]{b.cY(fVar.mSessionId), fVar.fNN.getName()});
        if (3 == fVar.hgj) {
            x.w("MicroMsg.exdevice.BluetoothLESimpleSession", "Close aready, Just leave");
            fVar.atT();
            return;
        }
        fVar.atQ();
        if (fVar.hfY == null) {
            x.w("MicroMsg.exdevice.BluetoothLESimpleSession", "close:BluetoothGatt not found");
            fVar.atT();
            return;
        }
        fVar.hgj = 3;
        fVar.mHandler.removeCallbacks(fVar.hgf);
        fVar.atT();
        if (fVar.hfY != null) {
            x.i("MicroMsg.exdevice.BluetoothLESimpleSession", "disconnect gatt, and wait gatt disconnected callback, mac=%s, name=%s", new Object[]{b.cY(fVar.mSessionId), fVar.fNN.getName()});
            fVar.hfY.disconnect();
            fVar.hgE = true;
            fVar.mHandler.postDelayed(fVar.hgz, 10000);
        }
    }

    static /* synthetic */ void c(f fVar, int i) {
        x.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------onDataWriteCallbackImp------ status = %d, mac=%s, name=%s", new Object[]{Integer.valueOf(i), b.cY(fVar.mSessionId), fVar.fNN.getName()});
        fVar.mHandler.removeCallbacks(fVar.hgd);
        if (i != 0) {
            x.e("MicroMsg.exdevice.BluetoothLESimpleSession", "write data error: " + i);
            if (fVar.hgy != null) {
                fVar.hgy.j(fVar.mSessionId, false);
            }
            fVar.atR();
            return;
        }
        byte[] atL = fVar.hgc.atL();
        x.d("MicroMsg.exdevice.BluetoothLESimpleSession", "Out data dump = %s", new Object[]{b.aq(atL)});
        if (atL == null) {
            x.i("MicroMsg.exdevice.BluetoothLESimpleSession", "write data complete");
            if (fVar.hgy != null) {
                fVar.hgy.j(fVar.mSessionId, true);
            }
            fVar.atR();
            return;
        }
        x.i("MicroMsg.exdevice.BluetoothLESimpleSession", "write next chunk...");
        fVar.hgc.hfD.setValue(atL);
        fVar.hfY.writeCharacteristic(fVar.hgc.hfD);
        fVar.mHandler.postDelayed(fVar.hgd, 5000);
    }

    static /* synthetic */ void d(f fVar) {
        while (fVar.hgD.size() > 0) {
            int i;
            BluetoothGattCharacteristic bluetoothGattCharacteristic = (BluetoothGattCharacteristic) fVar.hgD.remove(0);
            f fVar2 = fVar.hgA;
            int properties = bluetoothGattCharacteristic.getProperties();
            if ((properties & 48) == 0) {
                x.e("MicroMsg.exdevice.BluetoothLESimpleSession", "no indicate and notify");
                i = 0;
            } else if (fVar2.hfY.setCharacteristicNotification(bluetoothGattCharacteristic, true)) {
                BluetoothGattDescriptor descriptor = bluetoothGattCharacteristic.getDescriptor(UUID.fromString(h.hgM));
                if (descriptor == null) {
                    x.e("MicroMsg.exdevice.BluetoothLESimpleSession", "Can not get configure descriptor");
                    i = 0;
                } else {
                    x.i("MicroMsg.exdevice.BluetoothLESimpleSession", "Configure descriptor permissions: " + descriptor.getPermissions());
                    byte[] bArr = new byte[]{(byte) 0, (byte) 0};
                    if ((properties & 32) != 0) {
                        bArr[0] = (byte) (bArr[0] | BluetoothGattDescriptor.ENABLE_INDICATION_VALUE[0]);
                        bArr[1] = (byte) (bArr[1] | BluetoothGattDescriptor.ENABLE_INDICATION_VALUE[1]);
                    }
                    if ((properties & 16) != 0) {
                        bArr[0] = (byte) (bArr[0] | BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE[0]);
                        bArr[1] = (byte) (bArr[1] | BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE[1]);
                    }
                    if (!descriptor.setValue(bArr)) {
                        x.e("MicroMsg.exdevice.BluetoothLESimpleSession", "Can not set configure descriptor value");
                        i = 0;
                    } else if (fVar2.hfY.writeDescriptor(descriptor)) {
                        boolean i2 = true;
                    } else {
                        x.e("MicroMsg.exdevice.BluetoothLESimpleSession", "Can not write configure descriptor value");
                        i2 = 0;
                    }
                }
            } else {
                x.e("MicroMsg.exdevice.BluetoothLESimpleSession", "Unable to set indicator for read characteristic");
                i2 = 0;
            }
            if (i2 == 0) {
                x.e("MicroMsg.exdevice.BluetoothLESimpleSession", "mSelfSession.setCharacteristicNotification Failed!!!. uuid = %s, properties = %d", new Object[]{bluetoothGattCharacteristic.getUuid().toString(), Integer.valueOf(bluetoothGattCharacteristic.getProperties())});
            } else {
                return;
            }
        }
        x.d("MicroMsg.exdevice.BluetoothLESimpleSession", "onConnected = true");
        fVar.hgj = 1;
        fVar.mHandler.removeCallbacks(fVar.hgf);
        if (fVar.hgy != null) {
            fVar.hgy.a(fVar.mSessionId, true, fVar.hgC);
        }
    }

    final void atS() {
        x.i("MicroMsg.exdevice.BluetoothLESimpleSession", "markSessionDisconnected, mac=%s, name=%s", new Object[]{b.cY(this.mSessionId), this.fNN.getName()});
        this.hgj = 2;
        this.mHandler.removeCallbacks(this.hgf);
        this.mHandler.removeCallbacks(this.hgz);
        atT();
        releaseResources();
    }

    @TargetApi(18)
    public f(long j, Context context, a aVar) {
        this.hgh = new LinkedList();
        this.hgi = false;
        this.hgB = new HashMap();
        this.hgC = 0;
        this.hgD = new ArrayList();
        this.hgk = new 1(this);
        this.aeo = -1;
        this.aeo = hashCode();
        this.hgA = this;
        this.hgy = aVar;
        this.hfX = context;
        this.heY = ((BluetoothManager) this.hfX.getSystemService("bluetooth")).getAdapter();
        this.mSessionId = j;
        this.hgj = 3;
        this.fNN = this.heY.getRemoteDevice(a.bZ(j));
        this.hgc = new a();
        this.hgE = false;
        this.mThread = e.Xs("BluetoothLESimpleSession_handlerThread");
        this.mThread.start();
        this.mHandler = new b(this.mThread.getLooper(), this);
        this.hgd = new 2(this);
        this.hgf = new 3(this);
        this.hgz = new 4(this);
    }

    private void releaseResources() {
        if (this.hfY == null) {
            x.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------releaseResources------ nothing to release, objid=%d, mac=%s, name=%s", new Object[]{Integer.valueOf(hashCode()), b.cY(this.mSessionId), this.fNN.getName()});
            return;
        }
        hgF--;
        x.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------releaseResources------, objid=%d, resourceCount=%d, mac=%s, name=%s", new Object[]{Integer.valueOf(hashCode()), Integer.valueOf(hgF), b.cY(this.mSessionId), this.fNN.getName()});
        this.hgE = false;
        this.hfY.close();
        this.mThread.quitSafely();
        this.hfY = null;
        this.mThread = null;
    }

    public final boolean connect() {
        x.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------connect------, mac=%s, name=%s", new Object[]{b.cY(this.mSessionId), this.fNN.getName()});
        return this.mHandler.sendMessage(this.mHandler.obtainMessage(0));
    }

    private void atQ() {
        this.hgi = false;
        this.hgh.clear();
    }

    private void atT() {
        if (this.hgy == null) {
            x.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------notifySessionClose------ don't need to notify, mac=%s, name=%s", new Object[]{b.cY(this.mSessionId), this.fNN.getName()});
            return;
        }
        x.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------notifySessionClose------, mac=%s, name=%s", new Object[]{b.cY(this.mSessionId), this.fNN.getName()});
        if (this.hgy != null) {
            this.hgy.a(this.mSessionId, false, this.hgC);
        }
        this.hgy = null;
    }

    private void atR() {
        if (this.hgh.isEmpty()) {
            this.hgi = false;
            return;
        }
        com.tencent.mm.plugin.h.a.b.a.a ad = com.tencent.mm.plugin.h.a.b.a.a.ad((byte[]) this.hgh.pop());
        byte[] atV = ad.atV();
        String str = ad.hhi;
        int i = ad.hhj;
        HashMap hashMap = (HashMap) this.hgB.get(c.bX(ad.hgC));
        if (hashMap == null) {
            x.e("MicroMsg.exdevice.BluetoothLESimpleSession", "service(%s) not found, mac=%s, name=%s", new Object[]{r4, b.cY(this.mSessionId), this.fNN.getName()});
            if (this.hgy != null) {
                this.hgy.j(this.mSessionId, false);
                return;
            }
            return;
        }
        BluetoothGattCharacteristic bluetoothGattCharacteristic = (BluetoothGattCharacteristic) hashMap.get(str);
        if (bluetoothGattCharacteristic == null) {
            String str2;
            String str3 = "MicroMsg.exdevice.BluetoothLESimpleSession";
            String str4 = "characteristic(%s) not found, mac=%s, name=%s";
            Object[] objArr = new Object[3];
            if (str == null) {
                str2 = "null";
            } else {
                str2 = str;
            }
            objArr[0] = str2;
            objArr[1] = b.cY(this.mSessionId);
            objArr[2] = this.fNN.getName();
            x.e(str3, str4, objArr);
            if (this.hgy != null) {
                this.hgy.j(this.mSessionId, false);
            }
        } else if (i == 8) {
            this.hgc.hfD = bluetoothGattCharacteristic;
            this.hgc.setData(atV);
            x.d("MicroMsg.exdevice.BluetoothLESimpleSession", "write data to character, dump = %s, characteristicUuid=%s, mac=%s, name=%s", new Object[]{b.aq(this.hgc.atL()), str, b.cY(this.mSessionId), this.fNN.getName()});
            bluetoothGattCharacteristic.setValue(atV);
            this.mHandler.postDelayed(this.hgd, 5000);
            if (this.hfY.writeCharacteristic(bluetoothGattCharacteristic)) {
                this.hgi = true;
                return;
            }
            x.e("MicroMsg.exdevice.BluetoothLESimpleSession", "mBluetoothGatt.writeCharacteristic Failed!!!, mac=%s, name=%s", new Object[]{b.cY(this.mSessionId), this.fNN.getName()});
            if (this.hgy != null) {
                this.hgy.j(this.mSessionId, false);
            }
        } else {
            x.d("MicroMsg.exdevice.BluetoothLESimpleSession", "write property is needed. but current property is %d, mac=%s, name=%s", new Object[]{Integer.valueOf(i), b.cY(this.mSessionId), this.fNN.getName()});
            if (this.hgy != null) {
                this.hgy.j(this.mSessionId, false);
            }
        }
    }
}

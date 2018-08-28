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
import android.os.Looper;
import android.os.Message;
import com.tencent.mm.plugin.exdevice.j.b;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.UUID;
import junit.framework.Assert;

@TargetApi(18)
public final class d {
    private int aeo;
    BluetoothDevice fNN;
    private BluetoothAdapter heY;
    Context hfX;
    BluetoothGatt hfY;
    b hfZ;
    BluetoothGattCharacteristic hga;
    BluetoothGattCharacteristic hgb;
    a hgc;
    Runnable hgd;
    Runnable hge;
    Runnable hgf;
    d hgg;
    final LinkedList<byte[]> hgh;
    volatile boolean hgi;
    int hgj;
    final BluetoothGattCallback hgk;
    public ag mHandler;
    long mSessionId;
    private HandlerThread mThread;

    private static class a extends ag {
        private final WeakReference<d> hgm;

        public a(Looper looper, d dVar) {
            super(looper);
            this.hgm = new WeakReference(dVar);
        }

        public final void handleMessage(Message message) {
            boolean z = true;
            d dVar = (d) this.hgm.get();
            if (dVar == null) {
                x.e("MicroMsg.exdevice.BluetoothLESession", "null == BluetoothLESession");
                return;
            }
            byte[] atL;
            int i;
            int i2;
            switch (message.what) {
                case 0:
                    x.i("MicroMsg.exdevice.BluetoothLESession", "------connectImp------");
                    if (1 == dVar.hgj) {
                        x.w("MicroMsg.exdevice.BluetoothLESession", "Remote device is connected !!!");
                        return;
                    } else if (dVar.hgj == 0) {
                        x.w("MicroMsg.exdevice.BluetoothLESession", "Remote device is connecting !!!");
                        return;
                    } else {
                        dVar.atQ();
                        if (dVar.hfY == null) {
                            dVar.hfY = dVar.fNN.connectGatt(dVar.hfX, false, dVar.hgk);
                            if (dVar.hfY == null) {
                                x.e("MicroMsg.exdevice.BluetoothLESession", "mDevice.connectGatt Failed!!!");
                                if (dVar.hfZ != null) {
                                    dVar.hfZ.hfE.i(dVar.mSessionId, false);
                                    return;
                                }
                                return;
                            }
                            dVar.hgj = 0;
                            dVar.mHandler.postDelayed(dVar.hgf, 10000);
                            return;
                        } else if (dVar.hfY.connect()) {
                            dVar.hgj = 0;
                            dVar.mHandler.postDelayed(dVar.hgf, 10000);
                            return;
                        } else {
                            x.e("MicroMsg.exdevice.BluetoothLESession", "mBluetoothGatt.connect() Failed!!!");
                            if (dVar.hfZ != null) {
                                dVar.hfZ.hfE.i(dVar.mSessionId, false);
                                return;
                            }
                            return;
                        }
                    }
                case 1:
                    x.i("MicroMsg.exdevice.BluetoothLESession", "------disconnectImp------");
                    if (3 == dVar.hgj) {
                        x.w("MicroMsg.exdevice.BluetoothLESession", "diconnect or close is called aready, just leave");
                        return;
                    }
                    dVar.atQ();
                    if (dVar.hfY == null) {
                        x.e("MicroMsg.exdevice.BluetoothLESession", "disconnect:BluetoothGatt not found");
                        return;
                    }
                    dVar.hgj = 3;
                    dVar.mHandler.removeCallbacks(dVar.hgf);
                    dVar.mHandler.removeCallbacks(dVar.hge);
                    dVar.hfY.disconnect();
                    return;
                case 2:
                    x.i("MicroMsg.exdevice.BluetoothLESession", "------closeImp------");
                    if (3 == dVar.hgj) {
                        x.w("MicroMsg.exdevice.BluetoothLESession", "Close aready, Just leave");
                        return;
                    }
                    dVar.atQ();
                    if (dVar.hfY == null) {
                        x.w("MicroMsg.exdevice.BluetoothLESession", "close:BluetoothGatt not found");
                        return;
                    }
                    dVar.hgj = 3;
                    dVar.hfY.disconnect();
                    dVar.hfY.close();
                    dVar.hfY = null;
                    return;
                case 3:
                    x.i("MicroMsg.exdevice.BluetoothLESession", "------writeDataAsync------ length = %d", new Object[]{Integer.valueOf(((byte[]) message.obj).length)});
                    if (1 != dVar.hgj) {
                        x.e("MicroMsg.exdevice.BluetoothLESession", "Not ready for write data, connectstate = %d", new Object[]{Integer.valueOf(dVar.hgj)});
                        if (dVar.hfZ != null) {
                            dVar.hfZ.hfE.j(dVar.mSessionId, false);
                            return;
                        }
                        return;
                    }
                    boolean z2 = (dVar.hfY == null || dVar.hgb == null) ? false : true;
                    Assert.assertTrue(z2);
                    dVar.hgh.add(atL);
                    if (!dVar.hgi) {
                        if (1 != dVar.hgh.size()) {
                            z = false;
                        }
                        Assert.assertTrue(z);
                        dVar.atR();
                        return;
                    }
                    return;
                case 4:
                    i = message.arg1;
                    String str = "MicroMsg.exdevice.BluetoothLESession";
                    String str2 = "------onConnectionStateChangeImp------ aState = %s";
                    Object[] objArr = new Object[1];
                    objArr[0] = i == 2 ? "Connected" : "Disconnected";
                    x.i(str, str2, objArr);
                    if (i == 2) {
                        x.i("MicroMsg.exdevice.BluetoothLESession", "PHY Connected is OK, mConnectState = %d", new Object[]{Integer.valueOf(dVar.hgj)});
                        if (3 == dVar.hgj) {
                            x.w("MicroMsg.exdevice.BluetoothLESession", "Close or disconnect is Called, Leave without discover Services");
                            dVar.mHandler.removeCallbacks(dVar.hgf);
                            return;
                        } else if (1 == dVar.hgj) {
                            x.w("MicroMsg.exdevice.BluetoothLESession", "Connected is done, Leave without discover Services");
                            dVar.mHandler.removeCallbacks(dVar.hgf);
                            return;
                        } else if (dVar.hfY.discoverServices()) {
                            x.i("MicroMsg.exdevice.BluetoothLESession", "start discoverServices...");
                            return;
                        } else {
                            x.e("MicroMsg.exdevice.BluetoothLESession", "discover Services start failed!!!");
                            dVar.hgj = 2;
                            dVar.mHandler.removeCallbacks(dVar.hgf);
                            if (dVar.hfZ != null) {
                                dVar.hfZ.hfE.i(dVar.mSessionId, false);
                                return;
                            }
                            return;
                        }
                    } else if (i == 0) {
                        x.w("MicroMsg.exdevice.BluetoothLESession", "Disconnected from GATT server.");
                        dVar.hgj = 2;
                        dVar.mHandler.removeCallbacks(dVar.hgf);
                        if (dVar.hfZ != null) {
                            dVar.hfZ.hfE.i(dVar.mSessionId, false);
                            return;
                        }
                        return;
                    } else {
                        return;
                    }
                case 5:
                    BluetoothGatt bluetoothGatt = (BluetoothGatt) message.obj;
                    x.i("MicroMsg.exdevice.BluetoothLESession", "onServicesDiscoveredImp, status = %d", new Object[]{Integer.valueOf(message.arg1)});
                    if (3 == dVar.hgj) {
                        x.w("MicroMsg.exdevice.BluetoothLESession", "Close or disconnect is Called, Just Leave");
                        dVar.mHandler.removeCallbacks(dVar.hgf);
                        return;
                    } else if (1 == dVar.hgj) {
                        x.w("MicroMsg.exdevice.BluetoothLESession", "Connected is done, Just Leave");
                        dVar.mHandler.removeCallbacks(dVar.hgf);
                        return;
                    } else if (i != 0) {
                        x.e("MicroMsg.exdevice.BluetoothLESession", "Discover services error");
                        dVar.hgj = 2;
                        dVar.mHandler.removeCallbacks(dVar.hgf);
                        if (dVar.hfZ != null) {
                            dVar.hfZ.hfE.i(dVar.mSessionId, false);
                            return;
                        }
                        return;
                    } else {
                        BluetoothGattService service = bluetoothGatt.getService(UUID.fromString(h.hgN));
                        if (service == null) {
                            x.e("MicroMsg.exdevice.BluetoothLESession", "Can't not find service(with UUID 0xfee7)");
                            dVar.hgj = 2;
                            dVar.mHandler.removeCallbacks(dVar.hgf);
                            if (dVar.hfZ != null) {
                                dVar.hfZ.hfE.i(dVar.mSessionId, false);
                                return;
                            }
                            return;
                        }
                        dVar.hga = service.getCharacteristic(UUID.fromString(h.hgP));
                        if (dVar.hga == null) {
                            x.e("MicroMsg.exdevice.BluetoothLESession", "Can't not find characteristic(with UUID 0xfec8)");
                            dVar.hgj = 2;
                            dVar.mHandler.removeCallbacks(dVar.hgf);
                            if (dVar.hfZ != null) {
                                dVar.hfZ.hfE.i(dVar.mSessionId, false);
                                return;
                            }
                            return;
                        }
                        dVar.hgb = service.getCharacteristic(UUID.fromString(h.hgO));
                        if (dVar.hgb == null) {
                            x.e("MicroMsg.exdevice.BluetoothLESession", "Can't not find characteristic(with UUID 0xfec7)");
                            dVar.hgj = 2;
                            dVar.mHandler.removeCallbacks(dVar.hgf);
                            if (dVar.hfZ != null) {
                                dVar.hfZ.hfE.i(dVar.mSessionId, false);
                                return;
                            }
                            return;
                        }
                        x.i("MicroMsg.exdevice.BluetoothLESession", "mRecvCharacteristic.getProperties = %d", new Object[]{Integer.valueOf(dVar.hga.getProperties())});
                        if ((dVar.hga.getProperties() & 32) == 0) {
                            x.e("MicroMsg.exdevice.BluetoothLESession", "Read characteristic can not be indicated");
                            dVar.hgj = 2;
                            dVar.mHandler.removeCallbacks(dVar.hgf);
                            if (dVar.hfZ != null) {
                                dVar.hfZ.hfE.i(dVar.mSessionId, false);
                                return;
                            }
                            return;
                        }
                        x.i("MicroMsg.exdevice.BluetoothLESession", "Set read characteristic indicator");
                        d dVar2 = dVar.hgg;
                        BluetoothGattCharacteristic bluetoothGattCharacteristic = dVar.hga;
                        if (dVar2.hfY.setCharacteristicNotification(bluetoothGattCharacteristic, true)) {
                            BluetoothGattDescriptor descriptor = bluetoothGattCharacteristic.getDescriptor(UUID.fromString(h.hgM));
                            if (descriptor == null) {
                                x.e("MicroMsg.exdevice.BluetoothLESession", "Can not get configure descriptor");
                                z = false;
                            } else {
                                x.i("MicroMsg.exdevice.BluetoothLESession", "Configure descriptor permissions: " + descriptor.getPermissions());
                                if (!descriptor.setValue(BluetoothGattDescriptor.ENABLE_INDICATION_VALUE)) {
                                    x.e("MicroMsg.exdevice.BluetoothLESession", "Can not set configure descriptor value");
                                    z = false;
                                } else if (dVar2.hfY.writeDescriptor(descriptor)) {
                                    dVar2.mHandler.postDelayed(dVar2.hge, 5000);
                                } else {
                                    x.e("MicroMsg.exdevice.BluetoothLESession", "Can not write configure descriptor value");
                                    z = false;
                                }
                            }
                        } else {
                            x.e("MicroMsg.exdevice.BluetoothLESession", "Unable to set indicator for read characteristic");
                            z = false;
                        }
                        if (!z) {
                            x.e("MicroMsg.exdevice.BluetoothLESession", "mSelfSession.setCharacteristicNotification Failed!!!");
                            dVar.hgj = 2;
                            dVar.mHandler.removeCallbacks(dVar.hgf);
                            if (dVar.hfZ != null) {
                                dVar.hfZ.hfE.i(dVar.mSessionId, false);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                case 6:
                    Object obj = message.obj;
                    x.i("MicroMsg.exdevice.BluetoothLESession", "------onDescriptorWriteImp------ status = %d", new Object[]{Integer.valueOf(message.arg1)});
                    dVar.mHandler.removeCallbacks(dVar.hge);
                    dVar.mHandler.removeCallbacks(dVar.hgf);
                    if (3 == dVar.hgj) {
                        x.w("MicroMsg.exdevice.BluetoothLESession", "Close or disconnect is Called, Just Leave");
                        return;
                    } else if (1 == dVar.hgj) {
                        x.w("MicroMsg.exdevice.BluetoothLESession", "Connected is done, Just Leave");
                        return;
                    } else if (i2 != 0) {
                        x.e("MicroMsg.exdevice.BluetoothLESession", "Write configure descriptor error");
                        dVar.hgj = 2;
                        if (dVar.hfZ != null) {
                            dVar.hfZ.hfE.i(dVar.mSessionId, false);
                            return;
                        }
                        return;
                    } else {
                        dVar.hgj = 1;
                        if (dVar.hfZ != null) {
                            dVar.hfZ.hfE.i(dVar.mSessionId, true);
                        }
                        x.i("MicroMsg.exdevice.BluetoothLESession", "------BLE connect successfully------ mConnectState = %d", new Object[]{Integer.valueOf(dVar.hgj)});
                        return;
                    }
                case 7:
                    i2 = message.arg1;
                    x.i("MicroMsg.exdevice.BluetoothLESession", "------onDataWriteCallbackImp------ status = %d", new Object[]{Integer.valueOf(i2)});
                    dVar.mHandler.removeCallbacks(dVar.hgd);
                    if (i2 != 0) {
                        x.e("MicroMsg.exdevice.BluetoothLESession", "write data error: " + i2);
                        if (dVar.hfZ != null) {
                            dVar.hfZ.hfE.j(dVar.mSessionId, false);
                        }
                        dVar.atR();
                        return;
                    }
                    atL = dVar.hgc.atL();
                    x.d("MicroMsg.exdevice.BluetoothLESession", "Out data dump = %s", new Object[]{b.aq(atL)});
                    if (atL == null) {
                        x.i("MicroMsg.exdevice.BluetoothLESession", "write data complete");
                        if (dVar.hfZ != null) {
                            dVar.hfZ.hfE.j(dVar.mSessionId, true);
                        }
                        dVar.atR();
                        return;
                    }
                    x.i("MicroMsg.exdevice.BluetoothLESession", "write next chunk...");
                    dVar.hgb.setValue(atL);
                    dVar.hfY.writeCharacteristic(dVar.hgb);
                    dVar.mHandler.postDelayed(dVar.hgd, 5000);
                    return;
                case 8:
                    atL = (byte[]) message.obj;
                    x.i("MicroMsg.exdevice.BluetoothLESession", "------onDataReceiveImp------");
                    if (bi.bC(atL)) {
                        x.e("MicroMsg.exdevice.BluetoothLESession", "Receive data is null or nil");
                        return;
                    }
                    String O = b.O(atL, atL.length);
                    x.i("MicroMsg.exdevice.BluetoothLESession", "data length = %d", new Object[]{Integer.valueOf(atL.length)});
                    x.d("MicroMsg.exdevice.BluetoothLESession", "data dump = %s", new Object[]{O});
                    if (dVar.hfZ != null) {
                        dVar.hfZ.hfE.b(dVar.mSessionId, atL);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    @TargetApi(18)
    public d(long j, Context context, b bVar) {
        this.hgh = new LinkedList();
        this.hgi = false;
        this.hgk = new 1(this);
        this.aeo = -1;
        this.aeo = hashCode();
        this.hgg = this;
        this.hfZ = bVar;
        this.hfX = context;
        this.heY = ((BluetoothManager) this.hfX.getSystemService("bluetooth")).getAdapter();
        this.mSessionId = j;
        this.hgj = 3;
        this.fNN = this.heY.getRemoteDevice(com.tencent.mm.plugin.h.a.e.a.bZ(j));
        this.hga = null;
        this.hgb = null;
        this.hgc = new a();
        this.mThread = e.Xs("BluetoothLESession_handlerThread");
        this.mThread.start();
        this.mHandler = new a(this.mThread.getLooper(), this);
        this.hgd = new Runnable() {
            public final void run() {
                x.e("MicroMsg.exdevice.BluetoothLESession", "Write data timeout");
                if (d.this.hfZ != null) {
                    d.this.hfZ.hfE.j(d.this.mSessionId, false);
                }
                d.this.atR();
            }
        };
        this.hge = new 3(this);
        this.hgf = new 4(this);
    }

    public final boolean connect() {
        x.i("MicroMsg.exdevice.BluetoothLESession", "------connect------");
        return this.mHandler.sendMessage(this.mHandler.obtainMessage(0));
    }

    public final void close() {
        x.i("MicroMsg.exdevice.BluetoothLESession", "------close------");
        if (!this.mHandler.sendMessage(this.mHandler.obtainMessage(2))) {
            x.e("MicroMsg.exdevice.BluetoothLESession", "SendMessage Failed!!! MessageWhat = %d", new Object[]{Integer.valueOf(2)});
        }
        this.mThread.quitSafely();
    }

    final void atQ() {
        this.hgi = false;
        this.hgh.clear();
    }

    final void atR() {
        if (this.hgh.isEmpty()) {
            this.hgi = false;
            return;
        }
        this.hgc.setData((byte[]) this.hgh.pop());
        x.d("MicroMsg.exdevice.BluetoothLESession", "Out data dump = %s", new Object[]{b.aq(this.hgc.atL())});
        this.hgb.setValue(r0);
        this.mHandler.postDelayed(this.hgd, 5000);
        if (!this.hfY.writeCharacteristic(this.hgb)) {
            x.e("MicroMsg.exdevice.BluetoothLESession", "mBluetoothGatt.writeCharacteristic Failed!!!");
        }
        this.hgi = true;
    }
}

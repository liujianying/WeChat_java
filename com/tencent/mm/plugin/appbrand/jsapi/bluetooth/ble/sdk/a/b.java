package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.a;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.os.Handler;
import android.os.Looper;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.c.a;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;

public final class b implements e {
    public Queue<a> fLK;
    a fLL;
    public List<a> fLM;
    public Handler fLN = new Handler(Looper.getMainLooper());

    public final synchronized void ait() {
        if (this.fLL == null || this.fLL.anR) {
            if (this.fLK != null && this.fLK.size() > 0) {
                this.fLL = (a) this.fLK.poll();
                if (this.fLL == null) {
                    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.d.a.w("MicroMsg.Ble.BleConnectDispatcher", "curSerialAction is null, err", new Object[0]);
                } else if (this.fLL.fLy) {
                    this.fLN.postDelayed(new 2(this), this.fLL.fMg);
                } else {
                    this.fLL.aiv();
                }
            }
        }
    }

    public final void onConnectionStateChange(BluetoothGatt bluetoothGatt, int i, int i2) {
        if (this.fLL != null) {
            this.fLL.onConnectionStateChange(bluetoothGatt, i, i2);
        }
        if (this.fLM != null) {
            for (a aVar : this.fLM) {
                if (aVar.anR) {
                    aVar.onConnectionStateChange(bluetoothGatt, i, i2);
                }
            }
        }
    }

    public final void onServicesDiscovered(BluetoothGatt bluetoothGatt, int i) {
        if (this.fLL != null) {
            this.fLL.onServicesDiscovered(bluetoothGatt, i);
        }
        if (this.fLM != null) {
            for (a aVar : this.fLM) {
                if (aVar.anR) {
                    aVar.onServicesDiscovered(bluetoothGatt, i);
                }
            }
        }
    }

    public final void onCharacteristicRead(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
        if (this.fLL != null) {
            this.fLL.onCharacteristicRead(bluetoothGatt, bluetoothGattCharacteristic, i);
        }
        if (this.fLM != null) {
            for (a aVar : this.fLM) {
                if (aVar.anR) {
                    aVar.onServicesDiscovered(bluetoothGatt, i);
                }
            }
        }
    }

    public final void onCharacteristicWrite(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
        if (this.fLL != null) {
            this.fLL.onCharacteristicWrite(bluetoothGatt, bluetoothGattCharacteristic, i);
        }
        if (this.fLM != null) {
            for (a aVar : this.fLM) {
                if (aVar.anR) {
                    aVar.onCharacteristicWrite(bluetoothGatt, bluetoothGattCharacteristic, i);
                }
            }
        }
    }

    public final void onCharacteristicChanged(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        if (this.fLM != null) {
            Iterator it = this.fLM.iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }

    public final void onDescriptorRead(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i) {
        if (this.fLM != null) {
            Iterator it = this.fLM.iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }

    public final void onDescriptorWrite(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i) {
        if (this.fLL != null) {
            this.fLL.onDescriptorWrite(bluetoothGatt, bluetoothGattDescriptor, i);
        }
        if (this.fLM != null) {
            for (a aVar : this.fLM) {
                if (aVar.anR) {
                    aVar.onDescriptorWrite(bluetoothGatt, bluetoothGattDescriptor, i);
                }
            }
        }
    }

    public final void onReliableWriteCompleted(BluetoothGatt bluetoothGatt, int i) {
        if (this.fLM != null) {
            Iterator it = this.fLM.iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }

    public final void onReadRemoteRssi(BluetoothGatt bluetoothGatt, int i, int i2) {
        if (this.fLM != null) {
            for (a aVar : this.fLM) {
                if (aVar.anR) {
                    aVar.onServicesDiscovered(bluetoothGatt, i2);
                }
            }
        }
    }

    public final void onMtuChanged(BluetoothGatt bluetoothGatt, int i, int i2) {
        if (this.fLM != null) {
            Iterator it = this.fLM.iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }
}

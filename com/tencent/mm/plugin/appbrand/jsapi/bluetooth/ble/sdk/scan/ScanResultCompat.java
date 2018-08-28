package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.scan;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.le.ScanResult;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.Arrays;

public class ScanResultCompat implements Parcelable {
    public static final Creator<ScanResultCompat> CREATOR = new 1();
    private BluetoothDevice fNN;
    public f fNO;
    public int fNP;
    private long fNQ;

    /* synthetic */ ScanResultCompat(Parcel parcel, byte b) {
        this(parcel);
    }

    public ScanResultCompat(BluetoothDevice bluetoothDevice, f fVar, int i, long j) {
        this.fNN = bluetoothDevice;
        this.fNO = fVar;
        this.fNP = i;
        this.fNQ = j;
    }

    @TargetApi(21)
    ScanResultCompat(ScanResult scanResult) {
        this.fNN = scanResult.getDevice();
        this.fNO = new f(scanResult.getScanRecord());
        this.fNP = scanResult.getRssi();
        this.fNQ = System.currentTimeMillis();
    }

    private ScanResultCompat(Parcel parcel) {
        if (parcel.readInt() == 1) {
            this.fNN = (BluetoothDevice) BluetoothDevice.CREATOR.createFromParcel(parcel);
        }
        if (parcel.readInt() == 1) {
            this.fNO = f.V(parcel.createByteArray());
        }
        this.fNP = parcel.readInt();
        this.fNQ = parcel.readLong();
    }

    public void writeToParcel(Parcel parcel, int i) {
        if (this.fNN != null) {
            parcel.writeInt(1);
            this.fNN.writeToParcel(parcel, i);
        } else {
            parcel.writeInt(0);
        }
        if (this.fNO != null) {
            parcel.writeInt(1);
            parcel.writeByteArray(this.fNO.fNM);
        } else {
            parcel.writeInt(0);
        }
        parcel.writeInt(this.fNP);
        parcel.writeLong(this.fNQ);
    }

    public int describeContents() {
        return 0;
    }

    public final BluetoothDevice getDevice() {
        if (this.fNN != null) {
            return this.fNN;
        }
        return null;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.fNN, Integer.valueOf(this.fNP), this.fNO, Long.valueOf(this.fNQ)});
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ScanResultCompat scanResultCompat = (ScanResultCompat) obj;
        if (d.equals(this.fNN, scanResultCompat.fNN) && this.fNP == scanResultCompat.fNP && d.equals(this.fNO, scanResultCompat.fNO) && this.fNQ == scanResultCompat.fNQ) {
            return true;
        }
        return false;
    }

    public String toString() {
        return "ScanResult{mDevice=" + this.fNN + ", mScanRecord=" + d.toString(this.fNO) + ", mRssi=" + this.fNP + ", mTimestampNanos=" + this.fNQ + '}';
    }
}

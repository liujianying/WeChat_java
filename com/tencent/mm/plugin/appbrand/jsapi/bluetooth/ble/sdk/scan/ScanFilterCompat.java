package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.scan;

import android.os.Parcel;
import android.os.ParcelUuid;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.Arrays;
import java.util.UUID;

public class ScanFilterCompat implements Parcelable {
    public static final Creator<ScanFilterCompat> CREATOR = new 1();
    private static final ScanFilterCompat fNF = new a().aix();
    final byte[] fNA;
    final byte[] fNB;
    final int fNC;
    final byte[] fND;
    final byte[] fNE;
    final String fNv;
    final String fNw;
    final ParcelUuid fNx;
    final ParcelUuid fNy;
    final ParcelUuid fNz;

    /* synthetic */ ScanFilterCompat(String str, String str2, ParcelUuid parcelUuid, ParcelUuid parcelUuid2, ParcelUuid parcelUuid3, byte[] bArr, byte[] bArr2, int i, byte[] bArr3, byte[] bArr4, byte b) {
        this(str, str2, parcelUuid, parcelUuid2, parcelUuid3, bArr, bArr2, i, bArr3, bArr4);
    }

    private ScanFilterCompat(String str, String str2, ParcelUuid parcelUuid, ParcelUuid parcelUuid2, ParcelUuid parcelUuid3, byte[] bArr, byte[] bArr2, int i, byte[] bArr3, byte[] bArr4) {
        this.fNv = str;
        this.fNx = parcelUuid;
        this.fNy = parcelUuid2;
        this.fNw = str2;
        this.fNz = parcelUuid3;
        this.fNA = bArr;
        this.fNB = bArr2;
        this.fNC = i;
        this.fND = bArr3;
        this.fNE = bArr4;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2;
        int i3 = 0;
        parcel.writeInt(this.fNv == null ? 0 : 1);
        if (this.fNv != null) {
            parcel.writeString(this.fNv);
        }
        if (this.fNw == null) {
            i2 = 0;
        } else {
            i2 = 1;
        }
        parcel.writeInt(i2);
        if (this.fNw != null) {
            parcel.writeString(this.fNw);
        }
        if (this.fNx == null) {
            i2 = 0;
        } else {
            i2 = 1;
        }
        parcel.writeInt(i2);
        if (this.fNx != null) {
            parcel.writeParcelable(this.fNx, i);
            if (this.fNy == null) {
                i2 = 0;
            } else {
                i2 = 1;
            }
            parcel.writeInt(i2);
            if (this.fNy != null) {
                parcel.writeParcelable(this.fNy, i);
            }
        }
        if (this.fNz == null) {
            i2 = 0;
        } else {
            i2 = 1;
        }
        parcel.writeInt(i2);
        if (this.fNz != null) {
            parcel.writeParcelable(this.fNz, i);
            if (this.fNA == null) {
                i2 = 0;
            } else {
                i2 = 1;
            }
            parcel.writeInt(i2);
            if (this.fNA != null) {
                parcel.writeInt(this.fNA.length);
                parcel.writeByteArray(this.fNA);
                if (this.fNB == null) {
                    i2 = 0;
                } else {
                    i2 = 1;
                }
                parcel.writeInt(i2);
                if (this.fNB != null) {
                    parcel.writeInt(this.fNB.length);
                    parcel.writeByteArray(this.fNB);
                }
            }
        }
        parcel.writeInt(this.fNC);
        if (this.fND == null) {
            i2 = 0;
        } else {
            i2 = 1;
        }
        parcel.writeInt(i2);
        if (this.fND != null) {
            parcel.writeInt(this.fND.length);
            parcel.writeByteArray(this.fND);
            if (this.fNE != null) {
                i3 = 1;
            }
            parcel.writeInt(i3);
            if (this.fNE != null) {
                parcel.writeInt(this.fNE.length);
                parcel.writeByteArray(this.fNE);
            }
        }
    }

    static boolean a(UUID uuid, UUID uuid2, UUID uuid3) {
        if (uuid2 == null) {
            return uuid.equals(uuid3);
        }
        if ((uuid.getLeastSignificantBits() & uuid2.getLeastSignificantBits()) == (uuid3.getLeastSignificantBits() & uuid2.getLeastSignificantBits()) && (uuid.getMostSignificantBits() & uuid2.getMostSignificantBits()) == (uuid3.getMostSignificantBits() & uuid2.getMostSignificantBits())) {
            return true;
        }
        return false;
    }

    static boolean a(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        if (bArr3 == null || bArr3.length < bArr.length) {
            return false;
        }
        int i;
        if (bArr2 == null) {
            for (i = 0; i < bArr.length; i++) {
                if (bArr3[i] != bArr[i]) {
                    return false;
                }
            }
            return true;
        }
        for (i = 0; i < bArr.length; i++) {
            if ((bArr2[i] & bArr3[i]) != (bArr2[i] & bArr[i])) {
                return false;
            }
        }
        return true;
    }

    public String toString() {
        return "BluetoothLeScanFilter [mDeviceName=" + this.fNv + ", mDeviceAddress=" + this.fNw + ", mUuid=" + this.fNx + ", mUuidMask=" + this.fNy + ", mServiceDataUuid=" + d.toString(this.fNz) + ", mServiceData=" + Arrays.toString(this.fNA) + ", mServiceDataMask=" + Arrays.toString(this.fNB) + ", mManufacturerId=" + this.fNC + ", mManufacturerData=" + Arrays.toString(this.fND) + ", mManufacturerDataMask=" + Arrays.toString(this.fNE) + "]";
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.fNv, this.fNw, Integer.valueOf(this.fNC), this.fND, this.fNE, this.fNz, this.fNA, this.fNB, this.fNx, this.fNy});
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ScanFilterCompat scanFilterCompat = (ScanFilterCompat) obj;
        if (d.equals(this.fNv, scanFilterCompat.fNv) && d.equals(this.fNw, scanFilterCompat.fNw) && this.fNC == scanFilterCompat.fNC && d.deepEquals(this.fND, scanFilterCompat.fND) && d.deepEquals(this.fNE, scanFilterCompat.fNE) && d.deepEquals(this.fNz, scanFilterCompat.fNz) && d.deepEquals(this.fNA, scanFilterCompat.fNA) && d.deepEquals(this.fNB, scanFilterCompat.fNB) && d.equals(this.fNx, scanFilterCompat.fNx) && d.equals(this.fNy, scanFilterCompat.fNy)) {
            return true;
        }
        return false;
    }
}

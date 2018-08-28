package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.scan;

import android.bluetooth.BluetoothAdapter;
import android.os.Parcel;
import android.os.ParcelUuid;
import android.os.Parcelable.Creator;

class ScanFilterCompat$1 implements Creator<ScanFilterCompat> {
    ScanFilterCompat$1() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        ParcelUuid parcelUuid;
        byte[] bArr;
        byte[] bArr2;
        ScanFilterCompat$a scanFilterCompat$a = new ScanFilterCompat$a();
        if (parcel.readInt() == 1) {
            scanFilterCompat$a.fNv = parcel.readString();
        }
        if (parcel.readInt() == 1) {
            String readString = parcel.readString();
            if (readString == null || BluetoothAdapter.checkBluetoothAddress(readString)) {
                scanFilterCompat$a.fNw = readString;
            } else {
                throw new IllegalArgumentException("invalid device address " + readString);
            }
        }
        if (parcel.readInt() == 1) {
            parcelUuid = (ParcelUuid) parcel.readParcelable(ParcelUuid.class.getClassLoader());
            scanFilterCompat$a.a(parcelUuid);
            if (parcel.readInt() == 1) {
                ParcelUuid parcelUuid2 = (ParcelUuid) parcel.readParcelable(ParcelUuid.class.getClassLoader());
                if (scanFilterCompat$a.fNG == null || scanFilterCompat$a.fNx != null) {
                    scanFilterCompat$a.fNx = parcelUuid;
                    scanFilterCompat$a.fNG = parcelUuid2;
                } else {
                    throw new IllegalArgumentException("uuid is null while uuidMask is not null!");
                }
            }
        }
        if (parcel.readInt() == 1) {
            parcelUuid = (ParcelUuid) parcel.readParcelable(ParcelUuid.class.getClassLoader());
            if (parcel.readInt() == 1) {
                bArr = new byte[parcel.readInt()];
                parcel.readByteArray(bArr);
                if (parcel.readInt() != 0) {
                    bArr2 = new byte[parcel.readInt()];
                    parcel.readByteArray(bArr2);
                    if (parcelUuid == null) {
                        throw new IllegalArgumentException("serviceDataUuid is null");
                    }
                    if (scanFilterCompat$a.fNB != null) {
                        if (scanFilterCompat$a.fNA == null) {
                            throw new IllegalArgumentException("serviceData is null while serviceDataMask is not null");
                        } else if (scanFilterCompat$a.fNA.length != scanFilterCompat$a.fNB.length) {
                            throw new IllegalArgumentException("size mismatch for service data and service data mask");
                        }
                    }
                    scanFilterCompat$a.fNz = parcelUuid;
                    scanFilterCompat$a.fNA = bArr;
                    scanFilterCompat$a.fNB = bArr2;
                } else if (parcelUuid == null) {
                    throw new IllegalArgumentException("serviceDataUuid is null");
                } else {
                    scanFilterCompat$a.fNz = parcelUuid;
                    scanFilterCompat$a.fNA = bArr;
                    scanFilterCompat$a.fNB = null;
                }
            }
        }
        int readInt = parcel.readInt();
        if (parcel.readInt() == 1) {
            bArr = new byte[parcel.readInt()];
            parcel.readByteArray(bArr);
            if (parcel.readInt() != 0) {
                bArr2 = new byte[parcel.readInt()];
                parcel.readByteArray(bArr2);
                if (readInt < 0) {
                    throw new IllegalArgumentException("invalid manufacture id");
                }
                if (scanFilterCompat$a.fNE != null) {
                    if (scanFilterCompat$a.fND == null) {
                        throw new IllegalArgumentException("manufacturerData is null while manufacturerDataMask is not null");
                    } else if (scanFilterCompat$a.fND.length != scanFilterCompat$a.fNE.length) {
                        throw new IllegalArgumentException("size mismatch for manufacturerData and manufacturerDataMask");
                    }
                }
                scanFilterCompat$a.fNC = readInt;
                scanFilterCompat$a.fND = bArr;
                scanFilterCompat$a.fNE = bArr2;
            } else if (readInt < 0) {
                throw new IllegalArgumentException("invalid manufacture id");
            } else {
                scanFilterCompat$a.fNC = readInt;
                scanFilterCompat$a.fND = bArr;
                scanFilterCompat$a.fNE = null;
            }
        }
        return scanFilterCompat$a.aix();
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new ScanFilterCompat[i];
    }
}

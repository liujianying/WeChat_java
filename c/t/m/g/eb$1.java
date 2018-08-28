package c.t.m.g;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.map.geolocation.TencentLocation;

class eb$1 implements Creator<TencentLocation> {
    eb$1() {
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new TencentLocation[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        eb ebVar = new eb(parcel.readInt(), (byte) 0);
        dx dxVar = new dx();
        dv dvVar = new dv();
        dz dzVar = new dz();
        dvVar.c = dzVar;
        eb.a(ebVar, parcel.readString());
        dxVar.a = parcel.readDouble();
        dxVar.b = parcel.readDouble();
        dxVar.d = parcel.readFloat();
        dxVar.c = parcel.readDouble();
        dxVar.f = parcel.readString();
        dzVar.b = parcel.readString();
        dzVar.e = parcel.readString();
        dzVar.f = parcel.readString();
        dzVar.g = parcel.readString();
        dzVar.j = parcel.readString();
        dzVar.k = parcel.readString();
        dzVar.c = parcel.readString();
        eb.a(ebVar, dxVar);
        eb.a(ebVar, dvVar);
        eb.a(ebVar, parcel.readLong());
        Bundle readBundle = parcel.readBundle();
        if (readBundle != null) {
            eb.b(ebVar).putAll(readBundle);
        }
        return ebVar;
    }
}

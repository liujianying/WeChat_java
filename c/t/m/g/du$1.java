package c.t.m.g;

import android.os.Parcel;
import android.os.Parcelable.Creator;

class du$1 implements Creator<du> {
    du$1() {
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new du[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        du duVar = new du();
        duVar.a = parcel.readString();
        duVar.b = parcel.readString();
        duVar.c = parcel.readString();
        duVar.d = parcel.readDouble();
        duVar.e = parcel.readDouble();
        duVar.f = parcel.readDouble();
        duVar.g = parcel.readString();
        duVar.h = parcel.readString();
        return duVar;
    }
}

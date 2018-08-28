package com.tencent.mm.pluginsdk.location;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.modelgeo.Addr;

public class LocationIntent implements Parcelable {
    public static final Creator<LocationIntent> CREATOR = new 1();
    public int bSz = 0;
    public Addr dSa = null;
    public String kCB;
    public String kFa = "";
    public String label = "";
    public double lat;
    public double lng;
    public String qyA = "";
    public int qyB = 0;

    public final String bGa() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("lat " + this.lat + ";");
        stringBuffer.append("lng " + this.lng + ";");
        stringBuffer.append("scale " + this.bSz + ";");
        stringBuffer.append("label " + this.label + ";");
        stringBuffer.append("poiname " + this.kFa + ";");
        stringBuffer.append("infourl " + this.qyA + ";");
        stringBuffer.append("locTypeId " + this.kCB + ";");
        stringBuffer.append("poiType " + this.qyB + ";");
        if (this.dSa != null) {
            stringBuffer.append("addr " + this.dSa.toString() + ";");
        }
        return stringBuffer.toString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeDouble(this.lat);
        parcel.writeDouble(this.lng);
        parcel.writeInt(this.bSz);
        parcel.writeString(this.label);
        parcel.writeString(this.kFa);
        parcel.writeString(this.qyA);
        parcel.writeString(this.kCB);
        parcel.writeInt(this.qyB);
        parcel.writeParcelable(this.dSa, i);
    }
}

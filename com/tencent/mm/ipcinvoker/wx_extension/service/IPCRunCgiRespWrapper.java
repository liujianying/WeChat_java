package com.tencent.mm.ipcinvoker.wx_extension.service;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.ab.b;
import com.tencent.mm.ipcinvoker.extension.c;
import com.tencent.mm.ipcinvoker.wx_extension.a;

public class IPCRunCgiRespWrapper implements Parcelable {
    public static final Creator<IPCRunCgiRespWrapper> CREATOR = new 1();
    public String Yy;
    public b diG;
    public int errCode;
    public int errType;

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.errType);
        parcel.writeInt(this.errCode);
        parcel.writeString(this.Yy);
        c.a(this.diG, parcel);
    }

    IPCRunCgiRespWrapper(Parcel parcel) {
        this.errType = parcel.readInt();
        this.errCode = parcel.readInt();
        this.Yy = parcel.readString();
        this.diG = (b) c.a(a.class.getName(), parcel);
    }

    public static IPCRunCgiRespWrapper CF() {
        IPCRunCgiRespWrapper iPCRunCgiRespWrapper = new IPCRunCgiRespWrapper();
        iPCRunCgiRespWrapper.diG = null;
        iPCRunCgiRespWrapper.Yy = null;
        iPCRunCgiRespWrapper.errType = 3;
        iPCRunCgiRespWrapper.errCode = -2;
        return iPCRunCgiRespWrapper;
    }
}

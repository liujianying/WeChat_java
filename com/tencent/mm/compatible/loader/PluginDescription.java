package com.tencent.mm.compatible.loader;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.compatible.util.m;
import java.io.Serializable;

public class PluginDescription implements Parcelable, Serializable {
    public static final Creator<PluginDescription> CREATOR = new 1();
    public final String bKg;
    public final int dfH;
    public final String name;
    public final int size;
    public final String url;
    public final String version;

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.name);
        parcel.writeString(this.url);
        parcel.writeString(this.bKg);
        parcel.writeString(this.version);
        parcel.writeInt(this.size);
        parcel.writeInt(this.dfH);
    }

    protected PluginDescription(Parcel parcel) {
        this.name = (String) m.Z(parcel.readString());
        this.url = (String) m.Z(parcel.readString());
        this.bKg = (String) m.Z(parcel.readString());
        this.version = (String) m.Z(parcel.readString());
        this.size = parcel.readInt();
        this.dfH = parcel.readInt();
    }

    public String toString() {
        return String.format("PluginDescription = [name=%s, url=%s, md5=%s, version=%s, size=%d, downloadType=%d]", new Object[]{this.name, this.url, this.bKg, this.version, Integer.valueOf(this.size), Integer.valueOf(this.dfH)});
    }
}

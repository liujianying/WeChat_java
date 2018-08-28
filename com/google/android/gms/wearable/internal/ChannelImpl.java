package com.google.android.gms.wearable.internal;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.c;
import com.google.android.gms.common.api.e;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.v;
import com.google.android.gms.common.internal.w;
import com.google.android.gms.wearable.Channel;

public class ChannelImpl implements SafeParcelable, Channel {
    public static final Creator<ChannelImpl> CREATOR = new bb();
    final String bdn;
    final String bem;
    final String ben;
    final int mVersionCode;

    ChannelImpl(int i, String str, String str2, String str3) {
        this.mVersionCode = i;
        this.bem = (String) w.ah(str);
        this.bdn = (String) w.ah(str2);
        this.ben = (String) w.ah(str3);
    }

    public final e<Status> a(c cVar, Uri uri) {
        w.j(cVar, "client is null");
        w.j(uri, "uri is null");
        return cVar.b(new 1(this, cVar, uri));
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ChannelImpl)) {
            return false;
        }
        ChannelImpl channelImpl = (ChannelImpl) obj;
        return this.bem.equals(channelImpl.bem) && v.c(channelImpl.bdn, this.bdn) && v.c(channelImpl.ben, this.ben) && channelImpl.mVersionCode == this.mVersionCode;
    }

    public final String getPath() {
        return this.ben;
    }

    public int hashCode() {
        return this.bem.hashCode();
    }

    public final String rO() {
        return this.bdn;
    }

    public String toString() {
        return "ChannelImpl{versionCode=" + this.mVersionCode + ", token='" + this.bem + '\'' + ", nodeId='" + this.bdn + '\'' + ", path='" + this.ben + '\'' + "}";
    }

    public void writeToParcel(Parcel parcel, int i) {
        bb.a(this, parcel);
    }
}

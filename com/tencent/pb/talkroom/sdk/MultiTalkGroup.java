package com.tencent.pb.talkroom.sdk;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.ArrayList;
import java.util.List;

public class MultiTalkGroup implements Parcelable {
    public static final Creator<MultiTalkGroup> CREATOR = new 1();
    public int vcc;
    public String vgm = "";
    public String vgn = "";
    public String vgo = "";
    public String vgp = "";
    public List<MultiTalkGroupMember> vgq = new ArrayList();

    public String toString() {
        return "MultiTalkGroup [mMultiTalkGroupId=" + this.vgm + ", mMultiTalkClientGroupId=" + this.vgn + ", mWxGroupId=" + this.vgo + ", mRouteId=" + this.vcc + ", mCreatorUsrName=" + this.vgp + ", mMultiTalkGroupMemberList=" + this.vgq + "]";
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2 = 0;
        parcel.writeString(this.vgm == null ? "" : this.vgm);
        parcel.writeString(this.vgn == null ? "" : this.vgn);
        parcel.writeString(this.vgo == null ? "" : this.vgo);
        parcel.writeInt(this.vcc);
        parcel.writeString(this.vgp == null ? "" : this.vgp);
        int size = this.vgq == null ? 0 : this.vgq.size();
        parcel.writeInt(size);
        while (i2 < size) {
            parcel.writeParcelable((MultiTalkGroupMember) this.vgq.get(i2), i);
            i2++;
        }
    }

    public int describeContents() {
        return 0;
    }
}

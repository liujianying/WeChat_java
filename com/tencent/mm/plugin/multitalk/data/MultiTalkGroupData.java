package com.tencent.mm.plugin.multitalk.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.pb.talkroom.sdk.MultiTalkGroup;
import com.tencent.pb.talkroom.sdk.MultiTalkGroupMember;

public class MultiTalkGroupData implements Parcelable {
    public static final Creator<MultiTalkGroupData> CREATOR = new 1();
    private MultiTalkGroup lsV;

    public MultiTalkGroupData(MultiTalkGroup multiTalkGroup) {
        this.lsV = multiTalkGroup;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(bi.aG(this.lsV.vgm, ""));
        parcel.writeString(bi.aG(this.lsV.vgn, ""));
        parcel.writeString(bi.aG(this.lsV.vgo, ""));
        parcel.writeInt(this.lsV.vcc);
        parcel.writeString(bi.aG(this.lsV.vgp, ""));
        parcel.writeInt(this.lsV.vgq.size());
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.lsV.vgq.size()) {
                parcel.writeParcelable(new MultiTalkGroupMemberData((MultiTalkGroupMember) this.lsV.vgq.get(i3)), i);
                i2 = i3 + 1;
            } else {
                return;
            }
        }
    }
}

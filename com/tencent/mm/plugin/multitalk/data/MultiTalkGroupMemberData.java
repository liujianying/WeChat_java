package com.tencent.mm.plugin.multitalk.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.pb.talkroom.sdk.MultiTalkGroupMember;

public class MultiTalkGroupMemberData implements Parcelable {
    public static final Creator<MultiTalkGroupMemberData> CREATOR = new Creator<MultiTalkGroupMemberData>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            MultiTalkGroupMember multiTalkGroupMember = new MultiTalkGroupMember();
            multiTalkGroupMember.vgr = bi.aG(parcel.readString(), "");
            multiTalkGroupMember.vgs = bi.aG(parcel.readString(), "");
            multiTalkGroupMember.status = parcel.readInt();
            multiTalkGroupMember.aAk = parcel.readInt();
            multiTalkGroupMember.vfs = parcel.readInt();
            return new MultiTalkGroupMemberData(multiTalkGroupMember);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new MultiTalkGroupMemberData[i];
        }
    };
    MultiTalkGroupMember lsW;

    public MultiTalkGroupMemberData(MultiTalkGroupMember multiTalkGroupMember) {
        this.lsW = multiTalkGroupMember;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(bi.aG(this.lsW.vgr, ""));
        parcel.writeString(bi.aG(this.lsW.vgs, ""));
        parcel.writeInt(this.lsW.status);
        parcel.writeInt(this.lsW.aAk);
        parcel.writeInt(this.lsW.vfs);
    }
}

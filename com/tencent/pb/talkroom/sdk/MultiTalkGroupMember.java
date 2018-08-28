package com.tencent.pb.talkroom.sdk;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class MultiTalkGroupMember implements Parcelable {
    public static final Creator<MultiTalkGroupMember> CREATOR = new Creator<MultiTalkGroupMember>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            MultiTalkGroupMember multiTalkGroupMember = new MultiTalkGroupMember();
            multiTalkGroupMember.vgr = parcel.readString();
            multiTalkGroupMember.vgs = parcel.readString();
            multiTalkGroupMember.status = parcel.readInt();
            multiTalkGroupMember.aAk = parcel.readInt();
            multiTalkGroupMember.vfs = parcel.readInt();
            return multiTalkGroupMember;
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new MultiTalkGroupMember[i];
        }
    };
    public int aAk;
    public int status;
    public int vfs;
    public String vgr = "";
    public String vgs = "";

    public String toString() {
        return "MultiTalkGroupMember [usrName=" + this.vgr + ", inviteUsrName=" + this.vgs + ", status=" + this.status + ", reason=" + this.aAk + ", inviteTime=" + this.vfs + "]";
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.vgr == null ? "" : this.vgr);
        parcel.writeString(this.vgs == null ? "" : this.vgs);
        parcel.writeInt(this.status);
        parcel.writeInt(this.aAk);
        parcel.writeInt(this.vfs);
    }
}

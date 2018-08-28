package com.tencent.mm.plugin.multitalk.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.pb.talkroom.sdk.MultiTalkGroup;
import java.util.ArrayList;

class MultiTalkGroupData$1 implements Creator<MultiTalkGroupData> {
    MultiTalkGroupData$1() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        MultiTalkGroup multiTalkGroup = new MultiTalkGroup();
        multiTalkGroup.vgm = bi.aG(parcel.readString(), "");
        multiTalkGroup.vgn = bi.aG(parcel.readString(), "");
        multiTalkGroup.vgo = bi.aG(parcel.readString(), "");
        multiTalkGroup.vcc = parcel.readInt();
        multiTalkGroup.vgp = bi.aG(parcel.readString(), "");
        int readInt = parcel.readInt();
        multiTalkGroup.vgq = new ArrayList();
        for (int i = 0; i < readInt; i++) {
            multiTalkGroup.vgq.add(((MultiTalkGroupMemberData) parcel.readParcelable(MultiTalkGroupMemberData.class.getClassLoader())).lsW);
        }
        return new MultiTalkGroupData(multiTalkGroup);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new MultiTalkGroupData[i];
    }
}

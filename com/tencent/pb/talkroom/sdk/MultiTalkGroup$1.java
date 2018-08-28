package com.tencent.pb.talkroom.sdk;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.pb.common.c.c;
import java.util.ArrayList;

class MultiTalkGroup$1 implements Creator<MultiTalkGroup> {
    MultiTalkGroup$1() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        MultiTalkGroup multiTalkGroup = new MultiTalkGroup();
        multiTalkGroup.vgm = parcel.readString();
        multiTalkGroup.vgn = parcel.readString();
        multiTalkGroup.vgo = parcel.readString();
        multiTalkGroup.vcc = parcel.readInt();
        multiTalkGroup.vgp = parcel.readString();
        int readInt = parcel.readInt();
        multiTalkGroup.vgq = new ArrayList();
        for (int i = 0; i < readInt; i++) {
            MultiTalkGroupMember multiTalkGroupMember = (MultiTalkGroupMember) parcel.readParcelable(MultiTalkGroupMember.class.getClassLoader());
            if (multiTalkGroupMember != null) {
                multiTalkGroup.vgq.add(multiTalkGroupMember);
            } else {
                c.d("MultiTalkGroup", new Object[]{"CLTNOT readParcelable member = null"});
            }
        }
        return multiTalkGroup;
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new MultiTalkGroup[i];
    }
}

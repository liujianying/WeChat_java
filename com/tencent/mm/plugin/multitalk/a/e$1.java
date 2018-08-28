package com.tencent.mm.plugin.multitalk.a;

import com.tencent.pb.talkroom.sdk.MultiTalkGroupMember;
import java.util.Comparator;

class e$1 implements Comparator<MultiTalkGroupMember> {
    final /* synthetic */ e ltL;

    e$1(e eVar) {
        this.ltL = eVar;
    }

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        return -((MultiTalkGroupMember) obj).vgr.compareTo(((MultiTalkGroupMember) obj2).vgr);
    }
}

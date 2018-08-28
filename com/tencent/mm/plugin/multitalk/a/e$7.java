package com.tencent.mm.plugin.multitalk.a;

import com.tencent.pb.talkroom.sdk.MultiTalkGroupMember;
import java.util.Comparator;

class e$7 implements Comparator<MultiTalkGroupMember> {
    final /* synthetic */ e ltL;

    e$7(e eVar) {
        this.ltL = eVar;
    }

    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
        MultiTalkGroupMember multiTalkGroupMember = (MultiTalkGroupMember) obj;
        MultiTalkGroupMember multiTalkGroupMember2 = (MultiTalkGroupMember) obj2;
        if (multiTalkGroupMember.vfs > multiTalkGroupMember2.vfs) {
            return -1;
        }
        return multiTalkGroupMember.vfs < multiTalkGroupMember2.vfs ? 1 : 0;
    }
}

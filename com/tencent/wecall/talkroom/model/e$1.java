package com.tencent.wecall.talkroom.model;

import android.support.design.a$i;
import android.widget.Toast;
import com.tencent.pb.common.a.a;
import com.tencent.pb.common.b.a.a.am;
import com.tencent.pb.common.c.c;
import com.tencent.pb.common.c.d;
import com.tencent.pb.common.c.g;
import com.tencent.pb.talkroom.sdk.MultiTalkGroup;
import java.util.List;

class e$1 implements g$a {
    final /* synthetic */ e vxl;

    e$1(e eVar) {
        this.vxl = eVar;
    }

    public final void p(MultiTalkGroup multiTalkGroup) {
        c.x("TalkRoomSdkApi", new Object[]{"onCreateRoom", multiTalkGroup});
        if (a.vbC) {
            Toast.makeText(d.oSX, "onCreateRoom " + multiTalkGroup, 0).show();
        }
        if (e.a(this.vxl) != null) {
            e.a(this.vxl).e(multiTalkGroup);
        }
    }

    public final void Ip(int i) {
        c.d("TalkRoomSdkApi", new Object[]{"onOpeningChannel", Integer.valueOf(i)});
    }

    public final void St() {
        c.x("TalkRoomSdkApi", new Object[]{"onInitSeccess"});
        if (a.vbC) {
            Toast.makeText(d.oSX, "onInitSeccess ", 0).show();
        }
        if (e.a(this.vxl) != null) {
            e.a(this.vxl).bgs();
        }
    }

    public final void g(MultiTalkGroup multiTalkGroup) {
        String str = a.cHu().jTX;
        String str2 = null;
        if (multiTalkGroup != null) {
            str2 = multiTalkGroup.vgm;
        }
        c.w("TalkRoomSdkApi", new Object[]{"onMemberChange mGroupId: ", str, " groupId: ", str2, multiTalkGroup});
        if (a.vbC) {
            Toast.makeText(d.oSX, "onMemberChange " + multiTalkGroup, 0).show();
        }
        if (g.gr(str2, str)) {
            c.cHG();
            if (c.adj(str) && a.cHu().state != 3) {
                int i;
                int i2;
                c.cHG();
                int adk = c.adk(str);
                if (adk == a$i.AppCompatTheme_editTextStyle) {
                    i = -1602;
                    i2 = 325;
                } else if (adk == 2) {
                    i = -1603;
                    i2 = 326;
                } else {
                    i = -1604;
                    i2 = 328;
                }
                c.x("TalkRoomSdkApi", new Object[]{"onMemberChange isMySelfExit finish ", "stopstatus", Integer.valueOf(i), Integer.valueOf(i2), str2, " reason: ", Integer.valueOf(adk)});
                h.It(i);
                a.cHu().vxH.Ix(i2);
                f cHu = a.cHu();
                adk = a.cHu().kvL;
                long j = a.cHu().vxz;
                boolean z = a.cHu().oLU;
                cHu.a(str2, adk, j, false, false, false);
            }
        }
        if (e.a(this.vxl) != null) {
            e.a(this.vxl).g(multiTalkGroup);
        }
    }

    public final void h(int i, Object obj) {
        c.x("TalkRoomSdkApi", new Object[]{"onErr errCode: ", Integer.valueOf(i), " data: ", obj});
        if (e.a(this.vxl) != null) {
            e.a(this.vxl).h(i, obj);
        }
    }

    public final void q(MultiTalkGroup multiTalkGroup) {
        c.x("TalkRoomSdkApi", new Object[]{"onEnterRoom", multiTalkGroup});
        if (e.a(this.vxl) != null) {
            e.a(this.vxl).f(multiTalkGroup);
            if (a.vbC) {
                Toast.makeText(d.oSX, "onEnterRoom " + multiTalkGroup, 0).show();
            }
        }
    }

    public final void bF(String str, boolean z) {
        c.d("TalkRoomSdkApi", new Object[]{"onExitRoom", str, a.cHu().jTX, Boolean.valueOf(z)});
    }

    public final void onStateChanged(int i) {
        c.d("TalkRoomSdkApi", new Object[]{"onStateChanged", Integer.valueOf(i)});
    }

    public final void cHM() {
        c.d("TalkRoomSdkApi", new Object[]{"onSelfHoldOnBegin"});
    }

    public final void cHN() {
        c.d("TalkRoomSdkApi", new Object[]{"onSelfHoldOnEnd"});
    }

    public final void dF(String str, int i) {
        c.d("TalkRoomSdkApi", new Object[]{"onModifyGroupInfo", str, Integer.valueOf(i)});
    }

    public final void gD(boolean z) {
        c.w("TalkRoomSdkApi", new Object[]{"onMuteStateChange", Boolean.valueOf(z)});
        if (e.a(this.vxl) != null) {
            e.a(this.vxl).gD(z);
        }
    }

    public final void b(MultiTalkGroup multiTalkGroup) {
        c.x("TalkRoomSdkApi", new Object[]{"onInviteMultiTalk", multiTalkGroup});
        if (e.a(this.vxl) != null) {
            e.a(this.vxl).b(multiTalkGroup);
            if (a.vbC) {
                Toast.makeText(d.oSX, "onInviteMultiTalk " + multiTalkGroup, 0).show();
            }
        }
    }

    public final void a(int i, MultiTalkGroup multiTalkGroup) {
        c.x("TalkRoomSdkApi", new Object[]{"onMisscMultiTalk", multiTalkGroup, " time: ", Integer.valueOf(i)});
        if (e.a(this.vxl) != null) {
            e.a(this.vxl).d(multiTalkGroup);
            if (a.vbC) {
                Toast.makeText(d.oSX, "onMisscMultiTalk " + multiTalkGroup, 0).show();
            }
        }
    }

    public final void em(List<MultiTalkGroup> list) {
        c.w("TalkRoomSdkApi", new Object[]{"onActiveMultiTalkList ", list});
    }

    public final void cHO() {
        c.x("TalkRoomSdkApi", new Object[]{"onSendMsgSucc"});
    }

    public final void z(String str, byte[] bArr) {
        int i = 0;
        String str2 = "TalkRoomSdkApi";
        Object[] objArr = new Object[4];
        objArr[0] = "onRcvMultiTalkMsg groupId: ";
        objArr[1] = str;
        objArr[2] = " datas size: ";
        if (bArr != null) {
            i = bArr.length;
        }
        objArr[3] = Integer.valueOf(i);
        c.x(str2, objArr);
    }

    public final void Iq(int i) {
        c.d("TalkRoomSdkApi", new Object[]{"onSwitchMultiTalkVideoSuss bitRate: ", Integer.valueOf(i)});
        if (e.a(this.vxl) != null) {
            e.a(this.vxl).bgt();
        }
    }

    public final void bgu() {
        c.d("TalkRoomSdkApi", new Object[]{"onSubscribeLargeVideoSuss"});
        if (e.a(this.vxl) != null) {
            e.a(this.vxl).bgu();
        }
    }

    public final void bB(List<am> list) {
        c.d("TalkRoomSdkApi", new Object[]{"onVideoGroupMemberChange videoUserNames: ", list});
        if (e.a(this.vxl) != null) {
            e.a(this.vxl).bB(list);
        }
    }

    public final void th(int i) {
        c.d("TalkRoomSdkApi", new Object[]{"onNotifyLargeVideoSubscribersChange largeVideoSubscribersCnt: ", Integer.valueOf(i)});
        if (e.a(this.vxl) != null) {
            e.a(this.vxl).th(i);
        }
    }
}

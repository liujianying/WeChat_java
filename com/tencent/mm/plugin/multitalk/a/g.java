package com.tencent.mm.plugin.multitalk.a;

import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import com.tencent.mm.ax.f;
import com.tencent.mm.g.a.mz;
import com.tencent.mm.model.au;
import com.tencent.mm.model.r;
import com.tencent.mm.model.s;
import com.tencent.mm.p.a;
import com.tencent.mm.plugin.multitalk.ui.widget.e;
import com.tencent.mm.plugin.voip.b.d;
import com.tencent.mm.plugin.voip.model.i;
import com.tencent.mm.plugin.voip.ui.h;
import com.tencent.mm.pluginsdk.o.b;
import com.tencent.mm.pluginsdk.o.c;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.pb.common.b.a.a.av;
import com.tencent.pb.common.b.a.a.bb;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class g implements c {
    private List<b> avD = new ArrayList();
    private ag handler = new ag(Looper.getMainLooper());
    private LinkedList<String> ltR = null;
    private LinkedList<String> ltS = new LinkedList();
    private LinkedList<String> ltT = new LinkedList();

    public final LinkedList<String> bgy() {
        if (this.ltT == null) {
            this.ltT = new LinkedList();
        }
        return this.ltT;
    }

    public final synchronized void a(b bVar) {
        this.avD.add(bVar);
    }

    public final synchronized void b(b bVar) {
        this.avD.remove(bVar);
    }

    public final void HB(String str) {
        if (s.fq(str) && HD(str)) {
            x.i("MicroMsg.MultiTalkRoomListMsg", "isKicked! now clean banner and check if i am in multitalk.");
            au.HU();
            com.tencent.mm.model.c.DT().get(2, null);
            if (o.bgN().ltt != null && o.bgN().ltt.vgo.equals(str)) {
                x.i("MicroMsg.MultiTalkRoomListMsg", "yes i am now in multitalk so i exit now!");
                o.bgN().g(false, false, false);
            }
            this.handler.postDelayed(new 1(this, str), 2000);
        }
    }

    public final boolean HC(String str) {
        f HO = o.bgJ().HO(str);
        if (HO == null || HO.field_wxGroupId == null || !HO.field_wxGroupId.equals(str)) {
            return false;
        }
        if (System.currentTimeMillis() - HO.field_createTime <= 21600000) {
            return true;
        }
        x.i("MicroMsg.MultiTalkRoomListMsg", "wxGroupId:" + str + ",is out of time 6 hours..");
        HK(str);
        return false;
    }

    public final boolean HD(String str) {
        if (this.ltR == null) {
            bgB();
        }
        if (this.ltR == null || !this.ltR.contains(str)) {
            return false;
        }
        return true;
    }

    public final List<String> HE(String str) {
        List<com.tencent.mm.plugin.multitalk.b.b> HP = o.bgK().HP(str);
        List linkedList = new LinkedList();
        for (com.tencent.mm.plugin.multitalk.b.b bVar : HP) {
            linkedList.add(bVar.field_userName);
        }
        return linkedList;
    }

    public final boolean dL(String str, String str2) {
        if (o.bgK().dO(str, str2) != null) {
            return true;
        }
        return false;
    }

    public final boolean jy(String str) {
        if (this.ltR != null) {
            x.i("MicroMsg.MultiTalkRoomListMsg", "removewxGroupIdInMap:" + str);
            this.ltR.remove(str);
        } else {
            bgB();
        }
        return o.bgJ().jy(str);
    }

    public final boolean bgl() {
        return o.bgN().bgl();
    }

    public final boolean bgn() {
        return o.bgN().bgn();
    }

    public final boolean bgz() {
        return o.bgN().bgl() && (o.bgN().lts == e.lvL || o.bgN().lts == e.lvK);
    }

    public final boolean HF(String str) {
        com.tencent.mm.plugin.voip.ui.g bJJ = i.bJJ();
        if (bJJ != null) {
            Intent intent = bJJ.intent;
            if (intent != null) {
                String stringExtra = intent.getStringExtra("enterMainUiWxGroupId");
                h hVar = bJJ.oSM;
                if (!com.tencent.pb.common.c.g.isEmpty(stringExtra) && str.equals(stringExtra) && hVar != null && hVar.getVisibility() == 0 && hVar.isShown()) {
                    return true;
                }
            }
        }
        return false;
    }

    public final boolean bgA() {
        return d.bLT() || o.bgN().bgn() || o.bgN().bgl() || o.bgN().bgm();
    }

    public final String dM(String str, String str2) {
        com.tencent.mm.plugin.multitalk.b.b dO = o.bgK().dO(str, str2);
        if (dO != null) {
            return dO.field_inviteUserName;
        }
        return null;
    }

    public final String gT(String str) {
        return r.gT(str);
    }

    public final boolean by(Context context) {
        return a.by(context);
    }

    public final boolean HG(String str) {
        f HO = o.bgJ().HO(str);
        if (HO != null) {
            return com.tencent.wecall.talkroom.model.a.cHu().a(HO.field_groupId, HO.field_roomId, HO.field_roomKey, 1);
        }
        return false;
    }

    public final void HH(String str) {
        if (this.ltS == null) {
            this.ltS = new LinkedList();
            if (!this.ltS.contains(str)) {
                this.ltS.add(str);
            }
        } else if (!this.ltS.contains(str)) {
            this.ltS.add(str);
        }
    }

    public final boolean HI(String str) {
        f HO = o.bgJ().HO(str);
        if (HO != null) {
            return o.bgM().lta.HI(HO.field_groupId);
        }
        return false;
    }

    public final boolean HJ(String str) {
        f HO = o.bgJ().HO(str);
        if (HO == null) {
            return false;
        }
        x.d("MicroMsg.MultiTalkRoomListMsg", "enterMultiTalk, roomid:" + HO.field_roomId + " wxgroupid:" + str);
        return o.bgM().lta.a(HO.field_groupId, HO.field_roomId, HO.field_roomKey, HO.field_routeId, str);
    }

    public final int dN(String str, String str2) {
        com.tencent.mm.plugin.multitalk.b.b dO = o.bgK().dO(str, str2);
        if (dO != null) {
            return dO.field_status;
        }
        return 30;
    }

    public final void HK(String str) {
        if (com.tencent.pb.common.c.g.isNullOrEmpty(str)) {
            x.e("MicroMsg.MultiTalkRoomListMsg", "cleanBanner failure ! wxGroupId is null or empty!");
            return;
        }
        x.i("MicroMsg.MultiTalkRoomListMsg", "cleanBanner  wxGroupId = %s", new Object[]{str});
        jy(str);
        o.bgK().jy(str);
        HN(str);
    }

    public final void a(String str, bb bbVar) {
        x.i("MicroMsg.MultiTalkRoomListMsg", "showBanner  wxGroupId = %s", new Object[]{str});
        if (bbVar != null) {
            av[] avVarArr = bbVar.vea;
            if (avVarArr != null && avVarArr.length > 0) {
                o.bgK().jy(str);
                for (av avVar : avVarArr) {
                    com.tencent.mm.plugin.multitalk.b.b bVar = new com.tencent.mm.plugin.multitalk.b.b();
                    bVar.field_wxGroupId = str;
                    bVar.field_inviteUserName = avVar.vfE;
                    bVar.field_memberUuid = (long) avVar.qXJ;
                    bVar.field_userName = avVar.vez;
                    bVar.field_status = avVar.status;
                    if (!o.bgK().a(bVar)) {
                        x.e("MicroMsg.MultiTalkRoomListMsg", "save multiTalkMember failure! wxGroupId = %s,userName = %s,field_memberUuid = %d,multiTalkMember.field_inviteUserName = %s", new Object[]{str, avVar.vez, Long.valueOf(bVar.field_memberUuid), bVar.field_inviteUserName});
                    }
                    x.i("MicroMsg.MultiTalkRoomListMsg", "save multiTalkMember success! wxGroupId = %s,userName = %s,field_memberUuid = %d,multiTalkMember.field_inviteUserName = %s", new Object[]{str, avVar.vez, Long.valueOf(bVar.field_memberUuid), bVar.field_inviteUserName});
                }
            }
        }
        if (b(str, bbVar)) {
            x.i("MicroMsg.MultiTalkRoomListMsg", "addwxGroupIdInMap:" + str);
            if (this.ltR == null) {
                bgB();
                if (this.ltR != null) {
                    this.ltR.add(str);
                }
            } else if (!this.ltR.contains(str)) {
                this.ltR.add(str);
            }
        }
        HN(str);
    }

    public final void HL(String str) {
        if (this.ltS == null) {
            this.ltS = new LinkedList();
        } else {
            this.ltS.remove(str);
        }
    }

    public final boolean HM(String str) {
        if (this.ltS == null) {
            return false;
        }
        return this.ltS.contains(str);
    }

    final void HN(String str) {
        for (b 2 : this.avD) {
            this.handler.post(new 2(this, 2, str));
        }
    }

    public final f HO(String str) {
        return o.bgJ().HO(str);
    }

    public final void bgB() {
        LinkedList bgR = o.bgJ().bgR();
        x.i("MicroMsg.MultiTalkRoomListMsg", "setMultitalkingwxGroupIdMap reset!");
        this.ltR = new LinkedList();
        Iterator it = bgR.iterator();
        while (it.hasNext()) {
            this.ltR.add(((f) it.next()).field_wxGroupId);
        }
        mz mzVar = new mz();
        mzVar.bYb.type = 1;
        com.tencent.mm.sdk.b.a.sFg.m(mzVar);
    }

    private static boolean b(String str, bb bbVar) {
        int i = 0;
        if (bbVar == null) {
            return false;
        }
        f fVar = new f();
        fVar.field_wxGroupId = str;
        fVar.field_groupId = bbVar.groupId;
        fVar.field_roomId = bbVar.oLB;
        fVar.field_roomKey = bbVar.oLC;
        fVar.field_routeId = bbVar.vcN;
        fVar.field_inviteUserName = bbVar.vfZ;
        av[] avVarArr = bbVar.vea;
        if (avVarArr.length > 0) {
            i = avVarArr.length;
        }
        fVar.field_memberCount = i;
        fVar.field_createTime = System.currentTimeMillis();
        if (o.bgJ().HO(str) == null) {
            return o.bgJ().a(fVar);
        }
        return o.bgJ().b(fVar);
    }

    static boolean c(String str, bb bbVar) {
        if (bbVar == null) {
            return false;
        }
        av[] avVarArr = bbVar.vea;
        List linkedList = new LinkedList();
        for (av avVar : avVarArr) {
            linkedList.add(avVar.vez);
        }
        au.HU();
        String str2 = (String) com.tencent.mm.model.c.DT().get(2, null);
        if (str2 == null) {
            x.i("MicroMsg.MultiTalkRoomListMsg", "myUserName is null , go save delete all logic.");
            b(str, bbVar);
            return true;
        }
        boolean z;
        List<com.tencent.mm.plugin.multitalk.b.b> HP = o.bgK().HP(str);
        LinkedList linkedList2 = new LinkedList();
        com.tencent.mm.plugin.multitalk.b.b bVar = null;
        for (com.tencent.mm.plugin.multitalk.b.b bVar2 : HP) {
            com.tencent.mm.plugin.multitalk.b.b bVar22;
            linkedList2.add(bVar22.field_userName);
            if (!bVar22.field_userName.equals(str2)) {
                bVar22 = bVar;
            }
            bVar = bVar22;
        }
        if (bVar == null || !linkedList.contains(str2)) {
            z = true;
        } else {
            z = true;
            for (av avVar2 : avVarArr) {
                if (!(avVar2.vez == null || !avVar2.vez.equals(str2) || avVar2.status == bVar.field_status)) {
                    com.tencent.mm.plugin.multitalk.b.b bVar3 = new com.tencent.mm.plugin.multitalk.b.b();
                    bVar3.field_wxGroupId = str;
                    bVar3.field_inviteUserName = avVar2.vfE;
                    bVar3.field_memberUuid = (long) avVar2.qXJ;
                    bVar3.field_userName = avVar2.vez;
                    bVar3.field_status = avVar2.status;
                    if (!o.bgK().a(bVar3)) {
                        x.e("MicroMsg.MultiTalkRoomListMsg", "updateMultiTalkMembers update myself failure! wxGroupId = %s,userName = %s,field_memberUuid = %d,multiTalkMember.field_inviteUserName = %s", new Object[]{str, avVar2.vez, Long.valueOf(bVar3.field_memberUuid), bVar3.field_inviteUserName});
                        z = false;
                    }
                    x.i("MicroMsg.MultiTalkRoomListMsg", "updateMultiTalkMembers update myself success! wxGroupId = %s,userName = %s,field_memberUuid = %d,multiTalkMember.field_inviteUserName = %s", new Object[]{str, avVar2.vez, Long.valueOf(bVar3.field_memberUuid), bVar3.field_inviteUserName});
                }
            }
        }
        boolean z2 = z;
        for (av avVar3 : avVarArr) {
            if (!linkedList2.contains(avVar3.vez)) {
                com.tencent.mm.plugin.multitalk.b.b bVar4 = new com.tencent.mm.plugin.multitalk.b.b();
                bVar4.field_wxGroupId = str;
                bVar4.field_inviteUserName = avVar3.vfE;
                bVar4.field_memberUuid = (long) avVar3.qXJ;
                bVar4.field_userName = avVar3.vez;
                bVar4.field_status = avVar3.status;
                if (!o.bgK().a(bVar4)) {
                    x.e("MicroMsg.MultiTalkRoomListMsg", "updateMultiTalkMembers save multiTalkMember failure! wxGroupId = %s,userName = %s,field_memberUuid = %d,multiTalkMember.field_inviteUserName = %s", new Object[]{str, avVar3.vez, Long.valueOf(bVar4.field_memberUuid), bVar4.field_inviteUserName});
                    z2 = false;
                }
                x.i("MicroMsg.MultiTalkRoomListMsg", "updateMultiTalkMembers save multiTalkMember success! wxGroupId = %s,userName = %s,field_memberUuid = %d,multiTalkMember.field_inviteUserName = %s", new Object[]{str, avVar3.vez, Long.valueOf(bVar4.field_memberUuid), bVar4.field_inviteUserName});
            }
        }
        Iterator it = linkedList2.iterator();
        z = z2;
        while (it.hasNext()) {
            str2 = (String) it.next();
            if (!linkedList.contains(str2)) {
                if (o.bgK().ca(str, str2)) {
                    x.i("MicroMsg.MultiTalkRoomListMsg", "updateMultiTalkMembers delete success for wxGroupId = " + str + ", username = " + str2);
                } else {
                    z = false;
                    x.e("MicroMsg.MultiTalkRoomListMsg", "updateMultiTalkMembers delete fail for wxGroupId = " + str + ", username = " + str2);
                }
            }
            z = z;
        }
        return z;
    }
}

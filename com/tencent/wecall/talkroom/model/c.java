package com.tencent.wecall.talkroom.model;

import android.text.TextUtils;
import com.tencent.pb.a.a.a;
import com.tencent.pb.common.b.a.a.at;
import com.tencent.pb.common.b.a.a.av;
import com.tencent.pb.common.b.a.a.aw;
import com.tencent.pb.common.c.e;
import com.tencent.pb.talkroom.sdk.MultiTalkGroup;
import com.tencent.pb.talkroom.sdk.MultiTalkGroupMember;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class c {
    private static boolean DEBUG = false;
    public static boolean vxa = false;
    private static final e<c> vxb = new e<c>() {
        protected final /* synthetic */ Object cEE() {
            return new c();
        }
    };
    Map<String, TalkRoom> vxc;
    Map<String, String> vxd;
    g vxe;

    /* synthetic */ c(byte b) {
        this();
    }

    public static c cHG() {
        return (c) vxb.get();
    }

    private c() {
        this.vxc = new HashMap();
        this.vxd = new HashMap();
        com.tencent.pb.common.c.c.d("TalkRoomManager", new Object[]{"asyncLoadCache"});
    }

    public final boolean bE(String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            com.tencent.pb.common.c.c.x("TalkRoomManager", new Object[]{"isGroupActiveExceptMySelf groupid is null"});
            return false;
        }
        TalkRoom adg = adg(str);
        if (adg == null) {
            com.tencent.pb.common.c.c.x("TalkRoomManager", new Object[]{"isGroupActiveExceptMySelf talkRoom is null"});
            return false;
        }
        List<d> cHA = adg.cHA();
        if (cHA == null) {
            com.tencent.pb.common.c.c.x("TalkRoomManager", new Object[]{"isGroupActiveExceptMySelf TalkRoomMember list is null"});
            return false;
        }
        boolean z2 = false;
        boolean z3 = false;
        for (d dVar : cHA) {
            if (dVar != null) {
                boolean z4;
                TalkRoom.cHw();
                if (dVar.getState() != 10) {
                    z4 = z2;
                } else if (dVar.cHK()) {
                    z4 = true;
                } else {
                    z4 = z2;
                    z3 = true;
                }
                if (z && z3) {
                    return true;
                }
                if (z4 && z3) {
                    com.tencent.pb.common.c.c.x("TalkRoomManager", new Object[]{"isGroupActiveExceptMySelf is true"});
                    return true;
                }
                z2 = z4;
            }
        }
        return false;
    }

    public final TalkRoom adg(String str) {
        TalkRoom talkRoom = (TalkRoom) this.vxc.get(str);
        if (talkRoom != null || !j.ads(str)) {
            return talkRoom;
        }
        return (TalkRoom) this.vxc.get((String) this.vxd.get(str));
    }

    public final int adh(String str) {
        if (TextUtils.isEmpty(str)) {
            com.tencent.pb.common.c.c.x("TalkRoomManager", new Object[]{"getSelfMemberId invalid groupId"});
            return -1;
        }
        TalkRoom adg = adg(str);
        if (adg == null) {
            com.tencent.pb.common.c.c.x("TalkRoomManager", new Object[]{"getSelfMemberId TalkRoom is null  groupId: ", str});
            return -1;
        }
        d adf = adg.adf(a.cEG());
        if (adf != null) {
            com.tencent.pb.common.c.c.x("TalkRoomManager", new Object[]{"getSelfMemberId TalkRoomMember is not null groupId: ", str, " uuid: ", a.cEG(), " memberId: ", Integer.valueOf(adf.cHJ())});
            return adf.cHJ();
        }
        com.tencent.pb.common.c.c.x("TalkRoomManager", new Object[]{"getSelfMemberId TalkRoomMember is null"});
        return -1;
    }

    public final int adi(String str) {
        if (TextUtils.isEmpty(str)) {
            com.tencent.pb.common.c.c.x("TalkRoomManager", new Object[]{"getRountIdByGrouId invalid groupId"});
            return 0;
        }
        TalkRoom adg = adg(str);
        if (adg != null) {
            return adg.cHx();
        }
        com.tencent.pb.common.c.c.x("TalkRoomManager", new Object[]{"getRountIdByGrouId TalkRoom is null  groupId: ", str});
        return 0;
    }

    public final boolean c(String str, String str2, String... strArr) {
        com.tencent.pb.common.c.c.d("TalkRoomManager", new Object[]{"newTmpGroup groupId: ", str});
        if (!j.ads(str)) {
            com.tencent.pb.common.c.c.x("TalkRoomManager", new Object[]{"newTmpGroup invalid clientGroupId"});
            return false;
        } else if (strArr == null || strArr.length == 0) {
            com.tencent.pb.common.c.c.x("TalkRoomManager", new Object[]{"newTmpGroup empty uuid array"});
            return false;
        } else {
            try {
                at atVar = new at();
                atVar.bOS = 0;
                atVar.vfd = str2;
                atVar.vfc = a.cEG();
                TalkRoom talkRoom = new TalkRoom(str, null, atVar);
                int length = strArr.length;
                for (int i = 0; i != length; i++) {
                    String str3 = strArr[i];
                    av avVar = new av();
                    avVar.vez = str3;
                    avVar.vfE = a.cEG();
                    avVar.status = 20;
                    avVar.kpU = -1;
                    avVar.vfs = (int) (System.currentTimeMillis() / 1000);
                    talkRoom.a(new d(avVar, new aw()));
                }
                this.vxc.put(str, talkRoom);
                cHH();
                return true;
            } catch (Exception e) {
                com.tencent.pb.common.c.c.x("TalkRoomManager", new Object[]{"newTmpGroup err: ", e});
                return false;
            }
        }
    }

    static void cHH() {
        com.tencent.pb.common.c.c.d("TalkRoomManager", new Object[]{"asyncWriteBackCache"});
    }

    public static boolean adj(String str) {
        TalkRoom adg = cHG().adg(str);
        if (adg == null) {
            com.tencent.pb.common.c.c.x("TalkRoomManager", new Object[]{"isMySelfExit talkRoom is null"});
            return true;
        }
        d cHC = adg.cHC();
        if (cHC == null || 20 == cHC.getState()) {
            return true;
        }
        return false;
    }

    public static int adk(String str) {
        TalkRoom adg = cHG().adg(str);
        if (adg == null) {
            com.tencent.pb.common.c.c.x("TalkRoomManager", new Object[]{"getMySelfReason talkRoom is null groupId: ", str});
            return 0;
        }
        int i;
        d cHC = adg.cHC();
        if (cHC == null || cHC.vxf == null) {
            i = 0;
        } else {
            i = cHC.vxf.aAk;
        }
        com.tencent.pb.common.c.c.x("TalkRoomManager", new Object[]{"getMySelfReason groupId: ", str, " reason: ", Integer.valueOf(i)});
        return i;
    }

    public final MultiTalkGroup adl(String str) {
        TalkRoom adg = adg(str);
        if (adg == null) {
            return null;
        }
        MultiTalkGroup multiTalkGroup = new MultiTalkGroup();
        multiTalkGroup.vgm = adg.vgm;
        multiTalkGroup.vgn = adg.vgn;
        multiTalkGroup.vcc = adg.vcc;
        multiTalkGroup.vgo = adg.vgo;
        multiTalkGroup.vgp = adg.vgp;
        List arrayList = new ArrayList();
        List<d> cHB = adg.cHB();
        if (cHB.size() > 0) {
            for (d dVar : cHB) {
                if (dVar != null) {
                    MultiTalkGroupMember multiTalkGroupMember = new MultiTalkGroupMember();
                    multiTalkGroupMember.vgr = dVar.cHI();
                    multiTalkGroupMember.vgs = dVar.vxf != null ? dVar.vxf.vfE : "";
                    multiTalkGroupMember.aAk = dVar.vxf != null ? dVar.vxf.aAk : 0;
                    multiTalkGroupMember.status = dVar.getState();
                    int i = (dVar.vxf == null || dVar.vxf.vfs == 0) ? 0 : dVar.vxf.vfs;
                    multiTalkGroupMember.vfs = i;
                    arrayList.add(multiTalkGroupMember);
                }
            }
        }
        multiTalkGroup.vgq = arrayList;
        return multiTalkGroup;
    }
}

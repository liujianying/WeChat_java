package com.tencent.mm.model;

import com.tencent.mm.a.f;
import com.tencent.mm.aa.j;
import com.tencent.mm.aa.q;
import com.tencent.mm.g.a.ao;
import com.tencent.mm.g.a.ap;
import com.tencent.mm.g.a.jy;
import com.tencent.mm.g.c.ai;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.chatroom.b.b;
import com.tencent.mm.plugin.chatroom.c;
import com.tencent.mm.plugin.messenger.foundation.a.a.h.a;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.protocal.c.atj;
import com.tencent.mm.protocal.c.aub;
import com.tencent.mm.protocal.c.bo;
import com.tencent.mm.protocal.c.mx;
import com.tencent.mm.protocal.c.my;
import com.tencent.mm.protocal.c.qz;
import com.tencent.mm.protocal.c.ri;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ay;
import com.tencent.mm.storage.u;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import junit.framework.Assert;

public final class m {
    public static f<String, String> dAF = new f(100);

    public static boolean gA(String str) {
        u ih = ((b) g.l(b.class)).Ga().ih(str);
        return ih == null ? false : ih.ckP();
    }

    public static boolean c(String str, Map<String, String> map) {
        u ih = ((b) g.l(b.class)).Ga().ih(str);
        if (ih == null) {
            return false;
        }
        for (String str2 : ih.Nn()) {
            map.put(str2, ih.gT(str2));
        }
        return true;
    }

    public static boolean gB(String str) {
        String ij = ((b) g.l(b.class)).Ga().ij(str);
        String GF = q.GF();
        if (bi.oW(ij) || bi.oW(GF) || !ij.equals(GF)) {
            return false;
        }
        return true;
    }

    public static void a(String str, u uVar, boolean z) {
        uVar.ll(z);
        ((b) g.l(b.class)).Ga().c(uVar, new String[0]);
        String GF = q.GF();
        aub aub = new aub();
        aub.rvj = str;
        aub.hbL = GF;
        aub.rXb = 1;
        aub.mEc = z ? 1 : 2;
        ((i) g.l(i.class)).FQ().b(new a(49, aub));
    }

    public static String F(List<String> list) {
        return c((List) list, -1);
    }

    public static String c(List<String> list, int i) {
        if (list == null || list.size() == 0) {
            return "";
        }
        String str = "";
        int i2 = i - 1;
        int i3 = 0;
        while (i3 < list.size()) {
            String str2 = (String) list.get(i3);
            if (str2.length() > 0) {
                str2 = str + ((i) g.l(i.class)).FR().Yg(str2).BL();
                if (i3 == i2 && i3 < list.size()) {
                    return str2 + "...";
                }
                if (i3 < list.size() - 1) {
                    str2 = str2 + ad.getContext().getString(c.a.chatroom_sys_msg_invite_split);
                }
            } else {
                str2 = str;
            }
            i3++;
            str = str2;
        }
        return str;
    }

    public static boolean gC(String str) {
        String str2 = (String) g.Ei().DT().get(2, null);
        List gI = gI(str);
        if (gI == null) {
            x.d("MicroMsg.ChatroomMembersLogic", "getmembsersbychatroomname is null ");
            return false;
        } else if (gI.size() != 0 && gI.contains(str2)) {
            return true;
        } else {
            x.d("MicroMsg.ChatroomMembersLogic", "getmembsersbychatroomname is list is zero or no contains user  " + gI.size() + " ");
            return false;
        }
    }

    public static boolean gD(String str) {
        if (str == null || !str.toLowerCase().endsWith("@chatroom")) {
            return false;
        }
        if (((b) g.l(b.class)).Ga().im(str)) {
            List il = ((b) g.l(b.class)).Ga().il(str);
            if (il == null || il.size() == 0) {
                return true;
            }
            return false;
        }
        x.d("MicroMsg.ChatroomMembersLogic", "state is die");
        return true;
    }

    public static boolean gE(String str) {
        if (str == null || !str.toLowerCase().endsWith("@chatroom")) {
            return false;
        }
        x.d("MicroMsg.ChatroomMembersLogic", "updateFailState chatRoomName %s", new Object[]{str});
        af Ga = ((b) g.l(b.class)).Ga();
        u ih = Ga.ih(str);
        if (ih == null) {
            return false;
        }
        ih.field_roomflag = 1;
        return Ga.a(ih);
    }

    public static boolean a(String str, String str2, mx mxVar, String str3, com.tencent.mm.i.a.a.a aVar, com.tencent.mm.sdk.b.b bVar) {
        if ((str.toLowerCase().endsWith("@chatroom") || str.toLowerCase().endsWith("@groupcard") || str.toLowerCase().endsWith("@talkroom")) && mxVar.hLg != 0) {
            ay FR = ((i) g.l(i.class)).FR();
            u ih = ((b) g.l(b.class)).Ga().ih(str);
            if (ih != null) {
                aVar.bUd = ih.ckK();
            }
            List arrayList = new ArrayList();
            boolean z = false;
            x.i("MicroMsg.ChatroomMembersLogic", "SyncAddChatroomMember: room:[" + str + "] memCnt:" + mxVar.hLg);
            long currentTimeMillis = System.currentTimeMillis();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= mxVar.hLg) {
                    break;
                }
                my myVar = (my) mxVar.rqV.get(i2);
                ab Yg = FR.Yg(myVar.hbL);
                if (Yg == null) {
                    x.e("MicroMsg.ChatroomMembersLogic", "SyncAddChatroomMember memberlist username is null");
                } else {
                    com.tencent.mm.i.a.a.b bVar2 = new com.tencent.mm.i.a.a.b();
                    bVar2.userName = myVar.hbL;
                    bVar2.daC = myVar.rrc;
                    if (mxVar.rqW == 0) {
                        bVar2.daA = myVar.rqY;
                        bVar2.daB = myVar.rrb;
                        if (!bi.oW(myVar.rra)) {
                            j kc = q.KH().kc(myVar.hbL);
                            if (kc == null) {
                                kc = new j();
                                kc.username = myVar.hbL;
                            }
                            kc.dHR = myVar.rqZ;
                            kc.dHQ = myVar.rra;
                            kc.csA = 3;
                            kc.by(!bi.oW(myVar.rqZ));
                            q.KH().a(kc);
                        }
                    }
                    if (ih != null) {
                        com.tencent.mm.i.a.a.b XK = ih.XK(myVar.hbL);
                        if (XK != null) {
                            bVar2.daA = XK.daA;
                            bVar2.daB = XK.daB;
                            bVar2.daC = XK.daC;
                        }
                    }
                    aVar.dav.add(bVar2);
                    if (((int) Yg.dhP) == 0) {
                        Yg.setUsername(myVar.hbL);
                        if (myVar.hcS != null) {
                            Yg.dx(myVar.hcS);
                        }
                        Yg.Ba();
                        FR.T(Yg);
                        z = true;
                    }
                    arrayList.add(Yg.field_username);
                }
                i = i2 + 1;
            }
            x.i("MicroMsg.ChatroomMembersLogic", "summertt SyncAddChatroomMember listUsernames size: " + arrayList.size() + " event: " + bVar + " publish: " + z + " take[" + (System.currentTimeMillis() - currentTimeMillis) + "]ms");
            if (z) {
                com.tencent.mm.sdk.b.a.sFg.m(bVar);
            } else if (ih != null) {
                u.ckM();
            } else {
                x.i("MicroMsg.ChatroomMembersLogic", "ChatroomId:%s is Need Update All InviteerInfo ", new Object[]{str});
                ((jy) bVar).bUc.bUd = 0;
                com.tencent.mm.sdk.b.a.sFg.m(bVar);
            }
            u ih2 = ((b) g.l(b.class)).Ga().ih(str);
            if (ih2 == null) {
                ih2 = new u();
            }
            long currentTimeMillis2 = System.currentTimeMillis();
            ih2.field_chatroomname = str;
            ih2.field_roomowner = str2;
            u da = ih2.da(arrayList);
            da.field_displayname = F(arrayList);
            da.a(str3, aVar, mxVar.rqW != 0);
            currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis2;
            x.i("MicroMsg.ChatroomMembersLogic", "syncAddChatroomMember replaceChatroomMember ret : %s , during : %s", new Object[]{Boolean.valueOf(a(ih2)), Long.valueOf(currentTimeMillis2)});
            if (ih2.ckL()) {
                x.i("MicroMsg.ChatroomMembersLogic", "syncAddChatroomMember OldVer:%d", new Object[]{Integer.valueOf(ih2.ckK())});
                ao aoVar = new ao();
                aoVar.bHW.username = str;
                com.tencent.mm.sdk.b.a.sFg.m(aoVar);
            }
            return r3;
        }
        x.e("MicroMsg.ChatroomMembersLogic", "SyncAddChatroomMember: room:[" + str + "] listCnt:" + mxVar.hLg);
        return false;
    }

    public static boolean a(String str, mx mxVar) {
        if (mxVar == null) {
            x.e("MicroMsg.ChatroomMembersLogic", "[updateChatroomInviteer] memberData is null!");
            return false;
        } else if (bi.oW(str)) {
            x.e("MicroMsg.ChatroomMembersLogic", "[updateChatroomInviteer] username is null!");
            return false;
        } else if (s.fq(str)) {
            x.e("MicroMsg.ChatroomMembersLogic", "[updateChatroomInviteer] username is not personal! :%s", new Object[]{str});
            return false;
        } else {
            String a = com.tencent.mm.platformtools.ab.a(mxVar.rqX);
            if (bi.oW(a)) {
                x.e("MicroMsg.ChatroomMembersLogic", "[updateChatroomInviteer] chatroomId is null!");
                return false;
            }
            x.i("MicroMsg.ChatroomMembersLogic", "[updateChatroomInviteer] chatroomId:%s size:%s", new Object[]{a, Integer.valueOf(mxVar.rqV.size())});
            u ih = ((b) g.l(b.class)).Ga().ih(a);
            if (ih != null && mxVar.rqV.size() > 0 && ih.Nn().contains(((my) mxVar.rqV.get(0)).hbL)) {
                com.tencent.mm.i.a.a.b XK = ih.XK(((my) mxVar.rqV.get(0)).hbL);
                if (XK != null) {
                    x.i("MicroMsg.ChatroomMembersLogic", "oldMember contains:%s displayName:%s", new Object[]{r0, XK.daA});
                    XK.daC = ((my) mxVar.rqV.get(0)).rrc;
                    a(ih);
                } else {
                    x.e("MicroMsg.ChatroomMembersLogic", "talker:%s oldMemberData is null!", new Object[]{r0});
                }
                return true;
            } else if (ih == null || mxVar.rqV.size() <= 0) {
                if (mxVar.rqV.size() <= 0) {
                    x.e("MicroMsg.ChatroomMembersLogic", "[updateChatroomInviteer] memberData.ChatRoomMember.size() <= 0");
                }
                if (ih != null) {
                    x.e("MicroMsg.ChatroomMembersLogic", "[updateChatroomInviteer] oldMember is null!");
                }
                return false;
            } else {
                ap apVar = new ap();
                apVar.bHX.username = ((my) mxVar.rqV.get(0)).hbL;
                apVar.bHX.bHY = ((my) mxVar.rqV.get(0)).rrc;
                dAF.put(a + "#" + apVar.bHX.username, apVar.bHX.bHY);
                com.tencent.mm.sdk.b.a.sFg.m(apVar);
                return false;
            }
        }
    }

    public static String K(String str, String str2) {
        String str3 = str2 + "#" + str;
        if (dAF.ce(str3)) {
            return (String) dAF.get(str3);
        }
        return "";
    }

    public static boolean a(u uVar) {
        if (uVar == null) {
            x.e("MicroMsg.ChatroomMembersLogic", "updateChatroomMember error! member is null");
            return false;
        }
        boolean a = ((b) g.l(b.class)).Ga().a(uVar);
        if (a) {
            String str = uVar.field_chatroomname;
            String str2 = uVar.field_roomowner;
            x.d("MicroMsg.ChatroomMembersLogic", "update contact chatroom type to %d", new Object[]{Integer.valueOf(1)});
            ay FR = ((i) g.l(i.class)).FR();
            ab Yg = FR.Yg(str);
            if (!(((int) Yg.dhP) == 0 || bi.oW(str2) || bi.oW(q.GF()))) {
                if (str2.equals(q.GF())) {
                    Yg.ge(1);
                } else {
                    Yg.ge(0);
                }
                FR.a(str, Yg);
            }
        }
        return a;
    }

    public static boolean a(String str, qz qzVar) {
        if (!str.toLowerCase().endsWith("@chatroom") || qzVar.hLg == 0) {
            x.e("MicroMsg.ChatroomMembersLogic", "DelChatroomMember: room:[" + str + "] listCnt:" + qzVar.hLg);
            return false;
        }
        af Ga = ((b) g.l(b.class)).Ga();
        u ih = Ga.ih(str);
        List XM = u.XM(ih.field_memberlist);
        x.d("MicroMsg.ChatroomMembersLogic", "DelChatroomMember before " + XM.size());
        Iterator it = qzVar.rbQ.iterator();
        while (it.hasNext()) {
            XM.remove(com.tencent.mm.platformtools.ab.a(((ri) it.next()).rvo));
        }
        x.d("MicroMsg.ChatroomMembersLogic", "DelChatroomMember after " + XM.size());
        ih.da(XM).field_displayname = F(XM);
        boolean a = Ga.a(ih);
        x.d("MicroMsg.ChatroomMembersLogic", "delChatroomMember " + a);
        return a;
    }

    public static boolean a(String str, bo boVar) {
        if (!str.toLowerCase().endsWith("@chatroom") || boVar.hLg == 0) {
            x.e("MicroMsg.ChatroomMembersLogic", "AddChatroomMember: room:[" + str + "] listCnt:" + boVar.hLg);
            return false;
        }
        ArrayList arrayList = new ArrayList();
        ay FR = ((i) g.l(i.class)).FR();
        for (int i = 0; i < boVar.hLg; i++) {
            String a = com.tencent.mm.platformtools.ab.a(((atj) boVar.rbQ.get(i)).rvo);
            if (((atj) boVar.rbQ.get(i)).rWG == 0) {
                if (bi.oW(a)) {
                    x.e("MicroMsg.ChatroomMembersLogic", "this member name is null! chatRoomName : %s", new Object[]{str});
                } else {
                    ai aiVar;
                    ab Yg = FR.Yg(a);
                    if (((int) Yg.dhP) != 0) {
                        Yg.Ba();
                        FR.a(Yg.field_username, Yg);
                        aiVar = Yg;
                    } else {
                        aiVar = a(Yg, (atj) boVar.rbQ.get(i));
                        FR.T(aiVar);
                    }
                    arrayList.add(aiVar.field_username);
                }
            }
        }
        if (arrayList.isEmpty()) {
            return false;
        }
        return a(str, arrayList, null);
    }

    public static boolean gF(String str) {
        if (str.toLowerCase().endsWith("@groupcard")) {
            ay FR = ((i) g.l(i.class)).FR();
            if (FR.Yi(str)) {
                FR.Ym(str);
            } else {
                x.e("MicroMsg.ChatroomMembersLogic", "deleteWholeGroupcard RoomName not exist:[" + str + "]");
            }
            return gH(str);
        }
        x.e("MicroMsg.ChatroomMembersLogic", "deleteWholeGroupcard: room:[" + str + "]");
        return false;
    }

    public static boolean gG(String str) {
        if (str.toLowerCase().endsWith("@chatroom")) {
            ay FR = ((i) g.l(i.class)).FR();
            if (FR.Yi(str)) {
                FR.Ym(str);
            } else {
                x.e("MicroMsg.ChatroomMembersLogic", "deleteWholeChatroom RoomName not exist:[" + str + "]");
            }
            return gH(str);
        }
        x.e("MicroMsg.ChatroomMembersLogic", "deleteWholeChatroom: room:[" + str + "]");
        return false;
    }

    public static boolean a(String str, ArrayList<String> arrayList, String str2) {
        List gI;
        int i = 0;
        af Ga = ((b) g.l(b.class)).Ga();
        u ii = Ga.ii(str);
        if (str.endsWith("@chatroom")) {
            gI = gI(str);
        } else {
            gI = new LinkedList();
        }
        List linkedList = new LinkedList();
        if (gI != null) {
            for (int i2 = 0; i2 < gI.size(); i2++) {
                linkedList.add(gI.get(i2));
            }
            while (i < arrayList.size()) {
                if (!gI.contains(arrayList.get(i))) {
                    linkedList.add(arrayList.get(i));
                }
                i++;
            }
            if (!bi.oW(str2)) {
                ii.field_roomowner = str2;
            }
            ii.da(linkedList).field_displayname = F(linkedList);
            return Ga.a(ii);
        }
        while (i < arrayList.size()) {
            linkedList.add(arrayList.get(i));
            i++;
        }
        if (!bi.oW(str2)) {
            ii.field_roomowner = str2;
        }
        ii.da(linkedList).field_displayname = F(linkedList);
        ii.field_roomowner = str2;
        boolean a = Ga.a(ii);
        x.d("MicroMsg.ChatroomMembersLogic", "insertMembersByChatRoomName " + a);
        return a;
    }

    private static boolean gH(String str) {
        return ((b) g.l(b.class)).Ga().in(str);
    }

    public static List<String> gI(String str) {
        if (str == null) {
            x.e("MicroMsg.ChatroomMembersLogic", "chatroomName is null");
            return null;
        } else if (str.toLowerCase().endsWith("@chatroom")) {
            return ((b) g.l(b.class)).Ga().il(str);
        } else {
            x.e("MicroMsg.ChatroomMembersLogic", "getMembersByChatRoomName: this is not room:[" + str + "]");
            return null;
        }
    }

    public static List<String> gJ(String str) {
        if (str.toLowerCase().endsWith("@chatroom")) {
            return ((b) g.l(b.class)).Ga().il(str);
        }
        x.e("MicroMsg.ChatroomMembersLogic", "getMembersByChatRoomName: room:[" + str + "]");
        return null;
    }

    public static int gK(String str) {
        List gI = gI(str);
        if (gI != null) {
            return gI.size();
        }
        x.e("MicroMsg.ChatroomMembersLogic", "getMembersByChatRoomName: get room:[" + str + "] members count fail");
        return 0;
    }

    public static List<String> gL(String str) {
        int i = 0;
        if (str.toLowerCase().endsWith("@chatroom")) {
            List<String> gI = gI(str);
            if (gI == null || gI.size() <= 0) {
                return null;
            }
            String str2 = (String) g.Ei().DT().get(2, null);
            boolean z = str2 != null && str2.length() > 0;
            Assert.assertTrue(z);
            while (i < gI.size()) {
                if (((String) gI.get(i)).equals(str2)) {
                    gI.remove(i);
                    break;
                }
                i++;
            }
            if (gI.size() <= 0) {
                return null;
            }
            return gI;
        }
        x.e("MicroMsg.ChatroomMembersLogic", "getOtherMembersByChatRoomName: room:[" + str + "]");
        return null;
    }

    public static ab a(ab abVar, atj atj) {
        abVar.setUsername(com.tencent.mm.platformtools.ab.a(atj.rvo));
        abVar.dx(com.tencent.mm.platformtools.ab.a(atj.rvo));
        abVar.dy(com.tencent.mm.platformtools.ab.a(atj.rvo));
        abVar.dz(com.tencent.mm.platformtools.ab.a(atj.ruU));
        abVar.eJ(atj.eJH);
        abVar.dv(com.tencent.mm.platformtools.ab.a(atj.rWH));
        abVar.dC(com.tencent.mm.platformtools.ab.a(atj.rWI));
        abVar.dB(com.tencent.mm.platformtools.ab.a(atj.ruU));
        abVar.eM(atj.rup);
        abVar.eO(atj.eJL);
        abVar.dS(RegionCodeDecoder.aq(atj.eJQ, atj.eJI, atj.eJJ));
        abVar.dM(atj.eJK);
        return abVar;
    }

    public static String L(String str, String str2) {
        u ih = ((b) g.l(b.class)).Ga().ih(str2);
        if (ih == null) {
            return null;
        }
        return ih.gT(str);
    }

    public static String gM(String str) {
        u ih = ((b) g.l(b.class)).Ga().ih(str);
        if (ih == null) {
            return null;
        }
        return ih.field_chatroomnotice;
    }

    public static boolean F(String str, int i) {
        u ih = ((b) g.l(b.class)).Ga().ih(str);
        if (ih == null) {
            return false;
        }
        return ih.field_chatroomVersion < i;
    }

    public static String gN(String str) {
        u ih = ((b) g.l(b.class)).Ga().ih(str);
        if (ih == null) {
            return null;
        }
        return ih.field_chatroomnoticeEditor;
    }

    public static long gO(String str) {
        u ih = ((b) g.l(b.class)).Ga().ih(str);
        if (ih == null) {
            return -1;
        }
        return ih.field_chatroomnoticePublishTime;
    }

    public static void a(String str, String str2, String str3, long j, int i) {
        af Ga = ((b) g.l(b.class)).Ga();
        u ih = Ga.ih(str);
        if (ih != null) {
            ih.field_chatroomVersion = i;
            ih.field_chatroomnoticePublishTime = j;
            ih.field_chatroomnoticeEditor = str3;
            ih.field_chatroomnotice = str2;
            Ga.a(ih);
        }
    }

    public static void G(String str, int i) {
        af Ga = ((b) g.l(b.class)).Ga();
        u ih = Ga.ih(str);
        if (ih != null) {
            com.tencent.mm.i.a.a.a ckQ = ih.ckQ();
            ckQ.type = i;
            ih.a(str, ckQ, false);
            Ga.a(ih);
        }
    }
}

package com.tencent.mm.plugin.chatroom.d;

import android.util.Pair;
import com.tencent.mm.aa.j;
import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.acc;
import com.tencent.mm.protocal.c.acd;
import com.tencent.mm.protocal.c.my;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ay;
import com.tencent.mm.storage.u;
import java.util.LinkedList;
import java.util.List;

public final class i extends l implements k {
    private final String chatroomName;
    private int dYK;
    private final b diG;
    private e diJ = null;
    private int hLa = 0;

    public i(String str, int i) {
        int i2;
        a aVar = new a();
        aVar.dIG = new acc();
        aVar.dIH = new acd();
        aVar.uri = "/cgi-bin/micromsg-bin/getchatroommemberdetail";
        aVar.dIF = 551;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        this.chatroomName = str;
        au.HU();
        int ckK = c.Ga().ii(str).ckK();
        ((acc) this.diG.dID.dIL).rGL = str;
        acc acc = (acc) this.diG.dID.dIL;
        if (ckK < i) {
            i2 = i;
        } else {
            i2 = ckK;
        }
        acc.rgt = i2;
        x.i("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom chatroomName:%s, oldVer:%d, localVer:%d, stack[%s]", new Object[]{str, Integer.valueOf(i), Integer.valueOf(ckK), bi.cjd()});
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }

    public final int getType() {
        return 551;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        if (i2 == 0 && i3 == 0) {
            x.i("MicroMsg.NetSceneGetChatroomMemberDetail", "onGYNetEnd errType:%d, errCode:%d, errMsg:%s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
            acd acd = (acd) this.diG.dIE.dIL;
            au.HU();
            u ii = c.Ga().ii(this.chatroomName);
            long ckK = (long) ii.ckK();
            long j = 4294967295L & ((long) acd.hbC);
            String str2 = "MicroMsg.NetSceneGetChatroomMemberDetail";
            String str3 = "summerChatRoom svrVer:%d, modCnt:%d， localVer:%d";
            Object[] objArr = new Object[3];
            objArr[0] = Integer.valueOf(acd.hbC);
            objArr[1] = Integer.valueOf(acd.rGM == null ? 0 : acd.rGM.hLg);
            objArr[2] = Long.valueOf(ckK);
            x.i(str2, str3, objArr);
            if (ckK >= j) {
                x.e("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom localVer[%d] serverVer[%d] is new and return", new Object[]{Long.valueOf(ckK), Long.valueOf(j)});
                this.diJ.a(i2, i3, str, this);
                return;
            }
            int i4;
            final LinkedList linkedList;
            int i5 = acd.hbC;
            if (ii.b(ii.sOi)) {
                ii.ckJ();
            }
            ii.sOi.bUd = i5;
            try {
                ii.field_roomdata = ii.sOi.toByteArray();
            } catch (Throwable e) {
                x.e("MicroMsg.ChatRoomMember", "exception:%s", new Object[]{bi.i(e)});
            }
            u.ckM();
            if (acd.rGM == null) {
                List list = null;
            } else {
                Object list2 = acd.rGM.rqV;
            }
            String str4 = "MicroMsg.NetSceneGetChatroomMemberDetail";
            str2 = "summerChatRoom memInfoList size[%d]";
            Object[] objArr2 = new Object[1];
            objArr2[0] = Integer.valueOf(list2 == null ? -1 : list2.size());
            x.i(str4, str2, objArr2);
            str2 = com.tencent.mm.model.q.GF();
            if (ii.b(ii.sOi)) {
                ii.ckJ();
            }
            for (my myVar : list2) {
                if (ii.dNh.containsKey(myVar.hbL)) {
                    com.tencent.mm.i.a.a.b bVar = (com.tencent.mm.i.a.a.b) ii.dNh.get(myVar.hbL);
                    bVar.daA = myVar.rqY;
                    bVar.daB = myVar.rrb;
                    bVar.daC = myVar.rrc;
                }
            }
            ii.sOi.dav.clear();
            for (String str5 : ii.dNh.keySet()) {
                ii.sOi.dav.add(ii.dNh.get(str5));
            }
            ii.a(str2, ii.sOi, false);
            au.HU();
            c.Ga().a(ii);
            au.HU();
            ay FR = c.FR();
            com.tencent.mm.aa.k KH = com.tencent.mm.aa.q.KH();
            LinkedList linkedList2 = new LinkedList();
            LinkedList linkedList3 = new LinkedList();
            x.i("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom memInfoList size[%d]", new Object[]{Integer.valueOf(list2 == null ? -1 : list2.size())});
            if (((long) (list2 == null ? -1 : list2.size())) > HardCoderJNI.hcUpdateChatroomMemberCount) {
                i4 = 0;
            } else {
                int cij;
                boolean z = HardCoderJNI.hcUpdateChatroomEnable;
                int i6 = HardCoderJNI.hcUpdateChatroomDelay;
                int i7 = HardCoderJNI.hcUpdateChatroomCPU;
                int i8 = HardCoderJNI.hcUpdateChatroomIO;
                if (HardCoderJNI.hcUpdateChatroomThr) {
                    cij = g.Em().cij();
                } else {
                    cij = 0;
                }
                i4 = HardCoderJNI.startPerformance(z, i6, i7, i8, cij, HardCoderJNI.hcUpdateChatroomTimeout, 401, HardCoderJNI.hcUpdateChatroomAction, "MicroMsg.NetSceneGetChatroomMemberDetail");
            }
            this.dYK = i4;
            for (my myVar2 : list2) {
                if (!(bi.oW(myVar2.rra) || bi.oW(myVar2.hbL))) {
                    j kc = KH.kc(myVar2.hbL);
                    if (kc == null) {
                        kc = new j();
                        kc.username = myVar2.hbL;
                    } else {
                        kc.Ky().equals(myVar2.rra);
                    }
                    kc.dHR = myVar2.rqZ;
                    kc.dHQ = myVar2.rra;
                    kc.csA = 3;
                    kc.by(!bi.oW(myVar2.rqZ));
                    linkedList3.add(kc);
                }
                ab Yg = FR.Yg(myVar2.hbL);
                if (Yg == null) {
                    x.e("MicroMsg.NetSceneGetChatroomMemberDetail", "NetSceneGetChatroomMemberDetail memberlist username is null");
                } else if (Yg.Bz()) {
                    Yg.dx(myVar2.hcS);
                    linkedList2.add(new Pair(myVar2.hbL, Yg));
                }
            }
            x.d("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom update newImgFlagList size:%d, updateList size:%d", new Object[]{Integer.valueOf(linkedList3.size()), Integer.valueOf(linkedList2.size())});
            if (!linkedList3.isEmpty()) {
                this.hLa |= 1;
                linkedList = linkedList3;
                final com.tencent.mm.aa.k kVar = KH;
                new al(au.Em().lnJ.getLooper(), new al.a() {
                    public final boolean vD() {
                        int size = linkedList.size() < 25 ? linkedList.size() : 25;
                        x.d("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom update img list size:%d, loopCount:%d", new Object[]{Integer.valueOf(linkedList.size()), Integer.valueOf(size)});
                        if (size == 0) {
                            i.a(i.this, 1);
                            x.i("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom update img done loopCount is 0");
                            return false;
                        } else if (linkedList.isEmpty()) {
                            i.a(i.this, 1);
                            x.i("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom update img done newImgFlagList is empty");
                            return false;
                        } else {
                            long currentTimeMillis = System.currentTimeMillis();
                            au.HU();
                            long dO = c.FO().dO(Thread.currentThread().getId());
                            for (int i = 0; i < size; i++) {
                                j jVar = (j) linkedList.poll();
                                if (jVar == null) {
                                    break;
                                }
                                kVar.a(jVar);
                            }
                            au.HU();
                            c.FO().gp(dO);
                            x.d("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom update img loopCount:%d, take time:%d(ms)", new Object[]{Integer.valueOf(size), Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
                            if (!linkedList.isEmpty()) {
                                return true;
                            }
                            i.a(i.this, 1);
                            x.i("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom update img done newImgFlagList is empty");
                            return false;
                        }
                    }
                }, true).J(100, 100);
            }
            if (!linkedList2.isEmpty()) {
                this.hLa |= 2;
                linkedList = linkedList2;
                final ay ayVar = FR;
                new al(au.Em().lnJ.getLooper(), new al.a() {
                    public final boolean vD() {
                        int size = linkedList.size() < 25 ? linkedList.size() : 25;
                        x.d("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom update ctg list size:%d, loopCount:%d", new Object[]{Integer.valueOf(linkedList.size()), Integer.valueOf(size)});
                        if (size == 0) {
                            i.a(i.this, 2);
                            x.i("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom update ctg done loopCount is 0");
                            return false;
                        }
                        long currentTimeMillis = System.currentTimeMillis();
                        au.HU();
                        long dO = c.FO().dO(Thread.currentThread().getId());
                        for (int i = 0; i < size; i++) {
                            Pair pair = (Pair) linkedList.poll();
                            ayVar.a((String) pair.first, (ab) pair.second);
                        }
                        au.HU();
                        c.FO().gp(dO);
                        x.d("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom update ctg loopCount:%d, take time:%d(ms)", new Object[]{Integer.valueOf(size), Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
                        if (!linkedList.isEmpty()) {
                            return true;
                        }
                        i.a(i.this, 2);
                        x.i("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom update ctg done updateList is empty");
                        return false;
                    }
                }, true).J(100, 100);
            }
            this.diJ.a(i2, i3, str, this);
            return;
        }
        x.e("MicroMsg.NetSceneGetChatroomMemberDetail", "onGYNetEnd errType:%d, errCode:%d, errMsg:%s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        this.diJ.a(i2, i3, str, this);
    }
}

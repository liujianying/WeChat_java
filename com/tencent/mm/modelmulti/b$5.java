package com.tencent.mm.modelmulti;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.l;
import com.tencent.mm.ab.v.a;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.platformtools.ai;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.protocal.c.aby;
import com.tencent.mm.protocal.c.abz;
import com.tencent.mm.protocal.c.by;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;
import java.util.Collections;
import java.util.LinkedList;

class b$5 implements a {
    final /* synthetic */ b dYL;

    b$5(b bVar) {
        this.dYL = bVar;
    }

    public final int a(int i, int i2, String str, b bVar, l lVar) {
        x.i("MicroMsg.GetChatRoomMsgService", "summerbadcr callback [%d,%d,%s]", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        if (lVar.getType() != 805) {
            return 0;
        }
        this.dYL.dYJ.SO();
        f.mDy.a(403, 10, 1, false);
        this.dYL.dGS = false;
        if (i == 0 && i2 == 0 && bVar != null) {
            aby aby = (aby) bVar.dID.dIL;
            abz abz = (abz) bVar.dIE.dIL;
            String a = ab.a(aby.rGz);
            String str2;
            if (aby.rcr == 0) {
                String str3 = "MicroMsg.GetChatRoomMsgService";
                str2 = "summerbadcr clear chatroomId[%s], resp size[%d], ContinueFlag[%d]";
                Object[] objArr = new Object[3];
                objArr[0] = a;
                objArr[1] = Integer.valueOf(abz.rGE == null ? -1 : abz.rGE.size());
                objArr[2] = Integer.valueOf(abz.rlm);
                x.i(str3, str2, objArr);
                if (this.dYL.dSR.ciq()) {
                    this.dYL.dSR.J(500, 500);
                }
                f.mDy.a(403, 12, 1, false);
                return 0;
            }
            int cij;
            String str4;
            int i3;
            x.i("MicroMsg.GetChatRoomMsgService", "summerbadcr callback req chatroomId[%s], resp ContinueFlag[%d]", new Object[]{a, Integer.valueOf(abz.rlm)});
            b bVar2 = this.dYL;
            boolean z = HardCoderJNI.hcReceiveMsgEnable;
            int i4 = HardCoderJNI.hcReceiveMsgDelay;
            int i5 = HardCoderJNI.hcReceiveMsgCPU;
            int i6 = HardCoderJNI.hcReceiveMsgIO;
            if (HardCoderJNI.hcReceiveMsgThr) {
                cij = g.Em().cij();
            } else {
                cij = 0;
            }
            bVar2.dYK = HardCoderJNI.startPerformance(z, i4, i5, i6, cij, HardCoderJNI.hcReceiveMsgTimeout, 201, HardCoderJNI.hcReceiveMsgAction, "MicroMsg.GetChatRoomMsgService");
            synchronized (this.dYL.dYE) {
                if (this.dYL.dYG == null || ai.oW(this.dYL.dYG.PE())) {
                    this.dYL.dYE.clear();
                    this.dYL.dYG = null;
                    x.i("MicroMsg.GetChatRoomMsgService", "summerbadcr callback currentListener is or its chatroomid is null so clear map");
                    f.mDy.a(403, 15, 1, false);
                } else if (this.dYL.dYG.PE().equals(a)) {
                    f.mDy.a(403, 13, 1, false);
                    LinkedList linkedList = abz.rGE;
                    str4 = "MicroMsg.GetChatRoomMsgService";
                    String str5 = "summerbadcr callback currentListener still in and resp.ContinueFlag[%d], size[%d]";
                    Object[] objArr2 = new Object[2];
                    objArr2[0] = Integer.valueOf(abz.rlm);
                    objArr2[1] = Integer.valueOf(linkedList == null ? -1 : linkedList.size());
                    x.i(str4, str5, objArr2);
                    if (!(abz.rlm <= 0 || linkedList == null || linkedList.isEmpty())) {
                        i5 = ((by) linkedList.getFirst()).rcr;
                        i3 = ((by) linkedList.getLast()).rcr;
                        x.i("MicroMsg.GetChatRoomMsgService", "summerbadcr callback ContinueFlag[%d], list size[%d],firstSeq[%d], lastSeq[%d], UpDownFlag[%d]", new Object[]{Integer.valueOf(abz.rlm), Integer.valueOf(linkedList.size()), Integer.valueOf(i5), Integer.valueOf(i3), Integer.valueOf(aby.rGB)});
                    }
                } else {
                    x.i("MicroMsg.GetChatRoomMsgService", "summerbadcr callback currentListener changed current[%s], old[%s]", new Object[]{this.dYL.dYG.PE(), a});
                    f.mDy.a(403, 14, 1, false);
                }
            }
            if (this.dYL.dSR.ciq()) {
                this.dYL.dSR.J(500, 500);
            }
            if (abz.rGE == null || abz.rGE.isEmpty()) {
                f.mDy.a(403, 19, 1, false);
                str2 = "MicroMsg.GetChatRoomMsgService";
                str4 = "summerbadcr callback resp.AddMsgList is null[%b], empty[%b]";
                Object[] objArr3 = new Object[2];
                objArr3[0] = Boolean.valueOf(this.dYL.dSN == null);
                objArr3[1] = Boolean.valueOf(this.dYL.dSN != null ? this.dYL.dSN.isEmpty() : true);
                x.i(str2, str4, objArr3);
                if (abz.rlm == 0 && aby.rGB != 0) {
                    au.HU();
                    bd J = c.FT().J(a, (long) aby.rcr);
                    int i7;
                    if (J.field_msgSeq == ((long) aby.rcr)) {
                        i7 = J.field_flag;
                        x.i("MicroMsg.GetChatRoomMsgService", "summerbadcr callback resp.AddMsgList is empty reset Fault[%d, %d, %d, %d, %d, %d, %d]", new Object[]{Integer.valueOf(J.field_flag), Integer.valueOf(J.field_isSend), Long.valueOf(J.field_msgId), Long.valueOf(J.field_msgSvrId), Long.valueOf(J.field_msgSeq), Long.valueOf(J.field_createTime), Integer.valueOf(J.getType())});
                        if ((i7 & 1) != 0) {
                            long j;
                            J.fg(i7 & -2);
                            au.HU();
                            c.FT().a(J.field_msgId, J);
                            f fVar = f.mDy;
                            if (ai.bH(J.field_createTime) < 259200000) {
                                j = 36;
                            } else {
                                j = 37;
                            }
                            fVar.a(403, j, 1, false);
                        }
                    } else {
                        au.HU();
                        com.tencent.mm.storage.ai Yq = c.FW().Yq(a);
                        if (Yq != null) {
                            au.HU();
                            bd GF = c.FT().GF(a);
                            if (GF != null) {
                                x.i("MicroMsg.GetChatRoomMsgService", "summerbadcr callback resp.AddMsgList is empty need reset lastseq by last receive id[%d] svrid[%d], flag[%d] createtime[%d] seq[%d -> %d]", new Object[]{Long.valueOf(GF.field_msgId), Long.valueOf(GF.field_msgSvrId), Integer.valueOf(GF.field_flag), Long.valueOf(GF.field_createTime), Long.valueOf(Yq.field_lastSeq), Long.valueOf(GF.field_msgSeq)});
                                Yq.au(GF.field_msgSeq);
                            } else {
                                x.i("MicroMsg.GetChatRoomMsgService", "summerbadcr callback resp.AddMsgList is empty but no receive msg!");
                                Yq.au(0);
                            }
                            Yq.fc(0);
                            au.HU();
                            i7 = c.FW().a(Yq, Yq.field_username, false);
                            x.i("MicroMsg.GetChatRoomMsgService", "summerbadcr callback resp.AddMsgList is empty and update conv ret:%d", new Object[]{Integer.valueOf(i7)});
                        } else {
                            x.i("MicroMsg.GetChatRoomMsgService", "summerbadcr callback resp.AddMsgList but conv is null!");
                        }
                    }
                }
            } else {
                boolean z2;
                boolean z3;
                b$b b_b = new b$b(this.dYL);
                b_b.dYN = a;
                b_b.dYR = aby.rGB;
                b_b.dYU = abz.rlm;
                if (abz.rlm == 0) {
                    b_b.dYT = false;
                    f.mDy.a(403, 21, 1, false);
                } else {
                    f.mDy.a(403, 20, 1, false);
                }
                au.HU();
                com.tencent.mm.storage.ai Yq2 = c.FW().Yq(a);
                if (aby.rGB != 0) {
                    f.mDy.a(403, 18, (long) abz.rGE.size(), false);
                    i4 = (Yq2 == null ? 0 : Yq2.field_UnDeliverCount) - abz.rGE.size();
                    if (i4 < 0) {
                        i4 = 0;
                    }
                    if (Yq2 != null) {
                        Yq2.fc(i4);
                        au.HU();
                        i5 = c.FW().a(Yq2, Yq2.field_username, false);
                        x.i("MicroMsg.GetChatRoomMsgService", "summerbadcr callback up and FilterSeq 0 but NeedCount:%d, oldUnDeliverCount:%d, newUnDeliverCount:%d, ret:%d", new Object[]{Integer.valueOf(aby.rGA), Integer.valueOf(i3), Integer.valueOf(Yq2.field_UnDeliverCount), Integer.valueOf(i5)});
                    }
                    if (Yq2 == null && i4 == 0) {
                        b_b.dYT = false;
                    }
                } else {
                    if (aby.rGD <= 0 || aby.rGD != aby.rcr) {
                        f.mDy.a(403, 16, (long) abz.rGE.size(), false);
                    } else {
                        f.mDy.a(403, 17, (long) abz.rGE.size(), false);
                    }
                    if (Yq2 != null) {
                        i4 = Yq2.field_UnDeliverCount;
                        if (i4 > 0) {
                            i3 = i4 - abz.rGE.size();
                            if (i3 < 0) {
                                i3 = 0;
                            }
                            Yq2.fc(i3);
                            au.HU();
                            i3 = c.FW().a(Yq2, Yq2.field_username, false);
                            x.i("MicroMsg.GetChatRoomMsgService", "summerbadcr callback down NeedCount:%d, oldUnDeliverCount:%d, newUnDeliverCount:%d, ret:%d", new Object[]{Integer.valueOf(aby.rGA), Integer.valueOf(i4), Integer.valueOf(Yq2.field_UnDeliverCount), Integer.valueOf(i3)});
                        }
                    }
                }
                au.HU();
                i5 = (int) c.Gx().Gv(a);
                z = false;
                if (i5 != 0) {
                    while (true) {
                        z2 = z;
                        if (abz.rGE.isEmpty() || ((by) abz.rGE.peek()).rcr > i5) {
                            break;
                        }
                        abz.rGE.poll();
                        z = true;
                    }
                } else {
                    z2 = false;
                }
                if (z2) {
                    b_b.dYT = false;
                }
                if (aby.rGB == 0 || abz.rGE.isEmpty()) {
                    z3 = false;
                } else {
                    z3 = true;
                }
                if (abz.rGE.size() > 1 && z3) {
                    Collections.reverse(abz.rGE);
                }
                if (!abz.rGE.isEmpty()) {
                    b_b.dYS = abz.rGE;
                    this.dYL.dSN.add(b_b);
                    x.i("MicroMsg.GetChatRoomMsgService", "summerbadcr callback add resp to respList size[%d], dealFault[%b], lastDeleteSeq[%d], needReverse[%b], removed[%b]", new Object[]{Integer.valueOf(this.dYL.dSN.size()), Boolean.valueOf(b_b.dYT), Integer.valueOf(i5), Boolean.valueOf(z3), Boolean.valueOf(z2)});
                }
            }
            if (this.dYL.dSN.isEmpty() || !this.dYL.dSS.ciq()) {
                if (this.dYL.dYG != null) {
                    x.i("MicroMsg.GetChatRoomMsgService", "summerbadcr callback resp.AddMsgList is empty[%b] stopped[%b] at last", new Object[]{Boolean.valueOf(this.dYL.dSN.isEmpty()), Boolean.valueOf(this.dYL.dSS.ciq())});
                    this.dYL.dYG.ia(1);
                }
                HardCoderJNI.stopPerformace(HardCoderJNI.hcReceiveMsgEnable, this.dYL.dYK);
            } else {
                this.dYL.dSS.J(50, 50);
            }
            return 0;
        }
        x.e("MicroMsg.GetChatRoomMsgService", "summerbadcr callback errType:" + i + " errCode:" + i2 + " will retry");
        if (this.dYL.dYG != null) {
            x.e("MicroMsg.GetChatRoomMsgService", "summerbadcr callback err as ret errType, errcode[%d, %d]", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
            this.dYL.dYG.ia(1);
        }
        f.mDy.a(403, 11, 1, false);
        this.dYL.dSR.J(5000, 5000);
        return 0;
    }
}

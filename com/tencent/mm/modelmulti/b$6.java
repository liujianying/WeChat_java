package com.tencent.mm.modelmulti;

import com.tencent.mm.ab.d;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.modelmulti.b.b;
import com.tencent.mm.platformtools.ai;
import com.tencent.mm.plugin.bbom.r;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.protocal.c.by;
import com.tencent.mm.sdk.platformtools.al.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;
import java.util.HashMap;
import java.util.LinkedList;

class b$6 implements a {
    final /* synthetic */ b dYL;
    private h dYM;

    b$6(b bVar) {
        this.dYL = bVar;
    }

    public final boolean vD() {
        au.HU();
        c.FT().Gz("MicroMsg.GetChatRoomMsgService" + this.dYL.hashCode());
        if (this.dYL.dSN.isEmpty()) {
            x.i("MicroMsg.GetChatRoomMsgService", "summerbadcr respHandler queue maybe this time is null and return!");
            au.HU();
            c.FT().GA("MicroMsg.GetChatRoomMsgService" + this.dYL.hashCode());
            HardCoderJNI.stopPerformace(HardCoderJNI.hcReceiveMsgEnable, this.dYL.dYK);
            return false;
        }
        boolean z;
        long VF = ai.VF();
        int i = (this.dYL.dGS ? 9 : 18) + 1;
        x.i("MicroMsg.GetChatRoomMsgService", "summerbadcr respHandler start maxCnt[%d]", new Object[]{Integer.valueOf(i)});
        int i2 = 0;
        while (i2 < i) {
            b bVar = (b) this.dYL.dSN.peek();
            if (bVar == null) {
                x.i("MicroMsg.GetChatRoomMsgService", "summerbadcr respHandler queue maybe this time is null and break! currentListener[%s]", new Object[]{this.dYL.dYG});
                au.HU();
                c.FT().GA("MicroMsg.GetChatRoomMsgService" + this.dYL.hashCode());
                z = false;
                if (this.dYL.dYG != null) {
                    this.dYL.dYG.ia(0);
                }
                HardCoderJNI.stopPerformace(HardCoderJNI.hcReceiveMsgEnable, this.dYL.dYK);
                this.dYL.dSR.J(0, 0);
            } else {
                LinkedList linkedList = bVar.dYS;
                int size = linkedList.size();
                int i3 = size - 1;
                int i4 = bVar.dTa;
                if (size <= i4) {
                    this.dYL.dSN.poll();
                    if (this.dYL.dSN.isEmpty()) {
                        b.f(new HashMap(this.dYL.dYH), bVar.dYN);
                        au.HU();
                        c.FT().GA("MicroMsg.GetChatRoomMsgService" + this.dYL.hashCode());
                        String str = "MicroMsg.GetChatRoomMsgService";
                        String str2 = "summerbadcr respHandler resp proc fin gr.curIdx:%d size:%d and retList is empty break currentListener[%s], needCallBack[%b]";
                        Object[] objArr = new Object[4];
                        objArr[0] = Integer.valueOf(i4);
                        objArr[1] = Integer.valueOf(size);
                        objArr[2] = this.dYL.dYG;
                        objArr[3] = Boolean.valueOf(this.dYL.dYG == null ? false : this.dYL.dYG.PF());
                        x.i(str, str2, objArr);
                        z = false;
                        if (this.dYL.dYG != null) {
                            this.dYL.dYG.ia(0);
                        }
                        this.dYL.dSR.J(0, 0);
                    } else {
                        x.i("MicroMsg.GetChatRoomMsgService", "summerbadcr respHandler resp proc fin gr.curIdx:%d size:%d and retList is not empty continue next", new Object[]{Integer.valueOf(i4), Integer.valueOf(size)});
                    }
                } else {
                    by byVar = (by) linkedList.get(i4);
                    x.d("MicroMsg.GetChatRoomMsgService", "summerbadcr respHandler process curIdx[%d] last[%d] dealFault[%b] MsgSeq[%d], CreateTime[%d], MsgType[%d]", new Object[]{Integer.valueOf(i4), Integer.valueOf(i3), Boolean.valueOf(bVar.dYT), Integer.valueOf(byVar.rcr), Integer.valueOf(byVar.lOH), Integer.valueOf(byVar.jQd)});
                    boolean z2 = false;
                    int i5 = -1;
                    if (bVar.dYT && i4 == i3) {
                        if (bVar.dYU != 0) {
                            boolean z3 = true;
                            au.HU();
                            bd J = c.FT().J(bVar.dYN, (long) byVar.rcr);
                            if (bVar.dYR == 0 && (J.field_flag & 4) != 0) {
                                au.HU();
                                com.tencent.mm.storage.ai Yq = c.FW().Yq(bVar.dYN);
                                if (Yq != null && Yq.field_UnDeliverCount == 0) {
                                    z3 = false;
                                    x.i("MicroMsg.GetChatRoomMsgService", "summerbadcr respHandler process existed 1 curIdx == last[%d], MsgSeq[%d], flag[%d]", new Object[]{Integer.valueOf(i4), Long.valueOf(J.field_msgSeq), Integer.valueOf(J.field_flag)});
                                }
                            }
                            z2 = z3;
                        } else {
                            au.HU();
                            if (c.FT().J(bVar.dYN, (long) byVar.rcr).field_msgId == 0) {
                                au.HU();
                                com.tencent.mm.storage.ai Yq2 = c.FW().Yq(bVar.dYN);
                                if (Yq2 == null) {
                                    z2 = true;
                                } else {
                                    int i6;
                                    if ((bVar.dYR == 0 || Yq2.field_firstUnDeliverSeq == ((long) byVar.rcr)) && (bVar.dYR != 0 || Yq2.field_lastSeq == ((long) byVar.rcr))) {
                                        i6 = -1;
                                    } else {
                                        i6 = Yq2.field_UnDeliverCount;
                                        z2 = true;
                                    }
                                    i5 = i6;
                                }
                            } else {
                                x.i("MicroMsg.GetChatRoomMsgService", "summerbadcr respHandler process existed 2 curIdx == last[%d], MsgSeq[%d], flag[%d]", new Object[]{Integer.valueOf(i4), Long.valueOf(c.FT().J(bVar.dYN, (long) byVar.rcr).field_msgSeq), Integer.valueOf(c.FT().J(bVar.dYN, (long) byVar.rcr).field_flag)});
                            }
                        }
                    }
                    x.i("MicroMsg.GetChatRoomMsgService", "summerbadcr respHandler process fault[%b] curIdx[%d] last[%d], upFlag[%d]，MsgSeq[%d]", new Object[]{Boolean.valueOf(z2), Integer.valueOf(i4), Integer.valueOf(i3), Integer.valueOf(bVar.dYR), Integer.valueOf(byVar.rcr)});
                    if (this.dYM == null) {
                        this.dYM = (h) g.l(h.class);
                    }
                    this.dYM.a(new d.a(byVar, true, z2, bVar.dYR != 0), new r(true));
                    if (z2 && i5 == 0 && size > 1 && bVar.dYR == 0) {
                        au.HU();
                        bd J2 = c.FT().J(bVar.dYN, (long) byVar.rcr);
                        i5 = J2.field_flag;
                        long j = J2.field_createTime;
                        x.i("MicroMsg.GetChatRoomMsgService", "summerbadcr respHandler process check fault meet size[%d], seq[%d], flag[%d], creatTime[%d]", new Object[]{Integer.valueOf(size), Integer.valueOf(byVar.rcr), Integer.valueOf(i5), Long.valueOf(j)});
                        if ((i5 & 4) == 0) {
                            au.HU();
                            bd J3 = c.FT().J(bVar.dYN, (long) (byVar.rcr + 1));
                            if (J3.field_msgId == 0 || J3.field_msgSeq != ((long) (byVar.rcr + 1))) {
                                x.i("MicroMsg.GetChatRoomMsgService", "summerbadcr respHandler process check fault meet nextinfo is null[%b], id[%d], seq[%d]", new Object[]{Boolean.valueOf(false), Long.valueOf(J3.field_msgId), Long.valueOf(J3.field_msgSeq)});
                            } else {
                                x.i("MicroMsg.GetChatRoomMsgService", "summerbadcr respHandler process check fault meet seq[%d], creatTime[%d], flag[%d]", new Object[]{Long.valueOf(J3.field_msgSeq), Long.valueOf(J3.field_createTime), Integer.valueOf(J3.field_flag)});
                                if ((J3.field_flag & 4) != 0) {
                                    J2.fg(J2.field_flag & -2);
                                    au.HU();
                                    c.FT().a(J2.field_msgId, J2);
                                    J3.fg(J3.field_flag & -2);
                                    au.HU();
                                    c.FT().a(J3.field_msgId, J3);
                                    x.i("MicroMsg.GetChatRoomMsgService", "summerbadcr respHandler process check fault meet update succ!");
                                    f.mDy.a(403, 34, 1, false);
                                }
                            }
                        }
                    }
                    bVar.dTa++;
                }
                i2++;
            }
            x.i("MicroMsg.GetChatRoomMsgService", "summerbadcr respHandler onTimerExpired netSceneRunning:" + this.dYL.dGS + " ret:" + z + " maxCnt:" + i + " take:" + (ai.VF() - VF) + "ms");
            return z;
        }
        z = true;
        x.i("MicroMsg.GetChatRoomMsgService", "summerbadcr respHandler onTimerExpired netSceneRunning:" + this.dYL.dGS + " ret:" + z + " maxCnt:" + i + " take:" + (ai.VF() - VF) + "ms");
        return z;
    }
}

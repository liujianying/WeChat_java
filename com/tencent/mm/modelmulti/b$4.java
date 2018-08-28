package com.tencent.mm.modelmulti;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.v;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.modelmulti.b.5;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.platformtools.ai;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.protocal.c.aby;
import com.tencent.mm.protocal.c.abz;
import com.tencent.mm.sdk.platformtools.al.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;
import java.util.LinkedList;

class b$4 implements a {
    final /* synthetic */ b dYL;

    b$4(b bVar) {
        this.dYL = bVar;
    }

    public final boolean vD() {
        x.i("MicroMsg.GetChatRoomMsgService", "summerbadcr pusherTry onTimerExpired tryStartNetscene");
        b bVar = this.dYL;
        long VF = ai.VF();
        if (bVar.dGS && VF - bVar.dHc > 300000) {
            x.w("MicroMsg.GetChatRoomMsgService", "summerbadcr tryStartNetscene Not Callback too long:%d . Force Run Now", new Object[]{Long.valueOf(VF - bVar.dHc)});
            bVar.dGS = false;
        }
        if (bVar.dGS) {
            x.i("MicroMsg.GetChatRoomMsgService", "summerbadcr tryStartNetscene netSceneRunning: " + bVar.dGS + " ret");
        } else {
            b.a aVar;
            String str = null;
            b.a aVar2 = null;
            if (!bVar.dYF.isEmpty()) {
                aVar = (b.a) bVar.dYF.poll();
                str = aVar.dYN;
                aVar2 = aVar;
            }
            if (aVar2 == null) {
                synchronized (bVar.dYE) {
                    x.i("MicroMsg.GetChatRoomMsgService", "summerbadcr tryStartNetscene needGetInfosMap size[%d], content[%s]", new Object[]{Integer.valueOf(bVar.dYE.size()), bVar.dYE});
                    if (bVar.dYG == null || ai.oW(bVar.dYG.PE())) {
                        bVar.dYE.clear();
                        bVar.dYG = null;
                        x.i("MicroMsg.GetChatRoomMsgService", "summerbadcr tryStartNetscene currentListener is or its chatroomid is null ret");
                    } else {
                        str = bVar.dYG.PE();
                        LinkedList linkedList = (LinkedList) bVar.dYE.get(str);
                        if (linkedList == null || linkedList.size() == 0) {
                            String str2 = "MicroMsg.GetChatRoomMsgService";
                            String str3 = "summerbadcr tryStartNetscene current talker[%s] no infos and ret infos size:%d";
                            Object[] objArr = new Object[2];
                            objArr[0] = str;
                            objArr[1] = Integer.valueOf(linkedList == null ? -1 : linkedList.size());
                            x.i(str2, str3, objArr);
                        } else {
                            while (!linkedList.isEmpty()) {
                                b.a aVar3 = (b.a) linkedList.poll();
                                if (aVar3 == null) {
                                    break;
                                }
                                au.HU();
                                bd J = c.FT().J(str, (long) aVar3.dYP);
                                if (J.field_msgId == 0) {
                                    x.i("MicroMsg.GetChatRoomMsgService", "summerbadcr tryStartNetscene get nextInfo in map not in db:" + aVar3);
                                    aVar = aVar3;
                                    break;
                                } else if ((J.field_flag & 1) != 0) {
                                    x.i("MicroMsg.GetChatRoomMsgService", "summerbadcr tryStartNetscene get nextInfo in map in db but fault: " + aVar3 + " flag:" + J.field_flag + " seq:" + J.field_msgSeq);
                                    aVar = aVar3;
                                    break;
                                } else if (aVar3.dYR == 0) {
                                    x.i("MicroMsg.GetChatRoomMsgService", "summerbadcr tryStartNetscene get nextInfo in map in db not fault but down history: " + aVar3 + " flag:" + J.field_flag + " seq:" + J.field_msgSeq);
                                    aVar = aVar3;
                                    break;
                                } else {
                                    x.i("MicroMsg.GetChatRoomMsgService", "summerbadcr tryStartNetscene get nextInfo in map in db but not fault: " + aVar3 + " flag:" + J.field_flag + " seq:" + J.field_msgSeq);
                                }
                            }
                            aVar = aVar2;
                            if (aVar == null && !ai.oW(str)) {
                                au.HU();
                                com.tencent.mm.storage.ai Yq = c.FW().Yq(str);
                                if (Yq != null) {
                                    long j = Yq.field_lastSeq;
                                    long j2 = Yq.field_firstUnDeliverSeq;
                                    int i = Yq.field_UnDeliverCount;
                                    x.i("MicroMsg.GetChatRoomMsgService", "summerbadcr tryStartNetscene filterSeq[%d], lastSeq[%d], undeliverCount[%d]", new Object[]{Long.valueOf(j2), Long.valueOf(j), Integer.valueOf(i)});
                                    if (j != 0) {
                                        au.HU();
                                        if (c.FT().J(str, j).field_msgId == 0) {
                                            aVar = new b.a(str, (int) j2, (int) j, i, 1);
                                            x.i("MicroMsg.GetChatRoomMsgService", "summerbadcr tryStartNetscene get nextInfo in db:" + aVar);
                                        } else {
                                            if (i > 0) {
                                                Yq.eV(0);
                                                au.HU();
                                                c.FW().a(Yq, str);
                                            }
                                            x.i("MicroMsg.GetChatRoomMsgService", "summerbadcr tryStartNetscene get nextInfo in db but has get msg id:%d, svrId:%d, undeliverCount[%d]", new Object[]{Long.valueOf(r5.field_msgId), Long.valueOf(r5.field_msgSvrId), Integer.valueOf(Yq.field_UnDeliverCount)});
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            } else {
                aVar = aVar2;
            }
            x.i("MicroMsg.GetChatRoomMsgService", "summerbadcr tryStartNetscene nextInfo:" + aVar);
            if (aVar == null) {
                bVar.dSR.J(500, 500);
            } else {
                bVar.dGS = true;
                bVar.dHc = VF;
                aby aby = new aby();
                aby.rGz = ab.oT(str);
                aby.rcr = aVar.dYP;
                if (aVar.dYP == 0) {
                    aby.rGA = 0;
                    if (aVar.dYQ != 0) {
                        x.w("MicroMsg.GetChatRoomMsgService", "summerbadcr tryStartNetscene msgSeq is 0 but needCount[%d], stack[%s]!", new Object[]{Integer.valueOf(aVar.dYQ), ai.VI()});
                    }
                } else {
                    aby.rGA = 18;
                }
                aby.rGB = aVar.dYR;
                aby.rGD = aVar.dYO;
                if ((aby.rGB != 0 && aby.rGD > aby.rcr) || (aby.rGB == 0 && aby.rGD < aby.rcr)) {
                    x.w("MicroMsg.GetChatRoomMsgService", "summerbadcr tryStartNetscene FilterSeq msgSeq UpDownFlag not match[%d][%d][%d], stack[%s]!", new Object[]{Integer.valueOf(aby.rGD), Integer.valueOf(aby.rcr), Integer.valueOf(aby.rGB), ai.VI()});
                    f.mDy.a(403, aby.rGB == 0 ? 0 : 1, 1, false);
                    int i2 = aby.rGD;
                    aby.rGD = aby.rcr;
                    aby.rcr = i2;
                }
                if (aby.rGB != 0 && aby.rGD == 0 && aVar.dYQ < 18) {
                    if (aVar.dYQ > 0) {
                        aby.rGA = aVar.dYQ;
                    } else {
                        aby.rGA = 1;
                        f.mDy.a(403, 3, 1, false);
                    }
                    x.i("MicroMsg.GetChatRoomMsgService", "summerbadcr tryStartNetscene UpDownFlag FilterSeq 0 fix need nextInfo: %d req: %d", new Object[]{Integer.valueOf(aVar.dYQ), Integer.valueOf(aby.rGA)});
                }
                x.i("MicroMsg.GetChatRoomMsgService", "summerbadcr tryStartNetscene FilterSeq[%d], MsgSeq[%d], NeedCount[%d], UpDownFlag[%d], ClearFlag[%d]", new Object[]{Integer.valueOf(aby.rGD), Integer.valueOf(aby.rcr), Integer.valueOf(aby.rGA), Integer.valueOf(aby.rGB), Integer.valueOf(aby.rGC)});
                b.a aVar4 = new b.a();
                aVar4.dIG = aby;
                aVar4.dIH = new abz();
                aVar4.uri = "/cgi-bin/micromsg-bin/getcrmsg";
                aVar4.dIF = 805;
                aVar4.dII = 0;
                aVar4.dIJ = 0;
                f.mDy.a(403, aby.rcr == 0 ? 9 : 8, 1, false);
                v.a(aVar4.KT(), new 5(bVar), true);
                bVar.dYJ.J(5000, 5000);
            }
        }
        return false;
    }
}

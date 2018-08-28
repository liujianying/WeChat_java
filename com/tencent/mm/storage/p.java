package com.tencent.mm.storage;

import com.tencent.mm.ac.a.c;
import com.tencent.mm.ac.a.j;
import com.tencent.mm.ac.o;
import com.tencent.mm.ac.z;
import com.tencent.mm.kernel.g;
import com.tencent.mm.l.a;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.biz.b.b;
import com.tencent.mm.plugin.messenger.foundation.a.e;
import com.tencent.mm.plugin.messenger.foundation.a.f;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;

public final class p implements e, f {
    private az sNS;

    public p(az azVar) {
        z.Nm();
        this.sNS = azVar;
        this.sNS.a(this);
        this.sNS.a(this);
    }

    public final void a(bd bdVar, ai aiVar) {
        String str = null;
        if (aiVar != null && bdVar != null && bdVar.field_bizChatId != -1 && aiVar.gh(8388608)) {
            c ak = z.Na().ak(bdVar.field_bizChatId);
            String str2 = aiVar.field_digest;
            if (bi.oW(bdVar.field_bizChatUserId)) {
                x.w("MicroMsg.BizConversationStorage", "BizChatUserId is null:%s %s", new Object[]{ak.field_bizChatServId, ak.field_chatName});
                return;
            }
            String str3;
            j cz = z.Nc().cz(bdVar.field_bizChatUserId);
            if (cz != null) {
                str3 = cz.field_userName;
            } else {
                str3 = null;
            }
            boolean equals = bdVar.field_bizChatUserId.equals(z.Nc().cA(bdVar.field_talker));
            if (cz != null && equals) {
                aiVar.ed(ad.getContext().getString(b.app_me) + ":" + str2);
            } else if (!(cz == null || bi.oW(cz.field_userName))) {
                aiVar.ed(cz.field_userName + ":" + str2);
            }
            if (!ak.isGroup()) {
                if (equals || str3 == null || str3.length() <= 0 || str3.equals(ak.field_chatName)) {
                    j cz2 = z.Nc().cz(ak.field_bizChatServId);
                    if (cz2 != null) {
                        str = cz2.field_userName;
                    }
                    if (str != null && str.length() > 0 && !str.equals(ak.field_chatName)) {
                        ak.field_chatName = str;
                        z.Na().b(ak);
                        return;
                    }
                    return;
                }
                ak.field_chatName = str3;
                z.Na().b(ak);
            }
        }
    }

    public final void a(bd bdVar, ai aiVar, boolean z, com.tencent.mm.plugin.messenger.foundation.a.a.f.c cVar) {
        if (cVar == null) {
            x.e("MicroMsg.BizConversationStorage", "compose notifyInfo is null");
            return;
        }
        String str = cVar.talker;
        if (z) {
            if (!(bdVar == null || bdVar.field_isSend == 1 || (bf.k(bdVar) & 1) == 0)) {
                x.i("MicroMsg.BizConversationStorage", "create a temp session conversation.");
                aiVar.gf(4194304);
            }
            if (bdVar != null && com.tencent.mm.ac.f.eZ(str)) {
                x.i("MicroMsg.BizConversationStorage", "create a bitChat conversation.");
                aiVar.gf(8388608);
            }
        } else {
            ab Yg = ((i) g.l(i.class)).FR().Yg(str);
            if (!(Yg == null || !Yg.ckW() || a.gd(Yg.field_type) || bdVar == null || bdVar.field_isSend == 1 || aiVar.gh(4194304) || (aiVar.field_conversationTime >= z.Nm() && (bf.k(bdVar) & 1) == 0))) {
                aiVar.gf(4194304);
                x.i("MicroMsg.BizConversationStorage", "onNotifyChange is old temp session, %s", new Object[]{str});
            }
            if (bdVar != null && com.tencent.mm.ac.f.eZ(str)) {
                x.i("MicroMsg.BizConversationStorage", "onNotifyChange a bitChat conversation, %s", new Object[]{str});
                aiVar.gf(8388608);
            }
        }
        if (cVar != null && !cVar.lcy.isEmpty() && cVar.lcy.get(0) != null) {
            aiVar.eX(((bd) cVar.lcy.get(0)).field_isSend);
            if (cVar.lcx.equals("insert")) {
                aiVar.tay = (bd) cVar.lcy.get(cVar.lcy.size() - 1);
            }
        }
    }

    public final void b(bd bdVar, ai aiVar, boolean z, com.tencent.mm.plugin.messenger.foundation.a.a.f.c cVar) {
        int i;
        int i2;
        az FW = ((i) g.l(i.class)).FW();
        String str = cVar == null ? null : cVar.talker;
        if (cVar == null || !cVar.lcx.equals("delete") || cVar.lcB <= 0) {
            i = 0;
        } else {
            i = cVar.lcB;
        }
        if (cVar == null || !cVar.lcx.equals("insert") || cVar.lcA <= 0) {
            i2 = 0;
        } else {
            i2 = cVar.lcA;
        }
        if (!bi.oW(aiVar.field_parentRef)) {
            ai Yq = FW.Yq(aiVar.field_parentRef);
            if (Yq != null && Yq.gh(2097152)) {
                if (i2 > 0) {
                    if ((cVar.lcx.equals("insert") && cVar.lcz > 0) || (cVar.lcx.equals("update") && Yq.field_unReadCount + cVar.lcz >= 0)) {
                        ab Yg = ((i) g.l(i.class)).FR().Yg(str);
                        if (Yg == null || !Yg.BD()) {
                            Yq.eV(Yq.field_unReadCount + i2);
                        } else {
                            Yq.fb(Yq.field_unReadMuteCount + i2);
                        }
                    }
                    FW.a(aiVar, i, i2);
                }
                bd GE = ((i) g.l(i.class)).bcY().GE(((i) g.l(i.class)).FW().YD(aiVar.field_parentRef));
                if (GE == null || GE.field_msgId <= 0) {
                    Yq.clx();
                } else {
                    Yq.aj(GE);
                    Yq.setContent(GE.field_talker + ":" + GE.field_content);
                    Yq.ec(Integer.toString(GE.getType()));
                    if (FW.vu() != null) {
                        PString pString = new PString();
                        PString pString2 = new PString();
                        PInt pInt = new PInt();
                        GE.ep(aiVar.field_parentRef);
                        GE.setContent(Yq.field_content);
                        FW.vu().a(GE, pString, pString2, pInt, true);
                        String aZ = FW.aZ(GE.getType(), GE.field_content);
                        Yq.ed(bi.oV(pString.value).concat(bi.oW(aZ) ? "" : " " + bi.oV(aZ)));
                        Yq.ee(pString2.value);
                        Yq.eY(pInt.value);
                    }
                }
                if (FW.a(Yq, aiVar.field_parentRef) > 0) {
                    x.d("MicroMsg.BizConversationStorage", "hakon update parent conversation's unread %s, %d", new Object[]{aiVar.field_parentRef, Integer.valueOf(Yq.field_unReadCount + i2)});
                    FW.b(3, (m) FW, aiVar.field_parentRef);
                }
            } else if (Yq == null || !"officialaccounts".equals(Yq.field_username)) {
                if (Yq != null && "appbrandcustomerservicemsg".equals(Yq.field_username) && i2 > 0) {
                    if ((cVar.lcx.equals("insert") && cVar.lcz > 0) || (cVar.lcx.equals("update") && Yq.field_unReadCount + cVar.lcz >= 0)) {
                        Yq.eV(Yq.field_unReadCount + i2);
                    }
                    FW.a(aiVar, i, i2);
                    FW.a(Yq, aiVar.field_parentRef);
                }
            } else if (i2 > 0 && !s.auK() && ((cVar.lcx.equals("insert") && cVar.lcz > 0) || (cVar.lcx.equals("update") && Yq.field_unReadCount + cVar.lcz >= 0))) {
                Yq.eV(Yq.field_unReadCount + i2);
                FW.a(Yq, aiVar.field_parentRef);
            }
        }
        a(str, aiVar, i2, i, cVar);
    }

    private void a(String str, ai aiVar, int i, int i2, com.tencent.mm.plugin.messenger.foundation.a.a.f.c cVar) {
        if (aiVar != null && cVar != null && cVar.hpD != -1 && aiVar.gh(8388608)) {
            bd aq = ((o) g.l(o.class)).FU().aq(str, cVar.hpD);
            com.tencent.mm.ac.a.a bd = z.Nb().bd(cVar.hpD);
            c ak = z.Na().ak(cVar.hpD);
            if (ak.field_bizChatServId == null) {
                x.w("MicroMsg.BizConversationStorage", "willen updateBizChatConversation bizChatInfo == null");
            } else if (aq == null || aq.field_msgId == 0) {
                x.i("MicroMsg.BizConversationStorage", "update null BizChatConversation with talker " + str);
                bd.field_status = 0;
                bd.field_isSend = 0;
                bd.field_content = "";
                bd.field_msgType = "0";
                bd.field_unReadCount = 0;
                bd.field_digest = "";
                bd.field_digestUser = "";
                z.Nb();
                com.tencent.mm.ac.a.b.a(bd, i2, i);
                z.Nb().b(bd);
            } else {
                com.tencent.mm.ac.a.a aVar;
                long j;
                Object obj;
                int i3;
                String cA;
                Iterator it;
                Object obj2;
                boolean isGroup = ak.isGroup();
                bd.field_brandUserName = str;
                if (aq.cmh()) {
                    bd.field_content = aq.cmH();
                } else {
                    bd.field_content = aq.field_content;
                }
                PString pString = new PString();
                this.sNS.vu().a(aq, pString, new PString(), new PInt(), false);
                String str2 = pString.value;
                j cz = z.Nc().cz(aq.field_bizChatUserId);
                if (!isGroup) {
                    bd.field_digest = str2;
                    str2 = null;
                } else if (aq.field_isSend == 1 && cz != null) {
                    bd.field_digest = ad.getContext().getString(b.app_me) + ":" + str2;
                    cz.field_userName = ad.getContext().getString(b.app_me);
                    str2 = null;
                } else if (cz == null || bi.oW(cz.field_userName)) {
                    bd.field_digest = str2;
                    str2 = null;
                } else {
                    bd.field_digest = cz.field_userName + ":" + str2;
                    str2 = cz.field_userName;
                }
                String aZ = this.sNS.aZ(aq.getType(), aq.field_content);
                bd.field_digest = bi.oV(bd.field_digest).concat(bi.oW(aZ) ? "" : " " + bi.oV(aZ));
                bd.field_digestUser = "";
                bd.field_chatType = ak.field_chatType;
                bd.field_lastMsgID = aq.field_msgId;
                if (aq.cmk()) {
                    aVar = bd;
                } else if (aq.field_status == 1) {
                    j = Long.MAX_VALUE;
                    aVar = bd;
                    aVar.field_lastMsgTime = j;
                    bd.field_status = aq.field_status;
                    bd.field_isSend = aq.field_isSend;
                    bd.field_msgType = Integer.toString(aq.getType());
                    bd.field_flag = com.tencent.mm.ac.a.b.a(bd, 1, aq.field_createTime);
                    obj = null;
                    if ((cVar.lcx.equals("insert") && cVar.lcz > 0) || (cVar.lcx.equals("update") && bd.field_unReadCount + cVar.lcz >= 0)) {
                        bd.field_unReadCount += cVar.lcz;
                        bd.field_newUnReadCount += cVar.lcz;
                        if (cVar.lcz > 0 && ak.hu(1)) {
                            i3 = aiVar.field_unReadCount - cVar.lcz;
                            if (i3 > 0) {
                                aiVar.eV(0);
                            } else {
                                aiVar.eV(i3);
                            }
                            aiVar.fb(aiVar.field_unReadMuteCount + cVar.lcz);
                            obj = 1;
                        }
                    }
                    if (cVar.lcx.equals("insert") && cVar.lcy.size() > 0 && ak.isGroup()) {
                        cA = z.Nc().cA(aq.field_talker);
                        it = cVar.lcy.iterator();
                        while (true) {
                            obj2 = obj;
                            if (!it.hasNext()) {
                                break;
                            }
                            bd bdVar = (bd) it.next();
                            if (cA == null || bdVar.field_isSend == 1 || !bdVar.isText() || !bdVar.YU(cA)) {
                                obj = obj2;
                            } else {
                                bd.field_atCount++;
                                aiVar.fa(aiVar.field_atCount + 1);
                                obj = 1;
                            }
                        }
                        obj = obj2;
                    }
                    z.Nb();
                    com.tencent.mm.ac.a.b.a(bd, i2, i);
                    if (bi.oW(str2)) {
                        str2 = ak.gT(aq.field_bizChatUserId);
                    }
                    x.i("MicroMsg.BizConversationStorage", "updateBizChatConversation brandUserName:%s, bizChatId:%s, userId:%s, displayName:%s", new Object[]{str, ak.field_bizChatServId, aq.field_bizChatUserId, str2});
                    z.Nb().b(bd);
                    if (obj != null) {
                        this.sNS.a(aiVar, str);
                    }
                } else {
                    aVar = bd;
                }
                j = aq.field_createTime;
                aVar.field_lastMsgTime = j;
                bd.field_status = aq.field_status;
                bd.field_isSend = aq.field_isSend;
                bd.field_msgType = Integer.toString(aq.getType());
                bd.field_flag = com.tencent.mm.ac.a.b.a(bd, 1, aq.field_createTime);
                obj = null;
                bd.field_unReadCount += cVar.lcz;
                bd.field_newUnReadCount += cVar.lcz;
                i3 = aiVar.field_unReadCount - cVar.lcz;
                if (i3 > 0) {
                    aiVar.eV(i3);
                } else {
                    aiVar.eV(0);
                }
                aiVar.fb(aiVar.field_unReadMuteCount + cVar.lcz);
                obj = 1;
                cA = z.Nc().cA(aq.field_talker);
                it = cVar.lcy.iterator();
                while (true) {
                    obj2 = obj;
                    if (!it.hasNext()) {
                        break;
                    }
                    bd bdVar2 = (bd) it.next();
                    if (cA == null || bdVar2.field_isSend == 1 || !bdVar2.isText() || !bdVar2.YU(cA)) {
                        obj = obj2;
                    } else {
                        bd.field_atCount++;
                        aiVar.fa(aiVar.field_atCount + 1);
                        obj = 1;
                    }
                }
                obj = obj2;
                z.Nb();
                com.tencent.mm.ac.a.b.a(bd, i2, i);
                if (bi.oW(str2)) {
                    str2 = ak.gT(aq.field_bizChatUserId);
                }
                x.i("MicroMsg.BizConversationStorage", "updateBizChatConversation brandUserName:%s, bizChatId:%s, userId:%s, displayName:%s", new Object[]{str, ak.field_bizChatServId, aq.field_bizChatUserId, str2});
                z.Nb().b(bd);
                if (obj != null) {
                    this.sNS.a(aiVar, str);
                }
            }
        }
    }

    public final void XJ(String str) {
        if (str != null && s.hf(str) && com.tencent.mm.ac.f.kM(str)) {
            ai Yq = this.sNS.Yq(str);
            if (Yq != null) {
                bd GE = ((i) g.l(i.class)).bcY().GE(((i) g.l(i.class)).FW().YD(str));
                if (GE != null && GE.field_msgId > 0) {
                    Yq.aj(GE);
                    Yq.setContent(GE.field_talker + ":" + GE.field_content);
                    Yq.ec(Integer.toString(GE.getType()));
                    az.b vu = this.sNS.vu();
                    if (vu != null) {
                        PString pString = new PString();
                        PString pString2 = new PString();
                        PInt pInt = new PInt();
                        GE.ep(str);
                        GE.setContent(Yq.field_content);
                        vu.a(GE, pString, pString2, pInt, true);
                        Yq.ed(pString.value);
                        Yq.ee(pString2.value);
                        Yq.eY(pInt.value);
                    } else {
                        Yq.clx();
                    }
                    this.sNS.a(Yq, Yq.field_username);
                }
            }
        }
    }
}

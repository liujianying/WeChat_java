package com.tencent.mm.plugin.multitalk.a;

import android.util.Base64;
import com.google.a.a.e;
import com.tencent.mm.R;
import com.tencent.mm.ab.d.a;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.m;
import com.tencent.mm.model.q;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.protocal.c.by;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;
import com.tencent.pb.common.b.a.a.av;
import com.tencent.pb.common.b.a.a.bb;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class f {
    private Map<String, Long> ltQ = new ConcurrentHashMap();

    final void a(String str, a aVar) {
        String a = ab.a(aVar.dIN.rcl);
        byte[] decode = Base64.decode(str.getBytes(), 0);
        x.i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "receive banner msg:" + a + " buffer len " + decode.length);
        try {
            bb bbVar = (bb) e.a(new bb(), decode, decode.length);
            if (bbVar == null) {
                x.e("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "parse  bannerinfo  is null! xml:" + a);
            } else if (this.ltQ.get(bbVar.groupId) == null || ((Long) this.ltQ.get(bbVar.groupId)).longValue() < bbVar.vgb) {
                this.ltQ.put(bbVar.groupId, Long.valueOf(bbVar.vgb));
                by byVar = aVar.dIN;
                String a2 = ab.a(byVar.rcj);
                String a3 = ab.a(byVar.rck);
                au.HU();
                String str2 = (String) c.DT().get(2, null);
                if (str2 == null) {
                    x.e("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "userName is null");
                    return;
                }
                String str3 = str2.equals(a2) ? a3 : a2;
                String str4 = bbVar.vfZ;
                Object obj;
                String str5;
                Object obj2;
                if (bbVar.vfY == 1) {
                    x.i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "get WxVoiceBannerBegin,show bar!");
                    String[] strArr = bbVar.vga;
                    obj = null;
                    str5 = "";
                    for (av avVar : bbVar.vea) {
                        str5 = str5 + avVar.vez + ",";
                        if (avVar.vez != null && avVar.vez.equals(str2)) {
                            x.i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "in voiceGroupMem!");
                            obj = 1;
                        }
                    }
                    x.i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "memberUserNames :" + str5);
                    obj2 = null;
                    for (String str6 : strArr) {
                        if (str6 != null && str6.equals(str2)) {
                            x.i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "isInvitedNotFriend true! In invitelist and with talk creator is not friend!");
                            obj2 = 1;
                            break;
                        }
                    }
                    if (obj == null) {
                        o.bgP().HL(str3);
                        o.bgP().bgy().remove(str3);
                    } else if (!(o.bgP().bgy().contains(str3) || obj2 == null)) {
                        o.bgP().bgy().add(str3);
                    }
                    if (str2.equals(str4)) {
                        o.bgN().b(str3, str4, false, false);
                    } else if (obj != null && obj2 == null) {
                        o.bgN().b(str3, str4, false, false);
                    } else if (obj == null || obj2 == null) {
                        o.bgN().b(str3, str4, true, false);
                    } else {
                        o.bgN().b(str3, str4, true, true);
                    }
                    o.bgP().a(str3, bbVar);
                    o.bgM().lta.bg(bi.f((Integer) au.HS().get(1)), q.GF());
                } else if (bbVar.vfY == 2) {
                    x.i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "WxVoiceBannerMemChange!2,member size : " + bbVar.vea.length);
                    String[] strArr2 = bbVar.vga;
                    obj = null;
                    str5 = "";
                    for (av avVar2 : bbVar.vea) {
                        str5 = str5 + avVar2.vez + ",";
                        if (avVar2.vez != null && avVar2.vez.equals(str2)) {
                            x.i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "in voiceGroupMem!");
                            obj = 1;
                        }
                    }
                    x.i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "memberUserNames :" + str5);
                    obj2 = null;
                    for (String str7 : strArr2) {
                        if (str7 != null && str7.equals(str2)) {
                            x.i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "isInvitedNotFriend true! In invitelist and with talk creator is not friend!");
                            obj2 = 1;
                            break;
                        }
                    }
                    if (obj == null) {
                        if (!o.bgP().HM(str3) && o.bgP().bgy().contains(str3) && o.bgP().dL(str3, str2)) {
                            o.bgN();
                            e.Hz(str3);
                        }
                        o.bgP().HL(str3);
                        o.bgP().bgy().remove(str3);
                    } else if (!(o.bgP().bgy().contains(str3) || r3 == null)) {
                        o.bgP().bgy().add(str3);
                    }
                    o.bgM().lta.bg(bi.f((Integer) au.HS().get(1)), q.GF());
                    x.i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "WxVoiceBannerMemChange setWxUinAndUsrName:");
                    g bgP = o.bgP();
                    x.i("MicroMsg.MultiTalkRoomListMsg", "updateBanner  wxGroupId = %s", new Object[]{str3});
                    com.tencent.mm.ax.f HO = o.bgJ().HO(str3);
                    if (HO == null) {
                        x.i("MicroMsg.MultiTalkRoomListMsg", "change,still show banner.");
                        bgP.a(str3, bbVar);
                    } else if (HO.field_roomId != bbVar.oLB) {
                        x.i("MicroMsg.MultiTalkRoomListMsg", "roomid has changed! now return!multiTalkInfo.field_roomId:" + HO.field_roomId + "bannerinfo.roomid:" + bbVar.oLB);
                    } else if (g.c(str3, bbVar)) {
                        bgP.HN(str3);
                    } else {
                        x.e("MicroMsg.MultiTalkRoomListMsg", "update multiTalkMember failure!");
                    }
                } else if (bbVar.vfY == 0) {
                    x.i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "get WxVoiceBannerEnd,dismiss bar!");
                    if (!o.bgP().HM(str3) && o.bgP().bgy().contains(str3) && o.bgP().dL(str3, str2)) {
                        o.bgN();
                        e.Hz(str3);
                    }
                    e bgN = o.bgN();
                    bd bdVar = new bd();
                    bdVar.setType(64);
                    bdVar.ay(System.currentTimeMillis());
                    bdVar.setStatus(6);
                    bdVar.setContent(ad.getContext().getString(R.l.multitalk_system_master_multi_finish_msg));
                    if (m.gC(str3)) {
                        bdVar.ep(str3);
                        bdVar.setContent(bdVar.field_content);
                        au.HU();
                        c.FT().T(bdVar);
                    }
                    if (!(bgN.ltF == null || !str3.equals(bgN.ltF.vgo) || bgN.ltH.ciq())) {
                        x.i("MicroMsg.MT.MultiTalkManager", "multiTalkGroupTmp wxGroupId equals this wxGroupId.");
                        bgN.ltF = null;
                        bgN.ltG = 0;
                        bgN.ltH.SO();
                    }
                    o.bgP().HK(str3);
                    o.bgP().HL(str3);
                    o.bgP().bgy().remove(str3);
                } else if (bbVar.vfY == 3) {
                    for (av avVar3 : bbVar.vea) {
                        if (avVar3.vez != null && avVar3.vez.equals(str2)) {
                            x.i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "wxVoiceBannerWaitTimeOut in voiceGroupMem!");
                        }
                    }
                } else {
                    x.e("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "get bannerinfo voicestatus is invalidate!: voicestatus:" + bbVar.vfY);
                }
            } else {
                x.i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "msg for this groupId : " + bbVar.groupId + " is early than last msg, so we do not process,now return.");
            }
        } catch (Exception e) {
            x.e("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "parse  bannerinfo  failure! xml:" + a, new Object[]{e.getMessage()});
        }
    }
}

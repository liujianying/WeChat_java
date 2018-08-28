package com.tencent.mm.plugin.subapp.ui.friend;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.R;
import com.tencent.mm.az.d;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.subapp.b;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.u;
import junit.framework.Assert;

public final class a implements OnItemClickListener {
    private Context context;
    private boolean dIK = false;
    private b orL;

    public a(Context context, b bVar, boolean z) {
        this.context = context;
        this.orL = bVar;
        this.dIK = z;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (this.dIK) {
            i--;
        }
        ar arVar = (ar) this.orL.getItem(i);
        if (arVar == null) {
            x.e("MicroMsg.FConversationOnItemClickListener", "onItemClick, item is null, pos = " + i);
        } else {
            g(this.context, arVar.field_talker, false);
        }
    }

    public static void g(Context context, String str, boolean z) {
        if (str == null || str.length() == 0) {
            x.e("MicroMsg.FConversationOnItemClickListener", "dealOnClick fail, talker is null");
            return;
        }
        x.d("MicroMsg.FConversationOnItemClickListener", "dealOnClick, talker = " + str);
        d.SF().YK(str);
        at YO = d.SE().YO(str);
        if (YO == null) {
            x.e("MicroMsg.FConversationOnItemClickListener", "onItemClick, lastRecvFmsg is null, talker = " + str);
        } else if (YO.field_type == 0) {
            au.HU();
            com.tencent.mm.storage.bd.a GR = c.FT().GR(YO.field_msgContent);
            if (GR != null && GR.otZ.length() > 0) {
                Bundle bundle = new Bundle();
                bundle.putBoolean("Contact_ShowFMessageList", true);
                bundle.putInt("Contact_Source_FMessage", GR.scene);
                au.HU();
                ab Yg = c.FR().Yg(GR.otZ);
                if (Yg != null && ((int) Yg.dhP) > 0 && com.tencent.mm.l.a.gd(Yg.field_type)) {
                    b.ezo.a(context, Yg, GR, bundle, "");
                } else if (GR.lWQ > 0) {
                    if (bi.oW(GR.eLE) && bi.oW(GR.eLB) && !bi.oW(GR.nickname)) {
                        bundle.putString("Contact_QQNick", GR.nickname);
                    }
                    b.ezo.a(context, GR, bundle);
                } else if (bi.oW(GR.tbE) && bi.oW(GR.tbF)) {
                    b.ezo.a(context, GR, bundle);
                } else {
                    com.tencent.mm.plugin.account.friend.a.a pq = com.tencent.mm.plugin.account.b.getAddrUploadStg().pq(GR.tbE);
                    if (pq == null || pq.Xh() == null || pq.Xh().length() <= 0) {
                        pq = com.tencent.mm.plugin.account.b.getAddrUploadStg().pq(GR.tbF);
                        if (pq == null || pq.Xh() == null || pq.Xh().length() <= 0) {
                            if (Yg == null || ((int) Yg.dhP) <= 0) {
                                b.ezo.a(context, GR, bundle);
                            } else {
                                b.ezo.a(context, Yg, GR, bundle, "");
                            }
                            x.e("MicroMsg.FConversationOnItemClickListener", "error : this is not the mobile contact, MD5 = " + GR.tbE + " fullMD5:" + GR.tbF);
                            return;
                        }
                    }
                    if (pq.getUsername() == null || pq.getUsername().length() <= 0) {
                        pq.username = GR.otZ;
                        pq.bWA = 128;
                        if (com.tencent.mm.plugin.account.b.getAddrUploadStg().a(pq.Xh(), pq) == -1) {
                            x.e("MicroMsg.FConversationOnItemClickListener", "update mobile contact username failed");
                            return;
                        }
                    }
                    b.ezo.a(context, GR, bundle);
                }
            }
        } else {
            a(context, YO, z);
        }
    }

    public static void a(Context context, at atVar, boolean z) {
        String str = atVar.field_msgContent;
        x.w("MicroMsg.FConversationOnItemClickListener", "dealClickVerifyMsgEvent : " + str);
        if (str != null && str.length() > 0) {
            au.HU();
            bd.d GQ = c.FT().GQ(str);
            if (GQ != null && !bi.oW(GQ.otZ)) {
                Assert.assertTrue(GQ.otZ.length() > 0);
                au.HU();
                ab Yg = c.FR().Yg(GQ.otZ);
                Intent intent = new Intent();
                if (z) {
                    intent.putExtra("Accept_NewFriend_FromOutside", true);
                }
                intent.putExtra("Contact_ShowUserName", false);
                intent.putExtra("Contact_ShowFMessageList", true);
                intent.putExtra("Contact_Scene", GQ.scene);
                intent.putExtra("Verify_ticket", GQ.juZ);
                intent.putExtra("Contact_Source_FMessage", GQ.scene);
                if (Yg == null || ((int) Yg.dhP) <= 0 || !com.tencent.mm.l.a.gd(Yg.field_type)) {
                    if (atVar.field_type == 1 || atVar.field_type == 2) {
                        intent.putExtra("User_Verify", true);
                    }
                    intent.putExtra("Contact_User", GQ.otZ);
                    intent.putExtra("Contact_Alias", GQ.cCR);
                    intent.putExtra("Contact_Nick", GQ.nickname);
                    intent.putExtra("Contact_QuanPin", GQ.eLA);
                    intent.putExtra("Contact_PyInitial", GQ.eLz);
                    intent.putExtra("Contact_Sex", GQ.sex);
                    intent.putExtra("Contact_Signature", GQ.signature);
                    intent.putExtra("Contact_FMessageCard", true);
                    intent.putExtra("Contact_City", GQ.getCity());
                    intent.putExtra("Contact_Province", GQ.getProvince());
                    intent.putExtra("Contact_Mobile_MD5", GQ.tbE);
                    intent.putExtra("Contact_full_Mobile_MD5", GQ.tbF);
                    intent.putExtra("Contact_KSnsBgUrl", GQ.tbS);
                } else {
                    intent.putExtra("Contact_User", Yg.field_username);
                    b.ezo.a(intent, Yg.field_username);
                }
                str = GQ.content;
                if (bi.oV(str).length() <= 0) {
                    switch (GQ.scene) {
                        case 18:
                        case 22:
                        case 23:
                        case 24:
                        case 25:
                        case 26:
                        case 27:
                        case 28:
                        case 29:
                            str = context.getString(R.l.chatting_from_verify_lbs_tip);
                            break;
                        default:
                            str = context.getString(R.l.chatting_from_verify_contact_tip);
                            break;
                    }
                }
                intent.putExtra("Contact_Content", str);
                if (GQ.tbU == 1 && !bi.oW(GQ.tbW)) {
                    intent.putExtra("Safety_Warning_Detail", GQ.tbW);
                }
                intent.putExtra("Contact_verify_Scene", GQ.scene);
                if ((GQ.scene == 14 || GQ.scene == 8) && !bi.oW(GQ.chatroomName)) {
                    au.HU();
                    u ih = c.Ga().ih(GQ.chatroomName);
                    if (ih != null) {
                        intent.putExtra("Contact_RoomNickname", ih.gT(GQ.otZ));
                    }
                }
                intent.putExtra("Contact_Uin", GQ.lWQ);
                intent.putExtra("Contact_QQNick", GQ.eLB);
                intent.putExtra("Contact_Mobile_MD5", GQ.tbE);
                intent.putExtra("User_From_Fmessage", true);
                intent.putExtra("Contact_from_msgType", 37);
                if (Yg == null || !com.tencent.mm.l.a.gd(Yg.field_type)) {
                    intent.putExtra("Contact_KSnsIFlag", 0);
                }
                intent.putExtra("Contact_KSnsBgUrl", GQ.tbS);
                intent.putExtra("verify_gmail", GQ.eHT);
                intent.putExtra("source_from_user_name", GQ.qIb);
                intent.putExtra("source_from_nick_name", GQ.qIc);
                com.tencent.mm.bg.d.b(context, "profile", ".ui.ContactInfoUI", intent);
            }
        }
    }
}

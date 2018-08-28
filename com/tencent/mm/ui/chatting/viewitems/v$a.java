package com.tencent.mm.ui.chatting.viewitems;

import android.content.Intent;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import com.tencent.mm.R;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.s;
import com.tencent.mm.platformtools.ai;
import com.tencent.mm.plugin.account.friend.a.l;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.bd.d;
import com.tencent.mm.ui.chatting.b.b.g;
import com.tencent.mm.ui.chatting.c.a;
import com.tencent.mm.ui.chatting.viewitems.v.b;
import com.tencent.mm.ui.contact.e;
import com.tencent.wcdb.FileUtils;
import junit.framework.Assert;

public class v$a extends b {
    private a tKy;

    public final boolean bba() {
        return false;
    }

    public final boolean aq(int i, boolean z) {
        if (i == 37 || i == 40) {
            return true;
        }
        return false;
    }

    public final View a(LayoutInflater layoutInflater, View view) {
        if (view != null && view.getTag() != null) {
            return view;
        }
        r rVar = new r(layoutInflater, R.i.chatting_item_from_fmessage);
        rVar.setTag(new b().dG(rVar));
        return rVar;
    }

    protected final boolean cxM() {
        return false;
    }

    public final void a(b.a aVar, int i, a aVar2, bd bdVar, String str) {
        this.tKy = aVar2;
        b bVar = (b) aVar;
        if (bdVar.getType() == 37) {
            au.HU();
            d GQ = c.FT().GQ(bdVar.field_content);
            if (GQ == null || GQ.otZ == null || GQ.otZ.length() <= 0) {
                x.e("MicroMsg.ChattingItemFMessageFrom", "getView : parse verify msg failed");
                return;
            }
            com.tencent.mm.aa.c.J(GQ.otZ, GQ.tbD);
            if (s.he(GQ.otZ)) {
                bVar.ucS.setVisibility(8);
                bVar.ucT.setVisibility(8);
                bVar.ucU.setVisibility(0);
                bVar.ucR.setBackgroundColor(16777215);
                bVar.ucU.setText(aVar2.tTq.getMMResources().getString(R.l.friend_added));
            } else {
                bVar.ucS.setVisibility(0);
                bVar.ucT.setVisibility(0);
                bVar.ucU.setVisibility(0);
                bVar.ucR.setBackgroundResource(R.g.chatting_item_multi_bottom);
                bVar.ucU.setText(aVar2.tTq.getMMResources().getString(R.l.friend_add));
            }
            switch (GQ.scene) {
                case 13:
                    com.tencent.mm.plugin.account.friend.a.a pp = com.tencent.mm.plugin.account.b.getAddrUploadStg().pp(GQ.otZ);
                    if (pp != null && pp.Xj() != null && !pp.Xj().equals("")) {
                        bVar.ucV.setVisibility(0);
                        bVar.ucV.setText(aVar2.tTq.getMMResources().getString(R.l.chatting_from_mobile_friends_content, new Object[]{pp.Xj()}));
                        break;
                    }
                    bVar.ucV.setVisibility(8);
                    break;
                    break;
                case 18:
                    bVar.ubY.setText(R.l.chatting_from_verify_lbs);
                    break;
                case 22:
                case 23:
                case 24:
                case 26:
                case 27:
                case 28:
                case 29:
                    bVar.ubY.setText(R.l.chatting_from_verify_shake);
                    break;
                case 25:
                    bVar.ubY.setText(R.l.chatting_from_verify_bottle);
                    break;
                case 30:
                    bVar.ubY.setText(R.l.qrcode_sayhi_from);
                    break;
                default:
                    bVar.ubY.setText(R.l.chatting_from_verify_contact);
                    break;
            }
            bVar.eVw.setText(j.a(aVar2.tTq.getContext(), GQ.getDisplayName(), bVar.eVw.getTextSize()));
            b.r(bVar.eCl, GQ.otZ);
            bVar.ucQ.setVisibility(0);
            if (GQ.content == null || GQ.content.trim().equals("")) {
                bVar.ucQ.setText(aVar2.tTq.getMMResources().getString(R.l.chatting_from_verify_lbs_tip));
            } else {
                bVar.ucQ.setText(GQ.content);
            }
        } else if (bdVar.getType() == 40) {
            au.HU();
            bd.a GR = c.FT().GR(bdVar.field_content);
            if (GR == null || GR.otZ == null || GR.otZ.length() <= 0) {
                x.e("MicroMsg.ChattingItemFMessageFrom", "getView : parse possible friend msg failed");
                return;
            }
            com.tencent.mm.aa.c.J(GR.otZ, GR.tbD);
            if (s.he(GR.otZ)) {
                bVar.ucS.setVisibility(8);
                bVar.ucT.setVisibility(8);
                bVar.ucU.setVisibility(0);
                bVar.ucR.setBackgroundColor(16777215);
                bVar.ucU.setText(aVar2.tTq.getMMResources().getString(R.l.friend_added));
            } else {
                bVar.ucS.setVisibility(0);
                bVar.ucT.setVisibility(0);
                bVar.ucU.setVisibility(0);
                bVar.ucR.setBackgroundResource(R.g.chatting_item_multi_bottom);
                bVar.ucU.setText(aVar2.tTq.getMMResources().getString(R.l.friend_add));
            }
            switch (GR.scene) {
                case 4:
                    bVar.ubY.setText(R.l.chatting_from_QQ_friends);
                    bVar.ucQ.setText(R.l.chatting_from_QQ_friends_content);
                    CharSequence cmJ = GR.cmJ();
                    if (cmJ == null) {
                        cmJ = GR.getDisplayName();
                    }
                    bVar.eVw.setText(j.a(aVar2.tTq.getContext(), cmJ, bVar.eVw.getTextSize()));
                    break;
                case 10:
                case 11:
                    bVar.ubY.setText(R.l.chatting_from_mobile_friends);
                    String px = l.px(GR.tbE);
                    if (ai.oW(px)) {
                        px = l.px(GR.tbF);
                    }
                    bVar.ucQ.setText(aVar2.tTq.getMMResources().getString(R.l.chatting_from_mobile_friends_content, new Object[]{px}));
                    bVar.eVw.setText(j.a(aVar2.tTq.getContext(), GR.getDisplayName(), bVar.eVw.getTextSize()));
                    break;
                case 31:
                    bVar.ubY.setText(R.l.chatting_from_verify_facebook);
                    bVar.ucQ.setText(R.l.chatting_from_verify_facebook_content);
                    bVar.eVw.setText(j.a(aVar2.tTq.getContext(), GR.getDisplayName(), bVar.eVw.getTextSize()));
                    break;
                case 32:
                    bVar.ubY.setText(R.l.chatting_from_sns_tip);
                    bVar.ucQ.setText(R.l.chatting_from_sns_add_now);
                    bVar.eVw.setText(j.a(aVar2.tTq.getContext(), GR.getDisplayName(), bVar.eVw.getTextSize()));
                    break;
                default:
                    x.d("MicroMsg.ChattingItemFMessageFrom", "prossible friend sceneType:%d", Integer.valueOf(GR.scene));
                    bVar.ubY.setText(R.l.chatting_from_possible_friends);
                    bVar.ucQ.setText(R.l.chatting_from_possible_friends_content);
                    bVar.eVw.setText(j.a(aVar2.tTq.getContext(), GR.getDisplayName(), bVar.eVw.getTextSize()));
                    break;
            }
            b.r(bVar.eCl, GR.otZ);
        } else {
            x.w("MicroMsg.ChattingItemFMessageFrom", "FROM_FMESSAGE did not include this type, msgType = " + bdVar.getType());
        }
        bVar.hrH.setTag(new au(bdVar, aVar2.cwr(), i, null, 0));
        bVar.hrH.setOnClickListener(d(aVar2));
        bVar.hrH.setOnLongClickListener(c(aVar2));
        bVar.hrH.setOnTouchListener(((g) aVar2.O(g.class)).ctw());
    }

    public final boolean a(ContextMenu contextMenu, View view, bd bdVar) {
        return false;
    }

    public final boolean a(MenuItem menuItem, a aVar, bd bdVar) {
        return false;
    }

    public final boolean b(View view, a aVar, bd bdVar) {
        String str;
        if (bdVar.getType() == 37) {
            str = bdVar.field_content;
            x.w("MicroMsg.ChattingItemFMessageFrom", "dealClickVerifyMsgEvent : " + str);
            if (str != null && str.length() > 0) {
                au.HU();
                d GQ = c.FT().GQ(str);
                if (GQ != null) {
                    Assert.assertTrue(GQ.otZ.length() > 0);
                    au.HU();
                    com.tencent.mm.g.c.ai Yg = c.FR().Yg(GQ.otZ);
                    Intent intent = new Intent();
                    if (Yg == null || ((int) Yg.dhP) <= 0 || !com.tencent.mm.l.a.gd(Yg.field_type)) {
                        intent.putExtra("Verify_ticket", GQ.juZ);
                        intent.putExtra("User_Verify", true);
                        intent.putExtra("Contact_User", GQ.otZ);
                        intent.putExtra("Contact_Alias", GQ.cCR);
                        intent.putExtra("Contact_Nick", GQ.nickname);
                        intent.putExtra("Contact_QuanPin", GQ.eLA);
                        intent.putExtra("Contact_PyInitial", GQ.eLz);
                        intent.putExtra("Contact_Sex", GQ.sex);
                        intent.putExtra("Contact_Signature", GQ.signature);
                        intent.putExtra("Contact_Scene", GQ.scene);
                        intent.putExtra("Contact_FMessageCard", true);
                        intent.putExtra("Contact_City", GQ.getCity());
                        intent.putExtra("Contact_Province", GQ.getProvince());
                        intent.putExtra("Contact_Mobile_MD5", GQ.tbE);
                        intent.putExtra("Contact_full_Mobile_MD5", GQ.tbF);
                        intent.putExtra("Contact_KSnsIFlag", GQ.tbR);
                        intent.putExtra("Contact_KSnsBgUrl", GQ.tbS);
                    } else {
                        intent.putExtra("Contact_User", Yg.field_username);
                        e.a(intent, Yg.field_username);
                    }
                    str = GQ.content;
                    if (ai.oV(str).length() <= 0) {
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
                                str = this.tKy.tTq.getMMResources().getString(R.l.chatting_from_verify_lbs_tip);
                                break;
                            default:
                                str = this.tKy.tTq.getMMResources().getString(R.l.chatting_from_verify_contact_tip);
                                break;
                        }
                    }
                    intent.putExtra("Contact_Content", str);
                    intent.putExtra("Contact_verify_Scene", GQ.scene);
                    intent.putExtra("Contact_Uin", GQ.lWQ);
                    intent.putExtra("Contact_QQNick", GQ.eLB);
                    intent.putExtra("Contact_Mobile_MD5", GQ.tbE);
                    intent.putExtra("User_From_Fmessage", true);
                    intent.putExtra("Contact_from_msgType", 37);
                    intent.putExtra("Contact_KSnsIFlag", GQ.tbR);
                    intent.putExtra("Contact_KSnsBgUrl", GQ.tbS);
                    com.tencent.mm.bg.d.b(this.tKy.tTq.getContext(), "profile", ".ui.ContactInfoUI", intent);
                    com.tencent.mm.bh.a.Cy(GQ.scene);
                }
            }
        } else if (bdVar.getType() == 40) {
            str = bdVar.field_content;
            au.HU();
            bd.a GR = c.FT().GR(str);
            if (GR != null && GR.otZ.length() > 0) {
                com.tencent.mm.bh.a.Cy(GR.scene);
                au.HU();
                com.tencent.mm.g.c.ai Yg2 = c.FR().Yg(GR.otZ);
                if (Yg2 != null && ((int) Yg2.dhP) > 0 && com.tencent.mm.l.a.gd(Yg2.field_type)) {
                    e.a(this.tKy.tTq.getContext(), Yg2, GR);
                } else if (GR.lWQ > 0 || (ai.oW(GR.tbE) && ai.oW(GR.tbF))) {
                    e.a(this.tKy.tTq.getContext(), GR);
                } else {
                    com.tencent.mm.plugin.account.friend.a.a pq = com.tencent.mm.plugin.account.b.getAddrUploadStg().pq(GR.tbE);
                    if (pq == null || pq.Xh() == null || pq.Xh().length() <= 0) {
                        pq = com.tencent.mm.plugin.account.b.getAddrUploadStg().pq(GR.tbF);
                        if (pq == null || pq.Xh() == null || pq.Xh().length() <= 0) {
                            if (Yg2 == null || ((int) Yg2.dhP) <= 0) {
                                e.a(this.tKy.tTq.getContext(), GR);
                            } else {
                                e.a(this.tKy.tTq.getContext(), Yg2, GR);
                            }
                            x.e("MicroMsg.ChattingItemFMessageFrom", "error : this is not the mobile contact, MD5 = " + GR.tbE + " fullMD5:" + GR.tbF);
                        }
                    }
                    if (pq.getUsername() == null || pq.getUsername().length() <= 0) {
                        pq.username = GR.otZ;
                        pq.bWA = FileUtils.S_IWUSR;
                        if (com.tencent.mm.plugin.account.b.getAddrUploadStg().a(pq.Xh(), pq) == -1) {
                            x.e("MicroMsg.ChattingItemFMessageFrom", "update mobile contact username failed");
                        }
                    }
                    e.a(this.tKy.tTq.getContext(), GR);
                }
            }
        }
        return true;
    }
}

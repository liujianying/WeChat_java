package com.tencent.mm.plugin.sport.ui.a;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.ac.z;
import com.tencent.mm.ao.b;
import com.tencent.mm.g.a.ow;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.q;
import com.tencent.mm.model.s;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.exdevice.ui.ExdeviceRankDataSourceUI;
import com.tencent.mm.plugin.messenger.a.g;
import com.tencent.mm.plugin.sport.b.d;
import com.tencent.mm.pluginsdk.model.m;
import com.tencent.mm.pluginsdk.ui.preference.HelperHeaderPreference;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.f;
import java.util.LinkedList;
import java.util.List;

public final class a implements e, com.tencent.mm.pluginsdk.b.a {
    Context context;
    private f eOE;
    ab guS;
    private p guT;
    private CheckBoxPreference opQ;
    private CheckBoxPreference opR;

    public a(Context context) {
        this.context = context;
    }

    public final boolean a(f fVar, ab abVar, boolean z, int i) {
        this.eOE = fVar;
        this.guS = abVar;
        fVar.addPreferencesFromResource(R.o.contact_info_pref_sport);
        this.opQ = (CheckBoxPreference) fVar.ZZ("contact_info_top_sport");
        this.opR = (CheckBoxPreference) fVar.ZZ("contact_info_not_disturb");
        auv();
        return true;
    }

    public final boolean auw() {
        return true;
    }

    public final boolean wX(String str) {
        Intent intent;
        if ("contact_info_record_data".equals(str)) {
            this.context.startActivity(new Intent(this.context, ExdeviceRankDataSourceUI.class));
        } else if ("contact_info_top_sport".equals(str)) {
            if (this.opQ.isChecked()) {
                d.kB(20);
                s.t(this.guS.field_username, true);
            } else {
                d.kB(21);
                s.u(this.guS.field_username, true);
            }
        } else if ("contact_info_not_disturb".equals(str)) {
            if (this.opR.isChecked()) {
                d.kB(22);
                s.n(this.guS);
            } else {
                d.kB(23);
                s.o(this.guS);
            }
        } else if ("contact_info_go_to_sport".equals(str)) {
            intent = new Intent();
            intent.putExtra("Chat_User", this.guS.field_username);
            intent.putExtra("finish_direct", true);
            com.tencent.mm.bg.d.e(this.context, ".ui.chatting.ChattingUI", intent);
            d.kB(19);
        } else if ("contact_info_go_to_my_profile".equals(str)) {
            String GF = q.GF();
            if (bi.oW(GF)) {
                x.e("MicroMsg.Sport.ContactWidgetSport", "Get username from UserInfo return null or nil.");
            } else {
                Intent intent2 = new Intent();
                intent2.putExtra("username", GF);
                com.tencent.mm.bg.d.b(this.context, "exdevice", ".ui.ExdeviceProfileUI", intent2);
                d.kB(3);
            }
        } else if ("contact_info_invite_friend".equals(str)) {
            intent = new Intent();
            intent.putExtra("Select_Talker_Name", this.guS.field_username);
            intent.putExtra("Select_block_List", this.guS.field_username);
            intent.putExtra("Select_Conv_Type", 3);
            intent.putExtra("Select_Send_Card", true);
            intent.putExtra("mutil_select_is_ret", true);
            com.tencent.mm.bg.d.b(this.context, ".ui.transmit.SelectConversationUI", intent, 1);
            d.kB(4);
        } else if ("contact_info_common_problem".equals(str)) {
            intent = new Intent();
            intent.putExtra("KPublisherId", "custom_menu");
            intent.putExtra("pre_username", this.guS.field_username);
            intent.putExtra("prePublishId", "custom_menu");
            intent.putExtra("preUsername", this.guS.field_username);
            intent.putExtra("preChatName", this.guS.field_username);
            intent.putExtra("preChatTYPE", t.N(this.guS.field_username, this.guS.field_username));
            intent.putExtra("rawUrl", "https://support.weixin.qq.com/cgi-bin/mmsupport-bin/readtemplate?t=wechat_movement_faq/index");
            intent.putExtra("geta8key_username", this.guS.field_username);
            intent.putExtra("from_scence", 1);
            com.tencent.mm.bg.d.b(this.context, "webview", ".ui.tools.WebViewUI", intent);
            d.kB(5);
        } else if ("contact_info_privacy_and_notification".equals(str)) {
            com.tencent.mm.bg.d.A(this.context, "exdevice", ".ui.ExdeviceSettingUI");
        } else if ("contact_info_sport_install".equals(str)) {
            d.kB(13);
            Context context = this.context;
            this.context.getString(R.l.app_tip);
            this.guT = h.a(context, this.context.getString(R.l.settings_plugins_installing), true, null);
            this.guT.show();
            au.DF().a(30, this);
            List linkedList = new LinkedList();
            linkedList.add("gh_43f2581f6fd6");
            List linkedList2 = new LinkedList();
            linkedList2.add(Integer.valueOf(1));
            au.DF().a(new m(1, linkedList, linkedList2, "", ""), 0);
        } else if ("contact_info_sport_uninstall".equals(str)) {
            d.kB(14);
            h.a(this.context, this.context.getString(R.l.settings_plugins_uninstall_hint), "", this.context.getString(R.l.app_clear), this.context.getString(R.l.app_cancel), new 2(this), null);
        } else if ("contact_info_clear_data".equals(str)) {
            h.a(this.context, this.context.getString(R.l.contact_info_clear_data), "", this.context.getString(R.l.app_clear), this.context.getString(R.l.app_cancel), new 1(this), null);
        }
        return false;
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1) {
            switch (i) {
                case 1:
                    if (intent != null) {
                        List<String> F = bi.F(intent.getStringExtra("received_card_name").split(","));
                        String stringExtra = intent.getStringExtra("custom_send_text");
                        for (String str : F) {
                            g.bcT().l("gh_43f2581f6fd6", str, s.fq(str));
                            if (!bi.oW(stringExtra)) {
                                ow owVar = new ow();
                                owVar.bZQ.bZR = str;
                                owVar.bZQ.content = stringExtra;
                                owVar.bZQ.type = s.hQ(str);
                                owVar.bZQ.flags = 0;
                                com.tencent.mm.sdk.b.a.sFg.m(owVar);
                            }
                        }
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    final void auv() {
        HelperHeaderPreference helperHeaderPreference = (HelperHeaderPreference) this.eOE.ZZ("contact_info_header_helper");
        helperHeaderPreference.an(this.guS.field_username, this.guS.BL(), this.context.getString(R.l.contact_info_sport_switch_tip));
        if (com.tencent.mm.l.a.gd(this.guS.field_type)) {
            helperHeaderPreference.nw(1);
            this.eOE.bw("contact_info_sport_install", true);
            this.eOE.bw("contact_info_sport_uninstall", false);
            this.eOE.bw("contact_info_go_to_sport", false);
            this.eOE.bw("contact_info_go_to_my_profile", false);
            this.eOE.bw("contact_info_invite_friend", false);
            this.eOE.bw("contact_info_common_problem", false);
            this.eOE.bw("contact_info_record_data", false);
            this.eOE.bw("contact_info_privacy_and_notification", false);
            this.eOE.bw("contact_info_top_sport", false);
            this.eOE.bw("contact_info_not_disturb", false);
            au.HU();
            if (c.FW().Yx(this.guS.field_username)) {
                this.opQ.qpJ = true;
            } else {
                this.opQ.qpJ = false;
            }
            if (this.guS.BD()) {
                this.opR.qpJ = true;
                return;
            } else {
                this.opR.qpJ = false;
                return;
            }
        }
        helperHeaderPreference.nw(0);
        this.eOE.bw("contact_info_sport_install", false);
        this.eOE.bw("contact_info_sport_uninstall", true);
        this.eOE.bw("contact_info_go_to_sport", true);
        this.eOE.bw("contact_info_go_to_my_profile", true);
        this.eOE.bw("contact_info_invite_friend", true);
        this.eOE.bw("contact_info_common_problem", true);
        this.eOE.bw("contact_info_record_data", true);
        this.eOE.bw("contact_info_privacy_and_notification", true);
        this.eOE.bw("contact_info_top_sport", true);
        this.eOE.bw("contact_info_not_disturb", true);
    }

    public final void a(int i, int i2, String str, l lVar) {
        if (lVar instanceof m) {
            au.DF().b(30, this);
            if (i == 0 && i2 == 0) {
                String cby = ((m) lVar).cby();
                x.i("MicroMsg.Sport.ContactWidgetSport", "bind fitness contact %s success", new Object[]{cby});
                au.HU();
                ab Yg = c.FR().Yg("gh_43f2581f6fd6");
                if (Yg == null || bi.oW(cby)) {
                    x.e("MicroMsg.Sport.ContactWidgetSport", "respUsername == " + cby + ", contact = " + Yg);
                } else {
                    com.tencent.mm.ac.d kH;
                    if (s.hd(Yg.field_username)) {
                        String oV = bi.oV(Yg.field_username);
                        kH = com.tencent.mm.ac.f.kH(oV);
                        if (kH != null) {
                            kH.field_username = cby;
                        }
                        z.MY().delete(oV);
                        Yg.dD(oV);
                    } else {
                        kH = null;
                    }
                    Yg.setUsername(cby);
                    if (((int) Yg.dhP) == 0) {
                        au.HU();
                        c.FR().U(Yg);
                    }
                    if (((int) Yg.dhP) <= 0) {
                        x.e("MicroMsg.Sport.ContactWidgetSport", "addContact : insert contact failed");
                    } else {
                        s.p(Yg);
                        au.HU();
                        ab Yg2 = c.FR().Yg(Yg.field_username);
                        if (kH != null) {
                            z.MY().d(kH);
                        } else {
                            kH = com.tencent.mm.ac.f.kH(Yg2.field_username);
                            if (kH == null || kH.LS()) {
                                x.d("MicroMsg.Sport.ContactWidgetSport", "shouldUpdate");
                                com.tencent.mm.model.am.a.dBr.R(Yg2.field_username, "");
                                com.tencent.mm.aa.c.jN(Yg2.field_username);
                            } else if (Yg2.ckZ()) {
                                x.d("MicroMsg.Sport.ContactWidgetSport", "update contact, last check time=%d", new Object[]{Integer.valueOf(Yg2.csR)});
                                com.tencent.mm.model.am.a.dBr.R(Yg2.field_username, "");
                                com.tencent.mm.aa.c.jN(Yg2.field_username);
                            }
                        }
                    }
                }
                z.MY().e(z.MY().kA(Yg.field_username));
                au.HU();
                c.DT().set(327825, Boolean.valueOf(true));
                com.tencent.mm.plugin.ab.a.bji();
                com.tencent.mm.ao.d.b(b.ebo, b.ebk, "", null);
                x.i("MicroMsg.NewTipsManager", "dancy register local newtips, tipsId:%s, tipsVersion:%s, key:%s", new Object[]{Integer.valueOf(r0), Integer.valueOf(1), ""});
            } else {
                x.e("MicroMsg.Sport.ContactWidgetSport", "errType %d | errCode %d | errMsg %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
                if (i == 4 && i2 == -24 && !bi.oW(str)) {
                    Toast.makeText(ad.getContext(), str, 1).show();
                }
            }
            if (this.guT != null) {
                this.guT.dismiss();
            }
            auv();
        }
    }
}

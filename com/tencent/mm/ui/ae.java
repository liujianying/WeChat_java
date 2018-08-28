package com.tencent.mm.ui;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import com.tencent.mm.R;
import com.tencent.mm.ax.e;
import com.tencent.mm.g.a.nh;
import com.tencent.mm.g.a.rn;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bl;
import com.tencent.mm.model.c;
import com.tencent.mm.model.q;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.appbrand.widget.recentview.d;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.ab;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.b.n;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa.a;
import com.tencent.mm.ui.contact.SelectContactUI;
import com.tencent.mm.ui.contact.VoipAddressUI;
import com.tencent.mm.ui.contact.s;
import com.tencent.mm.ui.e.i;
import com.tencent.mm.ui.tools.p;

public final class ae extends p {
    private static final int[] tpL = new int[]{2, 1, 4, 10, 3, Integer.MAX_VALUE};
    private LayoutInflater Bc;
    private Context mContext;
    private SparseArray<c> tpH;
    private a tpJ;
    ad tpK = null;

    public ae(ActionBarActivity actionBarActivity) {
        super(actionBarActivity);
        this.mContext = actionBarActivity;
        this.Bc = LayoutInflater.from(actionBarActivity);
        mw(false);
        this.tpK = ad.cqQ();
    }

    public final boolean dZ() {
        int i = 0;
        this.tpK.lG(false);
        if (this.tpK.tpH.size() != 0) {
            this.tpH = this.tpK.tpH;
        } else {
            x.d("MicroMsg.PlusSubMenuHelper", "dyna plus config is null, we use default one");
            if (this.tpH != null) {
                this.tpH.clear();
            } else {
                this.tpH = new SparseArray();
            }
            for (int i2 = 0; i2 < tpL.length; i2++) {
                this.tpH.put(i2, new c(Ea(tpL[i2])));
            }
        }
        try {
            au.HU();
            if (((Boolean) c.DT().get(a.sRx, Boolean.valueOf(false))).booleanValue()) {
                while (i < this.tpH.size() && ((c) this.tpH.get(i)).tpQ.tpT != 2147483646) {
                    i++;
                }
                if (i == this.tpH.size()) {
                    this.tpH.put(this.tpH.size(), new c(Ea(2147483646)));
                }
            }
        } catch (Exception e) {
        }
        if (this.tpJ != null) {
            this.tpJ.notifyDataSetChanged();
        }
        return super.dZ();
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        boolean z = true;
        boolean z2 = false;
        if (this.mContext instanceof ActionBarActivity) {
            ((ActionBarActivity) this.mContext).supportInvalidateOptionsMenu();
        }
        int i2 = ((c) this.tpH.get(i)).tpQ.tpT;
        h.mEJ.h(11104, new Object[]{Integer.valueOf(i2)});
        if (g.l(d.class) != null) {
            ((d) g.l(d.class)).aoX();
        }
        Intent intent;
        String str;
        int a;
        Intent intent2;
        bl ID;
        switch (i2) {
            case 1:
                new Intent().putExtra("invite_friend_scene", 2);
                com.tencent.mm.bg.d.b(this.mContext, "subapp", ".ui.pluginapp.AddMoreFriendsUI", new Intent());
                break;
            case 2:
                intent = new Intent(this.mContext, SelectContactUI.class);
                intent.putExtra("titile", this.mContext.getString(R.l.address_title_launch_chatting));
                intent.putExtra("list_type", 0);
                intent.putExtra("list_attr", s.s(new int[]{s.ukG, ab.CTRL_BYTE, WXMediaMessage.TITLE_LENGTH_LIMIT}));
                intent.putExtra("scene", 7);
                this.mContext.startActivity(intent);
                break;
            case 3:
                intent = new Intent();
                intent.setClassName(this.mContext, "com.tencent.mm.ui.tools.ShareImageRedirectUI");
                this.mContext.startActivity(intent);
                break;
            case 4:
                rn rnVar = new rn();
                rnVar.ccn.ccp = true;
                com.tencent.mm.sdk.b.a.sFg.m(rnVar);
                str = rnVar.cco.ccr;
                if (!bi.oW(str)) {
                    x.v("MicroMsg.PlusSubMenuHelper", "Talkroom is on: " + str);
                    com.tencent.mm.ui.base.h.a(this.mContext, this.mContext.getString(R.l.talk_room_enter_voip_tip), "", this.mContext.getString(R.l.app_ok), this.mContext.getString(R.l.app_cancel), new 1(this), new 2(this));
                    break;
                }
                VoipAddressUI.gR(this.mContext);
                break;
            case 5:
                au.HU();
                if (!c.isSDCardAvailable()) {
                    com.tencent.mm.ui.base.s.gH(this.mContext);
                    break;
                }
                au.HU();
                str = (String) c.DT().get(2, null);
                Intent intent3 = new Intent();
                intent3.putExtra("sns_userName", str);
                intent3.setFlags(536870912);
                intent3.addFlags(67108864);
                au.HU();
                a = bi.a((Integer) c.DT().get(68389, null), 0);
                au.HU();
                c.DT().set(68389, Integer.valueOf(a + 1));
                com.tencent.mm.bg.d.b(this.mContext, "sns", ".ui.SnsUserUI", intent3);
                break;
            case 6:
                b.a(this.mContext, ".ui.FavoriteIndexUI", new Intent());
                break;
            case 7:
                com.tencent.mm.bg.d.b(this.mContext, "mall", ".ui.MallIndexUI", new Intent());
                break;
            case 8:
                intent = new Intent();
                intent.putExtra("preceding_scence", 2);
                com.tencent.mm.bg.d.b(this.mContext, "emoji", ".ui.v2.EmojiStoreV2UI", intent);
                break;
            case 9:
                com.tencent.mm.bg.d.b(this.mContext, "setting", ".ui.setting.SelfQRCodeUI", new Intent());
                break;
            case 10:
                h.mEJ.h(11265, new Object[]{Integer.valueOf(3)});
                if (!(com.tencent.mm.p.a.bx(this.mContext) || e.Sz())) {
                    com.tencent.mm.bg.d.A(this.mContext, "scanner", ".ui.BaseScanUI");
                    break;
                }
            case 11:
                au.HU();
                if (!c.isSDCardAvailable()) {
                    com.tencent.mm.ui.base.s.gH(this.mContext);
                    break;
                }
                com.tencent.mm.plugin.report.service.g.vu(10);
                au.HU();
                str = (String) c.DT().get(68377, null);
                au.HU();
                c.DT().set(68377, "");
                intent2 = new Intent();
                intent2.putExtra("sns_timeline_NeedFirstLoadint", true);
                boolean z3 = bi.oW(str);
                if (n.nkz == null) {
                    z2 = z3;
                } else if (n.nkz.axd() <= 0) {
                    z2 = z3;
                }
                intent2.putExtra("sns_resume_state", z2);
                com.tencent.mm.bg.d.b(this.mContext, "sns", ".ui.SnsTimeLineUI", intent2);
                break;
            case 12:
                au.HU();
                if (!c.isSDCardAvailable()) {
                    com.tencent.mm.ui.base.s.gH(this.mContext);
                    break;
                }
                com.tencent.mm.bg.d.A(this.mContext, "game", ".ui.GameCenterUI");
                new ag().postDelayed(new Runnable() {
                    public final void run() {
                        Intent intent = new Intent();
                        intent.setComponent(new ComponentName(i.thA, "com.tencent.mm.booter.MMReceivers$ToolsProcessReceiver"));
                        intent.putExtra("tools_process_action_code_key", "com.tencent.mm.intent.ACTION_START_TOOLS_PROCESS");
                        ae.this.mContext.sendBroadcast(intent);
                    }
                }, 100);
                break;
            case 13:
                com.tencent.mm.sdk.b.a.sFg.m(new nh());
                com.tencent.mm.bg.d.A(this.mContext, "shake", ".ui.ShakeReportUI");
                break;
            case 14:
                au.HU();
                if (!bi.d((Boolean) c.DT().get(4103, null))) {
                    com.tencent.mm.bg.d.A(this.mContext, "nearby", ".ui.NearbyFriendsIntroUI");
                    break;
                }
                ID = bl.ID();
                if (ID != null) {
                    String oV = bi.oV(ID.getProvince());
                    a = bi.a(Integer.valueOf(ID.sex), 0);
                    if (!bi.oW(oV) && a != 0) {
                        au.HU();
                        Boolean bool = (Boolean) c.DT().get(4104, null);
                        if (bool != null && bool.booleanValue()) {
                            View inflate = View.inflate(this.mContext, R.i.lbs_open_dialog_view, null);
                            CheckBox checkBox = (CheckBox) inflate.findViewById(R.h.lbs_open_dialog_cb);
                            checkBox.setChecked(false);
                            com.tencent.mm.ui.base.h.a(this.mContext, this.mContext.getString(R.l.app_tip), inflate, new 4(this, checkBox), null);
                            break;
                        }
                        LauncherUI cpQ = LauncherUI.cpQ();
                        if (cpQ != null) {
                            cpQ.tkn.tjF.ZS("tab_find_friend");
                        }
                        com.tencent.mm.be.a.eF(this.mContext);
                        break;
                    }
                    com.tencent.mm.bg.d.A(this.mContext, "nearby", ".ui.NearbyPersonalInfoUI");
                    break;
                }
                com.tencent.mm.bg.d.A(this.mContext, "nearby", ".ui.NearbyPersonalInfoUI");
                break;
                break;
            case 15:
                ID = bl.IC();
                if (bi.a(Integer.valueOf(ID.sex), 0) > 0 && !bi.oW(ID.getProvince())) {
                    com.tencent.mm.bg.d.A(this.mContext, "bottle", ".ui.BottleBeachUI");
                    break;
                } else {
                    com.tencent.mm.bg.d.A(this.mContext, "bottle", ".ui.BottleWizardStep1");
                    break;
                }
                break;
            case 16:
                au.HU();
                if (!c.FM()) {
                    com.tencent.mm.bg.d.A(this.mContext, "webwx", ".ui.WebWeiXinIntroductionUI");
                    break;
                } else {
                    com.tencent.mm.bg.d.A(this.mContext, "webwx", ".ui.WebWXLogoutUI");
                    break;
                }
            case 17:
                if ((q.GQ() & 65536) != 0) {
                    z = false;
                }
                if (!z) {
                    com.tencent.mm.bg.d.b(this.mContext, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", "masssendapp"));
                    break;
                } else {
                    com.tencent.mm.bg.d.A(this.mContext, "masssend", ".ui.MassSendHistoryUI");
                    break;
                }
            case 18:
                com.tencent.mm.bg.d.A(this.mContext, "radar", ".ui.RadarSearchUI");
                break;
            case 19:
                com.tencent.mm.bg.d.A(this.mContext, "pwdgroup", ".ui.FacingCreateChatRoomAllInOneUI");
                break;
            case 20:
                Context context = this.mContext;
                intent2 = new Intent();
                intent2.putExtra("key_from_scene", 2);
                com.tencent.mm.bg.d.b(context, "offline", ".ui.WalletOfflineEntranceUI", intent2);
                if (com.tencent.mm.s.c.Cp().aU(262159, 266248)) {
                    com.tencent.mm.s.c.Cp().aV(262159, 266248);
                    h.mEJ.h(14396, new Object[]{Integer.valueOf(2)});
                    break;
                }
                break;
            case 22:
                com.tencent.mm.pluginsdk.wallet.h.Z(this.mContext, 1);
                break;
            case 2147483645:
                intent2 = new Intent();
                au.HU();
                str = (String) c.DT().get(a.sXb, "");
                if (!bi.oW(str)) {
                    intent2.putExtra("rawUrl", str);
                    intent2.putExtra("showShare", true);
                    intent2.putExtra("show_bottom", false);
                    com.tencent.mm.bg.d.b(this.mContext, "webview", ".ui.tools.WebViewUI", intent2);
                    break;
                }
                com.tencent.mm.pluginsdk.d.eJ(this.mContext);
                break;
            case 2147483646:
                intent = new Intent();
                intent.putExtra("key_from_scene", 2);
                com.tencent.mm.bg.d.b(this.mContext, "offline", ".ui.WalletOfflineEntranceUI", intent);
                break;
            case Integer.MAX_VALUE:
                h.mEJ.k(10919, "1-6");
                com.tencent.mm.pluginsdk.d.eJ(this.mContext);
                break;
        }
        this.tpK.DZ(i2);
        dismiss();
    }

    public static d Ea(int i) {
        Context context = ad.getContext();
        switch (i) {
            case 1:
                if (HomeUI.tjy.booleanValue()) {
                    return new d(1, context.getString(R.l.menu_item_add_friend), "", R.k.ofm_add_green_icon, R.e.wechat_green);
                }
                return new d(1, context.getString(R.l.menu_item_add_friend), "", R.k.ofm_add_icon, 0);
            case 2:
                if (HomeUI.tjz.booleanValue()) {
                    return new d(2, context.getString(R.l.menu_item_new_group_chat), "", R.k.ofm_group_chat_green_icon, R.e.wechat_green);
                }
                return new d(2, context.getString(R.l.menu_item_new_group_chat), "", R.k.ofm_group_chat_icon, 0);
            case 3:
                return new d(3, context.getString(R.l.menu_item_send_image), "", R.k.camera, 0);
            case 4:
                if (1 == bi.getInt(com.tencent.mm.k.g.AT().getValue("VOIPCallType"), 0)) {
                    return new d(4, context.getString(R.l.menu_item_video_call), "", R.k.ofm_video_icon, 0);
                }
                return new d(4, context.getString(R.l.menu_item_audio_call), "", R.k.ofm_audio_icon, 0);
            case 5:
                return new d(5, context.getString(R.l.settings_my_album), "", R.k.ofm_pic_icon, 0);
            case 6:
                return new d(6, context.getString(R.l.settings_mm_favorite), "", R.k.ofm_favourite_icon, 0);
            case 7:
                return new d(7, context.getString(R.l.settings_mm_wallet), "", R.k.ofm_card_icon, 0);
            case 8:
                return new d(8, context.getString(R.l.emoji_store), "", R.k.ofm_emostore_icon, 0);
            case 9:
                return new d(9, context.getString(R.l.settings_my_qrcode), "", R.k.ofm_myqrcode_icon, 0);
            case 10:
                return new d(10, context.getString(R.l.find_friends_by_qrcode), "", R.k.ofm_qrcode_icon, 0);
            case 11:
                return new d(11, context.getString(R.l.sns_dyna_photo_ui_title), "", R.k.ofm_moment_icon, 0);
            case 12:
                return new d(12, context.getString(R.l.game_recommand), "", R.k.ofm_gamecenter_icon, 0);
            case 13:
                return new d(13, context.getString(R.l.shake_report_title), "", R.k.ofm_shake_icon, 0);
            case 14:
                return new d(14, context.getString(R.l.nearby_friend_title), "", R.k.ofm_nearby_icon, 0);
            case 15:
                return new d(15, context.getString(R.l.bottle_beach_title), "", R.k.ofm_bottle_icon, 0);
            case 16:
                return new d(16, context.getString(R.l.settings_WebWX), "", R.k.ofm_webwechat_icon, 0);
            case 17:
                return new d(17, context.getString(R.l.mass_send_helper), "", R.k.ofm_groupmessage_icon, 0);
            case 18:
                return new d(18, context.getString(R.l.find_friends_by_radar), "", R.k.ofm_radar_icon, 0);
            case 19:
                return new d(19, context.getString(R.l.find_friends_create_pwdgroup), "", R.k.actionbar_facefriend_icon, 0);
            case 20:
                au.HU();
                if (((Integer) c.DT().get(a.sTs, Integer.valueOf(0))).intValue() <= 1) {
                    return new d(20, context.getString(R.l.address_title_face_to_face), "", R.k.receipt_payment_icon, 0);
                }
                break;
            case 22:
                au.HU();
                if (((Integer) c.DT().get(a.sTs, Integer.valueOf(0))).intValue() == 8) {
                    return new d(22, context.getString(R.l.plus_wallet_pay_or_collect_tip_for_collect), "", R.k.offline_entrance_f2f_collect, 0);
                }
                break;
            case 2147483645:
                return new d(2147483645, context.getString(R.l.settings_crowdtest_feedback), "", R.k.ofm_feedback_icon, 0);
            case 2147483646:
                return new d(2147483646, "TIT", "", R.k.ofm_card_icon, 0);
            case Integer.MAX_VALUE:
                return new d(Integer.MAX_VALUE, context.getString(R.l.settings_feedback), "", R.k.ofm_feedback_icon, 0);
        }
        return null;
    }

    protected final BaseAdapter avF() {
        if (this.tpJ == null) {
            this.tpJ = new a(this, (byte) 0);
        }
        return this.tpJ;
    }
}

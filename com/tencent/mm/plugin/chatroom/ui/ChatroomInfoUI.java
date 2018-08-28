package com.tencent.mm.plugin.chatroom.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import com.tencent.mm.R;
import com.tencent.mm.ab.e;
import com.tencent.mm.aq.n;
import com.tencent.mm.ax.a;
import com.tencent.mm.ax.g;
import com.tencent.mm.g.a.ka;
import com.tencent.mm.g.a.pc;
import com.tencent.mm.g.a.rn;
import com.tencent.mm.g.a.sh;
import com.tencent.mm.model.am;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.l;
import com.tencent.mm.model.m;
import com.tencent.mm.model.q;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.appbrand.ui.widget.AppBrandLoadIconPreference;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.report.kvdata.IMBehavior;
import com.tencent.mm.plugin.report.kvdata.IMBehaviorChattingOP;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference;
import com.tencent.mm.pluginsdk.ui.d;
import com.tencent.mm.pluginsdk.ui.preference.RoomCardPreference;
import com.tencent.mm.pluginsdk.ui.preference.SignaturePreference;
import com.tencent.mm.protocal.c.aqv;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.NormalIconPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceCategory;
import com.tencent.mm.ui.base.preference.f;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class ChatroomInfoUI extends MMPreference implements e, a, j.a, b {
    private static boolean hLS = false;
    private boolean bSD;
    private SharedPreferences duR = null;
    private ProgressDialog eHw = null;
    private f eOE;
    String eOz;
    private p eXe = null;
    private String fsV;
    private ab guS;
    private boolean hEj;
    private boolean hLA = false;
    private u hLB = null;
    private int hLC = -1;
    private boolean hLD = true;
    private boolean hLE = false;
    private boolean hLF = false;
    private boolean hLG = false;
    private d hLH = new d(new 11(this));
    boolean hLI = false;
    private c hLJ = new 36(this);
    int hLK = -1;
    private boolean hLL = false;
    private h.a hLM;
    int hLN;
    private c hLO = new 8(this);
    private String hLP = "";
    private h.a hLQ;
    private String hLR;
    private String hLT = null;
    private com.tencent.mm.pluginsdk.c.b hLU = new 26(this);
    private al hLV = null;
    private int hLW = 0;
    private boolean hLj;
    private RoomCardPreference hLk;
    private SignaturePreference hLl;
    private Preference hLm;
    private NormalIconPreference hLn;
    private NormalIconPreference hLo;
    private ContactListExpandPreference hLp;
    private CheckBoxPreference hLq;
    private CheckBoxPreference hLr;
    private CheckBoxPreference hLs;
    private SignaturePreference hLt;
    private CheckBoxPreference hLu;
    private AppBrandLoadIconPreference hLv;
    private boolean hLw;
    private boolean hLx;
    private boolean hLy = false;
    private int hLz;
    private ag handler = new ag(Looper.getMainLooper()) {
        public final void handleMessage(Message message) {
            ChatroomInfoUI.a(ChatroomInfoUI.this);
        }
    };
    private boolean isDeleteCancel = false;

    static /* synthetic */ void y(ChatroomInfoUI chatroomInfoUI) {
        com.tencent.mm.plugin.report.service.h.mEJ.h(14553, new Object[]{Integer.valueOf(4), Integer.valueOf(2), chatroomInfoUI.fsV});
        au.HU();
        long j = com.tencent.mm.model.c.FT().GD(chatroomInfoUI.fsV).field_msgSvrId;
        au.HU();
        com.tencent.mm.model.c.FQ().b(new com.tencent.mm.aq.d(chatroomInfoUI.fsV, j));
        chatroomInfoUI.isDeleteCancel = false;
        chatroomInfoUI.getString(R.l.app_tip);
        final p a = com.tencent.mm.ui.base.h.a(chatroomInfoUI, chatroomInfoUI.getString(R.l.app_waiting), true, new 15(chatroomInfoUI));
        if (bi.oW(!chatroomInfoUI.isDeleteCancel ? com.tencent.mm.pluginsdk.wallet.e.Uk(chatroomInfoUI.guS.field_username) : null)) {
            chatroomInfoUI.dX(true);
            return;
        }
        a.dismiss();
        Object[] objArr = new Object[]{r0};
        com.tencent.mm.ui.base.h.a(chatroomInfoUI, false, chatroomInfoUI.getString(R.l.wallet_clear_exit_groupchat_note, objArr), null, chatroomInfoUI.getString(R.l.goto_conversation), chatroomInfoUI.getString(R.l.room_del_quit), new 16(chatroomInfoUI), new OnClickListener() {
            final /* synthetic */ boolean hMb = true;

            public final void onClick(DialogInterface dialogInterface, int i) {
                com.tencent.mm.plugin.report.service.h.mEJ.h(14553, new Object[]{Integer.valueOf(4), Integer.valueOf(3), ChatroomInfoUI.this.fsV});
                a.show();
                ChatroomInfoUI.this.isDeleteCancel = false;
                ChatroomInfoUI.this.dX(this.hMb);
            }
        }, -1, R.e.alert_btn_color_warn);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        au.DF().a(223, this);
        au.DF().a(179, this);
        au.DF().a(480, this);
        au.DF().a(610, this);
        com.tencent.mm.pluginsdk.c.b.a(ka.class.getName(), this.hLU);
        this.hLJ.cht().a(this);
        this.hLO.cht().a(this);
        au.HU();
        com.tencent.mm.model.c.FR().a(this);
        au.HU();
        com.tencent.mm.model.c.Ga().c(this);
        if (g.elf != null) {
            g.elf.a(this);
        }
        this.fsV = getIntent().getStringExtra("RoomInfo_Id");
        au.HU();
        this.guS = com.tencent.mm.model.c.FR().Yg(this.fsV);
        this.hLD = true;
        this.bSD = getIntent().getBooleanExtra("Is_Chatroom", true);
        this.hLj = getIntent().getBooleanExtra("Is_Lbsroom", false);
        this.hLE = getIntent().getBooleanExtra("fromChatting", false);
        this.hLF = getIntent().getBooleanExtra("isShowSetMuteAnimation", false);
        this.hLP = getPackageName() + "_preferences";
        if (this.bSD) {
            au.HU();
            this.hLB = com.tencent.mm.model.c.Ga().ih(this.fsV);
        }
        initView();
        if (this.bSD) {
            22 22 = new 22(this);
            if (this.hLB == null) {
                am.a.dBr.a(this.fsV, "", 22);
            } else if (System.currentTimeMillis() - this.hLB.field_modifytime >= 86400000) {
                au.Em().H(new 32(this, 22));
            }
        }
    }

    private void aAw() {
        x.i("MicroMsg.ChatroomInfoUI", "[doChatroomDetailCgi] :%s", new Object[]{this.fsV});
        new com.tencent.mm.plugin.chatroom.d.c(this.fsV).KM().c(this).h(new 35(this)).b(new 34(this));
    }

    public void onResume() {
        boolean F;
        String stringExtra;
        super.onResume();
        au.DF().a(120, this);
        this.eOE.notifyDataSetChanged();
        if (this.hLB != null) {
            com.tencent.mm.i.a.a.a ckQ = this.hLB.ckQ();
            if (ckQ != null) {
                F = m.F(this.hLB.field_chatroomname, ckQ.daz);
                x.i("MicroMsg.ChatroomInfoUI", "roomId:%s newVer:%s localVer:%s owner:%s", new Object[]{this.hLB.field_chatroomname, Integer.valueOf(ckQ.daz), Integer.valueOf(this.hLB.field_chatroomVersion), this.hLB.field_roomowner});
                if (m.gD(this.fsV) || F) {
                    aAw();
                }
                aAF();
                updateTitle();
                aAE();
                if (this.bSD) {
                    aAG();
                    aAD();
                }
                if (this.hLD) {
                    aAC();
                    this.hLD = false;
                }
                stringExtra = getIntent().getStringExtra("need_matte_high_light_item");
                if (!this.hLI) {
                    if (!bi.oW(stringExtra)) {
                        yn(stringExtra);
                    }
                    this.hLI = true;
                }
                if (!(bi.oW(stringExtra) || !stringExtra.equals("room_notify_new_notice") || this.hLI)) {
                    yn("room_card");
                    this.hLI = true;
                }
                x.d("MicroMsg.ChatroomInfoUI", "showSetMuteAnimation isShowSetMuteAnimation[%b]", new Object[]{Boolean.valueOf(this.hLF)});
                if (this.hLF) {
                    this.hLF = false;
                    ah.i(new 30(this), 50);
                }
            }
        }
        F = false;
        aAw();
        aAF();
        updateTitle();
        aAE();
        if (this.bSD) {
            aAG();
            aAD();
        }
        if (this.hLD) {
            aAC();
            this.hLD = false;
        }
        stringExtra = getIntent().getStringExtra("need_matte_high_light_item");
        if (this.hLI) {
            if (!bi.oW(stringExtra)) {
                yn(stringExtra);
            }
            this.hLI = true;
        }
        yn("room_card");
        this.hLI = true;
        x.d("MicroMsg.ChatroomInfoUI", "showSetMuteAnimation isShowSetMuteAnimation[%b]", new Object[]{Boolean.valueOf(this.hLF)});
        if (this.hLF) {
            this.hLF = false;
            ah.i(new 30(this), 50);
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.hLp.notifyChanged();
    }

    private void yn(String str) {
        int aab = this.eOE.aab(str);
        this.kww.smoothScrollToPosition(aab);
        new ag().postDelayed(new 37(this, aab), 10);
    }

    public void onPause() {
        super.onPause();
        au.DF().b(120, this);
        if (this.hLA && this.bSD && this.hLB != null) {
            m.a(this.fsV, this.hLB, this.hLw);
        }
    }

    public void onDestroy() {
        if (g.elf != null) {
            g.elf.a(this);
        }
        com.tencent.mm.ui.g.a.dismiss();
        au.DF().b(223, this);
        au.DF().b(179, this);
        au.DF().b(480, this);
        au.DF().b(610, this);
        com.tencent.mm.sdk.b.a.sFg.c(this.hLO);
        com.tencent.mm.sdk.b.a.sFg.c(this.hLJ);
        com.tencent.mm.pluginsdk.c.b.b(ka.class.getName(), this.hLU);
        if (au.HX()) {
            au.HU();
            com.tencent.mm.model.c.FR().b(this);
            au.HU();
            com.tencent.mm.model.c.Ga().d(this);
        }
        if (g.elf != null) {
            g.elf.b(this);
        }
        if (this.hLv != null) {
            AppBrandLoadIconPreference.onDestroy();
        }
        if (this.hLV != null) {
            this.hLV.SO();
        }
        super.onDestroy();
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        String stringExtra;
        switch (i) {
            case 1:
                if (intent != null) {
                    stringExtra = intent.getStringExtra("Select_Contact");
                    au.HU();
                    u ih = com.tencent.mm.model.c.Ga().ih(this.fsV);
                    if (ih == null) {
                        return;
                    }
                    if (ih.ckN() != 2 || this.hLy) {
                        q(stringExtra, null, R.l.adding_room_mem);
                        return;
                    } else {
                        com.tencent.mm.pluginsdk.ui.applet.g.b(this.mController, getString(R.l.request_to_owner_tip), getString(R.l.reason_invite_hint), getString(R.l.app_send), new 38(this, stringExtra));
                        return;
                    }
                }
                return;
            case 2:
                if (i2 == -1) {
                    finish();
                    return;
                }
                return;
            case 4:
                if (i2 == -1) {
                    stringExtra = intent.getStringExtra("room_name");
                    if (!bi.oW(stringExtra)) {
                        com.tencent.mm.sdk.b.a.sFg.m(new sh());
                        this.guS.dx(stringExtra);
                        au.HU();
                        com.tencent.mm.model.c.FR().S(this.guS);
                        aAG();
                        return;
                    }
                    return;
                }
                return;
            case 5:
                if (i2 == 0) {
                    this.hLK = -1;
                    return;
                }
                return;
            case 7:
                if (intent != null) {
                    stringExtra = intent.getStringExtra("Select_Contact");
                    if (stringExtra != null && !stringExtra.equals("")) {
                        com.tencent.mm.plugin.chatroom.d.g gVar = new com.tencent.mm.plugin.chatroom.d.g(this.fsV, bi.F(stringExtra.split(",")));
                        getString(R.l.app_tip);
                        this.eHw = com.tencent.mm.ui.base.h.a(this, getString(R.l.room_del_member), true, new 19(this, gVar));
                        au.DF().a(gVar, 0);
                        return;
                    }
                    return;
                }
                return;
            default:
                return;
        }
    }

    public final int Ys() {
        return R.o.roominfo_pref;
    }

    protected final void initView() {
        this.eOE = this.tCL;
        String str;
        if (this.bSD) {
            u ih;
            if (this.hLz == 0) {
                setMMTitle(getString(R.l.roominfo_name));
            } else {
                if (this.hLB != null) {
                    this.hLz = this.hLB.Nn().size();
                }
                setMMTitle(getString(R.l.fmt_chatting_title_group, new Object[]{getString(R.l.roominfo_name), Integer.valueOf(this.hLz)}));
            }
            str = null;
            if (this.hLB != null) {
                str = this.hLB.field_roomowner;
                this.hLz = this.hLB.Nn().size();
            }
            if (bi.oW(str)) {
                this.hLx = false;
                this.hLy = false;
            } else {
                this.hLx = true;
                this.hLy = str.equals(q.GF());
            }
            x.d("MicroMsg.ChatroomInfoUI", "initBaseChatRoomView()");
            this.hLp = (ContactListExpandPreference) this.eOE.ZZ("roominfo_contact_anchor");
            this.hLp.a(this.eOE, this.hLp.mKey);
            this.hLo = (NormalIconPreference) this.eOE.ZZ("del_selector_btn");
            this.hLn = (NormalIconPreference) this.eOE.ZZ("add_selector_btn");
            this.hLl = (SignaturePreference) this.eOE.ZZ("room_name");
            this.hLk = (RoomCardPreference) this.eOE.ZZ("room_card");
            this.hLm = this.eOE.ZZ("see_room_member");
            this.hLq = (CheckBoxPreference) this.eOE.ZZ("room_notify_new_msg");
            this.hLr = (CheckBoxPreference) this.eOE.ZZ("room_save_to_contact");
            this.hLs = (CheckBoxPreference) this.eOE.ZZ("room_placed_to_the_top");
            this.hLt = (SignaturePreference) this.eOE.ZZ("room_nickname");
            this.hLp.kG(true).kH(true).cdW();
            if (!this.hLy) {
                this.eOE.bw("del_selector_btn", true);
            } else if (m.gK(this.fsV) > 2) {
                this.eOE.bw("manage_room", false);
                if (this.hLB != null) {
                    this.hLp.TL(this.hLB.field_roomowner);
                    if (!bi.oW(this.hLB.field_roomowner)) {
                        this.hLp.qJA.qIM.qJq = true;
                    }
                }
                this.hLp.cdU();
                this.hLp.cdX();
                this.eOE.bw("add_selector_btn", true);
                this.eOE.bw("del_selector_btn", true);
                this.eOE.bw("room_name", false);
                this.eOE.bw("room_qr_code", false);
                this.eOE.bw("chatroom_info_chexboxes", true);
                this.eOE.bw("room_card", false);
                this.eOE.bw("room_upgrade_entry", true);
                if ((!this.hLy || this.hLz < com.tencent.mm.pluginsdk.ui.applet.j.qIV) && (!this.hLy || this.hLz < com.tencent.mm.pluginsdk.ui.applet.j.qIV - 1)) {
                    this.eOE.bw("see_room_member", true);
                } else {
                    this.eOE.bw("see_room_member", false);
                    this.hLm.setTitle(getString(R.l.see_member_selector_btn, new Object[]{Integer.valueOf(this.hLz)}));
                }
                this.hLv = (AppBrandLoadIconPreference) this.eOE.ZZ("chat_room_app_brand");
                this.hLv.gBf = this.fsV;
                x.d("MicroMsg.ChatroomInfoUI", "updatePlaceTop()");
                if (this.duR == null) {
                    this.duR = getSharedPreferences(getPackageName() + "_preferences", 0);
                }
                if (this.hLs != null) {
                    if (this.guS != null) {
                        au.HU();
                        this.duR.edit().putBoolean("room_placed_to_the_top", com.tencent.mm.model.c.FW().Yx(this.guS.field_username)).commit();
                    } else {
                        this.duR.edit().putBoolean("room_placed_to_the_top", false).commit();
                    }
                }
                this.eOE.notifyDataSetChanged();
                x.d("MicroMsg.ChatroomInfoUI", "updateSaveToContact()");
                if (this.duR == null) {
                    this.duR = getSharedPreferences(getPackageName() + "_preferences", 0);
                }
                if (this.hLr != null) {
                    au.HU();
                    ab Yg = com.tencent.mm.model.c.FR().Yg(this.fsV);
                    if (Yg == null) {
                        x.e("MicroMsg.ChatroomInfoUI", "contact == null !!!");
                        x.d("MicroMsg.ChatroomInfoUI", "updateDisplayNickname()");
                        if (this.duR == null) {
                            this.duR = getSharedPreferences(getPackageName() + "_preferences", 0);
                        }
                        au.HU();
                        ih = com.tencent.mm.model.c.Ga().ih(this.fsV);
                        if (ih == null) {
                            x.e("MicroMsg.ChatroomInfoUI", "members == null !!!");
                        } else {
                            this.hLw = ih.ckP();
                            this.hLu = (CheckBoxPreference) this.eOE.ZZ("room_msg_show_username");
                            if (this.hLu != null) {
                                this.duR.edit().putBoolean("room_msg_show_username", this.hLw).commit();
                            }
                            this.eOE.notifyDataSetChanged();
                        }
                        au.HU();
                        this.hLC = com.tencent.mm.model.c.FT().GW(this.fsV);
                    } else {
                        this.duR.edit().putBoolean("room_save_to_contact", com.tencent.mm.l.a.gd(Yg.field_type)).commit();
                    }
                }
                this.eOE.notifyDataSetChanged();
                x.d("MicroMsg.ChatroomInfoUI", "updateDisplayNickname()");
                if (this.duR == null) {
                    this.duR = getSharedPreferences(getPackageName() + "_preferences", 0);
                }
                au.HU();
                ih = com.tencent.mm.model.c.Ga().ih(this.fsV);
                if (ih == null) {
                    this.hLw = ih.ckP();
                    this.hLu = (CheckBoxPreference) this.eOE.ZZ("room_msg_show_username");
                    if (this.hLu != null) {
                        this.duR.edit().putBoolean("room_msg_show_username", this.hLw).commit();
                    }
                    this.eOE.notifyDataSetChanged();
                } else {
                    x.e("MicroMsg.ChatroomInfoUI", "members == null !!!");
                }
                au.HU();
                this.hLC = com.tencent.mm.model.c.FT().GW(this.fsV);
            }
            this.eOE.bw("manage_room", true);
            if (this.hLB != null) {
                this.hLp.TL(this.hLB.field_roomowner);
                if (!bi.oW(this.hLB.field_roomowner)) {
                    this.hLp.qJA.qIM.qJq = true;
                }
            }
            this.hLp.cdU();
            this.hLp.cdX();
            this.eOE.bw("add_selector_btn", true);
            this.eOE.bw("del_selector_btn", true);
            this.eOE.bw("room_name", false);
            this.eOE.bw("room_qr_code", false);
            this.eOE.bw("chatroom_info_chexboxes", true);
            this.eOE.bw("room_card", false);
            this.eOE.bw("room_upgrade_entry", true);
            if (this.hLy) {
            }
            this.eOE.bw("see_room_member", true);
            this.hLv = (AppBrandLoadIconPreference) this.eOE.ZZ("chat_room_app_brand");
            this.hLv.gBf = this.fsV;
            x.d("MicroMsg.ChatroomInfoUI", "updatePlaceTop()");
            if (this.duR == null) {
                this.duR = getSharedPreferences(getPackageName() + "_preferences", 0);
            }
            if (this.hLs != null) {
                if (this.guS != null) {
                    au.HU();
                    this.duR.edit().putBoolean("room_placed_to_the_top", com.tencent.mm.model.c.FW().Yx(this.guS.field_username)).commit();
                } else {
                    this.duR.edit().putBoolean("room_placed_to_the_top", false).commit();
                }
            }
            this.eOE.notifyDataSetChanged();
            x.d("MicroMsg.ChatroomInfoUI", "updateSaveToContact()");
            if (this.duR == null) {
                this.duR = getSharedPreferences(getPackageName() + "_preferences", 0);
            }
            if (this.hLr != null) {
                au.HU();
                ab Yg2 = com.tencent.mm.model.c.FR().Yg(this.fsV);
                if (Yg2 == null) {
                    x.e("MicroMsg.ChatroomInfoUI", "contact == null !!!");
                    x.d("MicroMsg.ChatroomInfoUI", "updateDisplayNickname()");
                    if (this.duR == null) {
                        this.duR = getSharedPreferences(getPackageName() + "_preferences", 0);
                    }
                    au.HU();
                    ih = com.tencent.mm.model.c.Ga().ih(this.fsV);
                    if (ih == null) {
                        x.e("MicroMsg.ChatroomInfoUI", "members == null !!!");
                    } else {
                        this.hLw = ih.ckP();
                        this.hLu = (CheckBoxPreference) this.eOE.ZZ("room_msg_show_username");
                        if (this.hLu != null) {
                            this.duR.edit().putBoolean("room_msg_show_username", this.hLw).commit();
                        }
                        this.eOE.notifyDataSetChanged();
                    }
                    au.HU();
                    this.hLC = com.tencent.mm.model.c.FT().GW(this.fsV);
                } else {
                    this.duR.edit().putBoolean("room_save_to_contact", com.tencent.mm.l.a.gd(Yg2.field_type)).commit();
                }
            }
            this.eOE.notifyDataSetChanged();
            x.d("MicroMsg.ChatroomInfoUI", "updateDisplayNickname()");
            if (this.duR == null) {
                this.duR = getSharedPreferences(getPackageName() + "_preferences", 0);
            }
            au.HU();
            ih = com.tencent.mm.model.c.Ga().ih(this.fsV);
            if (ih == null) {
                x.e("MicroMsg.ChatroomInfoUI", "members == null !!!");
            } else {
                this.hLw = ih.ckP();
                this.hLu = (CheckBoxPreference) this.eOE.ZZ("room_msg_show_username");
                if (this.hLu != null) {
                    this.duR.edit().putBoolean("room_msg_show_username", this.hLw).commit();
                }
                this.eOE.notifyDataSetChanged();
            }
            au.HU();
            this.hLC = com.tencent.mm.model.c.FT().GW(this.fsV);
        } else if (this.hLj) {
            this.hLy = false;
            setMMTitle(getString(R.l.room_lbsroom_member_title_init));
            this.hLp = (ContactListExpandPreference) this.eOE.ZZ("roominfo_contact_anchor");
            this.hLp.a(this.eOE, this.hLp.mKey);
            this.hLp.kG(false).kH(false);
            this.hLp.a(new 6(this));
            this.eOE.removeAll();
            this.eOE.a(new PreferenceCategory(this));
            this.eOE.a(this.hLp);
            str = this.fsV;
            final ka kaVar = new ka();
            kaVar.bUo.bSr = str;
            com.tencent.mm.sdk.b.a.sFg.m(kaVar);
            getString(R.l.app_tip);
            this.eHw = com.tencent.mm.ui.base.h.a(this, getString(R.l.room_lbsroom_member_loading), true, new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    ChatroomInfoUI.a(kaVar);
                }
            });
            this.eOE.notifyDataSetChanged();
        }
        if (this.hLp != null) {
            if (!this.bSD && this.hLj) {
                this.hLp.aa(new ArrayList());
            }
            this.kww.setOnScrollListener(this.hLH);
            this.hLp.a(this.hLH);
            this.hLp.a(new 2(this));
            ContactListExpandPreference contactListExpandPreference = this.hLp;
            View.OnClickListener anonymousClass3 = new View.OnClickListener() {
                public final void onClick(View view) {
                }
            };
            if (contactListExpandPreference.qJA != null) {
                contactListExpandPreference.qJA.mtE = anonymousClass3;
            }
            this.hLp.a(new ContactListExpandPreference.a() {
                public final void of(int i) {
                    ChatroomInfoUI.this.aAz();
                }

                public final void og(int i) {
                    String Cc = ChatroomInfoUI.this.hLp.Cc(i);
                    String oV = bi.oV(ChatroomInfoUI.this.hLp.Ce(i));
                    if (bi.oW(oV)) {
                        au.HU();
                        bq Hh = com.tencent.mm.model.c.FS().Hh(Cc);
                        if (!(Hh == null || bi.oW(Hh.field_encryptUsername))) {
                            oV = Hh.field_conRemark;
                        }
                    }
                    if (!bi.oW(Cc)) {
                        Intent intent = new Intent();
                        intent.putExtra("Contact_User", Cc);
                        intent.putExtra("Contact_RemarkName", oV);
                        if (ChatroomInfoUI.this.bSD && ChatroomInfoUI.this.hLB != null) {
                            intent.putExtra("Contact_RoomNickname", ChatroomInfoUI.this.hLB.gT(Cc));
                        }
                        intent.putExtra("Contact_Nick", bi.oV(ChatroomInfoUI.this.hLp.Cd(i)));
                        intent.putExtra("Contact_RoomMember", true);
                        intent.putExtra("room_name", ChatroomInfoUI.this.guS.field_username);
                        au.HU();
                        ab Yg = com.tencent.mm.model.c.FR().Yg(Cc);
                        if (Yg != null && ((int) Yg.dhP) > 0 && com.tencent.mm.l.a.gd(Yg.field_type)) {
                            pc pcVar = new pc();
                            pcVar.bZW.intent = intent;
                            pcVar.bZW.username = Cc;
                            com.tencent.mm.sdk.b.a.sFg.m(pcVar);
                        }
                        if (ChatroomInfoUI.this.bSD) {
                            com.tencent.mm.plugin.report.service.h.mEJ.a(219, 9, 1, true);
                            if (Yg != null && Yg.ckW()) {
                                com.tencent.mm.plugin.report.service.h.mEJ.k(10298, Yg.field_username + ",14");
                            }
                            intent.putExtra("Contact_Scene", 14);
                        } else if (ChatroomInfoUI.this.hLj) {
                            intent.putExtra("Contact_Scene", 44);
                            if (!q.gQ(Yg.field_username)) {
                                intent.putExtra("Contact_IsLBSFriend", true);
                            }
                        }
                        intent.putExtra("Is_RoomOwner", ChatroomInfoUI.this.hLy);
                        intent.putExtra("Contact_ChatRoomId", ChatroomInfoUI.this.fsV);
                        com.tencent.mm.plugin.chatroom.a.ezn.d(intent, ChatroomInfoUI.this);
                    }
                }

                public final void aAK() {
                    if (ChatroomInfoUI.this.hLp != null) {
                        ChatroomInfoUI.this.hLp.cdV();
                    }
                }

                public final void oh(int i) {
                    ChatroomInfoUI.this.aAy();
                }
            });
        }
        setBackBtn(new 5(this));
    }

    public final boolean a(f fVar, Preference preference) {
        int i = 1;
        String str = preference.mKey;
        int i2;
        Intent intent;
        Intent intent2;
        com.tencent.mm.modelstat.b bVar;
        String str2;
        boolean z;
        IMBehavior iMBehavior;
        String aAx;
        if (str.equals("room_name")) {
            str = com.tencent.mm.k.g.AT().getValue("ChatRoomOwnerModTopic");
            if (bi.oW(str)) {
                i2 = 0;
            } else {
                i2 = bi.WU(str);
            }
            if (bi.oW(this.hLB.field_roomowner) || i2 <= 0 || this.hLy || i2 >= this.hLz) {
                str = "";
                if (aAH()) {
                    str = this.guS.BL();
                }
                intent = new Intent();
                intent.setClass(this, ModRemarkRoomNameUI.class);
                intent.putExtra("room_name", str);
                intent.putExtra("RoomInfo_Id", this.fsV);
                startActivityForResult(intent, 4);
                com.tencent.mm.plugin.report.service.h.mEJ.a(219, 3, 1, true);
            } else {
                com.tencent.mm.ui.base.h.a(this, getString(R.l.room_too_many_member_to_mod_topic, new Object[]{aAA()}), null, getString(R.l.app_i_known), new 7(this));
            }
        } else if (str.equals("room_upgrade_entry")) {
            cU(this);
        } else if (str.equals("room_qr_code")) {
            com.tencent.mm.plugin.report.service.h.mEJ.a(219, 5, 1, true);
            intent2 = new Intent();
            intent2.putExtra("from_userName", this.fsV);
            com.tencent.mm.bg.d.b(this, "setting", ".ui.setting.SelfQRCodeUI", intent2);
        } else if (str.equals("room_card")) {
            if (!bi.oW(m.gM(this.fsV)) || this.hLy) {
                intent2 = new Intent();
                intent2.setClass(this, RoomCardUI.class);
                intent2.putExtra("RoomInfo_Id", this.fsV);
                intent2.putExtra("room_name", this.hLk.fyL.toString());
                this.hLz = m.gI(this.fsV).size();
                intent2.putExtra("room_member_count", this.hLz);
                intent2.putExtra("room_owner_name", aAA());
                intent2.putExtra("room_notice", m.gM(this.fsV));
                intent2.putExtra("room_notice_publish_time", m.gO(this.fsV));
                intent2.putExtra("room_notice_editor", m.gN(this.fsV));
                intent2.putExtra("Is_RoomOwner", this.hLy);
                startActivityForResult(intent2, 6);
            } else {
                com.tencent.mm.ui.base.h.a(this, getString(R.l.room_card_only_can_edit_notice_by_owner), null, getString(R.l.room_card_only_can_edit_notice_by_owner_knowned), null, null, null);
            }
        } else if (str.equals("room_notify_new_msg")) {
            this.hEj = !this.hEj;
            if (this.bSD) {
                i2 = this.hEj ? 0 : 1;
                au.HU();
                com.tencent.mm.model.c.FQ().b(new com.tencent.mm.aq.j(this.fsV, i2));
                au.HU();
                this.guS = com.tencent.mm.model.c.FR().Yg(this.fsV);
                this.guS.eN(i2);
                au.HU();
                com.tencent.mm.model.c.FR().a(this.fsV, this.guS);
                if (this.hLG) {
                    com.tencent.mm.plugin.report.service.h.mEJ.e(869, this.hEj ? 14 : 15, 1);
                }
            }
            bVar = com.tencent.mm.modelstat.b.ehL;
            str2 = this.fsV;
            z = this.hEj;
            if (bVar.RS() && bVar.cE(str2)) {
                iMBehavior = new IMBehavior();
                iMBehavior.opType = 1;
                iMBehavior.chattingOp = new IMBehaviorChattingOP();
                IMBehaviorChattingOP iMBehaviorChattingOP = iMBehavior.chattingOp;
                if (!z) {
                    i = 2;
                }
                iMBehaviorChattingOP.changeNotifyStatus = i;
                synchronized (bVar.lock) {
                    bVar.ehK.oplist_.add(iMBehavior);
                }
            }
            aAE();
        } else if (str.equals("room_save_to_contact")) {
            if (this.duR == null) {
                this.duR = getSharedPreferences(getPackageName() + "_preferences", 0);
            }
            au.HU();
            ab Yg = com.tencent.mm.model.c.FR().Yg(this.fsV);
            if (Yg != null) {
                z = com.tencent.mm.l.a.gd(Yg.field_type);
                this.duR.edit().putBoolean("room_save_to_contact", !z).commit();
                if (z) {
                    Yg.Bc();
                    s.t(Yg);
                    com.tencent.mm.ui.base.h.bA(this, getString(R.l.room_remove_from_group_card_ok));
                    com.tencent.mm.modelstat.b.ehL.L(this.fsV, false);
                } else {
                    s.q(Yg);
                    com.tencent.mm.ui.base.h.bA(this, getString(R.l.room_save_to_group_card_ok));
                    com.tencent.mm.modelstat.b.ehL.L(this.fsV, true);
                }
                this.eOE.notifyDataSetChanged();
            }
        } else if (str.equals("room_placed_to_the_top")) {
            SharedPreferences sharedPreferences = getSharedPreferences(this.hLP, 0);
            if (this.guS != null) {
                au.HU();
                if (com.tencent.mm.model.c.FW().Yx(this.guS.field_username)) {
                    s.u(this.guS.field_username, true);
                    com.tencent.mm.modelstat.b.ehL.c(false, this.fsV, false);
                } else {
                    s.t(this.guS.field_username, true);
                    com.tencent.mm.modelstat.b.ehL.c(false, this.fsV, true);
                }
                au.HU();
                sharedPreferences.edit().putBoolean("room_placed_to_the_top", com.tencent.mm.model.c.FW().Yx(this.guS.field_username)).commit();
            }
        } else if (str.equals("room_nickname")) {
            aAx = aAx();
            if (bi.oW(aAx)) {
                aAx = q.GH();
            }
            com.tencent.mm.ui.base.h.a(this.mController.tml, getString(R.l.room_my_displayname), aAx, getString(R.l.room_edit_my_nick_tips), 32, new 9(this, aAx));
        } else if (str.equals("room_msg_show_username")) {
            getSharedPreferences(this.hLP, 0).edit().putBoolean("room_msg_show_username", !this.hLw).commit();
            this.hLw = !this.hLw;
            this.hLA = true;
        } else if (str.equals("room_set_chatting_background")) {
            intent2 = new Intent();
            intent2.putExtra("isApplyToAll", false);
            intent2.putExtra("username", this.guS.field_username);
            com.tencent.mm.bg.d.b(this, "setting", ".ui.setting.SettingsChattingBackgroundUI", intent2, 2);
        } else if (str.equals("room_search_chatting_content")) {
            intent2 = new Intent();
            intent2.putExtra("detail_username", this.fsV);
            com.tencent.mm.plugin.fts.a.d.b(this, ".ui.FTSChattingConvUI", intent2);
            if (this.hLB == null || this.hLB.Nn() == null) {
                i2 = 0;
            } else {
                i2 = this.hLB.Nn().size();
            }
            com.tencent.mm.plugin.report.service.h.mEJ.h(14569, new Object[]{Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(i2), Integer.valueOf(1)});
        } else if (str.equals("room_clear_chatting_history")) {
            com.tencent.mm.ui.base.h.a(this.mController.tml, getString(R.l.fmt_delcontactmsg_confirm_group), "", getString(R.l.app_clear), getString(R.l.app_cancel), new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    String str;
                    com.tencent.mm.plugin.report.service.h.mEJ.h(14553, new Object[]{Integer.valueOf(3), Integer.valueOf(2), ChatroomInfoUI.this.fsV});
                    ChatroomInfoUI.hLS = false;
                    ChatroomInfoUI chatroomInfoUI = ChatroomInfoUI.this;
                    ChatroomInfoUI.this.getString(R.l.app_tip);
                    ProgressDialog a = com.tencent.mm.ui.base.h.a(chatroomInfoUI, ChatroomInfoUI.this.getString(R.l.app_waiting), true, new a());
                    if (l.gz(ChatroomInfoUI.this.guS.field_username)) {
                        com.tencent.mm.plugin.chatroom.a.ezo.cV(ChatroomInfoUI.this.guS.field_username);
                    }
                    if (ChatroomInfoUI.hLS) {
                        str = null;
                    } else {
                        str = com.tencent.mm.pluginsdk.wallet.e.Uk(ChatroomInfoUI.this.guS.field_username);
                    }
                    if (bi.oW(str)) {
                        bd.a(ChatroomInfoUI.this.guS.field_username, new bd.a(a) {
                            public final boolean Ip() {
                                return ChatroomInfoUI.hLS;
                            }

                            public final void Io() {
                                if (r3 != null) {
                                    r3.dismiss();
                                }
                            }
                        });
                        return;
                    }
                    a.dismiss();
                    com.tencent.mm.ui.base.h.a(ChatroomInfoUI.this, false, ChatroomInfoUI.this.getString(R.l.wallet_clear_chatting_history_note, new Object[]{str}), null, ChatroomInfoUI.this.getString(R.l.goto_conversation), ChatroomInfoUI.this.getString(R.l.clear_chat_history), new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            com.tencent.mm.plugin.report.service.h.mEJ.h(14553, new Object[]{Integer.valueOf(3), Integer.valueOf(4), ChatroomInfoUI.this.fsV});
                            ChatroomInfoUI.this.isDeleteCancel = true;
                            if (ChatroomInfoUI.this.hLE) {
                                ChatroomInfoUI.this.finish();
                                return;
                            }
                            Intent intent = new Intent();
                            intent.putExtra("Chat_User", ChatroomInfoUI.this.guS.field_username);
                            intent.addFlags(67108864);
                            com.tencent.mm.bg.d.e(ChatroomInfoUI.this, ".ui.chatting.ChattingUI", intent);
                        }
                    }, new 2(this, a), -1, R.e.alert_btn_color_warn);
                }
            }, null, R.e.alert_btn_color_warn);
        } else if (str.equals("room_report_it")) {
            intent2 = new Intent();
            intent2.putExtra("k_username", this.fsV);
            intent2.putExtra("showShare", false);
            intent2.putExtra("rawUrl", String.format("https://weixin110.qq.com/security/readtemplate?t=weixin_report/w_type&scene=%d#wechat_redirect", new Object[]{Integer.valueOf(36)}));
            com.tencent.mm.bg.d.b(this, "webview", ".ui.tools.WebViewUI", intent2);
            bVar = com.tencent.mm.modelstat.b.ehL;
            str2 = this.fsV;
            if (bVar.RS() && bVar.cE(str2)) {
                iMBehavior = new IMBehavior();
                iMBehavior.opType = 1;
                iMBehavior.chattingOp = new IMBehaviorChattingOP();
                iMBehavior.chattingOp.expose = 1;
                synchronized (bVar.lock) {
                    bVar.ehK.oplist_.add(iMBehavior);
                }
            }
        } else if (str.equals("room_del_quit")) {
            x.d("MicroMsg.ChatroomInfoUI", " quit " + this.fsV);
            rn rnVar = new rn();
            rnVar.ccn.ccp = true;
            com.tencent.mm.sdk.b.a.sFg.m(rnVar);
            boolean z2 = !bi.oW(this.fsV) && this.fsV.equals(rnVar.cco.ccr);
            if (z2) {
                x.d("MicroMsg.ChatroomInfoUI", " quit talkroom" + this.fsV);
            } else if (this.hLy && this.hLB.Nn().size() > 2) {
                com.tencent.mm.ui.base.h.a(this, "", new String[]{getString(R.l.room_owner_delete_direct)}, getString(R.l.app_cancel), new 13(this));
            }
            com.tencent.mm.ui.base.h.a(this.mController.tml, getString(R.l.del_room_mem_comfirm), "", getString(R.l.app_ok), getString(R.l.app_cancel), new 14(this, z2), null, R.e.alert_btn_color_warn);
        } else if (str.equals("add_selector_btn")) {
            aAy();
        } else if (str.equals("del_selector_btn")) {
            aAz();
        } else if (str.equals("see_room_member")) {
            intent = new Intent();
            intent.setClass(this.mController.tml, SeeRoomMemberUI.class);
            intent.putExtra("Block_list", q.GF());
            List gI = m.gI(this.fsV);
            if (gI != null) {
                this.hLz = gI.size();
            }
            intent.putExtra("Chatroom_member_list", bi.c(gI, ","));
            intent.putExtra("RoomInfo_Id", this.fsV);
            intent.putExtra("room_owner_name", this.hLB.field_roomowner);
            intent.putExtra("Is_RoomOwner", this.hLy);
            intent.putExtra("room_member_count", this.hLz);
            intent.putExtra("Add_address_titile", getString(R.l.room_see_room_member));
            if (this.bSD) {
                intent.putExtra("Contact_Scene", 14);
            } else if (this.hLj) {
                intent.putExtra("Contact_Scene", 44);
                if (!q.gQ(this.guS.field_username)) {
                    intent.putExtra("Contact_IsLBSFriend", true);
                }
            }
            aAx = "offset";
            View childAt = this.kww.getChildAt(0);
            intent.putExtra(aAx, childAt == null ? 0 : -childAt.getTop());
            intent.putExtra("first_pos", this.kww.getFirstVisiblePosition());
            intent.putExtra("room_name", this.guS.field_username);
            startActivityForResult(intent, 5);
            this.hLK = 5;
        } else if (str.equals("manage_room")) {
            intent2 = new Intent();
            intent2.setClass(this.mController.tml, ManageChatroomUI.class);
            intent2.putExtra("RoomInfo_Id", this.fsV);
            intent2.putExtra("room_owner_name", this.hLB.field_roomowner);
            startActivity(intent2);
        } else if (str.equals("chat_room_app_brand")) {
            intent2 = new Intent();
            intent2.putExtra("Chat_User", this.fsV);
            com.tencent.mm.bg.d.e(this, ".ui.chatting.gallery.AppBrandHistoryListUI", intent2);
            com.tencent.mm.plugin.report.service.h.mEJ.a(219, 25, 1, true);
        }
        return false;
    }

    private String aAx() {
        if (this.hLB == null) {
            return "";
        }
        return this.hLB.field_selfDisplayName;
    }

    private void dX(boolean z) {
        if (l.gz(this.fsV)) {
            com.tencent.mm.plugin.chatroom.a.ezo.cV(this.fsV);
        }
        bd.a(this.fsV, new 18(this));
        au.HU();
        com.tencent.mm.model.c.FQ().b(new com.tencent.mm.aq.b(this.fsV));
        au.HU();
        com.tencent.mm.model.c.FW().Yp(this.fsV);
        au.HU();
        com.tencent.mm.model.c.FQ().b(new com.tencent.mm.aq.c(this.fsV));
        if (z) {
            au.HU();
            com.tencent.mm.plugin.messenger.foundation.a.a.g FQ = com.tencent.mm.model.c.FQ();
            au.HU();
            FQ.b(new n((String) com.tencent.mm.model.c.DT().get(2, null), this.fsV));
        }
        m.gG(this.fsV);
        if (!z) {
            this.handler.post(new 28(this));
        }
        Intent intent = new Intent();
        intent.addFlags(67108864);
        com.tencent.mm.plugin.chatroom.a.ezn.q(intent, this.mController.tml);
        finish();
    }

    private void aAy() {
        List gI;
        if (this.bSD) {
            com.tencent.mm.plugin.report.service.h.mEJ.a(219, 7, 1, true);
            gI = m.gI(this.fsV);
            String c = bi.c(gI, ",");
            if (gI != null) {
                this.hLz = gI.size();
            }
            Intent intent = new Intent();
            intent.putExtra("titile", getString(R.l.address_title_select_contact));
            intent.putExtra("list_type", 1);
            intent.putExtra("list_attr", com.tencent.mm.ui.contact.s.ukF);
            intent.putExtra("always_select_contact", c);
            intent.putExtra("scene", 3);
            com.tencent.mm.bg.d.b(this, ".ui.contact.SelectContactUI", intent, 1);
            return;
        }
        com.tencent.mm.plugin.report.service.h.mEJ.k(10170, "1");
        gI = new LinkedList();
        gI.add(this.fsV);
        gI.add(q.GF());
        String c2 = bi.c(gI, ",");
        Intent intent2 = new Intent();
        intent2.putExtra("titile", getString(R.l.address_title_launch_chatting));
        intent2.putExtra("list_type", 0);
        intent2.putExtra("list_attr", com.tencent.mm.ui.contact.s.ukG);
        intent2.putExtra("always_select_contact", c2);
        com.tencent.mm.bg.d.e(this, ".ui.contact.SelectContactUI", intent2);
    }

    private void aAz() {
        com.tencent.mm.plugin.report.service.h.mEJ.a(219, 8, 1, true);
        List gI = m.gI(this.fsV);
        String c = bi.c(gI, ",");
        this.hLz = gI.size();
        Intent intent = new Intent();
        intent.putExtra("RoomInfo_Id", this.fsV);
        intent.putExtra("Is_Chatroom", true);
        intent.putExtra("Chatroom_member_list", c);
        intent.putExtra("room_member_count", this.hLz);
        intent.putExtra("Is_RoomOwner", this.hLy);
        intent.putExtra("list_attr", com.tencent.mm.ui.contact.s.ukF);
        intent.putExtra("room_name", this.guS.field_username);
        intent.putExtra("room_owner_name", this.hLB.field_roomowner);
        intent.setClass(this, SelectDelRoomMemberUI.class);
        startActivityForResult(intent, 7);
    }

    private void q(String str, String str2, int i) {
        if (s.gW(str)) {
            boolean z;
            if (bi.oV(q.GF()).equals(str)) {
                z = true;
            } else {
                List<String> gI = m.gI(this.fsV);
                if (gI == null) {
                    z = false;
                } else {
                    z = false;
                    for (String equals : gI) {
                        boolean z2;
                        if (equals.equals(str)) {
                            z2 = true;
                        } else {
                            z2 = z;
                        }
                        z = z2;
                    }
                }
            }
            if (z) {
                com.tencent.mm.ui.base.h.b(this, getString(R.l.add_room_mem_memberExits), getString(R.l.app_tip), true);
                return;
            }
            List F = bi.F(str.split(","));
            if (F != null) {
                com.tencent.mm.plugin.chatroom.d.d dVar = new com.tencent.mm.plugin.chatroom.d.d(this.fsV, F, str2);
                getString(R.l.app_tip);
                this.eHw = com.tencent.mm.ui.base.h.a(this, getString(i), true, new 20(this, dVar));
                au.DF().a(dVar, 0);
                return;
            }
            return;
        }
        com.tencent.mm.ui.base.h.b(this, getString(R.l.room_member_only_support_weixin), getString(R.l.app_tip), true);
    }

    private void a(int i, com.tencent.mm.plugin.chatroom.d.d dVar) {
        String str = "";
        String str2 = "";
        String string = ad.getContext().getString(R.l.chatroom_sys_msg_invite_split);
        List list = dVar.hKU;
        List list2 = dVar.hKW;
        List list3 = dVar.bTX;
        if (i != -2012 || ((list == null || list.isEmpty()) && (list2 == null || list2.isEmpty()))) {
            boolean z;
            au.HU();
            u ii = com.tencent.mm.model.c.Ga().ii(this.fsV);
            if (i == -116 && aAB() && !bi.oW(ii.field_roomowner)) {
                str = getString(R.l.room_member_needupgrade_tip);
                str2 = getString(R.l.room_member_needupgrade);
                z = true;
            } else {
                z = false;
            }
            if (i == -23) {
                str = getString(R.l.room_member_toomuch_tip);
                str2 = getString(R.l.room_member_toomuch);
            }
            if (i == -109) {
                str = getString(R.l.room_member_no_exist_tip);
                str2 = getString(R.l.room_member_no_exist);
            }
            if (i == -122) {
                str = getString(R.l.room_member_toomuch_tip);
                str2 = getString(R.l.room_member_other_toomuch, new Object[]{aAA(), Integer.valueOf(ii.ckO())});
            }
            list = dVar.hKV;
            if (list3 == null || list3.size() <= 0 || (list3.size() != dVar.bSU && (list == null || list.size() <= 0 || dVar.bSU != list3.size() + list.size()))) {
                String str3;
                list = dVar.hKV;
                if (list != null && list.size() > 0) {
                    str2 = str2 + getString(R.l.fmt_in_blacklist, new Object[]{bi.c(aE(list), string)});
                }
                list = dVar.bTW;
                if (list == null || list.size() <= 0) {
                    str3 = str2;
                } else {
                    str = getString(R.l.add_room_mem_err);
                    str3 = str2 + getString(R.l.fmt_no_user, new Object[]{bi.c(aE(list), string)});
                }
                List<String> list4 = dVar.bTU;
                if (list4 != null && list4.size() > 0) {
                    boolean z2;
                    for (String str22 : list4) {
                        if (ab.XR(str22)) {
                            str = getString(R.l.launchchatting_create_chatroom_fail);
                            str3 = getString(R.l.launchchatting_create_chatroom_openim_fail);
                            z2 = true;
                            break;
                        }
                    }
                    z2 = false;
                    if (!z2) {
                        str = getString(R.l.add_room_mem_err);
                        str3 = str3 + getString(R.l.fmt_invalid_username, new Object[]{bi.c(aE(list4), string)});
                    }
                }
                Collection collection = dVar.hKW;
                List list42 = new ArrayList();
                if (!(list3 == null || list3.isEmpty())) {
                    list42.addAll(list3);
                }
                if (collection != null && collection.size() > 0) {
                    list42.addAll(collection);
                }
                if (i != -2028) {
                    e(dVar.chatroomName, list3);
                }
                str22 = str3 + getString(R.l.fmt_chatroom_add_need_verify, new Object[]{bi.c(aE(list42), string)});
                if (list3 != null && list3.isEmpty()) {
                    str22 = null;
                }
                if (str22 != null && str22.length() > 0) {
                    if (z) {
                        com.tencent.mm.ui.base.h.a(this, str22, str, new 24(this), null);
                        return;
                    } else {
                        com.tencent.mm.ui.base.h.b(this, str22, str, true);
                        return;
                    }
                }
                return;
            }
            List linkedList = new LinkedList();
            for (int i2 = 0; i2 < list3.size(); i2++) {
                linkedList.add(list3.get(i2));
            }
            str22 = "";
            String string2 = ad.getContext().getString(R.l.chatroom_sys_msg_invite_split);
            if (!(list == null || list.isEmpty())) {
                str22 = getString(R.l.fmt_chatroom_add_in_blacklist, new Object[]{bi.c(aE(list), string2)}) + "\n";
            }
            if (!linkedList.isEmpty()) {
                str22 = str22 + getString(R.l.fmt_chatroom_add_need_verify, new Object[]{bi.c(aE(linkedList), string2)});
            }
            com.tencent.mm.ui.base.h.a(this, str22, "", getString(R.l.fmt_add_failure_alert_confirm), new 25(this));
            e(dVar.chatroomName, linkedList);
            return;
        }
        string = getString(R.l.add_room_mem_err_need_invite);
        String string3 = getString(R.l.invite_alert_ok);
        String string4 = getString(R.l.app_cancel);
        21 21 = new 21(this, dVar, list3, list, list2);
        com.tencent.mm.ui.base.h.a(this, string, null, string3, string4, 21, new 23(this));
    }

    private String aAA() {
        String str;
        String str2 = null;
        au.HU();
        ab Yg = com.tencent.mm.model.c.FR().Yg(this.hLB.field_roomowner);
        if (Yg == null || ((int) Yg.dhP) <= 0) {
            str = null;
        } else {
            str = Yg.field_conRemark;
        }
        if (bi.oW(str)) {
            str = this.hLB.field_roomowner;
            if (this.hLB != null) {
                str2 = this.hLB.gT(str);
            }
        } else {
            str2 = str;
        }
        if (bi.oW(str2) && Yg != null && ((int) Yg.dhP) > 0) {
            str2 = Yg.BK();
        }
        if (bi.oW(str2)) {
            return this.hLB.field_roomowner;
        }
        return str2;
    }

    private static boolean aAB() {
        return bi.getInt(com.tencent.mm.k.g.AT().getValue("ChatroomGlobalSwitch"), 1) == 1;
    }

    private void cU(Context context) {
        if (context != null && aAB()) {
            Intent intent = new Intent();
            intent.putExtra("rawUrl", getString(R.l.chatroom_how_to_upgrade, new Object[]{w.chP()}));
            intent.putExtra("geta8key_username", q.GF());
            intent.putExtra("showShare", false);
            com.tencent.mm.bg.d.b(this, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
        }
    }

    private void e(String str, List<String> list) {
        if (list != null && list.size() > 0) {
            List linkedList = new LinkedList();
            for (int i = 0; i < list.size(); i++) {
                linkedList.add(list.get(i));
            }
            l.a(str, linkedList, getString(R.l.chatroom_sys_msg_invite_error_tip), true, "weixin://findfriend/verifycontact/" + str + "/");
        }
    }

    private void updateTitle() {
        if (this.bSD) {
            this.hLz = m.gK(this.fsV);
            if (this.hLz == 0) {
                setMMTitle(getString(R.l.roominfo_name));
                return;
            }
            setMMTitle(getString(R.l.fmt_chatting_title_group, new Object[]{getString(R.l.roominfo_name), Integer.valueOf(this.hLz)}));
        }
    }

    private void aAC() {
        if (this.hLp == null) {
            return;
        }
        List gI;
        if (this.bSD) {
            au.HU();
            this.hLT = com.tencent.mm.model.c.Ga().ik(this.fsV);
            gI = m.gI(this.fsV);
            if (gI != null) {
                this.hLz = gI.size();
            } else {
                this.hLz = 0;
            }
            if (this.hLz > com.tencent.mm.pluginsdk.ui.applet.j.qIV + 1 && gI != null) {
                gI = gI.subList(0, com.tencent.mm.pluginsdk.ui.applet.j.qIV + 1);
                if (!(this.hLB == null || gI.contains(this.hLB.field_roomowner))) {
                    gI.add(0, this.hLB.field_roomowner);
                }
            }
            if (this.hLz <= 1) {
                this.eOE.bw("del_selector_btn", true);
                this.hLp.kG(true).kH(false).cdW();
            } else {
                this.hLp.kG(true).kH(this.hLy).cdW();
            }
            this.hLp.p(this.fsV, gI);
            return;
        }
        gI = new LinkedList();
        gI.add(this.fsV);
        this.hLp.p(this.fsV, gI);
    }

    private void aAD() {
        if (this.guS != null) {
            CharSequence aAx = aAx();
            if (bi.oW(aAx)) {
                aAx = q.GH();
            }
            if (bi.oW(aAx)) {
                this.hLt.setSummary("");
            } else {
                SignaturePreference signaturePreference = this.hLt;
                if (aAx.length() <= 0) {
                    aAx = getString(R.l.settings_signature_empty);
                }
                signaturePreference.setSummary(com.tencent.mm.pluginsdk.ui.d.j.a(this, aAx));
            }
            if (this.eOE != null) {
                this.eOE.notifyDataSetChanged();
            }
        }
    }

    private void aAE() {
        if (this.duR == null) {
            this.duR = getSharedPreferences(getPackageName() + "_preferences", 0);
        }
        if (this.bSD) {
            this.hEj = this.guS.csI == 0;
        } else if (!this.hLj) {
            this.hEj = this.guS.BD();
        }
        if (this.hEj) {
            setTitleMuteIconVisibility(0);
            if (this.hLq != null) {
                this.duR.edit().putBoolean("room_notify_new_msg", true).commit();
            }
        } else {
            setTitleMuteIconVisibility(8);
            if (this.hLq != null) {
                this.duR.edit().putBoolean("room_notify_new_msg", false).commit();
            }
        }
        this.eOE.notifyDataSetChanged();
    }

    private void aAF() {
        if (this.guS != null && this.hLk != null) {
            CharSequence gM = m.gM(this.fsV);
            if (gM == null || gM.length() <= 0) {
                this.hLk.bIq = false;
            } else {
                this.hLk.bIq = true;
                this.hLk.qPs = com.tencent.mm.pluginsdk.ui.d.j.a(this, gM);
            }
            au.HU();
            this.guS = com.tencent.mm.model.c.FR().Yg(this.fsV);
            if (aAH()) {
                gM = this.guS.BL();
                RoomCardPreference roomCardPreference = this.hLk;
                if (gM.length() <= 0) {
                    gM = getString(R.l.settings_signature_empty);
                }
                roomCardPreference.fyL = com.tencent.mm.pluginsdk.ui.d.j.a(this, gM);
            } else {
                this.hLk.fyL = getString(R.l.room_has_no_topic);
            }
            this.eOE.notifyDataSetChanged();
        }
    }

    private void aAG() {
        if (this.guS != null && this.hLl != null) {
            au.HU();
            this.guS = com.tencent.mm.model.c.FR().Yg(this.fsV);
            if (aAH()) {
                CharSequence BL = this.guS.BL();
                SignaturePreference signaturePreference = this.hLl;
                if (BL.length() <= 0) {
                    BL = getString(R.l.settings_signature_empty);
                }
                signaturePreference.setSummary(com.tencent.mm.pluginsdk.ui.d.j.a(this, BL));
                if (this.eOE != null) {
                    this.eOE.notifyDataSetChanged();
                    return;
                }
                return;
            }
            this.hLl.setSummary(getString(R.l.room_has_no_topic));
        }
    }

    private boolean aAH() {
        String str = this.guS.field_nickname;
        return !bi.oW(str) && str.length() <= 50;
    }

    public static ArrayList<ab> aD(List<aqv> list) {
        ArrayList<ab> arrayList = new ArrayList();
        if (list == null) {
            return arrayList;
        }
        for (aqv aqv : list) {
            ab abVar = new ab();
            abVar.setUsername(aqv.hbL);
            abVar.dx(aqv.hcS);
            arrayList.add(abVar);
        }
        return arrayList;
    }

    private static List<String> aE(List<String> list) {
        List<String> linkedList = new LinkedList();
        if (!au.HX()) {
            return linkedList;
        }
        if (list == null) {
            return linkedList;
        }
        for (Object obj : list) {
            Object obj2;
            au.HU();
            ab Yg = com.tencent.mm.model.c.FR().Yg(obj2);
            if (!(Yg == null || ((int) Yg.dhP) == 0)) {
                obj2 = Yg.BL();
            }
            linkedList.add(obj2);
        }
        return linkedList;
    }

    public final void a(int i, int i2, String str, com.tencent.mm.ab.l lVar) {
        x.i("MicroMsg.ChatroomInfoUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        x.d("MicroMsg.ChatroomInfoUI", "pre is " + this.hLz);
        this.hLz = m.gK(this.fsV);
        x.d("MicroMsg.ChatroomInfoUI", "now is " + this.hLz);
        if (this.eHw != null) {
            this.eHw.dismiss();
        }
        com.tencent.mm.h.a eV = com.tencent.mm.h.a.eV(str);
        if (eV != null) {
            eV.a(this, null, null);
        } else if (i == 0 && i2 == 0) {
            if (i == 0 && i2 == 0) {
                switch (lVar.getType()) {
                    case 120:
                        a(i2, (com.tencent.mm.plugin.chatroom.d.d) lVar);
                        aAI();
                        break;
                    case 179:
                        aAI();
                        break;
                    case 610:
                        if (this.hLK != 5) {
                            com.tencent.mm.ui.base.h.b(this, getString(R.l.invite_room_mem_ok), null, true);
                            break;
                        }
                        break;
                }
                if (this.hLB != null) {
                    this.hLz = this.hLB.Nn().size();
                }
                if ((!this.hLy && this.hLz >= com.tencent.mm.pluginsdk.ui.applet.j.qIV) || (this.hLy && this.hLz >= com.tencent.mm.pluginsdk.ui.applet.j.qIV - 1)) {
                    this.eOE.bw("see_room_member", false);
                    this.hLm.setTitle(getString(R.l.see_member_selector_btn));
                }
            }
            updateTitle();
        } else {
            if (lVar.getType() == 120 && this.hLK != 5) {
                a(i2, (com.tencent.mm.plugin.chatroom.d.d) lVar);
                aAI();
            }
            if (lVar.getType() == 179 && this.hLK != 5 && i2 == -66) {
                com.tencent.mm.ui.base.h.b(this, getString(R.l.del_room_mem_err), getString(R.l.app_tip), true);
                aAI();
            }
            if (lVar.getType() == 610 && this.hLK != 5) {
                com.tencent.mm.ui.base.h.b(this, getString(R.l.invite_room_mem_err), getString(R.l.app_tip), true);
            }
        }
    }

    private void aAI() {
        if (this.hLp != null) {
            if (this.bSD) {
                aAC();
            } else if (!this.hLj) {
                List linkedList = new LinkedList();
                linkedList.add(this.fsV);
                this.hLp.p(this.fsV, linkedList);
            }
            this.hLp.notifyChanged();
        }
        if (!this.hLy || m.gK(this.fsV) <= 2) {
            this.eOE.bw("manage_room", true);
        } else {
            this.eOE.bw("manage_room", false);
        }
        if ((this.hLy || this.hLz < com.tencent.mm.pluginsdk.ui.applet.j.qIV) && (!this.hLy || this.hLz < com.tencent.mm.pluginsdk.ui.applet.j.qIV - 1)) {
            this.eOE.bw("see_room_member", true);
        } else {
            this.eOE.bw("see_room_member", false);
            this.hLm.setTitle(getString(R.l.see_member_selector_btn, new Object[]{Integer.valueOf(this.hLz)}));
        }
        this.eOE.notifyDataSetChanged();
    }

    public final void a(int i, com.tencent.mm.sdk.e.m mVar, Object obj) {
        if (obj == null || !(obj instanceof String)) {
            x.d("MicroMsg.ChatroomInfoUI", "onNotifyChange obj not String event:%d stg:%s obj:%s", new Object[]{Integer.valueOf(i), mVar, obj});
            return;
        }
        a((String) obj, null);
    }

    public final void a(String str, com.tencent.mm.sdk.e.l lVar) {
        if (!bi.oW(str)) {
            if (str.endsWith("@chatroom")) {
                x.d("MicroMsg.ChatroomInfoUI", "event:" + str);
                if (this.bSD && str.equals(this.fsV)) {
                    au.Em().H(new 29(this));
                }
                aAI();
                return;
            }
            x.d("MicroMsg.ChatroomInfoUI", "event:" + str + " cancel");
        }
    }

    public final void p(String str, String str2, String str3) {
        if (str.equals(this.fsV) && this.hLp != null) {
            this.hLp.notifyChanged();
        }
    }

    public final com.tencent.mm.ui.base.preference.h a(SharedPreferences sharedPreferences) {
        return new com.tencent.mm.ui.base.preference.a(this, sharedPreferences);
    }
}

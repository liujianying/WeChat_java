package com.tencent.mm.plugin.chatroom.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import com.tencent.mm.R;
import com.tencent.mm.aq.j;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.c;
import com.tencent.mm.model.q;
import com.tencent.mm.model.s;
import com.tencent.mm.pluginsdk.ui.preference.SignaturePreference;
import com.tencent.mm.pluginsdk.wallet.e;
import com.tencent.mm.protocal.c.aua;
import com.tencent.mm.protocal.c.aub;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.e.d;

@Deprecated
public class RoomInfoDetailUI extends MMPreference implements a {
    private boolean bSD;
    private f eOE;
    private String fsV;
    private ab guS;
    private boolean hLA = false;
    private String hLP;
    private SignaturePreference hLl;
    private CheckBoxPreference hLq;
    private int hNE;
    private CheckBoxPreference hNF;
    private CheckBoxPreference hNG;
    private boolean isDeleteCancel = false;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
    }

    public void onResume() {
        super.onResume();
        aAE();
        aAO();
        if (!(this.guS == null || this.hNF == null)) {
            au.HU();
            u ii = c.Ga().ii(this.fsV);
            SharedPreferences sharedPreferences = getSharedPreferences(this.hLP, 0);
            if (ii.ckP()) {
                this.hNF.qpJ = true;
                sharedPreferences.edit().putBoolean("room_msg_show_username", true).commit();
            } else {
                this.hNF.qpJ = false;
                sharedPreferences.edit().putBoolean("room_msg_show_username", false).commit();
            }
        }
        this.eOE.notifyDataSetChanged();
    }

    protected final void initView() {
        setMMTitle(R.l.roominfo_detail_name);
        this.eOE = this.tCL;
        this.hLP = getPackageName() + "_preferences";
        this.bSD = getIntent().getBooleanExtra("Is_Chatroom", true);
        this.fsV = getIntent().getStringExtra("RoomInfo_Id");
        if (this.fsV == null) {
            this.fsV = getIntent().getStringExtra("Single_Chat_Talker");
        }
        au.HU();
        this.guS = c.FR().Yg(this.fsV);
        if (this.bSD) {
            this.hNE = this.guS.csI;
            this.hLl = (SignaturePreference) this.eOE.ZZ("room_name");
            this.hLq = (CheckBoxPreference) this.eOE.ZZ("room_msg_notify");
            this.hNG = (CheckBoxPreference) this.eOE.ZZ("room_show_msg_count");
            this.hNF = (CheckBoxPreference) this.eOE.ZZ("room_msg_show_username");
            this.hNG.tDr = false;
        } else {
            this.hNE = 1;
        }
        setBackBtn(new 1(this));
    }

    public final void a(String str, l lVar) {
    }

    public final int Ys() {
        return R.o.roominfo_detail_pref;
    }

    public final boolean a(f fVar, Preference preference) {
        Intent intent;
        String GF;
        u ih;
        boolean z = true;
        String str = preference.mKey;
        x.d("MicroMsg.RoomInfoDetailUI", "click key : %s", new Object[]{str});
        if (str.equals("room_name")) {
            intent = new Intent();
            intent.setClass(this, d.class);
            intent.putExtra("Contact_mode_name_type", 4);
            GF = q.GF();
            intent.putExtra("Contact_Nick", aAx());
            intent.putExtra("Contact_User", GF);
            intent.putExtra("MMActivity.OverrideEnterAnimation", R.a.fast_faded_in);
            intent.putExtra("MMActivity.OverrideExitAnimation", R.a.push_down_out);
            this.mController.tml.startActivityForResult(intent, 2);
        }
        if (str.equals("room_msg_show_username")) {
            au.HU();
            ih = c.Ga().ih(this.fsV);
            ih.ll(!ih.ckP());
            this.hLA = true;
        }
        if (str.equals("room_msg_notify")) {
            int i;
            if (this.hNE == 0) {
                i = 1;
            } else {
                i = 0;
            }
            this.hNE = i;
            au.HU();
            c.FQ().b(new j(this.fsV, this.hNE));
            au.HU();
            this.guS = c.FR().Yg(this.fsV);
            this.guS.eN(this.hNE);
            au.HU();
            c.FR().a(this.fsV, this.guS);
            aAE();
            au.HU();
            this.guS = c.FR().Yg(this.fsV);
            this.eOE.notifyDataSetChanged();
        }
        if (str.equals("room_set_chatting_background")) {
            intent = new Intent();
            intent.putExtra("isApplyToAll", false);
            intent.putExtra("username", this.guS.field_username);
            com.tencent.mm.bg.d.b(this, "setting", ".ui.setting.SettingsChattingBackgroundUI", intent, 1);
        }
        if (str.equals("room_clear_chatting_history")) {
            h.a((Context) this, this.bSD ? getString(R.l.fmt_delcontactmsg_confirm_group) : getString(R.l.fmt_delcontactmsg_confirm, new Object[]{this.guS.BL()}), new String[]{getString(R.l.room_clear_chatting_history)}, null, new h.c() {
                public final void ju(int i) {
                    switch (i) {
                        case 0:
                            String str;
                            RoomInfoDetailUI.this.isDeleteCancel = false;
                            Context context = RoomInfoDetailUI.this;
                            RoomInfoDetailUI.this.getString(R.l.app_tip);
                            ProgressDialog a = h.a(context, RoomInfoDetailUI.this.getString(R.l.app_waiting), true, new OnCancelListener() {
                                public final void onCancel(DialogInterface dialogInterface) {
                                    RoomInfoDetailUI.this.isDeleteCancel = true;
                                }
                            });
                            if (com.tencent.mm.model.l.gz(RoomInfoDetailUI.this.guS.field_username)) {
                                com.tencent.mm.plugin.chatroom.a.ezo.cV(RoomInfoDetailUI.this.guS.field_username);
                            }
                            if (RoomInfoDetailUI.this.isDeleteCancel) {
                                str = null;
                            } else {
                                str = e.Uk(RoomInfoDetailUI.this.guS.field_username);
                            }
                            if (bi.oW(str)) {
                                bd.a(RoomInfoDetailUI.this.guS.field_username, new 3(RoomInfoDetailUI.this, a));
                                return;
                            }
                            a.dismiss();
                            h.a(RoomInfoDetailUI.this, false, RoomInfoDetailUI.this.getString(R.l.wallet_clear_chatting_history_note, new Object[]{str}), null, RoomInfoDetailUI.this.getString(R.l.goto_conversation), RoomInfoDetailUI.this.getString(R.l.clear_chat_history), new 2(this), new 3(this, a), -1, R.e.alert_btn_color_warn);
                            return;
                        default:
                            return;
                    }
                }
            });
        }
        if (str.equals("room_placed_to_the_top")) {
            SharedPreferences sharedPreferences = getSharedPreferences(this.hLP, 0);
            if (this.guS != null) {
                au.HU();
                if (c.FW().Yx(this.guS.field_username)) {
                    s.u(this.guS.field_username, true);
                } else {
                    s.t(this.guS.field_username, true);
                }
                au.HU();
                sharedPreferences.edit().putBoolean("room_placed_to_the_top", c.FW().Yx(this.guS.field_username)).commit();
            }
        }
        if ("room_show_msg_count".equals(str)) {
            boolean z2;
            boolean BE = BE();
            x.d("MicroMsg.RoomInfoDetailUI", "old value undeliver[%B], now set show msg count[%B]", new Object[]{Boolean.valueOf(BE), Boolean.valueOf(BE)});
            if (BE) {
                z2 = false;
            } else {
                z2 = true;
            }
            au.HU();
            ih = c.Ga().ih(this.fsV);
            if (z2) {
                ih.ge(0);
            } else {
                ih.ge(2);
            }
            x.d("MicroMsg.RoomInfoDetailUI", "update show msg count[%B]", new Object[]{Boolean.valueOf(z2)});
            au.HU();
            c.Ga().c(ih, new String[0]);
            GF = q.GF();
            aub aub = new aub();
            aub.rvj = this.fsV;
            aub.hbL = GF;
            aub.rXb = 2;
            aub.mEc = z2 ? 2 : 1;
            au.HU();
            c.FQ().b(new com.tencent.mm.plugin.messenger.foundation.a.a.h.a(49, aub));
            if (this.hNG != null) {
                CheckBoxPreference checkBoxPreference = this.hNG;
                if (BE) {
                    z = false;
                }
                checkBoxPreference.qpJ = z;
            }
            this.eOE.notifyDataSetChanged();
        }
        return false;
    }

    public void onPause() {
        int i = 1;
        super.onPause();
        if (this.hLA) {
            au.HU();
            u ih = c.Ga().ih(this.fsV);
            au.HU();
            c.Ga().c(ih, new String[0]);
            String GF = q.GF();
            boolean ckP = ih.ckP();
            aub aub = new aub();
            aub.rvj = this.fsV;
            aub.hbL = GF;
            aub.rXb = 1;
            if (!ckP) {
                i = 0;
            }
            aub.mEc = i;
            au.HU();
            c.FQ().b(new com.tencent.mm.plugin.messenger.foundation.a.a.h.a(49, aub));
        }
    }

    private boolean BE() {
        au.HU();
        return (c.Ga().ih(this.fsV).field_chatroomdataflag & 2) == 0;
    }

    private String aAx() {
        au.HU();
        u ih = c.Ga().ih(this.fsV);
        if (ih == null) {
            return "";
        }
        return ih.field_selfDisplayName;
    }

    private void aAO() {
        if (this.guS != null && this.hLl != null) {
            CharSequence aAx = aAx();
            if (bi.oW(aAx)) {
                aAx = q.GH();
            }
            if (bi.oW(aAx)) {
                this.hLl.setSummary("");
                return;
            }
            SignaturePreference signaturePreference = this.hLl;
            if (aAx.length() <= 0) {
                aAx = getString(R.l.settings_signature_empty);
            }
            signaturePreference.setSummary(com.tencent.mm.pluginsdk.ui.d.j.a(this, aAx));
        }
    }

    private void aAE() {
        boolean z = true;
        if (this.bSD) {
            SharedPreferences sharedPreferences = getSharedPreferences(this.hLP, 0);
            if (this.hNE == 0) {
                setTitleMuteIconVisibility(0);
                if (this.hLq != null) {
                    this.hLq.qpJ = true;
                    sharedPreferences.edit().putBoolean("room_msg_notify", true).commit();
                }
                if (this.hNG != null) {
                    this.hNG.qpJ = BE();
                }
            } else if (this.hNE == 1) {
                setTitleMuteIconVisibility(8);
                if (this.hLq != null) {
                    this.hLq.qpJ = false;
                    sharedPreferences.edit().putBoolean("room_msg_notify", false).commit();
                }
            }
            f fVar = this.eOE;
            String str = "room_show_msg_count";
            if (this.hNE != 1) {
                z = false;
            }
            fVar.bw(str, z);
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 1:
                    if (i2 == -1) {
                        setResult(-1);
                        finish();
                        return;
                    }
                    return;
                case 2:
                    if (intent != null) {
                        String aG = bi.aG(intent.getStringExtra("Contact_Nick"), "");
                        if (!bi.oW(aG)) {
                            String GF = q.GF();
                            au.HU();
                            u ih = c.Ga().ih(this.fsV);
                            if (ih == null) {
                                ih = new u();
                            }
                            ih.field_chatroomname = this.fsV;
                            ih.field_selfDisplayName = aG;
                            au.HU();
                            c.Ga().c(ih, new String[0]);
                            aua aua = new aua();
                            aua.rvj = this.fsV;
                            aua.hbL = GF;
                            aua.rqY = bi.oV(aG);
                            au.HU();
                            c.FQ().b(new com.tencent.mm.plugin.messenger.foundation.a.a.h.a(48, aua));
                            aAO();
                            return;
                        }
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }
}

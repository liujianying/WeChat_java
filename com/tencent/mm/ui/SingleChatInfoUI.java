package com.tencent.mm.ui;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Looper;
import com.tencent.mm.R;
import com.tencent.mm.ax.a;
import com.tencent.mm.ax.g;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.c;
import com.tencent.mm.model.q;
import com.tencent.mm.platformtools.ai;
import com.tencent.mm.plugin.appbrand.ui.widget.AppBrandLoadIconPreference;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference;
import com.tencent.mm.pluginsdk.ui.d;
import com.tencent.mm.pluginsdk.wallet.e;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.contact.SelectContactUI;
import com.tencent.mm.ui.contact.s;
import java.util.LinkedList;
import java.util.List;

public class SingleChatInfoUI extends MMPreference implements a {
    private static boolean isDeleteCancel = false;
    private SharedPreferences duR = null;
    private f eOE;
    private ab guS;
    private boolean hEj;
    private int hLC = -1;
    private boolean hLE = false;
    private d hLH = new d(new 1(this));
    boolean hLI = false;
    private String hLP = "";
    private ContactListExpandPreference hLp;
    private CheckBoxPreference hLq;
    private CheckBoxPreference hLs;
    private AppBrandLoadIconPreference hLv;
    private ag handler = new ag(Looper.getMainLooper());
    private String talker;

    static /* synthetic */ void c(SingleChatInfoUI singleChatInfoUI) {
        h.mEJ.k(10170, "1");
        List linkedList = new LinkedList();
        linkedList.add(singleChatInfoUI.talker);
        linkedList.add(q.GF());
        String c = ai.c(linkedList, ",");
        Intent intent = new Intent();
        intent.setClass(singleChatInfoUI, SelectContactUI.class);
        intent.putExtra("titile", singleChatInfoUI.getString(R.l.address_title_launch_chatting));
        intent.putExtra("list_type", 0);
        intent.putExtra("list_attr", s.ukG);
        intent.putExtra("always_select_contact", c);
        intent.putExtra("scene", 2);
        singleChatInfoUI.startActivity(intent);
    }

    static /* synthetic */ void g(SingleChatInfoUI singleChatInfoUI) {
        h.mEJ.h(14553, new Object[]{Integer.valueOf(6), Integer.valueOf(2), singleChatInfoUI.talker});
        isDeleteCancel = false;
        singleChatInfoUI.getString(R.l.app_tip);
        ProgressDialog a = com.tencent.mm.ui.base.h.a(singleChatInfoUI, singleChatInfoUI.getString(R.l.app_waiting), true, new a((byte) 0));
        if (ai.oW(!isDeleteCancel ? e.Uk(singleChatInfoUI.guS.field_username) : null)) {
            singleChatInfoUI.b(a);
            return;
        }
        a.dismiss();
        Object[] objArr = new Object[]{r0};
        com.tencent.mm.ui.base.h.a(singleChatInfoUI, false, singleChatInfoUI.getString(R.l.wallet_clear_chatting_history_note, objArr), null, singleChatInfoUI.getString(R.l.goto_conversation), singleChatInfoUI.getString(R.l.clear_chat_history), new 5(singleChatInfoUI), new 6(singleChatInfoUI, a), -1, R.e.alert_btn_color_warn);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (g.elf != null) {
            g.elf.a(this);
        }
        this.talker = getIntent().getStringExtra("Single_Chat_Talker");
        this.hLE = getIntent().getBooleanExtra("fromChatting", false);
        au.HU();
        this.guS = c.FR().Yg(this.talker);
        this.hLP = getPackageName() + "_preferences";
        initView();
    }

    public void onResume() {
        aAE();
        if (this.hLp != null) {
            List linkedList = new LinkedList();
            linkedList.add(this.talker);
            this.hLp.p(this.talker, linkedList);
        }
        this.eOE.notifyDataSetChanged();
        super.onResume();
        if (!this.hLI) {
            String stringExtra = getIntent().getStringExtra("need_matte_high_light_item");
            if (!ai.oW(stringExtra)) {
                int aab = this.eOE.aab(stringExtra);
                setSelection(aab - 3);
                new ag().postDelayed(new 2(this, aab), 10);
            }
            this.hLI = true;
        }
    }

    public void onPause() {
        super.onPause();
    }

    public void onDestroy() {
        com.tencent.mm.ui.g.a.dismiss();
        if (g.elf != null) {
            g.elf.b(this);
        }
        if (this.hLv != null) {
            AppBrandLoadIconPreference.onDestroy();
        }
        super.onDestroy();
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 2:
                    if (i2 == -1) {
                        finish();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public final int Ys() {
        return R.o.roominfo_single_pref;
    }

    protected final void initView() {
        this.eOE = this.tCL;
        setMMTitle(getString(R.l.roominfo_name));
        this.hLp = (ContactListExpandPreference) this.eOE.ZZ("roominfo_contact_anchor");
        this.hLp.a(this.eOE, this.hLp.mKey);
        this.hLp.kG(true).kH(false);
        if (this.guS != null && this.guS.field_deleteFlag == 1) {
            this.hLp.kG(false);
        }
        if (this.guS != null && ab.XR(this.guS.field_username)) {
            this.hLp.kG(false);
        }
        this.hLq = (CheckBoxPreference) this.eOE.ZZ("room_notify_new_msg");
        this.hLs = (CheckBoxPreference) this.eOE.ZZ("room_placed_to_the_top");
        if (this.duR == null) {
            this.duR = getSharedPreferences(getPackageName() + "_preferences", 0);
        }
        if (this.guS != null) {
            au.HU();
            this.duR.edit().putBoolean("room_placed_to_the_top", c.FW().Yx(this.guS.field_username)).commit();
            this.hEj = this.guS.BD();
            this.duR.edit().putBoolean("room_notify_new_msg", this.hEj).commit();
        } else {
            this.duR.edit().putBoolean("room_notify_new_msg", false).commit();
            this.hEj = false;
        }
        au.HU();
        this.hLC = c.FT().GW(this.talker);
        this.hLv = (AppBrandLoadIconPreference) this.eOE.ZZ("chat_app_brand");
        this.hLv.gBf = this.talker;
        if (this.guS != null && ab.XR(this.guS.field_username)) {
            this.eOE.c(this.hLv);
        }
        this.eOE.notifyDataSetChanged();
        if (this.hLp != null) {
            List linkedList = new LinkedList();
            linkedList.add(this.talker);
            this.hLp.p(this.talker, linkedList);
            this.kww.setOnScrollListener(this.hLH);
            this.hLp.a(this.hLH);
            this.hLp.a(new 3(this));
        }
        setBackBtn(new 4(this));
    }

    public final boolean a(f fVar, Preference preference) {
        boolean z = true;
        String str = preference.mKey;
        Intent intent;
        if (str.equals("room_notify_new_msg")) {
            if (this.hEj) {
                z = false;
            }
            this.hEj = z;
            if (this.hEj) {
                com.tencent.mm.model.s.n(this.guS);
            } else {
                com.tencent.mm.model.s.o(this.guS);
            }
            au.HU();
            this.guS = c.FR().Yg(this.talker);
            if (this.duR == null) {
                this.duR = getSharedPreferences(getPackageName() + "_preferences", 0);
            }
            this.duR.edit().putBoolean("room_notify_new_msg", this.hEj).commit();
            aAE();
        } else if (str.equals("room_placed_to_the_top")) {
            SharedPreferences sharedPreferences = getSharedPreferences(this.hLP, 0);
            if (this.guS != null) {
                au.HU();
                if (c.FW().Yx(this.guS.field_username)) {
                    com.tencent.mm.model.s.u(this.guS.field_username, true);
                } else {
                    com.tencent.mm.model.s.t(this.guS.field_username, true);
                }
                au.HU();
                sharedPreferences.edit().putBoolean("room_placed_to_the_top", c.FW().Yx(this.guS.field_username)).commit();
            }
        } else if (str.equals("room_set_chatting_background")) {
            intent = new Intent();
            intent.putExtra("isApplyToAll", false);
            intent.putExtra("username", this.guS.field_username);
            com.tencent.mm.bg.d.b(this, "setting", ".ui.setting.SettingsChattingBackgroundUI", intent, 2);
        } else if (str.equals("room_search_chatting_content")) {
            intent = new Intent();
            intent.putExtra("detail_username", this.talker);
            com.tencent.mm.plugin.fts.a.d.b(this, ".ui.FTSChattingConvUI", intent);
            h.mEJ.h(14569, new Object[]{Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0)});
        } else if (str.equals("room_clear_chatting_history")) {
            com.tencent.mm.ui.base.h.a(this.mController.tml, getString(R.l.fmt_delcontactmsg_confirm, new Object[]{this.guS.BL()}), "", getString(R.l.app_clear), getString(R.l.app_cancel), new 8(this), null, R.e.alert_btn_color_warn);
        } else if (str.equals("room_expose")) {
            intent = new Intent();
            intent.putExtra("k_username", this.talker);
            intent.putExtra("showShare", false);
            intent.putExtra("rawUrl", String.format("https://weixin110.qq.com/security/readtemplate?t=weixin_report/w_type&scene=%d#wechat_redirect", new Object[]{Integer.valueOf(39)}));
            com.tencent.mm.bg.d.b(this, "webview", ".ui.tools.WebViewUI", intent);
        } else if (str.equals("chat_app_brand")) {
            intent = new Intent();
            intent.putExtra("Chat_User", this.talker);
            com.tencent.mm.bg.d.e(this, ".ui.chatting.gallery.AppBrandHistoryListUI", intent);
            h.mEJ.a(219, 25, 1, true);
        }
        return false;
    }

    private void b(final ProgressDialog progressDialog) {
        bd.a(this.guS.field_username, new bd.a() {
            public final boolean Ip() {
                return SingleChatInfoUI.isDeleteCancel;
            }

            public final void Io() {
                if (progressDialog != null) {
                    progressDialog.dismiss();
                }
            }
        });
        this.handler.post(new 9(this));
    }

    private void aAE() {
        if (this.duR == null) {
            this.duR = getSharedPreferences(getPackageName() + "_preferences", 0);
        }
        this.hEj = this.guS.BD();
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

    public final void p(String str, String str2, String str3) {
        if (str.equals(this.talker) && this.hLp != null) {
            this.hLp.notifyChanged();
        }
    }

    public final com.tencent.mm.ui.base.preference.h a(SharedPreferences sharedPreferences) {
        return new com.tencent.mm.ui.base.preference.a(this, sharedPreferences);
    }
}

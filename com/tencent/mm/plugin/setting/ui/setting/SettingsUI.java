package com.tencent.mm.plugin.setting.ui.setting;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.view.View;
import android.widget.CheckBox;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.o;
import com.tencent.mm.g.a.ef;
import com.tencent.mm.g.a.ja;
import com.tencent.mm.g.a.y;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.at;
import com.tencent.mm.model.bt;
import com.tencent.mm.model.q;
import com.tencent.mm.modelsimple.ac;
import com.tencent.mm.modelsimple.p;
import com.tencent.mm.modelsimple.r;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.account.bind.ui.BindMContactIntroUI;
import com.tencent.mm.plugin.setting.a.i;
import com.tencent.mm.plugin.setting.a.k;
import com.tencent.mm.pluginsdk.ui.tools.l;
import com.tencent.mm.s.a.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.IconPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.SwitchKeyValuePreference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.widget.a.c;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.smtt.sdk.WebView;
import java.util.ArrayList;

public class SettingsUI extends MMPreference implements b {
    private f eOE;
    private al eOf;
    private d eSg;
    private al eaF = null;
    private e ehD = null;
    private View kOX;
    private ProgressDialog mQY = null;
    private al mQZ;
    private e mRa = null;
    private PersonalPreference mUq = null;
    private e mUr = null;
    private a mUs = new 1(this);
    private Dialog mUt = null;
    private c mUu;
    private CheckBox mUv;
    private e mUw = null;

    static /* synthetic */ void h(SettingsUI settingsUI) {
        Object[] objArr = new Object[1];
        g.Eg();
        objArr[0] = Integer.valueOf(com.tencent.mm.kernel.a.Df());
        x.w("MicroMsg.SettingsUI", "dklogout User LOGOUT Now uin:%d , clear cookie", objArr);
        com.tencent.mm.modelstat.c.RT().commitNow();
        o DF = g.DF();
        9 9 = new 9(settingsUI);
        settingsUI.mRa = 9;
        DF.a(WebView.NORMAL_MODE_ALPHA, 9);
        r rVar = new r(2);
        rVar.efX = 2;
        g.DF().a(rVar, 0);
        settingsUI.mQZ = new al(Looper.getMainLooper(), new 10(settingsUI, rVar), false);
        settingsUI.mQZ.J(12000, 12000);
        settingsUI.getString(i.app_tip);
        settingsUI.mQY = h.a((Context) settingsUI, settingsUI.getString(i.wx_logout_processing_txt), false, new 11(settingsUI, rVar));
        if (g.Eg().Dx()) {
            String A = com.tencent.mm.aa.c.A(q.GF(), false);
            at.dBv.iy(A);
            g.Ei().DT().a(aa.a.sZO, A);
        }
    }

    static /* synthetic */ void k(SettingsUI settingsUI) {
        Object[] objArr = new Object[1];
        g.Eg();
        objArr[0] = Integer.valueOf(com.tencent.mm.kernel.a.Df());
        x.w("MicroMsg.SettingsUI", "dklogout User EXIT Now uin:%d", objArr);
        if (com.tencent.mm.kernel.a.gI(g.Eg().dpx)) {
            o DF = g.DF();
            6 6 = new 6(settingsUI);
            settingsUI.mUw = 6;
            DF.a(281, 6);
            ac acVar = new ac(2);
            g.DF().a(acVar, 0);
            settingsUI.eaF = new al(new 7(settingsUI, acVar), false);
            settingsUI.eaF.J(5000, 5000);
            Context context = settingsUI.mController.tml;
            settingsUI.getString(i.app_tip);
            settingsUI.mQY = h.a(context, settingsUI.getString(i.webwx_logout_processing_txt), true, new 8(settingsUI, acVar));
            return;
        }
        settingsUI.bui();
    }

    static /* synthetic */ void v(SettingsUI settingsUI) {
        if (!com.tencent.mm.kernel.a.gI(g.Eg().dpx) || com.tencent.mm.sdk.platformtools.d.EX_DEVICE_LOGIN) {
            settingsUI.buh();
            settingsUI.eOf = new al(Looper.getMainLooper(), new al.a() {
                public final boolean vD() {
                    g.DF().b(281, SettingsUI.this.ehD);
                    g.DF().b(282, SettingsUI.this.mUr);
                    SettingsUI.this.ehD = null;
                    SettingsUI.this.mUr = null;
                    if (SettingsUI.this.eOf != null) {
                        SettingsUI.this.eOf.SO();
                    }
                    if (SettingsUI.this.mQY != null) {
                        SettingsUI.this.mQY.cancel();
                    }
                    SettingsUI.this.btX();
                    return false;
                }
            }, false);
            settingsUI.eOf.J(3000, 3000);
            settingsUI.getString(i.app_tip);
            settingsUI.mQY = h.a((Context) settingsUI, settingsUI.getString(i.wx_logout_processing_txt), true, new 18(settingsUI));
            return;
        }
        o DF = g.DF();
        14 14 = new 14(settingsUI);
        settingsUI.ehD = 14;
        DF.a(281, 14);
        final ac acVar = new ac(2);
        g.DF().a(acVar, 0);
        settingsUI.buh();
        settingsUI.mQZ = new al(Looper.getMainLooper(), new al.a() {
            public final boolean vD() {
                g.DF().c(acVar);
                g.DF().b(281, SettingsUI.this.ehD);
                g.DF().b(282, SettingsUI.this.mUr);
                SettingsUI.this.ehD = null;
                SettingsUI.this.mUr = null;
                if (SettingsUI.this.mQZ != null) {
                    SettingsUI.this.mQZ.SO();
                    SettingsUI.this.mQZ = null;
                }
                if (SettingsUI.this.mQY != null) {
                    SettingsUI.this.mQY.cancel();
                }
                SettingsUI.this.btX();
                return false;
            }
        }, false);
        settingsUI.mQZ.J(5000, 5000);
        settingsUI.getString(i.app_tip);
        settingsUI.mQY = h.a((Context) settingsUI, settingsUI.getString(i.webwx_logout_processing_txt), true, new 16(settingsUI, acVar));
    }

    public final int Ys() {
        return k.settings_pref;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
        g.Ei().DT().a(this);
        com.tencent.mm.s.c.Cp().a(this.mUs);
        if (bi.getInt(com.tencent.mm.k.g.AT().getValue("VoiceprintEntry"), 0) == 1 && (g.Ei().DT().getInt(40, 0) & WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT) == 0) {
            g.Ei().DT().a(aa.a.sPp, Boolean.valueOf(false));
            x.i("MicroMsg.SettingsUI", "unset more tab dot");
        }
    }

    protected void onDestroy() {
        if (g.Eg().Dx()) {
            g.Ei().DT().b(this);
            com.tencent.mm.s.c.Cp().b(this.mUs);
        }
        if (this.ehD != null) {
            g.DF().b(281, this.ehD);
        }
        if (this.mRa != null) {
            g.DF().b(WebView.NORMAL_MODE_ALPHA, this.mRa);
        }
        if (this.mUw != null) {
            g.DF().b(281, this.mUw);
        }
        super.onDestroy();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        x.v("MicroMsg.SettingsUI", "settings handle");
        String d;
        switch (i) {
            case 2:
                if (intent != null) {
                    d = l.d(getApplicationContext(), intent, com.tencent.mm.plugin.p.c.Gb());
                    if (d != null) {
                        Intent intent2 = new Intent();
                        intent2.putExtra("CropImageMode", 1);
                        intent2.putExtra("CropImage_OutputPath", com.tencent.mm.aa.q.Kp().c(q.GF(), true, false));
                        intent2.putExtra("CropImage_ImgPath", d);
                        com.tencent.mm.plugin.setting.b.ezn.a(this, intent, intent2, com.tencent.mm.plugin.p.c.Gb(), 4, null);
                        return;
                    }
                    return;
                }
                return;
            case 3:
                d = l.d(getApplicationContext(), intent, com.tencent.mm.plugin.p.c.Gb());
                if (d != null) {
                    Intent intent3 = new Intent();
                    intent3.putExtra("CropImageMode", 1);
                    intent3.putExtra("CropImage_OutputPath", d);
                    intent3.putExtra("CropImage_ImgPath", d);
                    com.tencent.mm.plugin.setting.b.ezn.a(this.mController.tml, intent3, 4);
                    return;
                }
                return;
            case 4:
                if (intent != null) {
                    d = intent.getStringExtra("CropImage_OutputPath");
                    if (d == null) {
                        x.e("MicroMsg.SettingsUI", "crop picture failed");
                    } else {
                        new com.tencent.mm.aa.o(this.mController.tml, d).b(1, null);
                    }
                    super.onActivityResult(i, i2, intent);
                    return;
                }
                return;
            case 5:
                if (i2 == -1) {
                    btX();
                    return;
                }
                return;
            default:
                return;
        }
    }

    public void onPause() {
        super.onPause();
        g.Em().L(new 12(this));
    }

    public void onResume() {
        PersonalPreference personalPreference = (PersonalPreference) this.eOE.ZZ("settings_account");
        if (personalPreference != null) {
            String GF = q.GF();
            personalPreference.dHf = null;
            personalPreference.mQd = -1;
            personalPreference.mQe = GF;
            if (personalPreference.jev != null) {
                com.tencent.mm.pluginsdk.ui.a.b.a(personalPreference.jev, personalPreference.mQe);
            }
        }
        ef efVar = new ef();
        com.tencent.mm.sdk.b.a.sFg.m(efVar);
        if (!efVar.bMc.bKE) {
            this.eOE.c(this.eOE.ZZ("settings_about_device"));
        }
        bub();
        bud();
        bty();
        buc();
        IconPreference iconPreference = (IconPreference) this.eOE.ZZ("settings_welab");
        com.tencent.mm.plugin.welab.a.a.c cVar = (com.tencent.mm.plugin.welab.a.a.c) g.l(com.tencent.mm.plugin.welab.a.a.c.class);
        if (cVar.bYO()) {
            iconPreference.Er(0);
            iconPreference.dk(getString(i.app_new), com.tencent.mm.plugin.setting.a.e.new_tips_bg);
        } else {
            iconPreference.Er(8);
        }
        if (!cVar.bYP()) {
            iconPreference.eV(8, -1);
        } else if (cVar.bYN()) {
            iconPreference.eV(0, com.tencent.mm.plugin.setting.a.h.welab_icon_light);
        } else {
            iconPreference.eV(0, com.tencent.mm.plugin.setting.a.h.welab_icon_grey);
        }
        this.eOE.c(this.eOE.ZZ("settings_hardcoder"));
        x.v("MicroMsg.SettingsUI", "on resume");
        super.onResume();
    }

    private void bub() {
        IconPreference iconPreference = (IconPreference) this.eOE.ZZ("settings_account_info");
        if (iconPreference == null) {
            x.e("MicroMsg.SettingsUI", "safedevicesate preference is null");
            return;
        }
        iconPreference.Ew(8);
        if (com.tencent.mm.s.c.Cp().a(aa.a.sZC, 266257)) {
            iconPreference.Et(0);
        } else {
            iconPreference.Et(8);
        }
        if (bi.getInt(com.tencent.mm.k.g.AT().getValue("VoiceprintEntry"), 0) == 1) {
            if (!((Boolean) g.Ei().DT().get(aa.a.sPr, Boolean.valueOf(true))).booleanValue()) {
                iconPreference.Er(8);
                iconPreference.dk("", -1);
            } else if ((g.Ei().DT().getInt(40, 0) & WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT) == 0) {
                iconPreference.dk(getString(i.app_new), com.tencent.mm.plugin.setting.a.e.new_tips_bg);
                iconPreference.Er(0);
                x.i("MicroMsg.SettingsUI", "show voiceprint dot");
            }
            this.eOE.notifyDataSetChanged();
        }
    }

    protected final void initView() {
        setMMTitle(i.settings_title);
        this.eOE = this.tCL;
        setBackBtn(new 23(this));
        this.eSg = new d(this, 1, false);
        this.eSg.ofp = new 24(this);
        this.eSg.uJQ = new 25(this);
        this.eSg.ofq = new 26(this);
        27 27 = new 27(this);
        bud();
        bty();
        buc();
        if (!com.tencent.mm.sdk.platformtools.d.REDESIGN_ENTRANCE) {
            this.eOE.bw("settings_redesign", true);
        }
    }

    public final void a(int i, m mVar, Object obj) {
        int p = bi.p(obj, 0);
        x.d("MicroMsg.SettingsUI", "onNotifyChange event:%d obj:%d stg:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(p), mVar});
        if (mVar != g.Ei().DT() || p <= 0) {
            x.e("MicroMsg.SettingsUI", "onNotifyChange error obj:%d stg:%s", new Object[]{Integer.valueOf(p), mVar});
            return;
        }
        if (4 == p) {
            g.Ei().DT().get(2, null);
            g.Ei().DT().get(4, null);
        }
        if (6 == p) {
            bud();
        } else if (64 == p) {
            bub();
        }
    }

    private void bty() {
        int i;
        int i2 = 0;
        IconPreference iconPreference = (IconPreference) this.eOE.ZZ("settings_about_micromsg");
        boolean a = bi.a(Boolean.valueOf(com.tencent.mm.s.c.Cp().aT(262145, 266243)), false);
        boolean aU = com.tencent.mm.s.c.Cp().aU(262157, 266262);
        if (com.tencent.mm.sdk.platformtools.e.sFF) {
            iconPreference.dk("", -1);
            iconPreference.Er(8);
        } else if (a) {
            iconPreference.Er(0);
            iconPreference.dk(getString(i.app_new), com.tencent.mm.plugin.setting.a.e.new_tips_bg);
        } else if (aU) {
            iconPreference.Et(0);
        } else {
            iconPreference.Et(8);
            iconPreference.dk("", -1);
            iconPreference.Er(8);
        }
        iconPreference = (IconPreference) this.eOE.ZZ("settings_about_system");
        if (com.tencent.mm.s.c.Cp().aU(262158, 266265)) {
            i = 0;
        } else {
            i = 8;
        }
        iconPreference.Et(i);
        com.tencent.mm.plugin.ab.a.bjk();
        if (!com.tencent.mm.ao.c.ig(com.tencent.mm.ao.b.ebm)) {
            i2 = 8;
        }
        iconPreference.Et(i2);
    }

    private void buc() {
        IconPreference iconPreference = (IconPreference) this.eOE.ZZ("settings_about_privacy");
        if (iconPreference == null) {
            return;
        }
        if (((Integer) g.Ei().DT().get(aa.a.sWh, Integer.valueOf(0))).intValue() > ((Integer) g.Ei().DT().get(aa.a.sWi, Integer.valueOf(0))).intValue()) {
            iconPreference.Et(0);
        } else {
            iconPreference.Et(8);
        }
    }

    private void bud() {
        com.tencent.mm.plugin.account.friend.a.l.a XC = com.tencent.mm.plugin.account.friend.a.l.XC();
        SwitchKeyValuePreference switchKeyValuePreference = (SwitchKeyValuePreference) this.eOE.ZZ("settings_bind_mobile");
        if (switchKeyValuePreference != null) {
            boolean z = XC == com.tencent.mm.plugin.account.friend.a.l.a.eKt || XC == com.tencent.mm.plugin.account.friend.a.l.a.eKu;
            switchKeyValuePreference.bKe = z;
            switchKeyValuePreference.aL();
            int i = (XC == com.tencent.mm.plugin.account.friend.a.l.a.eKt || XC == com.tencent.mm.plugin.account.friend.a.l.a.eKu) ? i.settings_plugins_enable : i.settings_plugins_disable;
            switchKeyValuePreference.setSummary(i);
        }
    }

    public final boolean a(f fVar, Preference preference) {
        String str = preference.mKey;
        x.i("MicroMsg.SettingsUI", str + " item has been clicked!");
        Intent intent;
        if ("settings_welab".equals(str)) {
            intent = new Intent();
            ArrayList arrayList = new ArrayList();
            arrayList.add("labs_browse");
            intent.putStringArrayListExtra("key_exclude_apps", arrayList);
            ((com.tencent.mm.plugin.welab.a.a.c) g.l(com.tencent.mm.plugin.welab.a.a.c.class)).x(this, intent);
            return true;
        } else if ("settings_account_info".equals(str)) {
            if (bi.getInt(com.tencent.mm.k.g.AT().getValue("VoiceprintEntry"), 0) == 1 && (g.Ei().DT().getInt(40, 0) & WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT) == 0) {
                g.Ei().DT().a(aa.a.sPr, Boolean.valueOf(false));
                x.i("MicroMsg.SettingsUI", "unset setting account info dot show");
            }
            com.tencent.mm.s.c.Cp().b(aa.a.sZC, 266257);
            L(SettingsAccountInfoUI.class);
            return true;
        } else if ("settings_account".equals(str)) {
            this.mController.tml.startActivity(new Intent(this, SettingsPersonalInfoUI.class));
            return true;
        } else if (str.equals("settings_bind_mobile")) {
            Intent intent2 = new Intent(this, BindMContactIntroUI.class);
            intent2.putExtra("key_upload_scene", 4);
            MMWizardActivity.D(this, intent2);
            return true;
        } else if (str.equals("settings_about_privacy")) {
            int intValue = ((Integer) g.Ei().DT().get(aa.a.sWh, Integer.valueOf(0))).intValue();
            if (intValue > ((Integer) g.Ei().DT().get(aa.a.sWi, Integer.valueOf(0))).intValue()) {
                g.Ei().DT().a(aa.a.sWi, Integer.valueOf(intValue));
            }
            startActivity(new Intent(this, SettingsPrivacyUI.class));
            return true;
        } else if (str.equals("settings_about_system")) {
            com.tencent.mm.s.c.Cp().aV(262158, 266265);
            startActivity(new Intent(this, SettingsAboutSystemUI.class));
            return true;
        } else if (str.equals("settings_about_micromsg")) {
            com.tencent.mm.s.c.Cp().aV(262145, 266243);
            com.tencent.mm.s.c.Cp().aV(262157, 266262);
            this.mController.tml.startActivity(new Intent(this, SettingsAboutMicroMsgUI.class));
            new ag().postDelayed(new 29(this), 100);
            return true;
        } else if (str.equals("settings_about_device")) {
            com.tencent.mm.bg.d.b(this.mController.tml, "exdevice", ".ui.ExdeviceManageDeviceUI", new Intent());
            return true;
        } else if (str.equals("settings_logout")) {
            if (com.tencent.mm.al.b.PD()) {
                x.i("MicroMsg.SettingsUI", "oversea user logout");
                h.a(this.mController.tml, true, getResources().getString(i.settings_logout_warning_tip), "", getResources().getString(i.settings_logout), getString(i.app_cancel), new 13(this), null);
                return true;
            }
            com.tencent.mm.plugin.report.service.h.mEJ.h(11545, new Object[]{Integer.valueOf(8)});
            x.i("MicroMsg.SettingsUI", "reprot: MM_LightPushCloseWechat == OP_LogoutCloseEntrance");
            if (bt.dDs.IH().size() > 1) {
                com.tencent.mm.plugin.report.service.h.mEJ.h(14978, new Object[]{Integer.valueOf(1), Integer.valueOf(10), bt.dDs.II()});
            } else {
                com.tencent.mm.plugin.report.service.h.mEJ.h(14978, new Object[]{Integer.valueOf(0), Integer.valueOf(10), bt.dDs.II()});
            }
            this.eSg.bXO();
            return true;
        } else if (str.equals("settings_exit")) {
            return bug();
        } else {
            if (str.equals("settings_logout_option")) {
                return buf();
            }
            if (str.equals("settings_notification_preference")) {
                startActivity(new Intent(this, SettingsNotificationUI.class));
                return true;
            } else if (str.equals("settings_chatting")) {
                L(SettingsChattingUI.class);
                return true;
            } else if (str.equals("settings_active_time")) {
                com.tencent.mm.plugin.report.service.h.mEJ.h(11351, new Object[]{Integer.valueOf(1), Integer.valueOf(0)});
                L(SettingsActiveTimeUI.class);
                return true;
            } else {
                if (str.equals("settings_feedback")) {
                    str = (com.tencent.mm.sdk.platformtools.e.sFF || !w.chP().equals("zh_CN")) ? w.chP().equals("zh_HK") ? getString(i.wechat_faq_url_cht) : w.chP().equals("zh_TW") ? getString(i.wechat_faq_url_cht_tw) : getString(i.wechat_faq_url_en) : getString(i.wechat_faq_url);
                    x.d("MicroMsg.SettingsUI", "using faq webpage");
                    intent = new Intent();
                    intent.putExtra("showShare", false);
                    intent.putExtra("rawUrl", str);
                    intent.putExtra("show_feedback", false);
                    intent.putExtra("KShowFixToolsBtn", true);
                    com.tencent.mm.bg.d.b(this.mController.tml, "webview", ".ui.tools.WebViewUI", intent);
                } else if (!str.equals("settings_hardcoder")) {
                    if (str.equals("settings_switch_account")) {
                        if (bt.dDs.IH().size() > 1) {
                            com.tencent.mm.plugin.report.service.h.mEJ.h(14978, new Object[]{Integer.valueOf(1), Integer.valueOf(6), bt.dDs.II()});
                        } else {
                            com.tencent.mm.plugin.report.service.h.mEJ.h(14978, new Object[]{Integer.valueOf(0), Integer.valueOf(6), bt.dDs.II()});
                        }
                        if (g.Ei().DT().getBoolean(aa.a.sZa, true)) {
                            g.Ei().DT().a(aa.a.sZa, Boolean.valueOf(false));
                            h.a((Context) this, getString(i.settings_switch_account_alert_tip), getString(i.settings_switch_account_alert_title), getString(i.app_i_known), false, new 28(this));
                        } else {
                            bue();
                        }
                    } else if (str.equals("settings_redesign")) {
                        startActivity(new Intent(this, SettingRedesign.class));
                        return true;
                    }
                }
                return false;
            }
        }
    }

    private void bue() {
        Intent intent = new Intent(this, SettingsSwitchAccountUI.class);
        intent.putExtra("key_scene", 0);
        startActivity(intent);
    }

    private void btX() {
        x.i("MicroMsg.SettingsUI", "oneliang logout mm");
        com.tencent.mm.plugin.setting.b.ezo.vr();
        g.Ei().DT().b(this);
        ja jaVar = new ja();
        jaVar.bSG.status = 0;
        jaVar.bSG.aAk = 0;
        com.tencent.mm.sdk.b.a.sFg.m(jaVar);
        y yVar = new y();
        yVar.bHg.bHh = true;
        com.tencent.mm.sdk.b.a.sFg.m(yVar);
        af.Wq("show_whatsnew");
        com.tencent.mm.kernel.k.j(this, true);
        ad.getContext().getSharedPreferences("switch_account_preferences", 0).edit().putBoolean("last_logout_switch_account", false).commit();
        Intent intent = new Intent();
        intent.addFlags(67108864);
        intent.putExtra("Intro_Switch", true);
        com.tencent.mm.plugin.setting.b.ezn.q(intent, this.mController.tml);
        com.tencent.mm.platformtools.x.H(this, null);
        finish();
    }

    private boolean buf() {
        com.tencent.mm.plugin.report.service.h.mEJ.h(11545, new Object[]{Integer.valueOf(1)});
        x.i("MicroMsg.SettingsUI", "reprot: MM_LightPushCloseWechat == OP_LogoutOutside");
        if (this.mUt != null) {
            this.mUt.show();
        } else {
            x.i("MicroMsg.SettingsUI", "reprot: MM_LightPushCloseWechat == OP_LogoutOutside");
            this.mUt = h.a((Context) this, getString(i.settings_logout_warning_tip), "", getString(i.settings_logout), getString(i.settings_logout_option_cancel), new 2(this), new 3(this));
        }
        return true;
    }

    private boolean bug() {
        com.tencent.mm.plugin.report.service.h.mEJ.h(11545, new Object[]{Integer.valueOf(4)});
        x.i("MicroMsg.SettingsUI", "reprot: MM_LightPushCloseWechat == OP_CloseWeChat");
        if (this.kOX == null) {
            this.kOX = View.inflate(this.mController.tml, com.tencent.mm.plugin.setting.a.g.settings_close, null);
            this.mUv = (CheckBox) this.kOX.findViewById(com.tencent.mm.plugin.setting.a.f.settings_notify_dialog_cb);
            this.mUv.setChecked(true);
        }
        if (this.mUu == null) {
            this.mUu = h.a(this.mController.tml, null, this.kOX, getString(i.logout_menu_exit), getString(i.app_cancel), new 4(this), new 5(this));
        } else {
            this.mUu.show();
        }
        return true;
    }

    private void buh() {
        o DF = g.DF();
        19 19 = new 19(this);
        this.mUr = 19;
        DF.a(282, 19);
        g.DF().a(new p(), 0);
    }

    private void hC(boolean z) {
        af.Wq("welcome_page_show");
        if (z) {
            ((com.tencent.mm.plugin.notification.b.a) g.n(com.tencent.mm.plugin.notification.b.a.class)).getNotification().xU();
        } else {
            ((com.tencent.mm.plugin.notification.b.a) g.n(com.tencent.mm.plugin.notification.b.a.class)).getNotification().n(-1, null);
        }
        y yVar = new y();
        yVar.bHg.bHh = false;
        com.tencent.mm.sdk.b.a.sFg.m(yVar);
        com.tencent.mm.plugin.setting.b.ezo.vo();
        ((com.tencent.mm.plugin.notification.b.a) g.n(com.tencent.mm.plugin.notification.b.a.class)).getNotification().xR();
        finish();
        if (com.tencent.mm.pluginsdk.f.e.qBn != null) {
            com.tencent.mm.pluginsdk.f.e.qBn.h(this.mController.tml, z);
        }
    }

    private void bui() {
        o DF = g.DF();
        20 20 = new 20(this);
        this.mRa = 20;
        DF.a(WebView.NORMAL_MODE_ALPHA, 20);
        r rVar = new r(2);
        rVar.efX = 1;
        g.DF().a(rVar, 0);
        this.mQZ = new al(Looper.getMainLooper(), new 21(this, rVar), false);
        this.mQZ.J(3000, 3000);
        Context context = this.mController.tml;
        getString(i.app_tip);
        this.mQY = h.a(context, getString(i.wx_exit_processing_txt), false, new 22(this, rVar));
    }
}

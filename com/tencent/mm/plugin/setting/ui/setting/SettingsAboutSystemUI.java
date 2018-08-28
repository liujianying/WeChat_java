package com.tencent.mm.plugin.setting.ui.setting;

import android.app.ProgressDialog;
import android.content.ComponentName;
import android.content.Intent;
import android.nfc.NfcAdapter;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.compatible.i.a;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.af;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.setting.a.b;
import com.tencent.mm.plugin.setting.a.e;
import com.tencent.mm.plugin.setting.a.i;
import com.tencent.mm.plugin.setting.a.k;
import com.tencent.mm.protocal.c.xt;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.IconPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.widget.a.c;

public class SettingsAboutSystemUI extends MMPreference {
    private f eOE;
    private boolean isDeleteCancel = false;
    private ProgressDialog mQY = null;
    private boolean mRg = false;
    private int mRh = -1;
    private int mRi = -1;
    private boolean mRj = false;

    public final int Ys() {
        return k.settings_pref_system;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mRg = false;
        initView();
    }

    protected final void initView() {
        setMMTitle(i.settings_about_system);
        this.eOE = this.tCL;
        setBackBtn(new 1(this));
        this.eOE.bw("settings_swipeback_mode", !d.fR(19));
        if (!com.tencent.mm.bg.d.QS("backup")) {
            this.eOE.bw("settings_bak_chat", true);
        }
        bty();
        this.eOE.bw("settings_traffic_statistic", com.tencent.mm.bg.d.cfH());
        if (af.eyg) {
            this.eOE.bw("settings_take_photo", true);
        }
    }

    protected void onResume() {
        super.onResume();
        CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.eOE.ZZ("settings_voice_play_mode");
        if (checkBoxPreference != null) {
            checkBoxPreference.qpJ = ((Boolean) g.Ei().DT().get(26, Boolean.valueOf(false))).booleanValue();
            checkBoxPreference.tDr = false;
        }
        checkBoxPreference = (CheckBoxPreference) this.eOE.ZZ("settings_enter_button_send");
        if (checkBoxPreference != null) {
            checkBoxPreference.qpJ = ((Boolean) g.Ei().DT().get(66832, Boolean.valueOf(false))).booleanValue();
            checkBoxPreference.tDr = false;
        }
        checkBoxPreference = (CheckBoxPreference) this.eOE.ZZ("settings_swipeback_mode");
        if (checkBoxPreference != null) {
            checkBoxPreference.qpJ = a.zX();
            checkBoxPreference.tDr = false;
        }
        Preference ZZ = this.eOE.ZZ("settings_language");
        if (ZZ != null) {
            ZZ.setSummary(w.h(this.mController.tml, b.language_setting, i.app_lang_sys));
        }
        bty();
        btB();
        btB();
        btA();
        NfcAdapter defaultAdapter = NfcAdapter.getDefaultAdapter(this);
        checkBoxPreference = (CheckBoxPreference) this.eOE.ZZ("settings_nfc_switch");
        if (defaultAdapter == null) {
            this.eOE.bw("settings_nfc_switch", true);
            return;
        }
        this.eOE.bw("settings_nfc_switch", false);
        checkBoxPreference.setSummary(bi.oV((String) g.Ei().DT().get(aa.a.sQK, null)));
        if (this.mRg) {
            x.i("MicroMsg.SettingsAboutSystemUI", "lo-nfc-updateNfcOpenSwitch go setSystemNfc and back");
            if (defaultAdapter.isEnabled()) {
                gT(true);
                hz(true);
                return;
            }
        }
        int intValue = ((Integer) g.Ei().DT().get(aa.a.sQG, Integer.valueOf(0))).intValue();
        if (intValue == 0) {
            if (((Integer) g.Ei().DT().get(aa.a.sQH, Integer.valueOf(0))).intValue() == 1) {
                hz(true);
            } else {
                hz(false);
            }
        } else if (intValue == 1) {
            hz(true);
        } else {
            hz(false);
        }
        this.eOE.notifyDataSetChanged();
    }

    protected void onDestroy() {
        boolean z = true;
        super.onDestroy();
        if (this.mRj) {
            boolean z2;
            String str = "MicroMsg.SettingsAboutSystemUI";
            String str2 = "kvstat, autodownload sight change: %d, %b";
            Object[] objArr = new Object[2];
            objArr[0] = Integer.valueOf(this.mRi);
            if (this.mRh == this.mRi) {
                z2 = true;
            } else {
                z2 = false;
            }
            objArr[1] = Boolean.valueOf(z2);
            x.i(str, str2, objArr);
            h hVar = h.mEJ;
            Object[] objArr2 = new Object[3];
            objArr2[0] = Integer.valueOf(1);
            objArr2[1] = Integer.valueOf(this.mRi);
            if (this.mRh != this.mRi) {
                z = false;
            }
            objArr2[2] = Boolean.valueOf(z);
            hVar.h(11437, objArr2);
        }
    }

    public final boolean a(f fVar, Preference preference) {
        boolean z = false;
        String str = preference.mKey;
        boolean booleanValue;
        c.a aVar;
        LinearLayout linearLayout;
        c anj;
        if (str.equals("settings_landscape_mode")) {
            if (this.duR.getBoolean("settings_landscape_mode", false)) {
                setRequestedOrientation(-1);
                return true;
            }
            setRequestedOrientation(1);
            return true;
        } else if (str.equals("settings_voicerecorder_mode")) {
            if (this.duR.getBoolean("settings_voicerecorder_mode", q.deN.dbG != 1)) {
                return true;
            }
            com.tencent.mm.ui.base.h.a(this.mController.tml, i.settings_voicerecorder_mode_change_to_amr, i.app_tip, new 8(this), new 9(this));
            return true;
        } else if (str.equals("settings_nfc_switch")) {
            NfcAdapter defaultAdapter = NfcAdapter.getDefaultAdapter(this);
            if (defaultAdapter == null) {
                x.i("MicroMsg.SettingsAboutSystemUI", "lo-nfc-goTosetNfcSwitch phone not suppot nfc");
                return true;
            }
            int intValue = ((Integer) g.Ei().DT().get(aa.a.sQG, Integer.valueOf(0))).intValue();
            int intValue2 = ((Integer) g.Ei().DT().get(aa.a.sQH, Integer.valueOf(0))).intValue();
            if ((intValue == 2 || (intValue == 0 && intValue2 != 1)) && !defaultAdapter.isEnabled() && this.duR.getBoolean("settings_nfc_switch", false)) {
                hz(false);
                com.tencent.mm.ui.base.h.a(this.mController.tml, getString(i.nfc_off_tips), "", getString(i.nfc_open_title), getString(i.app_cancel), new 6(this), new 7(this));
                return true;
            }
            gT(this.duR.getBoolean("settings_nfc_switch", false));
            return true;
        } else if (str.equals("settings_voice_play_mode")) {
            booleanValue = ((Boolean) g.Ei().DT().get(26, Boolean.valueOf(false))).booleanValue();
            String str2 = "MicroMsg.SettingsAboutSystemUI";
            String str3 = "set voice mode from %B to %B";
            Object[] objArr = new Object[2];
            objArr[0] = Boolean.valueOf(booleanValue);
            objArr[1] = Boolean.valueOf(!booleanValue);
            x.d(str2, str3, objArr);
            com.tencent.mm.storage.x DT = g.Ei().DT();
            if (!booleanValue) {
                z = true;
            }
            DT.set(26, Boolean.valueOf(z));
            return true;
        } else if (str.equals("settings_enter_button_send")) {
            CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.eOE.ZZ("settings_enter_button_send");
            if (checkBoxPreference == null) {
                return true;
            }
            x.d("MicroMsg.SettingsAboutSystemUI", "set enter button send : %s", new Object[]{Boolean.valueOf(checkBoxPreference.isChecked())});
            g.Ei().DT().set(66832, Boolean.valueOf(r0));
            return true;
        } else if (str.equals("settings_sns_sight_auto_download")) {
            aVar = new c.a(this.mController.tml);
            aVar.Gu(i.app_cancel);
            aVar.Gq(i.settings_sns_sight_auto_download_tips);
            View inflate = View.inflate(this.mController.tml, com.tencent.mm.plugin.setting.a.g.mm_alert_switch, null);
            linearLayout = (LinearLayout) inflate.findViewById(com.tencent.mm.plugin.setting.a.f.switcher_container);
            int a = bi.a((Integer) g.Ei().DT().get(327686, null), bi.getInt(com.tencent.mm.k.g.AT().getValue("SIGHTAutoLoadNetwork"), 1));
            2 2 = new 2(this, linearLayout, a);
            a(linearLayout, i.settings_sns_sight_auto_download_always, 1, 1 == a, 2);
            a(linearLayout, i.settings_sns_sight_auto_download_wifi, 2, 2 == a, 2);
            a(linearLayout, i.settings_sns_sight_auto_download_never, 3, 3 == a, 2);
            aVar.dR(inflate);
            anj = aVar.anj();
            linearLayout.setTag(anj);
            anj.show();
            addDialog(anj);
            this.mRj = true;
            return true;
        } else if (str.equals("settings_silence_update_mode")) {
            aVar = new c.a(this.mController.tml);
            aVar.Gu(i.app_cancel);
            aVar.Gq(i.settings_silence_update_mode);
            View inflate2 = View.inflate(this.mController.tml, com.tencent.mm.plugin.setting.a.g.mm_alert_switch, null);
            linearLayout = (LinearLayout) inflate2.findViewById(com.tencent.mm.plugin.setting.a.f.switcher_container);
            OnClickListener anonymousClass10 = new OnClickListener() {
                public final void onClick(View view) {
                    int i;
                    int i2;
                    int i3 = 0;
                    for (i = 0; i < linearLayout.getChildCount(); i++) {
                        TextView textView = (TextView) linearLayout.getChildAt(i);
                        if (com.tencent.mm.plugin.setting.a.f.tips_tv != textView.getId()) {
                            textView.setCompoundDrawablesWithIntrinsicBounds(com.tencent.mm.plugin.setting.a.h.radio_off, 0, 0, 0);
                        }
                    }
                    ((TextView) view).setCompoundDrawablesWithIntrinsicBounds(com.tencent.mm.plugin.setting.a.h.radio_on, 0, 0, 0);
                    int intValue = ((Integer) g.Ei().DT().get(7, Integer.valueOf(0))).intValue();
                    int intValue2 = ((Integer) view.getTag()).intValue();
                    x.d("MicroMsg.SettingsAboutSystemUI", "settings_silence_update_mode choice: %d", new Object[]{Integer.valueOf(intValue2)});
                    if (intValue2 == 0) {
                        i = 1;
                    } else {
                        i = 0;
                    }
                    if ((intValue & 16777216) == 0) {
                        i2 = 1;
                    } else {
                        i2 = 0;
                    }
                    if (i != i2) {
                        if (intValue2 == 0) {
                            i3 = 1;
                        }
                        if (i3 != 0) {
                            i = -16777217 & intValue;
                        } else {
                            i = intValue | 16777216;
                        }
                        i2 = i3 == 0 ? 1 : 2;
                        g.Ei().DT().set(7, Integer.valueOf(i));
                        xt xtVar = new xt();
                        xtVar.rDz = 35;
                        xtVar.rDA = i2;
                        ((com.tencent.mm.plugin.messenger.foundation.a.i) g.l(com.tencent.mm.plugin.messenger.foundation.a.i.class)).FQ().b(new com.tencent.mm.plugin.messenger.foundation.a.a.h.a(23, xtVar));
                        com.tencent.mm.plugin.setting.b.ezo.vl();
                        view.post(new 1(this));
                    }
                }
            };
            boolean z2 = (((Integer) g.Ei().DT().get(7, Integer.valueOf(0))).intValue() & 16777216) == 0;
            a(linearLayout, i.settings_silence_update_mode_wifi, 0, z2, anonymousClass10);
            a(linearLayout, i.settings_silence_update_mode_none, 1, !z2, anonymousClass10);
            aVar.dR(inflate2);
            anj = aVar.anj();
            linearLayout.setTag(anj);
            anj.show();
            addDialog(anj);
            return true;
        } else if (str.equals("settings_language")) {
            startActivity(new Intent(this.mController.tml, SettingsLanguageUI.class));
            return true;
        } else if (str.equals("settings_text_size")) {
            return btz();
        } else {
            Intent intent;
            if (str.equals("settings_chatting_bg")) {
                intent = new Intent();
                intent.setClass(this, SettingsChattingBackgroundUI.class);
                this.mController.tml.startActivity(intent);
                return true;
            } else if (str.equals("settings_manage_findmoreui")) {
                intent = new Intent();
                intent.setClass(this, SettingsManageFindMoreUI.class);
                startActivity(intent);
                return true;
            } else if (str.equals("settings_plugins")) {
                g.Ei().DT().set(-2046825377, Boolean.valueOf(false));
                intent = new Intent();
                intent.setClass(this, SettingsPluginsUI.class);
                startActivity(intent);
                com.tencent.mm.s.c.Cp().aV(262158, 266266);
                return true;
            } else if (str.equals("settings_reset")) {
                com.tencent.mm.ui.base.h.a(this.mController.tml, getResources().getString(i.settings_reset_warning), "", getString(i.app_clear), getString(i.app_cancel), new 5(this), null);
                return true;
            } else if (str.equals("settings_emoji_manager")) {
                intent = new Intent();
                intent.putExtra("10931", 2);
                com.tencent.mm.bg.d.b(this.mController.tml, "emoji", ".ui.EmojiMineUI", intent);
                return true;
            } else if (str.equals("settngs_clean")) {
                if (g.Ei().isSDCardAvailable()) {
                    com.tencent.mm.bg.d.b(this.mController.tml, "clean", ".ui.CleanUI", new Intent());
                    return true;
                }
                s.gH(this.mController.tml);
                return true;
            } else if (str.equals("settings_traffic_statistic")) {
                startActivity(new Intent(this, SettingsNetStatUI.class));
                return true;
            } else if (str.equals("settings_text_size")) {
                return btz();
            } else {
                if (str.equals("settings_swipeback_mode")) {
                    CheckBoxPreference checkBoxPreference2 = (CheckBoxPreference) preference;
                    booleanValue = a.zX();
                    com.tencent.mm.ui.base.h.a(this.mController.tml, getString(!booleanValue ? i.settings_swipeback_mode_open_tips : i.settings_swipeback_mode_close_tips), null, new 3(this), new 4(this, checkBoxPreference2, booleanValue));
                    return true;
                }
                if (str.equals("settings_take_photo")) {
                    startActivity(new Intent(this, SettingsAboutCamera.class));
                }
                return false;
            }
        }
    }

    private void bty() {
        int i;
        int i2 = 0;
        IconPreference iconPreference = (IconPreference) this.eOE.ZZ("settings_plugins");
        if (bi.a((Boolean) g.Ei().DT().get(-2046825377, null), false)) {
            iconPreference.Er(0);
            iconPreference.dk(getString(i.app_new), e.new_tips_bg);
        } else {
            iconPreference.Er(8);
            iconPreference.dk("", -1);
        }
        if (com.tencent.mm.s.c.Cp().aU(262158, 266266)) {
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
        this.eOE.notifyDataSetChanged();
    }

    private boolean btz() {
        startActivity(new Intent(this, SettingsFontUI.class));
        return true;
    }

    private void gT(boolean z) {
        if (z) {
            getPackageManager().setComponentEnabledSetting(new ComponentName(ad.getPackageName(), "com.tencent.mm.plugin.nfc_open.ui.NfcWebViewUI"), 1, 1);
            g.Ei().DT().a(aa.a.sQG, Integer.valueOf(1));
            return;
        }
        getPackageManager().setComponentEnabledSetting(new ComponentName(ad.getPackageName(), "com.tencent.mm.plugin.nfc_open.ui.NfcWebViewUI"), 2, 1);
        g.Ei().DT().a(aa.a.sQG, Integer.valueOf(2));
    }

    private void hz(boolean z) {
        CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.eOE.ZZ("settings_nfc_switch");
        ad.getContext().getSharedPreferences(ad.chY(), 0).edit().putBoolean("settings_nfc_switch", z).commit();
        checkBoxPreference.qpJ = z;
        this.eOE.notifyDataSetChanged();
    }

    private void btA() {
        boolean z = true;
        boolean z2 = bi.WU(com.tencent.mm.k.g.AT().getValue("SilentDownloadApkAtWiFi")) != 0;
        if ((com.tencent.mm.sdk.platformtools.e.bxm & 1) != 0) {
            x.d("MicroMsg.SettingsAboutSystemUI", "channel pack, not silence download.");
            z2 = true;
        }
        if (z2) {
            this.eOE.bw("settings_silence_update_mode", true);
            return;
        }
        this.eOE.bw("settings_silence_update_mode", false);
        if ((((Integer) g.Ei().DT().get(7, Integer.valueOf(0))).intValue() & 16777216) != 0) {
            z = false;
        }
        this.eOE.ZZ("settings_silence_update_mode").setSummary(getString(z ? i.settings_silence_update_mode_wifi : i.settings_silence_update_mode_none));
        this.eOE.notifyDataSetChanged();
    }

    private void a(LinearLayout linearLayout, int i, int i2, boolean z, OnClickListener onClickListener) {
        TextView textView = (TextView) View.inflate(this.mController.tml, com.tencent.mm.plugin.setting.a.g.radio_btn_item, null);
        textView.setText(i);
        textView.setTag(Integer.valueOf(i2));
        linearLayout.addView(textView);
        textView.setOnClickListener(onClickListener);
        if (z) {
            textView.setCompoundDrawablesWithIntrinsicBounds(com.tencent.mm.plugin.setting.a.h.radio_on, 0, 0, 0);
        }
    }

    private void btB() {
        int a = bi.a((Integer) g.Ei().DT().get(327686, null), bi.getInt(com.tencent.mm.k.g.AT().getValue("SIGHTAutoLoadNetwork"), 1));
        x.i("MicroMsg.SettingsAboutSystemUI", "auto getSightViewSummary %d, %d", new Object[]{Integer.valueOf(r1), Integer.valueOf(a)});
        if (this.mRh == -1) {
            this.mRh = a;
        }
        this.mRi = a;
        if (3 == a) {
            a = i.settings_sns_sight_auto_download_never;
        } else if (2 == a) {
            a = i.settings_sns_sight_auto_download_wifi;
        } else {
            a = i.settings_sns_sight_auto_download_always;
        }
        Preference ZZ = this.eOE.ZZ("settings_sns_sight_auto_download");
        if (!(ZZ == null || a == 0)) {
            ZZ.setSummary(getString(a));
        }
        this.eOE.notifyDataSetChanged();
    }
}

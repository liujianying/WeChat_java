package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.mm.bg.d;
import com.tencent.mm.g.a.ay;
import com.tencent.mm.g.a.nq;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.am;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.account.bind.ui.BindMContactIntroUI;
import com.tencent.mm.plugin.account.ui.RegByMobileSetPwdUI;
import com.tencent.mm.plugin.setting.a;
import com.tencent.mm.plugin.setting.a.e;
import com.tencent.mm.plugin.setting.a.i;
import com.tencent.mm.plugin.setting.a.k;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.s.c;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.preference.IconPreference;
import com.tencent.mm.ui.base.preference.IconSwitchKeyValuePreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.PluginTextPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.base.s;

public class SettingsAccountInfoUI extends MMPreference implements b {
    private f eOE;
    private boolean mRA;
    private SparseIntArray mRB = new SparseIntArray();
    private View mRx;
    private TextView mRy;
    private EditText mRz;

    public SettingsAccountInfoUI() {
        this.mRB.put(0, i.settings_confirm_email_success_tip);
        this.mRB.put(-82, i.setting_unbind_qq_err_one_left);
        this.mRB.put(-83, i.setting_unbind_qq_err_has_unbind);
        this.mRB.put(-84, i.setting_unbind_qq_err_hasbinded);
        this.mRB.put(-85, i.setting_unbind_email_err_bindedbyother);
        this.mRB.put(-86, i.setting_unbind_qq_err_qmail);
    }

    public final int Ys() {
        return k.settings_pref_account_info;
    }

    public final boolean Yy() {
        return true;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
        g.Ei().DT().a(this);
    }

    protected void onDestroy() {
        super.onDestroy();
        g.Ei().DT().b(this);
    }

    protected final void initView() {
        setMMTitle(i.settings_account_info);
        this.eOE = this.tCL;
        this.mRx = View.inflate(this, a.g.sendrequest_dialog, null);
        this.mRy = (TextView) this.mRx.findViewById(a.f.sendrequest_tip);
        this.mRy.setText(getString(i.settings_independent_password_tip));
        this.mRz = (EditText) this.mRx.findViewById(a.f.sendrequest_content);
        this.mRz.setInputType(129);
        if (bi.getInt(com.tencent.mm.k.g.AT().getValue("VoiceprintEntry"), 0) != 1) {
            this.eOE.bw("settings_voiceprint_title", true);
        } else if (g.Eg().Dx()) {
            IconPreference iconPreference = (IconPreference) this.eOE.ZZ("settings_voiceprint_title");
            if (((Boolean) g.Ei().DT().get(aa.a.sPs, Boolean.valueOf(true))).booleanValue() && (g.Ei().DT().getInt(40, 0) & 131072) == 0) {
                iconPreference.dk(getString(i.app_new), e.new_tips_bg);
                iconPreference.Er(0);
                x.i("MicroMsg.SettingsAccountInfoUI", "show voiceprint dot");
                this.eOE.notifyDataSetChanged();
            }
        } else {
            x.e("MicroMsg.SettingsAccountInfoUI", "update voiceprint dot, account not ready!");
            return;
        }
        setBackBtn(new 1(this));
    }

    protected void onResume() {
        btC();
        btE();
        this.mRA = false;
        IconPreference iconPreference = (IconPreference) this.eOE.ZZ("settings_more_safe");
        if (c.Cp().b(aa.a.sZC, aa.a.sZD)) {
            iconPreference.Et(0);
        } else {
            iconPreference.Et(8);
        }
        btD();
        btF();
        this.eOE.bw("settings_facedect_title", true);
        PluginTextPreference pluginTextPreference = (PluginTextPreference) this.eOE.ZZ("settings_about_vusertitle");
        SelfVuserPreference selfVuserPreference = (SelfVuserPreference) this.eOE.ZZ("settings_about_vuserinfo");
        Preference ZZ = this.eOE.ZZ("settings_about_vuser_about");
        int f = bi.f((Integer) g.Ei().DT().get(66049, null));
        if (f != 0) {
            Bitmap e;
            pluginTextPreference.visibility = 8;
            pluginTextPreference.EA(i.contact_info_verify_user_title);
            if (am.a.dBt != null) {
                e = BackwardSupportUtil.b.e(am.a.dBt.gX(f), 2.0f);
            } else {
                e = null;
            }
            selfVuserPreference.drawable = new BitmapDrawable(getResources(), e);
            selfVuserPreference.text = (String) g.Ei().DT().get(66050, null);
        } else {
            this.eOE.c(pluginTextPreference);
            this.eOE.c(selfVuserPreference);
            this.eOE.c(ZZ);
        }
        super.onResume();
    }

    public final boolean a(f fVar, Preference preference) {
        String str = preference.mKey;
        x.i("MicroMsg.SettingsAccountInfoUI", str + " item has been clicked!");
        q.GF();
        if (bi.oW(str)) {
            return false;
        }
        if (str.equals("settings_username") && bi.oW(q.GG()) && ab.XU(q.GF())) {
            L(SettingsAliasUI.class);
        }
        if (str.equals("settings_mobile")) {
            Intent intent = new Intent(this, BindMContactIntroUI.class);
            intent.putExtra("key_upload_scene", 4);
            MMWizardActivity.D(this, intent);
            return true;
        }
        if (str.equals("settings_about_vuser_about")) {
            bi.L(this.mController.tml, String.format("https://weixin.qq.com/cgi-bin/readtemplate?check=false&t=weixin_faq_verifyaccount&platform=android&lang=%s", new Object[]{w.chP()}));
        } else if (str.equals("settings_independent_password")) {
            Intent intent2 = new Intent();
            intent2.putExtra("kintent_hint", getString(i.settings_modify_password_tip));
            a(RegByMobileSetPwdUI.class, intent2);
        } else if (str.equals("settings_manage_login_device")) {
            d.A(this, "account", ".security.ui.MySafeDeviceListUI");
        } else if (str.equals("settings_security_center")) {
            str = getString(i.wechat_securiy_center_path) + w.chP();
            ActionBarActivity actionBarActivity = this.mController.tml;
            Intent intent3 = new Intent();
            intent3.putExtra("rawUrl", str);
            intent3.putExtra("showShare", true);
            intent3.putExtra("show_bottom", false);
            intent3.putExtra("needRedirect", false);
            intent3.putExtra("hardcode_jspermission", JsapiPermissionWrapper.qWa);
            intent3.putExtra("hardcode_general_ctrl", GeneralControlWrapper.qVX);
            d.b(actionBarActivity, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent3);
        } else if (str.equals("settings_voiceprint_title")) {
            if (bi.getInt(com.tencent.mm.k.g.AT().getValue("VoiceprintEntry"), 0) == 1 && (g.Ei().DT().getInt(40, 0) & 131072) == 0) {
                g.Ei().DT().a(aa.a.sPs, Boolean.valueOf(false));
                ((IconPreference) this.eOE.ZZ("settings_voiceprint_title")).Er(8);
                this.eOE.notifyDataSetChanged();
                x.i("MicroMsg.SettingsAccountInfoUI", "unset setting account info new show");
            }
            d.A(this.mController.tml, "voiceprint", "com.tencent.mm.plugin.voiceprint.ui.SettingsVoicePrintUI");
        } else if (str.equals("settings_facedect_title")) {
            nq nqVar = new nq();
            nqVar.bYK.context = this;
            com.tencent.mm.sdk.b.a.sFg.m(nqVar);
            x.i("MicroMsg.SettingsAccountInfoUI", "hy: is start to face settings succ: %b", new Object[]{Boolean.valueOf(nqVar.bYL.bYJ)});
            if (!nqVar.bYL.bYJ) {
                s.makeText(this.mController.tml, getString(i.face_settings_not_support), 0).show();
            }
        } else if (str.equals("settings_trust_friend")) {
            L(SettingsTrustFriendUI.class);
        } else if (str.equals("settings_more_safe")) {
            c.Cp().c(aa.a.sZC, aa.a.sZD);
            L(SettingsMoreSafeUI.class);
        }
        return false;
    }

    public final void a(int i, m mVar, Object obj) {
        btC();
        btE();
        btD();
        btF();
    }

    private void btC() {
        Preference ZZ = this.eOE.ZZ("settings_username");
        CharSequence GG = q.GG();
        if (bi.oW(GG)) {
            GG = q.GF();
            if (ab.XT(GG)) {
                ZZ.setSummary(getString(i.settings_notset));
                return;
            } else {
                ZZ.setSummary(GG);
                return;
            }
        }
        ZZ.setSummary(GG);
    }

    private void btD() {
        if (this.eOE.ZZ("settings_manage_login_device") == null) {
            x.e("MicroMsg.SettingsAccountInfoUI", "safedevicesate preference is null");
        } else {
            this.eOE.bw("settings_manage_login_device", false);
        }
    }

    private void btE() {
        IconSwitchKeyValuePreference iconSwitchKeyValuePreference = (IconSwitchKeyValuePreference) this.eOE.ZZ("settings_mobile");
        if (iconSwitchKeyValuePreference == null) {
            x.e("MicroMsg.SettingsAccountInfoUI", "updateMobile Preference null");
            return;
        }
        String str = (String) g.Ei().DT().get(6, null);
        x.d("MicroMsg.SettingsAccountInfoUI", "mobile :" + str);
        if (str == null || str.length() <= 0) {
            iconSwitchKeyValuePreference.setSummary(getString(i.settings_bind_qq_unbind));
            iconSwitchKeyValuePreference.Ey(0);
            return;
        }
        iconSwitchKeyValuePreference.setSummary(str);
        iconSwitchKeyValuePreference.Ey(1);
    }

    private void btF() {
        boolean z;
        boolean z2 = true;
        ay ayVar = new ay();
        com.tencent.mm.sdk.b.a.sFg.m(ayVar);
        if (ayVar.bIt.bIu && ayVar.bIt.bIv && ayVar.bIt.bIw) {
            z = true;
        } else {
            z = false;
        }
        x.i("MicroMsg.SettingsAccountInfoUI", "check is support soter, isSupportSoter: %b, isSupportFP: %b, isSystemHasFPEnrolled: %b", new Object[]{Boolean.valueOf(ayVar.bIt.bIu), Boolean.valueOf(ayVar.bIt.bIv), Boolean.valueOf(ayVar.bIt.bIw)});
        f fVar = this.eOE;
        String str = "settings_fingerprint_title";
        if (z) {
            z2 = false;
        }
        fVar.bw(str, z2);
    }
}

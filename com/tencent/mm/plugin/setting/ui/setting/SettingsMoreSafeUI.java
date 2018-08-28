package com.tencent.mm.plugin.setting.ui.setting;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.SparseIntArray;
import com.tencent.map.lib.gl.model.GLIcon;
import com.tencent.mm.a.o;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.g.a.ja;
import com.tencent.mm.g.a.y;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.account.model.d;
import com.tencent.mm.plugin.account.ui.FacebookAuthUI;
import com.tencent.mm.plugin.setting.a.i;
import com.tencent.mm.plugin.setting.a.k;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.s.c;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.IconPreference;
import com.tencent.mm.ui.base.preference.IconSwitchKeyValuePreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import junit.framework.Assert;

public class SettingsMoreSafeUI extends MMPreference implements e, b {
    private ProgressDialog eHw;
    private f eOE;
    private SparseIntArray mRB = new SparseIntArray();
    private String mTa = null;
    private String mTb;

    public SettingsMoreSafeUI() {
        this.mRB.put(0, i.settings_confirm_email_success_tip);
        this.mRB.put(-82, i.setting_unbind_qq_err_one_left);
        this.mRB.put(-83, i.setting_unbind_qq_err_has_unbind);
        this.mRB.put(-84, i.setting_unbind_qq_err_hasbinded);
        this.mRB.put(-85, i.setting_unbind_email_err_bindedbyother);
        this.mRB.put(-86, i.setting_unbind_qq_err_qmail);
    }

    public final int Ys() {
        return k.settings_pref_more_safe;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
        g.DF().a(GLIcon.TOP, this);
    }

    protected void onDestroy() {
        super.onDestroy();
        g.DF().b(GLIcon.TOP, this);
    }

    protected final void initView() {
        setMMTitle(i.settings_more_safe);
        this.eOE = this.tCL;
        if (((Integer) g.Ei().DT().get(9, Integer.valueOf(0))).intValue() != 0) {
            x.i("MicroMsg.SettingsMoreSafeUI", "summerqq BindQQSwitch bindqq");
        } else if (bi.getInt(com.tencent.mm.k.g.AT().getValue("BindQQSwitch"), 1) != 1) {
            this.eOE.bw("settings_uin", true);
            x.i("MicroMsg.SettingsMoreSafeUI", "summerqq BindQQSwitch off");
        }
        this.mTa = com.tencent.mm.k.g.AT().getValue("CloseAcctUrl");
        setBackBtn(new 1(this));
    }

    protected void onResume() {
        btO();
        btL();
        btN();
        String value = com.tencent.mm.k.g.AT().getValue("ShowExportUserDataEntry");
        if (bi.oW(value)) {
            this.mTb = "";
            this.eOE.bw("settings_dump_personal_data", true);
        } else {
            this.mTb = value;
        }
        btM();
        this.eOE.c(this.eOE.ZZ("settings_about_domainmail"));
        if (bi.oW(this.mTa)) {
            this.eOE.c(this.eOE.ZZ("settings_delete_account"));
        }
        super.onResume();
    }

    protected void onPause() {
        super.onPause();
    }

    public final boolean a(f fVar, Preference preference) {
        boolean z = false;
        String str = preference.mKey;
        x.i("MicroMsg.SettingsMoreSafeUI", str + " item has been clicked!");
        if (bi.oW(str)) {
            return false;
        }
        Intent intent;
        if (str.equals("settings_facebook")) {
            L(FacebookAuthUI.class);
            return false;
        } else if (str.equals("settings_email_addr")) {
            Integer num = (Integer) g.Ei().DT().get(7, null);
            if (!(num == null || (num.intValue() & 2) == 0)) {
                z = true;
            }
            str = (String) g.Ei().DT().get(5, null);
            if (z || !bi.oW(str)) {
                startActivity(new Intent(this.mController.tml, SettingsModifyEmailAddrUI.class));
            } else {
                if (this.eHw != null) {
                    x.w("MicroMsg.SettingsMoreSafeUI", "do get email input, but tips dialog has not dismissed");
                    this.eHw.dismiss();
                    this.eHw = null;
                }
                h.a(this.mController.tml, getString(i.settings_modify_email_addr), bi.aG(com.tencent.mm.platformtools.x.cg(this.mController.tml), ""), getString(i.settings_modify_email_addr_warning), 50, new h.b() {
                    public final boolean p(CharSequence charSequence) {
                        if (bi.WF(charSequence.toString())) {
                            com.tencent.mm.plugin.setting.b.ezo.vl();
                            d dVar = new d(d.eNX, charSequence.toString());
                            g.DF().a(dVar, 0);
                            SettingsMoreSafeUI settingsMoreSafeUI = SettingsMoreSafeUI.this;
                            ActionBarActivity actionBarActivity = SettingsMoreSafeUI.this.mController.tml;
                            SettingsMoreSafeUI.this.getString(i.app_tip);
                            settingsMoreSafeUI.eHw = h.a(actionBarActivity, SettingsMoreSafeUI.this.getString(i.settings_binding), true, new 1(this, dVar));
                            return true;
                        }
                        h.bA(SettingsMoreSafeUI.this.mController.tml, SettingsMoreSafeUI.this.getString(i.verify_email_err_tip));
                        return false;
                    }
                });
            }
            return true;
        } else if (str.equals("settings_bind_qq")) {
            com.tencent.mm.plugin.setting.b.ezn.h(new Intent(), this);
            return true;
        } else if (str.equals("settings_phone_security")) {
            Intent intent2 = new Intent();
            int i = c.Cp().a(a.sZC) ? 1 : 0;
            c.Cp().b(a.sZC, false);
            ((IconPreference) preference).Et(8);
            int intValue = ((Integer) g.Ei().DT().get(a.sZE, Integer.valueOf(0))).intValue();
            com.tencent.mm.plugin.report.service.h.mEJ.h(10939, new Object[]{Integer.valueOf(intValue)});
            if (bi.br(this, "com.tencent.server.back.BackEngine")) {
                str = getString(i.qqpimsecure_jump_url, new Object[]{Integer.valueOf(intValue), Integer.valueOf(1), Integer.valueOf(i)});
            } else {
                str = getString(i.qqpimsecure_jump_url, new Object[]{Integer.valueOf(intValue), Integer.valueOf(0), Integer.valueOf(i)});
            }
            intent2.putExtra("rawUrl", str);
            intent2.putExtra("show_bottom", false);
            intent2.putExtra("showShare", false);
            com.tencent.mm.bg.d.b(this.mController.tml, "webview", ".ui.tools.WebViewUI", intent2);
            return false;
        } else if (str.equals("settings_delete_account")) {
            intent = new Intent();
            if (bi.oW(this.mTa)) {
                return false;
            }
            intent.putExtra("rawUrl", this.mTa + "&lang=" + w.fD(this.mController.tml));
            intent.putExtra("showShare", true);
            intent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.qWa);
            com.tencent.mm.bg.d.b(this.mController.tml, "webview", ".ui.tools.WebViewUI", intent, 2);
            return false;
        } else if (!str.equals("settings_dump_personal_data")) {
            return false;
        } else {
            intent = new Intent();
            if (bi.oW(this.mTb)) {
                return false;
            }
            intent.putExtra("rawUrl", this.mTb);
            intent.putExtra("showShare", false);
            intent.putExtra("needRedirect", false);
            intent.putExtra("neverGetA8Key", true);
            intent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.qWa);
            com.tencent.mm.bg.d.b(this.mController.tml, "webview", ".ui.tools.WebViewUI", intent);
            return false;
        }
    }

    private void btL() {
        Preference ZZ = this.eOE.ZZ("settings_email_addr");
        Assert.assertNotNull(ZZ);
        String str = (String) g.Ei().DT().get(5, null);
        Integer num = (Integer) g.Ei().DT().get(7, null);
        if (num != null && (num.intValue() & 2) != 0) {
            ZZ.setSummary(i.settings_email_addr_verified);
        } else if (str != null) {
            ZZ.setSummary(i.settings_email_addr_not_verified);
        } else {
            ZZ.setSummary(i.setting_unbind);
        }
    }

    public final void a(int i, m mVar, Object obj) {
        btO();
        btL();
        btN();
        btM();
    }

    private void btM() {
        IconSwitchKeyValuePreference iconSwitchKeyValuePreference = (IconSwitchKeyValuePreference) this.eOE.ZZ("settings_phone_security");
        if (iconSwitchKeyValuePreference == null) {
            x.e("MicroMsg.SettingsMoreSafeUI", "phone_security preference is null");
        } else if (com.tencent.mm.sdk.platformtools.e.chv()) {
            this.eOE.bw("settings_phone_security", true);
        } else if (c.Cp().a(a.sZC)) {
            iconSwitchKeyValuePreference.Et(0);
        } else {
            iconSwitchKeyValuePreference.Et(8);
        }
    }

    private void btN() {
        Preference ZZ = this.eOE.ZZ("settings_facebook");
        if (ZZ == null) {
            x.e("MicroMsg.SettingsMoreSafeUI", "updateFacebook Preference null");
        } else if (!q.He()) {
            this.eOE.c(ZZ);
        } else if (q.Hg()) {
            ZZ.setSummary((String) g.Ei().DT().get(65826, null));
        } else {
            ZZ.setSummary(getString(i.settings_bind_qq_unbind));
        }
    }

    private void btO() {
        Preference ZZ = this.eOE.ZZ("settings_bind_qq");
        if (ZZ == null) {
            x.e("MicroMsg.SettingsMoreSafeUI", "updateUin Preference null");
            return;
        }
        int intValue = ((Integer) g.Ei().DT().get(9, Integer.valueOf(0))).intValue();
        if (intValue == 0) {
            x.i("MicroMsg.SettingsMoreSafeUI", "updateUin 0 Preference");
            if (bi.getInt(com.tencent.mm.k.g.AT().getValue("BindQQSwitch"), 1) != 1) {
                this.eOE.bw("settings_uin", true);
                return;
            } else {
                ZZ.setSummary(i.settings_bind_qq_unbind);
                return;
            }
        }
        ZZ.setSummary(new o(intValue));
    }

    public final void a(int i, int i2, String str, l lVar) {
        x.d("MicroMsg.SettingsMoreSafeUI", "onSceneEnd " + i + " errCode " + i2 + " errMsg " + str + "  " + lVar.getType());
        if (this.eHw != null) {
            this.eHw.dismiss();
            this.eHw = null;
        }
        if (lVar.getType() != GLIcon.TOP) {
            return;
        }
        if ((i == 0 && i2 == 0) || !com.tencent.mm.plugin.setting.b.ezo.a((Context) this, i, i2, str)) {
            int i3 = this.mRB.get(i2);
            String string = getString(i.settings_confirm_email_fail_tip, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
            if (i3 != 0) {
                try {
                    string = getString(i3);
                } catch (Throwable e) {
                    x.e("MicroMsg.SettingsMoreSafeUI", "try get string by id %d, fail:%s", new Object[]{Integer.valueOf(i3), e.getMessage()});
                    x.printErrStackTrace("MicroMsg.SettingsMoreSafeUI", e, "", new Object[0]);
                }
            }
            h.bA(this.mController.tml, string);
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 2) {
            switch (i2) {
                case -1:
                    if (!(g.DF() == null || g.DF().dJs == null)) {
                        g.DF().dJs.bD(false);
                    }
                    com.tencent.mm.plugin.setting.b.ezo.vr();
                    g.Ei().DT().b(this);
                    ja jaVar = new ja();
                    jaVar.bSG.status = 0;
                    jaVar.bSG.aAk = 3;
                    com.tencent.mm.sdk.b.a.sFg.m(jaVar);
                    y yVar = new y();
                    yVar.bHg.bHh = true;
                    com.tencent.mm.sdk.b.a.sFg.m(yVar);
                    af.Wq("show_whatsnew");
                    com.tencent.mm.kernel.k.j(this, true);
                    Intent intent2 = new Intent();
                    intent2.addFlags(67108864);
                    intent2.putExtra("Intro_Switch", true);
                    com.tencent.mm.plugin.setting.b.ezn.q(intent2, this.mController.tml);
                    com.tencent.mm.platformtools.x.H(this, null);
                    finish();
                    return;
                default:
                    return;
            }
        }
    }
}

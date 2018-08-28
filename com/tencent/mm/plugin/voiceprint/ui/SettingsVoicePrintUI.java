package com.tencent.mm.plugin.voiceprint.ui;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import com.tencent.mm.R;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.model.at;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.appbrand.s$l;
import com.tencent.mm.plugin.voiceprint.model.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;

public class SettingsVoicePrintUI extends MMPreference implements e {
    private ProgressDialog eHw = null;
    private f eOE;
    private boolean iSc = false;
    private View ilW;
    private VoiceHeaderPreference oFZ;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setMMTitle(R.l.settings_voiceprint);
        au.DF().a(615, this);
        this.ilW = findViewById(R.h.mm_preference_list_content);
        initView();
        this.ilW.setBackgroundResource(R.e.white);
        au.HU();
        c.DT().a(a.sPp, Boolean.valueOf(false));
        au.HU();
        c.DT().a(a.sPq, Boolean.valueOf(false));
        au.HU();
        c.DT().a(a.sPr, Boolean.valueOf(false));
        au.HU();
        c.DT().a(a.sPs, Boolean.valueOf(false));
        x.i("MicroMsg.VoiceSettingsUI", "unset all voiceprint config");
    }

    public void onResume() {
        super.onResume();
        if (this.iSc) {
            this.iSc = false;
            if (this.eHw != null && this.eHw.isShowing()) {
                this.eHw.dismiss();
            }
            ActionBarActivity actionBarActivity = this.mController.tml;
            getString(R.l.app_tip);
            this.eHw = h.a(actionBarActivity, getString(R.l.app_waiting), true, new 1(this));
            x.d("MicroMsg.VoiceSettingsUI", "resume after create voiceprint, get switch status");
            au.DF().a(new i(1), 0);
        }
    }

    public void onDestroy() {
        super.onDestroy();
        au.DF().b(615, this);
        if (this.eHw != null) {
            this.eHw.dismiss();
        }
    }

    public final void initView() {
        au.HU();
        int p = bi.p(c.DT().get(40, Integer.valueOf(0)), 0);
        x.i("MicroMsg.VoiceSettingsUI", "plugSwitch " + p + " " + (p & 131072));
        this.eOE = this.tCL;
        this.oFZ = (VoiceHeaderPreference) this.eOE.ZZ("settings_voiceprint_header");
        ((CheckBoxPreference) this.eOE.ZZ("settings_voiceprint_title")).lM(true);
        this.eOE.notifyDataSetChanged();
        if (this.eHw != null && this.eHw.isShowing()) {
            this.eHw.dismiss();
        }
        ActionBarActivity actionBarActivity = this.mController.tml;
        getString(R.l.app_tip);
        this.eHw = h.a(actionBarActivity, getString(R.l.app_waiting), true, new 2(this));
        au.DF().a(new i(0), 0);
        this.eOE.bw("settings_voiceprint_unlock", true);
        this.eOE.bw("settings_voiceprint_reset", true);
        this.eOE.bw("settings_voiceprint_create", true);
        setBackBtn(new 3(this));
    }

    public final int Ys() {
        return R.o.settings_voice_print;
    }

    public final boolean a(f fVar, Preference preference) {
        String str = preference.mKey;
        Intent intent = new Intent();
        if (str.equals("settings_voiceprint_title")) {
            CheckBoxPreference checkBoxPreference = (CheckBoxPreference) fVar.ZZ("settings_voiceprint_title");
            x.d("MicroMsg.VoiceSettingsUI", "checkPref.isChecked() " + checkBoxPreference.isChecked());
            if (this.eHw != null && this.eHw.isShowing()) {
                this.eHw.dismiss();
            }
            ActionBarActivity actionBarActivity = this.mController.tml;
            getString(R.l.app_tip);
            this.eHw = h.a(actionBarActivity, getString(R.l.app_waiting), true, new 4(this));
            if (checkBoxPreference.isChecked()) {
                au.DF().a(new i(1), 0);
            } else {
                au.DF().a(new i(2), 0);
            }
            return true;
        } else if (str.equals("settings_voiceprint_unlock")) {
            intent.setClass(this, VoiceUnLockUI.class);
            intent.putExtra("kscene_type", 73);
            startActivity(intent);
            return true;
        } else if (!str.equals("settings_voiceprint_reset")) {
            return false;
        } else {
            intent.setClass(this, VoiceCreateUI.class);
            intent.putExtra("KvoicePrintReset", true);
            intent.putExtra("kscene_type", 73);
            startActivityForResult(intent, 1);
            return true;
        }
    }

    public final void a(int i, int i2, String str, l lVar) {
        x.d("MicroMsg.VoiceSettingsUI", "onSceneEnd, errType:%d, errCode:%d, sceneType:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(lVar.getType())});
        if (i == 0 || i2 == 0) {
            if (lVar.getType() == 615) {
                i iVar = (i) lVar;
                if (iVar.mStatus == 1) {
                    int i3;
                    x.d("MicroMsg.VoiceSettingsUI", "voiceprint exist");
                    this.eOE.bw("settings_voiceprint_unlock", false);
                    this.eOE.notifyDataSetChanged();
                    int GL = q.GL();
                    CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.eOE.ZZ("settings_voiceprint_title");
                    x.d("MicroMsg.VoiceSettingsUI", "opScene.getSwitch:%d", new Object[]{Integer.valueOf(iVar.oFh)});
                    if (iVar.oFh > 0) {
                        x.d("MicroMsg.VoiceSettingsUI", "voiceprint open");
                        checkBoxPreference.lM(true);
                        this.eOE.bw("settings_voiceprint_reset", false);
                        this.eOE.bw("settings_voiceprint_unlock", false);
                        i3 = 131072 | GL;
                        this.oFZ.cH(getString(R.l.voice_start_open), "");
                    } else {
                        x.d("MicroMsg.VoiceSettingsUI", "voiceprint close");
                        checkBoxPreference.lM(false);
                        this.eOE.bw("settings_voiceprint_reset", true);
                        this.eOE.bw("settings_voiceprint_unlock", true);
                        i3 = -131073 & GL;
                        this.oFZ.cH(getString(R.l.voice_start_close), "");
                    }
                    x.i("MicroMsg.VoiceSettingsUI", "scene end plugSwitch %d", new Object[]{Integer.valueOf(i3)});
                    at.dBv.T("last_login_use_voice", String.valueOf(i3));
                    au.HU();
                    c.DT().set(40, Integer.valueOf(i3));
                    this.eOE.bw("settings_voiceprint_create", true);
                    this.eOE.bw("settings_voiceprint_title", false);
                    this.oFZ.a(null);
                    this.eOE.notifyDataSetChanged();
                } else {
                    x.d("MicroMsg.VoiceSettingsUI", "voiceprint not exist");
                    com.tencent.mm.plugin.report.service.h.mEJ.h(11390, new Object[]{Integer.valueOf(2)});
                    this.eOE.bw("settings_voiceprint_unlock", true);
                    this.eOE.bw("settings_voiceprint_reset", true);
                    this.eOE.bw("settings_voiceprint_create", true);
                    this.eOE.bw("settings_voiceprint_title", true);
                    this.oFZ.cH(getString(R.l.voice_start_title), getString(R.l.voice_start_tip));
                    this.oFZ.a(new 5(this));
                    this.eOE.notifyDataSetChanged();
                }
            }
            if (this.eHw != null) {
                this.eHw.dismiss();
                return;
            }
            return;
        }
        this.eOE.bw("settings_voiceprint_unlock", true);
        this.eOE.bw("settings_voiceprint_reset", true);
        this.eOE.bw("settings_voiceprint_create", true);
        ((CheckBoxPreference) this.eOE.ZZ("settings_voiceprint_title")).lM(false);
        this.oFZ.cH(getString(R.l.voice_start_close), "");
        this.eOE.notifyDataSetChanged();
        if (this.eHw != null) {
            this.eHw.dismiss();
        }
    }

    private void bJh() {
        com.tencent.mm.plugin.report.service.h.mEJ.h(11390, new Object[]{Integer.valueOf(3)});
        Intent intent = new Intent();
        intent.setClass(this, VoiceCreateUI.class);
        intent.putExtra("kscene_type", 71);
        intent.putExtra("createVoicePrint", true);
        startActivityForResult(intent, 1);
        this.iSc = false;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 1 && intent != null) {
            this.iSc = intent.getBooleanExtra("KIsCreateSuccess", false);
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        x.i("MicroMsg.VoiceSettingsUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId())});
        switch (i) {
            case s$l.AppCompatTheme_panelMenuListTheme /*80*/:
                if (iArr[0] == 0) {
                    bJh();
                    return;
                } else {
                    h.a(this, getString(R.l.permission_microphone_request_again_msg), getString(R.l.permission_tips_title), getString(R.l.jump_to_settings), getString(R.l.cancel), false, new 6(this), new 7(this));
                    return;
                }
            default:
                return;
        }
    }
}

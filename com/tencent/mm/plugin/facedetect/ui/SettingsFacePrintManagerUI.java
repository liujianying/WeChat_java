package com.tencent.mm.plugin.facedetect.ui;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.at;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.facedetect.a;
import com.tencent.mm.plugin.facedetect.a$b;
import com.tencent.mm.plugin.facedetect.a.i;
import com.tencent.mm.plugin.facedetect.model.o;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;

public class SettingsFacePrintManagerUI extends MMPreference implements e {
    private ProgressDialog eHw = null;
    private f eOE;
    private FaceHeaderPreference iSb;
    private boolean iSc = false;
    private View ilW;

    static /* synthetic */ void a(SettingsFacePrintManagerUI settingsFacePrintManagerUI) {
        h.mEJ.h(11390, new Object[]{Integer.valueOf(3)});
        Intent intent = new Intent();
        intent.setClass(settingsFacePrintManagerUI, FaceDetectUI.class);
        intent.putExtra("k_need_signature", true);
        intent.putExtra("k_user_name", q.GI());
        intent.putExtra("k_purpose", 1);
        settingsFacePrintManagerUI.startActivityForResult(intent, 1);
        settingsFacePrintManagerUI.iSc = false;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setMMTitle(a.h.face_lock_title);
        g.DF().a(938, this);
        this.ilW = findViewById(a.e.mm_preference_list_content);
        initView();
        this.ilW.setBackgroundResource(a$b.white);
        o.q(this);
    }

    public void onResume() {
        super.onResume();
        if (this.iSc) {
            this.iSc = false;
            if (this.eHw != null && this.eHw.isShowing()) {
                this.eHw.dismiss();
            }
            ActionBarActivity actionBarActivity = this.mController.tml;
            getString(a.h.app_tip);
            this.eHw = com.tencent.mm.ui.base.h.a(actionBarActivity, getString(a.h.app_waiting), true, new 1(this));
            x.d("MicroMsg.FaceSettingsManagerUI", "hy: resume after create face, get switch status");
            g.DF().a(new com.tencent.mm.plugin.facedetect.b.q(1), 0);
        }
    }

    public void onDestroy() {
        super.onDestroy();
        g.DF().b(938, this);
        if (this.eHw != null) {
            this.eHw.dismiss();
        }
    }

    public final void initView() {
        int p = bi.p(g.Ei().DT().get(40, Integer.valueOf(0)), 0);
        x.i("MicroMsg.FaceSettingsManagerUI", "plugSwitch " + p + " " + (p & 4194304));
        this.eOE = this.tCL;
        this.iSb = (FaceHeaderPreference) this.eOE.ZZ("settings_faceprint_header");
        ((CheckBoxPreference) this.eOE.ZZ("settings_faceprint_title")).lM(true);
        this.eOE.notifyDataSetChanged();
        if (this.eHw != null && this.eHw.isShowing()) {
            this.eHw.dismiss();
        }
        ActionBarActivity actionBarActivity = this.mController.tml;
        getString(a.h.app_tip);
        this.eHw = com.tencent.mm.ui.base.h.a(actionBarActivity, getString(a.h.app_waiting), true, new 2(this));
        g.DF().a(new com.tencent.mm.plugin.facedetect.b.q(3), 0);
        this.eOE.bw("settings_faceprint_create", true);
        this.eOE.bw("settings_faceeprint_reset", true);
        this.eOE.bw("settings_faceprint_unlock", true);
        setBackBtn(new 3(this));
    }

    public final int Ys() {
        return i.settings_face_print;
    }

    public final boolean a(f fVar, Preference preference) {
        String str = preference.mKey;
        Intent intent = new Intent();
        if (str.equals("settings_faceprint_title")) {
            CheckBoxPreference checkBoxPreference = (CheckBoxPreference) fVar.ZZ("settings_faceprint_title");
            x.d("MicroMsg.FaceSettingsManagerUI", "hy: checkPref.isChecked() " + checkBoxPreference.isChecked());
            if (this.eHw != null && this.eHw.isShowing()) {
                this.eHw.dismiss();
            }
            ActionBarActivity actionBarActivity = this.mController.tml;
            getString(a.h.app_tip);
            this.eHw = com.tencent.mm.ui.base.h.a(actionBarActivity, getString(a.h.app_waiting), true, new 4(this));
            if (checkBoxPreference.isChecked()) {
                g.DF().a(new com.tencent.mm.plugin.facedetect.b.q(1), 0);
            } else {
                g.DF().a(new com.tencent.mm.plugin.facedetect.b.q(2), 0);
            }
            return true;
        } else if (str.equals("settings_faceprint_unlock")) {
            intent.setClass(this, FaceDetectUI.class);
            intent.putExtra("k_need_signature", true);
            intent.putExtra("k_user_name", q.GI());
            intent.putExtra("k_purpose", 2);
            startActivity(intent);
            return true;
        } else if (!str.equals("settings_faceeprint_reset")) {
            return false;
        } else {
            intent.setClass(this, FaceDetectUI.class);
            intent.putExtra("k_need_signature", true);
            intent.putExtra("k_user_name", q.GI());
            intent.putExtra("k_purpose", 1);
            startActivityForResult(intent, 1);
            return true;
        }
    }

    public final void a(int i, int i2, String str, l lVar) {
        x.d("MicroMsg.FaceSettingsManagerUI", "hy: onSceneEnd, errType:%d, errCode:%d, sceneType:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(lVar.getType())});
        if (i == 0 || i2 == 0) {
            if (lVar.getType() == 938) {
                com.tencent.mm.plugin.facedetect.b.q qVar = (com.tencent.mm.plugin.facedetect.b.q) lVar;
                if (qVar.iMJ) {
                    int i3;
                    x.d("MicroMsg.FaceSettingsManagerUI", "faceprint exist");
                    this.eOE.bw("settings_faceprint_unlock", false);
                    this.eOE.notifyDataSetChanged();
                    int GL = q.GL();
                    CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.eOE.ZZ("settings_faceprint_title");
                    x.d("MicroMsg.FaceSettingsManagerUI", "opScene.isOpenSwitch:%b", new Object[]{Boolean.valueOf(qVar.iMK)});
                    if (qVar.iMK) {
                        x.d("MicroMsg.FaceSettingsManagerUI", "hy: faceprint open");
                        checkBoxPreference.lM(true);
                        this.eOE.bw("settings_faceeprint_reset", false);
                        this.eOE.bw("settings_faceprint_unlock", false);
                        i3 = 4194304 | GL;
                        this.iSb.cH(getString(a.h.settings_faceprint_on), "");
                    } else {
                        x.d("MicroMsg.FaceSettingsManagerUI", "hy: faceprint close");
                        checkBoxPreference.lM(false);
                        this.eOE.bw("settings_faceeprint_reset", true);
                        this.eOE.bw("settings_faceprint_unlock", true);
                        i3 = -4194305 & GL;
                        this.iSb.cH(getString(a.h.settings_faceprint_off), "");
                    }
                    x.i("MicroMsg.FaceSettingsManagerUI", "scene end plugSwitch %d", new Object[]{Integer.valueOf(i3)});
                    at.dBv.T("last_login_use_voice", String.valueOf(i3));
                    g.Ei().DT().set(40, Integer.valueOf(i3));
                    this.eOE.bw("settings_faceprint_create", true);
                    this.eOE.bw("settings_faceprint_title", false);
                    this.iSb.a(null);
                    this.eOE.notifyDataSetChanged();
                } else {
                    x.d("MicroMsg.FaceSettingsManagerUI", "faceprint not exist");
                    h.mEJ.h(11390, new Object[]{Integer.valueOf(2)});
                    this.eOE.bw("settings_faceprint_create", true);
                    this.eOE.bw("settings_faceprint_title", true);
                    this.eOE.bw("settings_faceprint_unlock", true);
                    this.eOE.bw("settings_faceeprint_reset", true);
                    this.iSb.setTitle(getString(a.h.settings_face_title));
                    this.iSb.a(new 5(this));
                    this.eOE.notifyDataSetChanged();
                }
            }
            if (this.eHw != null) {
                this.eHw.dismiss();
                return;
            }
            return;
        }
        this.eOE.bw("settings_faceprint_create", true);
        this.eOE.bw("settings_faceprint_unlock", true);
        this.eOE.bw("settings_faceeprint_reset", true);
        ((CheckBoxPreference) this.eOE.ZZ("settings_faceprint_title")).lM(false);
        this.iSb.setTitle(getString(a.h.settings_faceprint_off));
        this.eOE.notifyDataSetChanged();
        if (this.eHw != null) {
            this.eHw.dismiss();
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 1) {
            if (intent != null && intent.getIntExtra("err_code", 10) == 0) {
                this.iSc = true;
            }
            x.i("MicroMsg.FaceSettingsManagerUI", "hy: is reg ok: %b", new Object[]{Boolean.valueOf(this.iSc)});
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (iArr != null && iArr.length > 1) {
            x.d("MicroMsg.FaceSettingsManagerUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults0[%d] grantResults1[%d] tid[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(iArr[0]), Integer.valueOf(iArr[1]), Long.valueOf(Thread.currentThread().getId())});
            switch (i) {
                case 23:
                    if (iArr[0] != 0 || iArr[1] != 0) {
                        x.w("MicroMsg.FaceSettingsManagerUI", "hy: permission not granted");
                        finish();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }
}

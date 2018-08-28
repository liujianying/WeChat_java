package com.tencent.mm.plugin.facedetect.ui;

import android.os.Bundle;
import android.view.View;
import com.tencent.mm.a.g;
import com.tencent.mm.model.at;
import com.tencent.mm.plugin.facedetect.a$h;
import com.tencent.mm.plugin.facedetect.a$i;
import com.tencent.mm.plugin.facedetect.a.b;
import com.tencent.mm.plugin.facedetect.a.e;
import com.tencent.mm.plugin.facedetect.model.o;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.base.s;
import java.io.File;

public class FaceDebugUI extends MMPreference {
    private f eOE;
    private CheckBoxPreference iPM = null;
    private CheckBoxPreference iPN = null;
    private CheckBoxPreference iPO = null;
    private CheckBoxPreference iPP = null;
    private CheckBoxPreference iPQ = null;
    private CheckBoxPreference iPR = null;
    private View ilW;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.ilW = findViewById(e.mm_preference_list_content);
        this.ilW.setBackgroundResource(b.white);
        aKm();
        setMMTitle(getString(a$h.face_debug_name));
        setBackBtn(new 1(this));
    }

    private void aKm() {
        this.eOE = this.tCL;
        this.iPM = (CheckBoxPreference) this.eOE.ZZ("face_debug_switch");
        this.iPN = (CheckBoxPreference) this.eOE.ZZ("face_debug_save_pic_switch");
        this.iPO = (CheckBoxPreference) this.eOE.ZZ("face_debug_save_final_switch");
        this.iPP = (CheckBoxPreference) this.eOE.ZZ("face_debug_save_lipreading_switch");
        this.iPQ = (CheckBoxPreference) this.eOE.ZZ("face_debug_save_voice_switch");
        this.iPR = (CheckBoxPreference) this.eOE.ZZ("face_debug_force_upload_video");
        this.eOE.notifyDataSetChanged();
    }

    protected void onResume() {
        super.onResume();
        aKn();
    }

    protected void onStop() {
        super.onStop();
    }

    private void aKn() {
        boolean aJE = com.tencent.mm.plugin.facedetect.model.e.aJE();
        boolean aJG = com.tencent.mm.plugin.facedetect.model.e.aJG();
        boolean aJH = com.tencent.mm.plugin.facedetect.model.e.aJH();
        boolean aJI = com.tencent.mm.plugin.facedetect.model.e.aJI();
        boolean aJJ = com.tencent.mm.plugin.facedetect.model.e.aJJ();
        boolean aJF = com.tencent.mm.plugin.facedetect.model.e.aJF();
        if (aJE) {
            this.iPM.lM(true);
            this.eOE.bw("face_debug_save_pic_switch", false);
            this.eOE.bw("face_debug_save_final_switch", false);
            this.eOE.bw("face_debug_save_lipreading_switch", false);
            this.eOE.bw("face_debug_save_voice_switch", false);
            this.eOE.bw("face_debug_force_upload_video", false);
            this.iPN.lM(aJG);
            this.iPO.lM(aJH);
            this.iPP.lM(aJI);
            this.iPQ.lM(aJJ);
            this.iPR.lM(aJF);
        } else {
            this.iPM.lM(false);
            this.eOE.bw("face_debug_save_pic_switch", true);
            this.eOE.bw("face_debug_save_final_switch", true);
            this.eOE.bw("face_debug_save_lipreading_switch", true);
            this.eOE.bw("face_debug_save_voice_switch", true);
            this.eOE.bw("face_debug_force_upload_video", true);
        }
        this.eOE.notifyDataSetChanged();
    }

    public final int Ys() {
        return a$i.face_debug_pref;
    }

    public final boolean a(f fVar, Preference preference) {
        aKm();
        File file;
        if ("face_debug_switch".equals(preference.mKey)) {
            com.tencent.mm.plugin.facedetect.model.e.eD(this.iPM.isChecked());
            aKn();
            return true;
        } else if ("face_debug_save_pic_switch".equals(preference.mKey)) {
            com.tencent.mm.plugin.facedetect.model.e.eE(this.iPN.isChecked());
            aKn();
            return true;
        } else if ("face_debug_save_final_switch".equals(preference.mKey)) {
            com.tencent.mm.plugin.facedetect.model.e.eF(this.iPO.isChecked());
            aKn();
            return true;
        } else if ("face_debug_save_lipreading_switch".equals(preference.mKey)) {
            com.tencent.mm.plugin.facedetect.model.e.eG(this.iPP.isChecked());
            aKn();
            return true;
        } else if ("face_debug_save_voice_switch".equals(preference.mKey)) {
            com.tencent.mm.plugin.facedetect.model.e.eH(this.iPQ.isChecked());
            aKn();
            return true;
        } else if ("face_debug_force_upload_video".equals(preference.mKey)) {
            com.tencent.mm.plugin.facedetect.model.e.eI(this.iPR.isChecked());
            aKn();
            return true;
        } else if ("face_debug_clear_resource".equals(preference.mKey)) {
            file = new File(o.pA(0));
            if (file.exists()) {
                file.delete();
            }
            File file2 = new File(o.pA(1));
            if (file2.exists()) {
                file2.delete();
            }
            at.dBv.T("LAST_LOGIN_FACE_MODEL_DETECT_VERSION", "-1");
            at.dBv.T("LAST_LOGIN_FACE_MODEL_ALIGNMENT_VERSION", "-1");
            return true;
        } else if (!"face_debug_check_resource".equals(preference.mKey)) {
            return false;
        } else {
            file = new File(o.pA(0));
            File file3 = new File(o.pA(1));
            s.makeText(this.mController.tml, String.format("is detect model exists: %b, is alignment model exists: %b", new Object[]{Boolean.valueOf(file.exists()), Boolean.valueOf(file3.exists())}), 0).show();
            x.i("MicroMsg.FaceDebugUI", "hy: detect bin md5: %s", new Object[]{g.m(file)});
            x.i("MicroMsg.FaceDebugUI", "hy: alignment bin md5: %s", new Object[]{g.m(file3)});
            return true;
        }
    }
}

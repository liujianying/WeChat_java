package com.tencent.mm.plugin.setting.ui.fixtools;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.setting.a.i;
import com.tencent.mm.plugin.setting.a.k;
import com.tencent.mm.plugin.setting.ui.setting.SettingsAboutMMHeaderPreference;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.e;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;

@a(3)
public class FixToolsUI extends MMPreference {
    private f eOE;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.eOE = this.tCL;
        setMMTitle(i.fix_tools);
        SettingsAboutMMHeaderPreference settingsAboutMMHeaderPreference = (SettingsAboutMMHeaderPreference) this.eOE.ZZ("fix_tools_micromsg_header");
        String aj = e.aj(this.mController.tml, d.qVN);
        if (d.qVQ) {
            aj = aj + " " + getString(i.alpha_version_alpha);
        }
        settingsAboutMMHeaderPreference.mQR = aj;
        h.mEJ.a(873, (long) getIntent().getIntExtra("entry_fix_tools", 2), 1, false);
        h.mEJ.a(873, 0, 1, false);
        setBackBtn(new 1(this));
    }

    public final int Ys() {
        return k.fix_tools;
    }

    public final boolean a(f fVar, Preference preference) {
        Intent intent;
        if (preference.mKey.equals("fix_tools_uplog")) {
            if (com.tencent.mm.plugin.setting.model.a.btq().egv) {
                MMWizardActivity.D(this, new Intent(this.mController.tml, FixToolsUpLogUploadingUI.class));
                return true;
            }
            intent = new Intent(this.mController.tml, FixToolsUplogUI.class);
            intent.putExtra("entry_fix_tools_uplog", 9);
            MMWizardActivity.D(this, intent);
            return true;
        } else if (!preference.mKey.equals("fix_tools_db_recover")) {
            return false;
        } else {
            intent = new Intent().setClassName(this.mController.tml, "com.tencent.mm.plugin.dbbackup.DBRecoveryUI");
            intent.putExtra("scene", 3);
            this.mController.tml.startActivity(intent);
            return true;
        }
    }
}

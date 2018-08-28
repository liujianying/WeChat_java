package com.tencent.mm.plugin.setting.ui.setting;

import android.os.Bundle;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.setting.a.i;
import com.tencent.mm.plugin.setting.model.UserAuthItemParcelable;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.base.preference.h;
import java.util.List;

public class SettingsModifyUserAuthUI extends MMPreference implements e {
    private String appId;
    private p eXe;
    private h mSX;
    private int scene;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mSX = this.tCL;
        List<UserAuthItemParcelable> parcelableArrayListExtra = getIntent().getParcelableArrayListExtra("app_auth_items");
        this.appId = getIntent().getStringExtra("app_id");
        this.scene = getIntent().getIntExtra("modify_scene", 1);
        if (!(parcelableArrayListExtra == null || parcelableArrayListExtra.isEmpty())) {
            for (UserAuthItemParcelable userAuthItemParcelable : parcelableArrayListExtra) {
                boolean z;
                CheckBoxPreference checkBoxPreference = new CheckBoxPreference(this);
                checkBoxPreference.setTitle(userAuthItemParcelable.mPl);
                if (userAuthItemParcelable.scope.equals("snsapi_friend")) {
                    checkBoxPreference.setSummary(i.settings_auth_close_friend_tip);
                }
                checkBoxPreference.setKey(userAuthItemParcelable.scope);
                if (userAuthItemParcelable.state == 1) {
                    z = true;
                } else {
                    z = false;
                }
                checkBoxPreference.qpJ = z;
                checkBoxPreference.tDr = false;
                this.mSX.a(checkBoxPreference, -1);
            }
        }
        setMMTitle(getIntent().getStringExtra("app_name"));
        setBackBtn(new 1(this));
    }

    public final void a(int i, int i2, String str, l lVar) {
        boolean z = true;
        x.i("MicroMsg.SettingsModifyUserAuthUI", "errCode %d, errMsg %s", new Object[]{Integer.valueOf(i2), str});
        if (this.eXe != null) {
            this.eXe.dismiss();
        }
        if (i == 0 && i2 == 0) {
            String str2 = ((com.tencent.mm.plugin.setting.model.h) lVar).mOL;
            int i3 = ((com.tencent.mm.plugin.setting.model.h) lVar).mOM;
            if (!bi.oW(str2)) {
                CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.mSX.ZZ(str2);
                if (i3 != 1) {
                    z = false;
                }
                checkBoxPreference.qpJ = z;
                return;
            }
            return;
        }
        com.tencent.mm.ui.base.h.bA(this, str);
    }

    protected void onResume() {
        super.onResume();
        g.DF().a(1144, this);
    }

    protected void onPause() {
        super.onPause();
        g.DF().b(1144, this);
    }

    public final int Ys() {
        return -1;
    }

    public final boolean a(f fVar, Preference preference) {
        int i;
        if (((CheckBoxPreference) preference).isChecked()) {
            i = 1;
        } else {
            i = 2;
        }
        com.tencent.mm.plugin.setting.model.h hVar = new com.tencent.mm.plugin.setting.model.h(this.appId, preference.mKey, i, this.scene);
        g.DF().a(hVar, 0);
        this.eXe = com.tencent.mm.ui.base.h.a(this, getString(i.app_sending), true, new 2(this, hVar));
        return true;
    }
}

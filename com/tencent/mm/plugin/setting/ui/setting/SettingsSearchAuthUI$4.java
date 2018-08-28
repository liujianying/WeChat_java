package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.plugin.setting.model.UserAuthItemParcelable;
import com.tencent.mm.protocal.c.bwy;
import com.tencent.mm.protocal.c.bwz;
import java.util.ArrayList;
import java.util.Arrays;

class SettingsSearchAuthUI$4 implements OnItemClickListener {
    final /* synthetic */ SettingsSearchAuthUI mTJ;

    SettingsSearchAuthUI$4(SettingsSearchAuthUI settingsSearchAuthUI) {
        this.mTJ = settingsSearchAuthUI;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (!SettingsSearchAuthUI.f(this.mTJ)) {
            bwy vN = SettingsSearchAuthUI.g(this.mTJ).vN(i);
            if (vN != null) {
                Intent intent = new Intent(this.mTJ, SettingsModifyUserAuthUI.class);
                UserAuthItemParcelable[] userAuthItemParcelableArr = (UserAuthItemParcelable[]) UserAuthItemParcelable.CREATOR.newArray(vN.stm.size());
                int i2 = 0;
                while (true) {
                    int i3 = i2;
                    if (i3 < vN.stm.size()) {
                        bwz bwz = (bwz) vN.stm.get(i3);
                        UserAuthItemParcelable userAuthItemParcelable = new UserAuthItemParcelable();
                        userAuthItemParcelable.scope = bwz.scope;
                        userAuthItemParcelable.mPl = bwz.mPl;
                        userAuthItemParcelable.state = bwz.state;
                        userAuthItemParcelable.mPm = bwz.mPm;
                        userAuthItemParcelableArr[i3] = userAuthItemParcelable;
                        i2 = i3 + 1;
                    } else {
                        intent.putExtra("app_id", vN.bPS);
                        intent.putExtra("app_name", vN.dxK);
                        intent.putExtra("modify_scene", 2);
                        intent.putParcelableArrayListExtra("app_auth_items", new ArrayList(Arrays.asList(userAuthItemParcelableArr)));
                        this.mTJ.startActivity(intent);
                        return;
                    }
                }
            }
        }
    }
}

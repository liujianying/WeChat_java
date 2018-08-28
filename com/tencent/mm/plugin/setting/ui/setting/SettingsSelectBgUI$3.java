package com.tencent.mm.plugin.setting.ui.setting;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Toast;
import com.tencent.mm.ar.j;
import com.tencent.mm.ar.m;
import com.tencent.mm.ar.n;
import com.tencent.mm.ar.r;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.setting.a.i;
import com.tencent.mm.sdk.platformtools.x;

class SettingsSelectBgUI$3 implements OnItemClickListener {
    final /* synthetic */ SettingsSelectBgUI mTS;

    SettingsSelectBgUI$3(SettingsSelectBgUI settingsSelectBgUI) {
        this.mTS = settingsSelectBgUI;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (i == 0) {
            SettingsSelectBgUI.a(this.mTS, -2);
            SettingsSelectBgUI.b(this.mTS).WT();
            if (!SettingsSelectBgUI.c(this.mTS)) {
                this.mTS.setResult(-1);
                this.mTS.finish();
            }
        } else if (i == 1) {
            SettingsSelectBgUI.a(this.mTS, 0);
            SettingsSelectBgUI.b(this.mTS).WT();
            if (!SettingsSelectBgUI.c(this.mTS)) {
                this.mTS.setResult(-1);
                this.mTS.finish();
            }
        } else if (g.Ei().isSDCardAvailable()) {
            m mVar = (m) adapterView.getItemAtPosition(i - 2);
            if (mVar == null) {
                x.e("MicroMsg.SettingsSelectBgUI", "onItemClick fail, info is null, position = " + i);
                return;
            }
            n Qp;
            switch (mVar.status) {
                case 1:
                case 2:
                    SettingsSelectBgUI.a(this.mTS, mVar.id);
                    if (SettingsSelectBgUI.c(this.mTS)) {
                        mVar.status = 1;
                        Qp = r.Qp();
                        Qp.ii(mVar.bPh);
                        mVar.status = 1;
                        Qp.b(mVar);
                    } else {
                        SettingsSelectBgUI.b(this.mTS).WT();
                    }
                    if (!SettingsSelectBgUI.c(this.mTS)) {
                        this.mTS.setResult(-1);
                        this.mTS.finish();
                        return;
                    }
                    return;
                case 3:
                    if (SettingsSelectBgUI.d(this.mTS) != null && SettingsSelectBgUI.d(this.mTS).ecO == mVar.id) {
                        g.DF().c(SettingsSelectBgUI.d(this.mTS));
                        r.Qp().bm(SettingsSelectBgUI.d(this.mTS).ecO, 1);
                        SettingsSelectBgUI.a(this.mTS, SettingsSelectBgUI.e(this.mTS));
                    }
                    SettingsSelectBgUI.f(mVar.id, SettingsSelectBgUI.e(this.mTS));
                    Qp = r.Qp();
                    mVar.status = 4;
                    Qp.b(mVar);
                    new 1(this, Qp, mVar.id).sendEmptyMessageDelayed(0, 1000);
                    return;
                case 4:
                    r.Qp().bm(mVar.id, 1);
                    return;
                case 5:
                    if (SettingsSelectBgUI.d(this.mTS) == null) {
                        SettingsSelectBgUI.a(this.mTS, new j(mVar.id, 1));
                        g.DF().a(SettingsSelectBgUI.d(this.mTS), 0);
                        return;
                    }
                    SettingsSelectBgUI.e(this.mTS).add(new j(mVar.id, 1));
                    return;
                default:
                    return;
            }
        } else {
            Toast.makeText(this.mTS, i.settings_select_bg_sdcard_fail, 1).show();
        }
    }
}

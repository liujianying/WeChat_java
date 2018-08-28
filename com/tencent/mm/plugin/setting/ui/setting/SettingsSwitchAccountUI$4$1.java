package com.tencent.mm.plugin.setting.ui.setting;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.model.bt;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.setting.ui.setting.SettingsSwitchAccountUI.4;
import com.tencent.mm.plugin.setting.ui.widget.SwitchAccountGridView;
import com.tencent.mm.sdk.platformtools.x;

class SettingsSwitchAccountUI$4$1 implements OnClickListener {
    final /* synthetic */ String mUf;
    final /* synthetic */ 4 mUg;

    SettingsSwitchAccountUI$4$1(4 4, String str) {
        this.mUg = 4;
        this.mUf = str;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        x.i("MicroMsg.SettingsSwitchAccountUI", "delete %s", new Object[]{this.mUf});
        this.mUg.mUe.mUd = true;
        bt.dDs.iL(this.mUf);
        this.mUg.mUe.mPV.remove(this.mUf);
        SwitchAccountGridView d = this.mUg.mUe.mPR;
        String str = this.mUf;
        if (d.mWc.contains(str)) {
            int indexOf = d.mWc.indexOf(str);
            d.mWc.remove(str);
            d.mWd.remove(indexOf);
            d.mWe.remove(indexOf);
        }
        this.mUg.mUe.mPR.bum();
        this.mUg.mUe.btV();
        if (this.mUg.mUe.scene != 0) {
            return;
        }
        if (bt.dDs.IH().size() > 0) {
            h.mEJ.h(14978, new Object[]{Integer.valueOf(1), Integer.valueOf(4), bt.dDs.II()});
            return;
        }
        h.mEJ.h(14978, new Object[]{Integer.valueOf(0), Integer.valueOf(4), bt.dDs.II()});
    }
}

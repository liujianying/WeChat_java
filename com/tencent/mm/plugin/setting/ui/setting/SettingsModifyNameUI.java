package com.tencent.mm.plugin.setting.ui.setting;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.messenger.foundation.a.a.h.b;
import com.tencent.mm.plugin.setting.a.f;
import com.tencent.mm.plugin.setting.a.g;
import com.tencent.mm.plugin.setting.a.i;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.tools.a.c.a;
import com.tencent.mm.ui.widget.MMEditText;

public class SettingsModifyNameUI extends MMActivity implements a {
    private p eXe = null;
    private boolean hLL = false;
    private c hLO = new 1(this);
    private MMEditText hMU;
    private b mPN;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.tencent.mm.sdk.b.a.sFg.b(this.hLO);
        initView();
    }

    protected void onDestroy() {
        com.tencent.mm.sdk.b.a.sFg.c(this.hLO);
        super.onDestroy();
    }

    protected final int getLayoutId() {
        return g.settings_modify_name;
    }

    protected final void initView() {
        setMMTitle(i.settings_modify_name);
        this.hMU = (MMEditText) findViewById(f.settings_modify_name_new_name_et);
        this.hMU.setText(j.a(this, (String) com.tencent.mm.kernel.g.Ei().DT().get(4, null), this.hMU.getTextSize()));
        this.hMU.setSelection(this.hMU.getText().length());
        this.hMU.addTextChangedListener(new 2(this));
        com.tencent.mm.ui.tools.a.c fj = com.tencent.mm.ui.tools.a.c.d(this.hMU).fj(1, 32);
        fj.uCR = false;
        fj.a(null);
        a(0, getString(i.app_save), new 3(this), s.b.tmX);
        enableOptionMenu(false);
        setBackBtn(new 4(this));
    }

    public final void pO(String str) {
        x.i("MiroMsg.SettingsModifyNameUI", "Set New NickName : " + str);
        this.hLL = true;
        ActionBarActivity actionBarActivity = this.mController.tml;
        getString(i.app_tip);
        this.eXe = h.a(actionBarActivity, getString(i.contact_info_change_remarkimage_save), false, null);
        this.mPN = q.q(2, str);
    }

    public final void YX() {
        h.i(this, i.settings_modify_name_invalid_less, i.settings_modify_name_title);
    }

    public final void YY() {
        h.i(this, i.settings_modify_name_invalid_more, i.settings_modify_name_title);
    }
}

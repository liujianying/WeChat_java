package com.tencent.mm.plugin.setting.ui.setting;

import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.TextView;
import com.tencent.mm.model.bl;
import com.tencent.mm.plugin.messenger.foundation.a.a.h.b;
import com.tencent.mm.plugin.setting.a.f;
import com.tencent.mm.plugin.setting.a.g;
import com.tencent.mm.plugin.setting.a.i;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.widget.MMEditText;

public class EditSignatureUI extends MMActivity {
    private p eXe = null;
    private boolean hLL = false;
    private c hLO = new 1(this);
    private TextView mPC;
    private MMEditText mPM;
    private b mPN;
    final bl mPO = bl.IC();

    protected final int getLayoutId() {
        return g.edit_signature;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        a.sFg.b(this.hLO);
        initView();
    }

    public void onDestroy() {
        super.onDestroy();
        a.sFg.c(this.hLO);
    }

    protected final void initView() {
        setMMTitle(i.settings_signature);
        this.mPM = (MMEditText) findViewById(f.content);
        this.mPC = (TextView) findViewById(f.wordcount);
        this.mPM.setText(j.a(this, bi.oV((String) com.tencent.mm.kernel.g.Ei().DT().get(12291, null)), this.mPM.getTextSize()));
        this.mPM.setSelection(this.mPM.getText().length());
        this.mPC.setText(com.tencent.mm.ui.tools.g.be(60, this.mPM.getEditableText().toString()));
        com.tencent.mm.ui.tools.a.c.d(this.mPM).fj(0, 60).a(null);
        this.mPM.addTextChangedListener(new a(this, (byte) 0));
        setBackBtn(new 2(this));
        a(0, getString(i.app_save), new 3(this), s.b.tmX);
        enableOptionMenu(false);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            finish();
        }
        return super.onKeyDown(i, keyEvent);
    }
}

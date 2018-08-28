package com.tencent.mm.ui.tools;

import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s.b;
import com.tencent.mm.w.a.g;
import com.tencent.mm.w.a.h;
import com.tencent.mm.w.a.k;

public class MMTextInputUI extends MMActivity {
    private int daw;
    private int hmI;
    private EditText jzo;
    private TextView uAF;
    private int uAG;
    private boolean uAH;

    public int getLayoutId() {
        return h.input_text_ui;
    }

    private void goBack() {
        if (getIntent().getBooleanExtra("key_show_confirm", false)) {
            com.tencent.mm.ui.base.h.a(this.mController.tml, getString(k.quit_confirm_tips), "", new 1(this), null);
            return;
        }
        YC();
        setResult(0);
        finish();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (4 != i) {
            return super.onKeyDown(i, keyEvent);
        }
        x.i("MicroMsg.MMTextInputUI", "on back key down");
        goBack();
        return true;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.jzo = (EditText) findViewById(g.text_edit);
        this.uAF = (TextView) findViewById(g.state_tv);
        this.jzo.setHint(bi.aG(getIntent().getStringExtra("key_hint"), ""));
        this.jzo.append(bi.aG(getIntent().getStringExtra("key_value"), ""));
        this.daw = getIntent().getIntExtra("key_max_count", -1) << 1;
        this.hmI = 0;
        this.uAG = Math.max(this.daw - 120, (this.daw * 9) / 10);
        this.uAH = getIntent().getBooleanExtra("key_nullable", false);
        setBackBtn(new 2(this));
        a(0, getString(k.app_finish), new 3(this), b.tmX);
        enableOptionMenu(this.uAH);
        if (!this.uAH || this.daw > 0) {
            this.jzo.addTextChangedListener(new 4(this));
        }
    }

    public void w(CharSequence charSequence) {
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    protected void onResume() {
        super.onResume();
    }

    protected void onPause() {
        super.onPause();
    }
}

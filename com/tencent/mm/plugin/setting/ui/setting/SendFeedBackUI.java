package com.tencent.mm.plugin.setting.ui.setting;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.setting.a.f;
import com.tencent.mm.plugin.setting.a.g;
import com.tencent.mm.plugin.setting.a.i;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;

public class SendFeedBackUI extends MMActivity implements e {
    private ProgressDialog eHw = null;
    private TextView mQC = null;
    private EditText meN;

    protected final int getLayoutId() {
        return g.edit_signature;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
    }

    public void onDestroy() {
        com.tencent.mm.kernel.g.DF().b(153, this);
        super.onDestroy();
    }

    protected final void initView() {
        setMMTitle(i.settings_feedbackui_title);
        this.meN = (EditText) findViewById(f.content);
        String stringExtra = getIntent().getStringExtra("intentKeyFrom");
        if (stringExtra != null && stringExtra.equals("fromEnjoyAppDialog")) {
            this.mQC = (TextView) findViewById(f.view_question_text_view);
            this.mQC.setVisibility(0);
            this.mQC.setOnClickListener(new 1(this));
        }
        setBackBtn(new 2(this));
        addTextOptionMenu(0, getString(i.app_send), new 3(this));
    }

    public final void a(int i, int i2, String str, l lVar) {
        if (this.eHw != null) {
            this.eHw.dismiss();
            this.eHw = null;
        }
        if (i == 0 && i2 == 0) {
            h.a((Context) this, getString(i.settings_feedbackui_succ), getString(i.app_tip), new 4(this));
        } else {
            h.a((Context) this, getString(i.settings_feedbackui_err), getString(i.app_tip), new 5(this));
        }
    }
}

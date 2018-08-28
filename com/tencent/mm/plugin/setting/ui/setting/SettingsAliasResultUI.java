package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.setting.a;
import com.tencent.mm.plugin.setting.a.f;
import com.tencent.mm.plugin.setting.a.i;
import com.tencent.mm.ui.MMActivity;

public class SettingsAliasResultUI extends MMActivity {
    private String cCR;
    private TextView eCn;
    private TextView mRM;
    private Button mRN;
    private ImageView mRO;
    private boolean mRP;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.cCR = (String) g.Ei().DT().get(42, null);
        this.mRP = Boolean.valueOf(getIntent().getBooleanExtra("has_pwd", true)).booleanValue();
        initView();
    }

    protected final int getLayoutId() {
        return a.g.settings_alias_result;
    }

    public void onPause() {
        super.onPause();
    }

    public void onDestroy() {
        super.onDestroy();
    }

    protected final void initView() {
        setMMTitle(i.modify_username);
        this.eCn = (TextView) findViewById(f.desc_tv);
        this.mRM = (TextView) findViewById(f.alias_tv);
        this.mRN = (Button) findViewById(f.setpwd_btn);
        this.mRO = (ImageView) findViewById(f.ok_iv);
        setBackBtn(new 1(this));
        this.mRM.setText(this.cCR);
        if (this.mRP) {
            this.mRN.setVisibility(8);
            this.eCn.setText(getString(i.modify_username_result_normal_desc));
        } else {
            this.mRN.setVisibility(0);
            this.eCn.setText(getString(i.modify_username_result_goto_setpass));
        }
        this.mRN.setOnClickListener(new 2(this));
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1) {
            finish();
        }
        super.onActivityResult(i, i2, intent);
    }
}

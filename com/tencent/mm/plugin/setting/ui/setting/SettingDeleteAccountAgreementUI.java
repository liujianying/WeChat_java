package com.tencent.mm.plugin.setting.ui.setting;

import android.os.Bundle;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.tencent.mm.plugin.setting.a.f;
import com.tencent.mm.plugin.setting.a.g;
import com.tencent.mm.plugin.setting.a.i;
import com.tencent.mm.ui.MMActivity;

public class SettingDeleteAccountAgreementUI extends MMActivity {
    protected final int getLayoutId() {
        return g.setting_delete_account_agreement_ui;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setMMTitle(i.setting_del_account_title);
        initView();
    }

    protected final void initView() {
        TextView textView = (TextView) findViewById(f.next_btn);
        textView.setOnClickListener(new 1(this));
        CheckedTextView checkedTextView = (CheckedTextView) findViewById(f.agreement_cb);
        checkedTextView.setOnClickListener(new 2(this, textView, checkedTextView));
        textView.setEnabled(checkedTextView.isChecked());
        setBackBtn(new 3(this));
    }
}

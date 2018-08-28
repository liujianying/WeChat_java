package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.tencent.mm.plugin.setting.a.f;
import com.tencent.mm.plugin.setting.a.i;
import com.tencent.mm.ui.base.preference.Preference;

public class SettingsAboutMMHeaderPreference extends Preference {
    public String mQR = "";

    public SettingsAboutMMHeaderPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public SettingsAboutMMHeaderPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    protected final void onBindView(View view) {
        super.onBindView(view);
        TextView textView = (TextView) view.findViewById(f.about_version_code);
        textView.setText(String.format("%s %s", new Object[]{view.getResources().getString(i.app_name), this.mQR}));
        textView.setOnClickListener(new 1(this));
    }
}

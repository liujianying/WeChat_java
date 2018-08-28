package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.tencent.mm.ui.base.preference.Preference;

class SetTextSizeUI$a extends Preference {
    private float mQG;
    final /* synthetic */ SetTextSizeUI mQI;

    public SetTextSizeUI$a(SetTextSizeUI setTextSizeUI, Context context, float f) {
        this.mQI = setTextSizeUI;
        super(context);
        this.mQG = f;
    }

    protected final void onBindView(View view) {
        super.onBindView(view);
        TextView textView = (TextView) view.findViewById(16908310);
        if (textView != null) {
            textView.setTextSize(1, SetTextSizeUI.ao(this.mQG));
        }
    }
}

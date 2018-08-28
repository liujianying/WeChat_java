package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mm.plugin.setting.a.f;
import com.tencent.mm.plugin.setting.a.g;
import com.tencent.mm.ui.base.preference.Preference;

public final class PluginEmptyTextPreference extends Preference {
    private Context context;
    private TextView hND;
    private String text;

    public PluginEmptyTextPreference(Context context, int i) {
        this(context, null, 0);
        this.text = context.getString(i);
    }

    public PluginEmptyTextPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hND = null;
        this.context = context;
        setLayoutResource(g.plugin_text2_preference);
    }

    protected final View onCreateView(ViewGroup viewGroup) {
        View onCreateView = super.onCreateView(viewGroup);
        View.inflate(this.context, g.plugin_text2_preference, null);
        return onCreateView;
    }

    protected final void onBindView(View view) {
        super.onBindView(view);
        this.hND = (TextView) view.findViewById(f.empty_tv);
        this.hND.setText(this.text);
    }
}

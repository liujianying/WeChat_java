package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.w.a.g;
import com.tencent.mm.w.a.h;
import com.tencent.mm.w.a.m;

public final class PluginTextPreference extends Preference {
    private TextView hND;
    private ImageView lWM;
    public int tDi;
    private String text;
    private int textColor;
    public int visibility;

    public PluginTextPreference(Context context) {
        this(context, null);
    }

    public PluginTextPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PluginTextPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.lWM = null;
        this.hND = null;
        setLayoutResource(h.mm_preference_content_plugin_text);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, m.PluginTextPreference);
        this.tDi = obtainStyledAttributes.getResourceId(m.PluginTextPreference_plugin_icon, 0);
        this.text = obtainStyledAttributes.getString(m.PluginTextPreference_plugin_text);
        this.textColor = obtainStyledAttributes.getColor(m.PluginTextPreference_plugin_text_color, -7039852);
        obtainStyledAttributes.recycle();
    }

    public final void EA(int i) {
        this.text = this.mContext.getString(i);
    }

    protected final void onBindView(View view) {
        super.onBindView(view);
        this.lWM = (ImageView) view.findViewById(g.image_iv);
        this.lWM.setImageResource(this.tDi);
        this.lWM.setVisibility(this.visibility);
        this.hND = (TextView) view.findViewById(g.text_tv);
        this.hND.setText(this.text);
        this.hND.setTextColor(this.textColor);
    }
}

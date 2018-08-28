package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.mm.plugin.game.f.e;
import com.tencent.mm.plugin.game.f.f;
import com.tencent.mm.ui.base.preference.Preference;

public class GameRegionPreference extends Preference {
    a kbx;

    public static class a {
        public String csQ;
        public boolean eQK;
        public boolean isDefault;
        public String kbA;
        public String kby;
        public String kbz;
    }

    public GameRegionPreference(Context context) {
        this(context, null);
    }

    public GameRegionPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GameRegionPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setLayoutResource(f.mm_preference);
    }

    protected final View onCreateView(ViewGroup viewGroup) {
        View onCreateView = super.onCreateView(viewGroup);
        LayoutInflater layoutInflater = (LayoutInflater) this.mContext.getSystemService("layout_inflater");
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(e.content);
        viewGroup2.removeAllViews();
        layoutInflater.inflate(f.game_region_select_layout, viewGroup2);
        return onCreateView;
    }

    protected final void onBindView(View view) {
        super.onBindView(view);
        TextView textView = (TextView) view.findViewById(e.region_name);
        CheckBox checkBox = (CheckBox) view.findViewById(e.state_icon);
        if (textView != null && checkBox != null && this.kbx != null) {
            textView.setText(com.tencent.mm.plugin.game.model.f.a(this.kbx));
            checkBox.setChecked(this.kbx.eQK);
        }
    }
}

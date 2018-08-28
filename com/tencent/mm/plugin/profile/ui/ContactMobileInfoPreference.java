package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ui.base.preference.Preference;

public class ContactMobileInfoPreference extends Preference {
    private String cZH;
    private String eTa;
    private TextView gsY;
    private TextView lUO;

    public ContactMobileInfoPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public ContactMobileInfoPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setLayoutResource(R.i.mm_preference);
    }

    protected final View onCreateView(ViewGroup viewGroup) {
        View onCreateView = super.onCreateView(viewGroup);
        LayoutInflater layoutInflater = (LayoutInflater) this.mContext.getSystemService("layout_inflater");
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(R.h.content);
        viewGroup2.removeAllViews();
        layoutInflater.inflate(R.i.mm_preference_content_mobile_info, viewGroup2);
        return onCreateView;
    }

    protected final void onBindView(View view) {
        this.gsY = (TextView) view.findViewById(R.h.title);
        this.lUO = (TextView) view.findViewById(R.h.mobile);
        if (this.gsY != null) {
            this.gsY.setText(this.cZH);
        }
        if (this.lUO != null) {
            this.lUO.setText(this.eTa);
        }
        super.onBindView(view);
    }
}

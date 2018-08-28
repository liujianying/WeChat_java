package com.tencent.mm.ui.tools;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.platformtools.ai;
import com.tencent.mm.storage.RegionCodeDecoder.Region;
import com.tencent.mm.ui.base.preference.Preference;

public class ZoneRecommandPreference extends Preference {
    private TextView eBR;
    int status;
    Region uCG;
    Region uCH;
    Region uCI;
    private TextView uCJ;
    private ImageView uCK;

    public ZoneRecommandPreference(Context context) {
        this(context, null);
    }

    public ZoneRecommandPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ZoneRecommandPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.status = 0;
        setLayoutResource(R.i.mm_preference);
    }

    protected final View onCreateView(ViewGroup viewGroup) {
        View onCreateView = super.onCreateView(viewGroup);
        LayoutInflater layoutInflater = (LayoutInflater) this.mContext.getSystemService("layout_inflater");
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(R.h.content);
        viewGroup2.removeAllViews();
        layoutInflater.inflate(R.i.mm_preference_content_zone_recommand, viewGroup2);
        this.uCJ = (TextView) onCreateView.findViewById(R.h.zonename);
        this.eBR = (TextView) onCreateView.findViewById(R.h.status);
        this.uCK = (ImageView) onCreateView.findViewById(R.h.status_image);
        return onCreateView;
    }

    protected final void onBindView(View view) {
        super.onBindView(view);
        czX();
    }

    final void czX() {
        if (this.uCJ != null && this.eBR != null) {
            switch (this.status) {
                case 0:
                    this.uCJ.setVisibility(8);
                    this.eBR.setVisibility(0);
                    this.eBR.setText(R.l.setting_zone_getting_location);
                    this.uCK.setImageResource(R.k.get_location_icon);
                    setEnabled(false);
                    setSelectable(false);
                    return;
                case 1:
                    this.uCJ.setVisibility(0);
                    this.eBR.setVisibility(8);
                    this.uCK.setImageResource(R.k.get_location_icon);
                    CharSequence charSequence = "";
                    if (!(this.uCG == null || ai.oW(this.uCG.getName()))) {
                        charSequence = charSequence + this.uCG.getName();
                    }
                    if (!(this.uCH == null || ai.oW(this.uCH.getName()))) {
                        charSequence = charSequence + " " + this.uCH.getName();
                    }
                    if (!(this.uCI == null || ai.oW(this.uCI.getName()))) {
                        charSequence = charSequence + " " + this.uCI.getName();
                    }
                    this.uCJ.setText(charSequence);
                    setEnabled(true);
                    setSelectable(true);
                    return;
                case 2:
                    this.uCJ.setVisibility(8);
                    this.eBR.setVisibility(0);
                    this.eBR.setText(R.l.setting_zone_cannot_get_location);
                    this.uCK.setImageResource(R.k.get_location_failed_icon);
                    setEnabled(false);
                    setSelectable(false);
                    return;
                default:
                    return;
            }
        }
    }

    public final void czY() {
        this.status = 2;
        czX();
    }
}

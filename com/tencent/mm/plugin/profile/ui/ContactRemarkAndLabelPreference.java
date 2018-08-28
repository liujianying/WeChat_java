package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bp.a;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.base.preference.Preference;

public class ContactRemarkAndLabelPreference extends Preference {
    private TextView gsY;
    private String iRT;
    private TextView lVp;
    private TextView lVq;
    private boolean lVr = false;
    private String lVs;
    private String lVt;
    private Context mContext;

    public ContactRemarkAndLabelPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
    }

    public ContactRemarkAndLabelPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
        setLayoutResource(R.i.mm_preference);
    }

    protected final View onCreateView(ViewGroup viewGroup) {
        View onCreateView = super.onCreateView(viewGroup);
        LayoutInflater layoutInflater = (LayoutInflater) this.mContext.getSystemService("layout_inflater");
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(R.h.content);
        viewGroup2.removeAllViews();
        layoutInflater.inflate(R.i.mm_preference_content_remark_and_label_info, viewGroup2);
        return onCreateView;
    }

    public final void onBindView(View view) {
        LayoutParams layoutParams;
        int i;
        this.gsY = (TextView) view.findViewById(R.h.title);
        this.lVp = (TextView) view.findViewById(R.h.remark);
        this.lVq = (TextView) view.findViewById(R.h.label);
        if (!(this.gsY == null || bi.oW(this.iRT))) {
            this.gsY.setVisibility(0);
            this.gsY.setText(this.iRT);
            layoutParams = (LayoutParams) this.gsY.getLayoutParams();
            layoutParams.width = a.ad(this.mContext, R.f.FixedTitleWidth);
            this.gsY.setLayoutParams(layoutParams);
        }
        if (this.lVp != null) {
            if (this.lVr) {
                this.lVp.setVisibility(0);
                this.lVp.setCompoundDrawablesWithIntrinsicBounds(R.k.card_photoicon, 0, 0, 0);
                i = 1;
            } else {
                this.lVp.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                i = 0;
            }
            if (!bi.oW(this.lVs)) {
                this.lVp.setVisibility(0);
                this.lVp.setText(j.a(this.mContext, bi.oV(this.lVs), this.lVp.getTextSize()));
                i = 1;
            }
        } else {
            i = 0;
        }
        if (!(this.lVq == null || bi.oW(this.lVt))) {
            i |= 2;
            this.lVq.setVisibility(0);
            this.lVq.setText(this.lVt);
        }
        int i2 = i;
        if (i2 == 1) {
            ((LayoutParams) this.lVp.getLayoutParams()).addRule(15);
        }
        if (i2 == 2) {
            layoutParams = (LayoutParams) this.lVq.getLayoutParams();
            layoutParams.addRule(3, 0);
            layoutParams.addRule(15);
        }
        super.onBindView(view);
    }
}

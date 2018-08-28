package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.Preference;

public class RemarkInfoPreference extends Preference {
    private MMActivity bGc;
    private TextView eBO;
    private ImageView gxd;
    private TextView lWL;
    private boolean lXU = false;
    private String summary;
    private String title;

    public final /* synthetic */ CharSequence getSummary() {
        return this.lWL.getText().toString();
    }

    public RemarkInfoPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bGc = (MMActivity) context;
    }

    public RemarkInfoPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setLayoutResource(R.i.mm_preference);
        setWidgetLayoutResource(R.i.mm_preference_submenu);
    }

    protected final View onCreateView(ViewGroup viewGroup) {
        View onCreateView = super.onCreateView(viewGroup);
        LayoutInflater layoutInflater = (LayoutInflater) this.mContext.getSystemService("layout_inflater");
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(R.h.content);
        viewGroup2.removeAllViews();
        layoutInflater.inflate(R.i.mm_preference_content_remark_info, viewGroup2);
        return onCreateView;
    }

    public final void onBindView(View view) {
        this.eBO = (TextView) view.findViewById(R.h.title);
        this.lWL = (TextView) view.findViewById(R.h.summary);
        this.gxd = (ImageView) view.findViewById(R.h.image_iv);
        if (this.lXU) {
            this.gxd.setVisibility(0);
        } else {
            this.gxd.setVisibility(8);
        }
        if (this.eBO != null) {
            this.eBO.setText(this.title);
        }
        if (this.lWL != null) {
            this.lWL.setText(this.summary);
        }
        super.onBindView(view);
    }
}

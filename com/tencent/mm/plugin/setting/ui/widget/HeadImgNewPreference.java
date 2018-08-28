package com.tencent.mm.plugin.setting.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.setting.a.f;
import com.tencent.mm.plugin.setting.a.g;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.ui.base.preference.Preference;

public final class HeadImgNewPreference extends Preference {
    public ImageView gwj;
    private int height;
    private TextView mVP;
    private View mVQ;
    public String mVR;
    public OnClickListener mVS;
    public boolean mVT;
    private boolean mVU;

    public HeadImgNewPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public HeadImgNewPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.height = -1;
        this.mVT = false;
        this.mVU = false;
        setLayoutResource(g.mm_preference);
    }

    protected final View onCreateView(ViewGroup viewGroup) {
        View onCreateView = super.onCreateView(viewGroup);
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(f.content);
        viewGroup2.removeAllViews();
        if (this.mVU) {
            View.inflate(this.mContext, g.more_tab_personal_info, viewGroup2);
        } else {
            View.inflate(this.mContext, g.mm_preference_content_headimg_new, viewGroup2);
        }
        this.gwj = (ImageView) onCreateView.findViewById(f.image_headimg);
        this.mVP = (TextView) onCreateView.findViewById(f.no_header_icon_tip);
        this.mVQ = onCreateView.findViewById(f.mask_header_icon);
        return onCreateView;
    }

    protected final void onBindView(View view) {
        super.onBindView(view);
        if (this.gwj == null) {
            this.gwj = (ImageView) view.findViewById(f.image_headimg);
        }
        if (this.mVP == null) {
            this.mVP = (TextView) view.findViewById(f.no_header_icon_tip);
        }
        if (this.mVQ == null) {
            this.mVQ = view.findViewById(f.mask_header_icon);
        }
        if (this.mVS != null) {
            this.mVQ.setOnClickListener(this.mVS);
        }
        if (this.mVR != null) {
            b.a(this.gwj, this.mVR);
            this.mVR = null;
        }
        if (this.mVT) {
            this.mVP.setVisibility(8);
            this.mVQ.setVisibility(0);
        } else {
            this.mVQ.setVisibility(8);
            this.mVP.setVisibility(0);
        }
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(f.mm_preference_ll_id);
        if (this.height != -1) {
            relativeLayout.setMinimumHeight(this.height);
        }
    }
}

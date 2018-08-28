package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bp.a;
import com.tencent.mm.ui.base.preference.Preference;

public class ContactMoreInfoPreference extends Preference {
    private TextView hEx;
    private ImageView lUP;
    private ImageView lUQ;
    private ImageView lUR;
    private ImageView lUS;
    private ImageView lUT;
    private ImageView lUU;
    private int lUV = 8;
    private int lUW = 8;
    private int lUX = 8;
    private int lUY = 8;
    private int lUZ = 8;
    private int lVa = 8;

    public ContactMoreInfoPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ContactMoreInfoPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setLayoutResource(R.i.mm_preference);
    }

    protected final View onCreateView(ViewGroup viewGroup) {
        View onCreateView = super.onCreateView(viewGroup);
        LayoutInflater layoutInflater = (LayoutInflater) this.mContext.getSystemService("layout_inflater");
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(R.h.content);
        viewGroup2.removeAllViews();
        layoutInflater.inflate(R.i.mm_preference_content_more_info, viewGroup2);
        return onCreateView;
    }

    public final void onBindView(View view) {
        this.lUP = (ImageView) view.findViewById(R.h.image_mobile);
        this.lUQ = (ImageView) view.findViewById(R.h.image_qq);
        this.lUR = (ImageView) view.findViewById(R.h.image_linkedin);
        this.lUS = (ImageView) view.findViewById(R.h.image_facebook);
        this.lUT = (ImageView) view.findViewById(R.h.image_googlecontacts);
        this.lUU = (ImageView) view.findViewById(R.h.image_weishop);
        this.hEx = (TextView) view.findViewById(R.h.title);
        aL();
        super.onBindView(view);
    }

    public final void uF(int i) {
        this.lUW = i;
        aL();
    }

    public final void uG(int i) {
        this.lUX = i;
        aL();
    }

    public final void uH(int i) {
        this.lUZ = i;
        aL();
    }

    public final void uI(int i) {
        this.lVa = i;
        aL();
    }

    private void aL() {
        if (this.lUP != null) {
            this.lUP.setVisibility(this.lUV);
        }
        if (this.lUQ != null) {
            this.lUQ.setVisibility(this.lUW);
        }
        if (this.lUR != null) {
            this.lUR.setVisibility(this.lUX);
        }
        if (this.lUS != null) {
            this.lUS.setVisibility(this.lUY);
        }
        if (this.lUT != null) {
            this.lUT.setVisibility(this.lUZ);
        }
        if (this.hEx != null) {
            LayoutParams layoutParams = this.hEx.getLayoutParams();
            layoutParams.width = a.ad(this.mContext, R.f.FixedTitleWidth);
            this.hEx.setLayoutParams(layoutParams);
        }
        if (this.lUU != null) {
            this.lUU.setVisibility(this.lVa);
        }
    }
}

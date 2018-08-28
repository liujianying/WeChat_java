package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.mm.R;
import com.tencent.mm.bp.a;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.ui.base.preference.Preference;
import java.util.List;

public class BizInfoPayInfoIconPreference extends Preference {
    private LayoutInflater Bc;
    private LinearLayout lUu;
    private List<String> lUv;
    private int lUw;

    public BizInfoPayInfoIconPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BizInfoPayInfoIconPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.lUw = -1;
        this.Bc = (LayoutInflater) context.getSystemService("layout_inflater");
        setLayoutResource(R.i.mm_preference);
    }

    protected final View onCreateView(ViewGroup viewGroup) {
        View onCreateView = super.onCreateView(viewGroup);
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(R.h.content);
        viewGroup2.removeAllViews();
        this.Bc.inflate(R.i.contact_info_pay_info_icon, viewGroup2);
        return onCreateView;
    }

    public final void onBindView(View view) {
        super.onBindView(view);
        this.lUu = (LinearLayout) view.findViewById(R.h.summary);
        aL();
    }

    public final void uD(int i) {
        if (i != this.lUw) {
            this.lUw = i;
            aL();
        }
    }

    public final void bH(List<String> list) {
        this.lUv = list;
        aL();
    }

    private void aL() {
        if (this.lUu != null) {
            this.lUu.removeAllViews();
            if (this.lUw >= 0) {
                int i = this.lUw;
                for (int i2 = 0; i2 < 5; i2++) {
                    if (i <= 0) {
                        uE(R.k.biz_info_brand_unselect);
                    } else if (i <= 10) {
                        uE(R.k.biz_info_brand_half_selected);
                        i -= 20;
                    } else {
                        uE(R.k.biz_info_brand_selected);
                        i -= 20;
                    }
                }
            } else if (this.lUv != null) {
                for (String str : this.lUv) {
                    CdnImageView cdnImageView = new CdnImageView(this.mContext);
                    cdnImageView.setUrl(str);
                    LayoutParams layoutParams = new LinearLayout.LayoutParams(a.fromDPToPix(this.mContext, 20), a.fromDPToPix(this.mContext, 20));
                    layoutParams.rightMargin = a.fromDPToPix(this.mContext, 6);
                    this.lUu.addView(cdnImageView, layoutParams);
                }
            }
        }
    }

    private void uE(int i) {
        ImageView imageView = (ImageView) this.Bc.inflate(R.i.contact_info_biz_info_icon, null);
        LayoutParams layoutParams = new LinearLayout.LayoutParams(a.fromDPToPix(this.mContext, 20), a.fromDPToPix(this.mContext, 20));
        layoutParams.rightMargin = a.fromDPToPix(this.mContext, 6);
        imageView.setImageResource(i);
        this.lUu.addView(imageView, layoutParams);
    }
}

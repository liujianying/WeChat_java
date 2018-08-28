package com.tencent.mm.plugin.appbrand.page;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.appbrand.s.g;
import com.tencent.mm.plugin.appbrand.s.h;

public class AppBrandActionSingleHeaderView extends LinearLayout {
    private ImageView bOA;
    private TextView ePz;

    public AppBrandActionSingleHeaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    @TargetApi(11)
    public AppBrandActionSingleHeaderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    private void init(Context context) {
        ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(h.appbrand_action_single_header, this);
        this.bOA = (ImageView) findViewById(g.appbrand_action_single_header_image);
        this.ePz = (TextView) findViewById(g.appbrand_action_single_header_text);
    }

    public ImageView getImageView() {
        return this.bOA;
    }

    public void setImageResource(int i) {
        this.bOA.setImageResource(i);
    }

    public void setImageDrawable(Drawable drawable) {
        this.bOA.setImageDrawable(drawable);
    }

    public void setTextViewText(String str) {
        this.ePz.setText(str);
    }

    public void setTextViewTextColor(int i) {
        this.ePz.setTextColor(i);
    }
}

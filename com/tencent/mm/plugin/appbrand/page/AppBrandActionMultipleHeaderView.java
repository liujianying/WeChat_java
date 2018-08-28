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

public class AppBrandActionMultipleHeaderView extends LinearLayout {
    private ImageView bOA;
    private TextView ePz;
    private String gmb;
    private String path;
    private int type;
    private String username;

    public AppBrandActionMultipleHeaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    @TargetApi(11)
    public AppBrandActionMultipleHeaderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    private void init(Context context) {
        ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(h.appbrand_action_multiple_header, this);
        this.bOA = (ImageView) findViewById(g.appbrand_action_multiple_header_image);
        this.ePz = (TextView) findViewById(g.appbrand_action_multiple_header_text);
    }

    public int getType() {
        return this.type;
    }

    public String getH5Url() {
        return this.gmb;
    }

    public String getUsername() {
        return this.username;
    }

    public String getPath() {
        return this.path;
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

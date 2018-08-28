package com.tencent.mm.plugin.nearlife.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;

public class NearPoiHeader extends LinearLayout {
    private TextView fAK;
    private ImageView kYV;

    @TargetApi(11)
    public NearPoiHeader(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    public NearPoiHeader(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    private void init(Context context) {
        View inflate = View.inflate(context, R.i.near_header_item, this);
        this.kYV = (ImageView) inflate.findViewById(R.h.location_icon);
        this.fAK = (TextView) inflate.findViewById(R.h.life_item_title);
    }

    public void setText(CharSequence charSequence) {
        this.fAK.setText(charSequence);
    }
}

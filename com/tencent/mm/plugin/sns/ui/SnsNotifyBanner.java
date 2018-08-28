package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.sns.i$f;
import com.tencent.mm.plugin.sns.i$g;

public class SnsNotifyBanner extends RelativeLayout {
    private LayoutInflater Bc;
    private View FU;
    private TextView nYZ;
    private ImageView nZa;
    int nZb = 0;
    private a nZc;

    public SnsNotifyBanner(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    public SnsNotifyBanner(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    private void init() {
        this.Bc = (LayoutInflater) getContext().getSystemService("layout_inflater");
        this.FU = this.Bc.inflate(i$g.sns_notify_banner, this, true);
        this.nYZ = (TextView) this.FU.findViewById(i$f.sns_banner_notify_tv);
        this.nZa = (ImageView) this.FU.findViewById(i$f.sns_banner_notify_close_iv);
        this.nZa.setOnClickListener(new 1(this));
    }

    public void setOnClickNotify(a aVar) {
        this.nZc = aVar;
        this.nYZ.setOnClickListener(new 2(this));
    }
}

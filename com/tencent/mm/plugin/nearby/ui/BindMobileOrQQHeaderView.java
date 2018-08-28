package com.tencent.mm.plugin.nearby.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;

public class BindMobileOrQQHeaderView extends LinearLayout {
    private ImageView gxd;
    private TextView lBv;
    private int lBw;
    private OnClickListener lBx;

    public BindMobileOrQQHeaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.lBx = new 1(this);
        co(context);
    }

    public BindMobileOrQQHeaderView(Context context) {
        super(context);
        this.lBx = new 1(this);
        this.lBw = a.lBA;
        co(context);
    }

    private void co(Context context) {
        View inflate = View.inflate(context, R.i.nearby_bindmobile_header_view, this);
        this.lBv = (TextView) inflate.findViewById(R.h.nearby_header_text);
        this.gxd = (ImageView) inflate.findViewById(R.h.nearby_bind_icon);
        switch (2.lBz[this.lBw - 1]) {
            case 1:
                setOnClickListener(this.lBx);
                this.gxd.setImageResource(R.k.userguide_bindmb_icon);
                return;
            case 2:
                setOnClickListener(this.lBx);
                this.gxd.setImageResource(R.k.userguide_contacts_icon);
                return;
            default:
                return;
        }
    }
}

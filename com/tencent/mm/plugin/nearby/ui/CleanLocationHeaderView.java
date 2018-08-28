package com.tencent.mm.plugin.nearby.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;

public class CleanLocationHeaderView extends LinearLayout {
    private ImageView gxd;
    private TextView lBv;

    public CleanLocationHeaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        co(context);
    }

    public CleanLocationHeaderView(Context context) {
        super(context);
        co(context);
    }

    private void co(Context context) {
        View inflate = View.inflate(context, R.i.nearby_bindmobile_header_view, this);
        this.lBv = (TextView) inflate.findViewById(R.h.nearby_header_text);
        this.lBv.setSingleLine(false);
        this.gxd = (ImageView) inflate.findViewById(R.h.nearby_bind_icon);
        this.lBv.setText(R.l.clean_loaction_header_title);
        this.gxd.setImageResource(R.k.peoplenearby_icon);
    }
}

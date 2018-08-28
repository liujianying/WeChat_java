package com.tencent.mm.plugin.aa.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.ui.y;

public class AAQueryListH5UrlFooterView extends LinearLayout {
    private TextView eBT;

    public AAQueryListH5UrlFooterView(Context context) {
        super(context);
        init(context);
    }

    public AAQueryListH5UrlFooterView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public AAQueryListH5UrlFooterView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    private void init(Context context) {
        this.eBT = (TextView) y.gq(context).inflate(g.aa_record_list_h5url_footer, this, true).findViewById(f.aa_record_bottom_link_tv);
    }

    public TextView getBottomLinkTv() {
        return this.eBT;
    }
}

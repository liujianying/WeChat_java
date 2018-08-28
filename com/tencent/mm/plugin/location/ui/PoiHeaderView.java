package com.tencent.mm.plugin.location.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.map.a.e;
import com.tencent.mm.plugin.map.a.f;
import com.tencent.mm.sdk.platformtools.x;

public class PoiHeaderView extends RelativeLayout {
    private Context context;
    public TextView hND;
    public String kFg = "";
    public String kFh = "";
    public SimpleImageView kFi;

    public PoiHeaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.context = context;
        View inflate = View.inflate(this.context, f.poi_header_view, this);
        this.hND = (TextView) inflate.findViewById(e.header_text);
        this.kFi = (SimpleImageView) inflate.findViewById(e.header_logo);
        this.hND.setVisibility(8);
        this.kFi.setVisibility(8);
        setVisibility(8);
        setOnClickListener(new 1(this));
    }

    public void setViewUrl(String str) {
        x.d("MicroMsg.PoiHeaderView", "viewUrl " + str);
        this.kFh = str;
    }
}

package com.tencent.mm.plugin.appbrand.ui.autofill;

import android.graphics.drawable.ShapeDrawable;
import android.support.v7.widget.RecyclerView.t;
import android.view.View;
import android.widget.TextView;
import com.tencent.mm.plugin.appbrand.s.g;

public class a$a$a extends t {
    public TextView eHU;
    public TextView gxt;

    public a$a$a(View view) {
        super(view);
        this.eHU = (TextView) view.findViewById(g.app_brand_idcard_show_item_name);
        ShapeDrawable shapeDrawable = new ShapeDrawable();
        this.gxt = (TextView) view.findViewById(g.app_brand_idcard_show_item_value);
    }
}

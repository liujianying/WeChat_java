package com.tencent.mm.plugin.fav.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.ui.m$e;
import com.tencent.mm.plugin.fav.ui.m$f;
import com.tencent.mm.plugin.fav.ui.m.i;

public class FavCapacityPanel extends LinearLayout {
    private OnClickListener iZP = new 1(this);
    private LinearLayout jeZ = this;
    public long jfa;
    public TextView jfb;
    public int jfc = 0;
    public long jfd;

    public FavCapacityPanel(Context context, AttributeSet attributeSet) {
        long j;
        super(context, attributeSet);
        View inflate = View.inflate(getContext(), m$f.fav_tag_panel_footview, null);
        inflate.measure(-2, -2);
        View findViewById = inflate.findViewById(m$e.fav_capacity_foot_line);
        View findViewById2 = inflate.findViewById(m$e.fav_capacity_foot_linear);
        this.jfb = (TextView) inflate.findViewById(m$e.fav_capacity_foot_desc);
        LayoutParams layoutParams = (LayoutParams) findViewById.getLayoutParams();
        layoutParams.width = inflate.getMeasuredWidth();
        findViewById.setLayoutParams(layoutParams);
        findViewById2.setOnClickListener(this.iZP);
        ViewGroup.LayoutParams layoutParams2 = new LayoutParams(0, -2);
        layoutParams2.weight = 1.0f;
        this.jeZ.addView(inflate, layoutParams2);
        this.jfa = b.aKR() / 1048576;
        this.jfd = b.aKS() / 1048576;
        TextView textView = this.jfb;
        Context context2 = this.jfb.getContext();
        int i = i.fav_capacity_info;
        Object[] objArr = new Object[2];
        if (this.jfd - this.jfa > 0) {
            j = this.jfd - this.jfa;
        } else {
            j = 0;
        }
        objArr[0] = Long.valueOf(j);
        objArr[1] = Long.valueOf(this.jfa);
        textView.setText(context2.getString(i, objArr));
    }
}

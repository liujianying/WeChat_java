package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.setting.a.d;
import com.tencent.mm.plugin.setting.a.f;
import com.tencent.mm.plugin.setting.a.g;

public class NetStatGroup extends LinearLayout {
    LinearLayout mPY;
    final TextView mPZ;

    public NetStatGroup(Context context) {
        this(context, null);
    }

    public NetStatGroup(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        View.inflate(context, g.netstat_group, this);
        this.mPY = (LinearLayout) findViewById(f.group);
        this.mPZ = (TextView) findViewById(f.date);
        this.mPZ.setTextSize(0, (float) context.getResources().getDimensionPixelSize(d.HintTextSize));
    }
}

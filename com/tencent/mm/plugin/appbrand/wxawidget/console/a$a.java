package com.tencent.mm.plugin.appbrand.wxawidget.console;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView.t;
import android.view.View;
import android.widget.TextView;
import com.tencent.mm.plugin.appbrand.wxawidget.b.b;
import com.tencent.smtt.sdk.TbsListener$ErrorCode;

class a$a extends t {
    TextView eZj;
    TextView gQm;

    public a$a(View view, int i) {
        super(view);
        this.gQm = (TextView) view.findViewById(b.level_tv);
        this.eZj = (TextView) view.findViewById(b.content_tv);
        switch (i) {
            case 1:
                this.gQm.setText("L");
                this.eZj.setTextColor(-7829368);
                return;
            case 2:
                this.gQm.setText("I");
                this.eZj.setTextColor(-16777216);
                return;
            case 3:
                this.gQm.setText("W");
                this.eZj.setTextColor(Color.rgb(0, 0, TbsListener$ErrorCode.APK_INVALID));
                return;
            case 4:
                this.gQm.setText("E");
                this.eZj.setTextColor(-65536);
                return;
            default:
                this.gQm.setText("L");
                this.eZj.setTextColor(-7829368);
                return;
        }
    }
}

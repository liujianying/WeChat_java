package com.tencent.mm.plugin.appbrand.wxawidget.console;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.ipcinvoker.type.IPCBoolean;
import com.tencent.mm.plugin.appbrand.wxawidget.b.b;
import com.tencent.mm.plugin.appbrand.wxawidget.b.c;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.ui.widget.MMSwitchBtn$a;

public class PerformancePanel extends FrameLayout {
    MMSwitchBtn fxV;
    MMSwitchBtn fxW;
    MMSwitchBtn fxX;

    public PerformancePanel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public PerformancePanel(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(c.performance_panel, this, true);
        final TextView textView = (TextView) findViewById(b.msg_panel);
        View findViewById = findViewById(b.refresh_btn);
        findViewById.setOnClickListener(new 1(this, textView));
        findViewById(b.clear_btn).setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                f.a("com.tencent.mm:support", null, a.class, null);
                com.tencent.mm.plugin.appbrand.collector.c.clear();
                com.tencent.mm.plugin.appbrand.collector.f.reset();
                textView.setText(com.tencent.mm.plugin.appbrand.collector.c.rx("jsapi_draw_canvas").toString());
            }
        });
        MMSwitchBtn mMSwitchBtn = (MMSwitchBtn) findViewById(b.open_collect_btn);
        boolean adr = com.tencent.mm.plugin.appbrand.collector.c.adr();
        mMSwitchBtn.setCheck(adr);
        mMSwitchBtn.setSwitchListener(new 3(this, findViewById));
        findViewById.setEnabled(adr);
        this.fxV = (MMSwitchBtn) findViewById(b.collect_draw_canvas_cost_time_btn);
        this.fxV.setEnabled(adr);
        this.fxV.setCheck(com.tencent.mm.plugin.appbrand.collector.c.rA("jsapi_draw_canvas"));
        this.fxV.setSwitchListener(new MMSwitchBtn$a() {
            public final void cf(boolean z) {
                f.a("com.tencent.mm:support", new IPCBoolean(z), b.class, null);
                if (z) {
                    com.tencent.mm.plugin.appbrand.collector.c.ry("jsapi_draw_canvas");
                } else {
                    com.tencent.mm.plugin.appbrand.collector.c.rz("jsapi_draw_canvas");
                }
            }
        });
        this.fxW = (MMSwitchBtn) findViewById(b.collect_widget_launch_cost_time_btn);
        this.fxW.setEnabled(adr);
        this.fxW.setCheck(com.tencent.mm.plugin.appbrand.collector.c.rA("widget_launch"));
        this.fxW.setSwitchListener(new 5(this));
        this.fxX = (MMSwitchBtn) findViewById(b.collect_widget_fps_btn);
        this.fxX.setEnabled(adr);
        this.fxX.setCheck(com.tencent.mm.plugin.appbrand.collector.f.ads());
        this.fxX.setSwitchListener(new 6(this));
    }
}

package com.tencent.mm.plugin.appbrand.dynamic.ui;

import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.ipcinvoker.i;
import com.tencent.mm.ipcinvoker.type.IPCBoolean;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.plugin.appbrand.wxawidget.b$c;
import com.tencent.mm.plugin.appbrand.wxawidget.b.b;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMSwitchBtn;

public class WxaWidgetPerformanceUI extends MMActivity {
    MMSwitchBtn fxV;
    MMSwitchBtn fxW;
    MMSwitchBtn fxX;

    private static class e implements i<IPCString, IPCString> {
        private e() {
        }

        public final /* synthetic */ Object av(Object obj) {
            return new IPCString(com.tencent.mm.plugin.appbrand.collector.c.rx(((IPCString) obj).value).toString());
        }
    }

    private static class a implements com.tencent.mm.ipcinvoker.a<IPCVoid, IPCVoid> {
        private a() {
        }

        public final /* synthetic */ void a(Object obj, com.tencent.mm.ipcinvoker.c cVar) {
            com.tencent.mm.plugin.appbrand.collector.c.clear();
        }
    }

    private static class c implements com.tencent.mm.ipcinvoker.a<IPCBoolean, IPCVoid> {
        private c() {
        }

        public final /* synthetic */ void a(Object obj, com.tencent.mm.ipcinvoker.c cVar) {
            if (((IPCBoolean) obj).value) {
                com.tencent.mm.plugin.appbrand.collector.c.ry("widget_launch");
            } else {
                com.tencent.mm.plugin.appbrand.collector.c.rz("widget_launch");
            }
        }
    }

    private static class d implements com.tencent.mm.ipcinvoker.a<IPCBoolean, IPCVoid> {
        private d() {
        }

        public final /* synthetic */ void a(Object obj, com.tencent.mm.ipcinvoker.c cVar) {
            com.tencent.mm.plugin.appbrand.collector.c.cx(((IPCBoolean) obj).value);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setBackBtn(new 1(this));
        setMMTitle(com.tencent.mm.plugin.appbrand.wxawidget.b.e.wxa_widget_performance);
        TextView textView = (TextView) findViewById(b.msg_panel);
        View findViewById = findViewById(b.refresh_btn);
        findViewById.setOnClickListener(new 2(this, textView));
        findViewById(b.clear_btn).setOnClickListener(new 3(this, textView));
        MMSwitchBtn mMSwitchBtn = (MMSwitchBtn) findViewById(b.open_collect_btn);
        boolean adr = com.tencent.mm.plugin.appbrand.collector.c.adr();
        mMSwitchBtn.setCheck(adr);
        mMSwitchBtn.setSwitchListener(new 4(this, findViewById));
        findViewById.setEnabled(adr);
        this.fxV = (MMSwitchBtn) findViewById(b.collect_draw_canvas_cost_time_btn);
        this.fxV.setEnabled(adr);
        this.fxV.setCheck(com.tencent.mm.plugin.appbrand.collector.c.rA("jsapi_draw_canvas"));
        this.fxV.setSwitchListener(new 5(this));
        this.fxW = (MMSwitchBtn) findViewById(b.collect_widget_launch_cost_time_btn);
        this.fxW.setEnabled(adr);
        this.fxW.setCheck(com.tencent.mm.plugin.appbrand.collector.c.rA("widget_launch"));
        this.fxW.setSwitchListener(new com.tencent.mm.ui.widget.MMSwitchBtn.a() {
            public final void cf(boolean z) {
                f.a("com.tencent.mm:support", new IPCBoolean(z), c.class, null);
                if (z) {
                    com.tencent.mm.plugin.appbrand.collector.c.ry("widget_launch");
                } else {
                    com.tencent.mm.plugin.appbrand.collector.c.rz("widget_launch");
                }
            }
        });
        this.fxX = (MMSwitchBtn) findViewById(b.collect_widget_fps_btn);
        this.fxX.setEnabled(adr);
        this.fxX.setCheck(com.tencent.mm.plugin.appbrand.collector.f.ads());
        this.fxX.setSwitchListener(new 7(this));
    }

    public void finish() {
        if (!isFinishing() && !this.tlP) {
            if (VERSION.SDK_INT >= 21) {
                finishAndRemoveTask();
            } else {
                super.finish();
            }
            TypedArray obtainStyledAttributes = obtainStyledAttributes(16973825, new int[]{16842938, 16842939});
            int resourceId = obtainStyledAttributes.getResourceId(0, 0);
            int resourceId2 = obtainStyledAttributes.getResourceId(1, 0);
            obtainStyledAttributes.recycle();
            overridePendingTransition(resourceId, resourceId2);
        }
    }

    protected final int getLayoutId() {
        return b$c.wxa_widget_performance_ui;
    }
}

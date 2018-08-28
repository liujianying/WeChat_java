package com.tencent.mm.plugin.appbrand.wxawidget.console;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.plugin.appbrand.collector.c;
import com.tencent.mm.plugin.appbrand.wxawidget.console.PerformancePanel.e;

class PerformancePanel$1 implements OnClickListener {
    final /* synthetic */ TextView fxZ;
    final /* synthetic */ PerformancePanel gQM;

    PerformancePanel$1(PerformancePanel performancePanel, TextView textView) {
        this.gQM = performancePanel;
        this.fxZ = textView;
    }

    public final void onClick(View view) {
        String stringBuilder = c.rx("jsapi_draw_canvas").toString();
        StringBuilder stringBuilder2 = new StringBuilder();
        if (stringBuilder != null && stringBuilder.length() > 0) {
            stringBuilder2.append("data size :").append(c.bb("jsapi_draw_canvas", "__invoke_jsapi_data_size")).append("\n").append(stringBuilder);
        }
        IPCString iPCString = (IPCString) f.a("com.tencent.mm:support", new IPCString("widget_launch"), e.class);
        if (iPCString != null) {
            stringBuilder2.append("\n\n").append(iPCString);
        }
        if (com.tencent.mm.plugin.appbrand.collector.f.ads()) {
            stringBuilder2.append("\n\n").append(com.tencent.mm.plugin.appbrand.collector.f.adt());
        }
        this.fxZ.setText(stringBuilder2.toString());
    }
}

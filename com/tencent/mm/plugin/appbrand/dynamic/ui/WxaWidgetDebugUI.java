package com.tencent.mm.plugin.appbrand.dynamic.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.text.style.URLSpan;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.dynamic.html.CustomURLSpan;
import com.tencent.mm.plugin.appbrand.dynamic.widget.c;
import com.tencent.mm.plugin.appbrand.widget.a.a;
import com.tencent.mm.plugin.appbrand.widget.l;
import com.tencent.mm.plugin.appbrand.wxawidget.b$c;
import com.tencent.mm.plugin.appbrand.wxawidget.b.b;
import com.tencent.mm.plugin.appbrand.wxawidget.b.e;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMSwitchBtn;

public class WxaWidgetDebugUI extends MMActivity {
    String appId;
    int bPh;
    int fii;
    MMSwitchBtn fxR;
    l fxS;
    String id;

    public void onCreate(Bundle bundle) {
        String format;
        super.onCreate(bundle);
        setBackBtn(new 1(this));
        int i = e.wxa_widget_debugger;
        Object[] objArr = new Object[1];
        if (((com.tencent.mm.modelappbrand.e) g.l(com.tencent.mm.modelappbrand.e.class)).JN().JQ()) {
            format = String.format("(%s)", new Object[]{c.afB()});
        } else {
            format = "";
        }
        objArr[0] = format;
        setMMTitle(getString(i, objArr));
        Intent intent = getIntent();
        this.id = intent.getStringExtra("id");
        this.appId = intent.getStringExtra("app_id");
        this.bPh = intent.getIntExtra("pkg_type", 0);
        this.fii = intent.getIntExtra("pkg_version", 0);
        setMMSubTitle(String.format("(%s)", new Object[]{this.id}));
        this.fxR = (MMSwitchBtn) findViewById(b.open_debug_btn);
        this.fxS = ((a) g.l(a.class)).abd().wg(this.appId);
        if (this.fxS == null) {
            this.fxS = new l();
            this.fxS.field_appId = this.appId;
        }
        this.fxR.setCheck(this.fxS.field_openDebug);
        this.fxR.setSwitchListener(new 2(this));
        TextView textView = (TextView) findViewById(b.inspect_guide_tv);
        CharSequence fromHtml = Html.fromHtml(getString(e.wxa_widget_open_inspect_guide), new com.tencent.mm.plugin.appbrand.dynamic.html.a(), new com.tencent.mm.plugin.appbrand.dynamic.html.b());
        if (fromHtml instanceof Spannable) {
            Spannable spannable = (Spannable) fromHtml;
            URLSpan[] uRLSpanArr = (URLSpan[]) spannable.getSpans(0, fromHtml.length(), URLSpan.class);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(fromHtml);
            for (URLSpan uRLSpan : uRLSpanArr) {
                spannableStringBuilder.removeSpan(uRLSpan);
                spannableStringBuilder.setSpan(new CustomURLSpan(uRLSpan.getURL()), spannable.getSpanStart(uRLSpan), spannable.getSpanEnd(uRLSpan), 34);
            }
            fromHtml = spannableStringBuilder;
        }
        textView.setText(fromHtml);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        findViewById(b.restart_support_process_btn).setOnClickListener(new 3(this));
        View findViewById = findViewById(b.widget_settings_btn);
        if (((com.tencent.mm.modelappbrand.e) g.l(com.tencent.mm.modelappbrand.e.class)).JN().JQ()) {
            findViewById.setVisibility(0);
            findViewById.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    Intent intent = new Intent(WxaWidgetDebugUI.this.mController.tml, WxaWidgetSettingsUI.class);
                    intent.putExtra("app_id", WxaWidgetDebugUI.this.appId);
                    intent.putExtra("pkg_type", WxaWidgetDebugUI.this.bPh);
                    intent.putExtra("pkg_version", WxaWidgetDebugUI.this.fii);
                    WxaWidgetDebugUI.this.startActivity(intent);
                }
            });
            return;
        }
        findViewById.setVisibility(8);
    }

    protected final int getLayoutId() {
        return b$c.wxa_widget_debug_ui;
    }
}

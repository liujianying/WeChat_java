package com.tencent.mm.plugin.webview.ui.tools;

import android.os.Bundle;

final class WebViewUI$d {
    private String jIA;
    private String jIB;
    private String jIw;
    private String jIx;
    private String jIy;
    private String jIz;
    private String lang;
    String qaF;

    private WebViewUI$d(Bundle bundle) {
        this.qaF = bundle.getString("close_window_confirm_dialog_switch");
        this.jIw = bundle.getString("close_window_confirm_dialog_title_cn");
        this.jIx = bundle.getString("close_window_confirm_dialog_title_eng");
        this.jIy = bundle.getString("close_window_confirm_dialog_ok_cn");
        this.jIz = bundle.getString("close_window_confirm_dialog_ok_eng");
        this.jIA = bundle.getString("close_window_confirm_dialog_cancel_cn");
        this.jIB = bundle.getString("close_window_confirm_dialog_cancel_eng");
        this.lang = bundle.getString("application_language");
    }

    public static WebViewUI$d W(Bundle bundle) {
        return new WebViewUI$d(bundle);
    }

    public final String bWI() {
        if ("zh_CN".equals(this.lang)) {
            return this.jIw;
        }
        return this.jIx;
    }

    public final String aSD() {
        if ("zh_CN".equals(this.lang)) {
            return this.jIy;
        }
        return this.jIz;
    }

    public final String aSE() {
        if ("zh_CN".equals(this.lang)) {
            return this.jIA;
        }
        return this.jIB;
    }
}

package com.tencent.xweb.x5;

import android.net.Uri;
import android.view.View;
import android.webkit.ConsoleMessage.MessageLevel;
import com.tencent.smtt.export.external.interfaces.ConsoleMessage;
import com.tencent.smtt.export.external.interfaces.GeolocationPermissionsCallback;
import com.tencent.smtt.export.external.interfaces.IX5WebChromeClient.CustomViewCallback;
import com.tencent.smtt.export.external.interfaces.JsPromptResult;
import com.tencent.smtt.export.external.interfaces.JsResult;
import com.tencent.smtt.sdk.ValueCallback;
import com.tencent.smtt.sdk.WebChromeClient.FileChooserParams;
import com.tencent.smtt.sdk.WebView;
import com.tencent.xweb.j;
import com.tencent.xweb.x5.g.c;
import com.tencent.xweb.x5.g.d;
import com.tencent.xweb.x5.g.e;
import com.tencent.xweb.x5.g.f;
import com.tencent.xweb.x5.g.g;
import org.xwalk.core.Log;

class j$1 extends b {
    final /* synthetic */ j vDW;

    j$1(j jVar) {
        this.vDW = jVar;
    }

    public final void onProgressChanged(WebView webView, int i) {
        Log.i("X5WebView", "onProgressChanged, progress = " + i);
        if (this.vDW.vDa != null) {
            this.vDW.vDa.a(this.vDW.vCX, i);
        } else {
            super.onProgressChanged(webView, i);
        }
    }

    public final void onReceivedTitle(WebView webView, String str) {
        Log.i("X5WebView", "onReceivedTitle: " + str);
        if (this.vDW.vDa != null) {
            this.vDW.vDa.d(this.vDW.vCX, str);
        } else {
            super.onReceivedTitle(webView, str);
        }
    }

    public final void onShowCustomView(View view, CustomViewCallback customViewCallback) {
        Log.i("X5WebView", "onShowCustomView");
        if (this.vDW.vDa != null) {
            this.vDW.vDa.onShowCustomView(view, new c(customViewCallback));
        } else {
            super.onShowCustomView(view, customViewCallback);
        }
    }

    public final void onHideCustomView() {
        Log.i("X5WebView", "onHideCustomView");
        if (this.vDW.vDa != null) {
            this.vDW.vDa.onHideCustomView();
        } else {
            super.onHideCustomView();
        }
    }

    public final boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
        Log.i("X5WebView", "onJsAlert");
        if (this.vDW.vDa != null) {
            return this.vDW.vDa.a(this.vDW.vCX, str, str2, new f(jsResult));
        }
        return super.onJsAlert(webView, str, str2, jsResult);
    }

    public final boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
        Log.i("X5WebView", "onJsConfirm");
        if (this.vDW.vDa != null) {
            return this.vDW.vDa.b(this.vDW.vCX, str, str2, new f(jsResult));
        }
        return super.onJsConfirm(webView, str, str2, jsResult);
    }

    public final boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        Log.i("X5WebView", "onJsPrompt");
        if (this.vDW.vDa == null) {
            return super.onJsPrompt(webView, str, str2, str3, jsPromptResult);
        }
        return this.vDW.vDa.a(this.vDW.vCX, str, str2, str3, new g(jsPromptResult));
    }

    public final void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissionsCallback geolocationPermissionsCallback) {
        Log.i("X5WebView", "onGeolocationPermissionsShowPrompt");
        if (this.vDW.vDa != null) {
            this.vDW.vDa.onGeolocationPermissionsShowPrompt(str, new e(geolocationPermissionsCallback));
        } else {
            super.onGeolocationPermissionsShowPrompt(str, geolocationPermissionsCallback);
        }
    }

    public final void onGeolocationPermissionsHidePrompt() {
        Log.i("X5WebView", "onGeolocationPermissionsHidePrompt");
        if (this.vDW.vDa == null) {
            super.onGeolocationPermissionsHidePrompt();
        }
    }

    public final boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        Log.i("X5WebView", "onConsoleMessage " + consoleMessage.message());
        if (this.vDW.vDa == null) {
            return super.onConsoleMessage(consoleMessage);
        }
        android.webkit.ConsoleMessage consoleMessage2;
        j jVar = this.vDW.vDa;
        if (consoleMessage == null) {
            consoleMessage2 = null;
        } else {
            MessageLevel messageLevel = MessageLevel.DEBUG;
            switch (consoleMessage.messageLevel()) {
                case DEBUG:
                    messageLevel = MessageLevel.DEBUG;
                    break;
                case ERROR:
                    messageLevel = MessageLevel.ERROR;
                    break;
                case LOG:
                    messageLevel = MessageLevel.LOG;
                    break;
                case TIP:
                    messageLevel = MessageLevel.TIP;
                    break;
                case WARNING:
                    messageLevel = MessageLevel.WARNING;
                    break;
            }
            consoleMessage2 = new android.webkit.ConsoleMessage(consoleMessage.message(), consoleMessage.sourceId(), consoleMessage.lineNumber(), messageLevel);
        }
        return jVar.onConsoleMessage(consoleMessage2);
    }

    public final void openFileChooser(ValueCallback<Uri> valueCallback, String str, String str2) {
        Log.i("X5WebView", "openFileChooser with three param");
        if (this.vDW.vDa != null) {
            this.vDW.vDa.openFileChooser(valueCallback, str, str2);
        } else {
            valueCallback.onReceiveValue(null);
        }
    }

    public final boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, FileChooserParams fileChooserParams) {
        Log.i("X5WebView", "onShowFileChooser last method");
        if (this.vDW.vDa != null) {
            return this.vDW.vDa.a(this.vDW.vCX, valueCallback, new d(fileChooserParams));
        }
        return super.onShowFileChooser(webView, new a.d(valueCallback), fileChooserParams);
    }

    public final View getVideoLoadingProgressView() {
        if (this.vDW.vDa != null) {
            return this.vDW.vDa.getVideoLoadingProgressView();
        }
        return super.getVideoLoadingProgressView();
    }
}

package com.tencent.mm.plugin.appbrand.jsapi.p;

import android.content.Intent;
import android.net.Uri;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.webkit.ValueCallback;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.jsapi.p.c.b;
import com.tencent.mm.plugin.webview.modeltools.c;
import com.tencent.mm.plugin.webview.modeltools.f;
import com.tencent.mm.plugin.webview.stub.d;
import com.tencent.mm.plugin.webview.ui.tools.widget.MMWebViewWithJsApi;
import com.tencent.mm.plugin.webview.ui.tools.widget.g;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.tools.k;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.WebView;

public class e implements OnCreateContextMenuListener, b {
    private String gcF;
    MMWebViewWithJsApi gcL;
    private b gcM;
    private a gcN;
    private d gcO;
    private com.tencent.mm.plugin.webview.ui.tools.e gcP;
    private k gcQ;
    private String gcR;
    int gcS;
    int gcT;
    f gcU;
    WebView.b gcV;
    WebView.b gcW;
    private final c gcX = new c();
    private final c.c gcY;
    private com.tencent.mm.plugin.webview.ui.tools.widget.k gcZ = new 1(this);
    private f.c gda = new 7(this);

    private class a extends g {
        a(MMWebViewWithJsApi mMWebViewWithJsApi) {
            super(mMWebViewWithJsApi);
        }

        public final void d(WebView webView, String str) {
            super.d(webView, str);
            e.this.gcY.ud(str);
        }

        protected final void onClose() {
            e.this.gcY.ako();
        }

        public final void openFileChooser(ValueCallback<Uri> valueCallback, String str, String str2) {
            a(valueCallback, null, str, str2);
        }

        public final boolean a(WebView webView, ValueCallback<Uri[]> valueCallback, com.tencent.xweb.j.a aVar) {
            if (aVar.getMode() != 0) {
                return false;
            }
            if (aVar.getAcceptTypes() == null || aVar.getAcceptTypes().length <= 0) {
                x.i("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "onShowFileChooser, mode = MODE_OPEN, but params.getAcceptTypes is null");
                return true;
            }
            String str = aVar.getAcceptTypes()[0];
            String str2 = "*";
            if (aVar.isCaptureEnabled()) {
                if ("image/*".equalsIgnoreCase(str)) {
                    str2 = "camera";
                } else if ("video/*".equalsIgnoreCase(str)) {
                    str2 = "camcorder";
                }
            }
            a(null, valueCallback, str, str2);
            return true;
        }

        private void a(ValueCallback<Uri> valueCallback, ValueCallback<Uri[]> valueCallback2, String str, String str2) {
            if (e.this.gcL.getContext() instanceof MMActivity) {
                MMActivity mMActivity = (MMActivity) e.this.gcL.getContext();
                mMActivity.geJ = new 1(this, mMActivity);
                e.this.gcX.a(mMActivity, e.this.gcP, valueCallback, valueCallback2, str, str2);
            }
        }
    }

    static /* synthetic */ void c(e eVar, String str) {
        Intent intent = new Intent();
        intent.putExtra("Retr_File_Name", str);
        intent.putExtra("Retr_Compress_Type", 0);
        intent.putExtra("Retr_Msg_Type", 0);
        if (intent.getIntExtra("Retr_Msg_Type", -1) < 0) {
            intent.putExtra("Retr_Msg_Type", 4);
        }
        com.tencent.mm.bg.d.e(eVar.gcL.getContext(), ".ui.transmit.MsgRetransmitUI", intent);
    }

    static /* synthetic */ void d(e eVar, String str) {
        try {
            if (eVar.gcO.QV(str) == 0) {
                Toast.makeText(eVar.gcL.getContext(), eVar.gcL.getContext().getString(R.l.favorite_ok), 0).show();
            }
        } catch (Exception e) {
            x.e("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "favoriteUrl fail, ex = " + e.getMessage());
        }
    }

    public e(c.c cVar) {
        this.gcY = cVar;
        this.gcL = (MMWebViewWithJsApi) cVar.getWebView();
        this.gcM = new b(this, this.gcL);
        this.gcN = new a(this.gcL);
        this.gcL.setWebViewClient(this.gcM);
        this.gcL.setWebChromeClient(this.gcN);
        this.gcL.setCleanOnDetached(true);
        this.gcQ = new k(this.gcL.getContext());
        this.gcQ.a(this.gcL, this, null);
        this.gcQ.d(new 2(this));
    }

    public final void cleanup() {
        this.gcM.cleanup();
        this.gcL.destroy();
    }

    private boolean a(ContextMenu contextMenu, String str) {
        boolean isSDCardAvailable;
        try {
            isSDCardAvailable = this.gcO.isSDCardAvailable();
        } catch (Exception e) {
            x.e("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "onCreateContextMenu fail, ex = " + e.getMessage());
            isSDCardAvailable = false;
        }
        if (!isSDCardAvailable) {
            return true;
        }
        if (this.gcP == null) {
            return true;
        }
        contextMenu.setHeaderTitle(R.l.wv_image);
        try {
            isSDCardAvailable = this.gcO.aSn();
        } catch (Exception e2) {
            x.e("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "get has setuin failed : %s", new Object[]{e2.getMessage()});
            isSDCardAvailable = false;
        }
        x.i("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "hasSetAcc = %b, canShareImage = %b, canFavImage = %b", new Object[]{Boolean.valueOf(isSDCardAvailable), Boolean.valueOf(this.gcP.bVS().cgj()), Boolean.valueOf(this.gcP.bVS().cgk())});
        if (isSDCardAvailable && r3) {
            contextMenu.add(0, 0, 0, this.gcL.getContext().getString(R.l.readerapp_alert_retransmit)).setOnMenuItemClickListener(new 3(this, str));
        }
        contextMenu.add(0, 0, 0, this.gcL.getContext().getString(R.l.save_to_local)).setOnMenuItemClickListener(new 4(this, str));
        if (isSDCardAvailable && r4) {
            contextMenu.add(0, 0, 0, this.gcL.getContext().getString(R.l.plugin_favorite_opt)).setOnMenuItemClickListener(new 5(this, str));
        }
        if (this.gcR == null) {
            return false;
        }
        CharSequence string;
        String str2 = this.gcR;
        if (com.tencent.mm.plugin.scanner.a.aB(this.gcS, this.gcR)) {
            string = this.gcL.getContext().getString(R.l.recog_wxcode_of_image_file);
        } else {
            string = this.gcL.getContext().getString(R.l.recog_qbar_of_image_file);
        }
        contextMenu.add(0, 0, 0, string).setOnMenuItemClickListener(new 6(this, str2, str));
        this.gcR = null;
        return true;
    }

    private void a(ContextMenu contextMenu, WebView.b bVar) {
        if (!a(contextMenu, bVar.mExtra) && this.gcP.bVS().cgh()) {
            this.gcW = bVar;
            this.gcU = new f();
            this.gcU.a(this.gcL, this.gda);
        }
    }

    private void b(ContextMenu contextMenu, WebView.b bVar) {
        if (!a(contextMenu, bVar.mExtra) && this.gcP.bVS().cgh()) {
            this.gcV = bVar;
            this.gcU = new f();
            this.gcU.a(this.gcL, this.gda);
        }
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        WebView.b hitTestResult;
        if (view instanceof android.webkit.WebView) {
            hitTestResult = this.gcL.getHitTestResult();
            if (hitTestResult != null) {
                if (hitTestResult.mType == 5 || hitTestResult.mType == 8) {
                    b(contextMenu, hitTestResult);
                }
            }
        } else if (view instanceof MMWebView) {
            hitTestResult = ((MMWebView) view).getHitTestResult();
            if (hitTestResult == null) {
                return;
            }
            if (hitTestResult.mType == 5 || hitTestResult.mType == 8) {
                a(contextMenu, hitTestResult);
            }
        }
    }
}

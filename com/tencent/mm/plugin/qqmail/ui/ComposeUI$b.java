package com.tencent.mm.plugin.qqmail.ui;

import android.content.Intent;
import android.graphics.Bitmap;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import com.tencent.xweb.WebView;
import com.tencent.xweb.p;
import java.net.URLDecoder;

class ComposeUI$b extends p {
    private boolean mfE;
    final /* synthetic */ ComposeUI mfs;

    private ComposeUI$b(ComposeUI composeUI) {
        this.mfs = composeUI;
        this.mfE = false;
    }

    /* synthetic */ ComposeUI$b(ComposeUI composeUI, byte b) {
        this(composeUI);
    }

    public final boolean b(WebView webView, String str) {
        x.d("MicroMsg.ComposeUI", "shouldOverrideUrlLoading, url = %s", new Object[]{str});
        String[] split;
        String str2;
        if (str.startsWith(ComposeUI.m(this.mfs))) {
            this.mfs.YC();
            try {
                split = URLDecoder.decode(str.substring(ComposeUI.m(this.mfs).length()), ProtocolPackage.ServerEncoding).split("@@")[0].split(":");
                String str3 = split[0];
                str2 = split[1];
                x.i("MicroMsg.ComposeUI", "img onclick, src: %s, msgLocalId: %s, msgSvrId: %s", new Object[]{r0[1], str3, str2});
                au.HU();
                bd dW = c.FT().dW((long) Integer.valueOf(str3).intValue());
                Intent intent = new Intent(this.mfs, MailImageDownloadUI.class);
                intent.putExtra("img_msg_id", dW.field_msgId);
                intent.putExtra("img_server_id", dW.field_msgSvrId);
                intent.putExtra("img_download_compress_type", 0);
                intent.putExtra("img_download_username", dW.field_talker);
                this.mfs.startActivity(intent);
            } catch (Exception e) {
                x.w("MicroMsg.ComposeUI", "shouldOverrideUrlLoading IMG_ONCLICK, ex = %s", new Object[]{e.getMessage()});
            }
        } else if (str.startsWith(ComposeUI.n(this.mfs))) {
            try {
                ComposeUI.a(this.mfs, URLDecoder.decode(str.substring(ComposeUI.n(this.mfs).length()), ProtocolPackage.ServerEncoding));
            } catch (Exception e2) {
                x.w("MicroMsg.ComposeUI", "shouldOverrideUrlLoading GET_MAIL_CONTENT, ex = %s", new Object[]{e2.getMessage()});
            }
            if (ComposeUI.o(this.mfs)) {
                if (ComposeUI.p(this.mfs).indexOf("<img") == -1) {
                    ComposeUI.q(this.mfs).clear();
                    ComposeUI.r(this.mfs);
                } else {
                    s.a(ComposeUI.s(this.mfs), ComposeUI.t(this.mfs), ComposeUI.u(this.mfs));
                }
            }
        } else if (str.startsWith(ComposeUI.t(this.mfs))) {
            ComposeUI.q(this.mfs).clear();
            try {
                String[] split2 = URLDecoder.decode(str.substring(ComposeUI.t(this.mfs).length()), ProtocolPackage.ServerEncoding).split("&&");
                for (String str22 : split2) {
                    split = str22.split("@@");
                    Object obj = split[0].split(":")[1];
                    Object obj2 = split[1];
                    if (obj2.startsWith("file://")) {
                        obj2 = obj2.replaceFirst("file://", "");
                    }
                    x.i("MicroMsg.ComposeUI", "put msgImgInfoMap, msgSvrId: %s, path: %s", new Object[]{obj, obj2});
                    ComposeUI.q(this.mfs).put(obj, obj2);
                }
                if (ComposeUI.o(this.mfs)) {
                    ComposeUI.r(this.mfs);
                }
            } catch (Exception e22) {
                x.w("MicroMsg.ComposeUI", "shouldOverrideUrlLoading GET_IMG_INFO, ex = %s", new Object[]{e22.getMessage()});
            }
        }
        return true;
    }

    public final void b(WebView webView, String str, Bitmap bitmap) {
        super.b(webView, str, bitmap);
        if (!ComposeUI.v(this.mfs)) {
            s.a(ComposeUI.s(this.mfs));
            ComposeUI.w(this.mfs);
        }
    }

    public final void a(WebView webView, String str) {
        x.d("MicroMsg.ComposeUI", "onPageFinished, url = %s, firstTimeLoaded = %b", new Object[]{str, Boolean.valueOf(this.mfE)});
        if (!this.mfE) {
            this.mfE = true;
            s.a(ComposeUI.s(this.mfs), ComposeUI.n(this.mfs), ComposeUI.x(this.mfs));
        }
        super.a(webView, str);
    }
}

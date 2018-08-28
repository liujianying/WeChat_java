package com.tencent.mm.plugin.qqmail.ui;

import android.content.Intent;
import android.webkit.ConsoleMessage;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;
import com.tencent.xweb.j;
import java.net.URLDecoder;

class ComposeUI$a extends j {
    final /* synthetic */ ComposeUI mfs;

    private ComposeUI$a(ComposeUI composeUI) {
        this.mfs = composeUI;
    }

    /* synthetic */ ComposeUI$a(ComposeUI composeUI, byte b) {
        this(composeUI);
    }

    @Deprecated
    public final boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        x.i("MicroMsg.ComposeUI", "console, consoleMessage: %s", new Object[]{consoleMessage});
        String Ug = s.Ug(consoleMessage != null ? consoleMessage.message() : null);
        String[] split;
        if (Ug.startsWith(ComposeUI.m(this.mfs))) {
            this.mfs.YC();
            try {
                String[] split2 = URLDecoder.decode(Ug.substring(ComposeUI.m(this.mfs).length()), "utf-8").split("@@")[0].split(":");
                String str = split2[0];
                String str2 = split2[1];
                x.i("MicroMsg.ComposeUI", "img onclick, src: %s, msgLocalId: %s, msgSvrId: %s", new Object[]{split[1], str, str2});
                au.HU();
                bd dW = c.FT().dW((long) Integer.valueOf(str).intValue());
                Intent intent = new Intent(this.mfs, MailImageDownloadUI.class);
                intent.putExtra("img_msg_id", dW.field_msgId);
                intent.putExtra("img_server_id", dW.field_msgSvrId);
                intent.putExtra("img_download_compress_type", 0);
                intent.putExtra("img_download_username", dW.field_talker);
                this.mfs.startActivity(intent);
                return true;
            } catch (Exception e) {
                x.w("MicroMsg.ComposeUI", "consoleMessage IMG_ONCLICK, ex = %s", new Object[]{e.getMessage()});
            }
        } else if (Ug.startsWith(ComposeUI.n(this.mfs))) {
            try {
                ComposeUI.a(this.mfs, URLDecoder.decode(Ug.substring(ComposeUI.n(this.mfs).length()), "utf-8"));
            } catch (Exception e2) {
                x.w("MicroMsg.ComposeUI", "consoleMessage GET_MAIL_CONTENT, ex = %s", new Object[]{e2.getMessage()});
            }
            if (ComposeUI.o(this.mfs)) {
                if (ComposeUI.p(this.mfs).indexOf("<img") == -1) {
                    ComposeUI.q(this.mfs).clear();
                    ComposeUI.r(this.mfs);
                    return true;
                }
                s.a(ComposeUI.s(this.mfs), ComposeUI.t(this.mfs), ComposeUI.u(this.mfs));
            }
            return true;
        } else {
            if (Ug.startsWith(ComposeUI.t(this.mfs))) {
                ComposeUI.q(this.mfs).clear();
                try {
                    String[] split3 = URLDecoder.decode(Ug.substring(ComposeUI.t(this.mfs).length()), "utf-8").split("&&");
                    for (String Ug2 : split3) {
                        split = Ug2.split("@@");
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
                    return true;
                } catch (Exception e22) {
                    x.w("MicroMsg.ComposeUI", "consoleMessage GET_IMG_INFO, ex = %s", new Object[]{e22.getMessage()});
                    return true;
                }
            }
            return super.onConsoleMessage(consoleMessage);
        }
    }
}

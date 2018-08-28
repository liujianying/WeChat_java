package com.tencent.mm.app;

import android.util.Base64;
import com.tencent.mm.sdk.platformtools.CrashMonitorForJni.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.xweb.WebView;
import java.util.Locale;

class k$1 implements a {
    k$1() {
    }

    public final String va() {
        StringBuilder stringBuilder = new StringBuilder();
        String processName = ad.getProcessName();
        if (processName != null && (processName.contains(":tools") || processName.contains(":appbrand"))) {
            stringBuilder.append("\n");
            processName = WebView.getCrashExtraMessage(ad.getContext());
            if (processName != null && processName.length() > 0) {
                processName = processName + String.format(Locale.US, "client_version:%s;", new Object[]{d.CLIENT_VERSION});
                if (processName.length() > 8192) {
                    processName = processName.substring(processName.length() - 8192);
                }
                stringBuilder.append("#qbrowser.crashmsg=" + Base64.encodeToString(processName.getBytes(), 2));
                x.v("MicroMsg.MMCrashReporter", "header #qbrowser.crashmsg=%s", new Object[]{processName});
            }
        }
        return stringBuilder.toString();
    }
}

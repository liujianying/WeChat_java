package com.tencent.smtt.sdk;

import com.tencent.smtt.utils.TbsLog;

final class bu extends Thread {
    bu() {
    }

    public final void run() {
        if (WebView.h() == null) {
            TbsLog.d("TbsNeedReboot", "WebView.updateNeeeRebootStatus--mAppContext == null");
            return;
        }
        o a = o.a(true);
        if (o.a) {
            TbsLog.d("TbsNeedReboot", "WebView.updateNeeeRebootStatus--needReboot = true");
            return;
        }
        ai a2 = ai.a(WebView.h());
        int c = a2.c();
        TbsLog.d("TbsNeedReboot", "WebView.updateNeeeRebootStatus--installStatus = " + c);
        if (c == 2) {
            TbsLog.d("TbsNeedReboot", "WebView.updateNeeeRebootStatus--install setTbsNeedReboot true");
            a.a(String.valueOf(a2.b()));
            a.b(true);
            return;
        }
        int b = a2.b("copy_status");
        TbsLog.d("TbsNeedReboot", "WebView.updateNeeeRebootStatus--copyStatus = " + b);
        if (b == 1) {
            TbsLog.d("TbsNeedReboot", "WebView.updateNeeeRebootStatus--copy setTbsNeedReboot true");
            a.a(String.valueOf(a2.c("copy_core_ver")));
            a.b(true);
        } else if (!bv.a().b()) {
            if (c == 3 || b == 3) {
                TbsLog.d("TbsNeedReboot", "WebView.updateNeeeRebootStatus--setTbsNeedReboot true");
                a.a(String.valueOf(o.d()));
                a.b(true);
            }
        }
    }
}

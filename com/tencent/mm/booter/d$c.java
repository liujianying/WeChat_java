package com.tencent.mm.booter;

import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Process;
import com.tencent.mm.app.ToolsProfile;
import com.tencent.mm.booter.MMReceivers.a;
import com.tencent.mm.plugin.websearch.api.z;
import com.tencent.mm.pluginsdk.model.u;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.xweb.x5.sdk.d;
import java.util.Locale;

public class d$c implements a {
    public final void onReceive(Context context, Intent intent) {
        if (context != null && intent != null) {
            String stringExtra = intent.getStringExtra("tools_process_action_code_key");
            x.i("MicroMsg.ToolsProcessReceiver", "onReceive, action = " + stringExtra);
            if (stringExtra.equals("com.tencent.mm.intent.ACTION_KILL_TOOLS_PROCESS")) {
                x.chS();
                x.i("MicroMsg.ToolsProcessReceiver", "onReceive, ACTION_KILL_TOOLS_PROCESS, x5 kernel video isLocked = %b", new Object[]{Boolean.valueOf(ToolsProfile.a.isLocked())});
                if (!ToolsProfile.a.isLocked()) {
                    Process.killProcess(Process.myPid());
                }
            } else if (stringExtra.equals("com.tencent.mm.intent.ACTION_RELOAD_RESOURCES")) {
                String stringExtra2 = intent.getStringExtra("tools_language");
                x.i("MicroMsg.ToolsProcessReceiver", "onReceive, language %s", new Object[]{stringExtra2});
                Locale Wl = w.Wl(stringExtra2);
                if ("language_default".equalsIgnoreCase(stringExtra2)) {
                    if (VERSION.SDK_INT >= 24) {
                        Wl = w.sGk;
                        Locale.setDefault(Wl);
                    } else {
                        Wl = Locale.getDefault();
                    }
                }
                w.a(context.getApplicationContext(), Wl);
                ad.a(com.tencent.mm.bq.a.a(context.getApplicationContext().getResources(), context.getApplicationContext(), stringExtra2));
            } else if (stringExtra.equals("com.tencent.mm.intent.ACTION_TOOLS_REMOVE_COOKIE")) {
                try {
                    d.clearAllWebViewCache(context.getApplicationContext(), true);
                } catch (Exception e) {
                    x.i("MicroMsg.ToolsProcessReceiver", "clear cookie faild : " + e.getMessage());
                }
            } else if (!stringExtra.equals("com.tencent.mm.intent.ACIONT_TOOLS_LOAD_DEX")) {
                if (stringExtra.equals("com.tencent.mm.intent.ACTION_CLEAR_WEBVIEW_CACHE")) {
                    x.i("MicroMsg.ToolsProcessReceiver", "WebViewCacheClearTask, clearAllWebViewCache, includeCookie = %b", new Object[]{Boolean.valueOf(intent.getBooleanExtra("tools_clean_webview_cache_ignore_cookie", true))});
                    if (intent.getBooleanExtra("tools_clean_webview_cache_ignore_cookie", true)) {
                        d.clearAllWebViewCache(context.getApplicationContext(), true);
                    } else {
                        d.clearAllWebViewCache(context.getApplicationContext(), false);
                    }
                } else if (stringExtra.equals("com.tencent.mm.intent.ACTION_START_TOOLS_PROCESS")) {
                    x.i("MicroMsg.ToolsProcessReceiver", "start tools process task, try to pre load tbs");
                } else if (stringExtra.equals("com.tencent.mm.intent.ACTION_START_TOOLS_PROCESS_DO_NOTHING")) {
                    x.i("MicroMsg.ToolsProcessReceiver", "start tools process and do nothing");
                } else if (stringExtra.equals("com.tencent.mm.intent.ACTION_CHECK_MINIQB_CAN_OPEN_FILE")) {
                    u.al(intent);
                } else if (stringExtra.equals("com.tencent.mm.intent.ACTION_PRELOAD_DISCOVERY_RECOMMEND")) {
                    z.bTc().cu(intent.getStringExtra("tools_param_preload_url"), 2);
                } else if (stringExtra.equals("com.tencent.mm.intent.ACTION_PRELOAD_DISCOVERY_SEARCH")) {
                    z.bTc().cu(intent.getStringExtra("tools_param_preload_url"), 1);
                } else if (stringExtra.equals("com.tencent.mm.intent.ACTION_PRELOAD_SET_SWITCH")) {
                    z.bTc().jP(intent.getBooleanExtra("tools_param_preload_switch", false));
                } else if (stringExtra.equals("com.tencent.mm.intent.ACTION_PRELOAD_SEARCH")) {
                    z.bTc().ai(intent);
                }
            }
        }
    }
}

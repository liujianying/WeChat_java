package com.tencent.mm.plugin.websearch.api;

import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.os.IBinder;
import android.text.TextUtils;
import com.tencent.mm.pluginsdk.model.u;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.e.i;

public class ToolsProcessStarterService extends Service {
    public IBinder onBind(Intent intent) {
        return null;
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        if (intent == null) {
            return super.onStartCommand(intent, i, i2);
        }
        String stringExtra = intent.getStringExtra("tools_process_action_code_key");
        if (TextUtils.isEmpty(stringExtra)) {
            return super.onStartCommand(intent, i, i2);
        }
        x.i("ToolsProcessStarterService", "onStartCommand, action = " + stringExtra);
        if (stringExtra.equals("com.tencent.mm.intent.ACTION_START_TOOLS_PROCESS")) {
            x.i("ToolsProcessStarterService", "start tools process task, try to pre load tbs");
        } else if (stringExtra.equals("com.tencent.mm.intent.ACTION_START_TOOLS_PROCESS_DO_NOTHING")) {
            x.i("ToolsProcessStarterService", "start tools process and do nothing");
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
        return super.onStartCommand(intent, i, i2);
    }

    public static void af(Intent intent) {
        intent.setComponent(new ComponentName(i.thA, "com.tencent.mm.plugin.websearch.api.ToolsProcessStarterService"));
        ad.getContext().startService(intent);
    }
}

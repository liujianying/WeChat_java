package com.tencent.mm.plugin.webview.luggage.ipc;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class LuggageMainProcessService extends Service {
    public IBinder onBind(Intent intent) {
        return null;
    }
}

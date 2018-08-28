package com.tencent.mm.plugin.appbrand.debugger;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.mm.kernel.c.a;
import com.tencent.mm.kernel.c.b;
import com.tencent.mm.sdk.platformtools.MultiProcessSharedPreferences;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bj;
import com.tencent.mm.sdk.platformtools.d;
import java.util.HashMap;
import java.util.Map;

public final class DebuggerShell extends BroadcastReceiver implements a, b {
    private static boolean fst;
    private final Map<String, a> fss = new HashMap();

    public final void onReceive(Context context, Intent intent) {
        String stringExtra = intent.getStringExtra("action");
        if (!bi.oW(stringExtra) && this.fss.containsKey(stringExtra)) {
            ((a) this.fss.get(stringExtra)).s(intent);
        }
    }

    public final void ET() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.tencent.mm.appbrand.debugger");
        ad.getContext().registerReceiver(this, intentFilter);
        a(new b());
        a(new c());
        a(new e());
    }

    public final void EU() {
        ad.getContext().unregisterReceiver(this);
        this.fss.clear();
    }

    private void a(a aVar) {
        if (!bi.oW(aVar.name())) {
            this.fss.put(aVar.name(), aVar);
        }
    }

    public static boolean aeq() {
        return fst;
    }

    public static boolean aer() {
        return fst || bj.cjh();
    }

    static {
        fst = false;
        if (d.sFy || bj.cjh()) {
            fst = MultiProcessSharedPreferences.getSharedPreferences(ad.getContext(), "ENABLE_APPBRAND_DEBUGGER", 0).getBoolean("ENABLE_APPBRAND_DEBUGGER", false);
        }
    }

    public static void aes() {
        MultiProcessSharedPreferences.getSharedPreferences(ad.getContext(), "ENABLE_APPBRAND_DEBUGGER", 0).edit().putBoolean("ENABLE_APPBRAND_DEBUGGER", true).apply();
        fst = true;
    }

    public static void aet() {
        MultiProcessSharedPreferences.getSharedPreferences(ad.getContext(), "ENABLE_APPBRAND_DEBUGGER", 0).edit().putBoolean("ENABLE_APPBRAND_DEBUGGER", false).apply();
        fst = false;
    }
}

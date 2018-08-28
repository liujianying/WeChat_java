package com.tinkerboots.sdk.a.a;

import android.content.Context;
import com.tinkerboots.sdk.b.b;
import com.tinkerboots.sdk.b.c;
import java.util.Map;

public class a implements b {
    public boolean aWu() {
        Context context = b.getContext();
        com.tencent.tinker.lib.e.a hL = com.tencent.tinker.lib.e.a.hL(context);
        if (!com.tinkerboots.sdk.b.a.isConnected(context)) {
            com.tencent.tinker.lib.f.a.i("Tinker.PatchRequestCallback", "TinkerBootsRequestCallback: beforePatchRequest return false, not connect to internet", new Object[0]);
            return false;
        } else if (com.tencent.tinker.lib.f.b.hN(context)) {
            com.tencent.tinker.lib.f.a.i("Tinker.PatchRequestCallback", "TinkerBootsRequestCallback: beforePatchRequest return false, tinker service is running", new Object[0]);
            return false;
        } else if (!hL.ons) {
            com.tencent.tinker.lib.f.a.i("Tinker.PatchRequestCallback", "TinkerBootsRequestCallback: beforePatchRequest return false, only request on the main process", new Object[0]);
            return false;
        } else if (!c.cJF()) {
            return true;
        } else {
            com.tencent.tinker.lib.f.a.e("Tinker.PatchRequestCallback", "TinkerBootsRequestCallback: beforePatchRequest return false, is in ignore channel, current channel:%s", new Object[]{c.cJE()});
            return false;
        }
    }

    public void E(Map<String, String> map) {
    }

    public void aWv() {
    }
}

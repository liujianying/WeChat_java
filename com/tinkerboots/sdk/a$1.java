package com.tinkerboots.sdk;

import android.content.SharedPreferences;
import android.os.MessageQueue.IdleHandler;
import com.tinkerboots.sdk.a.a;
import com.tinkerboots.sdk.b.b;

class a$1 implements IdleHandler {
    final /* synthetic */ boolean vFX;
    final /* synthetic */ a vFY;

    a$1(a aVar, boolean z) {
        this.vFY = aVar;
        this.vFX = z;
    }

    public final boolean queueIdle() {
        a aVar = this.vFY.vFW;
        boolean z = this.vFX;
        SharedPreferences sharedPreferences = b.getContext().getSharedPreferences("patch_server_config", 0);
        long j = sharedPreferences.getLong("fetch_patch_last_check", 0);
        if (j == -1) {
            com.tencent.tinker.lib.f.a.i("Tinker.ServerClient", "tinker sync is disabled, with never check flag!", new Object[0]);
        } else {
            j = System.currentTimeMillis() - j;
            if (z || aVar.isDebug || j >= aVar.fqj) {
                sharedPreferences.edit().putLong("fetch_patch_last_check", System.currentTimeMillis()).commit();
                com.tinkerboots.sdk.a.b.a aVar2 = aVar.vGd;
                com.tinkerboots.sdk.a.a.b bVar = aVar.vGb;
                if (bVar == null) {
                    throw new RuntimeException("callback can't be null");
                } else if (bVar.aWu()) {
                    bVar.aWv();
                    bVar.E(aVar2.vGe.vGf);
                }
            } else {
                com.tencent.tinker.lib.f.a.i("Tinker.ServerClient", "tinker sync should wait interval %ss", new Object[]{Long.valueOf((aVar.fqj - j) / 1000)});
            }
        }
        return false;
    }
}

package com.tencent.mm.plugin.hp.tinker;

import android.content.Context;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class g {
    public static boolean ar(Context context, String str) {
        String string = context.getSharedPreferences("tinker_patch_share_config", 4).getString("tinker_before_install", "");
        x.i("MicroMsg.Tinker.TinkerPatchSharedPreferencesUtil", "isBeforeDownloadDialogHaveCancel current patchID :%s patchID:%s", new Object[]{string, str});
        if (bi.oW(string) || bi.oW(str) || !string.equalsIgnoreCase(str)) {
            return false;
        }
        return true;
    }

    public static void as(Context context, String str) {
        context.getSharedPreferences("tinker_patch_share_config", 4).edit().putString("tinker_before_install", str).apply();
    }

    public static void dI(Context context) {
        int i = com.tencent.mm.k.g.AT().getInt("TinkerCheckUpdateInterval", 12);
        if (i < 0) {
            x.i("MicroMsg.Tinker.TinkerPatchSharedPreferencesUtil", "saveTinkerCheckUpdateTinker hours < 0 ");
            return;
        }
        x.i("MicroMsg.Tinker.TinkerPatchSharedPreferencesUtil", "saveTinkerCheckUpdateTinker hours:%d", new Object[]{Integer.valueOf(i)});
        context.getSharedPreferences("tinker_patch_share_config", 4).edit().putInt("check_tinker_update_interval", i).apply();
    }

    public static int dJ(Context context) {
        return context.getSharedPreferences("tinker_patch_share_config", 4).getInt("check_tinker_update_interval", 12);
    }

    public static void at(Context context, String str) {
        context.getSharedPreferences("tinker_patch_share_config", 4).edit().putString("tinker_node", str).apply();
    }

    public static void G(Context context, int i) {
        context.getSharedPreferences("tinker_patch_share_config", 4).edit().putInt("tinker_node_retry_time", i).apply();
    }
}

package com.tencent.mm.plugin.game.model.a;

import android.database.Cursor;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class f extends i<c> {
    public static final String[] diD = new String[]{i.a(c.dhO, "GameSilentDownload")};

    public f(e eVar) {
        super(eVar, c.dhO, "GameSilentDownload", null);
    }

    public final c DC(String str) {
        if (bi.oW(str)) {
            x.i("MicroMsg.GameSilentDownloadStorage", "getDownloadInfo: appid is null");
            return null;
        }
        Cursor rawQuery = rawQuery(String.format("select * from %s where %s=?", new Object[]{"GameSilentDownload", "appId"}), new String[]{str});
        if (rawQuery == null) {
            x.i("MicroMsg.GameSilentDownloadStorage", "cursor is null");
            return null;
        } else if (rawQuery.moveToFirst()) {
            c cVar = new c();
            cVar.d(rawQuery);
            rawQuery.close();
            return cVar;
        } else {
            x.i("MicroMsg.GameSilentDownloadStorage", "getDownloadInfo appid:%s, no record in DB", new Object[]{str});
            rawQuery.close();
            return null;
        }
    }

    public final boolean E(String str, long j) {
        if (bi.oW(str) || j < 0) {
            x.i("MicroMsg.GameSilentDownloadStorage", "updateNextCheckTime: appid is null");
            return false;
        }
        x.i("MicroMsg.GameSilentDownloadStorage", "updateNextCheckTime ret:%b", new Object[]{Boolean.valueOf(fV("GameSilentDownload", String.format("update %s set %s=%s where %s='%s'", new Object[]{"GameSilentDownload", "nextCheckTime", String.valueOf(j), "appId", str})))});
        return fV("GameSilentDownload", String.format("update %s set %s=%s where %s='%s'", new Object[]{"GameSilentDownload", "nextCheckTime", String.valueOf(j), "appId", str}));
    }

    public final boolean ay(String str, boolean z) {
        if (bi.oW(str)) {
            x.i("MicroMsg.GameSilentDownloadStorage", "updateRunningState: appid is null");
            return false;
        }
        c DC = DC(str);
        if (DC == null) {
            return false;
        }
        DC.field_isRunning = z;
        x.i("MicroMsg.GameSilentDownloadStorage", "updateRunningState, ret:%b", new Object[]{Boolean.valueOf(super.c(DC, new String[0]))});
        return super.c(DC, new String[0]);
    }

    public final boolean DD(String str) {
        if (bi.oW(str)) {
            x.i("MicroMsg.GameSilentDownloadStorage", "updateWifiState: appid is null");
            return false;
        }
        c DC = DC(str);
        if (DC == null) {
            return false;
        }
        DC.field_noWifi = false;
        x.i("MicroMsg.GameSilentDownloadStorage", "updateWifiState, ret:%b", new Object[]{Boolean.valueOf(super.c(DC, new String[0]))});
        return super.c(DC, new String[0]);
    }

    public final boolean DE(String str) {
        if (bi.oW(str)) {
            x.i("MicroMsg.GameSilentDownloadStorage", "updateSdcardAvailableState: appid is null");
            return false;
        }
        c DC = DC(str);
        if (DC == null) {
            return false;
        }
        DC.field_noSdcard = false;
        x.i("MicroMsg.GameSilentDownloadStorage", "updateSdcardAvailableState, ret:%b", new Object[]{Boolean.valueOf(super.c(DC, new String[0]))});
        return super.c(DC, new String[0]);
    }

    public final boolean DF(String str) {
        if (bi.oW(str)) {
            x.i("MicroMsg.GameSilentDownloadStorage", "updateSdcardSpaceState: appid is null");
            return false;
        }
        c DC = DC(str);
        if (DC == null) {
            return false;
        }
        DC.field_noEnoughSpace = false;
        x.i("MicroMsg.GameSilentDownloadStorage", "updateSdcardSpaceState, ret:%b", new Object[]{Boolean.valueOf(super.c(DC, new String[0]))});
        return super.c(DC, new String[0]);
    }

    public final boolean DG(String str) {
        if (bi.oW(str)) {
            x.i("MicroMsg.GameSilentDownloadStorage", "updateBatteryState: appid is null");
            return false;
        }
        c DC = DC(str);
        if (DC == null) {
            return false;
        }
        DC.field_lowBattery = false;
        x.i("MicroMsg.GameSilentDownloadStorage", "updateBatteryState, ret:%b", new Object[]{Boolean.valueOf(super.c(DC, new String[0]))});
        return super.c(DC, new String[0]);
    }

    public final boolean DH(String str) {
        if (bi.oW(str)) {
            x.i("MicroMsg.GameSilentDownloadStorage", "updateDelayState: appid is null");
            return false;
        }
        c DC = DC(str);
        if (DC == null) {
            return false;
        }
        DC.field_continueDelay = false;
        x.i("MicroMsg.GameSilentDownloadStorage", "updateDelayState, ret:%b", new Object[]{Boolean.valueOf(super.c(DC, new String[0]))});
        return super.c(DC, new String[0]);
    }
}

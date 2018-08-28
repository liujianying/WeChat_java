package com.tencent.mm.plugin.game.gamewebview.model;

import android.os.Bundle;
import com.tencent.mm.plugin.downloader.c.a;
import com.tencent.mm.plugin.downloader.model.c;
import com.tencent.mm.plugin.downloader.model.l;
import com.tencent.mm.sdk.platformtools.x;

public final class e implements l {
    public final void onTaskStarted(long j, String str) {
        Bundle bundle = new Bundle();
        bundle.putInt("mm_to_client_notify_type", 1);
        bundle.putString("js_event_name", "wxdownload:state_change");
        bundle.putString("state", "download_start");
        a cs = c.cs(j);
        bundle.putString("appid", cs != null ? cs.field_appId : "");
        bundle.putLong("download_id", j);
        com.tencent.mm.plugin.game.gamewebview.ipc.a.z(bundle);
    }

    public final void b(long j, String str, boolean z) {
        Bundle bundle = new Bundle();
        bundle.putInt("mm_to_client_notify_type", 1);
        bundle.putString("js_event_name", "wxdownload:state_change");
        bundle.putString("state", "download_succ");
        a cs = c.cs(j);
        bundle.putString("appid", cs != null ? cs.field_appId : "");
        bundle.putLong("download_id", j);
        com.tencent.mm.plugin.game.gamewebview.ipc.a.z(bundle);
    }

    public final void b(long j, int i, boolean z) {
        Bundle bundle = new Bundle();
        bundle.putInt("mm_to_client_notify_type", 1);
        bundle.putString("js_event_name", "wxdownload:state_change");
        bundle.putString("state", "download_fail");
        bundle.putInt("err_code", i);
        a cs = c.cs(j);
        bundle.putString("appid", cs != null ? cs.field_appId : "");
        bundle.putLong("download_id", j);
        com.tencent.mm.plugin.game.gamewebview.ipc.a.z(bundle);
    }

    public final void onTaskRemoved(long j) {
        Bundle bundle = new Bundle();
        bundle.putInt("mm_to_client_notify_type", 1);
        bundle.putString("js_event_name", "wxdownload:state_change");
        bundle.putString("state", "download_removed");
        a cs = c.cs(j);
        bundle.putString("appid", cs != null ? cs.field_appId : "");
        bundle.putLong("download_id", j);
        com.tencent.mm.plugin.game.gamewebview.ipc.a.z(bundle);
    }

    public final void onTaskPaused(long j) {
        Bundle bundle = new Bundle();
        bundle.putInt("mm_to_client_notify_type", 1);
        bundle.putString("js_event_name", "wxdownload:state_change");
        bundle.putString("state", "download_pause");
        a cs = c.cs(j);
        bundle.putString("appid", cs != null ? cs.field_appId : "");
        bundle.putLong("download_id", j);
        com.tencent.mm.plugin.game.gamewebview.ipc.a.z(bundle);
    }

    public final void bP(long j) {
        Bundle bundle = new Bundle();
        bundle.putInt("mm_to_client_notify_type", 1);
        bundle.putString("js_event_name", "wxdownload:progress_change");
        a cs = c.cs(j);
        if (cs == null || cs.field_totalSize == 0) {
            x.w("MicroMsg.GameWebViewDownloadEventBus", "loadDownloadProgress failed, downloadId = " + j);
            return;
        }
        bundle.putInt("progress", (int) ((((double) cs.field_downloadedSize) / ((double) cs.field_totalSize)) * 100.0d));
        bundle.putString("appid", cs.field_appId);
        bundle.putLong("download_id", j);
        com.tencent.mm.plugin.game.gamewebview.ipc.a.z(bundle);
    }

    public final void h(long j, String str) {
        Bundle bundle = new Bundle();
        bundle.putInt("mm_to_client_notify_type", 1);
        bundle.putString("js_event_name", "wxdownload:state_change");
        bundle.putString("state", "download_resumed");
        a cs = c.cs(j);
        bundle.putString("appid", cs != null ? cs.field_appId : "");
        bundle.putLong("download_id", j);
        com.tencent.mm.plugin.game.gamewebview.ipc.a.z(bundle);
    }
}

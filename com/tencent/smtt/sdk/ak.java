package com.tencent.smtt.sdk;

import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.l;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.m.a;

final class ak implements a {
    final /* synthetic */ TbsDownloadConfig a;
    final /* synthetic */ boolean b;

    ak(TbsDownloadConfig tbsDownloadConfig, boolean z) {
        this.a = tbsDownloadConfig;
        this.b = z;
    }

    public final void a(int i) {
        TbsLog.i("TbsDownload", "[TbsDownloader.sendRequest] httpResponseCode=" + i);
        if (TbsShareManager.isThirdPartyApp(TbsDownloader.a()) && i == HardCoderJNI.sHCDBDELAY_WRITE) {
            this.a.a.put("last_request_success", Long.valueOf(System.currentTimeMillis()));
            this.a.a.put("request_fail", Long.valueOf(0));
            this.a.a.put("count_request_fail_in_24hours", Long.valueOf(0));
            this.a.commit();
        }
        if (i < l.CTRL_BYTE) {
            return;
        }
        if (this.b) {
            this.a.setDownloadInterruptCode(-107);
        } else {
            this.a.setDownloadInterruptCode(-207);
        }
    }
}

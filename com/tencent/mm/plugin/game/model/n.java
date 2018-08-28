package com.tencent.mm.plugin.game.model;

import android.content.Context;
import com.tencent.mm.a.e;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.downloader.model.d;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.x;

public final class n {
    public d jMa;
    public boolean jMb = false;
    public int mode = 1;
    public int progress = 0;
    public int status = 0;

    public n(d dVar) {
        this.jMa = dVar;
    }

    public final void dC(Context context) {
        if (this.jMa != null) {
            int i = this.jMa.cmN;
            int i2 = this.jMa.cmN;
            x.i("MicroMsg.GameDownloadInfo", "AppId: %s, Initial downloadMode: %d", new Object[]{this.jMa.field_appId, Integer.valueOf(i)});
            if (i == 2) {
                i2 = 3;
            }
            if (i2 == 3 && !g.r(context, "wx3909f6add1206543")) {
                i2 = 1;
            }
            if (i2 != 1) {
                FileDownloadTaskInfo yO = d.aCU().yO(this.jMa.field_appId);
                if (yO.status == 1 || yO.status == 2 || yO.status == 3) {
                    i2 = 1;
                }
            }
            this.mode = i2;
            x.i("MicroMsg.GameDownloadInfo", "AppId: %s, Final downloadMode: %d", new Object[]{this.jMa.field_appId, Integer.valueOf(i2)});
        }
    }

    public final void aTT() {
        if (this.jMa != null) {
            switch (this.mode) {
                case 1:
                    FileDownloadTaskInfo yO = d.aCU().yO(this.jMa.field_appId);
                    if (yO.gTK != 0) {
                        this.progress = (int) ((((double) yO.icq) / ((double) yO.gTK)) * 100.0d);
                    } else {
                        this.progress = 0;
                    }
                    x.d("MicroMsg.GameDownloadInfo", "status = " + yO.status);
                    switch (yO.status) {
                        case 0:
                            this.status = 0;
                            break;
                        case 1:
                            this.status = 1;
                            break;
                        case 2:
                            this.status = 2;
                            break;
                        case 3:
                            if (!e.cn(yO.path)) {
                                this.status = 0;
                                break;
                            } else {
                                this.status = 3;
                                break;
                            }
                        case 4:
                            if (this.progress != 0 && !ao.isConnected(ad.getContext())) {
                                this.status = 2;
                                break;
                            } else {
                                this.status = 0;
                                break;
                            }
                            break;
                        default:
                            this.status = 0;
                            break;
                    }
                default:
                    this.status = 0;
                    break;
            }
            x.i("MicroMsg.GameDownloadInfo", "Updating Download Status, AppId: %s, downloadMode: %d, downloadStatus: %d", new Object[]{this.jMa.field_appId, Integer.valueOf(this.mode), Integer.valueOf(this.status)});
        }
    }

    public final void aTU() {
        this.mode = 1;
        this.jMb = true;
    }
}

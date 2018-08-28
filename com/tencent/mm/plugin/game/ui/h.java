package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.net.Uri;
import android.view.View;
import android.widget.Toast;
import com.tencent.mm.a.e;
import com.tencent.mm.plugin.game.e.c;
import com.tencent.mm.plugin.game.f.b;
import com.tencent.mm.plugin.game.f.i;
import com.tencent.mm.plugin.game.model.an;
import com.tencent.mm.plugin.game.model.d;
import com.tencent.mm.plugin.game.model.f;
import com.tencent.mm.plugin.game.model.m;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.q;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;

public final class h extends c {
    public h(Context context) {
        super(context);
    }

    public final void dc(String str, String str2) {
        this.jTR = str;
        this.jTS = str2;
    }

    public final void onClick(View view) {
        if (view.getTag() instanceof d) {
            this.jMa = (d) view.getTag();
            x.i("MicroMsg.GameClickListener", "Clicked appid = " + this.jMa.field_appId);
            aUJ();
            if (g.r(this.mContext, this.jMa.field_appId)) {
                int i;
                int i2;
                if (this.jMa instanceof d) {
                    int DP = c.DP(this.jMa.field_packageName);
                    i = this.jMa.versionCode;
                    i2 = DP;
                } else {
                    i = 0;
                    i2 = 0;
                }
                if (i > i2) {
                    x.i("MicroMsg.GameClickListener", "AppId: %s installed, local: %d, server: %d", new Object[]{this.jMa.field_appId, Integer.valueOf(i2), Integer.valueOf(i)});
                    m.a(this.jMa.cmE, this.jMa.cmJ, this.jMa.bYq, this.jMa.field_appId, this.jTQ, "app_update");
                    if (this.jTO.status == 1) {
                        x.i("MicroMsg.GameClickListener", "pauseDownloadTask ret = " + com.tencent.mm.plugin.downloader.model.d.aCU().cn(this.jTO.id));
                        return;
                    } else if (this.jTO.status == 2) {
                        if (com.tencent.mm.plugin.downloader.model.d.aCU().co(this.jTO.id)) {
                            f.ai(this.mContext, this.jMa.field_appId);
                            an.a(this.mContext, this.jMa.scene, this.jMa.bYq, this.jMa.position, 4, this.jMa.field_appId, this.jNv, this.jMa.bHF, this.jTR);
                            return;
                        }
                        x.e("MicroMsg.GameClickListener", "resumeDownloadTask false");
                        fw(true);
                        return;
                    } else if (this.jTO.status != 3) {
                        fw(true);
                        return;
                    } else if (!e.cn(this.jTO.path) || c.DQ(this.jTO.path) <= i2) {
                        fw(true);
                        return;
                    } else {
                        q.g(this.mContext, Uri.fromFile(new File(this.jTO.path)));
                        an.a(this.mContext, this.jMa.scene, this.jMa.bYq, this.jMa.position, 8, this.jMa.field_appId, this.jNv, this.jMa.bHF, this.jTR);
                        return;
                    }
                }
                x.i("MicroMsg.GameClickListener", "launchFromWX, appId = %s, pkg = %s, openId = %s", new Object[]{this.jMa.field_appId, this.jMa.field_packageName, this.jMa.field_openId});
                an.a(this.mContext, this.jMa.scene, this.jMa.bYq, this.jMa.position, 3, this.jMa.field_appId, this.jNv, this.jMa.bHF, this.jTR);
                aUI();
                return;
            } else if (this.jMa.aTx()) {
                c.r(this.mContext, this.jMa.jLx.jSu, "game_center_hv_game");
                an.a(this.mContext, this.jMa.scene, this.jMa.bYq, this.jMa.position, 29, this.jMa.field_appId, this.jNv, this.jMa.bHF, this.jTR);
                return;
            } else {
                m.a(this.jMa.cmE, this.jMa.cmJ, this.jMa.bYq, this.jMa.field_appId, this.jTQ, this.jTS);
                switch (this.mStatus) {
                    case 1:
                        x.i("MicroMsg.GameClickListener", "pauseDownloadTask ret = " + com.tencent.mm.plugin.downloader.model.d.aCU().cn(this.jTO.id));
                        return;
                    case 2:
                        if (!ao.isNetworkConnected(this.mContext)) {
                            Toast.makeText(this.mContext, this.mContext.getString(i.game_download_network_unavailable), 0).show();
                            return;
                        } else if (ao.isWifi(this.mContext)) {
                            aUS();
                            return;
                        } else {
                            com.tencent.mm.ui.base.h.a(this.mContext, this.mContext.getString(i.webview_download_ui_download_not_in_wifi_tips), this.mContext.getString(i.webview_download_ui_download_not_in_wifi_title), this.mContext.getString(i.webview_download_ui_btn_state_to_download), this.mContext.getString(i.app_cancel), false, new 1(this), new OnClickListener() {
                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    dialogInterface.dismiss();
                                    x.i("MicroMsg.GameClickListener", "resumeDownloadTask not wifi, user cancel");
                                }
                            }, b.wechat_green);
                            return;
                        }
                    case 3:
                        if (!bi.oW(this.jTN) && e.cn(this.jTN) && c.dd(this.jTN, this.jTP.field_md5)) {
                            c.a(this.jTN, this.jMa.field_appId, this.jMa.bYq, this.jTP.field_downloadId, this.jTP.field_channelId);
                            an.a(this.mContext, this.jMa.scene, this.jMa.bYq, this.jMa.position, 8, this.jMa.field_appId, this.jNv, this.jMa.bHF, this.jTR);
                            return;
                        }
                        fw(false);
                        return;
                    default:
                        fw(false);
                        return;
                }
            }
        }
        x.e("MicroMsg.GameClickListener", "No AppInfo");
    }

    private void aUS() {
        an.a(this.jMa.field_appId, this.jMa.bYq, 10, this.jTP.field_downloadId, "");
        if (com.tencent.mm.plugin.downloader.model.d.aCU().co(this.jTP.field_downloadId)) {
            f.ai(this.mContext, this.jMa.field_appId);
            an.a(this.mContext, this.jMa.scene, this.jMa.bYq, this.jMa.position, 4, this.jMa.field_appId, this.jNv, this.jMa.bHF, this.jTR);
            return;
        }
        x.e("MicroMsg.GameClickListener", "resumeDownloadTask false");
        com.tencent.mm.plugin.downloader.model.d.aCU().cl(this.jTP.field_downloadId);
        fw(false);
    }
}

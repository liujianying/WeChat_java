package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.provider.Settings.Secure;
import android.provider.Settings.SettingNotFoundException;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.downloader.c.a;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.downloader.model.e;
import com.tencent.mm.plugin.game.f.b;
import com.tencent.mm.plugin.game.f.i;
import com.tencent.mm.plugin.game.model.an;
import com.tencent.mm.plugin.game.model.d;
import com.tencent.mm.plugin.game.model.f;
import com.tencent.mm.plugin.game.model.m;
import com.tencent.mm.pluginsdk.model.app.q;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;

public abstract class c implements OnClickListener {
    protected long fGL = -1;
    protected d jMa = null;
    protected int jNv;
    protected String jTN;
    protected FileDownloadTaskInfo jTO;
    protected a jTP;
    protected String jTQ;
    protected String jTR;
    protected String jTS;
    private String jTT = "xiaomi";
    protected Context mContext;
    protected int mStatus = -1;

    public c(Context context) {
        this.mContext = context;
    }

    public final void setSourceScene(int i) {
        this.jNv = i;
    }

    protected final void aUI() {
        f.ah(this.mContext, this.jMa.field_appId);
    }

    protected final void fw(final boolean z) {
        if (ao.isNetworkConnected(this.mContext)) {
            g.Ek();
            if (!g.Ei().isSDCardAvailable()) {
                Toast.makeText(this.mContext, this.mContext.getString(i.game_download_sdcard_unavailable), 0).show();
                m.aTQ();
                m.a(this.jMa.field_appId, com.tencent.mm.plugin.downloader.a.a.ibo, false, null);
                return;
            } else if (com.tencent.mm.compatible.util.f.aM(this.jMa.jLw)) {
                if (com.tencent.mm.protocal.d.qVH.toLowerCase().contains(this.jTT)) {
                    try {
                        if (Secure.getInt(this.mContext.getContentResolver(), "install_non_market_apps") == 0 && !f.dt(this.mContext)) {
                            h.a(this.mContext, i.game_show_tips_message, i.game_show_tips_title, i.game_gcontact_authorize_title, i.app_cancel, false, new 3(this), new 4(this));
                            f.du(this.mContext);
                        }
                    } catch (SettingNotFoundException e) {
                        x.e("MicroMsg.CommonGameClickLinstener", "SettingNotFoundException ; %S", new Object[]{e.getMessage()});
                    }
                }
                if (bi.oW(this.jMa.cmE) || bi.oW(this.jMa.cmJ)) {
                    x.d("MicroMsg.CommonGameClickLinstener", "downloadApk: appdownloadurl is null or appmd5 is null, try gpDownload");
                    if (bi.oW(this.jMa.cmK)) {
                        x.e("MicroMsg.CommonGameClickLinstener", "downloadApk fail, gpDownloadUrl is null");
                    } else {
                        boolean bi = q.bi(this.mContext, this.jMa.cmK);
                        x.d("MicroMsg.CommonGameClickLinstener", "downloadApk with gp, ret = %b", new Object[]{Boolean.valueOf(bi)});
                    }
                    if (bi.oW(this.jMa.cmE)) {
                        m.aTQ();
                        m.a(this.jMa.field_appId, com.tencent.mm.plugin.downloader.a.a.DOWNLOAD_ERR_URL_INVALID, false, null);
                    }
                    if (bi.oW(this.jMa.cmJ)) {
                        m.aTQ();
                        m.a(this.jMa.field_appId, com.tencent.mm.plugin.downloader.a.a.ibl, false, null);
                        return;
                    }
                    return;
                }
                an.a(this.mContext, this.jMa.scene, this.jMa.bYq, this.jMa.position, 4, this.jMa.field_appId, this.jNv, this.jMa.bHF, this.jTR);
                if (ao.isWifi(this.mContext)) {
                    fx(z);
                    return;
                }
                com.tencent.mm.plugin.report.service.h.mEJ.h(14217, new Object[]{this.jMa.field_appId, Integer.valueOf(4), "", this.jMa.cmE, Integer.valueOf(2)});
                h.a(this.mContext, this.mContext.getString(i.webview_download_ui_download_not_in_wifi_tips), this.mContext.getString(i.webview_download_ui_download_not_in_wifi_title), this.mContext.getString(i.webview_download_ui_btn_state_to_download), this.mContext.getString(i.app_cancel), false, new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        com.tencent.mm.plugin.report.service.h.mEJ.h(14217, new Object[]{c.this.jMa.field_appId, Integer.valueOf(5), "", c.this.jMa.cmE, Integer.valueOf(2)});
                        c.this.fx(z);
                        dialogInterface.dismiss();
                    }
                }, new 2(this), b.wechat_green);
                return;
            } else {
                Toast.makeText(this.mContext, this.mContext.getString(i.game_download_not_enough_space), 0).show();
                m.aTQ();
                m.a(this.jMa.field_appId, com.tencent.mm.plugin.downloader.a.a.ibo, false, null);
                return;
            }
        }
        Toast.makeText(this.mContext, this.mContext.getString(i.game_download_network_unavailable), 0).show();
        m.aTQ();
        m.a(this.jMa.field_appId, com.tencent.mm.plugin.downloader.a.a.ibn, false, null);
    }

    private void fx(boolean z) {
        long b;
        if (z) {
            m.a(this.jMa.cmE, this.jMa.cmJ, this.jMa.bYq, this.jMa.field_appId, this.jTQ, "app_update");
        } else {
            m.a(this.jMa.cmE, this.jMa.cmJ, this.jMa.bYq, this.jMa.field_appId, this.jTQ, this.jTS);
        }
        e.a aVar = new e.a();
        aVar.yQ(this.jMa.cmE);
        aVar.yR(this.jMa.jLv);
        aVar.cx(this.jMa.jLw);
        aVar.yS(com.tencent.mm.pluginsdk.model.app.g.b(this.mContext, this.jMa, null));
        aVar.setAppId(this.jMa.field_appId);
        aVar.yT(this.jMa.cmJ);
        aVar.ef(true);
        aVar.ox(1);
        aVar.cQ(this.jMa.field_packageName);
        aVar.setScene(this.jMa.bYq);
        if (this.jMa.bPG == 1) {
            b = com.tencent.mm.plugin.downloader.model.d.aCU().b(aVar.ick);
        } else {
            b = com.tencent.mm.plugin.downloader.model.d.aCU().a(aVar.ick);
        }
        x.i("MicroMsg.CommonGameClickLinstener", " add download task result:[%d], appid[%s]，downloaerType[%d]", new Object[]{Long.valueOf(b), this.jMa.field_appId, Integer.valueOf(this.jMa.bPG)});
        f.ai(this.mContext, this.jMa.field_appId);
        an.a(this.jMa.field_appId, this.jMa.bYq, 9, b, "");
    }

    protected final void aUJ() {
        this.jTP = com.tencent.mm.plugin.downloader.model.c.yK(this.jMa.field_appId);
        this.jTO = com.tencent.mm.plugin.downloader.model.d.aCU().yO(this.jMa.field_appId);
        this.fGL = this.jTO.id;
        this.mStatus = this.jTO.status;
        this.jTN = this.jTO.path;
    }
}

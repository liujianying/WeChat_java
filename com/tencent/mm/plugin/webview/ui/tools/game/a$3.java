package com.tencent.mm.plugin.webview.ui.tools.game;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.s$l;
import com.tencent.mm.plugin.webview.a;
import com.tencent.mm.plugin.webview.ui.tools.d;
import com.tencent.mm.plugin.webview.ui.tools.g;
import com.tencent.mm.plugin.webview.ui.tools.widget.k;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.e.i;
import com.tencent.qqvideo.proxy.api.FactoryProxyManager;
import com.tencent.xweb.b;
import com.tencent.xweb.c;
import java.io.File;
import java.util.Map;

class a$3 extends k {
    final /* synthetic */ a qfR;

    a$3(a aVar) {
        this.qfR = aVar;
    }

    public final void P(Bundle bundle) {
        x.i("MicroMsg.GameFloatWebView", "closeWindow");
        try {
            this.qfR.CK.removeView(this.qfR.dEn);
            this.qfR.onDestroy();
        } catch (Exception e) {
        }
    }

    public final Bundle g(int i, Bundle bundle) {
        x.i("MicroMsg.GameFloatWebView", "game float invokeAsResult, actionCode = " + i);
        Bundle bundle2 = new Bundle();
        final String string;
        final int i2;
        boolean z;
        String currentUrl;
        int init;
        switch (i) {
            case 18:
                bundle2.putString("KPublisherId", d.bZM);
                bundle2.putInt("getA8KeyScene", this.qfR.cA(d.qgn, d.cfR));
                break;
            case s$l.AppCompatTheme_actionModeFindDrawable /*37*/:
                string = bundle.getString("show_kb_placeholder");
                i2 = bundle.getInt("show_kb_max_length");
                this.qfR.qfK.runOnUiThread(new Runnable() {
                    public final void run() {
                        a$3.this.qfR.qfK.cz(string, i2);
                    }
                });
                break;
            case s$l.AppCompatTheme_dialogPreferredPadding /*43*/:
                this.qfR.qfK.runOnUiThread(new 3(this, bundle.getString("set_page_title_text"), d.aO(bundle.getString("set_page_title_color"), this.qfR.qfK.getResources().getColor(R.e.action_bar_tittle_color))));
                break;
            case s$l.AppCompatTheme_selectableItemBackgroundBorderless /*53*/:
                this.qfR.qfK.runOnUiThread(new 4(this, bundle));
                break;
            case s$l.AppCompatTheme_borderlessButtonStyle /*54*/:
                z = bundle.getBoolean("add_shortcut_status");
                if (this.qfR.qfM != null) {
                    this.qfR.qfM.kk(z);
                    break;
                }
                break;
            case 79:
                this.qfR.qfK.runOnUiThread(new 2(this, bundle2));
                break;
            case 84:
                CharSequence mMTitle = this.qfR.qfK.mController.getMMTitle();
                currentUrl = getCurrentUrl();
                bundle2.putString("webview_current_url", currentUrl);
                bundle2.putString("webview_current_title", mMTitle != null ? mMTitle.toString() : "");
                bundle2.putString("webview_current_desc", currentUrl);
                break;
            case s$l.AppCompatTheme_colorControlHighlight /*87*/:
                z = this.qfR.qfO.qkQ;
                currentUrl = this.qfR.qfO.jJq;
                Map map = this.qfR.qfO.qkS;
                if (!z) {
                    bundle2.putString("full_url", bi.oV(currentUrl));
                    if (map != null && map.size() != 0) {
                        bundle2.putInt("set_cookie", 1);
                        c.ij(ad.getContext());
                        b cIi = b.cIi();
                        for (String string2 : map.keySet()) {
                            cIi.setCookie(bi.oV(currentUrl), string2 + "=" + ((String) map.get(string2)));
                        }
                        c.cIk();
                        c.sync();
                        x.i("MicroMsg.GameFloatWebView", "cookies:%s", new Object[]{cIi.getCookie(bi.oV(currentUrl))});
                        break;
                    }
                    bundle2.putInt("set_cookie", 0);
                    break;
                }
                bundle2.putString("result", "not_return");
                break;
                break;
            case s$l.AppCompatTheme_textColorAlertDialogListItem /*95*/:
                this.qfR.jJI.qfW.ab(bundle);
                x.i("MicroMsg.GameFloatWebView", "set game float page time data");
                break;
            case 99:
                bundle2.putInt("geta8key_scene", d.cfR);
                x.i("MicroMsg.GameFloatWebView", "Key value: getA8KeyScene(%d)", new Object[]{Integer.valueOf(init)});
                break;
            case s$l.AppCompatTheme_buttonStyleSmall /*101*/:
                bundle.setClassLoader(GameWebViewUI.class.getClassLoader());
                com.tencent.mm.bg.d.b(this.qfR.mContext, bundle.getString("open_ui_with_webview_ui_plugin_name"), bundle.getString("open_ui_with_webview_ui_plugin_entry"), new Intent().putExtras(bundle.getBundle("open_ui_with_webview_ui_extras")).putExtra("KPublisherId", d.bZM));
                break;
            case 5001:
                if (this.qfR.qcA.isSDCardAvailable()) {
                    x.i("MicroMsg.GameFloatWebView", "availableSize = %d", new Object[]{Long.valueOf(ax.ciJ())});
                    if (ax.ciJ() < 524288000) {
                        x.e("MicroMsg.GameFloatWebView", "available size not enough");
                    } else {
                        File file = new File(a.pNq);
                        z = true;
                        if (!file.exists()) {
                            z = file.mkdirs();
                            x.i("MicroMsg.GameFloatWebView", "create proxy cache path : %s, %b", new Object[]{file.getAbsolutePath(), Boolean.valueOf(z)});
                        }
                        if (z) {
                            init = FactoryProxyManager.getPlayManager().init(this.qfR.mContext, a.pNq);
                            FactoryProxyManager.getPlayManager().setMaxStorageSize(200);
                        }
                    }
                    init = FactoryProxyManager.getPlayManager().init(this.qfR.mContext, null);
                } else {
                    x.i("MicroMsg.GameFloatWebView", "sdcard not available");
                    init = FactoryProxyManager.getPlayManager().init(this.qfR.mContext, null);
                }
                bundle2.putInt("webview_video_proxy_init", init);
                break;
            case 5002:
                currentUrl = bundle.getString("webview_video_proxy_cdn_urls");
                String string3 = bundle.getString("webview_video_proxy_fileId");
                int i3 = bundle.getInt("webview_video_proxy_file_size");
                init = FactoryProxyManager.getPlayManager().startPlay(currentUrl, bundle.getInt("webview_video_proxy_file_type"), string3, (long) i3, bundle.getInt("webview_video_proxy_file_duration"));
                x.i("MicroMsg.GameFloatWebView", "cdnurls = %s, filedId = %s, fileSize = %d, fileDuration = %d, fileType = %d, playDataId = %d, localUrl = %s", new Object[]{currentUrl, string3, Integer.valueOf(i3), Integer.valueOf(r6), Integer.valueOf(r2), Integer.valueOf(init), FactoryProxyManager.getPlayManager().buildPlayURLMp4(init)});
                bundle2.putInt("webview_video_proxy_play_data_id", init);
                bundle2.putString("webview_video_proxy_local_url", r4);
                break;
            case 5003:
                init = bundle.getInt("webview_video_proxy_play_data_id");
                x.i("MicroMsg.GameFloatWebView", "webview proxy stop play, play id = %d", new Object[]{Integer.valueOf(init)});
                if (init > 0) {
                    FactoryProxyManager.getPlayManager().stopPlay(init);
                    break;
                }
                break;
            case 5004:
                FactoryProxyManager.getPlayManager().setPlayerState(bundle.getInt("webview_video_proxy_play_state"));
                break;
            case 5005:
                FactoryProxyManager.getPlayManager().setNetWorkState(bundle.getInt("webview_video_proxy_net_state"));
                break;
            case 5006:
                FactoryProxyManager.getPlayManager().setRemainTime(bundle.getInt("webview_video_proxy_play_data_id"), bundle.getInt("webview_video_proxy_play_remain_time"));
                break;
            case 5007:
                x.i("MicroMsg.GameFloatWebView", "playid = %d, duration = %d", new Object[]{Integer.valueOf(bundle.getInt("webview_video_proxy_play_data_id")), Integer.valueOf(bundle.getInt("webview_video_proxy_preload_duration"))});
                bundle2.putInt("webview_video_proxy_pre_load_result", FactoryProxyManager.getPlayManager().preLoad(init, i2));
                break;
            case 6001:
                x.i("MicroMsg.GameFloatWebView", "includeCookie = %b", new Object[]{Boolean.valueOf(bundle.getBoolean("clear_webview_cache_clear_cookie", false))});
                Intent intent = new Intent();
                intent.setComponent(new ComponentName(i.thA, "com.tencent.mm.booter.MMReceivers$ToolsProcessReceiver"));
                intent.putExtra("tools_process_action_code_key", "com.tencent.mm.intent.ACTION_CLEAR_WEBVIEW_CACHE");
                intent.putExtra("tools_clean_webview_cache_ignore_cookie", z);
                this.qfR.mContext.sendBroadcast(intent);
                break;
            case 90001:
                x.i("MicroMsg.GameFloatWebView", "url = %s, cookie = %s", new Object[]{getCurrentUrl(), b.cIi().getCookie(getCurrentUrl())});
                bundle2.putString("cookie", currentUrl);
                break;
            case 90002:
                g.pXv.fr(bundle.getString("traceid"), bundle.getString("username"));
                break;
            default:
                x.e("MicroMsg.GameFloatWebView", "undefine action code!!!");
                break;
        }
        return bundle2;
    }
}

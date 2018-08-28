package com.tencent.mm.plugin.game.gamewebview.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.ClipboardManager;
import android.view.MenuItem;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.p;
import com.tencent.mm.plugin.fav.ui.c;
import com.tencent.mm.plugin.game.gamewebview.ipc.AddShortcutTask;
import com.tencent.mm.plugin.game.gamewebview.ipc.GameKeepPageTopTask;
import com.tencent.mm.plugin.game.gamewebview.ipc.GameWebViewMainProcessService;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.GameJsApiSendAppMessage;
import com.tencent.mm.plugin.game.gamewebview.model.FavUrlTask;
import com.tencent.mm.plugin.game.gamewebview.model.h;
import com.tencent.mm.plugin.webview.modeltools.a;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.ui.widget.snackbar.a.b;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import org.json.JSONObject;

public class i {
    public static b jKu = new 9();
    protected GameWebViewUI jIJ;
    protected b jKc;
    private a jKq;
    public HashSet<Integer> jKr = new HashSet();
    public Map<String, Integer> jKs = new HashMap();
    public HashSet<Integer> jKt = new HashSet();
    private boolean mEnable = false;

    static /* synthetic */ void a(i iVar) {
        Intent intent = new Intent();
        intent.putExtra("key_fav_scene", 2);
        intent.putExtra("key_fav_item_id", iVar.getBundle().getLong("fav_local_id", -1));
        com.tencent.mm.plugin.fav.a.b.a(iVar.jIJ, ".ui.FavTagEditUI", intent);
    }

    static /* synthetic */ boolean a(i iVar, int i) {
        return !iVar.jKr.contains(Integer.valueOf(i));
    }

    static /* synthetic */ boolean aTs() {
        FavUrlTask favUrlTask = new FavUrlTask();
        favUrlTask.actionType = 3;
        GameWebViewMainProcessService.b(favUrlTask);
        return favUrlTask.jHW;
    }

    static /* synthetic */ boolean h(MenuItem menuItem) {
        return menuItem.getItemId() >= 10000;
    }

    public i(b bVar) {
        this.jKc = bVar;
        this.jIJ = (GameWebViewUI) bVar.getContext();
        this.jKs.clear();
        this.jKs.put("menuItem:share:brand", Integer.valueOf(0));
        this.jKs.put("menuItem:share:appMessage", Integer.valueOf(1));
        this.jKs.put("menuItem:share:dataMessage", Integer.valueOf(23));
        this.jKs.put("menuItem:share:timeline", Integer.valueOf(2));
        this.jKs.put("menuItem:favorite", Integer.valueOf(3));
        this.jKs.put("menuItem:profile", Integer.valueOf(5));
        this.jKs.put("menuItem:addContact", Integer.valueOf(5));
        this.jKs.put("menuItem:copyUrl", Integer.valueOf(6));
        this.jKs.put("menuItem:openWithSafari", Integer.valueOf(7));
        this.jKs.put("menuItem:share:email", Integer.valueOf(8));
        this.jKs.put("menuItem:delete", Integer.valueOf(9));
        this.jKs.put("menuItem:exposeArticle", Integer.valueOf(10));
        this.jKs.put("menuItem:setFont", Integer.valueOf(11));
        this.jKs.put("menuItem:editTag", Integer.valueOf(12));
        this.jKs.put("menuItem:readMode", Integer.valueOf(14));
        this.jKs.put("menuItem:originPage", Integer.valueOf(14));
        this.jKs.put("menuItem:share:qq", Integer.valueOf(20));
        this.jKs.put("menuItem:share:weiboApp", Integer.valueOf(21));
        this.jKs.put("menuItem:share:QZone", Integer.valueOf(22));
        this.jKs.put("menuItem:share:enterprise", Integer.valueOf(24));
        this.jKs.put("menuItem:refresh", Integer.valueOf(28));
        this.jKs.put("menuItem:share:wework", Integer.valueOf(25));
        this.jKs.put("menuItem:share:weread", Integer.valueOf(26));
        this.jKs.put("menuItem:keepTop", Integer.valueOf(30));
        this.jKs.put("menuItem:cancelKeepTop", Integer.valueOf(32));
        this.jKs.put("menuItem:addShortcut", Integer.valueOf(29));
        this.jKs.put("menuItem:search", Integer.valueOf(31));
        this.jKt.clear();
        this.jKt.add(Integer.valueOf(28));
        this.jKt.add(Integer.valueOf(6));
        this.jKt.add(Integer.valueOf(27));
        this.jKt.add(Integer.valueOf(30));
        this.jKt.add(Integer.valueOf(32));
    }

    public final boolean onActivityResult(int i, int i2, Intent intent) {
        if (this.jKq == null || !a.b(this.jIJ, i, i2, intent)) {
            return false;
        }
        return true;
    }

    public void aTe() {
        d dVar;
        Boolean valueOf = Boolean.valueOf(false);
        if (valueOf.booleanValue()) {
            dVar = new d(this.jIJ, 1, false);
        } else {
            dVar = new d(this.jIJ, 0, true);
        }
        dVar.uAx = new 1(this);
        dVar.uAy = new 2(this);
        dVar.ofq = new 3(this);
        dVar.ofp = new 4(this, valueOf);
        String currentURL = this.jKc.getPageView().getCurrentURL();
        if (!bi.oW(currentURL)) {
            if (!bi.oW(Uri.parse(currentURL).getHost())) {
                dVar.i(this.jIJ.getString(R.l.webview_logo_url, new Object[]{currentURL}), 1);
            }
        }
        if (this.jKc.isFullScreen()) {
            dVar.qgK = true;
            dVar.qgL = true;
        } else {
            dVar.qgK = false;
            dVar.qgL = false;
        }
        if (this.jKc.getPageView().jJb.isShown()) {
            this.jKc.getPageView().fq(false);
            ah.i(new 5(this, dVar), 100);
            return;
        }
        this.jIJ.YC();
        ah.i(new 6(this, dVar), 100);
    }

    protected final void aTh() {
        if (!this.jKc.getPageView().aST()) {
            this.jKc.aSH();
        }
    }

    protected final void aTi() {
        h.c(this.jKc.getPageView());
    }

    protected final void aTj() {
        d pageView = this.jKc.getPageView();
        if (pageView.bs("shareTimeline", 88)) {
            pageView.Dr("shareTimeline");
            pageView.cW("menu:share:timeline", "");
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            String shareUrl = pageView.getShareUrl();
            jSONObject.put("link", shareUrl);
            jSONObject.put("desc", shareUrl);
            jSONObject.put("title", pageView.getTitle());
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.GameWebViewShareController", e, "", new Object[0]);
        }
        pageView.cX("shareTimeline", jSONObject.toString());
    }

    protected final void aTk() {
        CharSequence shareUrl = this.jKc.getPageView().getShareUrl();
        ClipboardManager clipboardManager = (ClipboardManager) this.jIJ.getSystemService("clipboard");
        if (clipboardManager != null) {
            try {
                clipboardManager.setText(shareUrl);
                Toast.makeText(this.jIJ, this.jIJ.getString(R.l.wv_alert_copy_link_toast), 0).show();
                return;
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.OptionMenuBtnHelp", e, "clip.setText error", new Object[0]);
                return;
            }
        }
        x.e("MicroMsg.OptionMenuBtnHelp", "clipboard manager is null");
    }

    protected final void aTl() {
        x.i("MicroMsg.OptionMenuBtnHelp", "doKeepPageTopLogic");
        String string = getBundle().getString("custom_keep_top_url");
        String string2 = getBundle().getString("custom_keep_top_title");
        String string3 = getBundle().getString("shortcut_user_name");
        GameKeepPageTopTask gameKeepPageTopTask = new GameKeepPageTopTask();
        gameKeepPageTopTask.type = 2;
        if (bi.oW(string2) || bi.oW(string)) {
            gameKeepPageTopTask.url = this.jKc.getPageView().getRawUrl();
            gameKeepPageTopTask.title = this.jKc.getPageView().getTitle();
            gameKeepPageTopTask.username = "";
        } else {
            gameKeepPageTopTask.url = string;
            gameKeepPageTopTask.title = string2;
            gameKeepPageTopTask.username = string3;
        }
        GameWebViewMainProcessService.a(gameKeepPageTopTask);
        b bVar = this.jKc;
        bVar.jIF = true;
        bVar.setEnableGesture(bVar.aSF());
        bVar.jIE.b(bVar);
        com.tencent.mm.ui.widget.snackbar.b.h(this.jIJ, this.jIJ.getString(R.l.readerapp_keep_page_top_done));
    }

    protected final void aTm() {
        GameKeepPageTopTask gameKeepPageTopTask = new GameKeepPageTopTask();
        gameKeepPageTopTask.type = 2;
        gameKeepPageTopTask.url = "";
        gameKeepPageTopTask.title = "";
        gameKeepPageTopTask.username = "";
        GameWebViewMainProcessService.a(gameKeepPageTopTask);
        b bVar = this.jKc;
        bVar.jIF = false;
        bVar.setEnableGesture(bVar.aSF());
        bVar.jIE.aSI();
        com.tencent.mm.ui.widget.snackbar.b.h(this.jIJ, this.jIJ.getString(R.l.readerapp_cancel_keep_page_top_done));
    }

    protected final boolean Us() {
        if (this.jKc.aSG() || this.jKc.jIF) {
            return true;
        }
        GameKeepPageTopTask gameKeepPageTopTask = new GameKeepPageTopTask();
        gameKeepPageTopTask.type = 1;
        GameWebViewMainProcessService.b(gameKeepPageTopTask);
        if (this.jKc.getPageView().getRawUrl().equals(bi.oV(gameKeepPageTopTask.url))) {
            return true;
        }
        return false;
    }

    protected final void aTn() {
        String shareUrl = this.jKc.getPageView().getShareUrl();
        if (this.jKq == null) {
            this.jKq = new a();
        }
        a.d(this.jIJ, shareUrl);
    }

    protected final void aTo() {
        String string = getBundle().getString("shortcut_user_name");
        String cacheAppId = this.jKc.getPageView().getCacheAppId();
        if (bi.oW(string) || bi.oW(cacheAppId)) {
            x.e("MicroMsg.OptionMenuBtnHelp", "addShortcut,appid or username is null");
            return;
        }
        AddShortcutTask addShortcutTask = new AddShortcutTask();
        addShortcutTask.username = string;
        addShortcutTask.appId = cacheAppId;
        addShortcutTask.fFC = new 7(this, addShortcutTask);
        addShortcutTask.ahA();
        GameWebViewMainProcessService.a(addShortcutTask);
    }

    protected final void refresh() {
        if (this.jKc.getPageView().getWebView() != null) {
            this.jKc.getPageView().getWebView().reload();
        }
    }

    protected final void aTp() {
        Bundle bundle = new Bundle();
        bundle.putLong("msg_id", getBundle().getLong("msg_id", Long.MIN_VALUE));
        bundle.putString("sns_local_id", getBundle().getString("sns_local_id"));
        bundle.putInt("news_svr_id", getBundle().getInt("news_svr_id", 0));
        bundle.putString("news_svr_tweetid", getBundle().getString("news_svr_tweetid"));
        bundle.putInt("message_index", getBundle().getInt("message_index", 0));
        String rawUrl = this.jKc.getPageView().getRawUrl();
        bundle.putString("rawUrl", rawUrl);
        String currentURL = this.jKc.getPageView().getCurrentURL();
        if (!bi.oW(rawUrl) && rawUrl.endsWith("#rd")) {
            rawUrl = rawUrl.substring(0, rawUrl.length() - 3);
            if (!(bi.oW(currentURL) || currentURL.startsWith(rawUrl))) {
                bundle.putString("rawUrl", currentURL);
                bundle.putLong("msg_id", Long.MIN_VALUE);
            }
        } else if (!(bi.oW(currentURL) || currentURL.startsWith(rawUrl))) {
            bundle.putString("rawUrl", currentURL);
            bundle.putLong("msg_id", Long.MIN_VALUE);
            bundle.putString("sns_local_id", "");
        }
        if (getBundle() != null) {
            bundle.putString("preChatName", getBundle().getString("preChatName"));
            bundle.putInt("preMsgIndex", getBundle().getInt("preMsgIndex", 0));
            bundle.putString("prePublishId", getBundle().getString("prePublishId"));
            bundle.putString("preUsername", getBundle().getString("preUsername"));
        }
        FavUrlTask favUrlTask = new FavUrlTask();
        favUrlTask.actionType = 1;
        favUrlTask.jfZ = bundle;
        GameWebViewMainProcessService.b(favUrlTask);
        if (favUrlTask.jHV) {
            d pageView = this.jKc.getPageView();
            GameJsApiSendAppMessage.cfQ = 1;
            h.c(pageView);
            x.i("MicroMsg.OptionMenuBtnHelp", "on favorite simple url");
            return;
        }
        c.a(favUrlTask.ret, this.jIJ, jKu);
    }

    protected final void aTq() {
        com.tencent.mm.ui.base.h.a(this.jIJ, this.jIJ.getString(R.l.app_delete_tips), null, null, this.jIJ.getString(R.l.app_delete), new 8(this));
    }

    protected final void aTr() {
        String str = null;
        String string = getBundle().getString("geta8key_username");
        String currentURL = this.jKc.getPageView().getCurrentURL();
        Intent intent = new Intent(this.jIJ, GameWebViewUI.class);
        intent.putExtra("k_username", string);
        intent.putExtra("k_expose_url", currentURL);
        intent.putExtra("showShare", false);
        if (bi.oW(currentURL)) {
            string = null;
        } else {
            string = Uri.parse(currentURL).getHost();
        }
        if (bi.oW(string) || !string.startsWith("mp.weixin.qq.com")) {
            intent.putExtra("k_expose_current_url", currentURL);
        } else {
            try {
                string = String.format("https://mp.weixin.qq.com/mp/infringement?url=%s#wechat_redirect", new Object[]{p.encode(currentURL, "utf-8")});
            } catch (UnsupportedEncodingException e) {
                x.e("MicroMsg.OptionMenuBtnHelp", e.getMessage());
                string = null;
            }
            if (string != null) {
                str = string;
            }
        }
        if (bi.oW(str)) {
            str = String.format("https://weixin110.qq.com/security/readtemplate?t=weixin_report/w_type&scene=%d#wechat_redirect", new Object[]{Integer.valueOf(34)});
        }
        intent.putExtra("rawUrl", str);
        this.jIJ.startActivity(intent);
    }

    protected final Bundle getBundle() {
        return this.jKc != null ? this.jKc.getBundle() : new Bundle();
    }
}

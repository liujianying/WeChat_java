package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import com.tencent.mm.a.m;
import com.tencent.mm.bp.a;
import com.tencent.mm.plugin.game.gamewebview.b.a.b;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.ax;
import com.tencent.mm.plugin.websearch.api.c;
import com.tencent.mm.plugin.webview.ui.tools.e;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.smtt.sdk.TbsListener$ErrorCode;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class d implements c, b {
    private static final int qhj = (com.tencent.mm.compatible.util.d.fS(19) ? 200 : 20);
    public com.tencent.mm.plugin.webview.stub.d gcO;
    public int pUz;
    private List<String> qhA = new LinkedList();
    private al qhB = new al(new 26(this), false);
    public long qhC = 0;
    public MMWebView qhk;
    private final List<String> qhl = new LinkedList();
    private final LinkedList<i> qhm = new LinkedList();
    private ag qhn = null;
    Map<String, Object> qho;
    public Map<String, Object> qhp;
    public boolean qhq = false;
    private e qhr;
    public boolean qhs = false;
    public String qht = "";
    private Set<a> qhu;
    private final List<String> qhv = new LinkedList();
    volatile String qhw = null;
    volatile int qhx = 0;
    private JSONObject qhy = new JSONObject();
    private JSONArray qhz = new JSONArray();

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.jsapi.d$36 */
    class AnonymousClass36 implements Runnable {
        final /* synthetic */ String fzV;

        public AnonymousClass36(String str) {
            this.fzV = str;
        }

        public final void run() {
            try {
                d.this.qhk.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.fzV + ")", null);
            } catch (Exception e) {
                x.e("MicroMsg.JsApiHandler", "onGetPoiInfoReturn fail, ex = %s", new Object[]{e.getMessage()});
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.jsapi.d$58 */
    class AnonymousClass58 implements Runnable {
        final /* synthetic */ String fzV;

        public AnonymousClass58(String str) {
            this.fzV = str;
        }

        public final void run() {
            try {
                d.this.qhk.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.fzV + ")", null);
            } catch (Exception e) {
                x.e("MicroMsg.JsApiHandler", "onGetMsgProofItems fail, ex = %s", new Object[]{e.getMessage()});
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.jsapi.d$60 */
    class AnonymousClass60 implements Runnable {
        final /* synthetic */ String qhH;

        public AnonymousClass60(String str) {
            this.qhH = str;
        }

        public final void run() {
            try {
                if (d.this.qhk != null) {
                    d.this.qhk.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.qhH + ")", null);
                }
            } catch (Exception e) {
                x.e("MicroMsg.JsApiHandler", "eval onMiniProgramData, ex = %s", new Object[]{e});
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.jsapi.d$61 */
    class AnonymousClass61 implements Runnable {
        final /* synthetic */ String fzV;

        public AnonymousClass61(String str) {
            this.fzV = str;
        }

        public final void run() {
            try {
                d.this.qhk.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.fzV + ")", null);
            } catch (Exception e) {
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.jsapi.d$6 */
    class AnonymousClass6 implements Runnable {
        final /* synthetic */ String fzV;

        public AnonymousClass6(String str) {
            this.fzV = str;
        }

        public final void run() {
            try {
                d.this.qhk.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.fzV + ")", null);
            } catch (Exception e) {
                x.w("MicroMsg.JsApiHandler", "onWXDeviceLanStateChange, %s", new Object[]{e.getMessage()});
            }
        }
    }

    static /* synthetic */ Map C(String[] strArr) {
        int length = strArr == null ? 0 : strArr.length;
        if (length == 0) {
            return null;
        }
        Map hashMap = new HashMap();
        for (int i = 0; i < length; i++) {
            if (hashMap.keySet().contains(strArr[i])) {
                hashMap.put(strArr[i], Integer.valueOf(((Integer) hashMap.get(strArr[i])).intValue() + 1));
            } else {
                hashMap.put(strArr[i], Integer.valueOf(1));
            }
        }
        return hashMap;
    }

    static /* synthetic */ void c(d dVar) {
        if (dVar.qhl.size() <= 0) {
            x.i("MicroMsg.JsApiHandler", "dealMsgQueue fail, resultValueList is empty");
            return;
        }
        x.i("MicroMsg.JsApiHandler", "dealMsgQueue, pre msgList = " + dVar.qhm.size());
        Collection e = i$a.e((String) dVar.qhl.remove(0), dVar.qhs, dVar.qht);
        if (!bi.cX(e)) {
            dVar.qhm.addAll(e);
            x.i("MicroMsg.JsApiHandler", "now msg list size : %d", new Object[]{Integer.valueOf(dVar.qhm.size())});
        }
        x.i("MicroMsg.JsApiHandler", "dealMsgQueue, post msgList = " + dVar.qhm.size());
        dVar.bXT();
        if (dVar.qhn != null) {
            dVar.qhn.post(new 63(dVar));
        }
    }

    static /* synthetic */ void l(d dVar) {
        do {
        } while (dVar.bXU());
    }

    public d(MMWebView mMWebView, e eVar, Map<String, Object> map, com.tencent.mm.plugin.webview.stub.d dVar, int i) {
        this.qhk = mMWebView;
        this.qhr = eVar;
        this.qhn = new 1(this, Looper.getMainLooper());
        this.gcO = dVar;
        this.qho = map;
        this.pUz = i;
    }

    public final void bXQ() {
        this.qhs = true;
        this.qht = bi.Dc(16);
        x.i("MicroMsg.JsApiHandler", "js digest verification randomStr = %s", new Object[]{this.qht});
    }

    public final void bf(String str, boolean z) {
        try {
            this.gcO.i(str, z, this.pUz);
        } catch (Exception e) {
            x.w("MicroMsg.JsApiHandler", "addInvokedJsApiFromMenu, ex = " + e);
        }
    }

    @JavascriptInterface
    @org.xwalk.core.JavascriptInterface
    public final void _sendMessage(String str) {
        if (this.qhn != null) {
            Message obtain = Message.obtain();
            obtain.what = 1;
            obtain.obj = str;
            this.qhn.sendMessage(obtain);
        }
    }

    @JavascriptInterface
    @org.xwalk.core.JavascriptInterface
    public final void _getAllHosts(final String str) {
        if (str != null) {
            this.qhn.post(new Runnable() {
                public final void run() {
                    Map C = d.C(str.split(","));
                    String a = d.this.RK("hosts");
                    if (!d.r(a, C)) {
                        x.e("MicroMsg.JsApiHandler", "failed to write Hosts file");
                    } else if (d.this.gcO != null && d.this.qhk != null) {
                        try {
                            d.this.gcO.z(0, d.this.qhk.getUrl(), a);
                        } catch (RemoteException e) {
                            x.e("MicroMsg.JsApiHandler", "uploadFileToCDN error ", new Object[]{e.getMessage()});
                        }
                    }
                }
            });
        }
    }

    @JavascriptInterface
    @org.xwalk.core.JavascriptInterface
    public final void _getHtmlContent(String str) {
        if (str != null) {
            this.qhn.post(new 64(this, str));
        }
    }

    public final boolean Dt(String str) {
        if (bi.oW(str)) {
            return false;
        }
        return s.fj(str, "weixin://dispatch_message/");
    }

    public final boolean Du(final String str) {
        this.qhk.evaluateJavascript("javascript:WeixinJSBridge._fetchQueue()", new ValueCallback<String>() {
            public final /* synthetic */ void onReceiveValue(Object obj) {
                String str = (String) obj;
                x.i("MicroMsg.JsApiHandler", "handle url %s, re %s", new Object[]{str, str});
            }
        });
        return true;
    }

    public final void am(Map<String, Object> map) {
        if (this.qhq) {
            x.i("MicroMsg.JsApiHandler", "onPreloadWebViewInit success, ready");
            String str = "MicroMsg.JsApiHandler";
            String str2 = "onPreloadWebViewInit,params %s";
            Object[] objArr = new Object[1];
            objArr[0] = map == null ? "" : map.toString();
            x.i(str, str2, objArr);
            ah.A(new 44(this, i$a.a("onUiInit", (Map) map, this.qhs, this.qht)));
            return;
        }
        x.e("MicroMsg.JsApiHandler", "onPreloadWebViewInit fail, not ready");
    }

    public final void bXR() {
        this.qhq = true;
        if (this.qhu != null) {
            for (a aVar : this.qhu) {
                if (aVar != null) {
                    aVar.onReady();
                }
            }
        }
    }

    public final void a(a aVar) {
        if (this.qhu == null) {
            this.qhu = new HashSet();
        }
        this.qhu.add(aVar);
    }

    public final void bXS() {
        x.v("MicroMsg.JsApiHandler", "doAttachRunOn3rdApis, ready(%s).", new Object[]{Boolean.valueOf(this.qhq)});
        if (this.qhk != null && this.qhq) {
            MMWebView mMWebView = this.qhk;
            StringBuilder stringBuilder = new StringBuilder("javascript:WeixinJSBridge._handleMessageFromWeixin(");
            String str = "sys:attach_runOn3rd_apis";
            Map hashMap = new HashMap();
            JsapiPermissionWrapper bVR = this.qhr.bVR();
            Collection linkedList = new LinkedList();
            if (bVR != null) {
                if (bVR.gu(88)) {
                    linkedList.add("menu:share:timeline");
                }
                if (bVR.gu(89)) {
                    linkedList.add("menu:share:appmessage");
                }
                if (bVR.gu(94)) {
                    linkedList.add("menu:share:qq");
                }
                if (bVR.gu(109)) {
                    linkedList.add("menu:share:weiboApp");
                }
                if (bVR.gu(134)) {
                    linkedList.add("menu:share:QZone");
                }
                if (bVR.gu(TbsListener$ErrorCode.RENAME_EXCEPTION)) {
                    linkedList.add("sys:record");
                }
                linkedList.add("onVoiceRecordEnd");
                linkedList.add("onVoicePlayBegin");
                linkedList.add("onVoicePlayEnd");
                linkedList.add("onLocalImageUploadProgress");
                linkedList.add("onImageDownloadProgress");
                linkedList.add("onVoiceUploadProgress");
                linkedList.add("onVoiceDownloadProgress");
                linkedList.add("onVideoUploadProgress");
                linkedList.add("onMediaFileUploadProgress");
                linkedList.add("menu:setfont");
                linkedList.add("menu:share:weibo");
                linkedList.add("menu:share:email");
                linkedList.add(com.tencent.mm.plugin.game.gamewebview.b.a.c.NAME);
                linkedList.add(b.NAME);
                linkedList.add("hdOnDeviceStateChanged");
                linkedList.add("activity:state_change");
                linkedList.add("onWXDeviceBluetoothStateChange");
                linkedList.add("onWXDeviceLanStateChange");
                linkedList.add("onWXDeviceBindStateChange");
                linkedList.add("onReceiveDataFromWXDevice");
                linkedList.add("onScanWXDeviceResult");
                linkedList.add("onWXDeviceStateChange");
                linkedList.add("onNfcTouch");
                linkedList.add("onBeaconMonitoring");
                linkedList.add("onBeaconsInRange");
                linkedList.add("menu:custom");
                linkedList.add("onSearchWAWidgetOpenApp");
                linkedList.add("onSearchDataReady");
                linkedList.add("onGetPoiInfoReturn");
                linkedList.add("onSearchHistoryReady");
                linkedList.add("onSearchWAWidgetOnTapCallback");
                linkedList.add("onSearchImageListReady");
                linkedList.add("onTeachSearchDataReady");
                linkedList.add("onSearchGuideDataReady");
                linkedList.add("onSearchInputChange");
                linkedList.add("onSearchInputConfirm");
                linkedList.add("onSearchSuggestionDataReady");
                linkedList.add("onMusicStatusChanged");
                linkedList.add("switchToTabSearch");
                linkedList.add("onVideoPlayerCallback");
                linkedList.add("onSelectContact");
                linkedList.add("onSearchWAWidgetAttrChanged");
                linkedList.add("onSearchWAWidgetReloadData");
                linkedList.add("onSearchWAWidgetReloadDataFinish");
                linkedList.add("onSearchWAWidgetStateChange");
                linkedList.add("onSearchWAWidgetDataPush");
                linkedList.add("onPullDownRefresh");
                linkedList.add("onPageStateChange");
                linkedList.add("onGetKeyboardHeight");
                linkedList.add("onGetSmiley");
                linkedList.add("onAddShortcutStatus");
                linkedList.add("onFocusSearchInput");
                linkedList.add("onGetA8KeyUrl");
                linkedList.add("deleteAccountSuccess");
                linkedList.add("onGetMsgProofItems");
                linkedList.add("WNJSHandlerInsert");
                linkedList.add("WNJSHandlerMultiInsert");
                linkedList.add("WNJSHandlerExportData");
                linkedList.add("WNJSHandlerHeaderAndFooterChange");
                linkedList.add("WNJSHandlerEditableChange");
                linkedList.add("WNJSHandlerEditingChange");
                linkedList.add("WNJSHandlerSaveSelectionRange");
                linkedList.add("WNJSHandlerLoadSelectionRange");
                linkedList.add("onCustomGameMenuClicked");
                linkedList.add("showLoading");
                linkedList.add("getSearchEmotionDataCallBack");
                linkedList.add("onNavigationBarRightButtonClick");
                linkedList.add("onSearchActionSheetClick");
                linkedList.add("onGetMatchContactList");
                linkedList.add("onUiInit");
                linkedList.add("onNetWorkChange");
                linkedList.add("onMiniProgramData");
                linkedList.add("onBackgroundAudioStateChange");
                linkedList.add("onArticleReadingBtnClicked");
                if (!bi.cX(null)) {
                    linkedList.addAll(null);
                }
            }
            hashMap.put("__runOn3rd_apis", new JSONArray(linkedList));
            mMWebView.evaluateJavascript(stringBuilder.append(i$a.a(str, hashMap, this.qhs, this.qht)).append(")").toString(), new 55(this));
        }
    }

    private void bXT() {
        do {
        } while (bXU());
    }

    private boolean bXU() {
        if (bi.cX(this.qhm)) {
            x.i("MicroMsg.JsApiHandler", "dealNextMsg stop, msgList is empty");
            return false;
        }
        boolean Au;
        try {
            Au = this.gcO.Au(this.pUz);
        } catch (Exception e) {
            x.w("MicroMsg.JsApiHandler", "isBusy, ex = " + e.getMessage());
            Au = false;
        }
        x.i("MicroMsg.JsApiHandler", "dealNextMsg isBusy = " + Au);
        if (Au) {
            x.w("MicroMsg.JsApiHandler", "dealNextMsg fail, msgHandler is busy now");
            return false;
        } else if (this.qhm.size() == 0) {
            x.w("MicroMsg.JsApiHandler", "msgList size is 0.");
            return false;
        } else {
            i iVar = (i) this.qhm.remove(0);
            if (iVar == null) {
                x.e("MicroMsg.JsApiHandler", "dealNextMsg fail, msg is null");
                return true;
            } else if (iVar.qkl == null || iVar.mcy == null || iVar.type == null || this.qhk == null) {
                x.e("MicroMsg.JsApiHandler", "dealNextMsg fail, can cause nullpointer, function = " + iVar.qkl + ", params = " + iVar.mcy + ", type = " + iVar.type + ", wv = " + this.qhk);
                return true;
            } else {
                if (!(this.qhp == null || this.qhp.get("srcUsername") == null || bi.oW(this.qhp.get("srcUsername").toString()))) {
                    iVar.mcy.put("src_username", this.qhp.get("srcUsername").toString());
                }
                if (!(this.qhp == null || this.qhp.get("srcDisplayname") == null || bi.oW(this.qhp.get("srcDisplayname").toString()))) {
                    iVar.mcy.put("src_displayname", this.qhp.get("srcDisplayname").toString());
                }
                if (!(this.qhp == null || this.qhp.get("KTemplateId") == null || bi.oW(this.qhp.get("KTemplateId").toString()))) {
                    iVar.mcy.put("tempalate_id", this.qhp.get("KTemplateId").toString());
                }
                if (this.qhp != null) {
                    iVar.mcy.put("message_id", this.qhp.get("message_id"));
                    iVar.mcy.put("message_index", this.qhp.get("message_index"));
                    iVar.mcy.put("webview_scene", this.qhp.get("scene"));
                    iVar.mcy.put("pay_channel", this.qhp.get("pay_channel"));
                    iVar.mcy.put("pay_scene", this.qhp.get("pay_scene"));
                    x.i("MicroMsg.JsApiHandler", "getPackageName %s", new Object[]{this.qhp.get("pay_package")});
                    if (this.qhp.get("pay_package") != null) {
                        iVar.mcy.put("pay_packageName", this.qhp.get("pay_package"));
                    }
                    iVar.mcy.put("stastic_scene", this.qhp.get("stastic_scene"));
                    iVar.mcy.put("open_from_scene", this.qhp.get("from_scence"));
                    Bundle bundle = new Bundle();
                    bundle.putString("__jsapi_fw_ext_info_key_current_url", this.qhk.getUrl());
                    iVar.mcy.put("__jsapi_fw_ext_info", bundle);
                }
                if (!(iVar.qkl.equals("shareWeibo") || iVar.qkl.equals("openUrlByExtBrowser") || iVar.qkl.equals("openUrlWithExtraWebview") || iVar.qkl.equals("openCustomWebview") || iVar.qkl.equals("openGameWebView") || iVar.qkl.equals("addToEmoticon") || iVar.qkl.equals(ax.NAME) || iVar.qkl.equals("openGameUrlWithExtraWebView"))) {
                    iVar.mcy.put("url", this.qhk.getUrl());
                    x.i("MicroMsg.JsApiHandler", "cuiqi wv.getUrl" + this.qhk.getUrl());
                }
                if (iVar.qkl.equalsIgnoreCase("openDesignerEmojiView") || iVar.qkl.equalsIgnoreCase("openEmotionDetailViewLocal") || iVar.qkl.equalsIgnoreCase("openDesignerEmojiView") || iVar.qkl.equalsIgnoreCase("openDesignerEmojiViewLocal") || iVar.qkl.equalsIgnoreCase("openDesignerEmojiView") || iVar.qkl.equalsIgnoreCase("openDesignerProfile") || iVar.qkl.equalsIgnoreCase("openDesignerProfileLocal") || iVar.qkl.equalsIgnoreCase("getSearchEmotionData")) {
                    iVar.mcy.put("searchID", Long.valueOf(bXX()));
                    x.d("MicroMsg.JsApiHandler", "emoji search id:%d", new Object[]{Long.valueOf(bXX())});
                }
                try {
                    JsapiPermissionWrapper bVR = this.qhr.bVR();
                    Bundle bundle2 = new Bundle();
                    if (bVR != null) {
                        bVR.toBundle(bundle2);
                    }
                    Au = this.gcO.a(iVar.type, iVar.qkl, iVar.qkj, bundle2, i.aq(iVar.mcy), this.pUz);
                } catch (Throwable e2) {
                    x.printErrStackTrace("MicroMsg.JsApiHandler", e2, "", new Object[0]);
                    x.w("MicroMsg.JsApiHandler", "handleMsg, ex = " + e2.getMessage());
                    Au = false;
                }
                x.i("MicroMsg.JsApiHandler", "dealNextMsg, %s, handleRet = %s", new Object[]{iVar.qkl, Boolean.valueOf(Au)});
                if (Au) {
                    return false;
                }
                return true;
            }
        }
    }

    public final void detach() {
        this.qhq = false;
        this.qhm.clear();
        this.qhl.clear();
        this.qhn = null;
    }

    public final void keep_setReturnValue(String str, String str2) {
        x.i("MicroMsg.JsApiHandler", "setResultValue, scene = " + str + ", resultValue = " + str2);
        x.i("MicroMsg.JsApiHandler", "edw setResultValue = threadId = " + Thread.currentThread().getId() + ", threadName = " + Thread.currentThread().getName());
        if (this.qhn != null) {
            Message obtain = Message.obtain();
            obtain.obj = str2;
            if (str.equals("SCENE_FETCHQUEUE")) {
                obtain.what = 1;
            } else if (str.equals("SCENE_HANDLEMSGFROMWX")) {
                obtain.what = 2;
            }
            this.qhn.sendMessage(obtain);
        }
    }

    public final void bXV() {
        if (this.qhq) {
            Map hashMap = new HashMap();
            hashMap.put("scene", "friend");
            this.qhk.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + i$a.a("menu:share:appmessage", hashMap, this.qhs, this.qht) + ")", null);
            try {
                this.gcO.H("scene", "friend", this.pUz);
                return;
            } catch (Exception e) {
                x.w("MicroMsg.JsApiHandler", "jsapiBundlePutString, ex = " + e.getMessage());
                return;
            }
        }
        x.e("MicroMsg.JsApiHandler", "onSendToFriend fail, not ready");
    }

    public final void f(Bundle bundle, String str) {
        if (!this.qhq || bundle == null) {
            x.e("MicroMsg.JsApiHandler", "onDownloadStateChange fail, not ready");
            return;
        }
        long j = bundle.getLong("download_manager_downloadid");
        String string = bundle.getString("download_manager_appid", "");
        int i = bundle.getInt("download_manager_errcode");
        x.i("MicroMsg.JsApiHandler", "onDownloadStateChange, downloadId = " + j + ", state = " + str + ", errCode = " + i);
        Map hashMap = new HashMap();
        hashMap.put("appid", string);
        hashMap.put("download_id", Long.valueOf(j));
        hashMap.put("err_code", Integer.valueOf(i));
        hashMap.put("state", str);
        ah.A(new 65(this, i$a.a(com.tencent.mm.plugin.game.gamewebview.b.a.c.NAME, hashMap, this.qhs, this.qht)));
    }

    public final void g(String str, long j, int i) {
        if (this.qhq) {
            Map hashMap = new HashMap();
            hashMap.put("appid", str);
            hashMap.put("download_id", Long.valueOf(j));
            hashMap.put("progress", Integer.valueOf(i));
            ah.A(new 66(this, i$a.a(b.NAME, hashMap, this.qhs, this.qht)));
            return;
        }
        x.e("MicroMsg.JsApiHandler", "onDownloadStateChange fail, not ready");
    }

    public final void cB(String str, int i) {
        if (this.qhq) {
            x.i("MicroMsg.JsApiHandler", "onExdeviceStateChange: device id = %s, state = %s", new Object[]{str, Integer.valueOf(i)});
            if (bi.oW(str)) {
                x.e("MicroMsg.JsApiHandler", "parameter error!!!");
                return;
            }
            Map hashMap = new HashMap();
            hashMap.put("deviceId", str);
            if (i == 2) {
                hashMap.put("state", "connected");
            } else if (i == 1) {
                hashMap.put("state", "connecting");
            } else {
                hashMap.put("state", "disconnected");
            }
            ah.A(new 2(this, i$a.a("onWXDeviceStateChange", hashMap, this.qhs, this.qht)));
            return;
        }
        x.e("MicroMsg.JsApiHandler", "onExdeviceStateChange fail, not ready");
    }

    public final void an(Map<String, Object> map) {
        if (this.qhq) {
            x.i("MicroMsg.JsApiHandler", "onVoicePlayEnd");
            final String a = i$a.a("onVoicePlayEnd", (Map) map, this.qhs, this.qht);
            ah.A(new Runnable() {
                public final void run() {
                    try {
                        d.this.qhk.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + a + ")", null);
                    } catch (Exception e) {
                        x.e("MicroMsg.JsApiHandler", "onVoicePlayEnd fail, ex = %s", new Object[]{e.getMessage()});
                    }
                }
            });
            return;
        }
        x.e("MicroMsg.JsApiHandler", "onVoicePlayEnd fail, not ready");
    }

    public final void ao(Map<String, Object> map) {
        if (this.qhq) {
            x.i("MicroMsg.JsApiHandler", "onVoiceRecordEnd");
            x.i("MicroMsg.JsApiHandler", "onVoiceRecordEnd event : %s", new Object[]{i$a.a("onVoiceRecordEnd", (Map) map, this.qhs, this.qht)});
            ah.A(new 9(this, r0));
            return;
        }
        x.e("MicroMsg.JsApiHandler", "onVoiceRecordEnd fail, not ready");
    }

    public final void cC(String str, int i) {
        if (this.qhq) {
            x.i("MicroMsg.JsApiHandler", "onImageUploadProgress, local id : %s, percent : %d", new Object[]{str, Integer.valueOf(i)});
            Map hashMap = new HashMap();
            hashMap.put("localId", str);
            hashMap.put("percent", Integer.valueOf(i));
            ah.A(new 11(this, i$a.a("onImageUploadProgress", hashMap, this.qhs, this.qht)));
            return;
        }
        x.e("MicroMsg.JsApiHandler", "onImageUploadProgress fail, not ready");
    }

    public final void cD(String str, int i) {
        if (this.qhq) {
            x.i("MicroMsg.JsApiHandler", "onImageDownloadProgress, serverId id : %s, percent : %d", new Object[]{str, Integer.valueOf(i)});
            Map hashMap = new HashMap();
            hashMap.put("serverId", str);
            hashMap.put("percent", Integer.valueOf(i));
            ah.A(new 13(this, i$a.a("onImageDownloadProgress", hashMap, this.qhs, this.qht)));
            return;
        }
        x.e("MicroMsg.JsApiHandler", "onImageDownloadProgress fail, not ready");
    }

    public final void cE(String str, int i) {
        if (this.qhq) {
            x.i("MicroMsg.JsApiHandler", "onVoiceUploadProgress, local id : %s, percent : %d", new Object[]{str, Integer.valueOf(i)});
            Map hashMap = new HashMap();
            hashMap.put("localId", str);
            hashMap.put("percent", Integer.valueOf(i));
            ah.A(new 14(this, i$a.a("onVoiceUploadProgress", hashMap, this.qhs, this.qht)));
            return;
        }
        x.e("MicroMsg.JsApiHandler", "onVoiceUploadProgress fail, not ready");
    }

    public final void cF(String str, int i) {
        if (this.qhq) {
            x.i("MicroMsg.JsApiHandler", "onVoiceDownloadProgress, serverId id : %s, percent : %d", new Object[]{str, Integer.valueOf(i)});
            Map hashMap = new HashMap();
            hashMap.put("serverId", str);
            hashMap.put("percent", Integer.valueOf(i));
            ah.A(new 15(this, i$a.a("onVoiceDownloadProgress", hashMap, this.qhs, this.qht)));
            return;
        }
        x.e("MicroMsg.JsApiHandler", "onVoiceDownloadProgress fail, not ready");
    }

    public final void cG(String str, int i) {
        if (this.qhq) {
            x.i("MicroMsg.JsApiHandler", "onVideoUploadoadProgress, local id : %s, percent : %d", new Object[]{str, Integer.valueOf(i)});
            Map hashMap = new HashMap();
            hashMap.put("localId", str);
            hashMap.put("percent", Integer.valueOf(i));
            ah.A(new 16(this, i$a.a("onVideoUploadProgress", hashMap, this.qhs, this.qht)));
            return;
        }
        x.e("MicroMsg.JsApiHandler", "onVideoUploadoadProgress fail, not ready");
    }

    public final void RF(String str) {
        try {
            Bundle bundle = new Bundle();
            JsapiPermissionWrapper bVR = this.qhr.bVR();
            if (bVR != null) {
                bVR.toBundle(bundle);
            }
            this.gcO.a(str, bundle, this.pUz);
        } catch (Exception e) {
            x.w("MicroMsg.JsApiHandler", "doProfile, ex = " + e.getMessage());
        }
    }

    public final void Bc(int i) {
        Map hashMap = new HashMap();
        hashMap.put("height", Integer.valueOf(a.ag(ad.getContext(), i)));
        ah.A(new 20(this, i$a.a("onGetKeyboardHeight", hashMap, this.qhs, this.qht)));
    }

    public final void kk(boolean z) {
        Map hashMap = new HashMap();
        hashMap.put("success", Boolean.valueOf(z));
        ah.A(new 22(this, i$a.a("onAddShortcutStatus", hashMap, this.qhs, this.qht)));
    }

    public final void RG(String str) {
        Map hashMap = new HashMap();
        hashMap.put("err_msg", str);
        ah.A(new 24(this, i$a.a("onBeaconMonitoring", hashMap, this.qhs, this.qht)));
    }

    public final void q(final String str, final Map<String, String> map) {
        x.d("MicroMsg.JsApiHandler", "onGetA8KeyUrl, fullUrl = %s", new Object[]{str});
        if (!bi.oW(str)) {
            this.qhw = str;
            if (map == null || map.size() == 0) {
                this.qhx = 0;
            } else {
                this.qhx = 1;
            }
            final String cH = cH(str, this.qhx);
            ah.A(new Runnable() {
                public final void run() {
                    try {
                        if (!(map == null || map.size() == 0)) {
                            com.tencent.xweb.c.ij(ad.getContext());
                            com.tencent.xweb.b cIi = com.tencent.xweb.b.cIi();
                            for (String str : map.keySet()) {
                                cIi.setCookie(bi.Xl(str), str + "=" + ((String) map.get(str)));
                            }
                            cIi.setCookie(bi.Xl(str), "httponly");
                            com.tencent.xweb.c.cIk();
                            com.tencent.xweb.c.sync();
                            x.i("MicroMsg.JsApiHandler", "cookies:%s", new Object[]{cIi.getCookie(bi.Xl(str))});
                        }
                        d.this.qhk.evaluateJavascript(String.format("javascript:(function(){ window.getA8KeyUrl='%s'; })()", new Object[]{str}), null);
                        d.this.qhk.evaluateJavascript("javascript:(function(){ window.isWeixinCached=true; })()", null);
                        if (d.this.qhq) {
                            d.this.qhk.evaluateJavascript(cH, null);
                            d.this.qhw = null;
                            d.this.qhx = 0;
                        }
                    } catch (Exception e) {
                        x.e("MicroMsg.JsApiHandler", "onGetA8KeyUrl fail, ex = %s", new Object[]{e.getMessage()});
                    }
                }
            });
        }
    }

    final String cH(String str, int i) {
        Map hashMap = new HashMap(2);
        hashMap.put("url", str);
        hashMap.put("set_cookie", Integer.valueOf(i));
        return RI(i$a.a("onGetA8KeyUrl", hashMap, this.qhs, this.qht));
    }

    public final synchronized void a(String str, int i, int i2, double d, double d2, float f) {
        if (this.qhB.ciq()) {
            this.qhB.J(1000, 1000);
        }
        JSONObject jSONObject = new JSONObject();
        int i3 = 0;
        if (d > 0.0d && d < 0.5d) {
            i3 = 1;
        }
        try {
            if (!this.qhA.contains(String.valueOf(str) + String.valueOf(i) + String.valueOf(i2))) {
                this.qhA.add(String.valueOf(str) + String.valueOf(i) + String.valueOf(i2));
                jSONObject.put("uuid", String.valueOf(str));
                jSONObject.put("major", String.valueOf(i));
                jSONObject.put("minor", String.valueOf(i2));
                jSONObject.put("accuracy", String.valueOf(d));
                jSONObject.put("rssi", String.valueOf(d2));
                jSONObject.put("heading", String.valueOf(f));
                jSONObject.put("proximity", String.valueOf(i3));
                this.qhz.put(jSONObject);
                this.qhy.put("beacons", this.qhz);
                this.qhy.put("err_msg", "onBeaconsInRange:ok");
            }
        } catch (Exception e) {
            x.e("MicroMsg.JsApiHandler", "parse json error in onBeaconsInRange!! ", new Object[]{e.getMessage()});
        }
        i$a.a("onBeaconsInRange", this.qhy, this.qhs, this.qht);
        return;
    }

    public final void a(String str, String str2, Map<String, Object> map, boolean z) {
        if (!bi.oW(str)) {
            if (str2 == null || str2.length() == 0 || str == null) {
                x.e("MicroMsg.JsApiHandler", "doCallback, invalid args, ret = " + str2);
            } else {
                Map hashMap = new HashMap();
                hashMap.put("err_msg", str2);
                if (map != null && map.size() > 0) {
                    x.i("MicroMsg.JsApiHandler", "doCallback, retValue size = " + map.size());
                    hashMap.putAll(map);
                }
                String a = i$a.a("callback", str, hashMap, null, this.qhs, this.qht);
                x.i("MicroMsg.JsApiHandler", "doCallback, ret = " + str2 + ", cb = " + a);
                if (!(a == null || this.qhk == null)) {
                    ah.A(new 28(this, a));
                }
            }
        }
        if (z) {
            bVo();
        }
    }

    public final void bVo() {
        if (this.qhn != null) {
            this.qhn.post(new 27(this));
        }
    }

    public final void bVn() {
        if (this.qhm != null) {
            this.qhm.clear();
        }
    }

    public final void ap(Map<String, Object> map) {
        if (this.qhq) {
            x.i("MicroMsg.JsApiHandler", "onSelectContact success, ready");
            ah.A(new 29(this, i$a.a("onSelectContact", (Map) map, this.qhs, this.qht)));
            return;
        }
        x.e("MicroMsg.JsApiHandler", "onSelectContact fail, not ready");
    }

    public final void d(String str, boolean z, String str2) {
        if (this.qhq) {
            x.i("MicroMsg.JsApiHandler", "onSearchDataReady success, ready");
            Map hashMap = new HashMap();
            hashMap.put("json", str);
            hashMap.put("newQuery", Boolean.valueOf(z));
            hashMap.put("requestId", str2);
            ah.A(new 35(this, i$a.a("onSearchDataReady", hashMap, this.qhs, this.qht)));
            return;
        }
        x.e("MicroMsg.JsApiHandler", "onSearchDataReady fail, not ready");
    }

    public final void a(String str, boolean z, String str2, String str3) {
        if (this.qhq) {
            x.i("MicroMsg.JsApiHandler", "onSearchWAWidgetOnTapCallback success, ready");
            Map hashMap = new HashMap();
            hashMap.put("eventId", str);
            hashMap.put("widgetId", str3);
            hashMap.put("hitTest", Boolean.valueOf(z));
            hashMap.put("err_msg", str2);
            ah.A(new 38(this, i$a.a("onSearchWAWidgetOnTapCallback", hashMap, this.qhs, this.qht)));
            return;
        }
        x.e("MicroMsg.JsApiHandler", "onSearchWAWidgetOnTapCallback fail, not ready");
    }

    public final void cI(String str, int i) {
        if (this.qhq) {
            x.i("MicroMsg.JsApiHandler", "onSearchWAWidgetStateChange success, ready");
            Map hashMap = new HashMap();
            hashMap.put("widgetId", str);
            hashMap.put("state", Integer.valueOf(i));
            ah.A(new 42(this, i$a.a("onSearchWAWidgetStateChange", hashMap, this.qhs, this.qht)));
            return;
        }
        x.e("MicroMsg.JsApiHandler", "onSearchWAWidgetStateChange fail, not ready");
    }

    public final void a(String str, String str2, JSONArray jSONArray, int i) {
        if (this.qhq) {
            x.i("MicroMsg.JsApiHandler", "onSearchInputChange success, ready %s %s %s", new Object[]{str, str2, jSONArray.toString()});
            Map hashMap = new HashMap();
            hashMap.put("query", str);
            hashMap.put("custom", str2);
            hashMap.put("tagList", jSONArray);
            hashMap.put("isCancelButtonClick", Integer.valueOf(i));
            ah.A(new 45(this, i$a.a("onSearchInputChange", hashMap, this.qhs, this.qht)));
            return;
        }
        x.e("MicroMsg.JsApiHandler", "onSearchInputChange fail, not ready");
    }

    public final void a(String str, String str2, JSONArray jSONArray) {
        Map hashMap = new HashMap();
        hashMap.put("query", str);
        hashMap.put("custom", str2);
        hashMap.put("tagList", jSONArray);
        a("onSearchInputChange", hashMap, null);
    }

    public final boolean a(String str, String str2, String str3, String str4, String str5, Map<String, Object> map, Map<String, Object> map2) {
        JSONObject jSONObject = new JSONObject();
        if (map2 != null) {
            for (Entry entry : map2.entrySet()) {
                if (entry.getValue() != null) {
                    try {
                        jSONObject.put((String) entry.getKey(), new JSONObject(entry.getValue().toString()));
                    } catch (Throwable e) {
                        Throwable th = e;
                        try {
                            jSONObject.put((String) entry.getKey(), new JSONArray(entry.getValue().toString()));
                        } catch (JSONException e2) {
                            try {
                                jSONObject.put((String) entry.getKey(), entry.getValue());
                            } catch (JSONException e3) {
                                x.printErrStackTrace("MicroMsg.JsApiHandler", th, "", new Object[0]);
                            }
                        }
                    }
                }
            }
        }
        try {
            for (Entry entry2 : map.entrySet()) {
                jSONObject.put((String) entry2.getKey(), entry2.getValue());
            }
        } catch (Throwable e4) {
            x.printErrStackTrace("MicroMsg.JsApiHandler", e4, "", new Object[0]);
        }
        try {
            jSONObject.put("scene", str);
            jSONObject.put("type", str2);
            jSONObject.put("isSug", str3);
            jSONObject.put("isLocalSug", str4);
            jSONObject.put("sessionId", str5);
        } catch (Throwable e42) {
            x.printErrStackTrace("MicroMsg.JsApiHandler", e42, "", new Object[0]);
        }
        a("switchToTabSearch", null, jSONObject);
        return true;
    }

    public final void a(String str, Map<String, Object> map, JSONObject jSONObject) {
        if (!this.qhq || (map == null && jSONObject == null)) {
            x.e("MicroMsg.JsApiHandler", "onSendEventToJSBridge fail, event=%s", new Object[]{str});
            return;
        }
        String a;
        String str2 = "MicroMsg.JsApiHandler";
        String str3 = "onSendEventToJSBridge success, event=%s, params=%s, jsonParams=%s";
        Object[] objArr = new Object[3];
        objArr[0] = str;
        objArr[1] = map == null ? "" : map.toString();
        objArr[2] = jSONObject == null ? "" : jSONObject.toString();
        x.i(str2, str3, objArr);
        if (map != null) {
            a = i$a.a(str, (Map) map, this.qhs, this.qht);
        } else {
            a = i$a.a(str, jSONObject, this.qhs, this.qht);
        }
        ah.A(new 46(this, a, str));
    }

    public final boolean a(String str, String str2, String str3, String str4, String str5, String str6, String str7, JSONArray jSONArray, String str8, int i, Map<String, Object> map) {
        if (this.qhq) {
            x.i("MicroMsg.JsApiHandler", "switchToTabSearch success, ready %s %s %s %s %s", new Object[]{str, str2, str3, str4, str5});
            JSONObject jSONObject = new JSONObject();
            if (map != null) {
                for (Entry entry : map.entrySet()) {
                    if (entry.getValue() != null) {
                        try {
                            jSONObject.put((String) entry.getKey(), new JSONObject(entry.getValue().toString()));
                        } catch (Throwable e) {
                            Throwable th = e;
                            try {
                                jSONObject.put((String) entry.getKey(), new JSONArray(entry.getValue().toString()));
                            } catch (JSONException e2) {
                                try {
                                    jSONObject.put((String) entry.getKey(), entry.getValue());
                                } catch (JSONException e3) {
                                    x.printErrStackTrace("MicroMsg.JsApiHandler", th, "", new Object[0]);
                                }
                            }
                        }
                    }
                }
            }
            try {
                jSONObject.put("type", str);
                jSONObject.put("isMostSearchBiz", str2);
                jSONObject.put("isSug", str3);
                jSONObject.put("isLocalSug", str5);
                jSONObject.put("scene", str4);
                jSONObject.put("query", str6);
                jSONObject.put("custom", str7);
                jSONObject.put("tagList", jSONArray);
                jSONObject.put("isBackButtonClick", 0);
                jSONObject.put("sugId", str8);
                jSONObject.put("sugClickType", i);
            } catch (Throwable e4) {
                x.printErrStackTrace("MicroMsg.JsApiHandler", e4, "", new Object[0]);
            }
            final String a = i$a.a("switchToTabSearch", jSONObject, this.qhs, this.qht);
            ah.A(new Runnable() {
                public final void run() {
                    try {
                        d.this.qhk.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + a + ")", null);
                    } catch (Exception e) {
                        x.e("MicroMsg.JsApiHandler", "switchToTabSearch fail, ex = %s", new Object[]{e.getMessage()});
                    }
                }
            });
            return true;
        }
        x.e("MicroMsg.JsApiHandler", "switchToTabSearch fail, not ready");
        return false;
    }

    public final void a(String str, String str2, JSONArray jSONArray, int i, Map<String, Object> map) {
        String str3 = "";
        if (this.qhq) {
            x.i("MicroMsg.JsApiHandler", "onSearchInputConfirm success, ready %s %s %s", new Object[]{str, str2, jSONArray.toString()});
            JSONObject jSONObject = new JSONObject();
            if (map != null) {
                for (Entry entry : map.entrySet()) {
                    if (entry.getValue() != null) {
                        try {
                            jSONObject.put((String) entry.getKey(), new JSONObject(entry.getValue().toString()));
                        } catch (Throwable e) {
                            Throwable th = e;
                            try {
                                jSONObject.put((String) entry.getKey(), new JSONArray(entry.getValue().toString()));
                            } catch (JSONException e2) {
                                try {
                                    jSONObject.put((String) entry.getKey(), entry.getValue());
                                } catch (JSONException e3) {
                                    x.printErrStackTrace("MicroMsg.JsApiHandler", th, "", new Object[0]);
                                }
                            }
                        }
                    }
                }
            }
            try {
                jSONObject.put("query", str);
                jSONObject.put("custom", str2);
                jSONObject.put("tagList", jSONArray);
                jSONObject.put("isBackButtonClick", i);
                jSONObject.put("sugId", str3);
                jSONObject.put("sugClickType", 0);
            } catch (Throwable e4) {
                x.printErrStackTrace("MicroMsg.JsApiHandler", e4, "", new Object[0]);
            }
            ah.A(new 48(this, i$a.a("onSearchInputConfirm", jSONObject, this.qhs, this.qht)));
            return;
        }
        x.e("MicroMsg.JsApiHandler", "onSearchInputConfirm fail, not ready");
    }

    public final void RH(String str) {
        if (this.qhq) {
            x.i("MicroMsg.JsApiHandler", "onSearchSuggestionDataReady success, ready");
            Map hashMap = new HashMap();
            hashMap.put("json", str);
            ah.A(new 49(this, i$a.a("onSearchSuggestionDataReady", hashMap, this.qhs, this.qht)));
            return;
        }
        x.e("MicroMsg.JsApiHandler", "onSearchSuggestionDataReady fail, not ready");
    }

    public final void aV(int i, String str) {
        if (this.qhq) {
            Map hashMap = new HashMap();
            hashMap.put("ret", Integer.valueOf(i));
            hashMap.put("data", str);
            ah.A(new 50(this, i$a.a("onSearchImageListReady", hashMap, this.qhs, this.qht)));
            return;
        }
        x.e("MicroMsg.JsApiHandler", "onSearchImageListReady fail, not ready");
    }

    public final void i(int i, String str, int i2) {
        if (this.qhq) {
            x.i("MicroMsg.JsApiHandler", "onTeachSearchDataReady success, ready");
            Map hashMap = new HashMap();
            hashMap.put("requestType", Integer.valueOf(i));
            hashMap.put("json", str);
            hashMap.put("isCacheData", Integer.valueOf(i2));
            ah.A(new 51(this, i$a.a("onTeachSearchDataReady", hashMap, this.qhs, this.qht)));
            return;
        }
        x.e("MicroMsg.JsApiHandler", "onTeachSearchDataReady fail, not ready");
    }

    public final void cJ(String str, int i) {
        if (this.qhq) {
            x.i("MicroMsg.JsApiHandler", "onMusicStatusChanged success, ready");
            Map hashMap = new HashMap();
            hashMap.put("snsid", str);
            hashMap.put("status", Integer.valueOf(i));
            ah.A(new 53(this, i$a.a("onMusicStatusChanged", hashMap, this.qhs, this.qht)));
            return;
        }
        x.e("MicroMsg.JsApiHandler", "onMusicStatusChanged fail, not ready");
    }

    public static String RI(String str) {
        return String.format("javascript:WeixinJSBridge._handleMessageFromWeixin(%s)", new Object[]{bi.oV(str)});
    }

    public final void kl(boolean z) {
        x.i("MicroMsg.JsApiHandler", "getHtmlContent, ready(%s).", new Object[]{Boolean.valueOf(this.qhq)});
        if (this.qhk != null && this.gcO != null && this.qhq) {
            if (z) {
                this.qhk.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + i$a.a("sys:get_html_content", new HashMap(), this.qhs, this.qht) + ")", null);
                return;
            }
            List bVB;
            try {
                bVB = this.gcO.bVB();
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.JsApiHandler", e, "", new Object[0]);
                bVB = null;
            }
            Uri parse = Uri.parse(this.qhk.getUrl());
            if (parse != null) {
                x.d("MicroMsg.JsApiHandler", "wv hijack url host" + parse.getHost());
            }
            if (bVB != null && parse != null && bVB.contains(parse.getHost())) {
                this.qhk.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + i$a.a("sys:get_html_content", new HashMap(), this.qhs, this.qht) + ")", null);
            }
        }
    }

    public final void bXW() {
        if (this.qhq) {
            x.i("MicroMsg.JsApiHandler", "onEmojiStoreShowLoading success, ready");
            Map hashMap = new HashMap();
            hashMap.put("needShow", Boolean.valueOf(true));
            ah.A(new 57(this, i$a.a("showLoading", hashMap, this.qhs, this.qht)));
            return;
        }
        x.e("MicroMsg.JsApiHandler", "onEmojiStoreShowLoading fail, not ready");
    }

    public final void RJ(String str) {
        if (!bi.oW(str)) {
            Map hashMap = new HashMap();
            hashMap.put("netType", str);
            ah.A(new 59(this, i$a.a("onNetWorkChange", hashMap, this.qhs, this.qht)));
        }
    }

    public final long bXX() {
        x.d("MicroMsg.JsApiHandler", "cpan emoji get SearchID:%d", new Object[]{Long.valueOf(this.qhC)});
        return this.qhC;
    }

    private String RK(String str) {
        String url = this.qhk.getUrl();
        try {
            x.i("MicroMsg.JsApiHandler", "generate upload file name, url=%s, tag=%s, fullName=%s", new Object[]{url, str, com.tencent.mm.compatible.util.e.dgo + m.cw(url + str)});
            return com.tencent.mm.compatible.util.e.dgo + m.cw(url + str);
        } catch (Throwable e) {
            x.e("MicroMsg.JsApiHandler", "generating temp file name failed, url is " + url);
            x.printErrStackTrace("MicroMsg.JsApiHandler", e, "", new Object[0]);
            return null;
        }
    }

    private static boolean r(String str, Map<String, Integer> map) {
        Throwable e;
        if (bi.oW(str) || map == null) {
            x.w("MicroMsg.JsApiHandler", "write to file error, path is null or empty, or data is empty");
            return false;
        }
        File file = new File(str);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (Throwable e2) {
                x.e("MicroMsg.JsApiHandler", "creating file failed, filePath is " + str);
                x.printErrStackTrace("MicroMsg.JsApiHandler", e2, "", new Object[0]);
                return false;
            }
        }
        OutputStream outputStream = null;
        OutputStream bufferedOutputStream;
        try {
            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(str, true));
            try {
                for (String str2 : map.keySet()) {
                    bufferedOutputStream.write((((Integer) map.get(str2)).intValue() + " " + str2).getBytes());
                    bufferedOutputStream.write(13);
                    bufferedOutputStream.write(10);
                }
                bufferedOutputStream.flush();
                try {
                    bufferedOutputStream.close();
                } catch (Throwable e22) {
                    x.printErrStackTrace("MicroMsg.JsApiHandler", e22, "", new Object[0]);
                }
                x.d("MicroMsg.JsApiHandler", "writeToFile ok! " + str);
                return true;
            } catch (Exception e3) {
                e22 = e3;
                outputStream = bufferedOutputStream;
                try {
                    x.printErrStackTrace("MicroMsg.JsApiHandler", e22, "", new Object[0]);
                    x.w("MicroMsg.JsApiHandler", "write to file error");
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (Throwable e222) {
                            x.printErrStackTrace("MicroMsg.JsApiHandler", e222, "", new Object[0]);
                        }
                    }
                    return false;
                } catch (Throwable th) {
                    e222 = th;
                    bufferedOutputStream = outputStream;
                    if (bufferedOutputStream != null) {
                        try {
                            bufferedOutputStream.close();
                        } catch (Throwable e4) {
                            x.printErrStackTrace("MicroMsg.JsApiHandler", e4, "", new Object[0]);
                        }
                    }
                    throw e222;
                }
            } catch (Throwable th2) {
                e222 = th2;
                if (bufferedOutputStream != null) {
                    try {
                        bufferedOutputStream.close();
                    } catch (Throwable e42) {
                        x.printErrStackTrace("MicroMsg.JsApiHandler", e42, "", new Object[0]);
                    }
                }
                throw e222;
            }
        } catch (Exception e5) {
            e222 = e5;
            x.printErrStackTrace("MicroMsg.JsApiHandler", e222, "", new Object[0]);
            x.w("MicroMsg.JsApiHandler", "write to file error");
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (Throwable e2222) {
                    x.printErrStackTrace("MicroMsg.JsApiHandler", e2222, "", new Object[0]);
                }
            }
            return false;
        } catch (Throwable th3) {
            e2222 = th3;
            bufferedOutputStream = null;
            if (bufferedOutputStream != null) {
                try {
                    bufferedOutputStream.close();
                } catch (Throwable e422) {
                    x.printErrStackTrace("MicroMsg.JsApiHandler", e422, "", new Object[0]);
                }
            }
            throw e2222;
        }
    }

    private static boolean ft(String str, String str2) {
        Throwable e;
        if (bi.oW(str) || bi.oW(str2)) {
            x.w("MicroMsg.JsApiHandler", "write to file error, path is null or empty, or data is empty");
            return false;
        }
        File file = new File(str);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (Throwable e2) {
                x.e("MicroMsg.JsApiHandler", "creating file failed, filePath is " + str);
                x.printErrStackTrace("MicroMsg.JsApiHandler", e2, "", new Object[0]);
                return false;
            }
        }
        OutputStream outputStream = null;
        try {
            OutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(str, true));
            try {
                outputStream = new FileOutputStream(str);
                outputStream.write(str2.getBytes());
                outputStream.write(13);
                outputStream.write(10);
                outputStream.flush();
                try {
                    outputStream.close();
                } catch (Throwable e3) {
                    x.printErrStackTrace("MicroMsg.JsApiHandler", e3, "", new Object[0]);
                }
                x.d("MicroMsg.JsApiHandler", "writeToFile ok! " + str);
                return true;
            } catch (Exception e4) {
                e2 = e4;
                outputStream = bufferedOutputStream;
                try {
                    x.printErrStackTrace("MicroMsg.JsApiHandler", e2, "", new Object[0]);
                    x.w("MicroMsg.JsApiHandler", "write to file error");
                    if (outputStream != null) {
                        return false;
                    }
                    try {
                        outputStream.close();
                        return false;
                    } catch (Throwable e22) {
                        x.printErrStackTrace("MicroMsg.JsApiHandler", e22, "", new Object[0]);
                        return false;
                    }
                } catch (Throwable th) {
                    e22 = th;
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (Throwable e32) {
                            x.printErrStackTrace("MicroMsg.JsApiHandler", e32, "", new Object[0]);
                        }
                    }
                    throw e22;
                }
            } catch (Throwable th2) {
                e22 = th2;
                outputStream = bufferedOutputStream;
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (Throwable e322) {
                        x.printErrStackTrace("MicroMsg.JsApiHandler", e322, "", new Object[0]);
                    }
                }
                throw e22;
            }
        } catch (Exception e5) {
            e22 = e5;
            x.printErrStackTrace("MicroMsg.JsApiHandler", e22, "", new Object[0]);
            x.w("MicroMsg.JsApiHandler", "write to file error");
            if (outputStream != null) {
                return false;
            }
            try {
                outputStream.close();
                return false;
            } catch (Throwable e222) {
                x.printErrStackTrace("MicroMsg.JsApiHandler", e222, "", new Object[0]);
                return false;
            }
        }
    }
}

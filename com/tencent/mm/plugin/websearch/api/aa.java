package com.tencent.mm.plugin.websearch.api;

import android.content.Context;
import android.content.MutableContextWrapper;
import android.webkit.ValueCallback;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.ui.widget.MMWebView.a;
import com.tencent.xweb.WebView;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;

public final class aa implements h {
    String TAG = "MicroMsg.WebSearch.WebSearchPreloadMgr";
    private ah egm;
    private boolean gte = false;
    private HashSet<Object> gtg = new HashSet();
    int pMb;
    boolean pMc;
    List<ab> pMd = new LinkedList();
    long pMe;

    public aa(int i) {
        this.pMb = i;
        this.TAG += "_" + i;
        this.egm = new ah();
    }

    public final void PU(String str) {
        if (ad.cie()) {
            int i;
            if (this.pMb == 2 || !af.bTr().bTs()) {
                boolean i2;
                Context context = ad.getContext();
                if (WebView.isXWalk() || WebView.getUsingTbsCoreVersion(context) != 0) {
                    i2 = true;
                } else {
                    x.i("XWebUtil", "can not preload without x5 or xwalk");
                    i2 = 0;
                }
                if (i2 == 0) {
                    x.i(this.TAG, "isOpenRecommendPreload webview not support");
                    i2 = true;
                    if (i2 != 0) {
                        x.w(this.TAG, " preload forbidden");
                        return;
                    } else if (!ad.cie()) {
                        x.w(this.TAG, "preload please call from tools proc");
                        return;
                    } else if (!ah.isMainThread()) {
                        x.w(this.TAG, "preload please call from main thread");
                        return;
                    } else if (!this.gte) {
                        this.gte = true;
                        x.i(this.TAG, "preloading %s ", new Object[]{str});
                        this.egm.H(new 1(this, str));
                        return;
                    } else {
                        return;
                    }
                }
            }
            x.i(this.TAG, "use sys webview");
            x.i(this.TAG, "use sys webview 2");
            i2 = 0;
            if (i2 != 0) {
                x.w(this.TAG, " preload forbidden");
                return;
            } else if (!ad.cie()) {
                x.w(this.TAG, "preload please call from tools proc");
                return;
            } else if (!ah.isMainThread()) {
                x.w(this.TAG, "preload please call from main thread");
                return;
            } else if (!this.gte) {
                this.gte = true;
                x.i(this.TAG, "preloading %s ", new Object[]{str});
                this.egm.H(new 1(this, str));
                return;
            } else {
                return;
            }
        }
        x.w(this.TAG, "preload please call from tools proc");
    }

    final boolean a(final MMWebView mMWebView) {
        String convertStreamToString;
        x.i(this.TAG, "begin jsapi init,wv %s", new Object[]{mMWebView.toString()});
        try {
            convertStreamToString = bi.convertStreamToString(mMWebView.getContext().getAssets().open("jsapi/wxjs.js"));
        } catch (Throwable e) {
            x.printErrStackTrace(this.TAG, e, "", new Object[0]);
            convertStreamToString = null;
        }
        if (convertStreamToString == null) {
            x.e(this.TAG, "loadJavaScript fail, jsContent is null");
            return false;
        } else if (mMWebView == null) {
            x.e(this.TAG, "loadJavaScript, viewWV is null");
            return false;
        } else {
            mMWebView.evaluateJavascript("javascript:" + convertStreamToString, new 3(this, mMWebView));
            StringBuilder stringBuilder = new StringBuilder("javascript:WeixinJSBridge._handleMessageFromWeixin(");
            Map hashMap = new HashMap();
            hashMap.put("webview_type", "1");
            hashMap.put("init_url", mMWebView.getUrl());
            hashMap.put("init_font_size", "1");
            mMWebView.getRandomStr();
            mMWebView.evaluateJavascript(stringBuilder.append(a.e("event", "sys:init", hashMap)).append(")").toString(), new 4(this, mMWebView));
            stringBuilder = new StringBuilder("javascript:WeixinJSBridge._handleMessageFromWeixin(");
            mMWebView.getRandomStr();
            mMWebView.evaluateJavascript(stringBuilder.append(a.e("event", "sys:bridged", null)).append(")").toString(), new ValueCallback<String>() {
                public final /* synthetic */ void onReceiveValue(Object obj) {
                    String str = (String) obj;
                    x.i(aa.this.TAG, "loadJS, sys:bridged callback %s,view %s", new Object[]{str, mMWebView.toString()});
                }
            });
            stringBuilder = new StringBuilder("javascript:WeixinJSBridge._handleMessageFromWeixin(");
            convertStreamToString = "sys:attach_runOn3rd_apis";
            hashMap = new HashMap();
            Collection linkedList = new LinkedList();
            linkedList.add("menu:share:timeline");
            linkedList.add("menu:share:appmessage");
            linkedList.add("menu:share:weiboApp");
            linkedList.add("menu:share:QZone");
            linkedList.add("menu:share:qq");
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
            linkedList.add("wxdownload:state_change");
            linkedList.add("wxdownload:progress_change");
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
            linkedList.add("onBackgroundAudioStateChange");
            if (!bi.cX(null)) {
                linkedList.addAll(null);
            }
            hashMap.put("__runOn3rd_apis", new JSONArray(linkedList));
            mMWebView.getRandomStr();
            mMWebView.evaluateJavascript(stringBuilder.append(a.e("event", convertStreamToString, hashMap)).append(")").toString(), new 6(this, mMWebView));
            x.i(this.TAG, "jsapi init done");
            return true;
        }
    }

    final MMWebView bTf() {
        try {
            Context mutableContextWrapper = new MutableContextWrapper(ad.getContext());
            if (this.pMb == 2) {
                return a.cS(mutableContextWrapper);
            }
            return af.bTr().bTs() ? a.hf(mutableContextWrapper) : a.cS(mutableContextWrapper);
        } catch (Throwable e) {
            x.printErrStackTrace(this.TAG, e, "", new Object[0]);
            return null;
        }
    }

    public final Object ev(Context context) {
        if (ad.cie()) {
            x.i(this.TAG, "getWebView cached webview size %d", new Object[]{Integer.valueOf(this.pMd.size())});
            if (this.pMd.size() <= 0) {
                return null;
            }
            if (this.pMc) {
                ab abVar = (ab) this.pMd.get(0);
                if (abVar == null) {
                    this.pMd.remove(0);
                    return null;
                }
                MMWebView mMWebView = (MMWebView) abVar.pMi;
                if (mMWebView.getContext() instanceof MutableContextWrapper) {
                    ((MutableContextWrapper) mMWebView.getContext()).setBaseContext(context);
                }
                this.pMd.remove(abVar);
                this.pMc = false;
                return abVar;
            }
            x.i(this.TAG, "preload unfinished");
            return null;
        }
        x.w(this.TAG, "getWebView please call from tools proc");
        return null;
    }

    final synchronized void done() {
        x.i(this.TAG, "preInit finished");
        this.gte = false;
        Iterator it = this.gtg.iterator();
        while (it.hasNext()) {
            it.next();
        }
        this.gtg.clear();
    }
}

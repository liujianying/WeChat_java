package com.tencent.mm.protocal;

import com.tencent.mm.plugin.appbrand.jsapi.JsApiAdDataReport;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiPausePlayVoice;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiSetBackgroundAudioState;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiStartPlayVoice;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiStartRecordVoice;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.GameJsApiGetOpenDeviceId;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.aa;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.aq;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.as;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.at;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.av;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.b;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.d;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.n;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.o;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.t;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.v;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.w;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class c {
    private static Map<String, g> qVC = null;

    public static class af extends g {
        public af() {
            super("clearLocalData", "clearLocalData", 181, false);
        }
    }

    public static class al extends g {
        public al() {
            super("configWXDeviceWiFi", "configWXDeviceWiFi", 126, true);
        }
    }

    public static class ao extends g {
        public ao() {
            super("connectWXDevice", "connectWXDevice", 123, true);
        }
    }

    public static class bb extends g {
        public bb() {
            super("openEmotionUrl", "openEmotionUrl", 20000, false);
        }
    }

    public static class bd extends g {
        public bd() {
            super("enablePullDownRefresh", "enablePullDownRefresh", 199, false);
        }
    }

    private static final class bg extends g {
        bg() {
            super("requestWxFacePictureVerifyUnionVideo", "requestWxFacePictureVerifyUnionVideo", 264, true);
        }
    }

    public static class bo extends g {
        public bo() {
            super("getCurrentSSID", "getCurrentSSID", 176, true);
        }
    }

    public static class br extends g {
        public br() {
            super("getEnterpriseChat", "getEnterpriseChat", 244, false);
        }
    }

    public static class bv extends g {
        public bv() {
            super("getH5PrepayRequest", "getH5PrepayRequest", 137, true);
        }
    }

    public static class bw extends g {
        public bw() {
            super("getH5TransactionRequest", "getH5TransactionRequest", 138, true);
        }
    }

    public static class by extends g {
        public by() {
            super("getLocalData", "getLocalData", 179, false);
        }
    }

    public static class cj extends g {
        public cj() {
            super("getSearchData", "", 10000, false);
        }
    }

    public static class cl extends g {
        public cl() {
            super("getSearchEmotionData", "getSearchEmotionData", 20000, false);
        }
    }

    public static class cn extends g {
        public cn() {
            super("getSearchHistory", "", 10000, false);
        }
    }

    public static class cp extends g {
        public cp() {
            super("getSearchSnsImageList", "", 10000, false);
        }
    }

    private static final class cx extends g {
        cx() {
            super(t.NAME, t.NAME, -3, false);
        }
    }

    private static final class da extends g {
        da() {
            super("handleWCPayWalletBuffer", "handleWCPayWalletBuffer", 294, false);
        }
    }

    public static class db extends g {
        public db() {
            super("hideAllNonBaseMenuItem", "hideAllNonBaseMenuItem", 93, false);
        }
    }

    public static class dd extends g {
        public dd() {
            super("hideNavigationBarLoading", "hideNavigationBarLoading", 198, false);
        }
    }

    private static final class dt extends g {
        dt() {
            super("launchMiniProgram", "launchMiniProgram", 277, true);
        }
    }

    public static class dv extends g {
        public dv() {
            super("log", "", 0, false);
        }
    }

    private static final class dx extends g {
        dx() {
            super("makePhoneCall", "makePhoneCall", 10000, true);
        }
    }

    public static class ei extends g {
        public ei() {
            super("nfcTransceive", "nfcTransceive", 141, false);
        }
    }

    private static final class el extends g {
        el() {
            super("openADCanvas", "openADCanvas", 283, true);
        }
    }

    public static class f extends g {
        public f() {
            super("scanCover", "scanCover", 136, true);
        }
    }

    public static class fa extends g {
        public fa() {
            super("openLuckyMoneyDetailView", "openLuckyMoneyDetailView", 245, false);
        }
    }

    public static class fd extends g {
        public fd() {
            super("openMyDeviceProfile", "openMyDeviceProfile", 145, false);
        }
    }

    public static class fl extends g {
        public fl() {
            super("openSecurityView", "openSecurityView", 229, false);
        }
    }

    public static class fs extends g {
        public fs() {
            super("getBrandWCPayCreateCreditCardRequest", "get_wcpay_create_credit_card_request", 65, true);
        }
    }

    private static final class fv extends g {
        fv() {
            super("operateBackgroundAudio", "operateBackgroundAudio", 261, false);
        }
    }

    public static class gg extends g {
        public gg() {
            super("profile", "profile", 2, true);
        }
    }

    public static class gi extends g {
        public gi() {
            super("quicklyAddBrandContact", "quicklyAddBrandContact", 166, true);
        }
    }

    private static final class gk extends g {
        gk() {
            super("recordVideo", "recordVideo", 251, true);
        }
    }

    public static class gm extends g {
        public gm() {
            super("removeSearchWAWidgetView", "", 10000, false);
        }
    }

    private static final class gv extends g {
        gv() {
            super("requestWxFaceVerifyInternal", "requestWxFaceVerifyInternal", 273, true);
        }
    }

    public static class h extends g {
        public h() {
            super("addContact", "add_contact", 5, true);
        }
    }

    public static class ha extends g {
        public ha() {
            super("scanQRCode", "scanQRCode", 7, true);
        }
    }

    private static final class hq extends g {
        hq() {
            super("setWCPayPassword", "setWCPayPassword", 289, true);
        }
    }

    private static final class hu extends g {
        hu() {
            super(at.NAME, at.NAME, at.CTRL_BYTE, false);
        }
    }

    public static class i extends g {
        public i() {
            super("addCustomMenuItems", "addCustomMenuItems", 164, false);
        }
    }

    public static class if extends g {
        public if() {
            super("setSendDataDirection", "setSendDataDirection", 127, false);
        }
    }

    private static final class ii extends g {
        ii() {
            super("shareEmoticon", "shareEmoticon", 275, true);
        }
    }

    public static class ja extends g {
        public ja() {
            super("startScanWXDevice", "startScanWXDevice", 121, true);
        }
    }

    public static class jp extends g {
        public jp() {
            super("updateReddotTimeStamps", "", 10000, false);
        }
    }

    private static final class js extends g {
        js() {
            super("uploadEncryptMediaFile", "uploadEncryptMediaFile", 253, false);
        }
    }

    public static class k extends g {
        public k() {
            super("addDownloadTaskStraight", "add_download_task_straight", 269, true);
        }
    }

    public static class kd extends g {
        public kd() {
            super("videoProxySetPlayerState", "videoProxySetPlayerState", 159, false);
        }
    }

    public static class kf extends g {
        public kf() {
            super("videoProxyStartPlay", "videoProxyStartPlay", 157, false);
        }
    }

    public static class kh extends g {
        public kh() {
            super("publicCache", "publicCache", 149, false);
        }
    }

    private static final class kr extends g {
        kr() {
            super("openRealnameAuth", "openRealnameAuth", 314, true);
        }
    }

    public static class ks extends g {
        public ks() {
            super("WNNativeCallbackOnBecomeEditing", "WNNativeCallbackOnBecomeEditing", 10006, false);
        }
    }

    public static class kx extends g {
        public kx() {
            super("menu:share:qq", "", 94, false);
        }
    }

    public static class kz extends g {
        public kz() {
            super("menu:share:timeline", "", 88, false);
        }
    }

    public static class p extends g {
        public p() {
            super("batchViewCard", "batchViewCard", 111, true);
        }
    }

    private static final class q extends g {
        q() {
            super("bindEmail", "bindEmail", 306, true);
        }
    }

    public static class y extends g {
        public y() {
            super("chooseImage", "chooseImage", 104, true);
        }
    }

    public static g Ux(String str) {
        if (qVC == null || qVC.size() <= 0) {
            Map hashMap = new HashMap(128);
            qVC = hashMap;
            hashMap.put("log", new dv());
            qVC.put(w.NAME, new dg());
            qVC.put("profile", new gg());
            qVC.put("shareWeibo", new kj());
            qVC.put("shareTimeline", new jm());
            qVC.put(JsApiAdDataReport.NAME, new m());
            qVC.put("streamingVideoPlay", new jj());
            qVC.put("addContact", new h());
            qVC.put("sendAppMessage", new hh());
            qVC.put("scanQRCode", new ha());
            qVC.put(v.NAME, new de());
            qVC.put("showOptionMenu", new ir());
            qVC.put("getNetworkType", new cc());
            qVC.put("closeWindow", new ai());
            qVC.put("getInstallState", new bx());
            qVC.put("setFontSizeCallback", new hv());
            qVC.put("jumpToInstallUrl", new dl());
            qVC.put("launchApp", new dr());
            qVC.put(o.NAME, new bn());
            qVC.put("editAddress", new ba());
            qVC.put("getHeadingAndPitch", new bu());
            qVC.put("sendEmail", new hm());
            qVC.put("addDownloadTask", new j());
            qVC.put(com.tencent.mm.plugin.game.gamewebview.jsapi.biz.f.NAME, new r());
            qVC.put("pauseDownloadTask", new fz());
            qVC.put(aq.NAME, new gy());
            qVC.put("queryDownloadTask", new gh());
            qVC.put("installDownloadTask", new dj());
            qVC.put("getLatestAddress", new cf());
            qVC.put("openSpecificView", new fm());
            qVC.put("jumpWCMall", new dn());
            qVC.put(com.tencent.mm.plugin.game.gamewebview.jsapi.biz.y.NAME, new dq());
            qVC.put("writeCommData", new kq());
            qVC.put("openUrlByExtBrowser", new fn());
            qVC.put("geoLocation", new bk());
            qVC.put("getBrandWCPayBindCardRequest", new bm());
            qVC.put("openProductView", new fg());
            qVC.put("openProductViewWithPid", new fh());
            qVC.put("jumpToBizProfile", new dm());
            qVC.put("openTimelineCheckInList", new eb());
            qVC.put("openLocation", new ea());
            qVC.put("timelineCheckIn", new dz());
            qVC.put("getBrandWCPayCreateCreditCardRequest", new fs());
            qVC.put("chooseCard", new w());
            qVC.put("chooseInvoice", new z());
            qVC.put("sendServiceAppMessage", new hn());
            qVC.put("musicPlay", new dy());
            qVC.put("mmsf0001", new bq());
            qVC.put("connectToWiFi", new an());
            qVC.put("getTransferMoneyRequest", new cu());
            qVC.put("openWCPaySpecificView", new fp());
            qVC.put(as.NAME, new ht());
            qVC.put("batchAddCard", new o());
            qVC.put("preVerifyJSAPI", new gf());
            qVC.put(JsApiStartRecordVoice.NAME, new iz());
            qVC.put("stopRecord", new jg());
            qVC.put(JsApiStartPlayVoice.NAME, new gb());
            qVC.put(JsApiPausePlayVoice.NAME, new ga());
            qVC.put("stopVoice", new ji());
            qVC.put("uploadVoice", new jw());
            qVC.put("downloadVoice", new ax());
            qVC.put("chooseImage", new y());
            qVC.put("uploadImage", new jt());
            qVC.put("downloadImage", new aw());
            qVC.put("uploadMediaFile", new ju());
            qVC.put("hideMenuItems", new dc());
            qVC.put("showMenuItems", new ip());
            qVC.put("hideAllNonBaseMenuItem", new db());
            qVC.put("showAllNonBaseMenuItem", new im());
            qVC.put("checkJsApi", new v());
            qVC.put("translateVoice", new jn());
            qVC.put("shareQQ", new ij());
            qVC.put("shareWeiboApp", new il());
            qVC.put("shareQZone", new ik());
            qVC.put("connectToFreeWifi", new am());
            qVC.put("getSendC2CMessageRequest", new cr());
            qVC.put("batchViewCard", new p());
            qVC.put("configWXDeviceWiFi", new al());
            qVC.put("getCurrentSSID", new bo());
            qVC.put("setPageOwner", new ib());
            qVC.put("getWechatVerifyTicket", new cw());
            qVC.put("openWXDeviceLib", new ft());
            qVC.put("startScanWXDevice", new ja());
            qVC.put("stopScanWXDevice", new jh());
            qVC.put("connectWXDevice", new ao());
            qVC.put("disconnectWXDevice", new av());
            qVC.put("getWXDeviceTicket", new cz());
            qVC.put("getWXDeviceInfos", new cy());
            qVC.put("sendDataToWXDevice", new hj());
            qVC.put("closeWXDeviceLib", new ak());
            qVC.put("setSendDataDirection", new if());
            qVC.put("verifyWCPayPassword", new jy());
            qVC.put("getPaymentOrderRequest", new ce());
            qVC.put("openGameDetail", new ew());
            qVC.put("openGameCenter", new ev());
            qVC.put("setGameDebugConfig", new hx());
            qVC.put("startTempSession", new jc());
            qVC.put("getH5PrepayRequest", new bv());
            qVC.put("getH5TransactionRequest", new bw());
            qVC.put("menu:share:timeline", new kz());
            qVC.put("menu:share:appmessage", new kw());
            qVC.put("menu:share:qq", new kx());
            qVC.put("menu:share:weiboApp", new la());
            qVC.put("menu:setfont", new kv());
            qVC.put("menu:share:weibo", new la());
            qVC.put("menu:share:QZone", new ky());
            qVC.put("getRecevieBizHongBaoRequest", new e());
            qVC.put("insertVideoPlayer", new di());
            qVC.put("updateVideoPlayer", new jr());
            qVC.put(com.tencent.mm.plugin.appbrand.jsapi.video.c.NAME, new gn());
            qVC.put("operateVideoPlayer", new fx());
            qVC.put("deleteSearchHistory", new as());
            qVC.put("getSearchHistory", new cn());
            qVC.put("getSearchData", new cj());
            qVC.put("getPoiInfo", new bt());
            qVC.put("updateReddotTimeStamps", new jp());
            qVC.put("getTeachSearchData", new ct());
            qVC.put("getSearchGuideData", new cm());
            qVC.put("getSearchAvatarList", new ci());
            qVC.put("getSearchSnsImageList", new cp());
            qVC.put("getSearchImageList", new co());
            qVC.put("getSearchDisplayNameList", new ck());
            qVC.put("startSearchItemDetailPage", new jb());
            qVC.put("reportSearchStatistics", new gt());
            qVC.put("reportSearchRealTimeStatistics", new gs());
            qVC.put("searchDataHasResult", new hb());
            qVC.put("openEmotionPage", new bi());
            qVC.put("getSearchSuggestionData", new cq());
            qVC.put("setSearchInputWord", new ie());
            qVC.put("setSnsObjectXmlDescList", new ig());
            qVC.put("clickSnsMusicPlayButton", new ah());
            qVC.put("openWeAppPage", new fr());
            qVC.put("reportWeAppSearchRealtime", new kk());
            qVC.put("doSearchOperation", new az());
            qVC.put("insertSearchWAWidgetView", new dh());
            qVC.put("removeSearchWAWidgetView", new gm());
            qVC.put("updateSearchWAWidgetView", new jq());
            qVC.put("showSearchActionSheet", new is());
            qVC.put("cancelSearchActionSheet", new s());
            qVC.put("uxSearchOpLog", new jx());
            qVC.put("jumpToWXWallet", new do());
            qVC.put("scanCover", new f());
            qVC.put("reportActionInfo", new go());
            qVC.put("openMyDeviceProfile", new fd());
            qVC.put("selectPedometerSource", new he());
            qVC.put("nfcIsConnect", new eh());
            qVC.put("nfcConnect", new ee());
            qVC.put("nfcTransceive", new ei());
            qVC.put("nfcBatchTransceive", new ec());
            qVC.put("nfcGetId", new ef());
            qVC.put("nfcGetInfo", new eg());
            qVC.put("startMonitoringBeacons", new ix());
            qVC.put("stopMonitoringBeacons", new je());
            qVC.put("nfcCheckState", new ed());
            qVC.put("videoProxyInit", new kc());
            qVC.put("videoProxyStartPlay", new kf());
            qVC.put("videoProxyStopPlay", new kg());
            qVC.put("videoProxySetPlayerState", new kd());
            qVC.put("videoProxySetRemainTime", new ke());
            qVC.put("videoProxyPreload", new ki());
            qVC.put("getWebPayCheckoutCounterRequst", new du());
            qVC.put("addCustomMenuItems", new i());
            qVC.put("operateGameCenterMsg", new fw());
            qVC.put("openEnterpriseChat", new et());
            qVC.put("enterEnterpriseChat", new be());
            qVC.put("openEnterpriseContact", new eu());
            qVC.put("selectEnterpriseContact", new hd());
            qVC.put("getEnterpriseChat", new br());
            qVC.put("reportIDKey", new gq());
            qVC.put("quicklyAddBrandContact", new gi());
            qVC.put("consumedShareCard", new ap());
            qVC.put("cache", new kb());
            qVC.put("publicCache", new kh());
            qVC.put("kvReport", new dp());
            qVC.put("realtimeReport", new gj());
            qVC.put("openUrlWithExtraWebview", new fo());
            qVC.put("setFreeWifiOwner", new hw());
            qVC.put("selectSingleContact", new hf());
            qVC.put("sendAppMessageToSpecifiedContact", new hg());
            qVC.put("setLocalData", new hy());
            qVC.put("getLocalData", new by());
            qVC.put("clearLocalData", new af());
            qVC.put("showKeyboard", new io());
            qVC.put("showSmileyPanel", new iu());
            qVC.put(n.NAME, new at());
            qVC.put("clearBounceBackground", new ad());
            qVC.put("setNavigationBarButtons", new hz());
            qVC.put("enableFullScreen", new bc());
            qVC.put("showNavigationBarLoading", new iq());
            qVC.put("hideNavigationBarLoading", new dd());
            qVC.put("enablePullDownRefresh", new bd());
            qVC.put("startPullDownRefresh", new iy());
            qVC.put("stopPullDownRefresh", new jf());
            qVC.put("disablePullDownRefresh", new au());
            qVC.put(av.NAME, new ic());
            qVC.put("setStatusBarStyle", new ih());
            qVC.put("deleteAccountSuccess", new ar());
            qVC.put("chooseVideo", new ac());
            qVC.put("uploadVideo", new jv());
            qVC.put("openMapNavigateMenu", new fc());
            qVC.put("setNavigationBarColor", new ia());
            qVC.put("getWCPayRealnameVerify", new cv());
            qVC.put("openDesignerEmojiView", new en());
            qVC.put("openDesignerProfile", new ep());
            qVC.put("openEmoticonTopicList", new es());
            qVC.put("openDesignerEmojiViewLocal", new eo());
            qVC.put("openDesignerProfileLocal", new eq());
            qVC.put("openEmotionDetailViewLocal", new d());
            qVC.put("openNewPage", new fe());
            qVC.put("getSearchEmotionData", new cl());
            qVC.put("openEmotionUrl", new bb());
            qVC.put("WNNativeCallbackOnClick", new ko());
            qVC.put("WNNativeCallbackOnLongClick", new kp());
            qVC.put("WNNativeCallbackOnCaretChange", new kn());
            qVC.put("WNNativeCallbackInitData", new km());
            qVC.put("WNNativeAsyncCallback", new kl());
            qVC.put("WNNativeCallbackOnBecomeEditing", new ks());
            qVC.put("WNNativeCallbackOnBecomeEdited", new kt());
            qVC.put("changePayActivityView", new t());
            qVC.put("selectWalletCurrency", new jk());
            qVC.put("scanLicence", new gz());
            qVC.put("operateMusicPlayer", new b());
            qVC.put("getMusicPlayerState", new a());
            qVC.put("clearWebviewCache", new ag());
            qVC.put("requireSoterBiometricAuthentication", new iv());
            qVC.put("getSupportSoter", new iw());
            qVC.put("unbindBankCard", new jo());
            qVC.put("setBounceBackground", new hs());
            qVC.put("sendEnterpriseChat", new hk());
            qVC.put("doExposePreparation", new ay());
            qVC.put("getMsgProofItems", new cb());
            qVC.put("openSecurityView", new fl());
            qVC.put("startVoipCall", new jd());
            qVC.put("chooseInvoiceTitle", new aa());
            qVC.put(GameJsApiGetOpenDeviceId.NAME, new cd());
            qVC.put("getRouteUrl", new ch());
            qVC.put("idCardRealnameVerify", new df());
            qVC.put("uploadIdCardSuccess", new lc());
            qVC.put("showDatePickerView", new in());
            qVC.put("openLuckyMoneyDetailView", new fa());
            qVC.put("resendRemittanceMsg", new gx());
            qVC.put("getGameCommInfo", new bs());
            qVC.put("openGameRegion", new ex());
            qVC.put("chooseIdCard", new x());
            qVC.put("getLocalImgData", new c());
            qVC.put("openWeApp", new fq());
            qVC.put("recordVideo", new gk());
            qVC.put("previewVideo", new ge());
            qVC.put("uploadEncryptMediaFile", new js());
            qVC.put("chooseMedia", new ab());
            qVC.put("requestWxFacePictureVerify", new bf());
            qVC.put("openCustomWebview", new em());
            qVC.put("forceUpdateWxaAttr", new bh());
            qVC.put("openLuckyMoneyHistory", new fb());
            qVC.put(b.NAME, new hl());
            qVC.put(t.NAME, new cx());
            qVC.put("getLocalWePkgInfo", new bz());
            qVC.put("openGameWebView", new ez());
            qVC.put("launchApplication", new ds());
            qVC.put("showSearchOfBizHistory", new it());
            qVC.put(aa.NAME, new dw());
            qVC.put(d.NAME, new n());
            qVC.put("requestWxFacePictureVerifyUnionVideo", new bg());
            qVC.put("checkIsSupportFaceDetect", new u());
            qVC.put("operateBackgroundAudio", new fv());
            qVC.put(JsApiSetBackgroundAudioState.NAME, new hr());
            qVC.put("getBackgroundAudioState", new bl());
            qVC.put("addDownloadTaskStraight", new k());
            qVC.put("setScreenOrientation", new id());
            qVC.put("addToEmoticon", new l());
            qVC.put("shareEmoticon", new ii());
            qVC.put("makePhoneCall", new dx());
            qVC.put("openADCanvas", new el());
            qVC.put("openSearchCanvas", new fi());
            qVC.put("opVoteAdData", new fy());
            qVC.put("requestWxFaceRegisterInternal", new gu());
            qVC.put("requestWxFaceVerifyInternal", new gv());
            qVC.put("launchMiniProgram", new dt());
            qVC.put("reportMiniProgramPageData", new gr());
            qVC.put("selectContact", new hc());
            qVC.put("openSearchWAWidgetLogView", new fj());
            qVC.put("reloadSearchWAWidgetData", new gl());
            qVC.put("closeWindowAndGoNext", new aj());
            qVC.put("requestWxVoicePrintVerifyInternal", new gw());
            qVC.put("openBizChat", new ek());
            qVC.put("handleWCPayWalletBuffer", new da());
            qVC.put("tapSearchWAWidgetView", new jl());
            qVC.put("getMatchContactList", new ca());
            qVC.put("openSearchWebView", new fk());
            qVC.put("openWXSearchPage", new fu());
            qVC.put("viewTypeChange", new jz());
            qVC.put("invokeMiniProgramAPI", new dk());
            qVC.put("openGameUrlWithExtraWebView", new ey());
            qVC.put(at.NAME, new hu());
            qVC.put("getGameData", new bp());
            qVC.put("clearGameData", new ae());
            qVC.put("openECard", new er());
            qVC.put("reportGamePageTime", new gp());
            qVC.put("setWCPayPassword", new hq());
            qVC.put("openWCPayCardList", new ej());
            qVC.put("bindEmail", new q());
            qVC.put("openOfflinePayView", new ff());
            qVC.put("bindEmail", new q());
            qVC.put("doGoToRecVideoList", new cg());
            qVC.put("jumpWSRecVideoList", new ku());
            qVC.put("openWebSearchOutLinkItem", new lb());
            qVC.put("recordHistory", new bj());
            List<g> linkedList = new LinkedList();
            linkedList.add(new gd());
            linkedList.add(new gc());
            linkedList.add(new hi());
            for (g gVar : linkedList) {
                qVC.put(gVar.getName(), gVar);
            }
            qVC.put("getSystemInfo", new cs());
            qVC.put("serviceClick", new hp());
            qVC.put("openRealnameAuth", new kr());
            qVC.put("sendSingleAppMessage", new ho());
            qVC.put("wcPrivacyPolicyResult", new ka());
            qVC.put("currentMpInfo", new aq());
        }
        return (g) qVC.get(str);
    }
}

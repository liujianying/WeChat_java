package com.tencent.mm.plugin.webview.ui.tools.jsapi;

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
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.d;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.f;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.n;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.o;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.t;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.v;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.w;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.y;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.c.a.a;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.c.c;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.c.bxq;
import com.tencent.mm.protocal.c.g;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;

class g$1 extends c {
    final /* synthetic */ i qiH;
    final /* synthetic */ JsapiPermissionWrapper qiI;
    final /* synthetic */ g qiJ;
    final /* synthetic */ g qiK;

    g$1(g gVar, i iVar, JsapiPermissionWrapper jsapiPermissionWrapper, g gVar2) {
        this.qiK = gVar;
        this.qiH = iVar;
        this.qiI = jsapiPermissionWrapper;
        this.qiJ = gVar2;
    }

    public final void a(a aVar, String str, LinkedList<bxq> linkedList, int i, int i2) {
        boolean z = false;
        this.qiH.bYt().put("baseErrorCode", Integer.valueOf(i));
        this.qiH.bYt().put("jsapiErrorCode", Integer.valueOf(i2));
        if (this.qiK.RN(this.qiH.qkl)) {
            x.i("MicroMsg.MsgHandler", "current jsapi(%s) invoked is came from menu event.(original retCode : %s)", new Object[]{this.qiH.qkl, aVar});
            aVar = a.qhc;
        }
        x.i("MicroMsg.MsgHandler", "onJSVerifyEnd, put webviewID = %d", new Object[]{Integer.valueOf(g.a(this.qiK))});
        this.qiH.mcy.put("webview_instance_id", Integer.valueOf(g.a(this.qiK)));
        if (aVar != a.qhc) {
            if (aVar == a.qhf) {
                x.e("MicroMsg.MsgHandler", "handleMsg access denied %s", new Object[]{this.qiJ.getName()});
                if (this.qiH.qkl.equalsIgnoreCase(o.NAME)) {
                    h.mEJ.a(157, 1, 1, false);
                }
                g.a(this.qiK, this.qiH, "system:access_denied", null);
            } else if (aVar == a.qhe) {
                g.a(this.qiK, this.qiH, this.qiJ.cfX() + ":" + str, null);
            } else if (bi.oW(this.qiJ.cfX())) {
                this.qiK.iKs = false;
                kj(false);
                g.d(this.qiK, this.qiH, false);
                return;
            } else if (bi.oW(str)) {
                g.a(this.qiK, this.qiH, this.qiJ.cfX() + ":fail", null);
            } else {
                g.a(this.qiK, this.qiH, this.qiJ.cfX() + ":fail_" + str, null);
            }
            kj(true);
        } else if (this.qiH.qkl.equals("sendAppMessage")) {
            kj(g.a(this.qiK, this.qiH, this.qiI));
            z = true;
        } else if (this.qiH.qkl.equals("profile")) {
            kj(g.a(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equals("shareWeibo")) {
            kj(g.b(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equals("shareTimeline")) {
            kj(g.b(this.qiK, this.qiH, this.qiI));
            z = true;
        } else if (this.qiH.qkl.equals(JsApiAdDataReport.NAME)) {
            kj(g.c(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equals("streamingVideoPlay")) {
            kj(g.d(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equals("addContact")) {
            kj(g.c(this.qiK, this.qiH, this.qiI));
            z = true;
        } else if (this.qiH.qkl.equals(w.NAME)) {
            kj(g.e(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equals("log")) {
            kj(g.f(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equals(v.NAME)) {
            kj(g.b(this.qiK));
            z = true;
        } else if (this.qiH.qkl.equals("showOptionMenu")) {
            kj(g.c(this.qiK));
            z = true;
        } else if (this.qiH.qkl.equals("getNetworkType")) {
            kj(g.g(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equals("closeWindow")) {
            kj(g.h(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equals("getInstallState")) {
            kj(g.i(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equals("scanQRCode")) {
            kj(g.j(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equals("setFontSizeCallback")) {
            kj(g.k(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equals("jumpToInstallUrl")) {
            kj(g.l(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equalsIgnoreCase(o.NAME)) {
            kj(g.m(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equalsIgnoreCase("editAddress")) {
            kj(g.n(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equalsIgnoreCase("getLatestAddress")) {
            kj(g.d(this.qiK));
            z = true;
        } else if (this.qiH.qkl.equalsIgnoreCase("getHeadingAndPitch")) {
            kj(g.o(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equalsIgnoreCase("sendEmail")) {
            kj(g.p(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equalsIgnoreCase("addDownloadTask")) {
            kj(g.q(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equalsIgnoreCase(f.NAME)) {
            kj(g.r(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equalsIgnoreCase("pauseDownloadTask")) {
            kj(g.s(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equalsIgnoreCase(aq.NAME)) {
            kj(g.d(this.qiK, this.qiH, this.qiI));
            z = true;
        } else if (this.qiH.qkl.equalsIgnoreCase("queryDownloadTask")) {
            kj(g.t(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equalsIgnoreCase("installDownloadTask")) {
            kj(g.u(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equalsIgnoreCase("openSpecificView")) {
            kj(g.v(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equalsIgnoreCase(y.NAME)) {
            kj(g.w(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equalsIgnoreCase("jumpWCMall")) {
            kj(g.x(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equalsIgnoreCase("writeCommData")) {
            kj(g.y(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equalsIgnoreCase("openUrlByExtBrowser")) {
            kj(g.z(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equalsIgnoreCase("openProductView")) {
            kj(g.A(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equalsIgnoreCase("openProductViewWithPid")) {
            kj(g.B(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equalsIgnoreCase("getBrandWCPayBindCardRequest")) {
            kj(g.C(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equalsIgnoreCase("geoLocation")) {
            kj(g.e(this.qiK));
            z = true;
        } else if (this.qiH.qkl.equalsIgnoreCase("jumpToBizProfile")) {
            kj(g.D(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equalsIgnoreCase("openTimelineCheckInList")) {
            kj(g.E(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equalsIgnoreCase("openLocation")) {
            kj(g.F(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equalsIgnoreCase("timelineCheckIn")) {
            kj(g.G(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equalsIgnoreCase("getBrandWCPayCreateCreditCardRequest")) {
            kj(g.H(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equalsIgnoreCase("sendServiceAppMessage")) {
            kj(g.I(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equalsIgnoreCase("mmsf0001")) {
            kj(g.J(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equalsIgnoreCase("musicPlay")) {
            kj(g.K(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equalsIgnoreCase("connectToWiFi")) {
            kj(g.L(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equalsIgnoreCase("getTransferMoneyRequest")) {
            kj(g.M(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equalsIgnoreCase("openWCPaySpecificView")) {
            kj(g.N(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equalsIgnoreCase("chooseCard")) {
            kj(g.O(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equalsIgnoreCase("chooseInvoice")) {
            kj(g.P(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equalsIgnoreCase("batchAddCard")) {
            kj(g.Q(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equalsIgnoreCase(as.NAME)) {
            kj(g.R(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equalsIgnoreCase("preVerifyJSAPI")) {
            kj(g.S(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equalsIgnoreCase(JsApiStartRecordVoice.NAME)) {
            kj(g.T(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equalsIgnoreCase("stopRecord")) {
            kj(g.U(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equalsIgnoreCase(JsApiStartPlayVoice.NAME)) {
            kj(g.V(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equalsIgnoreCase(JsApiPausePlayVoice.NAME)) {
            kj(g.W(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equalsIgnoreCase("stopVoice")) {
            kj(g.X(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equalsIgnoreCase("uploadVoice")) {
            kj(g.Y(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equalsIgnoreCase("downloadVoice")) {
            kj(g.Z(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equalsIgnoreCase("chooseImage")) {
            kj(g.aa(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equalsIgnoreCase("uploadImage")) {
            kj(g.ab(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equalsIgnoreCase("downloadImage")) {
            kj(g.ac(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equalsIgnoreCase("hideMenuItems")) {
            kj(g.ad(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equalsIgnoreCase("showMenuItems")) {
            kj(g.ae(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equalsIgnoreCase("hideAllNonBaseMenuItem")) {
            kj(g.af(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equalsIgnoreCase("showAllNonBaseMenuItem")) {
            kj(g.ag(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equalsIgnoreCase("checkJsApi")) {
            kj(g.ah(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equalsIgnoreCase("translateVoice")) {
            kj(g.ai(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equalsIgnoreCase("shareQQ")) {
            kj(g.aj(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equalsIgnoreCase("shareWeiboApp")) {
            kj(g.ak(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equalsIgnoreCase("configWXDeviceWiFi")) {
            kj(g.al(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equalsIgnoreCase("getCurrentSSID")) {
            kj(g.am(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equalsIgnoreCase("getPaymentOrderRequest")) {
            kj(g.an(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equalsIgnoreCase("verifyWCPayPassword")) {
            kj(g.ao(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equalsIgnoreCase("startMonitoringBeacons")) {
            g.f(this.qiK);
            kj(g.a(this.qiK, this.qiH, new int[0]));
            z = true;
        } else if (this.qiH.qkl.equalsIgnoreCase("stopMonitoringBeacons")) {
            g.f(this.qiK);
            kj(g.b(this.qiK, this.qiH, new int[0]));
            z = true;
        } else if (this.qiH.qkl.equalsIgnoreCase("getSendC2CMessageRequest")) {
            kj(g.ap(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equalsIgnoreCase("batchViewCard")) {
            kj(g.aq(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equalsIgnoreCase("connectToFreeWifi")) {
            kj(g.ar(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equalsIgnoreCase("setFreeWifiOwner")) {
            kj(g.as(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equalsIgnoreCase("setPageOwner")) {
            kj(g.at(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equalsIgnoreCase("getWechatVerifyTicket")) {
            kj(g.au(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equalsIgnoreCase("openWXDeviceLib")) {
            kj(g.av(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equalsIgnoreCase("closeWXDeviceLib")) {
            kj(g.aw(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equalsIgnoreCase("startScanWXDevice")) {
            kj(g.ax(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equalsIgnoreCase("stopScanWXDevice")) {
            kj(g.ay(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equalsIgnoreCase("connectWXDevice")) {
            kj(g.az(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equalsIgnoreCase("disconnectWXDevice")) {
            kj(g.aA(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equalsIgnoreCase("getWXDeviceTicket")) {
            kj(g.aB(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equalsIgnoreCase("getWXDeviceInfos")) {
            kj(g.aC(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equalsIgnoreCase("sendDataToWXDevice")) {
            kj(g.aD(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equalsIgnoreCase("setSendDataDirection")) {
            kj(g.aE(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equalsIgnoreCase("openGameDetail")) {
            kj(g.aF(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equalsIgnoreCase("openGameCenter")) {
            kj(g.aG(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equalsIgnoreCase("setGameDebugConfig")) {
            kj(g.aH(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equalsIgnoreCase("shareQZone")) {
            kj(g.aj(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equalsIgnoreCase("startTempSession")) {
            kj(g.aI(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equalsIgnoreCase("getRecevieBizHongBaoRequest")) {
            kj(g.aJ(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equalsIgnoreCase("openMyDeviceProfile")) {
            kj(g.aK(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equalsIgnoreCase("selectPedometerSource")) {
            kj(this.qiK.ap(this.qiH));
            z = true;
        } else if (this.qiH.qkl.equalsIgnoreCase("getH5PrepayRequest")) {
            kj(g.aL(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equalsIgnoreCase("getH5TransactionRequest")) {
            kj(g.aM(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equalsIgnoreCase("jumpToWXWallet")) {
            kj(g.aN(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equalsIgnoreCase("scanCover")) {
            kj(g.aO(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equalsIgnoreCase("nfcIsConnect")) {
            kj(g.aP(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equalsIgnoreCase("nfcConnect")) {
            kj(g.aQ(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equalsIgnoreCase("nfcTransceive")) {
            kj(g.aR(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equalsIgnoreCase("nfcBatchTransceive")) {
            kj(g.aS(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equalsIgnoreCase("nfcGetId")) {
            kj(g.aT(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equalsIgnoreCase("nfcGetInfo")) {
            kj(g.aU(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equalsIgnoreCase("nfcCheckState")) {
            kj(g.aV(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equalsIgnoreCase("videoProxyInit")) {
            kj(g.aW(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equalsIgnoreCase("videoProxyStartPlay")) {
            kj(g.aX(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equalsIgnoreCase("videoProxyStopPlay")) {
            kj(g.aY(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equalsIgnoreCase("videoProxySetPlayerState")) {
            kj(g.aZ(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equalsIgnoreCase("videoProxySetRemainTime")) {
            kj(g.ba(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equalsIgnoreCase("getSearchData")) {
            kj(g.bb(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equalsIgnoreCase("getPoiInfo")) {
            kj(g.bc(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equalsIgnoreCase("updateReddotTimeStamps")) {
            kj(g.bd(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equalsIgnoreCase("reloadSearchWAWidgetData")) {
            kj(g.be(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equalsIgnoreCase("insertSearchWAWidgetView")) {
            kj(g.bf(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equalsIgnoreCase("removeSearchWAWidgetView")) {
            kj(g.bg(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equalsIgnoreCase("updateSearchWAWidgetView")) {
            kj(g.bh(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equalsIgnoreCase("getTeachSearchData")) {
            kj(g.bi(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equalsIgnoreCase("getSearchGuideData")) {
            kj(g.bj(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equalsIgnoreCase("getSearchAvatarList")) {
            kj(g.bk(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equalsIgnoreCase("getSearchSnsImageList")) {
            kj(g.bl(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equalsIgnoreCase("getSearchImageList")) {
            kj(g.bm(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equalsIgnoreCase("getSearchDisplayNameList")) {
            kj(g.bn(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equalsIgnoreCase("startSearchItemDetailPage")) {
            kj(g.bo(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equalsIgnoreCase("reportSearchStatistics")) {
            kj(g.bp(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equalsIgnoreCase("reportSearchRealTimeStatistics")) {
            kj(g.bq(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equalsIgnoreCase("searchDataHasResult")) {
            kj(g.br(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equalsIgnoreCase("getSearchSuggestionData")) {
            kj(g.bs(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equalsIgnoreCase("openEmotionPage")) {
            kj(g.bt(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equalsIgnoreCase("setSearchInputWord")) {
            kj(g.bu(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equalsIgnoreCase("openWeAppPage")) {
            kj(g.bv(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equalsIgnoreCase("reportWeAppSearchRealtime")) {
            kj(g.bw(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equalsIgnoreCase("doSearchOperation")) {
            kj(g.bx(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equalsIgnoreCase("operateGameCenterMsg")) {
            kj(g.by(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equalsIgnoreCase("getWebPayCheckoutCounterRequst")) {
            kj(g.bz(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equalsIgnoreCase("setSnsObjectXmlDescList")) {
            kj(g.bA(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equalsIgnoreCase("clickSnsMusicPlayButton")) {
            kj(g.bB(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equalsIgnoreCase("addCustomMenuItems")) {
            kj(g.bC(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equalsIgnoreCase("openEnterpriseChat")) {
            kj(g.bD(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equalsIgnoreCase("openEnterpriseContact")) {
            kj(g.bE(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equalsIgnoreCase("selectEnterpriseContact")) {
            kj(g.bF(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equalsIgnoreCase("sendEnterpriseChat")) {
            kj(g.bG(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equalsIgnoreCase("enterEnterpriseChat")) {
            kj(g.bH(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equalsIgnoreCase("getEnterpriseChat")) {
            kj(g.bI(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equalsIgnoreCase("reportActionInfo")) {
            kj(g.bJ(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equalsIgnoreCase("showSearchOfBizHistory")) {
            kj(g.bK(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equalsIgnoreCase("cache")) {
            kj(g.bL(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equalsIgnoreCase("publicCache")) {
            kj(g.bM(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equalsIgnoreCase("changePayActivityView")) {
            kj(g.bN(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equalsIgnoreCase("scanLicence")) {
            kj(g.bO(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equalsIgnoreCase("openWeApp")) {
            kj(g.bP(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equalsIgnoreCase("openECard")) {
            kj(g.bQ(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equalsIgnoreCase("sendDataToMiniProgram")) {
            kj(g.bR(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equalsIgnoreCase("preloadMiniProgramEnv")) {
            kj(g.bS(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equalsIgnoreCase("preloadMiniProgramContacts")) {
            kj(g.bT(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equalsIgnoreCase("enablePullDownRefresh")) {
            kj(this.qiK.bA(this.qiH));
            z = true;
        } else if (this.qiH.qkl.equalsIgnoreCase("startPullDownRefresh")) {
            kj(this.qiK.bB(this.qiH));
            z = true;
        } else if (this.qiH.qkl.equalsIgnoreCase("stopPullDownRefresh")) {
            kj(this.qiK.bC(this.qiH));
            z = true;
        } else if (this.qiH.qkl.equalsIgnoreCase("disablePullDownRefresh")) {
            kj(this.qiK.bYn());
            z = true;
        } else if (this.qiH.qkl.equalsIgnoreCase(n.NAME)) {
            kj(this.qiK.bF(this.qiH));
            z = true;
        } else if (this.qiH.qkl.equalsIgnoreCase("clearBounceBackground")) {
            kj(this.qiK.bG(this.qiH));
            z = true;
        } else if (this.qiH.qkl.equalsIgnoreCase("showKeyboard")) {
            kj(this.qiK.bD(this.qiH));
            z = true;
        } else if (this.qiH.qkl.equalsIgnoreCase("showSmileyPanel")) {
            kj(this.qiK.bE(this.qiH));
            z = true;
        } else if (this.qiH.qkl.equalsIgnoreCase("openMapNavigateMenu")) {
            kj(this.qiK.bJ(this.qiH));
            z = true;
        } else if (this.qiH.qkl.equalsIgnoreCase("setNavigationBarButtons")) {
            kj(g.bU(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equalsIgnoreCase("enableFullScreen")) {
            kj(g.bV(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equalsIgnoreCase("reportMiniProgramPageData")) {
            kj(g.bW(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equalsIgnoreCase(av.NAME)) {
            kj(g.bX(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equalsIgnoreCase("setStatusBarStyle")) {
            kj(g.bY(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equalsIgnoreCase("forceUpdateWxaAttr")) {
            kj(g.bZ(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equalsIgnoreCase("launchMiniProgram")) {
            kj(g.ca(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equalsIgnoreCase("reportIDKey")) {
            kj(g.cb(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equalsIgnoreCase("quicklyAddBrandContact")) {
            kj(g.cc(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equalsIgnoreCase("consumedShareCard")) {
            kj(g.cd(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equalsIgnoreCase("kvReport")) {
            kj(this.qiK.bs(this.qiH));
            z = true;
        } else if (this.qiH.qkl.equalsIgnoreCase("realtimeReport")) {
            kj(this.qiK.bI(this.qiH));
            z = true;
        } else if (this.qiH.qkl.equalsIgnoreCase("openUrlWithExtraWebview")) {
            kj(g.ce(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equalsIgnoreCase("videoProxyPreload")) {
            kj(g.cf(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equalsIgnoreCase("getLocalData")) {
            kj(g.cg(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equalsIgnoreCase("setLocalData")) {
            kj(g.ch(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equalsIgnoreCase("clearLocalData")) {
            kj(g.ci(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equalsIgnoreCase("selectSingleContact")) {
            kj(g.cj(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equalsIgnoreCase("sendAppMessageToSpecifiedContact")) {
            kj(g.ck(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equalsIgnoreCase("deleteAccountSuccess")) {
            kj(g.g(this.qiK));
            z = true;
        } else if (this.qiH.qkl.equalsIgnoreCase("chooseVideo")) {
            kj(g.cl(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equalsIgnoreCase("uploadVideo")) {
            kj(g.cm(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equalsIgnoreCase("setNavigationBarColor")) {
            kj(g.cn(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equalsIgnoreCase("openDesignerEmojiView")) {
            kj(g.a(this.qiK, this.qiH, false));
            z = true;
        } else if (this.qiH.qkl.equalsIgnoreCase("openDesignerProfile")) {
            kj(g.b(this.qiK, this.qiH, false));
            z = true;
        } else if (this.qiH.qkl.equalsIgnoreCase("openEmoticonTopicList")) {
            kj(g.co(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equalsIgnoreCase("openDesignerEmojiViewLocal")) {
            kj(g.a(this.qiK, this.qiH, true));
            z = true;
        } else if (this.qiH.qkl.equalsIgnoreCase("openDesignerProfileLocal")) {
            kj(g.b(this.qiK, this.qiH, true));
            z = true;
        } else if (this.qiH.qkl.equalsIgnoreCase("openEmotionDetailViewLocal")) {
            kj(g.cp(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equalsIgnoreCase("openNewPage")) {
            kj(g.cq(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equalsIgnoreCase("getSearchEmotionData")) {
            kj(g.cr(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equalsIgnoreCase("openEmotionUrl")) {
            kj(g.cs(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equals("getWCPayRealnameVerify")) {
            kj(this.qiK.aO(this.qiH));
            z = true;
        } else if (this.qiH.qkl.equals("selectWalletCurrency")) {
            kj(this.qiK.bYl());
            z = true;
        } else if (this.qiH.qkl.equalsIgnoreCase("operateMusicPlayer")) {
            kj(g.ct(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equalsIgnoreCase("getMusicPlayerState")) {
            kj(g.cu(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equalsIgnoreCase("clearWebviewCache")) {
            kj(g.cv(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equals("requireSoterBiometricAuthentication")) {
            kj(g.cw(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equals("getSupportSoter")) {
            kj(g.cx(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equals("unbindBankCard")) {
            kj(g.cy(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equals("setBounceBackground")) {
            kj(this.qiK.bH(this.qiH));
            z = true;
        } else if (this.qiH.qkl.equals("doExposePreparation")) {
            kj(g.cz(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equals("getMsgProofItems")) {
            kj(g.cA(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equals("uploadMediaFile")) {
            kj(g.cB(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equals("openSecurityView")) {
            kj(g.cC(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equals("startVoipCall")) {
            kj(g.cD(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equals(GameJsApiGetOpenDeviceId.NAME)) {
            kj(g.cE(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equalsIgnoreCase("getRouteUrl")) {
            kj(g.cF(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equals("idCardRealnameVerify")) {
            kj(this.qiK.aQ(this.qiH));
            z = true;
        } else if (this.qiH.qkl.equals("uploadIdCardSuccess")) {
            kj(this.qiK.aR(this.qiH));
            z = true;
        } else if (this.qiH.qkl.equals("getGameCommInfo")) {
            kj(this.qiK.aS(this.qiH));
            z = true;
        } else if (this.qiH.qkl.equals("openGameRegion")) {
            kj(this.qiK.bYm());
            z = true;
        } else if (this.qiH.qkl.equals("chooseIdCard")) {
            kj(this.qiK.aT(this.qiH));
            z = true;
        } else if (this.qiH.qkl.equals("showDatePickerView")) {
            kj(g.cG(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equals("openLuckyMoneyDetailView")) {
            kj(g.cH(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equals("resendRemittanceMsg")) {
            kj(g.cI(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equals("getLocalImgData")) {
            kj(g.cJ(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equals("recordVideo")) {
            kj(g.cK(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equals("previewVideo")) {
            kj(g.cL(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equals("uploadEncryptMediaFile")) {
            kj(g.cM(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equals("openCustomWebview")) {
            kj(g.cN(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equals("chooseMedia")) {
            kj(g.cO(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equals("openLuckyMoneyHistory")) {
            kj(g.cP(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equals("requestWxFacePictureVerify")) {
            kj(g.c(this.qiK, this.qiH, false));
            z = true;
        } else if (this.qiH.qkl.equals(t.NAME)) {
            kj(g.cQ(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equals("getLocalWePkgInfo")) {
            kj(g.cR(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equals("openGameWebView")) {
            kj(g.cS(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equals("launchApplication")) {
            kj(g.cT(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equals(aa.NAME) || this.qiH.qkl.equals(d.NAME)) {
            kj(g.cU(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equals("requestWxFacePictureVerifyUnionVideo")) {
            kj(g.c(this.qiK, this.qiH, true));
            z = true;
        } else if (this.qiH.qkl.equals("checkIsSupportFaceDetect")) {
            kj(g.cV(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equals("operateBackgroundAudio")) {
            kj(g.cW(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equals(JsApiSetBackgroundAudioState.NAME)) {
            kj(g.e(this.qiK, this.qiH, this.qiI));
            z = true;
        } else if (this.qiH.qkl.equals("getBackgroundAudioState")) {
            kj(g.cX(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equalsIgnoreCase("addDownloadTaskStraight")) {
            kj(g.f(this.qiK, this.qiH, this.qiI));
            z = true;
        } else if (this.qiH.qkl.equals("setScreenOrientation")) {
            kj(g.cY(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equals("addToEmoticon")) {
            kj(g.cZ(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equals("shareEmoticon")) {
            kj(g.da(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equals("requestWxFaceRegisterInternal")) {
            kj(g.db(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equals("requestWxFaceVerifyInternal")) {
            kj(g.dc(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equals("openADCanvas")) {
            kj(g.a(this.qiK, this.qiH, 0));
            z = true;
        } else if (this.qiH.qkl.equals("openSearchCanvas")) {
            kj(g.a(this.qiK, this.qiH, 1));
            z = true;
        } else if (this.qiH.qkl.equals("opVoteAdData")) {
            kj(g.dd(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equals("selectContact")) {
            kj(g.de(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equals("makePhoneCall")) {
            kj(g.df(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equals("setWCPayPassword")) {
            kj(g.dg(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equals("chooseInvoiceTitle")) {
            kj(g.dh(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equals("showSearchActionSheet")) {
            kj(g.di(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equals("cancelSearchActionSheet")) {
            kj(g.dj(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equals("uxSearchOpLog")) {
            kj(g.dk(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equals("openSearchWAWidgetLogView")) {
            kj(g.dl(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equals("openBizChat")) {
            kj(g.dm(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equals("tapSearchWAWidgetView")) {
            kj(g.dn(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equals("getMatchContactList")) {
            kj(g.do(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equals("openSearchWebView")) {
            kj(g.dp(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equalsIgnoreCase("openWXSearchPage")) {
            kj(g.dq(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equals("viewTypeChange")) {
            kj(g.dr(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equals("openGameUrlWithExtraWebView")) {
            kj(g.ds(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equals("requestWxVoicePrintVerifyInternal")) {
            kj(g.dt(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equals("closeWindowAndGoNext")) {
            kj(g.du(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equals("invokeMiniProgramAPI")) {
            kj(g.dv(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equals(at.NAME)) {
            kj(g.dw(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equals("getGameData")) {
            kj(g.dx(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equals("clearGameData")) {
            kj(g.dy(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equals("handleWCPayWalletBuffer")) {
            kj(g.dz(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equals("reportGamePageTime")) {
            kj(g.dA(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equals("insertVideoPlayer")) {
            kj(g.dB(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equals("updateVideoPlayer")) {
            kj(g.dC(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equals(com.tencent.mm.plugin.appbrand.jsapi.video.c.NAME)) {
            kj(g.dD(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equals("operateVideoPlayer")) {
            kj(g.dE(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equals("getSearchHistory")) {
            kj(g.h(this.qiK));
            z = true;
        } else if (this.qiH.qkl.equals("deleteSearchHistory")) {
            kj(g.dF(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equals("doGoToRecVideoList") || this.qiH.qkl.equals("jumpWSRecVideoList")) {
            kj(g.dG(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equals("recordHistory")) {
            kj(g.dH(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equals("openOfflinePayView")) {
            kj(g.dI(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equals("openWCPayCardList")) {
            kj(g.dJ(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equals("bindEmail")) {
            kj(g.i(this.qiK));
            z = true;
        } else if (this.qiH.qkl.equals("getSystemInfo")) {
            kj(g.dK(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equals("serviceClick")) {
            kj(g.dL(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equals("openRealnameAuth")) {
            kj(g.dM(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equals("sendSingleAppMessage")) {
            kj(g.dN(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equals("openWebSearchOutLinkItem")) {
            kj(g.dO(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equals("wcPrivacyPolicyResult")) {
            kj(g.dP(this.qiK, this.qiH));
            z = true;
        } else if (this.qiH.qkl.equals("currentMpInfo")) {
            kj(g.dQ(this.qiK, this.qiH));
            z = true;
        } else {
            x.e("MicroMsg.MsgHandler", "unknown function = " + this.qiH.qkl);
            g.a(this.qiK, this.qiH, "system:function_not_exist", null);
            kj(true);
        }
        Object obj = this.qiH.bYt().get("Internal@AsyncReport");
        if (!(obj != null && (obj instanceof Boolean) && ((Boolean) obj).booleanValue())) {
            g.d(this.qiK, this.qiH, z);
        }
        if (!z) {
            g.b(this.qiK, this.qiH, aVar.getCode());
        }
    }

    public final boolean bXP() {
        return this.qhh;
    }
}

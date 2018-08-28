package com.tencent.mm.plugin.base.stub;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.Binder;
import android.os.Looper;
import android.os.Process;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.mm.g.a.ca;
import com.tencent.mm.g.a.eu;
import com.tencent.mm.g.a.ev;
import com.tencent.mm.g.a.fb;
import com.tencent.mm.g.a.g;
import com.tencent.mm.g.a.ie;
import com.tencent.mm.g.a.of;
import com.tencent.mm.g.a.og;
import com.tencent.mm.g.a.oh;
import com.tencent.mm.g.a.oi;
import com.tencent.mm.g.a.tn;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.account.ui.LoginUI;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.d;
import com.tencent.mm.pluginsdk.model.app.aq;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

@JgClassChecked(author = 20, fComment = "checked", lastDate = "20140429", reviewer = 20, vComment = {EType.PROVIDERCHECK})
public class WXCommProvider extends ContentProvider {
    public static final String PREF_NAME = (ad.getPackageName() + "_comm_preferences");
    private static final String[] hdP = new String[]{"packageName", "data"};
    private static final UriMatcher hdR = new UriMatcher(-1);
    private static volatile boolean hdS = false;
    protected static boolean hdT = false;
    private static final Object lock = new Object();
    private SharedPreferences duR;
    private ag handler;
    protected MatrixCursor hdQ = new MatrixCursor(new String[0]);

    static {
        hdR.addURI("com.tencent.mm.sdk.comm.provider", "pref", 1);
        hdR.addURI("com.tencent.mm.sdk.comm.provider", "openQRCodeScan", 18);
        hdR.addURI("com.tencent.mm.sdk.comm.provider", "batchAddShortcut", 19);
        hdR.addURI("com.tencent.mm.sdk.comm.provider", "getUnreadCount", 20);
        hdR.addURI("com.tencent.mm.sdk.comm.provider", "jumpToBizProfile", 21);
        hdR.addURI("com.tencent.mm.sdk.comm.provider", "jumpToBizTempSession", 27);
        hdR.addURI("com.tencent.mm.sdk.comm.provider", "registerMsgListener", 22);
        hdR.addURI("com.tencent.mm.sdk.comm.provider", "getAvatar", 23);
        hdR.addURI("com.tencent.mm.sdk.comm.provider", "regWatchAppId", 24);
        hdR.addURI("com.tencent.mm.sdk.comm.provider", "decodeVoice", 25);
        hdR.addURI("com.tencent.mm.sdk.comm.provider", "addCardToWX", 26);
        hdR.addURI("com.tencent.mm.sdk.comm.provider", "unReadMsgs", 9);
        hdR.addURI("com.tencent.mm.sdk.comm.provider", "to_chatting", 3);
        hdR.addURI("com.tencent.mm.sdk.comm.provider", "setReaded", 13);
        hdR.addURI("com.tencent.mm.sdk.comm.provider", "voiceControl", 29);
        hdR.addURI("com.tencent.mm.sdk.comm.provider", "openRankList", 28);
        hdR.addURI("com.tencent.mm.sdk.comm.provider", "openWebview", 30);
        hdR.addURI("com.tencent.mm.sdk.comm.provider", "openBusiLuckyMoney", 31);
        hdR.addURI("com.tencent.mm.sdk.comm.provider", "createChatroom", 32);
        hdR.addURI("com.tencent.mm.sdk.comm.provider", "joinChatroom", 33);
        hdR.addURI("com.tencent.mm.sdk.comm.provider", "sendSight", 34);
        hdR.addURI("com.tencent.mm.sdk.comm.provider", "redirectToChattingByPhoneNumber", 35);
        hdR.addURI("com.tencent.mm.sdk.comm.provider", "redirectToWechatOutByPhoneNumber", 36);
        hdR.addURI("com.tencent.mm.sdk.comm.provider", "getWifiList", 37);
        hdR.addURI("com.tencent.mm.sdk.comm.provider", "connectWifi", 38);
        hdR.addURI("com.tencent.mm.sdk.comm.provider", "chooseCardFromWX", 39);
        hdR.addURI("com.tencent.mm.sdk.comm.provider", "openOfflinePay", 42);
        hdR.addURI("com.tencent.mm.sdk.comm.provider", "setWechatSportStep", 40);
        hdR.addURI("com.tencent.mm.sdk.comm.provider", "getWechatSportConfig", 41);
        hdR.addURI("com.tencent.mm.sdk.comm.provider", "handleScanResult", 44);
        hdR.addURI("com.tencent.mm.sdk.comm.provider", "openTypeWebview", 45);
        hdR.addURI("com.tencent.mm.sdk.comm.provider", "openCleanUI", 46);
        hdR.addURI("com.tencent.mm.sdk.comm.provider", "launchWXMiniprogram", 47);
        hdR.addURI("com.tencent.mm.sdk.comm.provider", "qrcodeEvent", 48);
        hdR.addURI("com.tencent.mm.sdk.comm.provider", "jumpToOfflinePay", 49);
    }

    public boolean onCreate() {
        x.d("MicroMsg.WXCommProvider", "onCreate");
        this.handler = new ag();
        x.i("MicroMsg.WXCommProvider", "pid = " + Process.myPid() + ", tid : = " + Process.myTid());
        this.duR = getContext().getSharedPreferences(PREF_NAME, 0);
        getContext().registerReceiver(new 1(this), new IntentFilter("com.tencent.mm.plugin.openapi.Intent.ACTION_REFRESH_WXAPP"));
        if (this.duR != null) {
            return true;
        }
        return false;
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        x.i("MicroMsg.WXCommProvider", "uri:%s", uri);
        if (uri == null) {
            x.e("MicroMsg.WXCommProvider", "query fail, uri is null return null");
            return null;
        }
        String[] aty = aty();
        if (aty == null || aty.length <= 0) {
            x.e("MicroMsg.WXCommProvider", "CallingPackages is null return null");
            return null;
        }
        int match = hdR.match(uri);
        if (a.sFg == null) {
            new al(Looper.getMainLooper(), new 2(this), true).J(50, 50);
            try {
                synchronized (lock) {
                    x.i("MicroMsg.WXCommProvider", "Lock to wait for the first initialize of the Application.");
                    while (!hdS) {
                        lock.wait();
                    }
                    hdS = false;
                }
            } catch (Throwable e) {
                x.e("MicroMsg.WXCommProvider", "the lock may have some problem," + e.getMessage());
                x.printErrStackTrace("MicroMsg.WXCommProvider", e, "", new Object[0]);
            }
        }
        return a(uri, strArr, str, strArr2, str2, match, aty);
    }

    public final Cursor a(Uri uri, String[] strArr, String str, String[] strArr2, String str2, int i, String[] strArr3) {
        Cursor matrixCursor;
        eu euVar;
        b tnVar;
        b ogVar;
        ca caVar;
        switch (i) {
            case 3:
            case 9:
            case 13:
            case 22:
            case 23:
            case 25:
            case 29:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 40:
            case 41:
            case 42:
            case 46:
            case 48:
                long currentTimeMillis = System.currentTimeMillis();
                if (atA()) {
                    fb fbVar = new fb();
                    fbVar.bNg.bMB = i;
                    fbVar.bNg.uri = uri;
                    fbVar.bNg.selectionArgs = strArr2;
                    fbVar.bNg.context = getContext();
                    fbVar.bNg.bGj = strArr3;
                    if (a.sFg.m(fbVar)) {
                        x.i("MicroMsg.WXCommProvider", "[extApiCost] total cost = %s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                        return fbVar.bNh.bMC;
                    }
                    x.e("MicroMsg.WXCommProvider", "ExtCallEvent fail return code = 8");
                    matrixCursor = new MatrixCursor(com.tencent.mm.protocal.b.iJr);
                    matrixCursor.addRow(new Object[]{Integer.valueOf(8)});
                    return matrixCursor;
                }
                String oV = bi.oV(uri.getQueryParameter("appid"));
                if ("1".equals(bi.aG(uri.getQueryParameter("autoLogin"), "0"))) {
                    x.i("MicroMsg.WXCommProvider", "hy: not login. try to login return code = 9");
                    aq.qBc = new aq(uri, strArr, str, strArr2, str2, i, strArr3);
                    aq.qBd = System.currentTimeMillis();
                    getContext().startActivity(new Intent(getContext(), LoginUI.class));
                    matrixCursor = new MatrixCursor(com.tencent.mm.protocal.b.iJr);
                    matrixCursor.addRow(new Object[]{Integer.valueOf(9)});
                    return matrixCursor;
                }
                x.i("MicroMsg.WXCommProvider", "not login, appID = %s, apiID = %s return code =%s ", oV, Integer.valueOf(i), Integer.valueOf(3));
                h.mEJ.h(10505, bi.oV(strArr3[0]), oV, Integer.valueOf(i), Integer.valueOf(1), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                matrixCursor = new MatrixCursor(com.tencent.mm.protocal.b.iJr);
                matrixCursor.addRow(new Object[]{Integer.valueOf(3)});
                return matrixCursor;
            case 18:
            case 19:
            case 20:
                if (!atz()) {
                    return null;
                }
                ev evVar = new ev();
                evVar.bMz.bMB = i;
                evVar.bMz.uri = uri;
                evVar.bMz.selectionArgs = strArr2;
                evVar.bMz.context = getContext();
                evVar.bMz.bGj = strArr3;
                if (a.sFg.m(evVar)) {
                    return evVar.bMA.bMC;
                }
                x.e("MicroMsg.WXCommProvider", "ExtCallEvent fail");
                return null;
            case 21:
                euVar = new eu();
                euVar.bMx.op = 21;
                euVar.bMx.source = 1;
                euVar.bMx.selectionArgs = strArr2;
                euVar.bMx.context = getContext();
                euVar.bMx.bGj = strArr3;
                if (!a.sFg.m(euVar)) {
                    x.e("MicroMsg.WXCommProvider", "ExtCallBizEvent fail");
                }
                return null;
            case 24:
                if (!atz()) {
                    return this.hdQ;
                }
                tnVar = new tn();
                tnVar.cfa.bMB = i;
                tnVar.cfa.uri = uri;
                tnVar.cfa.context = getContext();
                for (int i2 = 0; i2 < strArr3.length; i2++) {
                    if (strArr3[i2] != null) {
                        tnVar.cfa.cfc = strArr3[i2];
                        if (!a.sFg.m(tnVar)) {
                            return tnVar.cfb.bMC;
                        }
                        x.e("MicroMsg.WXCommProvider", "WatchAppIdRegEvent fail");
                        return null;
                    }
                }
                if (!a.sFg.m(tnVar)) {
                    return tnVar.cfb.bMC;
                }
                x.e("MicroMsg.WXCommProvider", "WatchAppIdRegEvent fail");
                return null;
            case 26:
                g gVar = new g();
                gVar.bGi.selectionArgs = strArr2;
                gVar.bGi.bGj = strArr3;
                gVar.bGi.context = getContext();
                if (!a.sFg.m(gVar)) {
                    x.e("MicroMsg.WXCommProvider", "add card to wx fail");
                }
                return null;
            case 27:
                if (strArr2 == null || strArr2.length < 2) {
                    x.e("MicroMsg.WXCommProvider", "wrong args");
                    return null;
                }
                euVar = new eu();
                euVar.bMx.op = 27;
                euVar.bMx.source = 1;
                euVar.bMx.selectionArgs = strArr2;
                euVar.bMx.context = getContext();
                euVar.bMx.bGj = strArr3;
                if (!a.sFg.m(euVar)) {
                    x.e("MicroMsg.WXCommProvider", "ExtCallBizEvent fail");
                }
                return null;
            case 28:
                euVar = new eu();
                euVar.bMx.op = i;
                euVar.bMx.selectionArgs = strArr2;
                euVar.bMx.context = getContext();
                euVar.bMx.bGj = strArr3;
                if (!a.sFg.m(euVar)) {
                    x.e("MicroMsg.WXCommProvider", "ExtCallBizEvent fail");
                }
                return null;
            case 30:
            case 45:
                tnVar = new oi();
                tnVar.bZh.selectionArgs = strArr2;
                tnVar.bZh.bGj = strArr3;
                tnVar.bZh.context = getContext();
                tnVar.bZh.bZi = i == 45;
                if (i == 30 && strArr2 != null && strArr2.length > 2) {
                    d.qya = strArr2[2];
                }
                if (!a.sFg.m(tnVar)) {
                    x.e("MicroMsg.WXCommProvider", "open webview fail");
                }
                return null;
            case 31:
                ogVar = new og();
                ogVar.bZf.selectionArgs = strArr2;
                ogVar.bZf.bGj = strArr3;
                ogVar.bZf.context = getContext();
                if (!a.sFg.m(ogVar)) {
                    x.e("MicroMsg.WXCommProvider", "open busi luckymoney fail");
                }
                return null;
            case 32:
                caVar = new ca();
                caVar.bJp.action = 1;
                caVar.bJp.selectionArgs = strArr2;
                caVar.bJp.bGj = strArr3;
                caVar.bJp.context = getContext();
                if (!a.sFg.m(caVar)) {
                    x.e("MicroMsg.WXCommProvider", "open webview fail");
                }
                return null;
            case 33:
                caVar = new ca();
                caVar.bJp.action = 2;
                caVar.bJp.selectionArgs = strArr2;
                caVar.bJp.bGj = strArr3;
                caVar.bJp.context = getContext();
                if (!a.sFg.m(caVar)) {
                    x.e("MicroMsg.WXCommProvider", "open webview fail");
                }
                return null;
            case 39:
                com.tencent.mm.g.a.bi biVar = new com.tencent.mm.g.a.bi();
                biVar.bIT.selectionArgs = strArr2;
                biVar.bIT.bGj = strArr3;
                biVar.bIT.context = getContext();
                if (!a.sFg.m(biVar)) {
                    x.e("MicroMsg.WXCommProvider", "choose card from wx fail");
                }
                return null;
            case 44:
                ie ieVar = new ie();
                ieVar.bRF.selectionArgs = strArr2;
                ieVar.bRF.bGj = strArr3;
                ieVar.bRF.context = getContext();
                if (!a.sFg.m(ieVar)) {
                    x.e("MicroMsg.WXCommProvider", "handle scan result failed try again");
                    ah.i(new 3(this, ieVar), 200);
                }
                return null;
            case 47:
                of ofVar = new of();
                ofVar.bZe.selectionArgs = strArr2;
                ofVar.bZe.bGj = strArr3;
                ofVar.bZe.context = getContext();
                if (!a.sFg.m(ofVar)) {
                    x.e("MicroMsg.WXCommProvider", "launch wx miniprogram fail");
                }
                return null;
            case 49:
                ogVar = new oh();
                ogVar.bZg.selectionArgs = strArr2;
                ogVar.bZg.bGj = strArr3;
                ogVar.bZg.context = getContext();
                if (!a.sFg.m(ogVar)) {
                    x.e("MicroMsg.WXCommProvider", "open offline pay fail");
                }
                return null;
            default:
                MatrixCursor matrixCursor2 = new MatrixCursor(hdP);
                matrixCursor = (Cursor) new 4(this, uri, i, strArr3, matrixCursor2).a(this.handler);
                if (matrixCursor != null) {
                    return matrixCursor;
                }
                matrixCursor2.close();
                return matrixCursor;
        }
    }

    public String getType(Uri uri) {
        return null;
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    public int delete(Uri uri, String str, String[] strArr) {
        if (uri == null) {
            x.e("MicroMsg.WXCommProvider", "delete fail, uri is null");
            return 0;
        }
        return ((Integer) new 5(this, Integer.valueOf(0), uri, hdR.match(uri), aty()).a(this.handler)).intValue();
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }

    private String[] aty() {
        try {
            int callingUid = Binder.getCallingUid();
            String[] packagesForUid = getContext().getPackageManager().getPackagesForUid(Binder.getCallingUid());
            String str = "MicroMsg.WXCommProvider";
            String str2 = "getCallingPackages, callingUid = %d, packages size = %d";
            Object[] objArr = new Object[2];
            objArr[0] = Integer.valueOf(callingUid);
            objArr[1] = Integer.valueOf(packagesForUid == null ? 0 : packagesForUid.length);
            x.i(str, str2, objArr);
            if (packagesForUid == null) {
                x.w("MicroMsg.WXCommProvider", "getCallingPackages fail, packages is null");
                return new String[0];
            }
            int length = packagesForUid.length;
            for (callingUid = 0; callingUid < length; callingUid++) {
                x.i("MicroMsg.WXCommProvider", "getCallingPackages = %s", packagesForUid[callingUid]);
            }
            return packagesForUid;
        } catch (Exception e) {
            x.e("MicroMsg.WXCommProvider", "getCallingPackages, ex = %s", e.getMessage());
            return new String[0];
        }
    }

    private boolean atz() {
        try {
            x.i("MicroMsg.WXCommProvider", "checkIsLogin()");
            if (hdT || ((Boolean) new 6(this, Boolean.valueOf(false)).a(this.handler)).booleanValue()) {
                if (au.HX() && au.HW() && !au.Dr()) {
                    hdT = true;
                } else {
                    hdT = false;
                }
                x.i("MicroMsg.WXCommProvider", "hasLogin = " + hdT);
                return hdT;
            }
            x.i("MicroMsg.WXCommProvider", "checkIsLogin !syncTaskRet");
            hdT = false;
            return false;
        } catch (Throwable e) {
            x.w("MicroMsg.WXCommProvider", e.getMessage());
            x.printErrStackTrace("MicroMsg.WXCommProvider", e, "", new Object[0]);
            return false;
        }
    }

    private boolean atA() {
        try {
            x.i("MicroMsg.WXCommProvider", "checkIsLogin()");
            if (!hdT) {
                com.tencent.mm.pluginsdk.d.a.b bVar = new com.tencent.mm.pluginsdk.d.a.b();
                bVar.b(4000, new 7(this, bVar));
            }
            if (au.HX() && au.HW() && !au.Dr()) {
                hdT = true;
            } else {
                hdT = false;
            }
            x.i("MicroMsg.WXCommProvider", "hasLogin = " + hdT);
            return hdT;
        } catch (Throwable e) {
            x.w("MicroMsg.WXCommProvider", e.getMessage());
            x.printErrStackTrace("MicroMsg.WXCommProvider", e, "", new Object[0]);
            return false;
        }
    }
}

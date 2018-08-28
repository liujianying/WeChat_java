package com.tencent.mm.plugin.ext.openapi.provider;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.Looper;
import com.tencent.mm.a.e;
import com.tencent.mm.aa.f;
import com.tencent.mm.bg.d;
import com.tencent.mm.g.a.fh;
import com.tencent.mm.g.a.qx;
import com.tencent.mm.model.au;
import com.tencent.mm.model.q;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.modelvoice.i;
import com.tencent.mm.modelvoice.o;
import com.tencent.mm.plugin.ext.c.d.b;
import com.tencent.mm.plugin.ext.c.e$a;
import com.tencent.mm.plugin.ext.c.e.2;
import com.tencent.mm.plugin.ext.provider.ExtContentProviderBase;
import com.tencent.mm.plugin.ext.ui.RedirectToQrCodeStubUI;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.sight.base.c;
import com.tencent.mm.plugin.wxpay.a$k;
import com.tencent.mm.pluginsdk.d.a.a;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.bk;
import com.tencent.mm.storage.bu;
import com.tencent.rtmp.TXLiveConstants;
import java.io.File;

public class ExtControlProviderOpenApi extends ExtContentProviderBase {
    private static final String[] iJA = new String[]{"retCode", "sportConfig"};
    private static final String[] iJB = new String[]{"openid", "avatar"};
    private static final String[] iJC = new String[]{"voiceType", "sampleRateInHz", "channelConfig", "audioFormat", "filePath"};
    private static final String[] iJD = new String[]{"ssid", "macAddress", "isSupportWechat", "name"};
    public static boolean iJy = false;
    private static final String[] iJz = new String[]{"retCode", "selfId"};
    private Context context;
    private ag handler;
    private String[] iJE = null;
    private int iJF = -1;

    public ExtControlProviderOpenApi(String[] strArr, int i, Context context) {
        this.iJE = strArr;
        this.iJF = i;
        this.context = context;
    }

    public String getType(Uri uri) {
        return null;
    }

    public boolean onCreate() {
        this.handler = new ag();
        return true;
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        x.i("MicroMsg.ExtControlProviderOpenApi", "query(), ApiId = %s", new Object[]{Integer.valueOf(this.iJF)});
        a(uri, this.context, this.iJF, this.iJE);
        String str3 = this.iJN;
        if (uri == null) {
            x.e("MicroMsg.ExtControlProviderOpenApi", "uri == null return code = 5");
            cw(3, 5);
            return a.BA(5);
        } else if (bi.oW(this.iJN)) {
            x.e("MicroMsg.ExtControlProviderOpenApi", "AppID == null return code = 7");
            cw(3, 7);
            return a.BA(7);
        } else if (bi.oW(aIW())) {
            x.e("MicroMsg.ExtControlProviderOpenApi", "PkgName == null return code = 6");
            cw(3, 6);
            return a.BA(6);
        } else if (atA()) {
            int i = 1;
            if (!iJy) {
                i = aIX();
            }
            if (i != 1) {
                x.e("MicroMsg.ExtControlProviderOpenApi", "invalid appid ! return code = " + i);
                cw(2, i);
                return a.BA(i);
            }
            String str4;
            String str5;
            Intent intent;
            long j;
            Intent intent2;
            switch (this.iJF) {
                case 22:
                    return i(uri.getQueryParameter("op"), uri.getQueryParameter("scene"), uri.getQueryParameter("msgType"), uri.getQueryParameter("msgState"));
                case 23:
                    return k(strArr2);
                case 25:
                    return l(strArr2);
                case 34:
                    x.i("MicroMsg.ExtControlProviderOpenApi", "sendSight ");
                    if (strArr2 == null || strArr2.length <= 0 || strArr2[0].length() <= 0) {
                        str3 = "MicroMsg.ExtControlProviderOpenApi";
                        str4 = "sendSight wrong args,args == null:%s";
                        Object[] objArr = new Object[1];
                        objArr[0] = Boolean.valueOf(strArr2 == null);
                        x.e(str3, str4, objArr);
                        cw(3, 3401);
                        return a.BA(3401);
                    }
                    Object obj;
                    str5 = strArr2[0];
                    if (bi.oW(str5) || !e.cn(str5)) {
                        obj = null;
                    } else {
                        c cVar = new c();
                        obj = SightVideoJNI.isSightOk(str5, cVar.ncd, cVar.nce, cVar.ncf, cVar.nch, cVar.ncg, cVar.ncg.length) == 0 ? 1 : null;
                    }
                    if (obj == null) {
                        x.e("MicroMsg.ExtControlProviderOpenApi", "isSightOk wrong args");
                        cw(3, 3402);
                        return a.BA(3402);
                    }
                    intent = new Intent();
                    intent.addFlags(268435456);
                    intent.addFlags(67108864);
                    intent.putExtra("sight_local_path", str5);
                    d.e(this.context, ".ui.transmit.SightForwardUI", intent);
                    H(12, 0, 1);
                    return a.BA(1);
                case a$k.AppCompatTheme_actionModeSelectAllDrawable /*35*/:
                    x.i("MicroMsg.ExtControlProviderOpenApi", "hy: start redirect to chatting by phone num");
                    if (strArr2 == null || strArr2.length <= 0 || bi.oW(strArr2[0])) {
                        x.e("MicroMsg.ExtControlProviderOpenApi", "hy: args error: no phone num or phone num is null or nil");
                        cw(3, 3201);
                        return a.BA(3201);
                    }
                    x.i("MicroMsg.ExtControlProviderOpenApi", "hy: start searching for phone num: %s", new Object[]{strArr2[0]});
                    i = new com.tencent.mm.plugin.ext.b.c(this.context, str5).aIS();
                    x.i("MicroMsg.ExtControlProviderOpenApi", " ret =  ", new Object[]{Integer.valueOf(i)});
                    if (i != -1) {
                        H(14, 0, i);
                        i = 0;
                    } else {
                        H(15, 0, i);
                    }
                    return a.BA(i);
                case a$k.AppCompatTheme_actionModeShareDrawable /*36*/:
                    x.i("MicroMsg.ExtControlProviderOpenApi", "hy: start redirect to wechat out by phone num");
                    if (strArr2 == null || strArr2.length < 3) {
                        x.e("MicroMsg.ExtControlProviderOpenApi", "hy: wechat out args error: args length error");
                        cw(3, 3301);
                        return a.BA(3301);
                    }
                    str5 = strArr2[0];
                    int i2 = bi.getInt(strArr2[1], -1);
                    str4 = strArr2[2];
                    x.i("MicroMsg.ExtControlProviderOpenApi", "hy: start wechat out: contactid: %s, countrycode: %s,  phone num: %s", new Object[]{str5, Integer.valueOf(i2), str4});
                    if (bi.oW(str5) || i2 < 0 || bi.oW(str4)) {
                        x.i("MicroMsg.ExtControlProviderOpenApi", "hy: param err");
                        cw(3, 3302);
                        return a.BA(3302);
                    }
                    qx qxVar = new qx();
                    qxVar.cbG.cbH = str5;
                    qxVar.cbG.cbI = i2;
                    qxVar.cbG.cbJ = str4;
                    qxVar.cbG.bgn = com.tencent.mm.pluginsdk.a.h(str5, this.context);
                    com.tencent.mm.sdk.b.a.sFg.m(qxVar);
                    H(16, 0, 1);
                    return a.BA(1);
                case a$k.AppCompatTheme_actionModeFindDrawable /*37*/:
                    x.d("MicroMsg.ExtControlProviderOpenApi", com.tencent.mm.plugin.appbrand.jsapi.wifi.c.NAME);
                    this.handler = new ag(Looper.getMainLooper());
                    MatrixCursor matrixCursor = (MatrixCursor) new 1(this, strArr2).a(this.handler);
                    if (matrixCursor == null) {
                        H(19, 4, 14);
                        return a.BA(14);
                    }
                    H(18, 0, 1);
                    x.i("MicroMsg.ExtControlProviderOpenApi", "returnMatrix syncTaskCur");
                    return matrixCursor;
                case a$k.AppCompatTheme_actionModeWebSearchDrawable /*38*/:
                    x.d("MicroMsg.ExtControlProviderOpenApi", "connectWifi");
                    this.handler = new ag(Looper.getMainLooper());
                    Integer num = (Integer) new 2(this, strArr2).a(this.handler);
                    if (num == null) {
                        H(21, 4, 14);
                        return a.BA(14);
                    }
                    H(20, 0, num.intValue());
                    return a.BA(num.intValue());
                case a$k.AppCompatTheme_textAppearanceLargePopupMenu /*40*/:
                    x.i("MicroMsg.ExtControlProviderOpenApi", "setSportStep start");
                    if (strArr2 == null || strArr2.length < 3) {
                        x.e("MicroMsg.ExtControlProviderOpenApi", "args error: args length error");
                        H(23, 3, 2);
                        return a.BA(2);
                    }
                    long j2 = bi.getLong(strArr2[0], -1);
                    j = bi.getLong(strArr2[1], -1);
                    long j3 = bi.getLong(strArr2[2], -1);
                    x.i("MicroMsg.ExtControlProviderOpenApi", "setSportStep: timestampe: %s, stepcount: %s,  version: %s", new Object[]{Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3)});
                    if (j < 0 || j2 < 0 || j3 < 0) {
                        x.i("MicroMsg.ExtControlProviderOpenApi", "param err");
                        H(23, 3, 2);
                        return a.BA(2);
                    }
                    aIT();
                    fh fhVar = new fh();
                    fhVar.bNx.action = 2;
                    fhVar.bNx.bNz = j;
                    fhVar.bNx.bNA = j2;
                    fhVar.bNx.bNB = j3;
                    if (com.tencent.mm.sdk.b.a.sFg.m(fhVar) && fhVar.bNy.bND) {
                        H(22, 0, fhVar.bNy.bNE);
                        return a.BA(fhVar.bNy.bNE);
                    }
                    H(23, 4, 8);
                    return a.BA(8);
                case a$k.AppCompatTheme_textAppearanceSmallPopupMenu /*41*/:
                    x.i("MicroMsg.ExtControlProviderOpenApi", "getSportConfig start");
                    aIT();
                    fh fhVar2 = new fh();
                    fhVar2.bNx.action = 3;
                    if (com.tencent.mm.sdk.b.a.sFg.m(fhVar2) && fhVar2.bNy.bND) {
                        str4 = fhVar2.bNy.bNC;
                        Cursor matrixCursor2 = new MatrixCursor(iJA);
                        matrixCursor2.addRow(new Object[]{Integer.valueOf(fhVar2.bNy.bNE), bi.oV(str4)});
                        H(22, 0, fhVar2.bNy.bNE);
                        x.i("MicroMsg.ExtControlProviderOpenApi", "return  code =%s ", new Object[]{Integer.valueOf(fhVar2.bNy.bNE)});
                        return matrixCursor2;
                    }
                    H(23, 4, 8);
                    return a.BA(8);
                case a$k.AppCompatTheme_dialogTheme /*42*/:
                    intent2 = new Intent();
                    intent2.addFlags(131072);
                    intent2.putExtra("key_from_scene", 4);
                    if (strArr2 == null || strArr2.length <= 0 || strArr2[0].length() <= 0) {
                        x.i("MicroMsg.ExtControlProviderOpenApi", "openOffline appid:%s", new Object[]{str3});
                    } else {
                        x.i("MicroMsg.ExtControlProviderOpenApi", "openOffline business_attach:%s,appid:%s", new Object[]{strArr2[0], str3});
                        intent2.putExtra("key_business_attach", strArr2[0]);
                    }
                    intent2.putExtra("key_appid", str3);
                    d.b(this.context, "offline", ".ui.WalletOfflineEntranceUI", intent2);
                    h.mEJ.h(12097, new Object[]{Integer.valueOf(9), Integer.valueOf(0), Long.valueOf(System.currentTimeMillis())});
                    H(24, 0, 1);
                    return a.BA(1);
                case a$k.AppCompatTheme_dropdownListPreferredItemHeight /*46*/:
                    x.d("MicroMsg.ExtControlProviderOpenApi", "openClean appid:%s", new Object[]{str3});
                    au.HU();
                    if (com.tencent.mm.model.c.isSDCardAvailable()) {
                        intent2 = new Intent();
                        intent2.putExtra("key_from_openapi", true);
                        intent2.putExtra("key_openapi_appid", str3);
                        d.b(this.context, "clean", ".ui.CleanUI", intent2);
                        H(26, 0, 1);
                        return a.BA(1);
                    }
                    H(27, 5, 4);
                    return a.BA(4101);
                case a$k.AppCompatTheme_homeAsUpIndicator /*48*/:
                    com.tencent.mm.plugin.ext.c.e.aJh().mContext = this.context;
                    if (strArr2 == null || strArr2.length <= 0) {
                        x.w("MicroMsg.ExtControlProviderOpenApi", "hy: invalid arg length!");
                        return a.BA(4201);
                    }
                    int i3 = bi.getInt(strArr2[0], -1);
                    if (i3 < 0 || !(i3 == 0 || i3 == 1 || i3 == 2)) {
                        x.w("MicroMsg.ExtControlProviderOpenApi", "hy: invalid command!");
                        H(32, 3, 2);
                        return a.BA(4201);
                    }
                    str5 = null;
                    if (i3 != 0 && i3 != 1) {
                        str4 = null;
                    } else if (strArr2.length < 2) {
                        x.w("MicroMsg.ExtControlProviderOpenApi", "hy: invalid arg length when check or open!");
                        return a.BA(4205);
                    } else {
                        str3 = strArr2[1];
                        if (i3 != 1) {
                            str4 = str3;
                        } else if (strArr2.length < 3) {
                            x.w("MicroMsg.ExtControlProviderOpenApi", "hy: not providing md5!");
                            return a.BA(4208);
                        } else {
                            str5 = strArr2[2];
                            str4 = str3;
                        }
                    }
                    x.i("MicroMsg.ExtControlProviderOpenApi", "hy: cmdid: %d, yuvHandle: %s", new Object[]{Integer.valueOf(i3), str4});
                    e$a AL;
                    switch (i3) {
                        case 0:
                            com.tencent.mm.plugin.ext.c.e aJh = com.tencent.mm.plugin.ext.c.e.aJh();
                            if (bi.oW(str4)) {
                                x.w("MicroMsg.ExtQrCodeHandler", "hy: null handle in doHandleCheckQrCode");
                                com.tencent.mm.plugin.ext.c.e.L(null, -1, 4205);
                                return a.BA(4205);
                            }
                            e$a e_a;
                            AL = com.tencent.mm.plugin.ext.c.c.AL(str4);
                            if (AL == null || bi.oW(AL.url)) {
                                b as = com.tencent.mm.plugin.ext.c.e.as(str4, false);
                                if (as == null) {
                                    x.w("MicroMsg.ExtQrCodeHandler", "hy: not retrieved yuv data in doHandleCheckQrCode");
                                    com.tencent.mm.plugin.ext.c.e.L(null, -1, 4206);
                                    return a.BA(4206);
                                }
                                AL = aJh.a(as);
                                if (AL == null || bi.oW(AL.url)) {
                                    x.w("MicroMsg.ExtQrCodeHandler", "hy: not resolved model");
                                    return a.BA(4203);
                                }
                                e_a = AL;
                            } else {
                                x.i("MicroMsg.ExtQrCodeHandler", "hy: handled previously. yuvhandle: %s, url: %s. direct return", new Object[]{str4, AL});
                                e_a = AL;
                            }
                            if (e_a.type != 19) {
                                x.i("MicroMsg.ExtQrCodeHandler", "hy: subapp code. can open");
                                return a.BA(1);
                            } else if (com.tencent.mm.plugin.ext.c.c.AN(e_a.url)) {
                                x.i("MicroMsg.ExtQrCodeHandler", "hy: fastjudge wechat cannot open: %s", new Object[]{e_a.url.toUpperCase()});
                                com.tencent.mm.plugin.ext.c.e.L(e_a.url, e_a.type, 4207);
                                return a.SI(e_a.url);
                            } else if (com.tencent.mm.plugin.ext.c.c.AM(e_a.url)) {
                                x.i("MicroMsg.ExtQrCodeHandler", "hy: wechat can open: %s", new Object[]{e_a.url});
                                com.tencent.mm.plugin.ext.c.e.L(e_a.url, e_a.type, 1);
                                return a.BA(1);
                            } else {
                                j = bi.VG();
                                b$b AO = com.tencent.mm.plugin.ext.c.c.AO(e_a.url);
                                x.i("MicroMsg.ExtQrCodeHandler", "hy: resolve config: %s, using: %d ms", new Object[]{AO.toString(), Long.valueOf(bi.bI(j))});
                                if (AO == b$b.WHITE) {
                                    com.tencent.mm.plugin.ext.c.c.AJ(e_a.url);
                                    com.tencent.mm.plugin.ext.c.e.L(e_a.url, e_a.type, 1);
                                    return a.BA(1);
                                }
                                if (AO != b$b.BLACK) {
                                    String str6 = e_a.url;
                                    int i4 = e_a.type;
                                    int i5 = e_a.iKW;
                                    x.i("MicroMsg.ExtQrCodeHandler", "hy: start remote judge url: %s", new Object[]{str6});
                                    long currentTimeMillis = System.currentTimeMillis();
                                    x.i("MicroMsg.ExtQrCodeHandler", "hy: can open: %b, using %d ms", new Object[]{(Boolean) new 2(aJh, Boolean.valueOf(true), str6, i4, i5).a(com.tencent.mm.plugin.ext.c.e.aJj()), Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
                                    if (((Boolean) new 2(aJh, Boolean.valueOf(true), str6, i4, i5).a(com.tencent.mm.plugin.ext.c.e.aJj())).booleanValue()) {
                                        com.tencent.mm.plugin.ext.c.c.AJ(e_a.url);
                                        com.tencent.mm.plugin.ext.c.e.L(e_a.url, e_a.type, 1);
                                        return a.BA(1);
                                    }
                                }
                                com.tencent.mm.plugin.ext.c.c.AK(e_a.url);
                                x.w("MicroMsg.ExtQrCodeHandler", "hy: remote wechat cannot open: %s", new Object[]{e_a.url});
                                com.tencent.mm.plugin.ext.c.e.L(e_a.url, e_a.type, 4207);
                                return a.SI(e_a.url);
                            }
                        case 1:
                            com.tencent.mm.plugin.ext.c.e aJh2 = com.tencent.mm.plugin.ext.c.e.aJh();
                            if (bi.oW(str4)) {
                                x.w("MicroMsg.ExtQrCodeHandler", "hy: null handle in doHandleOpenQrCode");
                                com.tencent.mm.plugin.ext.c.e.M(null, -1, 4205);
                                return a.BA(4205);
                            }
                            e$a AL2 = com.tencent.mm.plugin.ext.c.c.AL(str4);
                            if (AL2 != null && !bi.oW(AL2.url)) {
                                x.i("MicroMsg.ExtQrCodeHandler", "hy: handled previously. yuvhandle: %s, url: %s. direct return", new Object[]{str4, AL2});
                                AL = AL2;
                            } else if (bi.oW(str5)) {
                                x.w("MicroMsg.ExtQrCodeHandler", "hy: md5 not correct!!");
                                com.tencent.mm.plugin.ext.c.e.M(null, -1, 4208);
                                return a.BA(4208);
                            } else {
                                b as2 = com.tencent.mm.plugin.ext.c.e.as(str4, true);
                                if (as2 == null) {
                                    x.w("MicroMsg.ExtQrCodeHandler", "hy: not retrieved yuv data in doHandleOpenQrCode");
                                    com.tencent.mm.plugin.ext.c.e.M(null, -1, 4206);
                                    return a.BA(4206);
                                } else if (bi.oW(as2.bKg)) {
                                    x.w("MicroMsg.ExtQrCodeHandler", "hy: cannot retrieve md5 from yuv!");
                                    com.tencent.mm.plugin.ext.c.e.M(null, -1, 4210);
                                    return a.BA(4210);
                                } else if (as2.bKg.equalsIgnoreCase(str5)) {
                                    AL = aJh2.a(as2);
                                    if (AL == null || bi.oW(AL.url)) {
                                        x.w("MicroMsg.ExtQrCodeHandler", "hy: not resolved model");
                                        com.tencent.mm.plugin.ext.c.e.M(null, -1, 4203);
                                        return a.BA(4203);
                                    }
                                    com.tencent.mm.plugin.ext.c.c.a(str4, AL);
                                } else {
                                    x.w("MicroMsg.ExtQrCodeHandler", "hy: yuv data not match!!");
                                    com.tencent.mm.plugin.ext.c.e.M(null, -1, 4209);
                                    return a.BA(4209);
                                }
                            }
                            if (AL.type == 19 && com.tencent.mm.plugin.ext.c.c.AN(AL.url)) {
                                x.i("MicroMsg.ExtQrCodeHandler", "hy: fastjudge wechat cannot open: %s", new Object[]{AL.url});
                                com.tencent.mm.plugin.ext.c.e.M(AL.url, AL.type, 4207);
                                return a.BA(4207);
                            }
                            x.i("MicroMsg.ExtQrCodeHandler", "hy: do open");
                            x.i("MicroMsg.ExtQrCodeHandler", "hy: start open: %s", new Object[]{AL.toString()});
                            intent = new Intent(aJh2.mContext, RedirectToQrCodeStubUI.class);
                            intent.putExtra("K_STR", AL.url);
                            intent.putExtra("K_TYPE", AL.type);
                            intent.putExtra("K_VERSION", AL.iKW);
                            intent.addFlags(268435456);
                            aJh2.mContext.startActivity(intent);
                            com.tencent.mm.plugin.ext.c.e.M(AL.url, AL.type, 1);
                            return a.BA(1);
                        case 2:
                            com.tencent.mm.plugin.ext.c.e.aJh();
                            return com.tencent.mm.plugin.ext.c.e.aJi();
                        default:
                            return null;
                    }
                default:
                    cw(3, 15);
                    return null;
            }
        } else {
            x.e("MicroMsg.ExtControlProviderOpenApi", "not login return code = 3");
            cw(1, 3);
            return a.BA(3);
        }
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }

    private Cursor i(String str, String str2, String str3, String str4) {
        int i = -1;
        x.i("MicroMsg.ExtControlProviderOpenApi", "registerMsgReceiver, op = %s", new Object[]{str});
        if (this.context == null) {
            x.e("MicroMsg.ExtControlProviderOpenApi", "context == null return code = 2001");
            cw(4, TXLiveConstants.PLAY_EVT_CONNECT_SUCC);
            return a.BA(TXLiveConstants.PLAY_EVT_CONNECT_SUCC);
        } else if (bi.oW(str)) {
            x.e("MicroMsg.ExtControlProviderOpenApi", "wrong args, op is null return code = 2002");
            cw(3, TXLiveConstants.PLAY_EVT_RTMP_STREAM_BEGIN);
            return a.BA(TXLiveConstants.PLAY_EVT_RTMP_STREAM_BEGIN);
        } else {
            try {
                i = bi.getInt(str, -1);
            } catch (Exception e) {
            }
            if (i == 1) {
                return O(str2, str3, str4);
            }
            if (i == 2) {
                x.d("MicroMsg.ExtControlProviderOpenApi", "doUnRegisterMsgListener");
                if (com.tencent.mm.plugin.ext.b.aIL().Zf(this.iJN) == null) {
                    x.w("MicroMsg.ExtControlProviderOpenApi", "This app never been registered, appId = %s, pkg = %s", new Object[]{this.iJN, aIW()});
                    return a.BA(TXLiveConstants.PLAY_EVT_PLAY_LOADING);
                }
                boolean z;
                bk aIL = com.tencent.mm.plugin.ext.b.aIL();
                String str5 = this.iJN;
                if (str5 == null || str5.length() <= 0) {
                    z = false;
                } else {
                    z = aIL.diF.delete("OpenMsgListener", "appId=?", new String[]{bi.oU(str5)}) > 0;
                }
                x.i("MicroMsg.ExtControlProviderOpenApi", "doUnRegisterMsgListener ret = %s, appId = %s, pkg = %s", new Object[]{Boolean.valueOf(z), this.iJN, aIW()});
                if (!z) {
                    return a.BA(TXLiveConstants.PLAY_EVT_START_VIDEO_DECODER);
                }
                H(0, 0, 1);
                return a.BA(1);
            }
            x.e("MicroMsg.ExtControlProviderOpenApi", "wrong args, no such op, %s", new Object[]{Integer.valueOf(i)});
            cw(3, TXLiveConstants.PLAY_EVT_RCV_FIRST_I_FRAME);
            return a.BA(TXLiveConstants.PLAY_EVT_RCV_FIRST_I_FRAME);
        }
    }

    private Cursor O(String str, String str2, String str3) {
        Exception e;
        x.i("MicroMsg.ExtControlProviderOpenApi", "doRegisterMsgListener");
        if (bi.oW(str) || bi.oW(str2) || bi.oW(str3)) {
            x.e("MicroMsg.ExtControlProviderOpenApi", "wrong args, scene = %s, msgType = %s, msgState = %s", new Object[]{str, str2, str3});
            cw(3, TXLiveConstants.PLAY_EVT_PLAY_BEGIN);
            return a.BA(TXLiveConstants.PLAY_EVT_PLAY_BEGIN);
        }
        MatrixCursor matrixCursor = null;
        try {
            int parseInt = Integer.parseInt(str3);
            int parseInt2 = Integer.parseInt(str);
            int parseInt3 = Integer.parseInt(str2);
            if (parseInt != 2) {
                x.e("MicroMsg.ExtControlProviderOpenApi", "wrong msgState: " + parseInt);
                cw(3, TXLiveConstants.PLAY_EVT_PLAY_PROGRESS);
                return a.BA(TXLiveConstants.PLAY_EVT_PLAY_PROGRESS);
            }
            if (com.tencent.mm.plugin.ext.b.aIL().Zf(this.iJN) == null) {
                bj bjVar = new bj();
                bjVar.field_appId = this.iJN;
                bjVar.field_packageName = aIW();
                String str4 = this.iJN;
                if (bi.oW(str4) ? false : g.i(g.bl(str4, true))) {
                    bjVar.field_status = 1;
                } else {
                    bjVar.field_status = 0;
                }
                bjVar.field_sceneFlag = parseInt2;
                bjVar.field_msgTypeFlag = parseInt3;
                bjVar.field_msgState = parseInt;
                x.i("MicroMsg.ExtControlProviderOpenApi", "registerMsgReceiver ret = %s, pkgName = %s, scene = %s, msgType = %s, msgState = %s, appStatus = %s", new Object[]{Boolean.valueOf(com.tencent.mm.plugin.ext.b.aIL().b(bjVar)), aIW(), Integer.valueOf(parseInt2), Integer.valueOf(parseInt), Integer.valueOf(parseInt), Integer.valueOf(bjVar.field_status)});
                if (!com.tencent.mm.plugin.ext.b.aIL().b(bjVar)) {
                    return a.BA(TXLiveConstants.PLAY_EVT_PLAY_END);
                }
            }
            x.w("MicroMsg.ExtControlProviderOpenApi", "This app had already been registered, appId = %s, pkg = %s", new Object[]{this.iJN, aIW()});
            StringBuilder append = new StringBuilder().append(q.GF());
            au.HU();
            String ce = ac.ce(append.append(com.tencent.mm.model.c.Df()).toString());
            Cursor matrixCursor2 = new MatrixCursor(iJz);
            try {
                matrixCursor2.addRow(new Object[]{Integer.valueOf(1), bi.oV(ce)});
                H(0, 0, 1);
                x.i("MicroMsg.ExtControlProviderOpenApi", "return  code =%s ", new Object[]{Integer.valueOf(1)});
                return matrixCursor2;
            } catch (Exception e2) {
                e = e2;
                Cursor matrixCursor3 = matrixCursor2;
            }
        } catch (Exception e3) {
            e = e3;
            H(1, 4, 12);
            x.e("MicroMsg.ExtControlProviderOpenApi", "exception in doRegisterMsgListener, %s", new Object[]{e.getMessage()});
            if (matrixCursor3 != null) {
                matrixCursor3.close();
            }
            return a.BA(12);
        }
    }

    private Cursor k(String[] strArr) {
        x.i("MicroMsg.ExtControlProviderOpenApi", "getUserAvatarByOpenId");
        if (strArr == null || strArr.length <= 0) {
            x.e("MicroMsg.ExtControlProviderOpenApi", "wrong args");
            cw(3, 3001);
            return a.BA(3001);
        }
        Cursor matrixCursor = new MatrixCursor(iJB);
        int i = 0;
        while (i < strArr.length && i < 5) {
            try {
                if (!bi.oW(strArr[i])) {
                    bu Zq = com.tencent.mm.plugin.ext.b.aIM().Zq(strArr[i]);
                    if (Zq == null || bi.oW(Zq.field_openId) || bi.oW(Zq.field_username)) {
                        x.e("MicroMsg.ExtControlProviderOpenApi", "openidInApp is null");
                    } else {
                        au.HU();
                        ab Yg = com.tencent.mm.model.c.FR().Yg(Zq.field_username);
                        if (Yg == null || Yg.field_username == null || Yg.field_username.length() <= 0) {
                            x.e("MicroMsg.ExtControlProviderOpenApi", "contact is null");
                        } else {
                            String c = com.tencent.mm.aa.q.Kp().c(Yg.field_username, false, false);
                            if (bi.oW(c)) {
                                x.w("MicroMsg.ExtControlProviderOpenApi", "hy: get avatar sfs path is null or nil");
                            } else {
                                String str;
                                if (c.startsWith(com.tencent.mm.kernel.g.Ei().cachePath)) {
                                    str = com.tencent.mm.kernel.g.Ei().dqp + c.substring(com.tencent.mm.kernel.g.Ei().cachePath.length());
                                    FileOp.mL(new File(str).getParent());
                                    FileOp.y(c, str);
                                } else {
                                    str = c;
                                }
                                c = Yg.field_username;
                                f.d.jY(str);
                                if (FileOp.mH(str)) {
                                    matrixCursor.addRow(new Object[]{strArr[i], str});
                                } else {
                                    x.w("MicroMsg.ExtControlProviderOpenApi", "hy: copy or replace avatar from sfs to file system failed");
                                }
                            }
                        }
                    }
                }
                i++;
            } catch (Exception e) {
                x.e("MicroMsg.ExtControlProviderOpenApi", "Exception occur, %s", new Object[]{e.getMessage()});
                H(7, 4, 12);
                matrixCursor.close();
                return a.BA(12);
            }
        }
        H(6, 0, 1);
        return matrixCursor;
    }

    private Cursor l(String[] strArr) {
        x.i("MicroMsg.ExtControlProviderOpenApi", "decodeVoice");
        if (strArr == null || strArr.length <= 0 || strArr[0].length() <= 0) {
            x.e("MicroMsg.ExtControlProviderOpenApi", "decodeVoice wrong args");
            cw(3, 3101);
            return a.BA(3101);
        }
        MatrixCursor matrixCursor = null;
        int i = 0;
        while (i < 5 && i < strArr.length) {
            String str = strArr[i];
            try {
                if (o.f(str, 0, true)) {
                    String aB;
                    if (matrixCursor == null) {
                        matrixCursor = new MatrixCursor(iJC);
                    }
                    i iVar = new i();
                    String str2 = com.tencent.mm.plugin.ext.b.aIO() + "/" + ac.ce(str);
                    x.i("MicroMsg.ExtControlProviderOpenApi", "summerpcm pcmPath[%s]", new Object[]{str2});
                    if (!e.cn(str2) || cm(str2) == 0) {
                        aB = iVar.aB(str, str2);
                    } else {
                        x.d("MicroMsg.ExtControlProviderOpenApi", "pcm already exist");
                        aB = str2;
                    }
                    if (cm(str2) == 0) {
                        aB = iVar.aB(str, str2);
                    }
                    if (bi.oW(aB)) {
                        x.w("MicroMsg.ExtControlProviderOpenApi", "wrong args targetFilePath is null");
                    } else {
                        x.d("MicroMsg.ExtControlProviderOpenApi", "decode to pcm success %d", new Object[]{Integer.valueOf(i)});
                        matrixCursor.addRow(new Object[]{Integer.valueOf(1), Integer.valueOf(iVar.mSampleRate), Integer.valueOf(iVar.bEf), Integer.valueOf(2), aB});
                    }
                } else {
                    x.w("MicroMsg.ExtControlProviderOpenApi", "wrong args : %s", new Object[]{strArr[i]});
                }
            } catch (Exception e) {
                x.e("MicroMsg.ExtControlProviderOpenApi", "Exception in decodeVoice, %s", new Object[]{e.getMessage()});
            }
            i++;
        }
        if (matrixCursor != null) {
            H(8, 0, 1);
            return matrixCursor;
        }
        H(9, 3, 4);
        return a.BA(4);
    }

    private static int cm(String str) {
        if (str == null) {
            return 0;
        }
        File file = new File(str);
        if (file.exists()) {
            return (int) file.length();
        }
        return 0;
    }

    private void aIT() {
        String str = (String) com.tencent.mm.plugin.ext.b.aIK().get(aa.a.sUa, null);
        x.i("MicroMsg.ExtControlProviderOpenApi", "setSportBroadPkg: pkgNames: %s, pkg: %s", new Object[]{str, aIW()});
        if (str == null) {
            com.tencent.mm.plugin.ext.b.aIK().a(aa.a.sUa, aIW());
        } else if (!com.tencent.mm.compatible.loader.a.a(str.split(";"), r1)) {
            com.tencent.mm.plugin.ext.b.aIK().a(aa.a.sUa, str + ";" + aIW());
        }
    }
}

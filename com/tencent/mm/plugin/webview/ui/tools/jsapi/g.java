package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.app.Activity;
import android.app.ProgressDialog;
import android.app.Service;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Color;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcelable;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Base64;
import android.widget.Toast;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.map.lib.gl.model.GLIcon;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mars.smc.IDKey;
import com.tencent.mm.R;
import com.tencent.mm.ab.l;
import com.tencent.mm.ab.v;
import com.tencent.mm.ac.d$b;
import com.tencent.mm.ac.z;
import com.tencent.mm.ak.o;
import com.tencent.mm.g.a.ch;
import com.tencent.mm.g.a.cn;
import com.tencent.mm.g.a.da;
import com.tencent.mm.g.a.db;
import com.tencent.mm.g.a.de;
import com.tencent.mm.g.a.df;
import com.tencent.mm.g.a.dg;
import com.tencent.mm.g.a.di;
import com.tencent.mm.g.a.dl;
import com.tencent.mm.g.a.dr;
import com.tencent.mm.g.a.dx;
import com.tencent.mm.g.a.dy;
import com.tencent.mm.g.a.ea;
import com.tencent.mm.g.a.eb;
import com.tencent.mm.g.a.ee;
import com.tencent.mm.g.a.eo;
import com.tencent.mm.g.a.fi;
import com.tencent.mm.g.a.gk;
import com.tencent.mm.g.a.gl;
import com.tencent.mm.g.a.gm;
import com.tencent.mm.g.a.gn;
import com.tencent.mm.g.a.go;
import com.tencent.mm.g.a.gt;
import com.tencent.mm.g.a.hl;
import com.tencent.mm.g.a.hm;
import com.tencent.mm.g.a.ir;
import com.tencent.mm.g.a.lh;
import com.tencent.mm.g.a.lp;
import com.tencent.mm.g.a.lx;
import com.tencent.mm.g.a.mi;
import com.tencent.mm.g.a.nn;
import com.tencent.mm.g.a.np;
import com.tencent.mm.g.a.ot;
import com.tencent.mm.g.a.ow;
import com.tencent.mm.g.a.pc;
import com.tencent.mm.g.a.pz;
import com.tencent.mm.g.a.qu;
import com.tencent.mm.g.a.qy;
import com.tencent.mm.g.a.sv;
import com.tencent.mm.g.a.tl;
import com.tencent.mm.g.a.tw;
import com.tencent.mm.model.am;
import com.tencent.mm.model.at;
import com.tencent.mm.model.au;
import com.tencent.mm.model.av;
import com.tencent.mm.model.m;
import com.tencent.mm.model.q;
import com.tencent.mm.model.t;
import com.tencent.mm.model.u;
import com.tencent.mm.modelgeo.a.b;
import com.tencent.mm.modelgeo.c;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.opensdk.modelmsg.WXAppExtendObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXWebpageObject;
import com.tencent.mm.plugin.appbrand.jsapi.bh;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.game.f$k;
import com.tencent.mm.plugin.websearch.api.p;
import com.tencent.mm.plugin.webview.fts.i;
import com.tencent.mm.plugin.webview.fts.i.3;
import com.tencent.mm.plugin.webview.model.WebViewJSSDKFileItem;
import com.tencent.mm.plugin.webview.model.WebViewJSSDKImageItem;
import com.tencent.mm.plugin.webview.model.WebViewJSSDKVideoItem;
import com.tencent.mm.plugin.webview.model.af;
import com.tencent.mm.plugin.webview.model.ai;
import com.tencent.mm.plugin.webview.model.aj;
import com.tencent.mm.plugin.webview.model.ak;
import com.tencent.mm.plugin.webview.model.al;
import com.tencent.mm.plugin.webview.model.j;
import com.tencent.mm.plugin.webview.model.y;
import com.tencent.mm.plugin.webview.modeltools.d;
import com.tencent.mm.plugin.webview.stub.WebViewStubTempUI;
import com.tencent.mm.plugin.webview.stub.e;
import com.tencent.mm.plugin.webview.ui.tools.WebViewDownloadUI;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.ui.applet.n;
import com.tencent.mm.pluginsdk.ui.tools.r;
import com.tencent.mm.pluginsdk.wallet.h;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.MMProtocalJni;
import com.tencent.mm.protocal.c$ld;
import com.tencent.mm.protocal.c.aau;
import com.tencent.mm.protocal.c.ane;
import com.tencent.mm.protocal.c.anf;
import com.tencent.mm.protocal.c.aog;
import com.tencent.mm.protocal.c.aoh;
import com.tencent.mm.protocal.c.apy;
import com.tencent.mm.protocal.c.apz;
import com.tencent.mm.protocal.c.avq;
import com.tencent.mm.protocal.c.awz;
import com.tencent.mm.protocal.c.bjw;
import com.tencent.mm.protocal.c.bjx;
import com.tencent.mm.protocal.c.bk;
import com.tencent.mm.protocal.c.bth;
import com.tencent.mm.protocal.c.buf;
import com.tencent.mm.protocal.c.bug;
import com.tencent.mm.protocal.c.ccw;
import com.tencent.mm.protocal.c.ccx;
import com.tencent.mm.protocal.c.ccy;
import com.tencent.mm.protocal.c.ccz;
import com.tencent.mm.protocal.c.cfk;
import com.tencent.mm.protocal.c.iv;
import com.tencent.mm.protocal.c.zm;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.bl;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.mm.ui.contact.s;
import com.tencent.mm.ui.tools.k;
import com.tencent.smtt.sdk.TbsVideoCacheTask;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import com.tencent.tmassistantsdk.logreport.BaseReportManager;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;
import com.tencent.wework.api.WWAPIFactory;
import com.tencent.wework.api.model.WWMediaLink;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.net.URI;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

public class g implements a {
    private static final HashSet<String> fQY;
    private static final char[] gBx = new char[]{'<', '>', '\"', '\'', '&', ' ', '\''};
    private static final String[] gBy = new String[]{"&lt;", "&gt;", "&quot;", "&apos;", "&amp;", "&nbsp;", "&#39;"};
    private static boolean qiA = false;
    private static a qiB = new 120();
    public static Context qia;
    public static int qib = -1;
    private static final LinkedList<Runnable> qiz = new LinkedList();
    private WXMediaMessage bSg;
    public final int bWo;
    private c cXl = null;
    private Map<String, ane> cXp = new ConcurrentHashMap();
    private Context context;
    private ProgressDialog eHw = null;
    private com.tencent.mm.sdk.b.c fFB;
    private String hpJ = null;
    public boolean iKs = false;
    public HashSet<String> jGy;
    private ag jnn;
    private ProgressDialog kuy;
    private float mLC = 0.0f;
    private com.tencent.mm.sdk.b.c nbe = new 36(this);
    public com.tencent.mm.sdk.b.c nbf = new 37(this);
    public e pRY;
    public i qhP;
    public i qhQ;
    public HashSet<String> qhR;
    public Bundle qhS;
    private String qhT = null;
    public HashMap<String, String> qhU = null;
    public HashMap<String, String> qhV = null;
    public String qhW = null;
    public boolean qhX = false;
    public e qhY;
    private e qhZ;
    public final Map<Integer, c> qiC = new HashMap();
    private int qiD = 0;
    private int qiE = BaseReportManager.MAX_READ_COUNT;
    public volatile i qiF = null;
    public final com.tencent.mm.sdk.b.c qiG = new 26(this);
    private c qic = null;
    public boolean qid = false;
    private final j qie;
    private final d qif;
    private long qig = 0;
    private int qih;
    private int qii = -1;
    private Map<String, String> qij = new ConcurrentHashMap();
    private Map<String, List<anf>> qik = new ConcurrentHashMap();
    private List<ane> qil = new CopyOnWriteArrayList();
    private boolean qim = false;
    private long qin = 0;
    LocationManager qio = null;
    private String qip = "-1000.0";
    private String qiq = "-1000.0";
    private boolean qir = false;
    private SensorEventListener qis = new 38(this);
    private b qit = null;
    public i qiu;
    public com.tencent.mm.sdk.b.c qiv = new com.tencent.mm.sdk.b.c<qy>() {
        {
            this.sFo = qy.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            qy qyVar = (qy) bVar;
            if (qyVar != null && (qyVar instanceof qy)) {
                x.d("MicroMsg.MsgHandler", "StartVoipCSResultEvent = %s", new Object[]{Integer.valueOf(qyVar.cbK.status)});
                g.b(g.this, qyVar.cbK.status);
            }
            return false;
        }
    };
    public final Map<String, b> qiw = new HashMap();
    public String qix;
    public final List<String> qiy = new LinkedList();

    static /* synthetic */ boolean B(g gVar, i iVar) {
        x.i("MicroMsg.MsgHandler", "doOpenProductViewWithPid");
        String str = (String) iVar.mcy.get("pid");
        String str2 = (String) iVar.mcy.get(TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_URL);
        Integer valueOf = Integer.valueOf(bi.getInt((String) iVar.mcy.get(DownloadSettingTable$Columns.TYPE), 0));
        int i = bi.getInt((String) iVar.mcy.get("view_type"), 0);
        String str3 = (String) iVar.mcy.get("ext_info");
        Intent intent = new Intent();
        intent.putExtra("key_product_id", str);
        intent.putExtra("key_source_url", str2);
        return gVar.a(valueOf, 8, i, str3, intent);
    }

    static /* synthetic */ boolean C(g gVar, i iVar) {
        l.a(iVar.qkk, false, null, (String) iVar.mcy.get("appId"));
        x.i("MicroMsg.MsgHandler", "dogetBrandWCPayBindCardRequest JSOAUTH");
        if (gVar.context instanceof MMActivity) {
            com.tencent.mm.pluginsdk.wallet.g gVar2 = new com.tencent.mm.pluginsdk.wallet.g(iVar.mcy);
            gVar2.bVZ = 4;
            h.b((MMActivity) gVar.context, gVar2, 7, gVar);
        }
        return true;
    }

    static /* synthetic */ boolean H(g gVar, i iVar) {
        l.a(iVar.qkk, false, null, (String) iVar.mcy.get("appId"));
        x.i("MicroMsg.MsgHandler", "doOpenWXCredit JSOAUTH");
        if (gVar.context instanceof MMActivity) {
            com.tencent.mm.pluginsdk.wallet.g gVar2 = new com.tencent.mm.pluginsdk.wallet.g(iVar.mcy);
            gVar2.bVZ = 6;
            h.b((MMActivity) gVar.context, gVar2, 9, gVar);
        }
        return true;
    }

    static /* synthetic */ boolean I(g gVar, i iVar) {
        if (gVar.qhS == null) {
            x.e("MicroMsg.MsgHandler", "doSendServiceAppMsg fail, jsapiArgs is null");
            gVar.a(iVar, "send_service_app_msg:fail", null);
        } else if (gVar.qhS.getBoolean("isFromService", false)) {
            String string = gVar.qhS.getString("jsapi_args_appid");
            String string2 = gVar.qhS.getString("sendAppMsgToUserName");
            l.a(iVar.qkk, false, null, string);
            gVar.bSg = f(iVar);
            if (gVar.bSg == null) {
                x.e("MicroMsg.MsgHandler", "doSendServiceAppMsg fail, appmsg is null");
                gVar.a(iVar, "send_service_app_msg:fail", null);
            } else {
                f bl = com.tencent.mm.pluginsdk.model.app.g.bl(string, true);
                if (bi.oW(string2)) {
                    x.e("MicroMsg.MsgHandler", "toUser is null");
                    gVar.a(iVar, "send_service_app_msg:fail", null);
                } else {
                    String str = (String) iVar.mcy.get("img_url");
                    com.tencent.mm.plugin.report.service.h.mEJ.h(10923, new Object[]{Integer.valueOf(13), bl.field_appId, Integer.valueOf(1)});
                    if (bi.oW(str)) {
                        gVar.a(bl, "", string2, str, null, null, null, null);
                        com.tencent.mm.ui.base.h.bA(gVar.context, gVar.context.getString(R.l.app_saved));
                        gVar.a(iVar, "send_service_app_msg:ok", null);
                        gVar.aV(iVar);
                    } else {
                        o.Pe().a(str, new 8(gVar, com.tencent.mm.ui.base.h.a(gVar.context, gVar.context.getResources().getString(R.l.app_sending), true, new 7(gVar, str, iVar)), bl, string2, str, iVar));
                    }
                }
            }
        } else {
            x.e("MicroMsg.MsgHandler", "doSendServiceAppMsg fail, not from service");
            gVar.a(iVar, "send_service_app_msg:fail", null);
        }
        return true;
    }

    static /* synthetic */ boolean K(g gVar, i iVar) {
        String str = (String) iVar.mcy.get("title");
        String str2 = (String) iVar.mcy.get("singer");
        String str3 = (String) iVar.mcy.get("epname");
        String str4 = (String) iVar.mcy.get("coverImgUrl");
        String str5 = (String) iVar.mcy.get("dataUrl");
        String str6 = (String) iVar.mcy.get("lowbandUrl");
        String str7 = (String) iVar.mcy.get("webUrl");
        String str8 = (String) iVar.mcy.get("appId");
        String str9 = str4 == null ? "" : str4;
        l.a(iVar.qkk, false, null, str8);
        x.i("MicroMsg.MsgHandler", "title : %s, singer : %s, epName : %s, coverImgUrl : %s, dataUrl : %s, lowbandUrl : %s, webUrl : %s, appid : %s", new Object[]{str, str2, str3, str9, str5, str6, str7, str8});
        if (bi.oW(str) || bi.oW(str2) || bi.oW(str3) || bi.oW(str9) || bi.oW(str6) || bi.oW(str5) || bi.oW(str7)) {
            gVar.a(iVar, "playMusic:fail", null);
        } else {
            com.tencent.mm.an.b.PW();
            com.tencent.mm.an.a.b bVar = (com.tencent.mm.an.a.b) com.tencent.mm.kernel.g.l(com.tencent.mm.an.a.b.class);
            String str10 = str5.hashCode();
            String str11 = com.tencent.mm.compatible.util.e.bnE;
            StringBuilder stringBuilder = new StringBuilder();
            au.HU();
            com.tencent.mm.an.b.b(bVar.a(7, str9, str, str2, str7, str6, str5, str10, str11, stringBuilder.append(com.tencent.mm.model.c.Gb()).append(str9.hashCode()).toString(), str3, str8));
            gVar.a(iVar, "playMusic:ok", null);
        }
        return true;
    }

    static /* synthetic */ boolean L(g gVar, i iVar) {
        boolean z = false;
        String str = (String) iVar.mcy.get("ssid");
        String str2 = (String) iVar.mcy.get("password");
        x.d("MicroMsg.MsgHandler", "doConnectToWifi, ssid : %s, password : %s, encryptType : %s, hidessid : %s", new Object[]{str, str2, (String) iVar.mcy.get(DownloadSettingTable$Columns.TYPE), (String) iVar.mcy.get("isHidden")});
        if (bi.oW(str)) {
            x.e("MicroMsg.MsgHandler", "ssid is null");
            gVar.a(iVar, "connecttowifi:failed_ssid_invalid", null);
        } else {
            int i = bi.getInt(r0, 0);
            if (i == 0 || !bi.oW(str2)) {
                if (bi.getInt(r1, 0) == 1) {
                    z = true;
                }
                ah.A(new 54(gVar, str, str2, z, i));
                gVar.a(iVar, "connecttowifi:ok", null);
            } else {
                x.e("MicroMsg.MsgHandler", "encrypt type, while the password is null");
                gVar.a(iVar, "connecttowifi:failed_password_invalid", null);
            }
        }
        return true;
    }

    static /* synthetic */ boolean M(g gVar, i iVar) {
        x.i("MicroMsg.MsgHandler", "doGetTransferMoneyRequest JSOAUTH");
        l.a(iVar.qkk, false, null, (String) iVar.mcy.get("appId"));
        if (gVar.context instanceof MMActivity) {
            com.tencent.mm.pluginsdk.wallet.g gVar2 = new com.tencent.mm.pluginsdk.wallet.g(iVar.mcy);
            Intent intent = new Intent();
            intent.putExtra("scene", 3);
            intent.putExtra("appId", gVar2.appId);
            intent.putExtra("timeStamp", gVar2.timeStamp);
            intent.putExtra("nonceStr", gVar2.nonceStr);
            intent.putExtra("packageExt", gVar2.packageExt);
            intent.putExtra("signtype", gVar2.signType);
            intent.putExtra("paySignature", gVar2.bVW);
            intent.putExtra(TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_URL, gVar2.url);
            intent.putExtra("pay_channel", gVar2.bJY);
            ((MMActivity) gVar.context).geJ = gVar;
            com.tencent.mm.bg.d.b(gVar.context, "remittance", ".ui.RemittanceAdapterUI", intent, 11);
        }
        return true;
    }

    static /* synthetic */ boolean N(g gVar, i iVar) {
        x.i("MicroMsg.MsgHandler", "doOpenWCPaySpecificView");
        l.a(iVar.qkk, false, null, (String) iVar.mcy.get("appId"));
        if (gVar.context instanceof MMActivity) {
            com.tencent.mm.pluginsdk.wallet.g gVar2 = new com.tencent.mm.pluginsdk.wallet.g(iVar.mcy);
            Intent intent = new Intent();
            intent.putExtra("appId", gVar2.appId);
            intent.putExtra("timeStamp", gVar2.timeStamp);
            intent.putExtra("nonceStr", gVar2.nonceStr);
            intent.putExtra("packageExt", gVar2.packageExt);
            intent.putExtra("signtype", gVar2.signType);
            intent.putExtra("paySignature", gVar2.bVW);
            intent.putExtra(TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_URL, gVar2.url);
            intent.putExtra("pay_channel", gVar2.bJY);
            ((MMActivity) gVar.context).geJ = gVar;
            com.tencent.mm.bg.d.a(gVar.context, "wallet_index", ".ui.WalletOpenViewProxyUI", intent, 17, false);
        }
        return true;
    }

    static /* synthetic */ boolean O(g gVar, i iVar) {
        x.i("MicroMsg.MsgHandler", "doChooseCard JSOAUTH");
        String str = (String) iVar.mcy.get("app_id");
        int i = bi.getInt((String) iVar.mcy.get("location_id"), 0);
        String str2 = (String) iVar.mcy.get("sign_type");
        String str3 = (String) iVar.mcy.get("card_sign");
        int i2 = bi.getInt((String) iVar.mcy.get("time_stamp"), 0);
        String str4 = (String) iVar.mcy.get("nonce_str");
        String str5 = (String) iVar.mcy.get("card_id");
        String str6 = (String) iVar.mcy.get("card_type");
        if ("INVOICE".equalsIgnoreCase(str6)) {
            gVar.a(iVar, "choose_card:fail", new HashMap());
            return false;
        }
        int i3 = bi.getInt((String) iVar.mcy.get("can_multi_select"), 0);
        l.a(iVar.qkk, false, null, str);
        Intent intent = new Intent();
        intent.putExtra("app_id", str);
        intent.putExtra("shop_id", i);
        intent.putExtra("sign_type", str2);
        intent.putExtra("card_sign", str3);
        intent.putExtra("time_stamp", i2);
        intent.putExtra("nonce_str", str4);
        intent.putExtra("card_tp_id", str5);
        intent.putExtra("card_type", str6);
        intent.putExtra("can_multi_select", i3);
        intent.putExtra("key_from_scene", 7);
        if (gVar.context instanceof MMActivity) {
            ((MMActivity) gVar.context).geJ = gVar;
            com.tencent.mm.bg.d.a(gVar.context, "card", ".ui.CardListSelectedUI", intent, 13, false);
        }
        return true;
    }

    static /* synthetic */ boolean P(g gVar, i iVar) {
        x.i("MicroMsg.MsgHandler", "doChooseInvoice JSOAUTH");
        String str = (String) iVar.mcy.get("appId");
        String str2 = (String) iVar.mcy.get("signType");
        String str3 = (String) iVar.mcy.get("cardSign");
        int i = bi.getInt((String) iVar.mcy.get("timestamp"), 0);
        String str4 = (String) iVar.mcy.get("nonceStr");
        Intent intent = new Intent();
        intent.putExtra("app_id", str);
        intent.putExtra("sign_type", str2);
        intent.putExtra("card_sign", str3);
        intent.putExtra("time_stamp", i);
        intent.putExtra("nonce_str", str4);
        intent.putExtra("can_multi_select", 1);
        intent.putExtra("card_type", "INVOICE");
        intent.putExtra("key_from_scene", 7);
        if (gVar.context instanceof MMActivity) {
            ((MMActivity) gVar.context).geJ = gVar;
            com.tencent.mm.bg.d.a(gVar.context, "card", ".ui.CardListSelectedUI", intent, 36, false);
        }
        return true;
    }

    static /* synthetic */ boolean Q(g gVar, i iVar) {
        String str = (String) iVar.mcy.get("card_list");
        String str2 = (String) iVar.mcy.get("src_username");
        String str3 = (String) iVar.mcy.get(TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_URL);
        String str4 = (String) iVar.mcy.get("tempalate_id");
        x.i("MicroMsg.MsgHandler", "doBatchAddCard consumedCardId %s", new Object[]{(String) iVar.mcy.get("consumedCardId")});
        x.i("MicroMsg.MsgHandler", "doBatchAddCard %s", new Object[]{iVar.mcy.toString()});
        x.i("MicroMsg.MsgHandler", "doBatchAddCard src_username is %s, scene is %d, stasticScene is %d", new Object[]{str2, Integer.valueOf(bi.getInt((String) iVar.mcy.get("webview_scene"), 0) == 25 ? 16 : 7), Integer.valueOf(bi.getInt((String) iVar.mcy.get("stastic_scene"), 0))});
        Intent intent = new Intent();
        intent.putExtra("key_in_card_list", str);
        intent.putExtra("key_from_scene", r6);
        intent.putExtra("key_stastic_scene", r7);
        intent.putExtra("src_username", str2);
        intent.putExtra("js_url", str3);
        intent.putExtra("key_consumed_card_id", r4);
        intent.putExtra("key_template_id", str4);
        if (gVar.context instanceof MMActivity) {
            ((MMActivity) gVar.context).geJ = gVar;
            com.tencent.mm.bg.d.a(gVar.context, "card", ".ui.CardAddEntranceUI", intent, 16, false);
        }
        return true;
    }

    static /* synthetic */ boolean V(g gVar, i iVar) {
        String str = (String) iVar.mcy.get("appId");
        String str2 = (String) iVar.mcy.get("localId");
        l.a(iVar.qkk, false, null, str);
        x.i("MicroMsg.MsgHandler", "doPlayVoice, appId : %s, localId : %s", new Object[]{str, str2});
        if (bi.oW(str) || bi.oW(str2)) {
            gVar.a(iVar, "playVoice:fail_missing arguments", null);
        } else {
            WebViewJSSDKFileItem Qq = com.tencent.mm.plugin.webview.modeltools.e.bUX().Qq(str2);
            if (Qq != null) {
                ah.A(new 74(gVar, Qq, str2));
                gVar.a(iVar, "playVoice:ok", null);
            } else {
                gVar.a(iVar, "playVoice:fail_arguments error", null);
            }
        }
        return true;
    }

    static /* synthetic */ boolean W(g gVar, i iVar) {
        String str = (String) iVar.mcy.get("appId");
        String str2 = (String) iVar.mcy.get("localId");
        l.a(iVar.qkk, false, null, str);
        x.i("MicroMsg.MsgHandler", "doStopVoice, appId : %s, localId : %s", new Object[]{str, str2});
        if (bi.oW(str) || bi.oW(str2)) {
            gVar.a(iVar, "pauseVoice:fail_missing arguments", null);
        } else {
            WebViewJSSDKFileItem Qq = com.tencent.mm.plugin.webview.modeltools.e.bUX().Qq(str2);
            if (Qq != null) {
                ah.A(new 76(gVar, Qq));
                gVar.a(iVar, "pauseVoice:ok", null);
            } else {
                gVar.a(iVar, "pauseVoice:fail_not playing", null);
            }
        }
        return true;
    }

    static /* synthetic */ boolean X(g gVar, i iVar) {
        String str = (String) iVar.mcy.get("appId");
        String str2 = (String) iVar.mcy.get("localId");
        x.i("MicroMsg.MsgHandler", "doStopVoice, appId : %s, localId : %s", new Object[]{str, str2});
        l.a(iVar.qkk, false, null, str);
        if (bi.oW(str) || bi.oW(str2)) {
            gVar.a(iVar, "stopVoice:fail_missing arguments", null);
        } else {
            WebViewJSSDKFileItem Qq = com.tencent.mm.plugin.webview.modeltools.e.bUX().Qq(str2);
            if (Qq != null) {
                ah.A(new 75(gVar, Qq));
                gVar.a(iVar, "stopVoice:ok", null);
            } else {
                gVar.a(iVar, "stopVoice:fail_not playing", null);
            }
        }
        return true;
    }

    static /* synthetic */ com.tencent.mm.ui.widget.a.c a(g gVar, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        if (gVar.context == null || gVar.context.getResources() == null) {
            x.e("MicroMsg.MsgHandler", "showSendAppMsgDialog fail, context or context.getResources() is null");
            return null;
        } else if (gVar.context instanceof Activity) {
            String bYc = gVar.bYc();
            f bl = com.tencent.mm.pluginsdk.model.app.g.bl(str, true);
            return com.tencent.mm.pluginsdk.ui.applet.g.a(((MMActivity) gVar.context).mController, str2, str3, str5, true, gVar.context.getResources().getString(R.l.app_send), new 113(gVar, bl, str, str4, str3, str6, str7, bYc, str8, str9));
        } else {
            x.e("MicroMsg.MsgHandler", "showsSendAppMsgDialog fail, context is not activity");
            return null;
        }
    }

    static /* synthetic */ boolean aF(g gVar, i iVar) {
        String str = (String) iVar.mcy.get("gameId");
        if (bi.oW(str)) {
            str = (String) iVar.mcy.get("appId");
        }
        x.i("MicroMsg.MsgHandler", "openGameDetail, appid = %s", new Object[]{str});
        if (bi.oW(str)) {
            gVar.a(iVar, "openGameDetail:fail", null);
        } else {
            gk gkVar = new gk();
            gkVar.bPB.appId = str;
            gkVar.bPB.scene = 5;
            gkVar.bPB.actionCode = 2;
            gkVar.bPB.context = gVar.context;
            com.tencent.mm.sdk.b.a.sFg.m(gkVar);
            gVar.a(iVar, "openGameDetail:ok", null);
        }
        return true;
    }

    static /* synthetic */ boolean aG(g gVar, i iVar) {
        int i = bi.getInt((String) iVar.mcy.get("jumpView"), 0);
        int i2 = bi.getInt((String) iVar.mcy.get("jumpType"), 0);
        String str = (String) iVar.mcy.get("extInfo");
        lh lhVar = new lh();
        lhVar.bVG.bVH = i;
        lhVar.bVG.jumpType = i2;
        lhVar.bVG.extraInfo = str;
        lhVar.bVG.context = gVar.context;
        com.tencent.mm.sdk.b.a.sFg.m(lhVar);
        gVar.a(iVar, "gameCenterJump:ok", null);
        return true;
    }

    static /* synthetic */ boolean aH(g gVar, i iVar) {
        int i = bi.getInt((String) iVar.mcy.get("downloaderType"), 0);
        String str = (String) iVar.mcy.get("countryCode");
        int i2 = bi.getInt((String) iVar.mcy.get("showAllLog"), 0);
        gm gmVar = new gm();
        gmVar.bPF.bPG = i;
        gmVar.bPF.bPH = i2;
        gmVar.bPF.countryCode = str;
        com.tencent.mm.sdk.b.a.sFg.m(gmVar);
        gVar.a(iVar, "setGameDebugConfig:ok", null);
        return true;
    }

    static /* synthetic */ boolean aJ(g gVar, i iVar) {
        x.i("MicroMsg.MsgHandler", "doGetRecevieBizHongBaoRequest");
        l.a(iVar.qkk, false, null, (String) iVar.mcy.get("appId"));
        if (gVar.context instanceof MMActivity) {
            com.tencent.mm.pluginsdk.wallet.g gVar2 = new com.tencent.mm.pluginsdk.wallet.g(iVar.mcy);
            Intent intent = new Intent();
            intent.putExtra("key_way", 3);
            intent.putExtra("appId", gVar2.appId);
            intent.putExtra("timeStamp", gVar2.timeStamp);
            intent.putExtra("nonceStr", gVar2.nonceStr);
            intent.putExtra("packageExt", gVar2.packageExt);
            intent.putExtra("signtype", gVar2.signType);
            intent.putExtra("paySignature", gVar2.bVW);
            intent.putExtra(TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_URL, gVar2.url);
            ((MMActivity) gVar.context).geJ = gVar;
            com.tencent.mm.bg.d.b(gVar.context, "luckymoney", ".ui.LuckyMoneyBusiReceiveUI", intent, 22);
        }
        return true;
    }

    static /* synthetic */ boolean aK(g gVar, i iVar) {
        x.d("MicroMsg.MsgHandler", "doOpenMyDeviceProfile");
        if (gVar.context != null) {
            String str = (String) iVar.mcy.get("deviceType");
            if (bi.oW(str)) {
                x.e("MicroMsg.MsgHandler", "deviceType is null");
                gVar.a(iVar, "openMyDeviceProfile:fail_no deviceType", null);
            } else {
                String str2 = (String) iVar.mcy.get("deviceId");
                if (bi.oW(str2)) {
                    x.e("MicroMsg.MsgHandler", "deviceId is null");
                    gVar.a(iVar, "openMyDeviceProfile:fail_no deviceId", null);
                } else {
                    Intent intent = new Intent();
                    if (!(gVar.context instanceof Activity)) {
                        intent.addFlags(268435456);
                    }
                    intent.putExtra("device_type", str);
                    intent.putExtra("device_id", str2);
                    com.tencent.mm.bg.d.b(gVar.context, "exdevice", ".ui.ExdeviceDeviceProfileUI", intent);
                    gVar.a(iVar, "openMyDeviceProfile:ok", null);
                }
            }
        } else {
            x.e("MicroMsg.MsgHandler", "context is null");
            gVar.a(iVar, "openMyDeviceProfile:fail", null);
        }
        return true;
    }

    static /* synthetic */ boolean aL(g gVar, i iVar) {
        x.i("MicroMsg.MsgHandler", "hy: doGetIbgPrepayRequest");
        l.a(iVar.qkk, false, null, (String) iVar.mcy.get("appId"));
        if (gVar.context instanceof MMActivity) {
            com.tencent.mm.pluginsdk.wallet.g gVar2 = new com.tencent.mm.pluginsdk.wallet.g(iVar.mcy);
            gVar2.qUW = 2;
            h.a((MMActivity) gVar.context, gVar2, 27, gVar);
            long j = bi.getLong((String) iVar.mcy.get("message_id"), 0);
            int i = bi.getInt((String) iVar.mcy.get("message_index"), 0);
            com.tencent.mm.plugin.report.service.h.mEJ.h(10593, new Object[]{gVar2.bVX, gVar2.appId, Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(gVar2.bVY), gVar2.url});
            gVar.qii = gVar.aW(iVar);
        }
        return true;
    }

    static /* synthetic */ boolean aM(g gVar, i iVar) {
        x.i("MicroMsg.MsgHandler", "hy: doGetIbgTransactionRequest");
        if (gVar.context instanceof MMActivity) {
            com.tencent.mm.pluginsdk.wallet.g gVar2 = new com.tencent.mm.pluginsdk.wallet.g(iVar.mcy);
            gVar.qih = bi.getInt((String) iVar.mcy.get("closeWebAfterPayDetailBack"), 0);
            x.i("MicroMsg.MsgHandler", "close window: %s", new Object[]{Integer.valueOf(gVar.qih)});
            MMActivity mMActivity = (MMActivity) gVar.context;
            Intent intent = new Intent();
            intent.putExtra("appId", gVar2.appId);
            intent.putExtra("timeStamp", gVar2.timeStamp);
            intent.putExtra("nonceStr", gVar2.nonceStr);
            intent.putExtra("packageExt", gVar2.packageExt);
            intent.putExtra("signtype", gVar2.signType);
            intent.putExtra("paySignature", gVar2.bVW);
            intent.putExtra(TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_URL, gVar2.url);
            mMActivity.geJ = gVar;
            com.tencent.mm.bg.d.a(mMActivity, "wallet_core", ".ui.ibg.WalletIbgOrderInfoUI", intent, 25, true);
            long j = bi.getLong((String) iVar.mcy.get("message_id"), 0);
            int i = bi.getInt((String) iVar.mcy.get("message_index"), 0);
            com.tencent.mm.plugin.report.service.h.mEJ.h(10593, new Object[]{gVar2.bVX, gVar2.appId, Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(gVar2.bVY), gVar2.url});
        }
        return true;
    }

    static /* synthetic */ boolean aN(g gVar, i iVar) {
        x.i("MicroMsg.MsgHandler", "doJumpToWXWallet");
        l.a(iVar.qkk, false, null, (String) iVar.mcy.get("appId"));
        if (gVar.context instanceof MMActivity) {
            Intent intent = new Intent();
            intent.putExtra("key_wallet_region", 1);
            com.tencent.mm.bg.d.c(gVar.context, "mall", ".ui.MallIndexUI", intent);
            gVar.a(iVar, "jump_to_wx_wallet:ok", null);
        }
        return true;
    }

    static /* synthetic */ boolean aO(g gVar, i iVar) {
        x.i("MicroMsg.MsgHandler", "doScanCover");
        l.a(iVar.qkk, false, null, (String) iVar.mcy.get("appId"));
        Intent intent = new Intent();
        intent.putExtra("BaseScanUI_select_scan_mode", 2);
        if (com.tencent.mm.p.a.bx(gVar.context) || com.tencent.mm.ax.e.Sz()) {
            x.i("MicroMsg.MsgHandler", "VoipOutOfPackageUtil.checkCameraUsingAndShowToast fail");
            gVar.a(iVar, "scanCover:fail", null);
        } else {
            com.tencent.mm.bg.d.c(gVar.context, "scanner", ".ui.SingleTopScanUI", intent);
            gVar.a(iVar, "sacnCover:ok", null);
        }
        return true;
    }

    static /* synthetic */ boolean aP(g gVar, i iVar) {
        if (gVar.f("nfcIsConnect", 4001, new Bundle())) {
            gVar.a(iVar, "nfcIsConnect:connect", null);
        }
        return true;
    }

    static /* synthetic */ boolean aQ(g gVar, i iVar) {
        if (gVar.f("nfcConnect", 4002, new Bundle())) {
            gVar.a(iVar, "nfcConnect:connect", null);
        }
        return true;
    }

    static /* synthetic */ boolean aR(g gVar, i iVar) {
        if (gVar.f("nfcTransceive", 4002, new Bundle())) {
            Bundle bundle = new Bundle();
            bundle.putString("apdu", (String) iVar.mcy.get("apdu"));
            Bundle e = gVar.e("nfcTransceive", 4003, bundle);
            if (e != null) {
                Map hashMap = new HashMap();
                hashMap.put("result", e.getString("result"));
                x.i("MicroMsg.MsgHandler", "[NFC] nfcTransceive result : " + e.getString("result"));
                gVar.a(iVar, "nfcTransceive:ok", hashMap);
            } else {
                x.w("MicroMsg.MsgHandler", "[NFC] nfcGetId callback fail!");
                gVar.a(iVar, "nfcTransceive:fail", null);
            }
        }
        return true;
    }

    static /* synthetic */ boolean aS(g gVar, i iVar) {
        if (gVar.f("nfcBatchTransceive", 4002, new Bundle())) {
            Bundle bundle = new Bundle();
            bundle.putString("apdus", (String) iVar.mcy.get("apdus"));
            bundle.putBoolean("breakIfFail", bi.getInt((String) iVar.mcy.get("breakIfFail"), 1) == 1);
            Bundle e = gVar.e("nfcBatchTransceive", 4004, bundle);
            if (e != null) {
                Map hashMap = new HashMap();
                hashMap.put("result", e.getString("result"));
                x.i("MicroMsg.MsgHandler", "[NFC] nfcBatchTransceive result : " + e.getString("result"));
                gVar.a(iVar, "nfcBatchTransceive:ok", hashMap);
            } else {
                x.w("MicroMsg.MsgHandler", "[NFC] nfcGetId callback fail!");
                gVar.a(iVar, "nfcBatchTransceive:fail", null);
            }
        }
        return true;
    }

    static /* synthetic */ boolean aT(g gVar, i iVar) {
        Bundle bundle = new Bundle();
        if (gVar.f("nfcGetId", 4002, bundle)) {
            bundle = gVar.e("nfcGetId", 4005, bundle);
            if (bundle != null) {
                Map hashMap = new HashMap();
                hashMap.put("id", bundle.getString("id"));
                x.i("MicroMsg.MsgHandler", "[NFC] nfcGetId result : " + bundle.getString("id"));
                gVar.a(iVar, "nfcGetId:ok", hashMap);
            } else {
                x.w("MicroMsg.MsgHandler", "[NFC] nfcGetId callback fail!");
                gVar.a(iVar, "nfcGetId:fail", null);
            }
        }
        return true;
    }

    static /* synthetic */ boolean aU(g gVar, i iVar) {
        Bundle bundle = new Bundle();
        if (gVar.f("nfcGetInfo", 4002, bundle)) {
            bundle = gVar.e("nfcGetInfo", 4008, bundle);
            if (bundle != null) {
                Map hashMap = new HashMap();
                hashMap.put("info", bundle.getString("info"));
                gVar.a(iVar, "nfcGetInfo:ok", hashMap);
            } else {
                x.w("MicroMsg.MsgHandler", "[NFC] nfcGetInfo callback fail!");
                gVar.a(iVar, "nfcGetInfo:fail", null);
            }
        }
        return true;
    }

    static /* synthetic */ boolean al(g gVar, i iVar) {
        if (gVar.context instanceof MMActivity) {
            String str = (String) iVar.mcy.get("key");
            int i = bi.getInt((String) iVar.mcy.get("procint"), 0);
            int i2 = bi.getInt((String) iVar.mcy.get("dataint"), 0);
            Intent intent = new Intent();
            intent.putExtra("encryptKey", str);
            intent.putExtra("procInterval", i);
            intent.putExtra("dataInterval", i2);
            intent.putExtra("exdevice_airkiss_open_type", 1);
            ((MMActivity) gVar.context).geJ = gVar;
            com.tencent.mm.bg.d.b(gVar.context, "exdevice", ".ui.ExdeviceConnectWifiUI", intent, 19);
        } else {
            gVar.a(iVar, "configWXDeviceWiFi:fail", null);
        }
        return true;
    }

    static /* synthetic */ boolean ao(g gVar, i iVar) {
        x.i("MicroMsg.MsgHandler", "doVerifyWCPayPassword JSOAUTH");
        l.a(iVar.qkk, false, null, (String) iVar.mcy.get("appId"));
        if (gVar.context instanceof MMActivity) {
            com.tencent.mm.pluginsdk.wallet.g gVar2 = new com.tencent.mm.pluginsdk.wallet.g(iVar.mcy);
            Intent intent = new Intent();
            intent.putExtra("appId", gVar2.appId);
            intent.putExtra("timeStamp", gVar2.timeStamp);
            intent.putExtra("nonceStr", gVar2.nonceStr);
            intent.putExtra("packageExt", gVar2.packageExt);
            intent.putExtra("signtype", gVar2.signType);
            intent.putExtra("paySignature", gVar2.bVW);
            intent.putExtra(TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_URL, gVar2.url);
            intent.putExtra("scene", 1);
            intent.putExtra("pay_channel", gVar2.bJY);
            ((MMActivity) gVar.context).geJ = gVar;
            com.tencent.mm.bg.d.a(gVar.context, "wallet_core", ".ui.WalletCheckPwdUI", intent, 20, false);
        }
        return true;
    }

    static /* synthetic */ boolean ap(g gVar, i iVar) {
        x.i("MicroMsg.MsgHandler", "doOpenWCPaySpecificView JSOAUTH");
        l.a(iVar.qkk, false, null, (String) iVar.mcy.get("appId"));
        if (gVar.context instanceof MMActivity) {
            com.tencent.mm.pluginsdk.wallet.g gVar2 = new com.tencent.mm.pluginsdk.wallet.g(iVar.mcy);
            Intent intent = new Intent();
            intent.putExtra("appId", gVar2.appId);
            intent.putExtra("timeStamp", gVar2.timeStamp);
            intent.putExtra("nonceStr", gVar2.nonceStr);
            intent.putExtra("packageExt", gVar2.packageExt);
            intent.putExtra("signtype", gVar2.signType);
            intent.putExtra("paySignature", gVar2.bVW);
            intent.putExtra(TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_URL, gVar2.url);
            intent.putExtra("pay_channel", gVar2.bJY);
            ((MMActivity) gVar.context).geJ = gVar;
            com.tencent.mm.bg.d.a(gVar.context, "wallet_index", ".ui.WalletSendC2CMsgUI", intent, 18, false);
        }
        return true;
    }

    static /* synthetic */ boolean aq(g gVar, i iVar) {
        x.i("MicroMsg.MsgHandler", "doBatchViewCard JSOAUTH");
        String str = (String) iVar.mcy.get("card_list");
        String str2 = (String) iVar.mcy.get("tempalate_id");
        Intent intent = new Intent();
        intent.putExtra("card_list", str);
        intent.putExtra("key_template_id", str2);
        intent.putExtra("key_from_scene", 7);
        if (gVar.context instanceof MMActivity) {
            ((MMActivity) gVar.context).geJ = gVar;
            com.tencent.mm.bg.d.a(gVar.context, "card", ".ui.CardViewEntranceUI", intent, 23, false);
        } else {
            x.e("MicroMsg.MsgHandler", "doBatchViewCard invalid context");
            gVar.a(iVar, "batch_view_card:fail", null);
        }
        return true;
    }

    static /* synthetic */ boolean ar(g gVar, i iVar) {
        Object obj = iVar.mcy.get(DownloadSettingTable$Columns.TYPE);
        String obj2 = obj == null ? "0" : obj.toString();
        x.i("[MicroMsg.FreeWifi.MsgHandler]", "connect to freewifi, type is : %s", new Object[]{obj2});
        String str = (String) iVar.mcy.get("src_username");
        if (obj2.equals("0") || obj2.equals("1") || obj2.equals("2")) {
            String str2 = (String) iVar.mcy.get("apKey");
            x.i("[MicroMsg.FreeWifi.MsgHandler]", "connect to freewifi, ap key is : %s", new Object[]{str2});
            String str3 = bi.oW(str2) ? "" : str2;
            if (obj2.equals("0") && bi.oW(str3)) {
                gVar.a(iVar, "connectToFreeWifi:failed_invaildParam", null);
            } else {
                ah.A(new 82(gVar, obj2, str3, str, (String) iVar.mcy.get("sessionKey")));
                gVar.a(iVar, "connectToFreeWifi:ok", null);
            }
        } else {
            gVar.a(iVar, "connectToFreeWifi:failed_invaildParam", null);
        }
        return true;
    }

    static /* synthetic */ boolean bA(g gVar, i iVar) {
        gVar.iKs = false;
        com.tencent.mm.plugin.webview.fts.d bUU = com.tencent.mm.plugin.webview.modeltools.e.bUU();
        Map map = iVar.mcy;
        x.i("MicroMsg.FTS.FTSWebViewLogic", "setSnsObjectDescList");
        String t = p.t(map, "data");
        boolean u = p.u(map, "append");
        com.tencent.mm.plugin.webview.fts.d.a aVar = new com.tencent.mm.plugin.webview.fts.d.a(bUU, (byte) 0);
        aVar.data = t;
        aVar.pON = u;
        com.tencent.mm.sdk.f.e.post(aVar, "append_music_list_task");
        return false;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ boolean bB(com.tencent.mm.plugin.webview.ui.tools.jsapi.g r10, com.tencent.mm.plugin.webview.ui.tools.jsapi.i r11) {
        /*
        r9 = 9;
        r8 = 0;
        r10.iKs = r8;
        r1 = com.tencent.mm.plugin.webview.modeltools.e.bUU();
        r0 = r11.mcy;
        r2 = "MicroMsg.FTS.FTSWebViewLogic";
        r3 = "clickSnsMusicPlayButton %s";
        r4 = 1;
        r4 = new java.lang.Object[r4];
        r5 = r0.toString();
        r4[r8] = r5;
        com.tencent.mm.sdk.platformtools.x.i(r2, r3, r4);
        r2 = "isLoop";
        r2 = com.tencent.mm.plugin.websearch.api.p.u(r0, r2);
        r3 = "needStartMusicUI";
        r3 = com.tencent.mm.plugin.websearch.api.p.u(r0, r3);
        r4 = "snsid";
        r4 = com.tencent.mm.plugin.websearch.api.p.t(r0, r4);
        r5 = "webview_instance_id";
        r5 = r0.get(r5);
        r6 = -1;
        r5 = com.tencent.mm.sdk.platformtools.bi.p(r5, r6);
        r6 = com.tencent.mm.an.b.PY();
        if (r6 == 0) goto L_0x005a;
    L_0x0044:
        r6 = com.tencent.mm.an.b.Qa();
        r7 = r6.rYj;
        if (r7 != r9) goto L_0x005a;
    L_0x004c:
        r6 = r6.rsp;
        r4 = r6.equals(r4);
        if (r4 == 0) goto L_0x005a;
    L_0x0054:
        com.tencent.mm.an.b.PW();
        if (r3 != 0) goto L_0x005a;
    L_0x0059:
        return r8;
    L_0x005a:
        if (r3 == 0) goto L_0x006a;
    L_0x005c:
        r4 = r1.pOC;
        if (r4 == 0) goto L_0x006a;
    L_0x0060:
        r4 = r1.pOC;
        r6 = new com.tencent.mm.an.b$9;
        r6.<init>(r4);
        com.tencent.mm.sdk.platformtools.ah.A(r6);
    L_0x006a:
        r4 = "objectXmlDesc";
        r4 = com.tencent.mm.plugin.websearch.api.p.t(r0, r4);
        r0 = com.tencent.mm.plugin.sns.b.m.class;
        r0 = com.tencent.mm.kernel.g.l(r0);
        r0 = (com.tencent.mm.plugin.sns.b.m) r0;
        r4 = r0.ng(r4);
        r0 = com.tencent.mm.an.a.b.class;
        r0 = com.tencent.mm.kernel.g.l(r0);
        r0 = (com.tencent.mm.an.a.b) r0;
        com.tencent.mm.model.au.HU();
        r6 = com.tencent.mm.model.c.Gq();
        r0 = r0.a(r6, r4, r9);
        r0.rYB = r2;
        com.tencent.mm.an.b.a(r0);
        if (r3 == 0) goto L_0x00b5;
    L_0x0097:
        r0 = new android.content.Intent;
        r0.<init>();
        r2 = "key_scene";
        r3 = 4;
        r0.putExtra(r2, r3);
        r2 = 268435456; // 0x10000000 float:2.5243549E-29 double:1.32624737E-315;
        r0.setFlags(r2);
        r2 = com.tencent.mm.sdk.platformtools.ad.getContext();
        r3 = "music";
        r4 = ".ui.MusicMainUI";
        com.tencent.mm.bg.d.b(r2, r3, r4, r0);
    L_0x00b5:
        r0 = r1.pOv;
        r1 = java.lang.Integer.valueOf(r5);
        r0.add(r1);
        goto L_0x0059;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.webview.ui.tools.jsapi.g.bB(com.tencent.mm.plugin.webview.ui.tools.jsapi.g, com.tencent.mm.plugin.webview.ui.tools.jsapi.i):boolean");
    }

    static /* synthetic */ boolean bK(g gVar, i iVar) {
        gVar.iKs = false;
        String str = (String) iVar.mcy.get("brandUsername");
        Intent adR = p.adR();
        adR.putExtra("ftsneedkeyboard", true);
        adR.putExtra("ftsbizscene", 19);
        adR.putExtra("ftsType", 2);
        Map b = p.b(19, true, 2);
        b.put("userName", str);
        adR.putExtra("rawUrl", p.v(b));
        adR.putExtra("key_load_js_without_delay", true);
        adR.putExtra("ftsbizusername", str);
        com.tencent.mm.bg.d.b(ad.getContext(), "webview", ".ui.tools.fts.FTSSearchTabWebViewUI", adR);
        return false;
    }

    static /* synthetic */ boolean bO(g gVar, i iVar) {
        String str = (String) iVar.mcy.get("cardType");
        if (bi.oW(str) || gVar.context == null) {
            gVar.a(iVar, "scanLicence:fail", null);
        } else {
            if (!gVar.qif.a(str, gVar.context, new 32(gVar, str, iVar))) {
                Map hashMap = new HashMap(1);
                hashMap.put("cardType", str);
                gVar.a(iVar, "scanLicence:type not supported", hashMap);
            }
        }
        return true;
    }

    static /* synthetic */ boolean bQ(g gVar, i iVar) {
        x.i("MicroMsg.MsgHandler", "do ecard jsapi check");
        cn cnVar = new cn();
        com.tencent.mm.pluginsdk.wallet.g gVar2 = new com.tencent.mm.pluginsdk.wallet.g(iVar.mcy);
        cnVar.bJR.appId = gVar2.appId;
        cnVar.bJR.bJT = gVar2.timeStamp;
        cnVar.bJR.nonceStr = gVar2.nonceStr;
        cnVar.bJR.packageExt = gVar2.packageExt;
        cnVar.bJR.signature = gVar2.bVW;
        cnVar.bJR.signType = gVar2.signType;
        cnVar.bJR.bJU = gVar2.url;
        cnVar.bJR.bJV = (String) iVar.mcy.get("ecardType");
        cnVar.bJR.bJW = (String) iVar.mcy.get("openScene");
        cnVar.bJR.YC = new WeakReference(gVar.context);
        cnVar.bJR.token = (String) iVar.mcy.get("token");
        cnVar.bJR.bJX = new 35(gVar, cnVar, iVar);
        cnVar.bJR.bJY = gVar2.bJY;
        com.tencent.mm.sdk.b.a.sFg.m(cnVar);
        return true;
    }

    static /* synthetic */ boolean bc(g gVar, i iVar) {
        gVar.iKs = false;
        i bUV = com.tencent.mm.plugin.webview.modeltools.e.bUV();
        Map map = iVar.mcy;
        int p = bi.p(map.get("webview_instance_id"), -1);
        String t = p.t(map, "searchId");
        String t2 = p.t(map, "poiId");
        com.tencent.mm.ab.b.a aVar = new com.tencent.mm.ab.b.a();
        bjw bjw = new bjw();
        bjw.sjJ = t2;
        bjw.rlo = t;
        aVar.dIG = bjw;
        aVar.dIH = new bjx();
        aVar.uri = "/cgi-bin/mmsearch-bin/searchpoi";
        aVar.dIF = 2608;
        v.a(aVar.KT(), new 3(bUV, p, t, t2));
        return false;
    }

    static /* synthetic */ boolean bd(g gVar, i iVar) {
        gVar.iKs = false;
        if (bi.WU((String) iVar.mcy.get("isSearch")) == 1) {
            return p.fB(bi.WV((String) iVar.mcy.get("reddotTimeStamps")));
        }
        ((com.tencent.mm.plugin.topstory.a.b) com.tencent.mm.kernel.g.n(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().fu(bi.WV((String) iVar.mcy.get("reddotTimeStamps")));
        return false;
    }

    static /* synthetic */ boolean be(g gVar, i iVar) {
        iVar.mcy.put(DownloadSettingTable$Columns.TYPE, Integer.valueOf(262144));
        com.tencent.mm.plugin.webview.modeltools.e.bUV().pPr = new cfk();
        com.tencent.mm.plugin.webview.modeltools.e.bUV().pPr.szT = new iv();
        com.tencent.mm.plugin.webview.modeltools.e.bUV().pPr.szT.rkf = 1;
        return gVar.aX(iVar);
    }

    static /* synthetic */ boolean bp(g gVar, i iVar) {
        gVar.iKs = false;
        com.tencent.mm.plugin.webview.modeltools.e.bUU();
        Map map = iVar.mcy;
        x.i("MicroMsg.FTS.FTSWebViewLogic", "reportSearchStatistics: %s", new Object[]{map.toString()});
        int c = p.c(map, "logId", 0);
        x.i("MicroMsg.FTS.FTSWebViewLogic", "reportSearchStatistics reporting %d, logString %s", new Object[]{Integer.valueOf(c), p.t(map, "logString")});
        com.tencent.mm.plugin.websearch.api.ad.aQ(c, r0);
        return false;
    }

    static /* synthetic */ boolean br(g gVar, i iVar) {
        gVar.iKs = false;
        com.tencent.mm.plugin.webview.fts.d bUU = com.tencent.mm.plugin.webview.modeltools.e.bUU();
        Map map = iVar.mcy;
        boolean u = p.u(map, "hasResult");
        String t = p.t(map, "query");
        int c = p.c(map, DownloadSettingTable$Columns.TYPE, 0);
        int c2 = p.c(map, "scene", 0);
        x.d("MicroMsg.FTS.FTSWebViewLogic", "searchDataHashResult %b %s %d", new Object[]{Boolean.valueOf(u), t, Integer.valueOf(c)});
        com.tencent.mm.plugin.webview.fts.d.e eVar = bUU.pOB;
        if (eVar.scene == c2 && eVar.bWm != null && eVar.bWm.equals(t) && eVar.jtk == c) {
            eVar.bHx = u;
        } else {
            x.w("MicroMsg.FTS.FTSWebViewLogic", "setHasResultNotSame: %s VS %s | %d VS %d | %d VS %d", new Object[]{eVar.bWm, t, Integer.valueOf(eVar.jtk), Integer.valueOf(c), Integer.valueOf(eVar.scene), Integer.valueOf(c2)});
        }
        return false;
    }

    static /* synthetic */ boolean bt(g gVar, i iVar) {
        boolean z = true;
        gVar.iKs = false;
        com.tencent.mm.plugin.webview.modeltools.e.bUU();
        Map map = iVar.mcy;
        x.i("MicroMsg.FTS.FTSWebViewLogic", "openEmotionPage %s", new Object[]{map});
        int c = p.c(map, DownloadSettingTable$Columns.TYPE, 0);
        int c2 = p.c(map, "scene", 0);
        String t = p.t(map, "searchId");
        String t2 = p.t(map, "activityId");
        String str = "";
        Intent intent = new Intent();
        intent.setFlags(268435456);
        intent.putExtra("extra_scence", c2);
        intent.putExtra("extra_type", c);
        intent.putExtra("searchID", t);
        intent.putExtra("docID", p.t(map, "docID"));
        intent.putExtra("activityId", t2);
        switch (c) {
            case 1:
                intent.putExtra("extra_id", p.t(map, "productID"));
                intent.putExtra("preceding_scence", 18);
                intent.putExtra("download_entrance_scene", 27);
                intent.putExtra("searchID", bi.getLong(t, 0));
                str = ".ui.EmojiStoreDetailUI";
                break;
            case 2:
                intent.putExtra("extra_emoji_name", p.t(map, "express"));
                intent.putExtra("extra_md5", p.t(map, "md5"));
                intent.putExtra("extra_aeskey", p.t(map, "aesKey"));
                intent.putExtra("extra_encrypt_url", p.t(map, "encryptUrl"));
                intent.putExtra("extra_thumb_url", p.t(map, "thumb"));
                intent.putExtra("id", p.t(map, "designerId"));
                intent.putExtra("extra_product_id", p.t(map, "productID"));
                intent.putExtra("productUrl", p.t(map, "productUrl"));
                intent.putExtra("extra_product_name", p.t(map, "productName"));
                intent.putExtra("weapp_user_name", p.t(map, "weappUserName"));
                intent.putExtra("weapp_version", p.c(map, "weappVersion", 0));
                intent.putExtra("source_type", p.c(map, "sourceType", 0));
                str = ".ui.fts.FTSEmojiDetailPageUI";
                break;
            case 3:
                intent.putExtra("extra_emoji_name", p.t(map, "express"));
                intent.putExtra("extra_md5", p.t(map, "md5"));
                intent.putExtra("extra_aeskey", p.t(map, "aesKey"));
                intent.putExtra("extra_encrypt_url", p.t(map, "encryptUrl"));
                intent.putExtra("extra_thumb_url", p.t(map, "thumb"));
                intent.putExtra("id", p.t(map, "designerId"));
                intent.putExtra("name", p.t(map, "designerName"));
                intent.putExtra("headurl", p.t(map, "designerThumb"));
                intent.putExtra("weapp_user_name", p.t(map, "weappUserName"));
                intent.putExtra("weapp_version", p.c(map, "weappVersion", 0));
                intent.putExtra("source_type", p.c(map, "sourceType", 0));
                str = ".ui.fts.FTSEmojiDetailPageUI";
                break;
            case 4:
                intent.putExtra("extra_emoji_name", p.t(map, "express"));
                intent.putExtra("extra_encrypt_url", p.t(map, "encryptUrl"));
                intent.putExtra("extra_thumb_url", p.t(map, "thumb"));
                intent.putExtra("extra_article_name", p.t(map, "sourceTitle"));
                intent.putExtra("extra_article_url", p.t(map, "articleSource"));
                intent.putExtra("disableAddSticker", p.c(map, "disableAddSticker", 0) > 0);
                str = "needSavePhotosAlbum";
                if (p.c(map, "needSavePhotosAlbum", 0) <= 0) {
                    z = false;
                }
                intent.putExtra(str, z);
                intent.putExtra("weapp_user_name", p.t(map, "weappUserName"));
                intent.putExtra("weapp_version", p.c(map, "weappVersion", 0));
                intent.putExtra("source_type", p.c(map, "sourceType", 0));
                str = ".ui.fts.FTSEmojiDetailPageUI";
                break;
        }
        if (!bi.oW(str)) {
            com.tencent.mm.bg.d.b(ad.getContext(), "emoji", str, intent);
        }
        return false;
    }

    static /* synthetic */ boolean bu(g gVar, i iVar) {
        gVar.iKs = false;
        com.tencent.mm.plugin.webview.modeltools.e.bUU();
        return com.tencent.mm.plugin.webview.fts.d.ag(iVar.mcy);
    }

    static /* synthetic */ boolean by(g gVar, i iVar) {
        int i = bi.getInt((String) iVar.mcy.get("cmd"), 0);
        String str = (String) iVar.mcy.get("param");
        go goVar = new go();
        goVar.bPJ.nc = i;
        goVar.bPJ.bPE = str;
        com.tencent.mm.sdk.b.a.sFg.m(goVar);
        Map hashMap = new HashMap();
        hashMap.put("result", goVar.bPK.bPL);
        gVar.a(iVar, "getGameMessages:ok", hashMap);
        return true;
    }

    static /* synthetic */ boolean bz(g gVar, i iVar) {
        x.i("MicroMsg.MsgHandler", "doGetWebPayCheckoutCounterRequst start");
        com.tencent.mm.pluginsdk.wallet.g gVar2 = new com.tencent.mm.pluginsdk.wallet.g(iVar.mcy);
        Intent intent = new Intent();
        intent.putExtra("appId", gVar2.appId);
        intent.putExtra("timeStamp", gVar2.timeStamp);
        intent.putExtra("nonceStr", gVar2.nonceStr);
        intent.putExtra("packageExt", gVar2.packageExt);
        intent.putExtra("signtype", gVar2.signType);
        intent.putExtra("paySignature", gVar2.bVW);
        intent.putExtra(TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_URL, gVar2.url);
        intent.putExtra("pay_channel", gVar2.bJY);
        ((MMActivity) gVar.context).geJ = gVar;
        com.tencent.mm.bg.d.a(gVar.context, "wallet", ".pay.ui.WalletLoanRepaymentUI", intent, 28, false);
        return true;
    }

    static /* synthetic */ boolean cD(g gVar, i iVar) {
        String oV = bi.oV((String) iVar.mcy.get("toUsername"));
        String oV2 = bi.oV((String) iVar.mcy.get("scene"));
        String oV3 = bi.oV((String) iVar.mcy.get(DownloadSettingTable$Columns.TYPE));
        String oV4 = bi.oV((String) iVar.mcy.get("allowBackCamera"));
        String oV5 = bi.oV((String) iVar.mcy.get("showOther"));
        String oV6 = bi.oV((String) iVar.mcy.get("avatarUrl"));
        String oV7 = bi.oV((String) iVar.mcy.get("context"));
        x.i("MicroMsg.MsgHandler", "doStartVoipCS,toUserName:" + oV + ",scene:" + oV2 + ",type:" + oV3 + ",allowBackCamera:" + oV4 + ",showOther:" + oV5 + ",avatarUrl:" + oV6 + ",voipCSContext:" + oV7);
        String str = (String) iVar.mcy.get("appId");
        if (str == null || str.equals("") || oV == null || oV.equals("")) {
            gVar.a(iVar, "startVoipCall:param invalid", null);
        } else {
            gVar.qiu = iVar;
            com.tencent.mm.sdk.b.a.sFg.b(gVar.qiv);
            if (oV.equals("testacs")) {
                Intent intent = new Intent();
                intent.putExtra("voipCSBizId", "gh_e8b085bb67e0");
                intent.putExtra("voipCSAppId", "wx1224160e0adcefd6");
                com.tencent.mm.bg.d.b(ad.getContext(), "voip_cs", ".ui.VoipCSMainUI", intent);
            } else {
                Intent intent2 = new Intent();
                intent2.putExtra("voipCSBizId", oV);
                intent2.putExtra("voipCSScene", oV2);
                intent2.putExtra("voipCSType", oV3);
                intent2.putExtra("voipCSAppId", str);
                intent2.putExtra("voipCSAllowBackCamera", oV4);
                intent2.putExtra("voipCSShowOther", oV5);
                intent2.putExtra("voipCSAvatarUrl", oV6);
                intent2.putExtra("voipCSContext", oV7);
                com.tencent.mm.bg.d.b(ad.getContext(), "voip_cs", ".ui.VoipCSMainUI", intent2);
            }
        }
        return true;
    }

    static /* synthetic */ boolean cH(g gVar, i iVar) {
        x.d("MicroMsg.MsgHandler", "doOpenLuckyMoneyDetailView");
        String str = (String) iVar.mcy.get("sendId");
        int parseInt = Integer.parseInt((String) iVar.mcy.get("hbKind"));
        if (bi.oW(str)) {
            gVar.a(iVar, "openLuckyMoneyDetailView:fail", null);
        } else {
            x.i("MicroMsg.MsgHandler", "sendId: %s, hbKind: %s", new Object[]{str, Integer.valueOf(parseInt)});
            Intent intent = new Intent();
            intent.putExtra("key_sendid", str);
            intent.putExtra("key_jump_from", 4);
            if (parseInt == 2) {
                com.tencent.mm.bg.d.b(gVar.context, "luckymoney", ".ui.LuckyMoneyBusiDetailUI", intent);
            } else {
                com.tencent.mm.bg.d.b(gVar.context, "luckymoney", ".ui.LuckyMoneyDetailUI", intent);
            }
            gVar.a(iVar, "openLuckyMoneyDetailView:ok", null);
        }
        return true;
    }

    static /* synthetic */ boolean cI(g gVar, final i iVar) {
        x.d("MicroMsg.MsgHandler", "doResendRemittanceMsg");
        final String str = (String) iVar.mcy.get("transactionId");
        final String str2 = (String) iVar.mcy.get("receiverName");
        if (bi.oW(str) || bi.oW(str2)) {
            gVar.a(iVar, "doResendRemittanceMsg:fail", null);
        } else {
            com.tencent.mm.ui.base.h.a(gVar.context, R.l.span_remittance_confirm_resend_msg, R.l.app_remind, R.l.span_remittance_resend, R.l.app_cancel, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    Intent intent = new Intent();
                    intent.putExtra("transaction_id", str);
                    intent.putExtra("receiver_name", str2);
                    com.tencent.mm.bg.d.b(g.this.context, "remittance", ".ui.RemittanceResendMsgUI", intent);
                    g.this.a(iVar, "doResendRemittanceMsg:ok", null);
                }
            }, new 45(gVar));
        }
        return true;
    }

    static /* synthetic */ boolean cL(g gVar, i iVar) {
        x.i("MicroMsg.MsgHandler", "doPreviewVideo(), localId:%s", new Object[]{(String) iVar.mcy.get("localId")});
        WebViewJSSDKFileItem Qq = com.tencent.mm.plugin.webview.modeltools.e.bUX().Qq(r0);
        if (Qq == null) {
            x.e("MicroMsg.MsgHandler", "the item is null");
            gVar.a(iVar, "previewVideo:fail", null);
        } else if (TextUtils.isEmpty(Qq.fnM)) {
            x.e("MicroMsg.MsgHandler", "the File item not exist for localId:%s", new Object[]{Qq.bNH});
            gVar.a(iVar, "previewVideo:fail", null);
        } else if (new File(Qq.fnM).exists()) {
            Intent intent = new Intent();
            intent.putExtra("key_video_path", Qq.fnM);
            if (gVar.context instanceof MMActivity) {
                ((MMActivity) gVar.context).geJ = gVar;
                com.tencent.mm.bg.d.b(gVar.context, "card", ".ui.CardGiftVideoUI", intent, 46);
            }
        } else {
            x.e("MicroMsg.MsgHandler", "the File not exist for origFilePath:%s", new Object[]{Qq.fnM});
            gVar.a(iVar, "previewVideo:fail", null);
        }
        return true;
    }

    static /* synthetic */ boolean cR(g gVar, i iVar) {
        x.i("MicroMsg.MsgHandler", "getLocalWePkgInfo call");
        ah.A(new 28(gVar, iVar));
        return true;
    }

    static /* synthetic */ boolean cS(g gVar, i iVar) {
        boolean z = false;
        String str = (String) iVar.mcy.get(TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_URL);
        if (bi.oW(str)) {
            x.e("MicroMsg.MsgHandler", "url is null or nil");
            gVar.a(iVar, "openGameWebView:fail_invalid_url", null);
        } else {
            int i;
            boolean z2;
            String oV;
            Intent intent;
            gl glVar;
            String oV2 = bi.oV((String) iVar.mcy.get("orientation"));
            if (!bi.oW(oV2)) {
                if (oV2.equals("horizontal")) {
                    i = 0;
                } else if (oV2.equals("vertical")) {
                    i = 1;
                } else if (oV2.equals("sensor")) {
                    i = 4;
                }
                z2 = bi.oV((String) iVar.mcy.get("fullscreen")).equals("true");
                if (bi.oV((String) iVar.mcy.get("disable_swipe_back")).equals("1")) {
                    z = true;
                }
                oV = bi.oV((String) iVar.mcy.get("gameAppid"));
                intent = new Intent();
                intent.putExtra("rawUrl", str);
                intent.putExtra("geta8key_scene", 32);
                intent.putExtra("KPublisherId", "game_webview");
                intent.putExtra("screen_orientation", i);
                intent.putExtra("show_full_screen", z2);
                intent.putExtra("disable_swipe_back", z);
                intent.putExtra("game_hv_menu_appid", oV);
                com.tencent.mm.plugin.webview.ui.tools.d.a(intent.getExtras(), "webview", ".ui.tools.game.GameWebViewUI", gVar.pRY, new 29(gVar, intent));
                glVar = new gl();
                glVar.bPC.nc = 2;
                glVar.bPC.bPE = oV;
                com.tencent.mm.sdk.b.a.sFg.m(glVar);
                gVar.a(iVar, "openGameWebView:ok", null);
            }
            i = -1;
            if (bi.oV((String) iVar.mcy.get("fullscreen")).equals("true")) {
            }
            if (bi.oV((String) iVar.mcy.get("disable_swipe_back")).equals("1")) {
                z = true;
            }
            oV = bi.oV((String) iVar.mcy.get("gameAppid"));
            intent = new Intent();
            intent.putExtra("rawUrl", str);
            intent.putExtra("geta8key_scene", 32);
            intent.putExtra("KPublisherId", "game_webview");
            intent.putExtra("screen_orientation", i);
            intent.putExtra("show_full_screen", z2);
            intent.putExtra("disable_swipe_back", z);
            intent.putExtra("game_hv_menu_appid", oV);
            com.tencent.mm.plugin.webview.ui.tools.d.a(intent.getExtras(), "webview", ".ui.tools.game.GameWebViewUI", gVar.pRY, new 29(gVar, intent));
            glVar = new gl();
            glVar.bPC.nc = 2;
            glVar.bPC.bPE = oV;
            com.tencent.mm.sdk.b.a.sFg.m(glVar);
            gVar.a(iVar, "openGameWebView:ok", null);
        }
        return true;
    }

    static /* synthetic */ boolean cU(g gVar, i iVar) {
        x.i("MicroMsg.MsgHandler", "doLoginOrAuthorize!");
        121 121 = new 121(gVar, iVar);
        if (qiA) {
            qiz.add(121);
            x.i("MicroMsg.MsgHandler", "add to authJsApiQueue!");
        } else {
            qiA = true;
            121.run();
        }
        return true;
    }

    static /* synthetic */ boolean cV(g gVar, i iVar) {
        x.i("MicroMsg.MsgHandler", "hy: start do check is support face detect");
        hl hlVar = new hl();
        com.tencent.mm.sdk.b.a.sFg.m(hlVar);
        boolean z = hlVar.bQM.bQN;
        int i = hlVar.bQM.bQO;
        x.i("MicroMsg.MsgHandler", "hy: is support: %b, errCode: %d, errMsg: %s, ilbVersion: %d", new Object[]{Boolean.valueOf(z), Integer.valueOf(i), hlVar.bQM.bQP, Integer.valueOf(hlVar.bQM.bQQ)});
        Map hashMap = new HashMap();
        hashMap.put("err_code", String.valueOf(i));
        hashMap.put("err_msg", r3);
        hashMap.put("lib_version_code", String.valueOf(r0));
        gVar.a(iVar, "doCheckIsSupportFaceDetect: ok", hashMap);
        return true;
    }

    static /* synthetic */ boolean cZ(g gVar, i iVar) {
        String oV = bi.oV((String) iVar.mcy.get("base64DataString"));
        final String oV2 = bi.oV((String) iVar.mcy.get("thumbUrl"));
        final String oV3 = bi.oV((String) iVar.mcy.get(TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_URL));
        final String oV4 = bi.oV((String) iVar.mcy.get("activityId"));
        if (!bi.oW(oV)) {
            au.Em().H(new 103(gVar, oV, iVar, oV2, oV4));
        } else if (bi.oW(oV3)) {
            x.e("MicroMsg.MsgHandler", "doAddToEmoticon base64DataString is null and url is null");
            gVar.a(iVar, "addToEmoticon:fail_base64DataString_and_url_is_null", null);
            return false;
        } else {
            x.i("MicroMsg.MsgHandler", "doAddToEmoticon use url:%s", new Object[]{oV3});
            final File file = new File(gVar.context.getCacheDir(), com.tencent.mm.a.g.u(oV3.getBytes()));
            if (file.exists()) {
                au.Em().H(new Runnable() {
                    public final void run() {
                        String m = com.tencent.mm.a.g.m(file);
                        au.HU();
                        String L = EmojiLogic.L(com.tencent.mm.model.c.Gg(), "", m);
                        if (!FileOp.cn(L)) {
                            FileOp.y(file.getAbsolutePath(), L);
                        }
                        g.a(g.this, m, oV2, oV4);
                    }
                });
            } else {
                com.tencent.mm.ak.a.a.c.a aVar = new com.tencent.mm.ak.a.a.c.a();
                aVar.dXy = true;
                aVar.dXA = file.getAbsolutePath();
                aVar.dYc = new Object[]{file.getAbsolutePath()};
                final i iVar2 = iVar;
                com.tencent.mm.plugin.emoji.model.i.aDZ().a(oV3, null, aVar.Pt(), new com.tencent.mm.ak.a.c.i() {
                    public final void a(String str, Bitmap bitmap, Object... objArr) {
                        x.i("MicroMsg.MsgHandler", "imageLoaderListener onImageLoadComplete %s", new Object[]{str});
                        if (bitmap == null || objArr == null || objArr.length <= 0) {
                            g.this.a(iVar2, "addToEmoticon:fail", null);
                        } else if (objArr[0] == null || !(objArr[0] instanceof String)) {
                            g.this.a(iVar2, "addToEmoticon:fail", null);
                        } else if (str.equals(oV3)) {
                            File file = new File(objArr[0].toString());
                            if (file.exists()) {
                                String m = com.tencent.mm.a.g.m(file);
                                au.HU();
                                FileOp.y(file.getAbsolutePath(), EmojiLogic.L(com.tencent.mm.model.c.Gg(), "", m));
                                g.a(g.this, m, oV2, oV4);
                                return;
                            }
                            g.this.a(iVar2, "addToEmoticon:fail", null);
                        } else {
                            g.this.a(iVar2, "addToEmoticon:fail", null);
                        }
                    }
                });
            }
        }
        return true;
    }

    static /* synthetic */ boolean cc(g gVar, final i iVar) {
        if (com.tencent.mm.model.gdpr.c.Jm()) {
            x.i("MicroMsg.MsgHandler", "eu user just return fail");
            gVar.a(iVar, "add_contact:fail EU user failed", null);
            return true;
        }
        String str = (String) iVar.mcy.get("username");
        if (bi.oW(str)) {
            x.e("MicroMsg.MsgHandler", "user name is null or nil");
            gVar.a(iVar, "add_contact:fail", null);
            return false;
        }
        String str2 = (String) iVar.mcy.get("profileReportInfo");
        x.i("MicroMsg.MsgHandler", "get scene = %s", new Object[]{(String) iVar.mcy.get("scene")});
        ah.A(new 97(gVar, new com.tencent.mm.pluginsdk.ui.applet.b(gVar.context, str, bi.getInt(r0, 91), new n() {
            public final void ky(int i) {
                switch (i) {
                    case -2:
                        g.this.a(iVar, "quickly_add_contact:added", null);
                        return;
                    case -1:
                        g.this.a(iVar, "quickly_add_contact:fail", null);
                        return;
                    case 0:
                        g.this.a(iVar, "quickly_add_contact:cancel", null);
                        return;
                    case 1:
                        g.this.a(iVar, "quickly_add_contact:ok", null);
                        return;
                    default:
                        g.this.a(iVar, "quickly_add_contact:fail", null);
                        return;
                }
            }
        }, false, str2)));
        return true;
    }

    static /* synthetic */ boolean cd(g gVar, i iVar) {
        String str = (String) iVar.mcy.get("consumedCardId");
        String str2 = (String) iVar.mcy.get("consumedCode");
        x.i("MicroMsg.MsgHandler", "doConsumedShareCard consumedCardId is " + str);
        if (bi.oW(str) || bi.oW(str2)) {
            x.w("MicroMsg.MsgHandler", "doConsumedShareCard failed, illegal params (id : %s, code : %s)", new Object[]{str, str2});
            gVar.a(iVar, "consumedShareCard:fail", null);
            return false;
        }
        Intent intent = new Intent();
        intent.putExtra("key_from_scene", 1);
        intent.putExtra("key_consumed_card_id", str);
        intent.putExtra("key_consumed_Code", str2);
        ((MMActivity) gVar.context).geJ = gVar;
        com.tencent.mm.bg.d.b(gVar.context, "card", ".sharecard.ui.CardConsumeSuccessUI", intent, 29);
        return true;
    }

    static /* synthetic */ boolean ce(g gVar, i iVar) {
        String str = (String) iVar.mcy.get(TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_URL);
        String str2 = (String) iVar.mcy.get("open_game_webview");
        x.i("MicroMsg.MsgHandler", "open url with extra webview, url = %s", new Object[]{str});
        if (bi.oW(str)) {
            x.e("MicroMsg.MsgHandler", "url is null or nil");
            gVar.a(iVar, "openUrlWithExtraWebview:fail_invalid_url", null);
        } else {
            Intent intent = new Intent();
            intent.putExtra("rawUrl", str);
            intent.putExtra("convertActivityFromTranslucent", false);
            if (bi.oV(str2).equals("1")) {
                com.tencent.mm.plugin.webview.ui.tools.d.a(intent.getExtras(), "webview", ".ui.tools.game.GameWebViewUI", gVar.pRY, new 98(gVar, intent));
            } else {
                com.tencent.mm.plugin.webview.ui.tools.d.a(intent.getExtras(), "webview", ".ui.tools.WebViewUI", gVar.pRY, new 99(gVar, intent));
            }
            gVar.a(iVar, "openUrlWithExtraWebview:ok", null);
        }
        return true;
    }

    static /* synthetic */ boolean cj(g gVar, i iVar) {
        x.i("MicroMsg.MsgHandler", "doSelectSingleContact selectedMode:%d", new Object[]{Integer.valueOf(bi.getInt((String) iVar.mcy.get("selectMode"), 0))});
        Intent intent = new Intent();
        if (bi.getInt((String) iVar.mcy.get("selectMode"), 0) == 1) {
            intent.putExtra("Select_Conv_Type", 263);
            intent.putExtra("jsapi_select_mode", 1);
        } else {
            intent.putExtra("Select_Conv_Type", 259);
        }
        intent.putExtra("select_is_ret", true);
        intent.putExtra("Select_block_List", q.GF());
        intent.putExtra("scene_from", 4);
        if (gVar.context instanceof MMActivity) {
            com.tencent.mm.bg.d.a((MMActivity) gVar.context, ".ui.transmit.SelectConversationUI", intent, 30, gVar);
        }
        return true;
    }

    static /* synthetic */ boolean co(g gVar, i iVar) {
        x.i("MicroMsg.MsgHandler", "openEmoticonTopicList");
        int i = bi.getInt((String) iVar.mcy.get("tid"), 0);
        String str = (String) iVar.mcy.get("title");
        String str2 = (String) iVar.mcy.get("desc");
        String str3 = (String) iVar.mcy.get("iconUrl");
        String str4 = (String) iVar.mcy.get("secondUrl");
        Intent intent = new Intent();
        intent.putExtra("topic_id", i);
        intent.putExtra("topic_name", str);
        intent.putExtra("topic_desc", str2);
        intent.putExtra("topic_icon_url", str3);
        intent.putExtra("topic_ad_url", str4);
        intent.putExtra("extra_scence", 12);
        com.tencent.mm.bg.d.b(gVar.context, "emoji", ".ui.EmojiStoreTopicUI", intent);
        gVar.a(iVar, "openEmoticonTopicList", null);
        return true;
    }

    static /* synthetic */ boolean cp(g gVar, i iVar) {
        x.i("MicroMsg.MsgHandler", "openEmotionDetailView");
        String str = (String) iVar.mcy.get("ProductId");
        x.d("MicroMsg.MsgHandler", "cpan emoji openEmotionDetailView:%d", new Object[]{Long.valueOf(bi.getLong((String) iVar.mcy.get("searchID"), 0))});
        if (bi.oW(str)) {
            x.w("MicroMsg.MsgHandler", "openEmotionDetailView failed product id is null.");
            gVar.a(iVar, "openEmotionDetailView", null);
            return false;
        }
        Intent intent = new Intent();
        intent.putExtra("extra_id", str);
        intent.putExtra("preceding_scence", 12);
        intent.putExtra("download_entrance_scene", 12);
        intent.putExtra("searchID", r4);
        if (gVar.qid) {
            x.i("MicroMsg.MsgHandler", "had start emoji stroe detail ui.");
        } else {
            com.tencent.mm.bg.d.b(gVar.context, "emoji", ".ui.EmojiStoreDetailUI", intent);
            gVar.qid = true;
        }
        gVar.a(iVar, "openEmotionDetailView", null);
        com.tencent.mm.plugin.report.service.h.mEJ.h(13055, new Object[]{Integer.valueOf(0), str, "", "", Integer.valueOf(com.tencent.mm.ag.a.Oe()), Long.valueOf(r4)});
        return true;
    }

    static /* synthetic */ boolean cq(g gVar, i iVar) {
        gVar.iKs = false;
        com.tencent.mm.plugin.webview.modeltools.e.bUS();
        Map map = iVar.mcy;
        String Oc = com.tencent.mm.ag.a.Oc();
        if (bi.oW(Oc)) {
            x.e("MicroMsg.emoji.EmojiStoreWebViewLogic", "load emojiStore Template Path error");
            return false;
        }
        int v = com.tencent.mm.plugin.webview.c.a.v(map, DownloadSettingTable$Columns.TYPE);
        String t = com.tencent.mm.plugin.webview.c.a.t(map, "pageName");
        String t2 = com.tencent.mm.plugin.webview.c.a.t(map, "keyword");
        int v2 = com.tencent.mm.plugin.webview.c.a.v(map, "scene");
        Intent intent = new Intent();
        intent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.qWa);
        intent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.qVX);
        intent.putExtra("neverGetA8Key", true);
        intent.putExtra("rawUrl", "file://" + Oc + "/" + t + "?type=" + v + "&keyword=" + t2 + "&scene=" + v2 + "&lang=" + w.fD(ad.getContext()) + "&clientType=1&version=" + com.tencent.mm.ag.a.Oe());
        intent.putExtra("keyword", t2);
        intent.putExtra(DownloadSettingTable$Columns.TYPE, v);
        intent.putExtra("sence", v2);
        com.tencent.mm.bg.d.b(ad.getContext(), "webview", ".ui.tools.emojistore.EmojiStoreSearchWebViewUI", intent);
        com.tencent.mm.plugin.report.service.h.mEJ.h(13055, new Object[]{Integer.valueOf(1), "", "", Integer.valueOf(v), Integer.valueOf(com.tencent.mm.ag.a.Oe()), Long.valueOf(0)});
        lx lxVar = new lx();
        lxVar.bWl.type = v;
        lxVar.bWl.bWm = t2;
        lxVar.bWl.bWn = "";
        com.tencent.mm.sdk.b.a.sFg.m(lxVar);
        return true;
    }

    static /* synthetic */ boolean cs(g gVar, i iVar) {
        gVar.iKs = false;
        com.tencent.mm.plugin.webview.modeltools.e.bUS();
        String t = com.tencent.mm.plugin.webview.c.a.t(iVar.mcy, "urlString");
        Intent intent = new Intent();
        intent.putExtra("rawUrl", t);
        com.tencent.mm.bg.d.b(ad.getContext(), "webview", ".ui.tools.WebViewUI", intent);
        return false;
    }

    static /* synthetic */ boolean cw(g gVar, i iVar) {
        x.i("MicroMsg.MsgHandler", "hy: start soter auth");
        ((MMActivity) gVar.context).geJ = gVar;
        Bundle aq = i.aq(iVar.mcy);
        Intent intent = new Intent();
        intent.putExtras(aq);
        intent.putExtra("key_soter_fp_mp_scene", 0);
        String rL = gVar.rL(gVar.getCurrentUrl());
        if (rL == null) {
            rL = (String) iVar.mcy.get("appId");
        }
        intent.putExtra("key_app_id", rL);
        com.tencent.mm.bg.d.b(gVar.context, "soter_mp", ".ui.SoterAuthenticationUI", intent, 38);
        return true;
    }

    static /* synthetic */ boolean cx(g gVar, i iVar) {
        x.i("MicroMsg.MsgHandler", "hy: do get soter support");
        hm hmVar = new hm();
        com.tencent.mm.sdk.b.a.sFg.m(hmVar);
        Map hashMap = new HashMap();
        hashMap.put("support_mode", Integer.valueOf(hmVar.bQR.bQS));
        gVar.a(iVar, "getSupportSoter", hashMap);
        gVar.a(iVar, 0, hmVar.bQR.bQS == 1 ? 1 : 0);
        return true;
    }

    static /* synthetic */ boolean cy(g gVar, i iVar) {
        com.tencent.mm.pluginsdk.wallet.g gVar2 = new com.tencent.mm.pluginsdk.wallet.g(iVar.mcy);
        Intent intent = new Intent();
        String str = (String) iVar.mcy.get("appId");
        if (gVar.qhS != null) {
            if (TextUtils.isEmpty(str)) {
                str = gVar.qhS.getString("jsapi_args_appid");
            }
            if (TextUtils.isEmpty(str)) {
                str = gVar.qic.RE(gVar.getCurrentUrl());
            }
        }
        intent.putExtra("appId", str);
        intent.putExtra("timeStamp", gVar2.timeStamp);
        intent.putExtra("nonceStr", gVar2.nonceStr);
        intent.putExtra("packageExt", gVar2.packageExt);
        intent.putExtra("signtype", gVar2.signType);
        intent.putExtra("paySignature", gVar2.bVW);
        intent.putExtra(TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_URL, gVar.getCurrentUrl());
        ((MMActivity) gVar.context).geJ = gVar;
        com.tencent.mm.bg.d.a(gVar.context, "wallet", ".bind.ui.WalletUnbindBankCardProxyUI", intent, 39, false);
        return true;
    }

    static /* synthetic */ boolean dF(g gVar, i iVar) {
        gVar.iKs = false;
        if ("1".equals(iVar.mcy.get("isDeleteAll"))) {
            com.tencent.mm.plugin.webview.modeltools.e.bUU();
            ((com.tencent.mm.plugin.fts.a.n) com.tencent.mm.kernel.g.n(com.tencent.mm.plugin.fts.a.n.class)).deleteSOSHistory();
        } else {
            com.tencent.mm.plugin.webview.modeltools.e.bUU();
            ((com.tencent.mm.plugin.fts.a.n) com.tencent.mm.kernel.g.n(com.tencent.mm.plugin.fts.a.n.class)).deleteSOSHistory((String) iVar.mcy.get("query"));
        }
        return false;
    }

    static /* synthetic */ boolean dI(g gVar, i iVar) {
        x.i("MicroMsg.MsgHandler", "do open offline pay view");
        ((MMActivity) gVar.context).geJ = gVar;
        Context context = gVar.context;
        com.tencent.mm.pluginsdk.wallet.g gVar2 = new com.tencent.mm.pluginsdk.wallet.g(iVar.mcy);
        Intent intent = new Intent();
        intent.putExtra("appId", gVar2.appId);
        intent.putExtra("timeStamp", gVar2.timeStamp);
        intent.putExtra("nonceStr", gVar2.nonceStr);
        intent.putExtra("packageExt", gVar2.packageExt);
        intent.putExtra("signtype", gVar2.signType);
        intent.putExtra("paySignature", gVar2.bVW);
        intent.putExtra(TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_URL, gVar2.url);
        intent.putExtra("key_from_scene", 6);
        intent.putExtra("pay_channel", gVar2.bJY);
        com.tencent.mm.bg.d.b(context, "offline", ".ui.WalletOfflineEntranceUI", intent, 60);
        return true;
    }

    static /* synthetic */ boolean dJ(g gVar, i iVar) {
        com.tencent.mm.pluginsdk.wallet.g gVar2 = new com.tencent.mm.pluginsdk.wallet.g(iVar.mcy);
        Intent intent = new Intent();
        intent.putExtra("appId", gVar2.appId);
        intent.putExtra("timeStamp", gVar2.timeStamp);
        intent.putExtra("nonceStr", gVar2.nonceStr);
        intent.putExtra("packageExt", gVar2.packageExt);
        intent.putExtra("signtype", gVar2.signType);
        intent.putExtra("paySignature", gVar2.bVW);
        intent.putExtra(TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_URL, gVar2.url);
        intent.putExtra("pay_channel", gVar2.bJY);
        intent.putExtra("intent_jump_package", "wallet");
        x.i("MicroMsg.MsgHandler", "appid %s timeStamp %s nonceStr %s packageExt %s signType %s", new Object[]{bi.aG((String) iVar.mcy.get("appid"), ""), gVar2.timeStamp, gVar2.nonceStr, gVar2.packageExt, gVar2.signType});
        intent.putExtra("intent_jump_ui", ".bind.ui.WalletBankcardManageUI");
        ((MMActivity) gVar.context).geJ = gVar;
        com.tencent.mm.bg.d.b(gVar.context, "wallet", ".ui.WalletJsApiAdapterUI", intent, 59);
        return true;
    }

    static /* synthetic */ void dU(g gVar, i iVar) {
        if (gVar.context == null) {
            gVar.a(iVar, "chooseIdCard:fail", null);
            return;
        }
        if (!gVar.qif.a("identity_pay_auth", gVar.context, new 118(gVar, iVar))) {
            gVar.a(iVar, "chooseIdCard:fail", null);
        }
    }

    static /* synthetic */ void dV(g gVar, i iVar) {
        x.i("MicroMsg.MsgHandler", "real scene = %d", new Object[]{Integer.valueOf(3)});
        x.d("MicroMsg.MsgHandler", " checkPermission checkcamera[%b]", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.permission.a.a((Activity) gVar.context, "android.permission.CAMERA", 113, "", ""))});
        if (com.tencent.mm.pluginsdk.permission.a.a((Activity) gVar.context, "android.permission.CAMERA", 113, "", "")) {
            Intent intent = new Intent();
            intent.putExtra("key_pick_local_pic_capture", 3);
            intent.putExtra("key_pick_local_pic_query_source_type", 8);
            intent.putExtra("query_media_type", 1);
            intent.putExtra("key_pick_local_pic_count", 1);
            x.i("MicroMsg.MsgHandler", "doChooseImageIdCard: realScene: %d, querySourceType: %d", new Object[]{Integer.valueOf(3), Integer.valueOf(8)});
            if (gVar.context instanceof MMActivity) {
                ((MMActivity) gVar.context).geJ = gVar;
                com.tencent.mm.bg.d.a(gVar.context, "webview", ".ui.tools.OpenFileChooserUI", intent, 43, false);
                return;
            }
            return;
        }
        gVar.a(iVar, "chooseIdCard:fail", null);
    }

    static /* synthetic */ boolean da(g gVar, final i iVar) {
        final String oV = bi.oV((String) iVar.mcy.get("base64DataString"));
        String oV2 = bi.oV((String) iVar.mcy.get(TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_URL));
        final String oV3 = bi.oV((String) iVar.mcy.get("activityId"));
        if (!bi.oW(oV)) {
            au.Em().H(new Runnable() {
                public final void run() {
                    x.i("MicroMsg.MsgHandler", "doShareEmoticon use base64DataString");
                    int indexOf = oV.indexOf(";base64,");
                    String str = "";
                    if (indexOf != -1) {
                        str = oV.substring(indexOf + 8, oV.length());
                    }
                    try {
                        byte[] decode = Base64.decode(str, 0);
                        if (bi.bC(decode)) {
                            g.this.a(iVar, "shareEmoticon:fail", null);
                            return;
                        }
                        String u = com.tencent.mm.a.g.u(decode);
                        if (bi.oW(u)) {
                            g.this.a(iVar, "shareEmoticon:fail empty buffer", null);
                            return;
                        }
                        au.HU();
                        String L = EmojiLogic.L(com.tencent.mm.model.c.Gg(), "", u);
                        if (!(com.tencent.mm.a.e.cn(L) && com.tencent.mm.a.g.cu(L).equalsIgnoreCase(u))) {
                            com.tencent.mm.a.e.b(L, decode, decode.length);
                        }
                        ah.A(new 109(g.this, u, oV3));
                    } catch (Exception e) {
                        x.e("MicroMsg.MsgHandler", "doShareEmoticon error:" + e.getMessage());
                        g.this.a(iVar, "shareEmoticon:fail_" + e.getMessage(), null);
                    }
                }
            });
        } else if (bi.oW(oV2)) {
            x.e("MicroMsg.MsgHandler", "doShareEmoticon base64DataString is null and url is null");
            gVar.a(iVar, "shareEmoticon:fail_base64DataString_and_url_is_null", null);
            return false;
        } else {
            x.i("MicroMsg.MsgHandler", "doShareEmoticon use url:%s", new Object[]{oV2});
            File file = new File(gVar.context.getCacheDir(), com.tencent.mm.a.g.u(oV2.getBytes()));
            if (file.exists()) {
                au.Em().H(new 107(gVar, file, oV3));
            } else {
                com.tencent.mm.ak.a.a.c.a aVar = new com.tencent.mm.ak.a.a.c.a();
                aVar.dXy = true;
                aVar.dXA = file.getAbsolutePath();
                aVar.dYc = new Object[]{file.getAbsolutePath()};
                com.tencent.mm.plugin.emoji.model.i.aDZ().a(oV2, null, aVar.Pt(), new 108(gVar, oV2, oV3, iVar));
            }
        }
        return true;
    }

    static /* synthetic */ boolean db(g gVar, i iVar) {
        ((MMActivity) gVar.context).geJ = gVar;
        Bundle bundle = new Bundle();
        bundle.putBoolean("k_need_signature", true);
        bundle.putInt("k_server_scene", 3);
        bundle.putBoolean("key_is_need_video", false);
        bundle.putBoolean("is_check_dyncfg", false);
        bundle.putString("k_ticket", (String) iVar.mcy.get("request_ticket"));
        np npVar = new np();
        npVar.bYG.context = gVar.context;
        npVar.bYG.bYI = 50;
        npVar.bYG.extras = bundle;
        com.tencent.mm.sdk.b.a.sFg.m(npVar);
        x.i("MicroMsg.MsgHandler", "hy: start face register rsa event result: %b", new Object[]{Boolean.valueOf(npVar.bYH.bYJ)});
        if (!npVar.bYH.bYJ) {
            ((MMActivity) gVar.context).geJ = null;
            gVar.a(iVar, "requestWxFaceRegisterInternal:fail", i.ac(npVar.bYH.extras));
        }
        return true;
    }

    static /* synthetic */ boolean dc(g gVar, i iVar) {
        ((MMActivity) gVar.context).geJ = gVar;
        Bundle bundle = new Bundle();
        bundle.putBoolean("k_need_signature", true);
        bundle.putString("k_user_name", at.dBv.I("login_user_name", ""));
        bundle.putInt("k_server_scene", 4);
        bundle.putBoolean("key_is_need_video", false);
        bundle.putBoolean("is_check_dyncfg", false);
        bundle.putString("k_ticket", (String) iVar.mcy.get("request_ticket"));
        np npVar = new np();
        npVar.bYG.context = gVar.context;
        npVar.bYG.bYI = 51;
        npVar.bYG.extras = bundle;
        com.tencent.mm.sdk.b.a.sFg.m(npVar);
        x.i("MicroMsg.MsgHandler", "hy: start face verify rsa event result: %b", new Object[]{Boolean.valueOf(npVar.bYH.bYJ)});
        if (!npVar.bYH.bYJ) {
            ((MMActivity) gVar.context).geJ = null;
            gVar.a(iVar, "requestWxFaceVerifyInternal:fail", i.ac(npVar.bYH.extras));
        }
        return true;
    }

    static /* synthetic */ boolean de(g gVar, i iVar) {
        String str = (String) iVar.mcy.get("selected_user_name");
        Intent intent = new Intent();
        intent.putExtra("list_type", 15);
        intent.putExtra("already_select_contact", str);
        intent.putExtra("titile", gVar.context.getString(R.l.address_title_select_contact));
        intent.putExtra("list_attr", s.s(new int[]{16384, 1, 4, 1048576}));
        if (gVar.context instanceof MMActivity) {
            com.tencent.mm.bg.d.a((MMActivity) gVar.context, ".ui.contact.SelectContactUI", intent, 54, gVar);
        } else {
            x.e("MicroMsg.MsgHandler", "doSelectContact invalid context");
            gVar.a(iVar, "selectContact:fail", null);
        }
        return true;
    }

    static /* synthetic */ boolean df(g gVar, i iVar) {
        gVar.iKs = false;
        String str = (String) iVar.mcy.get("phoneNumber");
        x.d("MicroMsg.MsgHandler", "jsapi makePhoneCall num %s", new Object[]{str});
        if (TextUtils.isEmpty(str)) {
            gVar.a(iVar, "makePhoneCall:fail", null);
        } else {
            Intent intent = new Intent("android.intent.action.DIAL", Uri.parse("tel:" + str));
            intent.addFlags(268435456);
            if (bi.k(gVar.context, intent)) {
                gVar.context.startActivity(intent);
            }
            gVar.a(iVar, "makePhoneCall:succ", null);
        }
        return true;
    }

    static /* synthetic */ boolean dg(g gVar, i iVar) {
        com.tencent.mm.pluginsdk.wallet.g gVar2 = new com.tencent.mm.pluginsdk.wallet.g(iVar.mcy);
        Intent intent = new Intent();
        intent.putExtra("appId", bi.aG((String) iVar.mcy.get("appid"), ""));
        intent.putExtra("timeStamp", gVar2.timeStamp);
        intent.putExtra("nonceStr", gVar2.nonceStr);
        intent.putExtra("packageExt", gVar2.packageExt);
        intent.putExtra("signtype", gVar2.signType);
        intent.putExtra("paySignature", gVar2.bVW);
        intent.putExtra(TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_URL, gVar2.url);
        intent.putExtra("reset_pwd_token", gVar2.qUX);
        intent.putExtra("pay_channel", gVar2.bJY);
        ((MMActivity) gVar.context).geJ = gVar;
        com.tencent.mm.bg.d.b(gVar.context, "wallet", ".pwd.ui.WalletResetPwdAdapterUI", intent, 55);
        return true;
    }

    static /* synthetic */ boolean dh(g gVar, i iVar) {
        l.a(iVar.qkk, false, null, (String) iVar.mcy.get("appId"));
        x.i("MicroMsg.MsgHandler", "doChooseInvoiceTitle");
        Intent intent = new Intent();
        intent.putExtra("req_scene", 0);
        intent.putExtra("launch_from_webview", true);
        if (gVar.context instanceof MMActivity) {
            ((MMActivity) gVar.context).geJ = gVar;
            com.tencent.mm.bg.d.a(gVar.context, "address", ".ui.InvoiceListUI", intent, 56, false);
        }
        return true;
    }

    static /* synthetic */ boolean dq(g gVar, i iVar) {
        gVar.iKs = false;
        Map hashMap = new HashMap();
        hashMap.put("query", p.t(iVar.mcy, "query"));
        hashMap.put("scene", Integer.valueOf(33));
        if (iVar.mcy.containsKey(TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_URL)) {
            com.tencent.mm.plugin.webview.modeltools.e.bUV().pPr = new cfk();
            com.tencent.mm.plugin.webview.modeltools.e.bUV().pPr.szT = new iv();
            com.tencent.mm.plugin.webview.modeltools.e.bUV().pPr.szT.rki = p.t(iVar.mcy, TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_URL);
        }
        com.tencent.mm.plugin.webview.modeltools.e.bUU();
        String t = p.t(hashMap, "query");
        if (!bi.oW(t)) {
            int c = p.c(hashMap, "scene", 3);
            int c2 = p.c(hashMap, DownloadSettingTable$Columns.TYPE, 0);
            String zK = p.zK(c);
            Intent adR = p.adR();
            adR.putExtra("ftsbizscene", c);
            adR.putExtra("ftsType", c2);
            adR.putExtra("sessionId", zK);
            adR.putExtra("ftsQuery", t);
            adR.putExtra("ftsInitToSearch", true);
            hashMap = p.b(c, true, 0);
            hashMap.put("query", t);
            hashMap.put("sessionId", zK);
            adR.putExtra("rawUrl", p.v(hashMap));
            com.tencent.mm.bg.d.b(ad.getContext(), "webview", ".ui.tools.fts.FTSSOSHomeWebViewUI", adR);
        }
        return false;
    }

    static /* synthetic */ boolean dz(g gVar, i iVar) {
        x.i("MicroMsg.MsgHandler", "do handle wcpay buffer");
        l.a(iVar.qkk, false, null, (String) iVar.mcy.get("appId"));
        com.tencent.mm.pluginsdk.wallet.g gVar2 = new com.tencent.mm.pluginsdk.wallet.g(iVar.mcy);
        sv svVar = new sv();
        svVar.cdI.action = (String) iVar.mcy.get("action");
        svVar.cdI.buffer = (String) iVar.mcy.get("buffer");
        svVar.cdI.cdM = bi.getInt((String) iVar.mcy.get("walletRegion"), 0);
        svVar.cdI.appId = gVar2.appId;
        svVar.cdI.bJT = gVar2.timeStamp;
        svVar.cdI.nonceStr = gVar2.nonceStr;
        svVar.cdI.cdL = gVar2.bVW;
        svVar.cdI.signType = gVar2.signType;
        svVar.cdI.cdK = gVar2.packageExt;
        svVar.cdI.url = gVar2.url;
        svVar.cdJ.cdN = new 33(gVar, svVar, iVar);
        com.tencent.mm.sdk.b.a.sFg.m(svVar);
        return true;
    }

    static /* synthetic */ boolean f(g gVar, i iVar) {
        x.i("MicroMsg.MsgHandler", "jslog : " + iVar.mcy.get("msg"));
        gVar.iKs = false;
        return false;
    }

    static /* synthetic */ boolean g(g gVar, i iVar) {
        if (ao.isConnected(gVar.context)) {
            x.i("MicroMsg.MsgHandler", "getNetworkType, type = " + ao.getNetType(gVar.context));
            Map hashMap = new HashMap();
            if (ao.is2G(gVar.context)) {
                x.i("MicroMsg.MsgHandler", "getNetworkType, 2g");
                hashMap.put("subtype", "2g");
                gVar.a(iVar, "network_type:wwan", hashMap);
            } else if (ao.is3G(gVar.context)) {
                x.i("MicroMsg.MsgHandler", "getNetworkType, 3g");
                hashMap.put("subtype", "3g");
                gVar.a(iVar, "network_type:wwan", hashMap);
            } else if (ao.is4G(gVar.context)) {
                x.i("MicroMsg.MsgHandler", "getNetworkType, 4g");
                hashMap.put("subtype", "4g");
                gVar.a(iVar, "network_type:wwan", hashMap);
            } else if (ao.isWifi(gVar.context)) {
                x.i("MicroMsg.MsgHandler", "getNetworkType, wifi");
                gVar.a(iVar, "network_type:wifi", null);
            } else {
                x.w("MicroMsg.MsgHandler", "getNetworkType, unknown");
                gVar.a(iVar, "network_type:fail", null);
            }
        } else {
            x.i("MicroMsg.MsgHandler", "getNetworkType, not connected");
            gVar.a(iVar, "network_type:fail", null);
        }
        return true;
    }

    static /* synthetic */ boolean l(g gVar, i iVar) {
        x.i("MicroMsg.MsgHandler", "doJumpToInstallUrl");
        String str = (String) iVar.mcy.get(TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_URL);
        if (bi.oW(str)) {
            x.e("MicroMsg.MsgHandler", "jumpurl is null or nil");
        } else {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            intent.addFlags(268435456);
            if (bi.k(gVar.context, intent)) {
                gVar.context.startActivity(intent);
            }
        }
        gVar.iKs = false;
        return false;
    }

    static /* synthetic */ boolean m(g gVar, i iVar) {
        String aG = bi.aG(iVar.mcy.get("pay_packageName") == null ? "" : (String) iVar.mcy.get("pay_packageName"), "");
        l.a(iVar.qkk, false, null, (String) iVar.mcy.get("appId"));
        x.i("MicroMsg.MsgHandler", "doPay %s", new Object[]{aG});
        if (gVar.context instanceof MMActivity) {
            com.tencent.mm.pluginsdk.wallet.g gVar2 = new com.tencent.mm.pluginsdk.wallet.g(iVar.mcy);
            gVar2.qUW = 1;
            x.i("MicroMsg.MsgHandler", "doPay, pay channel: %s, scene: %s", new Object[]{Integer.valueOf(gVar2.bJY), Integer.valueOf(gVar2.bVY)});
            h.a((MMActivity) gVar.context, gVar2, 4, gVar);
            long j = bi.getLong((String) iVar.mcy.get("message_id"), 0);
            int i = bi.getInt((String) iVar.mcy.get("message_index"), 0);
            com.tencent.mm.plugin.report.service.h.mEJ.h(10593, new Object[]{gVar2.bVX, gVar2.appId, Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(gVar2.bVY), gVar2.url});
            gVar.qii = gVar.aW(iVar);
        }
        return true;
    }

    static /* synthetic */ boolean n(g gVar, i iVar) {
        l.a(iVar.qkk, false, null, (String) iVar.mcy.get("appId"));
        x.i("MicroMsg.MsgHandler", "doEditAddress");
        Intent intent = new Intent();
        intent.putExtra("req_url", (String) iVar.mcy.get(TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_URL));
        intent.putExtra("req_app_id", (String) iVar.mcy.get("appId"));
        intent.putExtra("launch_from_webview", true);
        if (gVar.context instanceof MMActivity) {
            ((MMActivity) gVar.context).geJ = gVar;
            com.tencent.mm.bg.d.a(gVar.context, "address", ".ui.WalletSelectAddrUI", intent, 3, false);
        }
        return true;
    }

    static /* synthetic */ boolean o(g gVar, i iVar) {
        Map hashMap = new HashMap();
        if (com.tencent.mm.pluginsdk.ui.tools.e.qSs == null) {
            x.w("MicroMsg.MsgHandler", "HeadingPitchSensorMgr.instance == null, init here");
            com.tencent.mm.pluginsdk.ui.tools.e eVar = new com.tencent.mm.pluginsdk.ui.tools.e();
            r.a(eVar);
            com.tencent.mm.pluginsdk.ui.tools.e.qSs = eVar;
            eVar.eZ(gVar.context);
            com.tencent.mm.pluginsdk.ui.tools.e.qSs = eVar;
        }
        hashMap.put("heading", Integer.valueOf(com.tencent.mm.pluginsdk.ui.tools.e.qSs.cfn()));
        hashMap.put("pitch", Integer.valueOf(com.tencent.mm.pluginsdk.ui.tools.e.qSs.getPitch()));
        x.i("MicroMsg.MsgHandler", "doGetHeadingAndPitch, heading=[%s], pitch=[%s]", new Object[]{Integer.valueOf(com.tencent.mm.pluginsdk.ui.tools.e.qSs.cfn()), Integer.valueOf(com.tencent.mm.pluginsdk.ui.tools.e.qSs.getPitch())});
        gVar.a(iVar, "get_heading_and_pitch:ok", hashMap);
        return true;
    }

    static /* synthetic */ boolean q(g gVar, i iVar) {
        if (com.tencent.mm.sdk.platformtools.e.chv()) {
            x.e("MicroMsg.MsgHandler", "doAddDownloadTask fail, GP Version not allowed to download");
            gVar.a(iVar, "system:access_denied", null);
            return true;
        }
        String str = (String) iVar.mcy.get("task_name");
        String str2 = (String) iVar.mcy.get("task_url");
        String str3 = (String) iVar.mcy.get("alternative_url");
        long j = bi.getLong((String) iVar.mcy.get("task_size"), 0);
        String str4 = (String) iVar.mcy.get("file_md5");
        String str5 = (String) iVar.mcy.get("extInfo");
        String str6 = (String) iVar.mcy.get("fileType");
        String str7 = (String) iVar.mcy.get("appid");
        String str8 = (String) iVar.mcy.get("package_name");
        String str9 = (String) iVar.mcy.get("thumb_url");
        String str10 = (String) iVar.mcy.get("title");
        x.i("MicroMsg.MsgHandler", "doAddDownloadTask, md5 = " + str4 + ", url = " + str2 + ", extinfo = " + str5 + ", fileType = " + str6);
        if (gVar.qhS != null) {
            int i = gVar.qhS.getInt("key_download_restrict", 0);
            if (!bi.oW(gVar.qhS.getString("key_function_id", ""))) {
                com.tencent.mm.plugin.report.service.h.mEJ.h(14596, new Object[]{r15, Integer.valueOf(i), Integer.valueOf(0)});
            }
            if (i == 1) {
                x.e("MicroMsg.MsgHandler", "not allow to download file");
                gVar.a(iVar, "add_download_task:fail", null);
                return true;
            }
        }
        if (ao.isNetworkConnected(gVar.context)) {
            au.HU();
            if (!com.tencent.mm.model.c.isSDCardAvailable()) {
                gVar.a(iVar, "add_download_task:fail_sdcard_not_ready", null);
                ah.A(new 43(gVar));
                u(str7, com.tencent.mm.plugin.downloader.a.a.ibo, str5);
                x.i("MicroMsg.MsgHandler", "doAddDownloadTask fail, sdcard not ready");
                return true;
            } else if (j > 0 && !com.tencent.mm.compatible.util.f.aM(j)) {
                gVar.a(iVar, "add_download_task:fail_sdcard_has_not_enough_space", null);
                ah.A(new 44(gVar));
                u(str7, com.tencent.mm.plugin.downloader.a.a.ibo, str5);
                x.i("MicroMsg.MsgHandler", "doAddDownloadTask fail, not enough space, require size = " + j);
                return true;
            } else if (bi.oW(str2)) {
                x.e("MicroMsg.MsgHandler", "doAddDownloadTask fail, url is null");
                gVar.a(iVar, "add_download_task:fail_invalid_url", null);
                u(str7, com.tencent.mm.plugin.downloader.a.a.DOWNLOAD_ERR_URL_INVALID, str5);
                return true;
            } else {
                Intent intent = new Intent();
                intent.setClass(gVar.context, WebViewDownloadUI.class);
                intent.putExtra("task_name", str);
                intent.putExtra("task_url", str2);
                intent.putExtra("alternative_url", str3);
                intent.putExtra("task_size", j);
                intent.putExtra("file_md5", str4);
                intent.putExtra("extInfo", str5);
                intent.putExtra("fileType", str6);
                intent.putExtra("appid", str7);
                intent.putExtra("package_name", str8);
                intent.putExtra("thumb_url", str9);
                intent.putExtra("title", str10);
                intent.putExtra("page_url", (String) iVar.mcy.get(TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_URL));
                intent.putExtra("page_scene", 0);
                intent.addFlags(268435456);
                gVar.context.startActivity(intent);
                final i iVar2 = iVar;
                gVar.fFB = new com.tencent.mm.sdk.b.c<com.tencent.mm.g.a.h>() {
                    public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                        com.tencent.mm.g.a.h hVar = (com.tencent.mm.g.a.h) bVar;
                        if (!(hVar instanceof com.tencent.mm.g.a.h)) {
                            x.w("MicroMsg.MsgHandler", "mismatched event");
                        } else if (hVar.bGk.scene != 0) {
                            x.i("MicroMsg.MsgHandler", "not jsapi api callback");
                        } else if (hVar.bGk.bGl) {
                            x.i("MicroMsg.MsgHandler", "doAddDownloadTask callback, cancel");
                            g.this.a(iVar2, "add_download_task:cancel", null);
                        } else {
                            if (hVar.bGk.bGm > 0) {
                                Map hashMap = new HashMap();
                                hashMap.put("download_id", Long.valueOf(hVar.bGk.bGm));
                                x.i("MicroMsg.MsgHandler", "doAddDownloadTask callback, ok");
                                g.this.a(iVar2, "add_download_task:ok", hashMap);
                            } else {
                                x.i("MicroMsg.MsgHandler", "doAddDownloadTask callback, failed");
                                g.this.a(iVar2, "add_download_task:fail", null);
                            }
                            com.tencent.mm.sdk.b.a.sFg.c(g.this.fFB);
                        }
                        return false;
                    }
                };
                com.tencent.mm.sdk.b.a.sFg.a(gVar.fFB);
                return true;
            }
        }
        gVar.a(iVar, "add_download_task:fail_network_not_connected", null);
        ah.A(new 42(gVar));
        x.i("MicroMsg.MsgHandler", "doAddDownloadTask fail, network not ready");
        u(str7, com.tencent.mm.plugin.downloader.a.a.ibn, str5);
        return true;
    }

    static /* synthetic */ boolean r(g gVar, i iVar) {
        long j = bi.getLong((String) iVar.mcy.get("download_id"), -1);
        x.i("MicroMsg.MsgHandler", "doCancelDownloadTask, downloadId = " + j);
        if (j <= 0) {
            x.e("MicroMsg.MsgHandler", "doCancelDownloadTask fail, invalid downloadId = " + j);
            gVar.a(iVar, "cancel_download_task:fail", null);
        } else {
            int cl = com.tencent.mm.plugin.downloader.model.d.aCU().cl(j);
            x.i("MicroMsg.MsgHandler", "doCancelDownloadTask, ret = " + cl);
            if (cl <= 0) {
                gVar.a(iVar, "cancel_download_task:fail", null);
            } else {
                gVar.a(iVar, "cancel_download_task:ok", null);
            }
        }
        return true;
    }

    static /* synthetic */ boolean s(g gVar, i iVar) {
        long j = bi.getLong((String) iVar.mcy.get("download_id"), -1);
        x.i("MicroMsg.MsgHandler", "doCancelDownloadTask, downloadId = " + j);
        if (j <= 0) {
            x.e("MicroMsg.MsgHandler", "doCancelDownloadTask fail, invalid downloadId = " + j);
            gVar.a(iVar, "pause_download_task:fail", null);
        } else {
            boolean cn = com.tencent.mm.plugin.downloader.model.d.aCU().cn(j);
            x.i("MicroMsg.MsgHandler", "doCancelDownloadTask, ret = " + cn);
            if (cn) {
                gVar.a(iVar, "pause_download_task:ok", null);
            } else {
                gVar.a(iVar, "pause_download_task:fail", null);
            }
        }
        return true;
    }

    static /* synthetic */ boolean t(g gVar, i iVar) {
        long j = bi.getLong((String) iVar.mcy.get("download_id"), -1);
        String str = (String) iVar.mcy.get("appid");
        String str2 = (String) iVar.mcy.get("appIdArray");
        x.i("MicroMsg.MsgHandler", "doQueryDownloadTask, downloadId = " + j + ",appId = " + str + ",appIds = " + str2);
        if (!bi.oW(str2)) {
            return gVar.a(str2, iVar);
        }
        FileDownloadTaskInfo cm;
        if (j > 0) {
            cm = com.tencent.mm.plugin.downloader.model.d.aCU().cm(j);
        } else if (bi.oW(str)) {
            x.e("MicroMsg.MsgHandler", "doQueryDownloadTask fail, invalid downloadId = " + j + " or appid is null");
            gVar.a(iVar, "query_download_task:fail", null);
            return true;
        } else {
            cm = com.tencent.mm.plugin.downloader.model.d.aCU().yO(str);
        }
        switch (cm.status) {
            case -1:
                x.e("MicroMsg.MsgHandler", "doQueryDownloadTask fail, api not support");
                gVar.a(iVar, "query_download_task:fail_apilevel_too_low", null);
                return true;
            case 1:
                str2 = "downloading";
                break;
            case 2:
                str2 = "download_pause";
                break;
            case 3:
                if (!com.tencent.mm.a.e.cn(cm.path)) {
                    str2 = "default";
                    break;
                }
                str2 = "download_succ";
                break;
            case 4:
                str2 = "download_fail";
                break;
            default:
                str2 = "default";
                break;
        }
        x.i("MicroMsg.MsgHandler", "doQueryDownloadTask, state = " + str2);
        Map hashMap = new HashMap();
        hashMap.put(OpenSDKTool4Assistant.EXTRA_STATE, str2);
        hashMap.put("download_id", Long.valueOf(cm.id));
        if (str2 == "downloading" && cm.gTK != 0) {
            hashMap.put("progress", Long.valueOf((long) ((((float) cm.icq) / ((float) cm.gTK)) * 100.0f)));
        }
        gVar.a(iVar, "query_download_task:ok", hashMap);
        return true;
    }

    static /* synthetic */ boolean u(g gVar, i iVar) {
        long j = bi.getLong((String) iVar.mcy.get("download_id"), -1);
        int i = bi.getInt((String) iVar.mcy.get("scene"), BaseReportManager.MAX_READ_COUNT);
        x.i("MicroMsg.MsgHandler", "doInstallDownloadTask, downloadId = " + j);
        if (j <= 0) {
            x.e("MicroMsg.MsgHandler", "doInstallDownloadTask fail, invalid downloadId = " + j);
        } else {
            com.tencent.mm.plugin.downloader.c.a cs = com.tencent.mm.plugin.downloader.model.c.cs(j);
            if (cs == null) {
                x.e("MicroMsg.MsgHandler", "doInstallDownloadTask fail, info is null");
            } else {
                if (cs.field_status == -1) {
                    x.e("MicroMsg.MsgHandler", "doInstallDownloadTask fail, apilevel not supported");
                    gVar.a(iVar, "install_download_task:fail_apilevel_too_low", null);
                } else if (cs.field_status != 3) {
                    x.e("MicroMsg.MsgHandler", "doInstallDownloadTask fail, invalid status = " + cs.field_status);
                } else if (com.tencent.mm.a.e.cn(cs.field_filePath)) {
                    if (com.tencent.mm.plugin.downloader.e.a.yW(cs.field_filePath)) {
                        com.tencent.mm.plugin.downloader.e.a.a(cs.field_appId, i, j, cs.field_channelId);
                        gVar.a(iVar, "install_download_task:ok", null);
                    } else {
                        gVar.a(iVar, "install_download_task:fail", null);
                    }
                }
                return true;
            }
        }
        gVar.a(iVar, "install_download_task:fail", null);
        return true;
    }

    static /* synthetic */ boolean v(g gVar, i iVar) {
        String str = (String) iVar.mcy.get("specificview");
        if (bi.oW(str)) {
            x.e("MicroMsg.MsgHandler", "doOpenSpecificView fail, invalid specificview");
            gVar.a(iVar, "specific_view:fail", null);
        } else {
            new Intent().addFlags(268435456);
            Bundle bundle = new Bundle();
            String str2 = (String) iVar.mcy.get(TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_URL);
            String str3 = (String) iVar.mcy.get("extinfo");
            bundle.putInt("webview_scene", bi.getInt((String) iVar.mcy.get("webview_scene"), 0));
            bundle.putString(TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_URL, str2);
            bundle.putString("extinfo", str3);
            x.i("MicroMsg.MsgHandler", "doOpenSpecificView, targetView = %s, ret = %b", new Object[]{str, Boolean.valueOf(com.tencent.mm.plugin.webview.a.a.ezn.b(gVar.context, str, new Object[]{bundle}))});
            if (com.tencent.mm.plugin.webview.a.a.ezn.b(gVar.context, str, new Object[]{bundle})) {
                gVar.a(iVar, "specific_view:ok", null);
            } else {
                x.e("MicroMsg.MsgHandler", "doOpenSpecificView, targetView not supported in current wechat version");
                gVar.a(iVar, "specific_view:not_supported", null);
            }
        }
        return true;
    }

    static /* synthetic */ boolean x(g gVar, i iVar) {
        x.i("MicroMsg.MsgHandler", "doJumpToMall");
        String str = (String) iVar.mcy.get("appId");
        String str2 = (String) iVar.mcy.get("funcId");
        String str3 = (String) iVar.mcy.get(TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_URL);
        l.a(iVar.qkk, false, null, str);
        Intent intent = new Intent();
        intent.putExtra("key_app_id", str);
        intent.putExtra("key_func_id", str2);
        intent.putExtra("key_url", str3);
        if (gVar.context instanceof MMActivity) {
            ((MMActivity) gVar.context).geJ = gVar;
            com.tencent.mm.bg.d.a(gVar.context, "mall", ".ui.MallIndexUI", intent, 5, false);
        }
        return true;
    }

    static /* synthetic */ boolean y(g gVar, i iVar) {
        String str = (String) iVar.mcy.get("packageName");
        if (bi.oW(str)) {
            x.e("MicroMsg.MsgHandler", "doWriteCommData fail, packageName is null");
        } else {
            String str2 = (String) iVar.mcy.get("data");
            boolean commit = gVar.context.getSharedPreferences(ad.getPackageName() + "_comm_preferences", 0).edit().putString(str, str2).commit();
            String str3 = "MicroMsg.MsgHandler";
            String str4 = "doWriteCommData, ret = %b, packageName = %s, data length = %d";
            Object[] objArr = new Object[3];
            objArr[0] = Boolean.valueOf(commit);
            objArr[1] = str;
            objArr[2] = Integer.valueOf(str2 == null ? 0 : str2.length());
            x.i(str3, str4, objArr);
            if (commit) {
                gVar.a(iVar, "write_comm_data:ok", null);
                return true;
            }
        }
        gVar.a(iVar, "write_comm_data:fail", null);
        return true;
    }

    static {
        HashSet hashSet = new HashSet();
        fQY = hashSet;
        hashSet.add("gcj02");
        fQY.add("wgs84");
    }

    g(int i) {
        this.bWo = i;
        this.iKs = false;
        this.qhR = new HashSet();
        this.jGy = new HashSet();
        this.qic = new c(this.bWo);
        this.qie = new j();
        this.qif = new d();
    }

    public final void km(boolean z) {
        this.qhX = z;
        x.i("MicroMsg.MsgHandler", "markAwaitingProxyUI %d, %b", new Object[]{Integer.valueOf(this.bWo), Boolean.valueOf(z)});
    }

    public final void bXZ() {
        x.i("MicroMsg.MsgHandler", "setIsBusy: true");
        this.iKs = true;
    }

    public final void a(Context context, e eVar) {
        String str = "MicroMsg.MsgHandler";
        String str2 = "set context and callbacker, callbacker %s";
        Object[] objArr = new Object[1];
        objArr[0] = eVar == null ? "null" : eVar.toString();
        x.i(str, str2, objArr);
        this.context = context;
        if (this.qic != null) {
            this.qic.a(context, eVar);
        }
        this.pRY = eVar;
    }

    public final void a(Context context, e eVar, e eVar2) {
        x.i("MicroMsg.MsgHandler", "set context, callbacker and service callbacker");
        this.context = context;
        if (this.qic != null) {
            this.qic.a(context, eVar);
        }
        this.pRY = eVar;
        this.qhZ = eVar2;
    }

    public final Bundle bYa() {
        if (this.qhS == null) {
            this.qhS = new Bundle();
        }
        return this.qhS;
    }

    public final String rL(String str) {
        if (this.qic != null) {
            return this.qic.RE(str);
        }
        x.i("MicroMsg.MsgHandler", "getCachedAppId, jsVerifyHelper is null, return null");
        return null;
    }

    private void RL(String str) {
        if (this.qhS == null) {
            this.qhS = new Bundle();
        }
        int i = bi.getInt(str, 33);
        if (this.qhS.getBoolean("KFromBizSearch")) {
            Bundle bundle = this.qhS.getBundle("KBizSearchExtArgs");
            if (bundle != null) {
                i = bundle.getInt("Contact_Scene");
            }
        }
        this.qhS.putInt("Contact_Scene", i);
    }

    private boolean RM(String str) {
        x.i("MicroMsg.MsgHandler", "getFromMenu, functionName = " + str);
        if (!this.qhR.contains(str)) {
            return false;
        }
        this.qhR.remove(str);
        return true;
    }

    public final boolean RN(String str) {
        x.i("MicroMsg.MsgHandler", "removeInvokedJsApiFromMenu, functionName = %s, succ = %s.", new Object[]{str, Boolean.valueOf(this.jGy.remove(str))});
        return this.jGy.remove(str);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(com.tencent.mm.plugin.webview.ui.tools.jsapi.i r21, com.tencent.mm.protocal.JsapiPermissionWrapper r22) {
        /*
        r20 = this;
        r0 = r20;
        r4 = r0.iKs;
        if (r4 == 0) goto L_0x000f;
    L_0x0006:
        r4 = "MicroMsg.MsgHandler";
        r5 = "handleMsg, MsgHandler is busy, old msg will be overrided";
        com.tencent.mm.sdk.platformtools.x.w(r4, r5);
    L_0x000f:
        r0 = r20;
        r4 = r0.qhS;
        if (r4 == 0) goto L_0x0024;
    L_0x0015:
        r0 = r20;
        r4 = r0.qhS;
        r5 = r20.getClass();
        r5 = r5.getClassLoader();
        r4.setClassLoader(r5);
    L_0x0024:
        r0 = r21;
        r1 = r20;
        r1.qhP = r0;
        r4 = 1;
        r0 = r20;
        r0.iKs = r4;
        r0 = r21;
        r4 = r0.type;
        r5 = "call";
        r4 = r4.equals(r5);
        if (r4 == 0) goto L_0x0189;
    L_0x003c:
        r0 = r21;
        r4 = r0.qkl;
        r0 = r20;
        r0.qhW = r4;
        r0 = r21;
        r4 = r0.qkl;
        r4 = com.tencent.mm.plugin.webview.ui.tools.a.QZ(r4);
        r5 = -1;
        if (r5 == r4) goto L_0x005a;
    L_0x004f:
        r5 = com.tencent.mm.plugin.report.service.h.mEJ;
        r6 = 157; // 0x9d float:2.2E-43 double:7.76E-322;
        r8 = (long) r4;
        r10 = 1;
        r12 = 0;
        r5.a(r6, r8, r10, r12);
    L_0x005a:
        r0 = r20;
        r4 = r0.qhW;
        r4 = com.tencent.mm.sdk.platformtools.bi.oV(r4);
        r5 = com.tencent.mm.protocal.c.Ux(r4);
        if (r5 != 0) goto L_0x0089;
    L_0x0068:
        r4 = "MicroMsg.MsgHandler";
        r5 = "unknown function = %s";
        r6 = 1;
        r6 = new java.lang.Object[r6];
        r7 = 0;
        r0 = r20;
        r8 = r0.qhW;
        r6[r7] = r8;
        com.tencent.mm.sdk.platformtools.x.e(r4, r5, r6);
        r4 = "system:function_not_exist";
        r5 = 0;
        r6 = 1;
        r0 = r20;
        r1 = r21;
        r0.a(r1, r4, r5, r6);
        r4 = 1;
    L_0x0088:
        return r4;
    L_0x0089:
        r4 = r5.getName();
        r6 = "recordHistory";
        if (r4 != r6) goto L_0x00b3;
    L_0x0092:
        r4 = "MicroMsg.MsgHandler";
        r6 = "handleMsg access denied func: %s";
        r7 = 1;
        r7 = new java.lang.Object[r7];
        r8 = 0;
        r5 = r5.getName();
        r7[r8] = r5;
        com.tencent.mm.sdk.platformtools.x.e(r4, r6, r7);
        r4 = "system:access_denied";
        r5 = 0;
        r6 = 1;
        r0 = r20;
        r1 = r21;
        r0.a(r1, r4, r5, r6);
        r4 = 1;
        goto L_0x0088;
    L_0x00b3:
        r4 = r5.getName();
        r0 = r20;
        r6 = r0.jGy;
        r4 = r6.contains(r4);
        if (r4 != 0) goto L_0x00ee;
    L_0x00c1:
        r4 = r5.cfY();
        r0 = r22;
        r4 = r0.CB(r4);
        if (r4 != 0) goto L_0x00ee;
    L_0x00cd:
        r4 = "MicroMsg.MsgHandler";
        r6 = "handleMsg access denied func: %s";
        r7 = 1;
        r7 = new java.lang.Object[r7];
        r8 = 0;
        r5 = r5.getName();
        r7[r8] = r5;
        com.tencent.mm.sdk.platformtools.x.e(r4, r6, r7);
        r4 = "system:access_denied";
        r5 = 0;
        r6 = 1;
        r0 = r20;
        r1 = r21;
        r0.a(r1, r4, r5, r6);
        r4 = 1;
        goto L_0x0088;
    L_0x00ee:
        r4 = new com.tencent.mm.plugin.webview.ui.tools.jsapi.g$1;	 Catch:{ Exception -> 0x0169 }
        r0 = r20;
        r1 = r21;
        r2 = r22;
        r4.<init>(r0, r1, r2, r5);	 Catch:{ Exception -> 0x0169 }
        r0 = r20;
        r0 = r0.qic;	 Catch:{ Exception -> 0x0169 }
        r18 = r0;
        r0 = r20;
        r6 = r0.pRY;	 Catch:{ Exception -> 0x0169 }
        r7 = r6.getCurrentUrl();	 Catch:{ Exception -> 0x0169 }
        r5 = r5.cfY();	 Catch:{ Exception -> 0x0169 }
        r0 = r21;
        r9 = r0.qkl;	 Catch:{ Exception -> 0x0169 }
        r6 = com.tencent.mm.sdk.platformtools.bi.oW(r9);	 Catch:{ Exception -> 0x0169 }
        if (r6 == 0) goto L_0x0133;
    L_0x0115:
        r5 = "MicroMsg.webview.JSVerifyHelper";
        r6 = "jsapi is null, %s";
        r8 = 1;
        r8 = new java.lang.Object[r8];	 Catch:{ Exception -> 0x0169 }
        r9 = 0;
        r8[r9] = r7;	 Catch:{ Exception -> 0x0169 }
        com.tencent.mm.sdk.platformtools.x.e(r5, r6, r8);	 Catch:{ Exception -> 0x0169 }
        r5 = com.tencent.mm.plugin.webview.ui.tools.jsapi.c.a.a.RET_ACCESS_DENIED;	 Catch:{ Exception -> 0x0169 }
        r6 = 0;
        r7 = 0;
        r8 = 0;
        r9 = 0;
        r4.a(r5, r6, r7, r8, r9);	 Catch:{ Exception -> 0x0169 }
    L_0x012d:
        r4 = r4.bXP();	 Catch:{ Exception -> 0x0169 }
        goto L_0x0088;
    L_0x0133:
        if (r22 == 0) goto L_0x0141;
    L_0x0135:
        r6 = com.tencent.mm.sdk.platformtools.bi.oW(r7);	 Catch:{ Exception -> 0x0169 }
        if (r6 != 0) goto L_0x0141;
    L_0x013b:
        r0 = r22;
        r6 = r0.qWe;	 Catch:{ Exception -> 0x0169 }
        if (r6 != 0) goto L_0x01ad;
    L_0x0141:
        r6 = "MicroMsg.webview.JSVerifyHelper";
        r8 = "handleJSVerify invalid argument, currentUrl = %s, jsapi = %s, %s";
        r5 = 3;
        r10 = new java.lang.Object[r5];	 Catch:{ Exception -> 0x0169 }
        r5 = 0;
        r10[r5] = r7;	 Catch:{ Exception -> 0x0169 }
        r5 = 1;
        r10[r5] = r9;	 Catch:{ Exception -> 0x0169 }
        r7 = 2;
        if (r22 == 0) goto L_0x01ab;
    L_0x0153:
        r5 = 1;
    L_0x0154:
        r5 = java.lang.Boolean.valueOf(r5);	 Catch:{ Exception -> 0x0169 }
        r10[r7] = r5;	 Catch:{ Exception -> 0x0169 }
        com.tencent.mm.sdk.platformtools.x.e(r6, r8, r10);	 Catch:{ Exception -> 0x0169 }
        r5 = com.tencent.mm.plugin.webview.ui.tools.jsapi.c.a.a.RET_FAIL;	 Catch:{ Exception -> 0x0169 }
        r6 = "localParameters";
        r7 = 0;
        r8 = 0;
        r9 = 0;
        r4.a(r5, r6, r7, r8, r9);	 Catch:{ Exception -> 0x0169 }
        goto L_0x012d;
    L_0x0169:
        r4 = move-exception;
        r5 = "MicroMsg.MsgHandler";
        r6 = "handleMsg excpetion %s";
        r7 = 1;
        r7 = new java.lang.Object[r7];
        r8 = 0;
        r9 = r4.getMessage();
        r7[r8] = r9;
        com.tencent.mm.sdk.platformtools.x.e(r5, r6, r7);
        r5 = "MicroMsg.MsgHandler";
        r6 = "";
        r7 = 0;
        r7 = new java.lang.Object[r7];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r5, r4, r6, r7);
    L_0x0189:
        r4 = "MicroMsg.MsgHandler";
        r5 = new java.lang.StringBuilder;
        r6 = "unknown type = ";
        r5.<init>(r6);
        r0 = r21;
        r6 = r0.type;
        r5 = r5.append(r6);
        r5 = r5.toString();
        com.tencent.mm.sdk.platformtools.x.e(r4, r5);
        r4 = 0;
        r0 = r20;
        r0.iKs = r4;
        r4 = 0;
        goto L_0x0088;
    L_0x01ab:
        r5 = 0;
        goto L_0x0154;
    L_0x01ad:
        r0 = r22;
        r17 = r0.CB(r5);	 Catch:{ Exception -> 0x0169 }
        r6 = "MicroMsg.webview.JSVerifyHelper";
        r8 = "handleJSVerify jsApi = %s, permission pos = %d, permission = %s currentUrl = %s";
        r10 = 4;
        r10 = new java.lang.Object[r10];	 Catch:{ Exception -> 0x0169 }
        r11 = 0;
        r10[r11] = r9;	 Catch:{ Exception -> 0x0169 }
        r11 = 1;
        r5 = java.lang.Integer.valueOf(r5);	 Catch:{ Exception -> 0x0169 }
        r10[r11] = r5;	 Catch:{ Exception -> 0x0169 }
        r5 = 2;
        r11 = java.lang.Integer.valueOf(r17);	 Catch:{ Exception -> 0x0169 }
        r10[r5] = r11;	 Catch:{ Exception -> 0x0169 }
        r5 = 3;
        r10[r5] = r7;	 Catch:{ Exception -> 0x0169 }
        com.tencent.mm.sdk.platformtools.x.i(r6, r8, r10);	 Catch:{ Exception -> 0x0169 }
        r0 = r18;
        r5 = r0.qgY;	 Catch:{ Exception -> 0x0169 }
        r5 = r5.get(r7);	 Catch:{ Exception -> 0x0169 }
        r5 = (java.lang.String) r5;	 Catch:{ Exception -> 0x0169 }
        r6 = com.tencent.mm.sdk.platformtools.bi.oW(r5);	 Catch:{ Exception -> 0x0169 }
        if (r6 == 0) goto L_0x03b8;
    L_0x01e3:
        r0 = r21;
        r5 = r0.mcy;	 Catch:{ Exception -> 0x0169 }
        r6 = "verifyAppId";
        r5 = r5.get(r6);	 Catch:{ Exception -> 0x0169 }
        r5 = (java.lang.String) r5;	 Catch:{ Exception -> 0x0169 }
        r14 = r5;
    L_0x01f1:
        r0 = r21;
        r5 = r0.qkk;	 Catch:{ Exception -> 0x0169 }
        r6 = "permissionValue";
        r8 = java.lang.Integer.valueOf(r17);	 Catch:{ Exception -> 0x0169 }
        r5.put(r6, r8);	 Catch:{ Exception -> 0x0169 }
        r6 = "appId";
        r5.put(r6, r14);	 Catch:{ Exception -> 0x0169 }
        switch(r17) {
            case 0: goto L_0x0257;
            case 1: goto L_0x022d;
            case 2: goto L_0x0238;
            case 3: goto L_0x028f;
            case 4: goto L_0x0262;
            default: goto L_0x0208;
        };	 Catch:{ Exception -> 0x0169 }
    L_0x0208:
        r5 = com.tencent.mm.plugin.webview.ui.tools.jsapi.c.a.a.RET_FAIL;	 Catch:{ Exception -> 0x0169 }
        r6 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0169 }
        r7 = "unkonwPermission_";
        r6.<init>(r7);	 Catch:{ Exception -> 0x0169 }
        r0 = r17;
        r6 = r6.append(r0);	 Catch:{ Exception -> 0x0169 }
        r6 = r6.toString();	 Catch:{ Exception -> 0x0169 }
        r7 = 0;
        r8 = 0;
        r9 = 0;
        r4.a(r5, r6, r7, r8, r9);	 Catch:{ Exception -> 0x0169 }
        r5 = "MicroMsg.webview.JSVerifyHelper";
        r6 = "unknow permission";
        com.tencent.mm.sdk.platformtools.x.e(r5, r6);	 Catch:{ Exception -> 0x0169 }
        goto L_0x012d;
    L_0x022d:
        r5 = com.tencent.mm.plugin.webview.ui.tools.jsapi.c.a.a.RET_OK;	 Catch:{ Exception -> 0x0169 }
        r6 = 0;
        r7 = 0;
        r8 = 0;
        r9 = 0;
        r4.a(r5, r6, r7, r8, r9);	 Catch:{ Exception -> 0x0169 }
        goto L_0x012d;
    L_0x0238:
        r5 = "preVerifyJSAPI";
        r5 = r9.equals(r5);	 Catch:{ Exception -> 0x0169 }
        if (r5 == 0) goto L_0x024c;
    L_0x0241:
        r5 = com.tencent.mm.plugin.webview.ui.tools.jsapi.c.a.a.RET_OK;	 Catch:{ Exception -> 0x0169 }
        r6 = 0;
        r7 = 0;
        r8 = 0;
        r9 = 0;
        r4.a(r5, r6, r7, r8, r9);	 Catch:{ Exception -> 0x0169 }
        goto L_0x012d;
    L_0x024c:
        r5 = com.tencent.mm.plugin.webview.ui.tools.jsapi.c.a.a.RET_ACCESS_DENIED;	 Catch:{ Exception -> 0x0169 }
        r6 = 0;
        r7 = 0;
        r8 = 0;
        r9 = 0;
        r4.a(r5, r6, r7, r8, r9);	 Catch:{ Exception -> 0x0169 }
        goto L_0x012d;
    L_0x0257:
        r5 = com.tencent.mm.plugin.webview.ui.tools.jsapi.c.a.a.RET_ACCESS_DENIED;	 Catch:{ Exception -> 0x0169 }
        r6 = 0;
        r7 = 0;
        r8 = 0;
        r9 = 0;
        r4.a(r5, r6, r7, r8, r9);	 Catch:{ Exception -> 0x0169 }
        goto L_0x012d;
    L_0x0262:
        r0 = r18;
        r5 = r0.qgX;	 Catch:{ Exception -> 0x0169 }
        r6 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0169 }
        r6.<init>();	 Catch:{ Exception -> 0x0169 }
        r6 = r6.append(r9);	 Catch:{ Exception -> 0x0169 }
        r6 = r6.append(r7);	 Catch:{ Exception -> 0x0169 }
        r6 = r6.toString();	 Catch:{ Exception -> 0x0169 }
        r5 = r5.get(r6);	 Catch:{ Exception -> 0x0169 }
        r5 = (com.tencent.mm.protocal.c.aoc) r5;	 Catch:{ Exception -> 0x0169 }
        if (r5 == 0) goto L_0x028f;
    L_0x027f:
        r5 = r5.reL;	 Catch:{ Exception -> 0x0169 }
        r6 = 1;
        if (r5 != r6) goto L_0x028f;
    L_0x0284:
        r5 = com.tencent.mm.plugin.webview.ui.tools.jsapi.c.a.a.RET_OK;	 Catch:{ Exception -> 0x0169 }
        r6 = 0;
        r7 = 0;
        r8 = 0;
        r9 = 0;
        r4.a(r5, r6, r7, r8, r9);	 Catch:{ Exception -> 0x0169 }
        goto L_0x012d;
    L_0x028f:
        r0 = r21;
        r5 = r0.mcy;	 Catch:{ Exception -> 0x0169 }
        r6 = "verifySignature";
        r5 = r5.get(r6);	 Catch:{ Exception -> 0x0169 }
        r5 = (java.lang.String) r5;	 Catch:{ Exception -> 0x0169 }
        r0 = r21;
        r6 = r0.mcy;	 Catch:{ Exception -> 0x0169 }
        r8 = "verifyNonceStr";
        r6 = r6.get(r8);	 Catch:{ Exception -> 0x0169 }
        r6 = (java.lang.String) r6;	 Catch:{ Exception -> 0x0169 }
        r0 = r21;
        r8 = r0.mcy;	 Catch:{ Exception -> 0x0169 }
        r10 = "verifyTimestamp";
        r8 = r8.get(r10);	 Catch:{ Exception -> 0x0169 }
        r0 = r8;
        r0 = (java.lang.String) r0;	 Catch:{ Exception -> 0x0169 }
        r10 = r0;
        r0 = r21;
        r8 = r0.mcy;	 Catch:{ Exception -> 0x0169 }
        r11 = "verifySignType";
        r8 = r8.get(r11);	 Catch:{ Exception -> 0x0169 }
        r0 = r8;
        r0 = (java.lang.String) r0;	 Catch:{ Exception -> 0x0169 }
        r13 = r0;
        r0 = r21;
        r8 = r0.mcy;	 Catch:{ Exception -> 0x0169 }
        r11 = "scope";
        r16 = r8.get(r11);	 Catch:{ Exception -> 0x0169 }
        r16 = (java.lang.String) r16;	 Catch:{ Exception -> 0x0169 }
        r0 = r21;
        r8 = r0.mcy;	 Catch:{ Exception -> 0x0169 }
        r11 = "addrSign";
        r8 = r8.get(r11);	 Catch:{ Exception -> 0x0169 }
        r8 = (java.lang.String) r8;	 Catch:{ Exception -> 0x0169 }
        r11 = "MicroMsg.webview.JSVerifyHelper";
        r12 = "handleJSVerify addrSign = %s, signature = %s";
        r15 = 2;
        r15 = new java.lang.Object[r15];	 Catch:{ Exception -> 0x0169 }
        r19 = 0;
        r15[r19] = r8;	 Catch:{ Exception -> 0x0169 }
        r19 = 1;
        r15[r19] = r5;	 Catch:{ Exception -> 0x0169 }
        com.tencent.mm.sdk.platformtools.x.i(r11, r12, r15);	 Catch:{ Exception -> 0x0169 }
        r15 = 0;
        r11 = com.tencent.mm.sdk.platformtools.bi.oW(r5);	 Catch:{ Exception -> 0x0169 }
        if (r11 == 0) goto L_0x0385;
    L_0x02fc:
        r8 = com.tencent.mm.sdk.platformtools.bi.oW(r8);	 Catch:{ Exception -> 0x0169 }
        if (r8 != 0) goto L_0x0385;
    L_0x0302:
        r15 = 1;
        r0 = r21;
        r5 = r0.mcy;	 Catch:{ Exception -> 0x0169 }
        r6 = "appId";
        r5 = r5.get(r6);	 Catch:{ Exception -> 0x0169 }
        r5 = (java.lang.String) r5;	 Catch:{ Exception -> 0x0169 }
        r0 = r21;
        r6 = r0.mcy;	 Catch:{ Exception -> 0x0169 }
        r8 = "addrSign";
        r6 = r6.get(r8);	 Catch:{ Exception -> 0x0169 }
        r6 = (java.lang.String) r6;	 Catch:{ Exception -> 0x0169 }
        r0 = r21;
        r8 = r0.mcy;	 Catch:{ Exception -> 0x0169 }
        r10 = "signType";
        r8 = r8.get(r10);	 Catch:{ Exception -> 0x0169 }
        r0 = r8;
        r0 = (java.lang.String) r0;	 Catch:{ Exception -> 0x0169 }
        r13 = r0;
        r0 = r21;
        r8 = r0.mcy;	 Catch:{ Exception -> 0x0169 }
        r10 = "timeStamp";
        r8 = r8.get(r10);	 Catch:{ Exception -> 0x0169 }
        r0 = r8;
        r0 = (java.lang.String) r0;	 Catch:{ Exception -> 0x0169 }
        r10 = r0;
        r0 = r21;
        r8 = r0.mcy;	 Catch:{ Exception -> 0x0169 }
        r11 = "nonceStr";
        r8 = r8.get(r11);	 Catch:{ Exception -> 0x0169 }
        r0 = r8;
        r0 = (java.lang.String) r0;	 Catch:{ Exception -> 0x0169 }
        r11 = r0;
        r12 = r6;
        r8 = r5;
    L_0x034c:
        r14 = 0;
        r0 = r21;
        r5 = r0.mcy;	 Catch:{ Exception -> 0x0169 }
        r5 = com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a.V(r5);	 Catch:{ Exception -> 0x0169 }
        if (r5 == 0) goto L_0x035f;
    L_0x0357:
        r5 = r5.toString();	 Catch:{ Exception -> 0x0169 }
        r14 = r5.getBytes();	 Catch:{ Exception -> 0x0169 }
    L_0x035f:
        r5 = 4;
        r0 = r17;
        if (r0 != r5) goto L_0x0390;
    L_0x0364:
        r5 = new com.tencent.mm.plugin.webview.model.m;	 Catch:{ Exception -> 0x0169 }
        r0 = r18;
        r0 = r0.pRn;	 Catch:{ Exception -> 0x0169 }
        r17 = r0;
        r6 = r4;
        r5.<init>(r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17);	 Catch:{ Exception -> 0x0169 }
        r6 = com.tencent.mm.model.au.DF();	 Catch:{ Exception -> 0x0169 }
        r7 = 1095; // 0x447 float:1.534E-42 double:5.41E-321;
        r0 = r18;
        r6.a(r7, r0);	 Catch:{ Exception -> 0x0169 }
        r6 = com.tencent.mm.model.au.DF();	 Catch:{ Exception -> 0x0169 }
        r7 = 0;
        r6.a(r5, r7);	 Catch:{ Exception -> 0x0169 }
        goto L_0x012d;
    L_0x0385:
        r8 = com.tencent.mm.sdk.platformtools.bi.oW(r5);	 Catch:{ Exception -> 0x0169 }
        if (r8 != 0) goto L_0x03b4;
    L_0x038b:
        r15 = 2;
        r11 = r6;
        r12 = r5;
        r8 = r14;
        goto L_0x034c;
    L_0x0390:
        r5 = 3;
        r0 = r17;
        if (r0 != r5) goto L_0x0208;
    L_0x0395:
        r5 = new com.tencent.mm.plugin.webview.model.o;	 Catch:{ Exception -> 0x0169 }
        r0 = r18;
        r15 = r0.pRn;	 Catch:{ Exception -> 0x0169 }
        r6 = r4;
        r5.<init>(r6, r7, r8, r9, r10, r11, r12, r13, r14, r15);	 Catch:{ Exception -> 0x0169 }
        r6 = com.tencent.mm.model.au.DF();	 Catch:{ Exception -> 0x0169 }
        r7 = 1094; // 0x446 float:1.533E-42 double:5.405E-321;
        r0 = r18;
        r6.a(r7, r0);	 Catch:{ Exception -> 0x0169 }
        r6 = com.tencent.mm.model.au.DF();	 Catch:{ Exception -> 0x0169 }
        r7 = 0;
        r6.a(r5, r7);	 Catch:{ Exception -> 0x0169 }
        goto L_0x012d;
    L_0x03b4:
        r11 = r6;
        r12 = r5;
        r8 = r14;
        goto L_0x034c;
    L_0x03b8:
        r14 = r5;
        goto L_0x01f1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.webview.ui.tools.jsapi.g.a(com.tencent.mm.plugin.webview.ui.tools.jsapi.i, com.tencent.mm.protocal.JsapiPermissionWrapper):boolean");
    }

    private boolean b(final i iVar) {
        x.d("MicroMsg.MsgHandler", "doShowDatePicker");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            String format;
            String str;
            String str2;
            String str3 = (String) iVar.mcy.get("current");
            if (bi.oW(str3)) {
                format = simpleDateFormat.format(Long.valueOf(System.currentTimeMillis()));
            } else {
                format = str3;
            }
            str3 = (String) iVar.mcy.get("range");
            if (bi.oW(str3)) {
                str = null;
                str2 = null;
            } else {
                JSONObject jSONObject = new JSONObject(str3);
                String optString = jSONObject.optString("start", "2013-01-01");
                str = jSONObject.optString("end", format);
                str2 = optString;
            }
            str3 = (String) iVar.mcy.get("fields");
            if (bi.oW(str3)) {
                str3 = "month";
            }
            Calendar instance = Calendar.getInstance();
            instance.setTime(simpleDateFormat.parse(format));
            if (this.context == null || !(this.context instanceof Activity)) {
                x.e("MicroMsg.MsgHandler", "context error!");
                return false;
            }
            boolean z;
            boolean z2;
            com.tencent.mm.ui.widget.picker.a aVar = new com.tencent.mm.ui.widget.picker.a(this.context);
            aVar.ao(instance.get(1), instance.get(2) + 1, instance.get(5));
            if (str3.equals("year")) {
                z = false;
                z2 = false;
            } else if (str3.equals("month")) {
                z = false;
                z2 = true;
            } else {
                z = true;
                z2 = true;
            }
            aVar.Z(z2, z);
            String[] split = str2.split("-");
            if (split.length >= 3) {
                aVar.ap(bi.getInt(split[0], 0), bi.getInt(split[1], 0), bi.getInt(split[2], 0));
            }
            split = str.split("-");
            if (split.length >= 3) {
                aVar.aq(bi.getInt(split[0], 0), bi.getInt(split[1], 0), bi.getInt(split[2], 0));
            }
            aVar.uLe = new com.tencent.mm.ui.widget.picker.a.a() {
                public final void a(boolean z, int i, int i2, int i3) {
                    x.i("MicroMsg.MsgHandler", "date set: %d, %d, %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
                    if (z) {
                        Map hashMap = new HashMap();
                        hashMap.put("selectTime", String.format("%d-%d-%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)}));
                        g.this.a(iVar, "showDatePickerView:ok", hashMap);
                        return;
                    }
                    x.i("MicroMsg.MsgHandler", "cancel date set");
                    g.this.a(iVar, "showDatePickerView:cancel", null);
                }
            };
            aVar.show();
            return true;
        } catch (JSONException e) {
        } catch (ParseException e2) {
        }
    }

    private boolean c(i iVar) {
        try {
            String str = (String) this.qhP.mcy.get("link");
            l.a(this.qhP.qkk, RM(com.tencent.mm.plugin.appbrand.jsapi.share.e.NAME), str, null);
            if (str == null || str.length() == 0) {
                x.e("MicroMsg.MsgHandler", "naerCheckIn fail, link is null");
                a(this.qhP, "timeline_check_in:fail", null);
                return true;
            }
            int intValue;
            truncate((String) this.qhP.mcy.get("desc"));
            x.i("MicroMsg.MsgHandler", "naerCheckIn, img_url = " + ((String) this.qhP.mcy.get("img_url")) + ", title = " + ((String) this.qhP.mcy.get("title")) + ", desc = " + ((String) this.qhP.mcy.get("desc")));
            str = (String) this.qhP.mcy.get("img_width");
            String str2 = (String) this.qhP.mcy.get("img_height");
            x.i("MicroMsg.MsgHandler", "naerCheckIn, rawUrl:[%s], shareUrl:[%s]", new Object[]{(String) this.qhP.mcy.get("link"), al.Dp((String) this.qhP.mcy.get("link"))});
            String str3 = (String) this.qhP.mcy.get(DownloadSettingTable$Columns.TYPE);
            this.qhP.mcy.get("desc");
            String str4 = (String) this.qhP.mcy.get("title");
            String str5 = (String) this.qhP.mcy.get("img_url");
            try {
                intValue = Integer.valueOf(str).intValue();
                try {
                    Integer.valueOf(str2);
                } catch (Exception e) {
                }
            } catch (Exception e2) {
                intValue = -1;
            }
            Intent intent = new Intent();
            intent.putExtra("Ksnsupload_width", intValue);
            intent.putExtra("Ksnsupload_height", intValue);
            intent.putExtra("Ksnsupload_link", r8);
            intent.putExtra("Ksnsupload_title", str4);
            intent.putExtra("Ksnsupload_imgurl", str5);
            intent.putExtra("Ksnsupload_type", 1);
            if (!bi.oW(str3) && str3.equals("music")) {
                intent.putExtra("ksnsis_music", true);
            }
            if (!bi.oW(str3) && str3.equals("video")) {
                intent.putExtra("ksnsis_video", true);
            }
            str = (String) this.qhP.mcy.get("poiId");
            str2 = (String) this.qhP.mcy.get("poiName");
            str3 = (String) this.qhP.mcy.get("poiAddress");
            float f = bi.getFloat((String) iVar.mcy.get("latitude"), 0.0f);
            float f2 = bi.getFloat((String) iVar.mcy.get("longitude"), 0.0f);
            intent.putExtra("kpoi_id", str);
            intent.putExtra("kpoi_name", str2);
            intent.putExtra("Kpoi_address", str3);
            intent.putExtra("k_lat", f);
            intent.putExtra("k_lng", f2);
            com.tencent.mm.bg.d.b(this.context, "sns", ".ui.SnsUploadUI", intent);
            this.iKs = false;
            return false;
        } catch (Exception e3) {
            return true;
        }
    }

    private boolean d(i iVar) {
        int i = 0;
        try {
            float f = bi.getFloat((String) iVar.mcy.get("latitude"), 0.0f);
            float f2 = bi.getFloat((String) iVar.mcy.get("longitude"), 0.0f);
            String vS = vS((String) iVar.mcy.get("name"));
            String vS2 = vS((String) iVar.mcy.get("address"));
            String vS3 = vS((String) iVar.mcy.get("infoUrl"));
            try {
                i = bi.getInt((String) iVar.mcy.get("scale"), 0);
            } catch (Exception e) {
            }
            Intent intent = new Intent();
            if (bi.getInt((String) this.qhP.mcy.get("webview_scene"), 0) == 25) {
                intent.putExtra("map_view_type", 9);
                intent.putExtra("kPoi_url", vS3);
            } else {
                intent.putExtra("map_view_type", 7);
            }
            intent.putExtra("kwebmap_slat", (double) f);
            intent.putExtra("kwebmap_lng", (double) f2);
            if (i > 0) {
                intent.putExtra("kwebmap_scale", i);
            }
            intent.putExtra("kPoiName", vS);
            intent.putExtra("Kwebmap_locaion", vS2);
            com.tencent.mm.bg.d.b(this.context, "location", ".ui.RedirectUI", intent);
            a(this.qhP, "open_location:ok", null);
        } catch (Exception e2) {
            a(this.qhP, "open_location:invalid_coordinate", null);
        }
        return true;
    }

    private static String vS(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        int length = str.length();
        int i = 0;
        while (i < length) {
            int i2 = 0;
            while (i2 < gBx.length) {
                String str2 = gBy[i2];
                int i3 = 0;
                while (i3 < str2.length() && i + i3 < length && str2.charAt(i3) == str.charAt(i + i3)) {
                    i3++;
                }
                if (i3 == str2.length()) {
                    break;
                }
                i2++;
            }
            if (i2 != gBx.length) {
                stringBuffer.append(gBx[i2]);
                i = gBy[i2].length() + i;
            } else {
                stringBuffer.append(str.charAt(i));
                i++;
            }
        }
        return stringBuffer.toString();
    }

    private boolean e(i iVar) {
        try {
            String str = (String) iVar.mcy.get("bid");
            Intent intent = new Intent();
            intent.putExtra("sns_bid", str);
            com.tencent.mm.bg.d.b(this.context, "sns", ".ui.ClassifyTimeLineUI", intent);
            a(this.qhP, "open_timeline_checkin_list:ok", null);
        } catch (Exception e) {
        }
        return true;
    }

    private boolean b(i iVar, JsapiPermissionWrapper jsapiPermissionWrapper) {
        this.bSg = f(iVar);
        if (this.bSg == null) {
            x.e("MicroMsg.MsgHandler", "doSendAppMsg fail, appmsg is null");
            a(iVar, "send_app_msg:fail", null);
            return true;
        }
        String string = bYa().getString("scene");
        bYa().remove("scene");
        if (!"friend".equals(string)) {
            l.a(iVar.qkk, RM("sendAppMessage"), null, (String) iVar.mcy.get("appid"));
        }
        x.i("MicroMsg.MsgHandler", "send appmsg scene is '%s'", new Object[]{string});
        String string2;
        Intent intent;
        if ("connector".equals(string)) {
            x.i("MicroMsg.MsgHandler", "directly send to %s", new Object[]{bYb()});
            b(1, -1, new Intent().putExtra("Select_Conv_User", string2));
        } else if ("favorite".equals(string)) {
            x.i("MicroMsg.MsgHandler", "favorite url");
            ch chVar = new ch();
            com.tencent.mm.plugin.webview.model.c.a aVar = new com.tencent.mm.plugin.webview.model.c.a();
            x.i("MicroMsg.MsgHandler", "rawurl:[%s], shareurl:[%s]", new Object[]{(String) this.qhP.mcy.get("link"), al.Dp((String) this.qhP.mcy.get("link"))});
            aVar.url = r4;
            aVar.thumbUrl = (String) this.qhP.mcy.get("img_url");
            aVar.title = (String) this.qhP.mcy.get("title");
            aVar.desc = (String) this.qhP.mcy.get("desc");
            aVar.bPS = (String) this.qhP.mcy.get("appid");
            if (this.qhS != null) {
                string2 = this.qhS.getString("key_snsad_statextstr");
                aVar.bZN = string2;
            } else {
                string2 = null;
            }
            try {
                Bundle g = this.pRY.g(18, null);
                if (g != null) {
                    String ic = u.ic(bi.oV(g.getString("KPublisherId")));
                    u.b v = u.Hx().v(ic, true);
                    v.p("sendAppMsgScene", Integer.valueOf(2));
                    v.p("preChatName", g.getString("preChatName"));
                    v.p("preMsgIndex", Integer.valueOf(g.getInt("preMsgIndex")));
                    v.p("prePublishId", g.getString("prePublishId"));
                    v.p("preUsername", g.getString("preUsername"));
                    v.p("getA8KeyScene", Integer.valueOf(g.getInt("getA8KeyScene")));
                    v.p("referUrl", g.getString("referUrl"));
                    if (!bi.oW(string2)) {
                        v.p("adExtStr", string2);
                    }
                    chVar.bJF.bJK = ic;
                }
            } catch (RemoteException e) {
                x.e("MicroMsg.MsgHandler", "try to report error, %s", new Object[]{e});
            }
            if (this.context instanceof Activity) {
                chVar.bJF.activity = (Activity) this.context;
                chVar.bJF.bJM = 36;
                try {
                    Object obj = this.qhP.mcy.get("KPublisherId");
                    if (obj != null) {
                        if (obj.toString().startsWith("wrd")) {
                            chVar.bJF.scene = 2;
                        } else if (obj.toString().startsWith("gs")) {
                            chVar.bJF.scene = 3;
                        }
                    }
                } catch (Exception e2) {
                }
            }
            com.tencent.mm.plugin.webview.model.c.a(chVar, aVar);
            chVar.bJF.bJO = new 67(this);
            com.tencent.mm.sdk.b.a.sFg.m(chVar);
            if (chVar.bJG.ret == 0) {
                em(3, 1);
                try {
                    a(aVar.bPS, aVar.thumbUrl, 4, this.pRY.g(85, null));
                } catch (RemoteException e3) {
                    x.e("MicroMsg.MsgHandler", "invokeAsResult error : %s", new Object[]{e3});
                }
            } else {
                em(3, 2);
                a(this.qhP, "send_fav_msg:fail", null);
            }
        } else if ("enterprise".equals(string)) {
            String bYb = bYb();
            Serializable hashMap = new HashMap();
            hashMap.put("img_url", (String) iVar.mcy.get("img_url"));
            hashMap.put("desc", (String) iVar.mcy.get("desc"));
            hashMap.put("title", (String) iVar.mcy.get("title"));
            hashMap.put("src_username", (String) iVar.mcy.get("src_username"));
            hashMap.put("src_displayname", (String) iVar.mcy.get("src_displayname"));
            x.i("MicroMsg.MsgHandler", "doSendAppMessage, img_url=%s, desc=%s, title=%s", new Object[]{(String) iVar.mcy.get("img_url"), (String) iVar.mcy.get("desc"), (String) iVar.mcy.get("title")});
            Intent intent2;
            if (com.tencent.mm.ac.f.eZ(bYb)) {
                intent2 = new Intent();
                intent2.setClassName(this.context, "com.tencent.mm.ui.bizchat.BizChatSelectConversationUI");
                intent2.putExtra("enterprise_biz_name", bYb);
                intent2.putExtra("biz_chat_scene", 1);
                intent2.putExtra("enterprise_extra_params", hashMap);
                if (this.context instanceof MMActivity) {
                    ((MMActivity) this.context).geJ = this;
                    ((MMActivity) this.context).b(this, intent2, 37);
                }
            } else if (com.tencent.mm.ac.f.kM(bYb)) {
                intent2 = new Intent();
                intent2.putExtra("enterprise_biz_name", bYb);
                intent2.putExtra("enterprise_scene", 3);
                intent2.putExtra("enterprise_extra_params", hashMap);
                if (this.context instanceof MMActivity) {
                    ((MMActivity) this.context).geJ = this;
                    com.tencent.mm.bg.d.b(this.context, "brandservice", ".ui.EnterpriseBizContactPlainListUI", intent2, 37);
                }
            }
        } else if ("wework".equals(string)) {
            aj(iVar);
        } else if ("facebook".equals(string)) {
            intent = new Intent();
            intent.putExtra("title", (String) iVar.mcy.get("title"));
            intent.putExtra("digest", (String) iVar.mcy.get("desc"));
            intent.putExtra("img", (String) iVar.mcy.get("img_url"));
            intent.putExtra("link", (String) iVar.mcy.get("link"));
            intent.setClassName(this.context, "com.tencent.mm.plugin.account.ui.ShareToFacebookRedirectUI");
            this.context.startActivity(intent);
            a(iVar, "shareQZone:ok", null);
        } else if ("qq".equals(string)) {
            ak(iVar);
        } else {
            x.i("MicroMsg.MsgHandler", "select user to send");
            Serializable hashMap2 = new HashMap();
            if (a(iVar, jsapiPermissionWrapper.gu(89))) {
                this.bSg = f(iVar);
            }
            if (jsapiPermissionWrapper.gu(290)) {
                this.qhP.mcy.put("share_callback_with_scene", Boolean.valueOf(true));
            } else {
                this.qhP.mcy.put("share_callback_with_scene", Boolean.valueOf(false));
            }
            string2 = (String) iVar.mcy.get("img_url");
            hashMap2.put("img_url", string2);
            hashMap2.put("desc", (String) iVar.mcy.get("desc"));
            hashMap2.put("title", (String) iVar.mcy.get("title"));
            hashMap2.put(TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_URL, (String) iVar.mcy.get(TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_URL));
            x.i("MicroMsg.MsgHandler", "doSendAppMessage, img_url=%s, desc=%s, title=%s, url=%s", new Object[]{(String) iVar.mcy.get("img_url"), (String) iVar.mcy.get("desc"), (String) iVar.mcy.get("title"), (String) iVar.mcy.get(TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_URL)});
            com.tencent.mm.plugin.report.service.h.mEJ.a(157, 5, 1, false);
            intent = new Intent();
            intent.putExtra("Select_Conv_Type", 3);
            intent.putExtra("scene_from", 2);
            intent.putExtra("mutil_select_is_ret", true);
            intent.putExtra("webview_params", hashMap2);
            intent.putExtra("Retr_Msg_Type", 2);
            if (this.context instanceof MMActivity) {
                iVar.qkk.put("Internal@AsyncReport", Boolean.valueOf(true));
                if (bi.getInt((String) iVar.mcy.get("open_from_scene"), 0) == 4) {
                    com.tencent.mm.plugin.fav.a.h.f(this.qhS.getLong("favlocalid", 0), 1, 0);
                }
                com.tencent.mm.bg.d.a((MMActivity) this.context, ".ui.transmit.SelectConversationUI", intent, 1, this);
                k.RQ(string2);
            } else {
                x.e("MicroMsg.MsgHandler", "doSendAppMessage context is not activity");
                return false;
            }
        }
        return true;
    }

    private boolean a(i iVar, boolean z) {
        Object string;
        int i;
        c$d c_d = null;
        Object obj = iVar.mcy.get("__jsapi_fw_ext_info");
        String str = (String) iVar.mcy.get("link");
        if (obj instanceof Bundle) {
            string = ((Bundle) obj).getString("__jsapi_fw_ext_info_key_current_url");
        } else {
            string = null;
        }
        c cVar = this.qic;
        if (!TextUtils.isEmpty(string)) {
            c$d c_d2 = (c$d) cVar.jJK.get(string);
            if (c_d2 == null) {
                c_d2 = (c$d) cVar.jJK.get(c.Dq(string));
            }
            c_d = c_d2;
        }
        if (TextUtils.isEmpty(str) || c_d == null || c_d.qhi == null || c_d.qhi.size() <= 0) {
            i = 0;
        } else {
            int i2;
            List<String> linkedList = new LinkedList();
            int indexOf = str.indexOf("://");
            if (indexOf == -1) {
                i2 = 1;
            } else {
                i2 = 3;
            }
            String substring = str.substring(i2 + indexOf);
            for (String str2 : c_d.qhi) {
                String str22;
                x.i("MicroMsg.MsgHandler", "now domain : %s", new Object[]{str22});
                if (!TextUtils.isEmpty(str22)) {
                    int i3;
                    int indexOf2 = str22.indexOf("://");
                    if (indexOf2 == -1) {
                        i3 = 1;
                    } else {
                        i3 = 3;
                    }
                    str22 = str22.substring(i3 + indexOf2);
                    if (!str22.contains("/")) {
                        linkedList.add(str22);
                    } else if (substring.equals(str22)) {
                        i2 = 0;
                        break;
                    } else {
                        if (!str22.endsWith("/")) {
                            str22 = str22 + "/";
                        }
                        if (substring.startsWith(str22)) {
                            i2 = 0;
                            break;
                        }
                    }
                }
            }
            boolean z2 = true;
            if (!(i2 == 0 || linkedList.isEmpty())) {
                URI create = URI.create(str);
                String host = create.getHost();
                int port = create.getPort();
                substring = host + ":" + port;
                x.i("MicroMsg.MsgHandler", "share domain : %s", new Object[]{host});
                if (!bi.oW(host)) {
                    for (String str3 : linkedList) {
                        if (host.equals(str3) || host.endsWith("." + str3) || (port != -1 && (substring.equals(str3) || substring.endsWith("." + str3)))) {
                            i = 0;
                            break;
                        }
                    }
                }
            }
            i = i2;
        }
        if (!(i == 0 && z)) {
            try {
                Bundle g = this.pRY.g(84, null);
                if (g != null) {
                    if (TextUtils.isEmpty(string)) {
                        string = al.Dp(g.getString("webview_current_url"));
                    }
                    iVar.mcy.put("img_url", "");
                    iVar.mcy.put("link", string);
                    iVar.mcy.put("desc", g.getString("webview_current_desc"));
                    iVar.mcy.put("title", g.getString("webview_current_title"));
                    return true;
                }
            } catch (RemoteException e) {
                x.e("MicroMsg.MsgHandler", "invokeAsResult error : %s", new Object[]{e});
            }
        }
        return false;
    }

    private String bYb() {
        String string = bYa().getString("connector_local_send");
        bYa().remove("connector_local_send");
        bYa().putString("connector_local_report", string);
        return string;
    }

    private String bYc() {
        String string = bYa().getString("connector_local_report");
        bYa().remove("connector_local_report");
        return string;
    }

    private static WXMediaMessage f(i iVar) {
        String str = (String) iVar.mcy.get("link");
        if (str == null || str.length() == 0) {
            x.e("MicroMsg.MsgHandler", "convert fail, link is null");
            return null;
        }
        x.i("MicroMsg.MsgHandler", "rawurl:[%s], shareurl:[%s]", new Object[]{str, al.Dp(str)});
        WXWebpageObject wXWebpageObject = new WXWebpageObject();
        wXWebpageObject.webpageUrl = r1;
        wXWebpageObject.extInfo = (String) iVar.mcy.get("review_data");
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.mediaObject = wXWebpageObject;
        wXMediaMessage.title = (String) iVar.mcy.get("title");
        wXMediaMessage.description = (String) iVar.mcy.get("desc");
        return wXMediaMessage;
    }

    private boolean g(i iVar) {
        int i = 0;
        this.iKs = false;
        String obj = iVar.mcy.get("list").toString();
        LinkedList linkedList = new LinkedList();
        try {
            JSONArray jSONArray = new JSONArray(obj);
            while (i < jSONArray.length()) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    awz awz = new awz();
                    awz.sad = optJSONObject.optInt("cmdId");
                    Object optString = optJSONObject.optString("cmdBuffer");
                    if (TextUtils.isEmpty(optString)) {
                        x.e("MicroMsg.MsgHandler", "doUxSearchOpLog cmdId " + awz.sad + " , cmdBuffer is empty");
                    } else {
                        awz.sae = new com.tencent.mm.bk.b(optString.getBytes());
                        linkedList.add(awz);
                    }
                }
                i++;
            }
        } catch (Throwable e) {
            x.e("MicroMsg.MsgHandler", bi.i(e));
        }
        if (!linkedList.isEmpty()) {
            com.tencent.mm.ab.b.a aVar = new com.tencent.mm.ab.b.a();
            aVar.dIG = new ccw();
            aVar.dIH = new ccx();
            aVar.uri = "/cgi-bin/mmux-bin/wxaapp/wxaapp_opsearch";
            aVar.dIF = 1865;
            com.tencent.mm.ab.b KT = aVar.KT();
            ((ccw) KT.dID.dIL).syy = linkedList;
            v.a(KT, new 78(this));
        }
        a(iVar, "uxSearchOpLog:succ", null);
        return true;
    }

    private boolean h(i iVar) {
        this.iKs = false;
        if (iVar.mcy.containsKey("actionSheetId")) {
            int WU = bi.WU((String) iVar.mcy.get("actionSheetId"));
            Bundle bundle = new Bundle();
            bundle.putInt("actionSheetId", WU);
            try {
                this.pRY.c(134, bundle);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.MsgHandler", e, "", new Object[0]);
            }
        }
        a(iVar, "", null);
        return true;
    }

    private boolean i(i iVar) {
        this.iKs = false;
        Bundle bundle = new Bundle();
        if (iVar.mcy.containsKey("title")) {
            bundle.putString("title", (String) iVar.mcy.get("title"));
        }
        if (iVar.mcy.containsKey("desc")) {
            bundle.putString("desc", (String) iVar.mcy.get("desc"));
        }
        if (iVar.mcy.containsKey("items")) {
            bundle.putString("items", (String) iVar.mcy.get("items"));
        }
        try {
            this.pRY.c(133, bundle);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.MsgHandler", e, "", new Object[0]);
        }
        Map hashMap = new HashMap();
        hashMap.put("actionSheetId", Integer.valueOf(bundle.getInt("actionSheetId")));
        a(iVar, iVar.qkl + ":ok", hashMap);
        return true;
    }

    public final boolean RO(String str) {
        if (str == null || str.length() == 0) {
            x.e("MicroMsg.MsgHandler", "doProfile fail, username is null");
            this.iKs = false;
            return false;
        } else if (bi.oW(str)) {
            Toast.makeText(ad.getContext(), this.context.getString(R.l.fmt_self_qrcode_getting_err, new Object[]{Integer.valueOf(3), Integer.valueOf(-1)}), 0).show();
            this.iKs = false;
            return false;
        } else {
            if (this.qhP != null) {
                l.a(this.qhP.qkk, RM("profile"), str, null);
            }
            if (au.HW()) {
                com.tencent.mm.l.a Yd;
                au.HU();
                ab Yg = com.tencent.mm.model.c.FR().Yg(str);
                if (Yg == null || ((int) Yg.dhP) <= 0) {
                    au.HU();
                    Yd = com.tencent.mm.model.c.FR().Yd(str);
                } else {
                    Yd = Yg;
                }
                Intent intent = new Intent();
                String str2 = "";
                if (!(this.qhP == null || this.qhP.mcy == null || this.qhP.mcy.get("profileReportInfo") == null)) {
                    str2 = (String) this.qhP.mcy.get("profileReportInfo");
                }
                if (!bi.oW(str2)) {
                    intent.putExtra("key_add_contact_report_info", str2);
                }
                if (this.qhS != null && this.qhS.getBoolean("KFromBizSearch")) {
                    intent.putExtra("Contact_Ext_Args", this.qhS.getBundle("KBizSearchExtArgs"));
                }
                if (Yd == null || ((int) Yd.dhP) <= 0) {
                    am.a.dBr.a(str, "", new 89(this, intent));
                    Context context = this.context;
                    this.context.getString(R.l.app_tip);
                    this.eHw = com.tencent.mm.ui.base.h.a(context, this.context.getString(R.l.app_waiting), true, new 100(this, str));
                    return true;
                }
                intent.addFlags(268435456);
                intent.putExtra("Contact_User", Yd.field_username);
                if (Yd.ckW()) {
                    int i;
                    if (this.qhS == null) {
                        i = 42;
                    } else {
                        i = this.qhS.getInt("Contact_Scene", 42);
                    }
                    com.tencent.mm.plugin.report.service.h.mEJ.k(10298, Yd.field_username + "," + i);
                    intent.putExtra("Contact_Scene", i);
                }
                if (com.tencent.mm.l.a.gd(Yd.field_type)) {
                    pc pcVar = new pc();
                    pcVar.bZW.intent = intent;
                    pcVar.bZW.username = Yd.field_username;
                    com.tencent.mm.sdk.b.a.sFg.m(pcVar);
                }
                ak(intent);
                a(this.qhP, "profile:ok", null);
                return false;
            }
            x.e("MicroMsg.MsgHandler", "doProfile, MMCore.hasCfgDefaultUin() is false");
            this.iKs = false;
            return false;
        }
    }

    private void ak(Intent intent) {
        com.tencent.mm.plugin.webview.ui.tools.d.a(intent.getExtras(), "profile", ".ui.ContactInfoUI", this.pRY, new 111(this, intent));
    }

    private boolean j(i iVar) {
        com.tencent.mm.ui.widget.a.c a;
        if (q.Hm()) {
            au.HU();
            bl Hg = com.tencent.mm.model.c.FZ().Hg("@t.qq.com");
            if (Hg == null || bi.oV(Hg.name).length() == 0) {
                a = com.tencent.mm.ui.base.h.a(this.context, R.l.wv_alert_no_weibo, R.l.app_tip, new 24(this));
                a.setCancelable(false);
                a.setOnDismissListener(new 27(this, iVar));
            } else {
                int i;
                int i2;
                String aG = bi.aG((String) iVar.mcy.get(DownloadSettingTable$Columns.TYPE), "40");
                if (aG == null || aG.length() <= 0) {
                    i = 40;
                } else {
                    try {
                        i = bi.getInt(aG, 40);
                    } catch (Exception e) {
                        i = 40;
                    }
                }
                if (i == 11 || i == 20) {
                    i2 = i;
                } else {
                    i2 = 40;
                }
                aG = (String) iVar.mcy.get("content");
                String str = (String) iVar.mcy.get(TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_URL);
                if (aG == null || aG.trim().length() == 0) {
                    aG = "";
                }
                if (str == null || str.length() == 0) {
                    x.e("MicroMsg.MsgHandler", "doWeibo fail, invalid argument, content = " + aG + ", url = " + str);
                    a(iVar, "share_weibo:fail_-2", null);
                } else {
                    l.a(iVar.qkk, RM("shareWeibo"), null, null);
                    str = al.Dp(str);
                    Intent intent = new Intent(this.context, ShareToQQWeiboUI.class);
                    intent.putExtra(DownloadSettingTable$Columns.TYPE, i2);
                    intent.putExtra("shortUrl", str);
                    intent.putExtra("content", aG);
                    if (this.context instanceof MMActivity) {
                        ((MMActivity) this.context).b(this, intent, 2);
                    }
                }
            }
        } else {
            x.e("MicroMsg.MsgHandler", "doWeibo fail, qq not binded");
            a = com.tencent.mm.ui.base.h.a(this.context, R.l.wv_alert_qq_not_bind, R.l.app_tip, new 2(this), null);
            a.setCancelable(false);
            a.setOnDismissListener(new 13(this, iVar));
        }
        return true;
    }

    private boolean c(i iVar, JsapiPermissionWrapper jsapiPermissionWrapper) {
        a(iVar, jsapiPermissionWrapper.gu(88));
        this.bSg = f(iVar);
        if (this.bSg == null) {
            x.e("MicroMsg.MsgHandler", "doTimeline fail, appmsg is null");
        }
        String str = (String) iVar.mcy.get("link");
        if (str == null || str.length() == 0) {
            x.e("MicroMsg.MsgHandler", "doTimeline fail, link is null");
            a(iVar, "share_timeline:fail", null);
            return true;
        }
        String str2;
        Bundle g;
        String str3 = (String) iVar.mcy.get("desc");
        if (str3 != null) {
            truncate(str3);
        }
        x.i("MicroMsg.MsgHandler", "doTimeline, img_url = " + ((String) iVar.mcy.get("img_url")) + ", title = " + ((String) iVar.mcy.get("title")) + ", desc = " + ((String) iVar.mcy.get("desc")));
        int i = 1;
        String str4 = "";
        int i2 = 0;
        if (this.qhS != null) {
            this.qhS.setClassLoader(getClass().getClassLoader());
            i = this.qhS.getInt("snsWebSource", 1);
            str4 = this.qhS.getString("jsapi_args_appid");
            i2 = bi.getInt(this.qhS.getString("urlAttribute"), 0);
            this.qhS.remove("urlAttribute");
        }
        int i3 = i2;
        int i4 = i;
        if (bi.oW(str4)) {
            str2 = (String) iVar.mcy.get("appid");
        } else {
            str2 = str4;
        }
        l.a(iVar.qkk, RM(com.tencent.mm.plugin.appbrand.jsapi.share.e.NAME), str, str2);
        str3 = (String) iVar.mcy.get("img_width");
        str4 = (String) iVar.mcy.get("img_height");
        String Dp = al.Dp((String) iVar.mcy.get("link"));
        x.i("MicroMsg.MsgHandler", "doTimeline, rawUrl:[%s], shareUrl:[%s]", new Object[]{r3, Dp});
        String str5 = (String) iVar.mcy.get(DownloadSettingTable$Columns.TYPE);
        iVar.mcy.get("desc");
        String str6 = (String) iVar.mcy.get("title");
        String str7 = (String) iVar.mcy.get("img_url");
        String str8 = (String) iVar.mcy.get("src_username");
        String str9 = (String) iVar.mcy.get("src_displayname");
        try {
            i2 = Integer.valueOf(str3).intValue();
            try {
                Integer.valueOf(str4);
            } catch (Exception e) {
            }
        } catch (Exception e2) {
            i2 = -1;
        }
        x.i("MicroMsg.MsgHandler", "doTimeline, init intent");
        Intent intent = new Intent();
        intent.putExtra("Ksnsupload_width", i2);
        intent.putExtra("Ksnsupload_height", i2);
        intent.putExtra("Ksnsupload_link", Dp);
        intent.putExtra("Ksnsupload_title", str6);
        intent.putExtra("Ksnsupload_imgurl", str7);
        intent.putExtra("Ksnsupload_contentattribute", i3);
        if (com.tencent.mm.model.s.hf(str8)) {
            intent.putExtra("src_username", str8);
            intent.putExtra("src_displayname", str9);
        }
        intent.putExtra("Ksnsupload_source", i4);
        intent.putExtra("Ksnsupload_type", 1);
        if (!bi.oW(str5) && str5.equals("music")) {
            intent.putExtra("ksnsis_music", true);
        }
        if (!bi.oW(str5) && str5.equals("video")) {
            intent.putExtra("ksnsis_video", true);
        }
        if (str2 != null && str2.length() > 0) {
            intent.putExtra("Ksnsupload_appid", str2);
        }
        str4 = "MicroMsg.MsgHandler";
        str5 = "doTimeline, init intent, jsapiArgs == null ? %b";
        Object[] objArr = new Object[1];
        objArr[0] = Boolean.valueOf(this.qhS == null);
        x.i(str4, str5, objArr);
        str3 = null;
        if (this.qhS != null) {
            str4 = this.qhS.getString("K_sns_thumb_url");
            str5 = this.qhS.getString("K_sns_raw_url");
            str6 = bi.aG(this.qhS.getString("KSnsStrId"), "");
            str7 = bi.aG(this.qhS.getString("KSnsLocalId"), "");
            str3 = this.qhS.getString("key_snsad_statextstr");
            intent.putExtra("key_snsad_statextstr", str3);
            x.i("MicroMsg.MsgHandler", "currentUrl %s contentUrl %s thumbUrl %s", new Object[]{str, str5, str4});
            if (!(str5 == null || str == null || !str5.equals(str))) {
                intent.putExtra("KlinkThumb_url", str4);
            }
            intent.putExtra("KSnsStrId", str6);
            intent.putExtra("KSnsLocalId", str7);
            Parcelable parcelable = this.qhS.getParcelable("KSnsAdTag");
            x.i("MicroMsg.MsgHandler", "doTimeline, snsAdTag : %s", new Object[]{parcelable});
            if (parcelable != null && (parcelable instanceof SnsAdClick)) {
                intent.putExtra("KsnsAdTag", (SnsAdClick) parcelable);
            }
            if (str6 != null && this.qhS.getBoolean("KFromTimeline", false)) {
                pz pzVar = new pz();
                pzVar.caF.bSZ = str6;
                pzVar.caF.bKW = str7;
                com.tencent.mm.sdk.b.a.sFg.m(pzVar);
            }
        }
        try {
            intent.putExtra("ShareUrlOriginal", this.pRY.bVl());
            g = this.pRY.g(18, null);
            intent.putExtra("KPublisherId", g == null ? "" : bi.oV(g.getString("KPublisherId")));
            str = this.pRY.getCurrentUrl();
            intent.putExtra("ShareUrlOpen", str);
            intent.putExtra("JsAppId", this.qic.RE(str));
        } catch (Throwable e3) {
            x.printErrStackTrace("MicroMsg.MsgHandler", e3, "", new Object[0]);
        }
        x.i("MicroMsg.MsgHandler", "doTimeline, start activity");
        if (this.context instanceof MMActivity) {
            intent.putExtra("need_result", true);
            try {
                g = this.pRY.g(18, null);
                if (g != null) {
                    str4 = u.ic(bi.oV(g.getString("KPublisherId")));
                    u.b v = u.Hx().v(str4, true);
                    v.p("sendAppMsgScene", Integer.valueOf(2));
                    v.p("preChatName", g.getString("preChatName"));
                    v.p("preMsgIndex", Integer.valueOf(g.getInt("preMsgIndex")));
                    v.p("prePublishId", g.getString("prePublishId"));
                    v.p("preUsername", g.getString("preUsername"));
                    v.p(TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_URL, Dp);
                    v.p("getA8KeyScene", Integer.valueOf(g.getInt("getA8KeyScene")));
                    v.p("referUrl", g.getString("referUrl"));
                    if (!bi.oW(str3)) {
                        v.p("adExtStr", str3);
                    }
                    intent.putExtra("reportSessionId", str4);
                }
            } catch (RemoteException e4) {
                x.e("MicroMsg.MsgHandler", "try to attach report args error, %s", new Object[]{e4});
            }
            ((MMActivity) this.context).geJ = this;
            com.tencent.mm.bg.d.a(this.context, "sns", ".ui.SnsUploadUI", intent, 24, false);
        }
        return true;
    }

    private boolean k(i iVar) {
        String str = (String) iVar.mcy.get("ad_info");
        String str2 = str + ",";
        String GF = q.GF();
        try {
            String str3;
            Bundle g = this.pRY.g(18, null);
            if (g != null) {
                String string = g.getString("prePublishId");
                String string2 = g.getString("preChatName");
                String string3 = g.getString("preUsername");
                str2 = str2 + string + "," + string2 + "," + string3 + "," + g.getInt("getA8KeyScene") + ",";
                if (string != null) {
                    try {
                        if (string.startsWith("msg_")) {
                            long parseLong = Long.parseLong(string.substring(4));
                            au.HU();
                            bd I = com.tencent.mm.model.c.FT().I(string2, parseLong);
                            str2 = str2 + I.getType() + "," + m.gK(I.field_talker) + "," + t.N(string3, string2) + "," + ak.bUp() + ",";
                            str3 = str2 + GF;
                            ((com.tencent.mm.plugin.sns.b.a) com.tencent.mm.kernel.g.l(com.tencent.mm.plugin.sns.b.a.class)).g(13297, str3, (int) bi.VE());
                            if (Integer.parseInt(bi.aG((String) iVar.mcy.get("need_record_page_operation"), "0")) != 0) {
                                Bundle bundle = new Bundle();
                                bundle.putString("traceid", str);
                                bundle.putString("username", GF);
                                try {
                                    this.pRY.g(90002, bundle);
                                } catch (RemoteException e) {
                                }
                            }
                            a(iVar, "adDataReport：ok", null);
                            return true;
                        }
                    } catch (Throwable e2) {
                        x.printErrStackTrace("MicroMsg.MsgHandler", e2, "", new Object[0]);
                    }
                }
                str2 = str2 + ",,,,";
                str3 = str2 + GF;
                ((com.tencent.mm.plugin.sns.b.a) com.tencent.mm.kernel.g.l(com.tencent.mm.plugin.sns.b.a.class)).g(13297, str3, (int) bi.VE());
                if (Integer.parseInt(bi.aG((String) iVar.mcy.get("need_record_page_operation"), "0")) != 0) {
                    Bundle bundle2 = new Bundle();
                    bundle2.putString("traceid", str);
                    bundle2.putString("username", GF);
                    try {
                        this.pRY.g(90002, bundle2);
                    } catch (RemoteException e3) {
                    }
                }
                a(iVar, "adDataReport：ok", null);
                return true;
            }
            str3 = str2;
            ((com.tencent.mm.plugin.sns.b.a) com.tencent.mm.kernel.g.l(com.tencent.mm.plugin.sns.b.a.class)).g(13297, str3, (int) bi.VE());
            if (Integer.parseInt(bi.aG((String) iVar.mcy.get("need_record_page_operation"), "0")) != 0) {
                Bundle bundle22 = new Bundle();
                bundle22.putString("traceid", str);
                bundle22.putString("username", GF);
                try {
                    this.pRY.g(90002, bundle22);
                } catch (RemoteException e32) {
                }
            }
            a(iVar, "adDataReport：ok", null);
        } catch (Throwable e4) {
            x.printErrStackTrace("MicroMsg.MsgHandler", e4, "", new Object[0]);
            a(iVar, "adDataReport：fail", null);
        }
        return true;
    }

    private boolean l(i iVar) {
        try {
            if (this.pRY != null) {
                Bundle g = this.pRY.g(87, null);
                if (g != null) {
                    if (bi.oV(g.getString("result")).equals("not_return")) {
                        a(iVar, "getWePkgAuthResult:fail_auth_result_not_return", null);
                    } else {
                        String string = g.getString("full_url");
                        int i = g.getInt("set_cookie");
                        if (bi.oW(string)) {
                            a(iVar, "getWePkgAuthResult:fail_full_url_empty", null);
                        } else {
                            Map hashMap = new HashMap();
                            hashMap.put("full_url", string);
                            hashMap.put("set_cookie", Integer.valueOf(i));
                            a(iVar, "getWePkgAuthResult:ok", hashMap);
                        }
                    }
                }
            }
        } catch (Exception e) {
            x.e("MicroMsg.MsgHandler", "doGetWePkgAuthResult exception, " + e.getMessage());
            a(iVar, "getWePkgAuthResult:fail", null);
        }
        return true;
    }

    private boolean m(i iVar) {
        String str = (String) iVar.mcy.get("reportId");
        boolean equals = bi.oV((String) iVar.mcy.get("reportInstantly")).equals("1");
        boolean equals2 = bi.oV((String) iVar.mcy.get("reportTimeBegin")).equals("1");
        String str2 = (String) iVar.mcy.get("reportFormatData");
        String str3 = (String) iVar.mcy.get("reportTabsFormatData");
        if (bi.oW(str)) {
            x.e("MicroMsg.MsgHandler", "reportId is null or nil");
            a(iVar, "reportGamePageTime:fail_invalid_reportId", null);
        } else if (bi.oW(str2) && bi.oW(str3)) {
            x.e("MicroMsg.MsgHandler", "reportFormatData && reportTabsFormatData is null or nil");
            a(iVar, "reportGamePageTime:fail_invalid_reportFormatData_reportTabsFormatData", null);
        } else {
            x.i("MicroMsg.MsgHandler", "reportGamePageTime, reportId:%s, reportInstantly:%b, reportTimeBegin:%b, reportFormatData:(%s), reportTabsFormatData(%s)", new Object[]{str, Boolean.valueOf(equals), Boolean.valueOf(equals2), str2, str3});
            Bundle bundle = new Bundle();
            bundle.putString("game_page_report_id", str);
            bundle.putBoolean("game_page_report_instantly", equals);
            bundle.putBoolean("game_page_report_time_begin", equals2);
            bundle.putString("game_page_report_format_data", str2);
            bundle.putString("game_page_report_tabs_format_data", str3);
            try {
                this.pRY.g(95, bundle);
                a(iVar, "reportGamePageTime:ok", null);
            } catch (Exception e) {
                x.e("MicroMsg.MsgHandler", "reportGamePageTime, exception = %s", new Object[]{e});
                a(iVar, "reportGamePageTime:fail", null);
            }
        }
        return true;
    }

    private static String truncate(String str) {
        if (str.startsWith("http://")) {
            return str.substring(7);
        }
        if (str.startsWith("https://")) {
            return str.substring(8);
        }
        return str;
    }

    private boolean n(i iVar) {
        int i = 33;
        String str = (String) iVar.mcy.get("webtype");
        String str2 = (String) iVar.mcy.get("username");
        String str3 = (String) iVar.mcy.get("scene");
        String str4 = (String) iVar.mcy.get("profileReportInfo");
        if (str == null || str.length() == 0 || str2 == null || str2.length() == 0) {
            x.e("MicroMsg.MsgHandler", "doAddContact fail, invalid arguments, webType = " + str + ", username = " + str2);
            a(iVar, "add_contact:fail", null);
            return true;
        }
        RL(str3);
        int i2 = bi.getInt(str, -1);
        if (i2 == -1) {
            x.e("MicroMsg.MsgHandler", "doAddContact fail, parseInt fail, str = " + str);
            a(iVar, "add_contact:fail", null);
            return true;
        } else if (this.context instanceof Activity) {
            l.a(iVar.qkk, false, str2, null);
            switch (i2) {
                case 1:
                    if (this.qhS != null) {
                        i = this.qhS.getInt("Contact_Scene", 33);
                    }
                    new com.tencent.mm.pluginsdk.ui.applet.b(this.context, str2, i, new 31(this, iVar), str4).show();
                    return true;
                default:
                    x.e("MicroMsg.MsgHandler", "unknown addScene = " + i2);
                    a(iVar, "add_contact:fail", null);
                    return true;
            }
        } else {
            x.e("MicroMsg.MsgHandler", "doAddContact invalid context");
            a(iVar, "add_contact:fail", null);
            return false;
        }
    }

    private boolean o(i iVar) {
        String str = (String) iVar.mcy.get("current");
        String[] strArr = (String[]) iVar.mcy.get("urls");
        ArrayList arrayList = new ArrayList();
        if (strArr == null || strArr.length == 0) {
            x.e("MicroMsg.MsgHandler", "doImgPreview fail, urls is null");
            this.iKs = false;
        } else {
            Bundle g;
            x.d("MicroMsg.MsgHandler", "doImgPreview ok");
            int i = 0;
            while (i < strArr.length) {
                if (bi.oW(strArr[i]) || strArr[i].equalsIgnoreCase("null")) {
                    x.e("MicroMsg.MsgHandler", "null url, i = %d", new Object[]{Integer.valueOf(i)});
                } else {
                    if (bi.oV(strArr[i]).startsWith("weixin://resourceid/")) {
                        strArr[i] = com.tencent.mm.plugin.webview.modeltools.e.bUX().Qq(strArr[i]).fnM;
                    }
                    arrayList.add(strArr[i]);
                }
                i++;
            }
            strArr = (String[]) arrayList.toArray(strArr);
            String[] strArr2 = (String[]) arrayList.toArray(new String[arrayList.size()]);
            if (bi.oW(str)) {
                str = strArr[0];
            } else if (str.startsWith("weixin://resourceid/")) {
                str = com.tencent.mm.plugin.webview.modeltools.e.bUX().Qq(str).fnM;
            }
            Intent intent = new Intent();
            intent.putExtra("nowUrl", str);
            intent.putExtra("urlList", strArr2);
            intent.putExtra(DownloadSettingTable$Columns.TYPE, -255);
            intent.putExtra("isFromWebView", true);
            intent.putExtra("shouldShowScanQrCodeMenu", true);
            try {
                g = this.pRY.g(90001, new Bundle());
                if (g != null) {
                    str = g.getString("cookie", null);
                    if (!bi.oW(str)) {
                        intent.putExtra("cookie", str);
                    }
                }
            } catch (Exception e) {
                x.e("MicroMsg.MsgHandler", "getCookie fail : %s", new Object[]{e.getMessage()});
            }
            if (this.context instanceof Service) {
                intent.addFlags(268435456);
            }
            g = new Bundle();
            g.putInt("stat_scene", 4);
            g.putString("stat_url", getCurrentUrl());
            intent.putExtra("_stat_obj", g);
            com.tencent.mm.plugin.webview.a.a.ezn.r(intent, this.context);
            this.iKs = false;
        }
        return false;
    }

    private boolean p(i iVar) {
        try {
            Bundle aq = i.aq(iVar.mcy);
            this.pRY.bVn();
            this.pRY.P(aq);
            String str = "";
            if (this.qhS != null) {
                this.qhS.setClassLoader(getClass().getClassLoader());
                str = this.qhS.getString("KoriginUrl");
                this.qhS.getBoolean("KIsHKAgreeUrl");
            }
            tw twVar = new tw();
            twVar.cfC.cfD = str;
            com.tencent.mm.sdk.b.a.sFg.m(twVar);
        } catch (Exception e) {
            x.w("MicroMsg.MsgHandler", "doCloseWindow, ex = " + e.getMessage());
        }
        a(iVar, "close_window:ok", null);
        return true;
    }

    private void a(i iVar, int i, int i2) {
        String str = iVar.qkl;
        if (str.equals("requireSoterBiometricAuthentication") || str.equals("getSupportSoter")) {
            String rL = rL(getCurrentUrl());
            com.tencent.mm.plugin.soter.c.g gVar = com.tencent.mm.plugin.soter.c.g.onG;
            com.tencent.mm.plugin.soter.c.g.m(str, rL, i, i2);
        }
    }

    private boolean q(i iVar) {
        this.iKs = false;
        int WU = bi.WU(iVar.mcy.get("voteResultIndex").toString());
        try {
            Bundle bundle = new Bundle();
            bundle.putInt("sns_landing_pages_ad_vote_index", WU);
            this.pRY.c(150, bundle);
        } catch (Exception e) {
        }
        return false;
    }

    private boolean r(i iVar) {
        String str = (String) iVar.mcy.get("packageName");
        if (bi.oW(str)) {
            x.i("MicroMsg.MsgHandler", "packageName is null or nil");
            a(iVar, "get_install_state:no", null);
            return true;
        }
        int i;
        l.a(iVar.qkk, false, str, null);
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() > 0) {
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                Object obj = null;
                i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= jSONArray.length()) {
                        break;
                    }
                    String string = jSONArray.getString(i2);
                    PackageInfo packageInfo = com.tencent.mm.pluginsdk.model.app.p.getPackageInfo(this.context, string);
                    int i3 = packageInfo == null ? 0 : packageInfo.versionCode;
                    String str2 = packageInfo == null ? "null" : packageInfo.versionName;
                    x.i("MicroMsg.MsgHandler", "doGetInstallState, packageName = " + string + ", packageInfo = " + packageInfo + ", version = " + i3 + ", versionName = " + str2);
                    if (obj == null && i3 > 0) {
                        obj = 1;
                    }
                    jSONObject.put(string, i3);
                    jSONObject2.put(string, str2);
                    i = i2 + 1;
                }
                Map hashMap = new HashMap();
                hashMap.put("result", jSONObject);
                hashMap.put("versionName", jSONObject2);
                if (obj != null) {
                    a(iVar, "get_install_state:yes", hashMap);
                } else {
                    a(iVar, "get_install_state:no", null);
                }
                return true;
            }
        } catch (Exception e) {
            x.i("MicroMsg.MsgHandler", "it is not batch get install state");
        }
        PackageInfo packageInfo2 = com.tencent.mm.pluginsdk.model.app.p.getPackageInfo(this.context, str);
        i = packageInfo2 == null ? 0 : packageInfo2.versionCode;
        String str3 = packageInfo2 == null ? "null" : packageInfo2.versionName;
        x.i("MicroMsg.MsgHandler", "doGetInstallState, packageName = " + str + ", packageInfo = " + packageInfo2 + ", version = " + i + ", versionName = " + str3);
        if (packageInfo2 == null) {
            a(iVar, "get_install_state:no", null);
        } else {
            Map hashMap2 = new HashMap();
            hashMap2.put("versionName", str3);
            a(iVar, "get_install_state:yes_" + i, hashMap2);
        }
        return true;
    }

    private boolean s(i iVar) {
        boolean z;
        boolean z2;
        int i;
        int i2 = 0;
        String str = (String) iVar.mcy.get("desc");
        int i3 = bi.getInt((String) iVar.mcy.get("needResult"), 1);
        String str2 = (String) iVar.mcy.get("scanType");
        x.i("MicroMsg.MsgHandler", "desc : %s, scene : %d, scanType : %s", new Object[]{str, Integer.valueOf(i3), str2});
        if (bi.oW(str2)) {
            z = true;
            z2 = true;
        } else {
            z = false;
            z2 = false;
        }
        boolean z3;
        if (str2 != null) {
            try {
                JSONArray jSONArray = new JSONArray(str2);
                while (true) {
                    try {
                        z3 = z;
                        if (i2 >= jSONArray.length()) {
                            break;
                        }
                        str = (String) jSONArray.get(i2);
                        if (str.equalsIgnoreCase("qrCode")) {
                            z = z3;
                            z2 = true;
                        } else if (str.equalsIgnoreCase("barCode")) {
                            z = true;
                        } else {
                            z = z3;
                        }
                        i2++;
                    } catch (Exception e) {
                        x.e("MicroMsg.MsgHandler", "doScanQRCode, ex in scanType");
                        if (!z2) {
                        }
                        if (!z2) {
                        }
                        i = 1;
                        if (i3 == 0) {
                            x.d("MicroMsg.MsgHandler", "doScanQRCode, startActivity to GetFriendQRCodeUI");
                            r1 = new Intent();
                            r1.putExtra("BaseScanUI_select_scan_mode", i);
                            if (!(com.tencent.mm.p.a.bx(this.context) || com.tencent.mm.ax.e.Sz())) {
                                com.tencent.mm.bg.d.c(this.context, "scanner", ".ui.SingleTopScanUI", r1);
                            }
                            a(iVar, "scanQRCode:ok", null);
                        } else if (i3 == 1) {
                            r1 = new Intent();
                            r1.putExtra("BaseScanUI_select_scan_mode", i);
                            r1.putExtra("BaseScanUI_only_scan_qrcode_with_zbar", true);
                            r1.putExtra("key_is_finish_on_scanned", true);
                            r1.putExtra("GetFriendQRCodeUI.INTENT_FROM_ACTIVITY", 3);
                            if (!(com.tencent.mm.p.a.bx(this.context) || com.tencent.mm.ax.e.Sz())) {
                                WebViewStubTempUI.a(this.context, "scanner", ".ui.SingleTopScanUI", r1, this.bWo);
                            }
                        } else {
                            x.e("MicroMsg.MsgHandler", "unkown scene");
                            a(iVar, "scanQRCode:fail_invalid_scene", null);
                        }
                        return true;
                    }
                }
            } catch (Exception e2) {
                z3 = z;
            }
        } else {
            z3 = z;
        }
        if (!z2 && !z3) {
            i = 8;
        } else if (z2 || !z3) {
            i = 1;
        } else {
            i = 4;
        }
        Intent intent;
        if (i3 == 0) {
            x.d("MicroMsg.MsgHandler", "doScanQRCode, startActivity to GetFriendQRCodeUI");
            intent = new Intent();
            intent.putExtra("BaseScanUI_select_scan_mode", i);
            if (!(com.tencent.mm.p.a.bx(this.context) || com.tencent.mm.ax.e.Sz())) {
                com.tencent.mm.bg.d.c(this.context, "scanner", ".ui.SingleTopScanUI", intent);
            }
            a(iVar, "scanQRCode:ok", null);
        } else if (i3 == 1) {
            intent = new Intent();
            intent.putExtra("BaseScanUI_select_scan_mode", i);
            intent.putExtra("BaseScanUI_only_scan_qrcode_with_zbar", true);
            intent.putExtra("key_is_finish_on_scanned", true);
            intent.putExtra("GetFriendQRCodeUI.INTENT_FROM_ACTIVITY", 3);
            if (!(com.tencent.mm.p.a.bx(this.context) || com.tencent.mm.ax.e.Sz())) {
                WebViewStubTempUI.a(this.context, "scanner", ".ui.SingleTopScanUI", intent, this.bWo);
            }
        } else {
            x.e("MicroMsg.MsgHandler", "unkown scene");
            a(iVar, "scanQRCode:fail_invalid_scene", null);
        }
        return true;
    }

    private boolean t(i iVar) {
        String str = (String) iVar.mcy.get("fontSize");
        if (str == null || str.length() == 0) {
            x.e("MicroMsg.MsgHandler", "doSetFontSizeCb, fontSize is null");
            this.iKs = false;
        } else {
            x.i("MicroMsg.MsgHandler", "doSetFontSizeCb, fontSize = " + str);
            try {
                this.pRY.QM(str);
            } catch (Exception e) {
                x.w("MicroMsg.MsgHandler", "setFontSizeCb, ex = " + e.getMessage());
            }
            this.iKs = false;
        }
        return false;
    }

    private boolean u(i iVar) {
        x.d("MicroMsg.MsgHandler", "hy: doGetPayResultReq");
        if (this.context instanceof MMActivity) {
            com.tencent.mm.pluginsdk.wallet.g gVar = new com.tencent.mm.pluginsdk.wallet.g(iVar.mcy);
            lp lpVar = new lp();
            lpVar.bVV.appId = gVar.appId;
            lpVar.bVV.partnerId = gVar.partnerId;
            lpVar.bVV.signType = gVar.signType;
            lpVar.bVV.nonceStr = gVar.nonceStr;
            lpVar.bVV.timeStamp = gVar.timeStamp;
            lpVar.bVV.packageExt = gVar.packageExt;
            lpVar.bVV.bVW = gVar.bVW;
            lpVar.bVV.url = gVar.url;
            lpVar.bVV.bVX = gVar.bVX;
            lpVar.bVV.bVY = gVar.bVY;
            lpVar.bVV.bJY = gVar.bJY;
            lpVar.bVV.bVZ = gVar.bVZ;
            com.tencent.mm.sdk.b.a.sFg.m(lpVar);
            b(21, -1, null);
        }
        l.a(iVar.qkk, false, null, (String) iVar.mcy.get("appId"));
        return true;
    }

    private boolean v(i iVar) {
        x.i("MicroMsg.MsgHandler", "doOpenProductView");
        String str = (String) iVar.mcy.get("productInfo");
        String str2 = (String) iVar.mcy.get(TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_URL);
        Integer valueOf = Integer.valueOf(0);
        try {
            valueOf = Integer.valueOf(new JSONObject(str).getInt("product_type"));
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.MsgHandler", e, "", new Object[0]);
        }
        Intent intent = new Intent();
        intent.putExtra("key_product_info", str);
        intent.putExtra("key_source_url", str2);
        return a(valueOf, 3, 0, null, intent);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean a(java.lang.Integer r7, int r8, int r9, java.lang.String r10, android.content.Intent r11) {
        /*
        r6 = this;
        r3 = 0;
        r5 = 1;
        r4 = 0;
        r0 = "key_product_scene";
        r11.putExtra(r0, r8);
        r0 = "MicroMsg.MsgHandler";
        r1 = "doOpenProductView, productType = %d";
        r2 = new java.lang.Object[r5];
        r2[r3] = r7;
        com.tencent.mm.sdk.platformtools.x.e(r0, r1, r2);
        r0 = r6.context;
        r0 = r0 instanceof com.tencent.mm.ui.MMActivity;
        if (r0 == 0) goto L_0x005a;
    L_0x001c:
        r0 = r6.context;
        r0 = (com.tencent.mm.ui.MMActivity) r0;
        r0.geJ = r6;
        r0 = r7.intValue();
        switch(r0) {
            case 0: goto L_0x0043;
            case 10000: goto L_0x0092;
            case 20000: goto L_0x0092;
            default: goto L_0x0029;
        };
    L_0x0029:
        r0 = "MicroMsg.MsgHandler";
        r1 = "doOpenProductView fail, productType = %d";
        r2 = new java.lang.Object[r5];
        r2[r3] = r7;
        com.tencent.mm.sdk.platformtools.x.e(r0, r1, r2);
        r0 = 8;
        if (r8 != r0) goto L_0x00a6;
    L_0x003a:
        r0 = r6.qhP;
        r1 = "open_product_view_with_id:fail";
        r6.a(r0, r1, r4);
    L_0x0042:
        return r5;
    L_0x0043:
        switch(r9) {
            case 0: goto L_0x0063;
            case 1: goto L_0x0077;
            default: goto L_0x0046;
        };
    L_0x0046:
        r0 = "MicroMsg.MsgHandler";
        r1 = "doOpenProductView fail, productType = %d, viewType = %d";
        r2 = 2;
        r2 = new java.lang.Object[r2];
        r2[r3] = r7;
        r3 = java.lang.Integer.valueOf(r9);
        r2[r5] = r3;
        com.tencent.mm.sdk.platformtools.x.e(r0, r1, r2);
    L_0x005a:
        r0 = r6.qhP;
        r1 = "open_product_view:fail";
        r6.a(r0, r1, r4);
        goto L_0x0042;
    L_0x0063:
        r0 = r6.context;
        r1 = "product";
        r2 = ".ui.MallProductUI";
        com.tencent.mm.bg.d.b(r0, r1, r2, r11);
        r0 = r6.qhP;
        r1 = "open_product_view:ok";
        r6.a(r0, r1, r4);
        goto L_0x0042;
    L_0x0077:
        r0 = "key_Qrcode_Url";
        r11.putExtra(r0, r10);
        r0 = "key_ProductUI_getProductInfoScene";
        r1 = 4;
        r11.putExtra(r0, r1);
        r0 = r6.context;
        r1 = "scanner";
        r2 = ".ui.ProductUI";
        r3 = 10;
        com.tencent.mm.bg.d.b(r0, r1, r2, r11, r3);
        goto L_0x0042;
    L_0x0092:
        r0 = r6.context;
        r1 = "card";
        r2 = ".ui.CardProductUI";
        com.tencent.mm.bg.d.b(r0, r1, r2, r11);
        r0 = r6.qhP;
        r1 = "open_product_view:ok";
        r6.a(r0, r1, r4);
        goto L_0x0042;
    L_0x00a6:
        r0 = r6.qhP;
        r1 = "open_product_view:fail";
        r6.a(r0, r1, r4);
        goto L_0x0042;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.webview.ui.tools.jsapi.g.a(java.lang.Integer, int, int, java.lang.String, android.content.Intent):boolean");
    }

    private boolean a(i iVar, int... iArr) {
        if (qib != -1) {
            this.qhP = a(qib).qhP;
            this.pRY = a(qib).pRY;
        }
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        if (VERSION.SDK_INT < 18) {
            a(iVar, "startMonitoringBeacons:system unsupported", null);
        } else {
            if (!(defaultAdapter == null || defaultAdapter.getState() == 12)) {
                if (defaultAdapter.getState() == 10) {
                    a(iVar, "startMonitoringBeacons:bluetooth power off", null);
                } else {
                    a(iVar, "startMonitoringBeacons:bluetooth state unknown", null);
                }
            }
            if (iArr == null || iArr.length == 0) {
                if (!this.qio.isProviderEnabled(TencentLocation.GPS_PROVIDER)) {
                    a(iVar, "startMonitoringBeacons:location service disable", null);
                }
                SensorManager sensorManager = (SensorManager) qia.getSystemService("sensor");
                sensorManager.registerListener(this.qis, sensorManager.getDefaultSensor(3), 0);
            }
            if (this.qir) {
                a(iVar, "startMonitoringBeacons:already started", null);
            } else {
                this.qir = true;
                a(iVar, "startMonitoringBeacons:ok", null);
            }
            if (!(iVar == null || iVar.mcy == null)) {
                Object obj = iVar.mcy.get("uuid");
                Object obj2 = iVar.mcy.get(TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_URL);
                Object obj3 = iVar.mcy.get("ticket");
                String obj4 = obj2 != null ? obj2.toString() : "";
                String obj5 = obj != null ? obj.toString() : "";
                com.tencent.mm.plugin.report.service.h.mEJ.h(12101, new Object[]{bi.oV(this.qic.RE(obj4)), obj4, this.qip, this.qiq, obj3 != null ? obj3.toString() : ""});
                new StringBuilder("{\"UUID\":\"").append(obj5).append("\",\"Major\":0,\"Minor\":0}");
                y yVar = new y(obj4, r4, r1);
                au.DF().a(1702, new 39(this, yVar, iVar));
                au.DF().a(yVar, 0);
            }
        }
        return true;
    }

    public final boolean b(i iVar, int... iArr) {
        if (qib != -1) {
            this.qhP = a(qib).qhP;
            this.pRY = a(qib).pRY;
        }
        if (VERSION.SDK_INT >= 18) {
            boolean a;
            com.tencent.mm.sdk.b.a.sFg.c(this.nbe);
            if (au.HX()) {
                au.HU();
                a = bi.a((Boolean) com.tencent.mm.model.c.DT().get(aa.a.sRU, null), false);
            } else {
                a = false;
            }
            for (String str : this.qij.keySet()) {
                dl dlVar = new dl();
                x.i("MicroMsg.MsgHandler", "[MsgHandler][doStopIBeaconRange]op=false,iBeacon = %s", new Object[]{str});
                dlVar.bLj.bLl = str;
                dlVar.bLj.bLi = false;
                if (!a) {
                    com.tencent.mm.sdk.b.a.sFg.m(dlVar);
                }
            }
            if (au.HX()) {
                au.HU();
                com.tencent.mm.model.c.DT().a(aa.a.sRP, Boolean.valueOf(false));
            }
            Editor edit = ad.getContext().getSharedPreferences("com.tencent.mm_exdevice_ibeacon_isNewScanning", 4).edit();
            edit.putBoolean("isNewScanning", false);
            edit.commit();
            this.qij.clear();
            this.cXp.clear();
            this.qik.clear();
            this.qil.clear();
            this.qir = false;
            if (iArr == null || iArr.length == 0) {
                a(iVar, "stopMonitoringBeacons:ok", null);
                this.qir = false;
            }
        }
        if (!(qia == null || this.qis == null)) {
            ((SensorManager) qia.getSystemService("sensor")).unregisterListener(this.qis);
        }
        return true;
    }

    private boolean bYd() {
        String currentUrl;
        x.i("MicroMsg.MsgHandler", "doGetLatestAddress JSOAUTH");
        String str = "";
        try {
            currentUrl = this.pRY.getCurrentUrl();
        } catch (Exception e) {
            x.w("MicroMsg.MsgHandler", "exception in get currentUrl %s", new Object[]{e.getMessage()});
            currentUrl = str;
        }
        final String str2 = "get_recently_used_address:";
        if (currentUrl == null) {
            a(this.qhP, str2 + "fail", null);
        } else {
            final mi miVar = new mi();
            miVar.bXa.appId = (String) this.qhP.mcy.get("appId");
            miVar.bXa.url = currentUrl;
            miVar.bXb.errCode = -119;
            miVar.bJX = new Runnable() {
                public final void run() {
                    x.i("MicroMsg.MsgHandler", "JSOAUTH errCode[%s], isAccept[%s]", new Object[]{Integer.valueOf(miVar.bXb.errCode), Boolean.valueOf(miVar.bXb.bXc)});
                    if (miVar.bXb.errCode != -119) {
                        if (miVar.bXb.errCode != 0) {
                            g.this.a(g.this.qhP, str2 + "fail", null);
                        } else if (miVar.bXb.bXc) {
                            Map hashMap = new HashMap();
                            hashMap.put("nationalCode", miVar.bXb.bXd);
                            hashMap.put("userName", miVar.bXb.userName);
                            hashMap.put("telNumber", miVar.bXb.bXe);
                            hashMap.put("addressPostalCode", miVar.bXb.bXf);
                            hashMap.put("proviceFirstStageName", miVar.bXb.bXg);
                            hashMap.put("addressCitySecondStageName", miVar.bXb.bXh);
                            hashMap.put("addressCountiesThirdStageName", miVar.bXb.bXi);
                            hashMap.put("addressDetailInfo", miVar.bXb.bXj);
                            g.this.a(g.this.qhP, str2 + "ok", hashMap);
                        } else {
                            g.this.a(g.this.qhP, str2 + "cancel", null);
                        }
                    }
                }
            };
            com.tencent.mm.sdk.b.a.sFg.a(miVar, Looper.getMainLooper());
        }
        return true;
    }

    private boolean w(i iVar) {
        l.a(iVar.qkk, RM("sendEmail"), null, null);
        String str = (String) iVar.mcy.get("title");
        String str2 = "";
        try {
            str2 = al.Dp(this.pRY.getCurrentUrl());
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.MsgHandler", e, "", new Object[0]);
        }
        Intent intent = new Intent();
        intent.putExtra("composeType", 1);
        intent.putExtra("subject", str);
        intent.putExtra("mail_content", str2);
        com.tencent.mm.bg.d.c(this.context, "qqmail", ".ui.ComposeUI", intent);
        a(iVar, "send_email:ok", null);
        return true;
    }

    private boolean x(i iVar) {
        com.tencent.mm.plugin.report.service.h.mEJ.a(157, 27, 1, false);
        String str = (String) iVar.mcy.get("task_name");
        String str2 = (String) iVar.mcy.get("task_url");
        String str3 = (String) iVar.mcy.get("alternative_url");
        long j = bi.getLong((String) iVar.mcy.get("task_size"), 0);
        String str4 = (String) iVar.mcy.get("file_md5");
        String str5 = (String) iVar.mcy.get("extInfo");
        String str6 = (String) iVar.mcy.get("fileType");
        String str7 = (String) iVar.mcy.get("appid");
        String str8 = (String) iVar.mcy.get("package_name");
        int i = bi.getInt((String) iVar.mcy.get("scene"), BaseReportManager.MAX_READ_COUNT);
        x.i("MicroMsg.MsgHandler", "doAddDownloadTaskStraight, md5 = " + str4 + ", url = " + str2 + ", extinfo = " + str5 + ", fileType = " + str6 + ", reportScene = " + i);
        if (this.qhS != null) {
            int i2 = this.qhS.getInt("key_download_restrict", 0);
            if (!bi.oW(this.qhS.getString("key_function_id", ""))) {
                com.tencent.mm.plugin.report.service.h.mEJ.h(14596, new Object[]{r14, Integer.valueOf(i2), Integer.valueOf(0)});
            }
            if (i2 == 1) {
                x.e("MicroMsg.MsgHandler", "not allow to download file");
                a(iVar, "add_download_task_straight:fail", null);
                return true;
            }
        }
        au.HU();
        if (!com.tencent.mm.model.c.isSDCardAvailable()) {
            Toast.makeText(this.context, this.context.getString(R.l.game_download_sdcard_unavailable), 0).show();
            a(iVar, "add_download_task_straight:fail_sdcard_not_ready", null);
            u(str7, com.tencent.mm.plugin.downloader.a.a.ibo, str5);
            x.i("MicroMsg.MsgHandler", "doAddDownloadTaskStraight fail, sdcard not ready");
            return true;
        } else if (j > 0 && !com.tencent.mm.compatible.util.f.aM(j)) {
            Toast.makeText(this.context, this.context.getString(R.l.game_download_not_enough_space), 0).show();
            a(iVar, "add_download_task_straight:fail_sdcard_has_not_enough_space", null);
            u(str7, com.tencent.mm.plugin.downloader.a.a.ibo, str5);
            x.i("MicroMsg.MsgHandler", "doAddDownloadTaskStraight fail, not enough space, require size = " + j);
            return true;
        } else if (bi.oW(str2)) {
            x.e("MicroMsg.MsgHandler", "doAddDownloadTaskStraight fail, url is null");
            a(iVar, "add_download_task_straight:fail_invalid_url", null);
            u(str7, com.tencent.mm.plugin.downloader.a.a.DOWNLOAD_ERR_URL_INVALID, str5);
            return true;
        } else {
            long b;
            gn gnVar = new gn();
            gnVar.bPI.url = str2;
            gnVar.bPI.bKg = str4;
            gnVar.bPI.extInfo = str5;
            gnVar.bPI.appId = str7;
            gnVar.bPI.scene = i;
            com.tencent.mm.sdk.b.a.sFg.m(gnVar);
            com.tencent.mm.plugin.downloader.model.e.a aVar = new com.tencent.mm.plugin.downloader.model.e.a();
            aVar.yQ(str2);
            aVar.yR(str3);
            aVar.cx(j);
            aVar.yS(str);
            aVar.yT(str4);
            aVar.setAppId(str7);
            aVar.cQ(str8);
            aVar.ef(true);
            aVar.ox(bi.getInt(str6, 1));
            aVar.setScene(i);
            aVar.yU(str5);
            com.tencent.mm.plugin.downloader.model.e eVar = aVar.ick;
            if (bi.getInt((String) iVar.mcy.get("downloader_type"), 0) == 1) {
                b = com.tencent.mm.plugin.downloader.model.d.aCU().b(eVar);
            } else {
                b = com.tencent.mm.plugin.downloader.model.d.aCU().a(eVar);
            }
            x.i("MicroMsg.MsgHandler", "doAddDownloadTaskStraight, downloadId = " + b);
            gt gtVar = new gt();
            gtVar.bPU.appId = str7;
            gtVar.bPU.scene = i;
            gtVar.bPU.bGm = b;
            gtVar.bPU.opType = 7;
            com.tencent.mm.sdk.b.a.sFg.m(gtVar);
            if (b <= 0) {
                x.e("MicroMsg.MsgHandler", "doAddDownloadTaskStraight fail, downloadId = " + b);
                a(iVar, "add_download_task_straight:fail", null);
            } else {
                Map hashMap = new HashMap();
                hashMap.put("download_id", Long.valueOf(b));
                a(iVar, "add_download_task_straight:ok", hashMap);
            }
            return true;
        }
    }

    private static void u(String str, int i, String str2) {
        gt gtVar = new gt();
        gtVar.bPU.appId = str;
        gtVar.bPU.opType = 2;
        gtVar.bPU.bPV = i;
        gtVar.bPU.bJv = str2;
        com.tencent.mm.sdk.b.a.sFg.m(gtVar);
    }

    private boolean y(i iVar) {
        long j = bi.getLong((String) iVar.mcy.get("download_id"), -1);
        x.i("MicroMsg.MsgHandler", "doResumeDownloadTask, downloadId = " + j);
        if (j <= 0) {
            x.e("MicroMsg.MsgHandler", "doResumeDownloadTask fail, invalid downloadId = " + j);
            a(iVar, "resume_download_task:fail", null);
        } else {
            boolean co = com.tencent.mm.plugin.downloader.model.d.aCU().co(j);
            x.i("MicroMsg.MsgHandler", "doResumeDownloadTask, ret = " + co);
            if (co) {
                a(iVar, "resume_download_task:ok", null);
            } else {
                a(iVar, "resume_download_task:fail", null);
            }
        }
        return true;
    }

    private boolean a(String str, i iVar) {
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() > 0) {
                JSONObject jSONObject = new JSONObject();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < jSONArray.length()) {
                        String str2;
                        String string = jSONArray.getString(i2);
                        FileDownloadTaskInfo yO = com.tencent.mm.plugin.downloader.model.d.aCU().yO(string);
                        JSONObject jSONObject2 = new JSONObject();
                        switch (yO.status) {
                            case -1:
                                str2 = "api_not_support";
                                break;
                            case 1:
                                str2 = "downloading";
                                break;
                            case 2:
                                str2 = "download_pause";
                                break;
                            case 3:
                                if (!com.tencent.mm.a.e.cn(yO.path)) {
                                    str2 = "default";
                                    break;
                                }
                                str2 = "download_succ";
                                break;
                            case 4:
                                str2 = "download_fail";
                                break;
                            default:
                                str2 = "default";
                                break;
                        }
                        jSONObject2.put("download_id", yO.id);
                        jSONObject2.put(OpenSDKTool4Assistant.EXTRA_STATE, str2);
                        if (str2 == "downloading" && yO.gTK != 0) {
                            jSONObject2.put("progress", (yO.icq / yO.gTK) * 100);
                        }
                        jSONObject.put(string, jSONObject2);
                        i = i2 + 1;
                    } else {
                        Map hashMap = new HashMap();
                        hashMap.put("result", jSONObject);
                        a(iVar, "query_download_task:ok", hashMap);
                    }
                }
            } else {
                a(iVar, "query_download_task:fail", null);
            }
        } catch (JSONException e) {
            x.e("MicroMsg.MsgHandler", e.getMessage());
            a(iVar, "query_download_task:fail", null);
        }
        return true;
    }

    private boolean z(i iVar) {
        String currentUrl;
        int i;
        if (this.qhS != null) {
            int i2 = this.qhS.getInt("key_download_restrict", 0);
            if (!bi.oW(this.qhS.getString("key_function_id", ""))) {
                com.tencent.mm.plugin.report.service.h.mEJ.h(14596, new Object[]{r1, Integer.valueOf(i2), Integer.valueOf(1)});
            }
            if (i2 == 1) {
                x.e("MicroMsg.MsgHandler", "not allow tolaunch 3rd app");
                a(iVar, "launch_3rdApp:fail", null);
                return true;
            }
        }
        String str = (String) iVar.mcy.get(DownloadSettingTable$Columns.TYPE);
        String str2 = (String) iVar.mcy.get("appID");
        x.i("MicroMsg.MsgHandler", "lauchTimeInterval = %d", new Object[]{Long.valueOf(bi.VE() - this.qig)});
        String str3 = "";
        String str4 = "";
        if (bi.VE() - this.qig < 2 && this.qig > 0) {
            try {
                currentUrl = this.pRY.getCurrentUrl();
                str4 = this.qic.RE(currentUrl);
                str3 = URLEncoder.encode(currentUrl, "UTF-8");
                com.tencent.mm.plugin.report.service.h.mEJ.h(13983, new Object[]{Integer.valueOf(5), str3, ""});
                currentUrl = str4;
            } catch (Exception e) {
                str3 = "";
                x.e("MicroMsg.MsgHandler", "report lauch3rd failed");
            }
            l.a(iVar.qkk, false, null, str2);
            if (!bi.oW(str)) {
                try {
                    i = bi.getInt(str, 0);
                } catch (Exception e2) {
                    x.e("MicroMsg.MsgHandler", "invalid type", new Object[]{e2.getMessage()});
                }
                x.i("MicroMsg.MsgHandler", "doLaunch3RdApp launchType = %s", new Object[]{str});
                if (i != 0) {
                    str = (String) iVar.mcy.get("extInfo");
                    x.i("MicroMsg.MsgHandler", "doLaunch3RdApp, appid:[%s], extinfo:[%s]", new Object[]{str2, str});
                    if (bi.oW(str2)) {
                        x.e("MicroMsg.MsgHandler", "appid is null or nil");
                        a(iVar, "launch_3rdApp:fail", null);
                    } else if (com.tencent.mm.plugin.webview.a.a.ezo.r(ad.getContext(), str2)) {
                        WXAppExtendObject wXAppExtendObject = new WXAppExtendObject();
                        wXAppExtendObject.extInfo = str;
                        WXMediaMessage wXMediaMessage = new WXMediaMessage(wXAppExtendObject);
                        wXMediaMessage.sdkVer = 620823808;
                        wXMediaMessage.messageExt = str;
                        ir irVar = new ir();
                        irVar.bSe.bSg = wXMediaMessage;
                        irVar.bSe.appId = str2;
                        irVar.bSe.context = this.context;
                        irVar.bSe.bSh = new 49(this, iVar);
                        com.tencent.mm.sdk.b.a.sFg.m(irVar);
                    } else {
                        x.e("MicroMsg.MsgHandler", "app is not installed, appid:[%s]", new Object[]{str2});
                        a(iVar, "launch_3rdApp:fail", null);
                    }
                } else if (i == 1) {
                    str = (String) iVar.mcy.get("signature");
                    str2 = (String) iVar.mcy.get("packageName");
                    x.i("MicroMsg.MsgHandler", "doLaunch3RdApp, signature:[%s], packageName:[%s], param:[%s]", new Object[]{str, str2, (String) iVar.mcy.get("param")});
                    if (bi.oW(str) || bi.oW(str2)) {
                        x.e("MicroMsg.MsgHandler", "doLaunch3RdApp invalid_args");
                        a(iVar, "launch_3rdApp:fail_invalid_args", null);
                    } else if (com.tencent.mm.pluginsdk.model.app.p.r(this.context, str2)) {
                        Signature[] bh = com.tencent.mm.pluginsdk.model.app.p.bh(this.context, str2);
                        if (!(bh == null || bh[0] == null)) {
                            String u = com.tencent.mm.a.g.u(bh[0].toByteArray());
                            if (u != null && u.equalsIgnoreCase(str)) {
                                try {
                                    Intent launchIntentForPackage = this.context.getPackageManager().getLaunchIntentForPackage(str2);
                                    if (launchIntentForPackage != null) {
                                        Bundle bundle = new Bundle();
                                        com.tencent.mm.pluginsdk.model.app.p.g(bundle, str4);
                                        launchIntentForPackage.putExtras(bundle);
                                        launchIntentForPackage.addFlags(268435456);
                                        bundle = new Bundle();
                                        bundle.putString("current_page_url", str3);
                                        bundle.putString("current_page_appid", currentUrl);
                                        com.tencent.mm.pluginsdk.model.app.g.a(this.context, launchIntentForPackage, null, new 50(this, iVar), bundle);
                                    }
                                } catch (Exception e3) {
                                    x.e("MicroMsg.MsgHandler", "doLaunch3RdApp getLaunchIntentForPackage, %s", new Object[]{e3.getMessage()});
                                }
                                a(iVar, "launch_3rdApp:fail", null);
                            }
                        }
                        x.e("MicroMsg.MsgHandler", "doLaunch3RdApp signature_mismatch");
                        a(iVar, "launch_3rdApp:fail_signature_mismatch", null);
                    } else {
                        x.e("MicroMsg.MsgHandler", "doLaunch3RdApp not_install");
                        a(iVar, "launch_3rdApp:fail_not_install", null);
                    }
                } else {
                    a(iVar, "launch_3rdApp:fail_invalid_type", null);
                }
                return true;
            }
            i = 0;
            x.i("MicroMsg.MsgHandler", "doLaunch3RdApp launchType = %s", new Object[]{str});
            if (i != 0) {
                str = (String) iVar.mcy.get("extInfo");
                x.i("MicroMsg.MsgHandler", "doLaunch3RdApp, appid:[%s], extinfo:[%s]", new Object[]{str2, str});
                if (bi.oW(str2)) {
                    x.e("MicroMsg.MsgHandler", "appid is null or nil");
                    a(iVar, "launch_3rdApp:fail", null);
                } else if (com.tencent.mm.plugin.webview.a.a.ezo.r(ad.getContext(), str2)) {
                    WXAppExtendObject wXAppExtendObject2 = new WXAppExtendObject();
                    wXAppExtendObject2.extInfo = str;
                    WXMediaMessage wXMediaMessage2 = new WXMediaMessage(wXAppExtendObject2);
                    wXMediaMessage2.sdkVer = 620823808;
                    wXMediaMessage2.messageExt = str;
                    ir irVar2 = new ir();
                    irVar2.bSe.bSg = wXMediaMessage2;
                    irVar2.bSe.appId = str2;
                    irVar2.bSe.context = this.context;
                    irVar2.bSe.bSh = new 49(this, iVar);
                    com.tencent.mm.sdk.b.a.sFg.m(irVar2);
                } else {
                    x.e("MicroMsg.MsgHandler", "app is not installed, appid:[%s]", new Object[]{str2});
                    a(iVar, "launch_3rdApp:fail", null);
                }
            } else if (i == 1) {
                str = (String) iVar.mcy.get("signature");
                str2 = (String) iVar.mcy.get("packageName");
                x.i("MicroMsg.MsgHandler", "doLaunch3RdApp, signature:[%s], packageName:[%s], param:[%s]", new Object[]{str, str2, (String) iVar.mcy.get("param")});
                if (bi.oW(str) || bi.oW(str2)) {
                    x.e("MicroMsg.MsgHandler", "doLaunch3RdApp invalid_args");
                    a(iVar, "launch_3rdApp:fail_invalid_args", null);
                } else if (com.tencent.mm.pluginsdk.model.app.p.r(this.context, str2)) {
                    Signature[] bh2 = com.tencent.mm.pluginsdk.model.app.p.bh(this.context, str2);
                    if (!(bh2 == null || bh2[0] == null)) {
                        String u2 = com.tencent.mm.a.g.u(bh2[0].toByteArray());
                        if (u2 != null && u2.equalsIgnoreCase(str)) {
                            try {
                                Intent launchIntentForPackage2 = this.context.getPackageManager().getLaunchIntentForPackage(str2);
                                if (launchIntentForPackage2 != null) {
                                    Bundle bundle2 = new Bundle();
                                    com.tencent.mm.pluginsdk.model.app.p.g(bundle2, str4);
                                    launchIntentForPackage2.putExtras(bundle2);
                                    launchIntentForPackage2.addFlags(268435456);
                                    bundle2 = new Bundle();
                                    bundle2.putString("current_page_url", str3);
                                    bundle2.putString("current_page_appid", currentUrl);
                                    com.tencent.mm.pluginsdk.model.app.g.a(this.context, launchIntentForPackage2, null, new 50(this, iVar), bundle2);
                                }
                            } catch (Exception e32) {
                                x.e("MicroMsg.MsgHandler", "doLaunch3RdApp getLaunchIntentForPackage, %s", new Object[]{e32.getMessage()});
                            }
                            a(iVar, "launch_3rdApp:fail", null);
                        }
                    }
                    x.e("MicroMsg.MsgHandler", "doLaunch3RdApp signature_mismatch");
                    a(iVar, "launch_3rdApp:fail_signature_mismatch", null);
                } else {
                    x.e("MicroMsg.MsgHandler", "doLaunch3RdApp not_install");
                    a(iVar, "launch_3rdApp:fail_not_install", null);
                }
            } else {
                a(iVar, "launch_3rdApp:fail_invalid_type", null);
            }
            return true;
        }
        currentUrl = str4;
        l.a(iVar.qkk, false, null, str2);
        if (bi.oW(str)) {
            try {
                i = bi.getInt(str, 0);
            } catch (Exception e22) {
                x.e("MicroMsg.MsgHandler", "invalid type", new Object[]{e22.getMessage()});
            }
            x.i("MicroMsg.MsgHandler", "doLaunch3RdApp launchType = %s", new Object[]{str});
            if (i != 0) {
                str = (String) iVar.mcy.get("extInfo");
                x.i("MicroMsg.MsgHandler", "doLaunch3RdApp, appid:[%s], extinfo:[%s]", new Object[]{str2, str});
                if (bi.oW(str2)) {
                    x.e("MicroMsg.MsgHandler", "appid is null or nil");
                    a(iVar, "launch_3rdApp:fail", null);
                } else if (com.tencent.mm.plugin.webview.a.a.ezo.r(ad.getContext(), str2)) {
                    WXAppExtendObject wXAppExtendObject22 = new WXAppExtendObject();
                    wXAppExtendObject22.extInfo = str;
                    WXMediaMessage wXMediaMessage22 = new WXMediaMessage(wXAppExtendObject22);
                    wXMediaMessage22.sdkVer = 620823808;
                    wXMediaMessage22.messageExt = str;
                    ir irVar22 = new ir();
                    irVar22.bSe.bSg = wXMediaMessage22;
                    irVar22.bSe.appId = str2;
                    irVar22.bSe.context = this.context;
                    irVar22.bSe.bSh = new 49(this, iVar);
                    com.tencent.mm.sdk.b.a.sFg.m(irVar22);
                } else {
                    x.e("MicroMsg.MsgHandler", "app is not installed, appid:[%s]", new Object[]{str2});
                    a(iVar, "launch_3rdApp:fail", null);
                }
            } else if (i == 1) {
                str = (String) iVar.mcy.get("signature");
                str2 = (String) iVar.mcy.get("packageName");
                x.i("MicroMsg.MsgHandler", "doLaunch3RdApp, signature:[%s], packageName:[%s], param:[%s]", new Object[]{str, str2, (String) iVar.mcy.get("param")});
                if (bi.oW(str) || bi.oW(str2)) {
                    x.e("MicroMsg.MsgHandler", "doLaunch3RdApp invalid_args");
                    a(iVar, "launch_3rdApp:fail_invalid_args", null);
                } else if (com.tencent.mm.pluginsdk.model.app.p.r(this.context, str2)) {
                    Signature[] bh22 = com.tencent.mm.pluginsdk.model.app.p.bh(this.context, str2);
                    if (!(bh22 == null || bh22[0] == null)) {
                        String u22 = com.tencent.mm.a.g.u(bh22[0].toByteArray());
                        if (u22 != null && u22.equalsIgnoreCase(str)) {
                            try {
                                Intent launchIntentForPackage22 = this.context.getPackageManager().getLaunchIntentForPackage(str2);
                                if (launchIntentForPackage22 != null) {
                                    Bundle bundle22 = new Bundle();
                                    com.tencent.mm.pluginsdk.model.app.p.g(bundle22, str4);
                                    launchIntentForPackage22.putExtras(bundle22);
                                    launchIntentForPackage22.addFlags(268435456);
                                    bundle22 = new Bundle();
                                    bundle22.putString("current_page_url", str3);
                                    bundle22.putString("current_page_appid", currentUrl);
                                    com.tencent.mm.pluginsdk.model.app.g.a(this.context, launchIntentForPackage22, null, new 50(this, iVar), bundle22);
                                }
                            } catch (Exception e322) {
                                x.e("MicroMsg.MsgHandler", "doLaunch3RdApp getLaunchIntentForPackage, %s", new Object[]{e322.getMessage()});
                            }
                            a(iVar, "launch_3rdApp:fail", null);
                        }
                    }
                    x.e("MicroMsg.MsgHandler", "doLaunch3RdApp signature_mismatch");
                    a(iVar, "launch_3rdApp:fail_signature_mismatch", null);
                } else {
                    x.e("MicroMsg.MsgHandler", "doLaunch3RdApp not_install");
                    a(iVar, "launch_3rdApp:fail_not_install", null);
                }
            } else {
                a(iVar, "launch_3rdApp:fail_invalid_type", null);
            }
            return true;
        }
        i = 0;
        x.i("MicroMsg.MsgHandler", "doLaunch3RdApp launchType = %s", new Object[]{str});
        if (i != 0) {
            str = (String) iVar.mcy.get("extInfo");
            x.i("MicroMsg.MsgHandler", "doLaunch3RdApp, appid:[%s], extinfo:[%s]", new Object[]{str2, str});
            if (bi.oW(str2)) {
                x.e("MicroMsg.MsgHandler", "appid is null or nil");
                a(iVar, "launch_3rdApp:fail", null);
            } else if (com.tencent.mm.plugin.webview.a.a.ezo.r(ad.getContext(), str2)) {
                WXAppExtendObject wXAppExtendObject222 = new WXAppExtendObject();
                wXAppExtendObject222.extInfo = str;
                WXMediaMessage wXMediaMessage222 = new WXMediaMessage(wXAppExtendObject222);
                wXMediaMessage222.sdkVer = 620823808;
                wXMediaMessage222.messageExt = str;
                ir irVar222 = new ir();
                irVar222.bSe.bSg = wXMediaMessage222;
                irVar222.bSe.appId = str2;
                irVar222.bSe.context = this.context;
                irVar222.bSe.bSh = new 49(this, iVar);
                com.tencent.mm.sdk.b.a.sFg.m(irVar222);
            } else {
                x.e("MicroMsg.MsgHandler", "app is not installed, appid:[%s]", new Object[]{str2});
                a(iVar, "launch_3rdApp:fail", null);
            }
        } else if (i == 1) {
            str = (String) iVar.mcy.get("signature");
            str2 = (String) iVar.mcy.get("packageName");
            x.i("MicroMsg.MsgHandler", "doLaunch3RdApp, signature:[%s], packageName:[%s], param:[%s]", new Object[]{str, str2, (String) iVar.mcy.get("param")});
            if (bi.oW(str) || bi.oW(str2)) {
                x.e("MicroMsg.MsgHandler", "doLaunch3RdApp invalid_args");
                a(iVar, "launch_3rdApp:fail_invalid_args", null);
            } else if (com.tencent.mm.pluginsdk.model.app.p.r(this.context, str2)) {
                Signature[] bh222 = com.tencent.mm.pluginsdk.model.app.p.bh(this.context, str2);
                if (!(bh222 == null || bh222[0] == null)) {
                    String u222 = com.tencent.mm.a.g.u(bh222[0].toByteArray());
                    if (u222 != null && u222.equalsIgnoreCase(str)) {
                        try {
                            Intent launchIntentForPackage222 = this.context.getPackageManager().getLaunchIntentForPackage(str2);
                            if (launchIntentForPackage222 != null) {
                                Bundle bundle222 = new Bundle();
                                com.tencent.mm.pluginsdk.model.app.p.g(bundle222, str4);
                                launchIntentForPackage222.putExtras(bundle222);
                                launchIntentForPackage222.addFlags(268435456);
                                bundle222 = new Bundle();
                                bundle222.putString("current_page_url", str3);
                                bundle222.putString("current_page_appid", currentUrl);
                                com.tencent.mm.pluginsdk.model.app.g.a(this.context, launchIntentForPackage222, null, new 50(this, iVar), bundle222);
                            }
                        } catch (Exception e3222) {
                            x.e("MicroMsg.MsgHandler", "doLaunch3RdApp getLaunchIntentForPackage, %s", new Object[]{e3222.getMessage()});
                        }
                        a(iVar, "launch_3rdApp:fail", null);
                    }
                }
                x.e("MicroMsg.MsgHandler", "doLaunch3RdApp signature_mismatch");
                a(iVar, "launch_3rdApp:fail_signature_mismatch", null);
            } else {
                x.e("MicroMsg.MsgHandler", "doLaunch3RdApp not_install");
                a(iVar, "launch_3rdApp:fail_not_install", null);
            }
        } else {
            a(iVar, "launch_3rdApp:fail_invalid_type", null);
        }
        return true;
    }

    private boolean A(i iVar) {
        String str = (String) iVar.mcy.get(TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_URL);
        if (bi.oW(str)) {
            x.e("MicroMsg.MsgHandler", "doOpenUrlByExtBrowser fail, url is null");
            a(iVar, "open_url_by_ext_browser:fail", null);
        } else {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            intent.addFlags(268435456);
            try {
                this.context.startActivity(intent);
                a(iVar, "open_url_by_ext_browser:ok", null);
            } catch (Exception e) {
                x.e("MicroMsg.MsgHandler", "doOpenUrlByExtBrowser fail, e = " + e.getMessage());
                a(iVar, "open_url_by_ext_browser:fail", null);
            }
        }
        return true;
    }

    private void bYe() {
        String str = (String) this.qhP.mcy.get(DownloadSettingTable$Columns.TYPE);
        x.v("MicroMsg.MsgHandler", "doGeoLocation, geoType = %s", new Object[]{str});
        if (!(bi.oW(str) || fQY.contains(str))) {
            x.e("MicroMsg.MsgHandler", "doGeoLocation fail, unsupported type = %s", new Object[]{str});
            a(this.qhP, "geo_location:fail_unsupported_type", null);
        }
        this.cXl = c.OB();
        if (this.cXl == null) {
            x.e("MicroMsg.MsgHandler", "doGeoLocation fail, iGetLocation is null");
            a(this.qhP, "geo_location:fail", null);
        }
        str = (String) this.qhP.mcy.get(DownloadSettingTable$Columns.TYPE);
        if (this.qit == null) {
            this.qit = new 51(this, str);
        }
        if (this.jnn == null) {
            this.jnn = new ag(Looper.getMainLooper());
        }
        this.jnn.postDelayed(new 52(this), 20000);
        if (bi.oW(str) || str.equalsIgnoreCase("gcj02")) {
            this.cXl.b(this.qit, false);
        } else if (str.equalsIgnoreCase("wgs84")) {
            this.cXl.a(this.qit, false);
        } else {
            x.e("MicroMsg.MsgHandler", "startGeoLocation, should not reach here !!!!!");
            this.qit = null;
            a(this.qhP, "geo_location:fail_unsupported_type_startgeo", null);
        }
    }

    private static byte[] bYf() {
        try {
            com.tencent.mm.sdk.platformtools.g gVar = new com.tencent.mm.sdk.platformtools.g("softtype");
            x.d("MicroMsg.AndroidDevicesReport", "cpu %s", new Object[]{bi.aG((String) com.tencent.mm.compatible.e.n.zn().get("Processor"), "")});
            gVar.bR("cpu", r0);
            gVar.bR("radio", com.tencent.mm.compatible.e.q.zH());
            gVar.bR("osversion", VERSION.RELEASE);
            String deviceID = com.tencent.mm.compatible.e.q.getDeviceID(ad.getContext());
            String zJ = com.tencent.mm.compatible.e.q.zJ();
            String zK = com.tencent.mm.compatible.e.q.zK();
            gVar.bR("deviceId", deviceID);
            gVar.bR("imsi", zJ);
            gVar.bR("iccid", zK);
            gVar.bR("androidid", com.tencent.mm.compatible.e.q.getAndroidId());
            gVar.bR("serial", com.tencent.mm.compatible.e.q.zL());
            gVar.bR("model", com.tencent.mm.compatible.e.q.zE());
            gVar.bR("core_count", com.tencent.mm.compatible.e.n.zs());
            gVar.bR("cpuhardware", bi.aG((String) com.tencent.mm.compatible.e.n.zt().get("Hardware"), ""));
            gVar.bR("cpureversion", bi.aG((String) com.tencent.mm.compatible.e.n.zt().get("CPU revision"), ""));
            gVar.bR("cpuserial", bi.aG((String) com.tencent.mm.compatible.e.n.zt().get("Serial"), ""));
            gVar.bR("Features", bi.aG((String) com.tencent.mm.compatible.e.n.zt().get("Features"), ""));
            gVar.bR("wifi-mac", bi.aG(com.tencent.mm.compatible.e.q.zB(), ""));
            gVar.bR("bluetooth", bi.aG(com.tencent.mm.compatible.e.q.zC(), ""));
            if (!bi.oW(gVar.sFG)) {
                gVar.wB(gVar.sFG);
                gVar.sFG = "";
            }
            x.d("MicroMsg.AndroidDevicesReport", "xmlStr %s", new Object[]{gVar.gVP.toString()});
            x.i("MicroMsg.MsgHandler", "xml %s", new Object[]{deviceID});
            buf buf = new buf();
            buf.srD = com.tencent.mm.bk.b.bi(com.tencent.mm.compatible.e.q.zz().getBytes()).Cz(16);
            x.i("MicroMsg.MsgHandler", bi.bE(buf.srD.lR));
            buf.srE = deviceID;
            SharedPreferences Ib = av.Ib();
            x.i("MicroMsg.MsgHandler", "cpan aak string:%s md5:%s uin:%d", new Object[]{bi.bE(r2), com.tencent.mm.a.g.u(bi.WP(Ib.getString("_auth_key", ""))), Integer.valueOf(Ib.getInt("_auth_uin", 0))});
            x.i("MicroMsg.MsgHandler", "aat len:%d", new Object[]{Integer.valueOf(r2.length)});
            buf.srF = com.tencent.mm.bk.b.bi(r2);
            buf.uin = r0;
            com.tencent.mm.protocal.y cgr = com.tencent.mm.protocal.y.cgr();
            byte[] toByteArray = buf.toByteArray();
            PByteArray pByteArray = new PByteArray();
            if (MMProtocalJni.rsaPublicEncrypt(toByteArray, pByteArray, cgr.qXe.getBytes(), cgr.qXf.getBytes())) {
                toByteArray = pByteArray.value;
            }
            x.d("MicroMsg.MsgHandler", "cpan buf string:%s ", new Object[]{bi.bE(toByteArray)});
            bug bug = new bug();
            bug.srH = cgr.ver;
            bug.srG = com.tencent.mm.protocal.d.qVN;
            bug.srI = com.tencent.mm.protocal.d.DEVICE_TYPE;
            bug.srJ = com.tencent.mm.bk.b.bi(toByteArray);
            x.i("MicroMsg.MsgHandler", "getdevice done");
            return bug.toByteArray();
        } catch (Throwable e) {
            x.e("MicroMsg.MsgHandler", "report error");
            x.printErrStackTrace("MicroMsg.MsgHandler", e, "", new Object[0]);
            return null;
        }
    }

    private boolean B(i iVar) {
        String str = "";
        try {
            str = this.pRY.getCurrentUrl();
        } catch (Exception e) {
            x.w("MicroMsg.MsgHandler", "JSOAUTH exception in get currentUrl" + e.getMessage());
        }
        x.i("MicroMsg.MsgHandler", "currentUrl %s", new Object[]{str});
        if (str.startsWith("https://support.weixin.qq.com/security/") || str.startsWith("https://support.wechat.com/security/") || str.startsWith("https://szsupport.weixin.qq.com/security/") || str.startsWith("https://hksupport.weixin.qq.com/security/") || str.startsWith("https://mlsupport.weixin.qq.com/security/") || str.startsWith("https://weixin110.qq.com/security/")) {
            Object obj = "";
            Map hashMap = new HashMap();
            try {
                x.i("MicroMsg.MsgHandler", "getDeviceInfo");
                obj = Base64.encodeToString(bYf(), 0);
            } catch (Throwable e2) {
                x.e("MicroMsg.MsgHandler", "device info get error %s", new Object[]{e2.getMessage()});
                x.printErrStackTrace("MicroMsg.MsgHandler", e2, "", new Object[0]);
            }
            hashMap.put("securityInfo", obj);
            a(iVar, "mmsf0001:ok", hashMap);
        } else {
            a(iVar, "system:access_denied", null);
        }
        return true;
    }

    private boolean C(i iVar) {
        Map map = null;
        if (this.context instanceof MMActivity) {
            String map2;
            x.d("MicroMsg.MsgHandler", "doJumpToBizProfile %s, %s", new Object[]{(String) iVar.mcy.get("tousername"), (String) iVar.mcy.get("extmsg")});
            try {
                map2 = this.pRY.getCurrentUrl();
            } catch (RemoteException e) {
                x.w("MicroMsg.MsgHandler", "JSOAUTH exception in get currentUrl" + e.getMessage());
            }
            Intent intent = new Intent();
            intent.putExtra("toUserName", r0);
            intent.putExtra("extInfo", r1);
            intent.putExtra("fromURL", map2);
            intent.putExtra("source", 2);
            com.tencent.mm.plugin.webview.a.a.ezn.a(intent, this, (MMActivity) this.context);
        } else {
            a(iVar, "jump_to_biz_profile:fail", map2);
        }
        return true;
    }

    private boolean D(i iVar) {
        x.i("MicroMsg.MsgHandler", "doSetCloseWindowConfirmDialogInfo, switch value : %s, title_cn : %s, title_eng : %s, ok_cn : %s,  ok_eng : %s,  cancel_cn : %s,  cancel_eng : %s", new Object[]{(String) iVar.mcy.get("switch"), (String) iVar.mcy.get("title_cn"), (String) iVar.mcy.get("title_eng"), (String) iVar.mcy.get("ok_cn"), (String) iVar.mcy.get("ok_eng"), (String) iVar.mcy.get("cancel_cn"), (String) iVar.mcy.get("cancel_eng")});
        Bundle bundle = new Bundle();
        bundle.putString("close_window_confirm_dialog_switch", r0);
        bundle.putString("close_window_confirm_dialog_title_cn", r1);
        bundle.putString("close_window_confirm_dialog_title_eng", r2);
        bundle.putString("close_window_confirm_dialog_ok_cn", r3);
        bundle.putString("close_window_confirm_dialog_ok_eng", r4);
        bundle.putString("close_window_confirm_dialog_cancel_cn", r5);
        bundle.putString("close_window_confirm_dialog_cancel_eng", r6);
        try {
            this.pRY.c(13, bundle);
        } catch (RemoteException e) {
            x.e("MicroMsg.MsgHandler", "doSetCloseWindowConfirmDialogInfo invoke callback failed : %s", new Object[]{e.getMessage()});
        }
        a(iVar, "setCloseWindowConfirmDialogInfo:ok", null);
        return true;
    }

    private boolean E(i iVar) {
        String str = (String) iVar.mcy.get("verifyAppId");
        String str2 = (String) iVar.mcy.get("verifyJsApiList");
        x.i("MicroMsg.MsgHandler", "doPreVerifyJSAPI, appid : %s, %s, %s, %s, %s", new Object[]{str, (String) iVar.mcy.get("verifySignature"), (String) iVar.mcy.get("verifyNonceStr"), (String) iVar.mcy.get("verifyTimestamp"), (String) iVar.mcy.get("verifySignType")});
        l.a(iVar.qkk, false, null, str);
        LinkedList linkedList = new LinkedList();
        try {
            JSONArray jSONArray = new JSONArray(str2);
            x.i("MicroMsg.MsgHandler", "doPreVerifyJSAPI jsItem length %s", new Object[]{Integer.valueOf(jSONArray.length())});
            if (jSONArray.length() == 0) {
                a(iVar, "checkJsApi:param is empty", null);
                return true;
            }
            for (int i = 0; i < jSONArray.length(); i++) {
                String string = jSONArray.getString(i);
                if (!bi.oW(string)) {
                    linkedList.add(string);
                }
            }
            String currentUrl = this.pRY.getCurrentUrl();
            int i2 = 0;
            String str3 = "";
            try {
                Bundle g = this.pRY.g(com.tencent.mm.plugin.appbrand.jsapi.f.b.CTRL_INDEX, null);
                i2 = g.getInt("key_webview_preverify_info_scene", 0);
                str3 = g.getString("key_webview_preverify_info_source_appid", "");
            } catch (Exception e) {
                x.e("TAG", "doPreVerifyJSAPI: %s", new Object[]{e});
            }
            e eVar = this.pRY;
            c cVar = this.qic;
            53 53 = new 53(this, currentUrl, eVar, iVar);
            if (bi.oW(str) || linkedList.size() <= 0) {
                x.e("MicroMsg.webview.JSVerifyHelper", "handlePreVerify wrong args, %s", new Object[]{str});
                53.a(c$a.a.RET_FAIL, null, null, 0, 0);
            } else {
                au.DF().a(1093, cVar);
                au.DF().a(new com.tencent.mm.plugin.webview.model.n(53, currentUrl, str, linkedList, r6, r7, r8, r9, i2, str3, cVar.pRn), 0);
            }
            return true;
        } catch (Exception e2) {
            x.w("MicroMsg.MsgHandler", "exception occur " + e2.getMessage());
            a(iVar, "pre_verify_jsapi:fail", null);
            return true;
        }
    }

    private boolean F(i iVar) {
        Map hashMap = new HashMap();
        try {
            de deVar = new de();
            deVar.bKM.bKD = true;
            com.tencent.mm.sdk.b.a.sFg.m(deVar);
            if (deVar.bKN.bKE) {
                hashMap.put("currentSSID", deVar.bKN.bKO);
                a(iVar, "getCurrentSSID:ok", hashMap);
            } else {
                hashMap.put("err_desc", "not on wifi");
                a(iVar, "getCurrentSSID:fail", hashMap);
            }
        } catch (Exception e) {
            x.e("MicroMsg.MsgHandler", "getCurrentSSID:fail");
            hashMap.put("err_desc", "not on wifi");
            a(iVar, "getCurrentSSID:fail", hashMap);
        }
        return true;
    }

    private boolean G(i iVar) {
        int bVC = bVC();
        int aUM = aUM();
        String bYg = bYg();
        x.i("MicroMsg.MsgHandler", "Key Scene(%d)", new Object[]{Integer.valueOf(aUM)});
        if (aUM == 27) {
            this.qhT = (String) iVar.mcy.get("brandUserName");
            x.i("MicroMsg.MsgHandler", "BrandUserName from shake(%s)", new Object[]{this.qhT});
        } else if (!(bVC == 8 || bVC == -1)) {
            this.hpJ = (String) iVar.mcy.get("brandUserName");
            x.i("MicroMsg.MsgHandler", "BrandUserName from H5(%s)", new Object[]{this.hpJ});
            if (!(bi.oW(bYg) || bi.oW(this.hpJ))) {
                x.i("MicroMsg.MsgHandler", "Chat name(%s)", new Object[]{bYg});
                com.tencent.mm.ac.d kH = com.tencent.mm.ac.f.kH(bYg);
                if (kH != null) {
                    d$b bG = kH.bG(false);
                    if (!(bG == null || bG.Ms() == null || !bG.Ms().MC() || bYg.equals(this.hpJ))) {
                        a(iVar, "openWXDeviceLib:fail_UsernameError", null);
                        return true;
                    }
                }
            }
        }
        bYg = Q(iVar);
        x.i("MicroMsg.MsgHandler", "srcUsername(%s)", new Object[]{bYg});
        if (bi.oW(bYg)) {
            a(iVar, "openWXDeviceLib:fail_UsernameError", null);
        } else {
            com.tencent.mm.plugin.report.service.h.mEJ.h(11533, new Object[]{bYg, "openWXDeviceLib"});
            String str = "";
            if (iVar.mcy.containsKey("connType")) {
                str = (String) iVar.mcy.get("connType");
            }
            Object obj;
            if (str.equalsIgnoreCase("lan")) {
                if (this.qhV == null) {
                    this.qhV = new HashMap();
                }
                try {
                    com.tencent.mm.plugin.webview.ui.tools.a.a bWZ = com.tencent.mm.plugin.webview.ui.tools.a.a.bWZ();
                    e eVar = this.pRY;
                    x.i("MicroMsg.webview.WebViewExDeviceLanMgr", "tryInit");
                    if (bWZ.qcP == null) {
                        bWZ.qcP = new com.tencent.mm.plugin.webview.ui.tools.a.a.a(eVar, bYg);
                        com.tencent.mm.sdk.b.a.sFg.b(bWZ.qcP.qcU);
                        com.tencent.mm.sdk.b.a.sFg.b(bWZ.qcP.qcV);
                        com.tencent.mm.sdk.b.a.sFg.b(bWZ.qcP.qcX);
                        com.tencent.mm.sdk.b.a.sFg.b(bWZ.qcP.qcW);
                        com.tencent.mm.sdk.b.a.sFg.b(bWZ.qcP.qcY);
                    }
                    dx dxVar = new dx();
                    dxVar.bLI.bKD = true;
                    com.tencent.mm.sdk.b.a.sFg.m(dxVar);
                    bWZ.hasInit = true;
                    bWZ.bKC = bYg;
                    bWZ.qcR = null;
                    r.a(com.tencent.mm.plugin.webview.ui.tools.a.a.bWZ());
                    if (ao.isWifi(this.context)) {
                        obj = "on";
                    } else {
                        obj = "off";
                    }
                    Map hashMap = new HashMap();
                    hashMap.put("minVersion", Integer.valueOf(1));
                    hashMap.put("maxVersion", Integer.valueOf(1));
                    hashMap.put("lanState", obj);
                    a(iVar, "openWXDeviceLib:ok", hashMap);
                } catch (Exception e) {
                    x.e("MicroMsg.MsgHandler", "openWXDeviceLib failed : %s", new Object[]{e.getMessage()});
                    a(iVar, "openWXDeviceLib:fail_exception", null);
                }
            } else {
                if (this.qhU == null) {
                    this.qhU = new HashMap();
                }
                try {
                    com.tencent.mm.plugin.webview.ui.tools.a.b bXc = com.tencent.mm.plugin.webview.ui.tools.a.b.bXc();
                    e eVar2 = this.pRY;
                    x.i("MicroMsg.webview.WebViewExDeviceMgr", "tryInit");
                    if (bXc.qda == null) {
                        bXc.qda = new com.tencent.mm.plugin.webview.ui.tools.a.b.a(eVar2, bYg);
                        com.tencent.mm.sdk.b.a.sFg.b(bXc.qda.qde);
                        com.tencent.mm.sdk.b.a.sFg.b(bXc.qda.qdf);
                        com.tencent.mm.sdk.b.a.sFg.b(bXc.qda.qdg);
                        com.tencent.mm.sdk.b.a.sFg.b(bXc.qda.qcU);
                        com.tencent.mm.sdk.b.a.sFg.b(bXc.qda.nbf);
                    }
                    dr drVar = new dr();
                    drVar.bLB.op = 1;
                    com.tencent.mm.sdk.b.a.sFg.m(drVar);
                    bXc.hasInit = true;
                    bXc.bKC = bYg;
                    bXc.qcR = null;
                    r.a(com.tencent.mm.plugin.webview.ui.tools.a.b.bXc());
                    BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
                    if (defaultAdapter != null) {
                        obj = "unknow";
                        switch (defaultAdapter.getState()) {
                            case 10:
                                obj = "off";
                                break;
                            case 11:
                                obj = "resetting";
                                break;
                            case 12:
                                obj = "on";
                                break;
                        }
                    }
                    obj = "unknow";
                    x.i("MicroMsg.webview.ExDeviceBluetoothUtil", "isBLESupported, ret = %b", new Object[]{Boolean.valueOf(ad.getContext().getPackageManager().hasSystemFeature("android.hardware.bluetooth_le"))});
                    Map hashMap2 = new HashMap();
                    hashMap2.put("minVersion", Integer.valueOf(1));
                    hashMap2.put("maxVersion", Integer.valueOf(1));
                    hashMap2.put("bluetoothState", obj);
                    hashMap2.put("isSupportBLE", ad.getContext().getPackageManager().hasSystemFeature("android.hardware.bluetooth_le") ? "yes" : "no");
                    if (bVC == 1) {
                        hashMap2.put("OS", "android");
                    }
                    a(iVar, "openWXDeviceLib:ok", hashMap2);
                } catch (Exception e2) {
                    x.e("MicroMsg.MsgHandler", "openWXDeviceLib failed : %s", new Object[]{e2.getMessage()});
                    a(iVar, "openWXDeviceLib:fail_exception", null);
                }
            }
        }
        return true;
    }

    private boolean H(i iVar) {
        String str = "";
        if (iVar.mcy.containsKey("connType")) {
            str = (String) iVar.mcy.get("connType");
        }
        if (str.equalsIgnoreCase("lan")) {
            try {
                str = Q(iVar);
                com.tencent.mm.plugin.report.service.h.mEJ.h(11533, new Object[]{str, "closeWXDeviceLib"});
                com.tencent.mm.plugin.webview.ui.tools.a.a.bWZ().bXa();
            } catch (Exception e) {
                x.e("MicroMsg.MsgHandler", "closeWXDeviceLib failed : %s", new Object[]{e.getMessage()});
                a(iVar, "closeWXDeviceLib:fail_exception", null);
            }
        } else {
            try {
                str = Q(iVar);
                com.tencent.mm.plugin.report.service.h.mEJ.h(11533, new Object[]{str, "closeWXDeviceLib"});
                com.tencent.mm.plugin.webview.ui.tools.a.b.bXc().bXa();
            } catch (Exception e2) {
                x.e("MicroMsg.MsgHandler", "closeWXDeviceLib failed : %s", new Object[]{e2.getMessage()});
                a(iVar, "closeWXDeviceLib:fail_exception", null);
            }
        }
        a(iVar, "closeWXDeviceLib:ok", null);
        return true;
    }

    private boolean I(i iVar) {
        String str = "";
        if (iVar.mcy.containsKey("connType")) {
            str = (String) iVar.mcy.get("connType");
        }
        if (str.equalsIgnoreCase("lan")) {
            if (com.tencent.mm.plugin.webview.ui.tools.a.a.bWZ().hasInit) {
                try {
                    x.i("MicroMsg.MsgHandler", "srcUsername(%s)", new Object[]{Q(iVar)});
                    com.tencent.mm.plugin.report.service.h.mEJ.h(11533, new Object[]{str, "startScanWXDevice"});
                    if (bi.oW(Q(iVar))) {
                        a(iVar, "startScanWXDevice:fail_UsernameError", null);
                    } else {
                        eo eoVar = new eo();
                        eoVar.bMs.bKD = true;
                        com.tencent.mm.sdk.b.a.sFg.m(eoVar);
                        com.tencent.mm.plugin.webview.ui.tools.a.a.bWZ().qcT = true;
                        a(iVar, "startScanWXDevice:ok", null);
                    }
                } catch (Exception e) {
                    x.e("MicroMsg.MsgHandler", "startScanWXDevice failed : %s", new Object[]{e.getMessage()});
                    a(iVar, "startScanWXDevice:fail_exception", null);
                }
            } else {
                x.e("MicroMsg.MsgHandler", "startScanWXDevice not init");
                a(iVar, "startScanWXDevice:fail_notInit", null);
            }
        } else if (com.tencent.mm.compatible.util.d.fR(23) && !((LocationManager) this.context.getSystemService("location")).isProviderEnabled(TencentLocation.GPS_PROVIDER) && !VERSION.RELEASE.equalsIgnoreCase("6.0") && !VERSION.RELEASE.equalsIgnoreCase("6.0.0")) {
            x.d("MicroMsg.MsgHandler", "Android version realse code: %s", new Object[]{VERSION.RELEASE});
            x.e("MicroMsg.MsgHandler", "ScannerInThisAndroidVersionRequireGPSServiceOn");
            a(iVar, "startScanWXDevice:fail_ThisAndroidVersionRequireGPSServiceOn", null);
        } else if (com.tencent.mm.plugin.webview.ui.tools.a.b.bXc().hasInit) {
            try {
                String Q = Q(iVar);
                str = (String) iVar.mcy.get("btVersion");
                x.i("MicroMsg.MsgHandler", "BtVersion(%s), srcUsername(%s)", new Object[]{str, Q});
                com.tencent.mm.plugin.report.service.h.mEJ.h(11533, new Object[]{Q, "startScanWXDevice"});
                if (bi.oW(Q)) {
                    a(iVar, "startScanWXDevice:fail_UsernameError", null);
                } else {
                    dy dyVar = new dy();
                    dyVar.bLJ.bKD = true;
                    dyVar.bLJ.bKC = Q;
                    if (bi.oV(str).equals("ble")) {
                        dyVar.bLJ.bLL = 0;
                    } else if (bi.oV(str).equals("bc")) {
                        dyVar.bLJ.bLL = 1;
                    }
                    com.tencent.mm.plugin.webview.ui.tools.a.b.bXc().qdc = dyVar.bLJ.bLL;
                    com.tencent.mm.sdk.b.a.sFg.m(dyVar);
                    if (dyVar.bLK.bKE) {
                        com.tencent.mm.plugin.webview.ui.tools.a.b.bXc().qcT = true;
                        a(iVar, "startScanWXDevice:ok", null);
                    } else {
                        a(iVar, "startScanWXDevice:fail", null);
                    }
                }
            } catch (Exception e2) {
                x.e("MicroMsg.MsgHandler", "startScanWXDevice failed : %s", new Object[]{e2.getMessage()});
                a(iVar, "startScanWXDevice:fail_exception", null);
            }
        } else {
            x.e("MicroMsg.MsgHandler", "startScanWXDevice not init");
            a(iVar, "startScanWXDevice:fail_notInit", null);
        }
        return true;
    }

    private boolean J(i iVar) {
        String str = "";
        if (iVar.mcy.containsKey("connType")) {
            str = (String) iVar.mcy.get("connType");
        }
        if (str.equalsIgnoreCase("lan")) {
            if (com.tencent.mm.plugin.webview.ui.tools.a.a.bWZ().hasInit) {
                try {
                    str = Q(iVar);
                    com.tencent.mm.plugin.report.service.h.mEJ.h(11533, new Object[]{str, "stopScanWXDevice"});
                    if (bi.oW(str)) {
                        a(iVar, "stopScanWXDevice:fail_UsernameError", null);
                    } else {
                        eo eoVar = new eo();
                        eoVar.bMs.bKD = false;
                        com.tencent.mm.sdk.b.a.sFg.m(eoVar);
                        com.tencent.mm.plugin.webview.ui.tools.a.a.bWZ().qcT = false;
                        a(iVar, "stopScanWXDevice:ok", null);
                    }
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.MsgHandler", e, "", new Object[0]);
                    x.e("MicroMsg.MsgHandler", "stopScanWXDevice failed : %s", new Object[]{e.getMessage()});
                    a(iVar, "stopScanWXDevice:fail_exception", null);
                }
            } else {
                x.e("MicroMsg.MsgHandler", "stopScanWXDevice not init");
                a(iVar, "stopScanWXDevice:fail_notInit", null);
            }
        } else if (com.tencent.mm.plugin.webview.ui.tools.a.b.bXc().hasInit) {
            try {
                str = Q(iVar);
                com.tencent.mm.plugin.report.service.h.mEJ.h(11533, new Object[]{str, "stopScanWXDevice"});
                if (bi.oW(str)) {
                    a(iVar, "stopScanWXDevice:fail_UsernameError", null);
                } else {
                    dy dyVar = new dy();
                    dyVar.bLJ.bKD = false;
                    dyVar.bLJ.bKC = str;
                    dyVar.bLJ.bLL = com.tencent.mm.plugin.webview.ui.tools.a.b.bXc().qdc;
                    com.tencent.mm.sdk.b.a.sFg.m(dyVar);
                    if (dyVar.bLK.bKE) {
                        com.tencent.mm.plugin.webview.ui.tools.a.b.bXc().qcT = false;
                        a(iVar, "stopScanWXDevice:ok", null);
                    } else {
                        x.e("MicroMsg.MsgHandler", "stopScanWXDevice fail");
                        a(iVar, "stopScanWXDevice:fail", null);
                    }
                }
            } catch (Throwable e2) {
                x.printErrStackTrace("MicroMsg.MsgHandler", e2, "", new Object[0]);
                x.e("MicroMsg.MsgHandler", "stopScanWXDevice failed : %s", new Object[]{e2.getMessage()});
                a(iVar, "stopScanWXDevice:fail_exception", null);
            }
        } else {
            x.e("MicroMsg.MsgHandler", "stopScanWXDevice not init");
            a(iVar, "stopScanWXDevice:fail_notInit", null);
        }
        return true;
    }

    private boolean K(i iVar) {
        String str = "";
        if (iVar.mcy.containsKey("connType")) {
            str = (String) iVar.mcy.get("connType");
        }
        String Q;
        if (str.equalsIgnoreCase("lan")) {
            if (com.tencent.mm.plugin.webview.ui.tools.a.a.bWZ().hasInit) {
                str = (String) iVar.mcy.get("deviceId");
                x.i("MicroMsg.MsgHandler", "doConnectWXDevice, deviceId : %s", new Object[]{str});
                if (bi.oW(str)) {
                    x.e("MicroMsg.MsgHandler", "deviceId is null");
                    a(iVar, "connectWXDevice:fail_noDeviceId", null);
                } else {
                    Q = Q(iVar);
                    com.tencent.mm.plugin.report.service.h.mEJ.h(11533, new Object[]{Q, "connectWXDevice"});
                    if (bi.oW(Q)) {
                        a(iVar, "connectWXDevice:fail_UsernameError", null);
                    } else {
                        if (!(this.qhV == null || this.qhV.containsKey(Q))) {
                            this.qhV.put(Q, str);
                        }
                        try {
                            db dbVar = new db();
                            dbVar.bKF.bKD = true;
                            dbVar.bKF.bKC = Q;
                            dbVar.bKF.byN = str;
                            com.tencent.mm.sdk.b.a.sFg.m(dbVar);
                            if (dbVar.bKG.bKE) {
                                a(iVar, "connectWXDevice:ok", null);
                            } else {
                                a(iVar, "connectWXDevice:fail", null);
                            }
                        } catch (Exception e) {
                            x.e("MicroMsg.MsgHandler", "connectWXDevice failed : %s", new Object[]{e.getMessage()});
                            a(iVar, "connectWXDevice:fail_exception", null);
                        }
                    }
                }
            } else {
                x.e("MicroMsg.MsgHandler", "connectWXDevice not init");
                a(iVar, "connectWXDevice:fail_notInit", null);
            }
        } else if (com.tencent.mm.plugin.webview.ui.tools.a.b.bXc().hasInit) {
            str = (String) iVar.mcy.get("deviceId");
            x.i("MicroMsg.MsgHandler", "doConnectWXDevice, deviceId : %s", new Object[]{str});
            if (bi.oW(str)) {
                x.e("MicroMsg.MsgHandler", "deviceId is null");
                a(iVar, "connectWXDevice:fail_noDeviceId", null);
            } else {
                Q = Q(iVar);
                com.tencent.mm.plugin.report.service.h.mEJ.h(11533, new Object[]{Q, "connectWXDevice"});
                if (bi.oW(Q)) {
                    a(iVar, "connectWXDevice:fail_UsernameError", null);
                } else {
                    if (!(this.qhU == null || this.qhU.containsValue(str))) {
                        this.qhU.put(Q, str);
                    }
                    try {
                        da daVar = new da();
                        daVar.bKA.bKD = true;
                        daVar.bKA.bKC = Q;
                        daVar.bKA.byN = str;
                        com.tencent.mm.sdk.b.a.sFg.m(daVar);
                        if (daVar.bKB.bKE) {
                            a(iVar, "connectWXDevice:ok", null);
                        } else {
                            a(iVar, "connectWXDevice:fail", null);
                        }
                    } catch (Exception e2) {
                        x.e("MicroMsg.MsgHandler", "connectWXDevice failed : %s", new Object[]{e2.getMessage()});
                        a(iVar, "connectWXDevice:fail_exception", null);
                    }
                }
            }
        } else {
            x.e("MicroMsg.MsgHandler", "connectWXDevice not init");
            a(iVar, "connectWXDevice:fail_notInit", null);
        }
        return true;
    }

    private boolean L(i iVar) {
        String str = "";
        if (iVar.mcy.containsKey("connType")) {
            str = (String) iVar.mcy.get("connType");
        }
        String Q;
        if (str.equalsIgnoreCase("lan")) {
            if (com.tencent.mm.plugin.webview.ui.tools.a.a.bWZ().hasInit) {
                str = (String) iVar.mcy.get("deviceId");
                x.i("MicroMsg.MsgHandler", "doDisconnectWXDevice, deviceId : %s", new Object[]{str});
                if (bi.oW(str)) {
                    x.e("MicroMsg.MsgHandler", "deviceId is null");
                    a(iVar, "disconnectWXDevice:fail_noDeviceId", null);
                } else {
                    Q = Q(iVar);
                    com.tencent.mm.plugin.report.service.h.mEJ.h(11533, new Object[]{Q, "disconnectWXDevice"});
                    if (bi.oW(Q)) {
                        a(iVar, "disconnectWXDevice:fail_UsernameError", null);
                    } else {
                        try {
                            db dbVar = new db();
                            dbVar.bKF.bKD = false;
                            dbVar.bKF.bKC = Q;
                            dbVar.bKF.byN = str;
                            com.tencent.mm.sdk.b.a.sFg.m(dbVar);
                            if (dbVar.bKG.bKE) {
                                a(iVar, "disconnectWXDevice:ok", null);
                                if (this.qhV != null && this.qhV.containsKey(Q)) {
                                    this.qhV.remove(Q);
                                }
                            } else {
                                a(iVar, "disconnectWXDevice:fail", null);
                            }
                        } catch (Exception e) {
                            x.e("MicroMsg.MsgHandler", "disconnectWXDevice failed : %s", new Object[]{e.getMessage()});
                            a(iVar, "disconnectWXDevice:fail_exception", null);
                        }
                    }
                }
            } else {
                x.e("MicroMsg.MsgHandler", "disconnectWXDevice  not init");
                a(iVar, "disconnectWXDevice:fail_notInit", null);
            }
        } else if (com.tencent.mm.plugin.webview.ui.tools.a.b.bXc().hasInit) {
            str = (String) iVar.mcy.get("deviceId");
            x.i("MicroMsg.MsgHandler", "doDisconnectWXDevice, deviceId : %s", new Object[]{str});
            if (bi.oW(str)) {
                x.e("MicroMsg.MsgHandler", "deviceId is null");
                a(iVar, "disconnectWXDevice:fail_noDeviceId", null);
            } else {
                Q = Q(iVar);
                com.tencent.mm.plugin.report.service.h.mEJ.h(11533, new Object[]{Q, "disconnectWXDevice"});
                if (bi.oW(Q)) {
                    a(iVar, "disconnectWXDevice:fail_UsernameError", null);
                } else {
                    try {
                        da daVar = new da();
                        daVar.bKA.bKD = false;
                        daVar.bKA.bKC = Q;
                        daVar.bKA.byN = str;
                        com.tencent.mm.sdk.b.a.sFg.m(daVar);
                        if (daVar.bKB.bKE) {
                            a(iVar, "disconnectWXDevice:ok", null);
                            if (this.qhU != null && this.qhU.containsKey(Q)) {
                                this.qhU.remove(Q);
                            }
                        } else {
                            a(iVar, "disconnectWXDevice:fail", null);
                        }
                    } catch (Exception e2) {
                        x.e("MicroMsg.MsgHandler", "disconnectWXDevice failed : %s", new Object[]{e2.getMessage()});
                        a(iVar, "disconnectWXDevice:fail_exception", null);
                    }
                }
            }
        } else {
            x.e("MicroMsg.MsgHandler", "disconnectWXDevice  not init");
            a(iVar, "disconnectWXDevice:fail_notInit", null);
        }
        return true;
    }

    private boolean M(i iVar) {
        if (com.tencent.mm.plugin.webview.ui.tools.a.b.bXc().hasInit || com.tencent.mm.plugin.webview.ui.tools.a.a.bWZ().hasInit) {
            String str = (String) iVar.mcy.get("deviceId");
            String str2 = (String) iVar.mcy.get(DownloadSettingTable$Columns.TYPE);
            x.i("MicroMsg.MsgHandler", "doGetWXDeviceTicket, deviceId : %s, type : %s", new Object[]{str, str2});
            if (bi.oW(str) || bi.oW(str2)) {
                x.e("MicroMsg.MsgHandler", "deviceId or type is null");
                a(iVar, "getWXDeviceTicket:fail_wrongParams", null);
            } else {
                try {
                    String Q = Q(iVar);
                    com.tencent.mm.plugin.report.service.h.mEJ.h(11533, new Object[]{Q, "getWXDeviceTicket"});
                    if (bi.oW(Q)) {
                        a(iVar, "getWXDeviceTicket:fail_UsernameError", null);
                    } else {
                        di diVar = new di();
                        diVar.bLa.type = bi.getInt(str2, 0);
                        diVar.bLa.bKC = Q;
                        diVar.bLa.byN = str;
                        diVar.bLa.bLc = iVar.qkj;
                        diVar.bJX = new 55(this, diVar, iVar);
                        com.tencent.mm.sdk.b.a.sFg.a(diVar, Looper.getMainLooper());
                    }
                } catch (Exception e) {
                    x.e("MicroMsg.MsgHandler", "getWXDeviceTicket failed : %s", new Object[]{e.getMessage()});
                    a(iVar, "getWXDeviceTicket:fail_exception", null);
                }
            }
        } else {
            x.e("MicroMsg.MsgHandler", "getWXDeviceTicket not init");
            a(iVar, "getWXDeviceTicket:fail_notInit", null);
        }
        return true;
    }

    private boolean N(i iVar) {
        String str = "";
        if (iVar.mcy.containsKey("connType")) {
            str = (String) iVar.mcy.get("connType");
        }
        Map hashMap;
        if (str.equalsIgnoreCase("lan")) {
            if (com.tencent.mm.plugin.webview.ui.tools.a.a.bWZ().hasInit) {
                try {
                    str = Q(iVar);
                    com.tencent.mm.plugin.report.service.h.mEJ.h(11533, new Object[]{str, "getWXDeviceInfos"});
                    x.i("MicroMsg.MsgHandler", "doGetWXDeviceInfos, %s", new Object[]{str});
                    if (bi.oW(str)) {
                        a(iVar, "getWXDeviceInfos:fail_UsernameError", null);
                    } else {
                        dg dgVar = new dg();
                        dgVar.bKS.bKC = str;
                        dgVar.bKS.context = this.context;
                        com.tencent.mm.sdk.b.a.sFg.m(dgVar);
                        if (!dgVar.bKT.bKE || dgVar.bKT.bKR == null) {
                            a(iVar, "getWXDeviceInfos:fail", null);
                        } else {
                            hashMap = new HashMap();
                            hashMap.put("jsapi_callback_json_special_key", "deviceInfos");
                            hashMap.put("deviceInfos", dgVar.bKT.bKR.toString());
                            a(iVar, "getWXDeviceInfos:ok", hashMap);
                        }
                    }
                } catch (Exception e) {
                    x.e("MicroMsg.MsgHandler", "getWXDeviceInfos failed : %s", new Object[]{e.getMessage()});
                    a(iVar, "getWXDeviceInfos:fail_exception", null);
                }
            } else {
                x.e("MicroMsg.MsgHandler", "getWXDeviceInfos not init");
                a(iVar, "getWXDeviceInfos:fail_notInit", null);
            }
        } else if (com.tencent.mm.plugin.webview.ui.tools.a.b.bXc().hasInit) {
            try {
                str = Q(iVar);
                com.tencent.mm.plugin.report.service.h.mEJ.h(11533, new Object[]{str, "getWXDeviceInfos"});
                x.i("MicroMsg.MsgHandler", "doGetWXDeviceInfos, %s", new Object[]{str});
                if (bi.oW(str)) {
                    a(iVar, "getWXDeviceInfos:fail_UsernameError", null);
                } else {
                    df dfVar = new df();
                    dfVar.bKP.bKC = str;
                    dfVar.bKP.context = this.context;
                    com.tencent.mm.sdk.b.a.sFg.m(dfVar);
                    if (!dfVar.bKQ.bKE || dfVar.bKQ.bKR == null) {
                        a(iVar, "getWXDeviceInfos:fail", null);
                    } else {
                        hashMap = new HashMap();
                        hashMap.put("jsapi_callback_json_special_key", "deviceInfos");
                        hashMap.put("deviceInfos", dfVar.bKQ.bKR.toString());
                        a(iVar, "getWXDeviceInfos:ok", hashMap);
                    }
                }
            } catch (Exception e2) {
                x.e("MicroMsg.MsgHandler", "getWXDeviceInfos failed : %s", new Object[]{e2.getMessage()});
                a(iVar, "getWXDeviceInfos:fail_exception", null);
            }
        } else {
            x.e("MicroMsg.MsgHandler", "getWXDeviceInfos not init");
            a(iVar, "getWXDeviceInfos:fail_notInit", null);
        }
        return true;
    }

    private boolean O(i iVar) {
        String str = "";
        if (iVar.mcy.containsKey("connType")) {
            str = (String) iVar.mcy.get("connType");
        }
        String str2;
        String str3;
        String str4;
        Object[] objArr;
        boolean z;
        String Q;
        if (str.equalsIgnoreCase("lan")) {
            if (com.tencent.mm.plugin.webview.ui.tools.a.a.bWZ().hasInit) {
                str = (String) iVar.mcy.get("deviceId");
                str2 = (String) iVar.mcy.get("base64Data");
                str3 = "MicroMsg.MsgHandler";
                str4 = "doSendDataToWXDevice, deviceId : %s, has data : %s";
                objArr = new Object[2];
                objArr[0] = str;
                if (bi.oW(str2)) {
                    z = false;
                } else {
                    z = true;
                }
                objArr[1] = Boolean.valueOf(z);
                x.i(str3, str4, objArr);
                if (bi.oW(str) || str2 == null) {
                    x.e("MicroMsg.MsgHandler", "deviceId or data is null");
                    a(iVar, "sendDataToWXDevice:fail_wrongParams", null);
                } else {
                    try {
                        Q = Q(iVar);
                        com.tencent.mm.plugin.report.service.h.mEJ.h(11533, new Object[]{Q, "sendDataToWXDevice"});
                        if (bi.oW(Q)) {
                            a(iVar, "sendDataToWXDevice:fail_UsernameError", null);
                        } else {
                            eb ebVar = new eb();
                            ebVar.bLQ.bKC = Q;
                            ebVar.bLQ.data = str2;
                            ebVar.bLQ.byN = str;
                            com.tencent.mm.sdk.b.a.sFg.m(ebVar);
                            if (ebVar.bLR.bKE) {
                                a(iVar, "sendDataToWXDevice:ok", null);
                            } else {
                                a(iVar, "sendDataToWXDevice:fail", null);
                            }
                        }
                    } catch (Exception e) {
                        x.e("MicroMsg.MsgHandler", "sendDataToWXDevice failed : %s", new Object[]{e.getMessage()});
                        a(iVar, "sendDataToWXDevice:fail_exception", null);
                    }
                }
            } else {
                x.e("MicroMsg.MsgHandler", "sendDataToWXDevice not init");
                a(iVar, "sendDataToWXDevice:fail_notInit", null);
            }
        } else if (com.tencent.mm.plugin.webview.ui.tools.a.b.bXc().hasInit) {
            str = (String) iVar.mcy.get("deviceId");
            str2 = (String) iVar.mcy.get("base64Data");
            str3 = "MicroMsg.MsgHandler";
            str4 = "doSendDataToWXDevice, deviceId : %s, has data : %s";
            objArr = new Object[2];
            objArr[0] = str;
            if (bi.oW(str2)) {
                z = false;
            } else {
                z = true;
            }
            objArr[1] = Boolean.valueOf(z);
            x.i(str3, str4, objArr);
            if (bi.oW(str) || str2 == null) {
                x.e("MicroMsg.MsgHandler", "deviceId or data is null");
                a(iVar, "sendDataToWXDevice:fail_wrongParams", null);
            } else {
                try {
                    Q = Q(iVar);
                    com.tencent.mm.plugin.report.service.h.mEJ.h(11533, new Object[]{Q, "sendDataToWXDevice"});
                    if (bi.oW(Q)) {
                        a(iVar, "sendDataToWXDevice:fail_UsernameError", null);
                    } else {
                        ea eaVar = new ea();
                        eaVar.bLO.bKC = Q;
                        eaVar.bLO.data = Base64.decode(str2, 0);
                        eaVar.bLO.byN = str;
                        com.tencent.mm.sdk.b.a.sFg.m(eaVar);
                        if (eaVar.bLP.bKE) {
                            a(iVar, "sendDataToWXDevice:ok", null);
                        } else {
                            a(iVar, "sendDataToWXDevice:fail", null);
                        }
                    }
                } catch (Exception e2) {
                    x.e("MicroMsg.MsgHandler", "sendDataToWXDevice failed : %s", new Object[]{e2.getMessage()});
                    a(iVar, "sendDataToWXDevice:fail_exception", null);
                }
            }
        } else {
            x.e("MicroMsg.MsgHandler", "sendDataToWXDevice not init");
            a(iVar, "sendDataToWXDevice:fail_notInit", null);
        }
        return true;
    }

    private boolean P(i iVar) {
        if (com.tencent.mm.plugin.webview.ui.tools.a.b.bXc().hasInit) {
            try {
                String str = (String) iVar.mcy.get("deviceId");
                String str2 = (String) iVar.mcy.get(TencentLocation.EXTRA_DIRECTION);
                x.i("MicroMsg.MsgHandler", "setSendDataDirection, deviceId = %s, direction = %s", new Object[]{str, str2});
                if (bi.oW(str) || bi.oW(str2)) {
                    x.e("MicroMsg.MsgHandler", "wrong args");
                    a(iVar, "setSendDataDirection:fail_wrongParams", null);
                } else {
                    int i = bi.getInt(str2, 0);
                    String Q = Q(iVar);
                    com.tencent.mm.plugin.report.service.h.mEJ.h(11533, new Object[]{Q, "setSendDataDirection"});
                    if (bi.oW(Q)) {
                        a(iVar, "setSendDataDirection:fail_UsernameError", null);
                    } else {
                        ee eeVar = new ee();
                        eeVar.bMa.byN = str;
                        eeVar.bMa.direction = i;
                        eeVar.bMa.clear = false;
                        com.tencent.mm.sdk.b.a.sFg.m(eeVar);
                        if (eeVar.bMb.bKE) {
                            a(iVar, "setSendDataDirection:ok", null);
                        } else {
                            a(iVar, "setSendDataDirection:fail", null);
                        }
                    }
                }
            } catch (Exception e) {
                x.e("MicroMsg.MsgHandler", "setSendDataDirection failed : %s", new Object[]{e.getMessage()});
                a(iVar, "setSendDataDirection:fail_exception", null);
            }
        } else {
            x.e("MicroMsg.MsgHandler", "setSendDataDirection not init");
            a(iVar, "setSendDataDirection:fail_notInit", null);
        }
        return true;
    }

    public final String bYg() {
        try {
            if (this.pRY == null) {
                return null;
            }
            Bundle g = this.pRY.g(18, null);
            if (g != null) {
                return g.getString("preChatName");
            }
            return null;
        } catch (RemoteException e) {
            x.e("MicroMsg.MsgHandler", "invokeAsResult error.%s", new Object[]{e});
            return null;
        }
    }

    public final int bVC() {
        try {
            if (this.pRY == null) {
                return -1;
            }
            Bundle g = this.pRY.g(22, null);
            if (g != null) {
                return g.getInt("pay_channel");
            }
            return -1;
        } catch (RemoteException e) {
            x.e("MicroMsg.MsgHandler", "invokeAsResult error.%s", new Object[]{e});
            return -1;
        }
    }

    public final int aUM() {
        try {
            if (this.pRY == null) {
                return 0;
            }
            Bundle g = this.pRY.g(25, null);
            if (g != null) {
                return g.getInt("scene");
            }
            return 0;
        } catch (RemoteException e) {
            x.e("MicroMsg.MsgHandler", "invokeAsResult error.%s", new Object[]{e});
            return 0;
        }
    }

    private int akt() {
        try {
            if (this.pRY == null) {
                return 0;
            }
            Bundle g = this.pRY.g(99, null);
            if (g != null) {
                return g.getInt("geta8key_scene");
            }
            return 0;
        } catch (RemoteException e) {
            x.e("MicroMsg.MsgHandler", "invokeAsResult error.%s", new Object[]{e});
            return 0;
        }
    }

    private String Q(i iVar) {
        String bYg = bYg();
        if (aUM() == 27) {
            return this.qhT;
        }
        String str;
        if (bVC() == 8 || bVC() == -1) {
            if (iVar == null) {
                return null;
            }
            str = (String) iVar.mcy.get("src_username");
            x.i("MicroMsg.MsgHandler", "key_src_username(%s)", new Object[]{(String) iVar.mcy.get("src_username")});
            return str;
        } else if (this.hpJ != null) {
            return this.hpJ;
        } else {
            if (bi.oW(bYg)) {
                return null;
            }
            x.i("MicroMsg.MsgHandler", "BrandUsername in H5 is null, check if it is in hardBiz chat");
            com.tencent.mm.ac.d kH = com.tencent.mm.ac.f.kH(bYg);
            if (kH == null) {
                return null;
            }
            d$b bG = kH.bG(false);
            if (bG == null || bG.Ms() == null || !bG.Ms().MC()) {
                return null;
            }
            str = (String) iVar.mcy.get("src_username");
            x.i("MicroMsg.MsgHandler", "HardBiz chat, key_src_username(%s)", new Object[]{(String) iVar.mcy.get("src_username")});
            return str;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean R(com.tencent.mm.plugin.webview.ui.tools.jsapi.i r14) {
        /*
        r13 = this;
        r6 = 7;
        r12 = 2;
        r2 = 3;
        r11 = 1;
        r5 = 0;
        r0 = r14.mcy;
        r1 = "sourceType";
        r0 = r0.get(r1);
        r0 = (java.lang.String) r0;
        r1 = "MicroMsg.MsgHandler";
        r3 = "source Type = %s";
        r4 = new java.lang.Object[r11];
        r4[r5] = r0;
        com.tencent.mm.sdk.platformtools.x.i(r1, r3, r4);
        r1 = com.tencent.mm.sdk.platformtools.bi.oW(r0);
        if (r1 != 0) goto L_0x019a;
    L_0x0023:
        r3 = new org.json.JSONArray;	 Catch:{ Exception -> 0x0052 }
        r3.<init>(r0);	 Catch:{ Exception -> 0x0052 }
        r1 = r5;
        r0 = r5;
    L_0x002a:
        r4 = r3.length();	 Catch:{ Exception -> 0x0191 }
        if (r1 >= r4) goto L_0x005d;
    L_0x0030:
        r4 = r3.getString(r1);	 Catch:{ Exception -> 0x0191 }
        r7 = "album";
        r4 = r4.equals(r7);	 Catch:{ Exception -> 0x0191 }
        if (r4 == 0) goto L_0x0042;
    L_0x003d:
        r0 = r0 | 1;
    L_0x003f:
        r1 = r1 + 1;
        goto L_0x002a;
    L_0x0042:
        r4 = r3.getString(r1);	 Catch:{ Exception -> 0x0191 }
        r7 = "camera";
        r4 = r4.equals(r7);	 Catch:{ Exception -> 0x0191 }
        if (r4 == 0) goto L_0x003f;
    L_0x004f:
        r0 = r0 | 2;
        goto L_0x003f;
    L_0x0052:
        r0 = move-exception;
        r0 = r5;
    L_0x0054:
        r1 = "MicroMsg.MsgHandler";
        r3 = "doChooseImage: sizeType parsing error";
        com.tencent.mm.sdk.platformtools.x.e(r1, r3);
    L_0x005d:
        if (r0 != 0) goto L_0x0197;
    L_0x005f:
        r1 = r2;
    L_0x0060:
        r0 = "MicroMsg.MsgHandler";
        r3 = "real scene = %d";
        r4 = new java.lang.Object[r11];
        r7 = java.lang.Integer.valueOf(r1);
        r4[r5] = r7;
        com.tencent.mm.sdk.platformtools.x.i(r0, r3, r4);
        if (r1 == r12) goto L_0x0075;
    L_0x0073:
        if (r1 != r2) goto L_0x009c;
    L_0x0075:
        r0 = r13.context;
        r0 = (android.app.Activity) r0;
        r3 = "android.permission.CAMERA";
        r4 = 113; // 0x71 float:1.58E-43 double:5.6E-322;
        r7 = "";
        r8 = "";
        r0 = com.tencent.mm.pluginsdk.permission.a.a(r0, r3, r4, r7, r8);
        r3 = "MicroMsg.MsgHandler";
        r4 = " checkPermission checkcamera[%b]";
        r7 = new java.lang.Object[r11];
        r8 = java.lang.Boolean.valueOf(r0);
        r7[r5] = r8;
        com.tencent.mm.sdk.platformtools.x.d(r3, r4, r7);
        if (r0 != 0) goto L_0x009c;
    L_0x009b:
        return r11;
    L_0x009c:
        r0 = r14.mcy;
        r3 = "count";
        r0 = r0.get(r3);
        r0 = (java.lang.String) r0;
        r8 = com.tencent.mm.sdk.platformtools.bi.getInt(r0, r5);
        r0 = r14.mcy;
        r3 = "sizeType";
        r0 = r0.get(r3);
        r0 = (java.lang.String) r0;
        r3 = java.lang.Boolean.valueOf(r5);
        r4 = java.lang.Boolean.valueOf(r5);
        r7 = com.tencent.mm.sdk.platformtools.bi.oW(r0);
        if (r7 != 0) goto L_0x0194;
    L_0x00c4:
        r9 = new org.json.JSONArray;	 Catch:{ Exception -> 0x00fa }
        r9.<init>(r0);	 Catch:{ Exception -> 0x00fa }
        r7 = r5;
        r0 = r4;
    L_0x00cb:
        r4 = r9.length();	 Catch:{ Exception -> 0x018e }
        if (r7 >= r4) goto L_0x0105;
    L_0x00d1:
        r4 = r9.getString(r7);	 Catch:{ Exception -> 0x018e }
        r10 = "original";
        r4 = r4.equals(r10);	 Catch:{ Exception -> 0x018e }
        if (r4 == 0) goto L_0x00e7;
    L_0x00de:
        r4 = 1;
        r3 = java.lang.Boolean.valueOf(r4);	 Catch:{ Exception -> 0x018e }
    L_0x00e3:
        r4 = r7 + 1;
        r7 = r4;
        goto L_0x00cb;
    L_0x00e7:
        r4 = r9.getString(r7);	 Catch:{ Exception -> 0x018e }
        r10 = "compressed";
        r4 = r4.equals(r10);	 Catch:{ Exception -> 0x018e }
        if (r4 == 0) goto L_0x00e3;
    L_0x00f4:
        r4 = 1;
        r0 = java.lang.Boolean.valueOf(r4);	 Catch:{ Exception -> 0x018e }
        goto L_0x00e3;
    L_0x00fa:
        r0 = move-exception;
        r0 = r4;
    L_0x00fc:
        r4 = "MicroMsg.MsgHandler";
        r7 = "doChooseImage: sizeType parsing error";
        com.tencent.mm.sdk.platformtools.x.e(r4, r7);
    L_0x0105:
        r4 = r3.booleanValue();
        if (r4 == 0) goto L_0x0174;
    L_0x010b:
        r4 = r0.booleanValue();
        if (r4 != 0) goto L_0x0174;
    L_0x0111:
        r0 = java.lang.Boolean.valueOf(r11);
        r4 = r6;
    L_0x0116:
        r3 = new android.content.Intent;
        r3.<init>();
        r6 = "key_pick_local_pic_capture";
        r3.putExtra(r6, r1);
        r6 = "key_pick_local_pic_count";
        r3.putExtra(r6, r8);
        r6 = "key_pick_local_pic_query_source_type";
        r3.putExtra(r6, r4);
        r6 = "key_pick_local_pic_send_raw";
        r3.putExtra(r6, r0);
        r6 = "query_media_type";
        r3.putExtra(r6, r11);
        r6 = "MicroMsg.MsgHandler";
        r7 = "doChooseImage: realScene: %d, count: %d, querySourceType: %d, sendRaw: %b";
        r9 = 4;
        r9 = new java.lang.Object[r9];
        r1 = java.lang.Integer.valueOf(r1);
        r9[r5] = r1;
        r1 = java.lang.Integer.valueOf(r8);
        r9[r11] = r1;
        r1 = java.lang.Integer.valueOf(r4);
        r9[r12] = r1;
        r9[r2] = r0;
        com.tencent.mm.sdk.platformtools.x.i(r6, r7, r9);
        r0 = r13.context;
        r0 = r0 instanceof com.tencent.mm.ui.MMActivity;
        if (r0 == 0) goto L_0x009b;
    L_0x015f:
        r0 = r13.context;
        r0 = (com.tencent.mm.ui.MMActivity) r0;
        r0.geJ = r13;
        r0 = r13.context;
        r1 = "webview";
        r2 = ".ui.tools.OpenFileChooserUI";
        r4 = 14;
        com.tencent.mm.bg.d.a(r0, r1, r2, r3, r4, r5);
        goto L_0x009b;
    L_0x0174:
        r3 = r3.booleanValue();
        if (r3 != 0) goto L_0x0186;
    L_0x017a:
        r0 = r0.booleanValue();
        if (r0 == 0) goto L_0x0186;
    L_0x0180:
        r0 = java.lang.Boolean.valueOf(r5);
        r4 = r6;
        goto L_0x0116;
    L_0x0186:
        r3 = 8;
        r0 = java.lang.Boolean.valueOf(r5);
        r4 = r3;
        goto L_0x0116;
    L_0x018e:
        r4 = move-exception;
        goto L_0x00fc;
    L_0x0191:
        r1 = move-exception;
        goto L_0x0054;
    L_0x0194:
        r0 = r4;
        goto L_0x0105;
    L_0x0197:
        r1 = r0;
        goto L_0x0060;
    L_0x019a:
        r0 = r5;
        goto L_0x005d;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.webview.ui.tools.jsapi.g.R(com.tencent.mm.plugin.webview.ui.tools.jsapi.i):boolean");
    }

    private boolean S(i iVar) {
        boolean z;
        String str = (String) iVar.mcy.get("appId");
        String str2 = (String) iVar.mcy.get("localId");
        Object obj = iVar.mcy.get("isShowProgressTips");
        if (obj != null) {
            try {
                z = bi.getInt(obj.toString(), 0) == 1;
            } catch (Exception e) {
                x.w("MicroMsg.MsgHandler", "Exception has occured : %s", new Object[]{e.getMessage()});
            }
            l.a(iVar.qkk, false, null, str);
            x.i("MicroMsg.MsgHandler", "upload local image, appid = %s, localid = %s, isShowProgressTips(%s)", new Object[]{str, str2, Boolean.valueOf(z)});
            if (!bi.oW(str) || bi.oW(str2)) {
                x.e("MicroMsg.MsgHandler", "appId or localid is null or nil.");
                a(iVar, "uploadImage:fail_missing arguments", null);
            } else {
                a(iVar, str, str2, com.tencent.mm.modelcdntran.b.MediaType_FILE, 0, 0, "uploadImage", z);
            }
            return true;
        }
        z = true;
        l.a(iVar.qkk, false, null, str);
        x.i("MicroMsg.MsgHandler", "upload local image, appid = %s, localid = %s, isShowProgressTips(%s)", new Object[]{str, str2, Boolean.valueOf(z)});
        if (bi.oW(str)) {
        }
        x.e("MicroMsg.MsgHandler", "appId or localid is null or nil.");
        a(iVar, "uploadImage:fail_missing arguments", null);
        return true;
    }

    private boolean T(final i iVar) {
        boolean z;
        String str = (String) iVar.mcy.get("appId");
        final String str2 = (String) iVar.mcy.get("serverId");
        Object obj = iVar.mcy.get("isShowProgressTips");
        if (obj != null) {
            try {
                z = bi.getInt(obj.toString(), 0) == 1;
            } catch (Exception e) {
                x.w("MicroMsg.MsgHandler", "Exception has occured : %s", new Object[]{e.getMessage()});
            }
            l.a(iVar.qkk, false, null, str);
            x.i("MicroMsg.MsgHandler", "doDownLoadImage, appid is : %s, media id is : %s", new Object[]{str, str2});
            if (!bi.oW(str) || bi.oW(str2)) {
                a(iVar, "downloadImage:fail_missing arguments", null);
            } else {
                final AnonymousClass57 anonymousClass57 = new com.tencent.mm.plugin.webview.model.d.b() {
                    public final void a(boolean z, String str, String str2, String str3) {
                        x.i("MicroMsg.MsgHandler", "doDownLoadImage, on cdn finish, is success : %b, local id : %s, media id is : %s", new Object[]{Boolean.valueOf(z), str, str2});
                        if (!bi.oW(str2) && str2.equals(str2)) {
                            com.tencent.mm.plugin.webview.modeltools.e.bUW().a(this);
                            if (g.this.eHw != null) {
                                g.this.eHw.dismiss();
                                g.this.eHw = null;
                            }
                            if (z) {
                                WebViewJSSDKFileItem Qq = com.tencent.mm.plugin.webview.modeltools.e.bUX().Qq(str);
                                if ((Qq instanceof WebViewJSSDKImageItem) && bi.oW(Qq.fOs)) {
                                    ((WebViewJSSDKImageItem) Qq).bUl();
                                }
                                Map hashMap = new HashMap();
                                hashMap.put("localId", str);
                                g.this.a(iVar, "downloadImage:ok", hashMap);
                                return;
                            }
                            g.this.a(iVar, "downloadImage:fail", null);
                        }
                    }
                };
                com.tencent.mm.plugin.webview.modeltools.e.bUW().a(str, str2, anonymousClass57);
                x.i("MicroMsg.MsgHandler", "doDownLoadImage, add cdn download task result : %b", new Object[]{Boolean.valueOf(true)});
                if (z) {
                    Context context = this.context;
                    this.context.getString(R.l.app_tip);
                    this.eHw = com.tencent.mm.ui.base.h.a(context, this.context.getString(R.l.wv_downloading), true, new OnCancelListener() {
                        public final void onCancel(DialogInterface dialogInterface) {
                            com.tencent.mm.plugin.webview.modeltools.e.bUW().a(anonymousClass57);
                            com.tencent.mm.plugin.webview.modeltools.e.bUW();
                            com.tencent.mm.plugin.webview.model.ad.Qm(str2);
                            g.this.a(iVar, "downloadImage:fail", null);
                        }
                    });
                }
            }
            return true;
        }
        z = true;
        l.a(iVar.qkk, false, null, str);
        x.i("MicroMsg.MsgHandler", "doDownLoadImage, appid is : %s, media id is : %s", new Object[]{str, str2});
        if (bi.oW(str)) {
        }
        a(iVar, "downloadImage:fail_missing arguments", null);
        return true;
    }

    private boolean U(i iVar) {
        boolean z;
        x.i("MicroMsg.MsgHandler", "doUploadEncryptMediaFile()");
        String str = (String) iVar.mcy.get("appId");
        String str2 = (String) iVar.mcy.get("localId");
        Object obj = iVar.mcy.get("isShowProgressTips");
        if (obj != null) {
            try {
                z = bi.getInt(obj.toString(), 0) == 1;
            } catch (Exception e) {
                x.w("MicroMsg.MsgHandler", "Exception has occured : %s", new Object[]{e.getMessage()});
            }
            x.i("MicroMsg.MsgHandler", "doUploadEncryptMediaFile, appid = %s, localid = %s, isShowProgressTips(%s)", new Object[]{str, str2, Boolean.valueOf(z)});
            if (bi.oW(str) && !bi.oW(str2)) {
                l.a(iVar.qkk, false, null, str);
                WebViewJSSDKFileItem Qq = com.tencent.mm.plugin.webview.modeltools.e.bUX().Qq(str2);
                if (Qq != null) {
                    switch (Qq.bMT) {
                        case 1:
                            a(iVar, str, str2, com.tencent.mm.modelcdntran.b.dOo, 0, 0, "uploadEncryptMediaFile", z);
                            break;
                        case 4:
                            b(iVar, str, str2, com.tencent.mm.modelcdntran.b.dOo, 0, 0, "uploadEncryptMediaFile", z);
                            break;
                        default:
                            b(iVar, str, str2, com.tencent.mm.modelcdntran.b.dOo, 0, 0, "uploadEncryptMediaFile", z);
                            break;
                    }
                }
                x.e("MicroMsg.MsgHandler", "jssdk file item is null for localId:%s", new Object[]{str2});
                a(iVar, "uploadEncryptMediaFile:file_not_exist", null);
            } else {
                x.e("MicroMsg.MsgHandler", "appId or localid is null");
                a(iVar, "uploadEncryptMediaFile:fail_missing arguments", null);
            }
            return true;
        }
        z = true;
        x.i("MicroMsg.MsgHandler", "doUploadEncryptMediaFile, appid = %s, localid = %s, isShowProgressTips(%s)", new Object[]{str, str2, Boolean.valueOf(z)});
        if (bi.oW(str)) {
        }
        x.e("MicroMsg.MsgHandler", "appId or localid is null");
        a(iVar, "uploadEncryptMediaFile:fail_missing arguments", null);
        return true;
    }

    private boolean V(i iVar) {
        x.i("MicroMsg.MsgHandler", "doChooseMedia()");
        x.i("MicroMsg.MsgHandler", " checkPermission checkcamera[%b]", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.permission.a.a((Activity) this.context, "android.permission.CAMERA", 119, "", ""))});
        if (!com.tencent.mm.pluginsdk.permission.a.a((Activity) this.context, "android.permission.CAMERA", 119, "", "")) {
            return true;
        }
        x.i("MicroMsg.MsgHandler", " checkPermission checkMicroPhone[%b]", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.permission.a.a((Activity) this.context, "android.permission.RECORD_AUDIO", 120, "", ""))});
        if (!com.tencent.mm.pluginsdk.permission.a.a((Activity) this.context, "android.permission.RECORD_AUDIO", 120, "", "")) {
            return true;
        }
        int i;
        String str;
        String oV = bi.oV((String) iVar.mcy.get("sourceType"));
        String oV2 = bi.oV((String) iVar.mcy.get("mediaType"));
        int min = Math.min(bi.getInt((String) iVar.mcy.get("maxDuration"), 10), 10);
        String oV3 = bi.oV((String) iVar.mcy.get("camera"));
        int i2 = bi.getInt((String) iVar.mcy.get("count"), 1);
        String oV4 = bi.oV((String) iVar.mcy.get("sizeType"));
        x.i("MicroMsg.MsgHandler", "doChooseMedia sourceType:%s, mediaType:%s, maxDuration:%d, camera:%s, count:%d, sizeType:%s", new Object[]{oV, oV2, Integer.valueOf(min), oV3, Integer.valueOf(i2), oV4});
        Intent intent = new Intent();
        intent.putExtra("key_pick_local_pic_count", i2);
        if (min <= 0) {
            i = 10;
        } else {
            i = min;
        }
        intent.putExtra("key_pick_local_media_duration", i);
        intent.putExtra("query_media_type", 3);
        intent.putExtra("key_pick_local_media_video_type", 2);
        intent.putExtra("key_pick_local_media_sight_type", oV2);
        intent.putExtra("key_pick_local_pic_query_source_type", (oV4.contains("original") ^ oV4.contains("compressed")) != 0 ? 7 : 8);
        intent.putExtra("key_pick_local_pic_send_raw", Boolean.valueOf(oV4.contains("compressed")));
        if (bi.oW(oV)) {
            str = "album|camera";
        } else {
            str = oV;
        }
        if (str.contains("album") && str.contains("camera")) {
            k kVar = new k(this.context);
            kVar.b(null, new 60(this), new 61(this, oV3, intent));
            kVar.d(new 62(this, iVar));
            kVar.bEo();
            return true;
        } else if (str.contains("album")) {
            K(intent);
            return true;
        } else if (str.contains("camera")) {
            a(oV3, intent);
            return true;
        } else {
            a(iVar, "chooseMedia:fail_sourceType_error", null);
            return true;
        }
    }

    private void a(String str, Intent intent) {
        int i;
        x.i("MicroMsg.MsgHandler", "chooseMediaFromCamera");
        if (str.equals("front")) {
            i = 16;
        } else {
            i = GLIcon.TOP;
        }
        intent.putExtra("key_pick_local_pic_capture", i);
        ((MMActivity) this.context).geJ = this;
        com.tencent.mm.bg.d.a(this.context, "webview", ".ui.tools.OpenFileChooserUI", intent, 47, false);
    }

    private void K(Intent intent) {
        x.i("MicroMsg.MsgHandler", "chooseMediaFromAlbum");
        intent.putExtra("key_pick_local_pic_capture", GLIcon.LEFT);
        ((MMActivity) this.context).geJ = this;
        com.tencent.mm.bg.d.a(this.context, "webview", ".ui.tools.OpenFileChooserUI", intent, 47, false);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean a(com.tencent.mm.plugin.webview.ui.tools.jsapi.i r13, int r14) {
        /*
        r12 = this;
        r1 = 60;
        r11 = 3;
        r10 = 2;
        r5 = 0;
        r6 = 1;
        r0 = r13.mcy;
        r2 = "sourceType";
        r0 = r0.get(r2);
        r0 = (java.lang.String) r0;
        r3 = com.tencent.mm.sdk.platformtools.bi.oV(r0);
        r0 = r13.mcy;
        r2 = "camera";
        r0 = r0.get(r2);
        r0 = (java.lang.String) r0;
        r4 = com.tencent.mm.sdk.platformtools.bi.oV(r0);
        r0 = "MicroMsg.MsgHandler";
        r2 = "doChooseVideo sourceType = %s, camera = %s, isVideoType:%d";
        r7 = new java.lang.Object[r11];
        r7[r5] = r3;
        r7[r6] = r4;
        r8 = java.lang.Integer.valueOf(r14);
        r7[r10] = r8;
        com.tencent.mm.sdk.platformtools.x.i(r0, r2, r7);
        r0 = r13.mcy;
        r2 = "maxDuration";
        r0 = r0.get(r2);
        r0 = (java.lang.String) r0;
        r2 = com.tencent.mm.sdk.platformtools.bi.getInt(r0, r1);
        r0 = "album";
        r0 = r3.contains(r0);
        if (r0 == 0) goto L_0x01ba;
    L_0x0051:
        r0 = 4096; // 0x1000 float:5.74E-42 double:2.0237E-320;
    L_0x0053:
        r7 = "camera";
        r3 = r3.contains(r7);
        if (r3 == 0) goto L_0x0071;
    L_0x005c:
        if (r2 > 0) goto L_0x0066;
    L_0x005e:
        r0 = "chooseVideo:fail";
        r1 = 0;
        r12.a(r13, r0, r1);
    L_0x0065:
        return r6;
    L_0x0066:
        r3 = "front";
        r3 = r4.equals(r3);
        if (r3 == 0) goto L_0x0176;
    L_0x006f:
        r0 = r0 | 16;
    L_0x0071:
        if (r0 != 0) goto L_0x01b7;
    L_0x0073:
        r0 = 4352; // 0x1100 float:6.098E-42 double:2.15E-320;
        r7 = r0;
    L_0x0076:
        r0 = 16;
        if (r7 == r0) goto L_0x0082;
    L_0x007a:
        r0 = 256; // 0x100 float:3.59E-43 double:1.265E-321;
        if (r7 == r0) goto L_0x0082;
    L_0x007e:
        r0 = 4352; // 0x1100 float:6.098E-42 double:2.15E-320;
        if (r7 != r0) goto L_0x00d0;
    L_0x0082:
        if (r14 != r6) goto L_0x017a;
    L_0x0084:
        r0 = r12.context;
        r0 = (android.app.Activity) r0;
        r3 = "android.permission.CAMERA";
        r4 = 117; // 0x75 float:1.64E-43 double:5.8E-322;
        r8 = "";
        r9 = "";
        r0 = com.tencent.mm.pluginsdk.permission.a.a(r0, r3, r4, r8, r9);
        r3 = "MicroMsg.MsgHandler";
        r4 = " checkPermission checkcamera[%b]";
        r8 = new java.lang.Object[r6];
        r9 = java.lang.Boolean.valueOf(r0);
        r8[r5] = r9;
        com.tencent.mm.sdk.platformtools.x.d(r3, r4, r8);
        if (r0 == 0) goto L_0x0065;
    L_0x00aa:
        r0 = r12.context;
        r0 = (android.app.Activity) r0;
        r3 = "android.permission.RECORD_AUDIO";
        r4 = 118; // 0x76 float:1.65E-43 double:5.83E-322;
        r8 = "";
        r9 = "";
        r0 = com.tencent.mm.pluginsdk.permission.a.a(r0, r3, r4, r8, r9);
        r3 = "MicroMsg.MsgHandler";
        r4 = " checkPermission checkMicroPhone[%b]";
        r8 = new java.lang.Object[r6];
        r9 = java.lang.Boolean.valueOf(r0);
        r8[r5] = r9;
        com.tencent.mm.sdk.platformtools.x.d(r3, r4, r8);
        if (r0 == 0) goto L_0x0065;
    L_0x00d0:
        r0 = r13.mcy;
        r3 = "quality";
        r0 = r0.get(r3);
        r0 = (java.lang.String) r0;
        r0 = com.tencent.mm.sdk.platformtools.bi.getInt(r0, r6);
        if (r0 == 0) goto L_0x01b4;
    L_0x00e1:
        if (r0 == r6) goto L_0x01b4;
    L_0x00e3:
        r4 = r6;
    L_0x00e4:
        if (r2 <= r1) goto L_0x01b1;
    L_0x00e6:
        r0 = r1;
    L_0x00e7:
        r1 = "MicroMsg.MsgHandler";
        r2 = "doChooseVideo real scene = %d, select count = %d, video quality = %d, duration = %d";
        r3 = 4;
        r3 = new java.lang.Object[r3];
        r8 = java.lang.Integer.valueOf(r7);
        r3[r5] = r8;
        r8 = java.lang.Integer.valueOf(r6);
        r3[r6] = r8;
        r8 = java.lang.Integer.valueOf(r4);
        r3[r10] = r8;
        r8 = java.lang.Integer.valueOf(r0);
        r3[r11] = r8;
        com.tencent.mm.sdk.platformtools.x.i(r1, r2, r3);
        r3 = new android.content.Intent;
        r3.<init>();
        r1 = "key_pick_local_pic_capture";
        r3.putExtra(r1, r7);
        r1 = "key_pick_local_pic_count";
        r3.putExtra(r1, r6);
        r1 = "key_pick_local_pic_query_source_type";
        r2 = 7;
        r3.putExtra(r1, r2);
        r1 = "key_pick_local_media_quality";
        r3.putExtra(r1, r4);
        r1 = "key_pick_local_media_duration";
        r3.putExtra(r1, r0);
        r0 = "query_media_type";
        r3.putExtra(r0, r10);
        r0 = "key_pick_local_media_video_type";
        r3.putExtra(r0, r14);
        r0 = "MicroMsg.MsgHandler";
        r1 = "doChooseVideo: realScene: %d, count: %d, querySourceType: %d";
        r2 = new java.lang.Object[r11];
        r4 = java.lang.Integer.valueOf(r7);
        r2[r5] = r4;
        r4 = java.lang.Integer.valueOf(r6);
        r2[r6] = r4;
        r4 = 7;
        r4 = java.lang.Integer.valueOf(r4);
        r2[r10] = r4;
        com.tencent.mm.sdk.platformtools.x.i(r0, r1, r2);
        r0 = r12.context;
        r0 = r0 instanceof com.tencent.mm.ui.MMActivity;
        if (r0 == 0) goto L_0x0065;
    L_0x015f:
        r0 = r12.context;
        r0 = (com.tencent.mm.ui.MMActivity) r0;
        r0.geJ = r12;
        if (r14 != r6) goto L_0x01a2;
    L_0x0167:
        r0 = r12.context;
        r1 = "webview";
        r2 = ".ui.tools.OpenFileChooserUI";
        r4 = 45;
        com.tencent.mm.bg.d.a(r0, r1, r2, r3, r4, r5);
        goto L_0x0065;
    L_0x0176:
        r0 = r0 | 256;
        goto L_0x0071;
    L_0x017a:
        r0 = r12.context;
        r0 = (android.app.Activity) r0;
        r3 = "android.permission.CAMERA";
        r4 = 115; // 0x73 float:1.61E-43 double:5.7E-322;
        r8 = "";
        r9 = "";
        r0 = com.tencent.mm.pluginsdk.permission.a.a(r0, r3, r4, r8, r9);
        r3 = "MicroMsg.MsgHandler";
        r4 = " checkPermission checkcamera[%b]";
        r8 = new java.lang.Object[r6];
        r9 = java.lang.Boolean.valueOf(r0);
        r8[r5] = r9;
        com.tencent.mm.sdk.platformtools.x.d(r3, r4, r8);
        if (r0 != 0) goto L_0x00d0;
    L_0x01a0:
        goto L_0x0065;
    L_0x01a2:
        r0 = r12.context;
        r1 = "webview";
        r2 = ".ui.tools.OpenFileChooserUI";
        r4 = 32;
        com.tencent.mm.bg.d.a(r0, r1, r2, r3, r4, r5);
        goto L_0x0065;
    L_0x01b1:
        r0 = r2;
        goto L_0x00e7;
    L_0x01b4:
        r4 = r0;
        goto L_0x00e4;
    L_0x01b7:
        r7 = r0;
        goto L_0x0076;
    L_0x01ba:
        r0 = r5;
        goto L_0x0053;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.webview.ui.tools.jsapi.g.a(com.tencent.mm.plugin.webview.ui.tools.jsapi.i, int):boolean");
    }

    private boolean W(i iVar) {
        boolean z;
        String str = (String) iVar.mcy.get("appId");
        String str2 = (String) iVar.mcy.get("localId");
        Object obj = iVar.mcy.get("isShowProgressTips");
        if (obj != null) {
            try {
                z = bi.getInt(obj.toString(), 0) == 1;
            } catch (Exception e) {
                x.w("MicroMsg.MsgHandler", "Exception has occured : %s", new Object[]{e.getMessage()});
            }
            x.i("MicroMsg.MsgHandler", "uploadMediaFile, appid = %s, localid = %s, isShowProgressTips(%s)", new Object[]{str, str2, Boolean.valueOf(z)});
            if (bi.oW(str) && !bi.oW(str2)) {
                l.a(iVar.qkk, false, null, str);
                WebViewJSSDKFileItem Qq = com.tencent.mm.plugin.webview.modeltools.e.bUX().Qq(str2);
                if (Qq != null) {
                    switch (Qq.bMT) {
                        case 1:
                            a(iVar, str, str2, com.tencent.mm.modelcdntran.b.dOq, (int) CdnLogic.kAppTypeYunStorage, 2, "uploadMediaFile", z);
                            break;
                        case 4:
                            b(iVar, str, str2, com.tencent.mm.modelcdntran.b.dOr, CdnLogic.kAppTypeYunStorage, 2, "uploadMediaFile", z);
                            break;
                        default:
                            b(iVar, str, str2, com.tencent.mm.modelcdntran.b.dOt, CdnLogic.kAppTypeYunStorage, 2, "uploadMediaFile", z);
                            break;
                    }
                }
                a(iVar, "uploadMediaFile:fail", null);
            } else {
                x.e("MicroMsg.MsgHandler", "appId or localid is null or nil.");
                a(iVar, "uploadMediaFile:fail_missing arguments", null);
            }
            return true;
        }
        z = true;
        x.i("MicroMsg.MsgHandler", "uploadMediaFile, appid = %s, localid = %s, isShowProgressTips(%s)", new Object[]{str, str2, Boolean.valueOf(z)});
        if (bi.oW(str)) {
        }
        x.e("MicroMsg.MsgHandler", "appId or localid is null or nil.");
        a(iVar, "uploadMediaFile:fail_missing arguments", null);
        return true;
    }

    private void a(i iVar, String str, String str2, int i, int i2, int i3, String str3, boolean z) {
        63 63 = new 63(this, str3, str2, iVar);
        WebViewJSSDKFileItem Qq = com.tencent.mm.plugin.webview.modeltools.e.bUX().Qq(str2);
        if (Qq == null) {
            a(iVar, str3 + ":fail", null);
            return;
        }
        com.tencent.mm.ak.e b = o.Pf().b(Long.valueOf(o.Pf().a(Qq.fnM, Qq.fnQ ? 0 : 1, 0, 0, new PString(), new PInt(), new PInt())));
        String str4 = Qq.fnM;
        Qq.fnM = o.Pf().o(b.dTL, "", "");
        x.i("MicroMsg.MsgHandler", "Image Inserted: %s", new Object[]{r2});
        x.i("MicroMsg.MsgHandler", str3 + ", add cdn upload task result : %b", new Object[]{Boolean.valueOf(com.tencent.mm.plugin.webview.modeltools.e.bUW().a(str, str2, i, i2, i3, 63))});
        if (!com.tencent.mm.plugin.webview.modeltools.e.bUW().a(str, str2, i, i2, i3, 63)) {
            a(iVar, str3 + ":fail", null);
        } else if (z) {
            Context context = this.context;
            this.context.getString(R.l.app_tip);
            this.eHw = com.tencent.mm.ui.base.h.a(context, this.context.getString(R.l.wv_uploading), true, new 64(this, 63, str2, iVar, str3));
        } else if (this.context instanceof Activity) {
            ((Activity) this.context).finish();
            this.pRY = this.qhZ;
        }
        Qq.fnM = str4;
    }

    private void b(i iVar, String str, String str2, int i, int i2, int i3, String str3, boolean z) {
        WebViewJSSDKFileItem Qq = com.tencent.mm.plugin.webview.modeltools.e.bUX().Qq(str2);
        if (Qq == null || bi.oW(Qq.fnM) || !com.tencent.mm.a.e.cn(Qq.fnM)) {
            a(iVar, str3 + ":fail_file not exist", null);
        } else if (com.tencent.mm.network.ab.bU(this.context)) {
            c(iVar, str, str2, i, i2, i3, str3, z);
        } else {
            String gc = bi.gc((long) com.tencent.mm.a.e.cm(Qq.fnM));
            Context context = this.context;
            String string = this.context.getString(R.l.webview_jssdk_upload_video_gprs_confirm, new Object[]{gc});
            String string2 = this.context.getString(R.l.app_tip);
            com.tencent.mm.ui.base.h.a(context, string, string2, false, new 65(this, iVar, str, str2, i, i2, i3, str3, z), new 66(this, iVar, str3));
        }
    }

    private void c(i iVar, String str, String str2, int i, int i2, int i3, String str3, boolean z) {
        68 68 = new 68(this, str3, str2, iVar);
        boolean a = com.tencent.mm.plugin.webview.modeltools.e.bUW().a(str, str2, i, i2, i3, 68);
        x.i("MicroMsg.MsgHandler", str3 + ", add cdn upload task result : %b", new Object[]{Boolean.valueOf(a)});
        if (a) {
            b bVar = new b((byte) 0);
            bVar.qhP = iVar;
            bVar.qkf = 68;
            this.qiw.put(str2, bVar);
            Bundle bundle = new Bundle();
            bundle.putString("close_window_confirm_dialog_switch", "true");
            bundle.putString("close_window_confirm_dialog_title_cn", this.context.getString(R.l.webview_jssdk_video_uploading_tips));
            bundle.putString("close_window_confirm_dialog_title_eng", this.context.getString(R.l.webview_jssdk_video_uploading_tips));
            bundle.putString("close_window_confirm_dialog_ok_cn", this.context.getString(R.l.webview_jssdk_upload_video_cancel));
            bundle.putString("close_window_confirm_dialog_ok_eng", this.context.getString(R.l.webview_jssdk_upload_video_cancel));
            bundle.putString("close_window_confirm_dialog_cancel_cn", this.context.getString(R.l.webview_jssdk_upload_video_continue));
            bundle.putString("close_window_confirm_dialog_cancel_eng", this.context.getString(R.l.webview_jssdk_upload_video_continue));
            try {
                this.pRY.c(13, bundle);
            } catch (Exception e) {
                x.e("MicroMsg.MsgHandler", "doSetCloseWindowConfirmDialogInfo invoke callback failed : %s", new Object[]{e.getMessage()});
            }
            if (z) {
                Context context = this.context;
                this.context.getString(R.l.app_tip);
                this.eHw = com.tencent.mm.ui.base.h.a(context, this.context.getString(R.l.wv_uploading), true, new 69(this, 68, str2, iVar, str3));
                this.eHw.setOnKeyListener(new 70(this));
                return;
            } else if (this.context instanceof Activity) {
                ((Activity) this.context).finish();
                this.pRY = this.qhZ;
                return;
            } else {
                return;
            }
        }
        a(iVar, str3 + ":fail", null);
    }

    private boolean X(i iVar) {
        boolean z;
        String str = (String) iVar.mcy.get("appId");
        String str2 = (String) iVar.mcy.get("localId");
        Object obj = iVar.mcy.get("isShowProgressTips");
        if (obj != null) {
            try {
                z = bi.getInt(obj.toString(), 0) == 1;
            } catch (Exception e) {
                x.w("MicroMsg.MsgHandler", "Exception has occurred : %s", new Object[]{e.getMessage()});
            }
            x.i("MicroMsg.MsgHandler", "upload local video, appId = %s, localId = %s, isShowProgressTips(%s)", new Object[]{str, str2, Boolean.valueOf(z)});
            if (!bi.oW(str) || bi.oW(str2)) {
                x.e("MicroMsg.MsgHandler", "appId or localId is null or nil.");
                a(iVar, "uploadVideo:fail_missing arguments", null);
            } else {
                b(iVar, str, str2, com.tencent.mm.modelcdntran.b.MediaType_FILE, 0, 0, "uploadVideo", z);
            }
            return true;
        }
        z = true;
        x.i("MicroMsg.MsgHandler", "upload local video, appId = %s, localId = %s, isShowProgressTips(%s)", new Object[]{str, str2, Boolean.valueOf(z)});
        if (bi.oW(str)) {
        }
        x.e("MicroMsg.MsgHandler", "appId or localId is null or nil.");
        a(iVar, "uploadVideo:fail_missing arguments", null);
        return true;
    }

    public final boolean bYh() {
        boolean z = !bi.oW(this.qix);
        if (z) {
            x.e("MicroMsg.MsgHandler", "in recording state.");
        }
        return z;
    }

    private boolean Y(i iVar) {
        if (bYh()) {
            try {
                this.pRY.c(2007, null);
            } catch (Exception e) {
                x.e("MicroMsg.MsgHandler", "callback start record failed");
            }
            a(iVar, "startRecord:fail_recording", null);
        } else {
            String str = (String) iVar.mcy.get("appId");
            if (bi.oW(str)) {
                x.e("MicroMsg.MsgHandler", "appId is null or nil.");
                a(iVar, "startRecord:fail_missing arguments", null);
            } else {
                l.a(iVar.qkk, false, null, str);
                if (com.tencent.mm.pluginsdk.permission.a.bj(this.context, "android.permission.RECORD_AUDIO")) {
                    WebViewJSSDKFileItem Qo = WebViewJSSDKFileItem.Qo(aj.Qx(str));
                    Qo.appId = str;
                    com.tencent.mm.plugin.webview.modeltools.e.bUX().b(Qo);
                    x.i("MicroMsg.MsgHandler", "start record appId : %s, voice file name : %s, voice file path : %s", new Object[]{str, r1, Qo.fnM});
                    this.qix = Qo.bNH;
                    ah.A(new 71(this, Qo, iVar));
                    try {
                        this.pRY.c(2007, null);
                    } catch (Exception e2) {
                        x.e("MicroMsg.MsgHandler", "callback start record failed");
                    }
                    a(iVar, "startRecord:ok", null);
                } else {
                    WebViewStubTempUI.a(this.context, this.pRY, new String[]{"android.permission.RECORD_AUDIO"}, 116, this.bWo);
                }
            }
        }
        return true;
    }

    private boolean Z(i iVar) {
        if (bYh()) {
            String str = (String) iVar.mcy.get("appId");
            x.i("MicroMsg.MsgHandler", "stop record appId : %s", new Object[]{str});
            l.a(iVar.qkk, false, null, str);
            WebViewJSSDKFileItem Qq = com.tencent.mm.plugin.webview.modeltools.e.bUX().Qq(this.qix);
            if (Qq == null || !str.equals(Qq.appId)) {
                x.e("MicroMsg.MsgHandler", "get jssdk file item by id failed or the appid is not corrected, appid is : %s", new Object[]{str});
                a(iVar, "stopRecord:fail", null);
            } else {
                ah.A(new 73(this, Qq));
                x.i("MicroMsg.MsgHandler", "stop record, file name  : %s, file path : %s, localid : %s", new Object[]{Qq.fileName, Qq.fnM, Qq.bNH});
                Map hashMap = new HashMap();
                hashMap.put("localId", Qq.bNH);
                try {
                    this.pRY.c(2009, null);
                } catch (RemoteException e) {
                    x.e("MicroMsg.MsgHandler", "callback on stop record failed.");
                }
                a(iVar, "stopRecord:ok", hashMap);
            }
        } else {
            x.w("MicroMsg.MsgHandler", "Do not in recording state.");
            a(iVar, "stopRecord:fail", null);
        }
        return true;
    }

    private boolean aa(i iVar) {
        boolean z;
        String str = (String) iVar.mcy.get("appId");
        String str2 = (String) iVar.mcy.get("localId");
        Object obj = iVar.mcy.get("isShowProgressTips");
        if (obj != null) {
            try {
                z = bi.getInt(obj.toString(), 0) == 1;
            } catch (Exception e) {
                x.w("MicroMsg.MsgHandler", "Exception has occured : %s", new Object[]{e.getMessage()});
            }
            l.a(iVar.qkk, false, null, str);
            x.i("MicroMsg.MsgHandler", "doUploadVoice, appId : %s, localId : %s, isShowProgressTips(%s)", new Object[]{str, str2, Boolean.valueOf(z)});
            if (!bi.oW(str) || bi.oW(str2)) {
                x.e("MicroMsg.MsgHandler", "appId or localId is null or nil.");
                a(iVar, "uploadVoice:fail_missing arguments", null);
            } else {
                77 77 = new 77(this, str2, iVar);
                x.i("MicroMsg.MsgHandler", "doUploadVoice, add cdn upload task result : %b", new Object[]{Boolean.valueOf(com.tencent.mm.plugin.webview.modeltools.e.bUW().b(str, str2, 77))});
                if (!com.tencent.mm.plugin.webview.modeltools.e.bUW().b(str, str2, 77)) {
                    a(iVar, "uploadVoice:fail", null);
                } else if (z) {
                    Context context = this.context;
                    this.context.getString(R.l.app_tip);
                    this.eHw = com.tencent.mm.ui.base.h.a(context, this.context.getString(R.l.wv_uploading), true, new 79(this, 77, str2, iVar));
                }
            }
            return true;
        }
        z = true;
        l.a(iVar.qkk, false, null, str);
        x.i("MicroMsg.MsgHandler", "doUploadVoice, appId : %s, localId : %s, isShowProgressTips(%s)", new Object[]{str, str2, Boolean.valueOf(z)});
        if (bi.oW(str)) {
        }
        x.e("MicroMsg.MsgHandler", "appId or localId is null or nil.");
        a(iVar, "uploadVoice:fail_missing arguments", null);
        return true;
    }

    private boolean ab(i iVar) {
        boolean z;
        String str = (String) iVar.mcy.get("appId");
        String str2 = (String) iVar.mcy.get("serverId");
        Object obj = iVar.mcy.get("isShowProgressTips");
        if (obj != null) {
            try {
                z = bi.getInt(obj.toString(), 0) == 1;
            } catch (Exception e) {
                x.w("MicroMsg.MsgHandler", "Exception has occured : %s", new Object[]{e.getMessage()});
            }
            l.a(iVar.qkk, false, null, str);
            x.i("MicroMsg.MsgHandler", "doDownloadVoice, appid is : %s, media id is : %s, isShowProgDialog(%s)", new Object[]{str, str2, Boolean.valueOf(z)});
            if (bi.oW(str2)) {
                80 80 = new 80(this, str2, iVar);
                com.tencent.mm.plugin.webview.modeltools.e.bUW().a(str, str2, 80);
                x.i("MicroMsg.MsgHandler", "doDownloadVoice, add cdn download task result : %b", new Object[]{Boolean.valueOf(true)});
                if (z) {
                    Context context = this.context;
                    this.context.getString(R.l.app_tip);
                    this.eHw = com.tencent.mm.ui.base.h.a(context, this.context.getString(R.l.wv_downloading), true, new 81(this, 80, str2, iVar));
                }
            } else {
                a(iVar, "downloadVoice:fail_invaild_serverId", null);
            }
            return true;
        }
        z = true;
        l.a(iVar.qkk, false, null, str);
        x.i("MicroMsg.MsgHandler", "doDownloadVoice, appid is : %s, media id is : %s, isShowProgDialog(%s)", new Object[]{str, str2, Boolean.valueOf(z)});
        if (bi.oW(str2)) {
            80 802 = new 80(this, str2, iVar);
            com.tencent.mm.plugin.webview.modeltools.e.bUW().a(str, str2, 802);
            x.i("MicroMsg.MsgHandler", "doDownloadVoice, add cdn download task result : %b", new Object[]{Boolean.valueOf(true)});
            if (z) {
                Context context2 = this.context;
                this.context.getString(R.l.app_tip);
                this.eHw = com.tencent.mm.ui.base.h.a(context2, this.context.getString(R.l.wv_downloading), true, new 81(this, 802, str2, iVar));
            }
        } else {
            a(iVar, "downloadVoice:fail_invaild_serverId", null);
        }
        return true;
    }

    private boolean ac(i iVar) {
        String str = (String) iVar.mcy.get("menuList");
        if (bi.oW(str)) {
            a(iVar, "hideMenuItems:param is empty", null);
        } else {
            try {
                JSONArray jSONArray = new JSONArray(str);
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < jSONArray.length(); i++) {
                    arrayList.add(jSONArray.getString(i));
                }
                Bundle bundle = new Bundle();
                bundle.putStringArrayList("menu_item_list", arrayList);
                this.pRY.q(3001, bundle);
                a(iVar, "hideMenuItems:ok", null);
            } catch (JSONException e) {
                x.w("MicroMsg.MsgHandler", "JSONException : %s", new Object[]{e.getMessage()});
                a(iVar, "hideMenuItems:param is empty", null);
            } catch (RemoteException e2) {
                a(iVar, "hideMenuItems:param is empty", null);
            }
        }
        return true;
    }

    private boolean ad(i iVar) {
        String str = (String) iVar.mcy.get("menuList");
        if (bi.oW(str)) {
            a(iVar, "showMenuItems:param is empty", null);
        } else {
            try {
                JSONArray jSONArray = new JSONArray(str);
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < jSONArray.length(); i++) {
                    arrayList.add(jSONArray.getString(i));
                }
                Bundle bundle = new Bundle();
                bundle.putStringArrayList("menu_item_list", arrayList);
                this.pRY.q(3002, bundle);
            } catch (JSONException e) {
                x.w("MicroMsg.MsgHandler", "JSONException : %s", new Object[]{e.getMessage()});
                a(iVar, "showMenuItems:param is empty", null);
            } catch (RemoteException e2) {
                x.w("MicroMsg.MsgHandler", "RemoteException : %s", new Object[]{e2.getMessage()});
                a(iVar, "showMenuItems:param is empty", null);
            }
            a(iVar, "showMenuItems:ok", null);
        }
        return true;
    }

    private boolean bYi() {
        try {
            this.pRY.q(3003, null);
        } catch (RemoteException e) {
            x.w("MicroMsg.MsgHandler", "doShowOptionMenu, RemoteException : %s", new Object[]{e.getMessage()});
        }
        this.iKs = false;
        return false;
    }

    private boolean bYj() {
        try {
            this.pRY.q(3004, null);
        } catch (RemoteException e) {
            x.w("MicroMsg.MsgHandler", "RemoteException : %s", new Object[]{e.getMessage()});
        }
        this.iKs = false;
        return false;
    }

    private boolean ae(i iVar) {
        try {
            this.pRY.q(3003, null);
        } catch (RemoteException e) {
            x.w("MicroMsg.MsgHandler", "RemoteException : %s", new Object[]{e.getMessage()});
            a(iVar, "hideAllNonBaseMenuItem:param is empty", null);
        }
        a(iVar, "hideAllNonBaseMenuItem:ok", null);
        return true;
    }

    private boolean af(i iVar) {
        try {
            this.pRY.q(3004, null);
        } catch (RemoteException e) {
            x.w("MicroMsg.MsgHandler", "RemoteException : %s", new Object[]{e.getMessage()});
            a(iVar, "showAllNonBaseMenuItem:param is empty", null);
        }
        a(iVar, "showAllNonBaseMenuItem:ok", null);
        return true;
    }

    private boolean ag(i iVar) {
        String str = (String) iVar.mcy.get("jsApiList");
        if (bi.oW(str)) {
            a(iVar, "checkJsApi:param is empty", null);
        } else {
            try {
                JSONObject jSONObject = new JSONObject();
                JSONArray jSONArray = new JSONArray(str);
                if (jSONArray.length() == 0) {
                    a(iVar, "checkJsApi:param is empty", null);
                } else {
                    for (int i = 0; i < jSONArray.length(); i++) {
                        boolean z;
                        String string = jSONArray.getString(i);
                        if (com.tencent.mm.protocal.c.Ux(string) == null) {
                            if (c$ld.qVG == null) {
                                Set hashSet = new HashSet();
                                c$ld.qVG = hashSet;
                                hashSet.add("menu:share:QZone");
                                c$ld.qVG.add("onImageDownloadProgress");
                                c$ld.qVG.add("onVoiceUploadProgress");
                                c$ld.qVG.add("onVoiceDownloadProgress");
                                c$ld.qVG.add("onVoiceRecordEnd");
                                c$ld.qVG.add("onVoicePlayBegin");
                                c$ld.qVG.add("onVoicePlayEnd");
                                c$ld.qVG.add("onLocalImageUploadProgress");
                                c$ld.qVG.add("wxdownload:state_change");
                                c$ld.qVG.add("wxdownload:progress_change");
                                c$ld.qVG.add("hdOnDeviceStateChanged");
                                c$ld.qVG.add("activity:state_change");
                                c$ld.qVG.add("onWXDeviceBluetoothStateChange");
                                c$ld.qVG.add("onWXDeviceLanStateChange");
                                c$ld.qVG.add("onWXDeviceBindStateChange");
                                c$ld.qVG.add("onReceiveDataFromWXDevice");
                                c$ld.qVG.add("onScanWXDeviceResult");
                                c$ld.qVG.add("onWXDeviceStateChange");
                                c$ld.qVG.add("onGetKeyboardHeight");
                                c$ld.qVG.add("onGetSmiley");
                                c$ld.qVG.add("onAddShortcutStatus");
                                c$ld.qVG.add("onMediaFileUploadProgess");
                                c$ld.qVG.add("onGetA8KeyUrl");
                                c$ld.qVG.add("onPageStateChange");
                                c$ld.qVG.add("onGetMsgProofItems");
                                c$ld.qVG.add("onNavigationBarRightButtonClick");
                                c$ld.qVG.add("onBackgroundAudioStateChange");
                                c$ld.qVG.add(com.tencent.mm.plugin.game.gamewebview.b.a.d.NAME);
                                c$ld.qVG.add(com.tencent.mm.plugin.game.gamewebview.b.a.a.NAME);
                                c$ld.qVG.add("onArticleReadingBtnClicked");
                                c$ld.qVG.add("onRecordHistory");
                                c$ld.qVG.add("onBeaconsInRange");
                                c$ld.qVG.add("onMiniProgramData");
                            }
                            if (!c$ld.qVG.contains(string)) {
                                z = false;
                                jSONObject.put(string, z);
                            }
                        }
                        z = true;
                        jSONObject.put(string, z);
                    }
                    Map hashMap = new HashMap();
                    hashMap.put("checkResult", jSONObject.toString());
                    a(iVar, "checkJsApi:ok", hashMap);
                }
            } catch (JSONException e) {
                x.w("MicroMsg.MsgHandler", "JSONException : %s", new Object[]{e.getMessage()});
                a(iVar, "checkJsApi:param is empty", null);
            }
        }
        return true;
    }

    private boolean ah(i iVar) {
        try {
            int intValue;
            String str = (String) iVar.mcy.get("userName");
            try {
                intValue = ((Integer) iVar.mcy.get(DownloadSettingTable$Columns.TYPE)).intValue();
            } catch (Exception e) {
                intValue = 0;
            }
            a(iVar, "setFreeWifiOwner:ok", null);
            Intent intent = new Intent();
            intent.putExtra("wifi_owner_name", str);
            intent.putExtra("wifi_owner_type", intValue);
            com.tencent.mm.bg.d.c(this.context, "freewifi", ".ui.FreeWifiOwnerUI", intent);
        } catch (Exception e2) {
            x.w("MicroMsg.MsgHandler", "setFreeWifiOwner, Exception: %s", new Object[]{e2.getMessage()});
        }
        return false;
    }

    private boolean ai(i iVar) {
        boolean z;
        String str = (String) iVar.mcy.get("appId");
        final String str2 = (String) iVar.mcy.get("localId");
        Object obj = iVar.mcy.get("isShowProgressTips");
        if (obj != null) {
            try {
                z = bi.getInt(obj.toString(), 0) == 1;
            } catch (Exception e) {
                x.w("MicroMsg.MsgHandler", "Exception has occured : %s", new Object[]{e.getMessage()});
            }
            x.i("MicroMsg.MsgHandler", "isShowProgressTips(%s)", new Object[]{Boolean.valueOf(z)});
            l.a(iVar.qkk, false, null, str);
            if (!bi.oW(str) || bi.oW(str2)) {
                x.i("MicroMsg.MsgHandler", "The localId(%s) is null or appId(%s) is null.", new Object[]{str2, str});
                a(iVar, "translateVoice:fail_missing arguments", null);
            } else {
                final WebViewJSSDKFileItem Qq = com.tencent.mm.plugin.webview.modeltools.e.bUX().Qq(str2);
                if (Qq != null) {
                    final i iVar2 = iVar;
                    ah.A(new Runnable() {
                        public final void run() {
                            if (z) {
                                g gVar = g.this;
                                Context j = g.this.context;
                                g.this.context.getString(R.l.app_tip);
                                gVar.eHw = com.tencent.mm.ui.base.h.a(j, g.this.context.getString(R.l.wv_translating), true, new 1(this));
                            }
                            fi fiVar = new fi();
                            fiVar.bNF.bNH = str2;
                            fiVar.bNF.fileName = Qq.fileName;
                            fiVar.bNF.bNI = 0;
                            fiVar.bNF.scene = 8;
                            fiVar.bNF.bNJ = new 2(this, fiVar);
                            com.tencent.mm.sdk.b.a.sFg.m(fiVar);
                        }
                    });
                } else {
                    a(iVar, "translateVoice:fail_arguments error", null);
                }
            }
            return true;
        }
        z = true;
        x.i("MicroMsg.MsgHandler", "isShowProgressTips(%s)", new Object[]{Boolean.valueOf(z)});
        l.a(iVar.qkk, false, null, str);
        if (bi.oW(str)) {
        }
        x.i("MicroMsg.MsgHandler", "The localId(%s) is null or appId(%s) is null.", new Object[]{str2, str});
        a(iVar, "translateVoice:fail_missing arguments", null);
        return true;
    }

    private boolean aj(i iVar) {
        WWMediaLink wWMediaLink = new WWMediaLink();
        wWMediaLink.thumbUrl = (String) iVar.mcy.get("img_url");
        try {
            wWMediaLink.webpageUrl = al.Dp(this.pRY.getCurrentUrl());
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.MsgHandler", e, "", new Object[0]);
            wWMediaLink.webpageUrl = (String) iVar.mcy.get("link");
        }
        wWMediaLink.title = (String) iVar.mcy.get("title");
        wWMediaLink.description = (String) iVar.mcy.get("desc");
        WWAPIFactory.ii(this.context).a(wWMediaLink);
        a(iVar, "shareWeWork:ok", null);
        return true;
    }

    private boolean ak(i iVar) {
        if (com.tencent.mm.plugin.webview.stub.a.ey(this.context)) {
            String str = (String) iVar.mcy.get("img_url");
            String str2 = (String) iVar.mcy.get("title");
            String str3 = (String) iVar.mcy.get("desc");
            String string = this.context.getResources().getString(R.l.app_name);
            String str4 = (String) iVar.mcy.get("link");
            try {
                if (bi.oW(str4)) {
                    str4 = this.pRY.getCurrentUrl();
                }
            } catch (RemoteException e) {
                x.w("MicroMsg.MsgHandler", "Get current url fail. exception : %s", new Object[]{e.getMessage()});
            }
            str4 = al.Dp(str4);
            if (bi.oW(str4) || bi.oW(str2) || bi.oW(str3)) {
                x.w("MicroMsg.MsgHandler", "url(%s) or title(%s) or description(%s) is null or nil.", new Object[]{str4, str2, str3});
                a(iVar, "shareQQ:fail", null);
            } else {
                Map hashMap = new HashMap();
                hashMap.put("image_url", com.tencent.mm.pluginsdk.ui.tools.s.Ue(str));
                hashMap.put("title", com.tencent.mm.pluginsdk.ui.tools.s.Ue(str2));
                hashMap.put("description", com.tencent.mm.pluginsdk.ui.tools.s.Ue(str3));
                hashMap.put(TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_URL, com.tencent.mm.pluginsdk.ui.tools.s.Ue(str4));
                hashMap.put("app_name", com.tencent.mm.pluginsdk.ui.tools.s.Ue(string));
                hashMap.put("req_type", com.tencent.mm.pluginsdk.ui.tools.s.Ue("1"));
                if (iVar.qkl.equalsIgnoreCase("shareQZone")) {
                    hashMap.put("cflag", com.tencent.mm.pluginsdk.ui.tools.s.Ue("1"));
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("mqqapi://share/to_fri?file_type=news&share_id=1103188687");
                stringBuilder.append("&");
                stringBuilder.append(com.tencent.mm.pluginsdk.ui.tools.s.as(hashMap));
                x.d("MicroMsg.MsgHandler", "Uri : %s", new Object[]{stringBuilder.toString()});
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(stringBuilder.toString()));
                intent.putExtra("pkg_name", "com.tencent.mm");
                intent.getStringExtra("pkg_name");
                intent.setFlags(268435456);
                if (bi.k(this.context, intent) && (this.context instanceof Activity)) {
                    ((Activity) this.context).startActivityForResult(intent, 44);
                    a(iVar, iVar.qkl + ":ok", null);
                } else {
                    a(iVar, iVar.qkl + ":fail", null);
                }
            }
        } else {
            x.w("MicroMsg.MsgHandler", "Tencent QQ hasn't installed at all.");
            a(iVar, "shareQQ:fail", null);
        }
        return true;
    }

    private boolean al(i iVar) {
        String str = (String) iVar.mcy.get("desc");
        String str2 = (String) iVar.mcy.get("img_url");
        String str3 = (String) iVar.mcy.get("link");
        try {
            if (bi.oW(str3)) {
                str3 = this.pRY.getCurrentUrl();
            }
        } catch (RemoteException e) {
            x.w("MicroMsg.MsgHandler", "Get current url fail. exception : %s", new Object[]{e.getMessage()});
        }
        str3 = al.Dp(str3);
        if (bi.oW(str3)) {
            x.e("MicroMsg.MsgHandler", "link is null or nil.");
            a(iVar, "shareWeiboApp:fail", null);
        } else {
            if (bi.oW(str)) {
                str = ((String) iVar.mcy.get("title")) + " " + str3;
            }
            Map hashMap = new HashMap();
            hashMap.put(DownloadSettingTable$Columns.TYPE, Integer.valueOf(0));
            hashMap.put("openLBS", Integer.valueOf(0));
            hashMap.put("content", com.tencent.mm.pluginsdk.ui.tools.s.Ud(str));
            hashMap.put(TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_URL, com.tencent.mm.pluginsdk.ui.tools.s.Ud(str2));
            hashMap.put("thumbnailurl", com.tencent.mm.pluginsdk.ui.tools.s.Ud(str2));
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("weibo://t.qq.com/proxy/write"));
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("TencentWeibo://Edit?from=weixin&");
            stringBuilder.append(com.tencent.mm.pluginsdk.ui.tools.s.as(hashMap));
            x.i("MicroMsg.MsgHandler", "Uri : %s", new Object[]{stringBuilder.toString()});
            intent.putExtra("microblog.intent.extra.ACTION", stringBuilder.toString());
            intent.setFlags(268435456);
            if (bi.k(this.context, intent)) {
                this.context.startActivity(intent);
                a(iVar, "shareWeiboApp:ok", null);
            } else {
                a(iVar, "shareWeiboApp:fail", null);
            }
        }
        return true;
    }

    private boolean am(i iVar) {
        String str = (String) iVar.mcy.get("sessionFrom");
        if (bi.oW((String) iVar.mcy.get("sessionId"))) {
            a(iVar, "startTempSession:fail_missing arguments", null);
        } else {
            String str2;
            int intValue;
            int i;
            String format;
            Intent intent;
            if (str != null) {
                try {
                    str = URLEncoder.encode(str, "UTF-8");
                } catch (UnsupportedEncodingException e) {
                    str2 = str;
                }
            } else {
                str = null;
            }
            str2 = str;
            Object obj = iVar.mcy.get("showType");
            if (obj != null) {
                if (obj instanceof Integer) {
                    intValue = ((Integer) obj).intValue();
                } else if (obj instanceof String) {
                    try {
                        intValue = bi.getInt((String) obj, 0);
                    } catch (NumberFormatException e2) {
                        intValue = 0;
                    }
                }
                i = bi.getInt(bi.oV((String) iVar.mcy.get("scene")), 0);
                format = String.format("weixin://dl/business/tempsession/?username=%s&appid=%s&sessionFrom=%s&showtype=%s&scene=%s", new Object[]{format, this.qic.RE(this.pRY.getCurrentUrl()), bi.oV(str2), Integer.valueOf(intValue), Integer.valueOf(i)});
                intent = new Intent("android.intent.action.VIEW");
                intent.addCategory("android.intent.category.BROWSABLE");
                intent.setData(Uri.parse(format));
                if (i == 0) {
                    intent.putExtra("translate_link_scene", i);
                } else {
                    intent.putExtra("translate_link_scene", 4);
                }
                this.context.startActivity(intent);
                a(iVar, "startTempSession:ok", null);
            }
            intValue = 0;
            i = bi.getInt(bi.oV((String) iVar.mcy.get("scene")), 0);
            try {
                format = String.format("weixin://dl/business/tempsession/?username=%s&appid=%s&sessionFrom=%s&showtype=%s&scene=%s", new Object[]{format, this.qic.RE(this.pRY.getCurrentUrl()), bi.oV(str2), Integer.valueOf(intValue), Integer.valueOf(i)});
                intent = new Intent("android.intent.action.VIEW");
                intent.addCategory("android.intent.category.BROWSABLE");
                intent.setData(Uri.parse(format));
                if (i == 0) {
                    intent.putExtra("translate_link_scene", 4);
                } else {
                    intent.putExtra("translate_link_scene", i);
                }
                this.context.startActivity(intent);
                a(iVar, "startTempSession:ok", null);
            } catch (Throwable e3) {
                x.printErrStackTrace("MicroMsg.MsgHandler", e3, "", new Object[0]);
                a(iVar, "startTempSession:fail_exception", null);
            }
        }
        return true;
    }

    private boolean an(i iVar) {
        try {
            String str = (String) iVar.mcy.get("userName");
            String str2 = (String) iVar.mcy.get("nickName");
            if (bi.oW(str)) {
                a(iVar, "setPageOwner:missing_arguments", null);
            } else {
                this.pRY.fo(str, str2);
                a(iVar, "setPageOwner:ok", null);
            }
        } catch (Exception e) {
            x.w("MicroMsg.MsgHandler", "setPageOwner, Exception: %s", new Object[]{e.getMessage()});
        }
        return false;
    }

    private boolean ao(final i iVar) {
        try {
            String str = (String) iVar.mcy.get("appId");
            String str2 = (String) iVar.mcy.get("signature");
            l.a(iVar.qkk, false, null, str);
            if (bi.oW(str)) {
                a(iVar, "get_wechat_verify_ticket:fail ticket", null);
            } else {
                au.DF().a(1097, new com.tencent.mm.ab.e() {
                    public final void a(int i, int i2, String str, l lVar) {
                        if (i == 0 && i2 == 0) {
                            com.tencent.mm.plugin.webview.model.h hVar = (com.tencent.mm.plugin.webview.model.h) lVar;
                            Map hashMap = new HashMap();
                            hashMap.put("ticket", ((zm) hVar.ivx.dIE.dIL).bLe);
                            g.this.a(iVar, "get_wechat_verify_ticket:ok ticket", hashMap);
                        } else {
                            x.e("MicroMsg.MsgHandler", "doGetWechatVerifyTicket, errType = " + i + ", errCode = " + i2);
                            g.this.a(iVar, "get_wechat_verify_ticket:fail ticket", null);
                        }
                        au.DF().b(1097, this);
                    }
                });
                au.DF().a(new com.tencent.mm.plugin.webview.model.h(str, str2), 0);
            }
        } catch (Exception e) {
            x.w("MicroMsg.MsgHandler", "getWechatVerifyTicket, Exception: %s", new Object[]{e.getMessage()});
        }
        return false;
    }

    public final boolean ap(i iVar) {
        x.d("MicroMsg.MsgHandler", "doSelectPedometerSource");
        if (this.context == null || !(this.context instanceof MMActivity)) {
            x.e("MicroMsg.MsgHandler", "context is null");
            a(iVar, "selectPedometerSource:fail", null);
        } else {
            ((MMActivity) this.context).geJ = this;
            com.tencent.mm.bg.d.b(this.context, "exdevice", ".ui.ExdeviceAddDataSourceUI", new Intent(), 26);
        }
        return true;
    }

    private Bundle e(String str, int i, Bundle bundle) {
        try {
            return this.pRY.g(i, bundle);
        } catch (RemoteException e) {
            x.w("MicroMsg.MsgHandler", "[NFC] " + str + " callback RemoteException!" + e.toString());
            return null;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean f(java.lang.String r6, int r7, android.os.Bundle r8) {
        /*
        r5 = this;
        r0 = -1;
        r4 = 0;
        r1 = r5.e(r6, r7, r8);
        if (r1 == 0) goto L_0x004e;
    L_0x0008:
        r2 = "status";
        r0 = r1.getInt(r2, r0);
    L_0x000f:
        r1 = "MicroMsg.MsgHandler";
        r2 = new java.lang.StringBuilder;
        r3 = "[NFC] ";
        r2.<init>(r3);
        r2 = r2.append(r6);
        r3 = " result status : ";
        r2 = r2.append(r3);
        r2 = r2.append(r0);
        r2 = r2.toString();
        com.tencent.mm.sdk.platformtools.x.i(r1, r2);
        switch(r0) {
            case 0: goto L_0x006c;
            case 1: goto L_0x0086;
            case 2: goto L_0x00a0;
            case 3: goto L_0x00b9;
            case 4: goto L_0x00bb;
            default: goto L_0x0033;
        };
    L_0x0033:
        r0 = r5.qhP;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r1 = r1.append(r6);
        r2 = ":fail";
        r1 = r1.append(r2);
        r1 = r1.toString();
        r5.a(r0, r1, r4);
    L_0x004c:
        r0 = 0;
    L_0x004d:
        return r0;
    L_0x004e:
        r1 = "MicroMsg.MsgHandler";
        r2 = new java.lang.StringBuilder;
        r3 = "[NFC] ";
        r2.<init>(r3);
        r2 = r2.append(r6);
        r3 = " callback fail!";
        r2 = r2.append(r3);
        r2 = r2.toString();
        com.tencent.mm.sdk.platformtools.x.w(r1, r2);
        goto L_0x000f;
    L_0x006c:
        r0 = r5.qhP;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r1 = r1.append(r6);
        r2 = ":nfc_not_support";
        r1 = r1.append(r2);
        r1 = r1.toString();
        r5.a(r0, r1, r4);
        goto L_0x004c;
    L_0x0086:
        r0 = r5.qhP;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r1 = r1.append(r6);
        r2 = ":nfc_off";
        r1 = r1.append(r2);
        r1 = r1.toString();
        r5.a(r0, r1, r4);
        goto L_0x004c;
    L_0x00a0:
        r0 = r5.qhP;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r1 = r1.append(r6);
        r2 = ":disconnect";
        r1 = r1.append(r2);
        r1 = r1.toString();
        r5.a(r0, r1, r4);
    L_0x00b9:
        r0 = 1;
        goto L_0x004d;
    L_0x00bb:
        r0 = r5.qhP;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r1 = r1.append(r6);
        r2 = ":card_not_support";
        r1 = r1.append(r2);
        r1 = r1.toString();
        r5.a(r0, r1, r4);
        goto L_0x004c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.webview.ui.tools.jsapi.g.f(java.lang.String, int, android.os.Bundle):boolean");
    }

    private boolean aq(i iVar) {
        try {
            Bundle g = this.pRY.g(5001, null);
            if (g != null) {
                int i = g.getInt("webview_video_proxy_init");
                x.i("MicroMsg.MsgHandler", "int webview video proxy : %d", new Object[]{Integer.valueOf(i)});
                Map hashMap = new HashMap();
                hashMap.put("videoProxyInitResult", Integer.valueOf(i));
                if (i == 0) {
                    ai bUm = ai.bUm();
                    bUm.pRY = this.pRY;
                    bUm.hasInit = true;
                    ArrayList arrayList = new ArrayList();
                    IDKey iDKey = new IDKey();
                    iDKey.SetID(142);
                    iDKey.SetKey(0);
                    iDKey.SetValue(1);
                    arrayList.add(iDKey);
                    iDKey = new IDKey();
                    iDKey.SetID(142);
                    iDKey.SetKey(1);
                    iDKey.SetValue(1);
                    arrayList.add(iDKey);
                    com.tencent.mm.plugin.report.service.h.mEJ.b(arrayList, false);
                    a(iVar, "videoProxyInit:ok", hashMap);
                } else {
                    ArrayList arrayList2 = new ArrayList();
                    IDKey iDKey2 = new IDKey();
                    iDKey2.SetID(142);
                    iDKey2.SetKey(0);
                    iDKey2.SetValue(1);
                    arrayList2.add(iDKey2);
                    iDKey2 = new IDKey();
                    iDKey2.SetID(142);
                    iDKey2.SetKey(2);
                    iDKey2.SetValue(1);
                    arrayList2.add(iDKey2);
                    iDKey2 = new IDKey();
                    iDKey2.SetID(142);
                    iDKey2.SetKey(com.tencent.mm.plugin.webview.ui.tools.a.Az(i));
                    iDKey2.SetValue(1);
                    arrayList2.add(iDKey2);
                    com.tencent.mm.plugin.report.service.h.mEJ.b(arrayList2, false);
                    a(iVar, "videoProxyInit:fail", hashMap);
                }
                return false;
            }
        } catch (Exception e) {
            x.i("MicroMsg.MsgHandler", "doinit webview proxy failed : %s", new Object[]{e.getMessage()});
        }
        a(iVar, "videoProxyInit:fail", null);
        return false;
    }

    private boolean ar(i iVar) {
        if (ai.bUm().hasInit) {
            String str = (String) iVar.mcy.get("webviewVideoProxyCdnUrls");
            x.i("MicroMsg.MsgHandler", "cdnurls = %s, filedId = %s, fileSize = %d, fileDuration = %d, fileType = %d", new Object[]{str, (String) iVar.mcy.get("webviewVideoProxyFileId"), Integer.valueOf(bi.getInt((String) iVar.mcy.get("webviewVideoProxyFileSize"), 0)), Integer.valueOf(bi.getInt((String) iVar.mcy.get("webviewVideoProxyFileDuration"), 0)), Integer.valueOf(bi.getInt((String) iVar.mcy.get("webviewVideoProxyFileType"), 1))});
            if (bi.oW(str)) {
                a(iVar, "videoProxyStartPlay:fail_cdnurl_is_null", null);
            } else {
                ArrayList arrayList = new ArrayList();
                try {
                    Bundle bundle = new Bundle();
                    bundle.putString("webview_video_proxy_cdn_urls", str);
                    bundle.putString("webview_video_proxy_fileId", r1);
                    bundle.putInt("webview_video_proxy_file_size", r3);
                    bundle.putInt("webview_video_proxy_file_duration", r4);
                    bundle.putInt("webview_video_proxy_file_type", r2);
                    Bundle g = this.pRY.g(5002, bundle);
                    IDKey iDKey = new IDKey();
                    iDKey.SetID(142);
                    iDKey.SetKey(15);
                    iDKey.SetValue(1);
                    arrayList.add(iDKey);
                    if (g != null) {
                        int i = g.getInt("webview_video_proxy_play_data_id");
                        str = g.getString("webview_video_proxy_local_url");
                        x.i("MicroMsg.MsgHandler", "invoke result palyDataId = %d, localUrl = %s", new Object[]{Integer.valueOf(i), str});
                        if (i > 0 && !bi.oW(str)) {
                            com.tencent.mm.plugin.report.service.h.mEJ.b(arrayList, false);
                            Map hashMap = new HashMap();
                            hashMap.put("videoProxyPlayDataId", Integer.valueOf(i));
                            hashMap.put("videoProxyPlayLocalUrl", str);
                            a(iVar, "videoProxyStartPlay:ok", hashMap);
                            com.tencent.mm.plugin.report.service.h.mEJ.b(arrayList, false);
                        }
                    }
                } catch (Exception e) {
                    x.e("MicroMsg.MsgHandler", "proxy start play failed : %s", new Object[]{e.getMessage()});
                }
                IDKey iDKey2 = new IDKey();
                iDKey2.SetID(142);
                iDKey2.SetKey(16);
                iDKey2.SetValue(1);
                arrayList.add(iDKey2);
                com.tencent.mm.plugin.report.service.h.mEJ.b(arrayList, false);
                a(iVar, "videoProxyStartPlay:fail", null);
            }
        } else {
            a(iVar, "videoProxyStartPlay:fail_has_not_init", null);
        }
        return false;
    }

    private boolean as(i iVar) {
        if (ai.bUm().hasInit) {
            int i = bi.getInt((String) iVar.mcy.get("webviewVideoProxyPlaydataId"), 0);
            if (i > 0) {
                Bundle bundle = new Bundle();
                bundle.putInt("webview_video_proxy_play_data_id", i);
                try {
                    this.pRY.g(5003, bundle);
                    a(iVar, "videoProxyStopPlay:ok", null);
                    return false;
                } catch (Exception e) {
                    x.e("MicroMsg.MsgHandler", "webview proxy stop play failed : %s", new Object[]{e.getMessage()});
                }
            }
            a(iVar, "videoProxyStopPlay:fail", null);
            return false;
        }
        a(iVar, "videoProxyStartPlay:fail_has_not_init", null);
        return true;
    }

    private boolean at(i iVar) {
        if (ai.bUm().hasInit) {
            String str = (String) iVar.mcy.get("webviewVideoProxyPlayState");
            x.i("MicroMsg.MsgHandler", "set player state : %s", new Object[]{str});
            if (bi.oW(str)) {
                a(iVar, "videoProxySetPlayerState:fail", null);
                return true;
            }
            int i = bi.getInt(str, 0);
            try {
                Bundle bundle = new Bundle();
                bundle.putInt("webview_video_proxy_play_state", i);
                this.pRY.g(5004, bundle);
                a(iVar, "videoProxySetPlayerState:ok", null);
                return false;
            } catch (Exception e) {
                x.e("MicroMsg.MsgHandler", "set player state failed : %s", new Object[]{e.getMessage()});
                a(iVar, "videoProxySetPlayerState:fail", null);
                return false;
            }
        }
        a(iVar, "videoProxyStartPlay:fail_has_not_init", null);
        return true;
    }

    private boolean au(i iVar) {
        if (ai.bUm().hasInit) {
            int i = bi.getInt((String) iVar.mcy.get("webviewVideoProxyPlaydataId"), 0);
            int i2 = bi.getInt((String) iVar.mcy.get("webviewVideoProxyRemainTime"), 0);
            x.i("MicroMsg.MsgHandler", "doWebviewProxySetRemainTime, id = %s, time = %s", new Object[]{r0, r1});
            try {
                Bundle bundle = new Bundle();
                bundle.putInt("webview_video_proxy_play_data_id", i);
                bundle.putInt("webview_video_proxy_play_remain_time", i2);
                this.pRY.g(5006, bundle);
                a(iVar, "videoProxySetRemainTime:ok", null);
            } catch (Exception e) {
                x.e("MicroMsg.MsgHandler", "set remain time faild : %s", new Object[]{e.getMessage()});
                a(iVar, "videoProxySetRemainTime:fail", null);
            }
        } else {
            a(iVar, "videoProxySetRemainTime:fail_has_not_init", null);
        }
        return false;
    }

    private boolean av(i iVar) {
        if (ai.bUm().hasInit) {
            String str = (String) iVar.mcy.get("webviewVideoProxyPlaydataId");
            x.i("MicroMsg.MsgHandler", "doWebviewProxyPreload, playDataId = %s, duration = %d", new Object[]{str, Integer.valueOf(bi.getInt((String) iVar.mcy.get("webviewVideoProxyPreloadTime"), 0))});
            if (bi.oW(str)) {
                x.e("MicroMsg.MsgHandler", "playDataId is null or nil");
                a(iVar, "videoProxyPreload:fail_invaild_play_data_id", null);
            } else {
                try {
                    int i = bi.getInt(str, 0);
                    Bundle bundle = new Bundle();
                    bundle.putInt("webview_video_proxy_play_data_id", i);
                    bundle.putInt("webview_video_proxy_preload_duration", r1);
                    x.i("MicroMsg.MsgHandler", "preload video result = %d", new Object[]{Integer.valueOf(this.pRY.g(5007, bundle).getInt("webview_video_proxy_pre_load_result"))});
                    if (this.pRY.g(5007, bundle).getInt("webview_video_proxy_pre_load_result") == 0) {
                        a(iVar, "videoProxyPreload:ok", null);
                    } else {
                        a(iVar, "videoProxyPreload:fail", null);
                    }
                } catch (Exception e) {
                    a(iVar, "videoProxyPreload:fail", null);
                }
            }
        } else {
            a(iVar, "videoProxyPreload:fail_has_not_init", null);
        }
        return false;
    }

    public final void A(int i, String str, String str2) {
        c Bd = a(i);
        if (Bd == null) {
            x.i("MicroMsg.MsgHandler", "onWebViewCacheCallback, get null MsgWrapperBin, may be the webview called cache api has been closed.");
            return;
        }
        i iVar = Bd.qhP;
        Be(i);
        if (!bi.oV(str2).equalsIgnoreCase("ok")) {
            int a = com.tencent.mm.plugin.webview.modelcache.p.a(iVar);
            if (-1 != a) {
                com.tencent.mm.plugin.webview.modelcache.m.Aq(a);
            }
        }
        if (this.pRY != null) {
            a(this.pRY, iVar, String.format("%s:%s", new Object[]{str, str2}), null, false, true);
        }
    }

    private boolean aw(i iVar) {
        Throwable e;
        Object obj;
        String str = (String) iVar.mcy.get("actionKey");
        String str2 = (String) iVar.mcy.get("actionValue");
        x.i("MicroMsg.MsgHandler", "doReportActionInfo, actionKey =  %s, actionValue =  %s", new Object[]{str, str2});
        if (bi.oW(str) || bi.oW(str2)) {
            x.e("MicroMsg.MsgHandler", "doReportActionInfo, actionKey or actionValue is null");
            a(iVar, "reportActionInfo:fail", null);
            return true;
        } else if (str.length() <= 0 || str.length() > 32 || str2.length() <= 0 || str2.length() > 1024) {
            x.e("MicroMsg.MsgHandler", "doReportActionInfo, actionKey or actionValue size is bad");
            a(iVar, "reportActionInfo:fail", null);
            return true;
        } else {
            String str3 = " ";
            String str4 = " ";
            String str5 = " ";
            try {
                Bundle g = this.pRY.g(77, null);
                if (g != null) {
                    str3 = bi.oV(g.getString("KSessionId"));
                    str4 = bi.oV(g.getString("KUserAgent"));
                    str5 = bi.oV(g.getString("KUrl"));
                    if (TextUtils.isEmpty(str5)) {
                        x.e("MicroMsg.MsgHandler", "doReportActionInfo, url is empty");
                        a(iVar, "reportActionInfo:fail", null);
                        return true;
                    }
                    x.i("MicroMsg.MsgHandler", "doReportActionInfo, sessionId %s, userAgent %s, url %s", new Object[]{str3, str4, str5});
                }
            } catch (Exception e2) {
                x.e("MicroMsg.MsgHandler", "get sessionId error, %s", new Object[]{e2});
            }
            if (TextUtils.isEmpty(rL(str5))) {
                x.e("MicroMsg.MsgHandler", "doReportActionInfo, appId is empty");
                a(iVar, "reportActionInfo:fail", null);
                return true;
            }
            x.i("MicroMsg.MsgHandler", "doReportActionInfo, appId %s", new Object[]{rL(str5)});
            int i = 0;
            if (ao.isConnected(this.context)) {
                if (ao.isWifi(this.context)) {
                    i = 1;
                } else if (ao.is4G(this.context)) {
                    i = 4;
                } else if (ao.is3G(this.context)) {
                    i = 3;
                } else if (ao.is2G(this.context)) {
                    i = 2;
                }
                x.i("MicroMsg.MsgHandler", "doReportActionInfo, get networkType %d", new Object[]{Integer.valueOf(i)});
            }
            long VE = bi.VE();
            x.d("MicroMsg.MsgHandler", "report(%s), clickTimestamp : %d, appID %s, networkType %d, userAgent %s, url : %s, sessionID : %s, actionKey : %s, actionValue : %s", new Object[]{Integer.valueOf(13379), Long.valueOf(VE), r10, Integer.valueOf(i), str4, str5, str3, str, str2});
            String str6 = "";
            String str7 = "";
            String str8 = "";
            String str9 = "";
            try {
                str6 = URLEncoder.encode(bi.oV(str4), "UTF-8");
                str4 = URLEncoder.encode(str5, "UTF-8");
                try {
                    str5 = URLEncoder.encode(str, "UTF-8");
                } catch (UnsupportedEncodingException e3) {
                    e = e3;
                    str2 = str8;
                }
                try {
                    str = URLEncoder.encode(str2, "UTF-8");
                    obj = str5;
                } catch (UnsupportedEncodingException e4) {
                    e = e4;
                    str2 = str5;
                    x.printErrStackTrace("MicroMsg.MsgHandler", e, "", new Object[0]);
                    str = str9;
                    com.tencent.mm.plugin.report.service.h.mEJ.h(13379, new Object[]{Long.valueOf(VE), r10, Integer.valueOf(i), str6, str4, str3, obj, str});
                    a(iVar, "reportActionInfo:ok", null);
                    return true;
                }
            } catch (UnsupportedEncodingException e5) {
                e = e5;
                obj = str8;
                str4 = str7;
            }
            com.tencent.mm.plugin.report.service.h.mEJ.h(13379, new Object[]{Long.valueOf(VE), r10, Integer.valueOf(i), str6, str4, str3, obj, str});
            a(iVar, "reportActionInfo:ok", null);
            return true;
        }
    }

    private boolean ax(i iVar) {
        int a = com.tencent.mm.plugin.webview.modelcache.p.a(iVar);
        if (-1 == a) {
            a(this.pRY, iVar, "cache:fail", null, true, false);
            return true;
        }
        int i = -1;
        if (2 == a) {
            i = 2;
        } else if (1 == a) {
            i = 1;
        }
        if (-1 != i) {
            com.tencent.mm.plugin.report.service.h.mEJ.a(238, (long) i, 1, false);
        }
        x.i("MicroMsg.MsgHandler", "user not in white list");
        com.tencent.mm.plugin.webview.modelcache.m.Aq(a);
        a(this.pRY, iVar, "cache:not in white list", null, true, false);
        return true;
    }

    private boolean ay(i iVar) {
        x.i("MicroMsg.MsgHandler", "doAddCustomMenuItems start");
        int i;
        if (iVar.mcy.containsKey("hideMenu")) {
            i = bi.getInt((String) iVar.mcy.get("hideMenu"), 0);
            x.e("MicroMsg.MsgHandler", "doAddCustomMenuItems hideMenu=" + i);
            if (kn(i == 1)) {
                a(iVar, "doAddCustomMenuItems:ok", null);
            } else {
                a(iVar, "doAddCustomMenuItems:fail", null);
            }
        } else {
            kn(false);
            String str = (String) iVar.mcy.get("itemList");
            if (bi.oW(str)) {
                x.e("MicroMsg.MsgHandler", "doAddCustomMenuItems fail: key or title must not be null");
                a(iVar, "doAddCustomMenuItems:params error", null);
            } else {
                try {
                    JSONArray jSONArray = new JSONArray(str);
                    ArrayList arrayList = new ArrayList();
                    ArrayList arrayList2 = new ArrayList();
                    int length = jSONArray.length();
                    for (i = 0; i < length; i++) {
                        JSONObject optJSONObject = jSONArray.optJSONObject(i);
                        if (optJSONObject != null) {
                            String optString = optJSONObject.optString("key");
                            String optString2 = optJSONObject.optString("title");
                            if (bi.oW(optString) || bi.oW("title")) {
                                x.e("MicroMsg.MsgHandler", "key or title is null,ignore item: " + i);
                            } else {
                                arrayList.add(optString);
                                arrayList2.add(optString2);
                            }
                        }
                    }
                    if (arrayList.size() > 0) {
                        Bundle bundle = new Bundle();
                        bundle.putStringArrayList("keys", arrayList);
                        bundle.putStringArrayList("titles", arrayList2);
                        try {
                            this.pRY.Q(bundle);
                            a(iVar, "doAddCustomMenuItems:ok", null);
                        } catch (Throwable e) {
                            x.printErrStackTrace("MicroMsg.MsgHandler", e, "", new Object[0]);
                            x.e("MicroMsg.MsgHandler", "doAddCustomMenuItems:fail");
                            a(iVar, "doAddCustomMenuItems:fail", null);
                        }
                    }
                } catch (JSONException e2) {
                    x.e("MicroMsg.MsgHandler", "doAddCustomMenuItems eroor, parse itemList to jsonarray error");
                    a(iVar, "doAddCustomMenuItems:params parse error", null);
                }
            }
        }
        return true;
    }

    private boolean az(i iVar) {
        String str = (String) iVar.mcy.get("key");
        if (bi.oW(str)) {
            a(iVar, "getLocalData:fail_key_is_null", null);
        } else {
            try {
                String currentUrl = this.pRY.getCurrentUrl();
                String str2 = new String(Base64.encode(str.getBytes(), 0));
                str = this.qic.RE(currentUrl);
                com.tencent.mm.plugin.webview.model.ag bVa = com.tencent.mm.plugin.webview.modeltools.e.bVa();
                String Xl = bi.Xl(currentUrl);
                x.i("MicroMsg.WebViewLocalDataStorage", "get value by key = %s, appid = %s, domin = %s", new Object[]{str2, str, Xl});
                if (bi.oW(str2) || bi.oW(str) || bi.oW(currentUrl) || bi.oW(Xl)) {
                    str = null;
                } else {
                    str = "select value from WebviewLocalData where recordId = " + com.tencent.mm.plugin.webview.model.ag.ak(str, Xl, str2);
                    x.i("MicroMsg.WebViewLocalDataStorage", str);
                    Cursor rawQuery = bVa.rawQuery(str, new String[0]);
                    if (rawQuery == null) {
                        x.e("MicroMsg.WebViewLocalDataStorage", "get cursor is null");
                        str = null;
                    } else {
                        if (rawQuery.moveToFirst()) {
                            str = rawQuery.getString(0);
                        } else {
                            str = null;
                        }
                        rawQuery.close();
                        x.i("MicroMsg.WebViewLocalDataStorage", "get value : %s for key : %s", new Object[]{str, str2});
                    }
                }
                if (bi.oW(str)) {
                    a(iVar, "getLocalData:fail", null);
                } else {
                    String str3 = new String(Base64.decode(str.getBytes(), 0));
                    Map hashMap = new HashMap();
                    hashMap.put("data", str3);
                    x.i("MicroMsg.MsgHandler", "get local data, key = %s, value = %s", new Object[]{str2, str3});
                    a(iVar, "getLocalData:ok", hashMap);
                }
            } catch (Exception e) {
                x.e("MicroMsg.MsgHandler", "get url failed : %s", new Object[]{e.getMessage()});
                a(iVar, "getLocalData:fail", null);
            }
        }
        return true;
    }

    private boolean aA(i iVar) {
        String str = (String) iVar.mcy.get("key");
        String str2 = (String) iVar.mcy.get("data");
        x.i("MicroMsg.MsgHandler", "set local data, key = %s, data = %s", new Object[]{str, str2});
        if (bi.oW(str) || bi.oW(str2)) {
            a(iVar, "setLocalData:fail_param_should_not_null", null);
            return true;
        } else if (str.length() > 1024 || str2.length() > 1024) {
            a(iVar, "setLocalData:fail_param_lenght_too_long", null);
            return true;
        } else {
            try {
                String currentUrl = this.pRY.getCurrentUrl();
                byte[] encode = Base64.encode(str.getBytes(), 0);
                byte[] encode2 = Base64.encode(str2.getBytes(), 0);
                String str3 = new String(encode);
                String str4 = new String(encode2);
                str2 = this.qic.RE(currentUrl);
                com.tencent.mm.plugin.webview.model.ag bVa = com.tencent.mm.plugin.webview.modeltools.e.bVa();
                String Xl = bi.Xl(currentUrl);
                x.i("MicroMsg.WebViewLocalDataStorage", "set data, key = %s, value = %s, url = %s, appId = %s, domin = %s", new Object[]{str3, str4, currentUrl, str2, Xl});
                if (bi.oW(str3) || bi.oW(currentUrl) || bi.oW(str2) || bi.oW(Xl)) {
                    str = "fail_params_invalid";
                } else {
                    int ak = com.tencent.mm.plugin.webview.model.ag.ak(str2, Xl, str3);
                    str = "select count(*) from WebviewLocalData where appId = '" + str2 + "' and domin = '" + Xl + "'";
                    x.i("MicroMsg.WebViewLocalDataStorage", str);
                    Cursor rawQuery = bVa.rawQuery(str, new String[0]);
                    if (rawQuery != null) {
                        if (rawQuery.moveToFirst()) {
                            x.i("MicroMsg.WebViewLocalDataStorage", "now count = %d", new Object[]{Integer.valueOf(rawQuery.getInt(0))});
                            rawQuery.close();
                            if (rawQuery.getInt(0) >= 5) {
                                str = "fail_exceed_max_count";
                            } else {
                                rawQuery = bVa.rawQuery("select count(*) from WebviewLocalData where recordId =" + ak, new String[0]);
                                if (rawQuery != null) {
                                    if (rawQuery.moveToFirst()) {
                                        x.i("MicroMsg.WebViewLocalDataStorage", "sql = %s, count = %d", new Object[]{r7, Integer.valueOf(rawQuery.getInt(0))});
                                        rawQuery.close();
                                        if (rawQuery.getInt(0) > 0) {
                                            x.i("MicroMsg.WebViewLocalDataStorage", "sql = %s, ret = %b", new Object[]{"update WebviewLocalData set value = '" + str4 + "' where recordId =" + ak, Boolean.valueOf(bVa.fV("WebviewLocalData", "update WebviewLocalData set value = '" + str4 + "' where recordId =" + ak))});
                                            str = bVa.fV("WebviewLocalData", "update WebviewLocalData set value = '" + str4 + "' where recordId =" + ak) ? "ok" : "fail";
                                        }
                                    }
                                    rawQuery.close();
                                }
                            }
                        }
                        rawQuery.close();
                    }
                    af afVar = new af();
                    afVar.field_appId = str2;
                    afVar.field_domin = Xl;
                    afVar.field_key = str3;
                    afVar.field_value = str4;
                    afVar.field_recordId = ak;
                    x.i("MicroMsg.WebViewLocalDataStorage", "insert data, ret = %b", new Object[]{Boolean.valueOf(bVa.b(afVar))});
                    str = "ok";
                }
                x.i("MicroMsg.MsgHandler", "doSetLocalData retValue = %s", new Object[]{str});
                a(iVar, "setLocalData:" + str, null);
                return true;
            } catch (Exception e) {
                x.e("MicroMsg.MsgHandler", "get url failed : %s", new Object[]{e.getMessage()});
                a(iVar, "setLocalData:fail", null);
                return true;
            }
        }
    }

    private boolean aB(i iVar) {
        try {
            String currentUrl = this.pRY.getCurrentUrl();
            com.tencent.mm.plugin.webview.model.ag bVa = com.tencent.mm.plugin.webview.modeltools.e.bVa();
            String RE = this.qic.RE(currentUrl);
            String Xl = bi.Xl(currentUrl);
            x.i("MicroMsg.WebViewLocalDataStorage", "appid = %s, url = %s, domin = %s", new Object[]{RE, currentUrl, Xl});
            if (bi.oW(RE) || bi.oW(currentUrl) || bi.oW(Xl)) {
                currentUrl = "fail";
            } else {
                currentUrl = bVa.fV("WebviewLocalData", new StringBuilder("delete from WebviewLocalData where appId = '").append(RE).append("' and domin = '").append(Xl).append("'").toString()) ? "ok" : "fail";
            }
            x.i("MicroMsg.MsgHandler", "doClearLocalData retValue = %s", new Object[]{currentUrl});
            a(iVar, "clearLocalData:" + currentUrl, null);
        } catch (Exception e) {
            x.e("MicroMsg.MsgHandler", "get url failed : %s", new Object[]{e.getMessage()});
            a(iVar, "clearLocalData:fail", null);
        }
        return true;
    }

    private boolean aC(i iVar) {
        String currentUrl;
        String str = (String) iVar.mcy.get("useridlist");
        String str2 = (String) iVar.mcy.get("chatname");
        String str3 = (String) iVar.mcy.get("chatscene");
        try {
            currentUrl = this.pRY.getCurrentUrl();
        } catch (RemoteException e) {
            x.w("MicroMsg.MsgHandler", "exception in get currentUrl %s", new Object[]{e.getMessage()});
            currentUrl = null;
        }
        currentUrl = bi.oV(this.qic.RE(currentUrl));
        LinkedList linkedList = new LinkedList();
        String[] split = str.split(";");
        if (split == null || split.length <= 0) {
            a(iVar, "openEnterpriseChat:fail", null);
            return false;
        }
        for (Object add : split) {
            linkedList.add(add);
        }
        z.Ng();
        com.tencent.mm.kernel.g.Eh().dpP.a(new com.tencent.mm.ac.a.t(currentUrl, str2, linkedList, new 87(this, iVar, str3)), 0);
        return true;
    }

    private boolean aD(i iVar) {
        String currentUrl;
        String str = (String) iVar.mcy.get("chatId");
        String str2 = (String) iVar.mcy.get("chatType");
        try {
            currentUrl = this.pRY.getCurrentUrl();
        } catch (RemoteException e) {
            x.w("MicroMsg.MsgHandler", "exception in get currentUrl %s", new Object[]{e.getMessage()});
            currentUrl = null;
        }
        currentUrl = bi.oV(this.qic.RE(currentUrl));
        if (bi.oW(str) || bi.oW(str2) || bi.oW(currentUrl)) {
            a(iVar, "enterEnterpriseChat:fail_params error", null);
        } else {
            z.Ng();
            com.tencent.mm.kernel.g.Eh().dpP.a(new com.tencent.mm.ac.a.m(currentUrl, str, str2, new 88(this, iVar)), 0);
        }
        return true;
    }

    private boolean aE(i iVar) {
        try {
            String oV = bi.oV(this.qic.RE(this.pRY.getCurrentUrl()));
            if (bi.oW(oV)) {
                a(iVar, "getEnterpriseChat:fail", null);
            } else {
                Bundle bundle = new Bundle();
                bundle.putString("enterprise_action", "enterprise_get_context_bizchat");
                bundle = this.pRY.g(71, bundle);
                String string = bundle.getString("enterprise_context_biz");
                String bl = com.tencent.mm.ac.a.e.bl(bundle.getLong("enterprise_context_bizchatid", -1));
                if (bi.oW(string) || bi.oW(bl)) {
                    a(iVar, "getEnterpriseChat:fail_not in enterprise chat", null);
                } else {
                    90 90 = new 90(this, iVar);
                    com.tencent.mm.kernel.g.Eh().dpP.a(1285, 90);
                    if (!com.tencent.mm.ac.t.m(oV, string, bl)) {
                        com.tencent.mm.ac.t.a(90);
                        a(iVar, "getEnterpriseChat:fail", null);
                    }
                }
            }
        } catch (Exception e) {
            a(iVar, "getEnterpriseChat:fail", null);
        }
        return true;
    }

    private boolean aF(i iVar) {
        String currentUrl;
        try {
            currentUrl = this.pRY.getCurrentUrl();
        } catch (RemoteException e) {
            x.w("MicroMsg.MsgHandler", "exception in get currentUrl %s", new Object[]{e.getMessage()});
            currentUrl = null;
        }
        String oV = bi.oV(this.qic.RE(currentUrl));
        if (bi.oW(oV)) {
            a(iVar, "openEnterpriseContact:fail", null);
        }
        j jVar = new j(oV, currentUrl, iVar.mcy);
        au.DF().a(1393, new 91(this, iVar, this));
        au.DF().a(jVar, 0);
        Context context = this.context;
        this.context.getString(R.l.app_tip);
        this.eHw = com.tencent.mm.ui.base.h.a(context, this.context.getString(R.l.app_waiting), true, new 92(this, jVar));
        return true;
    }

    private boolean aG(final i iVar) {
        String currentUrl;
        try {
            currentUrl = this.pRY.getCurrentUrl();
        } catch (RemoteException e) {
            x.w("MicroMsg.MsgHandler", "exception in get currentUrl %s", new Object[]{e.getMessage()});
            currentUrl = null;
        }
        String oV = bi.oV(this.qic.RE(currentUrl));
        if (bi.oW(oV)) {
            a(iVar, "selectEnterpriseContact:fail", null);
        }
        iVar.mcy.put("groupId", "");
        iVar.mcy.put("timestamp", "");
        iVar.mcy.put("nonceStr", "");
        iVar.mcy.put("signature", "");
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray((String) iVar.mcy.get(DownloadSettingTable$Columns.TYPE));
            jSONObject.put("fromDepartmentId", Integer.parseInt((String) iVar.mcy.get("fromDepartmentId")));
            jSONObject.put("mode", (String) iVar.mcy.get("mode"));
            jSONObject.put(DownloadSettingTable$Columns.TYPE, jSONArray);
            String str = (String) iVar.mcy.get("selectedDepartmentIds");
            if (str != null) {
                jSONObject.put("selectedDepartmentIds", new JSONArray(str));
            }
            str = (String) iVar.mcy.get("selectedUserIds");
            if (str != null) {
                jSONObject.put("selectedUserIds", new JSONArray(str));
            }
            iVar.mcy.put("params", jSONObject);
        } catch (JSONException e2) {
        } catch (NumberFormatException e3) {
        }
        final j jVar = new j(oV, currentUrl, iVar.mcy);
        final AnonymousClass93 anonymousClass93 = new com.tencent.mm.ab.e() {
            public final void a(int i, int i2, String str, l lVar) {
                aau bTX;
                int i3 = -1;
                if (g.this.eHw != null && g.this.eHw.isShowing()) {
                    g.this.eHw.dismiss();
                    g.this.eHw = null;
                }
                au.DF().b(1393, this);
                String str2 = "selectEnterpriseContact:fail";
                if (i == 0 && i2 == 0) {
                    bTX = ((j) lVar).bTX();
                    if (!(bTX == null || bTX.riQ == null)) {
                        i3 = bTX.riQ.ret;
                        if (bTX.riQ.bMI != null && bTX.riQ.bMI.length() > 0) {
                            str2 = bTX.riQ.bMI;
                        }
                    }
                } else {
                    bTX = null;
                }
                if (i3 != 0) {
                    g.this.a(iVar, str2, null);
                    return;
                }
                str2 = bTX.rqU;
                Intent intent = new Intent();
                intent.putExtra("rawUrl", str2);
                intent.putExtra("useJs", true);
                ((MMActivity) g.this.context).geJ = this;
                com.tencent.mm.bg.d.b(g.this.context, "webview", ".ui.tools.WebViewUI", intent, 53);
            }
        };
        au.DF().a(1393, anonymousClass93);
        au.DF().a(jVar, 0);
        Context context = this.context;
        this.context.getString(R.l.app_tip);
        this.eHw = com.tencent.mm.ui.base.h.a(context, this.context.getString(R.l.app_waiting), true, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                au.DF().c(jVar);
                au.DF().b(1393, anonymousClass93);
            }
        });
        return true;
    }

    private boolean aH(i iVar) {
        if (this.pRY == null) {
            a(iVar, "sendEnterpriseChat:fail", null);
            return true;
        }
        try {
            Bundle bundle = new Bundle();
            bundle.putString("enterprise_action", "enterprise_get_context_bizchat");
            bundle = this.pRY.g(71, bundle);
            final String string = bundle.getString("enterprise_context_biz");
            final long j = bundle.getLong("enterprise_context_bizchatid", -1);
            if (bi.oW(string) || j < 0) {
                a(iVar, "sendEnterpriseChat:fail_not in enterprise chat", null);
                return true;
            }
            String str = (String) iVar.mcy.get(DownloadSettingTable$Columns.TYPE);
            if ("text".equals(str)) {
                return a(iVar, string, j);
            }
            if ("link".equals(str)) {
                JSONObject jSONObject = new JSONObject((String) iVar.mcy.get("data"));
                str = jSONObject.optString("link");
                String optString = jSONObject.optString("title");
                String optString2 = jSONObject.optString("desc");
                final String optString3 = jSONObject.optString("imgUrl");
                if (bi.oW(optString) && bi.oW(optString2)) {
                    a(iVar, "sendEnterpriseChat:fail_params error", null);
                    return true;
                } else if (bi.oW(str)) {
                    a(iVar, "sendEnterpriseChat:fail_params error", null);
                    return true;
                } else {
                    String str2;
                    WXWebpageObject wXWebpageObject = new WXWebpageObject();
                    wXWebpageObject.webpageUrl = str;
                    this.bSg = new WXMediaMessage();
                    this.bSg.mediaObject = wXWebpageObject;
                    this.bSg.title = optString;
                    this.bSg.description = optString2;
                    str = (String) iVar.mcy.get("appid");
                    if (this.qhS == null || !TextUtils.isEmpty(str)) {
                        str2 = str;
                    } else {
                        str2 = this.qhS.getString("jsapi_args_appid");
                    }
                    final f bl = com.tencent.mm.pluginsdk.model.app.g.bl(str2, true);
                    if (this.context == null || this.context.getResources() == null) {
                        x.e("MicroMsg.MsgHandler", "showSendAppMsgDialog fail, context or context.getResources() is null");
                        a(iVar, "sendEnterpriseChat:fail", null);
                        return true;
                    } else if (this.context instanceof Activity) {
                        final i iVar2 = iVar;
                        com.tencent.mm.pluginsdk.ui.applet.g.a(((MMActivity) this.context).mController, optString, optString3, optString2, true, this.context.getResources().getString(R.l.app_send), new com.tencent.mm.pluginsdk.ui.applet.q.a() {
                            public final void a(boolean z, String str, int i) {
                                if (!z) {
                                    g.this.a(iVar2, "sendEnterpriseChat:cancel", null);
                                } else if (bi.oW(optString3)) {
                                    com.tencent.mm.ac.a.c ak = z.Na().ak(j);
                                    synchronized (com.tencent.mm.ac.a.e.dNr) {
                                        String Ir = com.tencent.mm.ac.a.e.Ir();
                                        com.tencent.mm.ac.a.e.d(ak);
                                        g.this.a(bl, str2, string, optString3, null, null, str, null);
                                        com.tencent.mm.ac.a.e.lh(Ir);
                                    }
                                    g.this.a(iVar2, "sendEnterpriseChat:ok", null);
                                    if (g.this.context != null) {
                                        com.tencent.mm.ui.base.h.bA(g.this.context, g.this.context.getResources().getString(R.l.app_shared));
                                    }
                                } else {
                                    o.Pe().a(optString3, new 1(this, str));
                                }
                            }
                        });
                        return true;
                    } else {
                        x.e("MicroMsg.MsgHandler", "showsSendAppMsgDialog fail, context is not activity");
                        a(iVar, "sendEnterpriseChat:fail", null);
                        return true;
                    }
                }
            }
            a(iVar, "sendEnterpriseChat:fail_params error", null);
            return true;
        } catch (Exception e) {
            x.e("MicroMsg.MsgHandler", "clear webview cache fail : %s", new Object[]{e.getMessage()});
            a(iVar, "sendEnterpriseChat:fail", null);
            return true;
        }
    }

    private boolean a(i iVar, String str, long j) {
        String optString = new JSONObject((String) iVar.mcy.get("data")).optString("content");
        if (bi.oW(optString)) {
            a(iVar, "sendEnterpriseChat:fail_params error", null);
        } else {
            boolean m;
            com.tencent.mm.ac.a.c ak = z.Na().ak(j);
            synchronized (com.tencent.mm.ac.a.e.dNr) {
                String Ir = com.tencent.mm.ac.a.e.Ir();
                com.tencent.mm.ac.a.e.d(ak);
                ow owVar = new ow();
                owVar.bZQ.bZR = str;
                owVar.bZQ.content = optString;
                owVar.bZQ.type = com.tencent.mm.model.s.hQ(str);
                owVar.bZQ.flags = 0;
                m = com.tencent.mm.sdk.b.a.sFg.m(owVar);
                com.tencent.mm.ac.a.e.lh(Ir);
            }
            if (m) {
                a(iVar, "sendEnterpriseChat:ok", null);
                if (this.context != null) {
                    com.tencent.mm.ui.base.h.bA(this.context, this.context.getResources().getString(R.l.app_shared));
                }
            } else {
                a(iVar, "sendEnterpriseChat:fail", null);
            }
        }
        return true;
    }

    private boolean aI(i iVar) {
        x.i("MicroMsg.MsgHandler", "start doChangePayActivityView");
        com.tencent.mm.g.a.am amVar = new com.tencent.mm.g.a.am();
        String str = (String) iVar.mcy.get("showInfo");
        if (bi.oW(str)) {
            x.e("MicroMsg.MsgHandler", "changePayActivityView eroor, parse showinfo to jsonarray error");
            a(iVar, "changePayActivityView:fail", null);
            return false;
        }
        try {
            boolean z;
            JSONObject jSONObject = new JSONObject(str);
            amVar.bHP.bHR = jSONObject.getString("buttonTitle");
            str = jSONObject.getString("isButtonEnable");
            String string = jSONObject.getString("isButtonHidden");
            String string2 = jSONObject.getString("isActivityViewHidden");
            x.i("MicroMsg.MsgHandler", "isButtonEnable:" + str + " isButtonHidden:" + string + " isActivityViewHidden:" + string2);
            amVar.bHP.bHS = bi.getInt(str, 0) > 0;
            com.tencent.mm.g.a.am.a aVar = amVar.bHP;
            if (bi.getInt(string, 0) > 0) {
                z = true;
            } else {
                z = false;
            }
            aVar.bHT = z;
            com.tencent.mm.g.a.am.a aVar2 = amVar.bHP;
            if (bi.getInt(string2, 0) > 0) {
                z = true;
            } else {
                z = false;
            }
            aVar2.bHU = z;
            com.tencent.mm.sdk.b.a.sFg.m(amVar);
            if (amVar.bHQ.bGZ) {
                x.i("MicroMsg.MsgHandler", "changePayActivityView:ok");
                a(iVar, "changePayActivityView:ok", null);
            } else {
                x.i("MicroMsg.MsgHandler", "changePayActivityView:fail");
                a(iVar, "changePayActivityView:fail", null);
            }
            return true;
        } catch (Exception e) {
            x.e("MicroMsg.MsgHandler", "changePayActivityView eroor, parse showinfo to jsonarray error");
            a(iVar, "changePayActivityView:fail", null);
            return false;
        }
    }

    private boolean aJ(i iVar) {
        String str = (String) iVar.mcy.get("idKeyDataInfo");
        if (bi.oW(str)) {
            x.e("MicroMsg.MsgHandler", "idkey data is null");
            a(iVar, "reportIDKey:fail_invaild_parms", null);
        } else {
            try {
                JSONArray jSONArray = new JSONArray(str);
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(i);
                    IDKey iDKey = new IDKey();
                    iDKey.SetID(bi.getInt(optJSONObject.optString("id"), 0));
                    iDKey.SetKey(bi.getInt(optJSONObject.optString("key"), 0));
                    iDKey.SetValue((long) bi.getInt(optJSONObject.optString(DownloadSettingTable$Columns.VALUE), 0));
                    arrayList.add(iDKey);
                }
                if (arrayList.size() > 0) {
                    com.tencent.mm.plugin.report.service.h.mEJ.b(arrayList, true);
                    a(iVar, "reportIDKey:ok", null);
                }
            } catch (Exception e) {
                x.e("MicroMsg.MsgHandler", "parse json array faild : %s", new Object[]{e.getMessage()});
            }
            a(iVar, "reportIDKey:fail", null);
        }
        return false;
    }

    private boolean aK(i iVar) {
        String str = (String) iVar.mcy.get(TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_URL);
        if (bi.oW(str)) {
            x.e("MicroMsg.MsgHandler", "url is null or nil");
            a(iVar, "openCunstonWebview:fail_invalid_url", null);
            return true;
        }
        int i;
        boolean z;
        boolean z2;
        boolean z3;
        Object obj;
        boolean z4;
        String oV;
        String oV2;
        boolean z5;
        String oV3;
        Intent intent;
        gl glVar;
        String oV4 = bi.oV((String) iVar.mcy.get("orientation"));
        if (!bi.oW(oV4)) {
            if (oV4.equals("horizontal")) {
                i = 0;
            } else if (oV4.equals("vertical")) {
                i = 1;
            } else if (oV4.equals("sensor")) {
                i = 4;
            }
            z = false;
            if (bi.oV((String) iVar.mcy.get("fullscreen")).equals("true")) {
                z = true;
            }
            iVar.mcy.get("top_url");
            iVar.mcy.get("top_title");
            z2 = false;
            if (this.pRY != null) {
                z2 = this.pRY.g(81, new Bundle()).getBoolean("from_shortcut", false);
            }
            z3 = z2;
            obj = null;
            if (bi.oV((String) iVar.mcy.get("finish_recent_webview")).equals("1")) {
                obj = 1;
            }
            z4 = false;
            if (bi.oV((String) iVar.mcy.get("disable_swipe_back")).equals("1")) {
                z4 = true;
            }
            oV = bi.oV((String) iVar.mcy.get("username"));
            oV2 = bi.oV((String) iVar.mcy.get("open_game_webview"));
            z2 = false;
            if (this.pRY != null) {
                z2 = this.pRY.g(86, new Bundle()).getBoolean("is_from_keep_top");
            }
            z5 = z2;
            oV3 = bi.oV((String) iVar.mcy.get("gameAppid"));
            intent = new Intent();
            intent.putExtra("rawUrl", str);
            intent.putExtra("screen_orientation", i);
            intent.putExtra("show_full_screen", z);
            intent.putExtra("disable_swipe_back", z4);
            intent.putExtra("from_shortcut", z3);
            intent.putExtra("shortcut_user_name", oV);
            intent.putExtra("is_from_keep_top", z5);
            intent.putExtra("game_hv_menu_appid", oV3);
            if (z3) {
                com.tencent.mm.bg.d.b(this.context, "webview", ".ui.tools.game.H5GameWebViewUI", intent);
            } else if (bi.oV(oV2).equals("1")) {
                com.tencent.mm.plugin.webview.ui.tools.d.a(intent.getExtras(), "webview", ".ui.tools.game.GameWebViewUI", this.pRY, new 101(this, intent));
            } else {
                com.tencent.mm.bg.d.b(this.context, "webview", ".ui.tools.WebViewUI", intent);
            }
            if (!(obj == null || z3)) {
                ah.i(new 102(this), 200);
            }
            glVar = new gl();
            glVar.bPC.nc = 2;
            glVar.bPC.bPE = oV3;
            com.tencent.mm.sdk.b.a.sFg.m(glVar);
            a(iVar, "openCunstonWebview:ok", null);
            return true;
        }
        i = -1;
        z = false;
        if (bi.oV((String) iVar.mcy.get("fullscreen")).equals("true")) {
            z = true;
        }
        iVar.mcy.get("top_url");
        iVar.mcy.get("top_title");
        z2 = false;
        try {
            if (this.pRY != null) {
                z2 = this.pRY.g(81, new Bundle()).getBoolean("from_shortcut", false);
            }
            z3 = z2;
        } catch (Exception e) {
            x.e("MicroMsg.MsgHandler", "doOpenCustomWebview, get from shortcut exception : %s", new Object[]{e.getMessage()});
            z3 = false;
        }
        obj = null;
        if (bi.oV((String) iVar.mcy.get("finish_recent_webview")).equals("1")) {
            obj = 1;
        }
        z4 = false;
        if (bi.oV((String) iVar.mcy.get("disable_swipe_back")).equals("1")) {
            z4 = true;
        }
        oV = bi.oV((String) iVar.mcy.get("username"));
        oV2 = bi.oV((String) iVar.mcy.get("open_game_webview"));
        z2 = false;
        try {
            if (this.pRY != null) {
                z2 = this.pRY.g(86, new Bundle()).getBoolean("is_from_keep_top");
            }
            z5 = z2;
        } catch (Exception e2) {
            x.e("MicroMsg.MsgHandler", "doOpenCustomWebview, get from keep top exception : %s", new Object[]{e2.getMessage()});
            z5 = false;
        }
        oV3 = bi.oV((String) iVar.mcy.get("gameAppid"));
        intent = new Intent();
        intent.putExtra("rawUrl", str);
        intent.putExtra("screen_orientation", i);
        intent.putExtra("show_full_screen", z);
        intent.putExtra("disable_swipe_back", z4);
        intent.putExtra("from_shortcut", z3);
        intent.putExtra("shortcut_user_name", oV);
        intent.putExtra("is_from_keep_top", z5);
        intent.putExtra("game_hv_menu_appid", oV3);
        if (z3) {
            com.tencent.mm.bg.d.b(this.context, "webview", ".ui.tools.game.H5GameWebViewUI", intent);
        } else if (bi.oV(oV2).equals("1")) {
            com.tencent.mm.plugin.webview.ui.tools.d.a(intent.getExtras(), "webview", ".ui.tools.game.GameWebViewUI", this.pRY, new 101(this, intent));
        } else {
            com.tencent.mm.bg.d.b(this.context, "webview", ".ui.tools.WebViewUI", intent);
        }
        ah.i(new 102(this), 200);
        glVar = new gl();
        glVar.bPC.nc = 2;
        glVar.bPC.bPE = oV3;
        com.tencent.mm.sdk.b.a.sFg.m(glVar);
        a(iVar, "openCunstonWebview:ok", null);
        return true;
    }

    private boolean aL(i iVar) {
        String oV = bi.oV((String) iVar.mcy.get("orientation"));
        int i = -1;
        if (!bi.oW(oV)) {
            if (oV.equals("horizontal")) {
                i = 0;
            } else if (oV.equals("vertical")) {
                i = 1;
            } else if (oV.equals("sensor")) {
                i = 4;
            } else if (oV.equals("horizontal_unforced")) {
                i = 1001;
            } else if (oV.equals("vertical_unforced")) {
                i = 1002;
            }
        }
        try {
            if (this.pRY != null) {
                Bundle bundle = new Bundle();
                bundle.putInt("screen_orientation", i);
                this.pRY.g(1009, bundle);
                a(iVar, "setScreenOrientation:ok", null);
            } else {
                a(iVar, "setScreenOrientation:fail", null);
            }
        } catch (Exception e) {
            x.e("MicroMsg.MsgHandler", "doSetScreenOrientation exception, " + e.getMessage());
            a(iVar, "setScreenOrientation:fail", null);
        }
        return true;
    }

    private boolean aM(i iVar) {
        x.i("MicroMsg.MsgHandler", bh.NAME);
        boolean equals = "1".equals((String) iVar.mcy.get("actionCode"));
        Bundle bundle = new Bundle();
        if (equals) {
            bundle.putBoolean("set_navigation_bar_color_reset", true);
        } else {
            int parseColor;
            int i;
            try {
                parseColor = Color.parseColor((String) iVar.mcy.get("color")) | -16777216;
            } catch (Exception e) {
                x.e("MicroMsg.MsgHandler", e.getMessage());
                bundle.putBoolean("set_navigation_bar_color_reset", true);
                parseColor = -1;
            }
            try {
                i = (int) (bi.getFloat((String) iVar.mcy.get("alpha"), 1.0f) * 255.0f);
                if (i < 0 || i > 255) {
                    i = 255;
                }
            } catch (Exception e2) {
                x.e("MicroMsg.MsgHandler", e2.getMessage());
                i = -1;
            }
            bundle.putInt("set_navigation_bar_color_color", parseColor);
            bundle.putInt("set_navigation_bar_color_alpha", i);
        }
        try {
            this.pRY.g(53, bundle);
            a(iVar, "setNavigationBarColor:ok", null);
        } catch (Exception e22) {
            x.e("MicroMsg.MsgHandler", e22.getMessage());
            a(iVar, "setNavigationBarColor:fail", null);
        }
        return true;
    }

    public final void a(String str, boolean z, String str2, long j) {
        Bundle bundle = new Bundle();
        bundle.putString("emoji_store_json_data", str);
        bundle.putBoolean("emoji_store_new_query", z);
        bundle.putString("emoji_store_page_buf", str2);
        bundle.putLong("emoji_store_search_id", j);
        x.d("MicroMsg.MsgHandler", "cpan emoji getSearchEmotionDataCallBack:%d", new Object[]{Long.valueOf(j)});
        try {
            if (this.pRY != null) {
                this.pRY.c(80001, bundle);
            }
        } catch (RemoteException e) {
            x.w("MicroMsg.MsgHandler", "getSearchEmotionDataCallBack exception" + e.getMessage());
        }
    }

    private boolean kn(boolean z) {
        x.e("MicroMsg.MsgHandler", "hideMenuEntry:" + z);
        try {
            this.pRY.jX(z);
            x.e("MicroMsg.MsgHandler", "hideMenuEntry succ");
            return true;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.MsgHandler", e, "", new Object[0]);
            x.e("MicroMsg.MsgHandler", "hideMenuEntry error");
            x.e("MicroMsg.MsgHandler", "hideMenuEntry succ");
            return false;
        } catch (Throwable th) {
            x.e("MicroMsg.MsgHandler", "hideMenuEntry succ");
            return true;
        }
    }

    private boolean aN(i iVar) {
        x.i("MicroMsg.MsgHandler", "doSendAppMsgToSpecifiedContact");
        String str = (String) iVar.mcy.get("openid");
        if (bi.oW(str)) {
            x.e("MicroMsg.MsgHandler", "doSendAppMsgToSpecifiedContact openid is null");
            a(iVar, "sendAppMessageToSpecifiedContact:fail", null);
        } else {
            String str2 = (String) iVar.mcy.get("appId");
            if (this.qhS != null && TextUtils.isEmpty(str2)) {
                str2 = this.qhS.getString("jsapi_args_appid");
            }
            if (bi.oW(str2)) {
                x.e("MicroMsg.MsgHandler", "doSendAppMsgToSpecifiedContact appid is null");
                a(iVar, "sendAppMessageToSpecifiedContact:fail", null);
            } else {
                this.bSg = f(iVar);
                com.tencent.mm.plugin.webview.model.w wVar = new com.tencent.mm.plugin.webview.model.w(str2, str);
                au.DF().a(1142, new 110(this, iVar, str2));
                au.DF().a(wVar, 0);
                Context context = this.context;
                this.context.getString(R.l.app_tip);
                this.eHw = com.tencent.mm.ui.base.h.a(context, this.context.getString(R.l.app_waiting), true, new 112(this, wVar));
            }
        }
        return true;
    }

    private boolean bYk() {
        try {
            Bundle bundle = new Bundle(1);
            bundle.putString("place_holder", "place_holder");
            this.pRY.bVn();
            this.pRY.P(bundle);
        } catch (Exception e) {
        }
        return true;
    }

    public final boolean aO(i iVar) {
        x.i("MicroMsg.MsgHandler", "doWCPayRealnameVerify call");
        com.tencent.mm.pluginsdk.wallet.g gVar = new com.tencent.mm.pluginsdk.wallet.g(iVar.mcy);
        Intent intent = new Intent();
        String str = null;
        try {
            str = this.pRY.getCurrentUrl();
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.MsgHandler", e, "", new Object[0]);
        }
        if (!bi.oW(str)) {
            intent.putExtra("appId", this.qic.RE(str));
            intent.putExtra("timeStamp", gVar.timeStamp);
            intent.putExtra("nonceStr", gVar.nonceStr);
            intent.putExtra("packageExt", gVar.packageExt);
            intent.putExtra("signtype", gVar.signType);
            intent.putExtra("paySignature", gVar.bVW);
            try {
                intent.putExtra(TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_URL, this.pRY.getCurrentUrl());
            } catch (Throwable e2) {
                x.printErrStackTrace("MicroMsg.MsgHandler", e2, "", new Object[0]);
            }
            intent.setFlags(536870912);
            intent.putExtra("pay_channel", gVar.bJY);
            intent.putExtra("realname_scene", 1);
            ((MMActivity) this.context).geJ = this;
            com.tencent.mm.bg.d.b(this.context, "wallet_core", ".id_verify.WalletRealNameProcessProxyUI", intent, 34);
        }
        return true;
    }

    public final boolean bYl() {
        x.i("MicroMsg.MsgHandler", "doSwitchWalletCurrency call");
        ((MMActivity) this.context).geJ = this;
        com.tencent.mm.bg.d.b(this.context, "wallet_core", ".ui.WalletSwitchWalletCurrencyUI", null, 35);
        return true;
    }

    private boolean aP(i iVar) {
        boolean z;
        String str = (String) iVar.mcy.get("clearCookie");
        x.i("MicroMsg.MsgHandler", "clearflag = %s", new Object[]{str});
        if (bi.oW(str) || !str.equalsIgnoreCase("true")) {
            z = false;
        } else {
            z = true;
        }
        str = (String) iVar.mcy.get(TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_URL);
        if (!bi.oW(str)) {
            str = com.tencent.mm.plugin.webview.modelcache.p.QB(str);
            if (bi.oW(str)) {
                str = null;
            } else {
                Uri parse = Uri.parse(str);
                str = parse.getHost() + ":" + parse.getPort();
            }
            if (!bi.oW(str)) {
                com.tencent.mm.plugin.webview.modelcache.q.a.bUL().Em().H(new 114(this, str));
            }
        }
        if (this.pRY != null) {
            Bundle bundle = new Bundle();
            bundle.putBoolean("clear_webview_cache_clear_cookie", z);
            try {
                this.pRY.g(6001, bundle);
                a(iVar, "clearWebviewCache:ok", null);
            } catch (Exception e) {
                x.e("MicroMsg.MsgHandler", "clear webview cache fail : %s", new Object[]{e.getMessage()});
                a(iVar, "clearWebviewCache:fail", null);
            }
        } else {
            a(iVar, "clearWebviewCache:fail", null);
        }
        return true;
    }

    public final boolean aQ(i iVar) {
        x.i("MicroMsg.MsgHandler", "doIdCardRealnameVerify call");
        com.tencent.mm.pluginsdk.wallet.g gVar = new com.tencent.mm.pluginsdk.wallet.g(iVar.mcy);
        Intent intent = new Intent();
        String str = null;
        try {
            str = this.pRY.getCurrentUrl();
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.MsgHandler", e, "", new Object[0]);
        }
        if (!bi.oW(str)) {
            intent.putExtra("appId", this.qic.RE(str));
            intent.putExtra("timeStamp", gVar.timeStamp);
            intent.putExtra("nonceStr", gVar.nonceStr);
            intent.putExtra("packageExt", gVar.packageExt);
            intent.putExtra("signtype", gVar.signType);
            intent.putExtra("paySignature", gVar.bVW);
            try {
                intent.putExtra(TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_URL, this.pRY.getCurrentUrl());
            } catch (Throwable e2) {
                x.printErrStackTrace("MicroMsg.MsgHandler", e2, "", new Object[0]);
            }
            intent.putExtra("pay_channel", gVar.bJY);
            intent.putExtra("real_name_verify_mode", 2);
            intent.setFlags(536870912);
            intent.putExtra("realname_scene", 1);
            ((MMActivity) this.context).geJ = this;
            com.tencent.mm.bg.d.b(this.context, "wallet_core", ".id_verify.WalletRealNameProcessProxyUI", intent, 41);
        }
        return true;
    }

    public final boolean aR(i iVar) {
        a(iVar, "uploadIdCardSuccess:ok", null);
        x.i("MicroMsg.MsgHandler", "uploadIdCardSuccess");
        tl tlVar = new tl();
        tlVar.ceY.result = -1;
        com.tencent.mm.sdk.b.a.sFg.m(tlVar);
        return true;
    }

    public final boolean aS(i iVar) {
        x.i("MicroMsg.MsgHandler", "getGameCommInfo call");
        int i = bi.getInt((String) iVar.mcy.get("cmd"), 0);
        String str = (String) iVar.mcy.get("param");
        Map hashMap;
        if (i != 10002) {
            gl glVar = new gl();
            glVar.bPC.nc = i;
            glVar.bPC.bPE = str;
            glVar.bPC.context = this.context;
            com.tencent.mm.sdk.b.a.sFg.m(glVar);
            x.i("MicroMsg.MsgHandler", "gameCommInfo:%s", new Object[]{glVar.bPD.result});
            if (bi.oW(glVar.bPD.result)) {
                a(iVar, "getGameCommInfo:fail", null);
            } else {
                try {
                    hashMap = new HashMap();
                    JSONObject jSONObject = new JSONObject(glVar.bPD.result);
                    Iterator keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        str = (String) keys.next();
                        hashMap.put(str, jSONObject.getString(str));
                    }
                    a(iVar, "getGameCommInfo:ok", hashMap);
                } catch (JSONException e) {
                    a(iVar, "getGameCommInfo:fail", null);
                }
            }
        } else if (this.pRY != null) {
            try {
                Bundle g = this.pRY.g(97, null);
                if (g != null) {
                    int i2 = g.getInt("web_page_count");
                    hashMap = new HashMap();
                    hashMap.put("webpageCount", Integer.valueOf(i2));
                    a(iVar, "getGameCommInfo:ok", hashMap);
                }
            } catch (RemoteException e2) {
                x.e("MicroMsg.MsgHandler", "doGetGameCommInfo exception, " + e2.getMessage());
                a(iVar, "getGameCommInfo:fail", null);
            }
        }
        return true;
    }

    public final boolean bYm() {
        x.i("MicroMsg.MsgHandler", "openGameRegion call");
        if (this.context instanceof MMActivity) {
            ((MMActivity) this.context).geJ = this;
            com.tencent.mm.bg.d.a(this.context, "game", ".ui.GameRegionSelectUI", null, 42, false);
        }
        return true;
    }

    public final boolean aT(i iVar) {
        k kVar = new k(this.context);
        kVar.b(null, new 115(this), new 116(this, iVar));
        kVar.d(new 117(this, iVar));
        kVar.bEo();
        return true;
    }

    private boolean aU(i iVar) {
        String str;
        if (this.qhS != null) {
            int i = this.qhS.getInt("key_download_restrict", 0);
            if (!bi.oW(this.qhS.getString("key_function_id", ""))) {
                com.tencent.mm.plugin.report.service.h.mEJ.h(14596, new Object[]{str, Integer.valueOf(i), Integer.valueOf(1)});
            }
            if (i == 1) {
                x.e("MicroMsg.MsgHandler", "not allow to launch application");
                a(iVar, "launchApplication:fail", null);
                return true;
            }
        }
        x.i("MicroMsg.MsgHandler", "launchTimeInterval = %d", new Object[]{Long.valueOf(bi.VE() - this.qig)});
        if (bi.VE() - this.qig < 2 && this.qig > 0) {
            try {
                String encode = URLEncoder.encode(this.pRY.getCurrentUrl(), "UTF-8");
                com.tencent.mm.plugin.report.service.h.mEJ.h(13983, new Object[]{Integer.valueOf(5), encode, ""});
            } catch (Exception e) {
                x.e("MicroMsg.MsgHandler", "report launchApplication failed");
            }
        }
        String str2 = (String) iVar.mcy.get("appID");
        String str3 = (String) iVar.mcy.get("schemeUrl");
        String str4 = (String) iVar.mcy.get("parameter");
        int i2 = bi.getInt((String) iVar.mcy.get("alertType"), 0);
        l.a(iVar.qkk, false, null, str2);
        x.i("MicroMsg.MsgHandler", "doLaunchApplication, appid : %s, scheme : %s, extinfo:[%s], parameter : %s", new Object[]{str2, str3, (String) iVar.mcy.get("extInfo"), str4});
        if (bi.oW(str2) && bi.oW(str3)) {
            x.e("MicroMsg.MsgHandler", "appid and scheme is null or nil");
            a(iVar, "launchApplication:fail", null);
            return true;
        }
        Object obj = iVar.mcy.get("__jsapi_fw_ext_info");
        str = null;
        if (obj instanceof Bundle) {
            str = ((Bundle) obj).getString("__jsapi_fw_ext_info_key_current_url");
        }
        String RE = this.qic.RE(str);
        Bundle bundle = new Bundle();
        if (!bi.oW(str)) {
            try {
                bundle.putString("current_page_url", URLEncoder.encode(str, "UTF-8"));
            } catch (UnsupportedEncodingException e2) {
            }
        }
        bundle.putString("current_page_appid", RE);
        com.tencent.mm.ab.b.a aVar = new com.tencent.mm.ab.b.a();
        aVar.dIG = new aog();
        aVar.dIH = new aoh();
        aVar.uri = "/cgi-bin/mmbiz-bin/checklaunchapp";
        aVar.dIF = 1125;
        com.tencent.mm.ab.b KT = aVar.KT();
        aog aog = (aog) KT.dID.dIL;
        aog.bPS = RE;
        aog.rQM = str2;
        aog.scene = akt();
        aog.url = str;
        aog.rQN = str3;
        aog.hUp = i2;
        aog.rQO = 0;
        x.i("MicroMsg.MsgHandler", "run cgi to check(appId : %s, toAppId : %s, scene : %s, url : %s, schemeUrl : %s, alertType : %s)", new Object[]{RE, str2, Integer.valueOf(aog.scene), aog.url, aog.rQN, Integer.valueOf(aog.hUp)});
        v.a(KT, new 119(this, iVar, str3, bundle, r5, str2, str4));
        return true;
    }

    private boolean a(i iVar, a aVar) {
        String currentUrl;
        x.i("MicroMsg.MsgHandler", "doLogin!");
        LinkedList linkedList = new LinkedList();
        String str = "";
        String str2 = "";
        try {
            currentUrl = this.pRY.getCurrentUrl();
        } catch (Exception e) {
            x.e("MicroMsg.MsgHandler", "exception in get currentUrl %s", new Object[]{e.getMessage()});
            currentUrl = null;
        }
        String oV = bi.oV(this.qic.RE(currentUrl));
        if (bi.oW(oV)) {
            x.e("MicroMsg.MsgHandler", "appId is null!");
            a(iVar, "doLogin:fail", null);
            aVar.aia();
            return false;
        }
        au.DF().a(new com.tencent.mm.u.a.c(oV, linkedList, str2, str, new 4(this, iVar, aVar, oV)), 0);
        return true;
    }

    private boolean b(i iVar, a aVar) {
        x.i("MicroMsg.MsgHandler", "doOauthAuthorize!");
        String str = (String) iVar.mcy.get("scope");
        if (bi.oW(str)) {
            x.e("MicroMsg.MsgHandler", "scope is null!");
            a(iVar, "authorize:fail", null);
            aVar.aia();
            return true;
        }
        String currentUrl;
        try {
            currentUrl = this.pRY.getCurrentUrl();
        } catch (Exception e) {
            x.e("MicroMsg.MsgHandler", "exception in get currentUrl %s", new Object[]{e.getMessage()});
            currentUrl = null;
        }
        currentUrl = bi.oV(this.qic.RE(currentUrl));
        if (bi.oW(currentUrl)) {
            x.e("MicroMsg.MsgHandler", "appId is null!");
            a(iVar, "authorize:fail", null);
            aVar.aia();
            return false;
        }
        LinkedList linkedList = new LinkedList();
        try {
            JSONArray jSONArray = new JSONArray(str);
            for (int i = 0; i < jSONArray.length(); i++) {
                linkedList.add(jSONArray.optString(i));
            }
            au.DF().a(new com.tencent.mm.u.a.a(currentUrl, linkedList, new 6(this, iVar, aVar, currentUrl)), 0);
            return true;
        } catch (Exception e2) {
            x.e("MicroMsg.MsgHandler", "Exception %s", new Object[]{e2.getMessage()});
            a(iVar, "authorize:fail", null);
            return true;
        }
    }

    public final void em(int i, int i2) {
        String str = "";
        String str2 = " ";
        Bundle bundle = null;
        try {
            if (this.pRY != null) {
                bundle = this.pRY.g(77, null);
            }
            if (bundle != null) {
                str = bundle.getString("KUrl");
                if (TextUtils.isEmpty(str)) {
                    x.e("MicroMsg.MsgHandler", "url is empty");
                    return;
                }
                x.i("MicroMsg.MsgHandler", "sessionId %s", new Object[]{bi.oV(bundle.getString("KSessionId"))});
                if (!bundle.getBoolean("KReportPage", false)) {
                    x.i("MicroMsg.MsgHandler", "not enable report page event control bytes");
                    return;
                }
            }
        } catch (Exception e) {
            x.e("MicroMsg.MsgHandler", "get sessionId error, %s", new Object[]{e});
        }
        if (TextUtils.isEmpty(rL(str))) {
            x.i("MicroMsg.MsgHandler", "appId is null or empty");
            return;
        }
        x.i("MicroMsg.MsgHandler", "appId %s", new Object[]{rL(str)});
        x.i("MicroMsg.MsgHandler", "type %d", new Object[]{Integer.valueOf(this.bSg.mediaObject.type())});
        if (this.bSg.mediaObject.type() == 5) {
            long VE = bi.VE();
            x.d("MicroMsg.MsgHandler", "report(%s), clickTimestamp : %d, appID : %s, url : %s, sessionId : %s, actionType : %d, flag : %d", new Object[]{Integer.valueOf(13377), Long.valueOf(VE), r3, str, str2, Integer.valueOf(i), Integer.valueOf(i2)});
            String str3 = "";
            try {
                str = URLEncoder.encode(bi.oV(str), "UTF-8");
            } catch (Throwable e2) {
                x.printErrStackTrace("MicroMsg.MsgHandler", e2, "", new Object[0]);
                str = str3;
            }
            com.tencent.mm.plugin.report.service.h.mEJ.h(13377, new Object[]{Long.valueOf(VE), r3, str, str2, Integer.valueOf(i), Integer.valueOf(i2)});
        }
    }

    private void aV(i iVar) {
        Bundle aq = i.aq(iVar.mcy);
        try {
            this.pRY.bVn();
            this.pRY.P(aq);
        } catch (RemoteException e) {
            x.w("MicroMsg.MsgHandler", "SendServiceAppMsg doCloseWindow, ex = " + e.getMessage());
        }
    }

    public final void b(int i, int i2, Intent intent) {
        x.i("MicroMsg.MsgHandler", "mmOnActivityResult, requestCode = " + i + ", resultCode = " + i2);
        String str;
        SnsAdClick snsAdClick;
        Object obj;
        String str2;
        String str3;
        String str4;
        String str5;
        String bYc;
        int i3;
        int i4;
        String aG;
        String aG2;
        String aG3;
        Map hashMap;
        Map hashMap2;
        WebViewJSSDKFileItem Qq;
        WebViewJSSDKVideoItem webViewJSSDKVideoItem;
        Bundle bundleExtra;
        Context context;
        Bundle bundle;
        if (i == 1) {
            if (this.bSg == null) {
                x.e("MicroMsg.MsgHandler", "mmOnActivityResult fail, appmsg is null");
                a(this.qhP, "send_app_msg:fail", null);
                return;
            }
            String string;
            str = (String) this.qhP.mcy.get("appid");
            snsAdClick = null;
            if (this.qhS != null) {
                snsAdClick = (SnsAdClick) this.qhS.getParcelable("KSnsAdTag");
                if (TextUtils.isEmpty(str)) {
                    string = this.qhS.getString("jsapi_args_appid");
                    obj = this.qhP.bYt().get("Internal@AsyncReport");
                    this.qhP.mcy.get("link");
                    switch (i2) {
                        case -1:
                            if (snsAdClick != null) {
                                snsAdClick.in(7);
                            }
                            f Jn = com.tencent.mm.pluginsdk.model.app.g.Jn(string);
                            if (intent == null) {
                                str2 = null;
                            } else {
                                str2 = intent.getStringExtra("Select_Conv_User");
                            }
                            if (str2 == null || str2.length() == 0) {
                                x.e("MicroMsg.MsgHandler", "mmOnActivityResult fail, toUser is null");
                                a(this.qhP, "send_app_msg:fail", null);
                                return;
                            }
                            str3 = (String) this.qhP.mcy.get("img_url");
                            this.qhP.mcy.get("desc");
                            str4 = (String) this.qhP.mcy.get("src_username");
                            str5 = (String) this.qhP.mcy.get("src_displayname");
                            bYc = bYc();
                            l.a(this.qhP.bYt(), RM("sendAppMessage"), str2, string);
                            if (obj != null && (obj instanceof Boolean) && ((Boolean) obj).booleanValue()) {
                                b(this.qhP, true);
                            }
                            String[] split = str2.split(",");
                            i3 = 0;
                            int i5 = 0;
                            int length = split.length;
                            int i6 = 0;
                            while (i6 < length) {
                                if (split[i6].endsWith("@chatroom")) {
                                    i4 = i3 + 1;
                                } else {
                                    i5++;
                                    i4 = i3;
                                }
                                i6++;
                                i3 = i4;
                            }
                            Map hashMap3 = new HashMap();
                            if (this.qhP.mcy.get("share_callback_with_scene") != null && ((Boolean) this.qhP.mcy.get("share_callback_with_scene")).booleanValue()) {
                                hashMap3.put("groupCount", Integer.valueOf(i3));
                                hashMap3.put("singleCount", Integer.valueOf(i5));
                            }
                            if (bi.oW(bYc)) {
                                a(null, "", str2, str3, str4, str5, intent == null ? null : intent.getStringExtra("custom_send_text"), bYc);
                                if (this.context != null) {
                                    com.tencent.mm.ui.base.h.bx(this.context, this.context.getResources().getString(R.l.app_shared));
                                }
                                em(1, 1);
                                a(this.qhP, "send_app_msg:ok", hashMap3);
                                return;
                            } else if (bi.oW(str3)) {
                                a(null, "", str2, str3, str4, str5, null, bYc);
                                com.tencent.mm.ui.base.h.bx(this.context, this.context.getString(R.l.app_saved));
                                a(this.qhP, "send_app_msg:ok", hashMap3);
                                return;
                            } else {
                                o.Pe().a(str3, new 10(this, com.tencent.mm.ui.base.h.a(this.context, this.context.getResources().getString(R.l.app_sending), true, new 9(this, str3)), Jn, string, str2, str3, str4, str5, bYc, hashMap3));
                                return;
                            }
                        case 0:
                            if (snsAdClick != null) {
                                snsAdClick.in(8);
                            }
                            l.a(this.qhP.bYt(), RM("sendAppMessage"), null, string);
                            if (obj != null && (obj instanceof Boolean) && ((Boolean) obj).booleanValue()) {
                                b(this.qhP, true);
                            }
                            em(1, 3);
                            a(this.qhP, "send_app_msg:cancel", null);
                            return;
                        default:
                            return;
                    }
                }
            }
            string = str;
            obj = this.qhP.bYt().get("Internal@AsyncReport");
            this.qhP.mcy.get("link");
            switch (i2) {
                case -1:
                    if (snsAdClick != null) {
                        snsAdClick.in(7);
                    }
                    f Jn2 = com.tencent.mm.pluginsdk.model.app.g.Jn(string);
                    if (intent == null) {
                        str2 = null;
                    } else {
                        str2 = intent.getStringExtra("Select_Conv_User");
                    }
                    if (str2 == null || str2.length() == 0) {
                        x.e("MicroMsg.MsgHandler", "mmOnActivityResult fail, toUser is null");
                        a(this.qhP, "send_app_msg:fail", null);
                        return;
                    }
                    str3 = (String) this.qhP.mcy.get("img_url");
                    this.qhP.mcy.get("desc");
                    str4 = (String) this.qhP.mcy.get("src_username");
                    str5 = (String) this.qhP.mcy.get("src_displayname");
                    bYc = bYc();
                    l.a(this.qhP.bYt(), RM("sendAppMessage"), str2, string);
                    if (obj != null && (obj instanceof Boolean) && ((Boolean) obj).booleanValue()) {
                        b(this.qhP, true);
                    }
                    String[] split2 = str2.split(",");
                    i3 = 0;
                    int i52 = 0;
                    int length2 = split2.length;
                    int i62 = 0;
                    while (i62 < length2) {
                        if (split2[i62].endsWith("@chatroom")) {
                            i4 = i3 + 1;
                        } else {
                            i52++;
                            i4 = i3;
                        }
                        i62++;
                        i3 = i4;
                    }
                    Map hashMap32 = new HashMap();
                    if (this.qhP.mcy.get("share_callback_with_scene") != null && ((Boolean) this.qhP.mcy.get("share_callback_with_scene")).booleanValue()) {
                        hashMap32.put("groupCount", Integer.valueOf(i3));
                        hashMap32.put("singleCount", Integer.valueOf(i52));
                    }
                    if (bi.oW(bYc)) {
                        a(null, "", str2, str3, str4, str5, intent == null ? null : intent.getStringExtra("custom_send_text"), bYc);
                        if (this.context != null) {
                            com.tencent.mm.ui.base.h.bx(this.context, this.context.getResources().getString(R.l.app_shared));
                        }
                        em(1, 1);
                        a(this.qhP, "send_app_msg:ok", hashMap32);
                        return;
                    } else if (bi.oW(str3)) {
                        a(null, "", str2, str3, str4, str5, null, bYc);
                        com.tencent.mm.ui.base.h.bx(this.context, this.context.getString(R.l.app_saved));
                        a(this.qhP, "send_app_msg:ok", hashMap32);
                        return;
                    } else {
                        o.Pe().a(str3, new 10(this, com.tencent.mm.ui.base.h.a(this.context, this.context.getResources().getString(R.l.app_sending), true, new 9(this, str3)), Jn2, string, str2, str3, str4, str5, bYc, hashMap32));
                        return;
                    }
                case 0:
                    if (snsAdClick != null) {
                        snsAdClick.in(8);
                    }
                    l.a(this.qhP.bYt(), RM("sendAppMessage"), null, string);
                    if (obj != null && (obj instanceof Boolean) && ((Boolean) obj).booleanValue()) {
                        b(this.qhP, true);
                    }
                    em(1, 3);
                    a(this.qhP, "send_app_msg:cancel", null);
                    return;
                default:
                    return;
            }
        } else if (i == 2) {
            switch (i2) {
                case -1:
                    com.tencent.mm.ui.base.h.bx(this.context, this.context.getResources().getString(R.l.app_shared));
                    a(this.qhP, "share_weibo:ok", null);
                    return;
                case 0:
                    a(this.qhP, "share_weibo:cancel", null);
                    return;
                case 1:
                    a(this.qhP, "share_weibo:fail_" + intent.getIntExtra("err_code", 0), null);
                    return;
                default:
                    a(this.qhP, "share_weibo:fail_" + intent.getIntExtra("err_code", 0), null);
                    x.e("MicroMsg.MsgHandler", "unknown resultCode");
                    return;
            }
        } else if (i == 3) {
            x.i("MicroMsg.MsgHandler", "get callback address, result code = %d", new Object[]{Integer.valueOf(i2)});
            if (i2 == -1 && intent != null) {
                str = bi.aG(intent.getStringExtra("nationalCode"), "");
                aG = bi.aG(intent.getStringExtra("userName"), "");
                aG2 = bi.aG(intent.getStringExtra("telNumber"), "");
                str2 = bi.aG(intent.getStringExtra("addressPostalCode"), "");
                str3 = bi.aG(intent.getStringExtra("proviceFirstStageName"), "");
                str4 = bi.aG(intent.getStringExtra("addressCitySecondStageName"), "");
                str5 = bi.aG(intent.getStringExtra("addressCountiesThirdStageName"), "");
                aG3 = bi.aG(intent.getStringExtra("addressDetailInfo"), "");
                x.i("MicroMsg.MsgHandler", "first =  " + str3 + " ; detail =" + aG3 + "; second = " + str4 + " ; tel = " + aG2 + "; third = " + str5);
                if (!bi.oW(aG)) {
                    Map hashMap4 = new HashMap();
                    hashMap4.put("nationalCode", str);
                    hashMap4.put("userName", aG);
                    hashMap4.put("telNumber", aG2);
                    hashMap4.put("addressPostalCode", str2);
                    hashMap4.put("proviceFirstStageName", str3);
                    hashMap4.put("addressCitySecondStageName", str4);
                    hashMap4.put("addressCountiesThirdStageName", str5);
                    hashMap4.put("addressDetailInfo", aG3);
                    a(this.qhP, "edit_address:ok", hashMap4);
                    return;
                }
            }
            if (i2 == 0) {
                a(this.qhP, "edit_address:cancel", null);
            } else {
                a(this.qhP, "edit_address:fail", null);
            }
        } else if (i == 4) {
            x.i("MicroMsg.MsgHandler", "request pay, resultCode = " + i2);
            if (this.qii != -1) {
                x.d("MicroMsg.MsgHandler", "hy: has blocked ");
                this.qhP = a(this.qii).qhP;
                this.pRY = a(this.qii).pRY;
                this.qii = -1;
            }
            if (i2 == -1) {
                if (intent != null) {
                    x.i("MicroMsg.MsgHandler", "closePage: %s", new Object[]{Integer.valueOf(intent.getIntExtra("key_jsapi_close_page_after_pay", 0))});
                    if (intent.getIntExtra("key_jsapi_close_page_after_pay", 0) == 1) {
                        try {
                            if (this.context != null && (this.context instanceof Activity)) {
                                ((Activity) this.context).finish();
                            }
                            if (this.pRY != null) {
                                this.pRY.bVn();
                                this.pRY.P(null);
                            }
                        } catch (Throwable e) {
                            x.printErrStackTrace("MicroMsg.MsgHandler", e, "", new Object[0]);
                        }
                    }
                }
                a(this.qhP, "get_brand_wcpay_request:ok", null);
            } else if (i2 == 5) {
                hashMap = new HashMap();
                i3 = intent.getIntExtra("key_jsapi_pay_err_code", 0);
                aG2 = bi.oV(intent.getStringExtra("key_jsapi_pay_err_msg"));
                hashMap.put("err_code", Integer.valueOf(i3));
                hashMap.put("err_desc", aG2);
                x.e("MicroMsg.MsgHandler", "hy: pay jsapi failed. errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i3), aG2});
                a(this.qhP, "get_brand_wcpay_request:fail", hashMap);
            } else {
                a(this.qhP, "get_brand_wcpay_request:cancel", null);
            }
        } else if (i == 27) {
            x.i("MicroMsg.MsgHandler", "request ibg prepay request, resultCode = " + i2);
            if (this.qii != -1) {
                x.d("MicroMsg.MsgHandler", "hy: has blocked ");
                this.qhP = a(this.qii).qhP;
                this.pRY = a(this.qii).pRY;
                this.qii = -1;
            }
            if (i2 == -1) {
                if (intent != null) {
                    if (intent.hasExtra(TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_URL)) {
                        str = null;
                        if (intent.hasExtra("view_port_code")) {
                            str = intent.getStringExtra("view_port_code");
                        }
                        try {
                            this.pRY.fp(intent.getStringExtra(TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_URL), str);
                        } catch (RemoteException e2) {
                        }
                    }
                }
                a(this.qhP, "get_h5_prepay_request:ok", null);
                return;
            }
            a(this.qhP, "get_h5_prepay_request:cancel", null);
        } else if (i == 5) {
            x.i("MicroMsg.MsgHandler", "request jump to mall, resultCode = " + i2);
            if (i2 == -1) {
                a(this.qhP, "jump_wcmall:ok", null);
            } else {
                a(this.qhP, "jump_wcmall:fail", null);
            }
        } else if (i == 6) {
            x.i("MicroMsg.MsgHandler", "request jump to product view, resultCode = " + i2);
            if (i2 == -1) {
                a(this.qhP, "open_product_view:ok", null);
            } else {
                a(this.qhP, "open_product_view:fail", null);
            }
        } else if (i == 7) {
            x.i("MicroMsg.MsgHandler", "request bind card, resultCode = " + i2);
            if (i2 == -1) {
                a(this.qhP, "get_brand_wcpay_bind_card_request:ok", null);
                com.tencent.mm.plugin.report.service.h.mEJ.h(14954, new Object[]{com.tencent.mm.pluginsdk.wallet.f.cfF(), "get_brand_wcpay_bind_card_request:ok"});
            } else {
                a(this.qhP, "get_brand_wcpay_bind_card_request:fail", null);
                if (!com.tencent.mm.pluginsdk.wallet.f.cfE()) {
                    com.tencent.mm.plugin.report.service.h.mEJ.h(14954, new Object[]{com.tencent.mm.pluginsdk.wallet.f.cfF(), "get_brand_wcpay_bind_card_request:fail"});
                }
            }
            if (!com.tencent.mm.pluginsdk.wallet.f.cfE()) {
                com.tencent.mm.pluginsdk.wallet.f.cfG();
            }
        } else if (i == 9) {
            x.i("MicroMsg.MsgHandler", "request open wxcredit, resultCode = " + i2);
            if (i2 == -1) {
                a(this.qhP, "get_wcpay_create_credit_card_request:ok", null);
            } else {
                a(this.qhP, "get_wcpay_create_credit_card_request:fail", null);
            }
        } else if (i == 8) {
            x.i("MicroMsg.MsgHandler", "request jumpToBizProfile, resultCode = " + i2);
            switch (i2) {
                case -1:
                    a(this.qhP, "jump_to_biz_profile:ok", null);
                    return;
                case 0:
                    a(this.qhP, "jump_to_biz_profile:cancel", null);
                    return;
                case 2:
                case 3:
                    a(this.qhP, "jump_to_biz_profile:check_fail", null);
                    return;
                default:
                    a(this.qhP, "jump_to_biz_profile:fail", null);
                    x.e("MicroMsg.MsgHandler", "unknown resultCode");
                    return;
            }
        } else if (i == 10) {
            if (i2 == 0) {
                x.i("MicroMsg.MsgHandler", "open scan product ui back");
                a(this.qhP, "open_scan_product_view:ok", null);
            }
        } else if (i == 11) {
            x.i("MicroMsg.MsgHandler", "request transfer_money, resultCode = " + i2);
            if (i2 == -1) {
                a(this.qhP, "get_transfer_money_request:ok", null);
                com.tencent.mm.plugin.report.service.h.mEJ.h(14954, new Object[]{com.tencent.mm.pluginsdk.wallet.f.cfF(), "get_transfer_money_request:ok"});
            } else {
                a(this.qhP, "get_transfer_money_request:fail", null);
                if (!com.tencent.mm.pluginsdk.wallet.f.cfE()) {
                    com.tencent.mm.plugin.report.service.h.mEJ.h(14954, new Object[]{com.tencent.mm.pluginsdk.wallet.f.cfF(), "get_transfer_money_request:fail"});
                }
            }
            if (!com.tencent.mm.pluginsdk.wallet.f.cfE()) {
                com.tencent.mm.pluginsdk.wallet.f.cfG();
            }
        } else if (i == 17) {
            x.i("MicroMsg.MsgHandler", "request open_wcpay_specific_view, resultCode = " + i2);
            if (intent != null) {
                if ("1".equals(intent.getStringExtra("closeWebView"))) {
                    x.i("MicroMsg.MsgHandler", "close web view");
                    try {
                        this.pRY.bVn();
                        this.pRY.P(null);
                    } catch (RemoteException e3) {
                    }
                }
            }
            if (i2 == -1) {
                a(this.qhP, "open_wcpay_specific_view:ok", null);
                com.tencent.mm.plugin.report.service.h.mEJ.h(14954, new Object[]{com.tencent.mm.pluginsdk.wallet.f.cfF(), "open_wcpay_specific_view:ok"});
            } else {
                a(this.qhP, "open_wcpay_specific_view:fail", null);
                if (!com.tencent.mm.pluginsdk.wallet.f.cfE()) {
                    com.tencent.mm.plugin.report.service.h.mEJ.h(14954, new Object[]{com.tencent.mm.pluginsdk.wallet.f.cfF(), "open_wcpay_specific_view:fail"});
                }
            }
            if (!com.tencent.mm.pluginsdk.wallet.f.cfE()) {
                com.tencent.mm.pluginsdk.wallet.f.cfG();
            }
        } else if (i == 18) {
            x.i("MicroMsg.MsgHandler", "request request_wcpay_send_c2c_msg, resultCode = " + i2);
            if (i2 == -1) {
                a(this.qhP, "get_send_c2c_message_request:ok", null);
                com.tencent.mm.plugin.report.service.h.mEJ.h(14954, new Object[]{com.tencent.mm.pluginsdk.wallet.f.cfF(), "get_send_c2c_message_request:ok"});
            } else if (i2 == 0) {
                a(this.qhP, "get_send_c2c_message_request:cancel", null);
                com.tencent.mm.plugin.report.service.h.mEJ.h(14954, new Object[]{com.tencent.mm.pluginsdk.wallet.f.cfF(), "get_send_c2c_message_request:cancel"});
            } else {
                a(this.qhP, "get_send_c2c_message_request:fail", null);
                if (!com.tencent.mm.pluginsdk.wallet.f.cfE()) {
                    com.tencent.mm.plugin.report.service.h.mEJ.h(14954, new Object[]{com.tencent.mm.pluginsdk.wallet.f.cfF(), "get_send_c2c_message_request:fail"});
                }
            }
            if (!com.tencent.mm.pluginsdk.wallet.f.cfE()) {
                com.tencent.mm.pluginsdk.wallet.f.cfG();
            }
        } else if (i == 13) {
            x.d("MicroMsg.MsgHandler", "request choose card, resultCode = " + i2);
            hashMap = new HashMap();
            if (i2 == -1) {
                if (intent != null) {
                    hashMap.put("choose_card_info", bi.aG(intent.getStringExtra("choose_card_info"), ""));
                }
                a(this.qhP, "choose_card:ok", hashMap);
            } else if (i2 == 0) {
                a(this.qhP, "choose_card:cancel", hashMap);
            } else {
                a(this.qhP, "choose_card:fail", hashMap);
            }
        } else if (i == 36) {
            x.d("MicroMsg.MsgHandler", "request choose invoice, resultCode = " + i2);
            hashMap = new HashMap();
            if (i2 == -1) {
                if (intent != null) {
                    hashMap.put("choose_invoice_info", bi.aG(intent.getStringExtra("choose_invoice_info"), ""));
                }
                a(this.qhP, "choose_invoice:ok", hashMap);
            } else if (i2 == 0) {
                a(this.qhP, "choose_invoice:cancel", hashMap);
            } else {
                a(this.qhP, "choose_invoice:fail", hashMap);
            }
        } else if (i == 16) {
            x.d("MicroMsg.MsgHandler", "request batch add card, resultCode = " + i2);
            hashMap2 = new HashMap();
            if (intent != null) {
                hashMap2.put("card_list", bi.aG(intent.getStringExtra("card_list"), ""));
            }
            if (i2 == -1) {
                a(this.qhP, "batch_add_card:ok", hashMap2);
                return;
            }
            i4 = 2;
            if (intent != null) {
                i4 = intent.getIntExtra("result_code", 2);
            }
            if (i4 == 2) {
                a(this.qhP, "batch_add_card:fail", hashMap2);
            } else {
                a(this.qhP, "batch_add_card:cancel", hashMap2);
            }
        } else if (i == 23) {
            if (i2 == -1) {
                a(this.qhP, "batch_view_card:ok", null);
            } else {
                a(this.qhP, "batch_view_card:fail", null);
            }
        } else if (i == 15) {
            if (this.qhP == null || bi.oW(this.qhP.qkl)) {
                x.e("MicroMsg.MsgHandler", "msg is null");
                return;
            }
            x.i("MicroMsg.MsgHandler", "request to scan qr code, result code = %d, function is %s", new Object[]{Integer.valueOf(i2), this.qhP.qkl});
            if (this.qhP.qkl.equals("scanQRCode")) {
                switch (i2) {
                    case -1:
                        hashMap = new HashMap();
                        if (intent != null) {
                            hashMap.put("resultStr", intent.getStringExtra("key_scan_result"));
                        }
                        a(this.qhP, "scanQRCode:ok", hashMap);
                        return;
                    case 0:
                        a(this.qhP, "scanQRCode:cancel", null);
                        return;
                    default:
                        a(this.qhP, "scanQRCode:fail", null);
                        return;
                }
            }
        } else if (i == 14) {
            x.i("MicroMsg.MsgHandler", "request to open file chooser, result code = %d, hasShowMemoryWarning = %b", new Object[]{Integer.valueOf(i2), Boolean.valueOf(intent == null ? false : intent.getBooleanExtra("key_pick_local_media_show_memory_warning", false))});
            hashMap2 = new HashMap();
            if (intent == null ? false : intent.getBooleanExtra("key_pick_local_media_show_memory_warning", false)) {
                hashMap2.put("memoryWarning", Boolean.valueOf(true));
            }
            switch (i2) {
                case -1:
                    str = intent.getStringExtra("key_pick_local_pic_callback_local_ids");
                    x.i("MicroMsg.MsgHandler", "localIds = %s", new Object[]{str});
                    if (!bi.oW(str)) {
                        hashMap2.put("localIds", str);
                        str = intent.getStringExtra("key_pick_local_pic_source_type");
                        if (str != null) {
                            hashMap2.put("sourceType", str);
                        }
                        a(this.qhP, "chooseImage:ok", hashMap2);
                        return;
                    }
                    break;
                case 0:
                    a(this.qhP, "chooseImage:cancel", hashMap2);
                    return;
            }
            a(this.qhP, "chooseImage:fail", hashMap2);
        } else if (i == 32) {
            switch (i2) {
                case -1:
                    aG = intent.getStringExtra("key_pick_local_media_local_id");
                    if (!bi.oW(aG)) {
                        Qq = com.tencent.mm.plugin.webview.modeltools.e.bUX().Qq(aG);
                        if (Qq != null && (Qq instanceof WebViewJSSDKVideoItem)) {
                            webViewJSSDKVideoItem = (WebViewJSSDKVideoItem) Qq;
                            Map hashMap5 = new HashMap();
                            hashMap5.put("localId", aG);
                            hashMap5.put("duration", Integer.valueOf(webViewJSSDKVideoItem.duration));
                            hashMap5.put("height", Integer.valueOf(webViewJSSDKVideoItem.height));
                            hashMap5.put("size", Integer.valueOf(webViewJSSDKVideoItem.size));
                            hashMap5.put("width", Integer.valueOf(webViewJSSDKVideoItem.width));
                            a(this.qhP, "chooseVideo:ok", hashMap5);
                            return;
                        }
                    }
                    a(this.qhP, "chooseVideo:fail", null);
                    return;
                case 0:
                    a(this.qhP, "chooseVideo:cancel", null);
                    return;
                default:
                    a(this.qhP, "chooseVideo:fail", null);
                    return;
            }
        } else if (i == 45) {
            switch (i2) {
                case -1:
                    aG = intent.getStringExtra("key_pick_local_media_local_id");
                    aG2 = intent.getStringExtra("key_pick_local_media_thumb_local_id");
                    x.i("MicroMsg.MsgHandler", "localId:%s", new Object[]{aG});
                    x.i("MicroMsg.MsgHandler", "thumbLocalId:%s", new Object[]{aG2});
                    if (!bi.oW(aG)) {
                        Qq = com.tencent.mm.plugin.webview.modeltools.e.bUX().Qq(aG);
                        if (Qq != null && (Qq instanceof WebViewJSSDKVideoItem)) {
                            webViewJSSDKVideoItem = (WebViewJSSDKVideoItem) Qq;
                            Map hashMap6 = new HashMap();
                            hashMap6.put("localId", aG);
                            hashMap6.put("duration", Integer.valueOf(webViewJSSDKVideoItem.duration));
                            hashMap6.put("height", Integer.valueOf(webViewJSSDKVideoItem.height));
                            hashMap6.put("size", Integer.valueOf(webViewJSSDKVideoItem.size));
                            hashMap6.put("width", Integer.valueOf(webViewJSSDKVideoItem.width));
                            hashMap6.put("thumbLocalId", aG2);
                            a(this.qhP, "recordVideo:ok", hashMap6);
                            return;
                        }
                    }
                    a(this.qhP, "recordVideo:fail", null);
                    return;
                case 0:
                    a(this.qhP, "recordVideo:cancel", null);
                    return;
                default:
                    a(this.qhP, "recordVideo:fail", null);
                    return;
            }
        } else if (i == 47) {
            switch (i2) {
                case -1:
                    if (intent == null) {
                        x.e("MicroMsg.MsgHandler", "mmOnActivityResult REQUEST_CHOOSE_MEDIA data is null,");
                        a(this.qhP, "chooseMedia:fail", null);
                        return;
                    }
                    i4 = intent.getIntExtra("key_pick_local_media_callback_type", 0);
                    if (i4 == 1) {
                        str = intent.getStringExtra("key_pick_local_media_local_id");
                        aG = intent.getStringExtra("key_pick_local_media_thumb_local_id");
                        x.i("MicroMsg.MsgHandler", "video localId:%s", new Object[]{str});
                        x.i("MicroMsg.MsgHandler", "video thumbLocalId:%s", new Object[]{aG});
                        if (bi.oW(str)) {
                            x.e("MicroMsg.MsgHandler", "mmOnActivityResult REQUEST_CHOOSE_MEDIA video localId is null");
                            a(this.qhP, "chooseMedia:fail", null);
                            return;
                        }
                        WebViewJSSDKFileItem Qq2 = com.tencent.mm.plugin.webview.modeltools.e.bUX().Qq(str);
                        if (Qq2 == null || !(Qq2 instanceof WebViewJSSDKVideoItem)) {
                            x.e("MicroMsg.MsgHandler", "mmOnActivityResult REQUEST_CHOOSE_MEDIA nor the videoitem");
                            a(this.qhP, "chooseMedia:fail", null);
                            return;
                        }
                        WebViewJSSDKVideoItem webViewJSSDKVideoItem2 = (WebViewJSSDKVideoItem) Qq2;
                        x.i("MicroMsg.MsgHandler", "after parse to json data : %s", new Object[]{aj.c(str, aG, webViewJSSDKVideoItem2.duration, webViewJSSDKVideoItem2.height, webViewJSSDKVideoItem2.width, webViewJSSDKVideoItem2.size)});
                        hashMap2 = new HashMap();
                        hashMap2.put(DownloadSettingTable$Columns.TYPE, Integer.valueOf(1));
                        hashMap2.put("localIds", str);
                        a(this.qhP, "chooseMedia:ok", hashMap2);
                        return;
                    } else if (i4 == 2) {
                        str = intent.getStringExtra("key_pick_local_media_local_ids");
                        x.i("MicroMsg.MsgHandler", "chooseMedia localIds:%s", new Object[]{str});
                        if (bi.oW(str)) {
                            x.e("MicroMsg.MsgHandler", "mmOnActivityResult REQUEST_CHOOSE_MEDIA image localIds is null");
                            a(this.qhP, "chooseMedia:fail", null);
                            return;
                        }
                        hashMap2 = new HashMap();
                        hashMap2.put(DownloadSettingTable$Columns.TYPE, Integer.valueOf(2));
                        hashMap2.put("localIds", str);
                        a(this.qhP, "chooseMedia:ok", hashMap2);
                        return;
                    } else {
                        x.e("MicroMsg.MsgHandler", "type:%d is error", new Object[]{Integer.valueOf(i4)});
                        a(this.qhP, "chooseMedia:fail", null);
                        return;
                    }
                case 0:
                    a(this.qhP, "chooseMedia:cancel", null);
                    return;
                default:
                    a(this.qhP, "chooseMedia:fail", null);
                    return;
            }
        } else if (i == 46) {
            switch (i2) {
                case -1:
                    a(this.qhP, "previewVideo:ok", null);
                    return;
                case 0:
                    a(this.qhP, "previewVideo:cancel", null);
                    return;
                default:
                    a(this.qhP, "previewVideo:fail", null);
                    return;
            }
        } else if (i == 19) {
            x.i("MicroMsg.MsgHandler", "request to config exdevice wifi connection, result code = " + i2);
            switch (i2) {
                case -1:
                    a(this.qhP, "configWXDeviceWiFi:ok", null);
                    return;
                case 0:
                    hashMap = null;
                    if (intent != null) {
                        if (!intent.getBooleanExtra("is_wifi_connected", true)) {
                            hashMap = new HashMap();
                            hashMap.put("desc", "wifi_not_connected");
                        }
                    }
                    a(this.qhP, "configWXDeviceWiFi:cancel", hashMap);
                    return;
                case 1:
                    a(this.qhP, "configWXDeviceWiFi:fail", null);
                    return;
                default:
                    return;
            }
        } else if (i == 20) {
            x.i("MicroMsg.MsgHandler", "request request_verify_wcpay_password, resultCode = " + i2);
            hashMap2 = new HashMap();
            if (i2 == -1) {
                CharSequence charSequence = "";
                if (intent != null) {
                    charSequence = bi.aG(intent.getStringExtra("token"), "");
                }
                if (TextUtils.isEmpty(charSequence)) {
                    x.i("MicroMsg.MsgHandler", "checkPwdToken is empty, verifyWCPayPassword:fail");
                    a(this.qhP, "verifyWCPayPassword:fail", null);
                    if (!com.tencent.mm.pluginsdk.wallet.f.cfE()) {
                        com.tencent.mm.plugin.report.service.h.mEJ.h(14954, new Object[]{com.tencent.mm.pluginsdk.wallet.f.cfF(), "verifyWCPayPassword:fail"});
                    }
                } else {
                    hashMap2.put("token", charSequence);
                    a(this.qhP, "verifyWCPayPassword:ok", hashMap2);
                    com.tencent.mm.plugin.report.service.h.mEJ.h(14954, new Object[]{com.tencent.mm.pluginsdk.wallet.f.cfF(), "verifyWCPayPassword:ok"});
                    x.i("MicroMsg.MsgHandler", "checkPwdToken is valid, verifyWCPayPassword:ok");
                }
            } else {
                x.i("MicroMsg.MsgHandler", "resultCode is canlcel, verifyWCPayPassword:fail");
                a(this.qhP, "verifyWCPayPassword:fail", null);
                if (!com.tencent.mm.pluginsdk.wallet.f.cfE()) {
                    com.tencent.mm.plugin.report.service.h.mEJ.h(14954, new Object[]{com.tencent.mm.pluginsdk.wallet.f.cfF(), "verifyWCPayPassword:fail"});
                }
            }
            if (!com.tencent.mm.pluginsdk.wallet.f.cfE()) {
                com.tencent.mm.pluginsdk.wallet.f.cfG();
            }
        } else if (21 == i) {
            x.d("MicroMsg.MsgHandler", "hy: callback to see order. directly finish");
            a(this.qhP, "see_order_ok", null);
        } else if (i == 22) {
            x.i("MicroMsg.MsgHandler", "request get_recevie_biz_hongbao_request, resultCode = " + i2);
            if (i2 == -1) {
                a(this.qhP, "get_recevie_biz_hongbao_request:ok", null);
            } else if (i == 0) {
                a(this.qhP, "get_recevie_biz_hongbao_request:cancel", null);
            } else {
                a(this.qhP, "get_recevie_biz_hongbao_request:fail", null);
            }
        } else if (i == 24) {
            if (i2 == -1) {
                em(2, 1);
                if (bi.getInt((String) this.qhP.mcy.get("open_from_scene"), 0) == 4) {
                    com.tencent.mm.plugin.fav.a.h.f(this.qhS.getLong("favlocalid", 0), 0, 0);
                }
                try {
                    if (this.pRY != null) {
                        str = (String) this.qhP.mcy.get("appId");
                        if (TextUtils.isEmpty(str)) {
                            aG = (String) this.qhP.mcy.get("appid");
                        } else {
                            aG = str;
                        }
                        a(aG, (String) this.qhP.mcy.get("img_url"), 1, this.pRY.g(85, null));
                    }
                } catch (RemoteException e4) {
                    x.e("MicroMsg.MsgHandler", "invokeAsResult : %s", new Object[]{e4});
                }
                a(this.qhP, "share_timeline:ok", null);
                return;
            }
            em(2, 3);
            a(this.qhP, "share_timeline:cancel", null);
        } else if (i == 26) {
            x.d("MicroMsg.MsgHandler", "select pedometer source resultCode = " + i2);
            if (i2 == -1) {
                a(this.qhP, "selectPedometerSource:ok", null);
            } else if (i2 == 0) {
                x.i("MicroMsg.MsgHandler", "selectPedometerSource result cancel");
                a(this.qhP, "selectPedometerSource:cancel", null);
            } else {
                x.e("MicroMsg.MsgHandler", "selectPedometerSource result fail");
                a(this.qhP, "selectPedometerSource:fail", null);
            }
        } else if (i == 25) {
            x.i("MicroMsg.MsgHandler", "hy: get ibg order finish. result code: %d", new Object[]{Integer.valueOf(i2)});
            if (this.qih == 1 && this.pRY != null) {
                try {
                    this.pRY.bVn();
                    this.pRY.P(null);
                } catch (Throwable e5) {
                    x.printErrStackTrace("MicroMsg.MsgHandler", e5, "", new Object[0]);
                }
            }
            if (i2 == -1) {
                a(this.qhP, "get_h5_transaction_request:ok", null);
            } else {
                a(this.qhP, "get_h5_transaction_request:cancel", null);
            }
        } else if (i == 28) {
            x.i("MicroMsg.MsgHandler", "get web pay checkout counter request finish. result code: %d", new Object[]{Integer.valueOf(i2)});
            if (i2 == -1) {
                hashMap = new HashMap();
                aG = bi.aG(intent.getStringExtra("token"), "");
                aG2 = bi.aG(intent.getStringExtra("bind_serial"), "");
                hashMap.put("token", aG);
                hashMap.put("bind_serial", aG2);
                a(this.qhP, "getWebPayCheckoutCounterRequst:ok", hashMap);
                com.tencent.mm.plugin.report.service.h.mEJ.h(14954, new Object[]{com.tencent.mm.pluginsdk.wallet.f.cfF(), "getWebPayCheckoutCounterRequst:ok"});
            } else {
                a(this.qhP, "getWebPayCheckoutCounterRequst:fail", null);
                if (!com.tencent.mm.pluginsdk.wallet.f.cfE()) {
                    com.tencent.mm.plugin.report.service.h.mEJ.h(14954, new Object[]{com.tencent.mm.pluginsdk.wallet.f.cfF(), "getWebPayCheckoutCounterRequst:fail"});
                }
            }
            if (!com.tencent.mm.pluginsdk.wallet.f.cfE()) {
                com.tencent.mm.pluginsdk.wallet.f.cfG();
            }
        } else if (i == 31) {
            if (i2 != -1) {
                a(this.qhP, "openEnterpriseContact:ok", null);
                return;
            }
            bundleExtra = intent.getBundleExtra("result_data");
            if (bundleExtra != null) {
                str = bundleExtra.getString("result");
                hashMap2 = new HashMap();
                hashMap2.put("result", str);
                a(this.qhP, "openEnterpriseContact:ok", hashMap2);
                return;
            }
            a(this.qhP, "openEnterpriseContact:ok", null);
        } else if (i == 53) {
            if (i2 != -1) {
                a(this.qhP, "selectEnterpriseContact:ok", null);
                return;
            }
            bundleExtra = intent.getBundleExtra("result_data");
            if (bundleExtra != null) {
                str = bundleExtra.getString("result");
                hashMap2 = new HashMap();
                hashMap2.put("result", str);
                a(this.qhP, "selectEnterpriseContact:ok", hashMap2);
                return;
            }
            a(this.qhP, "selectEnterpriseContact:ok", null);
        } else if (i == 29) {
            aG = "MicroMsg.MsgHandler";
            aG2 = "consumedShareCard:ok(r : %b)";
            Object[] objArr = new Object[1];
            objArr[0] = Boolean.valueOf(i2 == -1);
            x.d(aG, aG2, objArr);
            if (i2 == -1) {
                a(this.qhP, "consumedShareCard:ok", null);
            } else {
                a(this.qhP, "consumedShareCard:fail", null);
            }
        } else if (i == 113) {
            if (i2 == -1) {
                R(this.qhP);
            } else {
                a(this.qhP, "chooseImage:fail_android_permission_denied", null);
            }
        } else if (i == 116) {
            if (i2 == -1) {
                Y(this.qhP);
            } else {
                a(this.qhP, "startRecord:fail_android_permission_denied", null);
            }
        } else if (i == 115) {
            if (i2 == -1) {
                a(this.qhP, 0);
            } else {
                a(this.qhP, "chooseVideo:fail_android_permission_denied", null);
            }
        } else if (i == 117) {
            if (i2 == -1) {
                a(this.qhP, 1);
            } else {
                a(this.qhP, "recordVideo:fail_android_permission_denied", null);
            }
        } else if (i == 118) {
            if (i2 == -1) {
                a(this.qhP, 1);
            } else {
                a(this.qhP, "recordVideo:fail_android_permission_denied", null);
            }
        } else if (i == 119) {
            if (i2 == -1) {
                V(this.qhP);
                return;
            }
            x.e("MicroMsg.MsgHandler", "chooseMedia:fail_android_permission_denied:CAMERA");
            a(this.qhP, "chooseMedia:fail_android_permission_denied", null);
        } else if (i == 120) {
            if (i2 == -1) {
                V(this.qhP);
                return;
            }
            x.e("MicroMsg.MsgHandler", "chooseMedia:fail_android_permission_denied:MICROPHONE");
            a(this.qhP, "chooseMedia:fail_android_permission_denied", null);
        } else if (i == 30) {
            x.i("MicroMsg.MsgHandler", "doSelectSingleContact activtiy callback");
            str = (String) this.qhP.mcy.get("appId");
            if (this.qhS == null || !TextUtils.isEmpty(str)) {
                aG = str;
            } else {
                aG = this.qhS.getString("jsapi_args_appid");
            }
            int i7 = bi.getInt((String) this.qhP.mcy.get("selectMode"), 0);
            x.i("MicroMsg.MsgHandler", "select single contact : appId:%s, busiId:%s, selectedMode:%d", new Object[]{aG, (String) this.qhP.mcy.get("busiId"), Integer.valueOf(i7)});
            switch (i2) {
                case -1:
                    if (intent == null) {
                        aG2 = null;
                    } else {
                        aG2 = intent.getStringExtra("Select_Conv_User");
                    }
                    if (aG2 == null || aG2.length() == 0) {
                        x.e("MicroMsg.MsgHandler", "mmOnActivityResult,selectSingleContact fail, user is null");
                        a(this.qhP, "selectSingleContact:fail", null);
                        return;
                    } else if (i7 == 0) {
                        com.tencent.mm.plugin.webview.model.l lVar = new com.tencent.mm.plugin.webview.model.l(aG, aG2);
                        au.DF().a(1566, new 11(this));
                        au.DF().d(lVar);
                        Context context2 = this.context;
                        this.context.getString(R.l.app_tip);
                        this.eHw = com.tencent.mm.ui.base.h.a(context2, this.context.getString(R.l.app_waiting), true, new 12(this, lVar));
                        return;
                    } else if (i7 == 1) {
                        com.tencent.mm.plugin.webview.model.r rVar = new com.tencent.mm.plugin.webview.model.r(aG, str, aG2);
                        au.DF().a(1177, new 14(this));
                        au.DF().d(rVar);
                        context = this.context;
                        this.context.getString(R.l.app_tip);
                        this.eHw = com.tencent.mm.ui.base.h.a(context, this.context.getString(R.l.app_waiting), true, new 15(this, rVar));
                        return;
                    } else {
                        return;
                    }
                case 0:
                    a(this.qhP, "selectSingleContact:cancel", null);
                    return;
                default:
                    return;
            }
        } else if (i == 34) {
            if (i2 == -1) {
                a(this.qhP, "get_wcpay_realname_verify:ok", null);
                com.tencent.mm.plugin.report.service.h.mEJ.h(14954, new Object[]{com.tencent.mm.pluginsdk.wallet.f.cfF(), "get_wcpay_realname_verify:ok"});
            } else if (i2 == 1) {
                a(this.qhP, "get_wcpay_realname_verify:fail", null);
                if (!com.tencent.mm.pluginsdk.wallet.f.cfE()) {
                    com.tencent.mm.plugin.report.service.h.mEJ.h(14954, new Object[]{com.tencent.mm.pluginsdk.wallet.f.cfF(), "get_wcpay_realname_verify:fail"});
                }
            } else {
                a(this.qhP, "get_wcpay_realname_verify:cancel", null);
                com.tencent.mm.plugin.report.service.h.mEJ.h(14954, new Object[]{com.tencent.mm.pluginsdk.wallet.f.cfF(), "get_wcpay_realname_verify:cancel"});
            }
            if (!com.tencent.mm.pluginsdk.wallet.f.cfE()) {
                com.tencent.mm.pluginsdk.wallet.f.cfG();
            }
        } else if (i == 35) {
            if (i2 == -1) {
                nn nnVar = new nn();
                nnVar.bYA.context = this.context;
                com.tencent.mm.sdk.b.a.sFg.m(nnVar);
                try {
                    this.pRY.bVn();
                    this.pRY.P(null);
                    return;
                } catch (Throwable e52) {
                    x.printErrStackTrace("MicroMsg.MsgHandler", e52, "", new Object[0]);
                    return;
                }
            }
            a(this.qhP, "selectWalletCurrency:cancel", null);
        } else if (i == 37) {
            if (this.bSg == null) {
                x.e("MicroMsg.MsgHandler", "mmOnActivityResult fail, appmsg is null");
                a(this.qhP, "send_app_msg:fail", null);
                return;
            }
            str = (String) this.qhP.mcy.get("appid");
            snsAdClick = null;
            if (this.qhS != null) {
                snsAdClick = (SnsAdClick) this.qhS.getParcelable("KSnsAdTag");
                if (TextUtils.isEmpty(str)) {
                    aG2 = this.qhS.getString("jsapi_args_appid");
                    obj = this.qhP.bYt().get("Internal@AsyncReport");
                    switch (i2) {
                        case -1:
                            if (snsAdClick != null) {
                                snsAdClick.in(7);
                            }
                            f Jn3 = com.tencent.mm.pluginsdk.model.app.g.Jn(aG2);
                            if (intent != null) {
                                str2 = intent.getStringExtra("enterprise_biz_name");
                                long longExtra = intent.getLongExtra("key_biz_chat_id", -1);
                                aG3 = intent.getStringExtra("enterprise_share_append_text");
                                if (str2 == null || str2.length() == 0) {
                                    x.e("MicroMsg.MsgHandler", "mmOnActivityResult fail, toUser is null");
                                    a(this.qhP, "send_app_msg:fail", null);
                                    return;
                                }
                                str3 = (String) this.qhP.mcy.get("img_url");
                                this.qhP.mcy.get("desc");
                                str4 = (String) this.qhP.mcy.get("src_username");
                                str5 = (String) this.qhP.mcy.get("src_displayname");
                                bYc = bYc();
                                l.a(this.qhP.bYt(), RM("sendAppMessage"), str2, aG2);
                                if (obj != null && (obj instanceof Boolean) && ((Boolean) obj).booleanValue()) {
                                    b(this.qhP, true);
                                }
                                if (bi.oW(str3)) {
                                    if (longExtra >= 0) {
                                        com.tencent.mm.ac.a.c ak = z.Na().ak(longExtra);
                                        synchronized (com.tencent.mm.ac.a.e.dNr) {
                                            String Ir = com.tencent.mm.ac.a.e.Ir();
                                            com.tencent.mm.ac.a.e.d(ak);
                                            a(Jn3, aG2, str2, str3, str4, str5, aG3, bYc);
                                            com.tencent.mm.ac.a.e.lh(Ir);
                                        }
                                    } else {
                                        a(Jn3, aG2, str2, str3, str4, str5, aG3, bYc);
                                    }
                                    com.tencent.mm.ui.base.h.bx(this.context, this.context.getString(R.l.confirm_dialog_sent));
                                    a(this.qhP, "send_app_msg:ok", null);
                                    return;
                                }
                                o.Pe().a(str3, new 16(this, longExtra, Jn3, aG2, str2, str3, str4, str5, aG3, bYc));
                                return;
                            }
                            return;
                        case 0:
                            if (snsAdClick != null) {
                                snsAdClick.in(8);
                            }
                            l.a(this.qhP.bYt(), RM("sendAppMessage"), null, aG2);
                            if (obj != null && (obj instanceof Boolean) && ((Boolean) obj).booleanValue()) {
                                b(this.qhP, true);
                            }
                            a(this.qhP, "send_app_msg:cancel", null);
                            return;
                        default:
                            return;
                    }
                }
            }
            aG2 = str;
            obj = this.qhP.bYt().get("Internal@AsyncReport");
            switch (i2) {
                case -1:
                    if (snsAdClick != null) {
                        snsAdClick.in(7);
                    }
                    f Jn32 = com.tencent.mm.pluginsdk.model.app.g.Jn(aG2);
                    if (intent != null) {
                        str2 = intent.getStringExtra("enterprise_biz_name");
                        long longExtra2 = intent.getLongExtra("key_biz_chat_id", -1);
                        aG3 = intent.getStringExtra("enterprise_share_append_text");
                        if (str2 == null || str2.length() == 0) {
                            x.e("MicroMsg.MsgHandler", "mmOnActivityResult fail, toUser is null");
                            a(this.qhP, "send_app_msg:fail", null);
                            return;
                        }
                        str3 = (String) this.qhP.mcy.get("img_url");
                        this.qhP.mcy.get("desc");
                        str4 = (String) this.qhP.mcy.get("src_username");
                        str5 = (String) this.qhP.mcy.get("src_displayname");
                        bYc = bYc();
                        l.a(this.qhP.bYt(), RM("sendAppMessage"), str2, aG2);
                        if (obj != null && (obj instanceof Boolean) && ((Boolean) obj).booleanValue()) {
                            b(this.qhP, true);
                        }
                        if (bi.oW(str3)) {
                            if (longExtra2 >= 0) {
                                com.tencent.mm.ac.a.c ak2 = z.Na().ak(longExtra2);
                                synchronized (com.tencent.mm.ac.a.e.dNr) {
                                    String Ir2 = com.tencent.mm.ac.a.e.Ir();
                                    com.tencent.mm.ac.a.e.d(ak2);
                                    a(Jn32, aG2, str2, str3, str4, str5, aG3, bYc);
                                    com.tencent.mm.ac.a.e.lh(Ir2);
                                }
                            } else {
                                a(Jn32, aG2, str2, str3, str4, str5, aG3, bYc);
                            }
                            com.tencent.mm.ui.base.h.bx(this.context, this.context.getString(R.l.confirm_dialog_sent));
                            a(this.qhP, "send_app_msg:ok", null);
                            return;
                        }
                        o.Pe().a(str3, new 16(this, longExtra2, Jn32, aG2, str2, str3, str4, str5, aG3, bYc));
                        return;
                    }
                    return;
                case 0:
                    if (snsAdClick != null) {
                        snsAdClick.in(8);
                    }
                    l.a(this.qhP.bYt(), RM("sendAppMessage"), null, aG2);
                    if (obj != null && (obj instanceof Boolean) && ((Boolean) obj).booleanValue()) {
                        b(this.qhP, true);
                    }
                    a(this.qhP, "send_app_msg:cancel", null);
                    return;
                default:
                    return;
            }
        } else if (i == 38) {
            if (i2 == -1) {
                x.i("MicroMsg.MsgHandler", "hy: soter auth ok");
                a(this.qhP, "soter_biometric_authentication:ok", i.ac(intent.getExtras()));
            } else if (i2 == 1) {
                x.w("MicroMsg.MsgHandler", "hy: soter auth failed");
                a(this.qhP, "soter_biometric_authentication:fail", i.ac(intent.getExtras()));
            } else {
                x.e("MicroMsg.MsgHandler", "hy: soter user cancelled");
                a(this.qhP, "soter_biometric_authentication:cancel", i.ac(intent.getExtras()));
            }
        } else if (i == 39) {
            if (i2 == -1) {
                a(this.qhP, "unbind_bank_card:ok", null);
            } else if (i2 == 1) {
                a(this.qhP, "unbind_bank_card:fail", null);
            } else {
                a(this.qhP, "unbind_bank_card:cancel", null);
            }
            if (!com.tencent.mm.pluginsdk.wallet.f.cfE()) {
            }
        } else if (i == 40) {
            if (i2 == -1) {
                bundle = new Bundle();
                if (intent != null) {
                    ArrayList d = com.tencent.mm.az.a.d(intent.getLongArrayExtra("k_outside_expose_proof_item_list"));
                    int size = d.size();
                    String[] strArr = new String[size];
                    String[] strArr2 = new String[size];
                    String[] strArr3 = new String[size];
                    int[] iArr = new int[size];
                    int[] iArr2 = new int[size];
                    for (i3 = 0; i3 < size; i3++) {
                        bd bdVar = (bd) d.get(i3);
                        strArr[i3] = String.valueOf(bdVar.wW());
                        if (intent.getBooleanExtra("k_is_group_chat", false)) {
                            strArr2[i3] = com.tencent.mm.model.bd.iC(bdVar.getContent());
                            strArr3[i3] = com.tencent.mm.model.bd.iB(bdVar.getContent());
                        } else {
                            strArr2[i3] = bdVar.getContent();
                            strArr3[i3] = bdVar.wZ();
                        }
                        if (bdVar.wX() == 1) {
                            strArr3[i3] = q.GF();
                        }
                        if (strArr2[i3] == null) {
                            strArr2[i3] = "";
                        }
                        if (strArr3[i3] == null) {
                            strArr3[i3] = "";
                        }
                        if (bdVar.aQm()) {
                            iArr[i3] = 49;
                        } else {
                            iArr[i3] = bdVar.getType();
                        }
                        iArr2[i3] = (int) (bdVar.wY() / 1000);
                    }
                    bundle.putStringArray("msgIds", strArr);
                    bundle.putStringArray("contents", strArr2);
                    bundle.putStringArray("senders", strArr3);
                    bundle.putIntArray("msgTypes", iArr);
                    bundle.putIntArray("msgTimes", iArr2);
                    try {
                        if (this.pRY != null) {
                            this.pRY.c(48, bundle);
                        }
                        a(this.qhP, "select chat record:ok", null);
                        return;
                    } catch (RemoteException e42) {
                        x.w("MicroMsg.MsgHandler", "onGetMsgProofItems exception" + e42.getMessage());
                        a(this.qhP, "select chat record:fail", null);
                        return;
                    }
                }
                a(this.qhP, "select chat record:fail", null);
                return;
            }
            a(this.qhP, "select chat record:cancel", null);
        } else if (i == 41) {
            if (i2 == -1) {
                a(this.qhP, "id_card_realname_verify:ok", null);
                com.tencent.mm.plugin.report.service.h.mEJ.h(14954, new Object[]{com.tencent.mm.pluginsdk.wallet.f.cfF(), "id_card_realname_verify:ok"});
            } else if (i2 == 1) {
                a(this.qhP, "id_card_realname_verify:fail", null);
                if (!com.tencent.mm.pluginsdk.wallet.f.cfE()) {
                    com.tencent.mm.plugin.report.service.h.mEJ.h(14954, new Object[]{com.tencent.mm.pluginsdk.wallet.f.cfF(), "id_card_realname_verify:fail"});
                }
            } else {
                a(this.qhP, "id_card_realname_verify:cancel", null);
                com.tencent.mm.plugin.report.service.h.mEJ.h(14954, new Object[]{com.tencent.mm.pluginsdk.wallet.f.cfF(), "id_card_realname_verify:cancel"});
            }
            if (!com.tencent.mm.pluginsdk.wallet.f.cfE()) {
                com.tencent.mm.pluginsdk.wallet.f.cfG();
            }
        } else if (i == 42) {
            if (i2 == -1) {
                if (intent != null) {
                    str = bi.aG(intent.getStringExtra("gameRegionName"), "");
                    hashMap2 = new HashMap();
                    hashMap2.put("gameRegionName", str);
                    a(this.qhP, "get game region:ok", hashMap2);
                    return;
                }
                a(this.qhP, "get game region:fail", null);
            } else if (i2 == 1) {
                a(this.qhP, "get game region:fail", null);
            } else {
                a(this.qhP, "get game region:cancel", null);
            }
        } else if (i == 43) {
            x.i("MicroMsg.MsgHandler", "request to open file chooser for id card image, result code = " + i2);
            switch (i2) {
                case -1:
                    hashMap = new HashMap();
                    aG = intent.getStringExtra("key_pick_local_pic_callback_local_ids");
                    x.i("MicroMsg.MsgHandler", "localIds = %s", new Object[]{aG});
                    if (bi.oW(aG)) {
                        a(this.qhP, "chooseIdCard:fail", null);
                        return;
                    }
                    try {
                        JSONArray jSONArray = new JSONArray(aG);
                        if (jSONArray.length() > 0) {
                            hashMap.put("localId", jSONArray.get(0).toString());
                            if (intent.getStringExtra("key_pick_local_pic_source_type") != null) {
                                hashMap.put("sourceType", "album");
                            }
                            a(this.qhP, "chooseIdCard:ok", hashMap);
                            return;
                        }
                        a(this.qhP, "chooseImage:fail", null);
                        return;
                    } catch (Throwable e522) {
                        x.printErrStackTrace("MicroMsg.MsgHandler", e522, "", new Object[0]);
                        a(this.qhP, "chooseImage:fail", null);
                        return;
                    }
                case 0:
                    a(this.qhP, "chooseIdCard:cancel", null);
                    return;
                default:
                    a(this.qhP, "chooseImage:fail", null);
                    return;
            }
        } else if (i == 48) {
            x.i("MicroMsg.MsgHandler", "alvinluo: requestWxFacePictureVerify resultCode: %d", new Object[]{Integer.valueOf(i2)});
            if (i2 == -1) {
                a(this.qhP, "requestWxFacePictureVerify:ok", i.ac(intent != null ? intent.getExtras() : null));
            } else if (i2 == 1) {
                a(this.qhP, "requestWxFacePictureVerify:fail", i.ac(intent != null ? intent.getExtras() : null));
            } else if (i2 == 0) {
                a(this.qhP, "requestWxFacePictureVerify:cancel", i.ac(intent != null ? intent.getExtras() : null));
            }
        } else if (i == 49) {
            x.i("MicroMsg.MsgHandler", "hy: REQUEST_FACE_DETECT_WITH_VIDEO resultCode: %d", new Object[]{Integer.valueOf(i2)});
            if (i2 == -1) {
                a(this.qhP, "requestWxFacePictureVerifyUnionVideo:ok", i.ac(intent != null ? intent.getExtras() : null));
            } else if (i2 == 1) {
                a(this.qhP, "requestWxFacePictureVerifyUnionVideo:fail", i.ac(intent != null ? intent.getExtras() : null));
            } else if (i2 == 0) {
                a(this.qhP, "requestWxFacePictureVerifyUnionVideo:cancel", i.ac(intent != null ? intent.getExtras() : null));
            }
        } else if (i == 52) {
            x.i("MicroMsg.MsgHandler", "share emmotion resultCode: %d", new Object[]{Integer.valueOf(i2)});
            switch (i2) {
                case -1:
                    EmojiInfo n;
                    aG2 = bi.aG(intent.getStringExtra("Select_Conv_User"), "");
                    aG = bi.aG(intent.getStringExtra("emoji_thumb_path"), "");
                    str2 = bi.aG(intent.getStringExtra("emoji_activity_id"), "");
                    EmojiInfo Zy = com.tencent.mm.plugin.emoji.model.i.aEA().asE().Zy(aG);
                    if (Zy == null) {
                        au.HU();
                        str3 = EmojiLogic.L(com.tencent.mm.model.c.Gg(), "", aG);
                        if (com.tencent.mm.a.e.cn(str3)) {
                            i4 = com.tencent.mm.sdk.platformtools.o.Wf(str3) ? EmojiInfo.tcJ : EmojiInfo.tcI;
                            EmojiInfo emojiInfo = new EmojiInfo();
                            emojiInfo.po(aG);
                            emojiInfo.Ds(EmojiInfo.tcB);
                            emojiInfo.setType(i4);
                            emojiInfo.setSize(com.tencent.mm.a.e.cm(str3));
                            emojiInfo.cnD();
                            if (!bi.oW(str2)) {
                                emojiInfo.field_activityid = str2;
                            }
                            n = com.tencent.mm.plugin.emoji.model.i.aEA().asE().n(emojiInfo);
                            for (String str6 : bi.F(bi.aG(aG2, "").split(","))) {
                                if (n != null) {
                                    com.tencent.mm.plugin.emoji.model.i.aEw().a(str6, n, null);
                                }
                            }
                            a(this.qhP, "shareEmoticon:ok", null);
                            return;
                        }
                    }
                    n = Zy;
                    for (String str62 : bi.F(bi.aG(aG2, "").split(","))) {
                        if (n != null) {
                            com.tencent.mm.plugin.emoji.model.i.aEw().a(str62, n, null);
                        }
                    }
                    a(this.qhP, "shareEmoticon:ok", null);
                    return;
                case 0:
                    a(this.qhP, "shareEmoticon:cancel", null);
                    return;
                default:
                    a(this.qhP, "shareEmoticon:fail", null);
                    return;
            }
        } else if (i == 50) {
            x.i("MicroMsg.MsgHandler", "hy: requestWxFaceRegisterInternal resultCode: %d", new Object[]{Integer.valueOf(i2)});
            if (i2 == -1) {
                a(this.qhP, "requestWxFaceRegisterInternal:ok", i.ac(intent != null ? intent.getExtras() : null));
            } else if (i2 == 1) {
                a(this.qhP, "requestWxFaceRegisterInternal:fail", i.ac(intent != null ? intent.getExtras() : null));
            } else if (i2 == 0) {
                a(this.qhP, "requestWxFaceRegisterInternal:cancel", i.ac(intent != null ? intent.getExtras() : null));
            }
        } else if (i == 51) {
            x.i("MicroMsg.MsgHandler", "hy: requestWxFaceVerifyInternal resultCode: %d", new Object[]{Integer.valueOf(i2)});
            if (i2 == -1) {
                a(this.qhP, "requestWxFaceVerifyInternal:ok", i.ac(intent != null ? intent.getExtras() : null));
            } else if (i2 == 1) {
                a(this.qhP, "requestWxFaceVerifyInternal:fail", i.ac(intent != null ? intent.getExtras() : null));
            } else if (i2 == 0) {
                a(this.qhP, "requestWxFaceVerifyInternal:cancel", i.ac(intent != null ? intent.getExtras() : null));
            }
        } else if (i == 54) {
            if (i2 != -1 || intent == null) {
                a(this.qhP, "selectContact:fail", null);
                return;
            }
            str62 = intent.getStringExtra("Select_Contact");
            aG = com.tencent.mm.model.r.gT(str62);
            bundle = new Bundle();
            bundle.putString("username", str62);
            bundle.putString("nickname", aG);
            bundle.putInt("ret", 0);
            try {
                if (this.pRY != null) {
                    this.pRY.c(128, bundle);
                }
            } catch (RemoteException e422) {
                x.w("MicroMsg.MsgHandler", "onSearchDataReady exception" + e422.getMessage());
            }
            a(this.qhP, "selectContact:succ", null);
        } else if (i == 55) {
            x.i("MicroMsg.MsgHandler", "hy: REQUEST_SET_RESET_WALLET_PWD_REQUEST resultCode: %d", new Object[]{Integer.valueOf(i2)});
            if (i2 == -1) {
                a(this.qhP, "setWCPayPassword:ok", i.ac(intent != null ? intent.getExtras() : null));
                com.tencent.mm.plugin.report.service.h.mEJ.h(14954, new Object[]{com.tencent.mm.pluginsdk.wallet.f.cfF(), "setWCPayPassword:ok"});
            } else if (i2 == 0) {
                a(this.qhP, "setWCPayPassword:cancel", i.ac(intent != null ? intent.getExtras() : null));
                com.tencent.mm.plugin.report.service.h.mEJ.h(14954, new Object[]{com.tencent.mm.pluginsdk.wallet.f.cfF(), "setWCPayPassword:cancel"});
            } else {
                a(this.qhP, "setWCPayPassword:fail", i.ac(intent != null ? intent.getExtras() : null));
                if (!com.tencent.mm.pluginsdk.wallet.f.cfE()) {
                    com.tencent.mm.plugin.report.service.h.mEJ.h(14954, new Object[]{com.tencent.mm.pluginsdk.wallet.f.cfF(), "setWCPayPassword:fail"});
                }
            }
            if (!com.tencent.mm.pluginsdk.wallet.f.cfE()) {
                com.tencent.mm.pluginsdk.wallet.f.cfG();
            }
            x.d("MicroMsg.MsgHandler", "WalletJsApiReqKey: " + com.tencent.mm.pluginsdk.wallet.f.cfF());
        } else if (i == 56) {
            x.i("MicroMsg.MsgHandler", "request choose invoice title, resultCode = " + i2);
            hashMap = new HashMap();
            if (i2 == -1) {
                if (intent != null) {
                    hashMap.put("choose_invoice_title_info", bi.aG(intent.getStringExtra("choose_invoice_title_info"), ""));
                }
                a(this.qhP, "chooseInvoiceTitle:ok", hashMap);
            } else if (i2 == 0) {
                a(this.qhP, "chooseInvoiceTitle:cancel", hashMap);
            } else {
                a(this.qhP, "chooseInvoiceTitle:fail", hashMap);
            }
        } else if (i == 57) {
            x.i("MicroMsg.MsgHandler", "request voice login verify, resultCode: %d", new Object[]{Integer.valueOf(i2)});
            hashMap2 = new HashMap();
            if (i2 == -1) {
                hashMap2.put("err_code", Integer.valueOf(0));
                hashMap2.put("err_msg", "verify ok");
                if (this.context instanceof MMActivity) {
                    ((MMActivity) this.context).getIntent().putExtra("VoiceLoginAuthPwd", intent.getStringExtra("VoiceLoginAuthPwd"));
                }
                a(this.qhP, "request voice login verify:ok", hashMap2);
            } else if (i2 == 0) {
                hashMap2.put("err_code", Integer.valueOf(1));
                hashMap2.put("err_msg", "verify cancel");
                a(this.qhP, "request voice login verify:cancel", hashMap2);
            } else {
                hashMap2.put("err_code", Integer.valueOf(2));
                hashMap2.put("err_msg", "verify error");
                a(this.qhP, "request voice login verify:error", hashMap2);
            }
        } else if (i == 59) {
            x.i("MicroMsg.MsgHandler", "hy: REQUEST_OPEN_CARD_LIST resultCode: %d", new Object[]{Integer.valueOf(i2)});
            if (i2 == -1) {
                a(this.qhP, "openWCPayCardList:ok", i.ac(intent != null ? intent.getExtras() : null));
                com.tencent.mm.plugin.report.service.h.mEJ.h(14954, new Object[]{com.tencent.mm.pluginsdk.wallet.f.cfF(), "openWCPayCardList:ok"});
            } else if (i2 == 0) {
                a(this.qhP, "openWCPayCardList:fail", i.ac(intent != null ? intent.getExtras() : null));
                if (!com.tencent.mm.pluginsdk.wallet.f.cfE()) {
                    com.tencent.mm.plugin.report.service.h.mEJ.h(14954, new Object[]{com.tencent.mm.pluginsdk.wallet.f.cfF(), "openWCPayCardList:fail"});
                }
            } else {
                a(this.qhP, "openWCPayCardList:fail", i.ac(intent != null ? intent.getExtras() : null));
                if (!com.tencent.mm.pluginsdk.wallet.f.cfE()) {
                    com.tencent.mm.plugin.report.service.h.mEJ.h(14954, new Object[]{com.tencent.mm.pluginsdk.wallet.f.cfF(), "openWCPayCardList:fail"});
                }
            }
            if (!com.tencent.mm.pluginsdk.wallet.f.cfE()) {
                com.tencent.mm.pluginsdk.wallet.f.cfG();
            }
        } else if (i == 60) {
            if (intent != null) {
                str62 = intent.getStringExtra("key_callback");
                x.i("MicroMsg.MsgHandler", "open offline pay view callback: %s", new Object[]{str62});
                a(this.qhP, String.format("openOfflinePayView:%s", new Object[]{str62}), null);
                com.tencent.mm.plugin.report.service.h.mEJ.h(14954, new Object[]{com.tencent.mm.pluginsdk.wallet.f.cfF(), "openOfflinePayView:ok"});
            } else {
                a(this.qhP, "openOfflinePayView:fail", null);
                if (!com.tencent.mm.pluginsdk.wallet.f.cfE()) {
                    com.tencent.mm.plugin.report.service.h.mEJ.h(14954, new Object[]{com.tencent.mm.pluginsdk.wallet.f.cfF(), "openOfflinePayView:fail"});
                }
            }
            if (!com.tencent.mm.pluginsdk.wallet.f.cfE()) {
                com.tencent.mm.pluginsdk.wallet.f.cfG();
            }
        } else if (i == 58) {
            x.i("MicroMsg.MsgHandler", "request bind email, resultCode %d", new Object[]{Integer.valueOf(i2)});
            if (i2 == -1) {
                a(this.qhP, "bindEmail:ok", null);
            } else {
                a(this.qhP, "bindEmail:cancel", null);
            }
        } else if (i == 62) {
            x.i("MicroMsg.MsgHandler", "[openRealnameAuth]resultCode:%d", new Object[]{Integer.valueOf(i2)});
            hashMap = new HashMap();
            if (i2 == -1) {
                x.i("MicroMsg.MsgHandler", "openRealnameAuth ok");
                aG = intent.getStringExtra("intent_auth_token");
                if (bi.oW(aG)) {
                    a(this.qhP, "openRealnameAuth:fail", hashMap);
                    return;
                }
                hashMap.put("err_code", Integer.valueOf(0));
                hashMap.put("auth_token", aG);
                x.d("MicroMsg.MsgHandler", "authToken:%s", new Object[]{aG});
                a(this.qhP, "openRealnameAuth:ok", hashMap);
            } else if (i2 == 0) {
                x.i("MicroMsg.MsgHandler", "openRealnameAuth cancel");
                a(this.qhP, "openRealnameAuth:cancel", hashMap);
            } else if (i2 == 1) {
                x.i("MicroMsg.MsgHandler", "openRealnameAuth fail");
                if (intent != null) {
                    i3 = intent.getIntExtra("intent_err_code", -1);
                    aG2 = intent.getStringExtra("intent_err_msg");
                    hashMap.put("err_code", Integer.valueOf(i3));
                    hashMap.put("err_msg", aG2);
                    a(this.qhP, "openRealnameAuth:fail", hashMap);
                    x.i("MicroMsg.MsgHandler", "openRealnameAuth errCode:%d, errMsg:%s", new Object[]{Integer.valueOf(i3), aG2});
                    return;
                }
                a(this.qhP, "openRealnameAuth:fail", hashMap);
            }
        } else if (i == 61) {
            if (this.bSg == null) {
                x.e("MicroMsg.MsgHandler", "mmOnActivityResult fail, appmsg is null");
                a(this.qhP, "sendSingleAppMessage:fail", null);
                return;
            }
            switch (i2) {
                case -1:
                    if (intent == null) {
                        aG2 = null;
                    } else {
                        aG2 = intent.getStringExtra("Select_Conv_User");
                    }
                    if (aG2 == null || aG2.length() == 0) {
                        x.e("MicroMsg.MsgHandler", "mmOnActivityResult fail, toUser is null");
                        a(this.qhP, "sendSingleAppMessage:fail", null);
                        return;
                    }
                    obj = this.qhP.mcy.get("__jsapi_fw_ext_info");
                    if (obj instanceof Bundle) {
                        str62 = ((Bundle) obj).getString("__jsapi_fw_ext_info_key_current_url");
                    } else {
                        str62 = null;
                    }
                    str62 = this.qic.RE(str62);
                    if (bi.oW(str62)) {
                        str62 = (String) this.qhP.mcy.get("appId");
                    }
                    com.tencent.mm.plugin.webview.model.r rVar2 = new com.tencent.mm.plugin.webview.model.r(str62, "", aG2);
                    au.DF().a(1177, new 17(this, intent, aG2));
                    au.DF().d(rVar2);
                    context = this.context;
                    this.context.getString(R.l.app_tip);
                    this.eHw = com.tencent.mm.ui.base.h.a(context, this.context.getString(R.l.app_waiting), true, new 18(this, rVar2));
                    return;
                case 0:
                    a(this.qhP, "sendSingleAppMessage:cancel", null);
                    return;
                default:
                    a(this.qhP, "sendSingleAppMessage:fail", null);
                    return;
            }
        } else if (i != 75) {
        } else {
            if (i2 == -1) {
                bYe();
            } else {
                a(this.qhP, "geo_location:fail", null);
            }
        }
    }

    private boolean a(f fVar, String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        if (this.bSg == null) {
            x.w("MicroMsg.MsgHandler", "doSendAppMsg: but appmsg is null");
            return false;
        }
        o.Pe();
        Bitmap jz = com.tencent.mm.ak.c.jz(str3);
        if (!(jz == null || jz.isRecycled())) {
            x.i("MicroMsg.MsgHandler", "thumb image is not null");
            OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            jz.compress(CompressFormat.PNG, 100, byteArrayOutputStream);
            this.bSg.thumbData = byteArrayOutputStream.toByteArray();
        }
        ot otVar = new ot();
        otVar.bZE.bSg = this.bSg;
        otVar.bZE.appId = str;
        otVar.bZE.appName = fVar == null ? "" : fVar.field_appName;
        otVar.bZE.toUser = str2;
        otVar.bZE.bZF = 2;
        if (bi.oW(str4)) {
            otVar.bZE.bZI = null;
        } else {
            otVar.bZE.bZG = str4;
            otVar.bZE.bZH = str5;
        }
        try {
            String string = this.qhS.getString("key_snsad_statextstr");
            otVar.bZE.bZN = string;
            otVar.bZE.bZJ = this.pRY.bVl();
            Bundle g = this.pRY.g(18, null);
            if (g != null) {
                ot.a aVar = otVar.bZE;
                String oV = bi.oV(g.getString("KPublisherId"));
                aVar.bZM = oV;
                String ic = u.ic(oV);
                u.b v = u.Hx().v(ic, true);
                v.p("sendAppMsgScene", Integer.valueOf(2));
                v.p("preChatName", g.getString("preChatName"));
                v.p("preMsgIndex", Integer.valueOf(g.getInt("preMsgIndex")));
                v.p("prePublishId", g.getString("prePublishId"));
                v.p("preUsername", g.getString("preUsername"));
                v.p("getA8KeyScene", Integer.valueOf(g.getInt("getA8KeyScene")));
                v.p("referUrl", g.getString("referUrl"));
                if (!bi.oW(string)) {
                    v.p("adExtStr", string);
                }
                otVar.bZE.bJK = ic;
            }
            string = this.pRY.getCurrentUrl();
            otVar.bZE.bZK = string;
            otVar.bZE.bZL = this.qic.RE(string);
        } catch (Exception e) {
            x.e("MicroMsg.MsgHandler", "init bunddata failed : %s", new Object[]{e.getMessage()});
        }
        boolean m = com.tencent.mm.sdk.b.a.sFg.m(otVar);
        if (!bi.oW(str6)) {
            ow owVar = new ow();
            owVar.bZQ.bZR = str2;
            owVar.bZQ.content = str6;
            owVar.bZQ.type = com.tencent.mm.model.s.hQ(str2);
            owVar.bZQ.flags = 0;
            com.tencent.mm.sdk.b.a.sFg.m(owVar);
        }
        if (m) {
            try {
                if (this.pRY != null) {
                    a(str, str3, com.tencent.mm.model.s.fq(str2) ? 2 : 3, this.pRY.g(85, null));
                }
            } catch (RemoteException e2) {
                x.e("MicroMsg.MsgHandler", "invokeAsResult : %s", new Object[]{e2});
            }
        }
        if (bi.oW(str7)) {
            return m;
        }
        com.tencent.mm.plugin.report.service.h.mEJ.h(10424, new Object[]{Integer.valueOf(49), Integer.valueOf(128), str7});
        return m;
    }

    private void a(String str, String str2, int i, Bundle bundle) {
        if (bundle != null) {
            String string = bundle.getString("share_report_pre_msg_url");
            String string2 = bundle.getString("share_report_pre_msg_title");
            String string3 = bundle.getString("share_report_pre_msg_desc");
            String string4 = bundle.getString("share_report_pre_msg_icon_url");
            String string5 = bundle.getString("share_report_pre_msg_appid");
            int i2 = bundle.getInt("share_report_from_scene", 0);
            String string6 = bundle.getString("share_report_biz_username");
            String string7 = bundle.getString("share_report_current_url");
            String string8 = bundle.getString("share_report_current_title");
            String str3 = this.bSg.mediaObject instanceof WXWebpageObject ? ((WXWebpageObject) this.bSg.mediaObject).webpageUrl : "";
            String str4 = this.bSg.title;
            String str5 = this.bSg.description;
            com.tencent.mm.plugin.report.service.h.mEJ.h(14062, new Object[]{string, string2, string3, string4, string5, Integer.valueOf(i2), string6, string7, string8, str, str3, str4, str5, str2, Integer.valueOf(i)});
        }
    }

    private void a(i iVar, String str, Map<String, Object> map) {
        a(iVar, str, (Map) map, true);
    }

    public final void a(i iVar, String str, Map<String, Object> map, boolean z) {
        this.iKs = false;
        try {
            if (this.pRY != null) {
                this.pRY.a(iVar == null ? null : iVar.qkj, str, i.aq(map), z);
            }
        } catch (Exception e) {
            x.w("MicroMsg.MsgHandler", "onHandleEnd, ex = " + e.getMessage());
        }
    }

    public final void a(e eVar, i iVar, String str, Map<String, Object> map, boolean z, boolean z2) {
        if (!z2) {
            this.iKs = false;
        }
        try {
            eVar.a(iVar == null ? null : iVar.qkj, str, i.aq(map), z);
        } catch (Exception e) {
            x.w("MicroMsg.MsgHandler", "onHandleEnd, ex = " + e.getMessage());
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void b(com.tencent.mm.plugin.webview.ui.tools.jsapi.i r14, boolean r15) {
        /*
        r13 = this;
        r6 = 0;
        r1 = 0;
        if (r14 != 0) goto L_0x000e;
    L_0x0004:
        r0 = "MicroMsg.MsgHandler";
        r1 = "msg is null when report.";
        com.tencent.mm.sdk.platformtools.x.e(r0, r1);
    L_0x000d:
        return;
    L_0x000e:
        r9 = r14.qkl;
        r12 = r14.qkk;
        r0 = "isSuccess";
        r2 = java.lang.Boolean.valueOf(r15);
        r12.put(r0, r2);
        r4 = r13.pRY;
        r0 = com.tencent.mm.sdk.platformtools.bi.oW(r9);
        if (r0 == 0) goto L_0x00b2;
    L_0x0024:
        r0 = "MicroMsg.WebViewSecurityUtil";
        r2 = "function name is null or nil.";
        com.tencent.mm.sdk.platformtools.x.e(r0, r2);
    L_0x002d:
        r0 = "";
        r2 = r13.qhS;
        if (r2 == 0) goto L_0x003d;
    L_0x0034:
        r0 = r13.qhS;
        r2 = "key_webview_container_env";
        r0 = r0.getString(r2);
    L_0x003d:
        r2 = "miniProgram";
        r0 = r2.equals(r0);
        if (r0 == 0) goto L_0x000d;
    L_0x0046:
        r0 = r13.pRY;
        if (r0 == 0) goto L_0x000d;
    L_0x004a:
        r2 = 145; // 0x91 float:2.03E-43 double:7.16E-322;
        r3 = 0;
        r0 = r0.g(r2, r3);	 Catch:{ Exception -> 0x022d }
        if (r0 == 0) goto L_0x000d;
    L_0x0053:
        r2 = "key_webview_apbrand_jsapi_report_args";
        r2 = r0.getStringArray(r2);
        if (r2 == 0) goto L_0x000d;
    L_0x005c:
        r0 = r2.length;
        r3 = 19;
        if (r0 != r3) goto L_0x000d;
    L_0x0061:
        r0 = 10;
        r2[r0] = r9;
        r3 = 11;
        r0 = -1;
        r4 = r9.hashCode();
        switch(r4) {
            case -1008737020: goto L_0x023a;
            default: goto L_0x006f;
        };
    L_0x006f:
        r1 = r0;
    L_0x0070:
        switch(r1) {
            case 0: goto L_0x0245;
            default: goto L_0x0073;
        };
    L_0x0073:
        r0 = "";
    L_0x0076:
        r2[r3] = r0;
        r1 = 12;
        r0 = "true";
        r3 = "isSuccess";
        r3 = com.tencent.mm.plugin.webview.ui.tools.jsapi.m.a(r14, r3);
        r0 = r0.equals(r3);
        if (r0 == 0) goto L_0x0254;
    L_0x008a:
        r0 = "1";
    L_0x008d:
        r2[r1] = r0;
        r0 = 13;
        r1 = "permissionValue";
        r1 = com.tencent.mm.plugin.webview.ui.tools.jsapi.m.a(r14, r1);
        r2[r0] = r1;
        r0 = 14;
        r1 = "jsapiErrorCode";
        r1 = com.tencent.mm.plugin.webview.ui.tools.jsapi.m.a(r14, r1);
        r2[r0] = r1;
        r0 = com.tencent.mm.plugin.report.service.h.mEJ;
        r1 = 14993; // 0x3a91 float:2.101E-41 double:7.4075E-320;
        r2 = com.tencent.mm.plugin.webview.ui.tools.jsapi.m.j(r2);
        r0.h(r1, r2);
        goto L_0x000d;
    L_0x00b2:
        if (r4 != 0) goto L_0x01ec;
    L_0x00b4:
        r0 = 1;
    L_0x00b5:
        r3 = "";
        r2 = "";
        r8 = "";
        r5 = "";
        if (r0 == 0) goto L_0x01ef;
    L_0x00c3:
        r3 = "";
    L_0x00c6:
        if (r0 == 0) goto L_0x01f5;
    L_0x00c8:
        r2 = "";
    L_0x00cb:
        if (r0 == 0) goto L_0x01fb;
    L_0x00cd:
        r0 = "";
    L_0x00d0:
        r8 = r0;
        r10 = r2;
        r11 = r3;
    L_0x00d3:
        if (r12 == 0) goto L_0x0259;
    L_0x00d5:
        r0 = "fromMenu";
        r0 = r12.get(r0);
        r0 = (java.lang.Boolean) r0;
        r7 = com.tencent.mm.sdk.platformtools.bi.d(r0);
        r0 = "keyParam";
        r0 = r12.get(r0);
        r0 = (java.lang.String) r0;
        r6 = com.tencent.mm.sdk.platformtools.bi.oV(r0);
        r0 = "appId";
        r0 = r12.get(r0);
        r0 = (java.lang.String) r0;
        r2 = "";
        r5 = com.tencent.mm.sdk.platformtools.bi.aG(r0, r2);
        r0 = "isSuccess";
        r0 = r12.get(r0);
        r0 = (java.lang.Boolean) r0;
        r4 = com.tencent.mm.sdk.platformtools.bi.d(r0);
        r0 = "permissionValue";
        r0 = r12.get(r0);
        r0 = (java.lang.Integer) r0;
        r3 = com.tencent.mm.sdk.platformtools.bi.f(r0);
        r0 = "baseErrorCode";
        r0 = r12.get(r0);
        r0 = (java.lang.Integer) r0;
        r2 = com.tencent.mm.sdk.platformtools.bi.f(r0);
        r0 = "jsapiErrorCode";
        r0 = r12.get(r0);
        r0 = (java.lang.Integer) r0;
        r0 = com.tencent.mm.sdk.platformtools.bi.f(r0);
    L_0x0133:
        r12 = new java.lang.StringBuilder;
        r12.<init>();
        r11 = com.tencent.mm.sdk.platformtools.bi.oV(r11);
        r11 = java.net.URLEncoder.encode(r11);
        r12.append(r11);
        r11 = ",";
        r12.append(r11);
        r10 = com.tencent.mm.sdk.platformtools.bi.oV(r10);
        r10 = java.net.URLEncoder.encode(r10);
        r12.append(r10);
        r10 = ",";
        r12.append(r10);
        if (r8 != 0) goto L_0x015f;
    L_0x015c:
        r8 = "";
    L_0x015f:
        r12.append(r8);
        r8 = ",";
        r12.append(r8);
        if (r9 != 0) goto L_0x0220;
    L_0x016a:
        r8 = "";
    L_0x016d:
        r12.append(r8);
        r8 = ",";
        r12.append(r8);
        if (r7 == 0) goto L_0x0223;
    L_0x0178:
        r7 = "1";
    L_0x017b:
        r12.append(r7);
        r7 = ",";
        r12.append(r7);
        if (r6 != 0) goto L_0x0189;
    L_0x0186:
        r6 = "";
    L_0x0189:
        r12.append(r6);
        r6 = ",";
        r12.append(r6);
        r12.append(r5);
        r5 = ",";
        r12.append(r5);
        if (r4 == 0) goto L_0x0228;
    L_0x019d:
        r5 = "1";
    L_0x01a0:
        r12.append(r5);
        r5 = ",";
        r12.append(r5);
        r12.append(r3);
        if (r4 != 0) goto L_0x01c9;
    L_0x01ae:
        r3 = ",";
        r12.append(r3);
        r12.append(r1);
        r3 = ",";
        r12.append(r3);
        r12.append(r2);
        r2 = ",";
        r12.append(r2);
        r12.append(r0);
    L_0x01c9:
        r0 = r12.toString();
        r2 = "MicroMsg.WebViewSecurityUtil";
        r3 = new java.lang.StringBuilder;
        r4 = "report: ";
        r3.<init>(r4);
        r3 = r3.append(r0);
        r3 = r3.toString();
        com.tencent.mm.sdk.platformtools.x.d(r2, r3);
        r2 = com.tencent.mm.plugin.report.service.h.mEJ;
        r3 = 10417; // 0x28b1 float:1.4597E-41 double:5.1467E-320;
        r2.k(r3, r0);
        goto L_0x002d;
    L_0x01ec:
        r0 = r1;
        goto L_0x00b5;
    L_0x01ef:
        r3 = r4.bVl();	 Catch:{ Exception -> 0x0201 }
        goto L_0x00c6;
    L_0x01f5:
        r2 = r4.getCurrentUrl();	 Catch:{ Exception -> 0x0201 }
        goto L_0x00cb;
    L_0x01fb:
        r0 = r4.bVm();	 Catch:{ Exception -> 0x0201 }
        goto L_0x00d0;
    L_0x0201:
        r0 = move-exception;
        r4 = "MicroMsg.WebViewSecurityUtil";
        r7 = new java.lang.StringBuilder;
        r10 = "report, ex = ";
        r7.<init>(r10);
        r0 = r0.getMessage();
        r0 = r7.append(r0);
        r0 = r0.toString();
        com.tencent.mm.sdk.platformtools.x.w(r4, r0);
        r10 = r2;
        r11 = r3;
        goto L_0x00d3;
    L_0x0220:
        r8 = r9;
        goto L_0x016d;
    L_0x0223:
        r7 = "0";
        goto L_0x017b;
    L_0x0228:
        r5 = "0";
        goto L_0x01a0;
    L_0x022d:
        r0 = move-exception;
        r1 = "kv_14993";
        r0 = java.lang.String.valueOf(r0);
        com.tencent.mm.sdk.platformtools.x.e(r1, r0);
        goto L_0x000d;
    L_0x023a:
        r4 = "getBrandWCPayRequest";
        r4 = r9.equals(r4);
        if (r4 == 0) goto L_0x006f;
    L_0x0243:
        goto L_0x0070;
    L_0x0245:
        r0 = r14.mcy;
        r1 = "package";
        r0 = r0.get(r1);
        r0 = r0.toString();
        goto L_0x0076;
    L_0x0254:
        r0 = "2";
        goto L_0x008d;
    L_0x0259:
        r0 = r1;
        r2 = r1;
        r3 = r1;
        r4 = r1;
        r7 = r1;
        goto L_0x0133;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.webview.ui.tools.jsapi.g.b(com.tencent.mm.plugin.webview.ui.tools.jsapi.i, boolean):void");
    }

    private int aW(i iVar) {
        int hashCode = iVar.hashCode();
        this.qiC.put(Integer.valueOf(hashCode), new c(this, iVar, this.pRY));
        this.iKs = false;
        try {
            this.pRY.bVo();
        } catch (RemoteException e) {
            x.w("MicroMsg.MsgHandler", "blockMsg, dealNext ex = %s", new Object[]{e.getMessage()});
        }
        return hashCode;
    }

    /* renamed from: Bd */
    public final c a(int i) {
        return (c) this.qiC.get(Integer.valueOf(i));
    }

    private void Be(int i) {
        c cVar = (c) this.qiC.remove(Integer.valueOf(i));
        if (cVar != null) {
            cVar.qhP = null;
            cVar.pRY = null;
        }
    }

    private boolean aX(i iVar) {
        this.iKs = false;
        if (p.c(iVar.mcy, "scene", 0) == 21) {
            return com.tencent.mm.plugin.webview.fts.h.bTK().ai(iVar.mcy);
        }
        return com.tencent.mm.plugin.webview.modeltools.e.bUV().ai(iVar.mcy);
    }

    private boolean aY(i iVar) {
        Map hashMap = new HashMap();
        com.tencent.mm.plugin.webview.modeltools.e.bUU();
        com.tencent.mm.plugin.webview.fts.d.c(iVar.mcy, hashMap);
        a(iVar, "getSearchDisplayName:ok", hashMap);
        return true;
    }

    private boolean aZ(i iVar) {
        this.iKs = false;
        bth O = com.tencent.mm.plugin.topstory.a.g.O(iVar.mcy);
        Intent intent = new Intent();
        try {
            intent.putExtra("key_context", O.toByteArray());
        } catch (IOException e) {
        }
        p.c(this.context, ".ui.video.TopStoryVideoStreamUI", intent);
        Map hashMap = new HashMap();
        hashMap.put("ret", Integer.valueOf(0));
        a(iVar, "0", hashMap);
        return false;
    }

    private boolean ba(i iVar) {
        this.iKs = false;
        Map hashMap = new HashMap();
        if (p.c(iVar.mcy, "actionType", 0) == 1) {
            String t = p.t(iVar.mcy, "jumpUrl");
            String t2 = p.t(iVar.mcy, "publishId");
            Intent intent = new Intent();
            intent.putExtra("rawUrl", t);
            intent.putExtra("KPublisherId", t2);
            intent.putExtra("convertActivityFromTranslucent", false);
            com.tencent.mm.plugin.webview.ui.tools.d.a(intent.getExtras(), "webview", ".ui.tools.WebViewUI", this.pRY, new 20(this, intent));
            x.i("MicroMsg.MsgHandler", "doOpenWebSearchOutLinkItemClick actionType %d publishId %s url %s", new Object[]{Integer.valueOf(r1), t2, t});
            hashMap.put("ret", Integer.valueOf(0));
        } else {
            hashMap.put("ret", Integer.valueOf(-1));
        }
        a(iVar, "0", hashMap);
        return true;
    }

    private boolean bb(i iVar) {
        this.iKs = false;
        try {
            if (!(this.pRY == null || iVar.mcy == null || !iVar.mcy.containsKey("view"))) {
                Bundle bundle = new Bundle();
                bundle.putString("fts_key_data", (String) iVar.mcy.get("view"));
                this.pRY.c(138, bundle);
            }
        } catch (Exception e) {
        }
        return false;
    }

    private boolean bc(i iVar) {
        this.iKs = false;
        int WU = bi.WU((String) iVar.mcy.get("x"));
        int WU2 = bi.WU((String) iVar.mcy.get("y"));
        String str = (String) iVar.mcy.get("eventId");
        Bundle bundle = new Bundle();
        bundle.putString("widgetId", (String) iVar.mcy.get("widgetId"));
        bundle.putInt("x", WU);
        bundle.putInt("y", WU2);
        bundle.putString("eventId", str);
        try {
            if (this.pRY != null) {
                this.pRY.c(100002, bundle);
            }
        } catch (RemoteException e) {
            x.w("MicroMsg.MsgHandler", "doTapSearchWAWidgetView exception" + e.getMessage());
        }
        a(iVar, "tapSearchWAWidgetView:ok", null);
        return true;
    }

    private boolean bd(i iVar) {
        this.iKs = false;
        Bundle bundle = new Bundle();
        bundle.putString("widgetId", (String) iVar.mcy.get("widgetId"));
        try {
            if (this.pRY != null) {
                this.pRY.c(100001, bundle);
            }
        } catch (RemoteException e) {
            x.w("MicroMsg.MsgHandler", "doOpenSearchWAWidgetLogView exception" + e.getMessage());
        }
        a(iVar, "openSearchWAWidgetLogView:ok", null);
        return true;
    }

    private boolean be(i iVar) {
        this.iKs = false;
        this.qiD++;
        String str = ((String) iVar.mcy.get("appid")) + "_" + this.qiD;
        JSONObject jSONObject = new JSONObject(iVar.mcy);
        Bundle bundle = new Bundle();
        bundle.putString("fts_key_json_data", jSONObject.toString());
        bundle.putString("fts_key_widget_view_cache_key", str);
        try {
            if (this.pRY != null) {
                this.pRY.c(60, bundle);
            }
        } catch (RemoteException e) {
            x.w("MicroMsg.MsgHandler", "onSearchDataReady exception" + e.getMessage());
        }
        Map hashMap = new HashMap();
        hashMap.put("widgetId", str);
        a(iVar, "insertSearchWAWidgetView:ok", hashMap);
        return true;
    }

    private boolean bf(i iVar) {
        this.iKs = false;
        int i = this.qiE;
        this.qiE = i + 1;
        Bundle aq = i.aq(iVar.mcy);
        if (aq.containsKey("playerId")) {
            i = bi.WU(aq.getString("playerId"));
        } else {
            aq.putString("playerId", String.valueOf(i));
        }
        x.i("MicroMsg.MsgHandler", "inserting video player id %d, params %s", new Object[]{Integer.valueOf(i), iVar.mcy});
        try {
            if (this.pRY != null) {
                this.pRY.c(200000, aq);
            }
        } catch (RemoteException e) {
            x.w("MicroMsg.MsgHandler", "doInsertVideoPlayer exception" + e.getMessage());
        }
        Map hashMap = new HashMap();
        hashMap.put("playerId", Integer.valueOf(i));
        a(iVar, "insertVideoPlayer:ok", hashMap);
        return true;
    }

    private boolean bg(i iVar) {
        this.iKs = false;
        Bundle aq = i.aq(iVar.mcy);
        x.i("MicroMsg.MsgHandler", "update video player  params %s", new Object[]{iVar.mcy});
        try {
            if (this.pRY != null) {
                this.pRY.c(200001, aq);
            }
        } catch (RemoteException e) {
            x.w("MicroMsg.MsgHandler", "doInsertVideoPlayer exception" + e.getMessage());
        }
        a(iVar, "updateVideoPlayer:ok", null);
        return true;
    }

    private boolean bh(i iVar) {
        this.iKs = false;
        Bundle aq = i.aq(iVar.mcy);
        x.i("MicroMsg.MsgHandler", "remove video player   params %s", new Object[]{iVar.mcy});
        try {
            if (this.pRY != null) {
                this.pRY.c(200002, aq);
            }
        } catch (RemoteException e) {
            x.w("MicroMsg.MsgHandler", "doRemoveVideoPlayer exception" + e.getMessage());
        }
        a(iVar, "removeVideoPlayer:ok", null);
        return true;
    }

    private boolean bi(i iVar) {
        this.iKs = false;
        Bundle aq = i.aq(iVar.mcy);
        x.i("MicroMsg.MsgHandler", "operate video player  params %s", new Object[]{iVar.mcy});
        try {
            if (this.pRY != null) {
                this.pRY.c(200003, aq);
            }
        } catch (RemoteException e) {
            x.w("MicroMsg.MsgHandler", "doOperateVideoPlayer exception" + e.getMessage());
        }
        a(iVar, "operateVideoPlayer:ok", null);
        return true;
    }

    private boolean bj(i iVar) {
        this.iKs = false;
        JSONObject jSONObject = new JSONObject(iVar.mcy);
        String str = (String) iVar.mcy.get("widgetId");
        Bundle bundle = new Bundle();
        bundle.putString("fts_key_json_data", jSONObject.toString());
        bundle.putString("fts_key_widget_view_cache_key", str);
        try {
            if (this.pRY != null) {
                this.pRY.c(61, bundle);
            }
        } catch (RemoteException e) {
            x.w("MicroMsg.MsgHandler", "onSearchDataReady exception" + e.getMessage());
        }
        Map hashMap = new HashMap();
        hashMap.put("widgetId", str);
        a(iVar, "removeSearchWAWidgetView:ok", hashMap);
        return true;
    }

    private boolean bk(i iVar) {
        this.iKs = false;
        JSONObject jSONObject = new JSONObject(iVar.mcy);
        String str = (String) iVar.mcy.get("widgetId");
        Bundle bundle = new Bundle();
        bundle.putString("fts_key_json_data", jSONObject.toString());
        bundle.putString("fts_key_widget_view_cache_key", str);
        try {
            if (this.pRY != null) {
                this.pRY.c(62, bundle);
            }
        } catch (RemoteException e) {
            x.w("MicroMsg.MsgHandler", "onSearchDataReady exception" + e.getMessage());
        }
        Map hashMap = new HashMap();
        hashMap.put("widgetId", str);
        a(iVar, "updateSearchWAWidgetView:ok", hashMap);
        return true;
    }

    private boolean bl(i iVar) {
        String str = (String) iVar.mcy.get("miniprogramAppID");
        String str2 = (String) iVar.mcy.get("data");
        if (bi.oW(str)) {
            a(iVar, "sendDataToMiniProgram:fail invalid miniprogramAppID", null);
        } else {
            ((com.tencent.mm.plugin.appbrand.n.a) com.tencent.mm.kernel.g.l(com.tencent.mm.plugin.appbrand.n.a.class)).k(str, str2, this.bWo);
            a(iVar, "sendDataToMiniProgram:ok", null);
        }
        return false;
    }

    private boolean bm(i iVar) {
        this.iKs = false;
        com.tencent.mm.plugin.appbrand.n.a aVar = (com.tencent.mm.plugin.appbrand.n.a) com.tencent.mm.kernel.g.l(com.tencent.mm.plugin.appbrand.n.a.class);
        String.valueOf(iVar.mcy.get("appId"));
        aVar.aaT();
        a(iVar, "preloadMiniProgramEnv:ok", null);
        return true;
    }

    private boolean bn(i iVar) {
        List z;
        this.iKs = false;
        Object obj = iVar.mcy.get("userNames");
        String str = ":ok";
        if (obj instanceof String) {
            try {
                z = z(new JSONArray((String) obj));
            } catch (Exception e) {
                z = null;
                str = ":fail:param type mismatch";
            }
        } else if (obj instanceof JSONArray) {
            z = z((JSONArray) obj);
        } else if (obj instanceof String[]) {
            Object z2 = bi.F((String[]) obj);
        } else {
            z2 = null;
            str = ":fail:empty param";
        }
        if (!bi.cX(z2)) {
            ((com.tencent.mm.plugin.appbrand.n.c) com.tencent.mm.kernel.g.l(com.tencent.mm.plugin.appbrand.n.c.class)).al(z2);
        }
        a(iVar, "preloadMiniProgramContacts" + str, null);
        return true;
    }

    private static List<String> z(JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() <= 0) {
            return new LinkedList();
        }
        LinkedList linkedList = new LinkedList();
        for (int i = 0; i < jSONArray.length(); i++) {
            linkedList.add(jSONArray.optString(i));
        }
        return linkedList;
    }

    private boolean bo(i iVar) {
        this.iKs = false;
        qu quVar = new qu();
        quVar.cbq.context = this.context;
        quVar.cbq.userName = p.t(iVar.mcy, "userName");
        quVar.cbq.appId = p.t(iVar.mcy, "appId");
        quVar.cbq.cbs = p.t(iVar.mcy, "relativeURL");
        quVar.cbq.cbu = p.c(iVar.mcy, "appVersion", 0);
        quVar.cbq.scene = p.c(iVar.mcy, "scene", 1018);
        quVar.cbq.bGG = p.t(iVar.mcy, "sceneNote");
        if (bi.oW(quVar.cbq.bGG)) {
            quVar.cbq.bGG = com.tencent.mm.compatible.util.p.encode(bi.oV(getCurrentUrl()));
        }
        quVar.cbq.cbv = p.t(iVar.mcy, "downloadURL");
        quVar.cbq.cbt = p.c(iVar.mcy, "openType", 0);
        quVar.cbq.cbw = p.t(iVar.mcy, "checkSumMd5");
        quVar.cbq.cby = false;
        quVar.cbq.cbz.dFz = p.t(iVar.mcy, "extJsonInfo");
        com.tencent.mm.sdk.b.a.sFg.m(quVar);
        if (quVar.cbr.cbD) {
            a(iVar, "openWeApp:ok", null);
        } else {
            a(iVar, "openWeApp:fail:" + bi.oV(quVar.cbr.cbE), null);
        }
        return true;
    }

    private boolean bp(i iVar) {
        this.iKs = false;
        x.i("MicroMsg.MsgHandler", "doOpenWeAppPage %s", new Object[]{iVar.mcy});
        String t = p.t(iVar.mcy, "userName");
        String t2 = p.t(iVar.mcy, "relativeURL");
        int c = p.c(iVar.mcy, "appVersion", 0);
        String t3 = p.t(iVar.mcy, "searchId");
        String t4 = p.t(iVar.mcy, "docId");
        int c2 = p.c(iVar.mcy, "position", 1);
        int c3 = p.c(iVar.mcy, "scene", BaseReportManager.MAX_READ_COUNT);
        int c4 = p.c(iVar.mcy, "debugMode", 0);
        if (com.tencent.mm.plugin.webview.modeltools.e.bUV().pLd != null) {
            c4 = 1;
        }
        AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
        if (c3 == CdnLogic.kAppTypeNearEvent) {
            appBrandStatObject.scene = 1006;
        } else if (c3 == 3) {
            appBrandStatObject.scene = 1005;
        } else if (c3 == 16) {
            appBrandStatObject.scene = 1042;
        } else if (c3 == 20) {
            appBrandStatObject.scene = 1053;
        } else {
            appBrandStatObject.scene = BaseReportManager.MAX_READ_COUNT;
        }
        String t5 = p.t(iVar.mcy, "statSessionId");
        String t6 = p.t(iVar.mcy, "statKeywordId");
        appBrandStatObject.bGG = t5 + ":" + t6 + ":" + t3 + ":" + t4 + ":" + c2 + ":" + p.t(iVar.mcy, "subScene");
        ((com.tencent.mm.plugin.appbrand.n.d) com.tencent.mm.kernel.g.l(com.tencent.mm.plugin.appbrand.n.d.class)).a(this.context, t, null, c4, c, t2, appBrandStatObject);
        com.tencent.mm.ab.b.a aVar = new com.tencent.mm.ab.b.a();
        aVar.dIG = new ccy();
        aVar.dIH = new ccz();
        aVar.uri = "/cgi-bin/mmux-bin/weappsearchadclick";
        aVar.dIF = 1873;
        com.tencent.mm.ab.b KT = aVar.KT();
        ccy ccy = (ccy) KT.dID.dIL;
        ccy.syz = p.t(iVar.mcy, "statSessionId");
        ccy.syA = p.t(iVar.mcy, "statKeywordId");
        ccy.rUM = p.t(iVar.mcy, "searchId");
        ccy.shK = p.t(iVar.mcy, "docId");
        ccy.eIy = p.c(iVar.mcy, "position", 1);
        ccy.lPe = p.t(iVar.mcy, "userName");
        ccy.syB = p.c(iVar.mcy, "appVersion", 0);
        ccy.syC = p.t(iVar.mcy, "adBuffer");
        ccy.otY = c3;
        ccy.syD = p.t(iVar.mcy, "clickExtInfo");
        com.tencent.mm.modelsns.d dVar = new com.tencent.mm.modelsns.d();
        dVar.r("20StatSessionId", ccy.syz + ",");
        dVar.r("21KeywordId", ccy.syA + ",");
        dVar.r("22SearchId", ccy.rUM + ",");
        dVar.r("23DocId", ccy.shK + ",");
        dVar.r("24Pos", ccy.eIy + ",");
        dVar.r("25AppUserName", ccy.lPe + ",");
        dVar.r("26AppVersion", ccy.syB + ",");
        dVar.r("27AdBuffer", ccy.syC + ",");
        dVar.r("28AdClickBuffer", ccy.syD + ",");
        dVar.r("29scene", c3 + ",");
        x.i("MicroMsg.MsgHandler", "doClickReportScene oreh" + dVar.wF());
        v.a(KT, new 21(this, dVar));
        a(iVar, "openWeAppPage:ok", null);
        return true;
    }

    private boolean bq(i iVar) {
        int c = p.c(iVar.mcy, "logId", 0);
        x.i("MicroMsg.MsgHandler", "doSearchRailtime oreh id:%d, value:%s, params:%s", new Object[]{Integer.valueOf(c), p.t(iVar.mcy, "logString"), iVar.mcy});
        apz apz = new apz();
        apz.rSt = c;
        apz.rSB = (int) (System.currentTimeMillis() / 1000);
        apz.hbF = 1;
        apz.rSu = new com.tencent.mm.bk.b(r1.getBytes());
        com.tencent.mm.ab.b.a aVar = new com.tencent.mm.ab.b.a();
        aVar.dIG = new bk();
        aVar.dIH = new com.tencent.mm.protocal.c.bl();
        aVar.uri = "/cgi-bin/mmux-bin/adlog";
        aVar.dIF = 1802;
        com.tencent.mm.ab.b KT = aVar.KT();
        bk bkVar = (bk) KT.dID.dIL;
        apy apy = new apy();
        apy.rjL = com.tencent.mm.protocal.d.qVI;
        apy.rjM = com.tencent.mm.protocal.d.qVH;
        apy.rjN = com.tencent.mm.protocal.d.qVK;
        apy.rjO = com.tencent.mm.protocal.d.qVL;
        apy.rjP = w.chP();
        apy.rSA = (int) (System.currentTimeMillis() / 1000);
        bkVar.rbM = apy;
        bkVar.rbN.add(apz);
        v.a(KT, new 22(this));
        a(iVar, "reportWeAppSearchRealtime:ok", null);
        return true;
    }

    private boolean br(i iVar) {
        String str = (String) iVar.mcy.get("name");
        String str2 = (String) iVar.mcy.get("arg");
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("name", str);
            str = "arg";
            if (bi.oW(str2)) {
                str2 = "{}";
            }
            jSONObject.put(str, new JSONObject(str2));
            Bundle bundle = new Bundle();
            bundle.putString("info", jSONObject.toString());
            this.pRY.g(com.tencent.mm.plugin.appbrand.jsapi.x.CTRL_INDEX, bundle);
            a(iVar, "invokeMiniProgramAPI:ok", null);
        } catch (Exception e) {
            x.e("MicroMsg.MsgHandler", "doInvokeMiniProgramApi: %s", new Object[]{e});
            a(iVar, "invokeMiniProgramAPI:fail", null);
        }
        return true;
    }

    public final void a(String str, boolean z, String str2, Bundle bundle) {
        Bundle bundle2 = new Bundle();
        bundle2.putString("fts_key_json_data", str);
        bundle2.putString("fts_key_req_id", str2);
        bundle2.putBoolean("fts_key_new_query", z);
        if (bundle != null) {
            bundle2.putBundle("fts_key_data", bundle);
        }
        try {
            if (this.pRY != null) {
                this.pRY.c(119, bundle2);
            }
        } catch (RemoteException e) {
            x.w("MicroMsg.MsgHandler", "onSearchDataReady exception" + e.getMessage());
        }
    }

    public final void c(int i, String str, Map<String, Object> map) {
        Bundle bundle = new Bundle();
        bundle.putInt("FTS_KEY_onStartWebSearch_type", i);
        bundle.putString("FTS_KEY_onStartWebSearch_query", str);
        bundle.putSerializable("FTS_KEY_onStartWebSearch_params", new HashMap(map));
        try {
            if (this.pRY != null) {
                this.pRY.c(com.tencent.mm.plugin.appbrand.jsapi.f.a.CTRL_INDEX, bundle);
            }
        } catch (RemoteException e) {
            x.w("MicroMsg.MsgHandler", "onSearchDataReady exception" + e.getMessage());
        }
    }

    public final void RH(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("fts_key_json_data", str);
        try {
            if (this.pRY != null) {
                this.pRY.c(124, bundle);
            }
        } catch (RemoteException e) {
            x.w("MicroMsg.MsgHandler", "onSearchSuggestionDataReady exception" + e.getMessage());
        }
    }

    public final void cJ(String str, int i) {
        Bundle bundle = new Bundle();
        bundle.putString("fts_key_sns_id", str);
        bundle.putInt("fts_key_status", i);
        try {
            if (this.pRY != null) {
                this.pRY.c(125, bundle);
            }
        } catch (RemoteException e) {
            x.w("MicroMsg.MsgHandler", "onMusicStatusChanged exception" + e.getMessage());
        }
    }

    public final void aV(int i, String str) {
        x.i("MicroMsg.MsgHandler", "onSearchImageListReady ret %d data %s", new Object[]{Integer.valueOf(i), str});
        Bundle bundle = new Bundle();
        bundle.putInt("fts_key_ret", i);
        bundle.putString("fts_key_data", str);
        try {
            if (this.pRY != null) {
                this.pRY.c(120, bundle);
            }
        } catch (RemoteException e) {
            x.w("MicroMsg.MsgHandler", "onSearchImageListReady exception" + e.getMessage());
        }
    }

    public final void c(int i, String str, int i2, String str2) {
        Bundle bundle = new Bundle();
        bundle.putInt("fts_key_teach_request_type", i);
        bundle.putString("fts_key_json_data", str);
        bundle.putInt("fts_key_is_cache_data", i2);
        bundle.putString("requestId", str2);
        try {
            if (this.pRY != null) {
                this.pRY.c(121, bundle);
            }
        } catch (RemoteException e) {
            x.w("MicroMsg.MsgHandler", "onTeachSearchDataReady exception" + e.getMessage());
        }
    }

    public final void af(String str, int i, int i2) {
        Bundle bundle = new Bundle();
        bundle.putString("fts_key_json_data", str);
        bundle.putInt("fts_key_is_cache_data", i);
        bundle.putInt("fts_key_is_expired", i2);
        try {
            if (this.pRY != null) {
                this.pRY.c(142, bundle);
            }
        } catch (Exception e) {
        }
    }

    public final boolean bs(i iVar) {
        boolean z = false;
        int i = bi.getInt(bi.cg(iVar.mcy.get("id")), 0);
        if (i <= 0) {
            a(iVar, "kvReport:fail", null);
        } else {
            boolean z2;
            String cg = bi.cg(iVar.mcy.get(DownloadSettingTable$Columns.VALUE));
            if (bi.getInt(bi.cg(iVar.mcy.get("is_important")), 0) > 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (bi.getInt(bi.cg(iVar.mcy.get("is_report_now")), 0) > 0) {
                z = true;
            }
            com.tencent.mm.plugin.report.service.h.mEJ.a(i, cg, z, z2);
            a(iVar, "kvReport:ok", null);
        }
        return true;
    }

    public final String getCurrentUrl() {
        String str = null;
        if (this.pRY == null) {
            x.i("MicroMsg.MsgHandler", "getCurrentUrl, callbacker is null");
            return str;
        }
        try {
            return this.pRY.getCurrentUrl();
        } catch (Exception e) {
            x.e("MicroMsg.MsgHandler", "getCurrentUrl, exception = %s", new Object[]{e});
            return str;
        }
    }

    private boolean bt(i iVar) {
        int i;
        String str = (String) iVar.mcy.get("miniProgramAppId");
        if (bi.oW(str)) {
            i = 0;
        } else {
            i = ((com.tencent.mm.plugin.appbrand.n.a) com.tencent.mm.kernel.g.l(com.tencent.mm.plugin.appbrand.n.a.class)).qA(str);
        }
        Map hashMap = new HashMap(1);
        hashMap.put("reportId", Integer.valueOf(i));
        a(iVar, "reportMiniProgramPageData:ok", hashMap);
        return true;
    }

    private boolean bu(i iVar) {
        int i = 0;
        String t = p.t(iVar.mcy, "targetAppId");
        String currentUrl = getCurrentUrl();
        String rL = rL(currentUrl);
        if (bi.oW(rL)) {
            rL = p.t(iVar.mcy, "referrerAppId");
        }
        if (bi.oW(t)) {
            a(iVar, "launchMiniProgram:fail_invalid_targetAppId", null);
        } else if (bi.oW(rL)) {
            a(iVar, "launchMiniProgram:fail_invalid_referrerAppId", null);
        } else {
            String oV = bi.oV(p.t(iVar.mcy, "envVersion"));
            int i2 = -1;
            switch (oV.hashCode()) {
                case 110628630:
                    if (oV.equals("trial")) {
                        boolean i22 = true;
                        break;
                    }
                    break;
                case 1559690845:
                    if (oV.equals("develop")) {
                        i22 = 0;
                        break;
                    }
                    break;
            }
            switch (i22) {
                case 0:
                    i = 1;
                    break;
                case 1:
                    i = 2;
                    break;
            }
            ((com.tencent.mm.plugin.appbrand.n.d) com.tencent.mm.kernel.g.l(com.tencent.mm.plugin.appbrand.n.d.class)).a(this.context, currentUrl, rL, t, i, p.t(iVar.mcy, "path"));
            a(iVar, "launchMiniProgram:ok", null);
        }
        return true;
    }

    private boolean bv(i iVar) {
        String str = (String) iVar.mcy.get("username");
        if (!bi.oW(str)) {
            ((com.tencent.mm.plugin.appbrand.n.c) com.tencent.mm.kernel.g.l(com.tencent.mm.plugin.appbrand.n.c.class)).b(str, null);
        }
        a(iVar, "forceUpdateWxaAttr:ok", null);
        return true;
    }

    private boolean bw(i iVar) {
        Bundle bundle = new Bundle(2);
        bundle.putString("set_page_title_text", (String) iVar.mcy.get("title"));
        bundle.putString("set_page_title_color", (String) iVar.mcy.get("color"));
        try {
            this.pRY.g(43, bundle);
            a(iVar, "setPageTitle:ok", null);
        } catch (Exception e) {
            x.e("MicroMsg.MsgHandler", "doSetPageTitle, exception = %s", new Object[]{e});
            a(iVar, "setPageTitle:fail", null);
        }
        return true;
    }

    @Deprecated
    private boolean bx(i iVar) {
        String str = (String) iVar.mcy.get("color");
        if (bi.oW(str)) {
            x.i("MicroMsg.MsgHandler", "doSetStatusBarStyle, color is null or nill");
            a(iVar, "setStatusBarStyle:fail", null);
        } else {
            int i;
            if (str.equalsIgnoreCase("black")) {
                i = 48;
            } else if (str.equalsIgnoreCase("white")) {
                i = 49;
            } else {
                i = -1;
            }
            if (-1 != i) {
                try {
                    this.pRY.g(i, Bundle.EMPTY);
                    a(iVar, "setStatusBarStyle:ok", null);
                } catch (Exception e) {
                    x.e("MicroMsg.MsgHandler", "doSetStatusBarStyle, exception = %s", new Object[]{e});
                    a(iVar, "setStatusBarStyle:fail", null);
                }
            } else {
                x.i("MicroMsg.MsgHandler", "doSetStatusBarStyle, color is neither black or white");
                a(iVar, "setStatusBarStyle:fail", null);
            }
        }
        return true;
    }

    private boolean by(i iVar) {
        if (iVar.mcy.containsKey("enable")) {
            try {
                boolean parseBoolean = Boolean.parseBoolean((String) iVar.mcy.get("enable"));
                Bundle bundle = new Bundle(1);
                bundle.putBoolean("enable_fullscreen_params_enable", parseBoolean);
                this.pRY.g(45, bundle);
                a(iVar, "enableFullScreen:ok", null);
            } catch (Exception e) {
                x.e("MicroMsg.MsgHandler", "doEnableFullScreen, exception = %s", new Object[]{e});
                a(iVar, "enableFullScreen:fail", null);
            }
        } else {
            a(iVar, "enableFullScreen:fail_invalid_arguments", null);
        }
        return true;
    }

    private boolean bz(i iVar) {
        String str = (String) iVar.mcy.get("left");
        String str2 = (String) iVar.mcy.get("right");
        if (bi.oW(str) && bi.oW(str2)) {
            a(iVar, "setNavigationBarButtons:fail", null);
        } else {
            Bundle bundle = new Bundle();
            try {
                str = new JSONObject(str).optString("color", "");
                if (!bi.oW(str)) {
                    bundle.putString("set_navigation_bar_buttons_left_text_color", str);
                }
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.MsgHandler", e, "setNavigationBarButtons opt left ", new Object[0]);
            }
            try {
                JSONObject jSONObject = new JSONObject(str2);
                boolean optBoolean = jSONObject.optBoolean("hidden", false);
                String optString = jSONObject.optString("text", "");
                String oV = bi.oV(com.tencent.mm.pluginsdk.ui.tools.s.Uf(jSONObject.optString("iconData", "")));
                str = jSONObject.optString("color", "");
                if (optBoolean) {
                    bundle.putBoolean("set_navigation_bar_buttons_hide_right_button", true);
                } else {
                    bundle.putString("set_navigation_bar_buttons_text", optString);
                    bundle.putString("set_navigation_bar_buttons_icon_data", oV);
                    bundle.putString("set_navigation_bar_buttons_text_color", str);
                }
            } catch (Throwable e2) {
                x.printErrStackTrace("MicroMsg.MsgHandler", e2, "setNavigationBarButtons opt right ", new Object[0]);
            }
            if (bundle.size() < 0) {
                a(iVar, "setNavigationBarButtons:fail_invalid_params", null);
            } else {
                try {
                    this.pRY.g(44, bundle);
                    a(iVar, "setNavigationBarButtons:ok", null);
                } catch (Throwable e22) {
                    x.printErrStackTrace("MicroMsg.MsgHandler", e22, " setNavigationBarButtons invoke ", new Object[0]);
                    a(iVar, "setNavigationBarButtons:fail_invoke", null);
                }
            }
        }
        return true;
    }

    public final boolean bA(i iVar) {
        try {
            this.pRY.g(34, Bundle.EMPTY);
            a(iVar, "enablePullDownRefresh:ok", null);
        } catch (Exception e) {
            x.i("MicroMsg.MsgHandler", "doEnablePullDownRefresh, exception = %s", new Object[]{e});
            a(iVar, "enablePullDownRefresh:fail", null);
        }
        return true;
    }

    public final boolean bB(i iVar) {
        try {
            this.pRY.g(35, Bundle.EMPTY);
            a(iVar, "startPullDownRefresh:ok", null);
        } catch (Exception e) {
            x.i("MicroMsg.MsgHandler", "doStartPullDownRefresh, exception = %s", new Object[]{e});
            a(iVar, "startPullDownRefresh:fail", null);
        }
        return true;
    }

    public final boolean bC(i iVar) {
        try {
            this.pRY.g(36, Bundle.EMPTY);
            a(iVar, "stopPullDownRefresh:ok", null);
        } catch (Exception e) {
            x.i("MicroMsg.MsgHandler", "doStopPullDownRefresh, exception = %s", new Object[]{e});
            a(iVar, "stopPullDownRefresh:fail", null);
        }
        return true;
    }

    public final boolean bYn() {
        try {
            this.pRY.g(47, Bundle.EMPTY);
            a(this.qhP, "disablePullDownRefresh:ok", null);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.MsgHandler", e, "", new Object[0]);
            a(this.qhP, "disablePullDownRefresh:fail", null);
        }
        return true;
    }

    public final boolean bD(i iVar) {
        this.iKs = false;
        String oV = bi.oV((String) iVar.mcy.get("placeholder"));
        int i = bi.getInt((String) iVar.mcy.get("maxLength"), 0);
        try {
            Bundle bundle = new Bundle(2);
            bundle.putString("show_kb_placeholder", oV);
            bundle.putInt("show_kb_max_length", i);
            this.pRY.g(37, bundle);
            this.qiF = iVar;
        } catch (Exception e) {
            x.i("MicroMsg.MsgHandler", "doShowKeyBoard, exception = %s", new Object[]{e});
            a(this.pRY, iVar, "showKeyboard:fail", null, true, true);
        }
        return true;
    }

    public final boolean bE(i iVar) {
        this.iKs = false;
        try {
            Bundle g = this.pRY.g(79, new Bundle());
            Map hashMap = new HashMap();
            int i = g.getInt("height", 0);
            if (i > 0) {
                hashMap.put("height", Integer.valueOf(com.tencent.mm.bp.a.ag(ad.getContext(), i)));
                a(this.pRY, iVar, "showSmileyPanel:ok", hashMap, true, true);
            } else {
                a(this.pRY, iVar, "showSmileyPanel:fail", null, true, true);
            }
        } catch (Exception e) {
            x.i("MicroMsg.MsgHandler", "doShowSmileyPanel, exception = %s", new Object[]{e});
            a(this.pRY, iVar, "showSmileyPanel:fail", null, true, true);
        }
        return true;
    }

    public final boolean bF(i iVar) {
        String str = (String) iVar.mcy.get("place");
        if (bi.oW(str)) {
            a(iVar, "disableBounceScroll:fail", null);
        } else {
            try {
                JSONArray jSONArray = new JSONArray(str);
                int i = 0;
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    if ("top".equalsIgnoreCase(jSONArray.getString(i2))) {
                        i = true;
                    }
                }
                if (i == 0) {
                    a(iVar, "disableBounceScroll:ok", null);
                } else {
                    try {
                        Bundle bundle = new Bundle(1);
                        bundle.putInt("webview_disable_bounce_scroll_top", 1);
                        this.pRY.g(38, bundle);
                        a(iVar, "disableBounceScroll:ok", null);
                    } catch (Exception e) {
                        x.i("MicroMsg.MsgHandler", "doDisableBounceScroll, exception = %s", new Object[]{e});
                        a(iVar, "disableBounceScroll:fail", null);
                    }
                }
            } catch (JSONException e2) {
                x.i("MicroMsg.MsgHandler", "doDisableBounceScroll, invalid json array, string = %s", new Object[]{str});
                a(iVar, "disableBounceScroll:fail", null);
            }
        }
        return true;
    }

    public final boolean bG(i iVar) {
        try {
            this.pRY.g(39, new Bundle(0));
            a(iVar, "clearBounceBackground:ok", null);
        } catch (Exception e) {
            x.e("MicroMsg.MsgHandler", "doClearBounceBackground, exception = %s", new Object[]{e});
            a(iVar, "clearBounceBackground:fail", null);
        }
        return true;
    }

    public final boolean bH(i iVar) {
        Bundle bundle = new Bundle();
        bundle.putString("key_set_bounce_background_color", (String) iVar.mcy.get("backgroundColor"));
        try {
            this.pRY.g(72, bundle);
            a(iVar, "setBounceBackground:ok", null);
        } catch (Exception e) {
            x.e("MicroMsg.MsgHandler", "setBounceBackground, exception = %s", new Object[]{e});
            a(iVar, "setBounceBackground:fail", null);
        }
        return true;
    }

    public final boolean bI(i iVar) {
        int i = bi.getInt(bi.cg(iVar.mcy.get("id")), 0);
        if (i <= 0) {
            a(iVar, "realtimeReport:fail", null);
            return true;
        }
        Object obj;
        String cg = bi.cg(iVar.mcy.get(DownloadSettingTable$Columns.VALUE));
        int i2 = bi.getInt(bi.cg(iVar.mcy.get(DownloadSettingTable$Columns.TYPE)), 0);
        com.tencent.mm.plugin.webview.model.f bTW = f$a.pRk;
        if (au.HX()) {
            long longValue;
            com.tencent.mm.plugin.webview.model.e bUZ = com.tencent.mm.plugin.webview.modeltools.e.bUZ();
            Long l = (Long) bUZ.pRc.get(Integer.valueOf(i));
            if (l != null) {
                longValue = l.longValue();
            } else {
                Cursor b = bUZ.dCZ.b(String.format("select %s from %s where %s=?", new Object[]{"liftTime", "JsLogBlockList", "logId"}), new String[]{String.valueOf(i)}, 2);
                if (b == null) {
                    longValue = 0;
                } else if (b.moveToFirst()) {
                    longValue = b.getLong(0);
                    b.close();
                } else {
                    b.close();
                    longValue = 0;
                }
            }
            if (longValue != 0 && longValue < bi.VE()) {
                com.tencent.mm.sdk.platformtools.av avVar = bUZ.pRc;
                Integer valueOf = Integer.valueOf(i);
                if (valueOf == null) {
                    throw new NullPointerException("key == null");
                }
                if (avVar.get(valueOf) != null) {
                    avVar.s(valueOf, null);
                }
                longValue = 0;
            }
            if (longValue == 0 || longValue < bi.VE()) {
                apz apz = new apz();
                apz.rSt = i;
                apz.rSu = com.tencent.mm.bk.b.Uw(cg);
                apz.rSC = i2;
                bTW.pRh.add(apz);
                obj = 1;
                if (obj == null) {
                    a(iVar, "realtimeReport:ok", null);
                } else {
                    a(iVar, "realtimeReport:fail", null);
                }
                return true;
            }
        }
        x.i("MicroMsg.WebView.JsLogHelper", "kvStat(), acc not ready, skip");
        obj = null;
        if (obj == null) {
            a(iVar, "realtimeReport:fail", null);
        } else {
            a(iVar, "realtimeReport:ok", null);
        }
        return true;
    }

    public final boolean bJ(i iVar) {
        String str = (String) iVar.mcy.get("latitude");
        String str2 = (String) iVar.mcy.get("longitude");
        String str3 = (String) iVar.mcy.get("destinationName");
        if (bi.oW(str) || bi.oW(str2)) {
            a(iVar, "openMapNavigateMenu:fail", null);
        } else {
            try {
                double parseDouble = Double.parseDouble(str);
                double parseDouble2 = Double.parseDouble(str2);
                int i = bi.getInt((String) iVar.mcy.get("preferMap"), com.tencent.mm.pluginsdk.model.a.a.qyH.code);
                if (this.context == null || !(this.context instanceof Activity) || ((Activity) this.context).isFinishing()) {
                    a(iVar, "openMapNavigateMenu:fail", null);
                } else {
                    ah.A(new 23(this, i, parseDouble, parseDouble2, str3, aW(iVar)));
                }
            } catch (Exception e) {
                x.e("MicroMsg.MsgHandler", "doOpenMapNavigateMenu, parse double, exception = %s");
                a(iVar, "openMapNavigateMenu:fail", null);
            }
        }
        return true;
    }

    public final Bundle bYo() {
        Bundle bundle = null;
        try {
            bundle = this.pRY.g(33, null);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.MsgHandler", e, "", new Object[0]);
        }
        x.i("MicroMsg.MsgHandler", "getWebViewIntentExtras(%s)", new Object[]{bundle});
        return bundle;
    }

    private boolean bK(i iVar) {
        String str = (String) iVar.mcy.get("operationType");
        String str2 = (String) iVar.mcy.get("dataUrl");
        l.a(iVar.qkk, false, null, "");
        if (bi.oW(str) || bi.oW(str2)) {
            a(iVar, "operateMusicPlayer:fail", null);
            return true;
        }
        Object obj;
        if (str.equalsIgnoreCase("play")) {
            String str3 = (String) iVar.mcy.get("title");
            String str4 = (String) iVar.mcy.get("singer");
            String str5 = (String) iVar.mcy.get("epname");
            String str6 = (String) iVar.mcy.get("coverImgUrl");
            String str7 = (String) iVar.mcy.get("lowbandUrl");
            String str8 = (String) iVar.mcy.get("webUrl");
            iVar.mcy.get("lyric");
            x.i("MicroMsg.MsgHandler", "title : %s, singer : %s, epName : %s, coverImgUrl : %s, dataUrl : %s, lowbandUrl : %s, webUrl : %s, appid : %s", new Object[]{str3, str4, str5, str6, str2, str7, str8, ""});
            if (bi.oW(str3) || bi.oW(str4) || bi.oW(str5) || bi.oW(str6) || bi.oW(str7) || bi.oW(str2) || bi.oW(str8)) {
                a(iVar, "operateMusicPlayer:fail", null);
            } else {
                com.tencent.mm.an.b.PW();
                com.tencent.mm.an.a.b bVar = (com.tencent.mm.an.a.b) com.tencent.mm.kernel.g.l(com.tencent.mm.an.a.b.class);
                String str9 = str2.hashCode();
                String str10 = com.tencent.mm.compatible.util.e.bnE;
                StringBuilder stringBuilder = new StringBuilder();
                au.HU();
                com.tencent.mm.an.b.b(bVar.a(7, str6, str3, str4, str8, str7, str2, str9, str10, stringBuilder.append(com.tencent.mm.model.c.Gb()).append(str6.hashCode()).toString(), str5, ""));
                a(iVar, "operateMusicPlayer:ok", null);
            }
        } else if (str.equalsIgnoreCase("resume")) {
            if (com.tencent.mm.an.c.mq(str2) && com.tencent.mm.an.b.PZ() && !com.tencent.mm.an.b.PY()) {
                com.tencent.mm.an.b.yM();
                obj = 1;
            } else {
                obj = null;
            }
            if (obj != null) {
                a(iVar, "operateMusicPlayer:ok", null);
            } else {
                a(iVar, "operateMusicPlayer:fail", null);
            }
        } else if (str.equalsIgnoreCase("pause")) {
            if (com.tencent.mm.an.c.mq(str2) && com.tencent.mm.an.b.PY()) {
                com.tencent.mm.an.b.yL();
                obj = 1;
            } else {
                obj = null;
            }
            if (obj != null) {
                com.tencent.mm.an.b.PX();
                a(iVar, "operateMusicPlayer:ok", null);
            } else {
                a(iVar, "operateMusicPlayer:fail", null);
            }
        } else if (str.equalsIgnoreCase("seek")) {
            if (com.tencent.mm.an.c.mq(str2) ? com.tencent.mm.an.b.if(bi.getInt(bi.cg(iVar.mcy.get("position")), -1) * BaseReportManager.MAX_READ_COUNT) : false) {
                a(iVar, "operateMusicPlayer:ok", null);
            } else {
                a(iVar, "operateMusicPlayer:fail", null);
            }
        } else if (str.equalsIgnoreCase("stop")) {
            if (com.tencent.mm.an.c.mq(str2) && com.tencent.mm.an.b.PZ()) {
                com.tencent.mm.an.b.PW();
                obj = 1;
            } else {
                obj = null;
            }
            if (obj != null) {
                a(iVar, "operateMusicPlayer:ok", null);
            } else {
                a(iVar, "operateMusicPlayer:fail", null);
            }
        } else {
            a(iVar, "operateMusicPlayer:fail", null);
        }
        return true;
    }

    private boolean bL(i iVar) {
        String str = (String) iVar.mcy.get("dataUrl");
        l.a(iVar.qkk, false, null, (String) iVar.mcy.get("appId"));
        if (bi.oW(str)) {
            a(iVar, "getMusicPlayerState:fail_dataUrl_null", null);
        } else {
            x.i("MicroMsg.MsgHandler", "dataUrl : %s, appid : %s", new Object[]{str, r1});
            avq Qa = com.tencent.mm.an.b.Qa();
            if (Qa == null || !Qa.rYp.equals(str)) {
                a(iVar, "getMusicPlayerState:failed_dataUrl_diff", null);
            } else {
                int i;
                com.tencent.mm.an.d Qb = com.tencent.mm.an.b.Qb();
                int i2 = -1;
                if (Qb != null) {
                    i2 = Qb.mDuration;
                    i = Qb.mPosition;
                } else {
                    i = 0;
                }
                if (Qb == null || i2 < 0 || i < 0) {
                    a(iVar, "getMusicPlayerState:fail", null);
                } else {
                    i2 /= BaseReportManager.MAX_READ_COUNT;
                    i /= BaseReportManager.MAX_READ_COUNT;
                    int i3 = Qb.mStatus;
                    int i4 = Qb.ebg;
                    Map hashMap = new HashMap();
                    hashMap.put("duration", Integer.valueOf(i2));
                    hashMap.put("currentPosition", Integer.valueOf(i));
                    hashMap.put(DownloadInfo.STATUS, Integer.valueOf(i3));
                    hashMap.put("downloadPercent", Integer.valueOf(i4));
                    a(iVar, "getMusicPlayerState:ok", hashMap);
                }
            }
        }
        return true;
    }

    private boolean bM(i iVar) {
        String str = (String) iVar.mcy.get("localId");
        if (bi.oW(str)) {
            a(iVar, "getLocalImgData:fail_invaild_localid", null);
        } else {
            WebViewJSSDKFileItem Qq = com.tencent.mm.plugin.webview.modeltools.e.bUX().Qq(str);
            if (!(Qq == null || Qq.fOs == null)) {
                int i;
                Bitmap decodeFile = MMBitmapFactory.decodeFile(Qq.fOs);
                int i2 = decodeFile != null ? 1 : 0;
                if (decodeFile.isRecycled()) {
                    i = 0;
                } else {
                    i = 1;
                }
                if ((i2 & i) != 0) {
                    OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    decodeFile.compress(CompressFormat.JPEG, 100, byteArrayOutputStream);
                    x.i("MicroMsg.MsgHandler", "rawData lenght = %d, base64 lenght = %d", new Object[]{Integer.valueOf(byteArrayOutputStream.toByteArray().length), Integer.valueOf(Base64.encodeToString(byteArrayOutputStream.toByteArray(), 0).length())});
                    Map hashMap = new HashMap();
                    hashMap.put("localData", r3);
                    a(iVar, "getLocalImgData:ok", hashMap);
                    decodeFile.recycle();
                }
            }
            a(iVar, "getLocalImgData:fail", null);
        }
        return true;
    }

    private boolean bN(i iVar) {
        int i = 0;
        this.iKs = false;
        Bundle bundle = new Bundle();
        try {
            int i2 = bi.getInt(iVar.mcy.get("scene").toString().trim(), 0);
            bundle.putInt("scene", i2);
            x.i("MicroMsg.MsgHandler", "doExposePreparation scene:%d", new Object[]{Integer.valueOf(i2)});
            if (-1 == bundle.getInt("scene")) {
                a(iVar, "doExposePreparation fail:unknown scene", null);
            } else {
                bundle = this.pRY.g(73, bundle);
                Map hashMap = new HashMap();
                if (bundle.isEmpty()) {
                    a(iVar, "doExposePreparation fail", null);
                } else {
                    switch (i2) {
                        case 1:
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                        case 6:
                        case 7:
                        case 35:
                        case 36:
                        case 37:
                        case 38:
                        case 39:
                        case f$k.AppCompatTheme_actionDropDownStyle /*45*/:
                            break;
                        case 33:
                            hashMap.put("newMsgId", bundle.getString("newMsgId"));
                            break;
                        case 34:
                            hashMap.put("webviewImg", bundle.getString("webviewImg"));
                            hashMap.put("webviewHtml", bundle.getString("webviewHtml"));
                            hashMap.put("content", bundle.getString("content"));
                            x.i("MicroMsg.MsgHandler", "content = " + bundle.getString("content"));
                            break;
                        case f$k.AppCompatTheme_buttonBarButtonStyle /*51*/:
                            hashMap.put("newMsgId", bundle.getString("newMsgId"));
                            hashMap.put("msgType", Integer.valueOf(bundle.getInt("msgType")));
                            break;
                        default:
                            a(iVar, "doExposePreparation fail:unknown scene", null);
                            break;
                    }
                    hashMap.put("username", bundle.getString("username"));
                    JSONArray jSONArray = new JSONArray();
                    ArrayList stringArrayList = bundle.getStringArrayList("content");
                    if (stringArrayList != null) {
                        int size = stringArrayList.size();
                        while (i < size) {
                            jSONArray.put(stringArrayList.get(i));
                            i++;
                        }
                    }
                    if (hashMap.get("content") == null) {
                        hashMap.put("content", jSONArray.toString());
                    }
                    a(iVar, "doExposePreparation ok", hashMap);
                }
            }
        } catch (Exception e) {
            x.w("MicroMsg.MsgHandler", "doExposePreparation exception " + e.getMessage());
            a(iVar, "doExposePreparation fail", null);
        }
        return true;
    }

    private boolean bO(i iVar) {
        try {
            String obj = iVar.mcy.get(DownloadSettingTable$Columns.TYPE).toString();
            Intent intent;
            if (bi.oW(obj)) {
                a(iVar, "openLuckyMoneyHistory:fail", null);
            } else if (obj.equals("send")) {
                intent = new Intent();
                intent.putExtra("key_type", 1);
                com.tencent.mm.bg.d.b(this.context, "luckymoney", ".ui.LuckyMoneyMyRecordUI", intent);
                a(iVar, "openLuckyMoneyHistory:ok", null);
            } else if (obj.equals("receive")) {
                intent = new Intent();
                intent.putExtra("key_type", 2);
                com.tencent.mm.bg.d.b(this.context, "luckymoney", ".ui.LuckyMoneyMyRecordUI", intent);
                a(iVar, "openLuckyMoneyHistory:ok", null);
            }
        } catch (Exception e) {
            x.e("MicroMsg.MsgHandler", "doOpenLuckyMoneyHistory error %s", new Object[]{e});
            a(iVar, "openLuckyMoneyHistory:fail", null);
        }
        return true;
    }

    private boolean bP(i iVar) {
        String obj = iVar.mcy.get("chat_username").toString();
        Intent intent = new Intent();
        intent.putExtra("Chat_User", obj);
        intent.putExtra("finish_direct", true);
        intent.putExtra("expose_edit_mode", true);
        intent.setFlags(536870912);
        if (this.context instanceof MMActivity) {
            com.tencent.mm.bg.d.a((MMActivity) this.context, ".ui.chatting.ChattingUI", intent, 40, this);
        } else {
            x.e("MicroMsg.MsgHandler", "getMsgProofItems invalid context");
            a(iVar, "select chat record:fail", null);
        }
        return true;
    }

    private boolean bQ(i iVar) {
        this.iKs = false;
        String trim = iVar.mcy.get("scene").toString().trim();
        if (!trim.equals("expose")) {
            a(iVar, "openSecurityView fail, scene error : " + trim, null);
        } else if (iVar.mcy.get("userData") != null) {
            try {
                JSONObject jSONObject = (JSONObject) new JSONTokener(iVar.mcy.get("userData").toString()).nextValue();
                Intent intent = new Intent();
                intent.putExtra("sns_permission_userName", jSONObject.get("userName").toString());
                intent.putExtra("sns_permission_anim", true);
                intent.putExtra("sns_permission_block_scene", 1);
                intent.setFlags(536870912);
                com.tencent.mm.bg.d.b(this.context, "sns", ".ui.SnsPermissionUI", intent);
                a(iVar, "openSecurityView ok", null);
            } catch (JSONException e) {
                x.w("MicroMsg.MsgHandler", "openSecurityView error, userData not in json");
                a(iVar, "openSecurityView error,userData not in json", null);
            }
        } else {
            a(iVar, "openSecurityView fail, no userData", null);
        }
        return true;
    }

    private boolean bR(i iVar) {
        String rL = rL(getCurrentUrl());
        String zy = com.tencent.mm.compatible.e.q.zy();
        String zz = com.tencent.mm.compatible.e.q.zz();
        if (bi.oW(zy) || bi.oW(rL) || bi.oW(zz)) {
            a(iVar, "getOpenDeviceId:fail", null);
        } else {
            zy = ac.ce(ac.ce(rL + zy));
            rL = ac.ce(ac.ce(rL + zz));
            Map hashMap = new HashMap();
            hashMap.put("deviceid", zy);
            hashMap.put("newDeviceId", rL);
            a(iVar, "getOpenDeviceId:ok", hashMap);
        }
        return true;
    }

    private boolean bS(i iVar) {
        try {
            Bundle g = this.pRY.g(90000, null);
            if (g != null) {
                String str;
                String str2;
                String str3;
                Object[] objArr;
                Map hashMap;
                JSONArray jSONArray;
                String[] stringArray = g.getStringArray("webview_get_route_url_list");
                int i = g.getInt("webview_get_route_url_geta8key_scene");
                if (i == 7) {
                    String string = g.getString("geta8key_username");
                    if (!bi.oW(string)) {
                        com.tencent.mm.ac.d kH = com.tencent.mm.ac.f.kH(string);
                        if (kH != null) {
                            str = kH.field_appId;
                            str2 = "MicroMsg.MsgHandler";
                            str3 = "routeUrl length = %d, scene = %d, appid = %s";
                            objArr = new Object[3];
                            objArr[0] = Integer.valueOf(stringArray == null ? stringArray.length : -1);
                            objArr[1] = Integer.valueOf(i);
                            objArr[2] = str;
                            x.i(str2, str3, objArr);
                            if (stringArray != null && stringArray.length > 0) {
                                hashMap = new HashMap();
                                jSONArray = new JSONArray();
                                for (Object put : stringArray) {
                                    jSONArray.put(put);
                                }
                                hashMap.put("urls", jSONArray.toString());
                                hashMap.put("scene", Integer.valueOf(i));
                                if (!bi.oW(str)) {
                                    hashMap.put("appid", str);
                                }
                                a(iVar, "getRouteUrl:ok", hashMap);
                                return true;
                            }
                        }
                    }
                }
                str = null;
                str2 = "MicroMsg.MsgHandler";
                str3 = "routeUrl length = %d, scene = %d, appid = %s";
                objArr = new Object[3];
                if (stringArray == null) {
                }
                objArr[0] = Integer.valueOf(stringArray == null ? stringArray.length : -1);
                objArr[1] = Integer.valueOf(i);
                objArr[2] = str;
                x.i(str2, str3, objArr);
                hashMap = new HashMap();
                jSONArray = new JSONArray();
                while (r0 < r8) {
                    jSONArray.put(put);
                }
                hashMap.put("urls", jSONArray.toString());
                hashMap.put("scene", Integer.valueOf(i));
                if (bi.oW(str)) {
                    hashMap.put("appid", str);
                }
                a(iVar, "getRouteUrl:ok", hashMap);
                return true;
            }
        } catch (Exception e) {
            x.e("MicroMsg.MsgHandler", "get routeurl failed ; %s", new Object[]{e.getMessage()});
        }
        a(iVar, "getRouteUrl:fail", null);
        return true;
    }

    private boolean bT(i iVar) {
        x.i("MicroMsg.MsgHandler", "doGetBackgroundAudioState()");
        if (bV(iVar)) {
            avq Qa = com.tencent.mm.an.b.Qa();
            if (Qa != null) {
                int i;
                com.tencent.mm.an.d Qb = com.tencent.mm.an.b.Qb();
                int i2 = -1;
                if (Qb != null) {
                    i2 = Qb.mDuration;
                    i = Qb.mPosition;
                } else {
                    i = 0;
                }
                if (Qb == null || i2 < 0 || i < 0) {
                    x.e("MicroMsg.MsgHandler", "return parameter is invalid");
                    a(iVar, "getBackgroundAudioState:fail", null);
                } else {
                    com.tencent.mm.sdk.b.a.sFg.b(this.qiG);
                    i2 /= BaseReportManager.MAX_READ_COUNT;
                    int i3 = i / BaseReportManager.MAX_READ_COUNT;
                    int i4 = Qb.mStatus;
                    i = Qb.ebg;
                    if (i2 > 0) {
                        i = (i * i2) / 100;
                    } else {
                        i = 0;
                    }
                    Map hashMap = new HashMap();
                    hashMap.put("duration", Integer.valueOf(i2));
                    hashMap.put("currentTime", Integer.valueOf(i3));
                    hashMap.put("paused", Integer.valueOf(i4 == 1 ? 0 : 1));
                    hashMap.put("src", Qa.rYp);
                    hashMap.put("buffered", Integer.valueOf(i));
                    hashMap.put("title", Qa.rYl);
                    hashMap.put("epname", Qa.rYn);
                    hashMap.put("singer", Qa.rYm);
                    hashMap.put("coverImgUrl", Qa.rYo);
                    hashMap.put("isLive", Integer.valueOf(0));
                    hashMap.put("startTime", Integer.valueOf(Qa.dGs / BaseReportManager.MAX_READ_COUNT));
                    hashMap.put("srcId", Qa.eaZ);
                    hashMap.put("protocol", Qa.protocol == null ? "" : Qa.protocol);
                    hashMap.put("webUrl", Qa.rYr);
                    hashMap.put("playState", Qb.ebh);
                    x.i("MicroMsg.MsgHandler", "getBackgroundAudioState ok");
                    a(iVar, "getBackgroundAudioState:ok", hashMap);
                }
            } else {
                x.e("MicroMsg.MsgHandler", "currentWrapper is null");
                a(iVar, "getBackgroundAudioState:fail", null);
            }
        } else {
            x.e("MicroMsg.MsgHandler", "no permission to do get state");
            a(iVar, "getBackgroundAudioState:fail", null);
        }
        return true;
    }

    private boolean d(i iVar, JsapiPermissionWrapper jsapiPermissionWrapper) {
        String RE;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        int i;
        String str8;
        String str9;
        String str10;
        boolean gu;
        String str11;
        x.i("MicroMsg.MsgHandler", "doSetBackgroundAudioState()");
        com.tencent.mm.sdk.b.a.sFg.b(this.qiG);
        CharSequence charSequence = (String) iVar.mcy.get("appId");
        if (this.qhS != null) {
            if (TextUtils.isEmpty(charSequence)) {
                charSequence = this.qhS.getString("jsapi_args_appid");
            }
            if (TextUtils.isEmpty(charSequence)) {
                String QD;
                RE = this.qic.RE(getCurrentUrl());
                x.i("MicroMsg.MsgHandler", "appId:%s", new Object[]{RE});
                l.a(iVar.qkk, false, null, RE);
                str = (String) iVar.mcy.get(TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_URL);
                if (bi.oW(str)) {
                    QD = com.tencent.mm.plugin.webview.modelcache.p.QD(str);
                } else {
                    QD = null;
                }
                str2 = (String) iVar.mcy.get("src");
                str3 = (String) iVar.mcy.get("lowbandSrc");
                str4 = (String) iVar.mcy.get("title");
                str5 = (String) iVar.mcy.get("epname");
                str6 = (String) iVar.mcy.get("singer");
                str = (String) iVar.mcy.get("coverImgUrl");
                str7 = (String) iVar.mcy.get("webUrl");
                i = bi.getInt((String) iVar.mcy.get("startTime"), 0);
                str8 = (String) iVar.mcy.get("srcId");
                str9 = (String) iVar.mcy.get("protocol");
                str10 = (String) iVar.mcy.get("musicbar_url");
                gu = jsapiPermissionWrapper.gu(308);
                if (str != null) {
                    str11 = "";
                } else {
                    str11 = str;
                }
                x.i("MicroMsg.MsgHandler", "src : %s, title : %s, singer : %s, coverImgUrl : %s, webUrl : %s, startTime:%d, protocol:%s, barBackToWebView:%b, musicbar_url:%s", new Object[]{str2, str4, str6, str11, str7, Integer.valueOf(i), str9, Boolean.valueOf(gu), str10});
                if (!bi.oW(str2) || bi.oW(str4)) {
                    x.e("MicroMsg.MsgHandler", "setBackgroundAudioState fail, src or title is null");
                    a(iVar, "setBackgroundAudioState:fail", null);
                } else {
                    com.tencent.mm.an.a.b bVar = (com.tencent.mm.an.a.b) com.tencent.mm.kernel.g.l(com.tencent.mm.an.a.b.class);
                    String str12 = str2.hashCode();
                    String str13 = com.tencent.mm.compatible.util.e.bnE;
                    StringBuilder stringBuilder = new StringBuilder();
                    au.HU();
                    avq a = bVar.a(10, str11, str4, str6, str7, str3, str2, str12, str13, stringBuilder.append(com.tencent.mm.model.c.Gb()).append(str11.hashCode()).toString(), str5, RE);
                    a.rYD = QD;
                    a.dGs = i * BaseReportManager.MAX_READ_COUNT;
                    a.eaZ = str8;
                    a.protocol = str9;
                    a.rYE = gu;
                    a.rYF = str10;
                    com.tencent.mm.an.b.b(a);
                    x.i("MicroMsg.MsgHandler", "setBackgroundAudioState ok");
                    a(iVar, "setBackgroundAudioState:ok", null);
                }
                return true;
            }
        }
        CharSequence RE2 = charSequence;
        x.i("MicroMsg.MsgHandler", "appId:%s", new Object[]{RE2});
        l.a(iVar.qkk, false, null, RE2);
        str = (String) iVar.mcy.get(TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_URL);
        if (bi.oW(str)) {
            QD = null;
        } else {
            QD = com.tencent.mm.plugin.webview.modelcache.p.QD(str);
        }
        str2 = (String) iVar.mcy.get("src");
        str3 = (String) iVar.mcy.get("lowbandSrc");
        str4 = (String) iVar.mcy.get("title");
        str5 = (String) iVar.mcy.get("epname");
        str6 = (String) iVar.mcy.get("singer");
        str = (String) iVar.mcy.get("coverImgUrl");
        str7 = (String) iVar.mcy.get("webUrl");
        i = bi.getInt((String) iVar.mcy.get("startTime"), 0);
        str8 = (String) iVar.mcy.get("srcId");
        str9 = (String) iVar.mcy.get("protocol");
        str10 = (String) iVar.mcy.get("musicbar_url");
        gu = jsapiPermissionWrapper.gu(308);
        if (str != null) {
            str11 = str;
        } else {
            str11 = "";
        }
        x.i("MicroMsg.MsgHandler", "src : %s, title : %s, singer : %s, coverImgUrl : %s, webUrl : %s, startTime:%d, protocol:%s, barBackToWebView:%b, musicbar_url:%s", new Object[]{str2, str4, str6, str11, str7, Integer.valueOf(i), str9, Boolean.valueOf(gu), str10});
        if (bi.oW(str2)) {
        }
        x.e("MicroMsg.MsgHandler", "setBackgroundAudioState fail, src or title is null");
        a(iVar, "setBackgroundAudioState:fail", null);
        return true;
    }

    private boolean bU(i iVar) {
        String str = (String) iVar.mcy.get("operationType");
        x.i("MicroMsg.MsgHandler", "doOperateBackgroundAudio(), optype:%s", new Object[]{str});
        String str2 = (String) iVar.mcy.get("appId");
        if (this.qhS != null) {
            if (TextUtils.isEmpty(str2)) {
                str2 = this.qhS.getString("jsapi_args_appid");
            }
            if (TextUtils.isEmpty(str2)) {
                str2 = this.qic.RE(getCurrentUrl());
            }
        }
        l.a(iVar.qkk, false, null, str2);
        if (!bV(iVar)) {
            x.e("MicroMsg.MsgHandler", "doOperateBackgroundAudio getMusicPermission is false");
            a(iVar, "operateBackgroundAudio:fail", null);
        } else if (bi.oW(str)) {
            x.e("MicroMsg.MsgHandler", "doOperateBackgroundAudio optype is empty");
            a(iVar, "operateBackgroundAudio:fail", null);
        } else {
            com.tencent.mm.sdk.b.a.sFg.b(this.qiG);
            if (str.equalsIgnoreCase("play")) {
                if (com.tencent.mm.an.c.Qc()) {
                    a(iVar, "operateBackgroundAudio:ok", null);
                } else {
                    x.e("MicroMsg.MsgHandler", "operateBackgroundAudio play fail");
                    a(iVar, "operateBackgroundAudio:fail", null);
                }
            } else if (str.equalsIgnoreCase("resume")) {
                if (com.tencent.mm.an.c.Qc()) {
                    a(iVar, "operateBackgroundAudio:ok", null);
                } else {
                    x.e("MicroMsg.MsgHandler", "operateBackgroundAudio resume fail");
                    a(iVar, "operateBackgroundAudio:fail", null);
                }
            } else if (str.equalsIgnoreCase("pause")) {
                if (com.tencent.mm.an.c.Qd()) {
                    com.tencent.mm.an.b.PX();
                    a(iVar, "operateBackgroundAudio:ok", null);
                } else {
                    x.e("MicroMsg.MsgHandler", "operateBackgroundAudio pause fail");
                    a(iVar, "operateBackgroundAudio:fail", null);
                }
            } else if (str.equalsIgnoreCase("seek")) {
                int i = bi.getInt((String) iVar.mcy.get("currentTime"), -1);
                x.i("MicroMsg.MsgHandler", "currentTime:%d", new Object[]{Integer.valueOf(i)});
                if (i < 0) {
                    x.e("MicroMsg.MsgHandler", "currentTime is invalid!");
                    a(iVar, "operateBackgroundAudio:fail", null);
                } else if (com.tencent.mm.an.b.if(i * BaseReportManager.MAX_READ_COUNT)) {
                    a(iVar, "operateBackgroundAudio:ok", null);
                } else {
                    x.e("MicroMsg.MsgHandler", "operateBackgroundAudio seek fail");
                    a(iVar, "operateBackgroundAudio:fail", null);
                }
            } else if (!str.equalsIgnoreCase("stop")) {
                x.e("MicroMsg.MsgHandler", "operateBackgroundAudio fail, invalid opeType");
                a(iVar, "operateBackgroundAudio:fail", null);
            } else if (com.tencent.mm.an.c.Qe()) {
                a(iVar, "operateBackgroundAudio:ok", null);
            } else {
                x.e("MicroMsg.MsgHandler", "operateBackgroundAudio stop fail");
                a(iVar, "operateBackgroundAudio:fail", null);
            }
        }
        return true;
    }

    private boolean bV(i iVar) {
        String str;
        Object obj;
        boolean z;
        String str2;
        String str3;
        Object[] objArr;
        int i = 1;
        avq Qa = com.tencent.mm.an.b.Qa();
        CharSequence charSequence = (String) iVar.mcy.get("appId");
        if (this.qhS != null) {
            if (TextUtils.isEmpty(charSequence)) {
                charSequence = this.qhS.getString("jsapi_args_appid");
            }
            if (TextUtils.isEmpty(charSequence)) {
                Object RE = this.qic.RE(getCurrentUrl());
                str = (String) iVar.mcy.get(TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_URL);
                obj = null;
                if (!bi.oW(str)) {
                    obj = com.tencent.mm.plugin.webview.modelcache.p.QD(str);
                }
                if (Qa == null) {
                    str = Qa.jQb;
                    String QD = com.tencent.mm.plugin.webview.modelcache.p.QD(Qa.rYr);
                    String str4 = Qa.rYD;
                    x.i("MicroMsg.MsgHandler", "app_id:%s, musicAppId:%s", new Object[]{RE, str});
                    x.i("MicroMsg.MsgHandler", "domain: %s, songWebDomain: %s, jsWebDomain: %s， with no port", new Object[]{obj, QD, str4});
                    if (TextUtils.isEmpty(RE) || !RE.equalsIgnoreCase(str)) {
                        z = false;
                    } else {
                        z = true;
                    }
                    if (!TextUtils.isEmpty(obj) && obj.equalsIgnoreCase(QD)) {
                        z = true;
                    }
                    if (!TextUtils.isEmpty(obj) && obj.equalsIgnoreCase(str4)) {
                        z = true;
                    }
                } else {
                    x.e("MicroMsg.MsgHandler", "currentWrapper is null");
                    z = false;
                }
                str2 = "MicroMsg.MsgHandler";
                str3 = "getMusicPermission hasPermmision:%d";
                objArr = new Object[1];
                if (!z) {
                    i = 0;
                }
                objArr[0] = Integer.valueOf(i);
                x.i(str2, str3, objArr);
                return z;
            }
        }
        CharSequence RE2 = charSequence;
        str = (String) iVar.mcy.get(TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_URL);
        obj = null;
        if (bi.oW(str)) {
            obj = com.tencent.mm.plugin.webview.modelcache.p.QD(str);
        }
        if (Qa == null) {
            x.e("MicroMsg.MsgHandler", "currentWrapper is null");
            z = false;
        } else {
            str = Qa.jQb;
            String QD2 = com.tencent.mm.plugin.webview.modelcache.p.QD(Qa.rYr);
            String str42 = Qa.rYD;
            x.i("MicroMsg.MsgHandler", "app_id:%s, musicAppId:%s", new Object[]{RE2, str});
            x.i("MicroMsg.MsgHandler", "domain: %s, songWebDomain: %s, jsWebDomain: %s， with no port", new Object[]{obj, QD2, str42});
            if (TextUtils.isEmpty(RE2) || !RE2.equalsIgnoreCase(str)) {
                z = false;
            } else {
                z = true;
            }
            if (!TextUtils.isEmpty(obj) && obj.equalsIgnoreCase(QD2)) {
                z = true;
            }
            if (!TextUtils.isEmpty(obj) && obj.equalsIgnoreCase(str42)) {
                z = true;
            }
        }
        str2 = "MicroMsg.MsgHandler";
        str3 = "getMusicPermission hasPermmision:%d";
        objArr = new Object[1];
        if (z) {
            i = 0;
        }
        objArr[0] = Integer.valueOf(i);
        x.i(str2, str3, objArr);
        return z;
    }

    private boolean bW(i iVar) {
        String I = at.dBv.I("login_user_name", "");
        String str = (String) iVar.mcy.get("request_ticket");
        if (bi.oW(str)) {
            x.e("MicroMsg.MsgHandler", "requestVoiceLoginVerify, ticket is null");
            a(iVar, "requestVoiceLoginVerify:ticket is null", null);
        } else {
            Intent intent = new Intent();
            intent.putExtra("Kusername", I);
            intent.putExtra("Kvertify_key", str);
            if (this.context instanceof MMActivity) {
                ((MMActivity) this.context).geJ = this;
                com.tencent.mm.bg.d.b(this.context, "voiceprint", ".ui.VoiceLoginUI", intent, 57);
            }
        }
        return true;
    }

    private boolean bX(i iVar) {
        Map hashMap = new HashMap();
        try {
            String str = (String) iVar.mcy.get("next_step");
            x.i("MicroMsg.MsgHandler", "next_step: %s", new Object[]{str});
            Bundle bundle = new Bundle();
            if (!bi.oW(str)) {
                if ("auth_again".equals(str)) {
                    if (this.context != null && (this.context instanceof MMActivity)) {
                        if (((MMActivity) this.context).getIntent().hasExtra("VoiceLoginAuthPwd")) {
                            bundle.putString("VoiceLoginAuthPwd", ((MMActivity) this.context).getIntent().getStringExtra("VoiceLoginAuthPwd"));
                        }
                        bundle.putString("go_next", "auth_again");
                    }
                } else if ("get_reg_verify_code".equals(str)) {
                    bundle.putString("go_next", "get_reg_verify_code");
                }
            }
            this.pRY.bVn();
            this.pRY.P(bundle);
            com.tencent.mm.sdk.b.a.sFg.m(new tw());
            hashMap.put("err_code", Integer.valueOf(0));
            hashMap.put("err_msg", "ok");
            a(iVar, "close window and next:ok", hashMap);
        } catch (Exception e) {
            x.w("MicroMsg.MsgHandler", "doCloseWindow, ex = " + e.getMessage());
            hashMap.put("err_code", Integer.valueOf(1));
            hashMap.put("err_msg", "fail");
            a(iVar, "close window and next:fail", hashMap);
        }
        return true;
    }

    private boolean bY(i iVar) {
        String str = (String) iVar.mcy.get("username");
        if (bi.oW(str)) {
            a(iVar, "open_biz_chat:param_err", null);
        } else {
            au.HU();
            ab Yg = com.tencent.mm.model.c.FR().Yg(str);
            if (Yg == null || !Yg.ckW()) {
                a(iVar, "open_biz_chat:not biz username", null);
            } else if (com.tencent.mm.l.a.gd(Yg.field_type)) {
                Intent intent = new Intent();
                intent.putExtra("Chat_User", str);
                intent.putExtra("finish_direct", true);
                com.tencent.mm.bg.d.e(this.context, ".ui.chatting.ChattingUI", intent);
                a(iVar, "open_biz_chat:ok", null);
            } else {
                a(iVar, "open_biz_chat:unfollow", null);
            }
        }
        return true;
    }

    private boolean bZ(i iVar) {
        String str = (String) iVar.mcy.get(TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_URL);
        if (bi.oW(str)) {
            x.i("MicroMsg.MsgHandler", "doOpenGameUrlWithExtraWebView, url is null");
            a(iVar, "openGameUrlWithExtraWebView:fail", null);
        } else {
            String str2 = (String) iVar.mcy.get("statusBarColor");
            int i = 0;
            if (!bi.oW(str2)) {
                try {
                    i = Color.parseColor(str2);
                } catch (IllegalArgumentException e) {
                    x.e("MicroMsg.MsgHandler", "doOpenGameUrlWithExtraWebView: " + e.getMessage());
                    a(iVar, "openGameUrlWithExtraWebView:fail_invalid_color", null);
                }
            }
            str2 = (String) iVar.mcy.get("statusBarStyle");
            Intent intent = new Intent();
            intent.putExtra("rawUrl", str);
            intent.putExtra("customize_status_bar_color", i);
            intent.putExtra("status_bar_style", str2);
            com.tencent.mm.plugin.webview.ui.tools.d.a(intent.getExtras(), "webview", ".ui.tools.game.GameWebViewUI", this.pRY, new 25(this, intent));
            a(iVar, "openGameUrlWithExtraWebView:ok", null);
        }
        return true;
    }

    private boolean ca(i iVar) {
        String rL = rL(getCurrentUrl());
        if (bi.oW(rL)) {
            x.i("MicroMsg.MsgHandler", "appId is null");
            a(iVar, "setGameData:fail_appid_null", null);
        } else {
            String str = (String) iVar.mcy.get("key");
            String str2 = (String) iVar.mcy.get(DownloadSettingTable$Columns.VALUE);
            String str3 = (String) iVar.mcy.get("weight");
            String str4 = (String) iVar.mcy.get("expireTime");
            boolean z = bi.getBoolean((String) iVar.mcy.get("autoClean"), true);
            if (bi.oW(str) || bi.oW(str2)) {
                x.i("MicroMsg.MsgHandler", "key or value is null");
                a(iVar, "setGameData:fail_null_key", null);
            } else if (com.tencent.mm.plugin.webview.b.b.bTB().a(rL, str, str2, str3, str4, z)) {
                a(iVar, "setGameData:ok", null);
            } else {
                a(iVar, "setGameData:fail_exceed_size", null);
            }
        }
        return true;
    }

    private boolean cb(i iVar) {
        String rL = rL(getCurrentUrl());
        if (bi.oW(rL)) {
            x.i("MicroMsg.MsgHandler", "appId is null");
            a(iVar, "getGameData:fail", null);
        } else {
            String str = (String) iVar.mcy.get("key");
            if (bi.oW(str)) {
                x.i("MicroMsg.MsgHandler", "key is null");
                a(iVar, "getGameData:fail", null);
            } else {
                com.tencent.mm.plugin.webview.b.a fk = com.tencent.mm.plugin.webview.b.b.bTB().fk(rL, str);
                if (bi.oW(fk.field_value)) {
                    a(iVar, "getGameData:ok", null);
                } else {
                    Map hashMap = new HashMap();
                    hashMap.put(DownloadSettingTable$Columns.VALUE, fk.field_value);
                    hashMap.put("weight", fk.field_weight);
                    hashMap.put("expireTime", Long.valueOf(fk.field_expireTime - (System.currentTimeMillis() / 1000)));
                    a(iVar, "getGameData:ok", hashMap);
                }
            }
        }
        return true;
    }

    private boolean cc(i iVar) {
        String rL = rL(getCurrentUrl());
        if (bi.oW(rL)) {
            x.i("MicroMsg.MsgHandler", "appId is null");
            a(iVar, "clearData:fail", null);
        } else {
            String str = (String) iVar.mcy.get("keys");
            boolean z = bi.getBoolean((String) iVar.mcy.get("clearAllData"), false);
            if (!bi.oW(str)) {
                try {
                    com.tencent.mm.plugin.webview.b.b.bTB().b(rL, new JSONArray(str));
                    a(iVar, "clearGameData:ok", null);
                } catch (Exception e) {
                    x.e("MicroMsg.MsgHandler", "doClearData: " + e.getMessage());
                    a(iVar, "clearGameData:fail", null);
                }
            } else if (z) {
                com.tencent.mm.plugin.webview.b.b.bTB().Qc(rL);
                a(iVar, "clearGameData:ok", null);
            } else {
                x.i("MicroMsg.MsgHandler", "key is null");
                a(iVar, "clearGameData:fail", null);
            }
        }
        return true;
    }

    private boolean cd(i iVar) {
        this.iKs = false;
        a(iVar, "recordHistory:ok", null);
        if ((com.tencent.mm.au.b.Qu().edJ & 131072) == 131072) {
            String Dp = al.Dp((String) iVar.mcy.get(TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_URL));
            if (bi.oW(Dp)) {
                a(iVar, "recordHistory:fail", null);
            } else {
                boolean z;
                String str;
                String oV;
                int i = bi.getInt((String) iVar.mcy.get("webview_scene"), 0);
                if (i == 33 || i == 46) {
                    x.i("MicroMsg.MsgHandler", "hasRecordPermission false, getA8keyScene = " + i);
                    z = false;
                } else if (Dp.startsWith("http")) {
                    Uri parse = Uri.parse(Dp);
                    str = parse.getHost() + parse.getPath();
                    x.i("MicroMsg.MsgHandler", "hasRecordPermission, hostPath: " + str);
                    String string = com.tencent.mm.plugin.webview.model.z.a.bUf().getString("oauth_host_paths");
                    if (bi.oW(string)) {
                        string = "open.weixin.qq.com/connect/oauth2/authorize";
                    }
                    String[] split = string.split(";");
                    if (str.contains("weixin110.qq.com")) {
                        z = false;
                    } else if ("weixin110.qq.com;res.wx.qq.com;weops.qq.com;wx-credit-repay.tencent.com;chong.qq.com;qian.tenpay.com;payapp.weixin.qq.com;pay.weixin.qq.com;wx.tenpay.com".contains(parse.getHost().toLowerCase())) {
                        x.i("MicroMsg.MsgHandler", "forbidden host %s", new Object[]{parse.getHost()});
                        z = false;
                    } else {
                        for (String oV2 : split) {
                            if (str.equalsIgnoreCase(oV2)) {
                                z = false;
                                break;
                            }
                        }
                        z = true;
                    }
                } else {
                    z = false;
                }
                if (z) {
                    oV2 = bi.oV((String) iVar.mcy.get("title"));
                    str = bi.oV((String) iVar.mcy.get("source"));
                    String oV3 = bi.oV((String) iVar.mcy.get("img_url"));
                    x.i("MicroMsg.MsgHandler", "doRecordHistory link %s,title %s,source %s,imgUrl %s", new Object[]{Dp, oV2, str, oV3});
                    com.tencent.mm.plugin.webview.b.e bVb = com.tencent.mm.plugin.webview.modeltools.e.bVb();
                    com.tencent.mm.plugin.webview.b.d dVar = new com.tencent.mm.plugin.webview.b.d();
                    dVar.field_link = Dp;
                    if (!bVb.b(dVar, new String[]{"link"})) {
                        dVar = null;
                    }
                    if (dVar != null) {
                        x.i("MicroMsg.MsgHandler", "doRecordHistory update");
                        dVar.field_link = Dp;
                        dVar.field_title = oV2;
                        dVar.field_source = str;
                        dVar.field_imgUrl = oV3;
                        dVar.field_timeStamp = System.currentTimeMillis() / 1000;
                        com.tencent.mm.plugin.webview.modeltools.e.bVb().c(dVar, new String[0]);
                    } else {
                        x.i("MicroMsg.MsgHandler", "doRecordHistory insert");
                        com.tencent.mm.plugin.webview.b.e bVb2 = com.tencent.mm.plugin.webview.modeltools.e.bVb();
                        com.tencent.mm.plugin.webview.b.d dVar2 = new com.tencent.mm.plugin.webview.b.d();
                        dVar2.field_link = Dp;
                        dVar2.field_title = oV2;
                        dVar2.field_source = str;
                        dVar2.field_imgUrl = oV3;
                        dVar2.field_timeStamp = System.currentTimeMillis() / 1000;
                        dVar2.field_recordId = Dp.hashCode() + "_" + System.currentTimeMillis();
                        x.i("MicroMsg.WebViewHistoryStorage", "insert: " + bVb2.b(dVar2));
                        com.tencent.mm.bu.a.post(new e$1(bVb2));
                    }
                    a(iVar, "recordHistory:ok", null);
                } else {
                    a(iVar, "recordHistory:fail", null);
                }
            }
        } else {
            x.i("MicroMsg.MsgHandler", "doRecordHistory switch close");
        }
        return true;
    }

    private boolean ce(i iVar) {
        Map hashMap = new HashMap();
        hashMap.put("osVersion", Integer.valueOf(VERSION.SDK_INT));
        hashMap.put("cpuCores", Integer.valueOf(com.b.a.a.a.in()));
        hashMap.put("cpuFreqHz", Integer.valueOf(com.b.a.a.a.io()));
        hashMap.put("memory", Long.valueOf(com.b.a.a.a.U(ad.getContext())));
        hashMap.put("brand", Build.BRAND);
        hashMap.put("model", Build.MODEL);
        a(iVar, "getSystemInfo:ok", hashMap);
        return true;
    }

    private boolean cf(i iVar) {
        try {
            x.i("MicroMsg.MsgHandler", "doServiceClick, tid = %s", new Object[]{(String) iVar.mcy.get("tid")});
            Bundle bundle = new Bundle();
            bundle.putString("service_click_tid", r0);
            this.pRY.c(70, bundle);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.MsgHandler", e, "", new Object[0]);
        }
        this.iKs = false;
        return false;
    }

    private boolean cg(i iVar) {
        String rL = rL(getCurrentUrl());
        if (bi.oW(rL)) {
            x.e("MicroMsg.MsgHandler", "[doOpenRealnameAuth]appid is null, return");
            a(iVar, "openRealnameAuth:fail appid is null", null);
            return false;
        }
        String str = (String) iVar.mcy.get("categoryId");
        if (bi.oW(str)) {
            x.e("MicroMsg.MsgHandler", "[doOpenRealnameAuth]categoryId is null, return");
            a(iVar, "openRealnameAuth:fail categoryId is null", null);
            return false;
        }
        Intent putExtra = new Intent().putExtra("intent_appid", rL).putExtra("intent_category_id", str);
        if (this.context instanceof MMActivity) {
            ((MMActivity) this.context).geJ = this;
            com.tencent.mm.bg.d.b(this.context, "appbrand", ".ui.autofill.AppBrandIDCardUI", putExtra, 62);
            return true;
        }
        x.e("MicroMsg.MsgHandler", "[doOpenRealnameAuth]context is err, return");
        a(iVar, "openRealnameAuth:fail context is err", null);
        return false;
    }

    private boolean ch(i iVar) {
        this.bSg = f(iVar);
        if (this.bSg == null) {
            x.e("MicroMsg.MsgHandler", "doSendSingleAppMessage fail, appmsg is null");
            a(iVar, "sendSingleAppMessage:fail", null);
            return true;
        }
        Serializable hashMap = new HashMap();
        String str = (String) iVar.mcy.get("img_url");
        hashMap.put("img_url", str);
        hashMap.put("desc", (String) iVar.mcy.get("desc"));
        hashMap.put("title", (String) iVar.mcy.get("title"));
        hashMap.put(TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_URL, (String) iVar.mcy.get("link"));
        Intent intent = new Intent();
        intent.putExtra("Select_Conv_Type", 7);
        intent.putExtra("select_is_ret", true);
        intent.putExtra("Select_block_List", q.GF());
        intent.putExtra("Select_block_List", "filehelper," + q.GF());
        intent.putExtra("scene_from", 10);
        intent.putExtra("webview_params", hashMap);
        intent.putExtra("Retr_Msg_Type", 2);
        if (this.context instanceof MMActivity) {
            com.tencent.mm.bg.d.a((MMActivity) this.context, ".ui.transmit.SelectConversationUI", intent, 61, this);
            k.RQ(str);
            return true;
        }
        x.e("MicroMsg.MsgHandler", "doSendSingleAppMessage context is not activity");
        return false;
    }

    private boolean ci(i iVar) {
        String str = (String) iVar.mcy.get("brandName");
        x.i("MicroMsg.MsgHandler", "doCurrentMpInfo brandIcon:%s", new Object[]{(String) iVar.mcy.get("brandIcon")});
        try {
            Bundle bundle = new Bundle();
            bundle.putString("key_bag_icon", r0);
            bundle.putString("key_brand_name", str);
            this.pRY.c(71, bundle);
            a(iVar, "currentMpInfo:ok", null);
        } catch (Exception e) {
            a(iVar, "currentMpInfo:fail", null);
        }
        return true;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean cj(com.tencent.mm.plugin.webview.ui.tools.jsapi.i r12) {
        /*
        r11 = this;
        r8 = 6;
        r7 = 2;
        r10 = 0;
        r6 = 0;
        r5 = 1;
        r0 = r12.mcy;
        r1 = "opcode";
        r0 = r0.get(r1);
        r0 = (java.lang.String) r0;
        r1 = r12.mcy;
        r2 = "business";
        r1 = r1.get(r2);
        r1 = (java.lang.String) r1;
        r2 = "MicroMsg.MsgHandler";
        r3 = "business %s,opcode %s";
        r4 = new java.lang.Object[r7];
        r4[r6] = r1;
        r4[r5] = r0;
        com.tencent.mm.sdk.platformtools.x.i(r2, r3, r4);
        r2 = new java.lang.String[r7];
        r2[r6] = r0;
        r2[r5] = r1;
        r2 = com.tencent.mm.sdk.platformtools.bi.G(r2);
        if (r2 != 0) goto L_0x008d;
    L_0x0036:
        r2 = "regLogin";
        r2 = r1.equals(r2);
        if (r2 == 0) goto L_0x0262;
    L_0x003f:
        r1 = "setIsAgree";
        r1 = r0.equals(r1);
        if (r1 == 0) goto L_0x00aa;
    L_0x0048:
        r1 = new android.os.Bundle;	 Catch:{ Exception -> 0x008e }
        r1.<init>();	 Catch:{ Exception -> 0x008e }
        r0 = r12.mcy;	 Catch:{ Exception -> 0x008e }
        r2 = "isAgree";
        r0 = r0.get(r2);	 Catch:{ Exception -> 0x008e }
        r0 = (java.lang.String) r0;	 Catch:{ Exception -> 0x008e }
        r2 = 0;
        r0 = com.tencent.mm.sdk.platformtools.bi.getInt(r0, r2);	 Catch:{ Exception -> 0x008e }
        r2 = r11.context;	 Catch:{ Exception -> 0x008e }
        if (r2 == 0) goto L_0x0072;
    L_0x0061:
        r2 = r11.context;	 Catch:{ Exception -> 0x008e }
        r2 = r2 instanceof com.tencent.mm.ui.MMActivity;	 Catch:{ Exception -> 0x008e }
        if (r2 == 0) goto L_0x0072;
    L_0x0067:
        if (r0 != r5) goto L_0x0072;
    L_0x0069:
        r0 = "go_next";
        r2 = "agree_privacy";
        r1.putString(r0, r2);	 Catch:{ Exception -> 0x008e }
    L_0x0072:
        r0 = r11.pRY;	 Catch:{ Exception -> 0x008e }
        r0.bVn();	 Catch:{ Exception -> 0x008e }
        r0 = r11.pRY;	 Catch:{ Exception -> 0x008e }
        r0.P(r1);	 Catch:{ Exception -> 0x008e }
        r0 = com.tencent.mm.sdk.b.a.sFg;	 Catch:{ Exception -> 0x008e }
        r1 = new com.tencent.mm.g.a.tw;	 Catch:{ Exception -> 0x008e }
        r1.<init>();	 Catch:{ Exception -> 0x008e }
        r0.m(r1);	 Catch:{ Exception -> 0x008e }
        r0 = "set wc privacy policy result:ok";
        r1 = 0;
        r11.a(r12, r0, r1);	 Catch:{ Exception -> 0x008e }
    L_0x008d:
        return r5;
    L_0x008e:
        r0 = move-exception;
        r1 = "MicroMsg.MsgHandler";
        r2 = new java.lang.StringBuilder;
        r3 = "setWcPrivacyPolicyResult, ex = ";
        r2.<init>(r3);
        r0 = r0.getMessage();
        r0 = r2.append(r0);
        r0 = r0.toString();
        com.tencent.mm.sdk.platformtools.x.w(r1, r0);
        goto L_0x008d;
    L_0x00aa:
        r1 = "setBirthday";
        r1 = r0.equals(r1);
        if (r1 == 0) goto L_0x012e;
    L_0x00b3:
        r0 = r12.mcy;
        r1 = "birthday";
        r0 = r0.get(r1);
        r0 = (java.lang.String) r0;
        r1 = r12.mcy;
        r2 = "mobile";
        r1 = r1.get(r2);
        r1 = (java.lang.String) r1;
        r2 = "MicroMsg.MsgHandler";
        r3 = "mobile %s,birthday %s";
        r4 = new java.lang.Object[r7];
        r4[r6] = r1;
        r4[r5] = r0;
        com.tencent.mm.sdk.platformtools.x.i(r2, r3, r4);
        r2 = com.tencent.mm.sdk.platformtools.bi.oW(r1);
        if (r2 == 0) goto L_0x00f9;
    L_0x00de:
        r2 = com.tencent.mm.kernel.g.Eg();
        r2 = r2.Dx();
        if (r2 == 0) goto L_0x00f9;
    L_0x00e8:
        com.tencent.mm.kernel.g.Ek();
        r1 = com.tencent.mm.kernel.g.Ei();
        r1 = r1.DT();
        r1 = r1.get(r8, r10);
        r1 = (java.lang.String) r1;
    L_0x00f9:
        r2 = new java.lang.String[r7];
        r2[r6] = r1;
        r2[r5] = r0;
        r2 = com.tencent.mm.sdk.platformtools.bi.G(r2);
        if (r2 != 0) goto L_0x0126;
    L_0x0105:
        r2 = new java.util.HashMap;
        r2.<init>();
        r3 = "birthday";
        r2.put(r3, r0);
        r0 = "last_update_birthday_time";
        r6 = java.lang.System.currentTimeMillis();
        r8 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r6 = r6 / r8;
        r3 = java.lang.Long.valueOf(r6);
        r2.put(r0, r3);
        r0 = com.tencent.mm.model.bk.dDa;
        r0.d(r1, r2);
    L_0x0126:
        r0 = "setBirthday OK";
        r11.a(r12, r0, r10);
        goto L_0x008d;
    L_0x012e:
        r1 = "getBirthday";
        r1 = r0.equals(r1);
        if (r1 == 0) goto L_0x01c0;
    L_0x0137:
        r7 = new java.util.HashMap;
        r7.<init>();
        r0 = r12.mcy;
        r1 = "mobile";
        r0 = r0.get(r1);
        r0 = (java.lang.String) r0;
        r1 = "MicroMsg.MsgHandler";
        r2 = "getBirthday of %s";
        r3 = new java.lang.Object[r5];
        r3[r6] = r0;
        com.tencent.mm.sdk.platformtools.x.i(r1, r2, r3);
        r4 = "";
        r2 = 0;
        r1 = com.tencent.mm.sdk.platformtools.bi.oW(r0);
        if (r1 == 0) goto L_0x017a;
    L_0x015f:
        r1 = com.tencent.mm.kernel.g.Eg();
        r1 = r1.Dx();
        if (r1 == 0) goto L_0x017a;
    L_0x0169:
        com.tencent.mm.kernel.g.Ek();
        r0 = com.tencent.mm.kernel.g.Ei();
        r0 = r0.DT();
        r0 = r0.get(r8, r10);
        r0 = (java.lang.String) r0;
    L_0x017a:
        r1 = com.tencent.mm.sdk.platformtools.bi.oW(r0);
        if (r1 != 0) goto L_0x0323;
    L_0x0180:
        r1 = com.tencent.mm.model.bk.dDa;
        r2 = "birthday";
        r2 = r1.getString(r0, r2);
        r1 = com.tencent.mm.model.bk.dDa;
        r3 = "last_update_birthday_time";
        r0 = r1.getString(r0, r3);
        r0 = com.tencent.mm.sdk.platformtools.bi.WV(r0);
        r4 = r2;
    L_0x0197:
        r2 = "MicroMsg.MsgHandler";
        r3 = "updateTime %s";
        r8 = new java.lang.Object[r5];
        r9 = java.lang.Long.valueOf(r0);
        r8[r6] = r9;
        com.tencent.mm.sdk.platformtools.x.i(r2, r3, r8);
        r2 = "birthday";
        r7.put(r2, r4);
        r2 = "updatetime";
        r0 = java.lang.Long.valueOf(r0);
        r7.put(r2, r0);
        r0 = "getBirthday OK";
        r11.a(r12, r0, r7);
        goto L_0x008d;
    L_0x01c0:
        r1 = "birthdayComfirmOK";
        r1 = r0.equals(r1);
        if (r1 == 0) goto L_0x0211;
    L_0x01c9:
        r0 = new android.os.Bundle;	 Catch:{ Exception -> 0x01f4 }
        r0.<init>();	 Catch:{ Exception -> 0x01f4 }
        r1 = "go_next";
        r2 = "birthdayComfirmOK";
        r0.putString(r1, r2);	 Catch:{ Exception -> 0x01f4 }
        r1 = r11.pRY;	 Catch:{ Exception -> 0x01f4 }
        r1.bVn();	 Catch:{ Exception -> 0x01f4 }
        r1 = r11.pRY;	 Catch:{ Exception -> 0x01f4 }
        r1.P(r0);	 Catch:{ Exception -> 0x01f4 }
        r0 = com.tencent.mm.sdk.b.a.sFg;	 Catch:{ Exception -> 0x01f4 }
        r1 = new com.tencent.mm.g.a.tw;	 Catch:{ Exception -> 0x01f4 }
        r1.<init>();	 Catch:{ Exception -> 0x01f4 }
        r0.m(r1);	 Catch:{ Exception -> 0x01f4 }
        r0 = "birthdayConfirmOK";
        r1 = 0;
        r11.a(r12, r0, r1);	 Catch:{ Exception -> 0x01f4 }
        goto L_0x008d;
    L_0x01f4:
        r0 = move-exception;
        r1 = "MicroMsg.MsgHandler";
        r2 = new java.lang.StringBuilder;
        r3 = "setWcPrivacyPolicyResult, ex = ";
        r2.<init>(r3);
        r0 = r0.getMessage();
        r0 = r2.append(r0);
        r0 = r0.toString();
        com.tencent.mm.sdk.platformtools.x.w(r1, r0);
        goto L_0x008d;
    L_0x0211:
        r1 = "continue";
        r0 = r0.equals(r1);
        if (r0 == 0) goto L_0x008d;
    L_0x021a:
        r0 = new android.os.Bundle;	 Catch:{ Exception -> 0x0245 }
        r0.<init>();	 Catch:{ Exception -> 0x0245 }
        r1 = "go_next";
        r2 = "gdpr_confirm_continue";
        r0.putString(r1, r2);	 Catch:{ Exception -> 0x0245 }
        r1 = r11.pRY;	 Catch:{ Exception -> 0x0245 }
        r1.bVn();	 Catch:{ Exception -> 0x0245 }
        r1 = r11.pRY;	 Catch:{ Exception -> 0x0245 }
        r1.P(r0);	 Catch:{ Exception -> 0x0245 }
        r0 = com.tencent.mm.sdk.b.a.sFg;	 Catch:{ Exception -> 0x0245 }
        r1 = new com.tencent.mm.g.a.tw;	 Catch:{ Exception -> 0x0245 }
        r1.<init>();	 Catch:{ Exception -> 0x0245 }
        r0.m(r1);	 Catch:{ Exception -> 0x0245 }
        r0 = "h5 confirm continue OK";
        r1 = 0;
        r11.a(r12, r0, r1);	 Catch:{ Exception -> 0x0245 }
        goto L_0x008d;
    L_0x0245:
        r0 = move-exception;
        r1 = "MicroMsg.MsgHandler";
        r2 = new java.lang.StringBuilder;
        r3 = "setWcPrivacyPolicyResult, ex = ";
        r2.<init>(r3);
        r0 = r0.getMessage();
        r0 = r2.append(r0);
        r0 = r0.toString();
        com.tencent.mm.sdk.platformtools.x.w(r1, r0);
        goto L_0x008d;
    L_0x0262:
        r2 = com.tencent.mm.model.gdpr.a.iX(r1);
        if (r2 == 0) goto L_0x02ae;
    L_0x0268:
        r1 = "setIsAgree";
        r0 = r1.equals(r0);
        if (r0 == 0) goto L_0x0295;
    L_0x0271:
        r0 = r12.mcy;
        r1 = "isAgree";
        r0 = r0.get(r1);
        r0 = (java.lang.String) r0;
        r0 = com.tencent.mm.sdk.platformtools.bi.getInt(r0, r6);
        if (r0 != r5) goto L_0x029d;
    L_0x0282:
        r0 = r5;
    L_0x0283:
        r1 = new android.os.Bundle;
        r1.<init>(r5);
        r2 = "OnMPGdprPolicyAgreement_KIsAgree";
        r1.putBoolean(r2, r0);
        r0 = r11.pRY;	 Catch:{ Exception -> 0x029f }
        r2 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        r0.c(r2, r1);	 Catch:{ Exception -> 0x029f }
    L_0x0295:
        r0 = "wcPrivacyPolicyResult:ok";
        r11.a(r12, r0, r10);
        goto L_0x008d;
    L_0x029d:
        r0 = r6;
        goto L_0x0283;
    L_0x029f:
        r0 = move-exception;
        r1 = "MicroMsg.MsgHandler";
        r2 = "wcPrivacyPolicyResult, [mp_gdpr], callback ex = %s";
        r3 = new java.lang.Object[r5];
        r3[r6] = r0;
        com.tencent.mm.sdk.platformtools.x.e(r1, r2, r3);
        goto L_0x0295;
    L_0x02ae:
        r2 = "search";
        r1 = r1.equals(r2);
        if (r1 == 0) goto L_0x008d;
    L_0x02b7:
        r1 = -1;
        r2 = r0.hashCode();
        switch(r2) {
            case 158651840: goto L_0x02fe;
            case 334239890: goto L_0x02f4;
            default: goto L_0x02bf;
        };
    L_0x02bf:
        r6 = r1;
    L_0x02c0:
        switch(r6) {
            case 0: goto L_0x0309;
            case 1: goto L_0x0315;
            default: goto L_0x02c3;
        };
    L_0x02c3:
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r1 = r12.qkl;
        r0 = r0.append(r1);
        r1 = ":ok";
        r0 = r0.append(r1);
        r0 = r0.toString();
        r11.a(r12, r0, r10);
        r0 = r11.pRY;	 Catch:{ Exception -> 0x0321 }
        r1 = 0;
        r0.P(r1);	 Catch:{ Exception -> 0x0321 }
    L_0x02e2:
        r0 = com.tencent.mm.sdk.b.a.sFg;
        r1 = new com.tencent.mm.g.a.tw;
        r1.<init>();
        r0.m(r1);
        r0 = "wcPrivacyPolicyResult:ok";
        r11.a(r12, r0, r10);
        goto L_0x008d;
    L_0x02f4:
        r2 = "openSearch";
        r0 = r0.equals(r2);
        if (r0 == 0) goto L_0x02bf;
    L_0x02fd:
        goto L_0x02c0;
    L_0x02fe:
        r2 = "closeSearch";
        r0 = r0.equals(r2);
        if (r0 == 0) goto L_0x02bf;
    L_0x0307:
        r6 = r5;
        goto L_0x02c0;
    L_0x0309:
        r0 = com.tencent.mm.plugin.websearch.api.i.class;
        r0 = com.tencent.mm.kernel.g.l(r0);
        r0 = (com.tencent.mm.plugin.websearch.api.i) r0;
        r0.bSG();
        goto L_0x02c3;
    L_0x0315:
        r0 = com.tencent.mm.plugin.websearch.api.i.class;
        r0 = com.tencent.mm.kernel.g.l(r0);
        r0 = (com.tencent.mm.plugin.websearch.api.i) r0;
        r0.bSH();
        goto L_0x02c3;
    L_0x0321:
        r0 = move-exception;
        goto L_0x02e2;
    L_0x0323:
        r0 = r2;
        goto L_0x0197;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.webview.ui.tools.jsapi.g.cj(com.tencent.mm.plugin.webview.ui.tools.jsapi.i):boolean");
    }
}

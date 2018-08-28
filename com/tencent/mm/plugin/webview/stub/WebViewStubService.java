package com.tencent.mm.plugin.webview.stub;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.util.SparseArray;
import com.tencent.mm.ab.e;
import com.tencent.mm.g.c.ai;
import com.tencent.mm.model.au;
import com.tencent.mm.modelsimple.u;
import com.tencent.mm.network.n;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.plugin.downloader.model.b;
import com.tencent.mm.plugin.downloader.model.l;
import com.tencent.mm.plugin.messenger.a.f;
import com.tencent.mm.plugin.webview.model.al;
import com.tencent.mm.plugin.webview.model.d;
import com.tencent.mm.plugin.webview.model.k;
import com.tencent.mm.plugin.webview.model.s;
import com.tencent.mm.plugin.webview.model.t;
import com.tencent.mm.plugin.webview.model.z;
import com.tencent.mm.plugin.webview.modelcache.q;
import com.tencent.mm.plugin.webview.stub.d.a;
import com.tencent.mm.plugin.webview.ui.tools.WebViewStubCallbackWrapper;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.h;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.c.ahb;
import com.tencent.mm.protocal.c.amu;
import com.tencent.mm.protocal.c.awk;
import com.tencent.mm.protocal.c.awm;
import com.tencent.mm.protocal.c.bja;
import com.tencent.mm.protocal.c.g;
import com.tencent.mm.protocal.c.yl;
import com.tencent.mm.protocal.c.yo;
import com.tencent.mm.protocal.c.yp;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WebViewStubService extends Service implements e {
    private List<WebViewStubCallbackWrapper> bPa = new ArrayList();
    private c dlW = new 2(this);
    private ag handler;
    private Map<String, Integer> jIg;
    private n jkm;
    private final SparseArray<Bundle> pUK = new SparseArray();
    private a pUL = new 1(this);
    private int pUM = 0;
    private l pUN;
    private d.a pUO;
    private Set<Integer> pUP = new HashSet();
    private int pUQ = -1;

    static /* synthetic */ boolean QN(String str) {
        if (str == null) {
            x.e("MicroMsg.WebViewStubService", "doInActivity fail, function null");
        } else {
            g Ux = com.tencent.mm.protocal.c.Ux(str);
            if (Ux == null) {
                x.e("MicroMsg.WebViewStubService", "doInActivity fail, func null, %s", str);
            } else if (Ux.cfZ()) {
                return true;
            }
        }
        return false;
    }

    static /* synthetic */ boolean R(Bundle bundle) {
        com.tencent.mm.ab.l uVar = new u(bundle.getString("emoji_store_jump_url"));
        uVar.tag = Integer.valueOf(bundle.getInt("webview_binder_id"));
        return au.DF().a(uVar, 0);
    }

    static /* synthetic */ boolean a(WebViewStubService webViewStubService, String str, String str2, String str3, JsapiPermissionWrapper jsapiPermissionWrapper, Bundle bundle, int i) {
        WebViewStubCallbackWrapper webViewStubCallbackWrapper = null;
        for (WebViewStubCallbackWrapper webViewStubCallbackWrapper2 : webViewStubService.bPa) {
            WebViewStubCallbackWrapper webViewStubCallbackWrapper22;
            if (webViewStubCallbackWrapper22 == null || webViewStubCallbackWrapper22.id != i) {
                webViewStubCallbackWrapper22 = webViewStubCallbackWrapper;
            }
            webViewStubCallbackWrapper = webViewStubCallbackWrapper22;
        }
        if (webViewStubCallbackWrapper == null || webViewStubCallbackWrapper.pXx == null) {
            return false;
        }
        h.Bh(i).bXZ();
        Intent intent = new Intent(webViewStubService, WebViewStubProxyUI.class);
        intent.putExtras(bundle);
        intent.putExtra("proxyui_action_code_key", 1);
        intent.putExtra("proxyui_type_key", str);
        intent.putExtra("proxyui_function_key", str2);
        intent.putExtra("proxyui_callback_key", str3);
        intent.putExtra("webview_stub_callbacker_key", webViewStubCallbackWrapper);
        intent.putExtra("proxyui_perm_key", jsapiPermissionWrapper);
        intent.putExtra("webview_binder_id", i);
        intent.putExtra("screen_orientation", webViewStubService.pUQ);
        intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        return com.tencent.mm.plugin.webview.ui.tools.d.a(intent.getExtras(), "webview", ".stub.WebViewStubProxyUI", webViewStubCallbackWrapper.pXx, new 6(webViewStubService, intent));
    }

    public void onCreate() {
        super.onCreate();
        x.i("MicroMsg.WebViewStubService", "WebViewStubService onCreate");
        this.handler = new ag();
        this.pUN = new l() {
            public final void onTaskStarted(long j, String str) {
            }

            public final void b(long j, String str, boolean z) {
                x.i("MicroMsg.WebViewUI.IFileDownloadCallback", "onTaskFinished, downloadId = " + j);
                try {
                    for (WebViewStubCallbackWrapper webViewStubCallbackWrapper : WebViewStubService.this.bPa) {
                        Bundle bundle = new Bundle();
                        bundle.putLong("download_manager_downloadid", j);
                        com.tencent.mm.plugin.downloader.c.a cs = com.tencent.mm.plugin.downloader.model.c.cs(j);
                        bundle.putCharSequence("download_manager_appid", cs != null ? cs.field_appId : "");
                        webViewStubCallbackWrapper.pXx.c(1002, bundle);
                    }
                } catch (Exception e) {
                    x.w("MicroMsg.WebViewUI.IFileDownloadCallback", "onTaskFinished, ex = " + e.getMessage());
                }
            }

            public final void b(long j, int i, boolean z) {
                x.i("MicroMsg.WebViewUI.IFileDownloadCallback", "onTaskFailed, downloadId = " + j);
                try {
                    for (WebViewStubCallbackWrapper webViewStubCallbackWrapper : WebViewStubService.this.bPa) {
                        Bundle bundle = new Bundle();
                        bundle.putLong("download_manager_downloadid", j);
                        com.tencent.mm.plugin.downloader.c.a cs = com.tencent.mm.plugin.downloader.model.c.cs(j);
                        bundle.putCharSequence("download_manager_appid", cs != null ? cs.field_appId : "");
                        bundle.putInt("download_manager_errcode", i);
                        webViewStubCallbackWrapper.pXx.c(1003, bundle);
                    }
                } catch (Exception e) {
                    x.w("MicroMsg.WebViewUI.IFileDownloadCallback", "onTaskFailed, ex = " + e.getMessage());
                }
            }

            public final void onTaskRemoved(long j) {
                x.i("MicroMsg.WebViewUI.IFileDownloadCallback", "onTaskRemoved, downloadId = " + j);
                try {
                    for (WebViewStubCallbackWrapper webViewStubCallbackWrapper : WebViewStubService.this.bPa) {
                        Bundle bundle = new Bundle();
                        bundle.putLong("download_manager_downloadid", j);
                        com.tencent.mm.plugin.downloader.c.a cs = com.tencent.mm.plugin.downloader.model.c.cs(j);
                        bundle.putCharSequence("download_manager_appid", cs != null ? cs.field_appId : "");
                        webViewStubCallbackWrapper.pXx.c(1008, bundle);
                    }
                } catch (Exception e) {
                    x.w("MicroMsg.WebViewUI.IFileDownloadCallback", "onTaskRemoved, ex = " + e.getMessage());
                }
            }

            public final void onTaskPaused(long j) {
            }

            public final void bP(long j) {
                try {
                    for (WebViewStubCallbackWrapper webViewStubCallbackWrapper : WebViewStubService.this.bPa) {
                        com.tencent.mm.plugin.downloader.c.a cs = com.tencent.mm.plugin.downloader.model.c.cs(j);
                        if (cs == null || cs.field_totalSize == 0) {
                            x.w("MicroMsg.WebViewUI.IFileDownloadCallback", "loadDownloadProgress failed, downloadId = " + j);
                            return;
                        }
                        int i = (int) ((((double) cs.field_downloadedSize) / ((double) cs.field_totalSize)) * 100.0d);
                        Bundle bundle = new Bundle();
                        bundle.putLong("download_manager_downloadid", j);
                        bundle.putInt("download_manager_progress", i);
                        bundle.putString("download_manager_appid", cs.field_appId);
                        webViewStubCallbackWrapper.pXx.c(1007, bundle);
                    }
                } catch (Exception e) {
                    x.w("MicroMsg.WebViewUI.IFileDownloadCallback", "onTaskProgressChanged, ex = " + e.getMessage());
                }
            }

            public final void h(long j, String str) {
            }
        };
        com.tencent.mm.plugin.downloader.model.d.aCU();
        b.a(this.pUN);
        this.pUO = new 4(this);
        this.jkm = new 5(this);
        au.a(this.jkm);
        if (au.HX()) {
            com.tencent.mm.plugin.webview.modeltools.e.bUW().a(this.pUO);
        }
    }

    public IBinder onBind(Intent intent) {
        x.i("MicroMsg.WebViewStubService", "WebViewStubService onBind");
        return this.pUL;
    }

    public boolean onUnbind(Intent intent) {
        x.i("MicroMsg.WebViewStubService", "WebViewStubService onUnbind");
        h.detach();
        al.clear();
        q.a.bUL().release(false);
        return super.onUnbind(intent);
    }

    public void onDestroy() {
        x.i("MicroMsg.WebViewStubService", "WebViewStubService onDestroy");
        super.onDestroy();
        com.tencent.mm.plugin.downloader.model.d.aCU();
        b.b(this.pUN);
        if (au.HX()) {
            com.tencent.mm.plugin.webview.modeltools.e.bUW().b(this.pUO);
        }
        au.b(this.jkm);
        this.jkm = null;
        this.pUN = null;
        this.bPa.clear();
    }

    public final void a(int i, int i2, String str, com.tencent.mm.ab.l lVar) {
        int type = lVar.getType();
        x.i("MicroMsg.WebViewStubService", "onSceneEnd :[%d], errCode = %d, errType = %d, errMsg = %s", Integer.valueOf(type), Integer.valueOf(i2), Integer.valueOf(i), str);
        String a;
        Bundle bundle;
        int i3;
        String str2;
        b bVar;
        if (type == 106) {
            au.DF().b(106, (e) this);
            if (i == 0 && i2 == 0) {
                bja bcS = ((f) lVar).bcS();
                a = ab.a(bcS.rvi);
                com.tencent.mm.aa.q.Kp().g(a, ab.a(bcS.rcn));
                Intent intent = new Intent();
                com.tencent.mm.pluginsdk.ui.tools.c.a(intent, bcS, 30);
                if (bi.oV(a).length() > 0) {
                    au.HU();
                    ai Yg = com.tencent.mm.model.c.FR().Yg(a);
                    if (!(Yg == null || com.tencent.mm.l.a.gd(Yg.field_type))) {
                        intent.putExtra("Contact_IsLBSFriend", true);
                    }
                    if ((bcS.rTe & 8) > 0) {
                        com.tencent.mm.plugin.report.service.h.mEJ.k(10298, a + ",30");
                    }
                    intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                    com.tencent.mm.plugin.webview.a.a.ezn.d(intent, this);
                    bundle = new Bundle();
                    bundle.putString("search_contact_result_user", a);
                    try {
                        for (WebViewStubCallbackWrapper webViewStubCallbackWrapper : this.bPa) {
                            b bVar2 = new b();
                            bVar2.type = type;
                            bVar2.errType = i;
                            bVar2.errCode = i2;
                            bVar2.Yy = str;
                            bVar2.jfZ = bundle;
                            bVar2.jfZ.putInt("scene_end_listener_hash_code", webViewStubCallbackWrapper.id);
                            webViewStubCallbackWrapper.pXx.a(bVar2);
                        }
                        return;
                    } catch (Exception e) {
                        x.e("MicroMsg.WebViewStubService", "onSceneEnd searchcontact fail, ex = " + e.getMessage());
                        return;
                    }
                }
                return;
            }
            x.e("MicroMsg.WebViewStubService", "onSceneEnd, sendcard errType = " + i + ", errCode = " + i2);
        } else if (type == 233) {
            com.tencent.mm.modelsimple.h hVar = (com.tencent.mm.modelsimple.h) lVar;
            bundle = new Bundle();
            byte[] QO = hVar.QO();
            if (QO == null || QO.length <= 0) {
                x.e("MicroMsg.WebViewStubService", "getA8Key controlBytes is null");
            }
            a = "geta8key_result_jsapi_perm_control_bytes";
            if (QO == null) {
                QO = null;
            }
            bundle.putByteArray(a, QO);
            yl ylVar = ((yp) hVar.diG.dIE.dIL).rEF;
            bundle.putInt("geta8key_result_general_ctrl_b1", ylVar == null ? 0 : ylVar.rEl);
            bundle.putInt("geta8key_result_reason", ((yo) hVar.diG.dID.dIL).rEv);
            bundle.putString("geta8key_result_req_url", hVar.QM());
            bundle.putString("geta8key_result_full_url", hVar.QL());
            bundle.putString("geta8key_result_title", hVar.getTitle());
            bundle.putInt("geta8key_result_action_code", hVar.QN());
            bundle.putString("geta8key_result_content", hVar.getContent());
            bundle.putString("geta8key_result_head_img", ((yp) hVar.diG.dIE.dIL).rEO);
            bundle.putString("geta8key_result_wording", ((yp) hVar.diG.dIE.dIL).ksB);
            bundle.putLong("geta8key_result_deep_link_bit_set", hVar.QQ());
            bundle.putString("geta8key_data_username", ((yp) hVar.diG.dIE.dIL).hbL);
            bundle.putByteArray("geta8key_result_cookie", hVar.QT());
            bundle.putString("geta8key_result_menu_wording", ((yp) hVar.diG.dIE.dIL).rEP);
            x.d("MicroMsg.WebViewStubService", "getA8KeyCookie:%s", bi.bE(hVar.QT()));
            List<amu> QR = hVar.QR();
            if (!bi.cX(QR)) {
                amu amu;
                Object obj;
                for (amu amu2 : QR) {
                    if (amu2 != null && !bi.oW(amu2.riD)) {
                        if (bi.oW(amu2.mEl)) {
                            x.e("MicroMsg.WebViewStubService", "http header has null value");
                            obj = 1;
                            break;
                        }
                    }
                    x.e("MicroMsg.WebViewStubService", "http header has null value");
                    obj = 1;
                    break;
                }
                obj = null;
                if (obj == null) {
                    String[] strArr = new String[QR.size()];
                    String[] strArr2 = new String[QR.size()];
                    int i4 = 0;
                    while (true) {
                        i3 = i4;
                        if (i3 >= QR.size()) {
                            break;
                        }
                        amu2 = (amu) QR.get(i3);
                        x.i("MicroMsg.WebViewStubService", "http header index = %d, key = %s, value = %s", Integer.valueOf(i3), amu2.riD, amu2.mEl);
                        strArr[i3] = r9;
                        strArr2[i3] = str2;
                        i4 = i3 + 1;
                    }
                    bundle.putStringArray("geta8key_result_http_header_key_list", strArr);
                    bundle.putStringArray("geta8key_result_http_header_value_list", strArr2);
                }
            }
            bundle.putSerializable("geta8key_result_scope_list", hVar.QP());
            x.i("MicroMsg.WebViewStubService", "geta8key onscened: share url:[%s], full url:[%s], req url:[%s], has scopeList:[%s]", hVar.getShareUrl(), hVar.QL(), hVar.QM(), Boolean.valueOf(true));
            if (bi.oW(hVar.getShareUrl())) {
                x.e("MicroMsg.WebViewStubService", "null shareUrl, full url:[%s], req url:[%s]", hVar.QL(), hVar.QM());
            } else {
                al.fn(hVar.QL(), hVar.getShareUrl());
            }
            try {
                if (hVar.tag != null) {
                    i3 = ((Integer) hVar.tag).intValue();
                } else {
                    i3 = 0;
                }
                for (WebViewStubCallbackWrapper webViewStubCallbackWrapper2 : this.bPa) {
                    if (i3 == 0 || i3 == webViewStubCallbackWrapper2.id) {
                        bVar = new b();
                        bVar.type = type;
                        bVar.errType = i;
                        bVar.errCode = i2;
                        bVar.Yy = str;
                        bVar.jfZ = bundle;
                        bVar.jfZ.putInt("scene_end_listener_hash_code", webViewStubCallbackWrapper2.id);
                        webViewStubCallbackWrapper2.pXx.a(bVar);
                    } else {
                        x.d("MicroMsg.WebViewStubService", "geta8key hashcode not equal, this one = %d, that = %d", Integer.valueOf(i3), Integer.valueOf(webViewStubCallbackWrapper2.id));
                    }
                }
            } catch (Throwable e2) {
                x.e("MicroMsg.WebViewStubService", "onSceneEnd geta8key fail, ex = " + Log.getStackTraceString(e2));
            }
        } else if (type == 673) {
            k kVar = (k) lVar;
            bundle = new Bundle();
            a = "reading_mode_result_url";
            if (kVar.diG == null) {
                str2 = null;
            } else {
                str2 = ((ahb) kVar.diG.dIE.dIL).URL;
            }
            bundle.putString(a, str2);
            try {
                if (kVar.tag != null) {
                    i3 = ((Integer) kVar.tag).intValue();
                } else {
                    i3 = 0;
                }
                for (WebViewStubCallbackWrapper webViewStubCallbackWrapper22 : this.bPa) {
                    if (i3 == 0 || i3 == webViewStubCallbackWrapper22.id) {
                        bVar = new b();
                        bVar.type = type;
                        bVar.errType = i;
                        bVar.errCode = i2;
                        bVar.Yy = str;
                        bVar.jfZ = bundle;
                        bVar.jfZ.putInt("scene_end_listener_hash_code", webViewStubCallbackWrapper22.id);
                        webViewStubCallbackWrapper22.pXx.a(bVar);
                    } else {
                        x.d("MicroMsg.WebViewStubService", " get readingmodeinfo, hashcode not equal, this one = %d, that = %d", Integer.valueOf(i3), Integer.valueOf(webViewStubCallbackWrapper22.id));
                    }
                }
            } catch (Throwable e22) {
                x.e("MicroMsg.WebViewStubService", "onSceneEnd geta8key fail, ex = " + Log.getStackTraceString(e22));
            }
        } else if (type == 666) {
            u uVar = (u) lVar;
            bundle = new Bundle();
            bundle.putString("emoji_stroe_product_id", uVar.Rt().rem);
            if (i == 0 && i2 == 0) {
                str2 = bundle.getString("emoji_stroe_product_id");
                x.i("MicroMsg.WebViewStubService", "[cpan] onsceneend url:%s", str2);
                if (!bi.oW(str2)) {
                    Intent intent2 = new Intent();
                    intent2.putExtra("extra_id", str2);
                    intent2.putExtra("preceding_scence", 12);
                    intent2.putExtra("download_entrance_scene", 12);
                    com.tencent.mm.bg.d.b(this, "emoji", ".ui.EmojiStoreDetailUI", intent2);
                }
            }
            try {
                if (uVar.tag != null) {
                    i3 = ((Integer) uVar.tag).intValue();
                } else {
                    i3 = 0;
                }
                for (WebViewStubCallbackWrapper webViewStubCallbackWrapper222 : this.bPa) {
                    if (i3 == 0 || i3 == webViewStubCallbackWrapper222.id) {
                        bVar = new b();
                        bVar.type = type;
                        bVar.errType = i;
                        bVar.errCode = i2;
                        bVar.Yy = str;
                        bVar.jfZ = bundle;
                        bVar.jfZ.putInt("scene_end_listener_hash_code", webViewStubCallbackWrapper222.id);
                        webViewStubCallbackWrapper222.pXx.a(bVar);
                    } else {
                        x.d("MicroMsg.WebViewStubService", "jumpEmojiDetail, hashcode not equal, this one = %d, that = %d", Integer.valueOf(i3), Integer.valueOf(webViewStubCallbackWrapper222.id));
                    }
                }
            } catch (Exception e3) {
                x.e("MicroMsg.WebViewStubService", "onSceneEnd MMFunc_JumpEmotionDetail fail, ex = " + e3.getMessage());
            }
        } else if (type == 1254) {
            try {
                int intValue;
                s sVar = (s) lVar;
                if (sVar.tag != null) {
                    intValue = ((Integer) sVar.tag).intValue();
                } else {
                    intValue = 0;
                }
                for (WebViewStubCallbackWrapper webViewStubCallbackWrapper3 : this.bPa) {
                    if (intValue == 0 || intValue == webViewStubCallbackWrapper3.id) {
                        b bVar3 = new b();
                        bVar3.type = type;
                        bVar3.errType = i;
                        bVar3.errCode = i2;
                        bVar3.Yy = str;
                        Bundle bundle2 = new Bundle();
                        if (i == 0 && i2 == 0 && (lVar instanceof s)) {
                            awm awm = (awm) ((s) lVar).diG.dIE.dIL;
                            bundle2.putString("oauth_url", ((s) lVar).pRt);
                            bundle2.putSerializable("scope_list", z.an(awm.rZJ));
                            bundle2.putString("appname", awm.dxK);
                            bundle2.putString("appicon_url", awm.rZK);
                            bundle2.putString("redirect_url", awm.rqU);
                            bundle2.putBoolean("is_recent_has_auth", awm.rZL);
                            bundle2.putBoolean("is_silence_auth", awm.rZM);
                            bundle2.putBoolean("is_call_server_when_confirm", awm.rZN);
                        }
                        bVar3.jfZ = bundle2;
                        bVar3.jfZ.putInt("scene_end_listener_hash_code", webViewStubCallbackWrapper3.id);
                        webViewStubCallbackWrapper3.pXx.a(bVar3);
                    } else {
                        x.d("MicroMsg.WebViewStubService", "authorize, hashcode not equal, this one = %d, that = %d", Integer.valueOf(intValue), Integer.valueOf(webViewStubCallbackWrapper3.id));
                    }
                }
            } catch (Throwable e222) {
                x.e("MicroMsg.WebViewStubService", "onSceneEnd MMFunc_AuthorizeReq fail, ex = " + Log.getStackTraceString(e222));
            }
        } else if (type == 1373) {
            try {
                int intValue2;
                t tVar = (t) lVar;
                if (tVar.tag != null) {
                    intValue2 = ((Integer) tVar.tag).intValue();
                } else {
                    intValue2 = 0;
                }
                for (WebViewStubCallbackWrapper webViewStubCallbackWrapper4 : this.bPa) {
                    if (intValue2 == 0 || intValue2 == webViewStubCallbackWrapper4.id) {
                        b bVar4 = new b();
                        bVar4.type = type;
                        bVar4.errType = i;
                        bVar4.errCode = i2;
                        bVar4.Yy = str;
                        bundle = new Bundle();
                        if (i == 0 && i2 == 0 && (lVar instanceof t)) {
                            bundle.putString("redirect_url", ((awk) ((t) lVar).diG.dIE.dIL).rqU);
                        }
                        bVar4.jfZ = bundle;
                        bVar4.jfZ.putInt("scene_end_listener_hash_code", webViewStubCallbackWrapper4.id);
                        webViewStubCallbackWrapper4.pXx.a(bVar4);
                    } else {
                        x.d("MicroMsg.WebViewStubService", "authorizeconfirm, hashcode not equal, this one = %d, that = %d", Integer.valueOf(intValue2), Integer.valueOf(webViewStubCallbackWrapper4.id));
                    }
                }
            } catch (Throwable e2222) {
                x.e("MicroMsg.WebViewStubService", "onSceneEnd MMFunc_AuthorizeConfirmReq fail, ex = " + Log.getStackTraceString(e2222));
            }
        }
    }
}

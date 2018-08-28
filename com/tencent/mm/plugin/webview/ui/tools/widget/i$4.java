package com.tencent.mm.plugin.webview.ui.tools.widget;

import android.os.Bundle;
import com.tencent.mm.plugin.webview.stub.c;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;

class i$4 extends k {
    final /* synthetic */ i qkV;
    private k qkW = new k();

    i$4(i iVar) {
        this.qkV = iVar;
    }

    private k bYx() {
        k aks = this.qkV.aks();
        if (aks == null) {
            return this.qkW;
        }
        return aks;
    }

    public final boolean As(int i) {
        return bYx().As(i);
    }

    public final boolean c(int i, final Bundle bundle) {
        x.i("MicroMsg.MMWebViewClient", "callback, actionCode = " + i);
        Map hashMap;
        final String string;
        final int i2;
        switch (i) {
            case 90:
                if (this.qkV.qfM != null) {
                    this.qkV.mHandler.post(new 5(this, bundle));
                    break;
                }
                break;
            case 1002:
                this.qkV.mHandler.post(new 1(this, bundle));
                break;
            case 1003:
                this.qkV.mHandler.post(new 10(this, bundle));
                break;
            case 1006:
                if (this.qkV.qfM != null) {
                    this.qkV.mHandler.post(new 4(this, bundle));
                    break;
                }
                break;
            case 1007:
                long j = bundle.getLong("download_manager_downloadid");
                int i3 = bundle.getInt("download_manager_progress");
                this.qkV.mHandler.post(new 12(this, bundle.getString("download_manager_appid", ""), j, i3));
                break;
            case 1008:
                this.qkV.mHandler.post(new Runnable() {
                    public final void run() {
                        if (i$4.this.qkV.qfM != null && i$4.this.qkV.qhr != null && i$4.this.qkV.qhr.bVR() != null && i$4.this.qkV.qhr.bVR().gu(42)) {
                            i$4.this.qkV.qfM.f(bundle, "download_removed");
                        }
                    }
                });
                break;
            case 2002:
                hashMap = new HashMap();
                hashMap.put("err_msg", bundle.getString("playResult"));
                hashMap.put("localId", bundle.getString("localId"));
                this.qkV.mHandler.post(new 2(this, hashMap));
                break;
            case 2003:
                this.qkV.mHandler.post(new 13(this, bundle.getString("webview_jssdk_file_item_local_id"), bundle.getInt("webview_jssdk_file_item_progreess")));
                break;
            case 2004:
                string = bundle.getString("webview_jssdk_file_item_local_id");
                i2 = bundle.getInt("webview_jssdk_file_item_progreess");
                this.qkV.mHandler.post(new Runnable() {
                    public final void run() {
                        if (i$4.this.qkV.qfM != null) {
                            i$4.this.qkV.qfM.cD(string, i2);
                        }
                    }
                });
                break;
            case 2005:
                string = bundle.getString("webview_jssdk_file_item_local_id");
                i2 = bundle.getInt("webview_jssdk_file_item_progreess");
                this.qkV.mHandler.post(new Runnable() {
                    public final void run() {
                        if (i$4.this.qkV.qfM != null) {
                            i$4.this.qkV.qfM.cE(string, i2);
                        }
                    }
                });
                break;
            case 2006:
                string = bundle.getString("webview_jssdk_file_item_local_id");
                i2 = bundle.getInt("webview_jssdk_file_item_progreess");
                this.qkV.mHandler.post(new Runnable() {
                    public final void run() {
                        if (i$4.this.qkV.qfM != null) {
                            i$4.this.qkV.qfM.cF(string, i2);
                        }
                    }
                });
                break;
            case 2008:
                hashMap = new HashMap();
                hashMap.put("localId", bundle.getString("localId"));
                hashMap.put("err_msg", bundle.getString("recordResult"));
                this.qkV.mHandler.post(new 3(this, hashMap));
                break;
            case 2010:
                this.qkV.mHandler.post(new 17(this, bundle.getString("webview_jssdk_file_item_local_id"), bundle.getInt("webview_jssdk_file_item_progreess")));
                break;
            case 40001:
                if (this.qkV.qfM != null) {
                    this.qkV.mHandler.post(new 6(this, bundle.getString("err_msg")));
                    break;
                }
                break;
            case 40002:
                String string2 = bundle.getString("uuid");
                int i4 = bundle.getInt("major");
                int i5 = bundle.getInt("minor");
                double d = bundle.getDouble("accuracy");
                double d2 = bundle.getDouble("rssi");
                float f = bundle.getFloat("heading");
                if (this.qkV.qfM != null) {
                    this.qkV.mHandler.post(new 7(this, bundle.getString("err_msg"), string2, i4, i5, d, d2, f));
                    break;
                }
                break;
            default:
                x.e("MicroMsg.MMWebViewClient", "undefine action code!!!");
                break;
        }
        bYx().c(i, bundle);
        return true;
    }

    public final boolean a(c cVar) {
        if (this.qkV.dEn == null) {
            return true;
        }
        x.i("MicroMsg.MMWebViewClient", "onSceneEnd, instance hashcode = " + this.qkV.dEn.hashCode());
        this.qkV.mHandler.post(new 8(this, cVar));
        return bYx().a(cVar);
    }

    public final boolean a(String str, String str2, Bundle bundle, boolean z) {
        if (this.qkV.qfM != null) {
            this.qkV.mHandler.post(new 9(this, str, str2, bundle, z));
            bYx().a(str, str2, bundle, z);
        }
        return false;
    }

    public final String bVl() {
        return this.qkV.qkL;
    }

    public final String getCurrentUrl() {
        return this.qkV.getCurrentURL();
    }

    public final String bVm() {
        return bYx().bVm();
    }

    public final void jV(boolean z) {
        bYx().jV(z);
    }

    public final void jW(boolean z) {
        bYx().jW(z);
    }

    public final void q(int i, Bundle bundle) {
        bYx().q(i, bundle);
    }

    public final void bVn() {
        if (this.qkV.qfM != null) {
            this.qkV.qfM.bVn();
        }
    }

    public final void P(Bundle bundle) {
        bYx().P(bundle);
    }

    public final void QM(String str) {
        bYx().QM(str);
    }

    public final void fo(String str, String str2) {
        bYx().fo(str, str2);
    }

    public final void bVo() {
        if (this.qkV.qfM != null) {
            this.qkV.qfM.bVo();
        }
    }

    public final void e(String str, String str2, int i, int i2) {
        bYx().e(str, str2, i, i2);
    }

    public final Bundle g(int i, Bundle bundle) {
        if (i != 146) {
            return bYx().g(i, bundle);
        }
        Bundle bundle2 = new Bundle();
        String string = bundle.getString("_url");
        if (bi.oW(string)) {
            return bundle2;
        }
        JsapiPermissionWrapper Rl = this.qkV.qhr.Rl(string);
        if (Rl == null) {
            return bundle2;
        }
        bundle2.putParcelable("_permission_wrapper", Rl);
        return bundle2;
    }

    public final void Q(Bundle bundle) {
        bYx().Q(bundle);
    }

    public final void jX(boolean z) {
        bYx().jX(z);
    }

    public final void fp(String str, String str2) {
        bYx().fp(str, str2);
    }
}

package com.tencent.mm.plugin.nfc_open.ui;

import android.annotation.TargetApi;
import android.content.Intent;
import android.net.Uri;
import android.nfc.Tag;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.R;
import com.tencent.mm.bg.d;
import com.tencent.mm.plugin.nfc_open.a.a;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.pluginsdk.ui.AutoLoginActivity;
import com.tencent.mm.protocal.c.awf;
import com.tencent.mm.protocal.c.kw;
import com.tencent.mm.protocal.c.pl;
import com.tencent.mm.protocal.c.qj;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.e;
import com.tencent.mm.sdk.platformtools.s;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;
import java.util.regex.Pattern;

public class NfcWebViewUI extends WebViewUI {
    private String lFv = null;
    private boolean lFw = false;
    private a lFx = new a();

    public void onCreate(Bundle bundle) {
        Intent intent = getIntent();
        if (V(intent)) {
            x.e("MicroMsg.NfcWebViewUI", "onCreate judgeIllegalCall finish");
            intent.putExtra("key_trust_url", false);
            super.onCreate(bundle);
            finish();
            return;
        }
        intent.putExtra("key_trust_url", false);
        super.onCreate(bundle);
        com.tencent.mm.sdk.b.a.sFg.b(this.lFx);
        d.cfH();
        x.i("MicroMsg.NfcWebViewUI", "onCreate, intent action = " + intent.getAction());
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                if (NfcWebViewUI.this.lFw) {
                    NfcWebViewUI.this.bjx();
                } else {
                    NfcWebViewUI.this.finish();
                }
                return true;
            }
        });
        getIntent().putExtra("showShare", false);
        ka(false);
    }

    @TargetApi(11)
    protected void onDestroy() {
        super.onDestroy();
        com.tencent.mm.sdk.b.a.sFg.c(this.lFx);
    }

    protected final void ant() {
        if (bjv()) {
            finish();
            x.w("MicroMsg.NfcWebViewUI", "not login, go to SimpleLogin");
            return;
        }
        super.ant();
        a(AutoLoginActivity.a.qEF, getIntent());
    }

    public void onNewIntent(Intent intent) {
        if (V(intent)) {
            x.e("MicroMsg.NfcWebViewUI", "onNewIntent judgeIllegalCall finish");
            return;
        }
        intent.putExtra("key_trust_url", false);
        super.onNewIntent(intent);
        setIntent(intent);
        int a = s.a(intent, "wizard_activity_result_code", Integer.MAX_VALUE);
        x.i("MicroMsg.NfcWebViewUI", "onNewIntent, resultCode = " + a);
        if (a != Integer.MAX_VALUE) {
            this.lFw = true;
        }
        switch (a) {
            case -1:
                a(AutoLoginActivity.a.qEF, intent);
                break;
            case 0:
                bjv();
                return;
            case 1:
                a(AutoLoginActivity.a.qEH, intent);
                break;
        }
        gU(true);
        x.i("Foreground dispatch", "Discovered tag with intent: " + intent);
    }

    private boolean bjv() {
        try {
            if (!this.gcO.bVA()) {
                return false;
            }
            x.w("MicroMsg.NfcWebViewUI", "not login");
            Intent intent = new Intent(this, getClass());
            intent.putExtras(getIntent());
            intent.addFlags(67108864);
            this.gcO.aj(intent);
            return true;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.NfcWebViewUI", e, "", new Object[0]);
            return true;
        }
    }

    private void a(AutoLoginActivity.a aVar, Intent intent) {
        switch (3.hdM[aVar.ordinal()]) {
            case 1:
                Tag tag;
                Parcelable parcelableExtra = intent.getParcelableExtra("android.nfc.extra.TAG");
                if (parcelableExtra == null || !(parcelableExtra instanceof Tag)) {
                    tag = null;
                } else {
                    tag = (Tag) parcelableExtra;
                }
                if (tag == null) {
                    x.e("MicroMsg.NfcWebViewUI", "[NFC]tag is null");
                    return;
                }
                try {
                    com.tencent.mm.plugin.nfc.c.a.a.bjr().a(tag);
                    x.i("MicroMsg.NfcWebViewUI", "[NFC] connect status : " + com.tencent.mm.plugin.nfc.c.a.a.bjr().dX(this.mController.tml));
                    return;
                } catch (Exception e) {
                    x.e("MicroMsg.NfcWebViewUI", "exp protect");
                    return;
                }
            default:
                finish();
                return;
        }
    }

    protected final void gU(boolean z) {
        if (this.gcO == null) {
            x.e("MicroMsg.NfcWebViewUI", "[NFC] invoker is null");
            return;
        }
        a(AutoLoginActivity.a.qEF, getIntent());
        String bjw = bjw();
        String str = this.cbP;
        if (!z || bi.oW(this.cbP) || this.cbP.startsWith("https://support.weixin.qq.com/security/readtemplate?t=bus_recharge/index_error")) {
            this.cbP = bjw;
            if (bi.oW(this.cbP)) {
                this.cbP = tY(0);
                x.e("MicroMsg.NfcWebViewUI", "[NFC] url not found! not support this card ?");
            }
            getIntent().putExtra("rawUrl", this.cbP);
            if (!this.cbP.equals(str)) {
                x.i("MicroMsg.NfcWebViewUI", "lo-nfc-dealwithNFC: onNewIntent load:" + this.cbP);
                this.mhH.loadUrl(this.cbP);
                return;
            }
            return;
        }
        try {
            int i;
            if (!bi.oW(bjw)) {
                try {
                    Uri parse = Uri.parse(bjw);
                    Uri parse2 = Uri.parse(this.cbP);
                    bjw = parse.getHost();
                    str = parse2.getHost();
                    x.i("MicroMsg.NfcWebViewUI", "targetHost=" + bjw + ", curHost=" + str);
                    if (bjw.equals(str)) {
                        i = 1;
                        if (i != 0) {
                            this.pRY.c(4007, new Bundle());
                        }
                        x.i("MicroMsg.NfcWebViewUI", "[NFC]new intent not guide the page");
                    }
                } catch (Exception e) {
                }
            }
            i = 0;
            if (i != 0) {
                this.pRY.c(4007, new Bundle());
            }
        } catch (Throwable e2) {
            x.printErrStackTrace("MicroMsg.NfcWebViewUI", e2, "", new Object[0]);
        }
        x.i("MicroMsg.NfcWebViewUI", "[NFC]new intent not guide the page");
    }

    private static String tY(int i) {
        String str;
        StringBuilder stringBuilder = new StringBuilder("https://support.weixin.qq.com/security/readtemplate?t=bus_recharge/index_error");
        stringBuilder.append("&type=").append(i);
        if (!e.sFF && w.chP().equals("zh_CN")) {
            str = "zh_CN";
        } else if (w.chN()) {
            str = "zh_TW";
        } else {
            str = "en";
        }
        stringBuilder.append("&lang=").append(str);
        return stringBuilder.toString();
    }

    private String bjw() {
        String str = null;
        x.i("MicroMsg.NfcWebViewUI", "nfc-getNfcCpuCardGuideUrl start");
        try {
            Bundle g = this.gcO.g(4006, null);
            if (g == null) {
                x.i("MicroMsg.NfcWebViewUI", "nfc-getNfcCpuCardGuideUrl data is null");
                return str;
            }
            g.setClassLoader(getClass().getClassLoader());
            String string = g.getString("debugConfig");
            String string2 = g.getString("config");
            if (string != null) {
                str = IM(string);
            } else {
                str = IN(string2);
            }
            x.i("MicroMsg.NfcWebViewUI", "nfc-getNfcCpuCardGuideUrl targetUrl=" + bi.oV(str));
            return str;
        } catch (Throwable e) {
            x.e("MicroMsg.NfcWebViewUI", e.toString());
            x.printErrStackTrace("MicroMsg.NfcWebViewUI", e, "", new Object[0]);
        }
    }

    private String IM(String str) {
        x.i("MicroMsg.NfcWebViewUI", "nfc-getDebugNfcCardGuideUrl start");
        this.lFv = "";
        try {
            String[] split = str.split(" ");
            if (split != null && split.length > 1) {
                boolean z = false;
                for (int i = 0; i < split.length - 1; i = (i + 1) + 1) {
                    String str2 = split[i];
                    String str3 = split[i + 1];
                    x.d("MicroMsg.NfcWebViewUI", "nfc-getDebugNfcCardGuideUrl cmd = " + str2 + " anwser = " + str3);
                    z = a(new com.tencent.mm.plugin.nfc.a.a(com.tencent.mm.plugin.nfc.d.a.hexStringToByteArray(str2)), str3);
                    if (!z) {
                        break;
                    }
                }
                if (z) {
                    this.lFv = split[split.length - 1];
                    x.d("MicroMsg.NfcWebViewUI", "nfc-getDebugNfcCardGuideUrl tempurl = " + this.lFv);
                    return this.lFv;
                }
            }
            return this.lFv;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.NfcWebViewUI", e, "", new Object[0]);
            x.e("MicroMsg.NfcWebViewUI", "[NFC] Debug get nfc card type exception!" + e.toString());
            x.e("MicroMsg.NfcWebViewUI", "isConnect:" + com.tencent.mm.plugin.nfc.c.a.a.bjr().dW(this.mController.tml));
            this.lFv = tY(1);
            return this.lFv;
        }
    }

    private String IN(String str) {
        x.i("MicroMsg.NfcWebViewUI", "nfc-getCommonNfcCardGuideUrl start");
        this.lFv = "";
        awf awf = new awf();
        if (!bi.oW(str)) {
            try {
                awf.aG(str.getBytes("ISO-8859-1"));
                if (awf.ruL != null) {
                    int i = 0;
                    for (int i2 = 0; i2 < awf.ruL.size(); i2++) {
                        kw kwVar = (kw) awf.ruL.get(i2);
                        com.tencent.mm.plugin.nfc.c.a.a bjr = com.tencent.mm.plugin.nfc.c.a.a.bjr();
                        if (bjr.lFk != null) {
                            bjr.lFk.bjs();
                        }
                        if (!(kwVar == null || bi.oW(kwVar.qYo) || bi.cX(kwVar.rmS))) {
                            String str2;
                            int i3 = 0;
                            while (true) {
                                int i4 = i;
                                if (i3 >= kwVar.rmS.size()) {
                                    i = i4;
                                    break;
                                }
                                if (!bi.cX(((qj) kwVar.rmS.get(i3)).ruO)) {
                                    int i5 = 0;
                                    while (i5 < ((qj) kwVar.rmS.get(i3)).ruO.size()) {
                                        if (((qj) kwVar.rmS.get(i3)).ruO.get(i5) != null && !bi.oW(((pl) ((qj) kwVar.rmS.get(i3)).ruO.get(i5)).rtL) && !bi.oW(((pl) ((qj) kwVar.rmS.get(i3)).ruO.get(i5)).kQE)) {
                                            String str3 = ((pl) ((qj) kwVar.rmS.get(i3)).ruO.get(i5)).rtL;
                                            str2 = ((pl) ((qj) kwVar.rmS.get(i3)).ruO.get(i5)).kQE;
                                            x.d("MicroMsg.NfcWebViewUI", "nfc-getCommonNfcCardGuideUrl cmd = " + str3 + " anwser = " + str2);
                                            if (!a(new com.tencent.mm.plugin.nfc.a.a(com.tencent.mm.plugin.nfc.d.a.hexStringToByteArray(str3)), str2)) {
                                                i = 0;
                                                break;
                                            }
                                            i = 1;
                                        } else {
                                            i = i4;
                                        }
                                        i5++;
                                        i4 = i;
                                    }
                                    i = i4;
                                    if (i != 0) {
                                        break;
                                    }
                                } else {
                                    i = i4;
                                }
                                i3++;
                            }
                            if (i != 0) {
                                str2 = kwVar.qYo;
                                x.i("MicroMsg.NfcWebViewUI", "doCardTypeReport start");
                                com.tencent.mm.sdk.f.e.post(new 2(this, str2), getClass().getName());
                                return kwVar.qYo;
                            }
                        }
                        i = i;
                    }
                }
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.NfcWebViewUI", e, "", new Object[0]);
                x.e("MicroMsg.NfcWebViewUI", "[NFC] Common get nfc card type exception!" + e.toString());
                x.e("MicroMsg.NfcWebViewUI", "isConnect:" + com.tencent.mm.plugin.nfc.c.a.a.bjr().dW(this.mController.tml));
                this.lFv = tY(1);
                return this.lFv;
            }
        }
        return this.lFv;
    }

    private static boolean a(com.tencent.mm.plugin.nfc.a.a aVar, String str) {
        boolean z;
        x.i("MicroMsg.NfcWebViewUI", "nfc-doCmd start");
        CharSequence cVar = com.tencent.mm.plugin.nfc.c.a.a.bjr().a(aVar).toString();
        if (!bi.oW(cVar)) {
            x.d("MicroMsg.NfcWebViewUI", "nfc-judge mAnwser = " + bi.oV(str) + " resp = " + bi.oV(cVar));
            if (Pattern.compile(str, 2).matcher(cVar).find()) {
                z = true;
                if (z) {
                    return false;
                }
                return true;
            }
        }
        z = false;
        if (z) {
            return false;
        }
        return true;
    }

    public void onBackPressed() {
        if (this.lFw) {
            bjx();
        } else {
            super.onBackPressed();
        }
    }

    private void bjx() {
        Intent intent = new Intent();
        intent.addFlags(67108864);
        d.e(this, "com.tencent.mm.ui.LauncherUI", intent);
        finish();
        overridePendingTransition(R.a.anim_not_change, R.a.pop_out);
        x.i("MicroMsg.NfcWebViewUI", "lo-nfc-setBackBtn:back click after login");
    }

    private static boolean V(Intent intent) {
        if (intent == null) {
            x.e("MicroMsg.NfcWebViewUI", "intent is null");
            return true;
        }
        Tag tag;
        Iterator it = intent.getExtras().keySet().iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (!(str == null || str.startsWith("android.nfc"))) {
                x.e("MicroMsg.NfcWebViewUI", "extra wrong key = " + str);
                it.remove();
            }
        }
        Parcelable parcelableExtra = intent.getParcelableExtra("android.nfc.extra.TAG");
        if (parcelableExtra == null || !(parcelableExtra instanceof Tag)) {
            tag = null;
        } else {
            tag = (Tag) parcelableExtra;
        }
        if (tag != null) {
            return false;
        }
        x.e("MicroMsg.NfcWebViewUI", "tag is null");
        return true;
    }
}

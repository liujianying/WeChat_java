package com.tencent.mm.plugin.qqmail.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.a.e;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.qqmail.b.p.c;
import com.tencent.mm.plugin.qqmail.stub.ReadMailProxy;
import com.tencent.mm.plugin.webview.ui.tools.widget.MMWebViewWithJsApi;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.remoteservice.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bl;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.tools.k;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import com.tencent.xweb.WebView;
import com.tencent.xweb.WebView.b;
import java.util.HashMap;
import java.util.Map;

public class ReadMailUI extends MMActivity implements OnCreateContextMenuListener {
    private static String miv = "var mail_css = document.createElement(\"style\");";
    private static String miw = "";
    private static String mix = "";
    private static float miy;
    private static int miz;
    private long bJC = -1;
    private SharedPreferences duR;
    private ProgressBar eIJ;
    private long fGL = -1;
    private ag handler;
    private TextView hrV;
    private d iMQ = new d(this);
    private String mcf;
    private String mck;
    private String mhR;
    private MailMMWebView mhS;
    private ImageView mhT;
    private TextView mhU;
    private MailAddrsViewControl mhV;
    private MailAddrsViewControl mhW;
    private MailAddrsViewControl mhX;
    private TextView mhY;
    private View mhZ;
    private ReadMailProxy miA;
    private String miB;
    private int miC;
    private LinearLayout mia;
    private TextView mib;
    private TextView mic;
    private LinearLayout mid;
    private MailAttachListLinearLayout mie;
    private View mif;
    private TextView mig;
    private TextView mih;
    private View mii;
    private long mij = -1;
    private int mik;
    private int mil;
    private String mim;
    private String mio;
    private String mip;
    private int miq = 0;
    private String mir;
    private al mis;
    private int mit = 0;
    private int miu = 0;

    private class a extends com.tencent.mm.plugin.qqmail.b.p.a {
        int miL;

        public a(int i) {
            this.miL = i;
        }

        public final void onSuccess(String str, Map<String, String> map) {
            x.d("MicroMsg.ReadMailUI", "onSuccess userData = %d", new Object[]{Integer.valueOf(this.miL)});
            switch (this.miL) {
                case 1:
                    ReadMailUI.a(ReadMailUI.this, new 1(this, map));
                    return;
                case 2:
                    ReadMailUI.this.handler.post(new 2(this));
                    break;
            }
            x.e("MicroMsg.ReadMailUI", "onSuccess, invalid userData = %d", new Object[]{Integer.valueOf(this.miL)});
        }

        public final void onError(int i, String str) {
            x.d("MicroMsg.ReadMailUI", "onError errCode = %d, userData = %d", new Object[]{Integer.valueOf(i), Integer.valueOf(this.miL)});
            ReadMailUI.this.handler.post(new 3(this, i, str));
        }

        public final boolean onReady() {
            ReadMailUI.this.handler.post(new 4(this));
            return true;
        }

        public final void onComplete() {
            ReadMailUI.this.handler.post(new 5(this));
        }
    }

    static /* synthetic */ void E(ReadMailUI readMailUI) {
        readMailUI.duR = ad.getContext().getSharedPreferences("QQMAIL", 4);
        if (readMailUI.duR != null) {
            bi.j(readMailUI.duR.getString("qqmail_downloadpath", ""), readMailUI);
        }
    }

    static /* synthetic */ void F(ReadMailUI readMailUI) {
        final Intent intent = new Intent();
        if (bi.oW(readMailUI.miB)) {
            x.w("MicroMsg.ReadMailUI", "mQQMailSchemeForUnread is null");
            readMailUI.startActivity(readMailUI.getPackageManager().getLaunchIntentForPackage("com.tencent.androidqqmail"));
            return;
        }
        x.d("MicroMsg.ReadMailUI", "qq mail scheme:%s", new Object[]{readMailUI.miB.replace("$uin$", (String) new ReadMailProxy(readMailUI.iMQ, new a(1)).REMOTE_CALL("getBindUin", new Object[0]))});
        intent.setData(Uri.parse(r0));
        intent.addFlags(268435456);
        if (VERSION.SDK_INT >= 11) {
            intent.addFlags(WXMediaMessage.THUMB_LENGTH_LIMIT);
        }
        if (bi.k(readMailUI, intent)) {
            com.tencent.mm.bu.a.post(new Runnable() {
                public final void run() {
                    g.a(ReadMailUI.this, intent, ReadMailUI.this.getString(R.l.chatfooter_mail_without_unread_count), null);
                }
            });
            return;
        }
        x.w("MicroMsg.ReadMailUI", "schema failed");
        com.tencent.mm.bu.a.post(new 6(readMailUI));
    }

    static /* synthetic */ void J(ReadMailUI readMailUI) {
        try {
            new ReadMailProxy(readMailUI.iMQ, null).REMOTE_CALL("deleteMsgById", Long.valueOf(readMailUI.bJC));
        } catch (Exception e) {
            x.w("MicroMsg.ReadMailUI", "doDelete fail, ex = %s", new Object[]{e.getMessage()});
        }
        readMailUI.finish();
    }

    static /* synthetic */ void q(ReadMailUI readMailUI) {
        readMailUI.mic.setOnClickListener(new 11(readMailUI));
        readMailUI.mhT.setOnClickListener(new 12(readMailUI));
        readMailUI.addIconOptionMenu(0, R.g.mm_title_btn_menu, new 13(readMailUI));
        if (readMailUI.mij != -2) {
            String str;
            if (!(readMailUI.mij == -1 || readMailUI.mij == -2)) {
                try {
                    new ReadMailProxy(readMailUI.iMQ, new a(0)).REMOTE_CALL("cancel", Long.valueOf(readMailUI.mij));
                } catch (Exception e) {
                    x.w("MicroMsg.ReadMailUI", "render cancel, ex = %s", new Object[]{e.getMessage()});
                }
            }
            try {
                str = (String) new ReadMailProxy(readMailUI.iMQ, null).REMOTE_CALL("getMsgContent", Long.valueOf(readMailUI.bJC));
            } catch (Exception e2) {
                x.w("MicroMsg.ReadMailUI", "render, getMsgContent, ex = %s", new Object[]{e2.getMessage()});
                str = null;
            }
            Map z = bl.z(str, "msg");
            if (z == null) {
                x.e("MicroMsg.ReadMailUI", "render fail, maps is null");
                return;
            }
            readMailUI.setMMTitle("");
            readMailUI.mcf = (String) z.get(".msg.pushmail.mailid");
            readMailUI.mck = (String) z.get(".msg.pushmail.content.subject");
            readMailUI.mhV.a(new String[]{((String) z.get(".msg.pushmail.content.fromlist.item.name")) + " " + ((String) z.get(".msg.pushmail.content.fromlist.item.addr"))}, true);
            readMailUI.mhX.a(a(z, ".msg.pushmail.content.tolist", bi.getInt((String) z.get(".msg.pushmail.content.tolist.$count"), 0)), true);
            String[] a = a(z, ".msg.pushmail.content.cclist", bi.getInt((String) z.get(".msg.pushmail.content.cclist.$count"), 0));
            LinearLayout linearLayout = readMailUI.mia;
            int i = (a == null || a.length == 0) ? 8 : 0;
            linearLayout.setVisibility(i);
            readMailUI.mhW.a(a, true);
            readMailUI.mib.setText(readMailUI.mck);
            readMailUI.hrV.setText((CharSequence) z.get(".msg.pushmail.content.date"));
            readMailUI.mic.setEnabled(true);
            readMailUI.a(new c());
        }
    }

    static /* synthetic */ void s(ReadMailUI readMailUI) {
        readMailUI.duR = ad.getContext().getSharedPreferences("QQMAIL", 4);
        if (readMailUI.duR != null) {
            long j = readMailUI.duR.getLong("qqmail_info_report_time", -1);
            long currentTimeMillis = System.currentTimeMillis();
            if (j < 0 || currentTimeMillis - j > 86400000) {
                if (p.r(readMailUI, "com.tencent.androidqqmail")) {
                    int i = p.getPackageInfo(readMailUI, "com.tencent.androidqqmail").versionCode;
                    x.d("MicroMsg.ReadMailUI", "is intalled:%d, version:%d", new Object[]{Integer.valueOf(1), Integer.valueOf(i)});
                    new ReadMailProxy(readMailUI.iMQ, null).REMOTE_CALL("reportKvStates", Integer.valueOf(11389), Integer.valueOf(1), Integer.valueOf(i));
                } else {
                    x.d("MicroMsg.ReadMailUI", "is intalled:%d", new Object[]{Integer.valueOf(0)});
                    readMailUI.dm(11389, 0);
                }
                readMailUI.duR.edit().putLong("qqmail_info_report_time", currentTimeMillis).commit();
            }
        }
    }

    static /* synthetic */ void z(ReadMailUI readMailUI) {
        readMailUI.fGL = ((Long) new ReadMailProxy(readMailUI.iMQ, null).REMOTE_CALL("downloadQQMailApp", readMailUI.mio, readMailUI.mip)).longValue();
        if (readMailUI.fGL <= 0) {
            x.e("MicroMsg.ReadMailUI", "doAddDownloadTask fail, downloadId = %d ", new Object[]{Long.valueOf(readMailUI.fGL)});
            return;
        }
        readMailUI.duR = ad.getContext().getSharedPreferences("QQMAIL", 4);
        if (readMailUI.duR != null) {
            readMailUI.duR.edit().putLong("qqmail_downloadid", readMailUI.fGL).commit();
        }
        readMailUI.miu = 1;
        readMailUI.miq = ((Integer) new ReadMailProxy(readMailUI.iMQ, null).REMOTE_CALL("getMailAppDownloadStatus", Long.valueOf(readMailUI.fGL))).intValue();
        readMailUI.mif.setVisibility(0);
        readMailUI.bpk();
        readMailUI.bpg();
    }

    private void bpg() {
        switch (this.miu) {
            case 0:
                this.mih.setText(R.l.readmail_promo_btn_nor);
                return;
            case 1:
                this.mih.setText(R.l.readmail_promo_btn_downloading);
                return;
            case 2:
                this.mih.setText(R.l.readmail_promo_btn_install);
                return;
            case 3:
                String str = "";
                if (this.miC > 99) {
                    str = "99+";
                } else if (this.miC > 0) {
                    str = Integer.toString(this.miC);
                }
                if (bi.oW(str)) {
                    this.mih.setText(R.l.readmail_promo_btn_open);
                    return;
                }
                this.mih.setText(String.format(com.tencent.mm.bp.a.af(this, R.l.readmail_promo_btn_open_with_unread), new Object[]{str}));
                return;
            default:
                return;
        }
    }

    protected final int getLayoutId() {
        return R.i.readmail;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.handler = new ag();
        this.bJC = getIntent().getLongExtra("msgid", -1);
        this.mik = 0;
        this.mil = 0;
        initView();
        this.iMQ.K(new Runnable() {
            public final void run() {
                ReadMailUI.q(ReadMailUI.this);
                if (ReadMailUI.this.mil == 0) {
                    ReadMailUI.s(ReadMailUI.this);
                    if (!ReadMailUI.this.bpi()) {
                        ReadMailUI.this.bpj();
                    }
                    ReadMailUI.this.miA = new ReadMailProxy(ReadMailUI.this.iMQ, null, new b(ReadMailUI.this), new c(ReadMailUI.this));
                    ReadMailUI.this.miA.REMOTE_CALL("addDownloadCallback", new Object[0]);
                }
            }
        });
    }

    protected void onPause() {
        super.onPause();
        if (this.mij != -1 && this.mij != -2) {
            try {
                new ReadMailProxy(this.iMQ, new a(0)).REMOTE_CALL("cancel", Long.valueOf(this.mij));
            } catch (Exception e) {
                x.w("MicroMsg.ReadMailUI", "cancel, ex = %s", new Object[]{e.getMessage()});
            }
        }
    }

    protected void onStop() {
        super.onStop();
        this.mhS.stopLoading();
    }

    public void onDestroy() {
        super.onDestroy();
        if (this.miA != null) {
            this.miA.REMOTE_CALL("removeDownloadCallback", new Object[0]);
        }
        this.iMQ.release();
        this.mhS.setVisibility(8);
        this.mhS.destroy();
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1) {
            if (i == 1) {
                x.d("MicroMsg.ReadMailUI", "USER_DATA_READMAIL onAfterVerify");
                a(new c());
            } else if (i == 2) {
                x.d("MicroMsg.ReadMailUI", "USER_DATA_SETUNREAD onAfterVerify");
                bph();
            }
        }
    }

    protected final void initView() {
        this.mhV = (MailAddrsViewControl) findViewById(R.h.qqmail_readmail_addr_sender_control);
        this.mhX = (MailAddrsViewControl) findViewById(R.h.qqmail_readmail_addr_tolist_control);
        this.mhW = (MailAddrsViewControl) findViewById(R.h.qqmail_readmail_addr_cclist_control);
        this.mhY = (TextView) findViewById(R.h.readmail_detail_tv);
        this.mhZ = findViewById(R.h.readmail_receiver_ll);
        this.mia = (LinearLayout) findViewById(R.h.readmail_cclist_ll);
        this.mib = (TextView) findViewById(R.h.readmail_subject_tv);
        this.hrV = (TextView) findViewById(R.h.readmail_time_tv);
        this.mic = (TextView) findViewById(R.h.readmail_setunread_tv);
        this.mid = (LinearLayout) findViewById(R.h.readmail_attach_viewport_ll);
        this.mie = (MailAttachListLinearLayout) findViewById(R.h.readmail_attach_list_ll);
        this.eIJ = (ProgressBar) findViewById(R.h.readmail_loading_pb);
        this.mhT = (ImageView) findViewById(R.h.readmail_refresh_iv);
        this.mhU = (TextView) findViewById(R.h.readmail_tips);
        int i = R.h.readmail_wv;
        MMWebViewWithJsApi.eB(this);
        MMWebViewWithJsApi mMWebViewWithJsApi = (MMWebViewWithJsApi) findViewById(i);
        MMWebViewWithJsApi.b(mMWebViewWithJsApi);
        this.mhS = (MailMMWebView) mMWebViewWithJsApi;
        this.mii = findViewById(R.h.mail_title_bar);
        this.mif = findViewById(R.h.mail_download_bar);
        this.mih = (TextView) findViewById(R.h.mail_download_title);
        this.mig = (TextView) findViewById(R.h.mail_download_progress);
        this.mif.setOnClickListener(new 7(this));
        this.mhY.setOnClickListener(new 8(this));
        setBackBtn(new 9(this));
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        miy = ((float) displayMetrics.widthPixels) / displayMetrics.scaledDensity;
        miz = displayMetrics.heightPixels;
        this.mhS.getSettings().setDefaultTextEncodingName(ProtocolPackage.ServerEncoding);
        this.mhS.getSettings().setSupportZoom(false);
        this.mhS.getSettings().setBuiltInZoomControls(false);
        this.mhS.getSettings().cIo();
        this.mhS.getSettings().setLoadsImagesAutomatically(false);
        this.mhS.getSettings().setUseWideViewPort(true);
        this.mhS.cAx();
        this.mhS.setEmbeddedTitleBarCompat(this.mii);
        this.mhS.setEmbeddedBottomBar(this.mif);
        Intent intent = this.mController.tml.getIntent();
        byte[] bArr = new byte[112];
        bArr[25] = (byte) 1;
        bArr[16] = (byte) 1;
        bArr[57] = (byte) 1;
        bArr[63] = (byte) 1;
        bArr[61] = (byte) 1;
        bArr[70] = (byte) 1;
        bArr[68] = (byte) 1;
        bArr[82] = (byte) 1;
        bArr[111] = (byte) 1;
        intent.putExtra("hardcode_jspermission", new JsapiPermissionWrapper(bArr));
        this.mController.tml.setIntent(intent);
        this.mhS.setWebViewClient(new 10(this, this.mhS));
        if (miw.equals("")) {
            try {
                miw += bi.convertStreamToString(getAssets().open("mail/lib.js"));
                mix += bi.convertStreamToString(getAssets().open("mail/readmail.js"));
                miv += "mail_css.innerHTML='" + bi.convertStreamToString(getAssets().open("mail/qmail_webview.css")) + "'; document.head.appendChild(mail_css);";
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.ReadMailUI", e, "", new Object[0]);
                x.e("MicroMsg.ReadMailUI", "evaluateJavascript error " + e.getMessage());
            }
        }
        registerForContextMenu(this.mhS);
        new k(this).a(this.mhS, this, null);
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        if (view instanceof WebView) {
            b hitTestResult = ((WebView) view).getHitTestResult();
            if (hitTestResult.mType == 5 || hitTestResult.mType == 8) {
                boolean booleanValue;
                try {
                    booleanValue = ((Boolean) new ReadMailProxy(this.iMQ, null).REMOTE_CALL("isSDCardAvailable", new Object[0])).booleanValue();
                } catch (Exception e) {
                    x.w("MicroMsg.ReadMailUI", "createContextMenu, isSDCardAvailable, ex = %s", new Object[]{e.getMessage()});
                    booleanValue = false;
                }
                if (booleanValue) {
                    contextMenu.setHeaderTitle(R.l.wv_image);
                    contextMenu.add(0, 0, 0, getString(R.l.save_to_local)).setOnMenuItemClickListener(new 14(this, hitTestResult));
                } else {
                    return;
                }
            }
        }
        super.onCreateContextMenu(contextMenu, view, contextMenuInfo);
    }

    private static String[] a(Map<String, String> map, String str, int i) {
        if (map.get(str) == null) {
            return null;
        }
        String[] strArr = new String[i];
        int i2 = 0;
        while (i2 < i) {
            String str2 = str + ".item" + (i2 > 0 ? Integer.valueOf(i2) : "");
            strArr[i2] = ((String) map.get(str2 + ".name")) + " " + ((String) map.get(str2 + ".addr"));
            i2++;
        }
        return strArr;
    }

    private void a(c cVar) {
        if (this.mcf == null || this.mcf.length() == 0) {
            x.e("MicroMsg.ReadMailUI", "doReadMail invalid argument");
            return;
        }
        this.mhT.setVisibility(8);
        this.eIJ.setVisibility(0);
        Map hashMap = new HashMap();
        hashMap.put("mailid", this.mcf);
        hashMap.put("texttype", "html");
        if (!(this.mij == -1 || this.mij == -2)) {
            try {
                new ReadMailProxy(this.iMQ, new a(0)).REMOTE_CALL("cancel", Long.valueOf(this.mij));
            } catch (Exception e) {
                x.w("MicroMsg.ReadMailUI", "cancel, ex = %s", new Object[]{e.getMessage()});
            }
        }
        this.mhR = this.mcf;
        cVar.toBundle(new Bundle());
        try {
            this.mij = ((Long) new ReadMailProxy(this.iMQ, new a(1)).REMOTE_CALL("get", "/cgi-bin/readmail", hashMap, new Bundle())).longValue();
        } catch (Exception e2) {
            x.w("MicroMsg.ReadMailUI", "doReadMail get fail, ex = %s", new Object[]{e2.getMessage()});
        }
    }

    private void bph() {
        if (this.mcf == null || this.mcf.length() == 0) {
            x.e("MicroMsg.ReadMailUI", "doSetUnread invalid argument");
            return;
        }
        new HashMap().put("mailid", this.mcf);
        c cVar = new c();
        cVar.mdl = false;
        cVar.toBundle(new Bundle());
        try {
            new ReadMailProxy(this.iMQ, new a(2)).REMOTE_CALL("get", "/cgi-bin/setmailunread", new HashMap(), new Bundle());
        } catch (Exception e) {
            x.w("MicroMsg.ReadMailUI", "doSetUnread, ex = %s", new Object[]{e.getMessage()});
        }
    }

    private boolean bpi() {
        this.mim = (String) new ReadMailProxy(this.iMQ, null).REMOTE_CALL("getMailAppRedirectUrlAndroid", new Object[0]);
        this.miB = (String) new ReadMailProxy(this.iMQ, null).REMOTE_CALL("getMailAppEnterUlAndroid", new Object[0]);
        try {
            this.miC = ((Integer) new ReadMailProxy(this.iMQ, null).REMOTE_CALL("getUneradMailCountFromConfig", new Object[0])).intValue();
        } catch (Throwable e) {
            this.miC = -1;
            x.printErrStackTrace("MicroMsg.ReadMailUI", e, "getUneradMailCountFromConfig got an NullPointerException", new Object[0]);
        }
        new ReadMailProxy(this.iMQ, null).REMOTE_CALL("getUnreadMailCount", new Object[0]);
        Integer num = (Integer) new ReadMailProxy(this.iMQ, null).REMOTE_CALL("showMailAppRecommend", new Object[0]);
        if (num == null) {
            x.e("MicroMsg.ReadMailUI", "Remote server Proxy not ready");
            return true;
        }
        this.mil = 1;
        this.mik = num.intValue();
        if (bi.oW(this.miB)) {
            return true;
        }
        if (p.r(this, "com.tencent.androidqqmail")) {
            this.miu = 3;
            bpg();
            return true;
        }
        this.duR = ad.getContext().getSharedPreferences("QQMAIL", 4);
        if (this.duR == null) {
            return true;
        }
        this.fGL = this.duR.getLong("qqmail_downloadid", -1);
        this.miq = ((Integer) new ReadMailProxy(this.iMQ, null).REMOTE_CALL("getMailAppDownloadStatus", Long.valueOf(this.fGL))).intValue();
        this.mir = this.duR.getString("qqmail_downloadpath", "");
        if (this.miq == 3 && e.cn(this.mir)) {
            this.miu = 2;
            bpg();
            if (this.mis != null) {
                this.mis.SO();
            }
            return true;
        } else if (this.mik == 1) {
            return false;
        } else {
            this.mif.setVisibility(8);
            x.e("MicroMsg.ReadMailUI", "promote qq mail error:MailAppRecomend = %d", new Object[]{Integer.valueOf(this.mik)});
            return true;
        }
    }

    private void bpj() {
        if (bi.oW(this.mim)) {
            x.e("MicroMsg.ReadMailUI", "mQQMailRedirectUrl = null");
            return;
        }
        vb(0);
        x.i("MicroMsg.ReadMailUI", "status:%d", new Object[]{Integer.valueOf(this.miq)});
        switch (this.miq) {
            case 1:
            case 2:
                this.miu = 1;
                bpk();
                bpg();
                return;
            case 3:
                if (e.cn(this.mir)) {
                    return;
                }
                break;
        }
        this.miu = 0;
        vb(0);
        bpg();
    }

    private void vb(int i) {
        LayoutParams layoutParams = (LayoutParams) this.mig.getLayoutParams();
        layoutParams.width = i;
        this.mig.setLayoutParams(layoutParams);
    }

    private void bpk() {
        this.mis = new al(Looper.getMainLooper(), new 4(this), true);
        this.mis.J(500, 500);
    }

    private void dm(int i, int i2) {
        new ReadMailProxy(this.iMQ, null).REMOTE_CALL("reportKvState", Integer.valueOf(i), Integer.valueOf(i2));
    }

    protected void onResume() {
        if (this.mik == 1 && !bpi()) {
            bpj();
        }
        super.onResume();
    }
}

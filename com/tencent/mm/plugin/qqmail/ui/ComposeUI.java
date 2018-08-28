package com.tencent.mm.plugin.qqmail.ui;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.KeyEvent;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.qqmail.b.c;
import com.tencent.mm.plugin.qqmail.b.d;
import com.tencent.mm.plugin.qqmail.b.e;
import com.tencent.mm.plugin.qqmail.b.i;
import com.tencent.mm.plugin.qqmail.b.j;
import com.tencent.mm.plugin.qqmail.b.j.a;
import com.tencent.mm.plugin.qqmail.b.p$a;
import com.tencent.mm.plugin.qqmail.b.p$c;
import com.tencent.mm.plugin.qqmail.b.t;
import com.tencent.mm.plugin.qqmail.b.u;
import com.tencent.mm.plugin.qqmail.b.v;
import com.tencent.mm.plugin.qqmail.b.w;
import com.tencent.mm.pluginsdk.ui.tools.l;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.WebView;
import java.io.File;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@SuppressLint({"SetJavaScriptEnabled"})
public class ComposeUI extends MMActivity {
    private static List<i> mew;
    private int mce = 1;
    private Map<String, String> mdB = new HashMap();
    private v mdu = w.box();
    private LinearLayout meA;
    private LinearLayout meB;
    private MailAddrsViewControl meC;
    private ImageView meD;
    private LinearLayout meE;
    private MailAddrsViewControl meF;
    private ImageView meG;
    private EditText meH;
    private LinearLayout meI;
    private TextView meJ;
    private ImageView meK;
    private LinearLayout meL;
    private TextView meM;
    private EditText meN;
    private WebView meO;
    private j meP;
    private b meQ;
    public c meR = new c(this);
    private p meS;
    private String meT;
    private o meU;
    public boolean meV = true;
    public boolean meW = true;
    public boolean meX = false;
    private String meY = ("(function() { \nvar imgList = document.getElementsByTagName('img');var result = ''; \nfor (var i = 0; i < imgList.length; i++) {var img = imgList[i];var info = img.id + '@@' + img.src;result += info + '&&'}return result;" + "})()".trim());
    private String meZ = "document.getElementById('history').innerHTML";
    private long mea;
    private ScrollView mex;
    protected MailAddrsViewControl mey;
    private ImageView mez;
    private String mfa = "<div id=\"htmlContent\" contenteditable=\"true\" >";
    private String mfb = "</div>";
    private String mfc = null;
    private String mfd = null;
    private String mfe = "weixin://get_img_info/";
    private String mff = "weixin://get_mail_content/";
    private String mfg = "weixin://img_onclick/";
    private boolean mfh = false;
    private boolean mfi = false;
    private al mfj = new al(new 1(this), true);
    private al mfk = new al(new 12(this), true);
    a mfl = new 17(this);
    private OnClickListener mfm = new 7(this);
    private OnClickListener mfn = new 8(this);
    private OnMenuItemClickListener mfo = new 10(this);
    private OnClickListener mfp = new 11(this);
    private OnClickListener mfq = new 13(this);
    private p$a mfr = new 15(this);
    private int mode = 5;

    static /* synthetic */ long H(ComposeUI composeUI) {
        Map hashMap = new HashMap();
        hashMap.put("from", "");
        hashMap.put("to", composeUI.mey.getAddrsString());
        hashMap.put("cc", composeUI.meC.getAddrsString());
        hashMap.put("bcc", composeUI.meF.getAddrsString());
        hashMap.put("subject", composeUI.getSubject());
        hashMap.put("content", composeUI.boK());
        hashMap.put("attachlist", composeUI.meQ.boR());
        hashMap.put("sendtype", (composeUI.mce == 4 ? 1 : composeUI.mce));
        hashMap.put("oldmailid", composeUI.meT);
        p$c p_c = new p$c();
        p_c.mdl = false;
        p_c.mdk = true;
        return w.bow().a("/cgi-bin/composesendwithattach", hashMap, p_c, composeUI.mfr);
    }

    static /* synthetic */ void b(ComposeUI composeUI) {
        d dVar = new d();
        dVar.mce = composeUI.mce;
        dVar.mcf = composeUI.meT;
        dVar.mcg = composeUI.mey.getMailAddrs();
        dVar.mch = composeUI.meC.getMailAddrs();
        dVar.mci = composeUI.meF.getMailAddrs();
        dVar.mck = composeUI.meH.getText().toString();
        dVar.mcj = composeUI.meQ.boS();
        if (composeUI.mode != 6 && composeUI.mode == 5) {
            dVar.content = composeUI.boK();
            dVar.mcl = composeUI.mode;
            x.i("MicroMsg.ComposeUI", "save draft mail as normal mode");
        }
        c cVar = w.bow().mda;
        try {
            cVar.mcd.bok();
            e.r(cVar.mcd.mcn + c.bV(dVar.mcf, dVar.mce), dVar.toByteArray());
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.DraftBoxMgr", e, "", new Object[0]);
        }
    }

    static /* synthetic */ void r(ComposeUI composeUI) {
        Map map;
        String str = null;
        au.HU();
        String oVar = new com.tencent.mm.a.o(((Integer) com.tencent.mm.model.c.DT().get(9, null)).intValue()).toString();
        oVar = !bi.oW(oVar) ? oVar + "@qq.com" : null;
        u uVar = new u();
        uVar.bSS = oVar;
        uVar.mck = composeUI.getSubject();
        if (!bi.oW(composeUI.mey.getAddrsString())) {
            uVar.mcN = composeUI.mey.getAddrsString().split(",");
        }
        if (!bi.oW(composeUI.meC.getAddrsString())) {
            uVar.mcO = composeUI.meC.getAddrsString().split(",");
        }
        if (!bi.oW(composeUI.meF.getAddrsString())) {
            uVar.mcP = composeUI.meF.getAddrsString().split(",");
        }
        oVar = composeUI.boK();
        if (!bi.oW(oVar)) {
            str = oVar.replaceAll("src=\"file://", "src=\"cid:").replaceAll("height=\"100\"", "style=\"max-width: 200px; max-width:300px;\"");
        }
        uVar.mdA = str;
        if (composeUI.mdB.size() > 0) {
            map = composeUI.mdB;
            uVar.mdB = new HashMap();
            uVar.mdB.putAll(map);
        }
        x.d("MicroMsg.ComposeUI", "send mail content: \n%s", new Object[]{str});
        x.d("MicroMsg.ComposeUI", "msgImgInfoMap.size: %d", new Object[]{Integer.valueOf(composeUI.mdB.size())});
        x.d("MicroMsg.ComposeUI", "uploadedAttachidMap.size: %d", new Object[]{Integer.valueOf(composeUI.meQ.mgo.size())});
        if (composeUI.meQ.mgo.size() > 0 && composeUI.meQ.mgp.size() > 0) {
            map = composeUI.meQ.mgo;
            uVar.mdC = new LinkedHashMap();
            uVar.mdC.putAll(map);
            map = composeUI.meQ.mgp;
            uVar.mdD = new LinkedHashMap();
            uVar.mdD.putAll(map);
        }
        v vVar = composeUI.mdu;
        if (vVar.mdF == null) {
            vVar.mdF = new t();
        }
        vVar.mdF.a(uVar);
        composeUI.mfi = false;
        h.bA(composeUI.mController.tml, composeUI.getString(R.l.finish_sent));
        ah.i(new 14(composeUI), 800);
    }

    static /* synthetic */ void y(ComposeUI composeUI) {
        composeUI.mez.setVisibility(4);
        composeUI.meD.setVisibility(4);
        composeUI.meG.setVisibility(4);
    }

    protected final int getLayoutId() {
        return R.i.qqmail_compose;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mfc = this.mfa + "%s" + this.mfb;
        this.mfh = false;
        this.mfi = false;
        this.mce = getIntent().getIntExtra("composeType", 1);
        this.meT = getIntent().getStringExtra("mailid");
        if (this.meT == null) {
            this.meT = "";
        }
        this.mode = getIntent().getIntExtra("mail_mode", 5);
        x.d("MicroMsg.ComposeUI", "onCreate, mode = %d", new Object[]{Integer.valueOf(this.mode)});
        initView();
        this.meP = w.bow().mcZ;
        this.meP.a(this.mfl);
        this.meP.bom();
        this.mfk.J(180000, 180000);
    }

    protected void onResume() {
        super.onResume();
        this.mfj.J(1500, 1500);
    }

    protected void onPause() {
        super.onPause();
        YC();
        this.mfj.SO();
        if (this.meU != null) {
            this.meU.dismiss();
        }
    }

    public void onDestroy() {
        super.onDestroy();
        if (mew != null) {
            mew = null;
        }
        this.meQ.boT();
        au.DF().b(484, this.meQ);
        this.meP.b(this.mfl);
        this.meR.release();
        this.mfk.SO();
    }

    private void boI() {
        this.mey.clearFocus();
        this.meC.clearFocus();
        this.meF.clearFocus();
    }

    protected final void initView() {
        String str;
        CharSequence charSequence;
        this.mex = (ScrollView) findViewById(R.h.qqmail_compose_container_sv);
        this.mey = (MailAddrsViewControl) findViewById(R.h.qqmail_compose_addr_to_control);
        this.mez = (ImageView) findViewById(R.h.qqmail_compose_add_to_iv);
        this.meA = (LinearLayout) findViewById(R.h.qqmail_compose_ccbacc_ll);
        this.meB = (LinearLayout) findViewById(R.h.qqmail_compose_addr_cc_fl);
        this.meC = (MailAddrsViewControl) findViewById(R.h.qqmail_compose_addr_cc_control);
        this.meD = (ImageView) findViewById(R.h.qqmail_compose_add_cc_iv);
        this.meE = (LinearLayout) findViewById(R.h.qqmail_compose_addr_bcc_fl);
        this.meF = (MailAddrsViewControl) findViewById(R.h.qqmail_compose_addr_bcc_control);
        this.meG = (ImageView) findViewById(R.h.qqmail_compose_add_bcc_iv);
        this.meH = (EditText) findViewById(R.h.qqmail_compose_subject_et);
        this.meI = (LinearLayout) findViewById(R.h.qqmail_compose_add_attach_ll);
        this.meM = (TextView) findViewById(R.h.plugin_qqmail_compose_reply_hint_tv);
        this.meN = (EditText) findViewById(R.h.qqmail_compose_content_et);
        this.meO = MMWebView.a.l(this, R.h.qqmail_compose_content_web);
        this.meJ = (TextView) findViewById(R.h.qqmail_compose_attach_summary_iv);
        this.meK = (ImageView) findViewById(R.h.qqmail_compose_attach_summary_icon);
        this.meL = (LinearLayout) findViewById(R.h.plugin_qqmail_compose_attachment_container);
        this.mey.setEditable(true);
        this.meC.setEditable(true);
        this.meF.setEditable(true);
        CharSequence stringExtra = getIntent().getStringExtra("mail_content");
        List<String> stringArrayListExtra = getIntent().getStringArrayListExtra("mail_attach");
        List stringArrayListExtra2 = getIntent().getStringArrayListExtra("mail_attach_title");
        d bU = w.bow().mda.bU(this.meT, this.mce);
        this.meQ = new b(this, this.meJ, this.meK, this.meL, (byte) 0);
        if (!bi.oW(stringExtra)) {
            x.i("MicroMsg.ComposeUI", "read mail from extra");
            if (this.mode == 6) {
                boJ();
                this.mey.requestFocus();
                this.mfd = String.format(this.mfc, new Object[]{stringExtra});
                this.meO.loadDataWithBaseURL("", this.mfd, "text/html", "utf-8", "");
                this.meN.setVisibility(8);
                this.meO.setVisibility(0);
            } else if (this.mode == 5) {
                this.meN.setVisibility(0);
                this.meO.setVisibility(8);
                if (stringExtra.indexOf("<div>") != -1) {
                    x.i("MicroMsg.ComposeUI", "set content in html format");
                    this.meN.setText(Html.fromHtml(stringExtra));
                } else {
                    this.meN.setText(stringExtra);
                }
            }
            this.meQ.mode = this.mode;
            if (this.mode == 6) {
                int i = 0;
                for (String str2 : stringArrayListExtra) {
                    File file = new File(str2);
                    if (file.exists()) {
                        if (((int) file.length()) + this.meQ.boW() > 52428800) {
                            h.a(this, R.l.plugin_qqmail_upload_attach_size_exceed, R.l.app_tip, null);
                            break;
                        }
                        x.i("MicroMsg.ComposeUI", "in upload file mode = %d", new Object[]{Integer.valueOf(this.mode)});
                        int i2 = i + 1;
                        this.meQ.eg(str2, (String) stringArrayListExtra2.get(i));
                        i = i2;
                    }
                }
            }
        } else if (bU == null || this.mode != 6) {
            x.i("MicroMsg.ComposeUI", "no extra or draf mail content");
            if (this.mode == 6) {
                boJ();
                this.mey.requestFocus();
                this.mfd = String.format(this.mfc, new Object[]{""});
                this.meO.loadDataWithBaseURL("", this.mfd, "text/html", "utf-8", "");
                this.meN.setVisibility(8);
                this.meO.setVisibility(0);
            } else if (this.mode == 5) {
                this.meO.setVisibility(8);
                this.meN.setVisibility(0);
            }
            this.meQ.mode = this.mode;
        } else {
            x.i("MicroMsg.ComposeUI", "read mail from draftMail");
            this.mey.bO(bU.mcg);
            this.meC.bO(bU.mch);
            this.meF.bO(bU.mci);
            this.meH.setText(bU.mck);
            charSequence = bU.content;
            this.mode = 5;
            if (charSequence.indexOf("<div>") != -1) {
                x.i("MicroMsg.ComposeUI", "set content in html format");
                this.meN.setText(Html.fromHtml(charSequence));
            } else {
                this.meN.setText(charSequence);
            }
            this.meQ.mode = this.mode;
            this.meQ.bN(bU.mcj);
            this.meQ.boV();
            this.meO.setVisibility(8);
            this.meN.setVisibility(0);
        }
        String[] stringArrayExtra;
        if (this.mce != 1) {
            stringArrayExtra = getIntent().getStringArrayExtra("toList");
            String[] stringArrayExtra2 = getIntent().getStringArrayExtra("ccList");
            String[] stringArrayExtra3 = getIntent().getStringArrayExtra("bccList");
            String stringExtra2 = getIntent().getStringExtra("subject");
            this.mey.a(stringArrayExtra, false);
            this.meC.a(stringArrayExtra2, false);
            this.meF.a(stringArrayExtra3, false);
            if (!bi.oW(stringExtra2)) {
                EditText editText = this.meH;
                StringBuilder stringBuilder = new StringBuilder();
                if (this.mce == 2) {
                    str2 = "Re:";
                } else {
                    str2 = "Fwd:";
                }
                editText.setText(stringBuilder.append(str2).append(stringExtra2).toString());
            }
        } else if (this.mce == 2 || this.mce == 3) {
            this.meM.setVisibility(0);
        } else if (this.mce == 4) {
            stringArrayExtra = getIntent().getStringArrayExtra("toList");
            if (stringArrayExtra != null && stringArrayExtra.length > 0) {
                this.mey.a(stringArrayExtra, false);
            }
        } else if (this.mce == 1) {
            charSequence = getIntent().getStringExtra("subject");
            if (!bi.oW(charSequence)) {
                this.meH.setText(charSequence);
            }
        }
        if (this.meC.getMailAddrs().size() > 0 || this.meF.getMailAddrs().size() > 0) {
            this.meA.setVisibility(8);
            this.meB.setVisibility(0);
            this.meE.setVisibility(0);
        }
        if (this.mce == 2 && this.mode != 6 && this.mode == 5) {
            this.meN.requestFocus();
            this.meN.setSelection(0);
            this.mex.postDelayed(new 18(this), 1000);
        }
        this.mey.setOnActionListener(new c(this, this.mez, 0));
        this.meC.setOnActionListener(new c(this, this.meD, 1));
        this.meF.setOnActionListener(new c(this, this.meG, 2));
        19 19 = new 19(this);
        this.mey.setInvalidMailAddrListener(19);
        this.meC.setInvalidMailAddrListener(19);
        this.meF.setInvalidMailAddrListener(19);
        this.mez.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                Intent intent = new Intent(ComposeUI.this, MailAddrListUI.class);
                intent.putExtra("INIT_SELECTED_ADDRS_INTENT_EXTRA", ComposeUI.this.mey.a(false, null));
                intent.putExtra("MMActivity.OverrideExitAnimation", R.a.push_down_out);
                intent.putExtra("MMActivity.OverrideEnterAnimation", R.a.fast_faded_in);
                ComposeUI.this.startActivityForResult(intent, 0);
                ComposeUI.this.overridePendingTransition(R.a.push_up_in, R.a.fast_faded_out);
            }
        });
        this.meD.setOnClickListener(new 21(this));
        this.meG.setOnClickListener(new 22(this));
        this.meA.setOnClickListener(this.mfm);
        ImageView imageView = (ImageView) findViewById(R.h.qqmail_compose_subject_clear_iv);
        if (this.meW && this.meH.getText().length() > 0) {
            imageView.setVisibility(0);
        }
        this.meH.setOnFocusChangeListener(new 23(this));
        this.meH.addTextChangedListener(new 2(this, imageView));
        imageView.setOnClickListener(new 3(this));
        this.meI.setOnClickListener(this.mfn);
        setMMTitle(R.l.plugin_qqmail_composeui_title);
        if (getIntent().getBooleanExtra("show_qqmail", false)) {
            au.HU();
            int intValue = ((Integer) com.tencent.mm.model.c.DT().get(9, Integer.valueOf(0))).intValue();
            if (intValue == 0) {
                x.w("MicroMsg.ComposeUI", "want to show qqmail address, but unbind qq");
            } else {
                setMMSubTitle(new com.tencent.mm.a.o(intValue) + "@qq.com");
            }
        }
        setBackBtn(this.mfo);
        if (this.mode == 5) {
            addTextOptionMenu(0, getString(R.l.app_send), new 4(this));
        } else if (this.mode == 6) {
            x.i("MicroMsg.ComposeUI", "set onShareModeSendListener");
            addTextOptionMenu(0, getString(R.l.app_send), new 5(this));
        }
        enableOptionMenu(false);
        boI();
    }

    private void boJ() {
        if (this.meO != null) {
            this.meO.clearFocus();
            this.meO.getSettings().setJavaScriptEnabled(true);
            this.meO.setWebViewClient(new b(this, (byte) 0));
            this.meO.setWebChromeClient(new a(this, (byte) 0));
            this.meO.setOnTouchListener(new 6(this));
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        this.mfo.onMenuItemClick(null);
        return true;
    }

    private void auu() {
        if (!l.c(this, com.tencent.mm.compatible.util.e.dgl, "microMsg." + System.currentTimeMillis() + ".jpg", 3)) {
            Toast.makeText(this, getString(R.l.selectcameraapp_none), 1).show();
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        x.i("MicroMsg.ComposeUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId())});
        switch (i) {
            case 16:
                if (iArr[0] == 0) {
                    auu();
                    return;
                } else {
                    h.a(this, getString(R.l.permission_camera_request_again_msg), getString(R.l.permission_tips_title), getString(R.l.jump_to_settings), getString(R.l.cancel), false, new 9(this), null);
                    return;
                }
            default:
                return;
        }
    }

    private String boK() {
        if (this.mode == 6) {
            s.a(this.meO, this.mff, this.meZ);
            if (this.mfd != null) {
                int indexOf = this.mfd.indexOf(this.mfa);
                int lastIndexOf = this.mfd.lastIndexOf(this.mfb);
                if (indexOf == -1 || lastIndexOf == -1) {
                    return this.mfd;
                }
                return this.mfd.substring(indexOf + this.mfa.length(), lastIndexOf + this.mfb.length());
            }
        } else if (this.mode == 5) {
            return this.meN.getText().toString();
        }
        return null;
    }

    private String getSubject() {
        int i = 40;
        String obj = this.meH.getText().toString();
        if (obj.trim().length() > 0) {
            return obj;
        }
        obj = boK();
        if (this.mode == 5) {
            if (obj.length() > 0) {
                if (obj.length() <= 40) {
                    i = obj.length();
                }
                return obj.substring(0, i);
            }
        } else if (this.mode == 6 && !bi.oW(obj)) {
            if (obj.length() <= 40) {
                i = obj.length();
            }
            return obj.substring(0, i);
        }
        return getString(R.l.plugin_qqmail_composeui_nosubject);
    }

    protected final boolean boL() {
        if (!this.mey.bpa()) {
            Toast.makeText(this, R.l.plugin_qqmail_composeui_toaddr_invalid, 1).show();
            return false;
        } else if (!this.meC.bpa()) {
            Toast.makeText(this, R.l.plugin_qqmail_composeui_ccaddr_invalid, 1).show();
            return false;
        } else if (!this.meF.bpa()) {
            Toast.makeText(this, R.l.plugin_qqmail_composeui_bccaddr_invalid, 1).show();
            return false;
        } else if ((this.mey.getMailAddrs().size() + this.meC.getMailAddrs().size()) + this.meF.getMailAddrs().size() <= 20) {
            return true;
        } else {
            Toast.makeText(this, R.l.plugin_qqmail_svr_error_desc_101, 1).show();
            return false;
        }
    }

    static void bM(List<i> list) {
        mew = list;
    }

    private static void a(MailAddrsViewControl mailAddrsViewControl) {
        if (mew != null) {
            mailAddrsViewControl.setMailAdds(mew);
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1) {
            String d;
            switch (i) {
                case 0:
                    a(this.mey);
                    showVKB();
                    return;
                case 1:
                    a(this.meC);
                    showVKB();
                    return;
                case 2:
                    a(this.meF);
                    showVKB();
                    return;
                case 3:
                    au.HU();
                    d = l.d(this, intent, com.tencent.mm.model.c.Gb());
                    if (d != null) {
                        JY(d);
                        boI();
                        return;
                    }
                    return;
                case 4:
                    if (intent != null) {
                        au.HU();
                        d = com.tencent.mm.ui.tools.a.e(this, intent, com.tencent.mm.model.c.Gb());
                        if (d != null && d.length() > 0) {
                            JY(d);
                            boI();
                            return;
                        }
                        return;
                    }
                    return;
                case 5:
                    if (intent != null) {
                        JY(intent.getStringExtra("choosed_file_path"));
                        boI();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private void JY(String str) {
        File file = new File(str);
        if (!file.exists()) {
            return;
        }
        if (this.meQ.mgm.containsKey(str)) {
            h.i(this.mController.tml, R.l.plugin_qqmail_upload_attach_exist, R.l.app_tip);
            return;
        }
        int length = (int) file.length();
        if (length > 20971520) {
            h.a(this, R.l.plugin_qqmail_upload_attach_single_file_size_exceed, R.l.app_tip, null);
            return;
        }
        h.a(this, getString(R.l.plugin_qqmail_upload_attach_size_tip, new Object[]{bi.bF((long) length)}), getString(R.l.app_tip), new 16(this, length, file, str), null);
    }

    public void setRequestedOrientation(int i) {
    }
}

package com.tencent.mm.plugin.ipcall.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.ipcall.a.d.b;
import com.tencent.mm.plugin.ipcall.a.d.c;
import com.tencent.mm.protocal.c.ccg;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import java.util.LinkedList;

@a(3)
public class IPCallDialUI extends MMActivity implements e, b.a {
    private TextView eCM;
    private String eWQ;
    private DialPad ksT;
    private TextView ksU;
    private EditText ksV;
    private View ksW;
    private ImageButton ksX;
    private View ksY;
    private TextView ksZ;
    private TextView kta;
    private b kvm;
    private String kvn;
    private String kvo;
    private String kvp;
    private String kvq;
    private int kvr = 0;
    private int kvs = 0;
    private int kvt = -1;
    private LinkedList<ccg> kvu;
    b kvv;
    c kvw;
    private com.tencent.mm.sdk.b.c kvx = new 2(this);

    protected final int getForceOrientation() {
        return 1;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.tencent.mm.sdk.b.a.sFg.b(this.kvx);
        au.DF().a(807, this);
        au.DF().a(746, this);
        getWindow().addFlags(131072);
        setBackBtn(new 1(this), R.k.actionbar_quit_webview_icon);
        this.eWQ = getIntent().getStringExtra("IPCallTalkUI_nickname");
        this.kvn = getIntent().getStringExtra("IPCallTalkUI_phoneNumber");
        this.kvo = getIntent().getStringExtra("IPCallTalkUI_contactId");
        this.kvp = getIntent().getStringExtra("IPCallTalkUI_countryCode");
        this.kvq = getIntent().getStringExtra("IPCallTalkUI_toWechatUsername");
        this.kvr = getIntent().getIntExtra("IPCallTalkUI_dialScene", 0);
        x.i("MicroMsg.IPCallDialUI", "onCreate nickName:%s, phoneNumber:%s, contactId:%s, countryCode:%s, toUserName:%s, dialScene:%d", new Object[]{this.eWQ, this.kvn, this.kvo, this.kvp, this.kvq, Integer.valueOf(this.kvr)});
        if (!bi.oW(this.kvn)) {
            this.kvn = com.tencent.mm.plugin.ipcall.b.c.Fx(this.kvn);
        }
        if (bi.oW(this.kvp)) {
            if (com.tencent.mm.plugin.ipcall.b.a.Fr(this.kvn)) {
                if (bi.oW(com.tencent.mm.plugin.ipcall.b.a.Fp(this.kvn))) {
                    this.kvn = com.tencent.mm.plugin.ipcall.b.a.Fs(this.kvn);
                } else {
                    x.i("MicroMsg.IPCallDialUI", "country code exist, directly go to talk ui.");
                    this.kvs = 4;
                    Intent intent = new Intent(this, IPCallTalkUI.class);
                    intent.putExtra("IPCallTalkUI_contactId", this.kvo);
                    intent.putExtra("IPCallTalkUI_countryCode", this.kvp);
                    intent.putExtra("IPCallTalkUI_nickname", this.eWQ);
                    intent.putExtra("IPCallTalkUI_phoneNumber", this.kvn);
                    intent.putExtra("IPCallTalkUI_dialScene", this.kvr);
                    intent.putExtra("IPCallTalkUI_countryType", this.kvs);
                    startActivityForResult(intent, 1001);
                    finish();
                    return;
                }
            }
            this.kvp = com.tencent.mm.plugin.ipcall.b.c.aYB();
        }
        if (this.kvr != 1) {
            this.kvt = 0;
            this.kvs = 3;
            this.kvv = new b(this.kvn, this.kvp, "", bi.fS(this), this.kvr);
            au.DF().a(this.kvv, 0);
        } else {
            this.kvt = -1;
            this.kvs = 4;
        }
        init();
    }

    public void onStart() {
        super.onStart();
        this.kvw = new c();
        au.DF().a(this.kvw, 0);
    }

    protected void onResume() {
        x.d("MicroMsg.IPCallDialUI", "onResume");
        super.onResume();
    }

    protected final int getLayoutId() {
        return R.i.ip_call_dial_ui;
    }

    private void init() {
        x.i("MicroMsg.IPCallDialUI", "summerper checkPermission checkMicrophone[%b],stack[%s]", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.permission.a.a(this, "android.permission.RECORD_AUDIO", 80, null, null)), bi.cjd()});
        if (com.tencent.mm.pluginsdk.permission.a.a(this, "android.permission.RECORD_AUDIO", 80, null, null)) {
            setMMTitle(R.l.ip_call_dial_title);
            setVolumeControlStream(1);
            this.ksT = (DialPad) findViewById(R.h.dial_pad);
            this.ksU = (TextView) findViewById(R.h.country_code_tv);
            this.ksY = findViewById(R.h.country_code_icon_ll);
            this.ksV = (EditText) findViewById(R.h.phonenumber_tv);
            this.ksW = findViewById(R.h.phonenumber_del_button);
            this.eCM = (TextView) findViewById(R.h.dial_ui_username_tv);
            this.ksX = (ImageButton) findViewById(R.h.dial_button);
            this.ksZ = (TextView) findViewById(R.h.country_name_tv);
            this.kta = (TextView) findViewById(R.h.dial_free_tv);
            this.kvm = new b(this, this.ksV, this.ksU, this.ksW, this.ksT, this.ksX, this.eCM, this.ksY, this.ksZ, this.kta);
            this.kvm.ksS = this;
            if (!bi.oW(this.kvn)) {
                this.kvm.bx(this.kvn, -1);
            }
            if (!bi.oW(this.kvp)) {
                this.kvm.EW(this.kvp);
            }
            if (!(bi.oW(this.kvn) || bi.oW(this.kvp))) {
                this.kvm.aYa();
            }
            this.kvm.U(this.kvu);
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        b bVar = this.kvm;
        x.d("MicroMsg.DialPadController", "onActivityResult");
        if (i == 100 && i2 == 100) {
            String aG = bi.aG(intent.getStringExtra("country_name"), "");
            String aG2 = bi.aG(intent.getStringExtra("couttry_code"), "");
            x.d("MicroMsg.DialPadController", "onActivityResult, countryName: %s, countryCode: %s", new Object[]{aG2, aG});
            if (!bi.oW(aG2) && !bi.oW(aG)) {
                bVar.ktb = aG;
                bVar.ktc = "+" + aG2;
                bVar.ksU.setText(bVar.ktc);
                bVar.ktd = b.dr(aG2.replace("+", ""), bVar.ktd);
                bVar.bx(bVar.ktd, -1);
                bVar.kth = false;
            }
        } else if (i == 1001 && i2 == -1) {
            intent.getBooleanExtra("IPCallTalkUI_TalkIsOverdue", false);
            bVar.bGc.setResult(-1, intent);
            bVar.bGc.finish();
        }
    }

    public final void l(String str, String str2, String str3, String str4) {
        x.i("MicroMsg.IPCallDialUI", "onDial, countryCode: %s, phoneNumber: %s, contactId: %s, nickname: %s", new Object[]{str, str2, str3, str4});
        if (!com.tencent.mm.plugin.ipcall.b.c.dK(this)) {
            return;
        }
        if (com.tencent.mm.plugin.ipcall.a.c.aXb().ru(bi.getInt(str, -1))) {
            h.b(this, getString(R.l.callout_country_restriction_hint), getString(R.l.callout_country_restriction_hint_title), true);
            com.tencent.mm.plugin.report.service.h.mEJ.k(12058, str);
            return;
        }
        com.tencent.mm.plugin.report.service.h.mEJ.h(12059, new Object[]{Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1)});
        Intent intent = new Intent(this, IPCallTalkUI.class);
        intent.putExtra("IPCallTalkUI_contactId", str3);
        intent.putExtra("IPCallTalkUI_countryCode", str);
        intent.putExtra("IPCallTalkUI_nickname", str4);
        intent.putExtra("IPCallTalkUI_phoneNumber", str2);
        intent.putExtra("IPCallTalkUI_dialScene", this.kvr);
        intent.putExtra("IPCallTalkUI_countryType", this.kvs);
        startActivityForResult(intent, 1001);
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.kvm != null) {
            this.kvm.ksS = null;
        }
        com.tencent.mm.sdk.b.a.sFg.c(this.kvx);
        au.DF().b(807, this);
        au.DF().b(746, this);
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        x.i("MicroMsg.IPCallDialUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId())});
        switch (i) {
            case 80:
                if (iArr[0] == 0) {
                    init();
                    return;
                } else {
                    h.a(this, getString(R.l.permission_microphone_request_again_msg), getString(R.l.permission_tips_title), getString(R.l.jump_to_settings), getString(R.l.cancel), false, new 3(this), new 4(this));
                    return;
                }
            default:
                return;
        }
    }

    public final void a(int i, int i2, String str, l lVar) {
        if (lVar instanceof b) {
            if (i == 0 && i2 == 0 && lVar == this.kvv) {
                if (this.kvv.kri != null) {
                    x.i("MicroMsg.IPCallDialUI", "Response Result:%d,PureNumber:%s,CountryCode:%s", new Object[]{Integer.valueOf(this.kvv.kri.rsj), this.kvv.kri.sei, this.kvv.kri.kAk});
                }
                if (this.kvt != 2) {
                    this.kvt = 1;
                    this.kvs = 1;
                    b bVar = this.kvv;
                    int i3 = (bVar.kri == null || bVar.kri.rsj != 2) ? 0 : 1;
                    if (i3 != 0) {
                        x.i("MicroMsg.IPCallDialUI", "check error show error dialog");
                        return;
                    }
                    bVar = this.kvv;
                    i3 = (bVar.kri == null || !(bVar.kri.rsj == 1 || bVar.kri.rsj == 0)) ? 0 : 1;
                    if (i3 != 0) {
                        if (this.kvv.kri == null || bi.oW(this.kvv.kri.kAk)) {
                            x.i("MicroMsg.IPCallDialUI", "response country code is empty, ignore");
                        } else if (this.kvm != null) {
                            x.i("MicroMsg.IPCallDialUI", "response country code:%s, old country code:%s", new Object[]{this.kvv.kri.kAk, this.kvp});
                            this.kvp = this.kvv.kri.kAk;
                            this.kvm.EW(this.kvv.kri.kAk);
                        }
                    }
                    if (this.kvv.kri != null && !bi.oW(this.kvv.kri.sei) && this.kvm != null) {
                        x.i("MicroMsg.IPCallDialUI", "response number:%s, old number:%s", new Object[]{this.kvv.kri.sei, this.kvn});
                        this.kvn = this.kvv.kri.sei;
                        this.kvm.bx(this.kvv.kri.sei, -1);
                        return;
                    }
                    return;
                }
                x.i("MicroMsg.IPCallDialUI", "NetSceneIPCallCheckNumber onSceneEnd, mCheckNumberStatus = userModify, ignore");
            }
        } else if (lVar instanceof c) {
            if (i == 0 && i2 == 0) {
                this.kvu = ((c) lVar).krk.rMv;
            } else {
                this.kvu = null;
            }
            if (this.kvm != null) {
                this.kvm.U(this.kvu);
            }
        }
    }

    public final void EX(String str) {
        x.i("MicroMsg.IPCallDialUI", "onModifyCountryCodeByUser:countryCode:%s,mCountryCode:%s", new Object[]{str, this.kvp});
        if (this.kvt != 2 && this.kvt != -1 && !this.kvp.equals(str)) {
            aYi();
        }
    }

    public final void EY(String str) {
        x.i("MicroMsg.IPCallDialUI", "onModifyPhoneNumberByUser:phoneNumber:%s,mPhoneNumber:%s", new Object[]{str, this.kvn});
        if (this.kvt != 2 && this.kvt != -1 && !this.kvn.equals(str)) {
            aYi();
        }
    }

    private void aYi() {
        x.i("MicroMsg.IPCallDialUI", "modifyCountryCodeByUsder");
        this.kvt = 2;
        if (this.kvs == 1) {
            this.kvs = 2;
        } else {
            this.kvs = 4;
        }
    }
}

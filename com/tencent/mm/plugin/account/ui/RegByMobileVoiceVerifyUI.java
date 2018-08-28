package com.tencent.mm.plugin.account.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.al.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelfriend.a;
import com.tencent.mm.plugin.account.a$f;
import com.tencent.mm.plugin.account.a$g;
import com.tencent.mm.plugin.account.a.j;
import com.tencent.mm.plugin.account.friend.a.x;
import com.tencent.mm.ui.MMActivity;

public class RegByMobileVoiceVerifyUI extends MMActivity implements e {
    private String bTi;
    private String eHy;
    private a eNv;
    private TextView ePz;
    private String eQH;
    private String eVK;
    private x eVM;
    private int eVN = 0;

    static /* synthetic */ int d(RegByMobileVoiceVerifyUI regByMobileVoiceVerifyUI) {
        switch (regByMobileVoiceVerifyUI.eVN) {
            case 0:
                return 14;
            case 2:
                return 8;
            default:
                return 16;
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.bTi = getIntent().getExtras().getString("bindmcontact_mobile");
        this.eVN = getIntent().getExtras().getInt("voice_verify_type");
        if (this.eVN == 0 || this.eVN == 2 || this.eVN == 3) {
            g.DF().a(145, this);
        } else if (this.eVN == 4 || this.eVN == 1) {
            g.DF().a(132, this);
        }
        this.eHy = com.tencent.mm.plugin.c.a.Zu();
        initView();
    }

    protected void onResume() {
        super.onResume();
        if (this.eVN == 0 || this.eVN == 2 || this.eVN == 3) {
            StringBuilder stringBuilder = new StringBuilder();
            g.Eg();
            stringBuilder = stringBuilder.append(com.tencent.mm.kernel.a.DA()).append(",").append(getClass().getName()).append(",R200_500,");
            g.Eg();
            com.tencent.mm.plugin.c.a.d(true, stringBuilder.append(com.tencent.mm.kernel.a.gd("R200_500")).append(",1").toString());
            com.tencent.mm.plugin.c.a.pT("R200_500");
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        g.DF().b(132, this);
        g.DF().b(145, this);
        if (this.eVN == 0 || this.eVN == 2 || this.eVN == 3) {
            StringBuilder stringBuilder = new StringBuilder();
            g.Eg();
            stringBuilder = stringBuilder.append(com.tencent.mm.kernel.a.DA()).append(",").append(getClass().getName()).append(",R200_500,");
            g.Eg();
            com.tencent.mm.plugin.c.a.d(false, stringBuilder.append(com.tencent.mm.kernel.a.gd("R200_500")).append(",2").toString());
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        com.tencent.mm.plugin.c.a.pU(this.eHy);
        YC();
        finish();
        return true;
    }

    protected final void initView() {
        setMMTitle(j.bind_mcontact_voice_verify_voice_title);
        setBackBtn(new 1(this));
        this.ePz = (TextView) findViewById(a$f.languagename);
        Button button = (Button) findViewById(a$f.bind_mcontact_voice_verify_btn);
        this.eQH = RegByMobileVoiceVerifySelectUI.pR(this.bTi);
        this.ePz.setText(this.eQH);
        this.eVK = b.mk(this.bTi);
        findViewById(a$f.ll_current_language).setOnClickListener(new 2(this));
        button.setOnClickListener(new 3(this));
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 10000 && intent != null) {
            this.eQH = intent.getStringExtra("voice_verify_language");
            this.eVK = intent.getStringExtra("voice_verify_code");
            this.ePz.setText(this.eQH);
        }
    }

    protected final int getLayoutId() {
        return a$g.bindmcontact_voice_verify;
    }

    public final void a(int i, int i2, String str, l lVar) {
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.RegByMobileVoiceVerifyUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
    }
}

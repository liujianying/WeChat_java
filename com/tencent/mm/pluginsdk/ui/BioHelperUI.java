package com.tencent.mm.pluginsdk.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.bg.d;
import com.tencent.mm.plugin.account.a$e;
import com.tencent.mm.plugin.account.a.f;
import com.tencent.mm.plugin.account.a.g;
import com.tencent.mm.plugin.account.a.j;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;

public class BioHelperUI extends MMActivity {
    private String eHp;
    private String gtX;
    private int isA;
    private String kxY;
    private int mType;
    private String qEO;
    private b qEP;

    private class c implements b {
        private int fdx;

        private c() {
        }

        /* synthetic */ c(BioHelperUI bioHelperUI, byte b) {
            this();
        }

        public final void am(Intent intent) {
            if (intent != null) {
                this.fdx = intent.getIntExtra("kscene_type", 73);
            }
        }

        public final String cda() {
            return BioHelperUI.this.getString(j.bio_voice_title);
        }

        public final int cdb() {
            return a$e.voice_icon;
        }

        public final String cdc() {
            return BioHelperUI.this.getString(j.bio_help_voice_verify);
        }

        public final String cdd() {
            return BioHelperUI.this.getString(j.bio_default_tips_voice_wording);
        }

        public final void eX(Context context) {
            Intent intent = new Intent();
            intent.putExtra("kscene_type", this.fdx);
            intent.putExtra("Kusername", BioHelperUI.this.gtX);
            intent.putExtra("Kvertify_key", BioHelperUI.this.eHp);
            d.b(context, "voiceprint", ".ui.VoiceLoginUI", intent, 1024);
        }

        public final void e(int i, int i2, Intent intent) {
            int i3 = 0;
            if (i2 == -1) {
                if (i == 1024 && intent != null) {
                    String stringExtra = intent.getStringExtra("VoiceLoginAuthPwd");
                    String str = "MicroMsg.BioHelperUI";
                    String str2 = "onActivityResult, do voiceprint auth, authPwd is null:%b, authPwd.len:%d";
                    Object[] objArr = new Object[2];
                    objArr[0] = Boolean.valueOf(bi.oW(stringExtra));
                    if (!bi.oW(stringExtra)) {
                        i3 = stringExtra.length();
                    }
                    objArr[1] = Integer.valueOf(i3);
                    x.d(str, str2, objArr);
                    Intent intent2 = new Intent();
                    intent2.putExtra("VoiceLoginAuthPwd", stringExtra);
                    intent2.putExtra("KVoiceHelpCode", BioHelperUI.this.isA);
                    BioHelperUI.this.setResult(-1, intent2);
                }
                BioHelperUI.this.finish();
            }
        }
    }

    public void onCreate(Bundle bundle) {
        b bVar = null;
        super.onCreate(bundle);
        this.mType = getIntent().getIntExtra("k_type", 1);
        x.i("MicroMsg.BioHelperUI", "hy: starting to bio helper ui, type: %d", new Object[]{Integer.valueOf(this.mType)});
        this.gtX = bi.aG(getIntent().getStringExtra("Kusername"), null);
        this.eHp = bi.aG(getIntent().getStringExtra("Kvertify_key"), null);
        this.qEO = bi.aG(getIntent().getStringExtra("KVoiceHelpUrl"), null);
        this.kxY = bi.aG(getIntent().getStringExtra("KVoiceHelpWording"), null);
        this.isA = getIntent().getIntExtra("KVoiceHelpCode", 0);
        if (this.mType == 0) {
            bVar = new c(this, (byte) 0);
        } else if (this.mType == 1) {
            bVar = new a(this, (byte) 0);
        } else {
            x.e("MicroMsg.BioHelperUI", "hy: invalid type!!!");
        }
        this.qEP = bVar;
        if (this.qEP == null || bi.oW(this.gtX) || bi.oW(this.eHp)) {
            x.w("MicroMsg.BioHelperUI", "type or username or ticket is null and finish");
            finish();
            return;
        }
        TextView textView = (TextView) findViewById(f.bio_help_tip);
        if (bi.oW(this.kxY)) {
            textView.setText(this.qEP.cdd());
        } else {
            textView.setText(this.kxY);
        }
        setMMTitle(this.qEP.cda());
        ((ImageView) findViewById(f.bio_help_icon)).setImageResource(this.qEP.cdb());
        setBackBtn(new 1(this));
        this.qEP.am(getIntent());
        Button button = (Button) findViewById(f.bio_help_verify_btn);
        button.setText(this.qEP.cdc());
        button.setOnClickListener(new 2(this));
        findViewById(f.bio_help_other_verify_btn).setOnClickListener(new 3(this));
    }

    protected final int getLayoutId() {
        return g.bio_help;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        boolean z = true;
        super.onActivityResult(i, i2, intent);
        String str = "MicroMsg.BioHelperUI";
        String str2 = "onActivityResult, requestCode:%d, resultCode:%d, data==null:%b";
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Integer.valueOf(i2);
        if (intent != null) {
            z = false;
        }
        objArr[2] = Boolean.valueOf(z);
        x.i(str, str2, objArr);
        this.qEP.e(i, i2, intent);
    }
}

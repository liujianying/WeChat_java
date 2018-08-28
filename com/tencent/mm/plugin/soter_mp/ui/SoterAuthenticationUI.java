package com.tencent.mm.plugin.soter_mp.ui;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.R;
import com.tencent.mm.plugin.soter.c.g;
import com.tencent.mm.plugin.soter.c.h;
import com.tencent.mm.plugin.soter_mp.a.c;
import com.tencent.mm.plugin.soter_mp.b.d;
import com.tencent.mm.plugin.soter_mp.b.e;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.p;

@a(7)
public class SoterAuthenticationUI extends MMActivity {
    public static a oox = null;
    private String appId = null;
    private p fUo = null;
    private int fromScene = -1;
    private c oow = null;

    static /* synthetic */ void a(SoterAuthenticationUI soterAuthenticationUI, e eVar) {
        soterAuthenticationUI.setResult(-1, b(eVar));
        soterAuthenticationUI.c(eVar);
        soterAuthenticationUI.finish();
    }

    static /* synthetic */ void b(SoterAuthenticationUI soterAuthenticationUI, e eVar) {
        eVar.errCode = 90008;
        eVar.Yy = "user cancelled the authentication process";
        soterAuthenticationUI.setResult(0, b(eVar));
        soterAuthenticationUI.c(eVar);
        soterAuthenticationUI.finish();
    }

    @TargetApi(23)
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (oox != null) {
            a.a(oox);
        }
        oox = new a(this, (byte) 0);
        d dVar = new d();
        e eVar = new e();
        String stringExtra = getIntent().getStringExtra("auth_mode");
        if (bi.oW(stringExtra)) {
            x.e("MicroMsg.SoterAuthenticationUI", "hy: error authen mode : null");
            eVar.errCode = 90003;
            eVar.Yy = "authen mode is null";
        } else {
            try {
                dVar.oot = Byte.parseByte(bi.aG(stringExtra.substring(2), "00"), 16);
                dVar.jgX = getIntent().getStringExtra("challenge");
                dVar.content = getIntent().getStringExtra("auth_content");
                if (!h.bFl()) {
                    x.e("MicroMsg.SoterAuthenticationUI", "hy: not support soter");
                    eVar.errCode = 90001;
                    eVar.Yy = "not support soter";
                } else if (dVar.oot <= (byte) 0) {
                    x.e("MicroMsg.SoterAuthenticationUI", "hy: param error: request mode illegal");
                    eVar.errCode = 90003;
                    eVar.Yy = "resp model error";
                } else if (bi.oW(dVar.jgX)) {
                    x.e("MicroMsg.SoterAuthenticationUI", "hy: param error: challenge null");
                    eVar.errCode = 90004;
                    eVar.Yy = "challenge is null";
                } else if (dVar.jgX.length() >= 512) {
                    x.e("MicroMsg.SoterAuthenticationUI", "hy: param error: challenge too long");
                    eVar.errCode = 90004;
                    eVar.Yy = "challenge is too long. 512 chars at most";
                } else if (bi.oW(dVar.content)) {
                    dVar.content = getString(R.l.soter_authen_put_finger_msg);
                } else if (dVar.content.length() > 42) {
                    x.e("MicroMsg.SoterAuthenticationUI", "hy: param error: content too long. use default");
                    dVar.content = getString(R.l.soter_authen_put_finger_msg);
                }
            } catch (NumberFormatException e) {
                x.e("MicroMsg.SoterAuthenticationUI", "hy: error authen mode format: %s", new Object[]{stringExtra});
                eVar.errCode = 90003;
                eVar.Yy = "authen mode is illegal: number format error. found: " + stringExtra;
                if (eVar.errCode != 0) {
                    int i = com.tencent.mm.plugin.soter_mp.a.a.oob;
                    this.oow = com.tencent.mm.plugin.soter_mp.a.a.a(this, dVar, eVar);
                    if (this.oow == null) {
                        x.e("MicroMsg.SoterAuthenticationUI", "hy: no corresponding authen mode");
                        eVar.errCode = 90003;
                        eVar.Yy = "no corresponding mode";
                        a(eVar);
                        return;
                    }
                    this.fromScene = getIntent().getIntExtra("key_soter_fp_mp_scene", 0);
                    this.appId = getIntent().getStringExtra("key_app_id");
                    this.oow.dd();
                }
                a(eVar);
                return;
            } catch (IndexOutOfBoundsException e2) {
                x.e("MicroMsg.SoterAuthenticationUI", "hy: error authen mode format: %s", new Object[]{stringExtra});
                eVar.errCode = 90003;
                eVar.Yy = "authen mode is illegal: number format error. found: " + stringExtra;
                if (eVar.errCode != 0) {
                    a(eVar);
                    return;
                }
                int i2 = com.tencent.mm.plugin.soter_mp.a.a.oob;
                this.oow = com.tencent.mm.plugin.soter_mp.a.a.a(this, dVar, eVar);
                if (this.oow == null) {
                    x.e("MicroMsg.SoterAuthenticationUI", "hy: no corresponding authen mode");
                    eVar.errCode = 90003;
                    eVar.Yy = "no corresponding mode";
                    a(eVar);
                    return;
                }
                this.fromScene = getIntent().getIntExtra("key_soter_fp_mp_scene", 0);
                this.appId = getIntent().getStringExtra("key_app_id");
                this.oow.dd();
            }
        }
        if (eVar.errCode != 0) {
            a(eVar);
            return;
        }
        int i22 = com.tencent.mm.plugin.soter_mp.a.a.oob;
        this.oow = com.tencent.mm.plugin.soter_mp.a.a.a(this, dVar, eVar);
        if (this.oow == null) {
            x.e("MicroMsg.SoterAuthenticationUI", "hy: no corresponding authen mode");
            eVar.errCode = 90003;
            eVar.Yy = "no corresponding mode";
            a(eVar);
            return;
        }
        this.fromScene = getIntent().getIntExtra("key_soter_fp_mp_scene", 0);
        this.appId = getIntent().getStringExtra("key_app_id");
        this.oow.dd();
    }

    protected void onResume() {
        super.onResume();
        if (this.oow != null) {
            this.oow.onResume();
        }
    }

    protected void onPause() {
        super.onPause();
        if (this.oow != null) {
            this.oow.onPause();
        }
    }

    private void a(e eVar) {
        setResult(1, b(eVar));
        c(eVar);
        finish();
    }

    private static Intent b(e eVar) {
        Bundle bundle = new Bundle();
        bundle.putInt("err_code", eVar.errCode);
        bundle.putString("err_msg", eVar.Yy);
        bundle.putByte("use_mode", eVar.oou);
        bundle.putString("result_json", eVar.bZt);
        bundle.putString("result_json_signature", eVar.oov);
        x.d("MicroMsg.SoterAuthenticationUI", "hy: dump mp soter result: %s", new Object[]{bundle.toString()});
        Intent intent = new Intent();
        intent.putExtras(bundle);
        return intent;
    }

    private void c(e eVar) {
        if (eVar != null && this.fromScene == 0) {
            int i = -1;
            switch (eVar.errCode) {
                case 0:
                    i = 0;
                    break;
                case 90001:
                case 90002:
                case 90003:
                case 90004:
                case 90006:
                case 90007:
                case 90011:
                    i = 2;
                    break;
                case 90008:
                case 90009:
                case 90010:
                    i = 3;
                    break;
            }
            g gVar = g.onG;
            g.m("requireSoterBiometricAuthentication", this.appId, i, eVar.errCode);
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (this.oow != null) {
            this.oow.onRequestPermissionsResult(i, strArr, iArr);
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        a.a(oox);
    }

    protected final int getLayoutId() {
        return -1;
    }
}

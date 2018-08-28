package com.tencent.mm.plugin.voiceprint.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.voiceprint.model.e;
import com.tencent.mm.plugin.voiceprint.model.n;
import com.tencent.mm.plugin.voiceprint.model.n.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public class VoiceLoginUI extends BaseVoicePrintUI implements a {
    private String gtX = null;
    private n oGk = null;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        h.mEJ.h(11557, new Object[]{Integer.valueOf(1)});
        this.gtX = bi.aG(getIntent().getStringExtra("Kusername"), null);
        String aG = bi.aG(getIntent().getStringExtra("Kvertify_key"), null);
        x.d("MicroMsg.VoiceLoginUI", "summerauth onCreate, username:%s loginTicket==null:%b", new Object[]{this.gtX, Boolean.valueOf(bi.oW(aG))});
        if (bi.oW(this.gtX) && bi.oW(aG)) {
            x.e("MicroMsg.VoiceLoginUI", "onCreate error, username and ticket are both null");
            return;
        }
        this.oGk = new n();
        this.oGk.gtX = this.gtX;
        this.oGk.fsy = aG;
        this.oGk.oFr = this;
        n nVar = this.oGk;
        if (bi.oW(nVar.fsy)) {
            au.DF().a(new e(nVar.gtX), 0);
        } else {
            nVar.bIW();
        }
        boolean a = com.tencent.mm.pluginsdk.permission.a.a(this, "android.permission.RECORD_AUDIO", 80, "", "");
        x.i("MicroMsg.VoiceLoginUI", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[]{Boolean.valueOf(a), bi.cjd(), this});
        setBackBtn(new 1(this));
        if (d.fR(23)) {
            getWindow().setStatusBarColor(getResources().getColor(R.e.navpage));
            cqc();
        }
    }

    protected final void bJc() {
        x.d("MicroMsg.VoiceLoginUI", "sendVoice, filename:%s", new Object[]{this.oFK});
        if (!bi.oW(this.oFK) && !bi.oW(this.oFo)) {
            n nVar = this.oGk;
            com.tencent.mm.plugin.voiceprint.model.h hVar = new com.tencent.mm.plugin.voiceprint.model.h(this.oFK, nVar.oFp, nVar.fsy);
            hVar.oEW = true;
            au.DF().a(hVar, 0);
            this.oFF.setEnabled(false);
            this.oFI.bJl();
        }
    }

    protected final void aZW() {
        findViewById(R.h.right_btn).setVisibility(8);
        this.oFI.bJl();
        this.oFI.setTitleText(R.l.voice_print_auth_title);
        this.oFI.bJo();
        this.oFF.setEnabled(false);
    }

    private void goBack() {
        setResult(0);
        finish();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        goBack();
        return true;
    }

    public final void OF(String str) {
        x.d("MicroMsg.VoiceLoginUI", "onGetText");
        this.oFo = str;
        this.oFI.bJn();
        this.oFI.setTipText(str);
        this.oFI.bJm();
        this.oFF.setEnabled(true);
    }

    public final void iH(boolean z) {
        this.oFI.bJm();
        this.oFF.setEnabled(true);
        if (z) {
            x.i("MicroMsg.VoiceLoginUI", "login success[%s]", new Object[]{bi.Xf(this.oGk.eRp)});
            Intent intent = new Intent();
            intent.putExtra("VoiceLoginAuthPwd", this.oGk.eRp);
            setResult(-1, intent);
            finish();
            return;
        }
        x.i("MicroMsg.VoiceLoginUI", "login failed");
        this.oFI.setErr(R.l.voice_print_auth_error);
        this.oFI.bJp();
    }

    public final void bIV() {
        ym(R.l.voice_print_login_network_error);
    }

    public final void bIX() {
        this.oFF.setEnabled(false);
        this.oFF.setVisibility(4);
        this.oFI.bJm();
        this.oFI.setErr(R.l.voice_print_login_blocked_by_limited);
        this.oFI.bJp();
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.oGk != null) {
            n nVar = this.oGk;
            au.DF().b(618, nVar);
            au.DF().b(616, nVar);
            au.DF().b(617, nVar);
            nVar.oFr = null;
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        x.i("MicroMsg.VoiceLoginUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId())});
        switch (i) {
            case 80:
                if (iArr[0] == 0) {
                    bIZ();
                    return;
                } else {
                    com.tencent.mm.ui.base.h.a((Context) this, getString(R.l.permission_microphone_request_again_msg), getString(R.l.permission_tips_title), getString(R.l.jump_to_settings), getString(R.l.cancel), false, new 2(this), new 3(this));
                    return;
                }
            default:
                return;
        }
    }
}

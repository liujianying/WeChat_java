package com.tencent.mm.plugin.voiceprint.ui;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.R;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.voiceprint.model.d;
import com.tencent.mm.plugin.voiceprint.model.j;
import com.tencent.mm.plugin.voiceprint.model.q;
import com.tencent.mm.plugin.voiceprint.model.q.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public class VoiceUnLockUI extends BaseVoicePrintUI implements a {
    private q oGR;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.oGR = new q(this);
        x.d("MicroMsg.VoicePrintUnLockService", "getVoiceText");
        au.DF().a(new d(73, ""), 0);
    }

    protected final void bJc() {
        x.d("MicroMsg.VoiceUnLockUI", "sendVoice, filename:%s", this.oFK);
        if (!bi.oW(this.oFK) && !bi.oW(this.oGR.oFo)) {
            l jVar = new j(this.oFK, this.oGR.oFp);
            jVar.oEW = true;
            au.DF().a(jVar, 0);
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

    public final void OF(String str) {
        this.oFo = str;
        this.oFI.bJn();
        this.oFI.setTipText(str);
        this.oFI.bJm();
        this.oFF.setEnabled(true);
    }

    public final void iI(boolean z) {
        this.oFI.bJm();
        this.oFF.setEnabled(true);
        if (z) {
            x.d("MicroMsg.VoiceUnLockUI", "unlock success");
            bJk();
            return;
        }
        this.oFI.setErr(R.l.voice_print_auth_error);
        this.oFI.bJp();
    }

    protected void bJk() {
        Intent intent = new Intent();
        intent.putExtra("kscene_type", 73);
        intent.setClass(this, VoicePrintFinishUI.class);
        startActivity(intent);
        finish();
    }

    public final void bIV() {
        bJb();
    }

    protected void onDestroy() {
        super.onDestroy();
        e eVar = this.oGR;
        au.DF().b(611, eVar);
        au.DF().b(613, eVar);
        eVar.oFE = null;
    }
}

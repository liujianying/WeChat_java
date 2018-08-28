package com.tencent.mm.pluginsdk.ui;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.bg.d;
import com.tencent.mm.plugin.account.a.e;
import com.tencent.mm.plugin.account.a.j;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class BioHelperUI$a implements BioHelperUI$b {
    final /* synthetic */ BioHelperUI qEQ;

    private BioHelperUI$a(BioHelperUI bioHelperUI) {
        this.qEQ = bioHelperUI;
    }

    /* synthetic */ BioHelperUI$a(BioHelperUI bioHelperUI, byte b) {
        this(bioHelperUI);
    }

    public final void am(Intent intent) {
    }

    public final String cda() {
        return this.qEQ.getString(j.bio_face_title);
    }

    public final int cdb() {
        return e.face_icon;
    }

    public final String cdc() {
        return this.qEQ.getString(j.bio_help_face_verify);
    }

    public final String cdd() {
        return this.qEQ.getString(j.bio_default_tips_face_wording);
    }

    public final void eX(Context context) {
        Intent intent = new Intent();
        intent.putExtra("k_user_name", BioHelperUI.c(this.qEQ));
        intent.putExtra("k_purpose", 2);
        intent.putExtra("k_need_signature", true);
        intent.putExtra("k_ticket", BioHelperUI.d(this.qEQ));
        d.b(this.qEQ.mController.tml, "facedetect", ".ui.FaceDetectUI", intent, 1025);
    }

    public final void e(int i, int i2, Intent intent) {
        int i3 = 0;
        if (i2 == 2 && intent != null) {
            this.qEQ.finish();
            String stringExtra = intent.getStringExtra("KFaceLoginAuthPwd");
            String str = "MicroMsg.BioHelperUI";
            String str2 = "hy: secondary check onActivityResult, do faceprint auth, authPwd is null:%b, authPwd.len:%d";
            Object[] objArr = new Object[2];
            objArr[0] = Boolean.valueOf(bi.oW(stringExtra));
            if (!bi.oW(stringExtra)) {
                i3 = stringExtra.length();
            }
            objArr[1] = Integer.valueOf(i3);
            x.i(str, str2, objArr);
        }
    }
}

package com.tencent.mm.ui.contact;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.R;
import com.tencent.mm.g.a.su;
import com.tencent.mm.k.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wxpay.a$k;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.LauncherUI;
import java.util.ArrayList;
import java.util.List;

public class VoipAddressUI extends MMBaseSelectContactUI {
    private List<String> gRN;
    private String talker = "";
    private boolean umj = false;
    private boolean umk = false;
    private c uml = new 1(this);

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        a.sFg.b(this.uml);
    }

    public final void iV(int i) {
        com.tencent.mm.ui.contact.a.a aVar = (com.tencent.mm.ui.contact.a.a) getContentLV().getAdapter().getItem(i);
        if (aVar != null && aVar.guS != null) {
            this.talker = aVar.guS.field_username;
            if (this.umk) {
                bnz();
            } else {
                bny();
            }
        }
    }

    private void bny() {
        x.i("MicroMsg.VoipAddressUI", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.permission.a.a(this, "android.permission.RECORD_AUDIO", 82, "", "")), bi.cjd(), this});
        if (com.tencent.mm.pluginsdk.permission.a.a(this, "android.permission.RECORD_AUDIO", 82, "", "")) {
            su suVar = new su();
            suVar.cdE.bOh = 5;
            suVar.cdE.talker = this.talker;
            suVar.cdE.context = this;
            int i = this.umj ? 2 : 1;
            suVar.cdE.cdz = 3;
            h.mEJ.h(11033, new Object[]{Integer.valueOf(i), Integer.valueOf(2), Integer.valueOf(0)});
            a.sFg.m(suVar);
            YC();
        }
    }

    private void bnz() {
        x.i("MicroMsg.VoipAddressUI", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.permission.a.a(this, "android.permission.CAMERA", 19, "", "")), bi.cjd(), this});
        if (com.tencent.mm.pluginsdk.permission.a.a(this, "android.permission.CAMERA", 19, "", "")) {
            x.i("MicroMsg.VoipAddressUI", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.permission.a.a(this, "android.permission.RECORD_AUDIO", 19, "", "")), bi.cjd(), this});
            if (com.tencent.mm.pluginsdk.permission.a.a(this, "android.permission.RECORD_AUDIO", 19, "", "")) {
                su suVar = new su();
                suVar.cdE.bOh = 5;
                suVar.cdE.talker = this.talker;
                suVar.cdE.context = this;
                int i = this.umj ? 2 : 1;
                suVar.cdE.cdz = 2;
                h.mEJ.h(11033, new Object[]{Integer.valueOf(i), Integer.valueOf(1), Integer.valueOf(0)});
                a.sFg.m(suVar);
                YC();
            }
        }
    }

    protected final void Wj() {
        super.Wj();
        String stringExtra = getIntent().getStringExtra("LauncherUI.Shortcut.LaunchType");
        this.umk = getIntent().getBooleanExtra("voip_video", true);
        if (stringExtra != null) {
            this.umj = true;
            if (stringExtra.equals("launch_type_voip")) {
                this.umk = true;
            } else if (stringExtra.equals("launch_type_voip_audio")) {
                this.umk = false;
            }
        }
        this.gRN = new ArrayList();
        this.gRN.addAll(s.cyz());
        this.gRN.addAll(s.cyA());
    }

    protected final o Wn() {
        c.a aVar = new c.a();
        aVar.uhW = true;
        aVar.uhV = true;
        return new c(this, this.gRN, false, aVar);
    }

    protected final m Wo() {
        return new q(this, this.gRN, false, this.scene);
    }

    public static void gR(Context context) {
        int i = 0;
        boolean z = 1 == bi.getInt(g.AT().getValue("VOIPCallType"), 0);
        Intent intent = new Intent(context, VoipAddressUI.class);
        intent.putExtra("Add_address_titile", context.getString(R.l.address_title_select_contact));
        intent.putExtra("voip_video", z);
        context.startActivity(intent);
        h hVar = h.mEJ;
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(1);
        if (!z) {
            i = 1;
        }
        objArr[1] = Integer.valueOf(i);
        hVar.h(11034, objArr);
    }

    protected final boolean Wl() {
        return true;
    }

    public final int[] bbG() {
        return new int[]{131072};
    }

    public void onDestroy() {
        a.sFg.c(this.uml);
        super.onDestroy();
    }

    protected final void bbH() {
        if (this.umj) {
            Intent intent = new Intent(this, LauncherUI.class);
            intent.addFlags(67108864);
            startActivity(intent);
        }
        YC();
        finish();
    }

    protected final String Wm() {
        String stringExtra = getIntent().getStringExtra("Add_address_titile");
        if (bi.oW(stringExtra)) {
            return stringExtra;
        }
        return getString(R.l.address_title_select_contact);
    }

    protected final boolean Wk() {
        return false;
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        x.i("MicroMsg.VoipAddressUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId())});
        switch (i) {
            case 19:
                if (iArr[0] == 0) {
                    bnz();
                    return;
                }
                int i2 = "android.permission.CAMERA".equals(strArr[0]) ? R.l.permission_camera_request_again_msg : R.l.permission_microphone_request_again_msg;
                if (iArr[0] != 0) {
                    com.tencent.mm.ui.base.h.a(this, getString(i2), getString(R.l.permission_tips_title), getString(R.l.jump_to_settings), getString(R.l.cancel), false, new 2(this), new 3(this));
                    return;
                }
                return;
            case a$k.AppCompatTheme_colorPrimary /*82*/:
                if (iArr[0] == 0) {
                    bny();
                    return;
                } else {
                    com.tencent.mm.ui.base.h.a(this, getString(R.l.permission_location_request_again_msg), getString(R.l.permission_tips_title), getString(R.l.jump_to_settings), getString(R.l.cancel), false, new 4(this), null);
                    return;
                }
            default:
                return;
        }
    }
}

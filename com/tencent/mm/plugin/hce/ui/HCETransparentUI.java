package com.tencent.mm.plugin.hce.ui;

import android.annotation.TargetApi;
import android.app.ProgressDialog;
import android.content.ComponentName;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.nfc.NfcAdapter;
import android.nfc.cardemulation.CardEmulation;
import android.os.Bundle;
import com.tencent.mm.R;
import com.tencent.mm.plugin.hce.a.b;
import com.tencent.mm.plugin.nfc.HCEService;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.a.c;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

@a(7)
public class HCETransparentUI extends MMActivity {
    private boolean kjl = false;
    private boolean kjm = false;
    private c kjn = null;
    private ProgressDialog kjo = null;
    private boolean kjp = false;
    private int kjq = 0;
    private Timer kjr;
    private TimerTask kjs;

    static /* synthetic */ void c(HCETransparentUI hCETransparentUI) {
        hCETransparentUI.dismissDialog();
        if (hCETransparentUI.kjr != null) {
            hCETransparentUI.kjr.cancel();
        }
    }

    protected final int getLayoutId() {
        return R.i.hce_transparent_ui;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    protected void onResume() {
        super.onResume();
        x.i("MicroMsg.HCETransparentUI", "alvinluo onResume");
        if (this.kjp) {
            this.kjs = new 1(this);
            this.kjr = new Timer();
            this.kjr.scheduleAtFixedRate(this.kjs, 0, 300);
            this.kjo = h.a(this, getString(R.l.app_waiting), false, null);
            return;
        }
        aVY();
    }

    private void aVY() {
        if (!b.aVW()) {
            aq(13000, "not support NFC");
        } else if (!b.aVV()) {
            aq(13002, "not support HCE");
        } else if (b.aVX()) {
            aVZ();
        } else if (this.kjl) {
            x.i("MicroMsg.HCETransparentUI", "alvinluo has shown open NFC dialog");
            k(13001, "system NFC switch not opened", getString(R.l.hce_not_open_nfc_switch_tips));
        } else {
            boolean z;
            c.a aVar = new c.a(this);
            aVar.Gr(R.l.hce_open_nfc_switch_tips).Gt(R.l.jump_to_settings).a(new 2(this));
            List queryIntentActivities = getPackageManager().queryIntentActivities(new Intent("android.settings.NFC_SETTINGS"), 65536);
            if (queryIntentActivities == null || queryIntentActivities.size() <= 0) {
                x.e("MicroMsg.HCETransparentUI", "alvinluo Cannot jump to NFC setting");
                z = false;
            } else {
                x.i("MicroMsg.HCETransparentUI", "alvinluo NFC activity not null, activities size: " + queryIntentActivities.size());
                for (int i = 0; i < queryIntentActivities.size(); i++) {
                    x.i("MicroMsg.HCETransparentUI", "alvinluo NFC activity: %s", new Object[]{((ResolveInfo) queryIntentActivities.get(i)).activityInfo.name});
                }
                z = true;
            }
            if (z) {
                aVar.Gu(R.l.app_cancel).b(new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        x.i("MicroMsg.HCETransparentUI", "alvinluo user click cancel button of NFC tips dialog.");
                        HCETransparentUI.this.ar(13001, "system NFC switch not opened");
                    }
                });
            } else {
                aVar.Gt(R.l.app_ok);
            }
            aVar.e(new 4(this));
            this.kjn = aVar.anj();
            this.kjn.setCanceledOnTouchOutside(false);
            this.kjn.show();
            this.kjl = true;
        }
    }

    private void k(int i, String str, String str2) {
        dismissDialog();
        this.kjn = h.a(this, str2, "", getString(R.l.app_ok), new 5(this, i, str));
    }

    private void dismissDialog() {
        if (this.kjn != null && this.kjn.isShowing()) {
            this.kjn.dismiss();
            this.kjn = null;
        }
        if (this.kjo != null) {
            this.kjo.dismiss();
            this.kjo = null;
        }
    }

    private void aq(int i, String str) {
        Intent intent = new Intent();
        intent.putExtra("errCode", i);
        intent.putExtra("errMsg", str);
        setResult(1, intent);
    }

    @TargetApi(19)
    private void aVZ() {
        CardEmulation instance = CardEmulation.getInstance(NfcAdapter.getDefaultAdapter(this));
        ComponentName componentName = new ComponentName(this, HCEService.class.getCanonicalName());
        x.i("MicroMsg.HCETransparentUI", "alvinluo component name: " + componentName);
        if (instance.isDefaultServiceForCategory(componentName, "payment")) {
            x.i("MicroMsg.HCETransparentUI", "alvinluo now is NFC Default Application");
            ar(0, "NFC switch has opened and now is NFC default application");
            return;
        }
        x.i("MicroMsg.HCETransparentUI", "alvinluo not NFC Default Application, isAutoSet: %b", new Object[]{Boolean.valueOf(true)});
        x.i("MicroMsg.HCETransparentUI", "alvinluo request set default NFC application, hasRequestSetDefault: %b", new Object[]{Boolean.valueOf(this.kjm)});
        if (this.kjm) {
            x.i("MicroMsg.HCETransparentUI", "alvinluo has request set default NFC application");
            k(13004, "not set default NFC application", getString(R.l.hce_not_set_default_nfc_application_tips));
            return;
        }
        ah.i(new 6(this, componentName), 200);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        x.i("MicroMsg.HCETransparentUI", "alvinluo onActivityResult requestCode: %d, resultCode: %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        if (i == 1) {
            x.i("MicroMsg.HCETransparentUI", "alvinluo back from REQUEST_JUMP_NFC_SETTING");
            this.kjp = true;
        } else if (i == 2) {
            x.i("MicroMsg.HCETransparentUI", "alvinluo back from REQUEST_SET_DEFAULT_NFC_APPLICATION");
        }
    }

    private void ar(int i, String str) {
        Intent intent = new Intent();
        intent.putExtra("errCode", i);
        intent.putExtra("errMsg", str);
        setResult(-1, intent);
        finish();
    }

    protected void onPause() {
        super.onPause();
        dismissDialog();
    }

    protected void onDestroy() {
        super.onDestroy();
    }
}

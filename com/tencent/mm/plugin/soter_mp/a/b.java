package com.tencent.mm.plugin.soter_mp.a;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.d.b.c.a;
import com.tencent.mm.R;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.soter_mp.b.d;
import com.tencent.mm.plugin.soter_mp.ui.SoterAuthenticationUI;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.widget.a.c;
import java.lang.ref.WeakReference;

public final class b extends c implements e {
    TextView glY = null;
    a jgQ = null;
    boolean ood = false;
    private c ooe = null;
    ImageView oof = null;
    private final int oog = 3;
    private int ooh = 0;
    private final long ooi = 500;
    Animation ooj = null;
    Animation ook = null;
    Runnable ool = new 8(this);

    static /* synthetic */ void a(b bVar, boolean z) {
        if (bVar.ooe == null || !bVar.ooe.isShowing()) {
            if (bVar.oos == null || bVar.oos.get() == null) {
                x.e("MicroMsg.SoterControllerFingerprint", "hy: ui released.");
                bVar.oor.errCode = 90007;
                bVar.oor.Yy = "internal error occurred: ui released";
                bVar.bFs();
            } else {
                if (bVar.ooe == null) {
                    Activity activity = (Activity) bVar.oos.get();
                    c.a aVar = new c.a(activity);
                    View inflate = activity.getLayoutInflater().inflate(R.i.fingerprint_dialog_content, null, false);
                    bVar.oof = (ImageView) inflate.findViewById(R.h.fingerprint_icon);
                    bVar.glY = (TextView) inflate.findViewById(R.h.fingerprint_status);
                    ((TextView) inflate.findViewById(R.h.fingerprint_description)).setText(bVar.ooq.content);
                    aVar.dR(inflate);
                    aVar.mF(true);
                    aVar.Gu(R.l.app_cancel).b(new 5(bVar));
                    aVar.e(new OnCancelListener() {
                        @TargetApi(16)
                        public final void onCancel(DialogInterface dialogInterface) {
                            x.i("MicroMsg.SoterControllerFingerprint", "hy: user cancelled auth");
                            b.this.bFr();
                        }
                    });
                    bVar.ooe = aVar.anj();
                    a(bVar.ooe);
                    bVar.ooe.setCanceledOnTouchOutside(false);
                }
                if (!bVar.ooe.isShowing()) {
                    bVar.ooe.show();
                }
            }
        }
        if (z) {
            if (!(VERSION.SDK_INT < 23)) {
                x.i("MicroMsg.SoterControllerFingerprint", "hy: req restart after fail, but no need");
                return;
            }
        }
        if (bVar.jgQ != null) {
            x.e("MicroMsg.SoterControllerFingerprint", "alvinluo mFingerprintCanceller not null, cancel and start auth by delaying 500ms.");
            bVar.jgQ.mR(true);
            ah.i(new 2(bVar), 500);
            return;
        }
        bVar.bFo();
    }

    public b(WeakReference<Activity> weakReference, d dVar, com.tencent.mm.plugin.soter_mp.b.e eVar) {
        super(weakReference, dVar, eVar);
    }

    @TargetApi(23)
    public final void dd() {
        if (!com.tencent.d.a.a.hz(ad.getContext())) {
            this.oor.errCode = 90011;
            this.oor.Yy = "no fingerprint enrolled";
            bFs();
        }
        try {
            if (ad.getContext().checkSelfPermission("android.permission.USE_FINGERPRINT") != 0) {
                String[] strArr = new String[]{"android.permission.USE_FINGERPRINT"};
                if (SoterAuthenticationUI.oox != null) {
                    Message obtainMessage = SoterAuthenticationUI.oox.obtainMessage(3);
                    Bundle bundle = new Bundle();
                    bundle.putStringArray("permissions", strArr);
                    bundle.putInt("request_code", 0);
                    obtainMessage.setData(bundle);
                    obtainMessage.sendToTarget();
                    return;
                }
                x.e("MicroMsg.SoterMpBaseController", "hy: handler not bind");
                return;
            }
            this.ood = true;
        } catch (NoSuchMethodError e) {
            x.i("MicroMsg.SoterControllerFingerprint", "hy: not implements the checkSelfPermission. permission already given");
            this.ood = true;
        }
    }

    private boolean bFn() {
        if (SoterAuthenticationUI.oox != null) {
            SoterAuthenticationUI.oox.obtainMessage(4).sendToTarget();
        } else {
            x.e("MicroMsg.SoterMpBaseController", "hy: handler not bind");
        }
        x.i("MicroMsg.SoterControllerFingerprint", "hy: auth key not valid or auth key not valid");
        com.tencent.d.b.a.a(new 1(this), false, 2, new com.tencent.mm.plugin.soter_mp.b.c(), new com.tencent.mm.plugin.soter.b.e());
        return false;
    }

    public final void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i != 0) {
            return;
        }
        if (strArr.length <= 0 || iArr.length <= 0 || !"android.permission.USE_FINGERPRINT".equals(strArr[0]) || iArr[0] != 0) {
            x.w("MicroMsg.SoterControllerFingerprint", "hy: permission not granted");
            this.oor.errCode = 90002;
            this.oor.Yy = "user not grant to use fingerprint";
            bFs();
            return;
        }
        x.i("MicroMsg.SoterControllerFingerprint", "hy: permission granted");
        bFn();
        this.ood = true;
    }

    private void bFo() {
        this.jgQ = new a();
        3 3 = new 3(this);
        4 4 = new 4(this);
        com.tencent.d.b.f.b.a acG = new com.tencent.d.b.f.b.a().Hq(2).hK(ad.getContext()).a(this.jgQ).acG(this.ooq.jgX);
        acG.vml.vmj = null;
        com.tencent.d.b.a.a(3, acG.a(4).vml);
    }

    public final void onResume() {
        if (this.ood) {
            bFn();
        }
    }

    @TargetApi(16)
    public final void onPause() {
        if (this.ood && this.jgQ != null) {
            this.jgQ.mR(true);
        }
        if (this.ooe != null && this.ooe.isShowing()) {
            this.ooe.dismiss();
        }
    }

    public final void a(int i, int i2, String str, l lVar) {
    }
}

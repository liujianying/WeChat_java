package com.tencent.mm.plugin.voip.ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import com.tencent.mm.R;
import com.tencent.mm.a.o;
import com.tencent.mm.bp.a;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.compatible.f.b;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.pluginsdk.permission.RequestFloatWindowPermissionDialog;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.x;

public final class g {
    private static final String byN;
    private static final String byO;
    public static final int lvi = a.fromDPToPix(ad.getContext(), 8);
    public static final int lvo = a.fromDPToPix(ad.getContext(), 96);
    public static final int lvp = a.fromDPToPix(ad.getContext(), 76);
    public Intent intent;
    public h oSM;
    private Point oSN;
    private a oSO;
    private al oSP;

    static {
        String zz = q.zz();
        byN = zz;
        byO = o.getString(zz.hashCode());
    }

    public final void a(Intent intent, a aVar) {
        if (aVar == null) {
            x.e("MicroMsg.VoipVoiceMiniManager", "showMini, VoipMiniCallBack cannot be null!");
            return;
        }
        this.intent = intent;
        this.oSO = aVar;
        if (b.bv(ad.getContext())) {
            ab(intent);
            return;
        }
        x.e("MicroMsg.VoipVoiceMiniManager", "mini, permission denied");
        Context context = ad.getContext();
        RequestFloatWindowPermissionDialog.a(context, context.getString(R.l.voip_float_permission_alert_content), new 1(this, aVar, intent));
    }

    private void ab(Intent intent) {
        x.i("MicroMsg.VoipVoiceMiniManager", "mini now..");
        if (this.oSM != null) {
            dismiss();
        }
        if (this.oSM == null) {
            this.oSM = new h(ad.getContext());
        }
        if (this.oSP != null) {
            this.oSP.SO();
        }
        this.oSM.setOnClickListener(new 2(this, intent));
        WindowManager windowManager = (WindowManager) ad.getContext().getSystemService("window");
        LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.type = 2002;
        layoutParams.format = 1;
        layoutParams.flags = 40;
        layoutParams.gravity = 51;
        layoutParams.width = lvp;
        layoutParams.height = lvo;
        if (this.oSN == null) {
            au.HU();
            int i = c.DT().getInt(327947, 0);
            int i2 = lvi;
            layoutParams.x = (a.fk(ad.getContext()) - layoutParams.width) - i2;
            layoutParams.y = i + i2;
        } else {
            layoutParams.x = this.oSN.x;
            layoutParams.y = this.oSN.y;
        }
        try {
            windowManager.addView(this.oSM, layoutParams);
        } catch (Exception e) {
            x.e("MicroMsg.VoipVoiceMiniManager", "add failed", new Object[]{e});
        }
        this.oSO.a(intent, this.oSM);
    }

    public final void wQ(int i) {
        if (this.oSM != null) {
            this.oSM.OJ(String.format("%02d:%02d", new Object[]{Integer.valueOf(i / 60), Integer.valueOf(i % 60)}));
        }
    }

    public final void OI(String str) {
        if (this.oSM != null) {
            this.oSM.OI(str);
        }
    }

    public final void dismiss() {
        x.i("MicroMsg.VoipVoiceMiniManager", "dismiss now..");
        WindowManager windowManager = (WindowManager) ad.getContext().getSystemService("window");
        try {
            if (this.oSM != null) {
                WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) this.oSM.getLayoutParams();
                this.oSN = new Point(layoutParams.x, layoutParams.y);
                windowManager.removeView(this.oSM);
                this.oSM.setOnClickListener(null);
                this.oSM = null;
            }
        } catch (Exception e) {
            x.e("MicroMsg.VoipVoiceMiniManager", "remove failed", new Object[]{e});
        }
    }
}

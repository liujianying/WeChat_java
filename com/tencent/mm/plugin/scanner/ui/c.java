package com.tencent.mm.plugin.scanner.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ab.l;
import com.tencent.mm.ab.v;
import com.tencent.mm.g.a.on;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.scanner.util.b;
import com.tencent.mm.plugin.scanner.util.b$a;
import com.tencent.mm.plugin.scanner.util.k;
import com.tencent.mm.protocal.c.in;
import com.tencent.mm.protocal.c.io;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

public abstract class c extends i implements b$a {
    private long mGP;
    int mGQ;
    private HighlightRectSideView mGR;
    l mGS;
    private p mGT;
    private com.tencent.mm.ui.widget.a.c mGU;

    protected abstract b a(b$a b_a);

    protected abstract float bsg();

    protected abstract String bsh();

    protected abstract int bsi();

    static /* synthetic */ void a(c cVar, final String str) {
        if (cVar.mGU != null) {
            cVar.mGU.dismiss();
        }
        cVar.mGU = h.a(cVar.mKp.getContext(), R.l.scan_license_cancel_confirm, R.l.app_tip, new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                au.DF().c(c.this.mGS);
                on onVar = new on();
                onVar.bZr.cardType = str;
                onVar.bZr.bZs = 2;
                a.sFg.m(onVar);
                c.this.mKp.getContext().finish();
            }
        }, null);
    }

    public c(i.b bVar, Point point, DisplayMetrics displayMetrics, int i) {
        super(bVar, point);
        this.mGQ = 0;
        this.mGS = null;
        this.mGT = null;
        this.mGU = null;
        this.mKn = 0;
        this.mKo = 0;
        float bsg = bsg();
        Point point2 = i == 1 ? new Point(displayMetrics.widthPixels, displayMetrics.heightPixels) : new Point(displayMetrics.heightPixels, displayMetrics.widthPixels);
        int i2 = (int) (((float) point2.y) * 0.8f);
        int i3 = (int) (((float) point2.x) * 0.8f);
        if (((float) i2) * bsg > ((float) point2.x)) {
            i2 = (int) (((float) i3) / bsg);
        } else {
            i3 = (int) (((float) i2) * bsg);
        }
        Point point3 = new Point((int) (((float) i3) / displayMetrics.density), (int) (((float) i2) / displayMetrics.density));
        this.mKo = (int) (((((float) point2.y) / displayMetrics.density) - ((float) point3.y)) / 2.0f);
        do(point3.x, point3.y);
        if (bi.fQ(bVar.getContext()) < 100) {
            x.w("MicroMsg.BaseScanModeLicence", "memory is not much");
            this.mGP = 280;
            return;
        }
        this.mGP = 80;
    }

    protected final void onResume() {
    }

    protected final void onDestroy() {
    }

    protected final void bsj() {
    }

    protected final b bsk() {
        if (this.mKj == null) {
            this.mKj = a(this);
        }
        return this.mKj;
    }

    protected final int bsl() {
        return R.i.scan_licence;
    }

    protected final int bsm() {
        return 0;
    }

    protected final void bsn() {
    }

    protected final void cv(View view) {
        if (view != null) {
            TextView textView = (TextView) view.findViewById(R.h.card_tips);
            if (textView != null) {
                textView.setText(view.getContext().getString(R.l.scan_licence_tips, new Object[]{view.getContext().getString(bsi())}));
            }
        }
    }

    protected final boolean bso() {
        return false;
    }

    protected final boolean bsp() {
        return false;
    }

    protected final void j(Rect rect) {
        x.d("MicroMsg.BaseScanModeLicence", "smoothie, maskRect = %s", new Object[]{rect});
        HighlightRectSideView highlightRectSideView = (HighlightRectSideView) this.mKp.findViewById(R.h.card_highlight);
        if (highlightRectSideView != null) {
            highlightRectSideView.setMaskRect(rect);
        }
        this.mGR = highlightRectSideView;
    }

    public void b(int i, String str, byte[] bArr, byte[] bArr2, int i2, int i3) {
        x.d("MicroMsg.BaseScanModeLicence", "onDecodeSuccess");
        Bitmap bitmap = ((k) this.mKj).mNO;
        String bsh = bsh();
        if (this.mGT != null) {
            this.mGT.dismiss();
        }
        Context context = this.mKp.getContext();
        context.getString(R.l.app_tip);
        this.mGT = h.a(context, context.getString(R.l.scan_license_server_recognising), false, null);
        this.mGT.setOnKeyListener(new 2(this, bsh));
        com.tencent.mm.ab.b.a aVar = new com.tencent.mm.ab.b.a();
        aVar.dIG = new in();
        aVar.dIH = new io();
        aVar.uri = "/cgi-bin/mmbiz-bin/usrmsg/bizscanlicense";
        aVar.dIF = 1803;
        com.tencent.mm.ab.b KT = aVar.KT();
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        if (bitmap.compress(CompressFormat.JPEG, 80, byteArrayOutputStream)) {
            byte[] toByteArray = byteArrayOutputStream.toByteArray();
            if (bi.bC(toByteArray)) {
                r(2, bsh, "");
                return;
            }
            in inVar = (in) KT.dID.dIL;
            inVar.rjJ = new com.tencent.mm.bk.b(toByteArray);
            if (bsh.equals("driving")) {
                inVar.rjI = 0;
            } else if (bsh.equals("identity")) {
                inVar.rjI = 1;
            }
            this.mGS = v.a(KT, new 1(this, bsh), false);
            return;
        }
        r(2, bsh, "");
    }

    public final void bsf() {
        x.d("MicroMsg.BaseScanModeLicence", "onDecodeFail");
        if (this.mKp == null) {
            x.e("MicroMsg.BaseScanModeLicence", "ui callback is null");
        } else {
            bsq();
        }
    }

    private void bsq() {
        this.mGR.setShowRectEdges(((k) this.mKj).btk());
        this.mKp.eu(this.mGP);
    }

    private void r(int i, String str, String str2) {
        on onVar;
        on onVar2;
        if (i == 0) {
            onVar = new on();
            onVar.bZr.cardType = str;
            onVar.bZr.bZs = 1;
            onVar.bZr.bZt = str2;
            if (this.mKj instanceof k) {
                onVar.bZr.bZu = ((k) this.mKj).mNO;
            }
            a.sFg.a(onVar, Looper.getMainLooper());
            if (this.mGT != null) {
                this.mGT.dismiss();
            }
            this.mKp.getContext().finish();
        } else if ((i & 2) > 0 && (i & 1) > 0) {
            onVar2 = new on();
            onVar2.bZr.cardType = str;
            onVar2.bZr.bZs = 0;
            onVar2.bZr.bZt = str2;
            a.sFg.a(onVar2, Looper.getMainLooper());
            if (this.mGT != null) {
                this.mGT.dismiss();
            }
            this.mKp.getContext().finish();
        } else if (this.mGQ >= 3) {
            onVar = new on();
            onVar.bZr.cardType = str;
            onVar.bZr.bZs = 1;
            onVar.bZr.bZt = str2;
            if (this.mKj instanceof k) {
                onVar.bZr.bZu = ((k) this.mKj).mNO;
            }
            a.sFg.a(onVar, Looper.getMainLooper());
            if (this.mGT != null) {
                this.mGT.dismiss();
            }
            this.mKp.getContext().finish();
        } else if ((i & 1) <= 0 || this.mGQ >= 3) {
            onVar2 = new on();
            onVar2.bZr.cardType = str;
            onVar2.bZr.bZs = 0;
            onVar2.bZr.bZt = str2;
            a.sFg.a(onVar2, Looper.getMainLooper());
            if (this.mGT != null) {
                this.mGT.dismiss();
            }
            this.mKp.getContext().finish();
        } else {
            if (this.mGT != null) {
                this.mGT.dismiss();
            }
            bsk().bsU();
            int i2 = (i & 32) > 0 ? R.l.scan_license_image_incomplete : (i & 64) > 0 ? R.l.scan_license_image_too_dark : R.l.scan_license_continue;
            Toast.makeText(this.mKp.getContext(), i2, 0).show();
            bsq();
        }
    }

    public final void E(Bundle bundle) {
    }
}

package com.tencent.mm.plugin.scanner.ui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.g.a.ol;
import com.tencent.mm.plugin.scanner.ui.i.b;
import com.tencent.mm.plugin.scanner.util.b.a;
import com.tencent.mm.plugin.scanner.util.g;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class j extends i implements a {
    private long mGP;
    private HighlightRectSideView mKw;
    boolean mKx = false;
    private OnClickListener mKy = new 1(this);

    public j(b bVar, Point point, DisplayMetrics displayMetrics, int i) {
        Point point2;
        super(bVar, point);
        if (i == 1) {
            point2 = new Point(displayMetrics.widthPixels, displayMetrics.heightPixels);
        } else {
            point2 = new Point(displayMetrics.heightPixels, displayMetrics.widthPixels);
        }
        int i2 = point2.y - ((int) (118.0f * displayMetrics.density));
        Point point3 = new Point((int) (((float) ((int) (((float) i2) * 1.586f))) / displayMetrics.density), (int) (((float) i2) / displayMetrics.density));
        bVar.getContext().setResult(0);
        this.mKn = 0;
        this.mKo = 64;
        do(point3.x, point3.y);
        if (bi.fQ(bVar.getContext()) < 100) {
            x.w("MicroMsg.ScanModeBankCard", "memory is not much");
            this.mGP = 280;
            return;
        }
        this.mGP = 80;
    }

    protected final void onResume() {
    }

    protected final void onPause() {
    }

    protected final void onDestroy() {
    }

    protected final void bsj() {
    }

    protected final com.tencent.mm.plugin.scanner.util.b bsk() {
        if (this.mKj == null && this.mKp != null) {
            this.mKj = new g(this, this.mKp.bsz(), this.mKx);
        }
        return this.mKj;
    }

    protected final int bsl() {
        return R.i.scan_bank_card;
    }

    protected final int bsm() {
        return 300;
    }

    protected final void bsn() {
    }

    protected final void j(Rect rect) {
        String str;
        LinearLayout linearLayout = (LinearLayout) this.mKp.findViewById(R.h.bank_card_container);
        TextView textView = (TextView) this.mKp.findViewById(R.h.bank_card_owner);
        this.mKw = (HighlightRectSideView) this.mKp.findViewById(R.h.bank_card_highlight);
        this.mKw.setMaskRect(rect);
        Intent intent = this.mKp.getContext().getIntent();
        if (intent != null) {
            String aG = bi.aG(intent.getStringExtra("bank_card_owner"), "");
            textView.setText(String.format(this.mKp.getContext().getResources().getString(R.l.scan_bank_owner), new Object[]{aG}));
            str = aG;
        } else {
            str = null;
        }
        if (bi.oW(str)) {
            linearLayout.setVisibility(8);
        } else {
            linearLayout.setVisibility(0);
            ((ImageView) this.mKp.findViewById(R.h.bank_card_declare)).setOnClickListener(this.mKy);
        }
        if (this.mKj != null && this.mKp != null) {
            g gVar = (g) this.mKj;
            boolean bsz = this.mKp.bsz();
            x.d("MicroMsg.ScanBankCardDecoder", "need rotate:" + bsz);
            gVar.mNe = bsz;
        }
    }

    public final void b(int i, String str, byte[] bArr, byte[] bArr2, int i2, int i3) {
        x.d("MicroMsg.ScanModeBankCard", "decode success, resultType:%d", new Object[]{Integer.valueOf(i)});
        if (3 != i) {
            x.e("MicroMsg.ScanModeBankCard", "decode success, but result type error:" + i);
            return;
        }
        Bitmap bta = ((g) this.mKj).bta();
        if (this.mKx) {
            this.mKp.bsB();
            ConfirmScanBankCardResultUI.c(bta, str);
            return;
        }
        ol olVar = new ol();
        olVar.bZo.cardId = str;
        olVar.bZo.bZp = bta;
        com.tencent.mm.sdk.b.a.sFg.m(olVar);
        this.mKp.getContext().finish();
    }

    public final void bsf() {
        x.d("MicroMsg.ScanModeBankCard", "onDecodeFailed");
        if (this.mKp == null) {
            x.e("MicroMsg.ScanModeBankCard", "ui callback is null");
            return;
        }
        this.mKw.setShowRectEdges(((g) this.mKj).mNg);
        this.mKp.eu(this.mGP);
    }

    protected final boolean bso() {
        return false;
    }

    protected final boolean bsp() {
        return false;
    }

    public final void E(Bundle bundle) {
    }
}

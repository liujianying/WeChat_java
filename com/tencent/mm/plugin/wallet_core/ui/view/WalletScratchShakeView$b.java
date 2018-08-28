package com.tencent.mm.plugin.wallet_core.ui.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.mm.pluginsdk.i.c;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

class WalletScratchShakeView$b extends View {
    Paint aar;
    private int fVn = 0;
    long hmb;
    int jVn;
    c lAY;
    private Bitmap nGa;
    private Canvas pAd;
    Drawable pAe;
    Paint pAf;
    Paint pAg;
    Path pAh;
    Path pAi;
    private float pAj;
    private float pAk;
    private int[] pAl;
    private int pAm = -1;
    boolean pAn;
    boolean pAo;
    float pAp;
    float pAq;
    int pAr;
    private boolean pAs;
    boolean pAt;
    private float pAu = 0.9f;
    final /* synthetic */ WalletScratchShakeView pAv;
    private boolean pzG = false;

    static /* synthetic */ void d(WalletScratchShakeView$b walletScratchShakeView$b) {
        if (walletScratchShakeView$b.pAt) {
            x.i("MicroMsg.WalletScratchShakeView", "onStartShakeOrClick, already finish clear mask");
        } else if (!walletScratchShakeView$b.bQQ()) {
            if (walletScratchShakeView$b.pAs) {
                walletScratchShakeView$b.pAq += (float) (walletScratchShakeView$b.getHeight() / 6);
                walletScratchShakeView$b.bQR();
            } else {
                walletScratchShakeView$b.pAp += (float) (walletScratchShakeView$b.getHeight() / 6);
                walletScratchShakeView$b.bQR();
            }
            walletScratchShakeView$b.pAs = !walletScratchShakeView$b.pAs;
            if (!walletScratchShakeView$b.pAn) {
                ah.i(new Runnable() {
                    public final void run() {
                        if (WalletScratchShakeView.a(WalletScratchShakeView$b.this.pAv) != null) {
                            WalletScratchShakeView.a(WalletScratchShakeView$b.this.pAv).jF(false);
                        }
                    }
                }, 50);
                walletScratchShakeView$b.pAn = true;
            }
            walletScratchShakeView$b.bQQ();
        }
    }

    static /* synthetic */ void e(WalletScratchShakeView$b walletScratchShakeView$b) {
        int width = walletScratchShakeView$b.getWidth();
        int height = walletScratchShakeView$b.getHeight();
        walletScratchShakeView$b.nGa.getPixels(walletScratchShakeView$b.pAl, 0, width, 0, 0, width, height);
        float f = (float) (width * height);
        float f2 = 0.0f;
        for (int i = 0; ((float) i) < f; i++) {
            if (walletScratchShakeView$b.pAl[i] == 0) {
                f2 += 1.0f;
            }
        }
        f2 = (f2 < 0.0f || f <= 0.0f) ? 0.0f : f2 / f;
        x.i("MicroMsg.WalletScratchShakeView", "erasePercent: %s", new Object[]{Float.valueOf(f2)});
        x.i("MicroMsg.WalletScratchShakeView", "");
        if (f2 >= walletScratchShakeView$b.pAu) {
            walletScratchShakeView$b.pAt = true;
            if (!walletScratchShakeView$b.pAo) {
                ah.A(new Runnable() {
                    public final void run() {
                        WalletScratchShakeView$b.this.animate().alpha(0.0f).setDuration(100);
                        if (WalletScratchShakeView.a(WalletScratchShakeView$b.this.pAv) != null) {
                            WalletScratchShakeView.a(WalletScratchShakeView$b.this.pAv).bQP();
                        }
                    }
                });
                walletScratchShakeView$b.pAo = true;
            }
        }
    }

    public WalletScratchShakeView$b(WalletScratchShakeView walletScratchShakeView, Context context) {
        this.pAv = walletScratchShakeView;
        super(context);
    }

    static byte[] L(Bitmap bitmap) {
        int i = 0;
        int[] iArr = new int[]{30, bitmap.getWidth() / 3, bitmap.getWidth() - (bitmap.getWidth() / 3), bitmap.getWidth() - 30};
        int[] iArr2 = new int[]{0, bitmap.getHeight()};
        ByteBuffer order = ByteBuffer.allocate(92).order(ByteOrder.nativeOrder());
        order.put((byte) 1);
        order.put((byte) 4);
        order.put((byte) 2);
        order.put((byte) 9);
        order.putInt(0);
        order.putInt(0);
        order.putInt(0);
        order.putInt(0);
        order.putInt(0);
        order.putInt(0);
        order.putInt(0);
        order.putInt(iArr[0]);
        order.putInt(iArr[1]);
        order.putInt(iArr[2]);
        order.putInt(iArr[3]);
        order.putInt(iArr2[0]);
        order.putInt(iArr2[1]);
        while (i < 9) {
            order.putInt(1);
            i++;
        }
        return order.array();
    }

    private boolean bQQ() {
        if (this.pAq < ((float) getHeight())) {
            return false;
        }
        this.pAt = true;
        if (!this.pAo) {
            if (WalletScratchShakeView.a(this.pAv) != null) {
                WalletScratchShakeView.a(this.pAv).bQP();
            }
            this.pAo = true;
        }
        if (this.pAd != null) {
            this.pAi.reset();
            this.pAi.moveTo(0.0f, 0.0f);
            this.pAi.lineTo((float) getWidth(), 0.0f);
            this.pAi.lineTo((float) getWidth(), (float) getHeight());
            this.pAi.lineTo(0.0f, (float) getHeight());
            this.pAd.drawPath(this.pAi, this.pAg);
        }
        invalidate();
        return true;
    }

    private void bQR() {
        if (this.pAd != null) {
            this.pAi.reset();
            this.pAi.moveTo(0.0f, this.pAq);
            this.pAi.cubicTo((float) (getWidth() / 2), (float) getHeight(), (float) (getWidth() / 2), 0.0f, (float) getWidth(), this.pAp);
            this.pAi.lineTo((float) getWidth(), 0.0f);
            this.pAi.lineTo(0.0f, 0.0f);
            this.pAd.drawPath(this.pAi, this.pAg);
        }
        invalidate();
    }

    protected final void onDraw(Canvas canvas) {
        canvas.save();
        if (this.nGa == null) {
            int width = getWidth();
            int height = getHeight();
            x.i("MicroMsg.WalletScratchShakeView", "createMasker width: %s, height: %s, waterMark: %s", new Object[]{Integer.valueOf(width), Integer.valueOf(height), this.pAe});
            this.nGa = Bitmap.createBitmap(width, height, Config.ARGB_8888);
            this.pAd = new Canvas(this.nGa);
            if (this.pAe != null) {
                this.pAe.setBounds(new Rect(0, 0, width, height));
                this.pAe.draw(this.pAd);
            }
            this.pAl = new int[(width * height)];
        }
        canvas.drawBitmap(this.nGa, 0.0f, 0.0f, this.aar);
        canvas.restore();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean onTouchEvent(android.view.MotionEvent r8) {
        /*
        r7 = this;
        r6 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r3 = 0;
        r1 = 1;
        r0 = r7.pAv;
        r0 = com.tencent.mm.plugin.wallet_core.ui.view.WalletScratchShakeView.b(r0);
        if (r0 != 0) goto L_0x0011;
    L_0x000c:
        r1 = super.onTouchEvent(r8);
    L_0x0010:
        return r1;
    L_0x0011:
        r2 = r8.getAction();
        r0 = 0;
        switch(r2) {
            case 0: goto L_0x002a;
            case 1: goto L_0x00a9;
            case 2: goto L_0x0055;
            case 3: goto L_0x00a9;
            default: goto L_0x0019;
        };
    L_0x0019:
        r2 = r7.pAt;
        if (r2 != 0) goto L_0x0025;
    L_0x001d:
        r2 = r7.F(r8);
        if (r2 != 0) goto L_0x0025;
    L_0x0023:
        if (r0 != 0) goto L_0x0010;
    L_0x0025:
        r1 = super.onTouchEvent(r8);
        goto L_0x0010;
    L_0x002a:
        r0 = r8.getX();
        r2 = r8.getY();
        r3 = r7.pAh;
        r3.reset();
        r3 = r7.pAh;
        r3.moveTo(r0, r2);
        r7.pAj = r0;
        r7.pAk = r2;
        r7.invalidate();
        r0 = r7.pAn;
        if (r0 != 0) goto L_0x00c0;
    L_0x0047:
        r0 = new com.tencent.mm.plugin.wallet_core.ui.view.WalletScratchShakeView$b$3;
        r0.<init>();
        r2 = 50;
        com.tencent.mm.sdk.platformtools.ah.i(r0, r2);
        r7.pAn = r1;
        r0 = r1;
        goto L_0x0019;
    L_0x0055:
        r0 = r8.getX();
        r2 = r8.getY();
        r3 = r7.pAd;
        if (r3 == 0) goto L_0x00a3;
    L_0x0061:
        r3 = r7.pAj;
        r3 = r0 - r3;
        r3 = java.lang.Math.abs(r3);
        r3 = (int) r3;
        r4 = r7.pAk;
        r4 = r2 - r4;
        r4 = java.lang.Math.abs(r4);
        r4 = (int) r4;
        r5 = r7.jVn;
        if (r3 >= r5) goto L_0x007b;
    L_0x0077:
        r3 = r7.jVn;
        if (r4 < r3) goto L_0x00a3;
    L_0x007b:
        r7.pAj = r0;
        r7.pAk = r2;
        r3 = r7.pAh;
        r4 = r7.pAj;
        r4 = r4 + r0;
        r4 = r4 / r6;
        r5 = r7.pAk;
        r5 = r5 + r2;
        r5 = r5 / r6;
        r3.quadTo(r4, r5, r0, r2);
        r0 = r7.pAd;
        r2 = r7.pAh;
        r3 = r7.pAf;
        r0.drawPath(r2, r3);
        r0 = r7.pAh;
        r0.reset();
        r0 = r7.pAh;
        r2 = r7.pAj;
        r3 = r7.pAk;
        r0.moveTo(r2, r3);
    L_0x00a3:
        r7.invalidate();
        r0 = r1;
        goto L_0x0019;
    L_0x00a9:
        r7.pAj = r3;
        r7.pAk = r3;
        r0 = r7.pAh;
        r0.reset();
        r0 = new com.tencent.mm.plugin.wallet_core.ui.view.WalletScratchShakeView$b$4;
        r0.<init>();
        r2 = "ScratchShakeView_calcErasePercentAndCallEnd";
        com.tencent.mm.sdk.f.e.post(r0, r2);
        r7.invalidate();
    L_0x00c0:
        r0 = r1;
        goto L_0x0019;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.wallet_core.ui.view.WalletScratchShakeView$b.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public final boolean F(MotionEvent motionEvent) {
        if (this.nGa != null && (motionEvent.getAction() == 1 || motionEvent.getAction() == 3 || motionEvent.getAction() == 0)) {
            int width = getWidth();
            int height = getHeight();
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            int width2 = getWidth() * getHeight();
            x.d("MicroMsg.WalletScratchShakeView", "checkIsTouchEraseArea, x: %s, y: %s, width: %s, height: %s, index: %s, len: %s", new Object[]{Float.valueOf(motionEvent.getX()), Float.valueOf(motionEvent.getY()), Integer.valueOf(width), Integer.valueOf(height), Integer.valueOf((y * width) + x), Integer.valueOf(width2)});
            if ((y * width) + x > 0 && x > 0 && y > 0 && x < getWidth() && y < getHeight()) {
                if (this.nGa.getPixel(x, y) == 0) {
                    return true;
                }
                return false;
            }
        }
        return false;
    }
}

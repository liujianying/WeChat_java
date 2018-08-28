package com.tencent.mm.d;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.view.MotionEvent;
import com.tencent.mm.cache.g;
import com.tencent.mm.cache.g.1;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.t.d;
import com.tencent.mm.t.d.a;
import com.tencent.mm.t.d.b;
import java.util.LinkedList;

public final class f extends b<g> {
    private float VT;
    private float VU;
    private boolean bBR = false;
    private float bBS;
    private float bBT;
    private Bitmap bCD;
    private LinkedList<b> bCE = new LinkedList();
    public int bCF = a.doc;
    private boolean bCp = true;
    private Path ks = new Path();

    public final a vE() {
        return a.bBi;
    }

    public final void vH() {
        Bitmap bitmap;
        super.vH();
        h(((g) vG()).yv());
        Bitmap cfS = this.bBn.cfS();
        if (cfS == null) {
            x.e("MicroMsg.MosaicArtist", "[generateMosaicImage] bitmap is null");
            bitmap = null;
        } else {
            int width = cfS.getWidth();
            int height = cfS.getHeight();
            int aH = com.tencent.mm.bx.a.aH(6.0f);
            Bitmap createBitmap = Bitmap.createBitmap(width, height, Config.RGB_565);
            Canvas canvas = new Canvas(createBitmap);
            int ceil = (int) Math.ceil((double) (((float) width) / ((float) aH)));
            int ceil2 = (int) Math.ceil((double) (((float) height) / ((float) aH)));
            Paint paint = new Paint();
            paint.setAntiAlias(true);
            for (int i = 0; i < ceil; i++) {
                for (int i2 = 0; i2 < ceil2; i2++) {
                    int i3 = aH * i;
                    int i4 = aH * i2;
                    int i5 = i3 + aH;
                    int i6 = i5 > width ? width : i5;
                    i5 = i4 + aH;
                    if (i5 > height) {
                        i5 = height;
                    }
                    int pixel = cfS.getPixel(i3, i4);
                    Rect rect = new Rect(i3, i4, i6, i5);
                    paint.setColor(pixel);
                    canvas.drawRect(rect, paint);
                }
            }
            bitmap = createBitmap;
        }
        this.bCD = bitmap;
    }

    public final void onDestroy() {
        super.onDestroy();
        if (this.bCD != null && !this.bCD.isRecycled()) {
            this.bCD.recycle();
        }
    }

    public final void onDraw(Canvas canvas) {
        canvas.save();
        canvas.clipRect(this.bBp);
        if (this.bCF == a.doc) {
            b(canvas);
            new d(this.bCF, this.ks, 1.0f / getScale(), this.bCD).draw(canvas);
        } else if (this.bCF == a.dod) {
            new d(this.bCF, new LinkedList(this.bCE), 1.0f / getScale()).draw(new Canvas(vL()));
            b(canvas);
        }
        canvas.restore();
    }

    public final boolean q(MotionEvent motionEvent) {
        int i = 0;
        if (!vM()) {
            return false;
        }
        float[] w = w(motionEvent.getX(), motionEvent.getY());
        float f;
        switch (motionEvent.getActionMasked()) {
            case 0:
                if (this.bBp.contains((int) w[0], (int) w[1])) {
                    f = w[0];
                    this.bBS = f;
                    this.VT = f;
                    float f2 = w[1];
                    this.bBT = f2;
                    this.VU = f2;
                    this.bCp = true;
                } else {
                    this.bCp = false;
                }
                this.bBR = false;
                break;
            case 1:
            case 5:
                if (this.bCp && this.bBR) {
                    if (this.bCF == a.doc) {
                        ((g) vG()).add(new d(this.bCF, new Path(this.ks), 1.0f / getScale(), this.bCD));
                        aH(false);
                    } else if (this.bCF == a.dod) {
                        ((g) vG()).add(new d(this.bCF, new LinkedList(this.bCE), 1.0f / getScale()));
                        aH(false);
                    }
                    vP();
                }
                this.bCE.clear();
                this.ks.reset();
                this.bBR = false;
                this.bCp = false;
                break;
            case 2:
                if (!this.bCp || !this.bBR) {
                    if (this.bCp && !this.bBR) {
                        if (this.bCF == a.doc) {
                            this.ks.moveTo(w[0], w[1]);
                        }
                        this.bBR = true;
                        break;
                    }
                }
                this.bBS = this.VT;
                this.bBT = this.VU;
                this.VT = w[0];
                this.VU = w[1];
                if (this.bCF == a.doc) {
                    this.ks.quadTo(this.bBS, this.bBT, (this.VT + this.bBS) / 2.0f, (this.VU + this.bBT) / 2.0f);
                } else if (this.bCF == a.dod) {
                    int i2;
                    double toDegrees = Math.toDegrees(Math.atan((double) ((this.VT - this.bBS) / (this.VU - this.bBT))));
                    if (getRotation() == 180.0f) {
                        i2 = 180;
                    } else {
                        i2 = 0;
                    }
                    float f3 = ((float) (((double) i2) + toDegrees)) % 360.0f;
                    LinkedList linkedList = this.bCE;
                    f = 1.0f / getScale();
                    float f4 = this.VT;
                    float f5 = this.VU;
                    Bitmap cfS = this.bBn.cfS();
                    if (cfS == null || f4 >= ((float) cfS.getWidth()) || f5 >= ((float) cfS.getHeight()) || f4 <= 0.0f || f5 <= 0.0f) {
                        x.w("MicroMsg.MosaicArtist", "[getPosColor] X:%s,Y:%s", new Object[]{Float.valueOf(f4), Float.valueOf(f5)});
                    } else {
                        i = cfS.getPixel((int) f4, (int) f5);
                    }
                    linkedList.add(new b(f, i, f3, this.VT, this.VU));
                }
                vO();
                break;
                break;
        }
        return this.bCp;
    }

    public final void aH(boolean z) {
        super.aH(z);
        g gVar = (g) vG();
        Bitmap copy = vL().copy(Config.ARGB_8888, true);
        String aVar = a.bBi.toString();
        String str = e.dgk + String.format("%s%d.%s", new Object[]{"wx_photo_edit_", Long.valueOf(System.currentTimeMillis()), aVar});
        x.i("MicroMsg.MosaicCache", "[saveCacheToLocal] path:%s size:%s", new Object[]{str, Integer.valueOf(gVar.aW(true))});
        aVar = (String) gVar.daq.get(gVar.aW(true));
        if (!bi.oW(aVar)) {
            FileOp.deleteFile(aVar);
            gVar.daq.remove(gVar.aW(true));
        }
        gVar.daq.put(gVar.aW(true), str);
        gVar.dar.put(str, copy);
        com.tencent.mm.sdk.f.e.cjw();
        com.tencent.mm.sdk.f.e.a(new 1(gVar, copy, str), "[saveCacheToLocal] mosaic path:" + str);
    }

    public final void vF() {
        if (!(vL() == null || vL().isRecycled())) {
            vL().recycle();
        }
        h(((g) vG()).yv());
    }
}

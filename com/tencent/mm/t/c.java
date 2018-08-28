package com.tencent.mm.t;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.NinePatchDrawable;
import com.tencent.mm.api.i;
import com.tencent.mm.bd.a.d;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.List;

public class c implements Cloneable {
    public float dD = 1.0f;
    private Rect dnE;
    public String dnH;
    private i dnI;
    public Bitmap dnJ;
    public PointF dnK;
    public int dnL = 0;
    private float dnM = 1.0f;
    public boolean dnN;
    public PointF dnO;
    private float dnP;
    private float dnQ;
    public boolean dnR = false;
    public List<PointF> dnS = new ArrayList();
    public float dnT;
    private float dnU;
    protected Context mContext;
    private Matrix mMatrix;

    public c(Context context, Matrix matrix, String str, i iVar, Rect rect) {
        this.dnH = str;
        this.mMatrix = matrix;
        this.dnI = iVar;
        this.mContext = context;
        this.dnE = rect;
        this.dnK = new PointF();
        this.dnO = new PointF();
    }

    public c(Context context, Matrix matrix, String str, Rect rect) {
        this.dnH = str;
        this.mMatrix = matrix;
        this.mContext = context;
        this.dnE = rect;
        this.dnK = new PointF();
        this.dnO = new PointF();
    }

    public final void a(float f, float f2, float f3, int i) {
        this.dnJ = i(CJ());
        this.dnP = (1.2f * ((float) this.dnE.width())) / ((float) this.dnJ.getWidth());
        this.dnQ = (0.1f * ((float) this.dnE.width())) / ((float) this.dnJ.getWidth());
        this.dnM = f3;
        this.dnL = i;
        this.dD *= f3;
        x.i("MicroMsg.EmojiItem", "MAX_SCALE:%s MIN_SCALE:%s mInitScale:%s", new Object[]{Float.valueOf(this.dnP), Float.valueOf(this.dnQ), Float.valueOf(this.dnM)});
        this.dnK.set(f, f2);
        x.d("MicroMsg.EmojiItem", "[setPoint] point:%s", new Object[]{this.dnK});
        CK();
    }

    public final boolean CG() {
        x.d("MicroMsg.EmojiItem", "[checkBitmap]");
        if (this.dnJ != null && !this.dnJ.isRecycled()) {
            return false;
        }
        this.dnJ = i(CJ());
        return true;
    }

    public void setSelected(boolean z) {
        this.dnN = z;
    }

    public final void b(float f, float f2, float f3, int i) {
        this.dnK.offset(f, f2);
        if (0.0f != f3) {
            this.dD = f3;
        }
        this.dnL = i;
    }

    public final void clear() {
        x.i("MicroMsg.EmojiItem", "[clear]");
        if (this.dnJ != null && !this.dnJ.isRecycled()) {
            this.dnJ.recycle();
            this.dnJ = null;
        }
    }

    public final void draw(Canvas canvas) {
        if (this.dnJ == null || this.dnJ.isRecycled()) {
            x.w("MicroMsg.EmojiItem", "[draw] null == bitmap || bitmap isRecycled");
            return;
        }
        canvas.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
        if (this.dnP < this.dD * this.dnM) {
            this.dD = this.dnP / this.dnM;
        } else if (this.dnQ > this.dD * this.dnM) {
            this.dD = this.dnQ / this.dnM;
        }
        canvas.save();
        canvas.translate(this.dnK.x, this.dnK.y);
        canvas.rotate((float) this.dnL);
        canvas.scale(this.dD, this.dD);
        if (this.dnN) {
            canvas.drawBitmap(this.dnJ, (float) ((-CH()) / 2), (float) ((-CI()) / 2), null);
        } else {
            canvas.clipRect(((float) ((-CH()) / 2)) + 40.0f, ((float) ((-CI()) / 2)) + 40.0f, ((float) (this.dnJ.getWidth() / 2)) - 40.0f, ((float) (this.dnJ.getHeight() / 2)) - 40.0f);
            canvas.drawBitmap(this.dnJ, (float) ((-CH()) / 2), (float) ((-CI()) / 2), null);
        }
        canvas.restore();
        canvas.setDrawFilter(null);
    }

    private int CH() {
        if (this.dnJ != null) {
            return this.dnJ.getWidth();
        }
        return 0;
    }

    private int CI() {
        if (this.dnJ != null) {
            return this.dnJ.getHeight();
        }
        return 0;
    }

    protected Bitmap CJ() {
        if (this.dnJ == null || this.dnJ.isRecycled()) {
            this.dnJ = this.dnI.aR(this.mContext);
        }
        if (this.dnJ == null) {
            x.e("MicroMsg.EmojiItem", "[getEmojiBitmap] NULL!");
            com.tencent.mm.sdk.platformtools.c cVar = new com.tencent.mm.sdk.platformtools.c();
            this.dnJ = com.tencent.mm.sdk.platformtools.c.createBitmap(120, 120, Config.ARGB_4444);
            new Canvas(this.dnJ).drawColor(-7829368);
        }
        return this.dnJ;
    }

    private Bitmap i(Bitmap bitmap) {
        int width = (int) (((float) bitmap.getWidth()) + 80.0f);
        int height = (int) (((float) bitmap.getHeight()) + 80.0f);
        Bitmap createBitmap = Bitmap.createBitmap(width, height, Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawBitmap(bitmap, 40.0f, 40.0f, null);
        NinePatchDrawable ninePatchDrawable = new NinePatchDrawable(this.mContext.getResources(), BitmapFactory.decodeResource(this.mContext.getResources(), d.emoji_box), BitmapFactory.decodeResource(this.mContext.getResources(), d.emoji_box).getNinePatchChunk(), new Rect(), null);
        ninePatchDrawable.setBounds(0, 0, width, height);
        ninePatchDrawable.draw(canvas);
        return createBitmap;
    }

    public final void CK() {
        double CH = (double) ((((float) CH()) * 1.0f) / 2.0f);
        double CI = (double) ((((float) CI()) * 1.0f) / 2.0f);
        this.dnU = (float) Math.sqrt((CH * CH) + (CI * CI));
        this.dnU *= this.dD / this.dnM;
        this.dnT = (float) Math.toDegrees(Math.atan(CI / CH));
    }

    public final PointF U(float f) {
        PointF pointF = new PointF();
        double d = (((double) (((float) this.dnL) + f)) * 3.141592653589793d) / 180.0d;
        pointF.x = this.dnK.x + ((float) (((double) this.dnU) * Math.cos(d)));
        pointF.y = this.dnK.y + ((float) (Math.sin(d) * ((double) this.dnU)));
        return pointF;
    }

    /* renamed from: CL */
    public final c clone() {
        c cVar;
        Throwable e;
        try {
            cVar = (c) super.clone();
            try {
                cVar.dnK = new PointF(this.dnK.x, this.dnK.y);
                cVar.dnI = this.dnI;
            } catch (CloneNotSupportedException e2) {
                e = e2;
                x.printErrStackTrace("MicroMsg.EmojiItem", e, "", new Object[0]);
                return cVar;
            }
        } catch (CloneNotSupportedException e3) {
            e = e3;
            cVar = null;
            x.printErrStackTrace("MicroMsg.EmojiItem", e, "", new Object[0]);
            return cVar;
        }
        return cVar;
    }
}

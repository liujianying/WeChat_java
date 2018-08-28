package com.davemorrissey.labs.subscaleview.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnAttachStateChangeListener;
import android.view.View.OnLongClickListener;
import android.view.ViewParent;
import com.davemorrissey.labs.subscaleview.b.b;
import com.davemorrissey.labs.subscaleview.b.c;
import com.davemorrissey.labs.subscaleview.c.a;
import com.davemorrissey.labs.subscaleview.c.d;
import com.davemorrissey.labs.subscaleview.c.e;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class SubsamplingScaleImageView extends View {
    private static final String TAG = SubsamplingScaleImageView.class.getSimpleName();
    private static final List<Integer> YZ = Arrays.asList(new Integer[]{Integer.valueOf(0), Integer.valueOf(90), Integer.valueOf(180), Integer.valueOf(270), Integer.valueOf(-1)});
    private static final List<Integer> Za = Arrays.asList(new Integer[]{Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3)});
    private static final List<Integer> Zb = Arrays.asList(new Integer[]{Integer.valueOf(2), Integer.valueOf(1)});
    private static final List<Integer> Zc = Arrays.asList(new Integer[]{Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3)});
    private static final List<Integer> Zd = Arrays.asList(new Integer[]{Integer.valueOf(2), Integer.valueOf(1), Integer.valueOf(3), Integer.valueOf(4)});
    public static int Zw = Integer.MAX_VALUE;
    private static Config aaB = Config.RGB_565;
    private static a aaC = new com.davemorrissey.labs.subscaleview.b.a();
    private static d aaD = new c();
    private static com.davemorrissey.labs.subscaleview.c.c aaE = new b();
    private final ReadWriteLock YA = new ReentrantReadWriteLock(true);
    private com.davemorrissey.labs.subscaleview.a.d YI;
    public int YV;
    public int YW;
    private Rect YX;
    private boolean ZA = true;
    private boolean ZB = true;
    private boolean ZC = true;
    private float ZD = 2.0f;
    private int ZE = 1;
    private int ZF = HardCoderJNI.sHCDBDELAY_WRITE;
    private int ZG = HardCoderJNI.sHCDBDELAY_WRITE;
    private float ZH;
    private PointF ZI;
    private PointF ZJ;
    private PointF ZK;
    private Float ZL;
    private PointF ZM;
    private PointF ZN;
    private boolean ZO;
    private a ZP;
    private a ZQ;
    private int ZR;
    private int ZS = 0;
    private Rect ZT;
    private boolean ZU;
    private boolean ZV;
    private boolean ZW;
    private int ZX;
    private GestureDetector ZY;
    private SimpleOnGestureListener ZZ;
    private boolean Ze;
    private boolean Zf;
    private boolean Zg;
    private int Zh;
    private int Zi;
    private boolean Zj;
    private int Zk;
    private boolean Zl = true;
    private long Zm = -1;
    private long Zn = -1;
    private Bitmap Zo;
    private Map<Integer, List<e>> Zp;
    private boolean Zq = false;
    private float Zr = 2.0f;
    private float Zs = hL();
    private int Zt = -1;
    private int Zu = 1;
    private int Zv = 3;
    private int Zx = Zw;
    private int Zy = Zw;
    private boolean Zz = true;
    private Matrix aaA;
    public Executor aaF = AsyncTask.THREAD_POOL_EXECUTOR;
    private int aaG;
    private int aaH;
    private float aaI;
    private float aaJ;
    public float aaK;
    private float aaL;
    private float aaM;
    private float aaN;
    private float aaO = 1.0f;
    private float aaP = 20.0f;
    private boolean aaQ = true;
    private boolean aaR = false;
    private PointF aaS;
    private OnAttachStateChangeListener aaT;
    private com.davemorrissey.labs.subscaleview.d.a aaU = new com.davemorrissey.labs.subscaleview.d.a();
    private c aaV = new 1(this);
    private boolean aaW = false;
    private boolean aaX = false;
    private boolean aaY = false;
    private float aaZ;
    private GestureDetector aaa;
    private com.davemorrissey.labs.subscaleview.a.b<? extends com.davemorrissey.labs.subscaleview.a.d> aab = new com.davemorrissey.labs.subscaleview.a.a(com.davemorrissey.labs.subscaleview.a.e.class);
    private com.davemorrissey.labs.subscaleview.a.b<? extends com.davemorrissey.labs.subscaleview.a.d> aac = new com.davemorrissey.labs.subscaleview.a.a(com.davemorrissey.labs.subscaleview.a.e.class);
    private PointF aad;
    private float aae;
    private final float aaf;
    private float aag;
    private boolean aah;
    private PointF aai;
    private PointF aaj;
    private PointF aak;
    private a aal;
    private boolean aam;
    private boolean aan;
    private e aao;
    private f aap;
    private OnLongClickListener aaq;
    private Paint aar;
    private Paint aas;
    private Paint aat;
    private Paint aau;
    private g aav;
    private Matrix aaw;
    private RectF aax;
    private float[] aay = new float[8];
    private float[] aaz = new float[8];
    private float aba;
    private Bitmap bitmap;
    private float density = getResources().getDisplayMetrics().density;
    private Handler handler;
    private int orientation = -1;
    private float scale;
    private Uri uri;

    public final synchronized void bU(int i) {
        if (this.aaU != null) {
            com.davemorrissey.labs.subscaleview.d.a aVar = this.aaU;
            aVar.YR += i;
            x.d("MicroMsg.ImageDecodeRecord", "alvinluo addTileInitTime: %d, total: %d", Integer.valueOf(i), Integer.valueOf(aVar.YR));
        }
    }

    public final synchronized void bV(int i) {
        if (this.aaU != null) {
            com.davemorrissey.labs.subscaleview.d.a aVar = this.aaU;
            aVar.YQ += i;
            x.d("MicroMsg.ImageDecodeRecord", "alvinluo addPreviewLoadedTime: %d, total: %d", Integer.valueOf(i), Integer.valueOf(aVar.YQ));
        }
    }

    public final synchronized void bW(int i) {
        if (this.aaU != null) {
            com.davemorrissey.labs.subscaleview.d.a aVar = this.aaU;
            aVar.YS += i;
            x.d("MicroMsg.ImageDecodeRecord", "alvinluo addTileDecodeTime: %d, total: %d", Integer.valueOf(i), Integer.valueOf(aVar.YS));
        }
    }

    public synchronized com.davemorrissey.labs.subscaleview.d.a getImageDecodeRecord() {
        return this.aaU;
    }

    public void setEdgeSwipeListener(c cVar) {
        this.aaV = cVar;
    }

    public void setOnAttachStateChangeListener(OnAttachStateChangeListener onAttachStateChangeListener) {
        this.aaT = onAttachStateChangeListener;
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.aaT != null) {
            this.aaT.onViewAttachedToWindow(this);
        }
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.aaT != null) {
            this.aaT.onViewDetachedFromWindow(this);
        }
        if (this.Zo != null && !this.Zo.isRecycled()) {
            x.i(TAG, "alvinluo cache recycle fullImageBitmap");
        }
    }

    public SubsamplingScaleImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setDoubleTapZoomScale(2.0f);
        setMinimumTileDpi(320);
        setGestureDetector(context);
        this.aaA = new Matrix();
        this.handler = new Handler(new 2(this));
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, com.davemorrissey.labs.subscaleview.a.a.SubsamplingScaleImageView);
            if (obtainStyledAttributes.hasValue(com.davemorrissey.labs.subscaleview.a.a.SubsamplingScaleImageView_assetName)) {
                String string = obtainStyledAttributes.getString(com.davemorrissey.labs.subscaleview.a.a.SubsamplingScaleImageView_assetName);
                if (string != null && string.length() > 0) {
                    if (string == null) {
                        throw new NullPointerException("Asset name must not be null");
                    }
                    setImage(a.S("file:///android_asset/" + string).hB());
                }
            }
            if (obtainStyledAttributes.hasValue(com.davemorrissey.labs.subscaleview.a.a.SubsamplingScaleImageView_src)) {
                int resourceId = obtainStyledAttributes.getResourceId(com.davemorrissey.labs.subscaleview.a.a.SubsamplingScaleImageView_src, 0);
                if (resourceId > 0) {
                    setImage(new a(resourceId).hB());
                }
            }
            if (obtainStyledAttributes.hasValue(com.davemorrissey.labs.subscaleview.a.a.SubsamplingScaleImageView_panEnabled)) {
                setPanEnabled(obtainStyledAttributes.getBoolean(com.davemorrissey.labs.subscaleview.a.a.SubsamplingScaleImageView_panEnabled, true));
            }
            if (obtainStyledAttributes.hasValue(com.davemorrissey.labs.subscaleview.a.a.SubsamplingScaleImageView_zoomEnabled)) {
                setZoomEnabled(obtainStyledAttributes.getBoolean(com.davemorrissey.labs.subscaleview.a.a.SubsamplingScaleImageView_zoomEnabled, true));
            }
            if (obtainStyledAttributes.hasValue(com.davemorrissey.labs.subscaleview.a.a.SubsamplingScaleImageView_quickScaleEnabled)) {
                setQuickScaleEnabled(obtainStyledAttributes.getBoolean(com.davemorrissey.labs.subscaleview.a.a.SubsamplingScaleImageView_quickScaleEnabled, true));
            }
            if (obtainStyledAttributes.hasValue(com.davemorrissey.labs.subscaleview.a.a.SubsamplingScaleImageView_tileBackgroundColor)) {
                setTileBackgroundColor(obtainStyledAttributes.getColor(com.davemorrissey.labs.subscaleview.a.a.SubsamplingScaleImageView_tileBackgroundColor, Color.argb(0, 0, 0, 0)));
            }
            obtainStyledAttributes.recycle();
        }
        this.aaf = TypedValue.applyDimension(1, 20.0f, context.getResources().getDisplayMetrics());
        float f = ((float) getContext().getResources().getDisplayMetrics().widthPixels) / 720.0f;
        if (f > 1.0f) {
            this.aaO = f;
        }
    }

    public ReadWriteLock getDecoderLock() {
        return this.YA;
    }

    public int getFullImageSampleSize() {
        return this.Zk;
    }

    public Bitmap getFullImageBitmap() {
        return this.Zo;
    }

    public void setPreviewDone(boolean z) {
        this.aaQ = z;
        invalidate();
    }

    public static Config getPreferredBitmapConfig() {
        return aaB;
    }

    public static void setPreferredBitmapConfig(Config config) {
        aaB = config;
    }

    public final void setOrientation(int i) {
        if (YZ.contains(Integer.valueOf(i))) {
            this.orientation = i;
            reset(false);
            invalidate();
            requestLayout();
            return;
        }
        throw new IllegalArgumentException("Invalid orientation: " + i);
    }

    public Rect getsRegion() {
        return this.YX;
    }

    public void setsRegion(Rect rect) {
        this.YX = rect;
    }

    public void setScaleRate(float f) {
        this.aaK = f;
    }

    private void hC() {
        this.Zr = (getDoubleTapZoomScale() * 2.0f) * this.aaO;
        this.Zs = Math.min(hL(), this.aaK * 0.75f);
        x.i(TAG, "alvinluo initScaleRate: %f", Float.valueOf(this.aaK));
    }

    public void setImageMatrix(Matrix matrix) {
        if (matrix != null && matrix.isIdentity()) {
            matrix = null;
        }
        if ((matrix == null && !this.aaA.isIdentity()) || (matrix != null && !this.aaA.equals(matrix))) {
            this.aaA.set(matrix);
            invalidate();
        }
    }

    public final void setImage(a aVar) {
        a(aVar, null);
    }

    public static void setBitmapLoaderImp(a aVar) {
        aaC = aVar;
    }

    public static void setTileInitLoaderImp(com.davemorrissey.labs.subscaleview.c.c cVar) {
        aaE = cVar;
    }

    public static void setTileLoaderImp(d dVar) {
        aaD = dVar;
    }

    public final void a(a aVar, a aVar2) {
        if (aVar == null) {
            throw new NullPointerException("imageSource must not be null");
        }
        reset(true);
        this.ZP = aVar;
        this.ZQ = aVar2;
        if (aVar.uri != null) {
            this.ZR = h(getContext(), aVar.uri.toString());
        }
        if (aVar2 != null) {
            if (aVar.YV <= 0 || aVar.YW <= 0) {
                x.e(TAG, "alvinluo Preview image cannot be used unless dimensions are provided for the main image");
            } else {
                this.YV = aVar.YV;
                this.YW = aVar.YW;
                this.ZT = aVar2.YX;
                if (aVar2.bitmap != null) {
                    this.Zj = aVar2.YY;
                    a(aVar2.bitmap, Integer.valueOf(0));
                } else {
                    Uri uri = aVar2.uri;
                    if (uri == null && aVar2.YT != null) {
                        uri = Uri.parse("android.resource://" + getContext().getPackageName() + "/" + aVar2.YT);
                    }
                    aaC.a(this, getContext(), this.aab, uri, true).hy();
                }
            }
        }
        if (aVar.bitmap != null && aVar.YX != null) {
            b(Bitmap.createBitmap(aVar.bitmap, aVar.YX.left, aVar.YX.top, aVar.YX.width(), aVar.YX.height()), 0, false);
        } else if (aVar.bitmap != null) {
            b(aVar.bitmap, 0, aVar.YY);
        } else {
            this.YX = aVar.YX;
            this.uri = aVar.uri;
            if (this.uri == null && aVar.YT != null) {
                this.uri = Uri.parse("android.resource://" + getContext().getPackageName() + "/" + aVar.YT);
            }
            if (aVar.YU || this.YX != null) {
                aaE.a(this, getContext(), this.aac, this.uri).hy();
            } else {
                aaC.a(this, getContext(), this.aab, this.uri, false).hy();
            }
        }
    }

    private void reset(boolean z) {
        i("reset newImage=" + z, new Object[0]);
        this.scale = 0.0f;
        this.ZH = 0.0f;
        this.ZI = null;
        this.ZJ = null;
        this.ZK = null;
        this.ZL = Float.valueOf(0.0f);
        this.ZM = null;
        this.ZN = null;
        this.ZU = false;
        this.ZV = false;
        this.ZW = false;
        this.ZX = 0;
        this.Zk = 0;
        this.aad = null;
        this.aae = 0.0f;
        this.aag = 0.0f;
        this.aah = false;
        this.aaj = null;
        this.aai = null;
        this.aak = null;
        this.aal = null;
        this.aav = null;
        this.aaw = null;
        this.aax = null;
        if (z) {
            if (this.aaU != null) {
                com.davemorrissey.labs.subscaleview.d.a aVar = this.aaU;
                aVar.YS = 0;
                aVar.YQ = 0;
                aVar.YS = 0;
            }
            this.uri = null;
            this.YA.writeLock().lock();
            try {
                if (this.YI != null) {
                    this.YI.recycle();
                    this.YI = null;
                }
                this.YA.writeLock().unlock();
                if (!(this.bitmap == null || this.Zj)) {
                    this.bitmap.recycle();
                }
                if (!(this.bitmap == null || !this.Zj || this.aao == null)) {
                    this.aao.hP();
                }
                this.YV = 0;
                this.YW = 0;
                this.ZR = 0;
                this.YX = null;
                this.ZT = null;
                this.aam = false;
                this.aan = false;
                this.bitmap = null;
                this.Ze = false;
                this.Zj = false;
                this.Zf = false;
                this.Zg = false;
                this.Zl = true;
            } catch (Throwable th) {
                this.YA.writeLock().unlock();
            }
        }
        if (this.Zp != null) {
            for (Entry value : this.Zp.entrySet()) {
                for (e eVar : (List) value.getValue()) {
                    eVar.YN = false;
                    if (eVar.bitmap != null) {
                        eVar.bitmap.recycle();
                        eVar.bitmap = null;
                    }
                }
            }
            this.Zp = null;
        }
        setGestureDetector(getContext());
    }

    public e getOnImageEventListener() {
        return this.aao;
    }

    public void setGestureDetectorListener(SimpleOnGestureListener simpleOnGestureListener) {
        this.ZZ = simpleOnGestureListener;
    }

    private void setGestureDetector(Context context) {
        this.ZY = new GestureDetector(context, new 3(this, context));
        this.aaa = new GestureDetector(context, new 4(this));
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        i("onSizeChanged %dx%d -> %dx%d scale: %f, pendingScale: %f, needPendingScale: %b", Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i), Integer.valueOf(i2), Float.valueOf(this.scale), this.ZL, Boolean.valueOf(this.ZO));
        hC();
        PointF center = getCenter();
        if ((this.aam || this.ZO) && center != null) {
            this.aal = null;
            if (!this.ZO) {
                this.ZL = Float.valueOf(this.scale);
                this.ZM = center;
            }
        }
    }

    protected void onMeasure(int i, int i2) {
        int mode = MeasureSpec.getMode(i);
        int mode2 = MeasureSpec.getMode(i2);
        int size = MeasureSpec.getSize(i);
        int size2 = MeasureSpec.getSize(i2);
        int i3 = mode != 1073741824 ? 1 : 0;
        if (mode2 != 1073741824) {
            mode = 1;
        } else {
            mode = 0;
        }
        if (this.YV > 0 && this.YW > 0) {
            if (i3 == 0 || mode == 0) {
                if (mode != 0) {
                    mode = (int) ((((double) hK()) / ((double) hJ())) * ((double) size));
                } else if (i3 != 0) {
                    size = (int) ((((double) hJ()) / ((double) hK())) * ((double) size2));
                    mode = size2;
                }
                size2 = Math.max(size, getSuggestedMinimumWidth());
                mode = Math.max(mode, getSuggestedMinimumHeight());
                setMeasuredDimension(size2, mode);
                this.aaG = size2;
                this.aaH = mode;
                x.d(TAG, "alvinluo SubsamplingImageView onMeasure mViewWidth: %d, mViewHeight: %d", Integer.valueOf(this.aaG), Integer.valueOf(this.aaG));
            }
            size2 = hJ();
            mode = hK();
            size = size2;
            size2 = Math.max(size, getSuggestedMinimumWidth());
            mode = Math.max(mode, getSuggestedMinimumHeight());
            setMeasuredDimension(size2, mode);
            this.aaG = size2;
            this.aaH = mode;
            x.d(TAG, "alvinluo SubsamplingImageView onMeasure mViewWidth: %d, mViewHeight: %d", Integer.valueOf(this.aaG), Integer.valueOf(this.aaG));
        }
        mode = size2;
        size2 = Math.max(size, getSuggestedMinimumWidth());
        mode = Math.max(mode, getSuggestedMinimumHeight());
        setMeasuredDimension(size2, mode);
        this.aaG = size2;
        this.aaH = mode;
        x.d(TAG, "alvinluo SubsamplingImageView onMeasure mViewWidth: %d, mViewHeight: %d", Integer.valueOf(this.aaG), Integer.valueOf(this.aaG));
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        x.d(TAG, "alvinluo SubsamplingScaleImageView dispatchTouchEvent");
        return super.dispatchTouchEvent(motionEvent);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(android.view.MotionEvent r15) {
        /*
        r14 = this;
        r0 = TAG;
        r1 = "alvinluo SubSamplingScaleImageView onTouchEvent: %d";
        r2 = 1;
        r2 = new java.lang.Object[r2];
        r3 = 0;
        r4 = r15.getAction();
        r4 = java.lang.Integer.valueOf(r4);
        r2[r3] = r4;
        com.tencent.mm.sdk.platformtools.x.d(r0, r1, r2);
        r0 = r14.aal;
        if (r0 == 0) goto L_0x0026;
    L_0x001a:
        r0 = r14.aal;
        r0 = r0.abo;
        if (r0 != 0) goto L_0x0026;
    L_0x0020:
        r0 = 1;
        r14.requestDisallowInterceptTouchEvent(r0);
        r0 = 1;
    L_0x0025:
        return r0;
    L_0x0026:
        r0 = 0;
        r14.aal = r0;
        r0 = r14.ZI;
        if (r0 != 0) goto L_0x0038;
    L_0x002d:
        r0 = r14.aaa;
        if (r0 == 0) goto L_0x0036;
    L_0x0031:
        r0 = r14.aaa;
        r0.onTouchEvent(r15);
    L_0x0036:
        r0 = 1;
        goto L_0x0025;
    L_0x0038:
        r0 = r14.ZW;
        if (r0 != 0) goto L_0x0053;
    L_0x003c:
        r0 = r14.ZY;
        if (r0 == 0) goto L_0x0048;
    L_0x0040:
        r0 = r14.ZY;
        r0 = r0.onTouchEvent(r15);
        if (r0 == 0) goto L_0x0053;
    L_0x0048:
        r0 = 0;
        r14.ZU = r0;
        r0 = 0;
        r14.ZV = r0;
        r0 = 0;
        r14.ZX = r0;
        r0 = 1;
        goto L_0x0025;
    L_0x0053:
        r0 = r14.ZJ;
        if (r0 != 0) goto L_0x0060;
    L_0x0057:
        r0 = new android.graphics.PointF;
        r1 = 0;
        r2 = 0;
        r0.<init>(r1, r2);
        r14.ZJ = r0;
    L_0x0060:
        r0 = r14.ZK;
        if (r0 != 0) goto L_0x006d;
    L_0x0064:
        r0 = new android.graphics.PointF;
        r1 = 0;
        r2 = 0;
        r0.<init>(r1, r2);
        r14.ZK = r0;
    L_0x006d:
        r0 = r14.aad;
        if (r0 != 0) goto L_0x007a;
    L_0x0071:
        r0 = new android.graphics.PointF;
        r1 = 0;
        r2 = 0;
        r0.<init>(r1, r2);
        r14.aad = r0;
    L_0x007a:
        r0 = r14.ZK;
        r1 = r14.ZI;
        r0.set(r1);
        r1 = r15.getPointerCount();
        r0 = r15.getAction();
        switch(r0) {
            case 0: goto L_0x00b6;
            case 1: goto L_0x05ff;
            case 2: goto L_0x0158;
            case 5: goto L_0x00b6;
            case 6: goto L_0x05ff;
            case 261: goto L_0x00b6;
            case 262: goto L_0x05ff;
            default: goto L_0x008c;
        };
    L_0x008c:
        r0 = 0;
    L_0x008d:
        r1 = r14.ZK;
        r14.d(r1);
        r1 = super.onTouchEvent(r15);
        r2 = TAG;
        r3 = "alvinluo onTouchEvent super: %b, handled: %b";
        r4 = 2;
        r4 = new java.lang.Object[r4];
        r5 = 0;
        r6 = java.lang.Boolean.valueOf(r1);
        r4[r5] = r6;
        r5 = 1;
        r6 = java.lang.Boolean.valueOf(r0);
        r4[r5] = r6;
        com.tencent.mm.sdk.platformtools.x.i(r2, r3, r4);
        if (r0 != 0) goto L_0x00b3;
    L_0x00b1:
        if (r1 == 0) goto L_0x070c;
    L_0x00b3:
        r0 = 1;
        goto L_0x0025;
    L_0x00b6:
        r0 = r15.getRawX();
        r14.aaZ = r0;
        r0 = r15.getRawY();
        r14.aba = r0;
        r0 = 0;
        r14.aal = r0;
        r0 = 1;
        r14.requestDisallowInterceptTouchEvent(r0);
        r0 = r14.ZX;
        r0 = java.lang.Math.max(r0, r1);
        r14.ZX = r0;
        r0 = 2;
        if (r1 < r0) goto L_0x0131;
    L_0x00d4:
        r0 = r14.ZB;
        if (r0 == 0) goto L_0x012d;
    L_0x00d8:
        r0 = 0;
        r0 = r15.getX(r0);
        r1 = 1;
        r1 = r15.getX(r1);
        r2 = 0;
        r2 = r15.getY(r2);
        r3 = 1;
        r3 = r15.getY(r3);
        r0 = c(r0, r1, r2, r3);
        r1 = r14.scale;
        r14.ZH = r1;
        r14.aae = r0;
        r0 = r14.ZJ;
        r1 = r14.ZI;
        r1 = r1.x;
        r2 = r14.ZI;
        r2 = r2.y;
        r0.set(r1, r2);
        r0 = r14.aad;
        r1 = 0;
        r1 = r15.getX(r1);
        r2 = 1;
        r2 = r15.getX(r2);
        r1 = r1 + r2;
        r2 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r1 = r1 / r2;
        r2 = 0;
        r2 = r15.getY(r2);
        r3 = 1;
        r3 = r15.getY(r3);
        r2 = r2 + r3;
        r3 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r2 = r2 / r3;
        r0.set(r1, r2);
    L_0x0124:
        r0 = r14.handler;
        r1 = 1;
        r0.removeMessages(r1);
    L_0x012a:
        r0 = 1;
        goto L_0x008d;
    L_0x012d:
        r0 = 0;
        r14.ZX = r0;
        goto L_0x0124;
    L_0x0131:
        r0 = r14.ZW;
        if (r0 != 0) goto L_0x012a;
    L_0x0135:
        r0 = r14.ZJ;
        r1 = r14.ZI;
        r1 = r1.x;
        r2 = r14.ZI;
        r2 = r2.y;
        r0.set(r1, r2);
        r0 = r14.aad;
        r1 = r15.getX();
        r2 = r15.getY();
        r0.set(r1, r2);
        r0 = r14.handler;
        r1 = 1;
        r2 = 600; // 0x258 float:8.41E-43 double:2.964E-321;
        r0.sendEmptyMessageDelayed(r1, r2);
        goto L_0x012a;
    L_0x0158:
        r0 = 0;
        r2 = r14.ZX;
        if (r2 <= 0) goto L_0x0245;
    L_0x015d:
        r2 = 2;
        if (r1 < r2) goto L_0x0345;
    L_0x0160:
        r1 = 0;
        r1 = r15.getX(r1);
        r2 = 1;
        r2 = r15.getX(r2);
        r3 = 0;
        r3 = r15.getY(r3);
        r4 = 1;
        r4 = r15.getY(r4);
        r2 = c(r1, r2, r3, r4);
        r1 = 0;
        r1 = r15.getX(r1);
        r3 = 1;
        r3 = r15.getX(r3);
        r1 = r1 + r3;
        r3 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r3 = r1 / r3;
        r1 = 0;
        r1 = r15.getY(r1);
        r4 = 1;
        r4 = r15.getY(r4);
        r1 = r1 + r4;
        r4 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r4 = r1 / r4;
        r1 = new android.graphics.PointF;
        r1.<init>(r3, r4);
        r14.aaS = r1;
        r1 = r14.ZB;
        if (r1 == 0) goto L_0x0245;
    L_0x01a1:
        r1 = r14.aad;
        r1 = r1.x;
        r5 = r14.aad;
        r5 = r5.y;
        r1 = c(r1, r3, r5, r4);
        r5 = 1084227584; // 0x40a00000 float:5.0 double:5.356796015E-315;
        r1 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1));
        if (r1 > 0) goto L_0x01c5;
    L_0x01b3:
        r1 = r14.aae;
        r1 = r2 - r1;
        r1 = java.lang.Math.abs(r1);
        r5 = 1084227584; // 0x40a00000 float:5.0 double:5.356796015E-315;
        r1 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1));
        if (r1 > 0) goto L_0x01c5;
    L_0x01c1:
        r1 = r14.ZV;
        if (r1 == 0) goto L_0x0245;
    L_0x01c5:
        r0 = 1;
        r14.ZU = r0;
        r0 = 1;
        r14.ZV = r0;
        r1 = 1;
        r0 = r14.scale;
        r6 = (double) r0;
        r0 = r14.aae;
        r0 = r2 / r0;
        r5 = r14.ZH;
        r0 = r0 * r5;
        r5 = r14.Zr;
        r8 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r5 = r5 * r8;
        r5 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1));
        if (r5 < 0) goto L_0x01ec;
    L_0x01df:
        r5 = r14.Zr;
        r8 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r5 = r5 * r8;
        r8 = r14.Zr;
        r0 = r0 - r8;
        r8 = 1036831949; // 0x3dcccccd float:0.1 double:5.122630465E-315;
        r0 = r0 * r8;
        r0 = r0 + r5;
    L_0x01ec:
        r14.scale = r0;
        r0 = TAG;
        r5 = "alvinluo zoom preScale: %f, scale: %f, minScale: %f, maxScale: %f";
        r8 = 4;
        r8 = new java.lang.Object[r8];
        r9 = 0;
        r10 = java.lang.Double.valueOf(r6);
        r8[r9] = r10;
        r9 = 1;
        r10 = r14.scale;
        r10 = java.lang.Float.valueOf(r10);
        r8[r9] = r10;
        r9 = 2;
        r10 = r14.hL();
        r10 = java.lang.Float.valueOf(r10);
        r8[r9] = r10;
        r9 = 3;
        r10 = r14.Zr;
        r10 = java.lang.Float.valueOf(r10);
        r8[r9] = r10;
        com.tencent.mm.sdk.platformtools.x.i(r0, r5, r8);
        r0 = r14.scale;
        r5 = r14.hL();
        r0 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1));
        if (r0 > 0) goto L_0x0265;
    L_0x0227:
        r14.aae = r2;
        r0 = r14.hL();
        r14.ZH = r0;
        r0 = r14.aad;
        r0.set(r3, r4);
        r0 = r14.ZJ;
        r2 = r14.ZI;
        r0.set(r2);
    L_0x023b:
        r0 = 1;
        r14.ab(r0);
        r0 = r14.Zz;
        r14.aa(r0);
        r0 = r1;
    L_0x0245:
        r1 = TAG;
        r2 = "alvinluo Action_Move consumed: %b";
        r3 = 1;
        r3 = new java.lang.Object[r3];
        r4 = 0;
        r5 = java.lang.Boolean.valueOf(r0);
        r3[r4] = r5;
        com.tencent.mm.sdk.platformtools.x.d(r1, r2, r3);
        if (r0 == 0) goto L_0x008c;
    L_0x0259:
        r0 = r14.handler;
        r1 = 1;
        r0.removeMessages(r1);
        r14.invalidate();
        r0 = 1;
        goto L_0x008d;
    L_0x0265:
        r0 = r14.ZA;
        if (r0 == 0) goto L_0x02eb;
    L_0x0269:
        r0 = r14.aad;
        r0 = r0.x;
        r5 = r14.ZJ;
        r5 = r5.x;
        r0 = r0 - r5;
        r5 = r14.aad;
        r5 = r5.y;
        r8 = r14.ZJ;
        r8 = r8.y;
        r5 = r5 - r8;
        r8 = r14.scale;
        r9 = r14.ZH;
        r8 = r8 / r9;
        r0 = r0 * r8;
        r8 = r14.scale;
        r9 = r14.ZH;
        r8 = r8 / r9;
        r5 = r5 * r8;
        r8 = r14.ZI;
        r0 = r3 - r0;
        r8.x = r0;
        r0 = r14.ZI;
        r5 = r4 - r5;
        r0.y = r5;
        r0 = r14.hK();
        r8 = (double) r0;
        r8 = r8 * r6;
        r0 = r14.getHeight();
        r10 = (double) r0;
        r0 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1));
        if (r0 >= 0) goto L_0x02b3;
    L_0x02a2:
        r0 = r14.scale;
        r5 = r14.hK();
        r5 = (float) r5;
        r0 = r0 * r5;
        r5 = r14.getHeight();
        r5 = (float) r5;
        r0 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1));
        if (r0 >= 0) goto L_0x02d3;
    L_0x02b3:
        r0 = r14.hJ();
        r8 = (double) r0;
        r6 = r6 * r8;
        r0 = r14.getWidth();
        r8 = (double) r0;
        r0 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1));
        if (r0 >= 0) goto L_0x023b;
    L_0x02c2:
        r0 = r14.scale;
        r5 = r14.hJ();
        r5 = (float) r5;
        r0 = r0 * r5;
        r5 = r14.getWidth();
        r5 = (float) r5;
        r0 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1));
        if (r0 < 0) goto L_0x023b;
    L_0x02d3:
        r0 = 1;
        r14.ab(r0);
        r0 = r14.aad;
        r0.set(r3, r4);
        r0 = r14.ZJ;
        r3 = r14.ZI;
        r0.set(r3);
        r0 = r14.scale;
        r14.ZH = r0;
        r14.aae = r2;
        goto L_0x023b;
    L_0x02eb:
        r0 = r14.ZN;
        if (r0 == 0) goto L_0x0317;
    L_0x02ef:
        r0 = r14.ZI;
        r2 = r14.getWidth();
        r2 = r2 / 2;
        r2 = (float) r2;
        r3 = r14.scale;
        r4 = r14.ZN;
        r4 = r4.x;
        r3 = r3 * r4;
        r2 = r2 - r3;
        r0.x = r2;
        r0 = r14.ZI;
        r2 = r14.getHeight();
        r2 = r2 / 2;
        r2 = (float) r2;
        r3 = r14.scale;
        r4 = r14.ZN;
        r4 = r4.y;
        r3 = r3 * r4;
        r2 = r2 - r3;
        r0.y = r2;
        goto L_0x023b;
    L_0x0317:
        r0 = r14.ZI;
        r2 = r14.getWidth();
        r2 = r2 / 2;
        r2 = (float) r2;
        r3 = r14.scale;
        r4 = r14.hJ();
        r4 = r4 / 2;
        r4 = (float) r4;
        r3 = r3 * r4;
        r2 = r2 - r3;
        r0.x = r2;
        r0 = r14.ZI;
        r2 = r14.getHeight();
        r2 = r2 / 2;
        r2 = (float) r2;
        r3 = r14.scale;
        r4 = r14.hK();
        r4 = r4 / 2;
        r4 = (float) r4;
        r3 = r3 * r4;
        r2 = r2 - r3;
        r0.y = r2;
        goto L_0x023b;
    L_0x0345:
        r1 = r14.ZW;
        if (r1 == 0) goto L_0x04be;
    L_0x0349:
        r0 = r14.aak;
        r0 = r0.y;
        r1 = r15.getY();
        r0 = r0 - r1;
        r0 = java.lang.Math.abs(r0);
        r1 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r0 = r0 * r1;
        r1 = r14.aaf;
        r2 = r0 + r1;
        r0 = r14.aag;
        r1 = -1082130432; // 0xffffffffbf800000 float:-1.0 double:NaN;
        r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1));
        if (r0 != 0) goto L_0x0367;
    L_0x0365:
        r14.aag = r2;
    L_0x0367:
        r0 = r15.getY();
        r1 = r14.aai;
        r1 = r1.y;
        r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1));
        if (r0 <= 0) goto L_0x045e;
    L_0x0373:
        r0 = 1;
    L_0x0374:
        r1 = r14.aai;
        r3 = 0;
        r4 = r15.getY();
        r1.set(r3, r4);
        r1 = 1065353216; // 0x3f800000 float:1.0 double:5.263544247E-315;
        r3 = r14.aag;
        r3 = r2 / r3;
        r1 = r1 - r3;
        r1 = java.lang.Math.abs(r1);
        r3 = 1056964608; // 0x3f000000 float:0.5 double:5.222099017E-315;
        r3 = r3 * r1;
        r1 = 1022739087; // 0x3cf5c28f float:0.03 double:5.053002475E-315;
        r1 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1));
        if (r1 > 0) goto L_0x0397;
    L_0x0393:
        r1 = r14.aah;
        if (r1 == 0) goto L_0x0450;
    L_0x0397:
        r1 = 1;
        r14.aah = r1;
        r1 = 1065353216; // 0x3f800000 float:1.0 double:5.263544247E-315;
        r4 = r14.aag;
        r5 = 0;
        r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1));
        if (r4 <= 0) goto L_0x0712;
    L_0x03a3:
        if (r0 == 0) goto L_0x0461;
    L_0x03a5:
        r0 = 1065353216; // 0x3f800000 float:1.0 double:5.263544247E-315;
        r0 = r0 + r3;
    L_0x03a8:
        r1 = r14.scale;
        r4 = (double) r1;
        r1 = r14.hL();
        r3 = r14.Zr;
        r6 = r14.scale;
        r0 = r0 * r6;
        r0 = java.lang.Math.min(r3, r0);
        r0 = java.lang.Math.max(r1, r0);
        r14.scale = r0;
        r0 = r14.ZA;
        if (r0 == 0) goto L_0x0466;
    L_0x03c2:
        r0 = r14.aad;
        r0 = r0.x;
        r1 = r14.ZJ;
        r1 = r1.x;
        r0 = r0 - r1;
        r1 = r14.aad;
        r1 = r1.y;
        r3 = r14.ZJ;
        r3 = r3.y;
        r1 = r1 - r3;
        r3 = r14.scale;
        r6 = r14.ZH;
        r3 = r3 / r6;
        r0 = r0 * r3;
        r3 = r14.scale;
        r6 = r14.ZH;
        r3 = r3 / r6;
        r1 = r1 * r3;
        r3 = r14.ZI;
        r6 = r14.aad;
        r6 = r6.x;
        r0 = r6 - r0;
        r3.x = r0;
        r0 = r14.ZI;
        r3 = r14.aad;
        r3 = r3.y;
        r1 = r3 - r1;
        r0.y = r1;
        r0 = r14.hK();
        r0 = (double) r0;
        r0 = r0 * r4;
        r3 = r14.getHeight();
        r6 = (double) r3;
        r0 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1));
        if (r0 >= 0) goto L_0x0414;
    L_0x0403:
        r0 = r14.scale;
        r1 = r14.hK();
        r1 = (float) r1;
        r0 = r0 * r1;
        r1 = r14.getHeight();
        r1 = (float) r1;
        r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1));
        if (r0 >= 0) goto L_0x0434;
    L_0x0414:
        r0 = r14.hJ();
        r0 = (double) r0;
        r0 = r0 * r4;
        r3 = r14.getWidth();
        r4 = (double) r3;
        r0 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1));
        if (r0 >= 0) goto L_0x070f;
    L_0x0423:
        r0 = r14.scale;
        r1 = r14.hJ();
        r1 = (float) r1;
        r0 = r0 * r1;
        r1 = r14.getWidth();
        r1 = (float) r1;
        r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1));
        if (r0 < 0) goto L_0x070f;
    L_0x0434:
        r0 = 1;
        r14.ab(r0);
        r0 = r14.aad;
        r1 = r14.aaj;
        r1 = r14.c(r1);
        r0.set(r1);
        r0 = r14.ZJ;
        r1 = r14.ZI;
        r0.set(r1);
        r0 = r14.scale;
        r14.ZH = r0;
        r0 = 0;
    L_0x044f:
        r2 = r0;
    L_0x0450:
        r14.aag = r2;
        r0 = 1;
        r14.ab(r0);
        r0 = r14.Zz;
        r14.aa(r0);
        r0 = 1;
        goto L_0x0245;
    L_0x045e:
        r0 = 0;
        goto L_0x0374;
    L_0x0461:
        r0 = 1065353216; // 0x3f800000 float:1.0 double:5.263544247E-315;
        r0 = r0 - r3;
        goto L_0x03a8;
    L_0x0466:
        r0 = r14.ZN;
        if (r0 == 0) goto L_0x0491;
    L_0x046a:
        r0 = r14.ZI;
        r1 = r14.getWidth();
        r1 = r1 / 2;
        r1 = (float) r1;
        r3 = r14.scale;
        r4 = r14.ZN;
        r4 = r4.x;
        r3 = r3 * r4;
        r1 = r1 - r3;
        r0.x = r1;
        r0 = r14.ZI;
        r1 = r14.getHeight();
        r1 = r1 / 2;
        r1 = (float) r1;
        r3 = r14.scale;
        r4 = r14.ZN;
        r4 = r4.y;
        r3 = r3 * r4;
        r1 = r1 - r3;
        r0.y = r1;
        goto L_0x0450;
    L_0x0491:
        r0 = r14.ZI;
        r1 = r14.getWidth();
        r1 = r1 / 2;
        r1 = (float) r1;
        r3 = r14.scale;
        r4 = r14.hJ();
        r4 = r4 / 2;
        r4 = (float) r4;
        r3 = r3 * r4;
        r1 = r1 - r3;
        r0.x = r1;
        r0 = r14.ZI;
        r1 = r14.getHeight();
        r1 = r1 / 2;
        r1 = (float) r1;
        r3 = r14.scale;
        r4 = r14.hK();
        r4 = r4 / 2;
        r4 = (float) r4;
        r3 = r3 * r4;
        r1 = r1 - r3;
        r0.y = r1;
        goto L_0x0450;
    L_0x04be:
        r1 = r14.ZU;
        if (r1 != 0) goto L_0x0245;
    L_0x04c2:
        r1 = r15.getX();
        r2 = r14.aad;
        r2 = r2.x;
        r1 = r1 - r2;
        r6 = java.lang.Math.abs(r1);
        r1 = r15.getY();
        r2 = r14.aad;
        r2 = r2.y;
        r1 = r1 - r2;
        r7 = java.lang.Math.abs(r1);
        r1 = r14.density;
        r2 = 1084227584; // 0x40a00000 float:5.0 double:5.356796015E-315;
        r8 = r1 * r2;
        r1 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1));
        if (r1 > 0) goto L_0x04ee;
    L_0x04e6:
        r1 = (r7 > r8 ? 1 : (r7 == r8 ? 0 : -1));
        if (r1 > 0) goto L_0x04ee;
    L_0x04ea:
        r1 = r14.ZV;
        if (r1 == 0) goto L_0x0245;
    L_0x04ee:
        r3 = 1;
        r0 = r14.ZI;
        r1 = r14.ZJ;
        r1 = r1.x;
        r2 = r15.getX();
        r4 = r14.aad;
        r4 = r4.x;
        r2 = r2 - r4;
        r1 = r1 + r2;
        r0.x = r1;
        r0 = r14.ZI;
        r1 = r14.ZJ;
        r1 = r1.y;
        r2 = r15.getY();
        r4 = r14.aad;
        r4 = r4.y;
        r2 = r2 - r4;
        r1 = r1 + r2;
        r0.y = r1;
        r0 = r14.ZI;
        r0 = r0.x;
        r1 = r14.ZI;
        r2 = r1.y;
        r1 = 1;
        r14.ab(r1);
        r1 = r14.ZI;
        r1 = r1.x;
        r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1));
        if (r0 == 0) goto L_0x05d8;
    L_0x0527:
        r0 = 1;
    L_0x0528:
        r1 = r14.ZI;
        r1 = r1.y;
        r1 = (r2 > r1 ? 1 : (r2 == r1 ? 0 : -1));
        if (r1 == 0) goto L_0x05db;
    L_0x0530:
        r1 = 1;
        r5 = r1;
    L_0x0532:
        if (r0 == 0) goto L_0x05df;
    L_0x0534:
        r1 = (r6 > r7 ? 1 : (r6 == r7 ? 0 : -1));
        if (r1 <= 0) goto L_0x05df;
    L_0x0538:
        r1 = r14.ZV;
        if (r1 != 0) goto L_0x05df;
    L_0x053c:
        r1 = 1;
        r4 = r1;
    L_0x053e:
        if (r5 == 0) goto L_0x05e3;
    L_0x0540:
        r1 = (r7 > r6 ? 1 : (r7 == r6 ? 0 : -1));
        if (r1 <= 0) goto L_0x05e3;
    L_0x0544:
        r1 = r14.ZV;
        if (r1 != 0) goto L_0x05e3;
    L_0x0548:
        r1 = 1;
    L_0x0549:
        r9 = r14.ZI;
        r9 = r9.y;
        r2 = (r2 > r9 ? 1 : (r2 == r9 ? 0 : -1));
        if (r2 != 0) goto L_0x05e6;
    L_0x0551:
        r2 = 1077936128; // 0x40400000 float:3.0 double:5.325712093E-315;
        r2 = r2 * r8;
        r2 = (r7 > r2 ? 1 : (r7 == r2 ? 0 : -1));
        if (r2 <= 0) goto L_0x05e6;
    L_0x0558:
        r2 = 1;
    L_0x0559:
        r9 = TAG;
        r10 = "alvinluo Action_Move edge atXEdge: %b, atYEdge: %b, edgeXSwipe: %b, edgeYSwipe: %b, yPan: %b, isPanning: %b,dx: %f, dy: %f, offset: %f";
        r11 = 9;
        r11 = new java.lang.Object[r11];
        r12 = 0;
        r13 = java.lang.Boolean.valueOf(r0);
        r11[r12] = r13;
        r12 = 1;
        r13 = java.lang.Boolean.valueOf(r5);
        r11[r12] = r13;
        r12 = 2;
        r13 = java.lang.Boolean.valueOf(r4);
        r11[r12] = r13;
        r12 = 3;
        r13 = java.lang.Boolean.valueOf(r1);
        r11[r12] = r13;
        r12 = 4;
        r13 = java.lang.Boolean.valueOf(r2);
        r11[r12] = r13;
        r12 = 5;
        r13 = r14.ZV;
        r13 = java.lang.Boolean.valueOf(r13);
        r11[r12] = r13;
        r12 = 6;
        r13 = java.lang.Float.valueOf(r6);
        r11[r12] = r13;
        r12 = 7;
        r13 = java.lang.Float.valueOf(r7);
        r11[r12] = r13;
        r12 = 8;
        r13 = java.lang.Float.valueOf(r8);
        r11[r12] = r13;
        com.tencent.mm.sdk.platformtools.x.i(r9, r10, r11);
        if (r4 != 0) goto L_0x05e9;
    L_0x05a9:
        if (r1 != 0) goto L_0x05e9;
    L_0x05ab:
        if (r0 == 0) goto L_0x05b5;
    L_0x05ad:
        if (r5 == 0) goto L_0x05b5;
    L_0x05af:
        if (r2 != 0) goto L_0x05b5;
    L_0x05b1:
        r0 = r14.ZV;
        if (r0 == 0) goto L_0x05e9;
    L_0x05b5:
        r0 = 1;
        r14.ZV = r0;
    L_0x05b8:
        r0 = r14.ZA;
        if (r0 != 0) goto L_0x05d0;
    L_0x05bc:
        r0 = r14.ZI;
        r1 = r14.ZJ;
        r1 = r1.x;
        r0.x = r1;
        r0 = r14.ZI;
        r1 = r14.ZJ;
        r1 = r1.y;
        r0.y = r1;
        r0 = 0;
        r14.requestDisallowInterceptTouchEvent(r0);
    L_0x05d0:
        r0 = r14.Zz;
        r14.aa(r0);
        r0 = r3;
        goto L_0x0245;
    L_0x05d8:
        r0 = 0;
        goto L_0x0528;
    L_0x05db:
        r1 = 0;
        r5 = r1;
        goto L_0x0532;
    L_0x05df:
        r1 = 0;
        r4 = r1;
        goto L_0x053e;
    L_0x05e3:
        r1 = 0;
        goto L_0x0549;
    L_0x05e6:
        r2 = 0;
        goto L_0x0559;
    L_0x05e9:
        r0 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1));
        if (r0 > 0) goto L_0x05f1;
    L_0x05ed:
        r0 = (r7 > r8 ? 1 : (r7 == r8 ? 0 : -1));
        if (r0 <= 0) goto L_0x05b8;
    L_0x05f1:
        r0 = 0;
        r14.ZX = r0;
        r0 = r14.handler;
        r1 = 1;
        r0.removeMessages(r1);
        r0 = 0;
        r14.requestDisallowInterceptTouchEvent(r0);
        goto L_0x05b8;
    L_0x05ff:
        r0 = r14.handler;
        r2 = 1;
        r0.removeMessages(r2);
        r0 = r14.ZW;
        if (r0 == 0) goto L_0x0617;
    L_0x0609:
        r0 = 0;
        r14.ZW = r0;
        r0 = r14.aah;
        if (r0 != 0) goto L_0x0617;
    L_0x0610:
        r0 = r14.aaj;
        r2 = r14.aad;
        r14.a(r0, r2);
    L_0x0617:
        r0 = r14.ZX;
        if (r0 <= 0) goto L_0x06fd;
    L_0x061b:
        r0 = r14.ZU;
        if (r0 != 0) goto L_0x0623;
    L_0x061f:
        r0 = r14.ZV;
        if (r0 == 0) goto L_0x06fd;
    L_0x0623:
        r0 = r14.ZU;
        if (r0 == 0) goto L_0x068c;
    L_0x0627:
        r0 = 2;
        if (r1 != r0) goto L_0x068c;
    L_0x062a:
        r0 = 1;
        r14.ZV = r0;
        r0 = r14.ZJ;
        r2 = r14.ZI;
        r2 = r2.x;
        r3 = r14.ZI;
        r3 = r3.y;
        r0.set(r2, r3);
        r0 = r15.getActionIndex();
        r2 = 1;
        if (r0 != r2) goto L_0x06a2;
    L_0x0641:
        r0 = r14.aad;
        r2 = 0;
        r2 = r15.getX(r2);
        r3 = 0;
        r3 = r15.getY(r3);
        r0.set(r2, r3);
    L_0x0650:
        r0 = r14.scale;
        r2 = r14.aaK;
        r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
        if (r0 > 0) goto L_0x06b2;
    L_0x0658:
        r0 = TAG;
        r2 = "alvinluo scale %f less than %f, and need to reset";
        r3 = 2;
        r3 = new java.lang.Object[r3];
        r4 = 0;
        r5 = r14.scale;
        r5 = java.lang.Float.valueOf(r5);
        r3[r4] = r5;
        r4 = 1;
        r5 = r14.aaK;
        r5 = java.lang.Float.valueOf(r5);
        r3[r4] = r5;
        com.tencent.mm.sdk.platformtools.x.i(r0, r2, r3);
        r0 = new android.graphics.PointF;
        r2 = r14.aaG;
        r2 = r2 / 2;
        r2 = (float) r2;
        r3 = r14.aaH;
        r3 = r3 / 2;
        r3 = (float) r3;
        r0.<init>(r2, r3);
        r2 = r14.aaK;
        r14.b(r0, r0, r2);
        r0 = 0;
        r14.ZV = r0;
    L_0x068c:
        r0 = 3;
        if (r1 >= r0) goto L_0x0692;
    L_0x068f:
        r0 = 0;
        r14.ZU = r0;
    L_0x0692:
        r0 = 2;
        if (r1 >= r0) goto L_0x069b;
    L_0x0695:
        r0 = 0;
        r14.ZV = r0;
        r0 = 0;
        r14.ZX = r0;
    L_0x069b:
        r0 = 1;
        r14.aa(r0);
        r0 = 1;
        goto L_0x008d;
    L_0x06a2:
        r0 = r14.aad;
        r2 = 1;
        r2 = r15.getX(r2);
        r3 = 1;
        r3 = r15.getY(r3);
        r0.set(r2, r3);
        goto L_0x0650;
    L_0x06b2:
        r0 = r14.scale;
        r2 = r14.getDoubleTapZoomScale();
        r3 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r2 = r2 * r3;
        r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
        if (r0 <= 0) goto L_0x068c;
    L_0x06bf:
        r0 = TAG;
        r2 = "alvinluo current scale %f larger than maxScale: %f, and reset to scale: %f";
        r3 = 3;
        r3 = new java.lang.Object[r3];
        r4 = 0;
        r5 = r14.scale;
        r5 = java.lang.Float.valueOf(r5);
        r3[r4] = r5;
        r4 = 1;
        r5 = r14.Zr;
        r5 = java.lang.Float.valueOf(r5);
        r3[r4] = r5;
        r4 = 2;
        r5 = r14.getDoubleTapZoomScale();
        r6 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r5 = r5 * r6;
        r5 = java.lang.Float.valueOf(r5);
        r3[r4] = r5;
        com.tencent.mm.sdk.platformtools.x.i(r0, r2, r3);
        r0 = r14.aaS;
        r0 = r14.b(r0);
        r2 = r14.aaS;
        r3 = r14.getDoubleTapZoomScale();
        r4 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r3 = r3 * r4;
        r14.b(r0, r2, r3);
        goto L_0x068c;
    L_0x06fd:
        r0 = 1;
        if (r1 != r0) goto L_0x0709;
    L_0x0700:
        r0 = 0;
        r14.ZU = r0;
        r0 = 0;
        r14.ZV = r0;
        r0 = 0;
        r14.ZX = r0;
    L_0x0709:
        r0 = 0;
        goto L_0x008d;
    L_0x070c:
        r0 = 0;
        goto L_0x0025;
    L_0x070f:
        r0 = r2;
        goto L_0x044f;
    L_0x0712:
        r0 = r1;
        goto L_0x03a8;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.davemorrissey.labs.subscaleview.view.SubsamplingScaleImageView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    private void requestDisallowInterceptTouchEvent(boolean z) {
        ViewParent parent = getParent();
        if (parent != null) {
            x.i(TAG, "alvinluo requestDisallowInterceptTouchEvent disallow: %b", Boolean.valueOf(z));
            parent.requestDisallowInterceptTouchEvent(z);
        }
    }

    private float getDoubleTapZoomScale() {
        float f = this.aaK;
        if (this.aaI * 0.7f > f) {
            f = this.aaI;
        } else if (this.aaJ * 0.7f > f) {
            f = this.aaJ;
        } else {
            f = this.aaK * this.ZD;
        }
        if (((double) f) < 1.0d) {
            f = 1.0f;
        }
        if (f > this.Zr) {
            return this.Zr;
        }
        return f;
    }

    private void a(PointF pointF, PointF pointF2) {
        boolean z;
        if (!this.ZA) {
            if (this.ZN != null) {
                pointF.x = this.ZN.x;
                pointF.y = this.ZN.y;
            } else {
                pointF.x = (float) (hJ() / 2);
                pointF.y = (float) (hK() / 2);
            }
        }
        float doubleTapZoomScale = getDoubleTapZoomScale();
        x.i(TAG, "alvinluo doubleTapZoom %f", Float.valueOf(doubleTapZoomScale));
        if (((double) this.scale) <= ((double) doubleTapZoomScale) * 0.9d || this.scale == this.aaK) {
            z = true;
        } else {
            z = false;
        }
        float f = z ? doubleTapZoomScale : this.aaK;
        if (this.ZE == 3) {
            a(f, pointF);
        } else if (this.ZE == 2 || !z || !this.ZA) {
            b bVar = new b(this, f, pointF, (byte) 0);
            bVar.abo = false;
            bVar.duration = (long) this.ZF;
            b.a(bVar, 4).start();
        } else if (this.ZE == 1) {
            b bVar2 = new b(this, doubleTapZoomScale, pointF, pointF2, (byte) 0);
            bVar2.abo = false;
            bVar2.duration = (long) this.ZF;
            b.a(bVar2, 4).start();
        }
        invalidate();
    }

    private void b(PointF pointF, PointF pointF2, float f) {
        b bVar = new b(this, f, pointF, pointF2, (byte) 0);
        bVar.abo = false;
        bVar.duration = (long) this.ZG;
        b.a(bVar, 2).start();
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        System.currentTimeMillis();
        if (this.aar == null) {
            this.aar = new Paint();
            this.aar.setAntiAlias(true);
            this.aar.setFilterBitmap(true);
            this.aar.setDither(true);
        }
        if ((this.aas == null || this.aat == null) && this.Zq) {
            this.aas = new Paint();
            this.aas.setTextSize((float) px(20));
            this.aas.setColor(-65281);
            this.aas.setStyle(Style.FILL);
            this.aat = new Paint();
            this.aat.setColor(-65281);
            this.aat.setStyle(Style.STROKE);
            this.aat.setStrokeWidth((float) px(1));
        }
        if (this.YV != 0 && this.YW != 0 && getWidth() != 0 && getHeight() != 0) {
            if (this.Zp == null && this.YI != null) {
                b(new Point(Math.min(canvas.getMaximumBitmapWidth(), this.Zx), Math.min(canvas.getMaximumBitmapHeight(), this.Zy)));
            }
            if (hE()) {
                float a;
                PointF pointF;
                hG();
                if (!(this.aal == null || this.aal.abm == null)) {
                    if (this.ZK == null) {
                        this.ZK = new PointF(0.0f, 0.0f);
                    }
                    this.ZK.set(this.ZI);
                    long currentTimeMillis = System.currentTimeMillis() - this.aal.time;
                    boolean z = currentTimeMillis > this.aal.duration;
                    currentTimeMillis = Math.min(currentTimeMillis, this.aal.duration);
                    this.scale = a(this.aal.abp, currentTimeMillis, this.aal.ZH, this.aal.abi - this.aal.ZH, this.aal.duration);
                    float a2 = a(this.aal.abp, currentTimeMillis, this.aal.abm.x, this.aal.abn.x - this.aal.abm.x, this.aal.duration);
                    a = a(this.aal.abp, currentTimeMillis, this.aal.abm.y, this.aal.abn.y - this.aal.abm.y, this.aal.duration);
                    pointF = this.ZI;
                    pointF.x -= O(this.aal.abk.x) - a2;
                    pointF = this.ZI;
                    pointF.y -= P(this.aal.abk.y) - a;
                    boolean z2 = z || this.aal.ZH == this.aal.abi;
                    ab(z2);
                    d(this.ZK);
                    aa(z);
                    if (z) {
                        this.aal = null;
                    }
                    invalidate();
                }
                if (this.Zp != null && hD() && this.aaQ) {
                    Entry entry;
                    int min = Math.min(this.Zk, L(this.scale));
                    Object obj = null;
                    Iterator it = this.Zp.entrySet().iterator();
                    while (true) {
                        Object obj2 = obj;
                        if (!it.hasNext()) {
                            break;
                        }
                        entry = (Entry) it.next();
                        if (((Integer) entry.getKey()).intValue() == min) {
                            for (e eVar : (List) entry.getValue()) {
                                if (eVar.YN && (eVar.YM || eVar.bitmap == null)) {
                                    obj2 = 1;
                                }
                            }
                        }
                        obj = obj2;
                    }
                    for (Entry entry2 : this.Zp.entrySet()) {
                        if (((Integer) entry2.getKey()).intValue() == min || obj2 != null) {
                            for (e eVar2 : (List) entry2.getValue()) {
                                Rect rect = eVar2.YL;
                                eVar2.YO.set((int) O((float) rect.left), (int) P((float) rect.top), (int) O((float) rect.right), (int) P((float) rect.bottom));
                                if (!eVar2.YM && eVar2.bitmap != null) {
                                    if (this.aau != null) {
                                        canvas.drawRect(eVar2.YO, this.aau);
                                    }
                                    if (this.aaw == null) {
                                        this.aaw = new Matrix();
                                    }
                                    this.aaw.reset();
                                    a(this.aay, 0.0f, 0.0f, (float) eVar2.bitmap.getWidth(), 0.0f, (float) eVar2.bitmap.getWidth(), (float) eVar2.bitmap.getHeight(), 0.0f, (float) eVar2.bitmap.getHeight());
                                    if (getRequiredRotation() == 0) {
                                        a(this.aaz, (float) eVar2.YO.left, (float) eVar2.YO.top, (float) eVar2.YO.right, (float) eVar2.YO.top, (float) eVar2.YO.right, (float) eVar2.YO.bottom, (float) eVar2.YO.left, (float) eVar2.YO.bottom);
                                    } else if (getRequiredRotation() == 90) {
                                        a(this.aaz, (float) eVar2.YO.right, (float) eVar2.YO.top, (float) eVar2.YO.right, (float) eVar2.YO.bottom, (float) eVar2.YO.left, (float) eVar2.YO.bottom, (float) eVar2.YO.left, (float) eVar2.YO.top);
                                    } else if (getRequiredRotation() == 180) {
                                        a(this.aaz, (float) eVar2.YO.right, (float) eVar2.YO.bottom, (float) eVar2.YO.left, (float) eVar2.YO.bottom, (float) eVar2.YO.left, (float) eVar2.YO.top, (float) eVar2.YO.right, (float) eVar2.YO.top);
                                    } else if (getRequiredRotation() == 270) {
                                        a(this.aaz, (float) eVar2.YO.left, (float) eVar2.YO.bottom, (float) eVar2.YO.left, (float) eVar2.YO.top, (float) eVar2.YO.right, (float) eVar2.YO.top, (float) eVar2.YO.right, (float) eVar2.YO.bottom);
                                    }
                                    this.aaw.setPolyToPoly(this.aay, 0, this.aaz, 0, 4);
                                    canvas.drawBitmap(eVar2.bitmap, this.aaw, this.aar);
                                    if (this.Zq) {
                                        canvas.drawRect(eVar2.YO, this.aat);
                                    }
                                } else if (eVar2.YM && this.Zq) {
                                    canvas.drawText("LOADING", (float) (eVar2.YO.left + px(5)), (float) (eVar2.YO.top + px(35)), this.aas);
                                }
                                if (eVar2.YN && this.Zq) {
                                    canvas.drawText("ISS " + eVar2.sampleSize + " RECT " + eVar2.YL.top + "," + eVar2.YL.left + "," + eVar2.YL.bottom + "," + eVar2.YL.right, (float) (eVar2.YO.left + px(5)), (float) (eVar2.YO.top + px(15)), this.aas);
                                }
                            }
                        }
                    }
                } else if (this.bitmap != null) {
                    x.d(TAG, "alvinluo onDraw bitmap scale: %f, previewScale: %f", Float.valueOf(this.scale), Float.valueOf(this.aaL));
                    if (!this.Ze || this.Zg) {
                        if (this.aaw == null) {
                            this.aaw = new Matrix();
                        }
                        this.aaw.reset();
                        int width = this.bitmap.getWidth();
                        int height = this.bitmap.getHeight();
                        if (this.ZS == 90 || this.ZS == 270) {
                            width = this.bitmap.getHeight();
                            height = this.bitmap.getWidth();
                        }
                        if (this.Ze) {
                            this.aaw.postScale(this.aaM, this.aaN, ((float) width) / 2.0f, ((float) height) / 2.0f);
                        }
                        this.aaw.postTranslate((float) ((this.aaG - this.bitmap.getWidth()) / 2), (float) ((this.aaH - this.bitmap.getHeight()) / 2));
                        x.d(TAG, "alvinluo onDraw offsetX: %f, offsetY: %f", Float.valueOf(r0), Float.valueOf(a));
                        if (this.aau != null) {
                            if (this.aax == null) {
                                this.aax = new RectF();
                            }
                            this.aax.set(0.0f, 0.0f, this.Ze ? (float) this.bitmap.getWidth() : (float) this.YV, this.Ze ? (float) this.bitmap.getHeight() : (float) this.YW);
                            this.aaw.mapRect(this.aax);
                            canvas.drawRect(this.aax, this.aau);
                        }
                        canvas.drawBitmap(this.bitmap, this.aaw, this.aar);
                    }
                }
                if (this.Zq) {
                    x.d(TAG, "alvinluo onDraw debug vTranslate %f, %f", Float.valueOf(this.ZI.x), Float.valueOf(this.ZI.y));
                    canvas.drawText("Scale: " + String.format(Locale.ENGLISH, "%.2f", new Object[]{Float.valueOf(this.scale)}) + " (" + String.format(Locale.ENGLISH, "%.2f", new Object[]{Float.valueOf(hL())}) + " - " + String.format(Locale.ENGLISH, "%.2f", new Object[]{Float.valueOf(this.Zr)}) + ")", (float) px(5), (float) px(15), this.aas);
                    canvas.drawText("Translate: " + String.format(Locale.ENGLISH, "%.2f", new Object[]{Float.valueOf(this.ZI.x)}) + ":" + String.format(Locale.ENGLISH, "%.2f", new Object[]{Float.valueOf(this.ZI.y)}), (float) px(5), (float) px(30), this.aas);
                    PointF center = getCenter();
                    canvas.drawText("Source center: " + String.format(Locale.ENGLISH, "%.2f", new Object[]{Float.valueOf(center.x)}) + ":" + String.format(Locale.ENGLISH, "%.2f", new Object[]{Float.valueOf(center.y)}), (float) px(5), (float) px(45), this.aas);
                    if (this.aal != null) {
                        center = c(this.aal.abj);
                        PointF c = c(this.aal.abl);
                        pointF = c(this.aal.abk);
                        canvas.drawCircle(center.x, center.y, (float) px(10), this.aat);
                        this.aat.setColor(-65536);
                        canvas.drawCircle(c.x, c.y, (float) px(20), this.aat);
                        this.aat.setColor(-16776961);
                        canvas.drawCircle(pointF.x, pointF.y, (float) px(25), this.aat);
                        this.aat.setColor(-16711681);
                        canvas.drawCircle((float) (getWidth() / 2), (float) (getHeight() / 2), (float) px(30), this.aat);
                    }
                    if (this.aad != null) {
                        this.aat.setColor(-65536);
                        canvas.drawCircle(this.aad.x, this.aad.y, (float) px(20), this.aat);
                    }
                    if (this.aaj != null) {
                        this.aat.setColor(-16776961);
                        canvas.drawCircle(O(this.aaj.x), P(this.aaj.y), (float) px(35), this.aat);
                    }
                    if (this.aak != null && this.ZW) {
                        this.aat.setColor(-16711681);
                        canvas.drawCircle(this.aak.x, this.aak.y, (float) px(30), this.aat);
                    }
                    this.aat.setColor(-65281);
                }
            }
        }
    }

    private static void a(float[] fArr, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8) {
        fArr[0] = f;
        fArr[1] = f2;
        fArr[2] = f3;
        fArr[3] = f4;
        fArr[4] = f5;
        fArr[5] = f6;
        fArr[6] = f7;
        fArr[7] = f8;
    }

    private boolean hD() {
        boolean z = true;
        if (this.bitmap != null && !this.Ze) {
            return true;
        }
        if (this.Zp == null) {
            return false;
        }
        Iterator it = this.Zp.entrySet().iterator();
        while (true) {
            boolean z2 = z;
            if (!it.hasNext()) {
                return z2;
            }
            Entry entry = (Entry) it.next();
            if (((Integer) entry.getKey()).intValue() == this.Zk) {
                for (e eVar : (List) entry.getValue()) {
                    if (eVar.YM || eVar.bitmap == null) {
                        z2 = false;
                    }
                }
            }
            z = z2;
        }
    }

    private boolean hE() {
        boolean z = getWidth() > 0 && getHeight() > 0 && this.YV > 0 && this.YW > 0 && (this.bitmap != null || hD());
        if (!this.aam && z) {
            hG();
            this.aam = true;
        }
        return z;
    }

    private boolean hF() {
        boolean hD = hD();
        if (!this.aan && hD) {
            hG();
            this.aan = true;
            x.i(TAG, "alvinluo onImageLoaded");
            hC();
            a(this.aaK, new PointF(0.0f, 0.0f));
            if (this.Zm != -1) {
                this.Zn = System.currentTimeMillis();
                bW((int) (this.Zn - this.Zm));
            }
            com.tencent.mm.sdk.f.e.post(new 7(this), "rotateAndScaleFullImageBitmap");
        }
        return hD;
    }

    private synchronized void b(Point point) {
        i("initialiseBaseLayer maxTileDimensions=%dx%d", Integer.valueOf(point.x), Integer.valueOf(point.y));
        this.aav = new g(0.0f, new PointF(0.0f, 0.0f), (byte) 0);
        a(true, this.aav);
        this.Zk = L(this.aav.scale);
        c(point);
        for (e eVar : (List) this.Zp.get(Integer.valueOf(this.Zk))) {
            x.i(TAG, "alvinluo tile fullSampleSize: %d", Integer.valueOf(this.Zk));
            aaD.a(this, this.YI, eVar).hy();
        }
        aa(true);
    }

    private void aa(boolean z) {
        if (this.YI != null && this.Zp != null) {
            int min = Math.min(this.Zk, L(this.scale));
            for (Entry value : this.Zp.entrySet()) {
                for (e eVar : (List) value.getValue()) {
                    if (eVar.sampleSize < min || (eVar.sampleSize > min && eVar.sampleSize != this.Zk)) {
                        eVar.YN = false;
                        if (eVar.bitmap != null) {
                            eVar.bitmap.recycle();
                            eVar.bitmap = null;
                        }
                    }
                    if (eVar.sampleSize == min) {
                        boolean z2;
                        float M = M(0.0f);
                        float M2 = M((float) getWidth());
                        float N = N(0.0f);
                        float N2 = N((float) getHeight());
                        if (M > ((float) eVar.YL.right) || ((float) eVar.YL.left) > M2 || N > ((float) eVar.YL.bottom) || ((float) eVar.YL.top) > N2) {
                            z2 = false;
                        } else {
                            z2 = true;
                        }
                        if (z2) {
                            eVar.YN = true;
                            if (!eVar.YM && eVar.bitmap == null && z) {
                                aaD.a(this, this.YI, eVar).hy();
                            }
                        } else if (eVar.sampleSize != this.Zk) {
                            eVar.YN = false;
                            if (eVar.bitmap != null) {
                                eVar.bitmap.recycle();
                                eVar.bitmap = null;
                            }
                        }
                    } else if (eVar.sampleSize == this.Zk) {
                        eVar.YN = true;
                    }
                }
            }
        }
    }

    private void hG() {
        if (getWidth() != 0 && getHeight() != 0 && this.YV > 0 && this.YW > 0) {
            if (!(this.ZM == null || this.ZL == null)) {
                this.scale = this.ZL.floatValue();
                if (this.ZI == null) {
                    this.ZI = new PointF();
                }
                this.ZI.x = ((float) (getWidth() / 2)) - (this.scale * this.ZM.x);
                this.ZI.y = ((float) (getHeight() / 2)) - (this.scale * this.ZM.y);
                this.ZM = null;
                this.ZL = null;
                this.ZO = false;
                ab(true);
                aa(true);
            }
            ab(false);
        }
    }

    private int L(float f) {
        if (this.Zt > 0) {
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            f *= ((float) this.Zt) / ((displayMetrics.ydpi + displayMetrics.xdpi) / 2.0f);
        }
        int hJ = (int) (((float) hJ()) * f);
        int hK = (int) (((float) hK()) * f);
        if (hJ == 0 || hK == 0) {
            return 32;
        }
        if (hK() > hK || hJ() > hJ) {
            hK = Math.round(((float) hK()) / ((float) hK));
            hJ = Math.round(((float) hJ()) / ((float) hJ));
            if (hK >= hJ) {
                hK = hJ;
            }
        } else {
            hK = 1;
        }
        hJ = 1;
        while (hJ * 2 < hK) {
            hJ *= 2;
        }
        return hJ;
    }

    private void a(boolean z, g gVar) {
        float paddingLeft;
        float max;
        float f = 0.5f;
        if (this.Zu == 2 && this.aam) {
            z = false;
        }
        PointF pointF = gVar.ZI;
        float Q = Q(gVar.scale);
        float hJ = Q * ((float) hJ());
        float hK = Q * ((float) hK());
        if (this.Zu == 3 && this.aam) {
            pointF.x = Math.max(pointF.x, ((float) (getWidth() / 2)) - hJ);
            pointF.y = Math.max(pointF.y, ((float) (getHeight() / 2)) - hK);
        } else if (z) {
            pointF.x = Math.max(pointF.x, ((float) getWidth()) - hJ);
            pointF.y = Math.max(pointF.y, ((float) getHeight()) - hK);
        } else {
            pointF.x = Math.max(pointF.x, -hJ);
            pointF.y = Math.max(pointF.y, -hK);
        }
        if (getPaddingLeft() > 0 || getPaddingRight() > 0) {
            paddingLeft = ((float) getPaddingLeft()) / ((float) (getPaddingLeft() + getPaddingRight()));
        } else {
            paddingLeft = 0.5f;
        }
        if (getPaddingTop() > 0 || getPaddingBottom() > 0) {
            f = ((float) getPaddingTop()) / ((float) (getPaddingTop() + getPaddingBottom()));
        }
        if (this.Zu == 3 && this.aam) {
            paddingLeft = (float) Math.max(0, getWidth() / 2);
            max = (float) Math.max(0, getHeight() / 2);
        } else if (z) {
            paddingLeft = Math.max(0.0f, (((float) getWidth()) - hJ) * paddingLeft);
            max = Math.max(0.0f, (((float) getHeight()) - hK) * f);
        } else {
            paddingLeft = (float) Math.max(0, getWidth());
            max = (float) Math.max(0, getHeight());
        }
        pointF.x = Math.min(pointF.x, paddingLeft);
        pointF.y = Math.min(pointF.y, max);
        gVar.scale = Q;
    }

    private void ab(boolean z) {
        byte b;
        if (this.ZI == null) {
            b = (byte) 1;
            this.ZI = new PointF(0.0f, 0.0f);
        } else {
            b = (byte) 0;
        }
        if (this.aav == null) {
            this.aav = new g(0.0f, new PointF(0.0f, 0.0f), (byte) 0);
        }
        this.aav.scale = this.scale;
        this.aav.ZI.set(this.ZI);
        a(z, this.aav);
        this.scale = this.aav.scale;
        this.ZI.set(this.aav.ZI);
        if (b != (byte) 0 && this.Zv != 4) {
            this.ZI.set(f((float) (hJ() / 2), (float) (hK() / 2), this.scale));
        }
    }

    private void c(Point point) {
        i("initialiseTileMap maxTileDimensions=%dx%d", Integer.valueOf(point.x), Integer.valueOf(point.y));
        this.Zp = new LinkedHashMap();
        int i = this.Zk;
        int i2 = 1;
        int i3 = 1;
        while (true) {
            int i4;
            int hJ = hJ() / i2;
            int i5 = hJ / i;
            int hK = (hK() / i3) / i;
            while (true) {
                if ((i5 + i2) + 1 <= point.x) {
                    i5 = (((double) i5) > (((double) getWidth()) * 1.25d) ? 1 : (((double) i5) == (((double) getWidth()) * 1.25d) ? 0 : -1));
                    if (i5 <= 0) {
                        break;
                    }
                    i5 = this.Zk;
                    if (i >= i5) {
                        break;
                    }
                }
                i2++;
                hJ = hJ() / i2;
                i5 = hJ / i;
            }
            while (true) {
                i4 = hK;
                if ((i5 + i3) + 1 > point.y || (((double) i5) > ((double) getHeight()) * 1.25d && i < this.Zk)) {
                    i3++;
                    hK = hK() / i3;
                    i5 = hK / i;
                }
            }
            List arrayList = new ArrayList(i2 * i3);
            int i6 = 0;
            while (i6 < i2) {
                for (int i7 = 0; i7 < i3; i7++) {
                    e eVar = new e();
                    eVar.sampleSize = i;
                    eVar.YN = i == this.Zk;
                    int i8 = i6 * hJ;
                    int i9 = i7 * i4;
                    hK = i6 == i2 + -1 ? hJ() : (i6 + 1) * hJ;
                    if (i7 == i3 - 1) {
                        i5 = hK();
                    } else {
                        i5 = (i7 + 1) * i4;
                    }
                    eVar.YL = new Rect(i8, i9, hK, i5);
                    eVar.YO = new Rect(0, 0, 0, 0);
                    eVar.YP = new Rect(eVar.YL);
                    arrayList.add(eVar);
                }
                i6++;
            }
            this.Zp.put(Integer.valueOf(i), arrayList);
            if (i != 1) {
                i /= 2;
            } else {
                return;
            }
        }
    }

    public final synchronized void a(com.davemorrissey.labs.subscaleview.a.d dVar, int i, int i2, int i3) {
        i("alvinluo onTilesInited sWidth: %d, sHeight: %d, this.sWidth: %d, this.sHeight: %d, sOrientation: %d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(this.YV), Integer.valueOf(this.YW), Integer.valueOf(i3));
        if (this.YV > 0 && this.YW > 0 && !(this.YV == i && this.YW == i2)) {
            reset(false);
            if (this.bitmap != null) {
                if (!this.Zj) {
                    this.bitmap.recycle();
                }
                this.bitmap = null;
                if (this.aao != null && this.Zj) {
                    this.aao.hP();
                }
                this.Ze = false;
                this.Zj = false;
            }
        }
        this.YI = dVar;
        this.YV = i;
        this.YW = i2;
        this.ZR = i3;
        hE();
        if (!hF() && this.Zx > 0 && this.Zx != Zw && this.Zy > 0 && this.Zy != Zw && getWidth() > 0 && getHeight() > 0) {
            b(new Point(this.Zx, this.Zy));
        }
        invalidate();
        requestLayout();
        System.currentTimeMillis();
    }

    private void setFullImageBitmap(Bitmap bitmap) {
        com.tencent.mm.sdk.f.e.post(new 5(this, bitmap), "rotateAndScaleBitmap");
    }

    public final synchronized void a(e eVar) {
        boolean z = true;
        synchronized (this) {
            this.Zm = System.currentTimeMillis();
            String str = TAG;
            String str2 = "alvinluo onTileLoaded sampleSize: %d, bitmap == null: %b";
            Object[] objArr = new Object[2];
            objArr[0] = Integer.valueOf(eVar.sampleSize);
            if (eVar.bitmap != null) {
                z = false;
            }
            objArr[1] = Boolean.valueOf(z);
            x.d(str, str2, objArr);
            if (eVar.sampleSize == this.Zk && eVar.bitmap != null && this.Zl) {
                x.i(TAG, "alvinluo onTileLoaded set fullImageBitmap");
                this.Zl = false;
                this.Zo = eVar.bitmap;
            }
            hE();
            hF();
            if (hD() && this.bitmap != null) {
                if (!this.Zj) {
                    this.bitmap.recycle();
                }
                this.bitmap = null;
                if (this.aao != null && this.Zj) {
                    this.aao.hP();
                }
                this.Ze = false;
                this.Zj = false;
            }
            invalidate();
        }
    }

    public static Bitmap a(Bitmap bitmap, int i) {
        if (bitmap == null) {
            x.e(TAG, "alvinluo rotateAndScaleBitmap bitmap is null");
            return null;
        }
        Matrix matrix = new Matrix();
        matrix.postScale(1.0f, 1.0f);
        if (i != 0) {
            matrix.postRotate((float) i);
        }
        x.d(TAG, "alvinluo rotateAndScaleBitmap matrix.isIdentify: %b", Boolean.valueOf(matrix.isIdentity()));
        if (bitmap.getWidth() <= 0 || bitmap.getHeight() <= 0) {
            return null;
        }
        if (!matrix.isIdentity()) {
            return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        } else if (bitmap.getConfig() != null) {
            return bitmap.copy(bitmap.getConfig(), false);
        } else {
            return null;
        }
    }

    public final synchronized void a(Bitmap bitmap, Integer num) {
        x.i(TAG, "alvinluo onPreviewLoaded");
        long currentTimeMillis = System.currentTimeMillis();
        if (!this.aan) {
            if (this.ZT == null) {
                if (num != null) {
                    this.ZS = num.intValue();
                }
                this.bitmap = bitmap;
            } else if (this.ZT.width() > 0 && this.ZT.height() > 0) {
                this.bitmap = Bitmap.createBitmap(bitmap, this.ZT.left, this.ZT.top, this.ZT.width(), this.ZT.height());
                this.ZS = 0;
            }
            this.Ze = true;
            this.Zg = false;
            this.Zh = this.bitmap.getWidth();
            this.Zi = this.bitmap.getHeight();
            if (this.bitmap != null && this.Ze) {
                float hH = ((float) this.aaG) / ((float) hH());
                float hI = ((float) this.aaH) / ((float) hI());
                float hI2 = ((float) hI()) / ((float) hH());
                float f = 1.8f;
                if (!(this.aaG == 0 || this.aaH == 0)) {
                    f = ((float) this.aaH) / ((float) this.aaG);
                }
                if (hI2 <= f || ((double) hI2) > 2.2d) {
                    this.aaL = hH;
                } else {
                    this.aaL = hI;
                }
                hC();
                this.aaM = (this.aaK * ((float) hJ())) / ((float) hH());
                this.aaN = (this.aaK * ((float) hK())) / ((float) hI());
                x.i(TAG, "alvinluo initPreviewScaleRate previewWidthScale: %f, previewHeightScale: %f", Float.valueOf(this.aaM), Float.valueOf(this.aaN));
            }
            this.Zg = true;
            if (hE()) {
                invalidate();
                requestLayout();
            }
            bV((int) (System.currentTimeMillis() - currentTimeMillis));
            x.i(TAG, "alvinluo onPreviewLoaded");
            if (!(this.Zf || this.aao == null)) {
                this.aao.hO();
            }
        } else if (this.bitmap != null) {
            this.bitmap.recycle();
        }
    }

    public int getPreviewOrientation() {
        return this.ZS;
    }

    public int getPreviewWidth() {
        return this.Zh;
    }

    public int getPreviewHeight() {
        return this.Zi;
    }

    public final synchronized void b(Bitmap bitmap, int i, boolean z) {
        i("onImageLoaded has bitmap", new Object[0]);
        if (this.YV > 0 && this.YW > 0 && !(this.YV == bitmap.getWidth() && this.YW == bitmap.getHeight())) {
            reset(false);
        }
        if (!(this.bitmap == null || this.Zj)) {
            this.bitmap.recycle();
        }
        if (!(this.bitmap == null || !this.Zj || this.aao == null)) {
            this.aao.hP();
        }
        this.Ze = false;
        this.Zj = z;
        this.bitmap = bitmap;
        this.YV = bitmap.getWidth();
        this.YW = bitmap.getHeight();
        this.ZR = i;
        com.tencent.mm.sdk.f.e.post(new 6(this, i, bitmap, hE(), hF()), "rotateAndScaleBitmap");
    }

    public static int h(Context context, String str) {
        Cursor cursor;
        Throwable th;
        Cursor cursor2 = null;
        int i;
        if (str.startsWith("content")) {
            try {
                Cursor query = context.getContentResolver().query(Uri.parse(str), new String[]{"orientation"}, null, null, null);
                if (query != null) {
                    try {
                        if (query.moveToFirst()) {
                            i = query.getInt(0);
                            if (!YZ.contains(Integer.valueOf(i)) || i == -1) {
                                x.w(TAG, "Unsupported orientation: " + i);
                            }
                            if (query != null) {
                                query.close();
                                return i;
                            }
                            return i;
                        }
                    } catch (Exception e) {
                        cursor = query;
                        try {
                            x.w(TAG, "Could not get orientation of image from media store");
                            if (cursor != null) {
                                cursor.close();
                                return 0;
                            }
                            i = 0;
                            return i;
                        } catch (Throwable th2) {
                            th = th2;
                            cursor2 = cursor;
                            if (cursor2 != null) {
                                cursor2.close();
                            }
                            throw th;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        cursor2 = query;
                        if (cursor2 != null) {
                            cursor2.close();
                        }
                        throw th;
                    }
                }
                i = 0;
                if (query != null) {
                    query.close();
                    return i;
                }
            } catch (Exception e2) {
                cursor = null;
            } catch (Throwable th32) {
                th = th32;
                if (cursor2 != null) {
                    cursor2.close();
                }
                throw th;
            }
            return i;
        } else if (!str.startsWith("file:///") || str.startsWith("file:///android_asset/")) {
            return 0;
        } else {
            try {
                i = new android.support.b.a(str.substring(7)).C("Orientation");
                if (i == 1 || i == 0) {
                    return 0;
                }
                if (i == 6) {
                    return 90;
                }
                if (i == 3) {
                    return 180;
                }
                if (i == 8) {
                    return 270;
                }
                x.w(TAG, "Unsupported EXIF orientation: " + i);
                return 0;
            } catch (Exception e3) {
                x.w(TAG, "Could not get EXIF orientation of image");
                return 0;
            }
        }
    }

    public void setMaxTileSize(int i) {
        this.Zx = i;
        this.Zy = i;
    }

    private int hH() {
        if (this.bitmap == null || !this.Ze) {
            return 0;
        }
        int i = this.ZS;
        if (i == 90 || i == 270) {
            return this.bitmap.getHeight();
        }
        return this.bitmap.getWidth();
    }

    private int hI() {
        if (this.bitmap == null || !this.Ze) {
            return 0;
        }
        int i = this.ZS;
        if (i == 90 || i == 270) {
            return this.bitmap.getWidth();
        }
        return this.bitmap.getHeight();
    }

    private int hJ() {
        int requiredRotation = getRequiredRotation();
        if (requiredRotation == 90 || requiredRotation == 270) {
            return this.YW;
        }
        return this.YV;
    }

    private int hK() {
        int requiredRotation = getRequiredRotation();
        if (requiredRotation == 90 || requiredRotation == 270) {
            return this.YV;
        }
        return this.YW;
    }

    public int getRequiredRotation() {
        if (this.orientation == -1) {
            return this.ZR;
        }
        return this.orientation;
    }

    private static float c(float f, float f2, float f3, float f4) {
        float f5 = f - f2;
        float f6 = f3 - f4;
        return (float) Math.sqrt((double) ((f5 * f5) + (f6 * f6)));
    }

    private float M(float f) {
        if (this.ZI == null) {
            return Float.NaN;
        }
        return (f - this.ZI.x) / this.scale;
    }

    private float N(float f) {
        if (this.ZI == null) {
            return Float.NaN;
        }
        return (f - this.ZI.y) / this.scale;
    }

    public final PointF b(PointF pointF) {
        return a(pointF.x, pointF.y, new PointF());
    }

    private PointF a(float f, float f2, PointF pointF) {
        if (this.ZI == null) {
            return null;
        }
        pointF.set(M(f), N(f2));
        return pointF;
    }

    private float O(float f) {
        if (this.ZI == null) {
            return Float.NaN;
        }
        return (this.scale * f) + this.ZI.x;
    }

    private float P(float f) {
        if (this.ZI == null) {
            return Float.NaN;
        }
        return (this.scale * f) + this.ZI.y;
    }

    public final PointF c(PointF pointF) {
        float f = pointF.x;
        float f2 = pointF.y;
        PointF pointF2 = new PointF();
        if (this.ZI == null) {
            return null;
        }
        pointF2.set(O(f), P(f2));
        return pointF2;
    }

    private PointF f(float f, float f2, float f3) {
        int paddingLeft = getPaddingLeft() + (((getWidth() - getPaddingRight()) - getPaddingLeft()) / 2);
        int paddingTop = getPaddingTop() + (((getHeight() - getPaddingBottom()) - getPaddingTop()) / 2);
        if (this.aav == null) {
            this.aav = new g(0.0f, new PointF(0.0f, 0.0f), (byte) 0);
        }
        this.aav.scale = f3;
        this.aav.ZI.set(((float) paddingLeft) - (f * f3), ((float) paddingTop) - (f2 * f3));
        a(true, this.aav);
        return this.aav.ZI;
    }

    private float hL() {
        int paddingBottom = getPaddingBottom() + getPaddingTop();
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        if (this.Zv == 2 || this.Zv == 4) {
            return Math.max(((float) (getWidth() - paddingLeft)) / ((float) hJ()), ((float) (getHeight() - paddingBottom)) / ((float) hK()));
        }
        if (this.Zv != 3 || this.Zs <= 0.0f) {
            return Math.min(((float) (getWidth() - paddingLeft)) / ((float) hJ()), ((float) (getHeight() - paddingBottom)) / ((float) hK()));
        }
        return this.Zs;
    }

    private float Q(float f) {
        return Math.max(hL(), f);
    }

    private static float a(int i, long j, float f, float f2, long j2) {
        float f3;
        switch (i) {
            case 1:
                f3 = ((float) j) / ((float) j2);
                return ((f3 - 2.0f) * ((-f2) * f3)) + f;
            case 2:
                f3 = ((float) j) / (((float) j2) / 2.0f);
                if (f3 < 1.0f) {
                    return (f3 * ((f2 / 2.0f) * f3)) + f;
                }
                f3 -= 1.0f;
                return (((f3 * (f3 - 2.0f)) - 1.0f) * ((-f2) / 2.0f)) + f;
            default:
                throw new IllegalStateException("Unexpected easing type: " + i);
        }
    }

    public static void i(String str, Object... objArr) {
        x.d(TAG, String.format(str, objArr));
    }

    private int px(int i) {
        return (int) (this.density * ((float) i));
    }

    public final void setRegionDecoderClass(Class<? extends com.davemorrissey.labs.subscaleview.a.d> cls) {
        if (cls == null) {
            throw new IllegalArgumentException("Decoder class cannot be set to null");
        }
        this.aac = new com.davemorrissey.labs.subscaleview.a.a(cls);
    }

    public final void setRegionDecoderFactory(com.davemorrissey.labs.subscaleview.a.b<? extends com.davemorrissey.labs.subscaleview.a.d> bVar) {
        if (bVar == null) {
            throw new IllegalArgumentException("Decoder factory cannot be set to null");
        }
        this.aac = bVar;
    }

    public final void setBitmapDecoderClass(Class<? extends com.davemorrissey.labs.subscaleview.a.d> cls) {
        if (cls == null) {
            throw new IllegalArgumentException("Decoder class cannot be set to null");
        }
        this.aab = new com.davemorrissey.labs.subscaleview.a.a(cls);
    }

    public final void setBitmapDecoderFactory(com.davemorrissey.labs.subscaleview.a.b<? extends com.davemorrissey.labs.subscaleview.a.d> bVar) {
        if (bVar == null) {
            throw new IllegalArgumentException("Decoder factory cannot be set to null");
        }
        this.aab = bVar;
    }

    public final void setPanLimit(int i) {
        if (Zc.contains(Integer.valueOf(i))) {
            this.Zu = i;
            if (this.aam) {
                ab(true);
                invalidate();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Invalid pan limit: " + i);
    }

    public final void setMinimumScaleType(int i) {
        if (Zd.contains(Integer.valueOf(i))) {
            this.Zv = i;
            if (this.aam) {
                ab(true);
                invalidate();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Invalid scale type: " + i);
    }

    public final void setMaxScale(float f) {
        this.Zr = f;
    }

    public final void setMinScale(float f) {
        this.Zs = f;
    }

    public final void setMinimumDpi(int i) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        setMaxScale(((displayMetrics.ydpi + displayMetrics.xdpi) / 2.0f) / ((float) i));
    }

    public final void setMaximumDpi(int i) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        setMinScale(((displayMetrics.ydpi + displayMetrics.xdpi) / 2.0f) / ((float) i));
    }

    public float getMaxScale() {
        return this.Zr;
    }

    public final float getMinScale() {
        return hL();
    }

    public void setMinimumTileDpi(int i) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.Zt = (int) Math.min((displayMetrics.ydpi + displayMetrics.xdpi) / 2.0f, (float) i);
        if (this.aam) {
            reset(false);
            invalidate();
        }
    }

    public final PointF getCenter() {
        return a((float) (getWidth() / 2), (float) (getHeight() / 2), new PointF());
    }

    public final float getScale() {
        return this.scale;
    }

    public final void a(float f, PointF pointF) {
        this.aal = null;
        this.ZO = true;
        this.ZL = Float.valueOf(f);
        this.ZM = pointF;
        this.ZN = pointF;
        invalidate();
    }

    public final int getSWidth() {
        return this.YV;
    }

    public final int getSHeight() {
        return this.YW;
    }

    public final int getOrientation() {
        return this.orientation;
    }

    public final int getAppliedOrientation() {
        return getRequiredRotation();
    }

    public final b getState() {
        if (this.ZI == null || this.YV <= 0 || this.YW <= 0) {
            return null;
        }
        return new b(getScale(), getCenter(), getOrientation());
    }

    public final void setZoomEnabled(boolean z) {
        this.ZB = z;
    }

    public final void setQuickScaleEnabled(boolean z) {
        this.ZC = z;
    }

    public final void setPanEnabled(boolean z) {
        this.ZA = z;
        if (!z && this.ZI != null) {
            this.ZI.x = ((float) (getWidth() / 2)) - (this.scale * ((float) (hJ() / 2)));
            this.ZI.y = ((float) (getHeight() / 2)) - (this.scale * ((float) (hK() / 2)));
            if (this.aam) {
                aa(true);
                invalidate();
            }
        }
    }

    public final void setTileBackgroundColor(int i) {
        if (Color.alpha(i) == 0) {
            this.aau = null;
        } else {
            this.aau = new Paint();
            this.aau.setStyle(Style.FILL);
            this.aau.setColor(i);
        }
        invalidate();
    }

    public final void setDoubleTapZoomScale(float f) {
        this.ZD = f;
    }

    public final void setDoubleTapZoomDpi(int i) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        setDoubleTapZoomScale(((displayMetrics.ydpi + displayMetrics.xdpi) / 2.0f) / ((float) i));
    }

    public final void setDoubleTapZoomStyle(int i) {
        if (Za.contains(Integer.valueOf(i))) {
            this.ZE = i;
            return;
        }
        throw new IllegalArgumentException("Invalid zoom style: " + i);
    }

    public final void setDoubleTapZoomDuration(int i) {
        this.ZF = Math.max(0, i);
    }

    public void setExecutor(Executor executor) {
        if (executor == null) {
            throw new NullPointerException("Executor must not be null");
        }
        this.aaF = executor;
    }

    public void setEagerLoadingEnabled(boolean z) {
        this.Zz = z;
    }

    public final void setDebug(boolean z) {
        this.Zq = z;
    }

    public void setOnLongClickListener(OnLongClickListener onLongClickListener) {
        this.aaq = onLongClickListener;
    }

    public void setOnImageEventListener(e eVar) {
        this.aao = eVar;
    }

    public void setOnStateChangedListener(f fVar) {
        this.aap = fVar;
    }

    private void d(PointF pointF) {
        if (this.aap != null && !this.ZI.equals(pointF)) {
            getCenter();
        }
    }
}

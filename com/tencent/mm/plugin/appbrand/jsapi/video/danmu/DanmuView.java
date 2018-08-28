package com.tencent.mm.plugin.appbrand.jsapi.video.danmu;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Looper;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class DanmuView extends View {
    private int gbV;
    private int gbW;
    private int gbX;
    public float gbY;
    public float gbZ;
    private boolean gca;
    private boolean gcb;
    private c gcc;
    private HashMap<Integer, ArrayList<d>> gcd;
    public final Deque<d> gce;
    public List<d> gcf;
    private int[] gcg;
    private volatile boolean gch;
    private LinkedList<Long> gci;
    private Paint gcj;
    private long gck;
    private LinkedList<Float> gcl;
    private final Context mContext;
    public volatile int status;

    public DanmuView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DanmuView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gbV = 5;
        this.gbW = 500;
        this.gbX = 10;
        this.gbY = 0.0f;
        this.gbZ = 0.6f;
        this.gca = false;
        this.gcb = false;
        this.gce = new LinkedList();
        this.gcf = new LinkedList();
        this.status = 3;
        this.gck = 0;
        this.mContext = context;
    }

    public final void prepare() {
        float f = this.gbY;
        float f2 = this.gbZ;
        if (f >= f2) {
            throw new IllegalArgumentException("start_Y_offset must < end_Y_offset");
        } else if (f < 0.0f || f >= 1.0f || f2 < 0.0f || f2 > 1.0f) {
            throw new IllegalArgumentException("start_Y_offset and end_Y_offset must between 0 and 1)");
        } else {
            setBackgroundColor(0);
            setDrawingCacheBackgroundColor(0);
            akg();
        }
    }

    private void akg() {
        this.gcd = new HashMap(this.gbV);
        for (int i = 0; i < this.gbV; i++) {
            this.gcd.put(Integer.valueOf(i), new ArrayList(this.gbX));
        }
        akh();
    }

    private void akh() {
        int i = 0;
        this.gcg = new int[this.gbV];
        float cB = b.cB(this.mContext);
        float height = this.gbY * ((float) getHeight());
        for (int i2 = 0; i2 < this.gbV; i2++) {
            this.gcg[i2] = (int) (((((float) (i2 + 1)) * cB) + height) - ((3.0f * cB) / 4.0f));
        }
        if (this.gcb) {
            this.gcl.clear();
            this.gcl.add(Float.valueOf(height));
            while (i < this.gbV) {
                this.gcl.add(Float.valueOf((((float) (i + 1)) * cB) + height));
                i++;
            }
        }
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int i;
        Iterator it;
        Iterator it2;
        float floatValue;
        if (this.gch) {
            x.i("MicroMsg.DanmuView", "inTransition");
        } else if (this.status == 1) {
            try {
                d dVar;
                canvas.drawColor(0);
                for (i = 0; i < this.gcd.size(); i++) {
                    it = ((ArrayList) this.gcd.get(Integer.valueOf(i))).iterator();
                    while (it.hasNext()) {
                        dVar = (d) it.next();
                        if (dVar.akd()) {
                            it.remove();
                        } else {
                            dVar.b(canvas, false);
                        }
                    }
                }
                if (System.currentTimeMillis() - this.gck > ((long) this.gbW)) {
                    this.gck = System.currentTimeMillis();
                    synchronized (this.gce) {
                        if (this.gce.size() > 0) {
                            dVar = (d) this.gce.getFirst();
                            int NK = this.gcc.NK();
                            d dVar2 = dVar;
                            while (dVar2 != null && dVar2.kY(NK)) {
                                this.gce.pollFirst();
                                dVar2 = (d) this.gce.getFirst();
                            }
                            if (dVar2 != null && dVar2.kX(NK)) {
                                int b = b(dVar2);
                                if (b >= 0) {
                                    dVar2.bN(canvas.getWidth() - 2, this.gcg[b]);
                                    dVar2.b(canvas, false);
                                    ((ArrayList) this.gcd.get(Integer.valueOf(b))).add(dVar2);
                                    this.gce.pollFirst();
                                }
                            }
                        }
                    }
                }
                if (this.gca && this.gci != null) {
                    canvas.drawText("FPS:" + ((int) akl()), 5.0f, 20.0f, this.gcj);
                }
                if (this.gcb && this.gcl != null) {
                    it2 = this.gcl.iterator();
                    while (it2.hasNext()) {
                        floatValue = ((Float) it2.next()).floatValue();
                        canvas.drawLine(0.0f, floatValue, (float) getWidth(), floatValue, this.gcj);
                    }
                }
            } catch (Exception e) {
                x.w("MicroMsg.DanmuView", "STATUS_RUNNING onDraw e=%s", new Object[]{e});
            }
            invalidate();
        } else if (this.status == 2) {
            try {
                canvas.drawColor(0);
                for (i = 0; i < this.gcd.size(); i++) {
                    it = ((ArrayList) this.gcd.get(Integer.valueOf(i))).iterator();
                    while (it.hasNext()) {
                        ((d) it.next()).b(canvas, true);
                    }
                }
                if (this.gca && this.gci != null) {
                    canvas.drawText("FPS:" + ((int) akl()), 5.0f, 20.0f, this.gcj);
                }
                if (this.gcb && this.gcl != null) {
                    it2 = this.gcl.iterator();
                    while (it2.hasNext()) {
                        floatValue = ((Float) it2.next()).floatValue();
                        canvas.drawLine(0.0f, floatValue, (float) getWidth(), floatValue, this.gcj);
                    }
                }
            } catch (Exception e2) {
                x.w("MicroMsg.DanmuView", "STATUS_PAUSE onDraw e=%s", new Object[]{e2});
            }
            invalidate();
        }
    }

    private int b(d dVar) {
        int i = 0;
        while (true) {
            try {
                int i2 = i;
                if (i2 >= this.gbV) {
                    break;
                }
                int i3 = (i2 + 0) % this.gbV;
                ArrayList arrayList = (ArrayList) this.gcd.get(Integer.valueOf(i3));
                if (arrayList.size() == 0) {
                    return i3;
                }
                if (arrayList.size() <= this.gbX && !dVar.a((d) arrayList.get(arrayList.size() - 1))) {
                    return i3;
                }
                i = i2 + 1;
            } catch (Exception e) {
                x.w("MicroMsg.DanmuView", "findVacant,Exception:" + e.getMessage());
            }
        }
        return -1;
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        akh();
    }

    public final void aki() {
        if (isMainThread()) {
            this.gch = true;
        } else {
            post(new 1(this));
        }
    }

    /* renamed from: akj */
    public final void c() {
        if (isMainThread()) {
            this.gch = false;
            invalidate();
            return;
        }
        post(new 2(this));
    }

    public final void show() {
        this.status = 1;
        invalidate();
    }

    public final void pause() {
        this.status = 2;
        invalidate();
    }

    public final void hide() {
        this.status = 4;
        invalidate();
    }

    public final void akk() {
        if (!(this.gcd == null || this.gcd.isEmpty())) {
            this.gcd.clear();
        }
        synchronized (this.gce) {
            if (!this.gce.isEmpty()) {
                this.gce.clear();
            }
        }
    }

    public void setMaxRow(int i) {
        this.gbV = i;
        if (this.gcd != null) {
            synchronized (this.gcd) {
                int i2 = 0;
                while (true) {
                    int i3 = i2;
                    if (i3 >= this.gcd.size()) {
                        break;
                    }
                    ArrayList arrayList = (ArrayList) this.gcd.get(Integer.valueOf(i3));
                    if (arrayList != null) {
                        arrayList.clear();
                    }
                    i2 = i3 + 1;
                }
                while (true) {
                }
            }
        }
        akg();
    }

    public void setPickItemInterval(int i) {
        this.gbW = i;
    }

    public void setMaxRunningPerRow(int i) {
        this.gbX = i;
    }

    public float getYOffset() {
        return this.gbZ - this.gbY;
    }

    public void setShowFps(boolean z) {
        this.gca = z;
        if (!z) {
            return;
        }
        if (this.gcj == null || this.gci == null) {
            this.gcj = new TextPaint(1);
            this.gcj.setColor(-256);
            this.gcj.setTextSize(20.0f);
            this.gci = new LinkedList();
        }
    }

    public void setShowLines(boolean z) {
        this.gcb = z;
        if (z && this.gcl == null) {
            this.gcl = new LinkedList();
        }
    }

    public void setDanmuViewCallBack(c cVar) {
        this.gcc = cVar;
    }

    private double akl() {
        long nanoTime = System.nanoTime();
        this.gci.addLast(Long.valueOf(nanoTime));
        double longValue = ((double) (nanoTime - ((Long) this.gci.getFirst()).longValue())) / 1.0E9d;
        if (this.gci.size() > 100) {
            this.gci.removeFirst();
        }
        return longValue > 0.0d ? ((double) this.gci.size()) / longValue : 0.0d;
    }

    private static boolean isMainThread() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }
}

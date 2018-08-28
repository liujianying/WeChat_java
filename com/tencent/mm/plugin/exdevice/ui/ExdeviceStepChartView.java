package com.tencent.mm.plugin.exdevice.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PathEffect;
import android.graphics.Point;
import android.graphics.Shader.TileMode;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.mm.R;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.b;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.smtt.sdk.TbsReaderView$ReaderCallback;
import java.util.LinkedList;
import java.util.List;

public class ExdeviceStepChartView extends View {
    Paint fBa;
    private final float iGA;
    private final int iGB;
    private final float iGC;
    private final int iGD;
    private final float iGE;
    private final int iGF;
    private final float iGG;
    private final int iGH;
    private final float iGI;
    private final int iGJ;
    private final float iGK;
    private final int iGL;
    private final float iGM;
    private final int iGN;
    private final float iGO;
    private final float iGP;
    private final float iGQ;
    private final float iGR;
    private final int iGS;
    private final int iGT;
    private final int iGU;
    private final int iGV;
    private final float iGW;
    private final int iGX;
    private final float iGY;
    private final int iGZ;
    private final int iGa;
    private final int iGb;
    private final int iGc;
    private final float iGd;
    private final float iGe;
    private final float iGf;
    private final float iGg;
    private final float iGh;
    private final int iGi;
    private final int iGj;
    private final int iGk;
    private final int iGl;
    private int iGm;
    private int iGn;
    private int iGo;
    private final float iGp;
    private final float iGq;
    private final int iGr;
    private final float iGs;
    private final int iGt;
    private final float iGu;
    private final int iGv;
    private final float iGw;
    private final int iGx;
    private final float iGy;
    private final int iGz;
    List<String> iHA;
    private boolean iHB;
    PathEffect iHC;
    private int iHD;
    private boolean iHE;
    private final float iHa;
    private final int iHb;
    private final float iHc;
    private final int iHd;
    private final float iHe;
    private final int iHf;
    private final int iHg;
    private final int iHh;
    private final int iHi;
    private final int iHj;
    private final int iHk;
    private final int iHl;
    private final int iHm;
    private final int iHn;
    private int iHo;
    private final Typeface iHp;
    private final Typeface iHq;
    private int iHr;
    private int iHs;
    private int[] iHt;
    private final int iHu;
    private float[] iHv;
    private float[] iHw;
    private boolean[] iHx;
    Path iHy;
    Path iHz;
    List<Point> points;
    private int startY;

    public ExdeviceStepChartView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.iGa = -1;
        this.iGb = -1;
        this.iGc = getResources().getColor(R.e.exdevice_step_chart_background_line_color);
        this.iGd = 12.0f;
        this.iGe = 28.0f;
        this.iGf = 33.0f;
        this.iGg = 12.0f;
        this.iGh = 12.0f;
        this.iGi = getResources().getColor(R.e.exdevice_step_chart_date_text_color);
        this.iGj = -1;
        this.iGk = getResources().getColor(R.e.exdevice_step_chart_date_text_color);
        this.iGl = -1;
        this.iGm = Integer.MAX_VALUE;
        this.iGn = 0;
        this.iGo = 0;
        this.iGp = 10.0f;
        this.iGq = 2.5f;
        this.iGr = (int) i(1, 2.5f);
        this.iGs = 4.0f;
        this.iGt = (int) i(1, 4.0f);
        this.iGu = 1.8f;
        this.iGv = (int) i(1, 1.8f);
        this.iGw = 1.0f;
        this.iGx = (int) i(1, 1.0f);
        this.iGy = 8.0f;
        this.iGz = (int) i(1, 8.0f);
        this.iGA = 22.0f;
        this.iGB = (int) i(1, 22.0f);
        this.iGC = 67.0f;
        this.iGD = (int) i(1, 67.0f);
        this.iGE = 40.0f;
        this.iGF = (int) i(1, 40.0f);
        this.iGG = 22.0f;
        this.iGH = (int) i(1, 22.0f);
        this.iGI = 55.0f;
        this.iGJ = (int) i(1, 55.0f);
        this.iGK = 35.0f;
        this.iGL = (int) i(1, 35.0f);
        this.iGM = 45.0f;
        this.iGN = (int) i(1, 45.0f);
        this.iGO = 8.0f;
        this.iGP = (float) ((int) i(1, 8.0f));
        this.iGQ = 8.0f;
        this.iGR = (float) ((int) i(1, 8.0f));
        this.iGS = 2;
        this.iGT = (int) i(1, 2.0f);
        this.iGU = 15;
        this.iGV = (int) i(1, 15.0f);
        this.iGW = 33.0f;
        this.iGX = (int) i(1, 33.0f);
        this.iGY = 8.0f;
        this.iGZ = (int) i(1, 8.0f);
        this.iHa = 35.0f;
        this.iHb = (int) i(1, 35.0f);
        this.iHc = 10.0f;
        this.iHd = (int) i(1, 10.0f);
        this.iHe = 58.0f;
        this.iHf = (int) i(1, 58.0f);
        this.iHg = (int) i(1, 1.0f);
        this.iHh = 102;
        this.iHi = 102;
        this.iHj = 153;
        this.iHk = 102;
        this.iHl = 102;
        this.iHm = 102;
        this.iHn = 204;
        this.iHo = 0;
        this.iHp = Typeface.create(Typeface.DEFAULT_BOLD, 0);
        this.iHq = Typeface.create(Typeface.DEFAULT_BOLD, 1);
        this.iHr = 0;
        this.iHs = 0;
        this.iHt = new int[]{0, 0, 0, 0, 0, 0, 0};
        this.iHu = 7;
        this.iHv = new float[7];
        this.iHw = new float[7];
        this.iHx = new boolean[7];
        this.iHB = false;
        this.iHC = new DashPathEffect(new float[]{5.0f, 5.0f}, 0.0f);
        aIn();
    }

    public ExdeviceStepChartView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iGa = -1;
        this.iGb = -1;
        this.iGc = getResources().getColor(R.e.exdevice_step_chart_background_line_color);
        this.iGd = 12.0f;
        this.iGe = 28.0f;
        this.iGf = 33.0f;
        this.iGg = 12.0f;
        this.iGh = 12.0f;
        this.iGi = getResources().getColor(R.e.exdevice_step_chart_date_text_color);
        this.iGj = -1;
        this.iGk = getResources().getColor(R.e.exdevice_step_chart_date_text_color);
        this.iGl = -1;
        this.iGm = Integer.MAX_VALUE;
        this.iGn = 0;
        this.iGo = 0;
        this.iGp = 10.0f;
        this.iGq = 2.5f;
        this.iGr = (int) i(1, 2.5f);
        this.iGs = 4.0f;
        this.iGt = (int) i(1, 4.0f);
        this.iGu = 1.8f;
        this.iGv = (int) i(1, 1.8f);
        this.iGw = 1.0f;
        this.iGx = (int) i(1, 1.0f);
        this.iGy = 8.0f;
        this.iGz = (int) i(1, 8.0f);
        this.iGA = 22.0f;
        this.iGB = (int) i(1, 22.0f);
        this.iGC = 67.0f;
        this.iGD = (int) i(1, 67.0f);
        this.iGE = 40.0f;
        this.iGF = (int) i(1, 40.0f);
        this.iGG = 22.0f;
        this.iGH = (int) i(1, 22.0f);
        this.iGI = 55.0f;
        this.iGJ = (int) i(1, 55.0f);
        this.iGK = 35.0f;
        this.iGL = (int) i(1, 35.0f);
        this.iGM = 45.0f;
        this.iGN = (int) i(1, 45.0f);
        this.iGO = 8.0f;
        this.iGP = (float) ((int) i(1, 8.0f));
        this.iGQ = 8.0f;
        this.iGR = (float) ((int) i(1, 8.0f));
        this.iGS = 2;
        this.iGT = (int) i(1, 2.0f);
        this.iGU = 15;
        this.iGV = (int) i(1, 15.0f);
        this.iGW = 33.0f;
        this.iGX = (int) i(1, 33.0f);
        this.iGY = 8.0f;
        this.iGZ = (int) i(1, 8.0f);
        this.iHa = 35.0f;
        this.iHb = (int) i(1, 35.0f);
        this.iHc = 10.0f;
        this.iHd = (int) i(1, 10.0f);
        this.iHe = 58.0f;
        this.iHf = (int) i(1, 58.0f);
        this.iHg = (int) i(1, 1.0f);
        this.iHh = 102;
        this.iHi = 102;
        this.iHj = 153;
        this.iHk = 102;
        this.iHl = 102;
        this.iHm = 102;
        this.iHn = 204;
        this.iHo = 0;
        this.iHp = Typeface.create(Typeface.DEFAULT_BOLD, 0);
        this.iHq = Typeface.create(Typeface.DEFAULT_BOLD, 1);
        this.iHr = 0;
        this.iHs = 0;
        this.iHt = new int[]{0, 0, 0, 0, 0, 0, 0};
        this.iHu = 7;
        this.iHv = new float[7];
        this.iHw = new float[7];
        this.iHx = new boolean[7];
        this.iHB = false;
        this.iHC = new DashPathEffect(new float[]{5.0f, 5.0f}, 0.0f);
        aIn();
    }

    private void c(Canvas canvas, boolean z) {
        int i = 0;
        if (z) {
            this.iHz.reset();
            this.iHz.moveTo((float) ((Point) this.points.get(0)).x, (float) ((Point) this.points.get(0)).y);
            for (int i2 = 0; i2 < this.points.size(); i2++) {
                this.iHz.lineTo((float) ((Point) this.points.get(i2)).x, (float) ((Point) this.points.get(i2)).y);
            }
            this.iHz.lineTo(this.iHv[this.iHv.length - 1], (float) ((this.iGo - this.iGL) - 1));
            this.iHz.lineTo((float) this.iGz, (float) ((this.iGo - this.iGL) - 1));
            this.iHz.lineTo((float) this.iGz, this.iHw[0]);
            canvas.drawPath(this.iHz, this.fBa);
            return;
        }
        this.iHz.reset();
        this.iHz.moveTo((float) ((Point) this.points.get(0)).x, (float) ((Point) this.points.get(0)).y);
        while (i < this.points.size()) {
            if (i <= 0) {
                aIp();
            } else if (((Point) this.points.get(i - 1)).y == this.iGo - this.iGF) {
                this.fBa.reset();
                this.fBa.setPathEffect(new DashPathEffect(new float[]{5.0f, 5.0f}, 0.0f));
                this.fBa.setAntiAlias(true);
                this.fBa.setStrokeWidth((float) this.iGv);
                this.fBa.setStyle(Style.STROKE);
                this.fBa.setColor(-1);
            } else {
                aIp();
            }
            this.iHz.lineTo((float) ((Point) this.points.get(i)).x, (float) ((Point) this.points.get(i)).y);
            canvas.drawPath(this.iHz, this.fBa);
            this.iHz.reset();
            this.iHz.moveTo((float) ((Point) this.points.get(i)).x, (float) ((Point) this.points.get(i)).y);
            i++;
        }
    }

    private float i(int i, float f) {
        Resources system;
        Context context = getContext();
        if (context == null) {
            system = Resources.getSystem();
        } else {
            system = context.getResources();
        }
        return TypedValue.applyDimension(i, f, system.getDisplayMetrics());
    }

    private void b(Canvas canvas, List<String> list) {
        if (list != null && list.size() == 7) {
            this.fBa.reset();
            this.fBa.setAntiAlias(true);
            this.fBa.setStrokeWidth(0.0f);
            this.fBa.setTextSize(i(2, 12.0f));
            this.fBa.setAlpha(153);
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    if (i2 == 0) {
                        this.fBa.setTextAlign(Align.LEFT);
                    } else {
                        this.fBa.setTextAlign(Align.CENTER);
                    }
                    if (this.iHx[i2]) {
                        this.fBa.setColor(-1);
                    } else {
                        this.fBa.setColor(this.iGi);
                    }
                    canvas.drawText((String) list.get(i2), (float) ((Point) this.points.get(i2)).x, (float) (this.iGo - this.iGV), this.fBa);
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    private void aIn() {
        this.fBa = new Paint();
        this.iHy = new Path();
        this.iHz = new Path();
        this.points = new LinkedList();
        this.iHA = new LinkedList();
        aIo();
    }

    private void aIo() {
        for (int i = 0; i < 7; i++) {
            if (i == 6) {
                this.iHx[i] = true;
            } else {
                this.iHx[i] = false;
            }
        }
    }

    private void aIp() {
        this.fBa.reset();
        this.fBa.setAntiAlias(true);
        this.fBa.setStrokeWidth((float) this.iGv);
        this.fBa.setStyle(Style.STROKE);
        this.fBa.setColor(-1);
    }

    protected void onDraw(Canvas canvas) {
        getData();
        super.onDraw(canvas);
        if (!this.iHB) {
            int i;
            this.fBa.reset();
            this.fBa.setAntiAlias(true);
            this.fBa.setColor(-1);
            this.fBa.setStrokeWidth(0.0f);
            this.fBa.setStyle(Style.FILL);
            int i2 = 0;
            while (true) {
                i = i2;
                if (i >= this.points.size()) {
                    break;
                }
                Point point = (Point) this.points.get(i);
                if (i == this.points.size() - 1) {
                    canvas.drawCircle((float) point.x, (float) point.y, (float) this.iGt, this.fBa);
                } else {
                    canvas.drawCircle((float) point.x, (float) point.y, (float) this.iGr, this.fBa);
                }
                i2 = i + 1;
            }
            if (this.iGm != Integer.MAX_VALUE) {
                i = this.iGm;
                this.fBa.reset();
                this.fBa.setColor(this.iGi);
                this.fBa.setAntiAlias(true);
                this.fBa.setStrokeWidth(0.0f);
                this.fBa.setTextSize(i(2, 12.0f));
                this.fBa.setTextAlign(Align.CENTER);
                if (i >= 0 && i <= 6) {
                    if (i == 0) {
                        this.fBa.setTextAlign(Align.LEFT);
                    }
                    if (i == 6) {
                        this.fBa.setTextAlign(Align.RIGHT);
                    }
                    if (!this.iHE) {
                        this.iHD = ((Point) this.points.get(i)).y - this.iHf;
                        this.startY = this.iHD;
                        this.iHE = true;
                    }
                    if (this.iHE) {
                        float f = (float) (((double) this.startY) / 8.0d);
                        if (this.iHD > 0) {
                            this.fBa.setAlpha(((this.startY - this.iHD) * b.CTRL_BYTE) / this.startY);
                        }
                        canvas.drawText(this.iHt[i], (float) ((Point) this.points.get(i)).x, (float) (this.iHD + this.iHf), this.fBa);
                        if (this.iHD > 0) {
                            if (((float) this.iHD) / ((float) this.startY) <= 1.0f / f) {
                                this.iHD--;
                            } else {
                                this.iHD = (int) (((float) this.iHD) - ((((float) this.iHD) / ((float) this.startY)) * f));
                            }
                            invalidate();
                        } else {
                            this.iHE = false;
                        }
                    }
                }
                i2 = this.iGm;
                if (i2 >= 0 && i2 <= 6) {
                    this.iHx[i2] = true;
                }
            }
        }
        this.fBa.reset();
        this.iHy.reset();
        this.fBa.setPathEffect(new DashPathEffect(new float[]{5.0f, 5.0f}, 0.0f));
        this.fBa.setColor(this.iGc);
        this.fBa.setStrokeWidth((float) this.iGx);
        this.fBa.setAlpha(102);
        this.fBa.setStyle(Style.STROKE);
        if (!(this.iHo == 0 || this.iHB)) {
            this.iHy.moveTo((float) this.iGz, (float) this.iHo);
            this.iHy.lineTo((float) (this.iGn - this.iGH), (float) this.iHo);
            canvas.drawPath(this.iHy, this.fBa);
        }
        this.fBa.reset();
        this.iHy.reset();
        this.fBa.setColor(this.iGc);
        this.fBa.setStrokeWidth((float) this.iGx);
        this.fBa.setStyle(Style.STROKE);
        this.fBa.setAlpha(102);
        this.iHy.reset();
        this.iHy.moveTo(this.iGP, (float) (this.iGo - this.iGL));
        this.iHy.lineTo(((float) this.iGn) - this.iGR, (float) (this.iGo - this.iGL));
        this.iHy.moveTo(this.iGP, (float) this.iGN);
        this.iHy.lineTo(((float) this.iGn) - this.iGR, (float) this.iGN);
        canvas.drawPath(this.iHy, this.fBa);
        if (!this.iHB) {
            this.fBa.reset();
            this.fBa.setColor(this.iGk);
            this.fBa.setAntiAlias(true);
            this.fBa.setAlpha(102);
            this.fBa.setStrokeWidth(0.0f);
            this.fBa.setTextSize(i(2, 12.0f));
            this.fBa.setTextAlign(Align.RIGHT);
            canvas.drawText(getResources().getString(R.l.exdevice_profile_step_chart_1w_tips), (float) (this.iGn - this.iGT), (float) (((double) this.iHo) + (((double) this.fBa.getTextSize()) * 0.34d)), this.fBa);
        }
        this.fBa.reset();
        this.fBa.setColor(-1);
        this.fBa.setAntiAlias(true);
        this.fBa.setStrokeWidth(0.0f);
        this.fBa.setTypeface(this.iHp);
        this.fBa.setTextSize(i(2, 28.0f));
        canvas.drawText(getResources().getString(R.l.exdevice_profile_step_chart_step_tips), (float) this.iGZ, (float) this.iGX, this.fBa);
        this.fBa.setTextAlign(Align.RIGHT);
        this.fBa.setTextSize(i(2, 33.0f));
        canvas.drawText(this.iHt[this.iHt.length - 1], (float) (this.iGn - this.iHd), (float) this.iHb, this.fBa);
        if (this.points.size() > 2) {
            this.fBa.reset();
            this.fBa.setAntiAlias(true);
            this.fBa.setStrokeWidth(0.0f);
            this.fBa.setAlpha(102);
            this.fBa.setStyle(Style.FILL_AND_STROKE);
            this.fBa.setShader(new LinearGradient(0.0f, 0.0f, 0.0f, (float) (this.iGo - this.iGL), -1, 16777215, TileMode.REPEAT));
            this.fBa.setColor(-1);
            c(canvas, true);
            aIp();
            if (!this.iHB) {
                c(canvas, false);
            }
        }
        b(canvas, this.iHA);
    }

    private void getData() {
        int i;
        int i2 = 0;
        this.points.clear();
        View findViewById = findViewById(R.h.exdevice_rank_step_chart);
        this.iGn = findViewById.getWidth();
        this.iGo = findViewById.getHeight();
        this.iHr = ((this.iGn - this.iGz) - this.iGB) / 6;
        this.iHs = ((this.iGo - this.iGD) - this.iGF) / 2;
        for (i = 0; i < this.iHv.length; i++) {
            this.iHv[i] = (float) (this.iGz + (this.iHr * i));
        }
        i = this.iHt.length;
        if (i > 7) {
            i = 7;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < i; i4++) {
            if (this.iHt[i4] > 100000) {
                this.iHt[i4] = 100000;
            }
            if (this.iHt[i4] < 0) {
                this.iHt[i4] = 0;
            }
            if (this.iHt[i4] > i3) {
                i3 = this.iHt[i4];
            }
        }
        if (i3 <= 15000 && i3 >= 0) {
            i3 = 15000;
        } else if (i3 <= 15000 || i3 > 100000) {
            i3 = 0;
        } else if (((double) i3) / 5000.0d > ((double) (((float) i3) / 5000.0f))) {
            i3 = ((i3 / TbsReaderView$ReaderCallback.GET_BAR_ANIMATING) + 1) * TbsReaderView$ReaderCallback.GET_BAR_ANIMATING;
        }
        this.iHo = (((this.iGo - this.iGD) - this.iGF) * 10000) / i3;
        this.iHo = (this.iGo - this.iGF) - this.iHo;
        while (i2 < i) {
            this.iHw[i2] = ((float) (this.iGo - this.iGF)) - ((((float) this.iHt[i2]) / ((float) i3)) * ((float) ((this.iGo - this.iGD) - this.iGF)));
            this.points.add(new Point((int) this.iHv[i2], (int) this.iHw[i2]));
            i2++;
        }
    }

    private int ai(float f) {
        this.iGm = Integer.MAX_VALUE;
        if (this.points.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.points.size()) {
                    break;
                }
                if (i2 != 0) {
                    if (i2 > 0 && i2 < this.points.size() - 1) {
                        if (f < ((float) (((Point) this.points.get(i2)).x + (this.iHr / 2))) && f > ((float) (((Point) this.points.get(i2)).x - (this.iHr / 2)))) {
                            this.iGm = i2;
                            invalidate();
                            break;
                        }
                    } else if (i2 == this.points.size() - 1) {
                        if (f < ((float) this.iGn) && f > ((float) (((Point) this.points.get(i2)).x - (this.iHr / 2)))) {
                            this.iGm = i2;
                            invalidate();
                            break;
                        }
                    } else {
                        this.iGm = Integer.MAX_VALUE;
                        break;
                    }
                } else if (f < ((float) (((Point) this.points.get(i2)).x + (this.iHr / 2))) && f > 0.0f) {
                    this.iGm = i2;
                    invalidate();
                    break;
                }
                i = i2 + 1;
            }
        }
        return this.iGm;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        float x = motionEvent.getX();
        motionEvent.getY();
        x.i("MicroMsg.exdevice.ExdeviceStepChartView", "mOnTouchLinePsition:" + this.iGm);
        switch (motionEvent.getAction()) {
            case 0:
                x.d("MicroMsg.exdevice.ExdeviceStepChartView", "ACTION_DOWN");
                return true;
            case 1:
                x.d("MicroMsg.exdevice.ExdeviceStepChartView", "ACTION_UP");
                this.iGm = ai(x);
                aIo();
                this.iHE = false;
                invalidate();
                return false;
            default:
                x.d("MicroMsg.exdevice.ExdeviceStepChartView", "default");
                return false;
        }
    }
}

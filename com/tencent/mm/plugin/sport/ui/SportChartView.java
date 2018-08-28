package com.tencent.mm.plugin.sport.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Shader.TileMode;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.mm.plugin.appbrand.jsapi.a.d;
import com.tencent.mm.plugin.sns.i$l;
import com.tencent.mm.plugin.sport.b.e;
import com.tencent.mm.plugin.sport.ui.a.a;
import com.tencent.mm.plugin.sport.ui.a.b;
import com.tencent.mm.sdk.platformtools.x;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class SportChartView extends View {
    Paint fBa;
    private GestureDetector iEv;
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
    private int iGn;
    private int iGo;
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
    Path iHy;
    Path iHz;
    private int kPb;
    private boolean opA;
    private int opB;
    private int opC;
    private int opD;
    private int opE;
    private List<e> opF;
    private b[] opG;
    private int opH;
    private boolean opI;
    private OnGestureListener opJ;
    private SimpleDateFormat opy;
    private SimpleDateFormat opz;
    private int startY;

    public final void xT(int i) {
        this.opD = i;
        if (i == a.opM) {
            this.opE = 7;
        } else {
            this.opE = 30;
        }
        this.opG = new b[this.opE];
        bFU();
    }

    private void bFU() {
        for (int i = 0; i < this.opG.length; i++) {
            this.opG[i] = new b(this, (byte) 0);
        }
    }

    public SportChartView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.opy = new SimpleDateFormat(getResources().getString(b.sport_step_chart_fmt_date));
        this.opz = new SimpleDateFormat("d");
        this.iGa = -1;
        this.iGb = -1;
        this.iGc = getResources().getColor(a.sport_step_chart_background_line_color);
        this.iGd = 12.0f;
        this.iGe = 24.0f;
        this.iGf = 28.0f;
        this.iGg = 12.0f;
        this.iGh = 12.0f;
        this.iGi = getResources().getColor(a.sport_step_chart_date_text_color);
        this.iGj = -1;
        this.iGk = getResources().getColor(a.sport_step_chart_date_text_color);
        this.iGl = -1;
        this.kPb = Integer.MAX_VALUE;
        this.iGn = 0;
        this.iGo = 0;
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
        this.iHh = i$l.AppCompatTheme_checkboxStyle;
        this.iHi = i$l.AppCompatTheme_checkboxStyle;
        this.iHj = 153;
        this.iHk = i$l.AppCompatTheme_checkboxStyle;
        this.iHl = i$l.AppCompatTheme_checkboxStyle;
        this.iHm = i$l.AppCompatTheme_checkboxStyle;
        this.iHn = d.CTRL_INDEX;
        this.iHo = 0;
        this.iHp = Typeface.create(Typeface.DEFAULT_BOLD, 0);
        this.iHq = Typeface.create(Typeface.DEFAULT_BOLD, 1);
        this.iHr = 0;
        this.iHs = 0;
        this.opB = -1;
        this.opC = -1;
        this.opD = a.opM;
        this.opE = 7;
        this.opG = new b[this.opE];
        this.opJ = new 1(this);
        aIn();
    }

    public SportChartView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.opy = new SimpleDateFormat(getResources().getString(b.sport_step_chart_fmt_date));
        this.opz = new SimpleDateFormat("d");
        this.iGa = -1;
        this.iGb = -1;
        this.iGc = getResources().getColor(a.sport_step_chart_background_line_color);
        this.iGd = 12.0f;
        this.iGe = 24.0f;
        this.iGf = 28.0f;
        this.iGg = 12.0f;
        this.iGh = 12.0f;
        this.iGi = getResources().getColor(a.sport_step_chart_date_text_color);
        this.iGj = -1;
        this.iGk = getResources().getColor(a.sport_step_chart_date_text_color);
        this.iGl = -1;
        this.kPb = Integer.MAX_VALUE;
        this.iGn = 0;
        this.iGo = 0;
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
        this.iHh = i$l.AppCompatTheme_checkboxStyle;
        this.iHi = i$l.AppCompatTheme_checkboxStyle;
        this.iHj = 153;
        this.iHk = i$l.AppCompatTheme_checkboxStyle;
        this.iHl = i$l.AppCompatTheme_checkboxStyle;
        this.iHm = i$l.AppCompatTheme_checkboxStyle;
        this.iHn = d.CTRL_INDEX;
        this.iHo = 0;
        this.iHp = Typeface.create(Typeface.DEFAULT_BOLD, 0);
        this.iHq = Typeface.create(Typeface.DEFAULT_BOLD, 1);
        this.iHr = 0;
        this.iHs = 0;
        this.opB = -1;
        this.opC = -1;
        this.opD = a.opM;
        this.opE = 7;
        this.opG = new b[this.opE];
        this.opJ = new 1(this);
        aIn();
    }

    public void setTodayStep(int i) {
        this.opH = i;
    }

    private void c(Canvas canvas, boolean z) {
        int i = 0;
        if (z) {
            this.iHz.reset();
            this.iHz.moveTo(this.opG[0].x, this.opG[0].y);
            for (int i2 = 0; i2 < this.opG.length; i2++) {
                this.iHz.lineTo(this.opG[i2].x, this.opG[i2].y);
            }
            this.iHz.lineTo(this.opG[this.opG.length - 1].x, (float) ((this.iGo - this.iGL) - 1));
            this.iHz.lineTo((float) this.iGz, (float) ((this.iGo - this.iGL) - 1));
            this.iHz.lineTo((float) this.iGz, this.opG[0].y);
            canvas.drawPath(this.iHz, this.fBa);
            return;
        }
        this.iHz.reset();
        this.iHz.moveTo(this.opG[0].x, this.opG[0].y);
        while (i < this.opG.length) {
            if (i <= 0) {
                aIp();
            } else if (this.opG[i - 1].y == ((float) (this.iGo - this.iGF))) {
                this.fBa.reset();
                this.fBa.setPathEffect(new DashPathEffect(new float[]{5.0f, 5.0f}, 0.0f));
                this.fBa.setAntiAlias(true);
                this.fBa.setStrokeWidth((float) this.iGv);
                this.fBa.setStyle(Style.STROKE);
                this.fBa.setColor(-1);
            } else {
                aIp();
            }
            this.iHz.lineTo(this.opG[i].x, this.opG[i].y);
            canvas.drawPath(this.iHz, this.fBa);
            this.iHz.reset();
            this.iHz.moveTo(this.opG[i].x, this.opG[i].y);
            i++;
        }
    }

    private void g(Canvas canvas) {
        this.fBa.reset();
        this.fBa.setAntiAlias(true);
        this.fBa.setColor(-1);
        this.fBa.setStrokeWidth(0.0f);
        this.fBa.setStyle(Style.FILL);
        for (int i = 0; i < this.opG.length; i++) {
            if (i == this.opG.length - 1) {
                canvas.drawCircle(this.opG[i].x, this.opG[i].y, (float) this.iGt, this.fBa);
            } else {
                canvas.drawCircle(this.opG[i].x, this.opG[i].y, (float) this.iGr, this.fBa);
            }
        }
    }

    public final void cy(List<e> list) {
        this.opF = list;
        iv(true);
        invalidate();
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

    private void h(Canvas canvas) {
        this.fBa.reset();
        this.fBa.setAntiAlias(true);
        this.fBa.setStrokeWidth(0.0f);
        this.fBa.setTextSize(i(2, 12.0f));
        this.fBa.setAlpha(153);
        for (int i = 0; i < this.opG.length; i++) {
            if (i == 0) {
                this.fBa.setTextAlign(Align.LEFT);
            } else {
                this.fBa.setTextAlign(Align.CENTER);
            }
            if (this.opG[i].opP) {
                this.fBa.setColor(-1);
            } else {
                this.fBa.setColor(this.iGi);
            }
            canvas.drawText(this.opG[i].mPv, this.opG[i].x, (float) (this.iGo - this.iGV), this.fBa);
        }
    }

    private void aIn() {
        this.fBa = new Paint();
        this.iHy = new Path();
        this.iHz = new Path();
        this.opG = new b[this.opE];
        bFU();
        bFV();
        this.iEv = new GestureDetector(getContext(), this.opJ);
    }

    private void bFV() {
        for (int i = 0; i < this.opE; i++) {
            if (i == this.opE - 1) {
                this.opG[i].opP = true;
            } else {
                this.opG[i].opP = false;
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
        int i;
        this.iGn = getWidth();
        this.iGo = getHeight();
        this.iHr = ((this.iGn - this.iGz) - this.iGB) / (this.opE - 1);
        this.iHs = ((this.iGo - this.iGD) - this.iGF) / 2;
        for (i = 0; i < this.opG.length; i++) {
            this.opG[i].x = (float) (this.iGz + (this.iHr * i));
        }
        i = this.opG.length;
        if (i > this.opE) {
            i = this.opE;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            if (this.opG[i3].fHo > 100000) {
                this.opG[i3].fHo = 100000;
            }
            if (this.opG[i3].fHo < 0) {
                this.opG[i3].fHo = 0;
            }
            if (this.opG[i3].fHo > i2) {
                i2 = this.opG[i3].fHo;
            }
        }
        if (i2 <= 15000 && i2 >= 0) {
            i2 = 15000;
        } else if (i2 <= 15000 || i2 > 100000) {
            i2 = 0;
        } else if (((double) i2) / 5000.0d > ((double) (((float) i2) / 5000.0f))) {
            i2 = ((i2 / 5000) + 1) * 5000;
        }
        this.iHo = (((this.iGo - this.iGD) - this.iGF) * 10000) / i2;
        this.iHo = (this.iGo - this.iGF) - this.iHo;
        for (int i4 = 0; i4 < i; i4++) {
            this.opG[i4].y = ((float) (this.iGo - this.iGF)) - ((((float) this.opG[i4].fHo) / ((float) i2)) * ((float) ((this.iGo - this.iGD) - this.iGF)));
        }
        for (i2 = 0; i2 < i; i2++) {
            if (i2 == 0) {
                this.opG[i2].mPv = this.opy.format(new Date(this.opG[i2].timestamp));
            } else if (this.opD != a.opN) {
                this.opG[i2].mPv = this.opz.format(new Date(this.opG[i2].timestamp));
            } else if (i2 % 6 == 5) {
                this.opG[i2].mPv = this.opz.format(new Date(this.opG[i2].timestamp));
            } else {
                this.opG[i2].mPv = "";
            }
        }
        super.onDraw(canvas);
        if (!this.opA) {
            g(canvas);
            if (this.kPb != Integer.MAX_VALUE) {
                i = this.kPb;
                if (i >= 0 && i <= this.opE - 1) {
                    this.fBa.reset();
                    this.fBa.setColor(this.iGi);
                    this.fBa.setAntiAlias(true);
                    this.fBa.setStrokeWidth(0.0f);
                    this.fBa.setTextSize(i(2, 12.0f));
                    this.fBa.setTextAlign(Align.CENTER);
                    if (i == 0) {
                        this.fBa.setTextAlign(Align.LEFT);
                    }
                    if (i == this.opE - 1) {
                        this.fBa.setTextAlign(Align.RIGHT);
                    }
                    if (!this.iHE) {
                        this.iHD = ((int) this.opG[i].y) - this.iHf;
                        this.startY = this.iHD;
                        this.iHE = true;
                    }
                    if (this.iHE) {
                        float f = (float) (((double) this.startY) / 8.0d);
                        if (this.iHD > 0) {
                            this.fBa.setAlpha(((this.startY - this.iHD) * 255) / this.startY);
                        }
                        canvas.drawText(this.opG[i].fHo, this.opG[i].x, (float) (this.iHD + this.iHf), this.fBa);
                        if (this.opD == a.opN) {
                            this.fBa.reset();
                            this.iHy.reset();
                            this.fBa.setPathEffect(new DashPathEffect(new float[]{5.0f, 5.0f}, 0.0f));
                            this.fBa.setColor(this.iGc);
                            this.fBa.setStrokeWidth((float) this.iGx);
                            this.fBa.setStyle(Style.STROKE);
                            this.fBa.setAlpha(i$l.AppCompatTheme_checkboxStyle);
                            this.iHy.moveTo(this.opG[i].x, (float) (this.iGo - this.iGL));
                            this.iHy.lineTo(this.opG[i].x, (float) ((this.iHD + this.iHf) + this.iGt));
                            canvas.drawPath(this.iHy, this.fBa);
                        }
                        if (this.iHD > 0) {
                            if (((float) this.iHD) / ((float) this.startY) <= 1.0f / f) {
                                this.iHD--;
                            } else {
                                this.iHD = (int) (((float) this.iHD) - (f * (((float) this.iHD) / ((float) this.startY))));
                            }
                            invalidate();
                        } else {
                            this.iHE = false;
                        }
                    }
                }
                i = this.kPb;
                if (i >= 0 && i <= this.opE - 1) {
                    this.opG[i].opP = true;
                }
            }
        }
        this.fBa.reset();
        this.iHy.reset();
        this.fBa.setPathEffect(new DashPathEffect(new float[]{5.0f, 5.0f}, 0.0f));
        this.fBa.setColor(this.iGc);
        this.fBa.setStrokeWidth((float) this.iGx);
        this.fBa.setAlpha(i$l.AppCompatTheme_checkboxStyle);
        this.fBa.setStyle(Style.STROKE);
        if (!(this.iHo == 0 || this.opA)) {
            this.iHy.moveTo((float) this.iGz, (float) this.iHo);
            this.iHy.lineTo((float) (this.iGn - this.iGH), (float) this.iHo);
            canvas.drawPath(this.iHy, this.fBa);
        }
        this.fBa.reset();
        this.iHy.reset();
        this.fBa.setColor(this.iGc);
        this.fBa.setStrokeWidth((float) this.iGx);
        this.fBa.setStyle(Style.STROKE);
        this.fBa.setAlpha(i$l.AppCompatTheme_checkboxStyle);
        this.iHy.reset();
        this.iHy.moveTo(this.iGP, (float) (this.iGo - this.iGL));
        this.iHy.lineTo(((float) this.iGn) - this.iGR, (float) (this.iGo - this.iGL));
        this.iHy.moveTo(this.iGP, (float) this.iGN);
        this.iHy.lineTo(((float) this.iGn) - this.iGR, (float) this.iGN);
        canvas.drawPath(this.iHy, this.fBa);
        if (!this.opA) {
            this.fBa.reset();
            this.fBa.setColor(this.iGk);
            this.fBa.setAntiAlias(true);
            this.fBa.setAlpha(i$l.AppCompatTheme_checkboxStyle);
            this.fBa.setStrokeWidth(0.0f);
            this.fBa.setTextSize(i(2, 12.0f));
            this.fBa.setTextAlign(Align.RIGHT);
            canvas.drawText(getResources().getString(b.sport_step_chart_1w_tips), (float) (this.iGn - this.iGT), (float) (((double) this.iHo) + (((double) this.fBa.getTextSize()) * 0.34d)), this.fBa);
        }
        if (this.opI) {
            this.fBa.reset();
            this.fBa.setColor(-1);
            this.fBa.setAntiAlias(true);
            this.fBa.setStrokeWidth(0.0f);
            this.fBa.setTypeface(this.iHp);
            this.fBa.setTextAlign(Align.RIGHT);
            this.fBa.setTextSize(i(2, 28.0f));
            String valueOf = String.valueOf(this.opH);
            canvas.drawText(valueOf, (float) (this.iGn - this.iHd), (float) this.iHb, this.fBa);
            float measureText = this.fBa.measureText(valueOf);
            this.fBa.setTextSize(i(2, 24.0f));
            canvas.drawText(getResources().getString(b.sport_step_chart_switch_step_tips), ((float) (this.iGn - this.iHd)) - measureText, (float) this.iGX, this.fBa);
        } else {
            this.fBa.reset();
            this.fBa.setColor(-1);
            this.fBa.setAntiAlias(true);
            this.fBa.setStrokeWidth(0.0f);
            this.fBa.setTypeface(this.iHp);
            this.fBa.setTextSize(i(2, 24.0f));
            canvas.drawText(getResources().getString(b.sport_step_chart_step_tips), (float) this.iGZ, (float) this.iGX, this.fBa);
            this.fBa.setTextAlign(Align.RIGHT);
            this.fBa.setTextSize(i(2, 28.0f));
            canvas.drawText(this.opH, (float) (this.iGn - this.iHd), (float) this.iHb, this.fBa);
        }
        if (this.opG.length > 2) {
            this.fBa.reset();
            this.fBa.setAntiAlias(true);
            this.fBa.setStrokeWidth(0.0f);
            this.fBa.setAlpha(i$l.AppCompatTheme_checkboxStyle);
            this.fBa.setStyle(Style.FILL_AND_STROKE);
            this.fBa.setShader(new LinearGradient(0.0f, 0.0f, 0.0f, (float) (this.iGo - this.iGL), -1, 16777215, TileMode.REPEAT));
            this.fBa.setColor(-1);
            c(canvas, true);
            aIp();
            if (!this.opA) {
                c(canvas, false);
            }
        }
        h(canvas);
    }

    private void iv(boolean z) {
        int i = 0;
        this.kPb = Integer.MAX_VALUE;
        Calendar instance = Calendar.getInstance();
        this.opG = new b[this.opE];
        bFU();
        int i2;
        if (this.opF == null || this.opF.size() <= 0) {
            this.opA = true;
            instance.add(5, -this.opE);
            for (i2 = 0; i2 < this.opG.length; i2++) {
                instance.add(5, 1);
                this.opG[i2].timestamp = instance.getTimeInMillis();
                this.opG[i2].fHo = 0;
            }
            return;
        }
        this.opA = false;
        List arrayList = new ArrayList();
        arrayList.addAll(this.opF);
        Collections.sort(arrayList);
        int size = arrayList.size();
        if (z || this.opC == -1) {
            i2 = size / this.opE;
            if (size % this.opE != 0) {
                this.opC = i2 + 1;
            } else {
                this.opC = i2;
            }
            if (this.opC > 4) {
                this.opC = 4;
            }
            this.opB = this.opC;
        }
        i2 = size - (this.opE * ((this.opC - this.opB) + 1));
        if (i2 < 0) {
            i2 = 0;
        }
        x.i("MicroMsg.Sport.SportChartView", "updateViewItems beginIndex:%d endIndex:%d", new Object[]{Integer.valueOf(i2), Integer.valueOf(size - (this.opE * (this.opC - this.opB)))});
        arrayList = arrayList.subList(i2, size);
        size = arrayList.size();
        if (size < this.opE) {
            instance.setTimeInMillis(((e) arrayList.get(0)).field_timestamp);
            for (i2 = 0; i2 < this.opE - size; i2++) {
                instance.add(5, -1);
                e eVar = new e();
                eVar.field_timestamp = instance.getTimeInMillis();
                eVar.field_step = 0;
                arrayList.add(0, eVar);
            }
        }
        while (i < this.opE) {
            e eVar2 = (e) arrayList.get(i);
            this.opG[i].fHo = eVar2.field_step;
            this.opG[i].timestamp = eVar2.field_timestamp;
            i++;
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.iEv.onTouchEvent(motionEvent);
        return true;
    }

    public void setHasSwitchBtn(boolean z) {
        this.opI = z;
    }
}

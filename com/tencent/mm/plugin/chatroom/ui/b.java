package com.tencent.mm.plugin.chatroom.ui;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.text.format.DateUtils;
import android.text.format.Time;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import com.tencent.mm.R;
import com.tencent.mm.plugin.chatroom.d.a;
import com.tencent.mm.sdk.platformtools.x;
import java.security.InvalidParameterException;
import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashMap;
import java.util.Locale;

public final class b extends View {
    protected static int hPC = 32;
    protected static int hPD;
    protected static int hPE = 1;
    protected static int hPF;
    protected static int hPG = 10;
    protected static int hPH;
    protected static int hPI;
    protected static int hPJ;
    Collection<a> hMv = new ArrayList();
    protected int hPK = 80;
    protected Paint hPL;
    protected Paint hPM;
    protected Paint hPN;
    protected Paint hPO;
    protected Paint hPP;
    protected int hPQ;
    protected int hPR;
    protected int hPS;
    protected int hPT;
    protected int hPU;
    protected int hPV;
    protected int hPW;
    protected int hPX;
    protected int hPY;
    private final StringBuilder hPZ;
    protected boolean hQa = false;
    protected boolean hQb = false;
    protected int hQc = -1;
    protected int hQd = -1;
    protected int hQe = -1;
    protected int hQf = -1;
    protected int hQg = -1;
    protected int hQh = -1;
    protected int hQi = -1;
    protected int hQj = 1;
    protected int hQk = 7;
    protected int hQl = this.hQk;
    private int hQm = 0;
    protected Boolean hQn;
    protected int hQo = hPC;
    protected int hQp = 0;
    final Time hQq;
    private final Calendar hQr;
    private final Calendar hQs;
    private final Boolean hQt;
    public int hQu = 6;
    private DateFormatSymbols hQv = new DateFormatSymbols();
    private a hQw;
    protected int hhF;
    protected int hhG;
    private Context mContext;
    protected int mWidth;

    public b(Context context, TypedArray typedArray) {
        super(context);
        this.mContext = context;
        Resources resources = context.getResources();
        this.hQs = Calendar.getInstance();
        this.hQr = Calendar.getInstance();
        this.hQq = new Time(Time.getCurrentTimezone());
        this.hQq.setToNow();
        this.hPQ = typedArray.getColor(R.n.DayPickerView_colorCurrentDay, resources.getColor(R.e.normal_day));
        this.hPR = typedArray.getColor(R.n.DayPickerView_colorMonthName, resources.getColor(R.e.normal_day));
        this.hPS = typedArray.getColor(R.n.DayPickerView_colorDayName, resources.getColor(R.e.normal_day));
        this.hPT = typedArray.getColor(R.n.DayPickerView_colorDayName, resources.getColor(R.e.normal_label));
        this.hPU = typedArray.getColor(R.n.DayPickerView_colorNormalDay, resources.getColor(R.e.normal_day));
        this.hPW = typedArray.getColor(R.n.DayPickerView_colorPreviousDay, resources.getColor(R.e.normal_day));
        this.hPX = typedArray.getColor(R.n.DayPickerView_colorMarkDay, resources.getColor(R.e.marked_day_text));
        this.hPY = typedArray.getColor(R.n.DayPickerView_colorSelectedDayBackground, resources.getColor(R.e.selected_day_background));
        this.hPV = typedArray.getColor(R.n.DayPickerView_colorSelectedDayText, resources.getColor(R.e.selected_day_text));
        this.hQn = Boolean.valueOf(typedArray.getBoolean(R.n.DayPickerView_drawRoundRect, false));
        this.hPZ = new StringBuilder(50);
        hPF = typedArray.getDimensionPixelSize(R.n.DayPickerView_textSizeDay, resources.getDimensionPixelSize(R.f.text_size_day));
        hPJ = typedArray.getDimensionPixelSize(R.n.DayPickerView_textSizeMonth, resources.getDimensionPixelSize(R.f.text_size_month));
        hPH = typedArray.getDimensionPixelSize(R.n.DayPickerView_textSizeDayName, resources.getDimensionPixelSize(R.f.text_size_day_name));
        hPI = typedArray.getDimensionPixelOffset(R.n.DayPickerView_headerMonthHeight, resources.getDimensionPixelOffset(R.f.header_month_height));
        hPD = typedArray.getDimensionPixelSize(R.n.DayPickerView_selectedDayRadius, resources.getDimensionPixelOffset(R.f.selected_day_radius));
        this.hQo = (typedArray.getDimensionPixelSize(R.n.DayPickerView_calendarHeight, resources.getDimensionPixelOffset(R.f.calendar_height)) - hPI) / 6;
        this.hQp = typedArray.getDimensionPixelSize(R.n.DayPickerView_catteryPadding, resources.getDimensionPixelOffset(R.f.cattery_padding));
        this.hQt = Boolean.valueOf(typedArray.getBoolean(R.n.DayPickerView_enablePreviousDay, true));
        this.hPO = new Paint();
        this.hPO.setAntiAlias(true);
        this.hPO.setTextSize((float) hPJ);
        this.hPO.setTypeface(Typeface.create(Typeface.SANS_SERIF, 0));
        this.hPO.setColor(this.hPT);
        this.hPO.setTextAlign(Align.LEFT);
        this.hPO.setStyle(Style.FILL);
        this.hPN = new Paint();
        this.hPN.setFakeBoldText(true);
        this.hPN.setAntiAlias(true);
        this.hPN.setColor(this.hPV);
        this.hPN.setTextAlign(Align.CENTER);
        this.hPN.setStyle(Style.FILL);
        this.hPP = new Paint();
        this.hPP.setFakeBoldText(true);
        this.hPP.setAntiAlias(true);
        this.hPP.setColor(this.hPY);
        this.hPP.setTextAlign(Align.CENTER);
        this.hPP.setStyle(Style.FILL);
        this.hPL = new Paint();
        this.hPL.setAntiAlias(true);
        this.hPL.setTextSize((float) hPH);
        this.hPL.setColor(this.hPT);
        this.hPL.setTypeface(Typeface.create(Typeface.SANS_SERIF, 0));
        this.hPL.setStyle(Style.FILL);
        this.hPL.setTextAlign(Align.CENTER);
        this.hPL.setFakeBoldText(true);
        this.hPM = new Paint();
        this.hPM.setAntiAlias(true);
        this.hPM.setTextSize((float) hPF);
        this.hPM.setStyle(Style.FILL);
        this.hPM.setTextAlign(Align.CENTER);
        this.hPM.setFakeBoldText(false);
    }

    private void e(Canvas canvas) {
        int i = hPI - (hPH / 2);
        int i2 = (this.mWidth - (this.hPK * 2)) / (this.hQk * 2);
        for (int i3 = 0; i3 < this.hQk; i3++) {
            int i4 = (((i3 * 2) + 1) * i2) + this.hPK;
            this.hQs.set(7, (this.hQj + i3) % this.hQk);
            canvas.drawText(this.hQv.getShortWeekdays()[this.hQs.get(7)].toUpperCase(Locale.getDefault()), (float) i4, (float) i, this.hPL);
        }
    }

    private int aAW() {
        return (this.hQm < this.hQj ? this.hQm + this.hQk : this.hQm) - this.hQj;
    }

    private String getMonthAndYearString() {
        this.hPZ.setLength(0);
        long timeInMillis = this.hQr.getTimeInMillis();
        return DateUtils.formatDateRange(getContext(), timeInMillis, timeInMillis, 52);
    }

    private boolean a(int i, Time time) {
        return this.hhF < time.year || ((this.hhF == time.year && this.hhG < time.month) || (this.hhG == time.month && i < time.monthDay));
    }

    private void f(Canvas canvas) {
        int i = (((this.hQo + hPF) / 2) - hPE) + hPI;
        int i2 = (this.mWidth - (this.hPK * 2)) / (this.hQk * 2);
        int aAW = aAW();
        int i3 = 1;
        while (true) {
            int i4 = i3;
            if (i4 > this.hQl) {
                return;
            }
            if (i4 <= this.hQi || -1 == this.hQi) {
                int i5 = this.hPK + (((aAW * 2) + 1) * i2);
                if ((this.hhG == this.hQe && this.hQc == i4 && this.hQg == this.hhF) || ((this.hhG == this.hQf && this.hQd == i4 && this.hQh == this.hhF) || (this.hQa && this.hQi == i4 && this.hQc == -1))) {
                    if (this.hQn.booleanValue()) {
                        canvas.drawRoundRect(new RectF((float) (i5 - hPD), (float) ((i - (hPF / 3)) - hPD), (float) (hPD + i5), (float) ((i - (hPF / 3)) + hPD)), 10.0f, 10.0f, this.hPP);
                    } else {
                        canvas.drawCircle((float) i5, (float) (i - (hPF / 3)), (float) hPD, this.hPP);
                    }
                    if (this.hQa && this.hQi == i4 && this.hQc == -1) {
                        this.hPM.setColor(this.hPY);
                        this.hPM.setTypeface(Typeface.defaultFromStyle(0));
                        this.hPM.setTextSize(30.0f);
                        canvas.drawText(this.mContext.getResources().getString(R.l.today_tip), (float) i5, (float) ((i + 12) + hPD), this.hPM);
                    }
                }
                this.hPM.setTextSize((float) hPF);
                if (!(this.hQa && this.hQi == i4)) {
                    this.hPM.setColor(this.hPU);
                    this.hPM.setTypeface(Typeface.defaultFromStyle(0));
                }
                if (this.hQc != -1 && this.hQd != -1 && this.hQg == this.hQh && this.hQe == this.hQf && this.hQc == this.hQd && i4 == this.hQc && this.hhG == this.hQe && this.hhF == this.hQg) {
                    this.hPM.setColor(this.hPY);
                }
                if (this.hQc != -1 && this.hQd != -1 && this.hQg == this.hQh && this.hQg == this.hhF && ((this.hhG == this.hQe && this.hQf == this.hQe && ((this.hQc < this.hQd && i4 > this.hQc && i4 < this.hQd) || (this.hQc > this.hQd && i4 < this.hQc && i4 > this.hQd))) || ((this.hQe < this.hQf && this.hhG == this.hQe && i4 > this.hQc) || ((this.hQe < this.hQf && this.hhG == this.hQf && i4 < this.hQd) || ((this.hQe > this.hQf && this.hhG == this.hQe && i4 < this.hQc) || (this.hQe > this.hQf && this.hhG == this.hQf && i4 > this.hQd)))))) {
                    this.hPM.setColor(this.hPY);
                }
                if (!(this.hQc == -1 || this.hQd == -1 || this.hQg == this.hQh || (((this.hQg != this.hhF || this.hhG != this.hQe) && (this.hQh != this.hhF || this.hhG != this.hQf)) || ((this.hQe >= this.hQf || this.hhG != this.hQe || i4 >= this.hQc) && ((this.hQe >= this.hQf || this.hhG != this.hQf || i4 <= this.hQd) && ((this.hQe <= this.hQf || this.hhG != this.hQe || i4 <= this.hQc) && (this.hQe <= this.hQf || this.hhG != this.hQf || i4 >= this.hQd))))))) {
                    this.hPM.setColor(this.hPY);
                }
                if (this.hQc != -1 && this.hQd != -1 && this.hQg == this.hQh && this.hhF == this.hQg && ((this.hhG > this.hQe && this.hhG < this.hQf && this.hQe < this.hQf) || (this.hhG < this.hQe && this.hhG > this.hQf && this.hQe > this.hQf))) {
                    this.hPM.setColor(this.hPY);
                }
                if (!(this.hQc == -1 || this.hQd == -1 || this.hQg == this.hQh || ((this.hQg >= this.hQh || ((this.hhG <= this.hQe || this.hhF != this.hQg) && (this.hhG >= this.hQf || this.hhF != this.hQh))) && (this.hQg <= this.hQh || ((this.hhG >= this.hQe || this.hhF != this.hQg) && (this.hhG <= this.hQf || this.hhF != this.hQh)))))) {
                    this.hPM.setColor(this.hPY);
                }
                if (!this.hQt.booleanValue() && a(i4, this.hQq) && this.hQq.month == this.hhG && this.hQq.year == this.hhF) {
                    this.hPM.setColor(this.hPW);
                    this.hPM.setTypeface(Typeface.defaultFromStyle(2));
                }
                for (a aVar : this.hMv) {
                    if (aVar.day == i4 && aVar.month == this.hhG && aVar.year == this.hhF) {
                        this.hPM.setColor(this.hPX);
                        this.hPM.setTypeface(Typeface.defaultFromStyle(0));
                    }
                }
                if ((this.hhG == this.hQe && this.hQc == i4 && this.hQg == this.hhF) || ((this.hhG == this.hQf && this.hQd == i4 && this.hQh == this.hhF) || (this.hQa && this.hQi == i4 && this.hQc == -1))) {
                    this.hPM.setTypeface(Typeface.defaultFromStyle(0));
                    this.hPM.setColor(-1);
                }
                canvas.drawText(String.format("%d", new Object[]{Integer.valueOf(i4)}), (float) i5, (float) i, this.hPM);
                aAW++;
                if (aAW == this.hQk) {
                    aAW = 0;
                    i += this.hQo;
                }
                i3 = i4 + 1;
            } else {
                return;
            }
        }
    }

    protected final void onDraw(Canvas canvas) {
        int i = (((this.mWidth - (this.hPK * 2)) / (this.hQk * 2)) + this.hPK) - (hPJ / 2);
        int i2 = ((hPI - hPJ) / 2) + hPJ;
        StringBuilder stringBuilder = new StringBuilder(getMonthAndYearString().toLowerCase());
        stringBuilder.setCharAt(0, Character.toUpperCase(stringBuilder.charAt(0)));
        canvas.drawText(stringBuilder.toString(), (float) i, (float) i2, this.hPO);
        canvas.drawLine(0.0f, (float) hPI, (float) this.mWidth, (float) (hPI + 1), this.hPO);
        e(canvas);
        f(canvas);
    }

    protected final void onMeasure(int i, int i2) {
        setMeasuredDimension(MeasureSpec.getSize(i), ((this.hQo * this.hQu) + hPI) + this.hQp);
    }

    protected final void onSizeChanged(int i, int i2, int i3, int i4) {
        this.mWidth = i;
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            a aVar;
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            int i = this.hPK;
            if (x < ((float) i) || x > ((float) (this.mWidth - this.hPK))) {
                aVar = null;
            } else {
                int aAW = ((((int) (((x - ((float) i)) * ((float) this.hQk)) / ((float) ((this.mWidth - i) - this.hPK)))) - aAW()) + 1) + ((((int) (y - ((float) hPI))) / this.hQo) * this.hQk);
                if (this.hhG > 11 || this.hhG < 0 || com.tencent.mm.plugin.chatroom.f.a.cn(this.hhG, this.hhF) < aAW || aAW <= 0) {
                    aVar = null;
                } else {
                    a aVar2 = new a(this.hhF, this.hhG, aAW);
                    for (a aVar3 : this.hMv) {
                        if (aVar3.equals(aVar2)) {
                            break;
                        }
                    }
                    aVar3 = null;
                }
            }
            if (!(aVar3 == null || this.hQw == null || (!this.hQt.booleanValue() && aVar3.month == this.hQq.month && aVar3.year == this.hQq.year && aVar3.day < this.hQq.monthDay))) {
                this.hQw.b(aVar3);
            }
        }
        return true;
    }

    public final void setMarkDate(Collection<a> collection) {
        if (collection != null) {
            this.hMv = collection;
        } else {
            x.e("MicroMsg.SimpleMonthView", "markDateList is null");
        }
    }

    public final void setMonthParams(HashMap<String, Integer> hashMap) {
        int i = 0;
        if (hashMap.containsKey("month") || hashMap.containsKey("year")) {
            int i2;
            setTag(hashMap);
            if (hashMap.containsKey("height")) {
                this.hQo = ((Integer) hashMap.get("height")).intValue();
                if (this.hQo < hPG) {
                    this.hQo = hPG;
                }
            }
            if (hashMap.containsKey("selected_begin_day")) {
                this.hQc = ((Integer) hashMap.get("selected_begin_day")).intValue();
            }
            if (hashMap.containsKey("selected_last_day")) {
                this.hQd = ((Integer) hashMap.get("selected_last_day")).intValue();
            }
            if (hashMap.containsKey("selected_begin_month")) {
                this.hQe = ((Integer) hashMap.get("selected_begin_month")).intValue();
            }
            if (hashMap.containsKey("selected_last_month")) {
                this.hQf = ((Integer) hashMap.get("selected_last_month")).intValue();
            }
            if (hashMap.containsKey("selected_begin_year")) {
                this.hQg = ((Integer) hashMap.get("selected_begin_year")).intValue();
            }
            if (hashMap.containsKey("selected_last_year")) {
                this.hQh = ((Integer) hashMap.get("selected_last_year")).intValue();
            }
            this.hhG = ((Integer) hashMap.get("month")).intValue();
            this.hhF = ((Integer) hashMap.get("year")).intValue();
            this.hQa = false;
            this.hQi = -1;
            this.hQr.set(2, this.hhG);
            this.hQr.set(1, this.hhF);
            this.hQr.set(5, 1);
            this.hQm = this.hQr.get(7);
            if (hashMap.containsKey("week_start")) {
                this.hQj = ((Integer) hashMap.get("week_start")).intValue();
            } else {
                this.hQj = this.hQr.getFirstDayOfWeek();
            }
            this.hQl = com.tencent.mm.plugin.chatroom.f.a.cn(this.hhG, this.hhF);
            for (i2 = 0; i2 < this.hQl; i2++) {
                boolean z;
                int i3 = i2 + 1;
                Time time = this.hQq;
                if (this.hhF == time.year && this.hhG == time.month && i3 == time.monthDay) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    this.hQa = true;
                    this.hQi = i3;
                }
                this.hQb = a(i3, this.hQq);
            }
            i2 = aAW();
            int i4 = (this.hQl + i2) / this.hQk;
            if ((i2 + this.hQl) % this.hQk > 0) {
                i = 1;
            }
            this.hQu = i4 + i;
            return;
        }
        throw new InvalidParameterException("You must specify month and year for this view");
    }

    public final void setOnDayClickListener(a aVar) {
        this.hQw = aVar;
    }
}

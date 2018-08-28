package com.tencent.mm.plugin.pwdgroup.ui.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.x;

public class MMKeyBoardView extends LinearLayout implements OnClickListener, OnLongClickListener {
    private ColorStateList bv;
    private float kgD;
    private Context mContext;
    private Button maF;
    private Button maG;
    private Button maH;
    private Button maI;
    private Button maJ;
    private Button maK;
    private Button maL;
    private Button maM;
    private Button maN;
    private Button maO;
    private ImageButton maP;
    private View maQ;
    private View maR;
    private View maS;
    private View maT;
    private View maU;
    private View maV;
    private boolean maW;
    private int maX;
    private int maY;
    private int maZ;
    private a mak;
    private int mba;
    private int mbb;
    private int mbc;
    private int mbd;
    private int mbe;
    private int mbf;

    public MMKeyBoardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public MMKeyBoardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.maW = true;
        this.mContext = context;
        this.maX = getResources().getDimensionPixelSize(R.f.keyboard_button_padding_height);
        this.maY = getResources().getDimensionPixelSize(R.f.keyboard_button_padding_width);
        this.kgD = (float) getResources().getDimensionPixelSize(R.f.keyboard_button_text_size);
        this.bv = getResources().getColorStateList(R.e.keyboard_text_color);
        this.maZ = getResources().getColor(R.e.keyboard_div_line_color);
        this.maF = new Button(this.mContext);
        this.maG = new Button(this.mContext);
        this.maH = new Button(this.mContext);
        this.maI = new Button(this.mContext);
        this.maJ = new Button(this.mContext);
        this.maK = new Button(this.mContext);
        this.maL = new Button(this.mContext);
        this.maM = new Button(this.mContext);
        this.maN = new Button(this.mContext);
        this.maO = new Button(this.mContext);
        this.maP = new ImageButton(this.mContext);
        this.maQ = new View(this.mContext);
        this.maQ = new View(this.mContext);
        this.maR = new View(this.mContext);
        this.maS = new View(this.mContext);
        this.maT = new View(this.mContext);
        this.maU = new View(this.mContext);
        this.maV = new View(this.mContext);
        this.maF.setBackgroundResource(R.g.keyboard_btn);
        this.maG.setBackgroundResource(R.g.keyboard_btn);
        this.maH.setBackgroundResource(R.g.keyboard_btn);
        this.maI.setBackgroundResource(R.g.keyboard_btn);
        this.maJ.setBackgroundResource(R.g.keyboard_btn);
        this.maK.setBackgroundResource(R.g.keyboard_btn);
        this.maL.setBackgroundResource(R.g.keyboard_btn);
        this.maM.setBackgroundResource(R.g.keyboard_btn);
        this.maN.setBackgroundResource(R.g.keyboard_btn);
        this.maK.setBackgroundResource(R.g.keyboard_btn);
        this.maO.setBackgroundResource(R.g.keyboard_btn);
        this.maP.setBackgroundResource(R.g.keyboard_btn);
        this.maP.setImageResource(R.g.keyboard_delete_btn);
        this.maF.setText("0");
        this.maG.setText("1");
        this.maH.setText("2");
        this.maI.setText("3");
        this.maJ.setText("4");
        this.maK.setText("5");
        this.maL.setText("6");
        this.maM.setText("7");
        this.maN.setText("8");
        this.maO.setText("9");
        this.maF.setGravity(17);
        this.maG.setGravity(17);
        this.maH.setGravity(17);
        this.maI.setGravity(17);
        this.maJ.setGravity(17);
        this.maK.setGravity(17);
        this.maL.setGravity(17);
        this.maM.setGravity(17);
        this.maN.setGravity(17);
        this.maO.setGravity(17);
        this.maF.setTextSize(0, this.kgD);
        this.maG.setTextSize(0, this.kgD);
        this.maH.setTextSize(0, this.kgD);
        this.maI.setTextSize(0, this.kgD);
        this.maJ.setTextSize(0, this.kgD);
        this.maK.setTextSize(0, this.kgD);
        this.maL.setTextSize(0, this.kgD);
        this.maM.setTextSize(0, this.kgD);
        this.maN.setTextSize(0, this.kgD);
        this.maO.setTextSize(0, this.kgD);
        this.maF.setTextColor(this.bv);
        this.maG.setTextColor(this.bv);
        this.maH.setTextColor(this.bv);
        this.maI.setTextColor(this.bv);
        this.maJ.setTextColor(this.bv);
        this.maK.setTextColor(this.bv);
        this.maL.setTextColor(this.bv);
        this.maM.setTextColor(this.bv);
        this.maN.setTextColor(this.bv);
        this.maO.setTextColor(this.bv);
        this.maF.setOnClickListener(this);
        this.maG.setOnClickListener(this);
        this.maH.setOnClickListener(this);
        this.maI.setOnClickListener(this);
        this.maJ.setOnClickListener(this);
        this.maK.setOnClickListener(this);
        this.maL.setOnClickListener(this);
        this.maM.setOnClickListener(this);
        this.maN.setOnClickListener(this);
        this.maO.setOnClickListener(this);
        this.maP.setOnClickListener(this);
        this.maP.setOnLongClickListener(this);
        this.maQ.setBackgroundColor(this.maZ);
        this.maQ.setBackgroundColor(this.maZ);
        this.maR.setBackgroundColor(this.maZ);
        this.maS.setBackgroundColor(this.maZ);
        this.maT.setBackgroundColor(this.maZ);
        this.maU.setBackgroundColor(this.maZ);
        this.maV.setBackgroundColor(this.maZ);
        addView(this.maF);
        addView(this.maG);
        addView(this.maH);
        addView(this.maI);
        addView(this.maJ);
        addView(this.maK);
        addView(this.maL);
        addView(this.maM);
        addView(this.maN);
        addView(this.maO);
        addView(this.maP);
        addView(this.maQ);
        addView(this.maR);
        addView(this.maS);
        addView(this.maT);
        addView(this.maU);
        addView(this.maV);
        post(new 1(this));
    }

    protected void onDraw(Canvas canvas) {
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.mba = getWidth();
        this.mbb = getHeight();
        int i5 = -this.maY;
        int i6 = (this.mbe - this.maY) + 1;
        int i7 = ((this.mbe * 2) - this.maY) + 2;
        int i8 = this.mbf + 2;
        int i9 = (this.mbf * 2) + 3;
        int i10 = (this.mbf * 3) + 4;
        this.maG.layout(i5, 1, this.mbc + i5, this.mbd + 1);
        this.maH.layout(i6, 1, this.mbc + i6, this.mbd + 1);
        this.maI.layout(i7, 1, this.mbc + i7, this.mbd + 1);
        this.maJ.layout(i5, i8, this.mbc + i5, this.mbd + i8);
        this.maK.layout(i6, i8, this.mbc + i6, this.mbd + i8);
        this.maL.layout(i7, i8, this.mbc + i7, this.mbd + i8);
        this.maM.layout(i5, i9, this.mbc + i5, this.mbd + i9);
        this.maN.layout(i6, i9, this.mbc + i6, this.mbd + i9);
        this.maO.layout(i7, i9, this.mbc + i7, this.mbd + i9);
        this.maF.layout(i6, i10, this.mbc + i6, this.mbd + i10);
        this.maP.layout(i7, i10, this.mbc + i7, this.mbd + i10);
        this.maQ.layout(0, this.maX + 1, this.mba, (this.maX + 1) + 1);
        this.maR.layout(0, this.maX + i8, this.mba, (i8 + this.maX) + 1);
        this.maS.layout(0, this.maX + i9, this.mba, (i9 + this.maX) + 1);
        this.maT.layout(0, this.maX + i10, this.mba, (this.maX + i10) + 1);
        this.maU.layout(this.mbe + 1, this.maX, this.mbe + 2, this.mbb);
        this.maV.layout((this.mbe * 2) + 2, this.maX, (this.mbe * 2) + 3, this.mbb);
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.mba = getWidth();
        this.mbb = getHeight();
        if (!(this.mba == 0 || this.mbb == 0)) {
            this.mbe = (this.mba - 2) / 3;
            this.mbf = ((this.mbb - this.maX) - 4) / 4;
            this.mbc = this.mbe + (this.maY * 2);
            this.mbd = this.mbf + (this.maX * 2);
        }
        this.maG.measure(MeasureSpec.makeMeasureSpec(this.mbc, 1073741824), MeasureSpec.makeMeasureSpec(this.mbd, 1073741824));
        this.maH.measure(MeasureSpec.makeMeasureSpec(this.mbc, 1073741824), MeasureSpec.makeMeasureSpec(this.mbd, 1073741824));
        this.maI.measure(MeasureSpec.makeMeasureSpec(this.mbc, 1073741824), MeasureSpec.makeMeasureSpec(this.mbd, 1073741824));
        this.maJ.measure(MeasureSpec.makeMeasureSpec(this.mbc, 1073741824), MeasureSpec.makeMeasureSpec(this.mbd, 1073741824));
        this.maK.measure(MeasureSpec.makeMeasureSpec(this.mbc, 1073741824), MeasureSpec.makeMeasureSpec(this.mbd, 1073741824));
        this.maL.measure(MeasureSpec.makeMeasureSpec(this.mbc, 1073741824), MeasureSpec.makeMeasureSpec(this.mbd, 1073741824));
        this.maM.measure(MeasureSpec.makeMeasureSpec(this.mbc, 1073741824), MeasureSpec.makeMeasureSpec(this.mbd, 1073741824));
        this.maN.measure(MeasureSpec.makeMeasureSpec(this.mbc, 1073741824), MeasureSpec.makeMeasureSpec(this.mbd, 1073741824));
        this.maO.measure(MeasureSpec.makeMeasureSpec(this.mbc, 1073741824), MeasureSpec.makeMeasureSpec(this.mbd, 1073741824));
        this.maF.measure(MeasureSpec.makeMeasureSpec(this.mbc, 1073741824), MeasureSpec.makeMeasureSpec(this.mbd, 1073741824));
        this.maP.measure(MeasureSpec.makeMeasureSpec(this.mbc, 1073741824), MeasureSpec.makeMeasureSpec(this.mbd, 1073741824));
        this.maQ.measure(MeasureSpec.makeMeasureSpec(this.mba, 1073741824), MeasureSpec.makeMeasureSpec(1, 1073741824));
        this.maR.measure(MeasureSpec.makeMeasureSpec(this.mba, 1073741824), MeasureSpec.makeMeasureSpec(1, 1073741824));
        this.maS.measure(MeasureSpec.makeMeasureSpec(this.mba, 1073741824), MeasureSpec.makeMeasureSpec(1, 1073741824));
        this.maT.measure(MeasureSpec.makeMeasureSpec(this.mba, 1073741824), MeasureSpec.makeMeasureSpec(1, 1073741824));
        this.maU.measure(MeasureSpec.makeMeasureSpec(1, 1073741824), MeasureSpec.makeMeasureSpec(this.mbb, 1073741824));
        this.maV.measure(MeasureSpec.makeMeasureSpec(1, 1073741824), MeasureSpec.makeMeasureSpec(this.mbb, 1073741824));
    }

    public void onClick(View view) {
        if (!this.maW) {
            x.d("MicroMsg.Facing.MMKeyBoardView", "onClick KeyBoard is disable.");
        } else if (view == this.maF) {
            input("0");
        } else if (view == this.maG) {
            input("1");
        } else if (view == this.maH) {
            input("2");
        } else if (view == this.maI) {
            input("3");
        } else if (view == this.maJ) {
            input("4");
        } else if (view == this.maK) {
            input("5");
        } else if (view == this.maL) {
            input("6");
        } else if (view == this.maM) {
            input("7");
        } else if (view == this.maN) {
            input("8");
        } else if (view == this.maO) {
            input("9");
        } else if (view == this.maP && this.mak != null && this.maW) {
            this.mak.delete();
        }
    }

    public boolean onLongClick(View view) {
        if (view == this.maP && this.mak != null && this.maW) {
            this.mak.aPm();
        }
        return false;
    }

    public void setKeyBoardEnable(boolean z) {
        this.maW = z;
        this.maF.setEnabled(z);
        this.maG.setEnabled(z);
        this.maH.setEnabled(z);
        this.maI.setEnabled(z);
        this.maJ.setEnabled(z);
        this.maK.setEnabled(z);
        this.maL.setEnabled(z);
        this.maM.setEnabled(z);
        this.maN.setEnabled(z);
        this.maO.setEnabled(z);
        this.maP.setEnabled(z);
    }

    public void setOnInputDeleteListener(a aVar) {
        this.mak = aVar;
    }

    private void input(String str) {
        if (this.mak != null && this.maW) {
            this.mak.input(str);
        }
    }
}

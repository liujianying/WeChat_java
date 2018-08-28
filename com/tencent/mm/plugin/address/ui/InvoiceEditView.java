package com.tencent.mm.plugin.address.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bp.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public class InvoiceEditView extends RelativeLayout implements OnFocusChangeListener {
    private int background;
    private OnFocusChangeListener eYB;
    private TextView eYC;
    EditText eYD;
    private ImageView eYE;
    private String eYF;
    private String eYG;
    private int eYH;
    private int eYI;
    public boolean eYJ;
    private int eYK;
    public boolean eYL;
    private int eYM;
    private int eYN;
    private boolean eYO;
    private OnClickListener eYP;
    private String eYQ;
    public boolean eYS;
    private a eYT;
    private c eYU;
    private b eYV;
    private int eYW;
    public boolean eYX;
    private int gravity;
    private int imeOptions;
    private int inputType;

    public InvoiceEditView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.eYS = false;
        this.eYF = "";
        this.eYG = "";
        this.inputType = 1;
        this.eYW = 0;
        this.gravity = 19;
        this.eYH = -1;
        this.background = -1;
        this.eYI = -1;
        this.eYJ = true;
        this.eYX = true;
        this.eYL = false;
        this.eYM = 0;
        this.eYN = 100;
        this.eYO = true;
        this.eYP = new OnClickListener() {
            public final void onClick(View view) {
                if (InvoiceEditView.this.eYE.getVisibility() == 0 && InvoiceEditView.this.eYJ && InvoiceEditView.this.eYH != 2 && !bi.oW(InvoiceEditView.this.getText())) {
                    InvoiceEditView.this.eYD.setText("");
                    InvoiceEditView.this.cp(InvoiceEditView.this.eYD.isFocused());
                }
            }
        };
        this.eYQ = null;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.n.InvoiceEditView, i, 0);
        int resourceId = obtainStyledAttributes.getResourceId(R.n.InvoiceEditView_invoice_hint, 0);
        if (resourceId != 0) {
            this.eYF = context.getString(resourceId);
        }
        resourceId = obtainStyledAttributes.getResourceId(R.n.InvoiceEditView_invoice_tipmsg, 0);
        if (resourceId != 0) {
            this.eYG = context.getString(resourceId);
        }
        this.inputType = obtainStyledAttributes.getInteger(R.n.InvoiceEditView_android_inputType, 1);
        this.eYH = obtainStyledAttributes.getInteger(R.n.InvoiceEditView_invoice_editType, 0);
        this.eYJ = obtainStyledAttributes.getBoolean(R.n.InvoiceEditView_invoice_editable, true);
        this.gravity = obtainStyledAttributes.getInt(R.n.InvoiceEditView_android_gravity, 19);
        this.imeOptions = obtainStyledAttributes.getInteger(R.n.InvoiceEditView_android_imeOptions, 5);
        this.background = obtainStyledAttributes.getResourceId(R.n.InvoiceEditView_android_background, R.g.transparent_background);
        this.eYK = obtainStyledAttributes.getResourceId(R.n.InvoiceEditView_invoice_infoBackground, -1);
        this.eYI = obtainStyledAttributes.getResourceId(R.n.InvoiceEditView_invoice_hintTextBg, R.g.transparent_background);
        this.eYO = obtainStyledAttributes.getBoolean(R.n.InvoiceEditView_invoice_singleLine, true);
        obtainStyledAttributes.recycle();
        View inflate = LayoutInflater.from(context).inflate(R.i.invoice_edit_view, this, true);
        this.eYD = (EditText) inflate.findViewById(R.h.hint_et);
        this.eYD.setTextSize(0, (float) a.ad(context, R.f.NormalTextSize));
        this.eYC = (TextView) inflate.findViewById(R.h.tip_tv);
        this.eYE = (ImageView) inflate.findViewById(R.h.info_iv);
        this.eYE.setOnClickListener(this.eYP);
        this.eYD.setImeOptions(this.imeOptions);
        this.eYD.setInputType(this.inputType);
        if (this.inputType == 2) {
            this.eYD.setKeyListener(new 1(this));
        } else if (this.inputType == 3) {
            this.eYD.setKeyListener(new 2(this));
        } else {
            this.eYD.setInputType(this.inputType);
        }
        cp(this.eYD.isFocused());
        this.eYD.addTextChangedListener(new 3(this));
        this.eYD.setOnFocusChangeListener(this);
        if (!bi.oW(this.eYF)) {
            this.eYD.setHint(this.eYF);
        }
        if (!bi.oW(this.eYG)) {
            this.eYC.setText(this.eYG);
        }
        Rect rect = new Rect();
        b(this.eYD, rect);
        if (this.eYJ) {
            this.eYL = false;
            this.eYD.setBackgroundResource(this.eYI);
            setBackgroundResource(this.background);
        } else {
            this.eYD.setEnabled(false);
            this.eYD.setTextColor(getResources().getColor(R.e.address_link_color));
            this.eYD.setFocusable(false);
            this.eYD.setClickable(false);
            this.eYD.setBackgroundResource(R.g.transparent_background);
            if (this.eYX) {
                setBackgroundResource(R.g.comm_list_item_selector);
            }
            setPadding(a.fromDPToPix(getContext(), 8), getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
        c(this.eYD, rect);
        if (this.eYK != -1) {
            this.eYE.setImageResource(this.eYK);
        }
        if (!this.eYO) {
            this.eYD.setSingleLine(false);
        }
    }

    public InvoiceEditView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void setOnInputValidChangeListener(c cVar) {
        this.eYU = cVar;
    }

    public void setOnInputInvoiceTypeChangeListener(b bVar) {
        this.eYV = bVar;
    }

    public String getText() {
        return this.eYD.getText().toString();
    }

    public void setEllipsize(TruncateAt truncateAt) {
        this.eYD.setEllipsize(truncateAt);
    }

    public void setEnabled(boolean z) {
        super.setEnabled(z);
        this.eYJ = z;
        this.eYE.setEnabled(true);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!this.eYJ) {
            boolean z = this.eYE.getVisibility() == 0 ? getValidRectOfInfoIv().contains((int) motionEvent.getX(), (int) motionEvent.getY()) : false;
            if (!z) {
                return true;
            }
        }
        return false;
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        super.setOnClickListener(onClickListener);
    }

    public final boolean ZF() {
        String obj = this.eYD.getText().toString();
        switch (this.eYH) {
            case 0:
                if (obj.length() < this.eYM || obj.length() > this.eYN) {
                    return false;
                }
                return true;
            case 1:
                if (obj.length() == 0) {
                    return true;
                }
                if (obj.length() < this.eYM || obj.length() > this.eYN) {
                    return false;
                }
                return true;
            case 4:
                if (obj.length() > 100) {
                    return false;
                }
                return true;
            case 5:
                if (obj.length() > 48) {
                    return false;
                }
                return true;
            default:
                if (obj.length() < this.eYM || obj.length() > this.eYN) {
                    return false;
                }
                return true;
        }
    }

    private void cp(boolean z) {
        if (!this.eYJ || bi.oW(getText())) {
            switch (this.eYH) {
                case 0:
                case 1:
                case 4:
                    this.eYE.setVisibility(8);
                    return;
                case 2:
                    this.eYE.setVisibility(0);
                    this.eYE.setContentDescription(getContext().getString(R.l.address_contact));
                    return;
                case 3:
                    this.eYE.setVisibility(0);
                    this.eYE.setContentDescription(getContext().getString(R.l.address_location));
                    return;
                default:
                    this.eYE.setVisibility(8);
                    return;
            }
        }
        this.eYE.setImageResource(R.g.list_clear);
        this.eYE.setContentDescription(getContext().getString(R.l.clear_btn));
        switch (this.eYH) {
            case 0:
            case 1:
            case 4:
            case 5:
                if (z) {
                    this.eYE.setVisibility(0);
                    return;
                } else {
                    this.eYE.setVisibility(8);
                    return;
                }
            case 2:
                this.eYE.setVisibility(0);
                this.eYE.setContentDescription(getContext().getString(R.l.address_contact));
                return;
            case 3:
                this.eYE.setVisibility(0);
                this.eYE.setContentDescription(getContext().getString(R.l.address_location));
                return;
            default:
                this.eYE.setVisibility(8);
                return;
        }
    }

    public void setOnFocusChangeListener(OnFocusChangeListener onFocusChangeListener) {
        super.setOnFocusChangeListener(onFocusChangeListener);
        this.eYB = onFocusChangeListener;
    }

    public void setInfoIvOnClickListener(a aVar) {
        this.eYT = aVar;
    }

    public void onFocusChange(View view, boolean z) {
        if (this.eYB != null) {
            this.eYB.onFocusChange(this, z);
        }
        x.d("MicroMsg.InvoiceEditView", "View:" + this.eYG + ", editType:" + this.eYH + " onFocusChange to " + z);
        if (this.eYU != null) {
            this.eYU.ZC();
        }
        if (this.eYL) {
            this.eYC.setEnabled(true);
        } else {
            this.eYC.setEnabled(false);
        }
        if (view == this.eYD) {
            Rect rect = new Rect();
            b(this, rect);
            if (z) {
                setBackgroundResource(R.g.input_bar_bg_active);
            } else {
                setBackgroundResource(R.g.input_bar_bg_normal);
            }
            c(this, rect);
        }
        cp(z);
    }

    public void setHintStr(String str) {
        this.eYD.setHint(str);
    }

    public void setTipStr(String str) {
        this.eYC.setText(str);
    }

    public void setValStr(String str) {
        this.eYD.setText(str);
        this.eYD.setSelection(this.eYD.getText().length());
        this.eYQ = str;
    }

    public void setBankNumberValStr(String str) {
        CharSequence str2;
        int i = 0;
        if (this.eYH == 5) {
            String replace = str2.replace(" ", "");
            if (replace.length() >= 4) {
                StringBuilder stringBuilder = new StringBuilder();
                if (replace.length() % 4 == 0) {
                    while (i < (replace.length() / 4) - 1) {
                        stringBuilder.append(replace.substring(i * 4, (i + 1) * 4)).append(" ");
                        i++;
                    }
                } else {
                    while (i < replace.length() / 4) {
                        stringBuilder.append(replace.substring(i * 4, (i + 1) * 4)).append(" ");
                        i++;
                    }
                    str2 = stringBuilder.append(replace.substring((replace.length() / 4) * 4, replace.length())).toString();
                }
            }
        }
        this.eYD.setText(str2);
        this.eYD.setSelection(this.eYD.getText().length());
    }

    public final boolean ZG() {
        if (getText().equals(bi.oV(this.eYQ))) {
            return false;
        }
        return true;
    }

    public void setEditBG(int i) {
        if (this.eYD != null) {
            Rect rect = new Rect();
            b(this.eYD, rect);
            this.eYD.setBackgroundResource(i);
            c(this.eYD, rect);
        }
    }

    public void setTipTextColor(int i) {
        if (this.eYC != null) {
            this.eYC.setTextColor(i);
        }
    }

    public void setImeOptions(int i) {
        this.eYD.setImeOptions(i);
    }

    public void setInfoIvVisible(int i) {
        this.eYE.setVisibility(i);
    }

    private Rect getValidRectOfInfoIv() {
        Rect rect = new Rect();
        this.eYE.getHitRect(rect);
        rect.left -= 50;
        rect.right += 50;
        rect.top -= 25;
        rect.bottom += 25;
        return rect;
    }

    private static void b(View view, Rect rect) {
        rect.left = view.getPaddingLeft();
        rect.right = view.getPaddingRight();
        rect.top = view.getPaddingTop();
        rect.bottom = view.getPaddingBottom();
    }

    private static void c(View view, Rect rect) {
        view.setPadding(rect.left, rect.top, rect.right, rect.bottom);
    }
}

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
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bp.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public class InvoiceQrcodeTextView extends RelativeLayout implements OnFocusChangeListener {
    private int background;
    private OnFocusChangeListener eYB;
    private TextView eYC;
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
    private int eYW;
    public boolean eYX;
    private a eZm;
    private c eZn;
    private b eZo;
    TextView eZp;
    private int gravity;
    private int imeOptions;
    private int inputType;

    public InvoiceQrcodeTextView(Context context, AttributeSet attributeSet, int i) {
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
                if (InvoiceQrcodeTextView.this.eYE.getVisibility() == 0 && InvoiceQrcodeTextView.this.eYJ && InvoiceQrcodeTextView.this.eYH != 2 && !bi.oW(InvoiceQrcodeTextView.this.getText())) {
                    InvoiceQrcodeTextView.this.eZp.setText("");
                    InvoiceQrcodeTextView.this.cp(InvoiceQrcodeTextView.this.eZp.isFocused());
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
        View inflate = LayoutInflater.from(context).inflate(R.i.invoice_qrcode_text_view, this, true);
        this.eZp = (TextView) inflate.findViewById(R.h.hint_et);
        this.eZp.setTextSize(0, (float) a.ad(context, R.f.NormalTextSize));
        this.eYC = (TextView) inflate.findViewById(R.h.tip_tv);
        this.eYE = (ImageView) inflate.findViewById(R.h.info_iv);
        this.eYE.setOnClickListener(this.eYP);
        this.eZp.setImeOptions(this.imeOptions);
        if (!bi.oW(this.eYF)) {
            this.eZp.setHint(this.eYF);
        }
        if (!bi.oW(this.eYG)) {
            this.eYC.setText(this.eYG);
        }
        Rect rect = new Rect();
        b(this.eZp, rect);
        c(this.eZp, rect);
        setPadding(a.fromDPToPix(getContext(), 8), getPaddingTop(), getPaddingRight(), getPaddingBottom());
        if (this.eYK != -1) {
            this.eYE.setImageResource(this.eYK);
        }
        if (!this.eYO) {
            this.eZp.setSingleLine(false);
        }
    }

    public InvoiceQrcodeTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public final void ZI() {
        setBackgroundResource(0);
        this.eYC.setTextColor(getResources().getColor(R.e.semitransparent));
        this.eZp.setTextColor(getResources().getColor(R.e.black));
        this.eZp.setInputType(0);
        this.eZp.clearFocus();
        this.eZp.setSingleLine(false);
        ((InputMethodManager) getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.eZp.getWindowToken(), 0);
    }

    public void setOnInputValidChangeListener(c cVar) {
        this.eZn = cVar;
    }

    public void setOnInputInvoiceTypeChangeListener(b bVar) {
        this.eZo = bVar;
    }

    public String getText() {
        return this.eZp.getText().toString();
    }

    public void setEllipsize(TruncateAt truncateAt) {
        this.eZp.setEllipsize(truncateAt);
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
        this.eZm = aVar;
    }

    public void onFocusChange(View view, boolean z) {
        if (this.eYB != null) {
            this.eYB.onFocusChange(this, z);
        }
        x.d("MicroMsg.InvoiceEditView", "View:" + this.eYG + ", editType:" + this.eYH + " onFocusChange to " + z);
        if (this.eYL) {
            this.eYC.setEnabled(true);
        } else {
            this.eYC.setEnabled(false);
        }
        if (view == this.eZp) {
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
        this.eZp.setHint(str);
    }

    public void setTipStr(String str) {
        this.eYC.setText(str);
    }

    public void setValStr(String str) {
        this.eZp.setText(str);
        this.eYQ = str;
    }

    public void setBankNumberValStr(String str) {
        CharSequence str2;
        if (this.eYH == 5) {
            String replace = str2.replace(" ", "");
            if (replace.length() >= 4) {
                StringBuilder stringBuilder = new StringBuilder();
                for (int i = 0; i < replace.length() / 4; i++) {
                    stringBuilder.append(replace.substring(i * 4, (i + 1) * 4)).append(" ");
                }
                str2 = stringBuilder.append(replace.substring((replace.length() / 4) * 4, replace.length())).toString();
            }
        }
        this.eZp.setText(str2);
    }

    public void setEditBG(int i) {
        if (this.eZp != null) {
            Rect rect = new Rect();
            b(this.eZp, rect);
            this.eZp.setBackgroundResource(i);
            c(this.eZp, rect);
        }
    }

    public void setTipTextColor(int i) {
        if (this.eYC != null) {
            this.eYC.setTextColor(i);
        }
    }

    public void setImeOptions(int i) {
        this.eZp.setImeOptions(i);
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

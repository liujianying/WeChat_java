package com.tencent.mm.ui.tools;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.KeyEvent.DispatcherState;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnKeyListener;
import android.view.ViewGroup.LayoutParams;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.widget.AutoMatchKeywordEditText;
import com.tencent.mm.w.a.e;
import com.tencent.mm.w.a.f;
import com.tencent.mm.w.a.g;
import com.tencent.mm.w.a.h;
import com.tencent.mm.w.a.k;
import java.util.ArrayList;

public class ActionBarSearchView extends LinearLayout implements e {
    private boolean mQO = false;
    private TextWatcher qME = new TextWatcher() {
        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            ActionBarSearchView.this.czs();
            s b = ActionBarSearchView.this.uvh;
            if (b.uCz) {
                EditText editText = (EditText) b.uCx.get();
                if (editText != null) {
                    if (((charSequence == null || charSequence.toString() == null || charSequence.toString().length() == 0) && (b.gEw == null || b.gEw.length() == 0)) || !(b.gEw == null || charSequence == null || !b.gEw.equals(charSequence.toString()))) {
                        x.d("MicroMsg.WordsChecker", "text not change, new : %s, old : %s", charSequence, b.gEw);
                    } else {
                        b.gEw = charSequence != null ? charSequence.toString() : "";
                        b.uCw = s.k(b.gEw, b.uCy);
                        if (s.a(editText, b.uCy)) {
                            x.d("MicroMsg.WordsChecker", "decorate text succ.");
                        }
                    }
                }
            }
            if (ActionBarSearchView.this.uvi != null) {
                ActionBarSearchView.this.uvi.FW(charSequence == null ? "" : charSequence.toString());
            }
        }

        public final void afterTextChanged(Editable editable) {
        }
    };
    private View uvc;
    private ActionBarEditText uvd;
    private ImageButton uve;
    private int uvf = c.uvq;
    private boolean uvg = false;
    private s uvh;
    private b uvi;
    private a uvj;
    private OnFocusChangeListener uvk = new OnFocusChangeListener() {
        public final void onFocusChange(View view, boolean z) {
            x.v("MicroMsg.ActionBarSearchView", "on edittext focus changed, hasFocus %B", Boolean.valueOf(z));
            if (ActionBarSearchView.this.uvl != null) {
                ActionBarSearchView.this.uvl.onFocusChange(view, z);
            }
        }
    };
    private OnFocusChangeListener uvl;
    private OnClickListener uvm = new OnClickListener() {
        public final void onClick(View view) {
            if (c.uvq == ActionBarSearchView.this.uvf) {
                x.d("MicroMsg.ActionBarSearchView", "on status btn click, cur status is clear");
                ActionBarSearchView.this.mt(true);
                if (ActionBarSearchView.this.uvi != null) {
                    ActionBarSearchView.this.uvi.WY();
                    return;
                }
                return;
            }
            x.d("MicroMsg.ActionBarSearchView", "on status btn click, cur status is voice search");
            if (ActionBarSearchView.this.uvi != null) {
                ActionBarSearchView.this.uvi.bad();
            }
        }
    };
    private OnClickListener uvn = new OnClickListener() {
        public final void onClick(View view) {
            if (ActionBarSearchView.this.uvj != null) {
                ActionBarSearchView.this.uvj.bae();
            }
        }
    };

    public interface a {
        void bae();
    }

    public interface b {
        void FW(String str);

        void WY();

        void bac();

        void bad();
    }

    private enum c {
        ;

        static {
            uvq = 1;
            uvr = 2;
            uvs = new int[]{uvq, uvr};
        }
    }

    class d extends Drawable {
        private RectF cP;
        private String gEw;
        private Paint uvt;
        private int uvu = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.b(ad.getContext(), 2.0f);
        private float uvv;
        private float uvw;

        d(EditText editText, String str) {
            this.uvt = new Paint(editText.getPaint());
            this.gEw = str;
            this.uvt.setColor(ad.getResources().getColor(com.tencent.mm.w.a.d.green_text_color));
            this.uvv = this.uvt.measureText(this.gEw);
            FontMetrics fontMetrics = this.uvt.getFontMetrics();
            this.uvw = (float) Math.ceil((double) (fontMetrics.bottom - fontMetrics.top));
            setBounds(0, 0, (int) (((this.uvv + ((float) (this.uvu * 2))) + ((float) (this.uvu * 2))) + 2.0f), (int) this.uvw);
        }

        public final void draw(Canvas canvas) {
            FontMetricsInt fontMetricsInt = this.uvt.getFontMetricsInt();
            Rect bounds = getBounds();
            int i = bounds.right;
            i = bounds.left;
            float f = this.cP.right;
            f = this.cP.left;
            canvas.drawText(this.gEw, (float) (bounds.left + 2), (float) ((bounds.top + ((((bounds.bottom - bounds.top) - fontMetricsInt.bottom) + fontMetricsInt.top) / 2)) - fontMetricsInt.top), this.uvt);
        }

        public final void setBounds(int i, int i2, int i3, int i4) {
            super.setBounds(i, i2, i3, i4);
            FontMetrics fontMetrics = this.uvt.getFontMetrics();
            this.cP = new RectF((float) (this.uvu + i), (fontMetrics.ascent - fontMetrics.top) + ((float) i2), (float) (i3 - this.uvu), (float) i4);
            invalidateSelf();
        }

        public final void setAlpha(int i) {
        }

        public final void setColorFilter(ColorFilter colorFilter) {
        }

        public final int getOpacity() {
            return -3;
        }
    }

    public static class ActionBarEditText extends AutoMatchKeywordEditText {
        private ActionBarSearchView uvp;

        public ActionBarEditText(Context context, AttributeSet attributeSet, int i) {
            super(context, attributeSet, i);
        }

        public ActionBarEditText(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public void setSearchView(ActionBarSearchView actionBarSearchView) {
            this.uvp = actionBarSearchView;
        }

        public boolean onKeyPreIme(int i, KeyEvent keyEvent) {
            x.v("MicroMsg.ActionBarSearchView", "on onKeyPreIme");
            if (i == 4) {
                DispatcherState keyDispatcherState;
                if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                    x.v("MicroMsg.ActionBarSearchView", "on onKeyPreIme action down");
                    keyDispatcherState = getKeyDispatcherState();
                    if (keyDispatcherState != null) {
                        keyDispatcherState.startTracking(keyEvent, this);
                    }
                    return true;
                } else if (keyEvent.getAction() == 1) {
                    x.v("MicroMsg.ActionBarSearchView", "on onKeyPreIme action up");
                    keyDispatcherState = getKeyDispatcherState();
                    if (keyDispatcherState != null) {
                        keyDispatcherState.handleUpEvent(keyEvent);
                    }
                    if (keyEvent.isTracking() && !keyEvent.isCanceled()) {
                        x.v("MicroMsg.ActionBarSearchView", "on onKeyPreIme action up is tracking");
                        this.uvp.clearFocus();
                        InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
                        if (inputMethodManager != null) {
                            inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
                        }
                        return true;
                    }
                }
            }
            return super.onKeyPreIme(i, keyEvent);
        }
    }

    public void setFocusChangeListener(OnFocusChangeListener onFocusChangeListener) {
        this.uvl = onFocusChangeListener;
    }

    public ActionBarSearchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public ActionBarSearchView(Context context) {
        super(context);
        init();
    }

    private void init() {
        ((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(h.actionbar_searchview, this, true);
        this.uvc = findViewById(g.ab_back_container);
        this.uvc.setOnClickListener(this.uvn);
        this.uvd = (ActionBarEditText) findViewById(g.edittext);
        this.uvh = new s(this.uvd);
        this.uvd.setSearchView(this);
        this.uvd.post(new Runnable() {
            public final void run() {
                ActionBarSearchView.this.uvd.setText("");
                if (ActionBarSearchView.this.uvi != null) {
                    ActionBarSearchView.this.uvi.bac();
                }
            }
        });
        this.uve = (ImageButton) findViewById(g.status_btn);
        this.uvd.addTextChangedListener(this.qME);
        this.uvd.setOnKeyListener(new OnKeyListener() {
            public final boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (i != 67) {
                    return false;
                }
                x.d("MicroMsg.ActionBarSearchView", "on back key click.");
                s b = ActionBarSearchView.this.uvh;
                if (b.uCz) {
                    EditText editText = (EditText) b.uCx.get();
                    if (!(editText == null || b.uCw == null)) {
                        CharSequence text = editText.getText();
                        int selectionStart = editText.getSelectionStart();
                        if (selectionStart == editText.getSelectionEnd()) {
                            b Gg = b.Gg(selectionStart);
                            if (Gg != null && Gg.uCC) {
                                text.delete(Gg.start, Gg.start + Gg.length);
                                editText.setTextKeepState(text);
                                editText.setSelection(Gg.start);
                                return true;
                            }
                        }
                        return false;
                    }
                }
                return false;
            }
        });
        this.uvd.setOnSelectionChangeListener(new com.tencent.mm.ui.widget.AutoMatchKeywordEditText.a() {
            public final void b(EditText editText, int i, int i2) {
                x.d("MicroMsg.ActionBarSearchView", "start : %d, stop : %d", Integer.valueOf(i), Integer.valueOf(i2));
                s b = ActionBarSearchView.this.uvh;
                if (b.uCz) {
                    EditText editText2 = (EditText) b.uCx.get();
                    if (editText2 != null && editText == editText2) {
                        CharSequence text = editText2.getText();
                        int selectionStart = editText2.getSelectionStart();
                        int selectionEnd = editText2.getSelectionEnd();
                        if (selectionStart >= 0 && selectionEnd >= selectionStart) {
                            if (selectionStart == selectionEnd) {
                                b Gg = b.Gg(selectionStart);
                                if (Gg != null && Gg.uCC) {
                                    editText2.setTextKeepState(text);
                                    editText2.setSelection(Gg.length + Gg.start);
                                    return;
                                }
                                return;
                            }
                            b Gg2 = b.Gg(selectionStart);
                            if (Gg2 != null && Gg2.uCC) {
                                selectionStart = Gg2.start + Gg2.length;
                            }
                            if (selectionStart >= selectionEnd) {
                                editText2.setTextKeepState(text);
                                editText2.setSelection(selectionStart);
                                return;
                            }
                            b Gg3 = b.Gg(selectionEnd);
                            if (Gg3 != null && Gg3.uCC) {
                                int i3 = Gg3.start;
                                editText2.setTextKeepState(text);
                                editText2.setSelection(selectionStart, i3);
                            }
                        }
                    }
                }
            }
        });
        this.uvd.setOnFocusChangeListener(this.uvk);
        com.tencent.mm.ui.tools.a.c.d(this.uvd).Gi(100).a(null);
        this.uve.setOnClickListener(this.uvm);
    }

    public String getSearchContent() {
        if (this.uvd.getEditableText() != null) {
            return this.uvd.getEditableText().toString();
        }
        return "";
    }

    public void setCallBack(b bVar) {
        this.uvi = bVar;
    }

    public void setBackClickCallback(a aVar) {
        this.uvj = aVar;
    }

    public void setSearchContent(String str) {
        Object str2;
        if (str2 == null) {
            str2 = "";
        }
        this.uvd.setText(str2);
        this.uvd.setSelection(str2.length());
    }

    public void setHint(CharSequence charSequence) {
        this.uvd.setHint(charSequence);
    }

    public final void ms(boolean z) {
        this.uvg = z;
        czs();
    }

    public void setEditTextEnabled(boolean z) {
        this.uvd.setEnabled(z);
    }

    public void setStatusBtnEnabled(boolean z) {
        this.uve.setEnabled(z);
    }

    private void ff(int i, int i2) {
        this.uve.setImageResource(i);
        this.uve.setBackgroundResource(0);
        if (i == f.voicesearch_enter_btn) {
            this.uve.setContentDescription(getContext().getString(k.voice_Input));
        } else {
            this.uve.setContentDescription(getContext().getString(k.clear_btn));
        }
        LayoutParams layoutParams = this.uve.getLayoutParams();
        layoutParams.width = i2;
        this.uve.setLayoutParams(layoutParams);
    }

    private void czs() {
        if (this.uvd.getEditableText() != null && !bi.oW(this.uvd.getEditableText().toString())) {
            ff(f.search_clear, getResources().getDimensionPixelSize(e.NormalIconSize));
            this.uvf = c.uvq;
        } else if (this.uvg) {
            ff(f.voicesearch_enter_btn, getResources().getDimensionPixelSize(e.NormalIconSize));
            this.uvf = c.uvr;
        } else {
            ff(0, 0);
            this.uvf = c.uvq;
        }
    }

    public void setOnEditorActionListener(OnEditorActionListener onEditorActionListener) {
        this.uvd.setOnEditorActionListener(onEditorActionListener);
    }

    public final void mt(boolean z) {
        if (z) {
            this.uvd.setText("");
            return;
        }
        this.uvd.removeTextChangedListener(this.qME);
        this.uvd.setText("");
        this.uvd.addTextChangedListener(this.qME);
    }

    public final void czt() {
        this.uvd.clearFocus();
    }

    public void setNotRealCallBack(com.tencent.mm.ui.tools.SearchViewNotRealTimeHelper.a aVar) {
    }

    public final boolean czu() {
        if (this.uvd != null) {
            return this.uvd.hasFocus();
        }
        return false;
    }

    public final boolean czv() {
        if (this.uvd != null) {
            return this.uvd.requestFocus();
        }
        return false;
    }

    public void setEditTextClickListener(OnClickListener onClickListener) {
        if (this.uvd != null) {
            this.uvd.setFocusable(false);
            this.uvd.setOnClickListener(onClickListener);
        }
    }

    public void setKeywords(ArrayList<String> arrayList) {
        if (this.uvh != null) {
            s sVar = this.uvh;
            sVar.uCy = arrayList;
            if (sVar.uCz) {
                EditText editText = (EditText) sVar.uCx.get();
                if (editText != null) {
                    s.a(editText, sVar.uCy);
                }
            }
        }
    }

    public void setAutoMatchKeywords(boolean z) {
        if (this.uvh != null) {
            this.uvh.uCz = z;
        }
    }

    public void setSearchTipIcon(int i) {
        if (this.uvd != null) {
            this.uvd.setCompoundDrawables(ad.getResources().getDrawable(i), null, null, null);
        }
    }

    public void setSelectedTag(String str) {
        if (this.uvd != null) {
            this.uvd.setCompoundDrawables(new d(this.uvd, str), null, null, null);
            this.uvd.setHint("");
        }
    }
}

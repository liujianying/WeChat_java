package com.tencent.mm.ui.widget;

import android.content.Context;
import android.graphics.Rect;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.KeyEvent.DispatcherState;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.widget.edittext.PasterEditText;

public class MMEditText extends PasterEditText {
    int qrg = 0;
    private InputConnection uGh;
    private a uGi;

    public interface a {
        void bbt();
    }

    public interface b {
        void Yr();
    }

    public static class c implements TextWatcher {
        private final int limit;
        private EditText meN;
        private TextView uGj;
        public b uGk = null;
        private boolean uGl = false;

        public c(EditText editText, TextView textView, int i) {
            this.meN = editText;
            this.uGj = textView;
            this.limit = i;
        }

        public final void afterTextChanged(Editable editable) {
            int i;
            int i2 = 0;
            String obj = editable.toString();
            CharSequence charSequence = "";
            int i3 = 0;
            for (i = 0; i < obj.length(); i++) {
                if (bi.n(obj.charAt(i))) {
                    i3 += 2;
                } else {
                    i3++;
                }
                if (i3 > this.limit) {
                    break;
                }
                charSequence = charSequence + obj.charAt(i);
            }
            if (i3 > this.limit) {
                try {
                    this.meN.setText(charSequence);
                    if (this.uGl) {
                        this.meN.setSelection(0);
                    } else {
                        this.meN.setSelection(this.meN.getText().toString().length());
                    }
                    this.uGl = false;
                } catch (Exception e) {
                    this.uGl = true;
                    x.e("MicroMsg.MMEditText", "error " + e.getMessage());
                    this.meN.setText(charSequence);
                    this.meN.setSelection(0);
                }
            }
            i = this.limit - i3;
            if (i >= 0) {
                i2 = i;
            }
            if (this.uGj != null) {
                this.uGj.setText((i2 / 2));
            }
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if (this.uGk != null) {
                this.uGk.Yr();
            }
        }
    }

    public MMEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        this.uGh = super.onCreateInputConnection(editorInfo);
        return this.uGh;
    }

    public InputConnection getInputConnection() {
        return this.uGh;
    }

    public MMEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public final void abr(String str) {
        getContext();
        int bd = com.tencent.mm.ui.e.c.b.bd(getText().toString(), getSelectionStart());
        getContext();
        int bd2 = com.tencent.mm.ui.e.c.b.bd(getText().toString(), getSelectionEnd());
        StringBuffer stringBuffer = new StringBuffer(getText());
        setText(com.tencent.mm.ui.e.c.b.d(getContext(), stringBuffer.substring(0, bd) + str + stringBuffer.substring(bd2, stringBuffer.length()), getTextSize()));
        setSelection(bd + str.length());
    }

    public boolean requestFocus(int i, Rect rect) {
        return super.requestFocus(i, rect);
    }

    public void setSelection(int i) {
        super.setSelection(i);
    }

    public void setSelection(int i, int i2) {
        super.setSelection(i, i2);
    }

    public boolean onTextContextMenuItem(int i) {
        boolean onTextContextMenuItem;
        try {
            onTextContextMenuItem = super.onTextContextMenuItem(i);
        } catch (IndexOutOfBoundsException e) {
            x.e("MicroMsg.MMEditText", "!!MMEditText IndexOutOfBoundsException %s", e);
            onTextContextMenuItem = false;
        } catch (NullPointerException e2) {
            x.e("MicroMsg.MMEditText", "!!MMEditText NullPointerException %s", e2);
            return false;
        }
        if (i == 16908322) {
            this.qrg = 0;
            String obj = getText().toString();
            try {
                Tx(obj);
            } catch (IndexOutOfBoundsException e3) {
                x.e("MicroMsg.MMEditText", "!!MMEditText Exception %d", Integer.valueOf(this.qrg));
                if (this.qrg < 3) {
                    this.qrg++;
                    Tx(" " + obj);
                } else {
                    throw e3;
                }
            }
        }
        return onTextContextMenuItem;
    }

    private void Tx(String str) {
        int selectionStart = getSelectionStart();
        setText(com.tencent.mm.ui.e.c.b.d(getContext(), str, getTextSize()));
        int length = getText().length() - str.length();
        if (length > 0) {
            selectionStart += length;
            if (selectionStart <= getText().length()) {
                setSelection(selectionStart);
                return;
            }
            return;
        }
        setSelection(selectionStart);
    }

    public void setBackListener(a aVar) {
        this.uGi = aVar;
    }

    public boolean onKeyPreIme(int i, KeyEvent keyEvent) {
        String str = "MicroMsg.MMEditText";
        String str2 = "on onKeyPreIme, listener null ? %B";
        Object[] objArr = new Object[1];
        objArr[0] = Boolean.valueOf(this.uGi == null);
        x.v(str, str2, objArr);
        if (this.uGi != null && i == 4) {
            DispatcherState keyDispatcherState;
            if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                x.v("MicroMsg.MMEditText", "on onKeyPreIme action down");
                keyDispatcherState = getKeyDispatcherState();
                if (keyDispatcherState == null) {
                    return true;
                }
                keyDispatcherState.startTracking(keyEvent, this);
                return true;
            } else if (keyEvent.getAction() == 1) {
                x.v("MicroMsg.MMEditText", "on onKeyPreIme action up");
                keyDispatcherState = getKeyDispatcherState();
                if (keyDispatcherState != null) {
                    keyDispatcherState.handleUpEvent(keyEvent);
                }
                if (keyEvent.isTracking() && !keyEvent.isCanceled()) {
                    x.v("MicroMsg.MMEditText", "on onKeyPreIme action up is tracking");
                    this.uGi.bbt();
                    InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
                    if (inputMethodManager == null) {
                        return true;
                    }
                    inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
                    return true;
                }
            }
        }
        return super.onKeyPreIme(i, keyEvent);
    }
}

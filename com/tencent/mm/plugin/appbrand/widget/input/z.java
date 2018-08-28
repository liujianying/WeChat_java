package com.tencent.mm.plugin.appbrand.widget.input;

import android.content.Context;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.widget.input.autofill.b;

public interface z {
    void D(float f, float f2);

    void a(OnFocusChangeListener onFocusChangeListener);

    void a(a aVar);

    void a(c cVar);

    void addTextChangedListener(TextWatcher textWatcher);

    void apM();

    void apN();

    void apO();

    boolean apv();

    boolean apw();

    boolean apz();

    void b(OnFocusChangeListener onFocusChangeListener);

    void destroy();

    b getAutoFillController();

    Context getContext();

    int getInputId();

    View getInputPanel();

    char getLastKeyPressed();

    CharSequence getText();

    View getView();

    int mf(int i);

    void r(p pVar);

    void s(p pVar);

    void setFixed(boolean z);

    void setInputId(int i);

    void setOnKeyUpPostImeListener(b bVar);
}

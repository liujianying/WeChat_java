package com.tencent.mm.plugin.webview.ui.tools.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ui.MMActivity;

public class WebViewSearchContentInputFooter extends LinearLayout {
    private View qlq;
    private EditText qlr;
    private View qls;
    private View qlt;
    private View qlu;
    private TextView qlv;
    private a qlw;

    public WebViewSearchContentInputFooter(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public WebViewSearchContentInputFooter(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        View inflate = inflate(getContext(), R.i.webview_search_content_input_footer, this);
        this.qlr = (EditText) inflate.findViewById(R.h.edittext);
        this.qls = inflate.findViewById(R.h.close_btn);
        this.qlt = inflate.findViewById(R.h.pre_word_v);
        this.qlu = inflate.findViewById(R.h.next_word_v);
        this.qlv = (TextView) inflate.findViewById(R.h.index_tv);
        this.qlq = inflate.findViewById(R.h.input_footer_container);
        this.qls.setOnClickListener(new 1(this));
        this.qlt.setOnClickListener(new 2(this));
        this.qlu.setOnClickListener(new 3(this));
        this.qlr.setOnKeyListener(new 4(this));
        this.qlr.setOnFocusChangeListener(new 5(this));
        this.qlr.addTextChangedListener(new 6(this));
        this.qlr.setSelectAllOnFocus(true);
        reset();
    }

    public final void reset() {
        this.qlv.setText("");
        this.qlt.setEnabled(false);
        this.qlu.setEnabled(false);
    }

    public final void bYy() {
        this.qlr.setText("");
    }

    public boolean isShown() {
        return getVisibility() == 0;
    }

    public final void show() {
        setVisibility(0);
        if (this.qlw != null) {
            this.qlw.onShow();
        }
        this.qlr.requestFocus();
        postDelayed(new 7(this), 100);
    }

    public final void hide() {
        Context context = this.qlr.getContext();
        if (context instanceof MMActivity) {
            ((MMActivity) context).hideVKB(this.qlr);
        }
        this.qlr.clearFocus();
        setVisibility(8);
        if (this.qlw != null) {
            this.qlw.aSZ();
        }
    }

    public final void q(int i, int i2, boolean z) {
        boolean z2 = true;
        if (z) {
            boolean z3;
            TextView textView = this.qlv;
            String str = "%d/%d";
            Object[] objArr = new Object[2];
            objArr[0] = Integer.valueOf(i2 == 0 ? 0 : i + 1);
            objArr[1] = Integer.valueOf(i2);
            textView.setText(String.format(str, objArr));
            View view = this.qlu;
            if (i2 > 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            view.setEnabled(z3);
            View view2 = this.qlt;
            if (i2 <= 0) {
                z2 = false;
            }
            view2.setEnabled(z2);
        }
    }

    public void setActionDelegate(a aVar) {
        this.qlw = aVar;
    }

    public String getSearchContent() {
        return this.qlr.getText().toString();
    }
}

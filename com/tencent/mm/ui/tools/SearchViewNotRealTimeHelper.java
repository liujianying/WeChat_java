package com.tencent.mm.ui.tools;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.tools.ActionBarSearchView.b;
import com.tencent.mm.ui.tools.a.c;
import com.tencent.mm.ui.y;
import com.tencent.mm.w.a.g;
import com.tencent.mm.w.a.h;
import java.util.ArrayList;

public class SearchViewNotRealTimeHelper extends LinearLayout implements e {
    private EditText jzo;
    public Button uBI;
    private a uBJ;
    private View uvc;
    private ImageButton uve;
    private com.tencent.mm.ui.tools.ActionBarSearchView.a uvj;

    public interface a {
        void ava();

        boolean pj(String str);

        void wY(String str);
    }

    public SearchViewNotRealTimeHelper(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public SearchViewNotRealTimeHelper(Context context) {
        super(context);
        init();
    }

    private void init() {
        y.gq(getContext()).inflate(h.actionbar_searchview_with_searchbtn, this, true);
        this.jzo = (EditText) findViewById(g.edittext);
        this.uve = (ImageButton) findViewById(g.status_btn);
        this.uvc = findViewById(g.ab_back_container);
        this.uBI = (Button) findViewById(g.button);
        this.uBI.setEnabled(false);
        this.jzo.addTextChangedListener(new TextWatcher() {
            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void afterTextChanged(Editable editable) {
                if (editable == null || editable.length() <= 0) {
                    SearchViewNotRealTimeHelper.this.uve.setVisibility(8);
                    SearchViewNotRealTimeHelper.this.uBI.setEnabled(false);
                    return;
                }
                SearchViewNotRealTimeHelper.this.uve.setVisibility(0);
                SearchViewNotRealTimeHelper.this.uBI.setEnabled(true);
            }
        });
        this.jzo.setOnEditorActionListener(new OnEditorActionListener() {
            public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (3 != i || SearchViewNotRealTimeHelper.this.uBJ == null) {
                    return false;
                }
                return SearchViewNotRealTimeHelper.this.uBJ.pj(SearchViewNotRealTimeHelper.this.getSearchContent());
            }
        });
        c.d(this.jzo).Gi(100).a(null);
        this.uve.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                SearchViewNotRealTimeHelper.this.jzo.setText("");
                if (SearchViewNotRealTimeHelper.this.uBJ != null) {
                    SearchViewNotRealTimeHelper.this.uBJ.ava();
                }
            }
        });
        this.uvc.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                x.v("MicroMsg.SearchViewNotRealTimeHelper", "home btn click");
                if (SearchViewNotRealTimeHelper.this.uvj != null) {
                    SearchViewNotRealTimeHelper.this.uvj.bae();
                }
            }
        });
        this.uBI.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                if (SearchViewNotRealTimeHelper.this.uBJ != null) {
                    SearchViewNotRealTimeHelper.this.uBJ.wY(SearchViewNotRealTimeHelper.this.getSearchContent());
                }
            }
        });
    }

    public void setSearchBtnText(CharSequence charSequence) {
        this.uBI.setText(charSequence);
    }

    public void setSearchContent(CharSequence charSequence) {
        this.jzo.setText("");
        this.jzo.append(charSequence);
    }

    public void setSearchColor(int i) {
        this.jzo.setTextColor(i);
    }

    public void setSearchHint(CharSequence charSequence) {
        this.jzo.setHint(charSequence);
    }

    public void setSearchHintColor(int i) {
        this.jzo.setHintTextColor(i);
    }

    public void setSearchIcon(int i) {
        this.jzo.setCompoundDrawablesWithIntrinsicBounds(i, 0, 0, 0);
    }

    public void setShowBackIcon(boolean z) {
        if (this.uvc == null) {
            return;
        }
        if (z) {
            this.uvc.setVisibility(0);
        } else {
            this.uvc.setVisibility(8);
        }
    }

    public final void mt(boolean z) {
        this.jzo.setText("");
    }

    public final void czt() {
        this.jzo.clearFocus();
    }

    public void setCallBack(a aVar) {
        this.uBJ = aVar;
    }

    public String getSearchContent() {
        Editable editableText = this.jzo.getEditableText();
        return editableText == null ? "" : editableText.toString();
    }

    public void setSearchContent(String str) {
        setSearchContent((CharSequence) str);
    }

    public void setHint(CharSequence charSequence) {
        setSearchHint(charSequence);
    }

    public void setCallBack(b bVar) {
    }

    public final void ms(boolean z) {
    }

    public void setEditTextEnabled(boolean z) {
    }

    public void setStatusBtnEnabled(boolean z) {
    }

    public void setOnEditorActionListener(OnEditorActionListener onEditorActionListener) {
    }

    public void setNotRealCallBack(a aVar) {
        this.uBJ = aVar;
    }

    public boolean hasFocus() {
        return false;
    }

    public final boolean czv() {
        return false;
    }

    public final boolean czu() {
        return false;
    }

    public void setBackClickCallback(com.tencent.mm.ui.tools.ActionBarSearchView.a aVar) {
        this.uvj = aVar;
    }

    public void setKeywords(ArrayList<String> arrayList) {
    }

    public void setAutoMatchKeywords(boolean z) {
    }

    public void setSearchTipIcon(int i) {
    }

    public void setFocusChangeListener(OnFocusChangeListener onFocusChangeListener) {
    }

    public void setSelectedTag(String str) {
    }
}

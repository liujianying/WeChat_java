package com.tencent.mm.plugin.fts.ui.widget;

import android.content.Context;
import android.text.Editable;
import android.text.Selection;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.bp.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.tools.a.c;
import com.tencent.mm.w.a.e;
import com.tencent.mm.w.a.g;
import com.tencent.mm.w.a.h;
import java.util.ArrayList;
import java.util.List;

public class FTSEditTextView extends LinearLayout {
    private String eVC;
    private ImageView gmn;
    public ImageButton jfw;
    public EditText jzo;
    private List<com.tencent.mm.plugin.fts.ui.widget.a.b> jzp;
    private TextView jzq;
    private TextView jzr;
    private TextView jzs;
    private View jzt;
    private boolean jzu = true;
    private String jzv = "";
    private OnClickListener jzw = new 6(this);
    private a jzx;
    private b jzy = b.UserInput;
    public OnFocusChangeListener jzz = new 7(this);

    public enum b {
        UserInput,
        ClearText,
        SetText
    }

    static /* synthetic */ void e(FTSEditTextView fTSEditTextView) {
        String inEditTextQuery = fTSEditTextView.getInEditTextQuery();
        if (fTSEditTextView.jzx != null) {
            fTSEditTextView.jzx.a(fTSEditTextView.getTotalQuery(), inEditTextQuery, fTSEditTextView.jzp, fTSEditTextView.jzy);
        }
        if (inEditTextQuery.length() == 0) {
            fTSEditTextView.jzo.setHint(fTSEditTextView.eVC);
        }
        if (inEditTextQuery.length() > 0 || fTSEditTextView.jzp.size() > 0) {
            fTSEditTextView.jfw.setVisibility(0);
        } else {
            fTSEditTextView.jfw.setVisibility(8);
        }
    }

    public FTSEditTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public FTSEditTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    public void aQS() {
        ((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(h.fts_edittext_view, this, true);
    }

    public void init() {
        aQS();
        this.jzt = findViewById(g.tag_panel);
        this.gmn = (ImageView) findViewById(g.icon);
        this.jzo = (EditText) findViewById(g.edittext);
        this.jfw = (ImageButton) findViewById(g.clear_btn);
        this.jzq = (TextView) findViewById(g.tag_1);
        this.jzr = (TextView) findViewById(g.tag_2);
        this.jzs = (TextView) findViewById(g.tag_3);
        this.jzp = new ArrayList();
        this.jzo.setOnKeyListener(new 1(this));
        this.jzo.addTextChangedListener(new TextWatcher() {
            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                String totalQuery = FTSEditTextView.this.getTotalQuery();
                if (totalQuery != FTSEditTextView.this.jzv && !totalQuery.equals(FTSEditTextView.this.jzv)) {
                    FTSEditTextView.this.jzv = totalQuery;
                    if (totalQuery.length() > 0) {
                        FTSEditTextView.this.jfw.setVisibility(0);
                    } else {
                        FTSEditTextView.this.jfw.setVisibility(8);
                    }
                    FTSEditTextView.e(FTSEditTextView.this);
                }
            }

            public final void afterTextChanged(Editable editable) {
            }
        });
        this.jzo.setOnFocusChangeListener(this.jzz);
        this.jzo.setOnEditorActionListener(new 3(this));
        this.jzq.setOnClickListener(this.jzw);
        this.jzr.setOnClickListener(this.jzw);
        this.jzs.setOnClickListener(this.jzw);
        this.jfw.setOnClickListener(new 4(this));
        c.d(this.jzo).Gi(100).a(null);
    }

    public final void clearText() {
        this.jzy = b.ClearText;
        if (this.jzu) {
            this.jzp.clear();
        }
        this.jzo.setText("");
        this.jzo.setHint(this.eVC);
        this.jfw.setVisibility(8);
        aQV();
        this.jzy = b.UserInput;
    }

    public final void aQT() {
        postDelayed(new 5(this), 128);
    }

    public final void j(String str, List<com.tencent.mm.plugin.fts.ui.widget.a.b> list) {
        b bVar = b.UserInput;
        this.jzp.clear();
        if (list != null) {
            this.jzp.addAll(list);
        }
        x.i("MicroMsg.FTS.FTSEditTextView", "setText: %s %d", new Object[]{str, Integer.valueOf(this.jzp.size())});
        this.jzy = b.SetText;
        this.jzo.setText(str);
        Selection.setSelection(this.jzo.getText(), this.jzo.getText().length());
        aQV();
        this.jzy = bVar;
    }

    public final void aQU() {
        this.jzo.requestFocus();
    }

    public List<com.tencent.mm.plugin.fts.ui.widget.a.b> getTagList() {
        return this.jzp;
    }

    public void setHint(String str) {
        this.jzo.setHint(str);
        this.eVC = str;
    }

    private void aQV() {
        x.i("MicroMsg.FTS.FTSEditTextView", "updateTagView %s", new Object[]{Integer.valueOf(this.jzp.size())});
        float ad = (float) a.ad(getContext(), e.NormalTextSize);
        if (this.jzp.size() > 0) {
            this.jzq.setVisibility(0);
            this.jzq.setText(com.tencent.mm.ui.e.c.b.d(getContext(), ((com.tencent.mm.plugin.fts.ui.widget.a.b) this.jzp.get(0)).getTagName(), ad));
        } else {
            this.jzq.setVisibility(8);
        }
        if (this.jzp.size() >= 2) {
            this.jzr.setVisibility(0);
            this.jzr.setText(com.tencent.mm.ui.e.c.b.d(getContext(), ((com.tencent.mm.plugin.fts.ui.widget.a.b) this.jzp.get(1)).getTagName(), ad));
        } else {
            this.jzr.setVisibility(8);
        }
        if (this.jzp.size() >= 3) {
            this.jzs.setVisibility(0);
            this.jzs.setText(com.tencent.mm.ui.e.c.b.d(getContext(), ((com.tencent.mm.plugin.fts.ui.widget.a.b) this.jzp.get(2)).getTagName(), ad));
            return;
        }
        this.jzs.setVisibility(8);
    }

    public ImageView getIconView() {
        return this.gmn;
    }

    public EditText getEditText() {
        return this.jzo;
    }

    public ImageButton getClearBtn() {
        return this.jfw;
    }

    public void setFtsEditTextListener(a aVar) {
        this.jzx = aVar;
    }

    public String getInEditTextQuery() {
        return this.jzo.getText().toString().trim();
    }

    public String getTotalQuery() {
        StringBuffer stringBuffer = new StringBuffer();
        for (com.tencent.mm.plugin.fts.ui.widget.a.b tagName : this.jzp) {
            stringBuffer.append(tagName.getTagName());
            stringBuffer.append(" ");
        }
        stringBuffer.append(this.jzo.getText().toString());
        return stringBuffer.toString().trim();
    }

    public final void aQW() {
        this.gmn.setVisibility(8);
    }

    public final void aQX() {
        this.gmn.setVisibility(0);
    }

    public final void aQY() {
        this.jfw.setVisibility(8);
    }

    public View getTagPanel() {
        return this.jzt;
    }

    public b getTextChangeStatus() {
        return this.jzy;
    }

    public void setCanDeleteTag(boolean z) {
        this.jzu = z;
    }
}

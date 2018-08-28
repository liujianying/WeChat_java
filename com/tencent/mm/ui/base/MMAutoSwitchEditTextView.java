package com.tencent.mm.ui.base;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.text.method.DigitsKeyListener;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import com.tencent.mm.bp.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.w.a.h;
import com.tencent.mm.w.a.m;
import java.util.ArrayList;
import java.util.Iterator;

public class MMAutoSwitchEditTextView extends LinearLayout {
    private int idT = 100;
    private int kCi;
    private Context mContext;
    private int mScreenWidth;
    private int mwe;
    private int ttN;
    private String ttO;
    private ArrayList<MMAutoSwitchEditText> ttP = new ArrayList();
    private c ttQ = new c(this, (byte) 0);
    private a ttR;
    private b ttS;

    public void setOnInputFinished(a aVar) {
        this.ttR = aVar;
    }

    public void setOnTextChanged(b bVar) {
        this.ttS = bVar;
    }

    public String getText() {
        String str = "";
        Iterator it = this.ttP.iterator();
        while (it.hasNext()) {
            String str2;
            MMAutoSwitchEditText mMAutoSwitchEditText = (MMAutoSwitchEditText) it.next();
            if (bi.oW(mMAutoSwitchEditText.getText().toString().trim())) {
                str2 = str;
            } else {
                str2 = str + mMAutoSwitchEditText.getText().toString().trim();
            }
            str = str2;
        }
        return str;
    }

    public MMAutoSwitchEditTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, m.AutoSwitchLayout);
        this.ttN = obtainStyledAttributes.getInteger(m.AutoSwitchLayout_edit_text_count, 3);
        this.kCi = obtainStyledAttributes.getInteger(m.AutoSwitchLayout_max_input_count, 4);
        this.mwe = obtainStyledAttributes.getInteger(m.AutoSwitchLayout_edit_text_inputType, 2);
        int resourceId = obtainStyledAttributes.getResourceId(m.AutoSwitchLayout_edit_text_digits, 0);
        if (resourceId != 0) {
            this.ttO = context.getString(resourceId);
        }
        obtainStyledAttributes.recycle();
        if (context instanceof Activity) {
            this.mScreenWidth = ((Activity) context).getWindowManager().getDefaultDisplay().getWidth();
            this.idT = ((this.mScreenWidth - 80) - ((this.ttN - 1) * 20)) / this.ttN;
        }
        setPadding(a.fromDPToPix(context, 20), 0, a.fromDPToPix(context, 20), 0);
        crr();
    }

    private void crr() {
        for (int i = 0; i < this.ttN; i++) {
            MMAutoSwitchEditText mMAutoSwitchEditText = (MMAutoSwitchEditText) View.inflate(this.mContext, h.auto_switch_edittext, null);
            mMAutoSwitchEditText.setInputType(this.mwe);
            if (this.ttO != null && this.ttO.length() > 0) {
                mMAutoSwitchEditText.setKeyListener(DigitsKeyListener.getInstance(this.ttO));
            }
            mMAutoSwitchEditText.ttI.mIndex = i;
            mMAutoSwitchEditText.ttI.ttM = this.kCi;
            mMAutoSwitchEditText.ttI.ttJ = this.ttQ;
            mMAutoSwitchEditText.ttI.ttK = this.ttQ;
            mMAutoSwitchEditText.ttI.ttL = this.ttQ;
            LayoutParams layoutParams = new LinearLayout.LayoutParams(this.idT, -2);
            if (i > 0) {
                layoutParams.leftMargin = 20;
            } else {
                layoutParams.leftMargin = 0;
            }
            layoutParams.weight = 1.0f;
            mMAutoSwitchEditText.setLayoutParams(layoutParams);
            this.ttP.add(mMAutoSwitchEditText);
            addView(mMAutoSwitchEditText);
        }
    }
}

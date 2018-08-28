package com.tencent.mm.plugin.appbrand.game.widget.input;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.InputFilter;
import android.text.Spannable;
import android.text.Spannable.Factory;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;
import com.tencent.mm.br.b;
import com.tencent.mm.plugin.appbrand.s.c;
import com.tencent.mm.plugin.appbrand.widget.input.x;
import com.tencent.mm.pointers.PInt;
import com.tencent.wcdb.database.SQLiteDatabase;

@SuppressLint({"AppCompatCustomView"})
public class WAGamePanelInputEditText extends EditText {
    private final Factory fDA;
    private final x fDx;
    private final InputFilter fDy;
    private int fDz;

    static /* synthetic */ Spannable a(WAGamePanelInputEditText wAGamePanelInputEditText, Spannable spannable) {
        PInt pInt = new PInt();
        pInt.value = wAGamePanelInputEditText.fDz;
        b cjC = b.cjC();
        wAGamePanelInputEditText.getContext();
        return cjC.a(spannable, Math.round(wAGamePanelInputEditText.getTextSize()), pInt, wAGamePanelInputEditText.fDA);
    }

    public WAGamePanelInputEditText(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, c.editTextStyle);
    }

    public WAGamePanelInputEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fDy = new 2(this);
        this.fDz = Integer.MAX_VALUE;
        this.fDA = new 3(this);
        this.fDx = new x(this);
        super.setEditableFactory(new 1(this));
    }

    public void setComposingDismissedListener(com.tencent.mm.plugin.appbrand.widget.input.a.b bVar) {
        this.fDx.gIR = bVar;
    }

    public void setFilters(InputFilter[] inputFilterArr) {
        int i = 0;
        if (this.fDy != null) {
            if (inputFilterArr == null) {
                inputFilterArr = new InputFilter[0];
            }
            InputFilter[] inputFilterArr2 = new InputFilter[(inputFilterArr.length + 1)];
            while (i < inputFilterArr.length) {
                inputFilterArr2[i] = inputFilterArr[i];
                i++;
            }
            inputFilterArr2[i] = this.fDy;
            inputFilterArr = inputFilterArr2;
        }
        super.setFilters(inputFilterArr);
    }

    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
        editorInfo.imeOptions |= SQLiteDatabase.CREATE_IF_NECESSARY;
        return onCreateInputConnection;
    }

    public void setMaxLength(int i) {
        this.fDz = i;
    }

    public int getMaxLength() {
        return this.fDz;
    }
}

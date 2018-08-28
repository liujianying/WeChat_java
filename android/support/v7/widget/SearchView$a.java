package android.support.v7.widget;

import android.os.ResultReceiver;
import android.view.inputmethod.InputMethodManager;
import android.widget.AutoCompleteTextView;
import java.lang.reflect.Method;

class SearchView$a {
    Method UG;
    Method UH;
    private Method UI;
    Method UJ;

    SearchView$a() {
        try {
            this.UG = AutoCompleteTextView.class.getDeclaredMethod("doBeforeTextChanged", new Class[0]);
            this.UG.setAccessible(true);
        } catch (NoSuchMethodException e) {
        }
        try {
            this.UH = AutoCompleteTextView.class.getDeclaredMethod("doAfterTextChanged", new Class[0]);
            this.UH.setAccessible(true);
        } catch (NoSuchMethodException e2) {
        }
        try {
            this.UI = AutoCompleteTextView.class.getMethod("ensureImeVisible", new Class[]{Boolean.TYPE});
            this.UI.setAccessible(true);
        } catch (NoSuchMethodException e3) {
        }
        try {
            this.UJ = InputMethodManager.class.getMethod("showSoftInputUnchecked", new Class[]{Integer.TYPE, ResultReceiver.class});
            this.UJ.setAccessible(true);
        } catch (NoSuchMethodException e4) {
        }
    }

    final void a(AutoCompleteTextView autoCompleteTextView) {
        if (this.UI != null) {
            try {
                this.UI.invoke(autoCompleteTextView, new Object[]{Boolean.valueOf(true)});
            } catch (Exception e) {
            }
        }
    }
}

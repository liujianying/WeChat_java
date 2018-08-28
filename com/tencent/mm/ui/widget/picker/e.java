package com.tencent.mm.ui.widget.picker;

import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.widget.EditText;
import android.widget.NumberPicker;
import com.tencent.mm.ui.aj;

public final class e {
    public static void a(NumberPicker numberPicker, Drawable drawable) {
        if (numberPicker != null) {
            try {
                aj ajVar = new aj(numberPicker, "mSelectionDivider");
                ajVar.prepare();
                if (ajVar.dfG == null) {
                    throw new NoSuchFieldException();
                }
                ajVar.dfG.set(ajVar.obj, drawable);
            } catch (Exception e) {
            }
        }
    }

    public static EditText b(NumberPicker numberPicker) {
        if (numberPicker == null) {
            return null;
        }
        try {
            return (EditText) new aj(numberPicker, "mInputText").get();
        } catch (IllegalAccessException e) {
        } catch (NoSuchFieldException e2) {
        }
        return null;
    }

    public static void c(NumberPicker numberPicker) {
        if (numberPicker != null) {
            numberPicker.setDescendantFocusability(393216);
        }
    }

    public static void d(NumberPicker numberPicker) {
        if (numberPicker != null) {
            try {
                EditText editText = (EditText) new aj(numberPicker, "mInputText").get();
                if (editText != null) {
                    editText.setFilters(new InputFilter[0]);
                }
            } catch (IllegalAccessException e) {
            } catch (NoSuchFieldException e2) {
            }
        }
    }

    public static void e(NumberPicker numberPicker) {
        if (numberPicker != null) {
            try {
                Runnable runnable = (Runnable) new aj(numberPicker, "mSetSelectionCommand").get();
                if (runnable != null) {
                    numberPicker.removeCallbacks(runnable);
                }
            } catch (IllegalAccessException e) {
            } catch (NoSuchFieldException e2) {
            }
        }
    }
}

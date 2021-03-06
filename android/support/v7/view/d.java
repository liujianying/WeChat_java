package android.support.v7.view;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources.Theme;
import android.support.v7.a.a.j;
import android.view.LayoutInflater;

public final class d extends ContextWrapper {
    private LayoutInflater Bc;
    public int Gt;
    private Theme mTheme;

    public d(Context context, int i) {
        super(context);
        this.Gt = i;
    }

    public final void setTheme(int i) {
        if (this.Gt != i) {
            this.Gt = i;
            dt();
        }
    }

    public final Theme getTheme() {
        if (this.mTheme != null) {
            return this.mTheme;
        }
        if (this.Gt == 0) {
            this.Gt = j.Theme_AppCompat_Light;
        }
        dt();
        return this.mTheme;
    }

    public final Object getSystemService(String str) {
        if (!"layout_inflater".equals(str)) {
            return getBaseContext().getSystemService(str);
        }
        if (this.Bc == null) {
            this.Bc = LayoutInflater.from(getBaseContext()).cloneInContext(this);
        }
        return this.Bc;
    }

    private void dt() {
        if (this.mTheme == null) {
            this.mTheme = getResources().newTheme();
            Theme theme = getBaseContext().getTheme();
            if (theme != null) {
                this.mTheme.setTo(theme);
            }
        }
        this.mTheme.applyStyle(this.Gt, true);
    }
}

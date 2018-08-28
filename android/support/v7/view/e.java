package android.support.v7.view;

import android.content.Context;
import android.support.v7.view.menu.f;
import android.support.v7.view.menu.f.a;
import android.support.v7.widget.ActionBarContextView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import java.lang.ref.WeakReference;

public final class e extends b implements a {
    private ActionBarContextView FT;
    private b.a Gq;
    private WeakReference<View> Gr;
    private boolean Gu;
    private f bq;
    private Context mContext;
    private boolean mFinished;

    public e(Context context, ActionBarContextView actionBarContextView, b.a aVar, boolean z) {
        this.mContext = context;
        this.FT = actionBarContextView;
        this.Gq = aVar;
        f fVar = new f(actionBarContextView.getContext());
        this.bq = fVar;
        this.bq.a((a) this);
        this.Gu = z;
    }

    public final void setTitle(CharSequence charSequence) {
        this.FT.setTitle(charSequence);
    }

    public final void setSubtitle(CharSequence charSequence) {
        this.FT.setSubtitle(charSequence);
    }

    public final void setTitle(int i) {
        setTitle(this.mContext.getString(i));
    }

    public final void setSubtitle(int i) {
        setSubtitle(this.mContext.getString(i));
    }

    public final void setTitleOptionalHint(boolean z) {
        super.setTitleOptionalHint(z);
        this.FT.setTitleOptional(z);
    }

    public final boolean isTitleOptional() {
        return this.FT.JL;
    }

    public final void setCustomView(View view) {
        this.FT.setCustomView(view);
        this.Gr = view != null ? new WeakReference(view) : null;
    }

    public final void invalidate() {
        this.Gq.b(this, this.bq);
    }

    public final void finish() {
        if (!this.mFinished) {
            this.mFinished = true;
            this.FT.sendAccessibilityEvent(32);
            this.Gq.a(this);
        }
    }

    public final Menu getMenu() {
        return this.bq;
    }

    public final CharSequence getTitle() {
        return this.FT.getTitle();
    }

    public final CharSequence getSubtitle() {
        return this.FT.getSubtitle();
    }

    public final View getCustomView() {
        return this.Gr != null ? (View) this.Gr.get() : null;
    }

    public final MenuInflater getMenuInflater() {
        return new g(this.FT.getContext());
    }

    public final boolean a(f fVar, MenuItem menuItem) {
        return this.Gq.a((b) this, menuItem);
    }

    public final void b(f fVar) {
        invalidate();
        this.FT.showOverflowMenu();
    }
}

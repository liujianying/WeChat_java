package android.support.v7.view.menu;

import android.annotation.TargetApi;
import android.content.Context;
import android.support.v4.view.d.b;
import android.view.ActionProvider;
import android.view.ActionProvider.VisibilityListener;
import android.view.MenuItem;
import android.view.View;

@TargetApi(16)
final class j extends i {

    class a extends a implements VisibilityListener {
        b IU;

        public a(Context context, ActionProvider actionProvider) {
            super(context, actionProvider);
        }

        public final View onCreateActionView(MenuItem menuItem) {
            return this.IR.onCreateActionView(menuItem);
        }

        public final boolean overridesItemVisibility() {
            return this.IR.overridesItemVisibility();
        }

        public final boolean isVisible() {
            return this.IR.isVisible();
        }

        public final void a(b bVar) {
            this.IU = bVar;
            this.IR.setVisibilityListener(this);
        }

        public final void onActionProviderVisibilityChanged(boolean z) {
            if (this.IU != null) {
                this.IU.ca();
            }
        }
    }

    j(Context context, android.support.v4.c.a.b bVar) {
        super(context, bVar);
    }

    final a a(ActionProvider actionProvider) {
        return new a(this.mContext, actionProvider);
    }
}

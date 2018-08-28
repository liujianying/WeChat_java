package android.support.v7.widget;

import android.content.ComponentName;
import android.content.Intent;
import android.support.v7.widget.ActivityChooserView.a;
import android.support.v7.widget.d.c;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.PopupWindow.OnDismissListener;

class ActivityChooserView$b implements OnClickListener, OnLongClickListener, OnItemClickListener, OnDismissListener {
    final /* synthetic */ ActivityChooserView LK;

    private ActivityChooserView$b(ActivityChooserView activityChooserView) {
        this.LK = activityChooserView;
    }

    /* synthetic */ ActivityChooserView$b(ActivityChooserView activityChooserView, byte b) {
        this(activityChooserView);
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        switch (((a) adapterView.getAdapter()).getItemViewType(i)) {
            case 0:
                this.LK.ez();
                if (!ActivityChooserView.d(this.LK)) {
                    if (!ActivityChooserView.a(this.LK).LN) {
                        i++;
                    }
                    Intent aM = ActivityChooserView.a(this.LK).LL.aM(i);
                    if (aM != null) {
                        aM.addFlags(524288);
                        this.LK.getContext().startActivity(aM);
                        return;
                    }
                    return;
                } else if (i > 0) {
                    d dVar = ActivityChooserView.a(this.LK).LL;
                    synchronized (dVar.Lg) {
                        dVar.es();
                        d.a aVar = (d.a) dVar.Lh.get(i);
                        d.a aVar2 = (d.a) dVar.Lh.get(0);
                        dVar.a(new c(new ComponentName(aVar.resolveInfo.activityInfo.packageName, aVar.resolveInfo.activityInfo.name), System.currentTimeMillis(), aVar2 != null ? (aVar2.weight - aVar.weight) + 5.0f : 1.0f));
                    }
                    return;
                } else {
                    return;
                }
            case 1:
                ActivityChooserView.a(this.LK, Integer.MAX_VALUE);
                return;
            default:
                throw new IllegalArgumentException();
        }
    }

    public final void onClick(View view) {
        if (view == ActivityChooserView.e(this.LK)) {
            this.LK.ez();
            Intent aM = ActivityChooserView.a(this.LK).LL.aM(ActivityChooserView.a(this.LK).LL.a(ActivityChooserView.a(this.LK).LL.er()));
            if (aM != null) {
                aM.addFlags(524288);
                this.LK.getContext().startActivity(aM);
            }
        } else if (view == ActivityChooserView.f(this.LK)) {
            ActivityChooserView.a(this.LK, false);
            ActivityChooserView.a(this.LK, ActivityChooserView.g(this.LK));
        } else {
            throw new IllegalArgumentException();
        }
    }

    public final boolean onLongClick(View view) {
        if (view == ActivityChooserView.e(this.LK)) {
            if (ActivityChooserView.a(this.LK).getCount() > 0) {
                ActivityChooserView.a(this.LK, true);
                ActivityChooserView.a(this.LK, ActivityChooserView.g(this.LK));
            }
            return true;
        }
        throw new IllegalArgumentException();
    }

    public final void onDismiss() {
        if (ActivityChooserView.h(this.LK) != null) {
            ActivityChooserView.h(this.LK).onDismiss();
        }
        if (this.LK.LC != null) {
            this.LK.LC.v(false);
        }
    }
}

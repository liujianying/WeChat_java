package android.support.v7.widget;

import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.support.v4.view.z;
import android.support.v7.a.a.f;
import android.support.v7.a.a.h;
import android.support.v7.a.a.i;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

class ActivityChooserView$a extends BaseAdapter {
    final /* synthetic */ ActivityChooserView LK;
    d LL;
    private int LM;
    boolean LN;
    private boolean LO;
    private boolean LP;

    private ActivityChooserView$a(ActivityChooserView activityChooserView) {
        this.LK = activityChooserView;
        this.LM = 4;
    }

    /* synthetic */ ActivityChooserView$a(ActivityChooserView activityChooserView, byte b) {
        this(activityChooserView);
    }

    public final int getItemViewType(int i) {
        if (this.LP && i == getCount() - 1) {
            return 1;
        }
        return 0;
    }

    public final int getViewTypeCount() {
        return 3;
    }

    public final int getCount() {
        int eq = this.LL.eq();
        if (!(this.LN || this.LL.er() == null)) {
            eq--;
        }
        eq = Math.min(eq, this.LM);
        if (this.LP) {
            return eq + 1;
        }
        return eq;
    }

    public final Object getItem(int i) {
        switch (getItemViewType(i)) {
            case 0:
                if (!(this.LN || this.LL.er() == null)) {
                    i++;
                }
                return this.LL.aL(i);
            case 1:
                return null;
            default:
                throw new IllegalArgumentException();
        }
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        switch (getItemViewType(i)) {
            case 0:
                if (view == null || view.getId() != f.list_item) {
                    view = LayoutInflater.from(this.LK.getContext()).inflate(h.abc_activity_chooser_view_list_item, viewGroup, false);
                }
                PackageManager packageManager = this.LK.getContext().getPackageManager();
                ResolveInfo resolveInfo = (ResolveInfo) getItem(i);
                ((ImageView) view.findViewById(f.icon)).setImageDrawable(resolveInfo.loadIcon(packageManager));
                ((TextView) view.findViewById(f.title)).setText(resolveInfo.loadLabel(packageManager));
                if (this.LN && i == 0 && this.LO) {
                    z.b(view, true);
                    return view;
                }
                z.b(view, false);
                return view;
            case 1:
                if (view != null && view.getId() == 1) {
                    return view;
                }
                view = LayoutInflater.from(this.LK.getContext()).inflate(h.abc_activity_chooser_view_list_item, viewGroup, false);
                view.setId(1);
                ((TextView) view.findViewById(f.title)).setText(this.LK.getContext().getString(i.abc_activity_chooser_view_see_all));
                return view;
            default:
                throw new IllegalArgumentException();
        }
    }

    public final int eB() {
        int i = this.LM;
        this.LM = Integer.MAX_VALUE;
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(0, 0);
        int makeMeasureSpec2 = MeasureSpec.makeMeasureSpec(0, 0);
        int count = getCount();
        int i2 = 0;
        View view = null;
        int i3 = 0;
        while (i2 < count) {
            View view2 = getView(i2, view, null);
            view2.measure(makeMeasureSpec, makeMeasureSpec2);
            i3 = Math.max(i3, view2.getMeasuredWidth());
            i2++;
            view = view2;
        }
        this.LM = i;
        return i3;
    }

    public final void aO(int i) {
        if (this.LM != i) {
            this.LM = i;
            notifyDataSetChanged();
        }
    }

    public final void setShowFooterView(boolean z) {
        if (this.LP != z) {
            this.LP = z;
            notifyDataSetChanged();
        }
    }

    public final void f(boolean z, boolean z2) {
        if (this.LN != z || this.LO != z2) {
            this.LN = z;
            this.LO = z2;
            notifyDataSetChanged();
        }
    }
}

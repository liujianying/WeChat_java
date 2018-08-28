package com.tencent.mm.plugin.appbrand.widget.recyclerview;

import android.support.v7.widget.RecyclerView.c;
import android.support.v7.widget.RecyclerView.t;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.mm.plugin.appbrand.widget.k;
import java.util.LinkedList;
import java.util.List;

final class a extends android.support.v7.widget.RecyclerView.a<t> {
    private static LayoutParams gPK = new LayoutParams(-1, -2);
    android.support.v7.widget.RecyclerView.a QU;
    private ViewGroup gPL;
    private ViewGroup gPM;
    List<View> gPN = new LinkedList();
    private List<View> gPO = new LinkedList();
    b gPP;
    c gPQ;
    c gPR = new 1(this);

    private static class a extends t {
        a(View view) {
            super(view);
        }
    }

    a() {
    }

    public final int getItemViewType(int i) {
        if (!this.gPN.isEmpty() && i == 0) {
            return Integer.MAX_VALUE;
        }
        if (!this.gPO.isEmpty() && i == getItemCount() - 1) {
            return 2147483646;
        }
        return this.QU.getItemViewType(i - (this.gPN.isEmpty() ? 0 : 1));
    }

    public final long getItemId(int i) {
        if (getItemViewType(i) == Integer.MAX_VALUE) {
            return (long) "MRecyclerHeaderView".hashCode();
        }
        if (getItemViewType(i) == 2147483646) {
            return (long) "MRecyclerFooterView".hashCode();
        }
        if (!this.QU.RS) {
            return (long) i;
        }
        return this.QU.getItemId(i - (this.gPN.isEmpty() ? 0 : 1));
    }

    public final int getItemCount() {
        int itemCount = this.QU.getItemCount();
        if (!this.gPN.isEmpty()) {
            itemCount++;
        }
        if (this.gPO.isEmpty()) {
            return itemCount;
        }
        return itemCount + 1;
    }

    public final void a(final t tVar, int i) {
        if (!this.gPN.isEmpty() && i == 0) {
            return;
        }
        if (this.gPO.isEmpty() || i != getItemCount() - 1) {
            final int i2 = i - (this.gPN.isEmpty() ? 0 : 1);
            this.QU.a(tVar, i2);
            if (this.gPP != null) {
                tVar.SU.setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        if (a.this.gPP != null) {
                            b b = a.this.gPP;
                            View view2 = tVar.SU;
                            int i = i2;
                            long j = tVar.SW;
                            b.ms(i);
                        }
                    }
                });
            }
            if (this.gPQ != null) {
                tVar.SU.setOnLongClickListener(new OnLongClickListener() {
                    public final boolean onLongClick(View view) {
                        if (a.this.gPQ == null) {
                            return false;
                        }
                        c c = a.this.gPQ;
                        View view2 = tVar.SU;
                        long j = tVar.SW;
                        return c.aqE();
                    }
                });
            }
        }
    }

    public final void a(t tVar, int i, List<Object> list) {
        if (!this.gPN.isEmpty() && i == 0) {
            return;
        }
        if (this.gPO.isEmpty() || i != getItemCount() - 1) {
            int i2 = i - (this.gPN.isEmpty() ? 0 : 1);
            this.QU.a(tVar, i2, list);
            if (this.gPP != null) {
                tVar.SU.setOnClickListener(new 4(this, tVar, i2));
            }
            if (this.gPQ != null) {
                tVar.SU.setOnLongClickListener(new 5(this, tVar, i2));
            }
        }
    }

    public final t a(ViewGroup viewGroup, int i) {
        ViewGroup viewGroup2;
        if (i == 2147483646) {
            if (this.gPL != null) {
                this.gPL.removeAllViews();
            }
            viewGroup2 = (ViewGroup) LayoutInflater.from(viewGroup.getContext()).inflate(k.c.support_footer_recycler_view_container, viewGroup, false);
            this.gPL = viewGroup2;
            for (View addView : this.gPO) {
                viewGroup2.addView(addView, gPK);
            }
            return new a(viewGroup2);
        } else if (i != Integer.MAX_VALUE) {
            return this.QU.a(viewGroup, i);
        } else {
            if (this.gPM != null) {
                this.gPM.removeAllViews();
            }
            viewGroup2 = (ViewGroup) LayoutInflater.from(viewGroup.getContext()).inflate(k.c.support_footer_recycler_view_container, viewGroup, false);
            this.gPM = viewGroup2;
            for (View addView2 : this.gPN) {
                viewGroup2.addView(addView2, gPK);
            }
            return new a(viewGroup2);
        }
    }

    public final int aqC() {
        return this.gPO.size();
    }

    public final void addFooterView(View view) {
        this.gPO.add(view);
        X(getItemCount() - 1, 1);
    }

    public final void b(int i, View view) {
        this.gPO.add(i, view);
        X(getItemCount() - 1, 1);
    }

    public final void cj(View view) {
        this.gPO.remove(view);
        X(getItemCount() - 1, 1);
    }
}

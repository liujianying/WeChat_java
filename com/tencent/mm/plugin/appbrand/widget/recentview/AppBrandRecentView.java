package com.tencent.mm.plugin.appbrand.widget.recentview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView$a;
import android.util.AttributeSet;
import android.view.View;

public abstract class AppBrandRecentView extends RecyclerView {
    private b gOU;
    com.tencent.mm.plugin.appbrand.widget.recentview.d.a gOV;

    public interface a {
        boolean a(View view, a aVar, float f, float f2);

        boolean b(View view, a aVar, float f, float f2);
    }

    public abstract RecyclerView$a getAdapter();

    public abstract int getCount();

    public abstract a getOnItemClickListener();

    public abstract void refresh();

    public abstract void release();

    public abstract void setOnItemClickListener(a aVar);

    public AppBrandRecentView(Context context) {
        super(context);
    }

    public AppBrandRecentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setSceneFactory(com.tencent.mm.plugin.appbrand.widget.recentview.d.a aVar) {
        this.gOV = aVar;
    }

    public com.tencent.mm.plugin.appbrand.widget.recentview.d.a getSceneFactory() {
        return this.gOV;
    }

    public void setRefreshListener(b bVar) {
        this.gOU = bVar;
    }

    public b getRefreshListener() {
        return this.gOU;
    }
}

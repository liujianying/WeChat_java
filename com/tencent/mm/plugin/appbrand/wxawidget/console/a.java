package com.tencent.mm.plugin.appbrand.wxawidget.console;

import android.content.Context;
import android.support.v7.widget.RecyclerView$t;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.tencent.mm.modelappbrand.LogInfo;
import com.tencent.mm.plugin.appbrand.wxawidget.b.c;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

final class a extends android.support.v7.widget.RecyclerView.a {
    private static final SimpleDateFormat gQk = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
    LayoutInflater Bc;
    List<LogInfo> gQl = new LinkedList();

    a(Context context) {
        this.Bc = LayoutInflater.from(context);
    }

    public final RecyclerView$t a(ViewGroup viewGroup, int i) {
        return new a(this.Bc.inflate(c.console_log_item, viewGroup, false), i);
    }

    public final void a(RecyclerView$t recyclerView$t, int i) {
        LogInfo logInfo = (LogInfo) this.gQl.get(i);
        ((a) recyclerView$t).eZj.setText(String.format("[%s] %s", new Object[]{gQk.format(new Date(logInfo.ts)), logInfo.message}));
    }

    public final int getItemCount() {
        return this.gQl.size();
    }

    public final int getItemViewType(int i) {
        return ((LogInfo) this.gQl.get(i)).level;
    }
}

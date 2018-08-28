package com.tencent.mm.pluginsdk.ui.chat;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.GridView;

// 拍照功能的消息响应方法
public class AppGrid extends GridView  {
    Context context;
    private SharedPreferences duR;
    OnItemClickListener hpE = new OnItemClickListener() {    //点击 -》拍照
        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            AppGrid.this.qJT.a(AppGrid.this.qJT.Cf((AppGrid.this.qJX * AppGrid.this.qJV) + i), AppGrid.this.qJZ.xV(i));
        }
    };
    OnItemLongClickListener jbf = new OnItemLongClickListener() { //长按 -》 10s视频
        public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
            b c = AppGrid.this.qJT;
            int Cf = AppGrid.this.qJT.Cf((AppGrid.this.qJX * AppGrid.this.qJV) + i);
            AppGrid.this.qJZ.xV(i);
            c.Cg(Cf);
            return true;
        }
    };
    private b qJT;
    int qJU;
    int qJV = 0;
    int qJW = 0;
    int qJX;
    int qJY;
    a qJZ;

    public AppGrid(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.context = context;
    }

    public AppGrid(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.context = context;
    }

    public void setOnAppSelectedListener(b bVar) {
        this.qJT = bVar;
    }

    public int getCount() {
        return this.qJZ.getCount();
    }
}

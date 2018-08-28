package com.tencent.mm.ui.conversation;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ListView;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.al.a;
import com.tencent.mm.sdk.platformtools.x;

public class ConversationOverscrollListView extends ListView implements OnItemClickListener, OnItemLongClickListener, OnItemSelectedListener, a {
    private static final boolean uoG = d.fT(10);
    private OnItemClickListener PY;
    private OnItemSelectedListener PZ;
    private Rect cO = new Rect();
    private al eOf;
    private c uoH = new c();
    private a uoI;
    private boolean uoJ = false;
    private int uoK = 0;
    private int uoL = 0;
    private float uoM = 0.0f;
    private long uoN = 1;
    private final float uoO = 3.5f;
    private final float uoP = 13.5f;
    private float uoQ = 0.0f;
    private b uoR = new b(this);
    private final int uoS = 50;
    private OnItemLongClickListener uoT;
    private int yA = 0;

    public ConversationOverscrollListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        super.setOnItemClickListener(this);
        super.setOnItemLongClickListener(this);
        super.setOnItemSelectedListener(this);
        this.eOf = new al(this, false);
    }

    public void setOverScrollCallback(a aVar) {
        this.uoI = aVar;
    }

    @TargetApi(11)
    protected void onFinishInflate() {
    }

    @TargetApi(11)
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
    }

    private float getSpeed() {
        x.d("MicroMsg.ConversationOverscrollListView", "speed: %f", new Object[]{Float.valueOf((this.uoQ - this.uoM) / ((float) Math.max(1, System.currentTimeMillis() - this.uoN)))});
        return (this.uoQ - this.uoM) / ((float) Math.max(1, System.currentTimeMillis() - this.uoN));
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.PY = onItemClickListener;
    }

    public void setOnItemLongClickListener(OnItemLongClickListener onItemLongClickListener) {
        this.uoT = onItemLongClickListener;
    }

    public void setOnItemSelectedListener(OnItemSelectedListener onItemSelectedListener) {
        this.PZ = onItemSelectedListener;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.uoJ = true;
        if (this.PY != null) {
            this.PY.onItemClick(adapterView, view, i, j);
        }
    }

    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
        this.uoJ = true;
        if (this.PZ != null) {
            this.PZ.onItemSelected(adapterView, view, i, j);
        }
    }

    public void onNothingSelected(AdapterView<?> adapterView) {
        if (this.PZ != null) {
            this.PZ.onNothingSelected(adapterView);
        }
    }

    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.uoJ = true;
        if (this.uoT != null) {
            return this.uoT.onItemLongClick(adapterView, view, i, j);
        }
        return false;
    }

    public final boolean vD() {
        return false;
    }
}

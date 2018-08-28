package com.tencent.mm.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import com.tencent.mm.sdk.platformtools.x;

public class LayoutListenerView extends FrameLayout {
    private String TAG = "MicroMsg.LayoutListenerView";
    private byte[] tls = new byte[0];
    private a tlt;
    private c tlu;
    private b tlv;

    public interface a {
    }

    public interface b {
    }

    public interface c {
        void onSizeChanged(int i, int i2, int i3, int i4);
    }

    public void setOnLayoutListener(a aVar) {
        synchronized (this.tls) {
            this.tlt = aVar;
        }
    }

    public void setOnResizedListener(c cVar) {
        synchronized (this.tls) {
            this.tlu = cVar;
        }
    }

    public void setOnPreLayoutListener(b bVar) {
        synchronized (this.tls) {
            this.tlv = bVar;
        }
    }

    public LayoutListenerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        synchronized (this.tls) {
        }
        super.onLayout(z, i, i2, i3, i4);
        synchronized (this.tls) {
        }
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        synchronized (this.tls) {
            if (this.tlu != null) {
                this.tlu.onSizeChanged(i, i2, i3, i4);
            }
        }
    }

    @TargetApi(14)
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        x.d(this.TAG, "jacks onInitializeAccessibilityNodeInfo");
    }

    @TargetApi(14)
    public void onPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onPopulateAccessibilityEvent(accessibilityEvent);
        x.d(this.TAG, "jacks onPopulateAccessibilityEvent");
    }

    @TargetApi(14)
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        x.d(this.TAG, "jacks onInitializeAccessibilityEvent");
    }

    protected void onDetachedFromWindow() {
        synchronized (this.tls) {
            this.tlt = null;
            this.tlu = null;
            this.tlv = null;
        }
        super.onDetachedFromWindow();
    }
}

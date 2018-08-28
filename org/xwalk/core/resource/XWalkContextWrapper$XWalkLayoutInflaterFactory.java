package org.xwalk.core.resource;

import android.content.Context;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.LayoutInflater.Factory;
import android.view.View;
import android.view.ViewStub;
import org.xwalk.core.Log;

final class XWalkContextWrapper$XWalkLayoutInflaterFactory implements Factory {
    LayoutInflater layoutInflater;

    private XWalkContextWrapper$XWalkLayoutInflaterFactory() {
    }

    public final View onCreateView(String str, Context context, AttributeSet attributeSet) {
        View view = null;
        try {
            view = inflateView(str, context, attributeSet);
            if ((view instanceof ViewStub) && VERSION.SDK_INT >= 21) {
                ((ViewStub) view).setLayoutInflater(this.layoutInflater);
            }
        } catch (ClassNotFoundException e) {
            Log.w("XWalkLib", String.format("[XWalkContextWrapper] class not found. name:%s. Use default Inflate.", new Object[]{str}));
        } catch (InflateException e2) {
            Log.w("XWalkLib", String.format("[XWalkContextWrapper] Inflate failed. name:%s. Use default Inflate.", new Object[]{str}));
        }
        return view;
    }

    public final View inflateView(String str, Context context, AttributeSet attributeSet) {
        View view = null;
        if (str.indexOf(".") != -1) {
            return this.layoutInflater.createView(str, null, attributeSet);
        }
        if (str.equals("WebView")) {
            view = createView(str, "android.webkit.", attributeSet);
        }
        if (view == null) {
            view = createView(str, "android.widget.", attributeSet);
        }
        if (view == null) {
            return createView(str, "android.view.", attributeSet);
        }
        return view;
    }

    private View createView(String str, String str2, AttributeSet attributeSet) {
        View view = null;
        try {
            return this.layoutInflater.createView(str, str2, attributeSet);
        } catch (InflateException e) {
            return view;
        } catch (ClassNotFoundException e2) {
            return view;
        }
    }
}

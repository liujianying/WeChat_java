package com.tencent.mm.ui.a;

import android.annotation.TargetApi;
import android.media.AudioManager;
import android.os.Bundle;
import android.os.Vibrator;
import android.provider.Settings.Secure;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.a.a.AnonymousClass1;
import com.tencent.wcdb.FileUtils;
import java.lang.reflect.Method;
import java.util.Locale;

@TargetApi(14)
public final class c extends AccessibilityDelegate {
    private boolean tqU = false;

    public c() {
        boolean z;
        a cqX = a.tqS;
        AudioManager audioManager = (AudioManager) cqX.rc.getSystemService("audio");
        if (!cqX.cqW() || (Secure.getInt(cqX.rc.getContentResolver(), "speak_password", 0) == 0 && !audioManager.isWiredHeadsetOn())) {
            z = false;
        } else {
            z = true;
        }
        this.tqU = z;
    }

    public final boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        return false;
    }

    public final AccessibilityNodeProvider getAccessibilityNodeProvider(View view) {
        return null;
    }

    public final void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
    }

    public final void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
    }

    public final void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
    }

    public final boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return true;
    }

    public final boolean performAccessibilityAction(View view, int i, Bundle bundle) {
        return true;
    }

    public final void sendAccessibilityEvent(View view, int i) {
        if (!this.tqU || view == null) {
            return;
        }
        if (i == FileUtils.S_IWUSR || i == 1) {
            CharSequence text;
            if (view instanceof EditText) {
                EditText editText = (EditText) view;
                text = !bi.K(editText.getText()) ? editText.getText() : !bi.K(editText.getContentDescription()) ? editText.getContentDescription() : editText.getHint() != null ? editText.getHint() : null;
            } else {
                text = view instanceof TextView ? bi.K(view.getContentDescription()) ? ((TextView) view).getText() : view.getContentDescription() : view.getContentDescription();
            }
            x.d("MicroMsg.MMSecureAccessibilityDelegate", "speak content: %s", text);
            if (!bi.K(text)) {
                a cqX = a.tqS;
                String charSequence = text.toString();
                if (cqX.tqQ == null) {
                    cqX.tqQ = new TextToSpeech(cqX.rc, new AnonymousClass1(charSequence));
                } else {
                    cqX.tqQ.setLanguage(w.chL() ? Locale.CHINESE : Locale.ENGLISH);
                    cqX.tqQ.speak(charSequence, 0, null);
                }
                Class cls = View.class;
                try {
                    Method method = cls.getMethod("clearAccessibilityFocus", new Class[0]);
                    method.setAccessible(true);
                    method.invoke(view, new Object[0]);
                    Method method2 = cls.getMethod("requestAccessibilityFocus", new Class[0]);
                    method2.setAccessible(true);
                    method2.invoke(view, new Object[0]);
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.Accessibility.AccessibilityHelper", e, "", new Object[0]);
                }
                if (cqX.hni != null) {
                    cqX.hni = (Vibrator) ad.getContext().getSystemService("vibrator");
                }
                if (cqX.hni != null) {
                    cqX.hni.vibrate(50);
                }
            }
        }
    }

    public final void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
    }
}

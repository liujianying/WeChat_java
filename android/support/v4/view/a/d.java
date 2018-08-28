package android.support.v4.view.a;

import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import java.util.List;

final class d {

    /* renamed from: android.support.v4.view.a.d$1 */
    static class AnonymousClass1 extends AccessibilityNodeProvider {
        final /* synthetic */ a xV;

        AnonymousClass1(a aVar) {
            this.xV = aVar;
        }

        public final AccessibilityNodeInfo createAccessibilityNodeInfo(int i) {
            this.xV.cu();
            return null;
        }

        public final List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText(String str, int i) {
            return this.xV.cs();
        }

        public final boolean performAction(int i, int i2, Bundle bundle) {
            return this.xV.cr();
        }
    }

    interface a {
        boolean cr();

        List<Object> cs();

        Object cu();
    }
}

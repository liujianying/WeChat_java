package android.support.v4.view.a;

import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import java.util.List;

final class e {

    /* renamed from: android.support.v4.view.a.e$1 */
    static class AnonymousClass1 extends AccessibilityNodeProvider {
        final /* synthetic */ a xW;

        AnonymousClass1(a aVar) {
            this.xW = aVar;
        }

        public final AccessibilityNodeInfo createAccessibilityNodeInfo(int i) {
            this.xW.cu();
            return null;
        }

        public final List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText(String str, int i) {
            return this.xW.cs();
        }

        public final boolean performAction(int i, int i2, Bundle bundle) {
            return this.xW.cr();
        }

        public final AccessibilityNodeInfo findFocus(int i) {
            this.xW.cv();
            return null;
        }
    }

    interface a {
        boolean cr();

        List<Object> cs();

        Object cu();

        Object cv();
    }
}

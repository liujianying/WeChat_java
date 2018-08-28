package android.support.v4.app;

import android.graphics.Rect;
import android.transition.Transition;
import android.transition.Transition.EpicenterCallback;
import android.transition.TransitionSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnPreDrawListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

final class r {

    /* renamed from: android.support.v4.app.r$2 */
    static class AnonymousClass2 implements OnPreDrawListener {
        final /* synthetic */ View oI;
        final /* synthetic */ Transition oJ;
        final /* synthetic */ View oK;
        final /* synthetic */ b oL;
        final /* synthetic */ Map oM;
        final /* synthetic */ Map oN;
        final /* synthetic */ ArrayList oO;

        AnonymousClass2(View view, Transition transition, View view2, b bVar, Map map, Map map2, ArrayList arrayList) {
            this.oI = view;
            this.oJ = transition;
            this.oK = view2;
            this.oL = bVar;
            this.oM = map;
            this.oN = map2;
            this.oO = arrayList;
        }

        public final boolean onPreDraw() {
            this.oI.getViewTreeObserver().removeOnPreDrawListener(this);
            if (this.oJ != null) {
                this.oJ.removeTarget(this.oK);
            }
            View view = this.oL.getView();
            if (view != null) {
                if (!this.oM.isEmpty()) {
                    r.a(this.oN, view);
                    this.oN.keySet().retainAll(this.oM.values());
                    for (Entry entry : this.oM.entrySet()) {
                        View view2 = (View) this.oN.get((String) entry.getValue());
                        if (view2 != null) {
                            view2.setTransitionName((String) entry.getKey());
                        }
                    }
                }
                if (this.oJ != null) {
                    r.a(this.oO, view);
                    this.oO.removeAll(this.oN.values());
                    this.oO.add(this.oK);
                    r.b(this.oJ, this.oO);
                }
            }
            return true;
        }
    }

    /* renamed from: android.support.v4.app.r$3 */
    static class AnonymousClass3 extends EpicenterCallback {
        private Rect oP;
        final /* synthetic */ a oQ;

        AnonymousClass3(a aVar) {
            this.oQ = aVar;
        }

        public final Rect onGetEpicenter(Transition transition) {
            if (this.oP == null && this.oQ.oW != null) {
                this.oP = r.x(this.oQ.oW);
            }
            return this.oP;
        }
    }

    /* renamed from: android.support.v4.app.r$4 */
    static class AnonymousClass4 implements OnPreDrawListener {
        final /* synthetic */ View mS;
        final /* synthetic */ ArrayList mU;
        final /* synthetic */ Transition oJ;
        final /* synthetic */ View oK;
        final /* synthetic */ Map oN;
        final /* synthetic */ ArrayList oO;
        final /* synthetic */ Transition oR;
        final /* synthetic */ ArrayList oS;
        final /* synthetic */ Transition oT;
        final /* synthetic */ ArrayList oU;
        final /* synthetic */ Transition oV;

        AnonymousClass4(View view, Transition transition, ArrayList arrayList, Transition transition2, ArrayList arrayList2, Transition transition3, ArrayList arrayList3, Map map, ArrayList arrayList4, Transition transition4, View view2) {
            this.mS = view;
            this.oJ = transition;
            this.oO = arrayList;
            this.oR = transition2;
            this.oS = arrayList2;
            this.oT = transition3;
            this.mU = arrayList3;
            this.oN = map;
            this.oU = arrayList4;
            this.oV = transition4;
            this.oK = view2;
        }

        public final boolean onPreDraw() {
            this.mS.getViewTreeObserver().removeOnPreDrawListener(this);
            if (this.oJ != null) {
                r.a(this.oJ, this.oO);
            }
            if (this.oR != null) {
                r.a(this.oR, this.oS);
            }
            if (this.oT != null) {
                r.a(this.oT, this.mU);
            }
            for (Entry entry : this.oN.entrySet()) {
                ((View) entry.getValue()).setTransitionName((String) entry.getKey());
            }
            int size = this.oU.size();
            for (int i = 0; i < size; i++) {
                this.oV.excludeTarget((View) this.oU.get(i), false);
            }
            this.oV.excludeTarget(this.oK, false);
            return true;
        }
    }

    public static class a {
        public View oW;
    }

    public interface b {
        View getView();
    }

    public static Object f(Object obj) {
        if (obj != null) {
            return ((Transition) obj).clone();
        }
        return obj;
    }

    public static void a(Object obj, View view, boolean z) {
        ((Transition) obj).excludeTarget(view, z);
    }

    public static void a(Object obj, View view) {
        Transition transition = (Transition) obj;
        final Rect x = x(view);
        transition.setEpicenterCallback(new EpicenterCallback() {
            public final Rect onGetEpicenter(Transition transition) {
                return x;
            }
        });
    }

    public static void a(Object obj, View view, Map<String, View> map, ArrayList<View> arrayList) {
        TransitionSet transitionSet = (TransitionSet) obj;
        arrayList.clear();
        arrayList.addAll(map.values());
        List targets = transitionSet.getTargets();
        targets.clear();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            View view2 = (View) arrayList.get(i);
            int size2 = targets.size();
            if (!a(targets, view2, size2)) {
                targets.add(view2);
                for (int i2 = size2; i2 < targets.size(); i2++) {
                    view2 = (View) targets.get(i2);
                    if (view2 instanceof ViewGroup) {
                        ViewGroup viewGroup = (ViewGroup) view2;
                        int childCount = viewGroup.getChildCount();
                        for (int i3 = 0; i3 < childCount; i3++) {
                            View childAt = viewGroup.getChildAt(i3);
                            if (!a(targets, childAt, size2)) {
                                targets.add(childAt);
                            }
                        }
                    }
                }
            }
        }
        arrayList.add(view);
        b(transitionSet, arrayList);
    }

    private static boolean a(List<View> list, View view, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            if (list.get(i2) == view) {
                return true;
            }
        }
        return false;
    }

    static Rect x(View view) {
        Rect rect = new Rect();
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        rect.set(iArr[0], iArr[1], iArr[0] + view.getWidth(), iArr[1] + view.getHeight());
        return rect;
    }

    static void a(ArrayList<View> arrayList, View view) {
        if (view.getVisibility() != 0) {
            return;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (viewGroup.isTransitionGroup()) {
                arrayList.add(viewGroup);
                return;
            }
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                a((ArrayList) arrayList, viewGroup.getChildAt(i));
            }
            return;
        }
        arrayList.add(view);
    }

    public static void a(Map<String, View> map, View view) {
        if (view.getVisibility() == 0) {
            String transitionName = view.getTransitionName();
            if (transitionName != null) {
                map.put(transitionName, view);
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                int childCount = viewGroup.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    a((Map) map, viewGroup.getChildAt(i));
                }
            }
        }
    }

    public static void a(Object obj, ArrayList<View> arrayList) {
        Transition transition = (Transition) obj;
        int transitionCount;
        if (transition instanceof TransitionSet) {
            TransitionSet transitionSet = (TransitionSet) transition;
            transitionCount = transitionSet.getTransitionCount();
            for (int i = 0; i < transitionCount; i++) {
                a(transitionSet.getTransitionAt(i), (ArrayList) arrayList);
            }
        } else if (!a(transition)) {
            List targets = transition.getTargets();
            if (targets != null && targets.size() == arrayList.size() && targets.containsAll(arrayList)) {
                for (transitionCount = arrayList.size() - 1; transitionCount >= 0; transitionCount--) {
                    transition.removeTarget((View) arrayList.get(transitionCount));
                }
            }
        }
    }

    public static void b(Object obj, ArrayList<View> arrayList) {
        int i = 0;
        Transition transition = (Transition) obj;
        int transitionCount;
        if (transition instanceof TransitionSet) {
            TransitionSet transitionSet = (TransitionSet) transition;
            transitionCount = transitionSet.getTransitionCount();
            while (i < transitionCount) {
                b(transitionSet.getTransitionAt(i), arrayList);
                i++;
            }
        } else if (!a(transition) && g(transition.getTargets())) {
            int size = arrayList.size();
            for (transitionCount = 0; transitionCount < size; transitionCount++) {
                transition.addTarget((View) arrayList.get(transitionCount));
            }
        }
    }

    private static boolean a(Transition transition) {
        return (g(transition.getTargetIds()) && g(transition.getTargetNames()) && g(transition.getTargetTypes())) ? false : true;
    }

    private static boolean g(List list) {
        return list == null || list.isEmpty();
    }
}

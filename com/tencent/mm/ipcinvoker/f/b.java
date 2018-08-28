package com.tencent.mm.ipcinvoker.f;

import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class b {
    private static final Map<String, Set<c>> dmH = new HashMap();
    private static final Set<Object> dnf = new HashSet();

    public static void ay(Object obj) {
        dnf.add(obj);
    }

    public static void az(Object obj) {
        dnf.remove(obj);
    }

    public static boolean a(String str, c cVar) {
        if (str == null || str.length() == 0 || cVar == null) {
            return false;
        }
        Set set;
        boolean add;
        synchronized (dmH) {
            Set set2 = (Set) dmH.get(str);
            if (set2 == null) {
                HashSet hashSet = new HashSet();
                dmH.put(str, hashSet);
                set = hashSet;
            } else {
                set = set2;
            }
        }
        x.i("IPC.ObjectRecycler", "addIntoSet(%s)", new Object[]{str});
        synchronized (set) {
            add = set.add(cVar);
        }
        return add;
    }

    public static boolean b(String str, c cVar) {
        if (str == null || str.length() == 0 || cVar == null) {
            return false;
        }
        Set set;
        synchronized (dmH) {
            set = (Set) dmH.get(str);
        }
        if (set == null) {
            return false;
        }
        boolean remove;
        x.i("IPC.ObjectRecycler", "removeFromSet(%s)", new Object[]{str});
        synchronized (set) {
            remove = set.remove(cVar);
        }
        return remove;
    }

    public static void fI(String str) {
        if (str != null && str.length() != 0) {
            Set<c> set;
            synchronized (dmH) {
                set = (Set) dmH.remove(str);
            }
            if (set != null) {
                x.i("IPC.ObjectRecycler", "recycleAll(%s)", new Object[]{str});
                synchronized (set) {
                    for (c hashCode : set) {
                        x.i("IPC.ObjectRecycler", "recycle(%s)", new Object[]{Integer.valueOf(hashCode.hashCode())});
                        hashCode.recycle();
                    }
                    set.clear();
                }
            }
        }
    }
}

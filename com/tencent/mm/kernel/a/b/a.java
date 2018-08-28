package com.tencent.mm.kernel.a.b;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;
import junit.framework.Assert;

public final class a {
    private static ThreadLocal<Stack<b>> dse = new ThreadLocal();

    public static class a {
        Object dsb;
        Class dsf;
        Set dsg = new HashSet();

        a(Object obj, Class cls) {
            this.dsb = obj;
            if (cls != null) {
                this.dsf = cls;
            }
            aM(this.dsb);
        }

        private void aM(Object obj) {
            Assert.assertNotNull(obj);
            Assert.assertNotNull(this.dsf);
            if (!this.dsf.isInstance(obj)) {
                throw new IllegalArgumentException("Your depend object " + obj + " must implement your type " + this.dsf);
            }
        }

        public final a aN(Object obj) {
            this.dsg.add(obj);
            aM(obj);
            return this;
        }
    }

    static class b {
        public HashMap<Class, a> dsh = null;

        b() {
        }
    }

    public static a a(Object obj, Class cls) {
        b bVar = (b) ((Stack) dse.get()).peek();
        Assert.assertNotNull(bVar);
        if (bVar.dsh == null) {
            bVar.dsh = new HashMap();
        }
        a aVar = (a) bVar.dsh.get(cls);
        if (aVar != null) {
            return aVar;
        }
        aVar = new a(obj, cls);
        bVar.dsh.put(aVar.dsf, aVar);
        return aVar;
    }

    static void start() {
        b bVar = new b();
        Stack stack = (Stack) dse.get();
        if (stack == null) {
            stack = new Stack();
            dse.set(stack);
        }
        stack.push(bVar);
    }

    static b EC() {
        return (b) ((Stack) dse.get()).pop();
    }
}

package com.tencent.mm.vending.g;

import java.util.Stack;

final class f {
    private static f uRz;
    ThreadLocal<Stack<c>> uRA = new ThreadLocal();

    private f() {
    }

    static {
        uRz = null;
        uRz = new f();
    }

    public static f cBJ() {
        return uRz;
    }
}

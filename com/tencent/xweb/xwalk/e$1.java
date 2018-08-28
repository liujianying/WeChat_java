package com.tencent.xweb.xwalk;

import org.xwalk.core.XWalkUIClient.ConsoleMessageType;

/* synthetic */ class e$1 {
    static final /* synthetic */ int[] vEL = new int[ConsoleMessageType.values().length];

    static {
        try {
            vEL[ConsoleMessageType.DEBUG.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            vEL[ConsoleMessageType.ERROR.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            vEL[ConsoleMessageType.LOG.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
        try {
            vEL[ConsoleMessageType.INFO.ordinal()] = 4;
        } catch (NoSuchFieldError e4) {
        }
        try {
            vEL[ConsoleMessageType.WARNING.ordinal()] = 5;
        } catch (NoSuchFieldError e5) {
        }
    }
}

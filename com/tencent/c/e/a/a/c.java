package com.tencent.c.e.a.a;

public abstract class c implements Runnable {
    public abstract void cFm();

    public abstract void cFn();

    public void run() {
        try {
            cFm();
        } catch (Throwable th) {
            cFn();
        }
    }
}

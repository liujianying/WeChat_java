package com.tencent.mm.plugin.appbrand.launching;

import java.util.concurrent.Callable;

abstract class w<T> implements Callable<T> {
    abstract String getTag();

    w() {
    }
}

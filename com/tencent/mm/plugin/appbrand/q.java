package com.tencent.mm.plugin.appbrand;

import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.task.AppBrandRemoteTaskController.c;

public interface q {
    void a(MiniProgramNavigationBackResult miniProgramNavigationBackResult);

    void a(AppBrandInitConfig appBrandInitConfig, MiniProgramNavigationBackResult miniProgramNavigationBackResult, g gVar);

    void a(g gVar, AppBrandInitConfig appBrandInitConfig, AppBrandStatObject appBrandStatObject);

    g aaA();

    int aaB();

    c aaC();

    void close();

    g d(g gVar);

    boolean e(g gVar);

    void f(g gVar);
}

package com.tencent.xweb.xwalk.a;

import com.tencent.xweb.util.e;
import com.tencent.xweb.xwalk.a.a.a;
import com.tencent.xweb.xwalk.a.f.c;
import java.io.File;
import org.xwalk.core.XWalkEnvironment;
import org.xwalk.core.XWalkInitializer;

class e$1 implements b {
    e$1() {
    }

    public final void a(c cVar) {
        a aVar;
        String str = cVar.mFilePath;
        if (str == null) {
            XWalkInitializer.addXWalkInitializeLog("parse config failed ,path is empty");
            aVar = null;
        } else {
            File file = new File(str);
            if (file.exists()) {
                aVar = a.i(file, a.f(file, (int) file.length()));
            } else {
                XWalkInitializer.addXWalkInitializeLog("parse config failed ,file not exist");
                aVar = null;
            }
        }
        if (aVar == null) {
            e.gY(35);
            e.cJa();
            e.bh(15123, "0,21," + cVar.vFP + "," + cVar.mNetWorkType + "," + cVar.mRetryTimes + "," + cVar.vFQ + "," + cVar.mTotalSize);
            XWalkEnvironment.addXWalkInitializeLog("ConfigParser failed ");
            return;
        }
        try {
            com.tencent.xweb.a.a(aVar.vFn, aVar.vFl);
        } catch (Exception e) {
            XWalkEnvironment.addXWalkInitializeLog("apply cmds failed , " + e.getMessage());
        }
        XWalkEnvironment.addXWalkInitializeLog("doFetchUpdateConfigNew onTaskSucceed!!");
        e.hd(cVar.vFQ);
        e.bh(15123, aVar.vFl + ",21," + cVar.vFP + "," + cVar.mNetWorkType + "," + cVar.mRetryTimes + "," + cVar.vFQ + "," + cVar.mTotalSize + "," + e.bO());
        c.cJo();
        e.c(c.a(aVar));
    }

    public final void b(c cVar) {
        e.gY(35);
        e.cJa();
        e.bh(15123, "0,21," + cVar.vFP + "," + cVar.mNetWorkType + "," + cVar.mRetryTimes + "," + cVar.vFQ + "," + cVar.mTotalSize + "," + e.bO());
        XWalkEnvironment.addXWalkInitializeLog("get config onTaskFailed ");
    }
}

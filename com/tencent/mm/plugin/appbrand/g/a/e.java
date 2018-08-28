package com.tencent.mm.plugin.appbrand.g.a;

import com.eclipsesource.v8.JavaCallback;
import com.eclipsesource.v8.V8Array;
import com.eclipsesource.v8.V8Function;
import com.eclipsesource.v8.V8Object;
import com.eclipsesource.v8.utils.V8ObjectUtils;
import java.util.HashMap;
import java.util.List;
import java.util.Timer;
import java.util.concurrent.atomic.AtomicInteger;

final class e extends b {
    final AtomicInteger gea = new AtomicInteger(0);
    final HashMap<Integer, a> geb = new HashMap();

    private final class a {
        V8Function geg;
        V8Array geh;
        Timer gei;
        boolean gej = false;
        int id;

        public a(Timer timer, int i, V8Function v8Function, V8Array v8Array) {
            this.geg = v8Function;
            this.geh = v8Array;
            this.id = i;
            this.gei = timer;
        }

        public final void cX(boolean z) {
            if (!this.geg.isReleased()) {
                this.geg.call(null, this.geh);
            }
            if (z) {
                cleanup();
            }
        }

        final void cleanup() {
            e.this.geb.remove(Integer.valueOf(this.id));
            this.geg.release();
            this.geh.release();
        }
    }

    e() {
    }

    protected final void a(final f fVar, V8Object v8Object) {
        v8Object.registerJavaMethod(new JavaCallback() {
            public final Object invoke(V8Object v8Object, V8Array v8Array) {
                if (v8Array.length() <= 0 || v8Array.getType(0) != 7) {
                    return null;
                }
                int i;
                V8Array toV8Array;
                V8Function v8Function = (V8Function) v8Array.getObject(0);
                if (v8Array.length() <= 1) {
                    i = 0;
                } else if (v8Array.getType(1) != 1) {
                    return null;
                } else {
                    i = v8Array.getInteger(1);
                }
                if (v8Array.length() > 2) {
                    List toList = V8ObjectUtils.toList(v8Array);
                    toV8Array = V8ObjectUtils.toV8Array(fVar.gek, toList.subList(2, toList.size() - 1));
                } else {
                    toV8Array = new V8Array(fVar.gek);
                }
                e eVar = e.this;
                f fVar = fVar;
                Timer timer = new Timer();
                Integer valueOf = Integer.valueOf(eVar.gea.addAndGet(1));
                a aVar = new a(timer, valueOf.intValue(), v8Function, toV8Array);
                timer.schedule(new 5(eVar, fVar, aVar), (long) i);
                eVar.geb.put(valueOf, aVar);
                return Integer.valueOf(valueOf.intValue());
            }
        }, "setTimeout");
        v8Object.registerJavaMethod(new 2(this, fVar), "setInterval");
        v8Object.registerJavaMethod(new 3(this), "clearTimeout");
        v8Object.registerJavaMethod(new 4(this), "clearInterval");
    }
}

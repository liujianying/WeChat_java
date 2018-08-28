package com.tencent.mm.bs;

import java.util.concurrent.atomic.AtomicInteger;

public final class c {

    public static abstract class b<Out, In1, In2> extends a<Out> implements com.tencent.mm.bs.b.a<In1> {
        com.tencent.mm.bs.b.b<In1> sNF;
        private com.tencent.mm.bs.b.b<In2> sNG;
        private com.tencent.mm.bs.b.a<In2> sNH = new com.tencent.mm.bs.b.a<In2>() {
            public final void aZ(In2 in2) {
                b.this.set(b.this.u(b.this.sNF.get(), in2));
            }
        };
        private final AtomicInteger sNI = new AtomicInteger(0);

        protected abstract Out u(In1 in1, In2 in2);

        protected b(String str, com.tencent.mm.bs.b.b<In1> bVar, com.tencent.mm.bs.b.b<In2> bVar2, Out out) {
            super(str, out);
            this.sNF = bVar;
            this.sNG = bVar2;
        }

        protected final void c(com.tencent.mm.bs.b.a<Out> aVar) {
            super.c(aVar);
            if (this.sNI.getAndIncrement() == 0) {
                this.sNF.a(this);
                this.sNG.a(this.sNH);
            }
        }

        protected final void d(com.tencent.mm.bs.b.a<Out> aVar) {
            super.b(aVar);
            if (this.sNI.decrementAndGet() == 0) {
                this.sNF.b(this);
                this.sNG.b(this.sNH);
            }
        }

        public final void aZ(In1 in1) {
            set(u(in1, this.sNG.get()));
        }
    }

    public static abstract class d<Out, In> extends a<Out> implements com.tencent.mm.bs.b.a<In> {
        private final AtomicInteger sNI = new AtomicInteger(0);
        private com.tencent.mm.bs.b.b<In> sNK;

        protected abstract Out cj(In in);

        protected d(String str, com.tencent.mm.bs.b.b<In> bVar, Out out) {
            super(str, out);
            this.sNK = bVar;
        }

        protected final void c(com.tencent.mm.bs.b.a<Out> aVar) {
            super.c(aVar);
            if (this.sNI.getAndIncrement() == 0) {
                this.sNK.a(this);
            }
        }

        protected final void d(com.tencent.mm.bs.b.a<Out> aVar) {
            super.d(aVar);
            if (this.sNI.decrementAndGet() == 0) {
                this.sNK.b(this);
            }
        }

        public final void aZ(In in) {
            set(cj(in));
        }
    }

    private static class a extends b<Boolean, Boolean, Boolean> {
        protected final /* synthetic */ Object u(Object obj, Object obj2) {
            boolean z = ((Boolean) obj).booleanValue() && ((Boolean) obj2).booleanValue();
            return Boolean.valueOf(z);
        }

        public a(com.tencent.mm.bs.b.b<Boolean> bVar, com.tencent.mm.bs.b.b<Boolean> bVar2) {
            String str = bVar.name() + " && " + bVar2.name();
            boolean z = ((Boolean) bVar.get()).booleanValue() && ((Boolean) bVar2.get()).booleanValue();
            super(str, bVar, bVar2, Boolean.valueOf(z));
        }
    }

    private static class c extends d<Boolean, Boolean> {
        protected final /* synthetic */ Object cj(Object obj) {
            return Boolean.valueOf(!((Boolean) obj).booleanValue());
        }

        public c(com.tencent.mm.bs.b.b<Boolean> bVar) {
            super("!" + bVar.name(), bVar, Boolean.valueOf(!((Boolean) bVar.get()).booleanValue()));
        }
    }
}

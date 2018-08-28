package b.c;

import b.c.b.e;
import b.e.b;
import b.i;

public final class a {
    public static final <T> Class<T> a(b<T> bVar) {
        e.i(bVar, "$receiver");
        Class<T> cJL = ((b.c.b.b) bVar).cJL();
        if (cJL.isPrimitive()) {
            String name = cJL.getName();
            if (name != null) {
                switch (name.hashCode()) {
                    case -1325958191:
                        if (name.equals("double")) {
                            cJL = Double.class;
                            break;
                        }
                        break;
                    case 104431:
                        if (name.equals("int")) {
                            cJL = Integer.class;
                            break;
                        }
                        break;
                    case 3039496:
                        if (name.equals("byte")) {
                            cJL = Byte.class;
                            break;
                        }
                        break;
                    case 3052374:
                        if (name.equals("char")) {
                            cJL = Character.class;
                            break;
                        }
                        break;
                    case 3327612:
                        if (name.equals("long")) {
                            cJL = Long.class;
                            break;
                        }
                        break;
                    case 64711720:
                        if (name.equals("boolean")) {
                            cJL = Boolean.class;
                            break;
                        }
                        break;
                    case 97526364:
                        if (name.equals("float")) {
                            cJL = Float.class;
                            break;
                        }
                        break;
                    case 109413500:
                        if (name.equals("short")) {
                            cJL = Short.class;
                            break;
                        }
                        break;
                }
            }
            if (cJL == null) {
                throw new i("null cannot be cast to non-null type java.lang.Class<T>");
            }
        } else if (cJL == null) {
            throw new i("null cannot be cast to non-null type java.lang.Class<T>");
        }
        return cJL;
    }
}

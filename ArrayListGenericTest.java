import java.lang.reflect.TypeVariable;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author rafi, joshmhanson
 */
public class ArrayListGenericTest {
    private final Class<?> cls = MyArrayList.class;
    private final TypeVariable<? extends Class<?>> typeVar = cls.getTypeParameters()[0];

    @Test
    public void testDataField() {
        try {
            assertEquals("MyArrayList 'data' field has incorrect type", Object[].class, cls.getDeclaredField("data").getGenericType());
        } catch (NoSuchFieldException e) {
            fail("MyArrayList does not have field 'data'");
        }
    }

    @Test
    public void testGenericConstructor() {
        try {
            if (cls.getConstructor(Object[].class).getGenericParameterTypes()[0] == Object[].class)
                fail("MyArrayList has incorrect constructor parameter type");
        } catch (NoSuchMethodException e) {
            fail("MyArrayList does not have constructor of one generic argument");
        }
    }

    @Test
    public void testGenericAddMethod() {
        try {
            var addMethod = cls.getMethod("add", Object.class);
            assertEquals("MyArrayList add method has incorrect return type (should be void)", void.class, addMethod.getReturnType());
            assertEquals("MyArrayList add method has incorrect parameter type", typeVar, addMethod.getGenericParameterTypes()[0]);
        } catch (NoSuchMethodException e) {
            fail("MyArrayList does not have add method that takes generic parameter");
        }
    }

    @Test
    public void testGenericAddIndexMethod() {
        try {
            var addIndexMethod = cls.getMethod("add", int.class, Object.class);
            assertEquals("MyArrayList add by index method has incorrect return type (should be void)", void.class, addIndexMethod.getReturnType());
            assertEquals("MyArrayList add by index method has incorrect parameter type", typeVar, addIndexMethod.getGenericParameterTypes()[1]);
        } catch (NoSuchMethodException e) {
            fail("MyArrayList does not have add method that takes int index and a generic obj as parameters");
        }
    }

    @Test
    public void testGenericContainsMethod() {
        try {
            var containsMethod = cls.getMethod("contains", Object.class);
            assertEquals("MyArrayList contains method has incorrect return type (should be boolean)", boolean.class, containsMethod.getReturnType());
            assertEquals("MyArrayList contains method has incorrect parameter type", typeVar, containsMethod.getGenericParameterTypes()[0]);
        } catch (NoSuchMethodException e) {
            fail("MyArrayList does not have a contains method with generic parameter");
        }
    }

    @Test
    public void testGenericGetMethod() {
        try {
            assertEquals("MyArrayList get method has incorrect return type", typeVar, cls.getMethod("get", int.class).getGenericReturnType());
        } catch (NoSuchMethodException e) {
            fail("MyArrayList does not have a get method with int parameter");
        }
    }

    @Test
    public void testGenericRemoveMethod() {
        try {
            assertEquals("MyArrayList remove by index method has incorrect return type", typeVar, cls.getMethod("remove", int.class).getGenericReturnType());
        } catch (NoSuchMethodException e) {
            fail("MyArrayList does not have remove by index method");
        }
    }

    @Test
    public void testGenericRemoveObjMethod() {
        try {
            var removeObjMethod = cls.getMethod("remove", Object.class);
            assertEquals("MyArrayList remove object method has incorrect return type (should be boolean)", boolean.class, removeObjMethod.getReturnType());
            assertEquals("MyArrayList remove object method has incorrect parameter type", typeVar, removeObjMethod.getGenericParameterTypes()[0]);
        } catch (NoSuchMethodException e) {
            fail("MyArrayList does not have remove object method with generic parameter");
        }
    }

    @Test
    public void testGenericSetMethod() {
        try {
            var setMethod = cls.getMethod("set", int.class, Object.class);
            assertEquals("MyArrayList set method has incorrect return type", typeVar, setMethod.getGenericReturnType());
            assertEquals("MyArrayList set method has incorrect parameter type", typeVar, setMethod.getGenericParameterTypes()[1]);
        } catch (NoSuchMethodException e) {
            fail("MyArrayList does not have set method that takes int index and a generic obj as parameters");
        }
    }

    @Test
    public void testGenericUse() {
        MyArrayList<Double> list = new MyArrayList<>();
        Double testValue = 3.14;
        list.add(testValue);
        assertEquals("MyArrayList generic add and get test failed", testValue, list.get(0));
    }
}

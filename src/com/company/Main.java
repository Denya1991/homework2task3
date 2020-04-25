package com.company;

public class Main {

    public static void main(String[] args) throws IllegalAccessException, NoSuchFieldException, InstantiationException {
		MyClass myClass = new MyClass();
		myClass.setValueInt(9);
		myClass.setValueString("hello");
		myClass.valueLong(1554544);

		String res = Serialize.serializer(myClass);
		System.out.println(res);
		myClass = Serialize.deserializer(res, MyClass.class);
		System.out.println(myClass.getValueInt() + ", " + myClass.getValueString() + ", " + myClass.getValueLong());
	}
}

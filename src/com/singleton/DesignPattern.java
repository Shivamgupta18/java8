package com.singleton;

import java.io.Serializable;

public class DesignPattern implements Cloneable {
	static DesignPattern s1 = null;

	private DesignPattern() throws Exception {

	}

	static DesignPattern getInstance() throws Exception {
		if (s1 == null)
			s1 = new DesignPattern();
		return s1;
	}

	Object readResolve() {
		return s1;
	}
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return s1;
	}

}

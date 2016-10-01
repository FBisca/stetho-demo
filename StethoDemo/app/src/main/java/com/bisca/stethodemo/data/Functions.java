package com.bisca.stethodemo.data;

public interface Functions {
  interface Func0<R> {
    R invoke();
  }

  interface Func1<T, R> {
    R invoke(T param1);
  }

  interface Func2<T1, T2, R> {
    R invoke(T1 param1, T2 param2);
  }
}

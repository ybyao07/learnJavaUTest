## when.return，when.thenCallRealMethod

## verify
用途: 验证方法是否被调用（传参需要一模一样）及调用的次数。
例如：verify(calcService, atLeastOnce()).subtract(20.0, 10.0); verify(calcService, times(1)).add(10.0, 20.0);

## exception处理
用途：模拟触发异常的情况
doThrow(new RuntimeException("Add operation not implemented"))
.when(calcService).add(10.0,20.0);

## answer
最简单的答案是–如果在方法调用中需要固定的返回值，则应使用thenReturn（…）。 如果需要执行某些操作或需要在运行时计算值，则应使用thenAnswer（…）


# spring-boot-elasticsearch
elasticsearch , send-email



### elasticsearch demo

### spring-boot 发送邮件

### 调用阿里大于发送短信验证码



#### 1、NEW

线程刚刚被创建，也就是已经new过了，但是还没有调用start()方法

#### 2、RUNNABLE

RUNNABLE这个名字很具有欺骗性，很容易让人误以为处于这个状态的线程正在运行。事实上，这个状态只是表示，线程是可运行的。我们已经无数次提到过，一个单核CPU在同一时刻，只能运行一个线程。

#### 3、BLOCKED

线程处于阻塞状态，正在等待一个monitor lock。通常情况下，是因为本线程与其他线程公用了一个锁。其他在线程正在使用这个锁进入某个synchronized同步方法块或者方法，而本线程进入这个同步代码块也需要这个锁，最终导致本线程处于阻塞状态。

#### 4、WAITING

等待状态，调用以下方法可能会导致一个线程处于等待状态：

Object.wait with no timeout

Thread.join with no timeout

LockSupport.park

例如：对于wait()方法，一个线程处于等待状态，通常是在等待其他线程完成某个操作。本线程调用某个对象的wait()方法，其他线程处于完成之后，调用同一个对象的notify或者notifyAll()方法。Object.wait()方法只能够在同步代码块中调用。调用了wait()方法后，会释放锁。

#### 5、TIMED_WAITING

线程等待指定的时间，对于以下方法的调用，可能会导致线程处于这个状态：

Thread.sleep

Object.wait with timeout

Thread.join with timeout

LockSupport.parkNanos

LockSupport.parkUntil

#### 6、TERMINATED

线程终止。
